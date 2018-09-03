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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView LO;
    private NoNetworkView bvB;
    private ChannelFansActivity cDX;
    private com.baidu.tieba.channel.a.b cFJ;
    private TextView cFm;
    private View cFo;
    private ViewStub cFr;
    private TextView cFs;
    private AdapterView.OnItemClickListener cFv;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.cFv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.cFJ.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.jE()) {
                        d.this.cDX.showToast(f.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.cDX.getPageContext().getPageActivity(), item.ajU() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.cDX = channelFansActivity;
        this.cDX.setIsAddSwipeBackLayout(true);
        this.cDX.setSwipeBackEnabled(true);
        this.cDX.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cDX.setContentView(f.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.cDX.findViewById(f.g.parent);
        this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cDX.getResources().getString(f.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cFr = (ViewStub) this.mRootView.findViewById(f.g.no_data_viewstub);
        this.LO = (BdListView) this.mRootView.findViewById(f.g.channel_list_listview);
        this.cFJ = new com.baidu.tieba.channel.a.b(this.cDX);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cDX.getPageContext());
        this.LO.setPullRefresh(this.mPullView);
        this.LO.setOnItemClickListener(this.cFv);
        this.LO.setAdapter((ListAdapter) this.cFJ);
        this.cFo = LayoutInflater.from(this.cDX.getPageContext().getPageActivity()).inflate(f.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cFo.findViewById(f.g.list_more_progress);
        this.cFm = (TextView) this.cFo.findViewById(f.g.list_more_title);
        this.LO.addFooterView(this.cFo);
    }

    public void onDestroy() {
        if (this.cFJ != null) {
            this.cFJ = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.cFJ.setData(null);
            this.LO.setVisibility(8);
            this.cFr.setVisibility(0);
            this.cFs = (TextView) this.mRootView.findViewById(f.g.no_data_tip);
            this.cFs.setText(this.cDX.getResources().getString(f.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eG(cVar.hasMore());
        this.cFJ.setData(cVar.getItems());
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
        this.cDX.getLayoutMode().setNightMode(i == 1);
        this.cDX.getLayoutMode().onModeChanged(this.mRootView);
        this.cDX.getLayoutMode().onModeChanged(this.cFo);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvB.onChangeSkinType(getPageContext(), i);
        this.mPullView.dB(i);
        if (this.cFJ != null) {
            this.cFJ.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LO.setOnSrollToBottomListener(eVar);
    }
}
