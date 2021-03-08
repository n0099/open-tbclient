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
    private TextView joG;
    private TextView joH;
    private FrameLayout joI;
    private FrameLayout joJ;
    private ValueAnimator joK;
    private List<j> joL;
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
                FrsAdCommentScrollView.this.cFy();
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
                FrsAdCommentScrollView.this.cFy();
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
                FrsAdCommentScrollView.this.cFy();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.joL = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.joG = (TextView) findViewById(R.id.cur_display_view);
        this.joH = (TextView) findViewById(R.id.next_display_view);
        this.joI = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.joI.setTag(this.joG);
        this.joJ = (FrameLayout) findViewById(R.id.next_display_layout);
        this.joJ.setTag(this.joH);
    }

    public void cb(boolean z) {
        if (z) {
            cFw();
        }
    }

    public void cd(List<j> list) {
        if (y.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.joL.clear();
        this.joL.addAll(list);
        setVisibility(0);
        this.mCurIndex = 0;
        cFx();
        cFw();
    }

    private void cFw() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (y.getCount(this.joL) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFx() {
        j jVar;
        j jVar2 = (j) y.getItem(this.joL, this.mCurIndex);
        if (this.mCurIndex + 1 >= this.joL.size()) {
            jVar = (j) y.getItem(this.joL, 0);
        } else {
            jVar = (j) y.getItem(this.joL, this.mCurIndex + 1);
        }
        if ((this.joI.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dMN()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.joI.getTag()).setText(title);
        }
        if ((this.joJ.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.joJ.getTag()).setText(jVar.dMN() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFy() {
        final float y = this.joJ.getY();
        this.joK = ValueAnimator.ofFloat(0.0f, this.joI.getMeasuredHeight());
        this.joK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.joI.setY(-floatValue);
                FrsAdCommentScrollView.this.joJ.setY(y - floatValue);
            }
        });
        this.joK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.mCurIndex == FrsAdCommentScrollView.this.joL.size()) {
                    FrsAdCommentScrollView.this.mCurIndex = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.joI;
                FrsAdCommentScrollView.this.joI = FrsAdCommentScrollView.this.joJ;
                FrsAdCommentScrollView.this.joJ = frameLayout;
                FrsAdCommentScrollView.this.joJ.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.cFx();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.joK.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.joK != null) {
            this.joK.cancel();
        }
    }
}
