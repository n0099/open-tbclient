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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView auY;
    private NoNetworkView caX;
    private ChannelFansActivity dbV;
    private com.baidu.tieba.channel.a.b ddK;
    private TextView ddm;
    private View ddo;
    private ViewStub ddr;
    private TextView dds;
    private AdapterView.OnItemClickListener ddw;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.ddw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.ddK.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.oJ()) {
                        d.this.dbV.showToast(d.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.dbV.getPageContext().getPageActivity(), item.amq() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.dbV = channelFansActivity;
        this.dbV.setIsAddSwipeBackLayout(true);
        this.dbV.setSwipeBackEnabled(true);
        this.dbV.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dbV.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.dbV.findViewById(d.g.parent);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dbV.getResources().getString(d.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddr = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.auY = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.ddK = new com.baidu.tieba.channel.a.b(this.dbV);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.dbV.getPageContext());
        this.auY.setPullRefresh(this.mPullView);
        this.auY.setOnItemClickListener(this.ddw);
        this.auY.setAdapter((ListAdapter) this.ddK);
        this.ddo = LayoutInflater.from(this.dbV.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddo.findViewById(d.g.list_more_progress);
        this.ddm = (TextView) this.ddo.findViewById(d.g.list_more_title);
        this.auY.addFooterView(this.ddo);
    }

    public void onDestroy() {
        if (this.ddK != null) {
            this.ddK = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.ddK.setData(null);
            this.auY.setVisibility(8);
            this.ddr.setVisibility(0);
            this.dds = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.dds.setText(this.dbV.getResources().getString(d.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(cVar.hasMore());
        this.ddK.setData(cVar.getItems());
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
        this.dbV.getLayoutMode().aQ(i == 1);
        this.dbV.getLayoutMode().aM(this.mRootView);
        this.dbV.getLayoutMode().aM(this.ddo);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.caX.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        if (this.ddK != null) {
            this.ddK.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.auY.setOnSrollToBottomListener(eVar);
    }
}
