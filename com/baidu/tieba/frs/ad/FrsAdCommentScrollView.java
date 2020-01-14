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
import com.baidu.tieba.tbadkCore.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView grm;
    private TextView grn;
    private FrameLayout gro;
    private FrameLayout grp;
    private ValueAnimator grq;
    private List<i> grr;
    private int grs;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.grs;
        frsAdCommentScrollView.grs = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.grs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bEE();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.grs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bEE();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.grs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bEE();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.grr = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.grm = (TextView) findViewById(R.id.cur_display_view);
        this.grn = (TextView) findViewById(R.id.next_display_view);
        this.gro = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.gro.setTag(this.grm);
        this.grp = (FrameLayout) findViewById(R.id.next_display_layout);
        this.grp.setTag(this.grn);
    }

    public void lg(boolean z) {
        if (z) {
            bEC();
        }
    }

    public void bf(List<i> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.grr.clear();
        this.grr.addAll(list);
        setVisibility(0);
        this.grs = 0;
        bED();
        bEC();
    }

    private void bEC() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.grr) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bED() {
        i iVar;
        i iVar2 = (i) v.getItem(this.grr, this.grs);
        if (this.grs + 1 >= this.grr.size()) {
            iVar = (i) v.getItem(this.grr, 0);
        } else {
            iVar = (i) v.getItem(this.grr, this.grs + 1);
        }
        if ((this.gro.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.cIA()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.gro.getTag()).setText(title);
        }
        if ((this.grp.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.grp.getTag()).setText(iVar.cIA() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEE() {
        final float y = this.grp.getY();
        this.grq = ValueAnimator.ofFloat(0.0f, this.gro.getMeasuredHeight());
        this.grq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.gro.setY(-floatValue);
                FrsAdCommentScrollView.this.grp.setY(y - floatValue);
            }
        });
        this.grq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.grs == FrsAdCommentScrollView.this.grr.size()) {
                    FrsAdCommentScrollView.this.grs = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.gro;
                FrsAdCommentScrollView.this.gro = FrsAdCommentScrollView.this.grp;
                FrsAdCommentScrollView.this.grp = frameLayout;
                FrsAdCommentScrollView.this.grp.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bED();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.grq.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.grq != null) {
            this.grq.cancel();
        }
    }
}
