package com.baidu.tieba.frs.vc;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes21.dex */
public class e implements q {
    private NoPressedRelativeLayout iAK;
    private FrsFragment iBl;
    private TextView iBm;
    private final Runnable mHideRunnable;
    private int icc = -1;
    private int fFV = -1;
    private int iBp = -1;
    private final Handler iBk = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cwB();
                return true;
            }
            return false;
        }
    });
    private final Animation iBn = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation iBo = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.iAK = noPressedRelativeLayout;
        this.iBl = frsFragment;
        this.iBo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.iBm.getParent() != null) {
                    ((ViewGroup) e.this.iBm.getParent()).removeView(e.this.iBm);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cwC();
            }
        };
        initView();
    }

    private void initView() {
        this.iBm = new TextView(TbadkCoreApplication.getInst());
        this.iBm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cwC();
                if (e.this.iBl != null && !e.this.iBl.cpK() && e.this.iBl.cpf() != null) {
                    e.this.iBl.cpf().startPullRefresh();
                }
            }
        });
        this.iBm.setGravity(17);
        this.iBm.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.iBl.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.iBl.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.iBm.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.iBm.setTextSize(0, this.iBl.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.iBm, R.drawable.bg_home_float);
        ap.setViewTextColor(this.iBm, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.iBl.bKS().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.iBm.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.icc = i;
        this.fFV = i2;
        if (this.iBp < 0) {
            this.iBp = this.icc;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.icc > 0 && this.fFV > 0 && this.iBp >= 0 && this.icc + this.fFV + 1 < this.iBp) {
                this.iBk.sendEmptyMessage(111);
            }
            this.iBp = this.icc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwB() {
        if (this.iBm.getParent() == null) {
            this.iAK.addView(this.iBm);
            this.iBm.clearAnimation();
            this.iBm.startAnimation(this.iBn);
            this.iBk.removeCallbacks(this.mHideRunnable);
            this.iBk.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwC() {
        if (this.iBm.getParent() != null) {
            this.icc = -1;
            this.iBp = -1;
            this.iBk.removeCallbacks(this.mHideRunnable);
            this.iBm.clearAnimation();
            this.iBm.startAnimation(this.iBo);
        }
    }

    public void onDestory() {
        this.iBk.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.iBm, R.drawable.bg_home_float);
        ap.setViewTextColor(this.iBm, R.color.cp_link_tip_a);
    }
}
