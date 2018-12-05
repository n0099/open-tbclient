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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView OF;
    private NoNetworkView bOx;
    private ChannelListActivity das;
    private TextView dbl;
    private View dbn;
    private ViewStub dbq;
    private TextView dbr;
    private AdapterView.OnItemClickListener dbu;
    private com.baidu.tieba.channel.a.f dcs;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.dbu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.dcs.getItem(i);
                if (item != null) {
                    String aqr = item.aqr();
                    if (!TextUtils.isEmpty(aqr)) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            j.this.das.showToast(e.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.das.getActivity(), com.baidu.adp.lib.g.b.d(aqr, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.das = channelListActivity;
        this.das.setIsAddSwipeBackLayout(true);
        this.das.setSwipeBackEnabled(true);
        this.das.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.das.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.das.findViewById(e.g.parent);
        this.bOx = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.das.getResources().getString(e.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dbq = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OF = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.dcs = new com.baidu.tieba.channel.a.f(this.das);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.das.getPageContext());
        this.OF.setPullRefresh(this.mPullView);
        this.OF.setOnItemClickListener(this.dbu);
        this.OF.setAdapter((ListAdapter) this.dcs);
        this.dbn = LayoutInflater.from(this.das.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.dbn.findViewById(e.g.list_more_progress);
        this.dbl = (TextView) this.dbn.findViewById(e.g.list_more_title);
        this.OF.addFooterView(this.dbn);
    }

    public void onDestroy() {
        if (this.dcs != null) {
            this.dcs = null;
        }
    }

    public void aqA() {
        this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.OF.setVisibility(0);
        this.OF.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bOx.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.dcs.setData(null);
            this.OF.setVisibility(8);
            this.dbq.setVisibility(0);
            this.dbr = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.dbr.setText(this.das.getResources().getString(e.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fB(eVar.hasMore());
        this.dcs.setData(eVar.getItems());
    }

    public void fB(boolean z) {
        this.dbn.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.dbl.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.dbl.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.das.getLayoutMode().setNightMode(i == 1);
        this.das.getLayoutMode().onModeChanged(this.mRootView);
        this.das.getLayoutMode().onModeChanged(this.dbn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bOx.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        if (this.dcs != null) {
            this.dcs.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OF.setOnSrollToBottomListener(eVar);
    }
}
