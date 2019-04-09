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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView Pj;
    private NoNetworkView dbr;
    private ChannelFansActivity enk;
    private View eoB;
    private ViewStub eoE;
    private TextView eoF;
    private AdapterView.OnItemClickListener eoI;
    private com.baidu.tieba.channel.a.b eoW;
    private TextView eoz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.eoI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.eoW.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kY()) {
                        d.this.enk.showToast(d.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.enk.getPageContext().getPageActivity(), item.aRy() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.enk = channelFansActivity;
        this.enk.setIsAddSwipeBackLayout(true);
        this.enk.setSwipeBackEnabled(true);
        this.enk.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.enk.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.enk.findViewById(d.g.parent);
        this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.enk.getResources().getString(d.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eoE = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.Pj = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.eoW = new com.baidu.tieba.channel.a.b(this.enk);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.enk.getPageContext());
        this.Pj.setPullRefresh(this.mPullView);
        this.Pj.setOnItemClickListener(this.eoI);
        this.Pj.setAdapter((ListAdapter) this.eoW);
        this.eoB = LayoutInflater.from(this.enk.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eoB.findViewById(d.g.list_more_progress);
        this.eoz = (TextView) this.eoB.findViewById(d.g.list_more_title);
        this.Pj.addFooterView(this.eoB);
    }

    public void onDestroy() {
        if (this.eoW != null) {
            this.eoW = null;
        }
    }

    public void aRC() {
        this.Pj.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.Pj.setVisibility(0);
        this.Pj.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dbr.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.eoW.setData(null);
            this.Pj.setVisibility(8);
            this.eoE.setVisibility(0);
            this.eoF = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.eoF.setText(this.enk.getResources().getString(d.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        hY(cVar.hasMore());
        this.eoW.setData(cVar.getItems());
    }

    public void hY(boolean z) {
        this.eoB.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eoz.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eoz.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.enk.getLayoutMode().setNightMode(i == 1);
        this.enk.getLayoutMode().onModeChanged(this.mRootView);
        this.enk.getLayoutMode().onModeChanged(this.eoB);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbr.onChangeSkinType(getPageContext(), i);
        this.mPullView.ib(i);
        if (this.eoW != null) {
            this.eoW.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Pj.setOnSrollToBottomListener(eVar);
    }
}
