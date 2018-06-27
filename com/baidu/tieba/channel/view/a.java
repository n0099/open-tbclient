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
    private BdListView LS;
    private NoNetworkView buT;
    private ChannelAddVideoActivity cBo;
    private TextView cCK;
    private View cCL;
    private com.baidu.tieba.channel.a.a cCM;
    private TextView cCN;
    private ViewStub cCO;
    private TextView cCP;
    private int cCQ;
    private View.OnClickListener cCR;
    private AdapterView.OnItemClickListener cCS;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cCQ;
        aVar.cCQ = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cCQ;
        aVar.cCQ = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cCQ = 0;
        this.cCR = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cCQ > 20 || a.this.cCQ <= 0) {
                    a.this.cBo.showToast(d.k.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cCM.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aji()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new an("c11937").f(VideoPlayActivityConfig.OBJ_ID, a.this.cBo.getChannelId()).r("obj_locate", 5));
                a.this.cBo.aK(arrayList);
            }
        };
        this.cCS = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cCM.getItem(i);
                if (item != null) {
                    item.eC(!item.aji());
                    a.this.cCM.notifyDataSetChanged();
                    if (item.aji()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cCQ > 0) {
                        a.this.cCN.setTextColor(a.this.cBo.getResources().getColor(d.C0142d.cp_link_tip_a));
                        a.this.cCN.setEnabled(true);
                        return;
                    }
                    a.this.cCN.setTextColor(a.this.cBo.getResources().getColor(d.C0142d.cp_cont_d));
                    a.this.cCN.setEnabled(false);
                }
            }
        };
        this.cBo = channelAddVideoActivity;
        this.cBo.setIsAddSwipeBackLayout(true);
        this.cBo.setSwipeBackEnabled(true);
        this.cBo.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cBo.setContentView(d.i.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cBo.findViewById(d.g.parent);
        this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.cCO = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cBo.getResources().getString(d.k.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.add_video), this.cCR);
        this.cCN.setTextColor(this.cBo.getResources().getColor(d.C0142d.cp_cont_d));
        this.cCN.setEnabled(false);
        this.LS = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.cCM = new com.baidu.tieba.channel.a.a(this.cBo);
        this.LS.setOnItemClickListener(this.cCS);
        this.LS.setAdapter((ListAdapter) this.cCM);
        this.cCL = LayoutInflater.from(this.cBo.getPageContext().getPageActivity()).inflate(d.i.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.LS.addHeaderView(this.cCL);
        this.mFooterView = LayoutInflater.from(this.cBo.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cCK = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.LS.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cCM != null) {
            this.cCM = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.buT.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cCM.setData(null);
            this.LS.setVisibility(8);
            this.cCO.setVisibility(0);
            this.cCP = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cCP.setText(this.cBo.getResources().getString(d.k.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eF(aVar.hasMore());
        this.cCM.setData(aVar.getItems());
        this.cCM.notifyDataSetChanged();
        this.LS.setVisibility(0);
    }

    public void eF(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cCK.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cCK.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cBo.getLayoutMode().setNightMode(i == 1);
        this.cBo.getLayoutMode().onModeChanged(this.mRootView);
        this.cBo.getLayoutMode().onModeChanged(this.mFooterView);
        this.cBo.getLayoutMode().onModeChanged(this.cCL);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.buT.onChangeSkinType(getPageContext(), i);
        if (this.cCM != null) {
            this.cCM.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.LS.setOnSrollToBottomListener(eVar);
    }
}
