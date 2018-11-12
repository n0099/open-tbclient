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
    private NoNetworkView bKI;
    private ChannelAddVideoActivity cTg;
    private TextView cUC;
    private View cUD;
    private View cUE;
    private com.baidu.tieba.channel.a.a cUF;
    private TextView cUG;
    private ViewStub cUH;
    private TextView cUI;
    private int cUJ;
    private View.OnClickListener cUK;
    private AdapterView.OnItemClickListener cUL;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cUJ;
        aVar.cUJ = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cUJ;
        aVar.cUJ = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cUJ = 0;
        this.cUK = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cUJ > 20 || a.this.cUJ <= 0) {
                    a.this.cTg.showToast(e.j.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cUF.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aoy()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").h(VideoPlayActivityConfig.OBJ_ID, a.this.cTg.getChannelId()).x("obj_locate", 5));
                a.this.cTg.aY(arrayList);
            }
        };
        this.cUL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cUF.getItem(i);
                if (item != null) {
                    item.fx(!item.aoy());
                    a.this.cUF.notifyDataSetChanged();
                    if (item.aoy()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cUJ > 0) {
                        a.this.cUG.setTextColor(a.this.cTg.getResources().getColor(e.d.cp_link_tip_a));
                        a.this.cUG.setEnabled(true);
                        return;
                    }
                    a.this.cUG.setTextColor(a.this.cTg.getResources().getColor(e.d.cp_cont_d));
                    a.this.cUG.setEnabled(false);
                }
            }
        };
        this.cTg = channelAddVideoActivity;
        this.cTg.setIsAddSwipeBackLayout(true);
        this.cTg.setSwipeBackEnabled(true);
        this.cTg.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cTg.setContentView(e.h.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cTg.findViewById(e.g.parent);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.cUH = (ViewStub) this.mRootView.findViewById(e.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cTg.getResources().getString(e.j.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cUG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.add_video), this.cUK);
        this.cUG.setTextColor(this.cTg.getResources().getColor(e.d.cp_cont_d));
        this.cUG.setEnabled(false);
        this.OF = (BdListView) this.mRootView.findViewById(e.g.listview);
        this.cUF = new com.baidu.tieba.channel.a.a(this.cTg);
        this.OF.setOnItemClickListener(this.cUL);
        this.OF.setAdapter((ListAdapter) this.cUF);
        this.cUD = LayoutInflater.from(this.cTg.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.OF.addHeaderView(this.cUD);
        this.cUE = LayoutInflater.from(this.cTg.getPageContext().getPageActivity()).inflate(e.h.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.cUE.findViewById(e.g.list_more_progress);
        this.cUC = (TextView) this.cUE.findViewById(e.g.list_more_title);
        this.OF.addFooterView(this.cUE);
    }

    public void onDestroy() {
        if (this.cUF != null) {
            this.cUF = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bKI.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cUF.setData(null);
            this.OF.setVisibility(8);
            this.cUH.setVisibility(0);
            this.cUI = (TextView) this.mRootView.findViewById(e.g.no_data_tip);
            this.cUI.setText(this.cTg.getResources().getString(e.j.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        fA(aVar.hasMore());
        this.cUF.setData(aVar.getItems());
        this.cUF.notifyDataSetChanged();
        this.OF.setVisibility(0);
    }

    public void fA(boolean z) {
        this.cUE.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cUC.setText(getPageContext().getString(e.j.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cUC.setText(getPageContext().getString(e.j.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cTg.getLayoutMode().setNightMode(i == 1);
        this.cTg.getLayoutMode().onModeChanged(this.mRootView);
        this.cTg.getLayoutMode().onModeChanged(this.cUE);
        this.cTg.getLayoutMode().onModeChanged(this.cUD);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bKI.onChangeSkinType(getPageContext(), i);
        if (this.cUF != null) {
            this.cUF.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.OF.setOnSrollToBottomListener(eVar);
    }
}
