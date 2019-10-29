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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private View arb;
    private NoNetworkView dwI;
    private ChannelAddVideoActivity eSf;
    private TextView eTA;
    private View eTB;
    private com.baidu.tieba.channel.a.a eTC;
    private TextView eTD;
    private ViewStub eTE;
    private TextView eTF;
    private int eTG;
    private View.OnClickListener eTH;
    private AdapterView.OnItemClickListener eTI;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;
    private BdListView yl;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eTG;
        aVar.eTG = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eTG;
        aVar.eTG = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eTG = 0;
        this.eTH = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eTG > 20 || a.this.eTG <= 0) {
                    a.this.eSf.showToast(R.string.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eTC.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.bbi()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new an("c11937").p("obj_id", a.this.eSf.getChannelId()).O("obj_locate", 5));
                a.this.eSf.bL(arrayList);
            }
        };
        this.eTI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eTC.getItem(i);
                if (item != null) {
                    item.iP(!item.bbi());
                    a.this.eTC.notifyDataSetChanged();
                    if (item.bbi()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eTG > 0) {
                        a.this.eTD.setTextColor(a.this.eSf.getResources().getColor(R.color.cp_link_tip_a));
                        a.this.eTD.setEnabled(true);
                        return;
                    }
                    a.this.eTD.setTextColor(a.this.eSf.getResources().getColor(R.color.cp_cont_d));
                    a.this.eTD.setEnabled(false);
                }
            }
        };
        this.eSf = channelAddVideoActivity;
        this.eSf.setIsAddSwipeBackLayout(true);
        this.eSf.setSwipeBackEnabled(true);
        this.eSf.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eSf.setContentView(R.layout.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.eSf.findViewById(R.id.parent);
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eTE = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eSf.getResources().getString(R.string.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eTD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add_video), this.eTH);
        this.eTD.setTextColor(this.eSf.getResources().getColor(R.color.cp_cont_d));
        this.eTD.setEnabled(false);
        this.yl = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.eTC = new com.baidu.tieba.channel.a.a(this.eSf);
        this.yl.setOnItemClickListener(this.eTI);
        this.yl.setAdapter((ListAdapter) this.eTC);
        this.eTB = LayoutInflater.from(this.eSf.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.yl.addHeaderView(this.eTB);
        this.arb = LayoutInflater.from(this.eSf.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.arb.findViewById(R.id.list_more_progress);
        this.eTA = (TextView) this.arb.findViewById(R.id.list_more_title);
        this.yl.addFooterView(this.arb);
    }

    public void onDestroy() {
        if (this.eTC != null) {
            this.eTC = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dwI.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eTC.setData(null);
            this.yl.setVisibility(8);
            this.eTE.setVisibility(0);
            this.eTF = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eTF.setText(this.eSf.getResources().getString(R.string.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iS(aVar.hasMore());
        this.eTC.setData(aVar.getItems());
        this.eTC.notifyDataSetChanged();
        this.yl.setVisibility(0);
    }

    public void iS(boolean z) {
        this.arb.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eTA.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eTA.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.eSf.getLayoutMode().setNightMode(i == 1);
        this.eSf.getLayoutMode().onModeChanged(this.mRootView);
        this.eSf.getLayoutMode().onModeChanged(this.arb);
        this.eSf.getLayoutMode().onModeChanged(this.eTB);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dwI.onChangeSkinType(getPageContext(), i);
        if (this.eTC != null) {
            this.eTC.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.yl.setOnSrollToBottomListener(eVar);
    }
}
