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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView FH;
    private NoNetworkView blp;
    private ChannelAddVideoActivity cuR;
    private TextView cwo;
    private View cwp;
    private com.baidu.tieba.channel.a.a cwq;
    private TextView cwr;
    private ViewStub cws;
    private TextView cwt;
    private int cwu;
    private View.OnClickListener cwv;
    private AdapterView.OnItemClickListener cww;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cwu;
        aVar.cwu = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cwu;
        aVar.cwu = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cwu = 0;
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cwu > 20 || a.this.cwu <= 0) {
                    a.this.cuR.showToast(d.k.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cwq.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.agg()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new al("c11937").f(VideoPlayActivityConfig.OBJ_ID, a.this.cuR.getChannelId()).r("obj_locate", 5));
                a.this.cuR.aG(arrayList);
            }
        };
        this.cww = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cwq.getItem(i);
                if (item != null) {
                    item.ey(!item.agg());
                    a.this.cwq.notifyDataSetChanged();
                    if (item.agg()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cwu > 0) {
                        a.this.cwr.setTextColor(a.this.cuR.getResources().getColor(d.C0126d.cp_link_tip_a));
                        a.this.cwr.setEnabled(true);
                        return;
                    }
                    a.this.cwr.setTextColor(a.this.cuR.getResources().getColor(d.C0126d.cp_cont_d));
                    a.this.cwr.setEnabled(false);
                }
            }
        };
        this.cuR = channelAddVideoActivity;
        this.cuR.setIsAddSwipeBackLayout(true);
        this.cuR.setSwipeBackEnabled(true);
        this.cuR.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.cuR.setContentView(d.i.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.cuR.findViewById(d.g.parent);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.cws = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.cuR.getResources().getString(d.k.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cwr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.add_video), this.cwv);
        this.cwr.setTextColor(this.cuR.getResources().getColor(d.C0126d.cp_cont_d));
        this.cwr.setEnabled(false);
        this.FH = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.cwq = new com.baidu.tieba.channel.a.a(this.cuR);
        this.FH.setOnItemClickListener(this.cww);
        this.FH.setAdapter((ListAdapter) this.cwq);
        this.cwp = LayoutInflater.from(this.cuR.getPageContext().getPageActivity()).inflate(d.i.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.FH.addHeaderView(this.cwp);
        this.mFooterView = LayoutInflater.from(this.cuR.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cwo = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.FH.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cwq != null) {
            this.cwq = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.blp.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cwq.setData(null);
            this.FH.setVisibility(8);
            this.cws.setVisibility(0);
            this.cwt = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cwt.setText(this.cuR.getResources().getString(d.k.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eB(aVar.hasMore());
        this.cwq.setData(aVar.getItems());
        this.cwq.notifyDataSetChanged();
        this.FH.setVisibility(0);
    }

    public void eB(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cwo.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cwo.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.cuR.getLayoutMode().setNightMode(i == 1);
        this.cuR.getLayoutMode().u(this.mRootView);
        this.cuR.getLayoutMode().u(this.mFooterView);
        this.cuR.getLayoutMode().u(this.cwp);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.blp.onChangeSkinType(getPageContext(), i);
        if (this.cwq != null) {
            this.cwq.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.FH.setOnSrollToBottomListener(eVar);
    }
}
