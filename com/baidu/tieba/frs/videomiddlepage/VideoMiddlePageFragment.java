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
import com.baidu.tbadk.core.util.w;
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
    private View aVN;
    private String agd;
    private NoNetworkView buT;
    private g dEX;
    private e dEZ;
    private RelativeLayout dFw;
    private List<com.baidu.tieba.card.data.b> dFy;
    private c dFz;
    private com.baidu.tbadk.core.view.a dbO;
    private BdTypeListView doH;
    private PbListView doI;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dFx = true;
    private int dFs = -1;
    private boolean dFA = false;
    private boolean dFB = false;
    int dFD = 4;
    int dFE = 7;
    int dFF = 4;
    private CustomMessageListener dFG = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                if (j.jD()) {
                    if (VideoMiddlePageFragment.this.buT != null) {
                        VideoMiddlePageFragment.this.buT.setVisibility(8);
                    }
                    if (j.jF() && !com.baidu.tieba.video.f.bBB().bBC() && VideoMiddlePageFragment.this.dEZ != null && VideoMiddlePageFragment.this.dEZ.or()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(d.k.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.buT != null) {
                    VideoMiddlePageFragment.this.buT.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.dEZ != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Gr) {
                VideoMiddlePageFragment.this.dEZ.D(data.toUid, data.isAttention);
            }
        }
    };
    private HashMap dFC = new HashMap();

    public static VideoMiddlePageFragment bk(String str, String str2) {
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
        this.dEX = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dEX.setId(stringExtra);
            this.dEX.setLocation(stringExtra3);
            this.dEX.mA(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.dFC.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.dFC.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dEX.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.agd = arguments.getString("PARAM_FID");
        }
        if (this.dEX != null) {
            this.dEX.aAu();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dFG);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.i.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        int e = l.e(getPageContext().getPageActivity(), d.e.ds88) + l.e(getPageContext().getPageActivity(), d.e.tbds42);
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, e));
        this.doH = (BdTypeListView) view.findViewById(d.g.video_middle_page_list_view);
        this.doH.addHeaderView(this.mHeaderView);
        this.dFw = (RelativeLayout) view.findViewById(d.g.container);
        this.buT = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.jD()) {
            this.buT.setVisibility(0);
        }
        this.doI = new PbListView(getPageContext().getPageActivity());
        this.doI.aT(false);
        this.doI.nn();
        this.doI.AE();
        this.doI.dy(d.C0142d.cp_cont_b);
        this.doI.setText(getResources().getString(d.k.list_has_no_more));
        this.doI.setTextColor(d.C0142d.cp_cont_d);
        this.doI.dx(d.C0142d.cp_cont_d);
        this.doH.setNextPage(this.doI);
        this.doH.setOnScrollListener(this);
        this.dEZ = new e(getPageContext(), this.doH, this, true, this.mFrom, this.agd);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.aVN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.aVN.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.dFy = new ArrayList();
        this.dFz = new c();
        if (this.dEX.aAv() != null) {
            this.dFz.a(this.dEX);
            com.baidu.tieba.frs.aggregation.g aAq = this.dFz.aAq();
            ArrayList arrayList = new ArrayList();
            arrayList.add(aAq);
            b(arrayList, true, false);
            int dividerHeight = this.doH.getDividerHeight() + e;
            this.dFB = true;
            this.dFz.a(getPageContext(), this.dFw, dividerHeight, this.dEZ, new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.5
                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void aAs() {
                    VideoMiddlePageFragment.this.dFB = true;
                }

                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void aAt() {
                    VideoMiddlePageFragment.this.dFB = false;
                    if (VideoMiddlePageFragment.this.dEX != null && VideoMiddlePageFragment.this.dEX.aAv() != null) {
                        ArrayList arrayList2 = new ArrayList(VideoMiddlePageFragment.this.dFy);
                        String str = VideoMiddlePageFragment.this.dEX.aAv().threadId;
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
        if (this.dEZ != null) {
            this.dEZ.gq(false);
        }
        if (!this.dFx) {
            kC(2);
            if (this.dEZ != null && this.dFs != -1) {
                this.dEZ.lN(this.dFs);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dEZ != null) {
            this.dEZ.gq(true);
            this.dFs = this.dEZ.avJ();
        }
        kC(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dEX != null) {
            this.dEX.avN();
        }
        if (this.dEZ != null) {
            this.dEZ.onDestroy();
        }
        if (this.dFz != null) {
            this.dFz.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void hideLoadingView() {
        if (this.dbO != null) {
            this.dbO.aO(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void IG() {
    }

    public void kC(int i) {
        if (this.doH != null && this.dEZ != null) {
            if (i == 1 && this.dEZ.or()) {
                this.dEZ.op();
            }
            if (i == 2) {
                this.dEZ.oq();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void b(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        if (!w.A(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.dFD = TbadkCoreApplication.getInst().getAdAdSense().aBL;
                this.dFE = TbadkCoreApplication.getInst().getAdAdSense().aBN;
                this.dFF = TbadkCoreApplication.getInst().getAdAdSense().aBM;
            }
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.dFD + (-1))) % (this.dFE + (-1)) == 0;
                boolean z5 = i2 - size == this.dFF;
                if (i2 <= this.dFF) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dEX != null ? this.dEX.getPageNum() : 0, 0, "", "", lO(size));
                    a.h(this.dFC);
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
            if (!this.dFA && this.dFy.size() > 0 && this.dEX.aAv() != null) {
                String str = this.dEX.aAv().threadId;
                if (arrayList.size() > 0 && (arrayList.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (this.dFy.get(0) != null) {
                            this.dFy.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList.remove(gVar);
                    }
                    this.dFA = true;
                }
            }
            this.dFy.addAll(arrayList);
            this.mHasMore = z;
            if (!this.dFB) {
                h(arrayList, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.dEZ != null) {
            if (this.dFx) {
                this.dEZ.setData(list, true);
                this.dFx = false;
            } else {
                this.dEZ.setData(list, false);
            }
        }
        if (!z) {
            this.doI.AK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.buT.onChangeSkinType(getPageContext(), i);
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
        if (this.dEZ != null) {
            this.dEZ.onConfigurationChanged(configuration);
        }
    }

    private int lO(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.dFD - 1) {
            i2 = 1;
            int i4 = i3 - (this.dFD - 1);
            if (i4 >= this.dFD - 1) {
                i2 = (i4 % (this.dFE - 1)) + 1;
            }
        }
        return i2 + i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2 = 0;
        this.mScrollState = i;
        if (absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
            this.dEX.Tf();
        }
        if (i == 0) {
            int headerViewsCount = ((BdTypeListView) absListView).getHeaderViewsCount();
            int firstVisiblePosition = absListView.getFirstVisiblePosition() - headerViewsCount;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            if (absListView.getChildCount() > 1) {
                if (absListView.getChildAt(0) instanceof FrameLayout) {
                    i2 = aB(absListView.getChildAt(0));
                } else if (absListView.getChildAt(0) instanceof com.baidu.tieba.lego.card.view.e) {
                    i2 = aB(absListView.getChildAt(0));
                } else {
                    i2 = aB(absListView.getChildAt(1));
                }
            }
            if (i2 < 75) {
                firstVisiblePosition += this.dEZ.lM(firstVisiblePosition);
            }
            if (!this.mHasMore && this.dFy.size() == absListView.getLastVisiblePosition() - headerViewsCount) {
                firstVisiblePosition = this.dFy.size() - 1;
            }
            if (this.dEZ.avJ() != firstVisiblePosition) {
                this.dEZ.lN(firstVisiblePosition);
            }
        }
        if (i == 1) {
            this.mBackImageView.setAlpha(1.0f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dEZ != null) {
            if (i > this.dEZ.avJ() || i + i2 < this.dEZ.avJ()) {
                this.dEZ.avK();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void lK(int i) {
        if (this.dEZ != null) {
            this.dEZ.lL(i - 1);
        }
    }

    public boolean kB(int i) {
        if (this.dEZ == null) {
            return false;
        }
        return this.dEZ.kB(i);
    }

    public int aB(View view) {
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        int height = view.getHeight();
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
