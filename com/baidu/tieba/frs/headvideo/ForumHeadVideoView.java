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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
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
    private final com.baidu.tbadk.widget.layout.i aHz;
    private t.a aMn;
    private t.d aMo;
    private final List<BannerThreadInfoData> aUV;
    private com.baidu.adp.base.h<?> aUn;
    private b bSr;
    private t.b cfA;
    private final e.a cfb;
    private e cfj;
    private Animation cfk;
    private Animation cfl;
    private Animation cfm;
    private boolean cfn;
    private long cfo;
    private long cfp;
    private boolean cfq;
    private boolean cfr;
    private BdToast cfs;
    private g cft;
    private int[] cfu;
    private final SparseArray<SoftReference<Drawable>> cfv;
    private BlurDrawable cfw;
    private boolean cfx;
    private u.a cfy;
    final Runnable cfz;
    final Runnable mRunnable;

    public void setDoingPullRefresh(boolean z) {
        this.cfr = z;
        if (z) {
            stopPlay();
        } else {
            aga();
        }
    }

    protected Drawable getDrawable(int i) {
        SoftReference<Drawable> softReference = this.cfv.get(i);
        Drawable drawable = softReference != null ? softReference.get() : null;
        if (drawable == null) {
            try {
                Bitmap cO = at.cO(i);
                if (cO == null || cO.isRecycled()) {
                    return null;
                }
                if (this.cfw == null) {
                    this.cfw = new BlurDrawable(getContext());
                }
                this.cfw.init(8, 12, cO);
                if (this.cfw != null && this.cfw.drawBlur()) {
                    drawable = new BitmapDrawable(this.cfw.getBlurredBitmap());
                }
                if (drawable != null) {
                    this.cfv.put(i, new SoftReference<>(drawable));
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
        this.cfn = true;
        this.cfq = false;
        this.cfr = false;
        this.cfu = new int[]{r.f.pic_video_bg01, r.f.pic_video_bg02, r.f.pic_video_bg03, r.f.pic_video_bg04};
        this.aUV = new ArrayList();
        this.cfv = new SparseArray<>();
        this.cfy = new j(this);
        this.aHz = new m(this);
        this.cfb = new n(this);
        this.cfz = new o(this);
        this.mRunnable = new p(this);
        this.aMo = new q(this);
        this.aMn = new r(this);
        this.cfA = new s(this);
        init(context);
    }

    public ForumHeadVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cfn = true;
        this.cfq = false;
        this.cfr = false;
        this.cfu = new int[]{r.f.pic_video_bg01, r.f.pic_video_bg02, r.f.pic_video_bg03, r.f.pic_video_bg04};
        this.aUV = new ArrayList();
        this.cfv = new SparseArray<>();
        this.cfy = new j(this);
        this.aHz = new m(this);
        this.cfb = new n(this);
        this.cfz = new o(this);
        this.mRunnable = new p(this);
        this.aMo = new q(this);
        this.aMn = new r(this);
        this.cfA = new s(this);
        init(context);
    }

    private void init(Context context) {
        this.aUn = com.baidu.adp.base.l.C(context);
        this.cfj = new e(this.aUn);
        this.cfj.a(this.cfb);
        setOnSizeChangeListener(this.aHz);
    }

    public void afX() {
        c currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
            bk threadInfo = currentVideoItemView.getThreadInfo();
            if (!p(threadInfo)) {
                TiebaStatic.log(new av("c11278").ab("tid", threadInfo.getTid()).ab("fid", String.valueOf(threadInfo.getFid())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(bk bkVar) {
        if (bkVar == null) {
            return true;
        }
        return bkVar.getFid() <= 0 || com.baidu.adp.lib.h.b.c(bkVar.getTid(), 0L) <= 0 || com.baidu.adp.lib.h.b.c(bkVar.getId(), 0L) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(bk bkVar) {
        if (bkVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(getContext()).createNormalCfg(String.valueOf(bkVar.getFid()), bkVar.getTid(), "headvideo")));
        }
    }

    public c getCurrentVideoItemView() {
        return is(getChildCount() - 1);
    }

    public c getSwapVideoItemView() {
        return is(getChildCount() - 2);
    }

    private c is(int i) {
        if (i >= 0 && i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void it(int i) {
        BannerThreadInfoData bannerThreadInfoData;
        if (x.t(this.aUV)) {
            setVisibility(8);
            this.cfn = true;
            return;
        }
        BannerThreadInfoData bannerThreadInfoData2 = this.aUV.get(0);
        BannerThreadInfoData bannerThreadInfoData3 = this.aUV.size() >= 2 ? this.aUV.get(1) : bannerThreadInfoData2;
        if (this.aUV.size() < 3) {
            bannerThreadInfoData = null;
        } else {
            bannerThreadInfoData = this.aUV.get(2);
        }
        for (int i2 = 0; i2 < i; i2++) {
            c is = is(i2);
            if (is == null) {
                is = agb();
                a(is, i2, i);
                addView(is, i2);
            }
            if (i2 == i - 1) {
                is.a(bannerThreadInfoData2);
                is.afQ();
            } else if (i2 == i - 2) {
                is.a(bannerThreadInfoData3);
                is.afQ();
            } else if (i == 5 && i2 == i - 3) {
                is.a(bannerThreadInfoData3);
                is.afQ();
            } else if (bannerThreadInfoData != null) {
                is.a(bannerThreadInfoData);
            } else {
                is.a(bannerThreadInfoData3);
            }
            g(is, i2, i);
            is.setVideoBlurViewBackgroundDrawable(getDrawable(is.getBgResId()));
            is.setVideoBlurViewMaskColor(r.d.cp_bg_line_d_alpha90);
            f(is);
            is.setVisibility(0);
        }
        onChangeSkinType(this.aUn, TbadkCoreApplication.m9getInst().getSkinType());
        setVisibility(0);
        afY();
    }

    private void a(c cVar, int i, int i2) {
        if (cVar != null && this.cfu != null) {
            int length = (this.cfu.length - al(i, i2)) - 1;
            if (length < 0) {
                length = 0;
            } else if (length > this.cfu.length - 1) {
                length = this.cfu.length - 1;
            }
            int i3 = this.cfu[length];
            cVar.setVideoBlurViewBackgroundResId(i3);
            cVar.setVideoBlurViewBackgroundDrawable(getDrawable(i3));
        }
    }

    public void setWithSign(boolean z) {
        this.cfx = z;
    }

    public void a(long j, List<BannerThreadInfoData> list, b bVar) {
        if (this.cfx) {
            this.cfx = false;
            return;
        }
        this.cfj.reset();
        if (list == null || j < 0) {
            setVisibility(8);
            this.cfn = true;
            return;
        }
        this.bSr = bVar;
        this.cfo = j;
        this.aUV.clear();
        int min = Math.min(list.size(), 5);
        this.aUV.addAll(list.subList(0, min));
        this.cfp = aB(this.aUV);
        if (min >= 5) {
            this.cfj.setHasMore(1);
        } else {
            this.cfj.setHasMore(0);
        }
        it(min);
        if (this.cft == null) {
            this.cft = new g(getContext(), this, this.cfy);
        }
    }

    private void afY() {
        c currentVideoItemView;
        if ((this.bSr == null || !this.bSr.afP()) && (currentVideoItemView = getCurrentVideoItemView()) != null && this.bSr != null) {
            if (afZ()) {
                e(currentVideoItemView);
            } else if (a.afL() == 1) {
                agg();
            }
        }
    }

    private boolean afZ() {
        int afL = a.afL();
        if ((this.bSr == null || !this.bSr.afO()) && afL != 0) {
            return afL == 1 && getChildCount() == 1;
        }
        return true;
    }

    public void e(c cVar) {
        if (cVar != null && !this.cfr && w.fn(5)) {
            if (StringUtils.isNull(cVar.getVideoUrl())) {
                cVar.stopPlayback();
                cVar.setVideoPlayState(4);
            } else if (!cVar.isPlaying()) {
                cVar.JT();
            }
        }
    }

    public void aga() {
        if (this.bSr != null && !this.bSr.afP()) {
            e(getCurrentVideoItemView());
        }
    }

    public void f(c cVar) {
        if (cVar != null) {
            cVar.stopPlayback();
        }
    }

    private long aB(List<BannerThreadInfoData> list) {
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

    private int al(int i, int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 > 4 && i >= 3) {
            return i - 1;
        }
        return i;
    }

    private int am(int i, int i2) {
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
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(K - (am(i, i2) * 15), e - (al(i, i2) * 10));
            layoutParams.addRule(14, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    private c agb() {
        c cVar = new c(getContext());
        cVar.setVideoBlurViewMaskColor(r.d.cp_bg_line_d_alpha80);
        cVar.setVisibility(8);
        cVar.a(this.aMo, this.aMn, this.cfA);
        return cVar;
    }

    public void agc() {
        String string;
        if (this.cfn) {
            if (x.s(this.aUV) > 1) {
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
                    this.cfs = BdToast.b(getContext(), string, r.f.icon_toast_game_error).ty();
                }
            }
            JA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA() {
        if (hasMore() && x.s(this.aUV) <= 3) {
            this.cfj.j(this.cfo, this.cfp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        return this.cfj != null && this.cfj.hasMore();
    }

    private void g(c cVar) {
        if (this.cfn && cVar != null) {
            if (this.cfk == null) {
                agd();
            }
            cVar.setVisibility(8);
            cVar.startAnimation(this.cfk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(c cVar) {
        if (cVar != null) {
            if (this.cfl == null) {
                age();
            }
            cVar.setVisibility(0);
            cVar.startAnimation(this.cfl);
        }
    }

    private void agd() {
        this.cfk = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_slide_out);
        this.cfk.setAnimationListener(new t(this));
    }

    private void age() {
        this.cfl = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_slide_up);
        this.cfl.setAnimationListener(new k(this));
    }

    private void agf() {
        this.cfm = AnimationUtils.loadAnimation(getContext(), r.a.frs_head_video_jump_up);
        this.cfm.setAnimationListener(new l(this));
    }

    private void agg() {
        if (this.cfn) {
            if (this.cfm == null) {
                agf();
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.cfz, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agh() {
        if (getChildCount() > 4) {
            c is = is(2);
            c is2 = is(3);
            if (is != null && is2 != null) {
                int bgResId = is.getBgResId();
                is2.setVideoBlurViewBackgroundResId(bgResId);
                is2.setVideoBlurViewBackgroundDrawable(getDrawable(bgResId));
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c is = is(i2);
            if (is != null) {
                is.onChangeSkinType(hVar, i);
            }
        }
    }

    public void onDestory() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c is = is(i);
            if (is != null) {
                is.onDestory();
            }
        }
        if (this.cfs != null) {
            this.cfs.cancel();
        }
        if (this.cfv != null) {
            this.cfv.clear();
        }
        if (this.cfw != null) {
            this.cfw.onDestroy();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.mRunnable);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cfz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(bk bkVar) {
        if (bkVar != null && bkVar.sf() != null && !p(bkVar)) {
            z.a(bkVar.sf().video_md5, bkVar.getTid(), String.valueOf(bkVar.getFid()), "headvideo", "", "", "1");
        }
    }

    @Override // com.baidu.tieba.play.s
    public boolean JS() {
        return this.cfq;
    }

    @Override // com.baidu.tieba.play.s
    public boolean isPlaying() {
        if (getCurrentVideoItemView() == null) {
            return false;
        }
        return getCurrentVideoItemView().isPlaying();
    }

    @Override // com.baidu.tieba.play.s
    public void JT() {
        if (!this.cfq) {
            this.cfq = true;
            if (afZ()) {
                aga();
            }
        }
    }

    @Override // com.baidu.tieba.play.s
    public void stopPlay() {
        this.cfq = false;
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
