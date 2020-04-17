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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes9.dex */
public class e implements com.baidu.card.n {
    private FrsFragment hwJ;
    private TextView hwK;
    private NoPressedRelativeLayout hwi;
    private final Runnable mHideRunnable;
    private int gZW = -1;
    private int eNU = -1;
    private int hwN = -1;
    private final Handler hwI = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.bVj();
                return true;
            }
            return false;
        }
    });
    private final Animation hwL = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation hwM = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.hwi = noPressedRelativeLayout;
        this.hwJ = frsFragment;
        this.hwM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.hwK.getParent() != null) {
                    ((ViewGroup) e.this.hwK.getParent()).removeView(e.this.hwK);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.bVk();
            }
        };
        initView();
    }

    private void initView() {
        this.hwK = new TextView(TbadkCoreApplication.getInst());
        this.hwK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bVk();
                if (e.this.hwJ != null && !e.this.hwJ.bOZ() && e.this.hwJ.bOx() != null) {
                    e.this.hwJ.bOx().startPullRefresh();
                }
            }
        });
        this.hwK.setGravity(17);
        this.hwK.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.hwJ.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.hwJ.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.hwK.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.hwK.setTextSize(0, this.hwJ.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        am.setBackgroundResource(this.hwK, R.drawable.bg_home_float);
        am.setViewTextColor(this.hwK, (int) R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.hwJ.boh().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.hwK.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.gZW = i;
        this.eNU = i2;
        if (this.hwN < 0) {
            this.hwN = this.gZW;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.gZW > 0 && this.eNU > 0 && this.hwN >= 0 && this.gZW + this.eNU + 1 < this.hwN) {
                this.hwI.sendEmptyMessage(111);
            }
            this.hwN = this.gZW;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVj() {
        if (this.hwK.getParent() == null) {
            this.hwi.addView(this.hwK);
            this.hwK.clearAnimation();
            this.hwK.startAnimation(this.hwL);
            this.hwI.removeCallbacks(this.mHideRunnable);
            this.hwI.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVk() {
        if (this.hwK.getParent() != null) {
            this.gZW = -1;
            this.hwN = -1;
            this.hwI.removeCallbacks(this.mHideRunnable);
            this.hwK.clearAnimation();
            this.hwK.startAnimation(this.hwM);
        }
    }

    public void onDestory() {
        this.hwI.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.hwK, R.drawable.bg_home_float);
        am.setViewTextColor(this.hwK, (int) R.color.cp_link_tip_a);
    }
}
