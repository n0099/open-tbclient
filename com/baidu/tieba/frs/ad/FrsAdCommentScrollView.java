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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private TextView jmX;
    private TextView jmY;
    private FrameLayout jmZ;
    private FrameLayout jna;
    private ValueAnimator jnb;
    private List<j> jnc;
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
                FrsAdCommentScrollView.this.cFs();
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
                FrsAdCommentScrollView.this.cFs();
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
                FrsAdCommentScrollView.this.cFs();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.jnc = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.jmX = (TextView) findViewById(R.id.cur_display_view);
        this.jmY = (TextView) findViewById(R.id.next_display_view);
        this.jmZ = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.jmZ.setTag(this.jmX);
        this.jna = (FrameLayout) findViewById(R.id.next_display_layout);
        this.jna.setTag(this.jmY);
    }

    public void cb(boolean z) {
        if (z) {
            cFq();
        }
    }

    public void cd(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.jnc.clear();
        this.jnc.addAll(list);
        setVisibility(0);
        this.mCurIndex = 0;
        cFr();
        cFq();
    }

    private void cFq() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.jnc) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFr() {
        j jVar;
        j jVar2 = (j) y.getItem(this.jnc, this.mCurIndex);
        if (this.mCurIndex + 1 >= this.jnc.size()) {
            jVar = (j) y.getItem(this.jnc, 0);
        } else {
            jVar = (j) y.getItem(this.jnc, this.mCurIndex + 1);
        }
        if ((this.jmZ.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dMF()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.jmZ.getTag()).setText(title);
        }
        if ((this.jna.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.jna.getTag()).setText(jVar.dMF() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFs() {
        final float y = this.jna.getY();
        this.jnb = ValueAnimator.ofFloat(0.0f, this.jmZ.getMeasuredHeight());
        this.jnb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.jmZ.setY(-floatValue);
                FrsAdCommentScrollView.this.jna.setY(y - floatValue);
            }
        });
        this.jnb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.mCurIndex == FrsAdCommentScrollView.this.jnc.size()) {
                    FrsAdCommentScrollView.this.mCurIndex = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.jmZ;
                FrsAdCommentScrollView.this.jmZ = FrsAdCommentScrollView.this.jna;
                FrsAdCommentScrollView.this.jna = frameLayout;
                FrsAdCommentScrollView.this.jna.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cFr();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jnb.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.jnb != null) {
            this.jnb.cancel();
        }
    }
}
