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
    private NoNetworkView dbm;
    private ChannelAddVideoActivity enq;
    private TextView eoM;
    private View eoN;
    private View eoO;
    private com.baidu.tieba.channel.a.a eoP;
    private TextView eoQ;
    private ViewStub eoR;
    private TextView eoS;
    private int eoT;
    private View.OnClickListener eoU;
    private AdapterView.OnItemClickListener eoV;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eoT;
        aVar.eoT = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eoT;
        aVar.eoT = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eoT = 0;
        this.eoU = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eoT > 20 || a.this.eoT <= 0) {
                    a.this.enq.showToast(d.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eoP.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aRp()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").k(VideoPlayActivityConfig.OBJ_ID, a.this.enq.getChannelId()).T("obj_locate", 5));
                a.this.enq.bq(arrayList);
            }
        };
        this.eoV = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eoP.getItem(i);
                if (item != null) {
                    item.hV(!item.aRp());
                    a.this.eoP.notifyDataSetChanged();
                    if (item.aRp()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eoT > 0) {
                        a.this.eoQ.setTextColor(a.this.enq.getResources().getColor(d.C0277d.cp_link_tip_a));
                        a.this.eoQ.setEnabled(true);
                        return;
                    }
                    a.this.eoQ.setTextColor(a.this.enq.getResources().getColor(d.C0277d.cp_cont_d));
                    a.this.eoQ.setEnabled(false);
                }
            }
        };
        this.enq = channelAddVideoActivity;
        this.enq.setIsAddSwipeBackLayout(true);
        this.enq.setSwipeBackEnabled(true);
        this.enq.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.enq.setContentView(d.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.enq.findViewById(d.g.parent);
        this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.eoR = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.enq.getResources().getString(d.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eoQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.add_video), this.eoU);
        this.eoQ.setTextColor(this.enq.getResources().getColor(d.C0277d.cp_cont_d));
        this.eoQ.setEnabled(false);
        this.Pj = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.eoP = new com.baidu.tieba.channel.a.a(this.enq);
        this.Pj.setOnItemClickListener(this.eoV);
        this.Pj.setAdapter((ListAdapter) this.eoP);
        this.eoN = LayoutInflater.from(this.enq.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.Pj.addHeaderView(this.eoN);
        this.eoO = LayoutInflater.from(this.enq.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eoO.findViewById(d.g.list_more_progress);
        this.eoM = (TextView) this.eoO.findViewById(d.g.list_more_title);
        this.Pj.addFooterView(this.eoO);
    }

    public void onDestroy() {
        if (this.eoP != null) {
            this.eoP = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dbm.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eoP.setData(null);
            this.Pj.setVisibility(8);
            this.eoR.setVisibility(0);
            this.eoS = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.eoS.setText(this.enq.getResources().getString(d.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        hY(aVar.hasMore());
        this.eoP.setData(aVar.getItems());
        this.eoP.notifyDataSetChanged();
        this.Pj.setVisibility(0);
    }

    public void hY(boolean z) {
        this.eoO.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eoM.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eoM.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.enq.getLayoutMode().setNightMode(i == 1);
        this.enq.getLayoutMode().onModeChanged(this.mRootView);
        this.enq.getLayoutMode().onModeChanged(this.eoO);
        this.enq.getLayoutMode().onModeChanged(this.eoN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dbm.onChangeSkinType(getPageContext(), i);
        if (this.eoP != null) {
            this.eoP.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Pj.setOnSrollToBottomListener(eVar);
    }
}
