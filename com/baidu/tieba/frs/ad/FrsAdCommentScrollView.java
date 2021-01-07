package com.baidu.tieba.frs.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView jlI;
    private TextView jlJ;
    private FrameLayout jlK;
    private FrameLayout jlL;
    private ValueAnimator jlM;
    private List<j> jlN;
    private int mCurIndex;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.mCurIndex;
        frsAdCommentScrollView.mCurIndex = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.mCurIndex = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cHR();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.mCurIndex = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cHR();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.mCurIndex = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cHR();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.jlN = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.jlI = (TextView) findViewById(R.id.cur_display_view);
        this.jlJ = (TextView) findViewById(R.id.next_display_view);
        this.jlK = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.jlK.setTag(this.jlI);
        this.jlL = (FrameLayout) findViewById(R.id.next_display_layout);
        this.jlL.setTag(this.jlJ);
    }

    public void ca(boolean z) {
        if (z) {
            cHP();
        }
    }

    public void ci(List<j> list) {
        if (x.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.jlN.clear();
        this.jlN.addAll(list);
        setVisibility(0);
        this.mCurIndex = 0;
        cHQ();
        cHP();
    }

    private void cHP() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (x.getCount(this.jlN) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHQ() {
        j jVar;
        j jVar2 = (j) x.getItem(this.jlN, this.mCurIndex);
        if (this.mCurIndex + 1 >= this.jlN.size()) {
            jVar = (j) x.getItem(this.jlN, 0);
        } else {
            jVar = (j) x.getItem(this.jlN, this.mCurIndex + 1);
        }
        if ((this.jlK.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dOe()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.jlK.getTag()).setText(title);
        }
        if ((this.jlL.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.jlL.getTag()).setText(jVar.dOe() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHR() {
        final float y = this.jlL.getY();
        this.jlM = ValueAnimator.ofFloat(0.0f, this.jlK.getMeasuredHeight());
        this.jlM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.jlK.setY(-floatValue);
                FrsAdCommentScrollView.this.jlL.setY(y - floatValue);
            }
        });
        this.jlM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.mCurIndex == FrsAdCommentScrollView.this.jlN.size()) {
                    FrsAdCommentScrollView.this.mCurIndex = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.jlK;
                FrsAdCommentScrollView.this.jlK = FrsAdCommentScrollView.this.jlL;
                FrsAdCommentScrollView.this.jlL = frameLayout;
                FrsAdCommentScrollView.this.jlL.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cHQ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlM.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.jlM != null) {
            this.jlM.cancel();
        }
    }
}
