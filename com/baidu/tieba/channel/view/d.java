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
    private NoNetworkView bPm;
    private ChannelFansActivity ddB;
    private TextView deR;
    private View deT;
    private ViewStub deW;
    private TextView deX;
    private AdapterView.OnItemClickListener dfa;
    private com.baidu.tieba.channel.a.b dfo;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.dfa = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.dfo.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kV()) {
                        d.this.ddB.showToast(e.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.ddB.getPageContext().getPageActivity(), item.arJ() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.ddB = channelFansActivity;
        this.ddB.setIsAddSwipeBackLayout(true);
        this.ddB.setSwipeBackEnabled(true);
        this.ddB.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ddB.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.ddB.findViewById(e.g.parent);
        this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ddB.getResources().getString(e.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deW = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OQ = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.dfo = new com.baidu.tieba.channel.a.b(this.ddB);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.ddB.getPageContext());
        this.OQ.setPullRefresh(this.mPullView);
        this.OQ.setOnItemClickListener(this.dfa);
        this.OQ.setAdapter((ListAdapter) this.dfo);
        this.deT = LayoutInflater.from(this.ddB.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.deT.findViewById(e.g.list_more_progress);
        this.deR = (TextView) this.deT.findViewById(e.g.list_more_title);
        this.OQ.addFooterView(this.deT);
    }

    public void onDestroy() {
        if (this.dfo != null) {
            this.dfo = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.dfo.setData(null);
            this.OQ.setVisibility(8);
            this.deW.setVisibility(0);
            this.deX = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.deX.setText(this.ddB.getResources().getString(e.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fG(cVar.hasMore());
        this.dfo.setData(cVar.getItems());
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
        this.ddB.getLayoutMode().setNightMode(i == 1);
        this.ddB.getLayoutMode().onModeChanged(this.mRootView);
        this.ddB.getLayoutMode().onModeChanged(this.deT);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPm.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        if (this.dfo != null) {
            this.dfo.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OQ.setOnSrollToBottomListener(eVar);
    }
}
