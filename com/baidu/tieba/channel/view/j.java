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
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView auZ;
    private NoNetworkView cba;
    private ChannelListActivity dcy;
    private TextView ddp;
    private View ddr;
    private ViewStub ddv;
    private TextView ddw;
    private AdapterView.OnItemClickListener ddz;
    private com.baidu.tieba.channel.a.f dey;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.ddz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.dey.getItem(i);
                if (item != null) {
                    String amm = item.amm();
                    if (!TextUtils.isEmpty(amm)) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            j.this.dcy.showToast(d.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.dcy.getActivity(), com.baidu.adp.lib.g.b.c(amm, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.dcy = channelListActivity;
        this.dcy.setIsAddSwipeBackLayout(true);
        this.dcy.setSwipeBackEnabled(true);
        this.dcy.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dcy.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.dcy.findViewById(d.g.parent);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dcy.getResources().getString(d.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddv = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.auZ = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.dey = new com.baidu.tieba.channel.a.f(this.dcy);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.dcy.getPageContext());
        this.auZ.setPullRefresh(this.mPullView);
        this.auZ.setOnItemClickListener(this.ddz);
        this.auZ.setAdapter((ListAdapter) this.dey);
        this.ddr = LayoutInflater.from(this.dcy.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddr.findViewById(d.g.list_more_progress);
        this.ddp = (TextView) this.ddr.findViewById(d.g.list_more_title);
        this.auZ.addFooterView(this.ddr);
    }

    public void onDestroy() {
        if (this.dey != null) {
            this.dey = null;
        }
    }

    public void amw() {
        this.auZ.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.auZ.setVisibility(0);
        this.auZ.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.cba.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.dey.setData(null);
            this.auZ.setVisibility(8);
            this.ddv.setVisibility(0);
            this.ddw = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.ddw.setText(this.dcy.getResources().getString(d.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(eVar.hasMore());
        this.dey.setData(eVar.getItems());
    }

    public void eV(boolean z) {
        this.ddr.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.ddp.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.ddp.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.dcy.getLayoutMode().aQ(i == 1);
        this.dcy.getLayoutMode().aM(this.mRootView);
        this.dcy.getLayoutMode().aM(this.ddr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cba.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        if (this.dey != null) {
            this.dey.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.auZ.setOnSrollToBottomListener(eVar);
    }
}
