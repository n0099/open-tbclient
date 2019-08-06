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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelListActivity;
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView Ni;
    private NoNetworkView dnM;
    private ChannelListActivity eIv;
    private TextView eJl;
    private ViewStub eJp;
    private TextView eJq;
    private AdapterView.OnItemClickListener eJt;
    private com.baidu.tieba.channel.a.f eKr;
    private View eve;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eJt = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.eKr.getItem(i);
                if (item != null) {
                    String baG = item.baG();
                    if (!TextUtils.isEmpty(baG)) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            j.this.eIv.showToast(R.string.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.eIv.getActivity(), com.baidu.adp.lib.g.b.c(baG, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.eIv = channelListActivity;
        this.eIv.setIsAddSwipeBackLayout(true);
        this.eIv.setSwipeBackEnabled(true);
        this.eIv.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eIv.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eIv.findViewById(R.id.parent);
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eIv.getResources().getString(R.string.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJp = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.Ni = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eKr = new com.baidu.tieba.channel.a.f(this.eIv);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eIv.getPageContext());
        this.Ni.setPullRefresh(this.mPullView);
        this.Ni.setOnItemClickListener(this.eJt);
        this.Ni.setAdapter((ListAdapter) this.eKr);
        this.eve = LayoutInflater.from(this.eIv.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eve.findViewById(R.id.list_more_progress);
        this.eJl = (TextView) this.eve.findViewById(R.id.list_more_title);
        this.Ni.addFooterView(this.eve);
    }

    public void onDestroy() {
        if (this.eKr != null) {
            this.eKr = null;
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

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.eKr.setData(null);
            this.Ni.setVisibility(8);
            this.eJp.setVisibility(0);
            this.eJq = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eJq.setText(this.eIv.getResources().getString(R.string.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iM(eVar.hasMore());
        this.eKr.setData(eVar.getItems());
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
        this.eIv.getLayoutMode().setNightMode(i == 1);
        this.eIv.getLayoutMode().onModeChanged(this.mRootView);
        this.eIv.getLayoutMode().onModeChanged(this.eve);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnM.onChangeSkinType(getPageContext(), i);
        this.mPullView.iV(i);
        if (this.eKr != null) {
            this.eKr.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Ni.setOnSrollToBottomListener(eVar);
    }
}
