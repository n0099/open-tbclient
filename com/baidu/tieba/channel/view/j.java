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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView LS;
    private NoNetworkView buT;
    private ChannelListActivity cBT;
    private TextView cCK;
    private ViewStub cCO;
    private TextView cCP;
    private AdapterView.OnItemClickListener cCS;
    private com.baidu.tieba.channel.a.f cDQ;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cCS = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cDQ.getItem(i);
                if (item != null) {
                    String ajo = item.ajo();
                    if (!TextUtils.isEmpty(ajo)) {
                        if (!com.baidu.adp.lib.util.j.jD()) {
                            j.this.cBT.showToast(d.k.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cBT.getActivity(), com.baidu.adp.lib.g.b.c(ajo, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cBT = channelListActivity;
        this.cBT.setIsAddSwipeBackLayout(true);
        this.cBT.setSwipeBackEnabled(true);
        this.cBT.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cBT.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cBT.findViewById(d.g.parent);
        this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cBT.getResources().getString(d.k.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCO = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.LS = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cDQ = new com.baidu.tieba.channel.a.f(this.cBT);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cBT.getPageContext());
        this.LS.setPullRefresh(this.mPullView);
        this.LS.setOnItemClickListener(this.cCS);
        this.LS.setAdapter((ListAdapter) this.cDQ);
        this.mFooterView = LayoutInflater.from(this.cBT.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cCK = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.LS.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cDQ != null) {
            this.cDQ = null;
        }
    }

    public void ajy() {
        this.LS.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.LS.setVisibility(0);
        this.LS.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.buT.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cDQ.setData(null);
            this.LS.setVisibility(8);
            this.cCO.setVisibility(0);
            this.cCP = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cCP.setText(this.cBT.getResources().getString(d.k.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eF(eVar.hasMore());
        this.cDQ.setData(eVar.getItems());
    }

    public void eF(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cCK.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cCK.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void b(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cBT.getLayoutMode().setNightMode(i == 1);
        this.cBT.getLayoutMode().onModeChanged(this.mRootView);
        this.cBT.getLayoutMode().onModeChanged(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.buT.onChangeSkinType(getPageContext(), i);
        this.mPullView.dz(i);
        if (this.cDQ != null) {
            this.cDQ.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LS.setOnSrollToBottomListener(eVar);
    }
}
