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
    private NoNetworkView bPl;
    private ChannelAddVideoActivity dds;
    private TextView deQ;
    private View deR;
    private View deS;
    private com.baidu.tieba.channel.a.a deT;
    private TextView deU;
    private ViewStub deV;
    private TextView deW;
    private int deX;
    private View.OnClickListener deY;
    private AdapterView.OnItemClickListener deZ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.deX;
        aVar.deX = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.deX;
        aVar.deX = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.deX = 0;
        this.deY = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.deX > 20 || a.this.deX <= 0) {
                    a.this.dds.showToast(e.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.deT.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.ary()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").i(VideoPlayActivityConfig.OBJ_ID, a.this.dds.getChannelId()).y("obj_locate", 5));
                a.this.dds.bc(arrayList);
            }
        };
        this.deZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.deT.getItem(i);
                if (item != null) {
                    item.fD(!item.ary());
                    a.this.deT.notifyDataSetChanged();
                    if (item.ary()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.deX > 0) {
                        a.this.deU.setTextColor(a.this.dds.getResources().getColor(e.d.cp_link_tip_a));
                        a.this.deU.setEnabled(true);
                        return;
                    }
                    a.this.deU.setTextColor(a.this.dds.getResources().getColor(e.d.cp_cont_d));
                    a.this.deU.setEnabled(false);
                }
            }
        };
        this.dds = channelAddVideoActivity;
        this.dds.setIsAddSwipeBackLayout(true);
        this.dds.setSwipeBackEnabled(true);
        this.dds.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dds.setContentView(e.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.dds.findViewById(e.g.parent);
        this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.deV = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dds.getResources().getString(e.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.add_video), this.deY);
        this.deU.setTextColor(this.dds.getResources().getColor(e.d.cp_cont_d));
        this.deU.setEnabled(false);
        this.OQ = (BdListView) this.mRootView.findViewById(e.g.listview);
        this.deT = new com.baidu.tieba.channel.a.a(this.dds);
        this.OQ.setOnItemClickListener(this.deZ);
        this.OQ.setAdapter((ListAdapter) this.deT);
        this.deR = LayoutInflater.from(this.dds.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.OQ.addHeaderView(this.deR);
        this.deS = LayoutInflater.from(this.dds.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.deS.findViewById(e.g.list_more_progress);
        this.deQ = (TextView) this.deS.findViewById(e.g.list_more_title);
        this.OQ.addFooterView(this.deS);
    }

    public void onDestroy() {
        if (this.deT != null) {
            this.deT = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bPl.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.deT.setData(null);
            this.OQ.setVisibility(8);
            this.deV.setVisibility(0);
            this.deW = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.deW.setText(this.dds.getResources().getString(e.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fG(aVar.hasMore());
        this.deT.setData(aVar.getItems());
        this.deT.notifyDataSetChanged();
        this.OQ.setVisibility(0);
    }

    public void fG(boolean z) {
        this.deS.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.deQ.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.deQ.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.dds.getLayoutMode().setNightMode(i == 1);
        this.dds.getLayoutMode().onModeChanged(this.mRootView);
        this.dds.getLayoutMode().onModeChanged(this.deS);
        this.dds.getLayoutMode().onModeChanged(this.deR);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPl.onChangeSkinType(getPageContext(), i);
        if (this.deT != null) {
            this.deT.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OQ.setOnSrollToBottomListener(eVar);
    }
}
