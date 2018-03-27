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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView auZ;
    private NoNetworkView cba;
    private ChannelAddVideoActivity dbR;
    private TextView ddp;
    private View ddq;
    private View ddr;
    private com.baidu.tieba.channel.a.a dds;
    private TextView ddt;
    private ViewStub ddv;
    private TextView ddw;
    private int ddx;
    private View.OnClickListener ddy;
    private AdapterView.OnItemClickListener ddz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.ddx;
        aVar.ddx = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.ddx;
        aVar.ddx = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.ddx = 0;
        this.ddy = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ddx > 20 || a.this.ddx <= 0) {
                    a.this.dbR.showToast(d.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.dds.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.amg()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new ak("c11937").f("obj_id", a.this.dbR.getChannelId()).s("obj_locate", 5));
                a.this.dbR.aI(arrayList);
            }
        };
        this.ddz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.dds.getItem(i);
                if (item != null) {
                    item.eS(!item.amg());
                    a.this.dds.notifyDataSetChanged();
                    if (item.amg()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.ddx > 0) {
                        a.this.ddt.setTextColor(a.this.dbR.getResources().getColor(d.C0141d.cp_link_tip_a));
                        a.this.ddt.setEnabled(true);
                        return;
                    }
                    a.this.ddt.setTextColor(a.this.dbR.getResources().getColor(d.C0141d.cp_cont_d));
                    a.this.ddt.setEnabled(false);
                }
            }
        };
        this.dbR = channelAddVideoActivity;
        this.dbR.setIsAddSwipeBackLayout(true);
        this.dbR.setSwipeBackEnabled(true);
        this.dbR.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dbR.setContentView(d.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.dbR.findViewById(d.g.parent);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.ddv = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dbR.getResources().getString(d.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.add_video), this.ddy);
        this.ddt.setTextColor(this.dbR.getResources().getColor(d.C0141d.cp_cont_d));
        this.ddt.setEnabled(false);
        this.auZ = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.dds = new com.baidu.tieba.channel.a.a(this.dbR);
        this.auZ.setOnItemClickListener(this.ddz);
        this.auZ.setAdapter((ListAdapter) this.dds);
        this.ddq = LayoutInflater.from(this.dbR.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.auZ.addHeaderView(this.ddq);
        this.ddr = LayoutInflater.from(this.dbR.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddr.findViewById(d.g.list_more_progress);
        this.ddp = (TextView) this.ddr.findViewById(d.g.list_more_title);
        this.auZ.addFooterView(this.ddr);
    }

    public void onDestroy() {
        if (this.dds != null) {
            this.dds = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.cba.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.dds.setData(null);
            this.auZ.setVisibility(8);
            this.ddv.setVisibility(0);
            this.ddw = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.ddw.setText(this.dbR.getResources().getString(d.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(aVar.hasMore());
        this.dds.setData(aVar.getItems());
        this.dds.notifyDataSetChanged();
        this.auZ.setVisibility(0);
    }

    public void eV(boolean z) {
        this.ddr.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.ddp.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.ddp.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.dbR.getLayoutMode().aQ(i == 1);
        this.dbR.getLayoutMode().aM(this.mRootView);
        this.dbR.getLayoutMode().aM(this.ddr);
        this.dbR.getLayoutMode().aM(this.ddq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cba.onChangeSkinType(getPageContext(), i);
        if (this.dds != null) {
            this.dds.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.auZ.setOnSrollToBottomListener(eVar);
    }
}
