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
    private BdListView LO;
    private NoNetworkView bvz;
    private ChannelFansActivity cEa;
    private com.baidu.tieba.channel.a.b cFM;
    private TextView cFp;
    private View cFr;
    private ViewStub cFu;
    private TextView cFv;
    private AdapterView.OnItemClickListener cFy;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cFy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cFM.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.jE()) {
                        d.this.cEa.showToast(d.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.cEa.getPageContext().getPageActivity(), item.ajR() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.cEa = channelFansActivity;
        this.cEa.setIsAddSwipeBackLayout(true);
        this.cEa.setSwipeBackEnabled(true);
        this.cEa.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cEa.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cEa.findViewById(d.g.parent);
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cEa.getResources().getString(d.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cFu = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.LO = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cFM = new com.baidu.tieba.channel.a.b(this.cEa);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cEa.getPageContext());
        this.LO.setPullRefresh(this.mPullView);
        this.LO.setOnItemClickListener(this.cFy);
        this.LO.setAdapter((ListAdapter) this.cFM);
        this.cFr = LayoutInflater.from(this.cEa.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cFr.findViewById(d.g.list_more_progress);
        this.cFp = (TextView) this.cFr.findViewById(d.g.list_more_title);
        this.LO.addFooterView(this.cFr);
    }

    public void onDestroy() {
        if (this.cFM != null) {
            this.cFM = null;
        }
    }

    public void ajW() {
        this.LO.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.LO.setVisibility(0);
        this.LO.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bvz.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.cFM.setData(null);
            this.LO.setVisibility(8);
            this.cFu.setVisibility(0);
            this.cFv = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cFv.setText(this.cEa.getResources().getString(d.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eG(cVar.hasMore());
        this.cFM.setData(cVar.getItems());
    }

    public void eG(boolean z) {
        this.cFr.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cFp.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cFp.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void b(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cEa.getLayoutMode().setNightMode(i == 1);
        this.cEa.getLayoutMode().onModeChanged(this.mRootView);
        this.cEa.getLayoutMode().onModeChanged(this.cFr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvz.onChangeSkinType(getPageContext(), i);
        this.mPullView.dC(i);
        if (this.cFM != null) {
            this.cFM.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LO.setOnSrollToBottomListener(eVar);
    }
}
