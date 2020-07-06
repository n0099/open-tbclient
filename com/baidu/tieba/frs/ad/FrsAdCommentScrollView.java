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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView hFm;
    private TextView hFn;
    private FrameLayout hFo;
    private FrameLayout hFp;
    private ValueAnimator hFq;
    private List<j> hFr;
    private int hFs;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.hFs;
        frsAdCommentScrollView.hFs = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.hFs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.caF();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.hFs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.caF();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.hFs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.caF();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.hFr = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.hFm = (TextView) findViewById(R.id.cur_display_view);
        this.hFn = (TextView) findViewById(R.id.next_display_view);
        this.hFo = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.hFo.setTag(this.hFm);
        this.hFp = (FrameLayout) findViewById(R.id.next_display_layout);
        this.hFp.setTag(this.hFn);
    }

    public void bB(boolean z) {
        if (z) {
            caD();
        }
    }

    public void aP(List<j> list) {
        if (w.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.hFr.clear();
        this.hFr.addAll(list);
        setVisibility(0);
        this.hFs = 0;
        caE();
        caD();
    }

    private void caD() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (w.getCount(this.hFr) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caE() {
        j jVar;
        j jVar2 = (j) w.getItem(this.hFr, this.hFs);
        if (this.hFs + 1 >= this.hFr.size()) {
            jVar = (j) w.getItem(this.hFr, 0);
        } else {
            jVar = (j) w.getItem(this.hFr, this.hFs + 1);
        }
        if ((this.hFo.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dhe()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.hFo.getTag()).setText(title);
        }
        if ((this.hFp.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.hFp.getTag()).setText(jVar.dhe() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caF() {
        final float y = this.hFp.getY();
        this.hFq = ValueAnimator.ofFloat(0.0f, this.hFo.getMeasuredHeight());
        this.hFq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.hFo.setY(-floatValue);
                FrsAdCommentScrollView.this.hFp.setY(y - floatValue);
            }
        });
        this.hFq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.hFs == FrsAdCommentScrollView.this.hFr.size()) {
                    FrsAdCommentScrollView.this.hFs = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.hFo;
                FrsAdCommentScrollView.this.hFo = FrsAdCommentScrollView.this.hFp;
                FrsAdCommentScrollView.this.hFp = frameLayout;
                FrsAdCommentScrollView.this.hFp.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.caE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hFq.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.hFq != null) {
            this.hFq.cancel();
        }
    }
}
