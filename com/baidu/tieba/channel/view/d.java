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
    private ChannelFansActivity ctO;
    private com.baidu.tieba.channel.a.b cvB;
    private TextView cvf;
    private ViewStub cvj;
    private TextView cvk;
    private AdapterView.OnItemClickListener cvn;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cvn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cvB.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.gP()) {
                        d.this.ctO.showToast(d.k.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.ctO.getPageContext().getPageActivity(), item.agr() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.ctO = channelFansActivity;
        this.ctO.setIsAddSwipeBackLayout(true);
        this.ctO.setSwipeBackEnabled(true);
        this.ctO.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ctO.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.ctO.findViewById(d.g.parent);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ctO.getResources().getString(d.k.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cvj = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.FL = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cvB = new com.baidu.tieba.channel.a.b(this.ctO);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.ctO.getPageContext());
        this.FL.setPullRefresh(this.mPullView);
        this.FL.setOnItemClickListener(this.cvn);
        this.FL.setAdapter((ListAdapter) this.cvB);
        this.mFooterView = LayoutInflater.from(this.ctO.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cvf = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.FL.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cvB != null) {
            this.cvB = null;
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
            this.cvB.setData(null);
            this.FL.setVisibility(8);
            this.cvj.setVisibility(0);
            this.cvk = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cvk.setText(this.ctO.getResources().getString(d.k.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eA(cVar.hasMore());
        this.cvB.setData(cVar.getItems());
    }

    public void eA(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cvf.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cvf.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void b(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.ctO.getLayoutMode().setNightMode(i == 1);
        this.ctO.getLayoutMode().u(this.mRootView);
        this.ctO.getLayoutMode().u(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bla.onChangeSkinType(getPageContext(), i);
        this.mPullView.dv(i);
        if (this.cvB != null) {
            this.cvB.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.FL.setOnSrollToBottomListener(eVar);
    }
}
