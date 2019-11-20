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
    private View aqJ;
    private NoNetworkView dvR;
    private ChannelAddVideoActivity eRo;
    private TextView eSJ;
    private View eSK;
    private com.baidu.tieba.channel.a.a eSL;
    private TextView eSM;
    private ViewStub eSN;
    private TextView eSO;
    private int eSP;
    private View.OnClickListener eSQ;
    private AdapterView.OnItemClickListener eSR;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;
    private BdListView xL;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eSP;
        aVar.eSP = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eSP;
        aVar.eSP = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eSP = 0;
        this.eSQ = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eSP > 20 || a.this.eSP <= 0) {
                    a.this.eRo.showToast(R.string.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eSL.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.bbg()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new an("c11937").p("obj_id", a.this.eRo.getChannelId()).O("obj_locate", 5));
                a.this.eRo.bL(arrayList);
            }
        };
        this.eSR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eSL.getItem(i);
                if (item != null) {
                    item.iP(!item.bbg());
                    a.this.eSL.notifyDataSetChanged();
                    if (item.bbg()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eSP > 0) {
                        a.this.eSM.setTextColor(a.this.eRo.getResources().getColor(R.color.cp_link_tip_a));
                        a.this.eSM.setEnabled(true);
                        return;
                    }
                    a.this.eSM.setTextColor(a.this.eRo.getResources().getColor(R.color.cp_cont_d));
                    a.this.eSM.setEnabled(false);
                }
            }
        };
        this.eRo = channelAddVideoActivity;
        this.eRo.setIsAddSwipeBackLayout(true);
        this.eRo.setSwipeBackEnabled(true);
        this.eRo.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eRo.setContentView(R.layout.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.eRo.findViewById(R.id.parent);
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eSN = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eRo.getResources().getString(R.string.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add_video), this.eSQ);
        this.eSM.setTextColor(this.eRo.getResources().getColor(R.color.cp_cont_d));
        this.eSM.setEnabled(false);
        this.xL = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.eSL = new com.baidu.tieba.channel.a.a(this.eRo);
        this.xL.setOnItemClickListener(this.eSR);
        this.xL.setAdapter((ListAdapter) this.eSL);
        this.eSK = LayoutInflater.from(this.eRo.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.xL.addHeaderView(this.eSK);
        this.aqJ = LayoutInflater.from(this.eRo.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.aqJ.findViewById(R.id.list_more_progress);
        this.eSJ = (TextView) this.aqJ.findViewById(R.id.list_more_title);
        this.xL.addFooterView(this.aqJ);
    }

    public void onDestroy() {
        if (this.eSL != null) {
            this.eSL = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dvR.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eSL.setData(null);
            this.xL.setVisibility(8);
            this.eSN.setVisibility(0);
            this.eSO = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eSO.setText(this.eRo.getResources().getString(R.string.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iS(aVar.hasMore());
        this.eSL.setData(aVar.getItems());
        this.eSL.notifyDataSetChanged();
        this.xL.setVisibility(0);
    }

    public void iS(boolean z) {
        this.aqJ.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eSJ.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eSJ.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.eRo.getLayoutMode().setNightMode(i == 1);
        this.eRo.getLayoutMode().onModeChanged(this.mRootView);
        this.eRo.getLayoutMode().onModeChanged(this.aqJ);
        this.eRo.getLayoutMode().onModeChanged(this.eSK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dvR.onChangeSkinType(getPageContext(), i);
        if (this.eSL != null) {
            this.eSL.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.xL.setOnSrollToBottomListener(eVar);
    }
}
