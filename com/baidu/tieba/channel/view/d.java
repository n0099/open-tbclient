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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private View arb;
    private NoNetworkView dwI;
    private ChannelFansActivity eSm;
    private TextView eTA;
    private ViewStub eTE;
    private TextView eTF;
    private AdapterView.OnItemClickListener eTI;
    private com.baidu.tieba.channel.a.b eTW;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;
    private BdListView yl;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.eTI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.eTW.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        d.this.eSm.showToast(R.string.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.eSm.getPageContext().getPageActivity(), item.bbt() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.eSm = channelFansActivity;
        this.eSm.setIsAddSwipeBackLayout(true);
        this.eSm.setSwipeBackEnabled(true);
        this.eSm.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eSm.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eSm.findViewById(R.id.parent);
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eSm.getResources().getString(R.string.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eTE = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.yl = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eTW = new com.baidu.tieba.channel.a.b(this.eSm);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eSm.getPageContext());
        this.yl.setPullRefresh(this.mPullView);
        this.yl.setOnItemClickListener(this.eTI);
        this.yl.setAdapter((ListAdapter) this.eTW);
        this.arb = LayoutInflater.from(this.eSm.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.arb.findViewById(R.id.list_more_progress);
        this.eTA = (TextView) this.arb.findViewById(R.id.list_more_title);
        this.yl.addFooterView(this.arb);
    }

    public void onDestroy() {
        if (this.eTW != null) {
            this.eTW = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.eTW.setData(null);
            this.yl.setVisibility(8);
            this.eTE.setVisibility(0);
            this.eTF = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eTF.setText(this.eSm.getResources().getString(R.string.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iS(cVar.hasMore());
        this.eTW.setData(cVar.getItems());
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
        this.eSm.getLayoutMode().setNightMode(i == 1);
        this.eSm.getLayoutMode().onModeChanged(this.mRootView);
        this.eSm.getLayoutMode().onModeChanged(this.arb);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dwI.onChangeSkinType(getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.eTW != null) {
            this.eTW.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.yl.setOnSrollToBottomListener(eVar);
    }
}
