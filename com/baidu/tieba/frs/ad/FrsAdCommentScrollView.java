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
    private TextView hdr;
    private TextView hds;
    private FrameLayout hdt;
    private FrameLayout hdu;
    private ValueAnimator hdv;
    private List<j> hdw;
    private int hdx;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.hdx;
        frsAdCommentScrollView.hdx = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.hdx = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bQW();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.hdx = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bQW();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.hdx = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.bQW();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.hdw = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.hdr = (TextView) findViewById(R.id.cur_display_view);
        this.hds = (TextView) findViewById(R.id.next_display_view);
        this.hdt = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.hdt.setTag(this.hdr);
        this.hdu = (FrameLayout) findViewById(R.id.next_display_layout);
        this.hdu.setTag(this.hds);
    }

    public void jb(boolean z) {
        if (z) {
            bQU();
        }
    }

    public void bp(List<j> list) {
        if (v.getCount(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.hdw.clear();
        this.hdw.addAll(list);
        setVisibility(0);
        this.hdx = 0;
        bQV();
        bQU();
    }

    private void bQU() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.getCount(this.hdw) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQV() {
        j jVar;
        j jVar2 = (j) v.getItem(this.hdw, this.hdx);
        if (this.hdx + 1 >= this.hdw.size()) {
            jVar = (j) v.getItem(this.hdw, 0);
        } else {
            jVar = (j) v.getItem(this.hdw, this.hdx + 1);
        }
        if ((this.hdt.getTag() instanceof TextView) && jVar2 != null) {
            String title = jVar2.getTitle();
            if (jVar2.cVx()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.hdt.getTag()).setText(title);
        }
        if ((this.hdu.getTag() instanceof TextView) && jVar != null) {
            String title2 = jVar.getTitle();
            ((TextView) this.hdu.getTag()).setText(jVar.cVx() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQW() {
        final float y = this.hdu.getY();
        this.hdv = ValueAnimator.ofFloat(0.0f, this.hdt.getMeasuredHeight());
        this.hdv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.hdt.setY(-floatValue);
                FrsAdCommentScrollView.this.hdu.setY(y - floatValue);
            }
        });
        this.hdv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.hdx == FrsAdCommentScrollView.this.hdw.size()) {
                    FrsAdCommentScrollView.this.hdx = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.hdt;
                FrsAdCommentScrollView.this.hdt = FrsAdCommentScrollView.this.hdu;
                FrsAdCommentScrollView.this.hdu = frameLayout;
                FrsAdCommentScrollView.this.hdu.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bQV();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hdv.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.hdv != null) {
            this.hdv.cancel();
        }
    }
}
