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
    private NoNetworkView bKI;
    private ChannelFansActivity cTn;
    private TextView cUC;
    private View cUE;
    private ViewStub cUH;
    private TextView cUI;
    private AdapterView.OnItemClickListener cUL;
    private com.baidu.tieba.channel.a.b cUZ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cUL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cUZ.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kV()) {
                        d.this.cTn.showToast(e.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.cTn.getPageContext().getPageActivity(), item.aoJ() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.cTn = channelFansActivity;
        this.cTn.setIsAddSwipeBackLayout(true);
        this.cTn.setSwipeBackEnabled(true);
        this.cTn.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cTn.setContentView(e.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cTn.findViewById(e.g.parent);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cTn.getResources().getString(e.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cUH = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.OF = (BdListView) this.mRootView.findViewById(e.g.channel_list_listview);
        this.cUZ = new com.baidu.tieba.channel.a.b(this.cTn);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.cTn.getPageContext());
        this.OF.setPullRefresh(this.mPullView);
        this.OF.setOnItemClickListener(this.cUL);
        this.OF.setAdapter((ListAdapter) this.cUZ);
        this.cUE = LayoutInflater.from(this.cTn.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cUE.findViewById(e.g.list_more_progress);
        this.cUC = (TextView) this.cUE.findViewById(e.g.list_more_title);
        this.OF.addFooterView(this.cUE);
    }

    public void onDestroy() {
        if (this.cUZ != null) {
            this.cUZ = null;
        }
    }

    public void aoN() {
        this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.OF.setVisibility(0);
        this.OF.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bKI.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.cUZ.setData(null);
            this.OF.setVisibility(8);
            this.cUH.setVisibility(0);
            this.cUI = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cUI.setText(this.cTn.getResources().getString(e.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fA(cVar.hasMore());
        this.cUZ.setData(cVar.getItems());
    }

    public void fA(boolean z) {
        this.cUE.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cUC.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cUC.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cTn.getLayoutMode().setNightMode(i == 1);
        this.cTn.getLayoutMode().onModeChanged(this.mRootView);
        this.cTn.getLayoutMode().onModeChanged(this.cUE);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bKI.onChangeSkinType(getPageContext(), i);
        this.mPullView.ek(i);
        if (this.cUZ != null) {
            this.cUZ.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OF.setOnSrollToBottomListener(eVar);
    }
}
