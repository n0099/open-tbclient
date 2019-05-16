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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelListActivity;
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView MS;
    private NoNetworkView dlW;
    private ChannelListActivity eDr;
    private TextView eEh;
    private ViewStub eEl;
    private TextView eEm;
    private AdapterView.OnItemClickListener eEp;
    private com.baidu.tieba.channel.a.f eFn;
    private View epY;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eEp = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.eFn.getItem(i);
                if (item != null) {
                    String aYC = item.aYC();
                    if (!TextUtils.isEmpty(aYC)) {
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            j.this.eDr.showToast(R.string.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.eDr.getActivity(), com.baidu.adp.lib.g.b.c(aYC, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.eDr = channelListActivity;
        this.eDr.setIsAddSwipeBackLayout(true);
        this.eDr.setSwipeBackEnabled(true);
        this.eDr.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eDr.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eDr.findViewById(R.id.parent);
        this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eDr.getResources().getString(R.string.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEl = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.MS = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eFn = new com.baidu.tieba.channel.a.f(this.eDr);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eDr.getPageContext());
        this.MS.setPullRefresh(this.mPullView);
        this.MS.setOnItemClickListener(this.eEp);
        this.MS.setAdapter((ListAdapter) this.eFn);
        this.epY = LayoutInflater.from(this.eDr.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.epY.findViewById(R.id.list_more_progress);
        this.eEh = (TextView) this.epY.findViewById(R.id.list_more_title);
        this.MS.addFooterView(this.epY);
    }

    public void onDestroy() {
        if (this.eFn != null) {
            this.eFn = null;
        }
    }

    public void aYL() {
        this.MS.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.MS.setVisibility(0);
        this.MS.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dlW.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.eFn.setData(null);
            this.MS.setVisibility(8);
            this.eEl.setVisibility(0);
            this.eEm = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eEm.setText(this.eDr.getResources().getString(R.string.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iD(eVar.hasMore());
        this.eFn.setData(eVar.getItems());
    }

    public void iD(boolean z) {
        this.epY.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eEh.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eEh.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.eDr.getLayoutMode().setNightMode(i == 1);
        this.eDr.getLayoutMode().onModeChanged(this.mRootView);
        this.eDr.getLayoutMode().onModeChanged(this.epY);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlW.onChangeSkinType(getPageContext(), i);
        this.mPullView.iP(i);
        if (this.eFn != null) {
            this.eFn.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.MS.setOnSrollToBottomListener(eVar);
    }
}
