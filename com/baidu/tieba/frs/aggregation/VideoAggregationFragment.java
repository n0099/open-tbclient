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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, d {
    private NoNetworkView bOA;
    private BdTypeListView dQr;
    private PbListView dQs;
    private f dQt;
    private i dQu;
    private boolean isFullScreen;
    private String mFrom;
    private String mId;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private FrameLayout mRootView;
    private String st_type;
    private String yuelaou_locate;
    private List<g> mListData = null;
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV()) {
                if (VideoAggregationFragment.this.mNoDataView != null) {
                    VideoAggregationFragment.this.dQu.aDR();
                } else if (j.kX() && VideoAggregationFragment.this.dQt != null && VideoAggregationFragment.this.dQt.pB()) {
                    VideoAggregationFragment.this.getPageContext().showToast(e.j.video_mobile_play_tips);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoAggregationFragment.this.dQt != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Jr) {
                VideoAggregationFragment.this.dQt.M(data.toUid, data.isAttention);
            }
        }
    };

    public static VideoAggregationFragment l(String str, String str2, String str3, String str4) {
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
        this.dQu = new i(getPageContext(), this);
        this.dQu.setId(this.mId);
        this.dQu.setFrom(this.mFrom);
        this.dQu.ok(this.st_type);
        this.dQu.setLocation(this.yuelaou_locate);
        this.dQu.aDR();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(e.h.fragment_video_aggregation, (ViewGroup) null);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mRootView = (FrameLayout) view.findViewById(e.g.container);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.navigation_bar);
        azu();
        this.bOA = (NoNetworkView) view.findViewById(e.g.no_network_view);
        if (!j.kV()) {
            this.bOA.setVisibility(0);
        }
        this.dQr = (BdTypeListView) view.findViewById(e.g.listView);
        this.mPullView = new k(getPageContext());
        this.mPullView.oD();
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                VideoAggregationFragment.this.dQu.aDR();
            }
        });
        this.mPullView.setTag(getUniqueId());
        this.dQr.setPullRefresh(this.mPullView);
        this.dQs = new PbListView(getPageContext().getPageActivity());
        this.dQs.oD();
        this.dQs.EY();
        this.dQs.setText(getResources().getString(e.j.list_has_no_more));
        this.dQs.Fc();
        this.dQr.setNextPage(this.dQs);
        this.dQr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
                    VideoAggregationFragment.this.dQu.aDT();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (VideoAggregationFragment.this.dQt != null) {
                    if (i > VideoAggregationFragment.this.dQt.aDN() || i + i2 < VideoAggregationFragment.this.dQt.aDN()) {
                        VideoAggregationFragment.this.dQt.aDO();
                    }
                }
            }
        });
        this.dQt = new f(getPageContext(), this.dQr, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom));
        showLoadingView();
    }

    private void g(View view, boolean z) {
        if (this.mNoDataView == null) {
            if (z) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.net_refresh_emotion, 0, l.h(getPageContext().getPageActivity(), e.C0210e.ds480), l.h(getPageContext().getPageActivity(), e.C0210e.ds360)), NoDataViewFactory.d.aD(getPageContext().getPageActivity().getString(e.j.neterror), getPageContext().getPageActivity().getString(e.j.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getPageContext().getPageActivity().getString(e.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        VideoAggregationFragment.this.hideNoDataView();
                        VideoAggregationFragment.this.dQu.aDR();
                    }
                })));
            } else {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds220)), NoDataViewFactory.d.eq(e.j.video_no_data), null);
            }
        }
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.dQr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.setVisibility(8);
            this.dQr.setVisibility(0);
        }
    }

    private void azu() {
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.mFrom)) {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.video_aggregation_title));
        } else {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.video_middle_page_title));
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

    public void mI(int i) {
        if (this.dQr != null && this.dQt != null) {
            if (i == 1 && this.dQt.pB()) {
                this.dQt.pz();
            }
            if (i == 2) {
                this.dQt.pA();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bOA.onChangeSkinType(getPageContext(), i);
        al.j(this.mRootView, e.d.cp_cont_g);
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
        if (this.dQt != null) {
            this.dQt.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        mI(2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        mI(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dQu != null) {
            this.dQu.aDS();
        }
        if (this.dQt != null) {
            this.dQt.onDestroy();
        }
    }

    public void showLoadingView() {
        if (getPageContext() != null && this.mRootView != null) {
            showLoadingView(this.mRootView, false, l.h(getPageContext().getPageActivity(), e.C0210e.ds360));
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void hideLoadingView() {
        if (this.mRootView != null) {
            this.dQr.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            hideLoadingView(this.mRootView);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void Ng() {
        if (v.I(this.mListData)) {
            g(this.mRootView, true);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void c(List<g> list, boolean z, boolean z2) {
        if (list != null) {
            if (z) {
                this.mListData = list;
            } else {
                this.mListData.addAll(list);
            }
            if (z && list.size() == 0) {
                g(this.mRootView, false);
                return;
            }
            this.dQt.setData(list, z);
            if (!z2) {
                this.dQs.Fd();
            }
            hideNoDataView();
            if (this.mNoDataView != null) {
                this.mRootView.removeView(this.mNoDataView);
                this.mNoDataView = null;
            }
        }
    }

    public boolean mH(int i) {
        if (this.dQt == null) {
            return false;
        }
        return this.dQt.mH(i);
    }
}
