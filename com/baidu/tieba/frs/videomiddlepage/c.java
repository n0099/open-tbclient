package com.baidu.tieba.frs.videomiddlepage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
/* loaded from: classes3.dex */
public class c {
    private n bkR;
    private FrameLayout daL;
    private FrameLayout daM;
    private com.baidu.tieba.play.c daY;
    private g drr;
    private com.baidu.tieba.frs.aggregation.g drs;
    private e drt;
    private ValueAnimator dru;
    private a drv;
    private int mWidth;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void avD();

        void avE();
    }

    public void a(g gVar) {
        this.drr = gVar;
    }

    public com.baidu.tieba.frs.aggregation.g avB() {
        if (this.drs == null) {
            this.drs = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.drs, this.drr.avG());
        return this.drs;
    }

    private void a(com.baidu.tieba.frs.aggregation.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo != null) {
            g.a aVar = new g.a();
            if (videoSerializeVideoThreadInfo.getAuthor() != null) {
                aVar.userId = videoSerializeVideoThreadInfo.getAuthor().userId;
                aVar.userName = videoSerializeVideoThreadInfo.getAuthor().userName;
                aVar.userNickname = videoSerializeVideoThreadInfo.getAuthor().userNickname;
                aVar.isBigV = videoSerializeVideoThreadInfo.getAuthor().isBigV;
                aVar.isGod = videoSerializeVideoThreadInfo.getAuthor().isGod;
                aVar.portrait = videoSerializeVideoThreadInfo.getAuthor().portrait;
                aVar.hasFocus = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            }
            gVar.dby = aVar;
            g.b bVar = new g.b();
            if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
                bVar.thumbnailWidth = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
                bVar.thumbnailHeight = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
                bVar.videoMd5 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
                bVar.videoUrl = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
                bVar.videoDuration = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
                bVar.videoWidth = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
                bVar.videoHeight = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
                bVar.videoSize = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
                bVar.thumbnailUrl = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
                bVar.originVideoUrl = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
                gVar.playCount = videoSerializeVideoThreadInfo.playCount;
            }
            gVar.dbz = bVar;
            gVar.forumId = videoSerializeVideoThreadInfo.forumId;
            gVar.threadId = videoSerializeVideoThreadInfo.threadId;
            gVar.firstPostId = videoSerializeVideoThreadInfo.firstPostId;
            gVar.createTime = videoSerializeVideoThreadInfo.createTime;
            gVar.postNum = videoSerializeVideoThreadInfo.postNum;
            gVar.agreeNum = videoSerializeVideoThreadInfo.agreeNum;
            gVar.shareNum = videoSerializeVideoThreadInfo.shareNum;
            gVar.hasAgree = videoSerializeVideoThreadInfo.hasAgree;
            gVar.source = videoSerializeVideoThreadInfo.source;
            gVar.title = videoSerializeVideoThreadInfo.title;
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout, int i, e eVar, a aVar) {
        if (this.drs != null && this.drr != null && this.drr.avG() != null && this.drr.avG().mVideoCardViewInfo != null) {
            this.drv = aVar;
            this.drt = eVar;
            this.drt.fY(false);
            this.rootView = View.inflate(tbPageContext.getPageActivity(), d.i.card_video_middle_page_layout, null);
            this.mWidth = l.af(tbPageContext.getPageActivity());
            this.rootView.findViewById(d.g.user_container).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title).setVisibility(4);
            this.rootView.findViewById(d.g.video_agg_container_foreground).setVisibility(4);
            this.daL = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
            this.daM = (FrameLayout) this.rootView.findViewById(d.g.video_container);
            this.daY = new com.baidu.tieba.play.c(tbPageContext, this.daM, false);
            this.bkR = new n(tbPageContext.getPageActivity());
            b(this.drs, 0, eVar);
            if (this.rootView.getParent() != null) {
                ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
            }
            int i2 = this.drr.avG().mVideoCardViewInfo.cardViewX;
            int i3 = this.drr.avG().mVideoCardViewInfo.cardViewY;
            int i4 = this.drr.avG().mVideoCardViewInfo.cardViewWidth;
            int i5 = this.drr.avG().mVideoCardViewInfo.cardViewHeight;
            this.daL.setX(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daL.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.daL.setLayoutParams(layoutParams);
            this.rootView.setY(i3 - l.e(tbPageContext.getPageActivity(), d.e.tbds154));
            relativeLayout.addView(this.rootView);
            int i6 = this.mWidth;
            int avC = avC();
            if (i4 == i6) {
                i4 = i6 - l.e(tbPageContext.getPageActivity(), d.e.ds72);
            }
            a(this.rootView, this.daL, i2, 0, i3, i, i4, i6, i5, avC);
        }
    }

    private int avC() {
        return !avw() ? (int) (0.875f * this.mWidth) : (int) (0.5625f * this.mWidth);
    }

    private boolean avw() {
        try {
            int parseInt = Integer.parseInt(this.drs.dbz.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.drs.dbz.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dbz != null) {
            this.daY.stopPlay();
            this.daY.ln(true);
            this.daY.lq(true);
            this.daY.lo(false);
            this.daY.K(false, true);
            this.daY.lr(true);
            this.daY.ro(i);
            this.daY.ll(false);
            this.daY.getVideoView().setBusiness(this.bkR);
            this.daY.aLy();
            this.daY.oz(gVar.dbz.thumbnailUrl);
            this.daY.bK(gVar.dbz.videoUrl, gVar.threadId);
            this.daY.ayA();
            this.daY.show();
        }
    }

    private void a(final View view2, final View view3, final int i, final int i2, final int i3, final int i4, int i5, int i6, final int i7, final int i8) {
        int i9 = i > i2 ? i : i2;
        final int i10 = i9 - ((i + i2) - i9);
        int i11 = i3 > i4 ? i3 : i4;
        final int i12 = i11 - ((i3 + i4) - i11);
        int i13 = i8 > i7 ? i8 : i7;
        final int i14 = i13 - ((i8 + i7) - i13);
        this.dru = ValueAnimator.ofInt(i5, i6);
        this.dru.setDuration(400L);
        this.dru.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i15;
                int i16;
                float f;
                int animatedFraction = (int) (valueAnimator.getAnimatedFraction() * i12);
                if (i3 > i4) {
                    i15 = i3 - animatedFraction;
                } else {
                    i15 = animatedFraction + i3;
                }
                view2.setY(i15);
                int animatedFraction2 = (int) (valueAnimator.getAnimatedFraction() * i10);
                if (i > i2) {
                    i16 = i - animatedFraction2;
                } else {
                    i16 = animatedFraction2 + i;
                }
                view3.setX(i16);
                float animatedFraction3 = valueAnimator.getAnimatedFraction() * i14;
                if (i7 > i8) {
                    f = i7 - animatedFraction3;
                } else {
                    f = animatedFraction3 + i7;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view3.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                layoutParams.height = (int) f;
                view3.setLayoutParams(layoutParams);
            }
        });
        this.dru.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (c.this.drv != null) {
                    c.this.drv.avD();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.drt != null) {
                    c.this.drt.fY(true);
                }
                if (c.this.drv != null) {
                    c.this.drv.avE();
                }
                if (view3.getParent() != null) {
                    ((ViewGroup) view3.getParent()).removeView(view3);
                }
                c.this.aqT();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (c.this.drv != null) {
                    c.this.drv.avE();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dru.setTarget(view3);
        this.dru.start();
    }

    public void aqT() {
        if (this.daY != null) {
            this.daY.destroy();
            this.daY = null;
        }
    }

    public void onDestroy() {
        if (this.dru != null) {
            this.dru.cancel();
            this.dru = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        aqT();
    }
}
