package com.baidu.tieba.homepage.personalize.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private static final int geD = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds105);
    private static final int geE = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private View bBg;
    private TextView geF;
    private String geG;
    private c geH;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.bBg = getView();
        this.geF = (TextView) this.bBg.findViewById(R.id.read_progress_bar_time);
        this.geG = this.mPageContext.getResources().getString(R.string.home_read_here);
        this.bBg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.geH);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buB() {
        final ViewGroup.LayoutParams layoutParams = this.bBg.getLayoutParams();
        if (layoutParams != null && layoutParams.height != geD) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a.this.geF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    layoutParams.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.geD - a.geE)) + a.geE);
                    a.this.bBg.setLayoutParams(layoutParams);
                }
            });
            ofFloat.setDuration(400L);
            ofFloat.start();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.geF, R.color.cp_link_tip_a);
            al.k(this.bBg, R.color.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null && this.bBg.getLayoutParams() != null) {
            if (!cVar.geM) {
                this.bBg.getLayoutParams().height = geE;
                this.bBg.requestLayout();
                this.geF.setAlpha(0.0f);
            }
            if (this.bBg.getLayoutParams().height != geD) {
                cVar.geM = true;
                e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.b.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.buB();
                    }
                }, 1600L);
            }
            this.geF.setText(ap.aE(cVar.bbz) + this.geG);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
