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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView OQ;
    private NoNetworkView bPl;
    private ChannelFansActivity ddA;
    private TextView deQ;
    private View deS;
    private ViewStub deV;
    private TextView deW;
    private AdapterView.OnItemClickListener deZ;
    private com.baidu.tieba.channel.a.b dfn;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.deZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.dfn.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kV()) {
                        d.this.ddA.showToast(e.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.ddA.getPageContext().getPageActivity(), item.arJ() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.ddA = channelFansActivity;
        this.ddA.setIsAddSwipeBackLayout(true);
        this.ddA.setSwipeBackEnabled(true);
        this.ddA.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ddA.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.ddA.findViewById(e.g.parent);
        this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ddA.getResources().getString(e.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deV = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OQ = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.dfn = new com.baidu.tieba.channel.a.b(this.ddA);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.ddA.getPageContext());
        this.OQ.setPullRefresh(this.mPullView);
        this.OQ.setOnItemClickListener(this.deZ);
        this.OQ.setAdapter((ListAdapter) this.dfn);
        this.deS = LayoutInflater.from(this.ddA.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.deS.findViewById(e.g.list_more_progress);
        this.deQ = (TextView) this.deS.findViewById(e.g.list_more_title);
        this.OQ.addFooterView(this.deS);
    }

    public void onDestroy() {
        if (this.dfn != null) {
            this.dfn = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.dfn.setData(null);
            this.OQ.setVisibility(8);
            this.deV.setVisibility(0);
            this.deW = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.deW.setText(this.ddA.getResources().getString(e.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fG(cVar.hasMore());
        this.dfn.setData(cVar.getItems());
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
        this.ddA.getLayoutMode().setNightMode(i == 1);
        this.ddA.getLayoutMode().onModeChanged(this.mRootView);
        this.ddA.getLayoutMode().onModeChanged(this.deS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPl.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        if (this.dfn != null) {
            this.dfn.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OQ.setOnSrollToBottomListener(eVar);
    }
}
