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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel;
import com.baidu.tieba.frs.headvideo.t;
import com.baidu.tieba.play.ab;
import com.baidu.tieba.play.bb;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.v;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ForumHeadVideoView extends com.baidu.tbadk.widget.layout.g implements u {
    private final com.baidu.tbadk.widget.layout.i aLf;
    private v.a aQr;
    private v.d aQs;
    private final List<BannerThreadInfoData> aVq;
    private b bNi;
    private boolean bYA;
    private boolean bYB;
    private BdToast bYC;
    private f bYD;
    private int[] bYE;
    private final SparseArray<SoftReference<Drawable>> bYF;
    private BlurDrawable bYG;
    private boolean bYH;
    private t.a bYI;
    final Runnable bYJ;
    private v.b bYK;
    private final ForumHeadVideoListModel.a bYl;
    private ForumHeadVideoListModel bYt;
    private Animation bYu;
    private Animation bYv;
    private Animation bYw;
    private boolean bYx;
    private long bYy;
    private long bYz;
    private com.baidu.adp.base.g<?> mPageContext;
    final Runnable mRunnable;

    public void setDoingPullRefresh(boolean z) {
        this.bYB = z;
        if (z) {
            stopPlay();
        } else {
            acz();
        }
    }

    protected Drawable getDrawable(int i) {
        SoftReference<Drawable> softReference = this.bYF.get(i);
        Drawable drawable = softReference != null ? softReference.get() : null;
        if (drawable == null) {
            try {
                Bitmap cL = aq.cL(i);
                if (cL == null || cL.isRecycled()) {
                    return null;
                }
                if (this.bYG == null) {
                    this.bYG = new BlurDrawable(getContext());
                }
                this.bYG.init(8, 12, cL);
                if (this.bYG != null && this.bYG.drawBlur()) {
                    drawable = new BitmapDrawable(this.bYG.getBlurredBitmap());
                }
                if (drawable != null) {
                    this.bYF.put(i, new SoftReference<>(drawable));
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
        this.bYx = true;
        this.bYA = false;
        this.bYB = false;
        this.bYE = new int[]{w.g.pic_video_bg01, w.g.pic_video_bg02, w.g.pic_video_bg03, w.g.pic_video_bg04};
        this.aVq = new ArrayList();
        this.bYF = new SparseArray<>();
        this.bYI = new i(this);
        this.aLf = new l(this);
        this.bYl = new m(this);
        this.bYJ = new n(this);
        this.mRunnable = new o(this);
        this.aQs = new p(this);
        this.aQr = new q(this);
        this.bYK = new r(this);
        init(context);
    }

    public ForumHeadVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYx = true;
        this.bYA = false;
        this.bYB = false;
        this.bYE = new int[]{w.g.pic_video_bg01, w.g.pic_video_bg02, w.g.pic_video_bg03, w.g.pic_video_bg04};
        this.aVq = new ArrayList();
        this.bYF = new SparseArray<>();
        this.bYI = new i(this);
        this.aLf = new l(this);
        this.bYl = new m(this);
        this.bYJ = new n(this);
        this.mRunnable = new o(this);
        this.aQs = new p(this);
        this.aQr = new q(this);
        this.bYK = new r(this);
        init(context);
    }

    private void init(Context context) {
        this.mPageContext = com.baidu.adp.base.k.aa(context);
        this.bYt = new ForumHeadVideoListModel(this.mPageContext);
        this.bYt.a(this.bYl);
        setOnSizeChangeListener(this.aLf);
    }

    public void acw() {
        c currentVideoItemView = getCurrentVideoItemView();
        if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
            bj threadInfo = currentVideoItemView.getThreadInfo();
            if (!x(threadInfo)) {
                TiebaStatic.log(new as("c11278").Z("tid", threadInfo.getTid()).Z("fid", String.valueOf(threadInfo.getFid())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(bj bjVar) {
        if (bjVar == null) {
            return true;
        }
        return bjVar.getFid() <= 0 || com.baidu.adp.lib.g.b.c(bjVar.getTid(), 0L) <= 0 || com.baidu.adp.lib.g.b.c(bjVar.getId(), 0L) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(bj bjVar) {
        if (bjVar != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(bjVar.getId(), null, null);
            createNormalCfg.setVideo_source("headvideo");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public c getCurrentVideoItemView() {
        return il(getChildCount() - 1);
    }

    public c getSwapVideoItemView() {
        return il(getChildCount() - 2);
    }

    private c il(int i) {
        if (i >= 0 && i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(int i) {
        BannerThreadInfoData bannerThreadInfoData;
        if (x.q(this.aVq)) {
            setVisibility(8);
            this.bYx = true;
            return;
        }
        BannerThreadInfoData bannerThreadInfoData2 = this.aVq.get(0);
        BannerThreadInfoData bannerThreadInfoData3 = this.aVq.size() >= 2 ? this.aVq.get(1) : bannerThreadInfoData2;
        if (this.aVq.size() < 3) {
            bannerThreadInfoData = null;
        } else {
            bannerThreadInfoData = this.aVq.get(2);
        }
        for (int i2 = 0; i2 < i; i2++) {
            c il = il(i2);
            if (il == null) {
                il = acA();
                a(il, i2, i);
                addView(il, i2);
            }
            if (i2 == i - 1) {
                il.a(bannerThreadInfoData2);
                il.aco();
            } else if (i2 == i - 2) {
                il.a(bannerThreadInfoData3);
                il.aco();
            } else if (i == 5 && i2 == i - 3) {
                il.a(bannerThreadInfoData3);
                il.aco();
            } else if (bannerThreadInfoData != null) {
                il.a(bannerThreadInfoData);
            } else {
                il.a(bannerThreadInfoData3);
            }
            f(il, i2, i);
            il.setVideoBlurViewBackgroundDrawable(getDrawable(il.getBgResId()));
            il.setVideoBlurViewMaskColor(w.e.cp_bg_line_d_alpha90);
            f(il);
            il.setVisibility(0);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.m9getInst().getSkinType());
        setVisibility(0);
        acx();
    }

    private void a(c cVar, int i, int i2) {
        if (cVar != null && this.bYE != null) {
            int length = (this.bYE.length - al(i, i2)) - 1;
            if (length < 0) {
                length = 0;
            } else if (length > this.bYE.length - 1) {
                length = this.bYE.length - 1;
            }
            int i3 = this.bYE[length];
            cVar.setVideoBlurViewBackgroundResId(i3);
            cVar.setVideoBlurViewBackgroundDrawable(getDrawable(i3));
        }
    }

    public void setWithSign(boolean z) {
        this.bYH = z;
    }

    public void a(long j, List<BannerThreadInfoData> list, b bVar) {
        if (this.bYH) {
            this.bYH = false;
            return;
        }
        this.bYt.reset();
        if (list == null || j < 0) {
            setVisibility(8);
            this.bYx = true;
            return;
        }
        this.bNi = bVar;
        this.bYy = j;
        this.aVq.clear();
        int min = Math.min(list.size(), 5);
        this.aVq.addAll(list.subList(0, min));
        this.bYz = au(this.aVq);
        if (min >= 5) {
            this.bYt.setHasMore(1);
        } else {
            this.bYt.setHasMore(0);
        }
        im(min);
        if (this.bYD == null) {
            this.bYD = new f(getContext(), this, this.bYI);
        }
    }

    private void acx() {
        c currentVideoItemView;
        if ((this.bNi == null || !this.bNi.acn()) && (currentVideoItemView = getCurrentVideoItemView()) != null && this.bNi != null) {
            if (acy()) {
                e(currentVideoItemView);
            } else if (a.acj() == 1) {
                acF();
            }
        }
    }

    private boolean acy() {
        int acj = a.acj();
        if ((this.bNi == null || !this.bNi.acm()) && acj != 0) {
            return acj == 1 && getChildCount() == 1;
        }
        return true;
    }

    public void e(c cVar) {
        if (cVar != null && !this.bYB && com.baidu.tbadk.util.w.fh(5)) {
            if (StringUtils.isNull(cVar.getVideoUrl())) {
                cVar.stopPlayback();
                cVar.setVideoPlayState(4);
            } else if (!cVar.isPlaying()) {
                cVar.startPlay();
            }
        }
    }

    public void acz() {
        if (this.bNi != null && !this.bNi.acn()) {
            e(getCurrentVideoItemView());
        }
    }

    public void f(c cVar) {
        if (cVar != null) {
            cVar.stopPlayback();
        }
    }

    private long au(List<BannerThreadInfoData> list) {
        if (x.q(list)) {
            return 0L;
        }
        for (BannerThreadInfoData bannerThreadInfoData : list) {
            if (bannerThreadInfoData != null && bannerThreadInfoData.threadData != null && bannerThreadInfoData.from == 1) {
                return com.baidu.adp.lib.g.b.c(bannerThreadInfoData.threadData.getTid(), 0L);
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
    public void f(View view, int i, int i2) {
        if (view != null && i2 > 0 && i >= 0) {
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds500);
            int ag = com.baidu.adp.lib.util.k.ag(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ag - (am(i, i2) * 15), g - (al(i, i2) * 10));
            layoutParams.addRule(14, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    private c acA() {
        c cVar = new c(getContext());
        cVar.setVideoBlurViewMaskColor(w.e.cp_bg_line_d_alpha80);
        cVar.setVisibility(8);
        cVar.a(this.aQs, this.aQr, this.bYK);
        return cVar;
    }

    public void acB() {
        String string;
        if (this.bYx) {
            if (x.p(this.aVq) > 1) {
                g(getCurrentVideoItemView());
            } else {
                if (hasMore()) {
                    if (!com.baidu.adp.lib.util.i.he()) {
                        string = getContext().getString(w.l.frs_head_video_slide_no_network);
                    } else {
                        string = getContext().getString(w.l.frs_head_video_slide_data_loading);
                    }
                } else if (getChildCount() == 1) {
                    string = getContext().getString(w.l.frs_head_video_no_more_data);
                } else {
                    string = getContext().getString(w.l.frs_head_video_no_more_data_1);
                }
                if (!TextUtils.isEmpty(string)) {
                    this.bYC = BdToast.b(getContext(), string, w.g.icon_toast_game_error).tA();
                }
            }
            JO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        if (hasMore() && x.p(this.aVq) <= 3) {
            this.bYt.d(this.bYy, this.bYz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMore() {
        return this.bYt != null && this.bYt.hasMore();
    }

    private void g(c cVar) {
        if (this.bYx && cVar != null) {
            if (this.bYu == null) {
                acC();
            }
            cVar.setVisibility(8);
            cVar.startAnimation(this.bYu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(c cVar) {
        if (cVar != null) {
            if (this.bYv == null) {
                acD();
            }
            cVar.setVisibility(0);
            cVar.startAnimation(this.bYv);
        }
    }

    private void acC() {
        this.bYu = AnimationUtils.loadAnimation(getContext(), w.a.frs_head_video_slide_out);
        this.bYu.setAnimationListener(new s(this));
    }

    private void acD() {
        this.bYv = AnimationUtils.loadAnimation(getContext(), w.a.frs_head_video_slide_up);
        this.bYv.setAnimationListener(new j(this));
    }

    private void acE() {
        this.bYw = AnimationUtils.loadAnimation(getContext(), w.a.frs_head_video_jump_up);
        this.bYw.setAnimationListener(new k(this));
    }

    private void acF() {
        if (this.bYx) {
            if (this.bYw == null) {
                acE();
            }
            com.baidu.adp.lib.g.h.fM().postDelayed(this.bYJ, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acG() {
        if (getChildCount() > 4) {
            c il = il(2);
            c il2 = il(3);
            if (il != null && il2 != null) {
                int bgResId = il.getBgResId();
                il2.setVideoBlurViewBackgroundResId(bgResId);
                il2.setVideoBlurViewBackgroundDrawable(getDrawable(bgResId));
            }
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.g<?> gVar, int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c il = il(i2);
            if (il != null) {
                il.onChangeSkinType(gVar, i);
            }
        }
    }

    public void onDestory() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            c il = il(i);
            if (il != null) {
                il.onDestory();
            }
        }
        if (this.bYC != null) {
            this.bYC.cancel();
        }
        if (this.bYF != null) {
            this.bYF.clear();
        }
        if (this.bYG != null) {
            this.bYG.onDestroy();
        }
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.mRunnable);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.bYJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(bj bjVar) {
        if (bjVar != null && bjVar.sh() != null && !x(bjVar)) {
            bb bbVar = new bb();
            bbVar.mLocate = "headvideo";
            bbVar.bqB = bjVar.getTid();
            bbVar.bqC = new StringBuilder(String.valueOf(bjVar.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = bjVar.Zh;
            bbVar.eXe = bjVar.Zj;
            bbVar.eXf = bjVar.Zi;
            bbVar.eXg = "";
            if (bjVar.sU() != null && bjVar.sU().channelId > 0) {
                bbVar.Vy = new StringBuilder(String.valueOf(bjVar.sU().channelId)).toString();
            } else {
                bbVar.Vy = "0";
            }
            ab.a(bjVar.sh().video_md5, "", "1", bbVar);
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.bYA;
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
        if (!this.bYA) {
            this.bYA = true;
            if (acy()) {
                acz();
            }
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        this.bYA = false;
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
