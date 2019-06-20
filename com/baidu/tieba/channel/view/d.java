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
    private BdListView MR;
    private NoNetworkView dlX;
    private ChannelFansActivity eCV;
    private com.baidu.tieba.channel.a.b eEE;
    private TextView eEi;
    private ViewStub eEm;
    private TextView eEn;
    private AdapterView.OnItemClickListener eEq;
    private View epZ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.eEq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.eEE.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.jS()) {
                        d.this.eCV.showToast(R.string.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.eCV.getPageContext().getPageActivity(), item.aYK() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.eCV = channelFansActivity;
        this.eCV.setIsAddSwipeBackLayout(true);
        this.eCV.setSwipeBackEnabled(true);
        this.eCV.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eCV.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eCV.findViewById(R.id.parent);
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eCV.getResources().getString(R.string.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEm = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.MR = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eEE = new com.baidu.tieba.channel.a.b(this.eCV);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eCV.getPageContext());
        this.MR.setPullRefresh(this.mPullView);
        this.MR.setOnItemClickListener(this.eEq);
        this.MR.setAdapter((ListAdapter) this.eEE);
        this.epZ = LayoutInflater.from(this.eCV.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.epZ.findViewById(R.id.list_more_progress);
        this.eEi = (TextView) this.epZ.findViewById(R.id.list_more_title);
        this.MR.addFooterView(this.epZ);
    }

    public void onDestroy() {
        if (this.eEE != null) {
            this.eEE = null;
        }
    }

    public void aYO() {
        this.MR.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.MR.setVisibility(0);
        this.MR.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dlX.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.eEE.setData(null);
            this.MR.setVisibility(8);
            this.eEm.setVisibility(0);
            this.eEn = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eEn.setText(this.eCV.getResources().getString(R.string.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iD(cVar.hasMore());
        this.eEE.setData(cVar.getItems());
    }

    public void iD(boolean z) {
        this.epZ.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eEi.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eEi.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.eCV.getLayoutMode().setNightMode(i == 1);
        this.eCV.getLayoutMode().onModeChanged(this.mRootView);
        this.eCV.getLayoutMode().onModeChanged(this.epZ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlX.onChangeSkinType(getPageContext(), i);
        this.mPullView.iP(i);
        if (this.eEE != null) {
            this.eEE.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.MR.setOnSrollToBottomListener(eVar);
    }
}
