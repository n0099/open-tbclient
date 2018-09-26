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
    private BdListView Op;
    private NoNetworkView bBq;
    private ChannelAddVideoActivity cJH;
    private TextView cLd;
    private View cLe;
    private View cLf;
    private com.baidu.tieba.channel.a.a cLg;
    private TextView cLh;
    private ViewStub cLi;
    private TextView cLj;
    private int cLk;
    private View.OnClickListener cLl;
    private AdapterView.OnItemClickListener cLm;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cLk;
        aVar.cLk = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cLk;
        aVar.cLk = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cLk = 0;
        this.cLl = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cLk > 20 || a.this.cLk <= 0) {
                    a.this.cJH.showToast(e.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cLg.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.alu()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").g(VideoPlayActivityConfig.OBJ_ID, a.this.cJH.getChannelId()).w("obj_locate", 5));
                a.this.cJH.aK(arrayList);
            }
        };
        this.cLm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cLg.getItem(i);
                if (item != null) {
                    item.eU(!item.alu());
                    a.this.cLg.notifyDataSetChanged();
                    if (item.alu()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cLk > 0) {
                        a.this.cLh.setTextColor(a.this.cJH.getResources().getColor(e.d.cp_link_tip_a));
                        a.this.cLh.setEnabled(true);
                        return;
                    }
                    a.this.cLh.setTextColor(a.this.cJH.getResources().getColor(e.d.cp_cont_d));
                    a.this.cLh.setEnabled(false);
                }
            }
        };
        this.cJH = channelAddVideoActivity;
        this.cJH.setIsAddSwipeBackLayout(true);
        this.cJH.setSwipeBackEnabled(true);
        this.cJH.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cJH.setContentView(e.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cJH.findViewById(e.g.parent);
        this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.cLi = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cJH.getResources().getString(e.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cLh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.add_video), this.cLl);
        this.cLh.setTextColor(this.cJH.getResources().getColor(e.d.cp_cont_d));
        this.cLh.setEnabled(false);
        this.Op = (BdListView) this.mRootView.findViewById(e.g.listview);
        this.cLg = new com.baidu.tieba.channel.a.a(this.cJH);
        this.Op.setOnItemClickListener(this.cLm);
        this.Op.setAdapter((ListAdapter) this.cLg);
        this.cLe = LayoutInflater.from(this.cJH.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.Op.addHeaderView(this.cLe);
        this.cLf = LayoutInflater.from(this.cJH.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cLf.findViewById(e.g.list_more_progress);
        this.cLd = (TextView) this.cLf.findViewById(e.g.list_more_title);
        this.Op.addFooterView(this.cLf);
    }

    public void onDestroy() {
        if (this.cLg != null) {
            this.cLg = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bBq.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cLg.setData(null);
            this.Op.setVisibility(8);
            this.cLi.setVisibility(0);
            this.cLj = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cLj.setText(this.cJH.getResources().getString(e.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eX(aVar.hasMore());
        this.cLg.setData(aVar.getItems());
        this.cLg.notifyDataSetChanged();
        this.Op.setVisibility(0);
    }

    public void eX(boolean z) {
        this.cLf.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cLd.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cLd.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cJH.getLayoutMode().setNightMode(i == 1);
        this.cJH.getLayoutMode().onModeChanged(this.mRootView);
        this.cJH.getLayoutMode().onModeChanged(this.cLf);
        this.cJH.getLayoutMode().onModeChanged(this.cLe);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bBq.onChangeSkinType(getPageContext(), i);
        if (this.cLg != null) {
            this.cLg.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.Op.setOnSrollToBottomListener(eVar);
    }
}
