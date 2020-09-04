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
/* loaded from: classes16.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private List<j> hZA;
    private int hZB;
    private TextView hZv;
    private TextView hZw;
    private FrameLayout hZx;
    private FrameLayout hZy;
    private ValueAnimator hZz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.hZB;
        frsAdCommentScrollView.hZB = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.hZB = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.coI();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.hZB = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.coI();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.hZB = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.coI();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.hZA = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.hZv = (TextView) findViewById(R.id.cur_display_view);
        this.hZw = (TextView) findViewById(R.id.next_display_view);
        this.hZx = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.hZx.setTag(this.hZv);
        this.hZy = (FrameLayout) findViewById(R.id.next_display_layout);
        this.hZy.setTag(this.hZw);
    }

    public void bJ(boolean z) {
        if (z) {
            coG();
        }
    }

    public void by(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.hZA.clear();
        this.hZA.addAll(list);
        setVisibility(0);
        this.hZB = 0;
        coH();
        coG();
    }

    private void coG() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.hZA) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coH() {
        j jVar;
        j jVar2 = (j) y.getItem(this.hZA, this.hZB);
        if (this.hZB + 1 >= this.hZA.size()) {
            jVar = (j) y.getItem(this.hZA, 0);
        } else {
            jVar = (j) y.getItem(this.hZA, this.hZB + 1);
        }
        if ((this.hZx.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dvP()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.hZx.getTag()).setText(title);
        }
        if ((this.hZy.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.hZy.getTag()).setText(jVar.dvP() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coI() {
        final float y = this.hZy.getY();
        this.hZz = ValueAnimator.ofFloat(0.0f, this.hZx.getMeasuredHeight());
        this.hZz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.hZx.setY(-floatValue);
                FrsAdCommentScrollView.this.hZy.setY(y - floatValue);
            }
        });
        this.hZz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.hZB == FrsAdCommentScrollView.this.hZA.size()) {
                    FrsAdCommentScrollView.this.hZB = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.hZx;
                FrsAdCommentScrollView.this.hZx = FrsAdCommentScrollView.this.hZy;
                FrsAdCommentScrollView.this.hZy = frameLayout;
                FrsAdCommentScrollView.this.hZy.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.coH();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hZz.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.hZz != null) {
            this.hZz.cancel();
        }
    }
}
