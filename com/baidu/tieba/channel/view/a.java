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
    private NoNetworkView dbr;
    private ChannelAddVideoActivity enc;
    private View eoA;
    private View eoB;
    private com.baidu.tieba.channel.a.a eoC;
    private TextView eoD;
    private ViewStub eoE;
    private TextView eoF;
    private int eoG;
    private View.OnClickListener eoH;
    private AdapterView.OnItemClickListener eoI;
    private TextView eoz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eoG;
        aVar.eoG = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eoG;
        aVar.eoG = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eoG = 0;
        this.eoH = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eoG > 20 || a.this.eoG <= 0) {
                    a.this.enc.showToast(d.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eoC.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aRn()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").k(VideoPlayActivityConfig.OBJ_ID, a.this.enc.getChannelId()).T("obj_locate", 5));
                a.this.enc.bo(arrayList);
            }
        };
        this.eoI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eoC.getItem(i);
                if (item != null) {
                    item.hV(!item.aRn());
                    a.this.eoC.notifyDataSetChanged();
                    if (item.aRn()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eoG > 0) {
                        a.this.eoD.setTextColor(a.this.enc.getResources().getColor(d.C0277d.cp_link_tip_a));
                        a.this.eoD.setEnabled(true);
                        return;
                    }
                    a.this.eoD.setTextColor(a.this.enc.getResources().getColor(d.C0277d.cp_cont_d));
                    a.this.eoD.setEnabled(false);
                }
            }
        };
        this.enc = channelAddVideoActivity;
        this.enc.setIsAddSwipeBackLayout(true);
        this.enc.setSwipeBackEnabled(true);
        this.enc.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.enc.setContentView(d.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.enc.findViewById(d.g.parent);
        this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.eoE = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.enc.getResources().getString(d.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eoD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.add_video), this.eoH);
        this.eoD.setTextColor(this.enc.getResources().getColor(d.C0277d.cp_cont_d));
        this.eoD.setEnabled(false);
        this.Pj = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.eoC = new com.baidu.tieba.channel.a.a(this.enc);
        this.Pj.setOnItemClickListener(this.eoI);
        this.Pj.setAdapter((ListAdapter) this.eoC);
        this.eoA = LayoutInflater.from(this.enc.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.Pj.addHeaderView(this.eoA);
        this.eoB = LayoutInflater.from(this.enc.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eoB.findViewById(d.g.list_more_progress);
        this.eoz = (TextView) this.eoB.findViewById(d.g.list_more_title);
        this.Pj.addFooterView(this.eoB);
    }

    public void onDestroy() {
        if (this.eoC != null) {
            this.eoC = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dbr.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eoC.setData(null);
            this.Pj.setVisibility(8);
            this.eoE.setVisibility(0);
            this.eoF = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.eoF.setText(this.enc.getResources().getString(d.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        hY(aVar.hasMore());
        this.eoC.setData(aVar.getItems());
        this.eoC.notifyDataSetChanged();
        this.Pj.setVisibility(0);
    }

    public void hY(boolean z) {
        this.eoB.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eoz.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eoz.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.enc.getLayoutMode().setNightMode(i == 1);
        this.enc.getLayoutMode().onModeChanged(this.mRootView);
        this.enc.getLayoutMode().onModeChanged(this.eoB);
        this.enc.getLayoutMode().onModeChanged(this.eoA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbr.onChangeSkinType(getPageContext(), i);
        if (this.eoC != null) {
            this.eoC.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Pj.setOnSrollToBottomListener(eVar);
    }
}
