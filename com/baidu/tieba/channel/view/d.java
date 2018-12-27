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
    private BdListView OF;
    private NoNetworkView bOA;
    private ChannelFansActivity dcN;
    private com.baidu.tieba.channel.a.b deB;
    private TextView ded;
    private View def;
    private ViewStub dei;
    private TextView dej;
    private AdapterView.OnItemClickListener dem;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.dem = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.deB.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kV()) {
                        d.this.dcN.showToast(e.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.dcN.getPageContext().getPageActivity(), item.arl() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.dcN = channelFansActivity;
        this.dcN.setIsAddSwipeBackLayout(true);
        this.dcN.setSwipeBackEnabled(true);
        this.dcN.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dcN.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.dcN.findViewById(e.g.parent);
        this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dcN.getResources().getString(e.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dei = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OF = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.deB = new com.baidu.tieba.channel.a.b(this.dcN);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.dcN.getPageContext());
        this.OF.setPullRefresh(this.mPullView);
        this.OF.setOnItemClickListener(this.dem);
        this.OF.setAdapter((ListAdapter) this.deB);
        this.def = LayoutInflater.from(this.dcN.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.def.findViewById(e.g.list_more_progress);
        this.ded = (TextView) this.def.findViewById(e.g.list_more_title);
        this.OF.addFooterView(this.def);
    }

    public void onDestroy() {
        if (this.deB != null) {
            this.deB = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.deB.setData(null);
            this.OF.setVisibility(8);
            this.dei.setVisibility(0);
            this.dej = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.dej.setText(this.dcN.getResources().getString(e.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fD(cVar.hasMore());
        this.deB.setData(cVar.getItems());
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
        this.dcN.getLayoutMode().setNightMode(i == 1);
        this.dcN.getLayoutMode().onModeChanged(this.mRootView);
        this.dcN.getLayoutMode().onModeChanged(this.def);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bOA.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        if (this.deB != null) {
            this.deB.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OF.setOnSrollToBottomListener(eVar);
    }
}
