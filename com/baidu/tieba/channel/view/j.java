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
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView FL;
    private NoNetworkView bla;
    private ChannelListActivity cuq;
    private TextView cvi;
    private ViewStub cvm;
    private TextView cvn;
    private AdapterView.OnItemClickListener cvq;
    private com.baidu.tieba.channel.a.f cwo;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cvq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cwo.getItem(i);
                if (item != null) {
                    String agm = item.agm();
                    if (!TextUtils.isEmpty(agm)) {
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            j.this.cuq.showToast(d.k.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cuq.getActivity(), com.baidu.adp.lib.g.b.c(agm, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cuq = channelListActivity;
        this.cuq.setIsAddSwipeBackLayout(true);
        this.cuq.setSwipeBackEnabled(true);
        this.cuq.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cuq.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cuq.findViewById(d.g.parent);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cuq.getResources().getString(d.k.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cvm = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.FL = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cwo = new com.baidu.tieba.channel.a.f(this.cuq);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.cuq.getPageContext());
        this.FL.setPullRefresh(this.mPullView);
        this.FL.setOnItemClickListener(this.cvq);
        this.FL.setAdapter((ListAdapter) this.cwo);
        this.mFooterView = LayoutInflater.from(this.cuq.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cvi = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.FL.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cwo != null) {
            this.cwo = null;
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

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cwo.setData(null);
            this.FL.setVisibility(8);
            this.cvm.setVisibility(0);
            this.cvn = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cvn.setText(this.cuq.getResources().getString(d.k.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eA(eVar.hasMore());
        this.cwo.setData(eVar.getItems());
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
        this.cuq.getLayoutMode().setNightMode(i == 1);
        this.cuq.getLayoutMode().u(this.mRootView);
        this.cuq.getLayoutMode().u(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bla.onChangeSkinType(getPageContext(), i);
        this.mPullView.dw(i);
        if (this.cwo != null) {
            this.cwo.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.FL.setOnSrollToBottomListener(eVar);
    }
}
