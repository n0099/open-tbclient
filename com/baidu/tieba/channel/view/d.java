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
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.base.c<ChannelFansActivity> {
    private BdListView avh;
    private NoNetworkView cbj;
    private ChannelFansActivity dch;
    private View ddB;
    private ViewStub ddE;
    private TextView ddF;
    private AdapterView.OnItemClickListener ddI;
    private com.baidu.tieba.channel.a.b ddW;
    private TextView ddz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public d(ChannelFansActivity channelFansActivity) {
        super(channelFansActivity.getPageContext());
        this.mPullView = null;
        this.ddI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.i item = d.this.ddW.getItem(i);
                if (item != null && !TextUtils.isEmpty(item.getUser_name())) {
                    if (!com.baidu.adp.lib.util.j.oJ()) {
                        d.this.dch.showToast(d.j.neterror);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.dch.getPageContext().getPageActivity(), item.amr() + "", item.getUser_name())));
                    }
                }
            }
        };
        this.dch = channelFansActivity;
        this.dch.setIsAddSwipeBackLayout(true);
        this.dch.setSwipeBackEnabled(true);
        this.dch.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dch.setContentView(d.h.channel_list_layout);
        this.mRootView = (RelativeLayout) this.dch.findViewById(d.g.parent);
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.channel_list_no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_list_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dch.getResources().getString(d.j.subcribe_channel_fans_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddE = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.avh = (BdListView) this.mRootView.findViewById(d.g.channel_list_listview);
        this.ddW = new com.baidu.tieba.channel.a.b(this.dch);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.dch.getPageContext());
        this.avh.setPullRefresh(this.mPullView);
        this.avh.setOnItemClickListener(this.ddI);
        this.avh.setAdapter((ListAdapter) this.ddW);
        this.ddB = LayoutInflater.from(this.dch.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddB.findViewById(d.g.list_more_progress);
        this.ddz = (TextView) this.ddB.findViewById(d.g.list_more_title);
        this.avh.addFooterView(this.ddB);
    }

    public void onDestroy() {
        if (this.ddW != null) {
            this.ddW = null;
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

    public void a(com.baidu.tieba.channel.data.c cVar) {
        if (cVar == null || cVar.getItems() == null || cVar.getItems().size() <= 0) {
            this.ddW.setData(null);
            this.avh.setVisibility(8);
            this.ddE.setVisibility(0);
            this.ddF = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.ddF.setText(this.dch.getResources().getString(d.j.no_fans));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(cVar.hasMore());
        this.ddW.setData(cVar.getItems());
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
        this.dch.getLayoutMode().aQ(i == 1);
        this.dch.getLayoutMode().aM(this.mRootView);
        this.dch.getLayoutMode().aM(this.ddB);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cbj.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        if (this.ddW != null) {
            this.ddW.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.avh.setOnSrollToBottomListener(eVar);
    }
}
