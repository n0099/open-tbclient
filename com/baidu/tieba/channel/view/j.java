package com.baidu.tieba.channel.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView OF;
    private NoNetworkView bKI;
    private ChannelListActivity cTL;
    private TextView cUC;
    private View cUE;
    private ViewStub cUH;
    private TextView cUI;
    private AdapterView.OnItemClickListener cUL;
    private com.baidu.tieba.channel.a.f cVJ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cUL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cVJ.getItem(i);
                if (item != null) {
                    String aoE = item.aoE();
                    if (!TextUtils.isEmpty(aoE)) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            j.this.cTL.showToast(e.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cTL.getActivity(), com.baidu.adp.lib.g.b.d(aoE, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cTL = channelListActivity;
        this.cTL.setIsAddSwipeBackLayout(true);
        this.cTL.setSwipeBackEnabled(true);
        this.cTL.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cTL.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cTL.findViewById(e.g.parent);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cTL.getResources().getString(e.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cUH = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OF = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.cVJ = new com.baidu.tieba.channel.a.f(this.cTL);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.cTL.getPageContext());
        this.OF.setPullRefresh(this.mPullView);
        this.OF.setOnItemClickListener(this.cUL);
        this.OF.setAdapter((ListAdapter) this.cVJ);
        this.cUE = LayoutInflater.from(this.cTL.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cUE.findViewById(e.g.list_more_progress);
        this.cUC = (TextView) this.cUE.findViewById(e.g.list_more_title);
        this.OF.addFooterView(this.cUE);
    }

    public void onDestroy() {
        if (this.cVJ != null) {
            this.cVJ = null;
        }
    }

    public void aoN() {
        this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.OF.setVisibility(0);
        this.OF.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bKI.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cVJ.setData(null);
            this.OF.setVisibility(8);
            this.cUH.setVisibility(0);
            this.cUI = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cUI.setText(this.cTL.getResources().getString(e.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fA(eVar.hasMore());
        this.cVJ.setData(eVar.getItems());
    }

    public void fA(boolean z) {
        this.cUE.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cUC.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cUC.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cTL.getLayoutMode().setNightMode(i == 1);
        this.cTL.getLayoutMode().onModeChanged(this.mRootView);
        this.cTL.getLayoutMode().onModeChanged(this.cUE);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bKI.onChangeSkinType(getPageContext(), i);
        this.mPullView.ek(i);
        if (this.cVJ != null) {
            this.cVJ.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OF.setOnSrollToBottomListener(eVar);
    }
}
