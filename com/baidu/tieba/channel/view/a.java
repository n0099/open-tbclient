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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.base.c<ChannelAddVideoActivity> {
    private BdListView MS;
    private NoNetworkView dlX;
    private ChannelAddVideoActivity eCO;
    private TextView eEi;
    private View eEj;
    private com.baidu.tieba.channel.a.a eEk;
    private TextView eEl;
    private ViewStub eEm;
    private TextView eEn;
    private int eEo;
    private View.OnClickListener eEp;
    private AdapterView.OnItemClickListener eEq;
    private View epZ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eEo;
        aVar.eEo = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eEo;
        aVar.eEo = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eEo = 0;
        this.eEp = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eEo > 20 || a.this.eEo <= 0) {
                    a.this.eCO.showToast(R.string.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eEk.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aYz()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").l(VideoPlayActivityConfig.OBJ_ID, a.this.eCO.getChannelId()).P("obj_locate", 5));
                a.this.eCO.bw(arrayList);
            }
        };
        this.eEq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eEk.getItem(i);
                if (item != null) {
                    item.iA(!item.aYz());
                    a.this.eEk.notifyDataSetChanged();
                    if (item.aYz()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eEo > 0) {
                        a.this.eEl.setTextColor(a.this.eCO.getResources().getColor(R.color.cp_link_tip_a));
                        a.this.eEl.setEnabled(true);
                        return;
                    }
                    a.this.eEl.setTextColor(a.this.eCO.getResources().getColor(R.color.cp_cont_d));
                    a.this.eEl.setEnabled(false);
                }
            }
        };
        this.eCO = channelAddVideoActivity;
        this.eCO.setIsAddSwipeBackLayout(true);
        this.eCO.setSwipeBackEnabled(true);
        this.eCO.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eCO.setContentView(R.layout.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.eCO.findViewById(R.id.parent);
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eEm = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eCO.getResources().getString(R.string.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add_video), this.eEp);
        this.eEl.setTextColor(this.eCO.getResources().getColor(R.color.cp_cont_d));
        this.eEl.setEnabled(false);
        this.MS = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.eEk = new com.baidu.tieba.channel.a.a(this.eCO);
        this.MS.setOnItemClickListener(this.eEq);
        this.MS.setAdapter((ListAdapter) this.eEk);
        this.eEj = LayoutInflater.from(this.eCO.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.MS.addHeaderView(this.eEj);
        this.epZ = LayoutInflater.from(this.eCO.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.epZ.findViewById(R.id.list_more_progress);
        this.eEi = (TextView) this.epZ.findViewById(R.id.list_more_title);
        this.MS.addFooterView(this.epZ);
    }

    public void onDestroy() {
        if (this.eEk != null) {
            this.eEk = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dlX.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eEk.setData(null);
            this.MS.setVisibility(8);
            this.eEm.setVisibility(0);
            this.eEn = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eEn.setText(this.eCO.getResources().getString(R.string.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iD(aVar.hasMore());
        this.eEk.setData(aVar.getItems());
        this.eEk.notifyDataSetChanged();
        this.MS.setVisibility(0);
    }

    public void iD(boolean z) {
        this.epZ.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eEi.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eEi.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.eCO.getLayoutMode().setNightMode(i == 1);
        this.eCO.getLayoutMode().onModeChanged(this.mRootView);
        this.eCO.getLayoutMode().onModeChanged(this.epZ);
        this.eCO.getLayoutMode().onModeChanged(this.eEj);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlX.onChangeSkinType(getPageContext(), i);
        if (this.eEk != null) {
            this.eEk.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.MS.setOnSrollToBottomListener(eVar);
    }
}
