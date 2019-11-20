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
    private View aqJ;
    private NoNetworkView dvR;
    private ChannelFansActivity eRv;
    private TextView eSJ;
    private ViewStub eSN;
    private TextView eSO;
    private AdapterView.OnItemClickListener eSR;
    private com.baidu.tieba.channel.a.b eTf;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;
    private BdListView xL;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.eSR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.eTf.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        d.this.eRv.showToast(R.string.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.eRv.getPageContext().getPageActivity(), item.bbr() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.eRv = channelFansActivity;
        this.eRv.setIsAddSwipeBackLayout(true);
        this.eRv.setSwipeBackEnabled(true);
        this.eRv.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eRv.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eRv.findViewById(R.id.parent);
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eRv.getResources().getString(R.string.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSN = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.xL = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eTf = new com.baidu.tieba.channel.a.b(this.eRv);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eRv.getPageContext());
        this.xL.setPullRefresh(this.mPullView);
        this.xL.setOnItemClickListener(this.eSR);
        this.xL.setAdapter((ListAdapter) this.eTf);
        this.aqJ = LayoutInflater.from(this.eRv.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.aqJ.findViewById(R.id.list_more_progress);
        this.eSJ = (TextView) this.aqJ.findViewById(R.id.list_more_title);
        this.xL.addFooterView(this.aqJ);
    }

    public void onDestroy() {
        if (this.eTf != null) {
            this.eTf = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.eTf.setData(null);
            this.xL.setVisibility(8);
            this.eSN.setVisibility(0);
            this.eSO = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eSO.setText(this.eRv.getResources().getString(R.string.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iS(cVar.hasMore());
        this.eTf.setData(cVar.getItems());
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
        this.eRv.getLayoutMode().setNightMode(i == 1);
        this.eRv.getLayoutMode().onModeChanged(this.mRootView);
        this.eRv.getLayoutMode().onModeChanged(this.aqJ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dvR.onChangeSkinType(getPageContext(), i);
        this.mPullView.changeSkin(i);
        if (this.eTf != null) {
            this.eTf.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.xL.setOnSrollToBottomListener(eVar);
    }
}
