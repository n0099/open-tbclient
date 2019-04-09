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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView Pj;
    private NoNetworkView dbr;
    private ChannelListActivity enI;
    private View eoB;
    private ViewStub eoE;
    private TextView eoF;
    private AdapterView.OnItemClickListener eoI;
    private TextView eoz;
    private com.baidu.tieba.channel.a.f epG;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eoI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.epG.getItem(i);
                if (item != null) {
                    String aRt = item.aRt();
                    if (!TextUtils.isEmpty(aRt)) {
                        if (!com.baidu.adp.lib.util.j.kY()) {
                            j.this.enI.showToast(d.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.enI.getActivity(), com.baidu.adp.lib.g.b.d(aRt, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.enI = channelListActivity;
        this.enI.setIsAddSwipeBackLayout(true);
        this.enI.setSwipeBackEnabled(true);
        this.enI.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.enI.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.enI.findViewById(d.g.parent);
        this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.enI.getResources().getString(d.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eoE = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.Pj = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.epG = new com.baidu.tieba.channel.a.f(this.enI);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.enI.getPageContext());
        this.Pj.setPullRefresh(this.mPullView);
        this.Pj.setOnItemClickListener(this.eoI);
        this.Pj.setAdapter((ListAdapter) this.epG);
        this.eoB = LayoutInflater.from(this.enI.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eoB.findViewById(d.g.list_more_progress);
        this.eoz = (TextView) this.eoB.findViewById(d.g.list_more_title);
        this.Pj.addFooterView(this.eoB);
    }

    public void onDestroy() {
        if (this.epG != null) {
            this.epG = null;
        }
    }

    public void aRC() {
        this.Pj.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.Pj.setVisibility(0);
        this.Pj.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dbr.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.epG.setData(null);
            this.Pj.setVisibility(8);
            this.eoE.setVisibility(0);
            this.eoF = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.eoF.setText(this.enI.getResources().getString(d.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        hY(eVar.hasMore());
        this.epG.setData(eVar.getItems());
    }

    public void hY(boolean z) {
        this.eoB.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eoz.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eoz.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.enI.getLayoutMode().setNightMode(i == 1);
        this.enI.getLayoutMode().onModeChanged(this.mRootView);
        this.enI.getLayoutMode().onModeChanged(this.eoB);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbr.onChangeSkinType(getPageContext(), i);
        this.mPullView.ib(i);
        if (this.epG != null) {
            this.epG.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Pj.setOnSrollToBottomListener(eVar);
    }
}
