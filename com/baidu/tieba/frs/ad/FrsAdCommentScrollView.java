package com.baidu.tieba.frs.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView igA;
    private FrameLayout igB;
    private FrameLayout igC;
    private ValueAnimator igD;
    private List<j> igE;
    private int igF;
    private TextView igz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.igF;
        frsAdCommentScrollView.igF = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.igF = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.crV();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.igF = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.crV();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.igF = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.crV();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.igE = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.igz = (TextView) findViewById(R.id.cur_display_view);
        this.igA = (TextView) findViewById(R.id.next_display_view);
        this.igB = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.igB.setTag(this.igz);
        this.igC = (FrameLayout) findViewById(R.id.next_display_layout);
        this.igC.setTag(this.igA);
    }

    public void bL(boolean z) {
        if (z) {
            crT();
        }
    }

    public void bD(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.igE.clear();
        this.igE.addAll(list);
        setVisibility(0);
        this.igF = 0;
        crU();
        crT();
    }

    private void crT() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.igE) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crU() {
        j jVar;
        j jVar2 = (j) y.getItem(this.igE, this.igF);
        if (this.igF + 1 >= this.igE.size()) {
            jVar = (j) y.getItem(this.igE, 0);
        } else {
            jVar = (j) y.getItem(this.igE, this.igF + 1);
        }
        if ((this.igB.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dzI()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.igB.getTag()).setText(title);
        }
        if ((this.igC.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.igC.getTag()).setText(jVar.dzI() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crV() {
        final float y = this.igC.getY();
        this.igD = ValueAnimator.ofFloat(0.0f, this.igB.getMeasuredHeight());
        this.igD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.igB.setY(-floatValue);
                FrsAdCommentScrollView.this.igC.setY(y - floatValue);
            }
        });
        this.igD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.igF == FrsAdCommentScrollView.this.igE.size()) {
                    FrsAdCommentScrollView.this.igF = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.igB;
                FrsAdCommentScrollView.this.igB = FrsAdCommentScrollView.this.igC;
                FrsAdCommentScrollView.this.igC = frameLayout;
                FrsAdCommentScrollView.this.igC.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.crU();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.igD.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.igD != null) {
            this.igD.cancel();
        }
    }
}
