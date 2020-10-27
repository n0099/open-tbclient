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
    private TextView iHS;
    private TextView iHT;
    private FrameLayout iHU;
    private FrameLayout iHV;
    private ValueAnimator iHW;
    private List<j> iHX;
    private int iHY;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.iHY;
        frsAdCommentScrollView.iHY = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.iHY = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cyA();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.iHY = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cyA();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.iHY = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cyA();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.iHX = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.iHS = (TextView) findViewById(R.id.cur_display_view);
        this.iHT = (TextView) findViewById(R.id.next_display_view);
        this.iHU = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.iHU.setTag(this.iHS);
        this.iHV = (FrameLayout) findViewById(R.id.next_display_layout);
        this.iHV.setTag(this.iHT);
    }

    public void bP(boolean z) {
        if (z) {
            cyy();
        }
    }

    public void bQ(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.iHX.clear();
        this.iHX.addAll(list);
        setVisibility(0);
        this.iHY = 0;
        cyz();
        cyy();
    }

    private void cyy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.iHX) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyz() {
        j jVar;
        j jVar2 = (j) y.getItem(this.iHX, this.iHY);
        if (this.iHY + 1 >= this.iHX.size()) {
            jVar = (j) y.getItem(this.iHX, 0);
        } else {
            jVar = (j) y.getItem(this.iHX, this.iHY + 1);
        }
        if ((this.iHU.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dGB()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.iHU.getTag()).setText(title);
        }
        if ((this.iHV.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.iHV.getTag()).setText(jVar.dGB() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyA() {
        final float y = this.iHV.getY();
        this.iHW = ValueAnimator.ofFloat(0.0f, this.iHU.getMeasuredHeight());
        this.iHW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.iHU.setY(-floatValue);
                FrsAdCommentScrollView.this.iHV.setY(y - floatValue);
            }
        });
        this.iHW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.iHY == FrsAdCommentScrollView.this.iHX.size()) {
                    FrsAdCommentScrollView.this.iHY = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.iHU;
                FrsAdCommentScrollView.this.iHU = FrsAdCommentScrollView.this.iHV;
                FrsAdCommentScrollView.this.iHV = frameLayout;
                FrsAdCommentScrollView.this.iHV.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cyz();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iHW.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.iHW != null) {
            this.iHW.cancel();
        }
    }
}
