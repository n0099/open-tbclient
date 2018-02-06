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
import com.baidu.tieba.frs.aggregation.d;
import com.baidu.tieba.frs.aggregation.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
/* loaded from: classes3.dex */
public class b {
    private n cba;
    private FrameLayout dIc;
    private FrameLayout dId;
    private com.baidu.tieba.play.c dIp;
    private a dWA;
    private g dWw;
    private com.baidu.tieba.frs.aggregation.f dWx;
    private d dWy;
    private ValueAnimator dWz;
    private int mWidth;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void aAG();

        void aAH();
    }

    public void a(g gVar) {
        this.dWw = gVar;
    }

    public com.baidu.tieba.frs.aggregation.f aAE() {
        if (this.dWx == null) {
            this.dWx = new com.baidu.tieba.frs.aggregation.f();
        }
        a(this.dWx, this.dWw.aAJ());
        return this.dWx;
    }

    private void a(com.baidu.tieba.frs.aggregation.f fVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo != null) {
            f.a aVar = new f.a();
            if (videoSerializeVideoThreadInfo.getAuthor() != null) {
                aVar.userId = videoSerializeVideoThreadInfo.getAuthor().userId;
                aVar.userName = videoSerializeVideoThreadInfo.getAuthor().userName;
                aVar.userNickname = videoSerializeVideoThreadInfo.getAuthor().userNickname;
                aVar.isBigV = videoSerializeVideoThreadInfo.getAuthor().isBigV;
                aVar.isGod = videoSerializeVideoThreadInfo.getAuthor().isGod;
                aVar.portrait = videoSerializeVideoThreadInfo.getAuthor().portrait;
                aVar.hasFocus = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            }
            fVar.dIQ = aVar;
            f.b bVar = new f.b();
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
                fVar.playCount = videoSerializeVideoThreadInfo.playCount;
            }
            fVar.dIR = bVar;
            fVar.forumId = videoSerializeVideoThreadInfo.forumId;
            fVar.threadId = videoSerializeVideoThreadInfo.threadId;
            fVar.firstPostId = videoSerializeVideoThreadInfo.firstPostId;
            fVar.createTime = videoSerializeVideoThreadInfo.createTime;
            fVar.postNum = videoSerializeVideoThreadInfo.postNum;
            fVar.agreeNum = videoSerializeVideoThreadInfo.agreeNum;
            fVar.shareNum = videoSerializeVideoThreadInfo.shareNum;
            fVar.hasAgree = videoSerializeVideoThreadInfo.hasAgree;
            fVar.source = videoSerializeVideoThreadInfo.source;
            fVar.title = videoSerializeVideoThreadInfo.title;
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout, int i, d dVar, a aVar) {
        if (this.dWx != null && this.dWw != null && this.dWw.aAJ() != null && this.dWw.aAJ().mVideoCardViewInfo != null) {
            this.dWA = aVar;
            this.dWy = dVar;
            this.dWy.gu(false);
            this.rootView = View.inflate(tbPageContext.getPageActivity(), d.h.card_video_middle_page_layout, null);
            this.mWidth = l.ao(tbPageContext.getPageActivity());
            this.rootView.findViewById(d.g.user_container).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title).setVisibility(4);
            this.rootView.findViewById(d.g.video_agg_container_foreground).setVisibility(4);
            this.dIc = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
            this.dId = (FrameLayout) this.rootView.findViewById(d.g.video_container);
            this.dIp = new com.baidu.tieba.play.c(tbPageContext, this.dId, false);
            this.cba = new n(tbPageContext.getPageActivity());
            b(this.dWx, 0, dVar);
            if (this.rootView.getParent() != null) {
                ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
            }
            int i2 = this.dWw.aAJ().mVideoCardViewInfo.cardViewX;
            int i3 = this.dWw.aAJ().mVideoCardViewInfo.cardViewY;
            int i4 = this.dWw.aAJ().mVideoCardViewInfo.cardViewWidth;
            int i5 = this.dWw.aAJ().mVideoCardViewInfo.cardViewHeight;
            this.dIc.setX(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIc.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.dIc.setLayoutParams(layoutParams);
            this.rootView.setY(i3 - l.t(tbPageContext.getPageActivity(), d.e.tbds154));
            relativeLayout.addView(this.rootView);
            int i6 = this.mWidth;
            int aAF = aAF();
            if (i4 == i6) {
                i4 = i6 - l.t(tbPageContext.getPageActivity(), d.e.ds72);
            }
            a(this.rootView, this.dIc, i2, 0, i3, i, i4, i6, i5, aAF);
        }
    }

    private int aAF() {
        return !aAz() ? (int) (0.875f * this.mWidth) : (int) (0.5625f * this.mWidth);
    }

    private boolean aAz() {
        try {
            int parseInt = Integer.parseInt(this.dWx.dIR.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dWx.dIR.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void b(com.baidu.tieba.frs.aggregation.f fVar, int i, d.a aVar) {
        if (fVar != null && fVar.dIR != null) {
            this.dIp.stopPlay();
            this.dIp.lI(true);
            this.dIp.lL(true);
            this.dIp.lJ(false);
            this.dIp.Q(false, true);
            this.dIp.lM(true);
            this.dIp.tQ(i);
            this.dIp.lG(false);
            this.dIp.getVideoView().setBusiness(this.cba);
            this.dIp.aQz();
            this.dIp.ov(fVar.dIR.thumbnailUrl);
            this.dIp.bK(fVar.dIR.videoUrl, fVar.threadId);
            this.dIp.aDC();
            this.dIp.show();
        }
    }

    private void a(final View view, final View view2, final int i, final int i2, final int i3, final int i4, int i5, int i6, final int i7, final int i8) {
        int i9 = i > i2 ? i : i2;
        final int i10 = i9 - ((i + i2) - i9);
        int i11 = i3 > i4 ? i3 : i4;
        final int i12 = i11 - ((i3 + i4) - i11);
        int i13 = i8 > i7 ? i8 : i7;
        final int i14 = i13 - ((i8 + i7) - i13);
        this.dWz = ValueAnimator.ofInt(i5, i6);
        this.dWz.setDuration(400L);
        this.dWz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.videomiddlepage.b.1
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
                view.setY(i15);
                int animatedFraction2 = (int) (valueAnimator.getAnimatedFraction() * i10);
                if (i > i2) {
                    i16 = i - animatedFraction2;
                } else {
                    i16 = animatedFraction2 + i;
                }
                view2.setX(i16);
                float animatedFraction3 = valueAnimator.getAnimatedFraction() * i14;
                if (i7 > i8) {
                    f = i7 - animatedFraction3;
                } else {
                    f = animatedFraction3 + i7;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                layoutParams.height = (int) f;
                view2.setLayoutParams(layoutParams);
            }
        });
        this.dWz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (b.this.dWA != null) {
                    b.this.dWA.aAG();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.dWy != null) {
                    b.this.dWy.gu(true);
                }
                if (b.this.dWA != null) {
                    b.this.dWA.aAH();
                }
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                b.this.awz();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (b.this.dWA != null) {
                    b.this.dWA.aAH();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dWz.setTarget(view2);
        this.dWz.start();
    }

    public void awz() {
        if (this.dIp != null) {
            this.dIp.destroy();
            this.dIp = null;
        }
    }

    public void onDestroy() {
        if (this.dWz != null) {
            this.dWz.cancel();
            this.dWz = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        awz();
    }
}
