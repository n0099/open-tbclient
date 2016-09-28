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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.headvideo.g;
import com.baidu.tieba.frs.headvideo.w;
import com.baidu.tieba.play.e;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ForumHeadVideoView extends com.baidu.tbadk.widget.layout.g implements com.baidu.tieba.play.d {
    private final com.baidu.tbadk.widget.layout.i aGJ;
    private e.a aLq;
    private e.d aLr;
    private final List<BannerThreadInfoData> aSU;
    private com.baidu.adp.base.h<?> aSm;
    private c bPz;
    private final g.a cbF;
    private g cbN;
    private Animation cbO;
    private Animation cbP;
    private Animation cbQ;
    private boolean cbR;
    private long cbS;
    private long cbT;
    private boolean cbU;
    private boolean cbV;
    private BdToast cbW;
    private i cbX;
    private int[] cbY;
    private final SparseArray<SoftReference<Drawable>> cbZ;
    private BlurDrawable cca;
    private boolean ccb;
    private w.a ccc;
    final Runnable ccd;
    private e.b cce;
    final Runnable mRunnable;

    public void setDoingPullRefresh(boolean z) {
        this.cbV = z;
        if (z) {
            stopPlay();
        } else {
            aeI();
        }
    }

    protected Drawable getDrawable(int i) {
        SoftReference<Drawable> softReference = this.cbZ.get(i);
        Drawable drawable = softReference != null ? softReference.get() : null;
        if (drawable == null) {
            try {
                Bitmap cN = av.cN(i);
                if (cN == null || cN.isRecycled()) {
                    return null;
                }
                if (this.cca == null) {
                    this.cca = new BlurDrawable(getContext());
                }
                this.cca.init(8, 12, cN);
                if (this.cca != null && this.cca.drawBlur()) {
                    drawable = new BitmapDrawable(this.cca.getBlurredBitmap());
                }
                if (drawable != null) {
                    this.cbZ.put(i, new SoftReference<>(drawable));
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
        this.cbR = true;
        this.cbU = false;
        this.cbV = false;
        this.cbY = new int[]{r.f.pic_video_bg01, r.f.pic_video_bg02, r.f.pic_video_bg03, r.f.pic_video_bg04};
        this.aSU = new ArrayList();
        this.cbZ = new SparseArray<>();
        this.ccc = new l(this);
        this.aGJ = new o(this);
        this.cbF = new p(this);
        this.ccd = new q(this);
        this.mRunnable = new r(this);
        this.aLr = new s(this);
        this.aLq = new t(this);
        this.cce = new u(this);
        init(context);
    }

    public ForumHeadVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbR = true;
        this.cbU = false;
        this.cbV = false;
        this.cbY = new int[]{r.f.pic_video_bg01, r.f.pic_video_bg02, r.f.pic_video_bg03, r.f.pic_video_bg04};
        this.aSU = new ArrayList();
        this.cbZ = new SparseArray<>();
        this.ccc = new l(this);
        this.aGJ = new o(this);
        this.cbF = new p(this);
        this.ccd = new q(this);
        this.mRunnable = new r(this);
        this.aLr = new s(this);
        this.aLq = new t(this);
        this.cce = new u(this);
        init(context);
    }

    private void init(Context context) {
        this.aSm = com.baidu.adp.base.l.C(context);
        this.cbN = new g(this.aSm);
        this.cbN.a(this.cbF);
        setOnSizeChangeListener(this.aGJ);
    }

    public void aeF() {
        e currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
            bi threadInfo = currentVideoItemView.getThreadInfo();
            if (!o(threadInfo)) {
                TiebaStatic.log(new ax("c11278").ab("tid", threadInfo.getTid()).ab("fid", String.valueOf(threadInfo.getFid())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(bi biVar) {
        if (biVar == null) {
            return true;
        }
        return biVar.getFid() <= 0 || com.baidu.adp.lib.h.b.c(biVar.getTid(), 0L) <= 0 || com.baidu.adp.lib.h.b.c(biVar.getId(), 0L) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(bi biVar) {
        if (biVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(getContext()).createNormalCfg(String.valueOf(biVar.getFid()), biVar.getTid(), "headvideo")));
        }
    }

    public e getCurrentVideoItemView() {
        return ir(getChildCount() - 1);
    }

    public e getSwapVideoItemView() {
        return ir(getChildCount() - 2);
    }

    private e ir(int i) {
        if (i >= 0 && i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt instanceof e) {
                return (e) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void is(int i) {
        BannerThreadInfoData bannerThreadInfoData;
        if (y.t(this.aSU)) {
            setVisibility(8);
            this.cbR = true;
            return;
        }
        BannerThreadInfoData bannerThreadInfoData2 = this.aSU.get(0);
        BannerThreadInfoData bannerThreadInfoData3 = this.aSU.size() >= 2 ? this.aSU.get(1) : bannerThreadInfoData2;
        if (this.aSU.size() < 3) {
            bannerThreadInfoData = null;
        } else {
            bannerThreadInfoData = this.aSU.get(2);
        }
        for (int i2 = 0; i2 < i; i2++) {
            e ir = ir(i2);
            if (ir == null) {
                ir = aeJ();
                a(ir, i2, i);
                addView(ir, i2);
            }
            if (i2 == i - 1) {
                ir.a(bannerThreadInfoData2);
                ir.aez();
            } else if (i2 == i - 2) {
                ir.a(bannerThreadInfoData3);
                ir.aez();
            } else if (i == 5 && i2 == i - 3) {
                ir.a(bannerThreadInfoData3);
                ir.aez();
            } else if (bannerThreadInfoData != null) {
                ir.a(bannerThreadInfoData);
            } else {
                ir.a(bannerThreadInfoData3);
            }
            g(ir, i2, i);
            ir.setVideoBlurViewBackgroundDrawable(getDrawable(ir.getBgResId()));
            ir.setVideoBlurViewMaskColor(r.d.cp_bg_line_d_alpha90);
            f(ir);
            ir.setVisibility(0);
        }
        onChangeSkinType(this.aSm, TbadkCoreApplication.m9getInst().getSkinType());
        setVisibility(0);
        aeG();
    }

    private void a(e eVar, int i, int i2) {
        if (eVar != null && this.cbY != null) {
            int length = (this.cbY.length - ak(i, i2)) - 1;
            if (length < 0) {
                length = 0;
            } else if (length > this.cbY.length - 1) {
                length = this.cbY.length - 1;
            }
            int i3 = this.cbY[length];
            eVar.setVideoBlurViewBackgroundResId(i3);
            eVar.setVideoBlurViewBackgroundDrawable(getDrawable(i3));
        }
    }

    public void setWithSign(boolean z) {
        this.ccb = z;
    }

    public void a(long j, List<BannerThreadInfoData> list, c cVar) {
        if (this.ccb) {
            this.ccb = false;
            return;
        }
        this.cbN.reset();
        if (list == null || j < 0) {
            setVisibility(8);
            this.cbR = true;
            return;
        }
        this.bPz = cVar;
        this.cbS = j;
        this.aSU.clear();
        int min = Math.min(list.size(), 5);
        this.aSU.addAll(list.subList(0, min));
        this.cbT = aA(this.aSU);
        if (min >= 5) {
            this.cbN.setHasMore(1);
        } else {
            this.cbN.setHasMore(0);
        }
        is(min);
        if (this.cbX == null) {
            this.cbX = new i(getContext(), this, this.ccc);
        }
    }

    private void aeG() {
        e currentVideoItemView;
        if ((this.bPz == null || !this.bPz.aey()) && (currentVideoItemView = getCurrentVideoItemView()) != null && this.bPz != null) {
            if (aeH()) {
                e(currentVideoItemView);
                return;
            }
            int aer = a.aer();
            if (aer == 2) {
                this.bPz.aew();
                this.bPz.ee(true);
            } else if (aer == 1) {
                aeO();
            }
        }
    }

    private boolean aeH() {
        int aer = a.aer();
        if ((this.bPz == null || !this.bPz.aeu()) && aer != 0) {
            return aer == 1 && getChildCount() == 1;
        }
        return true;
    }

    public void e(e eVar) {
        if (eVar != null && !this.cbV && x.fk(5)) {
            if (StringUtils.isNull(eVar.getVideoUrl())) {
                eVar.stopPlayback();
                eVar.setVideoPlayState(4);
            } else if (!eVar.isPlaying()) {
                eVar.Js();
            }
        }
    }

    public void aeI() {
        if (this.bPz != null && !this.bPz.aey()) {
            e(getCurrentVideoItemView());
        }
    }

    public void f(e eVar) {
        if (eVar != null) {
            eVar.stopPlayback();
        }
    }

    private long aA(List<BannerThreadInfoData> list) {
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

    private int ak(int i, int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 > 4 && i >= 3) {
            return i - 1;
        }
        return i;
    }

    private int al(int i, int i2) {
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
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds500);
            int K = com.baidu.adp.lib.util.k.K(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(K - (al(i, i2) * 15), e - (ak(i, i2) * 10));
            layoutParams.addRule(14, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    private e aeJ() {
        e eVar = new e(getContext());
        eVar.setVideoBlurViewMaskColor(r.d.cp_bg_line_d_alpha80);
        eVar.setVisibility(8);
        eVar.a(this.aLr, this.aLq, this.cce);
        return eVar;
    }

    public void aeK() {
        String string;
        if (this.cbR) {
            if (y.s(this.aSU) > 1) {
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
                    this.cbW = BdToast.b(getContext(), string, r.f.icon_toast_game_error).tu();
                }
            }
            Jp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        if (hasMore() && y.s(this.aSU) <= 3) {
            this.cbN.j(this.cbS, this.cbT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        return this.cbN != null && this.cbN.hasMore();
    }

    private void g(e eVar) {
        if (this.cbR && eVar != null) {
            if (this.cbO == null) {
                aeL();
            }
            eVar.setVisibility(8);
            eVar.startAnimation(this.cbO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(e eVar) {
        if (eVar != null) {
            if (this.cbP == null) {
                aeM();
            }
            eVar.setVisibility(0);
            eVar.startAnimation(this.cbP);
        }
    }

    private void aeL() {
        this.cbO = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_slide_out);
        this.cbO.setAnimationListener(new v(this));
    }

    private void aeM() {
        this.cbP = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_slide_up);
        this.cbP.setAnimationListener(new m(this));
    }

    private void aeN() {
        this.cbQ = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_jump_up);
        this.cbQ.setAnimationListener(new n(this));
    }

    private void aeO() {
        if (this.cbR) {
            if (this.cbQ == null) {
                aeN();
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.ccd, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeP() {
        if (getChildCount() > 4) {
            e ir = ir(2);
            e ir2 = ir(3);
            if (ir != null && ir2 != null) {
                int bgResId = ir.getBgResId();
                ir2.setVideoBlurViewBackgroundResId(bgResId);
                ir2.setVideoBlurViewBackgroundDrawable(getDrawable(bgResId));
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            e ir = ir(i2);
            if (ir != null) {
                ir.onChangeSkinType(hVar, i);
            }
        }
    }

    public void onDestory() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            e ir = ir(i);
            if (ir != null) {
                ir.onDestory();
            }
        }
        if (this.cbW != null) {
            this.cbW.cancel();
        }
        if (this.cbZ != null) {
            this.cbZ.clear();
        }
        if (this.cca != null) {
            this.cca.onDestroy();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.mRunnable);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ccd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(bi biVar) {
        if (biVar != null && biVar.sd() != null && !o(biVar)) {
            com.baidu.tieba.play.j.a(biVar.sd().video_md5, biVar.getTid(), String.valueOf(biVar.getFid()), "headvideo", "", "", "1");
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean Jr() {
        return this.cbU;
    }

    @Override // com.baidu.tieba.play.d
    public boolean isPlaying() {
        if (getCurrentVideoItemView() == null) {
            return false;
        }
        return getCurrentVideoItemView().isPlaying();
    }

    @Override // com.baidu.tieba.play.d
    public void Js() {
        if (!this.cbU) {
            this.cbU = true;
            if (aeH()) {
                aeI();
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void stopPlay() {
        this.cbU = false;
        f(getCurrentVideoItemView());
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
