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
/* loaded from: classes21.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView iOC;
    private TextView iOD;
    private FrameLayout iOE;
    private FrameLayout iOF;
    private ValueAnimator iOG;
    private List<j> iOH;
    private int iOI;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.iOI;
        frsAdCommentScrollView.iOI = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.iOI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cAE();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.iOI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cAE();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.iOI = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cAE();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.iOH = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.iOC = (TextView) findViewById(R.id.cur_display_view);
        this.iOD = (TextView) findViewById(R.id.next_display_view);
        this.iOE = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.iOE.setTag(this.iOC);
        this.iOF = (FrameLayout) findViewById(R.id.next_display_layout);
        this.iOF.setTag(this.iOD);
    }

    public void bS(boolean z) {
        if (z) {
            cAC();
        }
    }

    public void bX(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.iOH.clear();
        this.iOH.addAll(list);
        setVisibility(0);
        this.iOI = 0;
        cAD();
        cAC();
    }

    private void cAC() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.iOH) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAD() {
        j jVar;
        j jVar2 = (j) y.getItem(this.iOH, this.iOI);
        if (this.iOI + 1 >= this.iOH.size()) {
            jVar = (j) y.getItem(this.iOH, 0);
        } else {
            jVar = (j) y.getItem(this.iOH, this.iOI + 1);
        }
        if ((this.iOE.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dIU()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.iOE.getTag()).setText(title);
        }
        if ((this.iOF.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.iOF.getTag()).setText(jVar.dIU() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAE() {
        final float y = this.iOF.getY();
        this.iOG = ValueAnimator.ofFloat(0.0f, this.iOE.getMeasuredHeight());
        this.iOG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.iOE.setY(-floatValue);
                FrsAdCommentScrollView.this.iOF.setY(y - floatValue);
            }
        });
        this.iOG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.iOI == FrsAdCommentScrollView.this.iOH.size()) {
                    FrsAdCommentScrollView.this.iOI = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.iOE;
                FrsAdCommentScrollView.this.iOE = FrsAdCommentScrollView.this.iOF;
                FrsAdCommentScrollView.this.iOF = frameLayout;
                FrsAdCommentScrollView.this.iOF.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cAD();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iOG.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.iOG != null) {
            this.iOG.cancel();
        }
    }
}
