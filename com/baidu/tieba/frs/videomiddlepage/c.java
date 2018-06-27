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
    private n buL;
    private g dEX;
    private com.baidu.tieba.frs.aggregation.g dEY;
    private e dEZ;
    private ValueAnimator dFa;
    private a dFb;
    private FrameLayout dnQ;
    private FrameLayout dnR;
    private com.baidu.tieba.play.c doe;
    private int mWidth;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void aAs();

        void aAt();
    }

    public void a(g gVar) {
        this.dEX = gVar;
    }

    public com.baidu.tieba.frs.aggregation.g aAq() {
        if (this.dEY == null) {
            this.dEY = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.dEY, this.dEX.aAv());
        return this.dEY;
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
            gVar.doE = aVar;
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
            gVar.doF = bVar;
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
        if (this.dEY != null && this.dEX != null && this.dEX.aAv() != null && this.dEX.aAv().mVideoCardViewInfo != null) {
            this.dFb = aVar;
            this.dEZ = eVar;
            this.dEZ.go(false);
            this.rootView = View.inflate(tbPageContext.getPageActivity(), d.i.card_video_middle_page_layout, null);
            this.mWidth = l.ah(tbPageContext.getPageActivity());
            this.rootView.findViewById(d.g.user_container).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title).setVisibility(4);
            this.rootView.findViewById(d.g.video_agg_container_foreground).setVisibility(4);
            this.dnQ = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
            this.dnR = (FrameLayout) this.rootView.findViewById(d.g.video_container);
            this.doe = new com.baidu.tieba.play.c(tbPageContext, this.dnR, false);
            this.buL = new n(tbPageContext.getPageActivity());
            b(this.dEY, 0, eVar);
            if (this.rootView.getParent() != null) {
                ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
            }
            int i2 = this.dEX.aAv().mVideoCardViewInfo.cardViewX;
            int i3 = this.dEX.aAv().mVideoCardViewInfo.cardViewY;
            int i4 = this.dEX.aAv().mVideoCardViewInfo.cardViewWidth;
            int i5 = this.dEX.aAv().mVideoCardViewInfo.cardViewHeight;
            this.dnQ.setX(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dnQ.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.dnQ.setLayoutParams(layoutParams);
            this.rootView.setY(i3 - l.e(tbPageContext.getPageActivity(), d.e.tbds154));
            relativeLayout.addView(this.rootView);
            int i6 = this.mWidth;
            int aAr = aAr();
            if (i4 == i6) {
                i4 = i6 - l.e(tbPageContext.getPageActivity(), d.e.ds72);
            }
            a(this.rootView, this.dnQ, i2, 0, i3, i, i4, i6, i5, aAr);
        }
    }

    private int aAr() {
        return !aAl() ? (int) (0.875f * this.mWidth) : (int) (0.5625f * this.mWidth);
    }

    private boolean aAl() {
        try {
            int parseInt = Integer.parseInt(this.dEY.doF.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dEY.doF.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.doF != null) {
            this.doe.stopPlay();
            this.doe.lE(true);
            this.doe.lH(true);
            this.doe.lF(false);
            this.doe.N(false, true);
            this.doe.lI(true);
            this.doe.rI(i);
            this.doe.lC(false);
            this.doe.getVideoView().setBusiness(this.buL);
            this.doe.aRa();
            this.doe.pr(gVar.doF.thumbnailUrl);
            this.doe.bW(gVar.doF.videoUrl, gVar.threadId);
            this.doe.aEd();
            this.doe.show();
        }
    }

    private void a(final View view, final View view2, final int i, final int i2, final int i3, final int i4, int i5, int i6, final int i7, final int i8) {
        int i9 = i > i2 ? i : i2;
        final int i10 = i9 - ((i + i2) - i9);
        int i11 = i3 > i4 ? i3 : i4;
        final int i12 = i11 - ((i3 + i4) - i11);
        int i13 = i8 > i7 ? i8 : i7;
        final int i14 = i13 - ((i8 + i7) - i13);
        this.dFa = ValueAnimator.ofInt(i5, i6);
        this.dFa.setDuration(400L);
        this.dFa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.1
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
        this.dFa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (c.this.dFb != null) {
                    c.this.dFb.aAs();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.dEZ != null) {
                    c.this.dEZ.go(true);
                }
                if (c.this.dFb != null) {
                    c.this.dFb.aAt();
                }
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                c.this.avB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (c.this.dFb != null) {
                    c.this.dFb.aAt();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dFa.setTarget(view2);
        this.dFa.start();
    }

    public void avB() {
        if (this.doe != null) {
            this.doe.destroy();
            this.doe = null;
        }
    }

    public void onDestroy() {
        if (this.dFa != null) {
            this.dFa.cancel();
            this.dFa = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        avB();
    }
}
