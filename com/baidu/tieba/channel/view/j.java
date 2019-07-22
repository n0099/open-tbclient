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
    private BdListView Ni;
    private NoNetworkView dnF;
    private ChannelListActivity eIo;
    private TextView eJe;
    private ViewStub eJi;
    private TextView eJj;
    private AdapterView.OnItemClickListener eJm;
    private com.baidu.tieba.channel.a.f eKk;
    private View euX;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(ChannelListActivity channelListActivity) {
        super(channelListActivity.getPageContext());
        this.mPullView = null;
        this.eJm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.j.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.f item = j.this.eKk.getItem(i);
                if (item != null) {
                    String baE = item.baE();
                    if (!TextUtils.isEmpty(baE)) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            j.this.eIo.showToast(R.string.neterror);
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(j.this.eIo.getActivity(), com.baidu.adp.lib.g.b.c(baE, 0L), 0)));
                        }
                    }
                }
            }
        };
        this.eIo = channelListActivity;
        this.eIo.setIsAddSwipeBackLayout(true);
        this.eIo.setSwipeBackEnabled(true);
        this.eIo.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eIo.setContentView(R.layout.channel_list_layout);
        this.mRootView = (RelativeLayout) this.eIo.findViewById(R.id.parent);
        this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eIo.getResources().getString(R.string.subcribe_channel_list_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJi = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.Ni = (BdListView) this.mRootView.findViewById(R.id.channel_list_listview);
        this.eKk = new com.baidu.tieba.channel.a.f(this.eIo);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eIo.getPageContext());
        this.Ni.setPullRefresh(this.mPullView);
        this.Ni.setOnItemClickListener(this.eJm);
        this.Ni.setAdapter((ListAdapter) this.eKk);
        this.euX = LayoutInflater.from(this.eIo.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.euX.findViewById(R.id.list_more_progress);
        this.eJe = (TextView) this.euX.findViewById(R.id.list_more_title);
        this.Ni.addFooterView(this.euX);
    }

    public void onDestroy() {
        if (this.eKk != null) {
            this.eKk = null;
        }
    }

    public void baN() {
        this.Ni.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.Ni.setVisibility(0);
        this.Ni.startPullRefresh();
    }

    public void c(NoNetworkView.a aVar) {
        this.dnF.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.e eVar) {
        if (eVar == null || eVar.getItems() == null || eVar.getItems().size() <= 0) {
            this.eKk.setData(null);
            this.Ni.setVisibility(8);
            this.eJi.setVisibility(0);
            this.eJj = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eJj.setText(this.eIo.getResources().getString(R.string.no_channel));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iM(eVar.hasMore());
        this.eKk.setData(eVar.getItems());
    }

    public void iM(boolean z) {
        this.euX.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eJe.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eJe.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void a(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void onChangeSkinType(int i) {
        this.eIo.getLayoutMode().setNightMode(i == 1);
        this.eIo.getLayoutMode().onModeChanged(this.mRootView);
        this.eIo.getLayoutMode().onModeChanged(this.euX);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnF.onChangeSkinType(getPageContext(), i);
        this.mPullView.iV(i);
        if (this.eKk != null) {
            this.eKk.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Ni.setOnSrollToBottomListener(eVar);
    }
}
