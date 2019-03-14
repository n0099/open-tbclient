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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView Pj;
    private NoNetworkView dbm;
    private ChannelFansActivity eny;
    private TextView eoM;
    private View eoO;
    private ViewStub eoR;
    private TextView eoS;
    private AdapterView.OnItemClickListener eoV;
    private com.baidu.tieba.channel.a.b epj;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.eoV = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.epj.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kY()) {
                        d.this.eny.showToast(d.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.eny.getPageContext().getPageActivity(), item.aRA() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.eny = channelFansActivity;
        this.eny.setIsAddSwipeBackLayout(true);
        this.eny.setSwipeBackEnabled(true);
        this.eny.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eny.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eny.findViewById(d.g.parent);
        this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eny.getResources().getString(d.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eoR = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.Pj = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.epj = new com.baidu.tieba.channel.a.b(this.eny);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eny.getPageContext());
        this.Pj.setPullRefresh(this.mPullView);
        this.Pj.setOnItemClickListener(this.eoV);
        this.Pj.setAdapter((ListAdapter) this.epj);
        this.eoO = LayoutInflater.from(this.eny.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eoO.findViewById(d.g.list_more_progress);
        this.eoM = (TextView) this.eoO.findViewById(d.g.list_more_title);
        this.Pj.addFooterView(this.eoO);
    }

    public void onDestroy() {
        if (this.epj != null) {
            this.epj = null;
        }
    }

    public void aRE() {
        this.Pj.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.Pj.setVisibility(0);
        this.Pj.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dbm.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.epj.setData(null);
            this.Pj.setVisibility(8);
            this.eoR.setVisibility(0);
            this.eoS = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.eoS.setText(this.eny.getResources().getString(d.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        hY(cVar.hasMore());
        this.epj.setData(cVar.getItems());
    }

    public void hY(boolean z) {
        this.eoO.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eoM.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eoM.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.eny.getLayoutMode().setNightMode(i == 1);
        this.eny.getLayoutMode().onModeChanged(this.mRootView);
        this.eny.getLayoutMode().onModeChanged(this.eoO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbm.onChangeSkinType(getPageContext(), i);
        this.mPullView.ic(i);
        if (this.epj != null) {
            this.epj.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Pj.setOnSrollToBottomListener(eVar);
    }
}
