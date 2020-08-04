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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView hLk;
    private TextView hLl;
    private FrameLayout hLm;
    private FrameLayout hLn;
    private ValueAnimator hLo;
    private List<j> hLp;
    private int hLq;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.hLq;
        frsAdCommentScrollView.hLq = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.hLq = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.ced();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.hLq = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.ced();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.hLq = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.ced();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.hLp = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.hLk = (TextView) findViewById(R.id.cur_display_view);
        this.hLl = (TextView) findViewById(R.id.next_display_view);
        this.hLm = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.hLm.setTag(this.hLk);
        this.hLn = (FrameLayout) findViewById(R.id.next_display_layout);
        this.hLn.setTag(this.hLl);
    }

    public void bE(boolean z) {
        if (z) {
            ceb();
        }
    }

    public void aV(List<j> list) {
        if (x.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.hLp.clear();
        this.hLp.addAll(list);
        setVisibility(0);
        this.hLq = 0;
        cec();
        ceb();
    }

    private void ceb() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (x.getCount(this.hLp) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cec() {
        j jVar;
        j jVar2 = (j) x.getItem(this.hLp, this.hLq);
        if (this.hLq + 1 >= this.hLp.size()) {
            jVar = (j) x.getItem(this.hLp, 0);
        } else {
            jVar = (j) x.getItem(this.hLp, this.hLq + 1);
        }
        if ((this.hLm.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dkn()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.hLm.getTag()).setText(title);
        }
        if ((this.hLn.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.hLn.getTag()).setText(jVar.dkn() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ced() {
        final float y = this.hLn.getY();
        this.hLo = ValueAnimator.ofFloat(0.0f, this.hLm.getMeasuredHeight());
        this.hLo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.hLm.setY(-floatValue);
                FrsAdCommentScrollView.this.hLn.setY(y - floatValue);
            }
        });
        this.hLo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.hLq == FrsAdCommentScrollView.this.hLp.size()) {
                    FrsAdCommentScrollView.this.hLq = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.hLm;
                FrsAdCommentScrollView.this.hLm = FrsAdCommentScrollView.this.hLn;
                FrsAdCommentScrollView.this.hLn = frameLayout;
                FrsAdCommentScrollView.this.hLn.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cec();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hLo.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.hLo != null) {
            this.hLo.cancel();
        }
    }
}
