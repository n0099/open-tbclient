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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<c> {
    private static final int M_H_X002 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
    private static final int M_H_X003 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
    private static final int M_H_X005 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
    private static final int jUZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds105);
    private static final int jVa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private TextView jVb;
    private String jVc;
    private c jVd;
    private final TbPageContext<?> mPageContext;
    private View mRoot;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.mRoot = getView();
        this.jVb = (TextView) this.mRoot.findViewById(R.id.read_progress_bar_time);
        if (com.baidu.tbadk.a.d.bkA()) {
            this.jVb.setPadding(0, M_H_X005 - M_H_X002, 0, M_H_X005);
        } else {
            this.jVb.setPadding(0, M_H_X005, 0, M_H_X005 - M_H_X003);
        }
        this.jVc = this.mPageContext.getResources().getString(R.string.home_read_here);
        this.mRoot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.crI() != null) {
                    a.this.crI().a(view, a.this.jVd);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQy() {
        final ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        if (layoutParams != null && layoutParams.height != jUZ) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a.this.jVb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    layoutParams.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.jUZ - a.jVa)) + a.jVa);
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
            ap.setViewTextColor(this.jVb, R.color.CAM_X0304);
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_card_refresh16, ap.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            this.jVb.setCompoundDrawables(a2, null, null, null);
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
            if (!cVar.jVj) {
                this.mRoot.getLayoutParams().height = jVa;
                this.mRoot.requestLayout();
                this.jVb.setAlpha(0.0f);
            }
            if (this.mRoot.getLayoutParams().height != jUZ) {
                cVar.jVj = true;
                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.b.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cQy();
                    }
                }, 1600L);
            }
            this.jVb.setText(au.getFormatTimeShort(cVar.mTimeStamp) + this.jVc);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
