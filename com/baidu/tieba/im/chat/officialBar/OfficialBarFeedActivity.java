package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.model.OfficialBarFeedMsglistModel;
import java.util.List;
/* loaded from: classes20.dex */
public class OfficialBarFeedActivity extends BaseActivity<BaseActivity> implements OfficialBarFeedMsglistModel.IFeedHeadLoadCallback {
    private OfficialBarFeedMsglistView iSQ;
    private OfficialBarFeedMsglistModel iSR;
    private boolean iSS = false;
    private int iST = 3;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.iST != i) {
            this.iST = i;
            super.onChangeSkinType(i);
            if (this.iSQ != null) {
                this.iSQ.onChangeSkinType(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iSR != null && this.iSS) {
            this.iSR.LoadData(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)));
        ap apVar = new ap("c13861");
        if (com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
            apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
        }
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.iSS = true;
        if (this.iSR != null) {
            this.iSR.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iSR != null) {
            this.iSR.onDestroy();
        }
    }

    private void initData() {
        try {
            this.iSR = new OfficialBarFeedMsglistModel(getPageContext());
            this.iSR.setHeadLoadCallback(this);
            this.iSR.LoadData(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        this.iSQ = new OfficialBarFeedMsglistView(this);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onListDataLoad(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.iSQ.r(list, list2);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        this.iSQ.a(longSparseArray);
    }
}
