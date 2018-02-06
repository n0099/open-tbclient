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
    private BdListView avh;
    private NoNetworkView cbj;
    private ChannelAddVideoActivity dca;
    private View ddA;
    private View ddB;
    private com.baidu.tieba.channel.a.a ddC;
    private TextView ddD;
    private ViewStub ddE;
    private TextView ddF;
    private int ddG;
    private View.OnClickListener ddH;
    private AdapterView.OnItemClickListener ddI;
    private TextView ddz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.ddG;
        aVar.ddG = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.ddG;
        aVar.ddG = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.ddG = 0;
        this.ddH = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ddG > 20 || a.this.ddG <= 0) {
                    a.this.dca.showToast(d.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.ddC.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.amg()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new ak("c11937").f("obj_id", a.this.dca.getChannelId()).s("obj_locate", 5));
                a.this.dca.aI(arrayList);
            }
        };
        this.ddI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.ddC.getItem(i);
                if (item != null) {
                    item.eS(!item.amg());
                    a.this.ddC.notifyDataSetChanged();
                    if (item.amg()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.ddG > 0) {
                        a.this.ddD.setTextColor(a.this.dca.getResources().getColor(d.C0140d.cp_link_tip_a));
                        a.this.ddD.setEnabled(true);
                        return;
                    }
                    a.this.ddD.setTextColor(a.this.dca.getResources().getColor(d.C0140d.cp_cont_d));
                    a.this.ddD.setEnabled(false);
                }
            }
        };
        this.dca = channelAddVideoActivity;
        this.dca.setIsAddSwipeBackLayout(true);
        this.dca.setSwipeBackEnabled(true);
        this.dca.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.dca.setContentView(d.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.dca.findViewById(d.g.parent);
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.ddE = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.dca.getResources().getString(d.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.add_video), this.ddH);
        this.ddD.setTextColor(this.dca.getResources().getColor(d.C0140d.cp_cont_d));
        this.ddD.setEnabled(false);
        this.avh = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.ddC = new com.baidu.tieba.channel.a.a(this.dca);
        this.avh.setOnItemClickListener(this.ddI);
        this.avh.setAdapter((ListAdapter) this.ddC);
        this.ddA = LayoutInflater.from(this.dca.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.avh.addHeaderView(this.ddA);
        this.ddB = LayoutInflater.from(this.dca.getPageContext().getPageActivity()).inflate(d.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ddB.findViewById(d.g.list_more_progress);
        this.ddz = (TextView) this.ddB.findViewById(d.g.list_more_title);
        this.avh.addFooterView(this.ddB);
    }

    public void onDestroy() {
        if (this.ddC != null) {
            this.ddC = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.cbj.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.ddC.setData(null);
            this.avh.setVisibility(8);
            this.ddE.setVisibility(0);
            this.ddF = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.ddF.setText(this.dca.getResources().getString(d.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eV(aVar.hasMore());
        this.ddC.setData(aVar.getItems());
        this.ddC.notifyDataSetChanged();
        this.avh.setVisibility(0);
    }

    public void eV(boolean z) {
        this.ddB.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.ddz.setText(getPageContext().getString(d.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.ddz.setText(getPageContext().getString(d.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.dca.getLayoutMode().aQ(i == 1);
        this.dca.getLayoutMode().aM(this.mRootView);
        this.dca.getLayoutMode().aM(this.ddB);
        this.dca.getLayoutMode().aM(this.ddA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cbj.onChangeSkinType(getPageContext(), i);
        if (this.ddC != null) {
            this.ddC.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.avh.setOnSrollToBottomListener(eVar);
    }
}
