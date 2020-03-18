package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, d {
    private FrameLayout ctk;
    private NoNetworkView elL;
    private BdTypeListView gvC;
    private PbListView gvD;
    private f gvE;
    private i gvF;
    private boolean isFullScreen;
    private String mFrom;
    private String mId;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private String st_type;
    private String yuelaou_locate;
    private List<g> mListData = null;
    private CustomMessageListener cLK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                if (VideoAggregationFragment.this.mNoDataView != null) {
                    VideoAggregationFragment.this.gvF.bGH();
                } else if (j.isMobileNet() && VideoAggregationFragment.this.gvE != null && VideoAggregationFragment.this.gvE.kR()) {
                    VideoAggregationFragment.this.getPageContext().showToast((int) R.string.video_mobile_play_tips);
                }
            }
        }
    };
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoAggregationFragment.this.gvE != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isSucc) {
                VideoAggregationFragment.this.gvE.al(data.toUid, data.isAttention);
            }
        }
    };

    public static VideoAggregationFragment x(String str, String str2, String str3, String str4) {
        VideoAggregationFragment videoAggregationFragment = new VideoAggregationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FID", str);
        bundle.putString("PARAM_FROM", str2);
        bundle.putString("st_type", str3);
        bundle.putString("yuelaou_locate", str4);
        videoAggregationFragment.setArguments(bundle);
        return videoAggregationFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mId = arguments.getString("PARAM_FID");
            this.mFrom = arguments.getString("PARAM_FROM");
            this.st_type = arguments.getString("st_type");
            this.yuelaou_locate = arguments.getString("yuelaou_locate");
        }
        this.gvF = new i(getPageContext(), this);
        this.gvF.setId(this.mId);
        this.gvF.setFrom(this.mFrom);
        this.gvF.Bl(this.st_type);
        this.gvF.setLocation(this.yuelaou_locate);
        this.gvF.bGH();
        registerListener(this.cLK);
        registerListener(this.dat);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_aggregation, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.ctk = (FrameLayout) view.findViewById(R.id.container);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        bcO();
        this.elL = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.isNetWorkAvailable()) {
            this.elL.setVisibility(0);
        }
        this.gvC = (BdTypeListView) view.findViewById(R.id.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.mPullView.createView();
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                VideoAggregationFragment.this.gvF.bGH();
            }
        });
        this.mPullView.setTag(getUniqueId());
        this.gvC.setPullRefresh(this.mPullView);
        this.gvD = new PbListView(getPageContext().getPageActivity());
        this.gvD.createView();
        this.gvD.setLineVisible();
        this.gvD.setText(getResources().getString(R.string.list_has_no_more));
        this.gvD.startLoadData();
        this.gvC.setNextPage(this.gvD);
        this.gvC.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
                    VideoAggregationFragment.this.gvF.bGJ();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (VideoAggregationFragment.this.gvE != null) {
                    if (i > VideoAggregationFragment.this.gvE.bGE() || i + i2 < VideoAggregationFragment.this.gvE.bGE()) {
                        VideoAggregationFragment.this.gvE.bGF();
                    }
                }
            }
        });
        this.gvE = new f(getPageContext(), this.gvC, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom));
        showLoadingView();
    }

    private void h(View view, boolean z) {
        if (this.mNoDataView == null) {
            if (z) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, 0, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds480), l.getDimens(getPageContext().getPageActivity(), R.dimen.ds360)), NoDataViewFactory.d.cz(getPageContext().getPageActivity().getString(R.string.neterror), getPageContext().getPageActivity().getString(R.string.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getPageContext().getPageActivity().getString(R.string.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        VideoAggregationFragment.this.hideNoDataView();
                        VideoAggregationFragment.this.gvF.bGH();
                    }
                })));
            } else {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.ctk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds220)), NoDataViewFactory.d.lh(R.string.video_no_data), null);
            }
        }
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.gvC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.setVisibility(8);
            this.gvC.setVisibility(0);
        }
    }

    private void bcO() {
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.mFrom)) {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.video_aggregation_title));
        } else {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.video_middle_page_title));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoAggregationFragment.this.getActivity() != null && !VideoAggregationFragment.this.getActivity().isFinishing()) {
                    VideoAggregationFragment.this.getActivity().finish();
                }
            }
        });
    }

    public void ti(int i) {
        if (this.gvC != null && this.gvE != null) {
            if (i == 1 && this.gvE.kR()) {
                this.gvE.kP();
            }
            if (i == 2) {
                this.gvE.kQ();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.elL.onChangeSkinType(getPageContext(), i);
        am.setBackgroundColor(this.ctk, R.color.cp_cont_g);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.isFullScreen = true;
            this.mNavigationBar.setVisibility(8);
        } else {
            this.isFullScreen = false;
            this.mNavigationBar.setVisibility(0);
        }
        if (this.gvE != null) {
            this.gvE.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ti(2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        ti(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gvF != null) {
            this.gvF.bGI();
        }
        if (this.gvE != null) {
            this.gvE.onDestroy();
        }
    }

    public void showLoadingView() {
        if (getPageContext() != null && this.ctk != null) {
            showLoadingView(this.ctk, false, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds360));
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void hideLoadingView() {
        if (this.ctk != null) {
            this.gvC.completePullRefreshPostDelayed(0L);
            hideLoadingView(this.ctk);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void Sn() {
        if (v.isEmpty(this.mListData)) {
            h(this.ctk, true);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void e(List<g> list, boolean z, boolean z2) {
        if (list != null) {
            if (z) {
                this.mListData = list;
            } else {
                this.mListData.addAll(list);
            }
            if (z && list.size() == 0) {
                h(this.ctk, false);
                return;
            }
            this.gvE.setData(list, z);
            if (!z2) {
                this.gvD.endLoadData();
            }
            hideNoDataView();
            if (this.mNoDataView != null) {
                this.ctk.removeView(this.mNoDataView);
                this.mNoDataView = null;
            }
        }
    }

    public boolean th(int i) {
        if (this.gvE == null) {
            return false;
        }
        return this.gvE.th(i);
    }
}
