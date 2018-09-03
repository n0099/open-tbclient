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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, d {
    private NoNetworkView bvB;
    private FrameLayout bvp;
    private f drA;
    private i drB;
    private BdTypeListView dry;
    private PbListView drz;
    private boolean isFullScreen;
    private String mFrom;
    private String mId;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private String st_type;
    private String yuelaou_locate;
    private List<g> mListData = null;
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jE()) {
                if (VideoAggregationFragment.this.mNoDataView != null) {
                    VideoAggregationFragment.this.drB.awq();
                } else if (j.jG() && VideoAggregationFragment.this.drA != null && VideoAggregationFragment.this.drA.oq()) {
                    VideoAggregationFragment.this.getPageContext().showToast(f.j.video_mobile_play_tips);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoAggregationFragment.this.drA != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Gp) {
                VideoAggregationFragment.this.drA.C(data.toUid, data.isAttention);
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
        this.drB = new i(getPageContext(), this);
        this.drB.setId(this.mId);
        this.drB.setFrom(this.mFrom);
        this.drB.mB(this.st_type);
        this.drB.setLocation(this.yuelaou_locate);
        this.drB.awq();
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(f.h.fragment_video_aggregation, (ViewGroup) null);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.bvp = (FrameLayout) view.findViewById(f.g.container);
        this.mNavigationBar = (NavigationBar) view.findViewById(f.g.navigation_bar);
        asl();
        this.bvB = (NoNetworkView) view.findViewById(f.g.no_network_view);
        if (!j.jE()) {
            this.bvB.setVisibility(0);
        }
        this.dry = (BdTypeListView) view.findViewById(f.g.listView);
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.mPullView.np();
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                VideoAggregationFragment.this.drB.awq();
            }
        });
        this.mPullView.setTag(getUniqueId());
        this.dry.setPullRefresh(this.mPullView);
        this.drz = new PbListView(getPageContext().getPageActivity());
        this.drz.np();
        this.drz.Ar();
        this.drz.setText(getResources().getString(f.j.list_has_no_more));
        this.drz.Av();
        this.dry.setNextPage(this.drz);
        this.dry.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
                    VideoAggregationFragment.this.drB.aws();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (VideoAggregationFragment.this.drA != null) {
                    if (i > VideoAggregationFragment.this.drA.awn() || i + i2 < VideoAggregationFragment.this.drA.awn()) {
                        VideoAggregationFragment.this.drA.awo();
                    }
                }
            }
        });
        this.drA = new f(getPageContext(), this.dry, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.mFrom));
        showLoadingView();
    }

    private void h(View view, boolean z) {
        if (this.mNoDataView == null) {
            if (z) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, f.C0146f.net_refresh_emotion, 0, l.f(getPageContext().getPageActivity(), f.e.ds480), l.f(getPageContext().getPageActivity(), f.e.ds360)), NoDataViewFactory.d.ag(getPageContext().getPageActivity().getString(f.j.neterror), getPageContext().getPageActivity().getString(f.j.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getPageContext().getPageActivity().getString(f.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        VideoAggregationFragment.this.hideNoDataView();
                        VideoAggregationFragment.this.drB.awq();
                    }
                })));
            } else {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bvp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), f.e.ds220)), NoDataViewFactory.d.dt(f.j.video_no_data), null);
            }
        }
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.dry.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
            this.mNoDataView.setVisibility(8);
            this.dry.setVisibility(0);
        }
    }

    private void asl() {
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.mFrom)) {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(f.j.video_aggregation_title));
        } else {
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(f.j.video_middle_page_title));
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

    public void kM(int i) {
        if (this.dry != null && this.drA != null) {
            if (i == 1 && this.drA.oq()) {
                this.drA.oo();
            }
            if (i == 2) {
                this.drA.op();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvB.onChangeSkinType(getPageContext(), i);
        am.j(this.bvp, f.d.cp_cont_g);
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
        if (this.drA != null) {
            this.drA.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        kM(2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        kM(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.drB != null) {
            this.drB.awr();
        }
        if (this.drA != null) {
            this.drA.onDestroy();
        }
    }

    public void showLoadingView() {
        if (getPageContext() != null && this.bvp != null) {
            showLoadingView(this.bvp, false, l.f(getPageContext().getPageActivity(), f.e.ds360));
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void hideLoadingView() {
        if (this.bvp != null) {
            this.dry.completePullRefreshPostDelayed(2000L);
            hideLoadingView(this.bvp);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void IB() {
        if (w.z(this.mListData)) {
            h(this.bvp, true);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d
    public void b(List<g> list, boolean z, boolean z2) {
        if (list != null) {
            if (z) {
                this.mListData = list;
            } else {
                this.mListData.addAll(list);
            }
            if (z && list.size() == 0) {
                h(this.bvp, false);
                return;
            }
            this.drA.setData(list, z);
            if (!z2) {
                this.drz.Aw();
            }
            hideNoDataView();
            if (this.mNoDataView != null) {
                this.bvp.removeView(this.mNoDataView);
                this.mNoDataView = null;
            }
        }
    }

    public boolean kL(int i) {
        if (this.drA == null) {
            return false;
        }
        return this.drA.kL(i);
    }
}
