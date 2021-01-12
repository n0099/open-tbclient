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
/* loaded from: classes7.dex */
public class OfficialBarFeedActivity extends BaseActivity<OfficialBarFeedActivity> implements OfficialBarFeedMsglistModel.IFeedHeadLoadCallback {
    private OfficialBarFeedMsglistView kum;
    private OfficialBarFeedMsglistModel kun;
    private boolean kuo = false;
    private int kup = 3;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.kup != i) {
            this.kup = i;
            super.onChangeSkinType(i);
            if (this.kum != null) {
                this.kum.onChangeSkinType(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kun != null && this.kuo) {
            this.kun.LoadData(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)));
        aq aqVar = new aq("c13861");
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kuo = true;
        if (this.kun != null) {
            this.kun.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kun != null) {
            this.kun.onDestroy();
        }
    }

    private void initData() {
        try {
            this.kun = new OfficialBarFeedMsglistModel(getPageContext());
            this.kun.setHeadLoadCallback(this);
            this.kun.LoadData(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        this.kum = new OfficialBarFeedMsglistView(this);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onListDataLoad(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.kum.B(list, list2);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        this.kum.a(longSparseArray);
    }
}
