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
    private TextView hsl;
    private TextView hsm;
    private FrameLayout hsn;
    private FrameLayout hso;
    private ValueAnimator hsp;
    private List<j> hsq;
    private int hsr;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.hsr;
        frsAdCommentScrollView.hsr = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.hsr = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bXr();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.hsr = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bXr();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.hsr = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bXr();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.hsq = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.hsl = (TextView) findViewById(R.id.cur_display_view);
        this.hsm = (TextView) findViewById(R.id.next_display_view);
        this.hsn = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.hsn.setTag(this.hsl);
        this.hso = (FrameLayout) findViewById(R.id.next_display_layout);
        this.hso.setTag(this.hsm);
    }

    public void bB(boolean z) {
        if (z) {
            bXp();
        }
    }

    public void bk(List<j> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.hsq.clear();
        this.hsq.addAll(list);
        setVisibility(0);
        this.hsr = 0;
        bXq();
        bXp();
    }

    private void bXp() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.hsq) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXq() {
        j jVar;
        j jVar2 = (j) v.getItem(this.hsq, this.hsr);
        if (this.hsr + 1 >= this.hsq.size()) {
            jVar = (j) v.getItem(this.hsq, 0);
        } else {
            jVar = (j) v.getItem(this.hsq, this.hsr + 1);
        }
        if ((this.hsn.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.dcz()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.hsn.getTag()).setText(title);
        }
        if ((this.hso.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.hso.getTag()).setText(jVar.dcz() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXr() {
        final float y = this.hso.getY();
        this.hsp = ValueAnimator.ofFloat(0.0f, this.hsn.getMeasuredHeight());
        this.hsp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.hsn.setY(-floatValue);
                FrsAdCommentScrollView.this.hso.setY(y - floatValue);
            }
        });
        this.hsp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.hsr == FrsAdCommentScrollView.this.hsq.size()) {
                    FrsAdCommentScrollView.this.hsr = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.hsn;
                FrsAdCommentScrollView.this.hsn = FrsAdCommentScrollView.this.hso;
                FrsAdCommentScrollView.this.hso = frameLayout;
                FrsAdCommentScrollView.this.hso.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bXq();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hsp.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.hsp != null) {
            this.hsp.cancel();
        }
    }
}
