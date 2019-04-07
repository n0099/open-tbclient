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
    private static final int fNr = l.h(TbadkCoreApplication.getInst(), d.e.tbds105);
    private static final int fNs = l.h(TbadkCoreApplication.getInst(), d.e.tbds6);
    private View bub;
    private TextView fNt;
    private String fNu;
    private c fNv;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.bub = getView();
        this.fNt = (TextView) this.bub.findViewById(d.g.read_progress_bar_time);
        this.fNu = this.mPageContext.getResources().getString(d.j.home_read_here);
        this.bub.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.fNv);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmV() {
        final ViewGroup.LayoutParams layoutParams = this.bub.getLayoutParams();
        if (layoutParams != null && layoutParams.height != fNr) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a.this.fNt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    layoutParams.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.fNr - a.fNs)) + a.fNs);
                    a.this.bub.setLayoutParams(layoutParams);
                }
            });
            ofFloat.setDuration(400L);
            ofFloat.start();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(this.fNt, d.C0277d.cp_link_tip_a);
            al.k(this.bub, d.C0277d.cp_bg_line_e);
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
        if (cVar != null && this.bub.getLayoutParams() != null) {
            if (!cVar.fNA) {
                this.bub.getLayoutParams().height = fNs;
                this.bub.requestLayout();
                this.fNt.setAlpha(0.0f);
            }
            if (this.bub.getLayoutParams().height != fNr) {
                cVar.fNA = true;
                e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.b.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bmV();
                    }
                }, 1600L);
            }
            this.fNt.setText(ap.aq(cVar.aYK) + this.fNu);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
