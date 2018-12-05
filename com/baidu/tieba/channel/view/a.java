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
    private BdListView OF;
    private NoNetworkView bOx;
    private ChannelAddVideoActivity cZN;
    private TextView dbl;
    private View dbm;
    private View dbn;
    private com.baidu.tieba.channel.a.a dbo;
    private TextView dbp;
    private ViewStub dbq;
    private TextView dbr;
    private int dbs;
    private View.OnClickListener dbt;
    private AdapterView.OnItemClickListener dbu;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.dbs;
        aVar.dbs = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.dbs;
        aVar.dbs = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.dbs = 0;
        this.dbt = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dbs > 20 || a.this.dbs <= 0) {
                    a.this.cZN.showToast(e.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.dbo.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aql()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").i(VideoPlayActivityConfig.OBJ_ID, a.this.cZN.getChannelId()).x("obj_locate", 5));
                a.this.cZN.ba(arrayList);
            }
        };
        this.dbu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.dbo.getItem(i);
                if (item != null) {
                    item.fy(!item.aql());
                    a.this.dbo.notifyDataSetChanged();
                    if (item.aql()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.dbs > 0) {
                        a.this.dbp.setTextColor(a.this.cZN.getResources().getColor(e.d.cp_link_tip_a));
                        a.this.dbp.setEnabled(true);
                        return;
                    }
                    a.this.dbp.setTextColor(a.this.cZN.getResources().getColor(e.d.cp_cont_d));
                    a.this.dbp.setEnabled(false);
                }
            }
        };
        this.cZN = channelAddVideoActivity;
        this.cZN.setIsAddSwipeBackLayout(true);
        this.cZN.setSwipeBackEnabled(true);
        this.cZN.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cZN.setContentView(e.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cZN.findViewById(e.g.parent);
        this.bOx = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.dbq = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cZN.getResources().getString(e.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dbp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.add_video), this.dbt);
        this.dbp.setTextColor(this.cZN.getResources().getColor(e.d.cp_cont_d));
        this.dbp.setEnabled(false);
        this.OF = (BdListView) this.mRootView.findViewById(e.g.listview);
        this.dbo = new com.baidu.tieba.channel.a.a(this.cZN);
        this.OF.setOnItemClickListener(this.dbu);
        this.OF.setAdapter((ListAdapter) this.dbo);
        this.dbm = LayoutInflater.from(this.cZN.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.OF.addHeaderView(this.dbm);
        this.dbn = LayoutInflater.from(this.cZN.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.dbn.findViewById(e.g.list_more_progress);
        this.dbl = (TextView) this.dbn.findViewById(e.g.list_more_title);
        this.OF.addFooterView(this.dbn);
    }

    public void onDestroy() {
        if (this.dbo != null) {
            this.dbo = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bOx.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.dbo.setData(null);
            this.OF.setVisibility(8);
            this.dbq.setVisibility(0);
            this.dbr = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.dbr.setText(this.cZN.getResources().getString(e.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fB(aVar.hasMore());
        this.dbo.setData(aVar.getItems());
        this.dbo.notifyDataSetChanged();
        this.OF.setVisibility(0);
    }

    public void fB(boolean z) {
        this.dbn.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.dbl.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.dbl.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cZN.getLayoutMode().setNightMode(i == 1);
        this.cZN.getLayoutMode().onModeChanged(this.mRootView);
        this.cZN.getLayoutMode().onModeChanged(this.dbn);
        this.cZN.getLayoutMode().onModeChanged(this.dbm);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bOx.onChangeSkinType(getPageContext(), i);
        if (this.dbo != null) {
            this.dbo.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OF.setOnSrollToBottomListener(eVar);
    }
}
