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
    private TextView iNP;
    private TextView iNQ;
    private FrameLayout iNR;
    private FrameLayout iNS;
    private ValueAnimator iNT;
    private List<j> iNU;
    private int iNV;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.iNV;
        frsAdCommentScrollView.iNV = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.iNV = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cBb();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.iNV = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cBb();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.iNV = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cBb();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.iNU = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.iNP = (TextView) findViewById(R.id.cur_display_view);
        this.iNQ = (TextView) findViewById(R.id.next_display_view);
        this.iNR = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.iNR.setTag(this.iNP);
        this.iNS = (FrameLayout) findViewById(R.id.next_display_layout);
        this.iNS.setTag(this.iNQ);
    }

    public void bQ(boolean z) {
        if (z) {
            cAZ();
        }
    }

    public void bX(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.iNU.clear();
        this.iNU.addAll(list);
        setVisibility(0);
        this.iNV = 0;
        cBa();
        cAZ();
    }

    private void cAZ() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.iNU) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBa() {
        j jVar;
        j jVar2 = (j) y.getItem(this.iNU, this.iNV);
        if (this.iNV + 1 >= this.iNU.size()) {
            jVar = (j) y.getItem(this.iNU, 0);
        } else {
            jVar = (j) y.getItem(this.iNU, this.iNV + 1);
        }
        if ((this.iNR.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dJd()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.iNR.getTag()).setText(title);
        }
        if ((this.iNS.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.iNS.getTag()).setText(jVar.dJd() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBb() {
        final float y = this.iNS.getY();
        this.iNT = ValueAnimator.ofFloat(0.0f, this.iNR.getMeasuredHeight());
        this.iNT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.iNR.setY(-floatValue);
                FrsAdCommentScrollView.this.iNS.setY(y - floatValue);
            }
        });
        this.iNT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.iNV == FrsAdCommentScrollView.this.iNU.size()) {
                    FrsAdCommentScrollView.this.iNV = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.iNR;
                FrsAdCommentScrollView.this.iNR = FrsAdCommentScrollView.this.iNS;
                FrsAdCommentScrollView.this.iNS = frameLayout;
                FrsAdCommentScrollView.this.iNS.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cBa();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iNT.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.iNT != null) {
            this.iNT.cancel();
        }
    }
}
