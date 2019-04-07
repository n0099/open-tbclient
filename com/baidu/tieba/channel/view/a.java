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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView Pj;
    private NoNetworkView dbq;
    private ChannelAddVideoActivity enb;
    private View eoA;
    private com.baidu.tieba.channel.a.a eoB;
    private TextView eoC;
    private ViewStub eoD;
    private TextView eoE;
    private int eoF;
    private View.OnClickListener eoG;
    private AdapterView.OnItemClickListener eoH;
    private TextView eoy;
    private View eoz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eoF;
        aVar.eoF = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eoF;
        aVar.eoF = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eoF = 0;
        this.eoG = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eoF > 20 || a.this.eoF <= 0) {
                    a.this.enb.showToast(d.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eoB.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aRn()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").k(VideoPlayActivityConfig.OBJ_ID, a.this.enb.getChannelId()).T("obj_locate", 5));
                a.this.enb.bo(arrayList);
            }
        };
        this.eoH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eoB.getItem(i);
                if (item != null) {
                    item.hV(!item.aRn());
                    a.this.eoB.notifyDataSetChanged();
                    if (item.aRn()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eoF > 0) {
                        a.this.eoC.setTextColor(a.this.enb.getResources().getColor(d.C0277d.cp_link_tip_a));
                        a.this.eoC.setEnabled(true);
                        return;
                    }
                    a.this.eoC.setTextColor(a.this.enb.getResources().getColor(d.C0277d.cp_cont_d));
                    a.this.eoC.setEnabled(false);
                }
            }
        };
        this.enb = channelAddVideoActivity;
        this.enb.setIsAddSwipeBackLayout(true);
        this.enb.setSwipeBackEnabled(true);
        this.enb.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.enb.setContentView(d.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.enb.findViewById(d.g.parent);
        this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.eoD = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.enb.getResources().getString(d.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eoC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.add_video), this.eoG);
        this.eoC.setTextColor(this.enb.getResources().getColor(d.C0277d.cp_cont_d));
        this.eoC.setEnabled(false);
        this.Pj = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.eoB = new com.baidu.tieba.channel.a.a(this.enb);
        this.Pj.setOnItemClickListener(this.eoH);
        this.Pj.setAdapter((ListAdapter) this.eoB);
        this.eoz = LayoutInflater.from(this.enb.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.Pj.addHeaderView(this.eoz);
        this.eoA = LayoutInflater.from(this.enb.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eoA.findViewById(d.g.list_more_progress);
        this.eoy = (TextView) this.eoA.findViewById(d.g.list_more_title);
        this.Pj.addFooterView(this.eoA);
    }

    public void onDestroy() {
        if (this.eoB != null) {
            this.eoB = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dbq.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eoB.setData(null);
            this.Pj.setVisibility(8);
            this.eoD.setVisibility(0);
            this.eoE = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.eoE.setText(this.enb.getResources().getString(d.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        hY(aVar.hasMore());
        this.eoB.setData(aVar.getItems());
        this.eoB.notifyDataSetChanged();
        this.Pj.setVisibility(0);
    }

    public void hY(boolean z) {
        this.eoA.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eoy.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eoy.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.enb.getLayoutMode().setNightMode(i == 1);
        this.enb.getLayoutMode().onModeChanged(this.mRootView);
        this.enb.getLayoutMode().onModeChanged(this.eoA);
        this.enb.getLayoutMode().onModeChanged(this.eoz);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbq.onChangeSkinType(getPageContext(), i);
        if (this.eoB != null) {
            this.eoB.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Pj.setOnSrollToBottomListener(eVar);
    }
}
