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
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.headvideo.e;
import com.baidu.tieba.frs.headvideo.u;
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.z;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ForumHeadVideoView extends com.baidu.tbadk.widget.layout.g implements com.baidu.tieba.play.s {
    private final com.baidu.tbadk.widget.layout.i aGT;
    private t.a aLE;
    private t.d aLF;
    private com.baidu.adp.base.h<?> aTE;
    private final List<BannerThreadInfoData> aUm;
    private final e.a bKK;
    private e bKS;
    private Animation bKT;
    private Animation bKU;
    private Animation bKV;
    private boolean bKW;
    private long bKX;
    private long bKY;
    private boolean bKZ;
    private boolean bLa;
    private BdToast bLb;
    private g bLc;
    private int[] bLd;
    private final SparseArray<SoftReference<Drawable>> bLe;
    private BlurDrawable bLf;
    private boolean bLg;
    private u.a bLh;
    final Runnable bLi;
    private t.b bLj;
    private b byB;
    final Runnable mRunnable;

    public void setDoingPullRefresh(boolean z) {
        this.bLa = z;
        if (z) {
            stopPlay();
        } else {
            aaw();
        }
    }

    protected Drawable getDrawable(int i) {
        SoftReference<Drawable> softReference = this.bLe.get(i);
        Drawable drawable = softReference != null ? softReference.get() : null;
        if (drawable == null) {
            try {
                Bitmap cQ = ar.cQ(i);
                if (cQ == null || cQ.isRecycled()) {
                    return null;
                }
                if (this.bLf == null) {
                    this.bLf = new BlurDrawable(getContext());
                }
                this.bLf.init(8, 12, cQ);
                if (this.bLf != null && this.bLf.drawBlur()) {
                    drawable = new BitmapDrawable(this.bLf.getBlurredBitmap());
                }
                if (drawable != null) {
                    this.bLe.put(i, new SoftReference<>(drawable));
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
        this.bKW = true;
        this.bKZ = false;
        this.bLa = false;
        this.bLd = new int[]{r.f.pic_video_bg01, r.f.pic_video_bg02, r.f.pic_video_bg03, r.f.pic_video_bg04};
        this.aUm = new ArrayList();
        this.bLe = new SparseArray<>();
        this.bLh = new j(this);
        this.aGT = new m(this);
        this.bKK = new n(this);
        this.bLi = new o(this);
        this.mRunnable = new p(this);
        this.aLF = new q(this);
        this.aLE = new r(this);
        this.bLj = new s(this);
        init(context);
    }

    public ForumHeadVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKW = true;
        this.bKZ = false;
        this.bLa = false;
        this.bLd = new int[]{r.f.pic_video_bg01, r.f.pic_video_bg02, r.f.pic_video_bg03, r.f.pic_video_bg04};
        this.aUm = new ArrayList();
        this.bLe = new SparseArray<>();
        this.bLh = new j(this);
        this.aGT = new m(this);
        this.bKK = new n(this);
        this.bLi = new o(this);
        this.mRunnable = new p(this);
        this.aLF = new q(this);
        this.aLE = new r(this);
        this.bLj = new s(this);
        init(context);
    }

    private void init(Context context) {
        this.aTE = com.baidu.adp.base.l.C(context);
        this.bKS = new e(this.aTE);
        this.bKS.a(this.bKK);
        setOnSizeChangeListener(this.aGT);
    }

    public void aat() {
        c currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
            bg threadInfo = currentVideoItemView.getThreadInfo();
            if (!u(threadInfo)) {
                TiebaStatic.log(new at("c11278").ab("tid", threadInfo.getTid()).ab("fid", String.valueOf(threadInfo.getFid())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(bg bgVar) {
        if (bgVar == null) {
            return true;
        }
        return bgVar.getFid() <= 0 || com.baidu.adp.lib.h.b.c(bgVar.getTid(), 0L) <= 0 || com.baidu.adp.lib.h.b.c(bgVar.getId(), 0L) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(bg bgVar) {
        if (bgVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(getContext()).createNormalCfg(String.valueOf(bgVar.getFid()), bgVar.getTid(), "headvideo")));
        }
    }

    public c getCurrentVideoItemView() {
        return hC(getChildCount() - 1);
    }

    public c getSwapVideoItemView() {
        return hC(getChildCount() - 2);
    }

    private c hC(int i) {
        if (i >= 0 && i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hD(int i) {
        BannerThreadInfoData bannerThreadInfoData;
        if (x.t(this.aUm)) {
            setVisibility(8);
            this.bKW = true;
            return;
        }
        BannerThreadInfoData bannerThreadInfoData2 = this.aUm.get(0);
        BannerThreadInfoData bannerThreadInfoData3 = this.aUm.size() >= 2 ? this.aUm.get(1) : bannerThreadInfoData2;
        if (this.aUm.size() < 3) {
            bannerThreadInfoData = null;
        } else {
            bannerThreadInfoData = this.aUm.get(2);
        }
        for (int i2 = 0; i2 < i; i2++) {
            c hC = hC(i2);
            if (hC == null) {
                hC = aax();
                a(hC, i2, i);
                addView(hC, i2);
            }
            if (i2 == i - 1) {
                hC.a(bannerThreadInfoData2);
                hC.aam();
            } else if (i2 == i - 2) {
                hC.a(bannerThreadInfoData3);
                hC.aam();
            } else if (i == 5 && i2 == i - 3) {
                hC.a(bannerThreadInfoData3);
                hC.aam();
            } else if (bannerThreadInfoData != null) {
                hC.a(bannerThreadInfoData);
            } else {
                hC.a(bannerThreadInfoData3);
            }
            f(hC, i2, i);
            hC.setVideoBlurViewBackgroundDrawable(getDrawable(hC.getBgResId()));
            hC.setVideoBlurViewMaskColor(r.d.cp_bg_line_d_alpha90);
            f(hC);
            hC.setVisibility(0);
        }
        onChangeSkinType(this.aTE, TbadkCoreApplication.m9getInst().getSkinType());
        setVisibility(0);
        aau();
    }

    private void a(c cVar, int i, int i2) {
        if (cVar != null && this.bLd != null) {
            int length = (this.bLd.length - ag(i, i2)) - 1;
            if (length < 0) {
                length = 0;
            } else if (length > this.bLd.length - 1) {
                length = this.bLd.length - 1;
            }
            int i3 = this.bLd[length];
            cVar.setVideoBlurViewBackgroundResId(i3);
            cVar.setVideoBlurViewBackgroundDrawable(getDrawable(i3));
        }
    }

    public void setWithSign(boolean z) {
        this.bLg = z;
    }

    public void a(long j, List<BannerThreadInfoData> list, b bVar) {
        if (this.bLg) {
            this.bLg = false;
            return;
        }
        this.bKS.reset();
        if (list == null || j < 0) {
            setVisibility(8);
            this.bKW = true;
            return;
        }
        this.byB = bVar;
        this.bKX = j;
        this.aUm.clear();
        int min = Math.min(list.size(), 5);
        this.aUm.addAll(list.subList(0, min));
        this.bKY = at(this.aUm);
        if (min >= 5) {
            this.bKS.setHasMore(1);
        } else {
            this.bKS.setHasMore(0);
        }
        hD(min);
        if (this.bLc == null) {
            this.bLc = new g(getContext(), this, this.bLh);
        }
    }

    private void aau() {
        c currentVideoItemView;
        if ((this.byB == null || !this.byB.aal()) && (currentVideoItemView = getCurrentVideoItemView()) != null && this.byB != null) {
            if (aav()) {
                e(currentVideoItemView);
            } else if (a.aah() == 1) {
                aaC();
            }
        }
    }

    private boolean aav() {
        int aah = a.aah();
        if ((this.byB == null || !this.byB.aak()) && aah != 0) {
            return aah == 1 && getChildCount() == 1;
        }
        return true;
    }

    public void e(c cVar) {
        if (cVar != null && !this.bLa && w.fn(5)) {
            if (StringUtils.isNull(cVar.getVideoUrl())) {
                cVar.stopPlayback();
                cVar.setVideoPlayState(4);
            } else if (!cVar.isPlaying()) {
                cVar.startPlay();
            }
        }
    }

    public void aaw() {
        if (this.byB != null && !this.byB.aal()) {
            e(getCurrentVideoItemView());
        }
    }

    public void f(c cVar) {
        if (cVar != null) {
            cVar.stopPlayback();
        }
    }

    private long at(List<BannerThreadInfoData> list) {
        if (x.t(list)) {
            return 0L;
        }
        for (BannerThreadInfoData bannerThreadInfoData : list) {
            if (bannerThreadInfoData != null && bannerThreadInfoData.threadData != null && bannerThreadInfoData.from == 1) {
                return com.baidu.adp.lib.h.b.c(bannerThreadInfoData.threadData.getTid(), 0L);
            }
        }
        return 0L;
    }

    private int ag(int i, int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 > 4 && i >= 3) {
            return i - 1;
        }
        return i;
    }

    private int ah(int i, int i2) {
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
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds500);
            int I = com.baidu.adp.lib.util.k.I(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(I - (ah(i, i2) * 15), e - (ag(i, i2) * 10));
            layoutParams.addRule(14, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    private c aax() {
        c cVar = new c(getContext());
        cVar.setVideoBlurViewMaskColor(r.d.cp_bg_line_d_alpha80);
        cVar.setVisibility(8);
        cVar.a(this.aLF, this.aLE, this.bLj);
        return cVar;
    }

    public void aay() {
        String string;
        if (this.bKW) {
            if (x.s(this.aUm) > 1) {
                g(getCurrentVideoItemView());
            } else {
                if (hasMore()) {
                    if (!com.baidu.adp.lib.util.i.gm()) {
                        string = getContext().getString(r.j.frs_head_video_slide_no_network);
                    } else {
                        string = getContext().getString(r.j.frs_head_video_slide_data_loading);
                    }
                } else if (getChildCount() == 1) {
                    string = getContext().getString(r.j.frs_head_video_no_more_data);
                } else {
                    string = getContext().getString(r.j.frs_head_video_no_more_data_1);
                }
                if (!TextUtils.isEmpty(string)) {
                    this.bLb = BdToast.b(getContext(), string, r.f.icon_toast_game_error).tj();
                }
            }
            IV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IV() {
        if (hasMore() && x.s(this.aUm) <= 3) {
            this.bKS.i(this.bKX, this.bKY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        return this.bKS != null && this.bKS.hasMore();
    }

    private void g(c cVar) {
        if (this.bKW && cVar != null) {
            if (this.bKT == null) {
                aaz();
            }
            cVar.setVisibility(8);
            cVar.startAnimation(this.bKT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(c cVar) {
        if (cVar != null) {
            if (this.bKU == null) {
                aaA();
            }
            cVar.setVisibility(0);
            cVar.startAnimation(this.bKU);
        }
    }

    private void aaz() {
        this.bKT = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_slide_out);
        this.bKT.setAnimationListener(new t(this));
    }

    private void aaA() {
        this.bKU = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_slide_up);
        this.bKU.setAnimationListener(new k(this));
    }

    private void aaB() {
        this.bKV = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_jump_up);
        this.bKV.setAnimationListener(new l(this));
    }

    private void aaC() {
        if (this.bKW) {
            if (this.bKV == null) {
                aaB();
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.bLi, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaD() {
        if (getChildCount() > 4) {
            c hC = hC(2);
            c hC2 = hC(3);
            if (hC != null && hC2 != null) {
                int bgResId = hC.getBgResId();
                hC2.setVideoBlurViewBackgroundResId(bgResId);
                hC2.setVideoBlurViewBackgroundDrawable(getDrawable(bgResId));
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c hC = hC(i2);
            if (hC != null) {
                hC.onChangeSkinType(hVar, i);
            }
        }
    }

    public void onDestory() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c hC = hC(i);
            if (hC != null) {
                hC.onDestory();
            }
        }
        if (this.bLb != null) {
            this.bLb.cancel();
        }
        if (this.bLe != null) {
            this.bLe.clear();
        }
        if (this.bLf != null) {
            this.bLf.onDestroy();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.mRunnable);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bLi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(bg bgVar) {
        if (bgVar != null && bgVar.rW() != null && !u(bgVar)) {
            z.a(bgVar.rW().video_md5, bgVar.getTid(), String.valueOf(bgVar.getFid()), "headvideo", "", "", "1");
        }
    }

    @Override // com.baidu.tieba.play.s
    public boolean isPlayStarted() {
        return this.bKZ;
    }

    @Override // com.baidu.tieba.play.s
    public boolean isPlaying() {
        if (getCurrentVideoItemView() == null) {
            return false;
        }
        return getCurrentVideoItemView().isPlaying();
    }

    @Override // com.baidu.tieba.play.s
    public void startPlay() {
        if (!this.bKZ) {
            this.bKZ = true;
            if (aav()) {
                aaw();
            }
        }
    }

    @Override // com.baidu.tieba.play.s
    public void stopPlay() {
        this.bKZ = false;
        f(getCurrentVideoItemView());
    }

    @Override // com.baidu.tieba.play.s
    public View getVideoContainer() {
        if (getCurrentVideoItemView() == null) {
            return null;
        }
        return getCurrentVideoItemView().getVideoContainer();
    }

    @Override // com.baidu.tieba.play.s
    public String getPlayUrl() {
        return null;
    }

    @Override // com.baidu.tieba.play.s
    public int getCurrentPosition() {
        return 0;
    }
}
