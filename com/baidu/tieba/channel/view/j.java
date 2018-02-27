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
    private BdListView auY;
    private NoNetworkView caX;
    private ChannelListActivity dcv;
    private TextView ddm;
    private View ddo;
    private ViewStub ddr;
    private TextView dds;
    private AdapterView.OnItemClickListener ddw;
    private com.baidu.tieba.channel.a.f dev;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.ddw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.dev.getItem(i);
                if (item != null) {
                    String aml = item.aml();
                    if (!TextUtils.isEmpty(aml)) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            j.this.dcv.showToast(d.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.dcv.getActivity(), com.baidu.adp.lib.g.b.c(aml, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.dcv = channelListActivity;
        this.dcv.setIsAddSwipeBackLayout(true);
        this.dcv.setSwipeBackEnabled(true);
        this.dcv.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dcv.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.dcv.findViewById(d.g.parent);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dcv.getResources().getString(d.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddr = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.auY = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.dev = new com.baidu.tieba.channel.a.f(this.dcv);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.dcv.getPageContext());
        this.auY.setPullRefresh(this.mPullView);
        this.auY.setOnItemClickListener(this.ddw);
        this.auY.setAdapter((ListAdapter) this.dev);
        this.ddo = LayoutInflater.from(this.dcv.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddo.findViewById(d.g.list_more_progress);
        this.ddm = (TextView) this.ddo.findViewById(d.g.list_more_title);
        this.auY.addFooterView(this.ddo);
    }

    public void onDestroy() {
        if (this.dev != null) {
            this.dev = null;
        }
    }

    public void amv() {
        this.auY.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.auY.setVisibility(0);
        this.auY.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.caX.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.dev.setData(null);
            this.auY.setVisibility(8);
            this.ddr.setVisibility(0);
            this.dds = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.dds.setText(this.dcv.getResources().getString(d.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(eVar.hasMore());
        this.dev.setData(eVar.getItems());
    }

    public void eV(boolean z) {
        this.ddo.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.ddm.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.ddm.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.dcv.getLayoutMode().aQ(i == 1);
        this.dcv.getLayoutMode().aM(this.mRootView);
        this.dcv.getLayoutMode().aM(this.ddo);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.caX.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        if (this.dev != null) {
            this.dev.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.auY.setOnSrollToBottomListener(eVar);
    }
}
