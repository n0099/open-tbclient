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
/* loaded from: classes22.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private List<j> iZA;
    private int iZB;
    private TextView iZv;
    private TextView iZw;
    private FrameLayout iZx;
    private FrameLayout iZy;
    private ValueAnimator iZz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.iZB;
        frsAdCommentScrollView.iZB = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.iZB = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cEV();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.iZB = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cEV();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.iZB = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cEV();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.iZA = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.iZv = (TextView) findViewById(R.id.cur_display_view);
        this.iZw = (TextView) findViewById(R.id.next_display_view);
        this.iZx = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.iZx.setTag(this.iZv);
        this.iZy = (FrameLayout) findViewById(R.id.next_display_layout);
        this.iZy.setTag(this.iZw);
    }

    public void cb(boolean z) {
        if (z) {
            cET();
        }
    }

    public void cb(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.iZA.clear();
        this.iZA.addAll(list);
        setVisibility(0);
        this.iZB = 0;
        cEU();
        cET();
    }

    private void cET() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.iZA) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEU() {
        j jVar;
        j jVar2 = (j) y.getItem(this.iZA, this.iZB);
        if (this.iZB + 1 >= this.iZA.size()) {
            jVar = (j) y.getItem(this.iZA, 0);
        } else {
            jVar = (j) y.getItem(this.iZA, this.iZB + 1);
        }
        if ((this.iZx.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dOl()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.iZx.getTag()).setText(title);
        }
        if ((this.iZy.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.iZy.getTag()).setText(jVar.dOl() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEV() {
        final float y = this.iZy.getY();
        this.iZz = ValueAnimator.ofFloat(0.0f, this.iZx.getMeasuredHeight());
        this.iZz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.iZx.setY(-floatValue);
                FrsAdCommentScrollView.this.iZy.setY(y - floatValue);
            }
        });
        this.iZz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.iZB == FrsAdCommentScrollView.this.iZA.size()) {
                    FrsAdCommentScrollView.this.iZB = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.iZx;
                FrsAdCommentScrollView.this.iZx = FrsAdCommentScrollView.this.iZy;
                FrsAdCommentScrollView.this.iZy = frameLayout;
                FrsAdCommentScrollView.this.iZy.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cEU();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iZz.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.iZz != null) {
            this.iZz.cancel();
        }
    }
}
