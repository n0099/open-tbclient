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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private static final int fNE = l.h(TbadkCoreApplication.getInst(), d.e.tbds105);
    private static final int fNF = l.h(TbadkCoreApplication.getInst(), d.e.tbds6);
    private View btW;
    private TextView fNG;
    private String fNH;
    private c fNI;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.btW = getView();
        this.fNG = (TextView) this.btW.findViewById(d.g.read_progress_bar_time);
        this.fNH = this.mPageContext.getResources().getString(d.j.home_read_here);
        this.btW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.fNI);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmY() {
        final ViewGroup.LayoutParams layoutParams = this.btW.getLayoutParams();
        if (layoutParams != null && layoutParams.height != fNE) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a.this.fNG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    layoutParams.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.fNE - a.fNF)) + a.fNF);
                    a.this.btW.setLayoutParams(layoutParams);
                }
            });
            ofFloat.setDuration(400L);
            ofFloat.start();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.fNG, d.C0236d.cp_link_tip_a);
            al.k(this.btW, d.C0236d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null && this.btW.getLayoutParams() != null) {
            if (!cVar.fNN) {
                this.btW.getLayoutParams().height = fNF;
                this.btW.requestLayout();
                this.fNG.setAlpha(0.0f);
            }
            if (this.btW.getLayoutParams().height != fNE) {
                cVar.fNN = true;
                e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.b.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bmY();
                    }
                }, 1600L);
            }
            this.fNG.setText(ap.aq(cVar.aYG) + this.fNH);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
