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
    private View aUR;
    private String afO;
    private NoNetworkView btu;
    private g dBJ;
    private e dBL;
    private RelativeLayout dCi;
    private List<com.baidu.tieba.card.data.b> dCk;
    private com.baidu.tbadk.core.view.a dCl;
    private c dCm;
    private BdTypeListView dlV;
    private PbListView dlW;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dCj = true;
    private int dCe = -1;
    private boolean dCn = false;
    private boolean dCo = false;
    int dCq = 4;
    int dCr = 7;
    int dCs = 4;
    private CustomMessageListener dCt = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                    if (VideoMiddlePageFragment.this.btu != null) {
                        VideoMiddlePageFragment.this.btu.setVisibility(8);
                    }
                    if (j.jF() && !com.baidu.tieba.video.f.bBb().bBc() && VideoMiddlePageFragment.this.dBL != null && VideoMiddlePageFragment.this.dBL.or()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(d.k.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.btu != null) {
                    VideoMiddlePageFragment.this.btu.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.dBL != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Gp) {
                VideoMiddlePageFragment.this.dBL.C(data.toUid, data.isAttention);
            }
        }
    };
    private HashMap dCp = new HashMap();

    public static VideoMiddlePageFragment bg(String str, String str2) {
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
        this.dBJ = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dBJ.setId(stringExtra);
            this.dBJ.setLocation(stringExtra3);
            this.dBJ.mA(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.dCp.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.dCp.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dBJ.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.afO = arguments.getString("PARAM_FID");
        }
        if (this.dBJ != null) {
            this.dBJ.azN();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dCt);
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
        this.dlV = (BdTypeListView) view.findViewById(d.g.video_middle_page_list_view);
        this.dlV.addHeaderView(this.mHeaderView);
        this.dCi = (RelativeLayout) view.findViewById(d.g.container);
        this.btu = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.jD()) {
            this.btu.setVisibility(0);
        }
        this.dlW = new PbListView(getPageContext().getPageActivity());
        this.dlW.aR(false);
        this.dlW.nn();
        this.dlW.Ao();
        this.dlW.dx(d.C0141d.cp_cont_b);
        this.dlW.setText(getResources().getString(d.k.list_has_no_more));
        this.dlW.setTextColor(d.C0141d.cp_cont_d);
        this.dlW.dw(d.C0141d.cp_cont_d);
        this.dlV.setNextPage(this.dlW);
        this.dlV.setOnScrollListener(this);
        this.dBL = new e(getPageContext(), this.dlV, this, true, this.mFrom, this.afO);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.aUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.aUR.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.dCk = new ArrayList();
        this.dCm = new c();
        if (this.dBJ.azO() != null) {
            this.dCm.a(this.dBJ);
            com.baidu.tieba.frs.aggregation.g azJ = this.dCm.azJ();
            ArrayList arrayList = new ArrayList();
            arrayList.add(azJ);
            b(arrayList, true, false);
            int dividerHeight = this.dlV.getDividerHeight() + e;
            this.dCo = true;
            this.dCm.a(getPageContext(), this.dCi, dividerHeight, this.dBL, new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.5
                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void azL() {
                    VideoMiddlePageFragment.this.dCo = true;
                }

                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void azM() {
                    VideoMiddlePageFragment.this.dCo = false;
                    if (VideoMiddlePageFragment.this.dBJ != null && VideoMiddlePageFragment.this.dBJ.azO() != null) {
                        ArrayList arrayList2 = new ArrayList(VideoMiddlePageFragment.this.dCk);
                        String str = VideoMiddlePageFragment.this.dBJ.azO().threadId;
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
        if (this.dBL != null) {
            this.dBL.gg(false);
        }
        if (!this.dCj) {
            kv(2);
            if (this.dBL != null && this.dCe != -1) {
                this.dBL.lG(this.dCe);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dBL != null) {
            this.dBL.gg(true);
            this.dCe = this.dBL.avf();
        }
        kv(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dBJ != null) {
            this.dBJ.avk();
        }
        if (this.dBL != null) {
            this.dBL.onDestroy();
        }
        if (this.dCm != null) {
            this.dCm.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void hideLoadingView() {
        if (this.dCl != null) {
            this.dCl.aM(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void Io() {
    }

    public void kv(int i) {
        if (this.dlV != null && this.dBL != null) {
            if (i == 1 && this.dBL.or()) {
                this.dBL.op();
            }
            if (i == 2) {
                this.dBL.oq();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void b(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        if (!w.z(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.dCq = TbadkCoreApplication.getInst().getAdAdSense().aAS;
                this.dCr = TbadkCoreApplication.getInst().getAdAdSense().aAU;
                this.dCs = TbadkCoreApplication.getInst().getAdAdSense().aAT;
            }
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.dCq + (-1))) % (this.dCr + (-1)) == 0;
                boolean z5 = i2 - size == this.dCs;
                if (i2 <= this.dCs) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dBJ != null ? this.dBJ.getPageNum() : 0, 0, "", "", lH(size));
                    a.h(this.dCp);
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
            if (!this.dCn && this.dCk.size() > 0 && this.dBJ.azO() != null) {
                String str = this.dBJ.azO().threadId;
                if (arrayList.size() > 0 && (arrayList.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (this.dCk.get(0) != null) {
                            this.dCk.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList.remove(gVar);
                    }
                    this.dCn = true;
                }
            }
            this.dCk.addAll(arrayList);
            this.mHasMore = z;
            if (!this.dCo) {
                h(arrayList, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.dBL != null) {
            if (this.dCj) {
                this.dBL.setData(list, true);
                this.dCj = false;
            } else {
                this.dBL.setData(list, false);
            }
        }
        if (!z) {
            this.dlW.Au();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.btu.onChangeSkinType(getPageContext(), i);
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
        if (this.dBL != null) {
            this.dBL.onConfigurationChanged(configuration);
        }
    }

    private int lH(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.dCq - 1) {
            i2 = 1;
            int i4 = i3 - (this.dCq - 1);
            if (i4 >= this.dCq - 1) {
                i2 = (i4 % (this.dCr - 1)) + 1;
            }
        }
        return i2 + i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2 = 0;
        this.mScrollState = i;
        if (absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
            this.dBJ.SJ();
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
                firstVisiblePosition += this.dBL.lF(firstVisiblePosition);
            }
            if (!this.mHasMore && this.dCk.size() == absListView.getLastVisiblePosition() - headerViewsCount) {
                firstVisiblePosition = this.dCk.size() - 1;
            }
            if (this.dBL.avf() != firstVisiblePosition) {
                this.dBL.lG(firstVisiblePosition);
            }
        }
        if (i == 1) {
            this.mBackImageView.setAlpha(1.0f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dBL != null) {
            if (i > this.dBL.avf() || i + i2 < this.dBL.avf()) {
                this.dBL.avg();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void lD(int i) {
        if (this.dBL != null) {
            this.dBL.lE(i - 1);
        }
    }

    public boolean ku(int i) {
        if (this.dBL == null) {
            return false;
        }
        return this.dBL.ku(i);
    }

    public int az(View view) {
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
