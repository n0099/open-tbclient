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
    private BdListView auY;
    private NoNetworkView caX;
    private ChannelAddVideoActivity dbO;
    private TextView ddm;
    private View ddn;
    private View ddo;
    private com.baidu.tieba.channel.a.a ddp;
    private TextView ddq;
    private ViewStub ddr;
    private TextView dds;
    private int ddt;
    private View.OnClickListener ddv;
    private AdapterView.OnItemClickListener ddw;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.ddt;
        aVar.ddt = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.ddt;
        aVar.ddt = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.ddt = 0;
        this.ddv = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ddt > 20 || a.this.ddt <= 0) {
                    a.this.dbO.showToast(d.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.ddp.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.amf()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new ak("c11937").f("obj_id", a.this.dbO.getChannelId()).s("obj_locate", 5));
                a.this.dbO.aI(arrayList);
            }
        };
        this.ddw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.ddp.getItem(i);
                if (item != null) {
                    item.eS(!item.amf());
                    a.this.ddp.notifyDataSetChanged();
                    if (item.amf()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.ddt > 0) {
                        a.this.ddq.setTextColor(a.this.dbO.getResources().getColor(d.C0141d.cp_link_tip_a));
                        a.this.ddq.setEnabled(true);
                        return;
                    }
                    a.this.ddq.setTextColor(a.this.dbO.getResources().getColor(d.C0141d.cp_cont_d));
                    a.this.ddq.setEnabled(false);
                }
            }
        };
        this.dbO = channelAddVideoActivity;
        this.dbO.setIsAddSwipeBackLayout(true);
        this.dbO.setSwipeBackEnabled(true);
        this.dbO.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dbO.setContentView(d.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.dbO.findViewById(d.g.parent);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.ddr = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dbO.getResources().getString(d.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.add_video), this.ddv);
        this.ddq.setTextColor(this.dbO.getResources().getColor(d.C0141d.cp_cont_d));
        this.ddq.setEnabled(false);
        this.auY = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.ddp = new com.baidu.tieba.channel.a.a(this.dbO);
        this.auY.setOnItemClickListener(this.ddw);
        this.auY.setAdapter((ListAdapter) this.ddp);
        this.ddn = LayoutInflater.from(this.dbO.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.auY.addHeaderView(this.ddn);
        this.ddo = LayoutInflater.from(this.dbO.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddo.findViewById(d.g.list_more_progress);
        this.ddm = (TextView) this.ddo.findViewById(d.g.list_more_title);
        this.auY.addFooterView(this.ddo);
    }

    public void onDestroy() {
        if (this.ddp != null) {
            this.ddp = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.caX.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.ddp.setData(null);
            this.auY.setVisibility(8);
            this.ddr.setVisibility(0);
            this.dds = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.dds.setText(this.dbO.getResources().getString(d.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(aVar.hasMore());
        this.ddp.setData(aVar.getItems());
        this.ddp.notifyDataSetChanged();
        this.auY.setVisibility(0);
    }

    public void eV(boolean z) {
        this.ddo.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.ddm.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.ddm.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.dbO.getLayoutMode().aQ(i == 1);
        this.dbO.getLayoutMode().aM(this.mRootView);
        this.dbO.getLayoutMode().aM(this.ddo);
        this.dbO.getLayoutMode().aM(this.ddn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.caX.onChangeSkinType(getPageContext(), i);
        if (this.ddp != null) {
            this.ddp.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.auY.setOnSrollToBottomListener(eVar);
    }
}
