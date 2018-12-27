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
    private NoNetworkView bOA;
    private ChannelListActivity ddl;
    private TextView ded;
    private View def;
    private ViewStub dei;
    private TextView dej;
    private AdapterView.OnItemClickListener dem;
    private com.baidu.tieba.channel.a.f dfl;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.dem = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.dfl.getItem(i);
                if (item != null) {
                    String arg = item.arg();
                    if (!TextUtils.isEmpty(arg)) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            j.this.ddl.showToast(e.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.ddl.getActivity(), com.baidu.adp.lib.g.b.d(arg, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.ddl = channelListActivity;
        this.ddl.setIsAddSwipeBackLayout(true);
        this.ddl.setSwipeBackEnabled(true);
        this.ddl.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ddl.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.ddl.findViewById(e.g.parent);
        this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ddl.getResources().getString(e.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dei = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OF = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.dfl = new com.baidu.tieba.channel.a.f(this.ddl);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.ddl.getPageContext());
        this.OF.setPullRefresh(this.mPullView);
        this.OF.setOnItemClickListener(this.dem);
        this.OF.setAdapter((ListAdapter) this.dfl);
        this.def = LayoutInflater.from(this.ddl.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.def.findViewById(e.g.list_more_progress);
        this.ded = (TextView) this.def.findViewById(e.g.list_more_title);
        this.OF.addFooterView(this.def);
    }

    public void onDestroy() {
        if (this.dfl != null) {
            this.dfl = null;
        }
    }

    public void arp() {
        this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.OF.setVisibility(0);
        this.OF.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bOA.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.dfl.setData(null);
            this.OF.setVisibility(8);
            this.dei.setVisibility(0);
            this.dej = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.dej.setText(this.ddl.getResources().getString(e.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fD(eVar.hasMore());
        this.dfl.setData(eVar.getItems());
    }

    public void fD(boolean z) {
        this.def.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.ded.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.ded.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.ddl.getLayoutMode().setNightMode(i == 1);
        this.ddl.getLayoutMode().onModeChanged(this.mRootView);
        this.ddl.getLayoutMode().onModeChanged(this.def);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bOA.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        if (this.dfl != null) {
            this.dfl.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OF.setOnSrollToBottomListener(eVar);
    }
}
