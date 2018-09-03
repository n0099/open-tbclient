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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView LO;
    private NoNetworkView bvB;
    private ChannelListActivity cEv;
    private TextView cFm;
    private View cFo;
    private ViewStub cFr;
    private TextView cFs;
    private AdapterView.OnItemClickListener cFv;
    private com.baidu.tieba.channel.a.f cGt;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.cFv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.cGt.getItem(i);
                if (item != null) {
                    String ajP = item.ajP();
                    if (!TextUtils.isEmpty(ajP)) {
                        if (!com.baidu.adp.lib.util.j.jE()) {
                            j.this.cEv.showToast(f.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.cEv.getActivity(), com.baidu.adp.lib.g.b.c(ajP, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.cEv = channelListActivity;
        this.cEv.setIsAddSwipeBackLayout(true);
        this.cEv.setSwipeBackEnabled(true);
        this.cEv.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cEv.setContentView(f.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cEv.findViewById(f.g.parent);
        this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cEv.getResources().getString(f.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cFr = (ViewStub) this.mRootView.findViewById(f.g.no_data_viewstub);
        this.LO = (BdListView) this.mRootView.findViewById(f.g.channel_list_listview);
        this.cGt = new com.baidu.tieba.channel.a.f(this.cEv);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cEv.getPageContext());
        this.LO.setPullRefresh(this.mPullView);
        this.LO.setOnItemClickListener(this.cFv);
        this.LO.setAdapter((ListAdapter) this.cGt);
        this.cFo = LayoutInflater.from(this.cEv.getPageContext().getPageActivity()).inflate(f.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cFo.findViewById(f.g.list_more_progress);
        this.cFm = (TextView) this.cFo.findViewById(f.g.list_more_title);
        this.LO.addFooterView(this.cFo);
    }

    public void onDestroy() {
        if (this.cGt != null) {
            this.cGt = null;
        }
    }

    public void ajY() {
        this.LO.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.LO.setVisibility(0);
        this.LO.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.bvB.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.cGt.setData(null);
            this.LO.setVisibility(8);
            this.cFr.setVisibility(0);
            this.cFs = (TextView) this.mRootView.findViewById(f.g.no_data_tip);
            this.cFs.setText(this.cEv.getResources().getString(f.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eG(eVar.hasMore());
        this.cGt.setData(eVar.getItems());
    }

    public void eG(boolean z) {
        this.cFo.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cFm.setText(getPageContext().getString(f.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cFm.setText(getPageContext().getString(f.j.channel_subscribe_list_no_more));
    }

    public void b(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.cEv.getLayoutMode().setNightMode(i == 1);
        this.cEv.getLayoutMode().onModeChanged(this.mRootView);
        this.cEv.getLayoutMode().onModeChanged(this.cFo);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvB.onChangeSkinType(getPageContext(), i);
        this.mPullView.dB(i);
        if (this.cGt != null) {
            this.cGt.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LO.setOnSrollToBottomListener(eVar);
    }
}
