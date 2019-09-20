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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView Nj;
    private NoNetworkView dpy;
    private ChannelAddVideoActivity eJA;
    private TextView eKU;
    private View eKV;
    private com.baidu.tieba.channel.a.a eKW;
    private TextView eKX;
    private ViewStub eKY;
    private TextView eKZ;
    private int eLa;
    private View.OnClickListener eLb;
    private AdapterView.OnItemClickListener eLc;
    private View ewO;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eLa;
        aVar.eLa = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eLa;
        aVar.eLa = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eLa = 0;
        this.eLb = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eLa > 20 || a.this.eLa <= 0) {
                    a.this.eJA.showToast(R.string.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eKW.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.bbe()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new an("c11937").n(VideoPlayActivityConfig.OBJ_ID, a.this.eJA.getChannelId()).P("obj_locate", 5));
                a.this.eJA.by(arrayList);
            }
        };
        this.eLc = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eKW.getItem(i);
                if (item != null) {
                    item.iM(!item.bbe());
                    a.this.eKW.notifyDataSetChanged();
                    if (item.bbe()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eLa > 0) {
                        a.this.eKX.setTextColor(a.this.eJA.getResources().getColor(R.color.cp_link_tip_a));
                        a.this.eKX.setEnabled(true);
                        return;
                    }
                    a.this.eKX.setTextColor(a.this.eJA.getResources().getColor(R.color.cp_cont_d));
                    a.this.eKX.setEnabled(false);
                }
            }
        };
        this.eJA = channelAddVideoActivity;
        this.eJA.setIsAddSwipeBackLayout(true);
        this.eJA.setSwipeBackEnabled(true);
        this.eJA.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eJA.setContentView(R.layout.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.eJA.findViewById(R.id.parent);
        this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eKY = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eJA.getResources().getString(R.string.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add_video), this.eLb);
        this.eKX.setTextColor(this.eJA.getResources().getColor(R.color.cp_cont_d));
        this.eKX.setEnabled(false);
        this.Nj = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.eKW = new com.baidu.tieba.channel.a.a(this.eJA);
        this.Nj.setOnItemClickListener(this.eLc);
        this.Nj.setAdapter((ListAdapter) this.eKW);
        this.eKV = LayoutInflater.from(this.eJA.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.Nj.addHeaderView(this.eKV);
        this.ewO = LayoutInflater.from(this.eJA.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.ewO.findViewById(R.id.list_more_progress);
        this.eKU = (TextView) this.ewO.findViewById(R.id.list_more_title);
        this.Nj.addFooterView(this.ewO);
    }

    public void onDestroy() {
        if (this.eKW != null) {
            this.eKW = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dpy.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eKW.setData(null);
            this.Nj.setVisibility(8);
            this.eKY.setVisibility(0);
            this.eKZ = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eKZ.setText(this.eJA.getResources().getString(R.string.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iP(aVar.hasMore());
        this.eKW.setData(aVar.getItems());
        this.eKW.notifyDataSetChanged();
        this.Nj.setVisibility(0);
    }

    public void iP(boolean z) {
        this.ewO.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eKU.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eKU.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.eJA.getLayoutMode().setNightMode(i == 1);
        this.eJA.getLayoutMode().onModeChanged(this.mRootView);
        this.eJA.getLayoutMode().onModeChanged(this.ewO);
        this.eJA.getLayoutMode().onModeChanged(this.eKV);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dpy.onChangeSkinType(getPageContext(), i);
        if (this.eKW != null) {
            this.eKW.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Nj.setOnSrollToBottomListener(eVar);
    }
}
