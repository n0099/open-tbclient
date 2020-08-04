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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<c> {
    private static final int iBx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds105);
    private static final int iBy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private String iBA;
    private c iBB;
    private TextView iBz;
    private final TbPageContext<?> mPageContext;
    private View mRoot;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.mRoot = getView();
        this.iBz = (TextView) this.mRoot.findViewById(R.id.read_progress_bar_time);
        this.iBA = this.mPageContext.getResources().getString(R.string.home_read_here);
        this.mRoot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bRn() != null) {
                    a.this.bRn().a(view, a.this.iBB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnM() {
        final ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        if (layoutParams != null && layoutParams.height != iBx) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a.this.iBz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    layoutParams.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.iBx - a.iBy)) + a.iBy);
                    a.this.mRoot.setLayoutParams(layoutParams);
                }
            });
            ofFloat.setDuration(400L);
            ofFloat.start();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.iBz, R.color.cp_link_tip_a);
            this.iBz.setCompoundDrawablesWithIntrinsicBounds(SvgManager.baR().a(R.drawable.icon_pure_card_refresh16_svg, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setBackgroundResource(this.mRoot, R.color.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null && this.mRoot.getLayoutParams() != null) {
            if (!cVar.iBH) {
                this.mRoot.getLayoutParams().height = iBy;
                this.mRoot.requestLayout();
                this.iBz.setAlpha(0.0f);
            }
            if (this.mRoot.getLayoutParams().height != iBx) {
                cVar.iBH = true;
                e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.b.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cnM();
                    }
                }, 1600L);
            }
            this.iBz.setText(as.getFormatTimeShort(cVar.mTimeStamp) + this.iBA);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
