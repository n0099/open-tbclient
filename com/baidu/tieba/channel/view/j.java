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
    private BdListView OE;
    private NoNetworkView bJX;
    private ChannelListActivity cSF;
    private ViewStub cTB;
    private TextView cTC;
    private AdapterView.OnItemClickListener cTF;
    private TextView cTw;
    private View cTy;
    private com.baidu.tieba.channel.a.f cUD;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cTF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cUD.getItem(i);
                if (item != null) {
                    String apc = item.apc();
                    if (!TextUtils.isEmpty(apc)) {
                        if (!com.baidu.adp.lib.util.j.kX()) {
                            j.this.cSF.showToast(e.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cSF.getActivity(), com.baidu.adp.lib.g.b.d(apc, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cSF = channelListActivity;
        this.cSF.setIsAddSwipeBackLayout(true);
        this.cSF.setSwipeBackEnabled(true);
        this.cSF.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cSF.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cSF.findViewById(e.g.parent);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cSF.getResources().getString(e.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cTB = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OE = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.cUD = new com.baidu.tieba.channel.a.f(this.cSF);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.cSF.getPageContext());
        this.OE.setPullRefresh(this.mPullView);
        this.OE.setOnItemClickListener(this.cTF);
        this.OE.setAdapter((ListAdapter) this.cUD);
        this.cTy = LayoutInflater.from(this.cSF.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cTy.findViewById(e.g.list_more_progress);
        this.cTw = (TextView) this.cTy.findViewById(e.g.list_more_title);
        this.OE.addFooterView(this.cTy);
    }

    public void onDestroy() {
        if (this.cUD != null) {
            this.cUD = null;
        }
    }

    public void apm() {
        this.OE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.OE.setVisibility(0);
        this.OE.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bJX.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cUD.setData(null);
            this.OE.setVisibility(8);
            this.cTB.setVisibility(0);
            this.cTC = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cTC.setText(this.cSF.getResources().getString(e.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fp(eVar.hasMore());
        this.cUD.setData(eVar.getItems());
    }

    public void fp(boolean z) {
        this.cTy.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cTw.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cTw.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cSF.getLayoutMode().setNightMode(i == 1);
        this.cSF.getLayoutMode().onModeChanged(this.mRootView);
        this.cSF.getLayoutMode().onModeChanged(this.cTy);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bJX.onChangeSkinType(getPageContext(), i);
        this.mPullView.dW(i);
        if (this.cUD != null) {
            this.cUD.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OE.setOnSrollToBottomListener(eVar);
    }
}
