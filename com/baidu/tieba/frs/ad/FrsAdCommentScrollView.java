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
    private TextView hZp;
    private TextView hZq;
    private FrameLayout hZr;
    private FrameLayout hZs;
    private ValueAnimator hZt;
    private List<j> hZu;
    private int hZv;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.hZv;
        frsAdCommentScrollView.hZv = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.hZv = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.coH();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.hZv = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.coH();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.hZv = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.coH();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.hZu = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.hZp = (TextView) findViewById(R.id.cur_display_view);
        this.hZq = (TextView) findViewById(R.id.next_display_view);
        this.hZr = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.hZr.setTag(this.hZp);
        this.hZs = (FrameLayout) findViewById(R.id.next_display_layout);
        this.hZs.setTag(this.hZq);
    }

    public void bJ(boolean z) {
        if (z) {
            coF();
        }
    }

    public void by(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.hZu.clear();
        this.hZu.addAll(list);
        setVisibility(0);
        this.hZv = 0;
        coG();
        coF();
    }

    private void coF() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.hZu) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coG() {
        j jVar;
        j jVar2 = (j) y.getItem(this.hZu, this.hZv);
        if (this.hZv + 1 >= this.hZu.size()) {
            jVar = (j) y.getItem(this.hZu, 0);
        } else {
            jVar = (j) y.getItem(this.hZu, this.hZv + 1);
        }
        if ((this.hZr.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dvK()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.hZr.getTag()).setText(title);
        }
        if ((this.hZs.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.hZs.getTag()).setText(jVar.dvK() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coH() {
        final float y = this.hZs.getY();
        this.hZt = ValueAnimator.ofFloat(0.0f, this.hZr.getMeasuredHeight());
        this.hZt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.hZr.setY(-floatValue);
                FrsAdCommentScrollView.this.hZs.setY(y - floatValue);
            }
        });
        this.hZt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.hZv == FrsAdCommentScrollView.this.hZu.size()) {
                    FrsAdCommentScrollView.this.hZv = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.hZr;
                FrsAdCommentScrollView.this.hZr = FrsAdCommentScrollView.this.hZs;
                FrsAdCommentScrollView.this.hZs = frameLayout;
                FrsAdCommentScrollView.this.hZs.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.coG();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hZt.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.hZt != null) {
            this.hZt.cancel();
        }
    }
}
