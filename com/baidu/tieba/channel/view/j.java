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
    private BdListView FH;
    private NoNetworkView blp;
    private ChannelListActivity cvx;
    private TextView cwo;
    private ViewStub cws;
    private TextView cwt;
    private AdapterView.OnItemClickListener cww;
    private com.baidu.tieba.channel.a.f cxu;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cww = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cxu.getItem(i);
                if (item != null) {
                    String agm = item.agm();
                    if (!TextUtils.isEmpty(agm)) {
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            j.this.cvx.showToast(d.k.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cvx.getActivity(), com.baidu.adp.lib.g.b.c(agm, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cvx = channelListActivity;
        this.cvx.setIsAddSwipeBackLayout(true);
        this.cvx.setSwipeBackEnabled(true);
        this.cvx.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cvx.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cvx.findViewById(d.g.parent);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cvx.getResources().getString(d.k.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cws = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.FH = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cxu = new com.baidu.tieba.channel.a.f(this.cvx);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.cvx.getPageContext());
        this.FH.setPullRefresh(this.mPullView);
        this.FH.setOnItemClickListener(this.cww);
        this.FH.setAdapter((ListAdapter) this.cxu);
        this.mFooterView = LayoutInflater.from(this.cvx.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cwo = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.FH.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cxu != null) {
            this.cxu = null;
        }
    }

    public void agw() {
        this.FH.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.FH.setVisibility(0);
        this.FH.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.blp.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cxu.setData(null);
            this.FH.setVisibility(8);
            this.cws.setVisibility(0);
            this.cwt = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cwt.setText(this.cvx.getResources().getString(d.k.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eB(eVar.hasMore());
        this.cxu.setData(eVar.getItems());
    }

    public void eB(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cwo.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cwo.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void b(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cvx.getLayoutMode().setNightMode(i == 1);
        this.cvx.getLayoutMode().u(this.mRootView);
        this.cvx.getLayoutMode().u(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.blp.onChangeSkinType(getPageContext(), i);
        this.mPullView.dw(i);
        if (this.cxu != null) {
            this.cxu.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.FH.setOnSrollToBottomListener(eVar);
    }
}
