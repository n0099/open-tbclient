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
    private n blg;
    private FrameLayout dbP;
    private FrameLayout dbQ;
    private com.baidu.tieba.play.c dcc;
    private a dsA;
    private g dsw;
    private com.baidu.tieba.frs.aggregation.g dsx;
    private e dsy;
    private ValueAnimator dsz;
    private int mWidth;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void avC();

        void avD();
    }

    public void a(g gVar) {
        this.dsw = gVar;
    }

    public com.baidu.tieba.frs.aggregation.g avA() {
        if (this.dsx == null) {
            this.dsx = new com.baidu.tieba.frs.aggregation.g();
        }
        a(this.dsx, this.dsw.avF());
        return this.dsx;
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
            gVar.dcD = aVar;
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
            gVar.dcE = bVar;
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
        if (this.dsx != null && this.dsw != null && this.dsw.avF() != null && this.dsw.avF().mVideoCardViewInfo != null) {
            this.dsA = aVar;
            this.dsy = eVar;
            this.dsy.fZ(false);
            this.rootView = View.inflate(tbPageContext.getPageActivity(), d.i.card_video_middle_page_layout, null);
            this.mWidth = l.af(tbPageContext.getPageActivity());
            this.rootView.findViewById(d.g.user_container).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout).setVisibility(4);
            this.rootView.findViewById(d.g.comment_and_priase_layout_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title_foreground).setVisibility(4);
            this.rootView.findViewById(d.g.title).setVisibility(4);
            this.rootView.findViewById(d.g.video_agg_container_foreground).setVisibility(4);
            this.dbP = (FrameLayout) this.rootView.findViewById(d.g.video_agg_container);
            this.dbQ = (FrameLayout) this.rootView.findViewById(d.g.video_container);
            this.dcc = new com.baidu.tieba.play.c(tbPageContext, this.dbQ, false);
            this.blg = new n(tbPageContext.getPageActivity());
            b(this.dsx, 0, eVar);
            if (this.rootView.getParent() != null) {
                ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
            }
            int i2 = this.dsw.avF().mVideoCardViewInfo.cardViewX;
            int i3 = this.dsw.avF().mVideoCardViewInfo.cardViewY;
            int i4 = this.dsw.avF().mVideoCardViewInfo.cardViewWidth;
            int i5 = this.dsw.avF().mVideoCardViewInfo.cardViewHeight;
            this.dbP.setX(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dbP.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.dbP.setLayoutParams(layoutParams);
            this.rootView.setY(i3 - l.e(tbPageContext.getPageActivity(), d.e.tbds154));
            relativeLayout.addView(this.rootView);
            int i6 = this.mWidth;
            int avB = avB();
            if (i4 == i6) {
                i4 = i6 - l.e(tbPageContext.getPageActivity(), d.e.ds72);
            }
            a(this.rootView, this.dbP, i2, 0, i3, i, i4, i6, i5, avB);
        }
    }

    private int avB() {
        return !avv() ? (int) (0.875f * this.mWidth) : (int) (0.5625f * this.mWidth);
    }

    private boolean avv() {
        try {
            int parseInt = Integer.parseInt(this.dsx.dcE.videoWidth);
            return parseInt <= 0 || ((float) Integer.parseInt(this.dsx.dcE.videoHeight)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private void b(com.baidu.tieba.frs.aggregation.g gVar, int i, com.baidu.tieba.frs.aggregation.a aVar) {
        if (gVar != null && gVar.dcE != null) {
            this.dcc.stopPlay();
            this.dcc.lo(true);
            this.dcc.lr(true);
            this.dcc.lp(false);
            this.dcc.K(false, true);
            this.dcc.ls(true);
            this.dcc.rn(i);
            this.dcc.lm(false);
            this.dcc.getVideoView().setBusiness(this.blg);
            this.dcc.aLx();
            this.dcc.oC(gVar.dcE.thumbnailUrl);
            this.dcc.bK(gVar.dcE.videoUrl, gVar.threadId);
            this.dcc.ayy();
            this.dcc.show();
        }
    }

    private void a(final View view2, final View view3, final int i, final int i2, final int i3, final int i4, int i5, int i6, final int i7, final int i8) {
        int i9 = i > i2 ? i : i2;
        final int i10 = i9 - ((i + i2) - i9);
        int i11 = i3 > i4 ? i3 : i4;
        final int i12 = i11 - ((i3 + i4) - i11);
        int i13 = i8 > i7 ? i8 : i7;
        final int i14 = i13 - ((i8 + i7) - i13);
        this.dsz = ValueAnimator.ofInt(i5, i6);
        this.dsz.setDuration(400L);
        this.dsz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.1
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
        this.dsz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.videomiddlepage.c.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (c.this.dsA != null) {
                    c.this.dsA.avC();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.dsy != null) {
                    c.this.dsy.fZ(true);
                }
                if (c.this.dsA != null) {
                    c.this.dsA.avD();
                }
                if (view3.getParent() != null) {
                    ((ViewGroup) view3.getParent()).removeView(view3);
                }
                c.this.aqS();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (c.this.dsA != null) {
                    c.this.dsA.avD();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dsz.setTarget(view3);
        this.dsz.start();
    }

    public void aqS() {
        if (this.dcc != null) {
            this.dcc.destroy();
            this.dcc = null;
        }
    }

    public void onDestroy() {
        if (this.dsz != null) {
            this.dsz.cancel();
            this.dsz = null;
        }
        if (this.rootView != null) {
            this.rootView.clearAnimation();
        }
        aqS();
    }
}
