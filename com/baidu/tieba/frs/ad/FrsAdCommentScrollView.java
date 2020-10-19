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
    private ValueAnimator ivA;
    private List<j> ivB;
    private int ivC;
    private TextView ivw;
    private TextView ivx;
    private FrameLayout ivy;
    private FrameLayout ivz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.ivC;
        frsAdCommentScrollView.ivC = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.ivC = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cvt();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.ivC = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cvt();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.ivC = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cvt();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.ivB = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.ivw = (TextView) findViewById(R.id.cur_display_view);
        this.ivx = (TextView) findViewById(R.id.next_display_view);
        this.ivy = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.ivy.setTag(this.ivw);
        this.ivz = (FrameLayout) findViewById(R.id.next_display_layout);
        this.ivz.setTag(this.ivx);
    }

    public void bO(boolean z) {
        if (z) {
            cvr();
        }
    }

    public void bG(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.ivB.clear();
        this.ivB.addAll(list);
        setVisibility(0);
        this.ivC = 0;
        cvs();
        cvr();
    }

    private void cvr() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.ivB) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvs() {
        j jVar;
        j jVar2 = (j) y.getItem(this.ivB, this.ivC);
        if (this.ivC + 1 >= this.ivB.size()) {
            jVar = (j) y.getItem(this.ivB, 0);
        } else {
            jVar = (j) y.getItem(this.ivB, this.ivC + 1);
        }
        if ((this.ivy.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dDt()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.ivy.getTag()).setText(title);
        }
        if ((this.ivz.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.ivz.getTag()).setText(jVar.dDt() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvt() {
        final float y = this.ivz.getY();
        this.ivA = ValueAnimator.ofFloat(0.0f, this.ivy.getMeasuredHeight());
        this.ivA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.ivy.setY(-floatValue);
                FrsAdCommentScrollView.this.ivz.setY(y - floatValue);
            }
        });
        this.ivA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.ivC == FrsAdCommentScrollView.this.ivB.size()) {
                    FrsAdCommentScrollView.this.ivC = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.ivy;
                FrsAdCommentScrollView.this.ivy = FrsAdCommentScrollView.this.ivz;
                FrsAdCommentScrollView.this.ivz = frameLayout;
                FrsAdCommentScrollView.this.ivz.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cvs();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ivA.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.ivA != null) {
            this.ivA.cancel();
        }
    }
}
