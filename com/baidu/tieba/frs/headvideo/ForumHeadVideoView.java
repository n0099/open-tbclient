package com.baidu.tieba.frs.headvideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.headvideo.g;
import com.baidu.tieba.frs.headvideo.w;
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ForumHeadVideoView extends com.baidu.tbadk.widget.layout.g implements com.baidu.tieba.play.d {
    private final com.baidu.tbadk.widget.layout.i aDj;
    private com.baidu.adp.base.h<?> aKR;
    private final List<BannerThreadInfoData> aLB;
    private MediaPlayer.OnCompletionListener ade;
    private MediaPlayer.OnPreparedListener adf;
    private c bCW;
    private final g.a bOJ;
    private g bOR;
    private Animation bOS;
    private Animation bOT;
    private Animation bOU;
    private boolean bOV;
    private long bOW;
    private boolean bOX;
    private boolean bOY;
    private BdToast bOZ;
    private i bPa;
    private int[] bPb;
    private final SparseArray<SoftReference<Drawable>> bPc;
    private BlurDrawable bPd;
    private w.a bPe;
    final Runnable bPf;
    private MediaPlayer.OnErrorListener bPg;
    private long mFid;
    final Runnable mRunnable;

    public void setDoingPullRefresh(boolean z) {
        this.bOY = z;
        if (z) {
            stopPlay();
        } else {
            Zn();
        }
    }

    protected Drawable getDrawable(int i) {
        SoftReference<Drawable> softReference = this.bPc.get(i);
        Drawable drawable = softReference != null ? softReference.get() : null;
        if (drawable == null) {
            Bitmap cA = av.cA(i);
            if (cA == null || cA.isRecycled()) {
                return null;
            }
            if (this.bPd == null) {
                this.bPd = new BlurDrawable(getContext());
            }
            this.bPd.init(8, 12, cA);
            if (this.bPd != null && this.bPd.drawBlur()) {
                drawable = new BitmapDrawable(this.bPd.getBlurredBitmap());
            }
            if (drawable != null) {
                this.bPc.put(i, new SoftReference<>(drawable));
                return drawable;
            }
            return drawable;
        }
        return drawable;
    }

    public ForumHeadVideoView(Context context) {
        super(context);
        this.bOV = true;
        this.bOX = false;
        this.bOY = false;
        this.bPb = new int[]{u.f.pic_video_bg01, u.f.pic_video_bg02, u.f.pic_video_bg03, u.f.pic_video_bg04};
        this.aLB = new ArrayList();
        this.bPc = new SparseArray<>();
        this.bPe = new l(this);
        this.aDj = new o(this);
        this.bOJ = new p(this);
        this.bPf = new q(this);
        this.mRunnable = new r(this);
        this.adf = new s(this);
        this.ade = new t(this);
        this.bPg = new u(this);
        init(context);
    }

    public ForumHeadVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOV = true;
        this.bOX = false;
        this.bOY = false;
        this.bPb = new int[]{u.f.pic_video_bg01, u.f.pic_video_bg02, u.f.pic_video_bg03, u.f.pic_video_bg04};
        this.aLB = new ArrayList();
        this.bPc = new SparseArray<>();
        this.bPe = new l(this);
        this.aDj = new o(this);
        this.bOJ = new p(this);
        this.bPf = new q(this);
        this.mRunnable = new r(this);
        this.adf = new s(this);
        this.ade = new t(this);
        this.bPg = new u(this);
        init(context);
    }

    private void init(Context context) {
        this.aKR = com.baidu.adp.base.l.s(context);
        this.bOR = new g(this.aKR);
        this.bOR.a(this.bOJ);
        setOnSizeChangeListener(this.aDj);
    }

    public void Zk() {
        e currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
            az threadInfo = currentVideoItemView.getThreadInfo();
            if (!l(threadInfo)) {
                TiebaStatic.log(new ay("c11278").ab("tid", threadInfo.getTid()).ab("fid", String.valueOf(threadInfo.getFid())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(az azVar) {
        if (azVar == null) {
            return true;
        }
        return azVar.getFid() <= 0 || com.baidu.adp.lib.h.b.c(azVar.getTid(), 0L) <= 0 || com.baidu.adp.lib.h.b.c(azVar.getId(), 0L) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(az azVar) {
        if (azVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(getContext()).createNormalCfg(String.valueOf(azVar.getFid()), azVar.getTid(), VideoListActivityConfig.KEY_SOURCE_FRS_HEAD)));
        }
    }

    public e getCurrentVideoItemView() {
        return hJ(getChildCount() - 1);
    }

    public e getSwapVideoItemView() {
        return hJ(getChildCount() - 2);
    }

    private e hJ(int i) {
        if (i >= 0 && i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt instanceof e) {
                return (e) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hK(int i) {
        BannerThreadInfoData bannerThreadInfoData;
        if (y.t(this.aLB)) {
            setVisibility(8);
            this.bOV = true;
            return;
        }
        BannerThreadInfoData bannerThreadInfoData2 = this.aLB.get(0);
        BannerThreadInfoData bannerThreadInfoData3 = this.aLB.size() >= 2 ? this.aLB.get(1) : bannerThreadInfoData2;
        if (this.aLB.size() < 3) {
            bannerThreadInfoData = null;
        } else {
            bannerThreadInfoData = this.aLB.get(2);
        }
        for (int i2 = 0; i2 < i; i2++) {
            e hJ = hJ(i2);
            if (hJ == null) {
                hJ = Zo();
                a(hJ, i2, i);
                addView(hJ, i2);
            }
            if (i2 == i - 1) {
                hJ.a(bannerThreadInfoData2);
                hJ.Zc();
            } else if (i2 == i - 2) {
                hJ.a(bannerThreadInfoData3);
                hJ.Zc();
            } else if (i == 5 && i2 == i - 3) {
                hJ.a(bannerThreadInfoData3);
                hJ.Zc();
            } else if (bannerThreadInfoData != null) {
                hJ.a(bannerThreadInfoData);
            } else {
                hJ.a(bannerThreadInfoData3);
            }
            g(hJ, i2, i);
            hJ.setVideoBlurViewBackgroundDrawable(getDrawable(hJ.getBgResId()));
            hJ.setVideoBlurViewMaskColor(u.d.cp_bg_line_d_alpha90);
            e(hJ);
            hJ.setVisibility(0);
        }
        onChangeSkinType(this.aKR, TbadkCoreApplication.m9getInst().getSkinType());
        setVisibility(0);
        Zl();
    }

    private void a(e eVar, int i, int i2) {
        if (eVar != null && this.bPb != null) {
            int length = (this.bPb.length - ad(i, i2)) - 1;
            if (length < 0) {
                length = 0;
            } else if (length > this.bPb.length - 1) {
                length = this.bPb.length - 1;
            }
            int i3 = this.bPb[length];
            eVar.setVideoBlurViewBackgroundResId(i3);
            eVar.setVideoBlurViewBackgroundDrawable(getDrawable(i3));
        }
    }

    public void a(long j, List<BannerThreadInfoData> list, c cVar) {
        this.bOR.reset();
        if (list == null || j < 0) {
            setVisibility(8);
            this.bOV = true;
            return;
        }
        this.bCW = cVar;
        this.mFid = j;
        this.aLB.clear();
        int min = Math.min(list.size(), 5);
        this.aLB.addAll(list.subList(0, min));
        this.bOW = au(this.aLB);
        if (min >= 5) {
            this.bOR.setHasMore(1);
        } else {
            this.bOR.setHasMore(0);
        }
        hK(min);
        if (this.bPa == null) {
            this.bPa = new i(getContext(), this, this.bPe);
        }
    }

    private void Zl() {
        e currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && this.bCW != null) {
            if (Zm()) {
                d(currentVideoItemView);
                return;
            }
            int YV = a.YV();
            if (YV == 2) {
                this.bCW.Za();
                this.bCW.dJ(true);
            } else if (YV == 1) {
                Zu();
            }
        }
    }

    private boolean Zm() {
        int YV = a.YV();
        if ((this.bCW == null || !this.bCW.YY()) && YV != 0) {
            return YV == 1 && getChildCount() == 1;
        }
        return true;
    }

    public void d(e eVar) {
        if (eVar != null && !this.bOY && com.baidu.tbadk.util.w.eX(5)) {
            if (StringUtils.isNull(eVar.getVideoUrl())) {
                eVar.stopPlayback();
                eVar.setVideoPlayState(4);
            } else if (!eVar.isPlaying()) {
                eVar.IA();
            }
        }
    }

    public void Zn() {
        d(getCurrentVideoItemView());
    }

    public void e(e eVar) {
        if (eVar != null) {
            eVar.stopPlayback();
        }
    }

    private long au(List<BannerThreadInfoData> list) {
        if (y.t(list)) {
            return 0L;
        }
        for (BannerThreadInfoData bannerThreadInfoData : list) {
            if (bannerThreadInfoData != null && bannerThreadInfoData.threadData != null && bannerThreadInfoData.from == 1) {
                return com.baidu.adp.lib.h.b.c(bannerThreadInfoData.threadData.getTid(), 0L);
            }
        }
        return 0L;
    }

    private int ad(int i, int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 > 4 && i >= 3) {
            return i - 1;
        }
        return i;
    }

    private int ae(int i, int i2) {
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
    public void g(View view, int i, int i2) {
        if (view != null && i2 > 0 && i >= 0) {
            int c = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds500);
            int A = com.baidu.adp.lib.util.k.A(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A - (ae(i, i2) * 15), c - (ad(i, i2) * 10));
            layoutParams.addRule(14, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    private e Zo() {
        e eVar = new e(getContext());
        eVar.setVideoBlurViewMaskColor(u.d.cp_bg_line_d_alpha80);
        eVar.setVisibility(8);
        eVar.a(this.adf, this.ade, this.bPg);
        return eVar;
    }

    public void Zp() {
        String string;
        if (this.bOV) {
            if (y.s(this.aLB) > 1) {
                f(getCurrentVideoItemView());
            } else {
                if (hasMore()) {
                    if (!com.baidu.adp.lib.util.i.fr()) {
                        string = getContext().getString(u.j.frs_head_video_slide_no_network);
                    } else {
                        string = getContext().getString(u.j.frs_head_video_slide_data_loading);
                    }
                } else if (getChildCount() == 1) {
                    string = getContext().getString(u.j.frs_head_video_no_more_data);
                } else {
                    string = getContext().getString(u.j.frs_head_video_no_more_data_1);
                }
                if (!TextUtils.isEmpty(string)) {
                    this.bOZ = BdToast.b(getContext(), string, u.f.icon_toast_game_error).sb();
                }
            }
            Zq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zq() {
        if (hasMore() && y.s(this.aLB) <= 3) {
            this.bOR.c(this.mFid, this.bOW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        return this.bOR != null && this.bOR.hasMore();
    }

    private void f(e eVar) {
        if (this.bOV && eVar != null) {
            if (this.bOS == null) {
                Zr();
            }
            eVar.setVisibility(8);
            eVar.startAnimation(this.bOS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(e eVar) {
        if (eVar != null) {
            if (this.bOT == null) {
                Zs();
            }
            eVar.setVisibility(0);
            eVar.startAnimation(this.bOT);
        }
    }

    private void Zr() {
        this.bOS = AnimationUtils.loadAnimation(getContext(), u.a.frs_head_video_slide_out);
        this.bOS.setAnimationListener(new v(this));
    }

    private void Zs() {
        this.bOT = AnimationUtils.loadAnimation(getContext(), u.a.frs_head_video_slide_up);
        this.bOT.setAnimationListener(new m(this));
    }

    private void Zt() {
        this.bOU = AnimationUtils.loadAnimation(getContext(), u.a.frs_head_video_jump_up);
        this.bOU.setAnimationListener(new n(this));
    }

    private void Zu() {
        if (this.bOV) {
            if (this.bOU == null) {
                Zt();
            }
            com.baidu.adp.lib.h.h.dM().postDelayed(this.bPf, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zv() {
        if (getChildCount() > 4) {
            e hJ = hJ(2);
            e hJ2 = hJ(3);
            if (hJ != null && hJ2 != null) {
                int bgResId = hJ.getBgResId();
                hJ2.setVideoBlurViewBackgroundResId(bgResId);
                hJ2.setVideoBlurViewBackgroundDrawable(getDrawable(bgResId));
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            e hJ = hJ(i2);
            if (hJ != null) {
                hJ.onChangeSkinType(hVar, i);
            }
        }
    }

    public void onDestory() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            e hJ = hJ(i);
            if (hJ != null) {
                hJ.onDestory();
            }
        }
        if (this.bOZ != null) {
            this.bOZ.cancel();
        }
        if (this.bPc != null) {
            this.bPc.clear();
        }
        if (this.bPd != null) {
            this.bPd.onDestroy();
        }
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.mRunnable);
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.bPf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(az azVar) {
        if (azVar != null && azVar.qW() != null && !l(azVar)) {
            com.baidu.tieba.play.e.k(azVar.qW().video_md5, azVar.getTid(), String.valueOf(azVar.getFid()), VideoListActivityConfig.KEY_SOURCE_FRS_HEAD);
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean IB() {
        return this.bOX;
    }

    @Override // com.baidu.tieba.play.d
    public boolean isPlaying() {
        if (getCurrentVideoItemView() == null) {
            return false;
        }
        return getCurrentVideoItemView().isPlaying();
    }

    @Override // com.baidu.tieba.play.d
    public void IA() {
        if (!this.bOX) {
            this.bOX = true;
            if (Zm()) {
                Zn();
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void stopPlay() {
        this.bOX = false;
        e(getCurrentVideoItemView());
    }

    @Override // com.baidu.tieba.play.d
    public View getVideoContainer() {
        if (getCurrentVideoItemView() == null) {
            return null;
        }
        return getCurrentVideoItemView().getVideoContainer();
    }

    @Override // com.baidu.tieba.play.d
    public String getPlayUrl() {
        return null;
    }

    @Override // com.baidu.tieba.play.d
    public int getCurrentPosition() {
        return 0;
    }
}
