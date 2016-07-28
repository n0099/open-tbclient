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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.headvideo.g;
import com.baidu.tieba.frs.headvideo.w;
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ForumHeadVideoView extends com.baidu.tbadk.widget.layout.g implements com.baidu.tieba.play.d {
    private final com.baidu.tbadk.widget.layout.i aEa;
    private com.baidu.adp.base.h<?> aLK;
    private final List<BannerThreadInfoData> aMv;
    private MediaPlayer.OnCompletionListener adO;
    private MediaPlayer.OnPreparedListener adP;
    private c bEd;
    private g bQD;
    private Animation bQE;
    private Animation bQF;
    private Animation bQG;
    private boolean bQH;
    private long bQI;
    private long bQJ;
    private boolean bQK;
    private boolean bQL;
    private BdToast bQM;
    private i bQN;
    private int[] bQO;
    private final SparseArray<SoftReference<Drawable>> bQP;
    private BlurDrawable bQQ;
    private w.a bQR;
    final Runnable bQS;
    private MediaPlayer.OnErrorListener bQT;
    private final g.a bQv;
    final Runnable mRunnable;

    public void setDoingPullRefresh(boolean z) {
        this.bQL = z;
        if (z) {
            stopPlay();
        } else {
            ZJ();
        }
    }

    protected Drawable getDrawable(int i) {
        SoftReference<Drawable> softReference = this.bQP.get(i);
        Drawable drawable = softReference != null ? softReference.get() : null;
        if (drawable == null) {
            Bitmap cA = av.cA(i);
            if (cA == null || cA.isRecycled()) {
                return null;
            }
            if (this.bQQ == null) {
                this.bQQ = new BlurDrawable(getContext());
            }
            this.bQQ.init(8, 12, cA);
            if (this.bQQ != null && this.bQQ.drawBlur()) {
                drawable = new BitmapDrawable(this.bQQ.getBlurredBitmap());
            }
            if (drawable != null) {
                this.bQP.put(i, new SoftReference<>(drawable));
                return drawable;
            }
            return drawable;
        }
        return drawable;
    }

    public ForumHeadVideoView(Context context) {
        super(context);
        this.bQH = true;
        this.bQK = false;
        this.bQL = false;
        this.bQO = new int[]{u.f.pic_video_bg01, u.f.pic_video_bg02, u.f.pic_video_bg03, u.f.pic_video_bg04};
        this.aMv = new ArrayList();
        this.bQP = new SparseArray<>();
        this.bQR = new l(this);
        this.aEa = new o(this);
        this.bQv = new p(this);
        this.bQS = new q(this);
        this.mRunnable = new r(this);
        this.adP = new s(this);
        this.adO = new t(this);
        this.bQT = new u(this);
        init(context);
    }

    public ForumHeadVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQH = true;
        this.bQK = false;
        this.bQL = false;
        this.bQO = new int[]{u.f.pic_video_bg01, u.f.pic_video_bg02, u.f.pic_video_bg03, u.f.pic_video_bg04};
        this.aMv = new ArrayList();
        this.bQP = new SparseArray<>();
        this.bQR = new l(this);
        this.aEa = new o(this);
        this.bQv = new p(this);
        this.bQS = new q(this);
        this.mRunnable = new r(this);
        this.adP = new s(this);
        this.adO = new t(this);
        this.bQT = new u(this);
        init(context);
    }

    private void init(Context context) {
        this.aLK = com.baidu.adp.base.l.s(context);
        this.bQD = new g(this.aLK);
        this.bQD.a(this.bQv);
        setOnSizeChangeListener(this.aEa);
    }

    public void ZG() {
        e currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
            be threadInfo = currentVideoItemView.getThreadInfo();
            if (!n(threadInfo)) {
                TiebaStatic.log(new ay("c11278").ab("tid", threadInfo.getTid()).ab("fid", String.valueOf(threadInfo.getFid())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(be beVar) {
        if (beVar == null) {
            return true;
        }
        return beVar.getFid() <= 0 || com.baidu.adp.lib.h.b.c(beVar.getTid(), 0L) <= 0 || com.baidu.adp.lib.h.b.c(beVar.getId(), 0L) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(be beVar) {
        if (beVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(getContext()).createNormalCfg(String.valueOf(beVar.getFid()), beVar.getTid(), VideoListActivityConfig.KEY_SOURCE_FRS_HEAD)));
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
        if (y.t(this.aMv)) {
            setVisibility(8);
            this.bQH = true;
            return;
        }
        BannerThreadInfoData bannerThreadInfoData2 = this.aMv.get(0);
        BannerThreadInfoData bannerThreadInfoData3 = this.aMv.size() >= 2 ? this.aMv.get(1) : bannerThreadInfoData2;
        if (this.aMv.size() < 3) {
            bannerThreadInfoData = null;
        } else {
            bannerThreadInfoData = this.aMv.get(2);
        }
        for (int i2 = 0; i2 < i; i2++) {
            e hJ = hJ(i2);
            if (hJ == null) {
                hJ = ZK();
                a(hJ, i2, i);
                addView(hJ, i2);
            }
            if (i2 == i - 1) {
                hJ.a(bannerThreadInfoData2);
                hJ.Zy();
            } else if (i2 == i - 2) {
                hJ.a(bannerThreadInfoData3);
                hJ.Zy();
            } else if (i == 5 && i2 == i - 3) {
                hJ.a(bannerThreadInfoData3);
                hJ.Zy();
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
        onChangeSkinType(this.aLK, TbadkCoreApplication.m10getInst().getSkinType());
        setVisibility(0);
        ZH();
    }

    private void a(e eVar, int i, int i2) {
        if (eVar != null && this.bQO != null) {
            int length = (this.bQO.length - ae(i, i2)) - 1;
            if (length < 0) {
                length = 0;
            } else if (length > this.bQO.length - 1) {
                length = this.bQO.length - 1;
            }
            int i3 = this.bQO[length];
            eVar.setVideoBlurViewBackgroundResId(i3);
            eVar.setVideoBlurViewBackgroundDrawable(getDrawable(i3));
        }
    }

    public void a(long j, List<BannerThreadInfoData> list, c cVar) {
        this.bQD.reset();
        if (list == null || j < 0) {
            setVisibility(8);
            this.bQH = true;
            return;
        }
        this.bEd = cVar;
        this.bQI = j;
        this.aMv.clear();
        int min = Math.min(list.size(), 5);
        this.aMv.addAll(list.subList(0, min));
        this.bQJ = ay(this.aMv);
        if (min >= 5) {
            this.bQD.setHasMore(1);
        } else {
            this.bQD.setHasMore(0);
        }
        hK(min);
        if (this.bQN == null) {
            this.bQN = new i(getContext(), this, this.bQR);
        }
    }

    private void ZH() {
        e currentVideoItemView;
        if ((this.bEd == null || !this.bEd.Zx()) && (currentVideoItemView = getCurrentVideoItemView()) != null && this.bEd != null) {
            if (ZI()) {
                d(currentVideoItemView);
                return;
            }
            int Zq = a.Zq();
            if (Zq == 2) {
                this.bEd.Zv();
                this.bEd.dH(true);
            } else if (Zq == 1) {
                ZQ();
            }
        }
    }

    private boolean ZI() {
        int Zq = a.Zq();
        if ((this.bEd == null || !this.bEd.Zt()) && Zq != 0) {
            return Zq == 1 && getChildCount() == 1;
        }
        return true;
    }

    public void d(e eVar) {
        if (eVar != null && !this.bQL && x.eX(5)) {
            if (StringUtils.isNull(eVar.getVideoUrl())) {
                eVar.stopPlayback();
                eVar.setVideoPlayState(4);
            } else if (!eVar.isPlaying()) {
                eVar.Iz();
            }
        }
    }

    public void ZJ() {
        if (this.bEd != null && !this.bEd.Zx()) {
            d(getCurrentVideoItemView());
        }
    }

    public void e(e eVar) {
        if (eVar != null) {
            eVar.stopPlayback();
        }
    }

    private long ay(List<BannerThreadInfoData> list) {
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

    private int ae(int i, int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 > 4 && i >= 3) {
            return i - 1;
        }
        return i;
    }

    private int af(int i, int i2) {
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
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A - (af(i, i2) * 15), c - (ae(i, i2) * 10));
            layoutParams.addRule(14, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    private e ZK() {
        e eVar = new e(getContext());
        eVar.setVideoBlurViewMaskColor(u.d.cp_bg_line_d_alpha80);
        eVar.setVisibility(8);
        eVar.a(this.adP, this.adO, this.bQT);
        return eVar;
    }

    public void ZL() {
        String string;
        if (this.bQH) {
            if (y.s(this.aMv) > 1) {
                f(getCurrentVideoItemView());
            } else {
                if (hasMore()) {
                    if (!com.baidu.adp.lib.util.i.fq()) {
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
                    this.bQM = BdToast.b(getContext(), string, u.f.icon_toast_game_error).sa();
                }
            }
            ZM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZM() {
        if (hasMore() && y.s(this.aMv) <= 3) {
            this.bQD.c(this.bQI, this.bQJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        return this.bQD != null && this.bQD.hasMore();
    }

    private void f(e eVar) {
        if (this.bQH && eVar != null) {
            if (this.bQE == null) {
                ZN();
            }
            eVar.setVisibility(8);
            eVar.startAnimation(this.bQE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(e eVar) {
        if (eVar != null) {
            if (this.bQF == null) {
                ZO();
            }
            eVar.setVisibility(0);
            eVar.startAnimation(this.bQF);
        }
    }

    private void ZN() {
        this.bQE = AnimationUtils.loadAnimation(getContext(), u.a.frs_head_video_slide_out);
        this.bQE.setAnimationListener(new v(this));
    }

    private void ZO() {
        this.bQF = AnimationUtils.loadAnimation(getContext(), u.a.frs_head_video_slide_up);
        this.bQF.setAnimationListener(new m(this));
    }

    private void ZP() {
        this.bQG = AnimationUtils.loadAnimation(getContext(), u.a.frs_head_video_jump_up);
        this.bQG.setAnimationListener(new n(this));
    }

    private void ZQ() {
        if (this.bQH) {
            if (this.bQG == null) {
                ZP();
            }
            com.baidu.adp.lib.h.h.dL().postDelayed(this.bQS, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZR() {
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
        if (this.bQM != null) {
            this.bQM.cancel();
        }
        if (this.bQP != null) {
            this.bQP.clear();
        }
        if (this.bQQ != null) {
            this.bQQ.onDestroy();
        }
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.mRunnable);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.bQS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(be beVar) {
        if (beVar != null && beVar.qM() != null && !n(beVar)) {
            com.baidu.tieba.play.e.k(beVar.qM().video_md5, beVar.getTid(), String.valueOf(beVar.getFid()), VideoListActivityConfig.KEY_SOURCE_FRS_HEAD);
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean IA() {
        return this.bQK;
    }

    @Override // com.baidu.tieba.play.d
    public boolean isPlaying() {
        if (getCurrentVideoItemView() == null) {
            return false;
        }
        return getCurrentVideoItemView().isPlaying();
    }

    @Override // com.baidu.tieba.play.d
    public void Iz() {
        if (!this.bQK) {
            this.bQK = true;
            if (ZI()) {
                ZJ();
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void stopPlay() {
        this.bQK = false;
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
