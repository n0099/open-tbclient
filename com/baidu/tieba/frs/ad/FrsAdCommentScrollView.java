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
import com.baidu.tieba.tbadkCore.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private ValueAnimator hsA;
    private List<j> hsB;
    private int hsC;
    private TextView hsw;
    private TextView hsx;
    private FrameLayout hsy;
    private FrameLayout hsz;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.hsC;
        frsAdCommentScrollView.hsC = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.hsC = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bXt();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.hsC = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bXt();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.hsC = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bXt();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.hsB = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.hsw = (TextView) findViewById(R.id.cur_display_view);
        this.hsx = (TextView) findViewById(R.id.next_display_view);
        this.hsy = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.hsy.setTag(this.hsw);
        this.hsz = (FrameLayout) findViewById(R.id.next_display_layout);
        this.hsz.setTag(this.hsx);
    }

    public void bB(boolean z) {
        if (z) {
            bXr();
        }
    }

    public void bk(List<j> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.hsB.clear();
        this.hsB.addAll(list);
        setVisibility(0);
        this.hsC = 0;
        bXs();
        bXr();
    }

    private void bXr() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.hsB) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        j jVar;
        j jVar2 = (j) v.getItem(this.hsB, this.hsC);
        if (this.hsC + 1 >= this.hsB.size()) {
            jVar = (j) v.getItem(this.hsB, 0);
        } else {
            jVar = (j) v.getItem(this.hsB, this.hsC + 1);
        }
        if ((this.hsy.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dcO()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.hsy.getTag()).setText(title);
        }
        if ((this.hsz.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.hsz.getTag()).setText(jVar.dcO() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXt() {
        final float y = this.hsz.getY();
        this.hsA = ValueAnimator.ofFloat(0.0f, this.hsy.getMeasuredHeight());
        this.hsA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.hsy.setY(-floatValue);
                FrsAdCommentScrollView.this.hsz.setY(y - floatValue);
            }
        });
        this.hsA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.hsC == FrsAdCommentScrollView.this.hsB.size()) {
                    FrsAdCommentScrollView.this.hsC = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.hsy;
                FrsAdCommentScrollView.this.hsy = FrsAdCommentScrollView.this.hsz;
                FrsAdCommentScrollView.this.hsz = frameLayout;
                FrsAdCommentScrollView.this.hsz.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bXs();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hsA.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.hsA != null) {
            this.hsA.cancel();
        }
    }
}
