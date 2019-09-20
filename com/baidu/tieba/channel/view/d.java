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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView Nj;
    private NoNetworkView dpy;
    private ChannelFansActivity eJH;
    private TextView eKU;
    private ViewStub eKY;
    private TextView eKZ;
    private AdapterView.OnItemClickListener eLc;
    private com.baidu.tieba.channel.a.b eLq;
    private View ewO;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.eLc = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.eLq.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kc()) {
                        d.this.eJH.showToast(R.string.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.eJH.getPageContext().getPageActivity(), item.bbp() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.eJH = channelFansActivity;
        this.eJH.setIsAddSwipeBackLayout(true);
        this.eJH.setSwipeBackEnabled(true);
        this.eJH.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eJH.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eJH.findViewById(R.id.parent);
        this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eJH.getResources().getString(R.string.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKY = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.Nj = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eLq = new com.baidu.tieba.channel.a.b(this.eJH);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eJH.getPageContext());
        this.Nj.setPullRefresh(this.mPullView);
        this.Nj.setOnItemClickListener(this.eLc);
        this.Nj.setAdapter((ListAdapter) this.eLq);
        this.ewO = LayoutInflater.from(this.eJH.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ewO.findViewById(R.id.list_more_progress);
        this.eKU = (TextView) this.ewO.findViewById(R.id.list_more_title);
        this.Nj.addFooterView(this.ewO);
    }

    public void onDestroy() {
        if (this.eLq != null) {
            this.eLq = null;
        }
    }

    public void bbt() {
        this.Nj.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.Nj.setVisibility(0);
        this.Nj.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dpy.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.eLq.setData(null);
            this.Nj.setVisibility(8);
            this.eKY.setVisibility(0);
            this.eKZ = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eKZ.setText(this.eJH.getResources().getString(R.string.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iP(cVar.hasMore());
        this.eLq.setData(cVar.getItems());
    }

    public void iP(boolean z) {
        this.ewO.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eKU.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eKU.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.eJH.getLayoutMode().setNightMode(i == 1);
        this.eJH.getLayoutMode().onModeChanged(this.mRootView);
        this.eJH.getLayoutMode().onModeChanged(this.ewO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dpy.onChangeSkinType(getPageContext(), i);
        this.mPullView.iY(i);
        if (this.eLq != null) {
            this.eLq.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Nj.setOnSrollToBottomListener(eVar);
    }
}
