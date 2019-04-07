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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView Pj;
    private NoNetworkView dbq;
    private ChannelListActivity enH;
    private View eoA;
    private ViewStub eoD;
    private TextView eoE;
    private AdapterView.OnItemClickListener eoH;
    private TextView eoy;
    private com.baidu.tieba.channel.a.f epF;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eoH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.epF.getItem(i);
                if (item != null) {
                    String aRt = item.aRt();
                    if (!TextUtils.isEmpty(aRt)) {
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            j.this.enH.showToast(d.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.enH.getActivity(), com.baidu.adp.lib.g.b.d(aRt, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.enH = channelListActivity;
        this.enH.setIsAddSwipeBackLayout(true);
        this.enH.setSwipeBackEnabled(true);
        this.enH.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.enH.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.enH.findViewById(d.g.parent);
        this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.enH.getResources().getString(d.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eoD = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.Pj = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.epF = new com.baidu.tieba.channel.a.f(this.enH);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.enH.getPageContext());
        this.Pj.setPullRefresh(this.mPullView);
        this.Pj.setOnItemClickListener(this.eoH);
        this.Pj.setAdapter((ListAdapter) this.epF);
        this.eoA = LayoutInflater.from(this.enH.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eoA.findViewById(d.g.list_more_progress);
        this.eoy = (TextView) this.eoA.findViewById(d.g.list_more_title);
        this.Pj.addFooterView(this.eoA);
    }

    public void onDestroy() {
        if (this.epF != null) {
            this.epF = null;
        }
    }

    public void aRC() {
        this.Pj.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.Pj.setVisibility(0);
        this.Pj.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dbq.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.epF.setData(null);
            this.Pj.setVisibility(8);
            this.eoD.setVisibility(0);
            this.eoE = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.eoE.setText(this.enH.getResources().getString(d.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        hY(eVar.hasMore());
        this.epF.setData(eVar.getItems());
    }

    public void hY(boolean z) {
        this.eoA.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eoy.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eoy.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.enH.getLayoutMode().setNightMode(i == 1);
        this.enH.getLayoutMode().onModeChanged(this.mRootView);
        this.enH.getLayoutMode().onModeChanged(this.eoA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbq.onChangeSkinType(getPageContext(), i);
        this.mPullView.ib(i);
        if (this.epF != null) {
            this.epF.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Pj.setOnSrollToBottomListener(eVar);
    }
}
