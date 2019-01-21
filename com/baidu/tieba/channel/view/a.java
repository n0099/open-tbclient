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
    private BdListView OQ;
    private NoNetworkView bPm;
    private ChannelAddVideoActivity ddt;
    private TextView deR;
    private View deS;
    private View deT;
    private com.baidu.tieba.channel.a.a deU;
    private TextView deV;
    private ViewStub deW;
    private TextView deX;
    private int deY;
    private View.OnClickListener deZ;
    private AdapterView.OnItemClickListener dfa;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.deY;
        aVar.deY = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.deY;
        aVar.deY = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.deY = 0;
        this.deZ = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.deY > 20 || a.this.deY <= 0) {
                    a.this.ddt.showToast(e.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.deU.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.ary()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").i(VideoPlayActivityConfig.OBJ_ID, a.this.ddt.getChannelId()).y("obj_locate", 5));
                a.this.ddt.bc(arrayList);
            }
        };
        this.dfa = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.deU.getItem(i);
                if (item != null) {
                    item.fD(!item.ary());
                    a.this.deU.notifyDataSetChanged();
                    if (item.ary()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.deY > 0) {
                        a.this.deV.setTextColor(a.this.ddt.getResources().getColor(e.d.cp_link_tip_a));
                        a.this.deV.setEnabled(true);
                        return;
                    }
                    a.this.deV.setTextColor(a.this.ddt.getResources().getColor(e.d.cp_cont_d));
                    a.this.deV.setEnabled(false);
                }
            }
        };
        this.ddt = channelAddVideoActivity;
        this.ddt.setIsAddSwipeBackLayout(true);
        this.ddt.setSwipeBackEnabled(true);
        this.ddt.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ddt.setContentView(e.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.ddt.findViewById(e.g.parent);
        this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.deW = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ddt.getResources().getString(e.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.add_video), this.deZ);
        this.deV.setTextColor(this.ddt.getResources().getColor(e.d.cp_cont_d));
        this.deV.setEnabled(false);
        this.OQ = (BdListView) this.mRootView.findViewById(e.g.listview);
        this.deU = new com.baidu.tieba.channel.a.a(this.ddt);
        this.OQ.setOnItemClickListener(this.dfa);
        this.OQ.setAdapter((ListAdapter) this.deU);
        this.deS = LayoutInflater.from(this.ddt.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.OQ.addHeaderView(this.deS);
        this.deT = LayoutInflater.from(this.ddt.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.deT.findViewById(e.g.list_more_progress);
        this.deR = (TextView) this.deT.findViewById(e.g.list_more_title);
        this.OQ.addFooterView(this.deT);
    }

    public void onDestroy() {
        if (this.deU != null) {
            this.deU = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bPm.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.deU.setData(null);
            this.OQ.setVisibility(8);
            this.deW.setVisibility(0);
            this.deX = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.deX.setText(this.ddt.getResources().getString(e.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fG(aVar.hasMore());
        this.deU.setData(aVar.getItems());
        this.deU.notifyDataSetChanged();
        this.OQ.setVisibility(0);
    }

    public void fG(boolean z) {
        this.deT.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.deR.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.deR.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.ddt.getLayoutMode().setNightMode(i == 1);
        this.ddt.getLayoutMode().onModeChanged(this.mRootView);
        this.ddt.getLayoutMode().onModeChanged(this.deT);
        this.ddt.getLayoutMode().onModeChanged(this.deS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPm.onChangeSkinType(getPageContext(), i);
        if (this.deU != null) {
            this.deU.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OQ.setOnSrollToBottomListener(eVar);
    }
}
