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
    private BdListView Ni;
    private NoNetworkView dnM;
    private ChannelFansActivity eHY;
    private com.baidu.tieba.channel.a.b eJH;
    private TextView eJl;
    private ViewStub eJp;
    private TextView eJq;
    private AdapterView.OnItemClickListener eJt;
    private View eve;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.eJt = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.eJH.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.kc()) {
                        d.this.eHY.showToast(R.string.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.eHY.getPageContext().getPageActivity(), item.baL() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.eHY = channelFansActivity;
        this.eHY.setIsAddSwipeBackLayout(true);
        this.eHY.setSwipeBackEnabled(true);
        this.eHY.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eHY.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eHY.findViewById(R.id.parent);
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eHY.getResources().getString(R.string.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJp = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.Ni = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eJH = new com.baidu.tieba.channel.a.b(this.eHY);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eHY.getPageContext());
        this.Ni.setPullRefresh(this.mPullView);
        this.Ni.setOnItemClickListener(this.eJt);
        this.Ni.setAdapter((ListAdapter) this.eJH);
        this.eve = LayoutInflater.from(this.eHY.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eve.findViewById(R.id.list_more_progress);
        this.eJl = (TextView) this.eve.findViewById(R.id.list_more_title);
        this.Ni.addFooterView(this.eve);
    }

    public void onDestroy() {
        if (this.eJH != null) {
            this.eJH = null;
        }
    }

    public void baP() {
        this.Ni.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.Ni.setVisibility(0);
        this.Ni.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dnM.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.eJH.setData(null);
            this.Ni.setVisibility(8);
            this.eJp.setVisibility(0);
            this.eJq = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eJq.setText(this.eHY.getResources().getString(R.string.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iM(cVar.hasMore());
        this.eJH.setData(cVar.getItems());
    }

    public void iM(boolean z) {
        this.eve.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eJl.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eJl.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.eHY.getLayoutMode().setNightMode(i == 1);
        this.eHY.getLayoutMode().onModeChanged(this.mRootView);
        this.eHY.getLayoutMode().onModeChanged(this.eve);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnM.onChangeSkinType(getPageContext(), i);
        this.mPullView.iV(i);
        if (this.eJH != null) {
            this.eJH.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Ni.setOnSrollToBottomListener(eVar);
    }
}
