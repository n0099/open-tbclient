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
import com.baidu.tieba.tbadkCore.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsAdCommentScrollView extends LinearLayout {
    private int evs;
    private ValueAnimator evt;
    private TextView fBk;
    private TextView fBl;
    private FrameLayout fBm;
    private FrameLayout fBn;
    private List<i> fBo;
    private Handler mHandler;
    private Runnable mScrollRunnable;

    static /* synthetic */ int e(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i = frsAdCommentScrollView.evs;
        frsAdCommentScrollView.evs = i + 1;
        return i;
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.mHandler = new Handler();
        this.evs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.aYO();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.evs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.aYO();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler();
        this.evs = 0;
        this.mScrollRunnable = new Runnable() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                FrsAdCommentScrollView.this.aYO();
                FrsAdCommentScrollView.this.mHandler.postDelayed(this, 5000L);
            }
        };
        init();
    }

    private void init() {
        this.fBo = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.fBk = (TextView) findViewById(R.id.cur_display_view);
        this.fBl = (TextView) findViewById(R.id.next_display_view);
        this.fBm = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.fBm.setTag(this.fBk);
        this.fBn = (FrameLayout) findViewById(R.id.next_display_layout);
        this.fBn.setTag(this.fBl);
    }

    public void jV(boolean z) {
        if (z) {
            bpb();
        }
    }

    public void aU(List<i> list) {
        if (v.Z(list) <= 1) {
            this.mHandler.removeCallbacks(this.mScrollRunnable);
            setVisibility(8);
            return;
        }
        this.fBo.clear();
        this.fBo.addAll(list);
        setVisibility(0);
        this.evs = 0;
        bpc();
        bpb();
    }

    private void bpb() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (v.Z(this.fBo) >= 2) {
            this.mHandler.postDelayed(this.mScrollRunnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpc() {
        i iVar;
        i iVar2 = (i) v.c(this.fBo, this.evs);
        if (this.evs + 1 >= this.fBo.size()) {
            iVar = (i) v.c(this.fBo, 0);
        } else {
            iVar = (i) v.c(this.fBo, this.evs + 1);
        }
        if ((this.fBm.getTag() instanceof TextView) && iVar2 != null) {
            String title = iVar2.getTitle();
            if (iVar2.cpz()) {
                title = getContext().getString(R.string.frs_top_ad_lz_reply, title);
            }
            ((TextView) this.fBm.getTag()).setText(title);
        }
        if ((this.fBn.getTag() instanceof TextView) && iVar != null) {
            String title2 = iVar.getTitle();
            ((TextView) this.fBn.getTag()).setText(iVar.cpz() ? getContext().getString(R.string.frs_top_ad_lz_reply, title2) : title2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYO() {
        final float y = this.fBn.getY();
        this.evt = ValueAnimator.ofFloat(0.0f, this.fBm.getMeasuredHeight());
        this.evt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrsAdCommentScrollView.this.fBm.setY(-floatValue);
                FrsAdCommentScrollView.this.fBn.setY(y - floatValue);
            }
        });
        this.evt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ad.FrsAdCommentScrollView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsAdCommentScrollView.e(FrsAdCommentScrollView.this);
                if (FrsAdCommentScrollView.this.evs == FrsAdCommentScrollView.this.fBo.size()) {
                    FrsAdCommentScrollView.this.evs = 0;
                }
                FrameLayout frameLayout = FrsAdCommentScrollView.this.fBm;
                FrsAdCommentScrollView.this.fBm = FrsAdCommentScrollView.this.fBn;
                FrsAdCommentScrollView.this.fBn = frameLayout;
                FrsAdCommentScrollView.this.fBn.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
                FrsAdCommentScrollView.this.bpc();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.evt.start();
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mScrollRunnable);
        if (this.evt != null) {
            this.evt.cancel();
        }
    }
}
