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
    private BdListView Nj;
    private NoNetworkView dpy;
    private TextView eKU;
    private ViewStub eKY;
    private TextView eKZ;
    private ChannelListActivity eKe;
    private AdapterView.OnItemClickListener eLc;
    private com.baidu.tieba.channel.a.f eMa;
    private View ewO;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eLc = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.eMa.getItem(i);
                if (item != null) {
                    String bbk = item.bbk();
                    if (!TextUtils.isEmpty(bbk)) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            j.this.eKe.showToast(R.string.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.eKe.getActivity(), com.baidu.adp.lib.g.b.e(bbk, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.eKe = channelListActivity;
        this.eKe.setIsAddSwipeBackLayout(true);
        this.eKe.setSwipeBackEnabled(true);
        this.eKe.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eKe.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eKe.findViewById(R.id.parent);
        this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eKe.getResources().getString(R.string.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKY = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.Nj = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eMa = new com.baidu.tieba.channel.a.f(this.eKe);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eKe.getPageContext());
        this.Nj.setPullRefresh(this.mPullView);
        this.Nj.setOnItemClickListener(this.eLc);
        this.Nj.setAdapter((ListAdapter) this.eMa);
        this.ewO = LayoutInflater.from(this.eKe.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ewO.findViewById(R.id.list_more_progress);
        this.eKU = (TextView) this.ewO.findViewById(R.id.list_more_title);
        this.Nj.addFooterView(this.ewO);
    }

    public void onDestroy() {
        if (this.eMa != null) {
            this.eMa = null;
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

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.eMa.setData(null);
            this.Nj.setVisibility(8);
            this.eKY.setVisibility(0);
            this.eKZ = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eKZ.setText(this.eKe.getResources().getString(R.string.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iP(eVar.hasMore());
        this.eMa.setData(eVar.getItems());
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
        this.eKe.getLayoutMode().setNightMode(i == 1);
        this.eKe.getLayoutMode().onModeChanged(this.mRootView);
        this.eKe.getLayoutMode().onModeChanged(this.ewO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dpy.onChangeSkinType(getPageContext(), i);
        this.mPullView.iY(i);
        if (this.eMa != null) {
            this.eMa.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Nj.setOnSrollToBottomListener(eVar);
    }
}
