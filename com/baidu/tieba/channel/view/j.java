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
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private BdListView avh;
    private NoNetworkView cbj;
    private ChannelListActivity dcH;
    private View ddB;
    private ViewStub ddE;
    private TextView ddF;
    private AdapterView.OnItemClickListener ddI;
    private TextView ddz;
    private com.baidu.tieba.channel.a.f deH;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.ddI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.deH.getItem(i);
                if (item != null) {
                    String amm = item.amm();
                    if (!TextUtils.isEmpty(amm)) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            j.this.dcH.showToast(d.j.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.dcH.getActivity(), com.baidu.adp.lib.g.b.c(amm, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.dcH = channelListActivity;
        this.dcH.setIsAddSwipeBackLayout(true);
        this.dcH.setSwipeBackEnabled(true);
        this.dcH.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dcH.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.dcH.findViewById(d.g.parent);
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dcH.getResources().getString(d.j.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddE = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.avh = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.deH = new com.baidu.tieba.channel.a.f(this.dcH);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.dcH.getPageContext());
        this.avh.setPullRefresh(this.mPullView);
        this.avh.setOnItemClickListener(this.ddI);
        this.avh.setAdapter((ListAdapter) this.deH);
        this.ddB = LayoutInflater.from(this.dcH.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddB.findViewById(d.g.list_more_progress);
        this.ddz = (TextView) this.ddB.findViewById(d.g.list_more_title);
        this.avh.addFooterView(this.ddB);
    }

    public void onDestroy() {
        if (this.deH != null) {
            this.deH = null;
        }
    }

    public void amw() {
        this.avh.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.avh.setVisibility(0);
        this.avh.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.cbj.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.deH.setData(null);
            this.avh.setVisibility(8);
            this.ddE.setVisibility(0);
            this.ddF = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.ddF.setText(this.dcH.getResources().getString(d.j.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(eVar.hasMore());
        this.deH.setData(eVar.getItems());
    }

    public void eV(boolean z) {
        this.ddB.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.ddz.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.ddz.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void b(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void onChangeSkinType(int i) {
        this.dcH.getLayoutMode().aQ(i == 1);
        this.dcH.getLayoutMode().aM(this.mRootView);
        this.dcH.getLayoutMode().aM(this.ddB);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cbj.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        if (this.deH != null) {
            this.deH.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.avh.setOnSrollToBottomListener(eVar);
    }
}
