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
/* loaded from: classes22.dex */
public class e implements q {
    private NoPressedRelativeLayout jbY;
    private TextView jcA;
    private FrsFragment jcz;
    private final Runnable mHideRunnable;
    private int iDz = -1;
    private int gch = -1;
    private int jcB = -1;
    private final Handler jcy = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.frs.vc.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.cDf();
                return true;
            }
            return false;
        }
    });
    private final Animation bEl = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
    private final Animation bEm = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.jbY = noPressedRelativeLayout;
        this.jcz = frsFragment;
        this.bEm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.vc.e.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (e.this.jcA.getParent() != null) {
                    ((ViewGroup) e.this.jcA.getParent()).removeView(e.this.jcA);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.cDg();
            }
        };
        initView();
    }

    private void initView() {
        this.jcA = new TextView(TbadkCoreApplication.getInst());
        this.jcA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cDg();
                if (e.this.jcz != null && !e.this.jcz.cwp() && e.this.jcz.cvK() != null) {
                    e.this.jcz.cvK().startPullRefresh();
                }
            }
        });
        this.jcA.setGravity(17);
        this.jcA.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.jcz.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.jcz.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.jcA.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.jcA.setTextSize(0, this.jcz.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        ap.setBackgroundResource(this.jcA, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jcA, R.color.cp_link_tip_a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.jcz.bQh().getBottom() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.jcA.setLayoutParams(layoutParams);
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.iDz = i;
        this.gch = i2;
        if (this.jcB < 0) {
            this.jcB = this.iDz;
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            if (this.iDz > 0 && this.gch > 0 && this.jcB >= 0 && this.iDz + this.gch + 1 < this.jcB) {
                this.jcy.sendEmptyMessage(111);
            }
            this.jcB = this.iDz;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDf() {
        if (this.jcA.getParent() == null) {
            this.jbY.addView(this.jcA);
            this.jcA.clearAnimation();
            this.jcA.startAnimation(this.bEl);
            this.jcy.removeCallbacks(this.mHideRunnable);
            this.jcy.postDelayed(this.mHideRunnable, 4000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDg() {
        if (this.jcA.getParent() != null) {
            this.iDz = -1;
            this.jcB = -1;
            this.jcy.removeCallbacks(this.mHideRunnable);
            this.jcA.clearAnimation();
            this.jcA.startAnimation(this.bEm);
        }
    }

    public void onDestory() {
        this.jcy.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundResource(this.jcA, R.drawable.bg_home_float);
        ap.setViewTextColor(this.jcA, R.color.cp_link_tip_a);
    }
}
