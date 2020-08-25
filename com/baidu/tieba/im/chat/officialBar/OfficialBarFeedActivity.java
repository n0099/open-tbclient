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
/* loaded from: classes20.dex */
public class OfficialBarFeedActivity extends BaseActivity<BaseActivity> implements OfficialBarFeedMsglistModel.IFeedHeadLoadCallback {
    private OfficialBarFeedMsglistView jhP;
    private OfficialBarFeedMsglistModel jhQ;
    private boolean jhR = false;
    private int jhS = 3;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jhS != i) {
            this.jhS = i;
            super.onChangeSkinType(i);
            if (this.jhP != null) {
                this.jhP.onChangeSkinType(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jhQ != null && this.jhR) {
            this.jhQ.LoadData(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)));
        aq aqVar = new aq("c13861");
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jhR = true;
        if (this.jhQ != null) {
            this.jhQ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jhQ != null) {
            this.jhQ.onDestroy();
        }
    }

    private void initData() {
        try {
            this.jhQ = new OfficialBarFeedMsglistModel(getPageContext());
            this.jhQ.setHeadLoadCallback(this);
            this.jhQ.LoadData(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        this.jhP = new OfficialBarFeedMsglistView(this);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onListDataLoad(List<com.baidu.tieba.im.message.chat.b> list, List<com.baidu.tieba.im.db.pojo.a> list2) {
        this.jhP.u(list, list2);
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        this.jhP.a(longSparseArray);
    }
}
