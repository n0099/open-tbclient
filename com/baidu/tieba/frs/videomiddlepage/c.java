package com.baidu.tieba.frs.videomiddlepage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
/* loaded from: classes3.dex */
public class c {
    private n bvt;
    private g dHG;
    private com.baidu.tieba.frs.aggregation.g dHH;
    private e dHI;
    private ValueAnimator dHJ;
    private a dHK;
    private FrameLayout dqH;
    private FrameLayout dqI;
    private com.baidu.tieba.play.c dqV;
    private int mWidth;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void aAW();

        void aAX();
    }

    public void a(g gVar) {
        this.dHG = gVar;
    }

    public com.baidu.tieba.frs.aggregation.g aAU() {
        if (this.dHH == null) {
            this.dHH = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.dHH, this.dHG.aBb());
        return this.dHH;
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
            gVar.dru = aVar;
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
            gVar.drv = bVar;
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
        if (this.dHH != null && this.dHG != null && this.dHG.aBb() != null && this.dHG.aBb().mVideoCardViewInfo != null) {
            this.dHK = aVar;
            this.dHI = eVar;
            this.dHI.gq(false);
            this.rootView = View.inflate(tbPageContext.getPageActivity(), f.h.card_video_middle_page_layout, null);
            this.mWidth = l.ah(tbPageContext.getPageActivity());
            this.rootView.findViewById(f.g.user_container).setVisibility(4);
            this.rootView.findViewById(f.g.comment_and_priase_layout).setVisibility(4);
            this.rootView.findViewById(f.g.comment_and_priase_layout_foreground).setVisibility(4);
            this.rootView.findViewById(f.g.title_foreground).setVisibility(4);
            this.rootView.findViewById(f.g.title).setVisibility(4);
            this.rootView.findViewById(f.g.video_agg_container_foreground).setVisibility(4);
            this.dqH = (FrameLayout) this.rootView.findViewById(f.g.video_agg_container);
            this.dqI = (FrameLayout) this.rootView.findViewById(f.g.video_container);
            this.dqV = new com.baidu.tieba.play.c(tbPageContext, this.dqI, false);
            this.bvt = new n(tbPageContext.getPageActivity());
            b(this.dHH, 0, eVar);
            if (this.rootView.getParent() != null) {
                ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
            }
            int i2 = this.dHG.aBb().mVideoCardViewInfo.cardViewX;
            int i3 = this.dHG.aBb().mVideoCardViewInfo.cardViewY;
            int i4 = this.dHG.aBb().mVideoCardViewInfo.cardViewWidth;
            int i5 = this.dHG.aBb().mVideoCardViewInfo.cardViewHeight;
            this.dqH.setX(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqH.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.dqH.setLayoutParams(layoutParams);
            this.rootView.setY(i3 - l.f(tbPageContext.getPageActivity(), f.e.tbds154));
            relativeLayout.addView(this.rootView);
            int i6 = this.mWidth;
            int aAV = aAV();
            if (i4 == i6) {
                i4 = i6 - l.f(tbPageContext.getPageActivity(), f.e.ds72);
            }
            a(this.rootView, this.dqH, i2, 0, i3, i, i4, i6, i5, aAV);
        }
    }

    private int aAV() {
        return !aAP() ? (int) (0.875f * this.mWidth) : (int) (0.5625f * this.mWidth);
    }

    private boolean aAP() {
        try {
            int parseInt = Integer.parseInt(this.dHH.drv.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dHH.drv.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.drv != null) {
            this.dqV.stopPlay();
            this.dqV.setIsNeedRecoveryVideoPlayer(true);
            this.dqV.ls(true);
            this.dqV.lq(false);
            this.dqV.N(false, true);
            this.dqV.lt(true);
            this.dqV.rF(i);
            this.dqV.lo(false);
            this.dqV.getVideoView().setBusiness(this.bvt);
            this.dqV.aRZ();
            this.dqV.setThumbnail(gVar.drv.thumbnailUrl);
            this.dqV.setVideoUrl(gVar.drv.videoUrl, gVar.threadId);
            this.dqV.aFa();
            this.dqV.show();
        }
    }

    private void a(final View view, final View view2, final int i, final int i2, final int i3, final int i4, int i5, int i6, final int i7, final int i8) {
        int i9 = i > i2 ? i : i2;
        final int i10 = i9 - ((i + i2) - i9);
        int i11 = i3 > i4 ? i3 : i4;
        final int i12 = i11 - ((i3 + i4) - i11);
        int i13 = i8 > i7 ? i8 : i7;
        final int i14 = i13 - ((i8 + i7) - i13);
        this.dHJ = ValueAnimator.ofInt(i5, i6);
        this.dHJ.setDuration(400L);
        this.dHJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.1
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
        this.dHJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (c.this.dHK != null) {
                    c.this.dHK.aAW();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.dHI != null) {
                    c.this.dHI.gq(true);
                }
                if (c.this.dHK != null) {
                    c.this.dHK.aAX();
                }
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                c.this.awf();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (c.this.dHK != null) {
                    c.this.dHK.aAX();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dHJ.setTarget(view2);
        this.dHJ.start();
    }

    public void awf() {
        if (this.dqV != null) {
            this.dqV.destroy();
            this.dqV = null;
        }
    }

    public void onDestroy() {
        if (this.dHJ != null) {
            this.dHJ.cancel();
            this.dHJ = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        awf();
    }
}
