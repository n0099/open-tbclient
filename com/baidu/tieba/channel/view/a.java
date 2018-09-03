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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView LO;
    private NoNetworkView bvB;
    private ChannelAddVideoActivity cDQ;
    private TextView cFm;
    private View cFn;
    private View cFo;
    private com.baidu.tieba.channel.a.a cFp;
    private TextView cFq;
    private ViewStub cFr;
    private TextView cFs;
    private int cFt;
    private View.OnClickListener cFu;
    private AdapterView.OnItemClickListener cFv;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cFt;
        aVar.cFt = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cFt;
        aVar.cFt = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cFt = 0;
        this.cFu = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cFt > 20 || a.this.cFt <= 0) {
                    a.this.cDQ.showToast(f.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cFp.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.ajJ()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new an("c11937").f(VideoPlayActivityConfig.OBJ_ID, a.this.cDQ.getChannelId()).r("obj_locate", 5));
                a.this.cDQ.aJ(arrayList);
            }
        };
        this.cFv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cFp.getItem(i);
                if (item != null) {
                    item.eD(!item.ajJ());
                    a.this.cFp.notifyDataSetChanged();
                    if (item.ajJ()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cFt > 0) {
                        a.this.cFq.setTextColor(a.this.cDQ.getResources().getColor(f.d.cp_link_tip_a));
                        a.this.cFq.setEnabled(true);
                        return;
                    }
                    a.this.cFq.setTextColor(a.this.cDQ.getResources().getColor(f.d.cp_cont_d));
                    a.this.cFq.setEnabled(false);
                }
            }
        };
        this.cDQ = channelAddVideoActivity;
        this.cDQ.setIsAddSwipeBackLayout(true);
        this.cDQ.setSwipeBackEnabled(true);
        this.cDQ.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cDQ.setContentView(f.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cDQ.findViewById(f.g.parent);
        this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.navigation_bar);
        this.cFr = (ViewStub) this.mRootView.findViewById(f.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cDQ.getResources().getString(f.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cFq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(f.j.add_video), this.cFu);
        this.cFq.setTextColor(this.cDQ.getResources().getColor(f.d.cp_cont_d));
        this.cFq.setEnabled(false);
        this.LO = (BdListView) this.mRootView.findViewById(f.g.listview);
        this.cFp = new com.baidu.tieba.channel.a.a(this.cDQ);
        this.LO.setOnItemClickListener(this.cFv);
        this.LO.setAdapter((ListAdapter) this.cFp);
        this.cFn = LayoutInflater.from(this.cDQ.getPageContext().getPageActivity()).inflate(f.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.LO.addHeaderView(this.cFn);
        this.cFo = LayoutInflater.from(this.cDQ.getPageContext().getPageActivity()).inflate(f.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cFo.findViewById(f.g.list_more_progress);
        this.cFm = (TextView) this.cFo.findViewById(f.g.list_more_title);
        this.LO.addFooterView(this.cFo);
    }

    public void onDestroy() {
        if (this.cFp != null) {
            this.cFp = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bvB.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cFp.setData(null);
            this.LO.setVisibility(8);
            this.cFr.setVisibility(0);
            this.cFs = (TextView) this.mRootView.findViewById(f.g.no_data_tip);
            this.cFs.setText(this.cDQ.getResources().getString(f.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eG(aVar.hasMore());
        this.cFp.setData(aVar.getItems());
        this.cFp.notifyDataSetChanged();
        this.LO.setVisibility(0);
    }

    public void eG(boolean z) {
        this.cFo.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cFm.setText(getPageContext().getString(f.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cFm.setText(getPageContext().getString(f.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cDQ.getLayoutMode().setNightMode(i == 1);
        this.cDQ.getLayoutMode().onModeChanged(this.mRootView);
        this.cDQ.getLayoutMode().onModeChanged(this.cFo);
        this.cDQ.getLayoutMode().onModeChanged(this.cFn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvB.onChangeSkinType(getPageContext(), i);
        if (this.cFp != null) {
            this.cFp.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LO.setOnSrollToBottomListener(eVar);
    }
}
