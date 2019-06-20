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
    private BdListView MR;
    private NoNetworkView dlX;
    private ChannelListActivity eDs;
    private TextView eEi;
    private ViewStub eEm;
    private TextView eEn;
    private AdapterView.OnItemClickListener eEq;
    private com.baidu.tieba.channel.a.f eFo;
    private View epZ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eEq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.eFo.getItem(i);
                if (item != null) {
                    String aYF = item.aYF();
                    if (!TextUtils.isEmpty(aYF)) {
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            j.this.eDs.showToast(R.string.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.eDs.getActivity(), com.baidu.adp.lib.g.b.c(aYF, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.eDs = channelListActivity;
        this.eDs.setIsAddSwipeBackLayout(true);
        this.eDs.setSwipeBackEnabled(true);
        this.eDs.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eDs.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eDs.findViewById(R.id.parent);
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eDs.getResources().getString(R.string.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEm = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.MR = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eFo = new com.baidu.tieba.channel.a.f(this.eDs);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eDs.getPageContext());
        this.MR.setPullRefresh(this.mPullView);
        this.MR.setOnItemClickListener(this.eEq);
        this.MR.setAdapter((ListAdapter) this.eFo);
        this.epZ = LayoutInflater.from(this.eDs.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.epZ.findViewById(R.id.list_more_progress);
        this.eEi = (TextView) this.epZ.findViewById(R.id.list_more_title);
        this.MR.addFooterView(this.epZ);
    }

    public void onDestroy() {
        if (this.eFo != null) {
            this.eFo = null;
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

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.eFo.setData(null);
            this.MR.setVisibility(8);
            this.eEm.setVisibility(0);
            this.eEn = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eEn.setText(this.eDs.getResources().getString(R.string.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iD(eVar.hasMore());
        this.eFo.setData(eVar.getItems());
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
        this.eDs.getLayoutMode().setNightMode(i == 1);
        this.eDs.getLayoutMode().onModeChanged(this.mRootView);
        this.eDs.getLayoutMode().onModeChanged(this.epZ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlX.onChangeSkinType(getPageContext(), i);
        this.mPullView.iP(i);
        if (this.eFo != null) {
            this.eFo.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.MR.setOnSrollToBottomListener(eVar);
    }
}
