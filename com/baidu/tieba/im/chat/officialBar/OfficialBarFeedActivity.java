package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.model.OfficialBarFeedMsglistModel;
import d.a.j0.e1.h.o.a;
import d.a.j0.e1.l.c.b;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarFeedActivity extends BaseActivity<OfficialBarFeedActivity> implements OfficialBarFeedMsglistModel.IFeedHeadLoadCallback {
    public OfficialBarFeedMsglistModel mCurrentMsgListModel;
    public OfficialBarFeedMsglistView mCurrentMsgListView;
    public boolean resume = false;
    public int skinChangeType = 3;

    private void initData() {
        try {
            OfficialBarFeedMsglistModel officialBarFeedMsglistModel = new OfficialBarFeedMsglistModel(getPageContext());
            this.mCurrentMsgListModel = officialBarFeedMsglistModel;
            officialBarFeedMsglistModel.setHeadLoadCallback(this);
            this.mCurrentMsgListModel.LoadData(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void initView() {
        this.mCurrentMsgListView = new OfficialBarFeedMsglistView(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        if (this.skinChangeType == i2) {
            return;
        }
        this.skinChangeType = i2;
        super.onChangeSkinType(i2);
        OfficialBarFeedMsglistView officialBarFeedMsglistView = this.mCurrentMsgListView;
        if (officialBarFeedMsglistView != null) {
            officialBarFeedMsglistView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OfficialBarFeedMsglistModel officialBarFeedMsglistModel = this.mCurrentMsgListModel;
        if (officialBarFeedMsglistModel != null) {
            officialBarFeedMsglistModel.onDestroy();
        }
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onListDataLoad(List<b> list, List<a> list2) {
        this.mCurrentMsgListView.l(list, list2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.resume = true;
        OfficialBarFeedMsglistModel officialBarFeedMsglistModel = this.mCurrentMsgListModel;
        if (officialBarFeedMsglistModel != null) {
            officialBarFeedMsglistModel.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.IFeedHeadLoadCallback
    public void onReadCountLoad(LongSparseArray<d.a.j0.e1.i.a.b.b> longSparseArray) {
        this.mCurrentMsgListView.m(longSparseArray);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        OfficialBarFeedMsglistModel officialBarFeedMsglistModel = this.mCurrentMsgListModel;
        if (officialBarFeedMsglistModel != null && this.resume) {
            officialBarFeedMsglistModel.LoadData(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)));
        StatisticItem statisticItem = new StatisticItem("c13861");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }
}
