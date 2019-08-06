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
/* loaded from: classes4.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private int etI;
    private ValueAnimator etJ;
    private FrameLayout fzA;
    private List<i> fzB;
    private TextView fzx;
    private TextView fzy;
    private FrameLayout fzz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.etI;
        frsAdCommentScrollView.etI = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.etI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.aYk();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.etI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.aYk();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.etI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.aYk();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.fzB = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.fzx = (TextView) findViewById(R.id.cur_display_view);
        this.fzy = (TextView) findViewById(R.id.next_display_view);
        this.fzz = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.fzz.setTag(this.fzx);
        this.fzA = (FrameLayout) findViewById(R.id.next_display_layout);
        this.fzA.setTag(this.fzy);
    }

    public void jS(boolean z) {
        if (z) {
            boq();
        }
    }

    public void aU(List<i> list) {
        if (v.Z(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.fzB.clear();
        this.fzB.addAll(list);
        setVisibility(0);
        this.etI = 0;
        bor();
        boq();
    }

    private void boq() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.Z(this.fzB) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bor() {
        i iVar;
        i iVar2 = (i) v.c(this.fzB, this.etI);
        if (this.etI + 1 >= this.fzB.size()) {
            iVar = (i) v.c(this.fzB, 0);
        } else {
            iVar = (i) v.c(this.fzB, this.etI + 1);
        }
        if ((this.fzz.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.coM()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.fzz.getTag()).setText(title);
        }
        if ((this.fzA.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.fzA.getTag()).setText(iVar.coM() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYk() {
        final float y = this.fzA.getY();
        this.etJ = ValueAnimator.ofFloat(0.0f, this.fzz.getMeasuredHeight());
        this.etJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.fzz.setY(-floatValue);
                FrsAdCommentScrollView.this.fzA.setY(y - floatValue);
            }
        });
        this.etJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.etI == FrsAdCommentScrollView.this.fzB.size()) {
                    FrsAdCommentScrollView.this.etI = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.fzz;
                FrsAdCommentScrollView.this.fzz = FrsAdCommentScrollView.this.fzA;
                FrsAdCommentScrollView.this.fzA = frameLayout;
                FrsAdCommentScrollView.this.fzA.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bor();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.etJ.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.etJ != null) {
            this.etJ.cancel();
        }
    }
}
