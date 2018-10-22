package com.baidu.tieba.channel.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView OE;
    private NoNetworkView bJX;
    private ChannelAddVideoActivity cSa;
    private TextView cTA;
    private ViewStub cTB;
    private TextView cTC;
    private int cTD;
    private View.OnClickListener cTE;
    private AdapterView.OnItemClickListener cTF;
    private TextView cTw;
    private View cTx;
    private View cTy;
    private com.baidu.tieba.channel.a.a cTz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cTD;
        aVar.cTD = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cTD;
        aVar.cTD = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cTD = 0;
        this.cTE = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cTD > 20 || a.this.cTD <= 0) {
                    a.this.cSa.showToast(e.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cTz.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aoX()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").h(VideoPlayActivityConfig.OBJ_ID, a.this.cSa.getChannelId()).x("obj_locate", 5));
                a.this.cSa.ba(arrayList);
            }
        };
        this.cTF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cTz.getItem(i);
                if (item != null) {
                    item.fm(!item.aoX());
                    a.this.cTz.notifyDataSetChanged();
                    if (item.aoX()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cTD > 0) {
                        a.this.cTA.setTextColor(a.this.cSa.getResources().getColor(e.d.cp_link_tip_a));
                        a.this.cTA.setEnabled(true);
                        return;
                    }
                    a.this.cTA.setTextColor(a.this.cSa.getResources().getColor(e.d.cp_cont_d));
                    a.this.cTA.setEnabled(false);
                }
            }
        };
        this.cSa = channelAddVideoActivity;
        this.cSa.setIsAddSwipeBackLayout(true);
        this.cSa.setSwipeBackEnabled(true);
        this.cSa.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cSa.setContentView(e.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cSa.findViewById(e.g.parent);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.cTB = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cSa.getResources().getString(e.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cTA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.add_video), this.cTE);
        this.cTA.setTextColor(this.cSa.getResources().getColor(e.d.cp_cont_d));
        this.cTA.setEnabled(false);
        this.OE = (BdListView) this.mRootView.findViewById(e.g.listview);
        this.cTz = new com.baidu.tieba.channel.a.a(this.cSa);
        this.OE.setOnItemClickListener(this.cTF);
        this.OE.setAdapter((ListAdapter) this.cTz);
        this.cTx = LayoutInflater.from(this.cSa.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.OE.addHeaderView(this.cTx);
        this.cTy = LayoutInflater.from(this.cSa.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cTy.findViewById(e.g.list_more_progress);
        this.cTw = (TextView) this.cTy.findViewById(e.g.list_more_title);
        this.OE.addFooterView(this.cTy);
    }

    public void onDestroy() {
        if (this.cTz != null) {
            this.cTz = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bJX.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cTz.setData(null);
            this.OE.setVisibility(8);
            this.cTB.setVisibility(0);
            this.cTC = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cTC.setText(this.cSa.getResources().getString(e.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fp(aVar.hasMore());
        this.cTz.setData(aVar.getItems());
        this.cTz.notifyDataSetChanged();
        this.OE.setVisibility(0);
    }

    public void fp(boolean z) {
        this.cTy.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cTw.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cTw.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cSa.getLayoutMode().setNightMode(i == 1);
        this.cSa.getLayoutMode().onModeChanged(this.mRootView);
        this.cSa.getLayoutMode().onModeChanged(this.cTy);
        this.cSa.getLayoutMode().onModeChanged(this.cTx);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bJX.onChangeSkinType(getPageContext(), i);
        if (this.cTz != null) {
            this.cTz.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OE.setOnSrollToBottomListener(eVar);
    }
}
