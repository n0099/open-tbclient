package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import d.a.c.e.p.l;
import d.a.j0.c1.c.j;
import d.a.j0.c1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.b {
    public d.a.j0.c1.b.b hotTopicShareModel;
    public List<j> mHotTopicRanklistDataList;
    public List<p> mTopicTabList;
    public d.a.j0.c1.f.b ranklistMainView;
    public HotRanklistModel ranklistModel;
    public String callFrom = "";
    public String listType = "";
    public long pageStayTime = System.currentTimeMillis();
    public boolean isTabListLoaded = false;
    public CustomMessageListener changeTabListener = new b(2001433);

    /* loaded from: classes4.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (!z || HotRanklistActivity.this.ranklistModel == null) {
                return;
            }
            j jVar = (j) HotRanklistActivity.this.mHotTopicRanklistDataList.get(HotRanklistActivity.this.ranklistMainView.h());
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                HotRanklistActivity.this.ranklistMainView.k();
                HotRanklistActivity.this.ranklistMainView.x();
                HotRanklistActivity.this.loadHotTopicRanklistData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof p) {
                int j = HotRanklistActivity.this.ranklistMainView.j((p) data);
                if (j >= 0) {
                    HotRanklistActivity.this.ranklistMainView.s(j);
                }
            }
        }
    }

    private void destoryListeners() {
        d.a.j0.c1.f.b bVar = this.ranklistMainView;
        if (bVar != null) {
            bVar.r();
        }
    }

    private void firstTimeLoadNetData() {
        showLoadingView(this.ranklistMainView.i(), true);
        if (!d.a.c.e.p.j.A()) {
            hideLoadingView(this.ranklistMainView.i());
            showNetRefreshView(this.ranklistMainView.i(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(l.g(getActivity(), R.dimen.ds350));
            this.ranklistMainView.t(0);
            this.ranklistMainView.w(8);
            this.ranklistMainView.v(8);
            return;
        }
        this.ranklistMainView.t(8);
        this.ranklistMainView.w(0);
        this.ranklistMainView.v(0);
        loadHotTopicRanklistData();
    }

    private void initListeners() {
        registerListener(this.changeTabListener);
        this.ranklistMainView.u(new a());
    }

    private void initParamsFromIntent(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra(IntentConfig.CALL_FROM);
            this.listType = intent.getStringExtra(IntentConfig.LIST_TYPE);
        } else if (bundle != null) {
            this.callFrom = bundle.getString(IntentConfig.CALL_FROM);
            this.listType = bundle.getString(IntentConfig.LIST_TYPE);
        }
    }

    private void initUI() {
        this.ranklistMainView = new d.a.j0.c1.f.b(this);
        this.hotTopicShareModel = new d.a.j0.c1.b.b(this);
        HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
        this.ranklistModel = hotRanklistModel;
        hotRanklistModel.x(this);
    }

    private void sendPauseMessageForVideo() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a014";
    }

    public void loadHotTopicRanklistData() {
        if (!d.a.c.e.p.j.z()) {
            this.ranklistMainView.q();
        } else if (this.ranklistModel != null) {
            String str = this.isTabListLoaded ? "0" : "1";
            if (!ListUtils.isEmpty(this.mTopicTabList)) {
                this.listType = this.mTopicTabList.get(this.ranklistMainView.h()).f51733f;
            }
            this.ranklistModel.u(this.callFrom, this.listType, str, 0L);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.b
    public void loadNetDataCallback(boolean z, j jVar, int i2, String str) {
        this.ranklistMainView.q();
        hideLoadingView(this.ranklistMainView.i());
        if (!z && !StringUtils.isNull(str)) {
            showToast(str);
        }
        if (this.ranklistMainView == null) {
            return;
        }
        if (!ListUtils.isEmpty(jVar.f51708b) && !this.isTabListLoaded) {
            this.mTopicTabList = jVar.f51708b;
            this.mHotTopicRanklistDataList = new ArrayList();
            for (p pVar : jVar.f51708b) {
                j jVar2 = new j();
                jVar2.f51707a = pVar.f51733f;
                this.mHotTopicRanklistDataList.add(jVar2);
            }
        }
        int i3 = -1;
        if (ListUtils.isEmpty(this.mHotTopicRanklistDataList)) {
            this.mHotTopicRanklistDataList = new ArrayList();
        } else if (jVar != null) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.mHotTopicRanklistDataList.size()) {
                    break;
                } else if (this.mHotTopicRanklistDataList.get(i4).f51707a.equals(jVar.f51707a)) {
                    i3 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (i3 == 0) {
                jVar.f51708b = this.mTopicTabList;
            } else if (ListUtils.isEmpty(this.mHotTopicRanklistDataList.get(0).f51708b)) {
                this.mHotTopicRanklistDataList.get(0).f51708b = this.mTopicTabList;
            }
            this.mHotTopicRanklistDataList.add(i3, jVar);
            this.mHotTopicRanklistDataList.remove(i3 + 1);
        }
        this.ranklistMainView.n(this.mHotTopicRanklistDataList);
        if (this.isTabListLoaded || ListUtils.isEmpty(this.mHotTopicRanklistDataList) || ListUtils.isEmpty(this.mHotTopicRanklistDataList.get(0).f51708b) || ListUtils.isEmpty(this.mTopicTabList)) {
            return;
        }
        this.isTabListLoaded = true;
        this.ranklistMainView.z();
        if (i3 >= 0) {
            this.ranklistMainView.s(i3);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.ranklistMainView.o(i2);
        changeSkinType(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParamsFromIntent(bundle);
        initUI();
        initListeners();
        firstTimeLoadNetData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004014));
        destoryListeners();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && this.ranklistMainView.p()) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (d.a.c.e.p.j.A()) {
            hideNetRefreshView(this.ranklistMainView.i());
            firstTimeLoadNetData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        sendPauseMessageForVideo();
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        super.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (StringUtils.isNull(this.callFrom) && StringUtils.isNull(this.listType)) {
            return;
        }
        bundle.putString(IntentConfig.CALL_FROM, this.callFrom);
        bundle.putString(IntentConfig.LIST_TYPE, this.listType);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        long currentTimeMillis = System.currentTimeMillis() - this.pageStayTime;
        StatisticItem statisticItem = new StatisticItem("c10818");
        TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, "" + currentTimeMillis));
    }

    public void shareTopic() {
        p pVar;
        if (ListUtils.isEmpty(this.mTopicTabList) || (pVar = this.mTopicTabList.get(this.ranklistMainView.h())) == null) {
            return;
        }
        this.hotTopicShareModel.e(null, pVar.f51735h, pVar.j, pVar.f51734g, pVar.f51736i, false);
    }
}
