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
    private TextView iZt;
    private TextView iZu;
    private FrameLayout iZv;
    private FrameLayout iZw;
    private ValueAnimator iZx;
    private List<j> iZy;
    private int iZz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.iZz;
        frsAdCommentScrollView.iZz = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.iZz = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cEU();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.iZz = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cEU();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.iZz = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.cEU();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.iZy = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.iZt = (TextView) findViewById(R.id.cur_display_view);
        this.iZu = (TextView) findViewById(R.id.next_display_view);
        this.iZv = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.iZv.setTag(this.iZt);
        this.iZw = (FrameLayout) findViewById(R.id.next_display_layout);
        this.iZw.setTag(this.iZu);
    }

    public void cb(boolean z) {
        if (z) {
            cES();
        }
    }

    public void cb(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.iZy.clear();
        this.iZy.addAll(list);
        setVisibility(0);
        this.iZz = 0;
        cET();
        cES();
    }

    private void cES() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.iZy) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cET() {
        j jVar;
        j jVar2 = (j) y.getItem(this.iZy, this.iZz);
        if (this.iZz + 1 >= this.iZy.size()) {
            jVar = (j) y.getItem(this.iZy, 0);
        } else {
            jVar = (j) y.getItem(this.iZy, this.iZz + 1);
        }
        if ((this.iZv.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dOk()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.iZv.getTag()).setText(title);
        }
        if ((this.iZw.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.iZw.getTag()).setText(jVar.dOk() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEU() {
        final float y = this.iZw.getY();
        this.iZx = ValueAnimator.ofFloat(0.0f, this.iZv.getMeasuredHeight());
        this.iZx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.iZv.setY(-floatValue);
                FrsAdCommentScrollView.this.iZw.setY(y - floatValue);
            }
        });
        this.iZx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.iZz == FrsAdCommentScrollView.this.iZy.size()) {
                    FrsAdCommentScrollView.this.iZz = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.iZv;
                FrsAdCommentScrollView.this.iZv = FrsAdCommentScrollView.this.iZw;
                FrsAdCommentScrollView.this.iZw = frameLayout;
                FrsAdCommentScrollView.this.iZw.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cET();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iZx.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.iZx != null) {
            this.iZx.cancel();
        }
    }
}
