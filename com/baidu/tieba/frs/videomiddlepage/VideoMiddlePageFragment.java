package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.afd.i;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.videomiddlepage.c;
import com.baidu.tieba.frs.videomiddlepage.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoMiddlePageFragment extends BaseFragment implements b, f.b {
    private String XN;
    private View aMT;
    private NoNetworkView blp;
    private BdTypeListView dcG;
    private PbListView dcH;
    private RelativeLayout dsV;
    private List<com.baidu.tieba.card.data.b> dsX;
    private com.baidu.tbadk.core.view.a dsY;
    private c dsZ;
    private g dsw;
    private e dsy;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dsW = true;
    private int dsR = -1;
    private boolean dta = false;
    private boolean dtb = false;
    int dtd = 4;
    int dte = 7;
    int dtf = 4;
    private CustomMessageListener dtg = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921317 && customResponsedMessage.getmOrginalMessage() != null && customResponsedMessage.getmOrginalMessage().getExtra() != null) {
                String str = (String) customResponsedMessage.getmOrginalMessage().getExtra();
                if (VideoMiddlePageFragment.this.mBackImageView != null) {
                    if ("low".equals(str)) {
                        VideoMiddlePageFragment.this.mBackImageView.setAlpha(0.6f);
                    } else if ("high".equals(str)) {
                        VideoMiddlePageFragment.this.mBackImageView.setAlpha(1.0f);
                    }
                }
            }
        }
    };
    private CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.gP()) {
                    if (VideoMiddlePageFragment.this.blp != null) {
                        VideoMiddlePageFragment.this.blp.setVisibility(8);
                    }
                    if (j.gR() && !com.baidu.tieba.video.f.bvU().bvV() && VideoMiddlePageFragment.this.dsy != null && VideoMiddlePageFragment.this.dsy.lB()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(d.k.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.blp != null) {
                    VideoMiddlePageFragment.this.blp.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.dsy != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Ai) {
                VideoMiddlePageFragment.this.dsy.C(data.toUid, data.isAttention);
            }
        }
    };
    private HashMap dtc = new HashMap();

    public static VideoMiddlePageFragment aZ(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FROM", str);
        bundle.putString("PARAM_FID", str2);
        VideoMiddlePageFragment videoMiddlePageFragment = new VideoMiddlePageFragment();
        videoMiddlePageFragment.setArguments(bundle);
        return videoMiddlePageFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dsw = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dsw.setId(stringExtra);
            this.dsw.setLocation(stringExtra3);
            this.dsw.lT(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.dtc.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.dtc.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dsw.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.XN = arguments.getString("PARAM_FID");
        }
        if (this.dsw != null) {
            this.dsw.avE();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dtg);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.i.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        int e = l.e(getPageContext().getPageActivity(), d.e.ds88) + l.e(getPageContext().getPageActivity(), d.e.tbds42);
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, e));
        this.dcG = (BdTypeListView) view2.findViewById(d.g.video_middle_page_list_view);
        this.dcG.addHeaderView(this.mHeaderView);
        this.dsV = (RelativeLayout) view2.findViewById(d.g.container);
        this.blp = (NoNetworkView) view2.findViewById(d.g.no_network_view);
        if (!j.gP()) {
            this.blp.setVisibility(0);
        }
        this.dcH = new PbListView(getPageContext().getPageActivity());
        this.dcH.aN(false);
        this.dcH.kz();
        this.dcH.wN();
        this.dcH.dv(d.C0126d.cp_cont_b);
        this.dcH.setText(getResources().getString(d.k.list_has_no_more));
        this.dcH.setTextColor(d.C0126d.cp_cont_d);
        this.dcH.du(d.C0126d.cp_cont_d);
        this.dcG.setNextPage(this.dcH);
        this.dcG.setOnScrollListener(this);
        this.dsy = new e(getPageContext(), this.dcG, this, true, this.mFrom, this.XN);
        this.mNavigationBar = (NavigationBar) view2.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.aMT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.aMT.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.dsX = new ArrayList();
        this.dsZ = new c();
        if (this.dsw.avF() != null) {
            this.dsZ.a(this.dsw);
            com.baidu.tieba.frs.aggregation.g avA = this.dsZ.avA();
            ArrayList arrayList = new ArrayList();
            arrayList.add(avA);
            b(arrayList, true, false);
            int dividerHeight = this.dcG.getDividerHeight() + e;
            this.dtb = true;
            this.dsZ.a(getPageContext(), this.dsV, dividerHeight, this.dsy, new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.5
                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void avC() {
                    VideoMiddlePageFragment.this.dtb = true;
                }

                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void avD() {
                    VideoMiddlePageFragment.this.dtb = false;
                    if (VideoMiddlePageFragment.this.dsw != null && VideoMiddlePageFragment.this.dsw.avF() != null) {
                        ArrayList arrayList2 = new ArrayList(VideoMiddlePageFragment.this.dsX);
                        String str = VideoMiddlePageFragment.this.dsw.avF().threadId;
                        if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                            com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                            if (str.equals(gVar.threadId)) {
                                arrayList2.remove(gVar);
                            }
                        }
                        VideoMiddlePageFragment.this.h(arrayList2, VideoMiddlePageFragment.this.mHasMore);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dsy != null) {
            this.dsy.gb(false);
        }
        if (!this.dsW) {
            kq(2);
            if (this.dsy != null && this.dsR != -1) {
                this.dsy.lz(this.dsR);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dsy != null) {
            this.dsy.gb(true);
            this.dsR = this.dsy.ara();
        }
        kq(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dsw != null) {
            this.dsw.arf();
        }
        if (this.dsy != null) {
            this.dsy.onDestroy();
        }
        if (this.dsZ != null) {
            this.dsZ.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void Os() {
        if (this.dsY != null) {
            this.dsY.aI(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void EK() {
    }

    public void kq(int i) {
        if (this.dcG != null && this.dsy != null) {
            if (i == 1 && this.dsy.lB()) {
                this.dsy.lz();
            }
            if (i == 2) {
                this.dsy.lA();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void b(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        if (!v.w(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.dtd = TbadkCoreApplication.getInst().getAdAdSense().asL;
                this.dte = TbadkCoreApplication.getInst().getAdAdSense().asN;
                this.dtf = TbadkCoreApplication.getInst().getAdAdSense().asM;
            }
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.dtd + (-1))) % (this.dte + (-1)) == 0;
                boolean z5 = i2 - size == this.dtf;
                if (i2 <= this.dtf) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dsw != null ? this.dsw.getPageNum() : 0, 0, "", "", lA(size));
                    a.h(this.dtc);
                    dVar = com.baidu.afd.d.a(a);
                    arrayList.add(0, dVar);
                    i = size + 1;
                } else {
                    dVar = dVar2;
                    i = i2;
                }
                if (z3) {
                    com.baidu.tieba.card.data.b bVar = list.get(size - 1);
                    if (dVar != null && bVar != null) {
                        bVar.setTrigger(new i.a(dVar));
                    }
                }
                arrayList.add(0, list.get(size - 1));
                size--;
                i2 = i;
                dVar2 = dVar;
            }
            if (!this.dta && this.dsX.size() > 0 && this.dsw.avF() != null) {
                String str = this.dsw.avF().threadId;
                if (arrayList.size() > 0 && (arrayList.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (this.dsX.get(0) != null) {
                            this.dsX.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList.remove(gVar);
                    }
                    this.dta = true;
                }
            }
            this.dsX.addAll(arrayList);
            this.mHasMore = z;
            if (!this.dtb) {
                h(arrayList, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.dsy != null) {
            if (this.dsW) {
                this.dsy.setData(list, true);
                this.dsW = false;
            } else {
                this.dsy.setData(list, false);
            }
        }
        if (!z) {
            this.dcH.wT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.blp.onChangeSkinType(getPageContext(), i);
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
        if (this.dsy != null) {
            this.dsy.onConfigurationChanged(configuration);
        }
    }

    private int lA(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.dtd - 1) {
            i2 = 1;
            int i4 = i3 - (this.dtd - 1);
            if (i4 >= this.dtd - 1) {
                i2 = (i4 % (this.dte - 1)) + 1;
            }
        }
        return i2 + i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2 = 0;
        this.mScrollState = i;
        if (absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
            this.dsw.Pl();
        }
        if (i == 0) {
            int headerViewsCount = ((BdTypeListView) absListView).getHeaderViewsCount();
            int firstVisiblePosition = absListView.getFirstVisiblePosition() - headerViewsCount;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            if (absListView.getChildCount() > 1) {
                if (absListView.getChildAt(0) instanceof FrameLayout) {
                    i2 = az(absListView.getChildAt(0));
                } else if (absListView.getChildAt(0) instanceof com.baidu.tieba.lego.card.view.e) {
                    i2 = az(absListView.getChildAt(0));
                } else {
                    i2 = az(absListView.getChildAt(1));
                }
            }
            if (i2 < 75) {
                firstVisiblePosition += this.dsy.ly(firstVisiblePosition);
            }
            if (!this.mHasMore && this.dsX.size() == absListView.getLastVisiblePosition() - headerViewsCount) {
                firstVisiblePosition = this.dsX.size() - 1;
            }
            if (this.dsy.ara() != firstVisiblePosition) {
                this.dsy.lz(firstVisiblePosition);
            }
        }
        if (i == 1) {
            this.mBackImageView.setAlpha(1.0f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dsy != null) {
            if (i > this.dsy.ara() || i + i2 < this.dsy.ara()) {
                this.dsy.arb();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void lw(int i) {
        if (this.dsy != null) {
            this.dsy.lx(i - 1);
        }
    }

    public boolean kp(int i) {
        if (this.dsy == null) {
            return false;
        }
        return this.dsy.kp(i);
    }

    public int az(View view2) {
        Rect rect = new Rect();
        view2.getLocalVisibleRect(rect);
        int height = view2.getHeight();
        if (rect.top == 0 && rect.bottom == height) {
            return 100;
        }
        if (rect.top > 0) {
            return ((height - rect.top) * 100) / height;
        }
        if (rect.bottom <= 0 || rect.bottom >= height) {
            return 100;
        }
        return (rect.bottom * 100) / height;
    }
}
