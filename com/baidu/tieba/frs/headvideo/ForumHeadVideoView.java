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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.BannerThreadInfoData;
import com.baidu.tbadk.core.data.bg;
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
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ForumHeadVideoView extends com.baidu.tbadk.widget.layout.g implements com.baidu.tieba.play.d {
    private final com.baidu.tbadk.widget.layout.i aHk;
    private final List<BannerThreadInfoData> aRP;
    private com.baidu.adp.base.h<?> aRe;
    private MediaPlayer.OnCompletionListener agF;
    private MediaPlayer.OnPreparedListener agG;
    private c bPH;
    private final g.a cbD;
    private g cbL;
    private Animation cbM;
    private Animation cbN;
    private Animation cbO;
    private boolean cbP;
    private long cbQ;
    private long cbR;
    private boolean cbS;
    private boolean cbT;
    private BdToast cbU;
    private i cbV;
    private int[] cbW;
    private final SparseArray<SoftReference<Drawable>> cbX;
    private BlurDrawable cbY;
    private boolean cbZ;
    private w.a cca;
    final Runnable ccb;
    private MediaPlayer.OnErrorListener ccc;
    final Runnable mRunnable;

    public void setDoingPullRefresh(boolean z) {
        this.cbT = z;
        if (z) {
            stopPlay();
        } else {
            aet();
        }
    }

    protected Drawable getDrawable(int i) {
        SoftReference<Drawable> softReference = this.cbX.get(i);
        Drawable drawable = softReference != null ? softReference.get() : null;
        if (drawable == null) {
            try {
                Bitmap cN = av.cN(i);
                if (cN == null || cN.isRecycled()) {
                    return null;
                }
                if (this.cbY == null) {
                    this.cbY = new BlurDrawable(getContext());
                }
                this.cbY.init(8, 12, cN);
                if (this.cbY != null && this.cbY.drawBlur()) {
                    drawable = new BitmapDrawable(this.cbY.getBlurredBitmap());
                }
                if (drawable != null) {
                    this.cbX.put(i, new SoftReference<>(drawable));
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
        this.cbP = true;
        this.cbS = false;
        this.cbT = false;
        this.cbW = new int[]{t.f.pic_video_bg01, t.f.pic_video_bg02, t.f.pic_video_bg03, t.f.pic_video_bg04};
        this.aRP = new ArrayList();
        this.cbX = new SparseArray<>();
        this.cca = new l(this);
        this.aHk = new o(this);
        this.cbD = new p(this);
        this.ccb = new q(this);
        this.mRunnable = new r(this);
        this.agG = new s(this);
        this.agF = new t(this);
        this.ccc = new u(this);
        init(context);
    }

    public ForumHeadVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbP = true;
        this.cbS = false;
        this.cbT = false;
        this.cbW = new int[]{t.f.pic_video_bg01, t.f.pic_video_bg02, t.f.pic_video_bg03, t.f.pic_video_bg04};
        this.aRP = new ArrayList();
        this.cbX = new SparseArray<>();
        this.cca = new l(this);
        this.aHk = new o(this);
        this.cbD = new p(this);
        this.ccb = new q(this);
        this.mRunnable = new r(this);
        this.agG = new s(this);
        this.agF = new t(this);
        this.ccc = new u(this);
        init(context);
    }

    private void init(Context context) {
        this.aRe = com.baidu.adp.base.l.C(context);
        this.cbL = new g(this.aRe);
        this.cbL.a(this.cbD);
        setOnSizeChangeListener(this.aHk);
    }

    public void aeq() {
        e currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
            bg threadInfo = currentVideoItemView.getThreadInfo();
            if (!n(threadInfo)) {
                TiebaStatic.log(new ay("c11278").ab("tid", threadInfo.getTid()).ab("fid", String.valueOf(threadInfo.getFid())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(bg bgVar) {
        if (bgVar == null) {
            return true;
        }
        return bgVar.getFid() <= 0 || com.baidu.adp.lib.h.b.c(bgVar.getTid(), 0L) <= 0 || com.baidu.adp.lib.h.b.c(bgVar.getId(), 0L) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(bg bgVar) {
        if (bgVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(getContext()).createNormalCfg(String.valueOf(bgVar.getFid()), bgVar.getTid(), "headvideo")));
        }
    }

    public e getCurrentVideoItemView() {
        return im(getChildCount() - 1);
    }

    public e getSwapVideoItemView() {
        return im(getChildCount() - 2);
    }

    private e im(int i) {
        if (i >= 0 && i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt instanceof e) {
                return (e) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(int i) {
        BannerThreadInfoData bannerThreadInfoData;
        if (y.t(this.aRP)) {
            setVisibility(8);
            this.cbP = true;
            return;
        }
        BannerThreadInfoData bannerThreadInfoData2 = this.aRP.get(0);
        BannerThreadInfoData bannerThreadInfoData3 = this.aRP.size() >= 2 ? this.aRP.get(1) : bannerThreadInfoData2;
        if (this.aRP.size() < 3) {
            bannerThreadInfoData = null;
        } else {
            bannerThreadInfoData = this.aRP.get(2);
        }
        for (int i2 = 0; i2 < i; i2++) {
            e im = im(i2);
            if (im == null) {
                im = aeu();
                a(im, i2, i);
                addView(im, i2);
            }
            if (i2 == i - 1) {
                im.a(bannerThreadInfoData2);
                im.aek();
            } else if (i2 == i - 2) {
                im.a(bannerThreadInfoData3);
                im.aek();
            } else if (i == 5 && i2 == i - 3) {
                im.a(bannerThreadInfoData3);
                im.aek();
            } else if (bannerThreadInfoData != null) {
                im.a(bannerThreadInfoData);
            } else {
                im.a(bannerThreadInfoData3);
            }
            g(im, i2, i);
            im.setVideoBlurViewBackgroundDrawable(getDrawable(im.getBgResId()));
            im.setVideoBlurViewMaskColor(t.d.cp_bg_line_d_alpha90);
            e(im);
            im.setVisibility(0);
        }
        onChangeSkinType(this.aRe, TbadkCoreApplication.m9getInst().getSkinType());
        setVisibility(0);
        aer();
    }

    private void a(e eVar, int i, int i2) {
        if (eVar != null && this.cbW != null) {
            int length = (this.cbW.length - aj(i, i2)) - 1;
            if (length < 0) {
                length = 0;
            } else if (length > this.cbW.length - 1) {
                length = this.cbW.length - 1;
            }
            int i3 = this.cbW[length];
            eVar.setVideoBlurViewBackgroundResId(i3);
            eVar.setVideoBlurViewBackgroundDrawable(getDrawable(i3));
        }
    }

    public void setWithSign(boolean z) {
        this.cbZ = z;
    }

    public void a(long j, List<BannerThreadInfoData> list, c cVar) {
        if (this.cbZ) {
            this.cbZ = false;
            return;
        }
        this.cbL.reset();
        if (list == null || j < 0) {
            setVisibility(8);
            this.cbP = true;
            return;
        }
        this.bPH = cVar;
        this.cbQ = j;
        this.aRP.clear();
        int min = Math.min(list.size(), 5);
        this.aRP.addAll(list.subList(0, min));
        this.cbR = aA(this.aRP);
        if (min >= 5) {
            this.cbL.setHasMore(1);
        } else {
            this.cbL.setHasMore(0);
        }
        in(min);
        if (this.cbV == null) {
            this.cbV = new i(getContext(), this, this.cca);
        }
    }

    private void aer() {
        e currentVideoItemView;
        if ((this.bPH == null || !this.bPH.aej()) && (currentVideoItemView = getCurrentVideoItemView()) != null && this.bPH != null) {
            if (aes()) {
                d(currentVideoItemView);
                return;
            }
            int aec = a.aec();
            if (aec == 2) {
                this.bPH.aeh();
                this.bPH.ed(true);
            } else if (aec == 1) {
                aeA();
            }
        }
    }

    private boolean aes() {
        int aec = a.aec();
        if ((this.bPH == null || !this.bPH.aef()) && aec != 0) {
            return aec == 1 && getChildCount() == 1;
        }
        return true;
    }

    public void d(e eVar) {
        if (eVar != null && !this.cbT && x.fl(5)) {
            if (StringUtils.isNull(eVar.getVideoUrl())) {
                eVar.stopPlayback();
                eVar.setVideoPlayState(4);
            } else if (!eVar.isPlaying()) {
                eVar.Kz();
            }
        }
    }

    public void aet() {
        if (this.bPH != null && !this.bPH.aej()) {
            d(getCurrentVideoItemView());
        }
    }

    public void e(e eVar) {
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

    private int aj(int i, int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 > 4 && i >= 3) {
            return i - 1;
        }
        return i;
    }

    private int ak(int i, int i2) {
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
            int e = com.baidu.adp.lib.util.k.e(getContext(), t.e.ds500);
            int K = com.baidu.adp.lib.util.k.K(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(K - (ak(i, i2) * 15), e - (aj(i, i2) * 10));
            layoutParams.addRule(14, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    private e aeu() {
        e eVar = new e(getContext());
        eVar.setVideoBlurViewMaskColor(t.d.cp_bg_line_d_alpha80);
        eVar.setVisibility(8);
        eVar.a(this.agG, this.agF, this.ccc);
        return eVar;
    }

    public void aev() {
        String string;
        if (this.cbP) {
            if (y.s(this.aRP) > 1) {
                f(getCurrentVideoItemView());
            } else {
                if (hasMore()) {
                    if (!com.baidu.adp.lib.util.i.gm()) {
                        string = getContext().getString(t.j.frs_head_video_slide_no_network);
                    } else {
                        string = getContext().getString(t.j.frs_head_video_slide_data_loading);
                    }
                } else if (getChildCount() == 1) {
                    string = getContext().getString(t.j.frs_head_video_no_more_data);
                } else {
                    string = getContext().getString(t.j.frs_head_video_no_more_data_1);
                }
                if (!TextUtils.isEmpty(string)) {
                    this.cbU = BdToast.b(getContext(), string, t.f.icon_toast_game_error).tf();
                }
            }
            aew();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aew() {
        if (hasMore() && y.s(this.aRP) <= 3) {
            this.cbL.i(this.cbQ, this.cbR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        return this.cbL != null && this.cbL.hasMore();
    }

    private void f(e eVar) {
        if (this.cbP && eVar != null) {
            if (this.cbM == null) {
                aex();
            }
            eVar.setVisibility(8);
            eVar.startAnimation(this.cbM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(e eVar) {
        if (eVar != null) {
            if (this.cbN == null) {
                aey();
            }
            eVar.setVisibility(0);
            eVar.startAnimation(this.cbN);
        }
    }

    private void aex() {
        this.cbM = AnimationUtils.loadAnimation(getContext(), t.a.frs_head_video_slide_out);
        this.cbM.setAnimationListener(new v(this));
    }

    private void aey() {
        this.cbN = AnimationUtils.loadAnimation(getContext(), t.a.frs_head_video_slide_up);
        this.cbN.setAnimationListener(new m(this));
    }

    private void aez() {
        this.cbO = AnimationUtils.loadAnimation(getContext(), t.a.frs_head_video_jump_up);
        this.cbO.setAnimationListener(new n(this));
    }

    private void aeA() {
        if (this.cbP) {
            if (this.cbO == null) {
                aez();
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.ccb, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeB() {
        if (getChildCount() > 4) {
            e im = im(2);
            e im2 = im(3);
            if (im != null && im2 != null) {
                int bgResId = im.getBgResId();
                im2.setVideoBlurViewBackgroundResId(bgResId);
                im2.setVideoBlurViewBackgroundDrawable(getDrawable(bgResId));
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.h<?> hVar, int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            e im = im(i2);
            if (im != null) {
                im.onChangeSkinType(hVar, i);
            }
        }
    }

    public void onDestory() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            e im = im(i);
            if (im != null) {
                im.onDestory();
            }
        }
        if (this.cbU != null) {
            this.cbU.cancel();
        }
        if (this.cbX != null) {
            this.cbX.clear();
        }
        if (this.cbY != null) {
            this.cbY.onDestroy();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.mRunnable);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ccb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(bg bgVar) {
        if (bgVar != null && bgVar.rR() != null && !n(bgVar)) {
            com.baidu.tieba.play.h.l(bgVar.rR().video_md5, bgVar.getTid(), String.valueOf(bgVar.getFid()), "headvideo");
        }
    }

    @Override // com.baidu.tieba.play.d
    public boolean KA() {
        return this.cbS;
    }

    @Override // com.baidu.tieba.play.d
    public boolean isPlaying() {
        if (getCurrentVideoItemView() == null) {
            return false;
        }
        return getCurrentVideoItemView().isPlaying();
    }

    @Override // com.baidu.tieba.play.d
    public void Kz() {
        if (!this.cbS) {
            this.cbS = true;
            if (aes()) {
                aet();
            }
        }
    }

    @Override // com.baidu.tieba.play.d
    public void stopPlay() {
        this.cbS = false;
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
