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
    private View arb;
    private NoNetworkView dwI;
    private ChannelListActivity eSJ;
    private TextView eTA;
    private ViewStub eTE;
    private TextView eTF;
    private AdapterView.OnItemClickListener eTI;
    private com.baidu.tieba.channel.a.f eUG;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;
    private BdListView yl;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eTI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.eUG.getItem(i);
                if (item != null) {
                    String bbo = item.bbo();
                    if (!TextUtils.isEmpty(bbo)) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            j.this.eSJ.showToast(R.string.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(j.this.eSJ.getActivity(), com.baidu.adp.lib.g.b.toLong(bbo, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.eSJ = channelListActivity;
        this.eSJ.setIsAddSwipeBackLayout(true);
        this.eSJ.setSwipeBackEnabled(true);
        this.eSJ.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eSJ.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eSJ.findViewById(R.id.parent);
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eSJ.getResources().getString(R.string.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eTE = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.yl = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eUG = new com.baidu.tieba.channel.a.f(this.eSJ);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eSJ.getPageContext());
        this.yl.setPullRefresh(this.mPullView);
        this.yl.setOnItemClickListener(this.eTI);
        this.yl.setAdapter((ListAdapter) this.eUG);
        this.arb = LayoutInflater.from(this.eSJ.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.arb.findViewById(R.id.list_more_progress);
        this.eTA = (TextView) this.arb.findViewById(R.id.list_more_title);
        this.yl.addFooterView(this.arb);
    }

    public void onDestroy() {
        if (this.eUG != null) {
            this.eUG = null;
        }
    }

    public void bby() {
        this.yl.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.yl.setVisibility(0);
        this.yl.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dwI.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.eUG.setData(null);
            this.yl.setVisibility(8);
            this.eTE.setVisibility(0);
            this.eTF = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eTF.setText(this.eSJ.getResources().getString(R.string.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iS(eVar.hasMore());
        this.eUG.setData(eVar.getItems());
    }

    public void iS(boolean z) {
        this.arb.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eTA.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eTA.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.eSJ.getLayoutMode().setNightMode(i == 1);
        this.eSJ.getLayoutMode().onModeChanged(this.mRootView);
        this.eSJ.getLayoutMode().onModeChanged(this.arb);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dwI.onChangeSkinType(getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.eUG != null) {
            this.eUG.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.yl.setOnSrollToBottomListener(eVar);
    }
}
