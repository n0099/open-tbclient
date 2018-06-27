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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView LS;
    private NoNetworkView buT;
    private ChannelFansActivity cBv;
    private TextView cCK;
    private ViewStub cCO;
    private TextView cCP;
    private AdapterView.OnItemClickListener cCS;
    private com.baidu.tieba.channel.a.b cDg;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cCS = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cDg.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.jD()) {
                        d.this.cBv.showToast(d.k.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.cBv.getPageContext().getPageActivity(), item.ajt() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.cBv = channelFansActivity;
        this.cBv.setIsAddSwipeBackLayout(true);
        this.cBv.setSwipeBackEnabled(true);
        this.cBv.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cBv.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cBv.findViewById(d.g.parent);
        this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cBv.getResources().getString(d.k.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCO = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.LS = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cDg = new com.baidu.tieba.channel.a.b(this.cBv);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cBv.getPageContext());
        this.LS.setPullRefresh(this.mPullView);
        this.LS.setOnItemClickListener(this.cCS);
        this.LS.setAdapter((ListAdapter) this.cDg);
        this.mFooterView = LayoutInflater.from(this.cBv.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cCK = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.LS.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cDg != null) {
            this.cDg = null;
        }
    }

    public void ajy() {
        this.LS.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.LS.setVisibility(0);
        this.LS.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.buT.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.cDg.setData(null);
            this.LS.setVisibility(8);
            this.cCO.setVisibility(0);
            this.cCP = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cCP.setText(this.cBv.getResources().getString(d.k.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eF(cVar.hasMore());
        this.cDg.setData(cVar.getItems());
    }

    public void eF(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cCK.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cCK.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void b(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cBv.getLayoutMode().setNightMode(i == 1);
        this.cBv.getLayoutMode().onModeChanged(this.mRootView);
        this.cBv.getLayoutMode().onModeChanged(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.buT.onChangeSkinType(getPageContext(), i);
        this.mPullView.dz(i);
        if (this.cDg != null) {
            this.cDg.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LS.setOnSrollToBottomListener(eVar);
    }
}
