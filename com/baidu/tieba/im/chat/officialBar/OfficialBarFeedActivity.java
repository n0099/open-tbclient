package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.model.OfficialBarFeedMsglistModel;
import java.util.List;
/* loaded from: classes26.dex */
public class OfficialBarFeedActivity extends BaseActivity<OfficialBarFeedActivity> implements OfficialBarFeedMsglistModel.IFeedHeadLoadCallback {
    private OfficialBarFeedMsglistView jXU;
    private OfficialBarFeedMsglistModel jXV;
    private boolean jXW = false;
    private int jXX = 3;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jXX != i) {
            this.jXX = i;
            super.onChangeSkinType(i);
            if (this.jXU != null) {
                this.jXU.onChangeSkinType(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jXV != null && this.jXW) {
            this.jXV.LoadData(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)));
        aq aqVar = new aq("c13861");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jXW = true;
        if (this.jXV != null) {
            this.jXV.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jXV != null) {
            this.jXV.onDestroy();
        }
    }

    private void initData() {
        try {
            this.jXV = new OfficialBarFeedMsglistModel(getPageContext());
            this.jXV.setHeadLoadCallback(this);
            this.jXV.LoadData(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        this.jXU = new OfficialBarFeedMsglistView(this);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onListDataLoad(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.jXU.z(list, list2);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        this.jXU.a(longSparseArray);
    }
}
