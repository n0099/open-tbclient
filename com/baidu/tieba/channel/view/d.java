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
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView FL;
    private NoNetworkView bla;
    private ChannelFansActivity ctR;
    private com.baidu.tieba.channel.a.b cvE;
    private TextView cvi;
    private ViewStub cvm;
    private TextView cvn;
    private AdapterView.OnItemClickListener cvq;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cvq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cvE.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.gP()) {
                        d.this.ctR.showToast(d.k.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.ctR.getPageContext().getPageActivity(), item.agr() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.ctR = channelFansActivity;
        this.ctR.setIsAddSwipeBackLayout(true);
        this.ctR.setSwipeBackEnabled(true);
        this.ctR.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ctR.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.ctR.findViewById(d.g.parent);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ctR.getResources().getString(d.k.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cvm = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.FL = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cvE = new com.baidu.tieba.channel.a.b(this.ctR);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.ctR.getPageContext());
        this.FL.setPullRefresh(this.mPullView);
        this.FL.setOnItemClickListener(this.cvq);
        this.FL.setAdapter((ListAdapter) this.cvE);
        this.mFooterView = LayoutInflater.from(this.ctR.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cvi = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.FL.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cvE != null) {
            this.cvE = null;
        }
    }

    public void agw() {
        this.FL.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.FL.setVisibility(0);
        this.FL.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bla.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.cvE.setData(null);
            this.FL.setVisibility(8);
            this.cvm.setVisibility(0);
            this.cvn = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cvn.setText(this.ctR.getResources().getString(d.k.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eA(cVar.hasMore());
        this.cvE.setData(cVar.getItems());
    }

    public void eA(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cvi.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cvi.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void b(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.ctR.getLayoutMode().setNightMode(i == 1);
        this.ctR.getLayoutMode().u(this.mRootView);
        this.ctR.getLayoutMode().u(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bla.onChangeSkinType(getPageContext(), i);
        this.mPullView.dw(i);
        if (this.cvE != null) {
            this.cvE.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.FL.setOnSrollToBottomListener(eVar);
    }
}
