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
    private NoNetworkView bOA;
    private ChannelAddVideoActivity dcG;
    private TextView ded;
    private View dee;
    private View def;
    private com.baidu.tieba.channel.a.a deg;
    private TextView deh;
    private ViewStub dei;
    private TextView dej;
    private int dek;
    private View.OnClickListener del;
    private AdapterView.OnItemClickListener dem;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.dek;
        aVar.dek = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.dek;
        aVar.dek = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.dek = 0;
        this.del = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dek > 20 || a.this.dek <= 0) {
                    a.this.dcG.showToast(e.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.deg.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.ara()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").i(VideoPlayActivityConfig.OBJ_ID, a.this.dcG.getChannelId()).x("obj_locate", 5));
                a.this.dcG.bb(arrayList);
            }
        };
        this.dem = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.deg.getItem(i);
                if (item != null) {
                    item.fA(!item.ara());
                    a.this.deg.notifyDataSetChanged();
                    if (item.ara()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.dek > 0) {
                        a.this.deh.setTextColor(a.this.dcG.getResources().getColor(e.d.cp_link_tip_a));
                        a.this.deh.setEnabled(true);
                        return;
                    }
                    a.this.deh.setTextColor(a.this.dcG.getResources().getColor(e.d.cp_cont_d));
                    a.this.deh.setEnabled(false);
                }
            }
        };
        this.dcG = channelAddVideoActivity;
        this.dcG.setIsAddSwipeBackLayout(true);
        this.dcG.setSwipeBackEnabled(true);
        this.dcG.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dcG.setContentView(e.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.dcG.findViewById(e.g.parent);
        this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.dei = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dcG.getResources().getString(e.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.add_video), this.del);
        this.deh.setTextColor(this.dcG.getResources().getColor(e.d.cp_cont_d));
        this.deh.setEnabled(false);
        this.OF = (BdListView) this.mRootView.findViewById(e.g.listview);
        this.deg = new com.baidu.tieba.channel.a.a(this.dcG);
        this.OF.setOnItemClickListener(this.dem);
        this.OF.setAdapter((ListAdapter) this.deg);
        this.dee = LayoutInflater.from(this.dcG.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.OF.addHeaderView(this.dee);
        this.def = LayoutInflater.from(this.dcG.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.def.findViewById(e.g.list_more_progress);
        this.ded = (TextView) this.def.findViewById(e.g.list_more_title);
        this.OF.addFooterView(this.def);
    }

    public void onDestroy() {
        if (this.deg != null) {
            this.deg = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bOA.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.deg.setData(null);
            this.OF.setVisibility(8);
            this.dei.setVisibility(0);
            this.dej = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.dej.setText(this.dcG.getResources().getString(e.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fD(aVar.hasMore());
        this.deg.setData(aVar.getItems());
        this.deg.notifyDataSetChanged();
        this.OF.setVisibility(0);
    }

    public void fD(boolean z) {
        this.def.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.ded.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.ded.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.dcG.getLayoutMode().setNightMode(i == 1);
        this.dcG.getLayoutMode().onModeChanged(this.mRootView);
        this.dcG.getLayoutMode().onModeChanged(this.def);
        this.dcG.getLayoutMode().onModeChanged(this.dee);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bOA.onChangeSkinType(getPageContext(), i);
        if (this.deg != null) {
            this.deg.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OF.setOnSrollToBottomListener(eVar);
    }
}
