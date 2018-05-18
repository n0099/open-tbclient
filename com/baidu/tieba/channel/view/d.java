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
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView FH;
    private NoNetworkView blp;
    private ChannelFansActivity cuY;
    private com.baidu.tieba.channel.a.b cwK;
    private TextView cwo;
    private ViewStub cws;
    private TextView cwt;
    private AdapterView.OnItemClickListener cww;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cww = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cwK.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.gP()) {
                        d.this.cuY.showToast(d.k.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.cuY.getPageContext().getPageActivity(), item.agr() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.cuY = channelFansActivity;
        this.cuY.setIsAddSwipeBackLayout(true);
        this.cuY.setSwipeBackEnabled(true);
        this.cuY.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cuY.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cuY.findViewById(d.g.parent);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cuY.getResources().getString(d.k.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cws = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.FH = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cwK = new com.baidu.tieba.channel.a.b(this.cuY);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.cuY.getPageContext());
        this.FH.setPullRefresh(this.mPullView);
        this.FH.setOnItemClickListener(this.cww);
        this.FH.setAdapter((ListAdapter) this.cwK);
        this.mFooterView = LayoutInflater.from(this.cuY.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cwo = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.FH.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cwK != null) {
            this.cwK = null;
        }
    }

    public void agw() {
        this.FH.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.FH.setVisibility(0);
        this.FH.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.blp.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.cwK.setData(null);
            this.FH.setVisibility(8);
            this.cws.setVisibility(0);
            this.cwt = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cwt.setText(this.cuY.getResources().getString(d.k.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eB(cVar.hasMore());
        this.cwK.setData(cVar.getItems());
    }

    public void eB(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cwo.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cwo.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void b(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cuY.getLayoutMode().setNightMode(i == 1);
        this.cuY.getLayoutMode().u(this.mRootView);
        this.cuY.getLayoutMode().u(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.blp.onChangeSkinType(getPageContext(), i);
        this.mPullView.dw(i);
        if (this.cwK != null) {
            this.cwK.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.FH.setOnSrollToBottomListener(eVar);
    }
}
