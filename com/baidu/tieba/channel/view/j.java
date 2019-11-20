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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelListActivity;
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.base.c<ChannelListActivity> {
    private View aqJ;
    private NoNetworkView dvR;
    private ChannelListActivity eRS;
    private TextView eSJ;
    private ViewStub eSN;
    private TextView eSO;
    private AdapterView.OnItemClickListener eSR;
    private com.baidu.tieba.channel.a.f eTP;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;
    private BdListView xL;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eSR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.eTP.getItem(i);
                if (item != null) {
                    String bbm = item.bbm();
                    if (!TextUtils.isEmpty(bbm)) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            j.this.eRS.showToast(R.string.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(j.this.eRS.getActivity(), com.baidu.adp.lib.g.b.toLong(bbm, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.eRS = channelListActivity;
        this.eRS.setIsAddSwipeBackLayout(true);
        this.eRS.setSwipeBackEnabled(true);
        this.eRS.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eRS.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eRS.findViewById(R.id.parent);
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eRS.getResources().getString(R.string.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSN = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.xL = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eTP = new com.baidu.tieba.channel.a.f(this.eRS);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eRS.getPageContext());
        this.xL.setPullRefresh(this.mPullView);
        this.xL.setOnItemClickListener(this.eSR);
        this.xL.setAdapter((ListAdapter) this.eTP);
        this.aqJ = LayoutInflater.from(this.eRS.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.aqJ.findViewById(R.id.list_more_progress);
        this.eSJ = (TextView) this.aqJ.findViewById(R.id.list_more_title);
        this.xL.addFooterView(this.aqJ);
    }

    public void onDestroy() {
        if (this.eTP != null) {
            this.eTP = null;
        }
    }

    public void bbw() {
        this.xL.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.xL.setVisibility(0);
        this.xL.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dvR.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.eTP.setData(null);
            this.xL.setVisibility(8);
            this.eSN.setVisibility(0);
            this.eSO = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eSO.setText(this.eRS.getResources().getString(R.string.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iS(eVar.hasMore());
        this.eTP.setData(eVar.getItems());
    }

    public void iS(boolean z) {
        this.aqJ.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eSJ.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eSJ.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.eRS.getLayoutMode().setNightMode(i == 1);
        this.eRS.getLayoutMode().onModeChanged(this.mRootView);
        this.eRS.getLayoutMode().onModeChanged(this.aqJ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dvR.onChangeSkinType(getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.eTP != null) {
            this.eTP.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.xL.setOnSrollToBottomListener(eVar);
    }
}
