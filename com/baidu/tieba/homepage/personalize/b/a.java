package com.baidu.tieba.homepage.personalize.b;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private static final int hdi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds105);
    private static final int hdj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private TextView hdk;
    private String hdl;
    private c hdm;
    private final TbPageContext<?> mPageContext;
    private View mRoot;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.mRoot = getView();
        this.hdk = (TextView) this.mRoot.findViewById(R.id.read_progress_bar_time);
        this.hdl = this.mPageContext.getResources().getString(R.string.home_read_here);
        this.mRoot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bta() != null) {
                    a.this.bta().a(view, a.this.hdm);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNF() {
        final ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        if (layoutParams != null && layoutParams.height != hdi) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a.this.hdk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    layoutParams.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.hdi - a.hdj)) + a.hdj);
                    a.this.mRoot.setLayoutParams(layoutParams);
                }
            });
            ofFloat.setDuration(400L);
            ofFloat.start();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.hdk, (int) R.color.cp_link_tip_a);
            this.hdk.setCompoundDrawablesWithIntrinsicBounds(SvgManager.aEp().a(R.drawable.icon_pure_card_refresh16_svg, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_c);
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
        if (cVar != null && this.mRoot.getLayoutParams() != null) {
            if (!cVar.hdr) {
                this.mRoot.getLayoutParams().height = hdj;
                this.mRoot.requestLayout();
                this.hdk.setAlpha(0.0f);
            }
            if (this.mRoot.getLayoutParams().height != hdi) {
                cVar.hdr = true;
                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.b.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bNF();
                    }
                }, 1600L);
            }
            this.hdk.setText(aq.getFormatTimeShort(cVar.mTimeStamp) + this.hdl);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
