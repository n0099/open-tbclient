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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private FrameLayout hdA;
    private ValueAnimator hdB;
    private List<j> hdC;
    private int hdD;
    private TextView hdx;
    private TextView hdy;
    private FrameLayout hdz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.hdD;
        frsAdCommentScrollView.hdD = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.hdD = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bQU();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.hdD = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bQU();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.hdD = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bQU();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.hdC = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.hdx = (TextView) findViewById(R.id.cur_display_view);
        this.hdy = (TextView) findViewById(R.id.next_display_view);
        this.hdz = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.hdz.setTag(this.hdx);
        this.hdA = (FrameLayout) findViewById(R.id.next_display_layout);
        this.hdA.setTag(this.hdy);
    }

    public void jb(boolean z) {
        if (z) {
            bQS();
        }
    }

    public void bp(List<j> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.hdC.clear();
        this.hdC.addAll(list);
        setVisibility(0);
        this.hdD = 0;
        bQT();
        bQS();
    }

    private void bQS() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.hdC) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQT() {
        j jVar;
        j jVar2 = (j) v.getItem(this.hdC, this.hdD);
        if (this.hdD + 1 >= this.hdC.size()) {
            jVar = (j) v.getItem(this.hdC, 0);
        } else {
            jVar = (j) v.getItem(this.hdC, this.hdD + 1);
        }
        if ((this.hdz.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.cVu()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.hdz.getTag()).setText(title);
        }
        if ((this.hdA.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.hdA.getTag()).setText(jVar.cVu() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQU() {
        final float y = this.hdA.getY();
        this.hdB = ValueAnimator.ofFloat(0.0f, this.hdz.getMeasuredHeight());
        this.hdB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.hdz.setY(-floatValue);
                FrsAdCommentScrollView.this.hdA.setY(y - floatValue);
            }
        });
        this.hdB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.hdD == FrsAdCommentScrollView.this.hdC.size()) {
                    FrsAdCommentScrollView.this.hdD = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.hdz;
                FrsAdCommentScrollView.this.hdz = FrsAdCommentScrollView.this.hdA;
                FrsAdCommentScrollView.this.hdA = frameLayout;
                FrsAdCommentScrollView.this.hdA.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bQT();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hdB.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.hdB != null) {
            this.hdB.cancel();
        }
    }
}
