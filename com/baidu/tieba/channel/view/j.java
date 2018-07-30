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
    private BdListView LO;
    private NoNetworkView bvz;
    private ChannelListActivity cEy;
    private TextView cFp;
    private View cFr;
    private ViewStub cFu;
    private TextView cFv;
    private AdapterView.OnItemClickListener cFy;
    private com.baidu.tieba.channel.a.f cGw;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cFy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cGw.getItem(i);
                if (item != null) {
                    String ajM = item.ajM();
                    if (!TextUtils.isEmpty(ajM)) {
                        if (!com.baidu.adp.lib.util.j.jE()) {
                            j.this.cEy.showToast(d.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cEy.getActivity(), com.baidu.adp.lib.g.b.c(ajM, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cEy = channelListActivity;
        this.cEy.setIsAddSwipeBackLayout(true);
        this.cEy.setSwipeBackEnabled(true);
        this.cEy.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cEy.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cEy.findViewById(d.g.parent);
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cEy.getResources().getString(d.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cFu = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.LO = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cGw = new com.baidu.tieba.channel.a.f(this.cEy);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cEy.getPageContext());
        this.LO.setPullRefresh(this.mPullView);
        this.LO.setOnItemClickListener(this.cFy);
        this.LO.setAdapter((ListAdapter) this.cGw);
        this.cFr = LayoutInflater.from(this.cEy.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cFr.findViewById(d.g.list_more_progress);
        this.cFp = (TextView) this.cFr.findViewById(d.g.list_more_title);
        this.LO.addFooterView(this.cFr);
    }

    public void onDestroy() {
        if (this.cGw != null) {
            this.cGw = null;
        }
    }

    public void ajW() {
        this.LO.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.LO.setVisibility(0);
        this.LO.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bvz.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cGw.setData(null);
            this.LO.setVisibility(8);
            this.cFu.setVisibility(0);
            this.cFv = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cFv.setText(this.cEy.getResources().getString(d.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eG(eVar.hasMore());
        this.cGw.setData(eVar.getItems());
    }

    public void eG(boolean z) {
        this.cFr.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cFp.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cFp.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void b(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cEy.getLayoutMode().setNightMode(i == 1);
        this.cEy.getLayoutMode().onModeChanged(this.mRootView);
        this.cEy.getLayoutMode().onModeChanged(this.cFr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvz.onChangeSkinType(getPageContext(), i);
        this.mPullView.dC(i);
        if (this.cGw != null) {
            this.cGw.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LO.setOnSrollToBottomListener(eVar);
    }
}
