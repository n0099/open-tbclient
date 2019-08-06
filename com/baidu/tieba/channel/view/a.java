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
    private BdListView Ni;
    private NoNetworkView dnM;
    private ChannelAddVideoActivity eHR;
    private TextView eJl;
    private View eJm;
    private com.baidu.tieba.channel.a.a eJn;
    private TextView eJo;
    private ViewStub eJp;
    private TextView eJq;
    private int eJr;
    private View.OnClickListener eJs;
    private AdapterView.OnItemClickListener eJt;
    private View eve;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eJr;
        aVar.eJr = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eJr;
        aVar.eJr = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eJr = 0;
        this.eJs = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eJr > 20 || a.this.eJr <= 0) {
                    a.this.eHR.showToast(R.string.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eJn.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.baA()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new an("c11937").l(VideoPlayActivityConfig.OBJ_ID, a.this.eHR.getChannelId()).P("obj_locate", 5));
                a.this.eHR.by(arrayList);
            }
        };
        this.eJt = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eJn.getItem(i);
                if (item != null) {
                    item.iJ(!item.baA());
                    a.this.eJn.notifyDataSetChanged();
                    if (item.baA()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eJr > 0) {
                        a.this.eJo.setTextColor(a.this.eHR.getResources().getColor(R.color.cp_link_tip_a));
                        a.this.eJo.setEnabled(true);
                        return;
                    }
                    a.this.eJo.setTextColor(a.this.eHR.getResources().getColor(R.color.cp_cont_d));
                    a.this.eJo.setEnabled(false);
                }
            }
        };
        this.eHR = channelAddVideoActivity;
        this.eHR.setIsAddSwipeBackLayout(true);
        this.eHR.setSwipeBackEnabled(true);
        this.eHR.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eHR.setContentView(R.layout.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.eHR.findViewById(R.id.parent);
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eJp = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eHR.getResources().getString(R.string.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add_video), this.eJs);
        this.eJo.setTextColor(this.eHR.getResources().getColor(R.color.cp_cont_d));
        this.eJo.setEnabled(false);
        this.Ni = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.eJn = new com.baidu.tieba.channel.a.a(this.eHR);
        this.Ni.setOnItemClickListener(this.eJt);
        this.Ni.setAdapter((ListAdapter) this.eJn);
        this.eJm = LayoutInflater.from(this.eHR.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.Ni.addHeaderView(this.eJm);
        this.eve = LayoutInflater.from(this.eHR.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.eve.findViewById(R.id.list_more_progress);
        this.eJl = (TextView) this.eve.findViewById(R.id.list_more_title);
        this.Ni.addFooterView(this.eve);
    }

    public void onDestroy() {
        if (this.eJn != null) {
            this.eJn = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dnM.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eJn.setData(null);
            this.Ni.setVisibility(8);
            this.eJp.setVisibility(0);
            this.eJq = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eJq.setText(this.eHR.getResources().getString(R.string.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iM(aVar.hasMore());
        this.eJn.setData(aVar.getItems());
        this.eJn.notifyDataSetChanged();
        this.Ni.setVisibility(0);
    }

    public void iM(boolean z) {
        this.eve.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eJl.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eJl.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.eHR.getLayoutMode().setNightMode(i == 1);
        this.eHR.getLayoutMode().onModeChanged(this.mRootView);
        this.eHR.getLayoutMode().onModeChanged(this.eve);
        this.eHR.getLayoutMode().onModeChanged(this.eJm);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnM.onChangeSkinType(getPageContext(), i);
        if (this.eJn != null) {
            this.eJn.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Ni.setOnSrollToBottomListener(eVar);
    }
}
