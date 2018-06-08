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
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView LQ;
    private NoNetworkView btu;
    private ChannelAddVideoActivity cDu;
    private TextView cER;
    private View cES;
    private com.baidu.tieba.channel.a.a cET;
    private TextView cEU;
    private ViewStub cEV;
    private TextView cEW;
    private int cEX;
    private View.OnClickListener cEY;
    private AdapterView.OnItemClickListener cEZ;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cEX;
        aVar.cEX = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cEX;
        aVar.cEX = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cEX = 0;
        this.cEY = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cEX > 20 || a.this.cEX <= 0) {
                    a.this.cDu.showToast(d.k.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cET.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.ajO()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").f(VideoPlayActivityConfig.OBJ_ID, a.this.cDu.getChannelId()).r("obj_locate", 5));
                a.this.cDu.aJ(arrayList);
            }
        };
        this.cEZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cET.getItem(i);
                if (item != null) {
                    item.eC(!item.ajO());
                    a.this.cET.notifyDataSetChanged();
                    if (item.ajO()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cEX > 0) {
                        a.this.cEU.setTextColor(a.this.cDu.getResources().getColor(d.C0141d.cp_link_tip_a));
                        a.this.cEU.setEnabled(true);
                        return;
                    }
                    a.this.cEU.setTextColor(a.this.cDu.getResources().getColor(d.C0141d.cp_cont_d));
                    a.this.cEU.setEnabled(false);
                }
            }
        };
        this.cDu = channelAddVideoActivity;
        this.cDu.setIsAddSwipeBackLayout(true);
        this.cDu.setSwipeBackEnabled(true);
        this.cDu.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cDu.setContentView(d.i.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cDu.findViewById(d.g.parent);
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.cEV = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cDu.getResources().getString(d.k.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cEU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.add_video), this.cEY);
        this.cEU.setTextColor(this.cDu.getResources().getColor(d.C0141d.cp_cont_d));
        this.cEU.setEnabled(false);
        this.LQ = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.cET = new com.baidu.tieba.channel.a.a(this.cDu);
        this.LQ.setOnItemClickListener(this.cEZ);
        this.LQ.setAdapter((ListAdapter) this.cET);
        this.cES = LayoutInflater.from(this.cDu.getPageContext().getPageActivity()).inflate(d.i.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.LQ.addHeaderView(this.cES);
        this.mFooterView = LayoutInflater.from(this.cDu.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cER = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.LQ.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cET != null) {
            this.cET = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.btu.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cET.setData(null);
            this.LQ.setVisibility(8);
            this.cEV.setVisibility(0);
            this.cEW = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cEW.setText(this.cDu.getResources().getString(d.k.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eF(aVar.hasMore());
        this.cET.setData(aVar.getItems());
        this.cET.notifyDataSetChanged();
        this.LQ.setVisibility(0);
    }

    public void eF(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cER.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cER.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cDu.getLayoutMode().setNightMode(i == 1);
        this.cDu.getLayoutMode().onModeChanged(this.mRootView);
        this.cDu.getLayoutMode().onModeChanged(this.mFooterView);
        this.cDu.getLayoutMode().onModeChanged(this.cES);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.btu.onChangeSkinType(getPageContext(), i);
        if (this.cET != null) {
            this.cET.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LQ.setOnSrollToBottomListener(eVar);
    }
}
