package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel;
import com.baidu.tieba.frs.headvideo.t;
import com.baidu.tieba.play.ab;
import com.baidu.tieba.play.bb;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.v;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ForumHeadVideoView extends com.baidu.tbadk.widget.layout.g implements u {
    private final com.baidu.tbadk.widget.layout.i aFI;
    private v.a aKG;
    private v.d aKH;
    private final List<BannerThreadInfoData> aPE;
    private b bGa;
    private t.a bRA;
    final Runnable bRB;
    private v.b bRC;
    private final ForumHeadVideoListModel.a bRd;
    private ForumHeadVideoListModel bRl;
    private Animation bRm;
    private Animation bRn;
    private Animation bRo;
    private boolean bRp;
    private long bRq;
    private long bRr;
    private boolean bRs;
    private boolean bRt;
    private BdToast bRu;
    private f bRv;
    private int[] bRw;
    private final SparseArray<SoftReference<Drawable>> bRx;
    private BlurDrawable bRy;
    private boolean bRz;
    private com.baidu.adp.base.g<?> mPageContext;
    final Runnable mRunnable;

    public void setDoingPullRefresh(boolean z) {
        this.bRt = z;
        if (z) {
            stopPlay();
        } else {
            abC();
        }
    }

    protected Drawable getDrawable(int i) {
        SoftReference<Drawable> softReference = this.bRx.get(i);
        Drawable drawable = softReference != null ? softReference.get() : null;
        if (drawable == null) {
            try {
                Bitmap cP = ap.cP(i);
                if (cP == null || cP.isRecycled()) {
                    return null;
                }
                if (this.bRy == null) {
                    this.bRy = new BlurDrawable(getContext());
                }
                this.bRy.init(8, 12, cP);
                if (this.bRy != null && this.bRy.drawBlur()) {
                    drawable = new BitmapDrawable(this.bRy.getBlurredBitmap());
                }
                if (drawable != null) {
                    this.bRx.put(i, new SoftReference<>(drawable));
                    return drawable;
                }
                return drawable;
            } catch (Throwable th) {
                BdLog.detailException("BlurDrawable Is Throwable", th);
                return drawable;
            }
        }
        return drawable;
    }

    public ForumHeadVideoView(Context context) {
        super(context);
        this.bRp = true;
        this.bRs = false;
        this.bRt = false;
        this.bRw = new int[]{r.g.pic_video_bg01, r.g.pic_video_bg02, r.g.pic_video_bg03, r.g.pic_video_bg04};
        this.aPE = new ArrayList();
        this.bRx = new SparseArray<>();
        this.bRA = new i(this);
        this.aFI = new l(this);
        this.bRd = new m(this);
        this.bRB = new n(this);
        this.mRunnable = new o(this);
        this.aKH = new p(this);
        this.aKG = new q(this);
        this.bRC = new r(this);
        init(context);
    }

    public ForumHeadVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRp = true;
        this.bRs = false;
        this.bRt = false;
        this.bRw = new int[]{r.g.pic_video_bg01, r.g.pic_video_bg02, r.g.pic_video_bg03, r.g.pic_video_bg04};
        this.aPE = new ArrayList();
        this.bRx = new SparseArray<>();
        this.bRA = new i(this);
        this.aFI = new l(this);
        this.bRd = new m(this);
        this.bRB = new n(this);
        this.mRunnable = new o(this);
        this.aKH = new p(this);
        this.aKG = new q(this);
        this.bRC = new r(this);
        init(context);
    }

    private void init(Context context) {
        this.mPageContext = com.baidu.adp.base.k.C(context);
        this.bRl = new ForumHeadVideoListModel(this.mPageContext);
        this.bRl.a(this.bRd);
        setOnSizeChangeListener(this.aFI);
    }

    public void abz() {
        c currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
            bh threadInfo = currentVideoItemView.getThreadInfo();
            if (!x(threadInfo)) {
                TiebaStatic.log(new ar("c11278").ab("tid", threadInfo.getTid()).ab("fid", String.valueOf(threadInfo.getFid())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(bh bhVar) {
        if (bhVar == null) {
            return true;
        }
        return bhVar.getFid() <= 0 || com.baidu.adp.lib.g.b.c(bhVar.getTid(), 0L) <= 0 || com.baidu.adp.lib.g.b.c(bhVar.getId(), 0L) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(bh bhVar) {
        if (bhVar != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(bhVar.getId(), null, null);
            createNormalCfg.setVideo_source("headvideo");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public c getCurrentVideoItemView() {
        return ip(getChildCount() - 1);
    }

    public c getSwapVideoItemView() {
        return ip(getChildCount() - 2);
    }

    private c ip(int i) {
        if (i >= 0 && i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iq(int i) {
        BannerThreadInfoData bannerThreadInfoData;
        if (w.s(this.aPE)) {
            setVisibility(8);
            this.bRp = true;
            return;
        }
        BannerThreadInfoData bannerThreadInfoData2 = this.aPE.get(0);
        BannerThreadInfoData bannerThreadInfoData3 = this.aPE.size() >= 2 ? this.aPE.get(1) : bannerThreadInfoData2;
        if (this.aPE.size() < 3) {
            bannerThreadInfoData = null;
        } else {
            bannerThreadInfoData = this.aPE.get(2);
        }
        for (int i2 = 0; i2 < i; i2++) {
            c ip = ip(i2);
            if (ip == null) {
                ip = abD();
                a(ip, i2, i);
                addView(ip, i2);
            }
            if (i2 == i - 1) {
                ip.a(bannerThreadInfoData2);
                ip.abr();
            } else if (i2 == i - 2) {
                ip.a(bannerThreadInfoData3);
                ip.abr();
            } else if (i == 5 && i2 == i - 3) {
                ip.a(bannerThreadInfoData3);
                ip.abr();
            } else if (bannerThreadInfoData != null) {
                ip.a(bannerThreadInfoData);
            } else {
                ip.a(bannerThreadInfoData3);
            }
            f(ip, i2, i);
            ip.setVideoBlurViewBackgroundDrawable(getDrawable(ip.getBgResId()));
            ip.setVideoBlurViewMaskColor(r.e.cp_bg_line_d_alpha90);
            f(ip);
            ip.setVisibility(0);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        setVisibility(0);
        abA();
    }

    private void a(c cVar, int i, int i2) {
        if (cVar != null && this.bRw != null) {
            int length = (this.bRw.length - af(i, i2)) - 1;
            if (length < 0) {
                length = 0;
            } else if (length > this.bRw.length - 1) {
                length = this.bRw.length - 1;
            }
            int i3 = this.bRw[length];
            cVar.setVideoBlurViewBackgroundResId(i3);
            cVar.setVideoBlurViewBackgroundDrawable(getDrawable(i3));
        }
    }

    public void setWithSign(boolean z) {
        this.bRz = z;
    }

    public void a(long j, List<BannerThreadInfoData> list, b bVar) {
        if (this.bRz) {
            this.bRz = false;
            return;
        }
        this.bRl.reset();
        if (list == null || j < 0) {
            setVisibility(8);
            this.bRp = true;
            return;
        }
        this.bGa = bVar;
        this.bRq = j;
        this.aPE.clear();
        int min = Math.min(list.size(), 5);
        this.aPE.addAll(list.subList(0, min));
        this.bRr = ax(this.aPE);
        if (min >= 5) {
            this.bRl.setHasMore(1);
        } else {
            this.bRl.setHasMore(0);
        }
        iq(min);
        if (this.bRv == null) {
            this.bRv = new f(getContext(), this, this.bRA);
        }
    }

    private void abA() {
        c currentVideoItemView;
        if ((this.bGa == null || !this.bGa.abq()) && (currentVideoItemView = getCurrentVideoItemView()) != null && this.bGa != null) {
            if (abB()) {
                e(currentVideoItemView);
            } else if (a.abm() == 1) {
                abI();
            }
        }
    }

    private boolean abB() {
        int abm = a.abm();
        if ((this.bGa == null || !this.bGa.abp()) && abm != 0) {
            return abm == 1 && getChildCount() == 1;
        }
        return true;
    }

    public void e(c cVar) {
        if (cVar != null && !this.bRt && com.baidu.tbadk.util.w.fo(5)) {
            if (StringUtils.isNull(cVar.getVideoUrl())) {
                cVar.stopPlayback();
                cVar.setVideoPlayState(4);
            } else if (!cVar.isPlaying()) {
                cVar.startPlay();
            }
        }
    }

    public void abC() {
        if (this.bGa != null && !this.bGa.abq()) {
            e(getCurrentVideoItemView());
        }
    }

    public void f(c cVar) {
        if (cVar != null) {
            cVar.stopPlayback();
        }
    }

    private long ax(List<BannerThreadInfoData> list) {
        if (w.s(list)) {
            return 0L;
        }
        for (BannerThreadInfoData bannerThreadInfoData : list) {
            if (bannerThreadInfoData != null && bannerThreadInfoData.threadData != null && bannerThreadInfoData.from == 1) {
                return com.baidu.adp.lib.g.b.c(bannerThreadInfoData.threadData.getTid(), 0L);
            }
        }
        return 0L;
    }

    private int af(int i, int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 > 4 && i >= 3) {
            return i - 1;
        }
        return i;
    }

    private int ag(int i, int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 <= 4) {
            return (i2 - i) - 1;
        }
        if (i >= 3) {
            i--;
        }
        return (i2 - i) - 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, int i, int i2) {
        if (view != null && i2 > 0 && i >= 0) {
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds500);
            int I = com.baidu.adp.lib.util.k.I(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(I - (ag(i, i2) * 15), e - (af(i, i2) * 10));
            layoutParams.addRule(14, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    private c abD() {
        c cVar = new c(getContext());
        cVar.setVideoBlurViewMaskColor(r.e.cp_bg_line_d_alpha80);
        cVar.setVisibility(8);
        cVar.a(this.aKH, this.aKG, this.bRC);
        return cVar;
    }

    public void abE() {
        String string;
        if (this.bRp) {
            if (w.r(this.aPE) > 1) {
                g(getCurrentVideoItemView());
            } else {
                if (hasMore()) {
                    if (!com.baidu.adp.lib.util.i.gk()) {
                        string = getContext().getString(r.l.frs_head_video_slide_no_network);
                    } else {
                        string = getContext().getString(r.l.frs_head_video_slide_data_loading);
                    }
                } else if (getChildCount() == 1) {
                    string = getContext().getString(r.l.frs_head_video_no_more_data);
                } else {
                    string = getContext().getString(r.l.frs_head_video_no_more_data_1);
                }
                if (!TextUtils.isEmpty(string)) {
                    this.bRu = BdToast.b(getContext(), string, r.g.icon_toast_game_error).td();
                }
            }
            Jj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj() {
        if (hasMore() && w.r(this.aPE) <= 3) {
            this.bRl.d(this.bRq, this.bRr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        return this.bRl != null && this.bRl.hasMore();
    }

    private void g(c cVar) {
        if (this.bRp && cVar != null) {
            if (this.bRm == null) {
                abF();
            }
            cVar.setVisibility(8);
            cVar.startAnimation(this.bRm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(c cVar) {
        if (cVar != null) {
            if (this.bRn == null) {
                abG();
            }
            cVar.setVisibility(0);
            cVar.startAnimation(this.bRn);
        }
    }

    private void abF() {
        this.bRm = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_slide_out);
        this.bRm.setAnimationListener(new s(this));
    }

    private void abG() {
        this.bRn = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_slide_up);
        this.bRn.setAnimationListener(new j(this));
    }

    private void abH() {
        this.bRo = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_jump_up);
        this.bRo.setAnimationListener(new k(this));
    }

    private void abI() {
        if (this.bRp) {
            if (this.bRo == null) {
                abH();
            }
            com.baidu.adp.lib.g.h.eE().postDelayed(this.bRB, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abJ() {
        if (getChildCount() > 4) {
            c ip = ip(2);
            c ip2 = ip(3);
            if (ip != null && ip2 != null) {
                int bgResId = ip.getBgResId();
                ip2.setVideoBlurViewBackgroundResId(bgResId);
                ip2.setVideoBlurViewBackgroundDrawable(getDrawable(bgResId));
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c ip = ip(i2);
            if (ip != null) {
                ip.onChangeSkinType(gVar, i);
            }
        }
    }

    public void onDestory() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c ip = ip(i);
            if (ip != null) {
                ip.onDestory();
            }
        }
        if (this.bRu != null) {
            this.bRu.cancel();
        }
        if (this.bRx != null) {
            this.bRx.clear();
        }
        if (this.bRy != null) {
            this.bRy.onDestroy();
        }
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.mRunnable);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bRB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(bh bhVar) {
        if (bhVar != null && bhVar.rN() != null && !x(bhVar)) {
            bb bbVar = new bb();
            bbVar.mLocate = "headvideo";
            bbVar.bjS = bhVar.getTid();
            bbVar.bjT = new StringBuilder(String.valueOf(bhVar.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = bhVar.TW;
            bbVar.eTy = bhVar.TY;
            bbVar.eTz = bhVar.TX;
            bbVar.eTA = "";
            if (bhVar.sz() != null && bhVar.sz().channelId > 0) {
                bbVar.Ql = new StringBuilder(String.valueOf(bhVar.sz().channelId)).toString();
            } else {
                bbVar.Ql = "0";
            }
            ab.a(bhVar.rN().video_md5, "", "1", bbVar);
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.bRs;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (getCurrentVideoItemView() == null) {
            return false;
        }
        return getCurrentVideoItemView().isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (!this.bRs) {
            this.bRs = true;
            if (abB()) {
                abC();
            }
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        this.bRs = false;
        f(getCurrentVideoItemView());
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (getCurrentVideoItemView() == null) {
            return null;
        }
        return getCurrentVideoItemView().getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        return null;
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        return 0;
    }
}
