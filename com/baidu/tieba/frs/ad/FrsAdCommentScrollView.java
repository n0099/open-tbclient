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
    private TextView gug;
    private TextView guh;
    private FrameLayout gui;
    private FrameLayout guj;
    private ValueAnimator guk;
    private List<j> gul;
    private int gum;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.gum;
        frsAdCommentScrollView.gum = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.gum = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGv();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.gum = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGv();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.gum = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bGv();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.gul = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.gug = (TextView) findViewById(R.id.cur_display_view);
        this.guh = (TextView) findViewById(R.id.next_display_view);
        this.gui = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.gui.setTag(this.gug);
        this.guj = (FrameLayout) findViewById(R.id.next_display_layout);
        this.guj.setTag(this.guh);
    }

    public void onPrimary(boolean z) {
        if (z) {
            bGt();
        }
    }

    public void bf(List<j> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.gul.clear();
        this.gul.addAll(list);
        setVisibility(0);
        this.gum = 0;
        bGu();
        bGt();
    }

    private void bGt() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.gul) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGu() {
        j jVar;
        j jVar2 = (j) v.getItem(this.gul, this.gum);
        if (this.gum + 1 >= this.gul.size()) {
            jVar = (j) v.getItem(this.gul, 0);
        } else {
            jVar = (j) v.getItem(this.gul, this.gum + 1);
        }
        if ((this.gui.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.cKB()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.gui.getTag()).setText(title);
        }
        if ((this.guj.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.guj.getTag()).setText(jVar.cKB() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGv() {
        final float y = this.guj.getY();
        this.guk = ValueAnimator.ofFloat(0.0f, this.gui.getMeasuredHeight());
        this.guk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.gui.setY(-floatValue);
                FrsAdCommentScrollView.this.guj.setY(y - floatValue);
            }
        });
        this.guk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.gum == FrsAdCommentScrollView.this.gul.size()) {
                    FrsAdCommentScrollView.this.gum = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.gui;
                FrsAdCommentScrollView.this.gui = FrsAdCommentScrollView.this.guj;
                FrsAdCommentScrollView.this.guj = frameLayout;
                FrsAdCommentScrollView.this.guj.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bGu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.guk.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.guk != null) {
            this.guk.cancel();
        }
    }
}
