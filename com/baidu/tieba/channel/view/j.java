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
    private BdListView OQ;
    private NoNetworkView bPm;
    private ChannelListActivity ddZ;
    private TextView deR;
    private View deT;
    private ViewStub deW;
    private TextView deX;
    private com.baidu.tieba.channel.a.f dfY;
    private AdapterView.OnItemClickListener dfa;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.dfa = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.dfY.getItem(i);
                if (item != null) {
                    String arE = item.arE();
                    if (!TextUtils.isEmpty(arE)) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            j.this.ddZ.showToast(e.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.ddZ.getActivity(), com.baidu.adp.lib.g.b.d(arE, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.ddZ = channelListActivity;
        this.ddZ.setIsAddSwipeBackLayout(true);
        this.ddZ.setSwipeBackEnabled(true);
        this.ddZ.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ddZ.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.ddZ.findViewById(e.g.parent);
        this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ddZ.getResources().getString(e.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deW = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OQ = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.dfY = new com.baidu.tieba.channel.a.f(this.ddZ);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.ddZ.getPageContext());
        this.OQ.setPullRefresh(this.mPullView);
        this.OQ.setOnItemClickListener(this.dfa);
        this.OQ.setAdapter((ListAdapter) this.dfY);
        this.deT = LayoutInflater.from(this.ddZ.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.deT.findViewById(e.g.list_more_progress);
        this.deR = (TextView) this.deT.findViewById(e.g.list_more_title);
        this.OQ.addFooterView(this.deT);
    }

    public void onDestroy() {
        if (this.dfY != null) {
            this.dfY = null;
        }
    }

    public void arN() {
        this.OQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.OQ.setVisibility(0);
        this.OQ.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bPm.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.dfY.setData(null);
            this.OQ.setVisibility(8);
            this.deW.setVisibility(0);
            this.deX = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.deX.setText(this.ddZ.getResources().getString(e.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fG(eVar.hasMore());
        this.dfY.setData(eVar.getItems());
    }

    public void fG(boolean z) {
        this.deT.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.deR.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.deR.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.ddZ.getLayoutMode().setNightMode(i == 1);
        this.ddZ.getLayoutMode().onModeChanged(this.mRootView);
        this.ddZ.getLayoutMode().onModeChanged(this.deT);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPm.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        if (this.dfY != null) {
            this.dfY.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OQ.setOnSrollToBottomListener(eVar);
    }
}
