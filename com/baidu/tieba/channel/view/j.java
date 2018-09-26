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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView Op;
    private NoNetworkView bBq;
    private ChannelListActivity cKm;
    private TextView cLd;
    private View cLf;
    private ViewStub cLi;
    private TextView cLj;
    private AdapterView.OnItemClickListener cLm;
    private com.baidu.tieba.channel.a.f cMk;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cLm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cMk.getItem(i);
                if (item != null) {
                    String alA = item.alA();
                    if (!TextUtils.isEmpty(alA)) {
                        if (!com.baidu.adp.lib.util.j.kK()) {
                            j.this.cKm.showToast(e.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cKm.getActivity(), com.baidu.adp.lib.g.b.d(alA, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cKm = channelListActivity;
        this.cKm.setIsAddSwipeBackLayout(true);
        this.cKm.setSwipeBackEnabled(true);
        this.cKm.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cKm.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cKm.findViewById(e.g.parent);
        this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cKm.getResources().getString(e.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cLi = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.Op = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.cMk = new com.baidu.tieba.channel.a.f(this.cKm);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.cKm.getPageContext());
        this.Op.setPullRefresh(this.mPullView);
        this.Op.setOnItemClickListener(this.cLm);
        this.Op.setAdapter((ListAdapter) this.cMk);
        this.cLf = LayoutInflater.from(this.cKm.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cLf.findViewById(e.g.list_more_progress);
        this.cLd = (TextView) this.cLf.findViewById(e.g.list_more_title);
        this.Op.addFooterView(this.cLf);
    }

    public void onDestroy() {
        if (this.cMk != null) {
            this.cMk = null;
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

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cMk.setData(null);
            this.Op.setVisibility(8);
            this.cLi.setVisibility(0);
            this.cLj = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cLj.setText(this.cKm.getResources().getString(e.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eX(eVar.hasMore());
        this.cMk.setData(eVar.getItems());
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
        this.cKm.getLayoutMode().setNightMode(i == 1);
        this.cKm.getLayoutMode().onModeChanged(this.mRootView);
        this.cKm.getLayoutMode().onModeChanged(this.cLf);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bBq.onChangeSkinType(getPageContext(), i);
        this.mPullView.dM(i);
        if (this.cMk != null) {
            this.cMk.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.Op.setOnSrollToBottomListener(eVar);
    }
}
