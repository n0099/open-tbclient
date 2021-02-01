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
    private TextView jmJ;
    private TextView jmK;
    private FrameLayout jmL;
    private FrameLayout jmM;
    private ValueAnimator jmN;
    private List<j> jmO;
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
                FrsAdCommentScrollView.this.cFl();
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
                FrsAdCommentScrollView.this.cFl();
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
                FrsAdCommentScrollView.this.cFl();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.jmO = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.jmJ = (TextView) findViewById(R.id.cur_display_view);
        this.jmK = (TextView) findViewById(R.id.next_display_view);
        this.jmL = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.jmL.setTag(this.jmJ);
        this.jmM = (FrameLayout) findViewById(R.id.next_display_layout);
        this.jmM.setTag(this.jmK);
    }

    public void cb(boolean z) {
        if (z) {
            cFj();
        }
    }

    public void cd(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.jmO.clear();
        this.jmO.addAll(list);
        setVisibility(0);
        this.mCurIndex = 0;
        cFk();
        cFj();
    }

    private void cFj() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.jmO) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFk() {
        j jVar;
        j jVar2 = (j) y.getItem(this.jmO, this.mCurIndex);
        if (this.mCurIndex + 1 >= this.jmO.size()) {
            jVar = (j) y.getItem(this.jmO, 0);
        } else {
            jVar = (j) y.getItem(this.jmO, this.mCurIndex + 1);
        }
        if ((this.jmL.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dMx()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.jmL.getTag()).setText(title);
        }
        if ((this.jmM.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.jmM.getTag()).setText(jVar.dMx() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFl() {
        final float y = this.jmM.getY();
        this.jmN = ValueAnimator.ofFloat(0.0f, this.jmL.getMeasuredHeight());
        this.jmN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.jmL.setY(-floatValue);
                FrsAdCommentScrollView.this.jmM.setY(y - floatValue);
            }
        });
        this.jmN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.mCurIndex == FrsAdCommentScrollView.this.jmO.size()) {
                    FrsAdCommentScrollView.this.mCurIndex = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.jmL;
                FrsAdCommentScrollView.this.jmL = FrsAdCommentScrollView.this.jmM;
                FrsAdCommentScrollView.this.jmM = frameLayout;
                FrsAdCommentScrollView.this.jmM.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cFk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jmN.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.jmN != null) {
            this.jmN.cancel();
        }
    }
}
