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
/* loaded from: classes8.dex */
public class OfficialBarFeedActivity extends BaseActivity<OfficialBarFeedActivity> implements OfficialBarFeedMsglistModel.IFeedHeadLoadCallback {
    private OfficialBarFeedMsglistView kyR;
    private OfficialBarFeedMsglistModel kyS;
    private boolean kyT = false;
    private int kyU = 3;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.kyU != i) {
            this.kyU = i;
            super.onChangeSkinType(i);
            if (this.kyR != null) {
                this.kyR.onChangeSkinType(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kyS != null && this.kyT) {
            this.kyS.LoadData(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)));
        aq aqVar = new aq("c13861");
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kyT = true;
        if (this.kyS != null) {
            this.kyS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kyS != null) {
            this.kyS.onDestroy();
        }
    }

    private void initData() {
        try {
            this.kyS = new OfficialBarFeedMsglistModel(getPageContext());
            this.kyS.setHeadLoadCallback(this);
            this.kyS.LoadData(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        this.kyR = new OfficialBarFeedMsglistView(this);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onListDataLoad(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.kyR.B(list, list2);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        this.kyR.a(longSparseArray);
    }
}
