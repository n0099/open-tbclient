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
    private NoNetworkView bPl;
    private ChannelListActivity ddY;
    private TextView deQ;
    private View deS;
    private ViewStub deV;
    private TextView deW;
    private AdapterView.OnItemClickListener deZ;
    private com.baidu.tieba.channel.a.f dfX;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.deZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.dfX.getItem(i);
                if (item != null) {
                    String arE = item.arE();
                    if (!TextUtils.isEmpty(arE)) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            j.this.ddY.showToast(e.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.ddY.getActivity(), com.baidu.adp.lib.g.b.d(arE, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.ddY = channelListActivity;
        this.ddY.setIsAddSwipeBackLayout(true);
        this.ddY.setSwipeBackEnabled(true);
        this.ddY.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ddY.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.ddY.findViewById(e.g.parent);
        this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ddY.getResources().getString(e.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deV = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OQ = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.dfX = new com.baidu.tieba.channel.a.f(this.ddY);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.ddY.getPageContext());
        this.OQ.setPullRefresh(this.mPullView);
        this.OQ.setOnItemClickListener(this.deZ);
        this.OQ.setAdapter((ListAdapter) this.dfX);
        this.deS = LayoutInflater.from(this.ddY.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.deS.findViewById(e.g.list_more_progress);
        this.deQ = (TextView) this.deS.findViewById(e.g.list_more_title);
        this.OQ.addFooterView(this.deS);
    }

    public void onDestroy() {
        if (this.dfX != null) {
            this.dfX = null;
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
        this.bPl.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.dfX.setData(null);
            this.OQ.setVisibility(8);
            this.deV.setVisibility(0);
            this.deW = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.deW.setText(this.ddY.getResources().getString(e.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fG(eVar.hasMore());
        this.dfX.setData(eVar.getItems());
    }

    public void fG(boolean z) {
        this.deS.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.deQ.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.deQ.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.ddY.getLayoutMode().setNightMode(i == 1);
        this.ddY.getLayoutMode().onModeChanged(this.mRootView);
        this.ddY.getLayoutMode().onModeChanged(this.deS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPl.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        if (this.dfX != null) {
            this.dfX.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OQ.setOnSrollToBottomListener(eVar);
    }
}
