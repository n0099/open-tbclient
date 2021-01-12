package com.baidu.tieba.homepage.personalize.readProgressBar;

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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<b> {
    private static final int M_H_X002 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
    private static final int M_H_X003 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
    private static final int M_H_X005 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
    private static final int kdG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds105);
    private static final int kdH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private TextView kdI;
    private String kdJ;
    private b kdK;
    private final TbPageContext<?> mPageContext;
    private View mRoot;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.mRoot = getView();
        this.kdI = (TextView) this.mRoot.findViewById(R.id.read_progress_bar_time);
        this.kdI.setPadding(0, M_H_X005, 0, M_H_X005 - M_H_X003);
        this.kdJ = this.mPageContext.getResources().getString(R.string.home_read_here);
        this.mRoot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.readProgressBar.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cqL() != null) {
                    a.this.cqL().a(view, a.this.kdK);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPO() {
        final ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        if (layoutParams != null && layoutParams.height != kdG) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.personalize.readProgressBar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a.this.kdI.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    layoutParams.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.kdG - a.kdH)) + a.kdH);
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
            ao.setViewTextColor(this.kdI, R.color.CAM_X0304);
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_card_refresh16, ao.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            this.kdI.setCompoundDrawables(a2, null, null, null);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(b bVar) {
        if (bVar != null && this.mRoot.getLayoutParams() != null) {
            if (!bVar.kdQ) {
                this.mRoot.getLayoutParams().height = kdH;
                this.mRoot.requestLayout();
                this.kdI.setAlpha(0.0f);
            }
            if (this.mRoot.getLayoutParams().height != kdG) {
                bVar.kdQ = true;
                e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.readProgressBar.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cPO();
                    }
                }, 1600L);
            }
            this.kdI.setText(at.getFormatTimeShort(bVar.mTimeStamp) + this.kdJ);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
