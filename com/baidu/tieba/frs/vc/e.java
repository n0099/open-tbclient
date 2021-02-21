package com.baidu.tieba.frs.vc;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes2.dex */
public class e implements q {
    private NoPressedRelativeLayout jJS;
    private FrsFragment jKt;
    private TextView jKu;
    private final Runnable mHideRunnable;
    private int jiE = -1;
    private int gzf = -1;
    private int jKv = -1;
    private final Handler jKs = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cHM();
                return true;
            }
            return false;
        }
    });
    private final Animation bRg = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bRh = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jJS = noPressedRelativeLayout;
        this.jKt = frsFragment;
        this.bRh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jKu.getParent() != null) {
                    ((ViewGroup) e.this.jKu.getParent()).removeView(e.this.jKu);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cHN();
            }
        };
        initView();
    }

    private void initView() {
        this.jKu = new TextView(TbadkCoreApplication.getInst());
        this.jKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cHN();
                if (e.this.jKt != null && !e.this.jKt.cDh() && e.this.jKt.cCB() != null) {
                    e.this.jKt.cCB().startPullRefresh();
                }
            }
        });
        this.jKu.setGravity(17);
        this.jKu.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jKt.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jKt.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jKu.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jKu.setTextSize(0, this.jKt.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.jKu, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jKu, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jKt.bVk().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jKu.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.jiE = i;
        this.gzf = i2;
        if (this.jKv < 0) {
            this.jKv = this.jiE;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.jiE > 0 && this.gzf > 0 && this.jKv >= 0 && this.jiE + this.gzf + 1 < this.jKv) {
                this.jKs.sendEmptyMessage(111);
            }
            this.jKv = this.jiE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHM() {
        if (this.jKu.getParent() == null) {
            this.jJS.addView(this.jKu);
            this.jKu.clearAnimation();
            this.jKu.startAnimation(this.bRg);
            this.jKs.removeCallbacks(this.mHideRunnable);
            this.jKs.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHN() {
        if (this.jKu.getParent() != null) {
            this.jiE = -1;
            this.jKv = -1;
            this.jKs.removeCallbacks(this.mHideRunnable);
            this.jKu.clearAnimation();
            this.jKu.startAnimation(this.bRh);
        }
    }

    public void onDestory() {
        this.jKs.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.jKu, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jKu, R.color.CAM_X0302);
    }
}
