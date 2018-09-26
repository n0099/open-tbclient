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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView Op;
    private NoNetworkView bBq;
    private ChannelFansActivity cJO;
    private com.baidu.tieba.channel.a.b cLA;
    private TextView cLd;
    private View cLf;
    private ViewStub cLi;
    private TextView cLj;
    private AdapterView.OnItemClickListener cLm;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cLm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cLA.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        d.this.cJO.showToast(e.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.cJO.getPageContext().getPageActivity(), item.alF() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.cJO = channelFansActivity;
        this.cJO.setIsAddSwipeBackLayout(true);
        this.cJO.setSwipeBackEnabled(true);
        this.cJO.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cJO.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cJO.findViewById(e.g.parent);
        this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cJO.getResources().getString(e.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cLi = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.Op = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.cLA = new com.baidu.tieba.channel.a.b(this.cJO);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.cJO.getPageContext());
        this.Op.setPullRefresh(this.mPullView);
        this.Op.setOnItemClickListener(this.cLm);
        this.Op.setAdapter((ListAdapter) this.cLA);
        this.cLf = LayoutInflater.from(this.cJO.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cLf.findViewById(e.g.list_more_progress);
        this.cLd = (TextView) this.cLf.findViewById(e.g.list_more_title);
        this.Op.addFooterView(this.cLf);
    }

    public void onDestroy() {
        if (this.cLA != null) {
            this.cLA = null;
        }
    }

    public void alJ() {
        this.Op.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.Op.setVisibility(0);
        this.Op.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bBq.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.cLA.setData(null);
            this.Op.setVisibility(8);
            this.cLi.setVisibility(0);
            this.cLj = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cLj.setText(this.cJO.getResources().getString(e.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eX(cVar.hasMore());
        this.cLA.setData(cVar.getItems());
    }

    public void eX(boolean z) {
        this.cLf.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cLd.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cLd.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cJO.getLayoutMode().setNightMode(i == 1);
        this.cJO.getLayoutMode().onModeChanged(this.mRootView);
        this.cJO.getLayoutMode().onModeChanged(this.cLf);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bBq.onChangeSkinType(getPageContext(), i);
        this.mPullView.dM(i);
        if (this.cLA != null) {
            this.cLA.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.Op.setOnSrollToBottomListener(eVar);
    }
}
