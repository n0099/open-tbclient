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
    private BdListView OE;
    private NoNetworkView bJX;
    private ChannelFansActivity cSh;
    private ViewStub cTB;
    private TextView cTC;
    private AdapterView.OnItemClickListener cTF;
    private com.baidu.tieba.channel.a.b cTT;
    private TextView cTw;
    private View cTy;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cTF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cTT.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kX()) {
                        d.this.cSh.showToast(e.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.cSh.getPageContext().getPageActivity(), item.apj() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.cSh = channelFansActivity;
        this.cSh.setIsAddSwipeBackLayout(true);
        this.cSh.setSwipeBackEnabled(true);
        this.cSh.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cSh.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cSh.findViewById(e.g.parent);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cSh.getResources().getString(e.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cTB = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OE = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.cTT = new com.baidu.tieba.channel.a.b(this.cSh);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.cSh.getPageContext());
        this.OE.setPullRefresh(this.mPullView);
        this.OE.setOnItemClickListener(this.cTF);
        this.OE.setAdapter((ListAdapter) this.cTT);
        this.cTy = LayoutInflater.from(this.cSh.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cTy.findViewById(e.g.list_more_progress);
        this.cTw = (TextView) this.cTy.findViewById(e.g.list_more_title);
        this.OE.addFooterView(this.cTy);
    }

    public void onDestroy() {
        if (this.cTT != null) {
            this.cTT = null;
        }
    }

    public void apn() {
        this.OE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.OE.setVisibility(0);
        this.OE.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bJX.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.cTT.setData(null);
            this.OE.setVisibility(8);
            this.cTB.setVisibility(0);
            this.cTC = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cTC.setText(this.cSh.getResources().getString(e.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fp(cVar.hasMore());
        this.cTT.setData(cVar.getItems());
    }

    public void fp(boolean z) {
        this.cTy.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cTw.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cTw.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cSh.getLayoutMode().setNightMode(i == 1);
        this.cSh.getLayoutMode().onModeChanged(this.mRootView);
        this.cSh.getLayoutMode().onModeChanged(this.cTy);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bJX.onChangeSkinType(getPageContext(), i);
        this.mPullView.dW(i);
        if (this.cTT != null) {
            this.cTT.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OE.setOnSrollToBottomListener(eVar);
    }
}
