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
    private NoNetworkView dnF;
    private ChannelAddVideoActivity eHK;
    private TextView eJe;
    private View eJf;
    private com.baidu.tieba.channel.a.a eJg;
    private TextView eJh;
    private ViewStub eJi;
    private TextView eJj;
    private int eJk;
    private View.OnClickListener eJl;
    private AdapterView.OnItemClickListener eJm;
    private View euX;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    static /* synthetic */ int d(a aVar) {
        int i = aVar.eJk;
        aVar.eJk = i + 1;
        return i;
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.eJk;
        aVar.eJk = i - 1;
        return i;
    }

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        super(channelAddVideoActivity.getPageContext());
        this.eJk = 0;
        this.eJl = new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eJk > 20 || a.this.eJk <= 0) {
                    a.this.eHK.showToast(R.string.hundred_once_at_most);
                    return;
                }
                List<com.baidu.tieba.channel.data.b> data = a.this.eJg.getData();
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.channel.data.b bVar : data) {
                    if (bVar.bay()) {
                        arrayList.add(Long.valueOf(bVar.getThreadId()));
                    }
                }
                TiebaStatic.log(new an("c11937").l(VideoPlayActivityConfig.OBJ_ID, a.this.eHK.getChannelId()).P("obj_locate", 5));
                a.this.eHK.by(arrayList);
            }
        };
        this.eJm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.channel.view.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tieba.channel.data.b item = a.this.eJg.getItem(i);
                if (item != null) {
                    item.iJ(!item.bay());
                    a.this.eJg.notifyDataSetChanged();
                    if (item.bay()) {
                        a.d(a.this);
                    } else {
                        a.e(a.this);
                    }
                    if (a.this.eJk > 0) {
                        a.this.eJh.setTextColor(a.this.eHK.getResources().getColor(R.color.cp_link_tip_a));
                        a.this.eJh.setEnabled(true);
                        return;
                    }
                    a.this.eJh.setTextColor(a.this.eHK.getResources().getColor(R.color.cp_cont_d));
                    a.this.eJh.setEnabled(false);
                }
            }
        };
        this.eHK = channelAddVideoActivity;
        this.eHK.setIsAddSwipeBackLayout(true);
        this.eHK.setSwipeBackEnabled(true);
        this.eHK.setUseStyleImmersiveSticky(true);
        initViews();
    }

    private void initViews() {
        this.eHK.setContentView(R.layout.channel_add_video_layout);
        this.mRootView = (RelativeLayout) this.eHK.findViewById(R.id.parent);
        this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.eJi = (ViewStub) this.mRootView.findViewById(R.id.no_data_viewstub);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.setCenterTextTitle(this.eHK.getResources().getString(R.string.add_video_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add_video), this.eJl);
        this.eJh.setTextColor(this.eHK.getResources().getColor(R.color.cp_cont_d));
        this.eJh.setEnabled(false);
        this.Ni = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.eJg = new com.baidu.tieba.channel.a.a(this.eHK);
        this.Ni.setOnItemClickListener(this.eJm);
        this.Ni.setAdapter((ListAdapter) this.eJg);
        this.eJf = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_toast_layout, (ViewGroup) null, false);
        this.Ni.addHeaderView(this.eJf);
        this.euX = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(R.layout.channel_list_footer, (ViewGroup) null, false);
        this.mProgressBar = (ProgressBar) this.euX.findViewById(R.id.list_more_progress);
        this.eJe = (TextView) this.euX.findViewById(R.id.list_more_title);
        this.Ni.addFooterView(this.euX);
    }

    public void onDestroy() {
        if (this.eJg != null) {
            this.eJg = null;
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.dnF.a(aVar);
    }

    public void a(com.baidu.tieba.channel.data.a aVar) {
        if (aVar == null || aVar.getItems() == null || aVar.getItems().size() <= 0) {
            this.eJg.setData(null);
            this.Ni.setVisibility(8);
            this.eJi.setVisibility(0);
            this.eJj = (TextView) this.mRootView.findViewById(R.id.no_data_tip);
            this.eJj.setText(this.eHK.getResources().getString(R.string.add_video_no_data));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        iM(aVar.hasMore());
        this.eJg.setData(aVar.getItems());
        this.eJg.notifyDataSetChanged();
        this.Ni.setVisibility(0);
    }

    public void iM(boolean z) {
        this.euX.setVisibility(0);
        if (z) {
            this.mProgressBar.setVisibility(0);
            this.eJe.setText(getPageContext().getString(R.string.subcribe_channel_list_hasmore));
            return;
        }
        this.mProgressBar.setVisibility(8);
        this.eJe.setText(getPageContext().getString(R.string.channel_subscribe_list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.eHK.getLayoutMode().setNightMode(i == 1);
        this.eHK.getLayoutMode().onModeChanged(this.mRootView);
        this.eHK.getLayoutMode().onModeChanged(this.euX);
        this.eHK.getLayoutMode().onModeChanged(this.eJf);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnF.onChangeSkinType(getPageContext(), i);
        if (this.eJg != null) {
            this.eJg.notifyDataSetChanged();
        }
    }

    public void b(BdListView.e eVar) {
        this.Ni.setOnSrollToBottomListener(eVar);
    }
}
