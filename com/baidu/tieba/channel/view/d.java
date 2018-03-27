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
    private BdListView auZ;
    private NoNetworkView cba;
    private ChannelFansActivity dbY;
    private com.baidu.tieba.channel.a.b ddN;
    private TextView ddp;
    private View ddr;
    private ViewStub ddv;
    private TextView ddw;
    private AdapterView.OnItemClickListener ddz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.ddz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.ddN.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.oJ()) {
                        d.this.dbY.showToast(d.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.dbY.getPageContext().getPageActivity(), item.amr() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.dbY = channelFansActivity;
        this.dbY.setIsAddSwipeBackLayout(true);
        this.dbY.setSwipeBackEnabled(true);
        this.dbY.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dbY.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.dbY.findViewById(d.g.parent);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dbY.getResources().getString(d.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddv = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.auZ = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.ddN = new com.baidu.tieba.channel.a.b(this.dbY);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.dbY.getPageContext());
        this.auZ.setPullRefresh(this.mPullView);
        this.auZ.setOnItemClickListener(this.ddz);
        this.auZ.setAdapter((ListAdapter) this.ddN);
        this.ddr = LayoutInflater.from(this.dbY.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddr.findViewById(d.g.list_more_progress);
        this.ddp = (TextView) this.ddr.findViewById(d.g.list_more_title);
        this.auZ.addFooterView(this.ddr);
    }

    public void onDestroy() {
        if (this.ddN != null) {
            this.ddN = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.ddN.setData(null);
            this.auZ.setVisibility(8);
            this.ddv.setVisibility(0);
            this.ddw = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.ddw.setText(this.dbY.getResources().getString(d.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(cVar.hasMore());
        this.ddN.setData(cVar.getItems());
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
        this.dbY.getLayoutMode().aQ(i == 1);
        this.dbY.getLayoutMode().aM(this.mRootView);
        this.dbY.getLayoutMode().aM(this.ddr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cba.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        if (this.ddN != null) {
            this.ddN.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.auZ.setOnSrollToBottomListener(eVar);
    }
}
