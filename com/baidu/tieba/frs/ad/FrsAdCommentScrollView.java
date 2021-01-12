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
    private TextView jhb;
    private TextView jhc;
    private FrameLayout jhd;
    private FrameLayout jhe;
    private ValueAnimator jhf;
    private List<j> jhg;
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
                FrsAdCommentScrollView.this.cDZ();
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
                FrsAdCommentScrollView.this.cDZ();
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
                FrsAdCommentScrollView.this.cDZ();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.jhg = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.jhb = (TextView) findViewById(R.id.cur_display_view);
        this.jhc = (TextView) findViewById(R.id.next_display_view);
        this.jhd = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.jhd.setTag(this.jhb);
        this.jhe = (FrameLayout) findViewById(R.id.next_display_layout);
        this.jhe.setTag(this.jhc);
    }

    public void bW(boolean z) {
        if (z) {
            cDX();
        }
    }

    public void ci(List<j> list) {
        if (x.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.jhg.clear();
        this.jhg.addAll(list);
        setVisibility(0);
        this.mCurIndex = 0;
        cDY();
        cDX();
    }

    private void cDX() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (x.getCount(this.jhg) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDY() {
        j jVar;
        j jVar2 = (j) x.getItem(this.jhg, this.mCurIndex);
        if (this.mCurIndex + 1 >= this.jhg.size()) {
            jVar = (j) x.getItem(this.jhg, 0);
        } else {
            jVar = (j) x.getItem(this.jhg, this.mCurIndex + 1);
        }
        if ((this.jhd.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dKm()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.jhd.getTag()).setText(title);
        }
        if ((this.jhe.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.jhe.getTag()).setText(jVar.dKm() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDZ() {
        final float y = this.jhe.getY();
        this.jhf = ValueAnimator.ofFloat(0.0f, this.jhd.getMeasuredHeight());
        this.jhf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.jhd.setY(-floatValue);
                FrsAdCommentScrollView.this.jhe.setY(y - floatValue);
            }
        });
        this.jhf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.mCurIndex == FrsAdCommentScrollView.this.jhg.size()) {
                    FrsAdCommentScrollView.this.mCurIndex = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.jhd;
                FrsAdCommentScrollView.this.jhd = FrsAdCommentScrollView.this.jhe;
                FrsAdCommentScrollView.this.jhe = frameLayout;
                FrsAdCommentScrollView.this.jhe.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cDY();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jhf.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.jhf != null) {
            this.jhf.cancel();
        }
    }
}
