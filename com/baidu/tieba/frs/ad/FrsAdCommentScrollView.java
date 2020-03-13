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
/* loaded from: classes9.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView gtC;
    private TextView gtD;
    private FrameLayout gtE;
    private FrameLayout gtF;
    private ValueAnimator gtG;
    private List<i> gtH;
    private int gtI;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.gtI;
        frsAdCommentScrollView.gtI = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.gtI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGj();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.gtI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGj();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.gtI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGj();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.gtH = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.gtC = (TextView) findViewById(R.id.cur_display_view);
        this.gtD = (TextView) findViewById(R.id.next_display_view);
        this.gtE = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.gtE.setTag(this.gtC);
        this.gtF = (FrameLayout) findViewById(R.id.next_display_layout);
        this.gtF.setTag(this.gtD);
    }

    public void onPrimary(boolean z) {
        if (z) {
            bGh();
        }
    }

    public void bf(List<i> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.gtH.clear();
        this.gtH.addAll(list);
        setVisibility(0);
        this.gtI = 0;
        bGi();
        bGh();
    }

    private void bGh() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.gtH) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGi() {
        i iVar;
        i iVar2 = (i) v.getItem(this.gtH, this.gtI);
        if (this.gtI + 1 >= this.gtH.size()) {
            iVar = (i) v.getItem(this.gtH, 0);
        } else {
            iVar = (i) v.getItem(this.gtH, this.gtI + 1);
        }
        if ((this.gtE.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.cKh()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.gtE.getTag()).setText(title);
        }
        if ((this.gtF.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.gtF.getTag()).setText(iVar.cKh() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGj() {
        final float y = this.gtF.getY();
        this.gtG = ValueAnimator.ofFloat(0.0f, this.gtE.getMeasuredHeight());
        this.gtG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.gtE.setY(-floatValue);
                FrsAdCommentScrollView.this.gtF.setY(y - floatValue);
            }
        });
        this.gtG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.gtI == FrsAdCommentScrollView.this.gtH.size()) {
                    FrsAdCommentScrollView.this.gtI = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.gtE;
                FrsAdCommentScrollView.this.gtE = FrsAdCommentScrollView.this.gtF;
                FrsAdCommentScrollView.this.gtF = frameLayout;
                FrsAdCommentScrollView.this.gtF.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bGi();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gtG.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.gtG != null) {
            this.gtG.cancel();
        }
    }
}
