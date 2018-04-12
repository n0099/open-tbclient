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
    private BdListView FL;
    private NoNetworkView bla;
    private ChannelAddVideoActivity ctK;
    private TextView cvi;
    private View cvj;
    private com.baidu.tieba.channel.a.a cvk;
    private TextView cvl;
    private ViewStub cvm;
    private TextView cvn;
    private int cvo;
    private View.OnClickListener cvp;
    private AdapterView.OnItemClickListener cvq;
    private View mFooterView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.cvo;
        aVar.cvo = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.cvo;
        aVar.cvo = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.cvo = 0;
        this.cvp = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cvo > 20 || a.this.cvo <= 0) {
                    a.this.ctK.showToast(d.k.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.cvk.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.agg()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new al("c11937").f(VideoPlayActivityConfig.OBJ_ID, a.this.ctK.getChannelId()).r("obj_locate", 5));
                a.this.ctK.aD(arrayList);
            }
        };
        this.cvq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.cvk.getItem(i);
                if (item != null) {
                    item.ex(!item.agg());
                    a.this.cvk.notifyDataSetChanged();
                    if (item.agg()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.cvo > 0) {
                        a.this.cvl.setTextColor(a.this.ctK.getResources().getColor(d.C0126d.cp_link_tip_a));
                        a.this.cvl.setEnabled(true);
                        return;
                    }
                    a.this.cvl.setTextColor(a.this.ctK.getResources().getColor(d.C0126d.cp_cont_d));
                    a.this.cvl.setEnabled(false);
                }
            }
        };
        this.ctK = channelAddVideoActivity;
        this.ctK.setIsAddSwipeBackLayout(true);
        this.ctK.setSwipeBackEnabled(true);
        this.ctK.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.ctK.setContentView(d.i.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.ctK.findViewById(d.g.parent);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.cvm = (ViewStub) this.mRootView.findViewById(d.g.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.ctK.getResources().getString(d.k.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cvl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.add_video), this.cvp);
        this.cvl.setTextColor(this.ctK.getResources().getColor(d.C0126d.cp_cont_d));
        this.cvl.setEnabled(false);
        this.FL = (BdListView) this.mRootView.findViewById(d.g.listview);
        this.cvk = new com.baidu.tieba.channel.a.a(this.ctK);
        this.FL.setOnItemClickListener(this.cvq);
        this.FL.setAdapter((ListAdapter) this.cvk);
        this.cvj = LayoutInflater.from(this.ctK.getPageContext().getPageActivity()).inflate(d.i.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.FL.addHeaderView(this.cvj);
        this.mFooterView = LayoutInflater.from(this.ctK.getPageContext().getPageActivity()).inflate(d.i.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.mFooterView.findViewById(d.g.list_more_progress);
        this.cvi = (TextView) this.mFooterView.findViewById(d.g.list_more_title);
        this.FL.addFooterView(this.mFooterView);
    }

    public void onDestroy() {
        if (this.cvk != null) {
            this.cvk = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.bla.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.cvk.setData(null);
            this.FL.setVisibility(8);
            this.cvm.setVisibility(0);
            this.cvn = (TextView) this.mRootView.findViewById(d.g.no_data_tip);
            this.cvn.setText(this.ctK.getResources().getString(d.k.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        eA(aVar.hasMore());
        this.cvk.setData(aVar.getItems());
        this.cvk.notifyDataSetChanged();
        this.FL.setVisibility(0);
    }

    public void eA(boolean z) {
        this.mFooterView.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.cvi.setText(getPageContext().getString(d.k.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.cvi.setText(getPageContext().getString(d.k.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.ctK.getLayoutMode().setNightMode(i == 1);
        this.ctK.getLayoutMode().u(this.mRootView);
        this.ctK.getLayoutMode().u(this.mFooterView);
        this.ctK.getLayoutMode().u(this.cvj);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bla.onChangeSkinType(getPageContext(), i);
        if (this.cvk != null) {
            this.cvk.notifyDataSetChanged();
        }
    }

    public void a(BdListView.e eVar) {
        this.FL.setOnSrollToBottomListener(eVar);
    }
}
