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
    private n bvr;
    private g dHK;
    private com.baidu.tieba.frs.aggregation.g dHL;
    private e dHM;
    private ValueAnimator dHN;
    private a dHO;
    private FrameLayout dqJ;
    private FrameLayout dqK;
    private com.baidu.tieba.play.c dqX;
    private int mWidth;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void aAZ();

        void aBa();
    }

    public void a(g gVar) {
        this.dHK = gVar;
    }

    public com.baidu.tieba.frs.aggregation.g aAX() {
        if (this.dHL == null) {
            this.dHL = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.dHL, this.dHK.aBe());
        return this.dHL;
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
            gVar.drx = aVar;
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
            gVar.dry = bVar;
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
        if (this.dHL != null && this.dHK != null && this.dHK.aBe() != null && this.dHK.aBe().mVideoCardViewInfo != null) {
            this.dHO = aVar;
            this.dHM = eVar;
            this.dHM.gq(false);
            this.rootView = View.inflate(tbPageContext.getPageActivity(), d.h.card_video_middle_page_layout, null);
            this.mWidth = l.ah(tbPageContext.getPageActivity());
            this.rootView.findViewById(d.g.user_container).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title).setVisibility(4);
            this.rootView.findViewById(d.g.video_agg_container_foreground).setVisibility(4);
            this.dqJ = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
            this.dqK = (FrameLayout) this.rootView.findViewById(d.g.video_container);
            this.dqX = new com.baidu.tieba.play.c(tbPageContext, this.dqK, false);
            this.bvr = new n(tbPageContext.getPageActivity());
            b(this.dHL, 0, eVar);
            if (this.rootView.getParent() != null) {
                ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
            }
            int i2 = this.dHK.aBe().mVideoCardViewInfo.cardViewX;
            int i3 = this.dHK.aBe().mVideoCardViewInfo.cardViewY;
            int i4 = this.dHK.aBe().mVideoCardViewInfo.cardViewWidth;
            int i5 = this.dHK.aBe().mVideoCardViewInfo.cardViewHeight;
            this.dqJ.setX(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqJ.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.dqJ.setLayoutParams(layoutParams);
            this.rootView.setY(i3 - l.f(tbPageContext.getPageActivity(), d.e.tbds154));
            relativeLayout.addView(this.rootView);
            int i6 = this.mWidth;
            int aAY = aAY();
            if (i4 == i6) {
                i4 = i6 - l.f(tbPageContext.getPageActivity(), d.e.ds72);
            }
            a(this.rootView, this.dqJ, i2, 0, i3, i, i4, i6, i5, aAY);
        }
    }

    private int aAY() {
        return !aAS() ? (int) (0.875f * this.mWidth) : (int) (0.5625f * this.mWidth);
    }

    private boolean aAS() {
        try {
            int parseInt = Integer.parseInt(this.dHL.dry.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dHL.dry.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dry != null) {
            this.dqX.stopPlay();
            this.dqX.setIsNeedRecoveryVideoPlayer(true);
            this.dqX.ls(true);
            this.dqX.lq(false);
            this.dqX.N(false, true);
            this.dqX.lt(true);
            this.dqX.rF(i);
            this.dqX.lo(false);
            this.dqX.getVideoView().setBusiness(this.bvr);
            this.dqX.aSc();
            this.dqX.setThumbnail(gVar.dry.thumbnailUrl);
            this.dqX.setVideoUrl(gVar.dry.videoUrl, gVar.threadId);
            this.dqX.aFd();
            this.dqX.show();
        }
    }

    private void a(final View view, final View view2, final int i, final int i2, final int i3, final int i4, int i5, int i6, final int i7, final int i8) {
        int i9 = i > i2 ? i : i2;
        final int i10 = i9 - ((i + i2) - i9);
        int i11 = i3 > i4 ? i3 : i4;
        final int i12 = i11 - ((i3 + i4) - i11);
        int i13 = i8 > i7 ? i8 : i7;
        final int i14 = i13 - ((i8 + i7) - i13);
        this.dHN = ValueAnimator.ofInt(i5, i6);
        this.dHN.setDuration(400L);
        this.dHN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.1
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
        this.dHN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (c.this.dHO != null) {
                    c.this.dHO.aAZ();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.dHM != null) {
                    c.this.dHM.gq(true);
                }
                if (c.this.dHO != null) {
                    c.this.dHO.aBa();
                }
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                c.this.awg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (c.this.dHO != null) {
                    c.this.dHO.aBa();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dHN.setTarget(view2);
        this.dHN.start();
    }

    public void awg() {
        if (this.dqX != null) {
            this.dqX.destroy();
            this.dqX = null;
        }
    }

    public void onDestroy() {
        if (this.dHN != null) {
            this.dHN.cancel();
            this.dHN = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        awg();
    }
}
