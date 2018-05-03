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
    private ChannelListActivity cun;
    private TextView cvf;
    private ViewStub cvj;
    private TextView cvk;
    private AdapterView.OnItemClickListener cvn;
    private com.baidu.tieba.channel.a.f cwl;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cvn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cwl.getItem(i);
                if (item != null) {
                    String agm = item.agm();
                    if (!TextUtils.isEmpty(agm)) {
                        if (!com.baidu.adp.lib.util.j.gP()) {
                            j.this.cun.showToast(d.k.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cun.getActivity(), com.baidu.adp.lib.g.b.c(agm, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cun = channelListActivity;
        this.cun.setIsAddSwipeBackLayout(true);
        this.cun.setSwipeBackEnabled(true);
        this.cun.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cun.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cun.findViewById(d.g.parent);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cun.getResources().getString(d.k.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cvj = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.FL = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cwl = new com.baidu.tieba.channel.a.f(this.cun);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.cun.getPageContext());
        this.FL.setPullRefresh(this.mPullView);
        this.FL.setOnItemClickListener(this.cvn);
        this.FL.setAdapter((ListAdapter) this.cwl);
        this.mFooterView = LayoutInflater.from(this.cun.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cvf = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.FL.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cwl != null) {
            this.cwl = null;
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
            this.cwl.setData(null);
            this.FL.setVisibility(8);
            this.cvj.setVisibility(0);
            this.cvk = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cvk.setText(this.cun.getResources().getString(d.k.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eA(eVar.hasMore());
        this.cwl.setData(eVar.getItems());
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
        this.cun.getLayoutMode().setNightMode(i == 1);
        this.cun.getLayoutMode().u(this.mRootView);
        this.cun.getLayoutMode().u(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bla.onChangeSkinType(getPageContext(), i);
        this.mPullView.dv(i);
        if (this.cwl != null) {
            this.cwl.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.FL.setOnSrollToBottomListener(eVar);
    }
}
