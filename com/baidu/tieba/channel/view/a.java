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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView LO;
    private NoNetworkView bvz;
    private ChannelAddVideoActivity cDT;
    private TextView cFp;
    private View cFq;
    private View cFr;
    private com.baidu.tieba.channel.a.a cFs;
    private TextView cFt;
    private ViewStub cFu;
    private TextView cFv;
    private int cFw;
    private View.OnClickListener cFx;
    private AdapterView.OnItemClickListener cFy;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cFw;
        aVar.cFw = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cFw;
        aVar.cFw = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cFw = 0;
        this.cFx = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cFw > 20 || a.this.cFw <= 0) {
                    a.this.cDT.showToast(d.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cFs.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.ajG()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new an("c11937").f(VideoPlayActivityConfig.OBJ_ID, a.this.cDT.getChannelId()).r("obj_locate", 5));
                a.this.cDT.aJ(arrayList);
            }
        };
        this.cFy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cFs.getItem(i);
                if (item != null) {
                    item.eD(!item.ajG());
                    a.this.cFs.notifyDataSetChanged();
                    if (item.ajG()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cFw > 0) {
                        a.this.cFt.setTextColor(a.this.cDT.getResources().getColor(d.C0140d.cp_link_tip_a));
                        a.this.cFt.setEnabled(true);
                        return;
                    }
                    a.this.cFt.setTextColor(a.this.cDT.getResources().getColor(d.C0140d.cp_cont_d));
                    a.this.cFt.setEnabled(false);
                }
            }
        };
        this.cDT = channelAddVideoActivity;
        this.cDT.setIsAddSwipeBackLayout(true);
        this.cDT.setSwipeBackEnabled(true);
        this.cDT.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cDT.setContentView(d.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cDT.findViewById(d.g.parent);
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.cFu = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cDT.getResources().getString(d.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cFt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.add_video), this.cFx);
        this.cFt.setTextColor(this.cDT.getResources().getColor(d.C0140d.cp_cont_d));
        this.cFt.setEnabled(false);
        this.LO = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.cFs = new com.baidu.tieba.channel.a.a(this.cDT);
        this.LO.setOnItemClickListener(this.cFy);
        this.LO.setAdapter((ListAdapter) this.cFs);
        this.cFq = LayoutInflater.from(this.cDT.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.LO.addHeaderView(this.cFq);
        this.cFr = LayoutInflater.from(this.cDT.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cFr.findViewById(d.g.list_more_progress);
        this.cFp = (TextView) this.cFr.findViewById(d.g.list_more_title);
        this.LO.addFooterView(this.cFr);
    }

    public void onDestroy() {
        if (this.cFs != null) {
            this.cFs = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bvz.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cFs.setData(null);
            this.LO.setVisibility(8);
            this.cFu.setVisibility(0);
            this.cFv = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cFv.setText(this.cDT.getResources().getString(d.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eG(aVar.hasMore());
        this.cFs.setData(aVar.getItems());
        this.cFs.notifyDataSetChanged();
        this.LO.setVisibility(0);
    }

    public void eG(boolean z) {
        this.cFr.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cFp.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cFp.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cDT.getLayoutMode().setNightMode(i == 1);
        this.cDT.getLayoutMode().onModeChanged(this.mRootView);
        this.cDT.getLayoutMode().onModeChanged(this.cFr);
        this.cDT.getLayoutMode().onModeChanged(this.cFq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvz.onChangeSkinType(getPageContext(), i);
        if (this.cFs != null) {
            this.cFs.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LO.setOnSrollToBottomListener(eVar);
    }
}
