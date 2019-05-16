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
    private NoNetworkView dlW;
    private ChannelAddVideoActivity eCN;
    private TextView eEh;
    private View eEi;
    private com.baidu.tieba.channel.a.a eEj;
    private TextView eEk;
    private ViewStub eEl;
    private TextView eEm;
    private int eEn;
    private View.OnClickListener eEo;
    private AdapterView.OnItemClickListener eEp;
    private View epY;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eEn;
        aVar.eEn = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eEn;
        aVar.eEn = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eEn = 0;
        this.eEo = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eEn > 20 || a.this.eEn <= 0) {
                    a.this.eCN.showToast(R.string.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eEj.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.aYw()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new am("c11937").l(VideoPlayActivityConfig.OBJ_ID, a.this.eCN.getChannelId()).P("obj_locate", 5));
                a.this.eCN.bw(arrayList);
            }
        };
        this.eEp = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eEj.getItem(i);
                if (item != null) {
                    item.iA(!item.aYw());
                    a.this.eEj.notifyDataSetChanged();
                    if (item.aYw()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eEn > 0) {
                        a.this.eEk.setTextColor(a.this.eCN.getResources().getColor(R.color.cp_link_tip_a));
                        a.this.eEk.setEnabled(true);
                        return;
                    }
                    a.this.eEk.setTextColor(a.this.eCN.getResources().getColor(R.color.cp_cont_d));
                    a.this.eEk.setEnabled(false);
                }
            }
        };
        this.eCN = channelAddVideoActivity;
        this.eCN.setIsAddSwipeBackLayout(true);
        this.eCN.setSwipeBackEnabled(true);
        this.eCN.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eCN.setContentView(R.layout.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.eCN.findViewById(R.id.parent);
        this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eEl = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eCN.getResources().getString(R.string.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add_video), this.eEo);
        this.eEk.setTextColor(this.eCN.getResources().getColor(R.color.cp_cont_d));
        this.eEk.setEnabled(false);
        this.MS = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.eEj = new com.baidu.tieba.channel.a.a(this.eCN);
        this.MS.setOnItemClickListener(this.eEp);
        this.MS.setAdapter((ListAdapter) this.eEj);
        this.eEi = LayoutInflater.from(this.eCN.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.MS.addHeaderView(this.eEi);
        this.epY = LayoutInflater.from(this.eCN.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.epY.findViewById(R.id.list_more_progress);
        this.eEh = (TextView) this.epY.findViewById(R.id.list_more_title);
        this.MS.addFooterView(this.epY);
    }

    public void onDestroy() {
        if (this.eEj != null) {
            this.eEj = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dlW.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eEj.setData(null);
            this.MS.setVisibility(8);
            this.eEl.setVisibility(0);
            this.eEm = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eEm.setText(this.eCN.getResources().getString(R.string.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iD(aVar.hasMore());
        this.eEj.setData(aVar.getItems());
        this.eEj.notifyDataSetChanged();
        this.MS.setVisibility(0);
    }

    public void iD(boolean z) {
        this.epY.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eEh.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eEh.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.eCN.getLayoutMode().setNightMode(i == 1);
        this.eCN.getLayoutMode().onModeChanged(this.mRootView);
        this.eCN.getLayoutMode().onModeChanged(this.epY);
        this.eCN.getLayoutMode().onModeChanged(this.eEi);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlW.onChangeSkinType(getPageContext(), i);
        if (this.eEj != null) {
            this.eEj.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.MS.setOnSrollToBottomListener(eVar);
    }
}
