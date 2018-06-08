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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView LQ;
    private NoNetworkView btu;
    private TextView cER;
    private ViewStub cEV;
    private TextView cEW;
    private AdapterView.OnItemClickListener cEZ;
    private ChannelListActivity cEa;
    private com.baidu.tieba.channel.a.f cFX;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cEZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cFX.getItem(i);
                if (item != null) {
                    String ajU = item.ajU();
                    if (!TextUtils.isEmpty(ajU)) {
                        if (!com.baidu.adp.lib.util.j.jD()) {
                            j.this.cEa.showToast(d.k.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cEa.getActivity(), com.baidu.adp.lib.g.b.c(ajU, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cEa = channelListActivity;
        this.cEa.setIsAddSwipeBackLayout(true);
        this.cEa.setSwipeBackEnabled(true);
        this.cEa.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cEa.setContentView(d.i.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cEa.findViewById(d.g.parent);
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cEa.getResources().getString(d.k.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cEV = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.LQ = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.cFX = new com.baidu.tieba.channel.a.f(this.cEa);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.cEa.getPageContext());
        this.LQ.setPullRefresh(this.mPullView);
        this.LQ.setOnItemClickListener(this.cEZ);
        this.LQ.setAdapter((ListAdapter) this.cFX);
        this.mFooterView = LayoutInflater.from(this.cEa.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cER = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.LQ.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cFX != null) {
            this.cFX = null;
        }
    }

    public void ake() {
        this.LQ.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.LQ.setVisibility(0);
        this.LQ.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.btu.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cFX.setData(null);
            this.LQ.setVisibility(8);
            this.cEV.setVisibility(0);
            this.cEW = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cEW.setText(this.cEa.getResources().getString(d.k.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eF(eVar.hasMore());
        this.cFX.setData(eVar.getItems());
    }

    public void eF(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cER.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cER.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void b(f.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cEa.getLayoutMode().setNightMode(i == 1);
        this.cEa.getLayoutMode().onModeChanged(this.mRootView);
        this.cEa.getLayoutMode().onModeChanged(this.mFooterView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.btu.onChangeSkinType(getPageContext(), i);
        this.mPullView.dy(i);
        if (this.cFX != null) {
            this.cFX.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LQ.setOnSrollToBottomListener(eVar);
    }
}
