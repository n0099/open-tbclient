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
import com.baidu.adp.framework.MessageManager;
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
import com.baidu.tbadk.core.util.ap;
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
    private View aVP;
    private String afx;
    private NoNetworkView bvz;
    private g dHK;
    private e dHM;
    private RelativeLayout dIk;
    private List<com.baidu.tieba.card.data.b> dIm;
    private c dIn;
    private com.baidu.tieba.t.a dIr;
    private com.baidu.tbadk.core.view.a deH;
    private BdTypeListView drB;
    private PbListView drC;
    private boolean isFullScreen;
    private ImageView mBackImageView;
    private String mFrom;
    private boolean mHasMore;
    private View mHeaderView;
    private NavigationBar mNavigationBar;
    private int mScrollState;
    private boolean dIl = true;
    private int dIg = -1;
    private boolean dIo = false;
    private boolean dIp = false;
    int dIs = 4;
    int dIt = 7;
    int dIu = 4;
    private CustomMessageListener dIv = new CustomMessageListener(2921317) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.1
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
                if (j.jE()) {
                    if (VideoMiddlePageFragment.this.bvz != null) {
                        VideoMiddlePageFragment.this.bvz.setVisibility(8);
                    }
                    if (j.jG() && !com.baidu.tieba.video.g.bAi().bAj() && VideoMiddlePageFragment.this.dHM != null && VideoMiddlePageFragment.this.dHM.ot()) {
                        VideoMiddlePageFragment.this.getPageContext().showToast(d.j.video_mobile_play_tips);
                    }
                } else if (VideoMiddlePageFragment.this.bvz != null) {
                    VideoMiddlePageFragment.this.bvz.setVisibility(0);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && VideoMiddlePageFragment.this.dHM != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.Gp) {
                VideoMiddlePageFragment.this.dHM.C(data.toUid, data.isAttention);
            }
        }
    };
    private HashMap dIq = new HashMap();

    public static VideoMiddlePageFragment bi(String str, String str2) {
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
        this.dHK = new g(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.dHK.setId(stringExtra);
            this.dHK.setLocation(stringExtra3);
            this.dHK.mz(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra(VideoMiddlePageActivityConfig.PARAM_VIDEO_THREAD_INFO);
            if (videoSerializeVideoThreadInfo != null) {
                this.dIq.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.dIq.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.dHK.a(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFrom = arguments.getString("PARAM_FROM");
            this.afx = arguments.getString("PARAM_FID");
        }
        if (this.dHK != null) {
            this.dHK.setFrom(this.mFrom);
            this.dHK.aBd();
        }
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.mAttentionListener);
        registerListener(this.dIv);
        this.dIr = new com.baidu.tieba.t.a();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(d.h.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mHeaderView = new View(getPageContext().getPageActivity());
        int f = l.f(getPageContext().getPageActivity(), d.e.ds88) + l.f(getPageContext().getPageActivity(), d.e.tbds42);
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, f));
        this.drB = (BdTypeListView) view.findViewById(d.g.video_middle_page_list_view);
        this.drB.addHeaderView(this.mHeaderView);
        this.dIk = (RelativeLayout) view.findViewById(d.g.container);
        this.bvz = (NoNetworkView) view.findViewById(d.g.no_network_view);
        if (!j.jE()) {
            this.bvz.setVisibility(0);
        }
        this.drC = new PbListView(getPageContext().getPageActivity());
        this.drC.aR(false);
        this.drC.np();
        this.drC.Au();
        this.drC.dB(d.C0140d.cp_cont_b);
        this.drC.setText(getResources().getString(d.j.list_has_no_more));
        this.drC.setTextColor(d.C0140d.cp_cont_d);
        this.drC.dA(d.C0140d.cp_cont_f);
        this.drB.setNextPage(this.drC);
        this.drC.dD(l.f(TbadkCoreApplication.getInst(), d.e.tbds804));
        this.drB.setOnScrollListener(this);
        this.dHM = new e(getPageContext(), this.drB, this, true, this.mFrom, this.afx);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.navigation_bar);
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        this.mNavigationBar.hideBottomLine();
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
            }
        });
        this.mBackImageView = (ImageView) this.aVP.findViewById(d.g.widget_navi_back_button);
        this.mBackImageView.setImageDrawable(getPageContext().getResources().getDrawable(d.f.icon_return_bg));
        this.dIm = new ArrayList();
        this.dIn = new c();
        if (this.dHK.aBe() != null) {
            this.dIn.a(this.dHK);
            com.baidu.tieba.frs.aggregation.g aAX = this.dIn.aAX();
            ArrayList arrayList = new ArrayList();
            arrayList.add(aAX);
            b(arrayList, true, false);
            int dividerHeight = this.drB.getDividerHeight() + f;
            this.dIp = true;
            this.dIn.a(getPageContext(), this.dIk, dividerHeight, this.dHM, new c.a() { // from class: com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment.5
                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void aAZ() {
                    VideoMiddlePageFragment.this.dIp = true;
                }

                @Override // com.baidu.tieba.frs.videomiddlepage.c.a
                public void aBa() {
                    VideoMiddlePageFragment.this.dIp = false;
                    if (VideoMiddlePageFragment.this.dHK != null && VideoMiddlePageFragment.this.dHK.aBe() != null) {
                        ArrayList arrayList2 = new ArrayList(VideoMiddlePageFragment.this.dIm);
                        String str = VideoMiddlePageFragment.this.dHK.aBe().threadId;
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
        if (this.dHM != null) {
            this.dHM.gs(false);
        }
        if (!this.dIl && this.dIr != null && !this.dIr.isKeyguardLocked()) {
            kN(2);
            if (this.dHM != null && this.dIg != -1) {
                this.dHM.lZ(this.dIg);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dHM != null) {
            this.dHM.gs(true);
            this.dIg = this.dHM.awo();
        }
        kN(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dHK != null) {
            this.dHK.aws();
        }
        if (this.dHM != null) {
            this.dHM.onDestroy();
        }
        if (this.dIn != null) {
            this.dIn.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void a(f.a aVar) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void hideLoadingView() {
        if (this.deH != null) {
            this.deH.aM(false);
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void showMsg(String str) {
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void IB() {
    }

    public void kN(int i) {
        if (this.drB != null && this.dHM != null) {
            if (i == 1 && this.dHM.ot()) {
                this.dHM.or();
            }
            if (i == 2) {
                this.dHM.os();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.f.b
    public void b(List<com.baidu.tieba.card.data.b> list, boolean z, boolean z2) {
        boolean z3;
        com.baidu.afd.d dVar;
        int i;
        ArrayList arrayList = null;
        this.mHasMore = z;
        if (!w.z(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.dIs = TbadkCoreApplication.getInst().getAdAdSense().aBF;
                this.dIt = TbadkCoreApplication.getInst().getAdAdSense().aBH;
                this.dIu = TbadkCoreApplication.getInst().getAdAdSense().aBG;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            com.baidu.afd.d dVar2 = null;
            int i2 = 0;
            while (size > 0) {
                boolean z4 = (size - (this.dIs + (-1))) % (this.dIt + (-1)) == 0;
                boolean z5 = i2 - size == this.dIu;
                if (i2 <= this.dIu) {
                    z3 = size == 1;
                } else {
                    z3 = z5;
                }
                if (z4) {
                    com.baidu.afd.g a = com.baidu.afd.c.a(3, this.dHK != null ? this.dHK.getPageNum() : 0, 0, "", "", ma(size));
                    a.h(this.dIq);
                    dVar = com.baidu.afd.d.a(a);
                    arrayList2.add(0, dVar);
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
                arrayList2.add(0, list.get(size - 1));
                size--;
                i2 = i;
                dVar2 = dVar;
            }
            if (!this.dIo && this.dIm.size() > 0 && this.dHK.aBe() != null) {
                String str = this.dHK.aBe().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof com.baidu.tieba.frs.aggregation.g)) {
                    com.baidu.tieba.frs.aggregation.g gVar = (com.baidu.tieba.frs.aggregation.g) arrayList2.get(0);
                    if (str.equals(gVar.threadId)) {
                        if (this.dIm.get(0) != null) {
                            this.dIm.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.dIo = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.dIm.addAll(arrayList);
        }
        if (!this.dIp) {
            h(arrayList, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (this.dHM != null && !w.z(list)) {
            if (this.dIl) {
                this.dHM.setData(list, true);
                this.dIl = false;
            } else {
                this.dHM.setData(list, false);
            }
        }
        if (!z) {
            this.drC.AA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bvz.onChangeSkinType(getPageContext(), i);
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
        if (this.dHM != null) {
            this.dHM.onConfigurationChanged(configuration);
        }
    }

    private int ma(int i) {
        int i2 = 0;
        int i3 = i + 1;
        if (i3 > this.dIs - 1) {
            i2 = 1;
            int i4 = i3 - (this.dIs - 1);
            if (i4 >= this.dIs - 1) {
                i2 = (i4 % (this.dIt - 1)) + 1;
            }
        }
        return i2 + i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.mScrollState = i;
        if (absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
            this.dHK.setFrom(this.mFrom);
            this.dHK.Tn();
        }
        if (i == 0) {
            a(absListView);
            b(absListView);
        } else if (i == 1) {
            this.mBackImageView.setAlpha(1.0f);
        }
    }

    private void a(AbsListView absListView) {
        List<String> list;
        com.baidu.tieba.card.a.a aVar;
        if (absListView != null) {
            List<String> list2 = null;
            int childCount = absListView.getChildCount();
            ArrayList arrayList = new ArrayList();
            if (childCount > 0) {
                int i = 0;
                while (i < childCount) {
                    View childAt = absListView.getChildAt(i);
                    if (childAt != null && (childAt.getTag() instanceof com.baidu.tieba.card.a.a) && (aVar = (com.baidu.tieba.card.a.a) childAt.getTag()) != null && (aVar.ajz() instanceof com.baidu.tieba.lego.card.view.i)) {
                        com.baidu.tieba.lego.card.view.i iVar = (com.baidu.tieba.lego.card.view.i) aVar.ajz();
                        if (!ap.isEmpty(iVar.getMediaId())) {
                            arrayList.add(iVar.getMediaId());
                        }
                        if (list2 == null) {
                            list = iVar.getMediaIDs();
                            i++;
                            list2 = list;
                        }
                    }
                    list = list2;
                    i++;
                    list2 = list;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (!w.z(list2)) {
                for (String str : list2) {
                    if (!ap.isEmpty(str) && !arrayList.contains(str)) {
                        arrayList2.add(str);
                    }
                }
            }
            if (!w.z(arrayList2)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList2));
            }
        }
    }

    private void b(AbsListView absListView) {
        int i = 0;
        int firstVisiblePosition = absListView.getFirstVisiblePosition() - ((BdTypeListView) absListView).getHeaderViewsCount();
        if (firstVisiblePosition < 0) {
            firstVisiblePosition = 0;
        }
        if (absListView.getChildCount() > 0 && ((absListView.getChildAt(0) instanceof FrameLayout) || (absListView.getChildAt(0) instanceof com.baidu.tieba.lego.card.view.e))) {
            i = aE(absListView.getChildAt(0));
        } else if (absListView.getChildCount() > 1) {
            i = aE(absListView.getChildAt(1));
        }
        if (!this.dHM.lY(firstVisiblePosition) || i < 75) {
            firstVisiblePosition += this.dHM.lX(firstVisiblePosition);
        }
        this.dHM.lZ(firstVisiblePosition);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dHM != null) {
            if (i > this.dHM.awo() || i + i2 < this.dHM.awo()) {
                this.dHM.awp();
            }
        }
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public void lV(int i) {
        if (this.dHM != null) {
            this.dHM.lW(i - 1);
        }
    }

    public boolean kM(int i) {
        if (this.dHM == null) {
            return false;
        }
        return this.dHM.kM(i);
    }

    public int aE(View view) {
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
