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
    private static final int kin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds105);
    private static final int kio = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    private TextView kip;
    private String kiq;
    private b kir;
    private final TbPageContext<?> mPageContext;
    private View mRoot;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.mRoot = getView();
        this.kip = (TextView) this.mRoot.findViewById(R.id.read_progress_bar_time);
        this.kip.setPadding(0, M_H_X005, 0, M_H_X005 - M_H_X003);
        this.kiq = this.mPageContext.getResources().getString(R.string.home_read_here);
        this.mRoot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.readProgressBar.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cuD() != null) {
                    a.this.cuD().a(view, a.this.kir);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTG() {
        final ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        if (layoutParams != null && layoutParams.height != kin) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.personalize.readProgressBar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a.this.kip.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    layoutParams.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.kin - a.kio)) + a.kio);
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
            ao.setViewTextColor(this.kip, R.color.CAM_X0304);
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_card_refresh16, ao.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            this.kip.setCompoundDrawables(a2, null, null, null);
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
            if (!bVar.kix) {
                this.mRoot.getLayoutParams().height = kio;
                this.mRoot.requestLayout();
                this.kip.setAlpha(0.0f);
            }
            if (this.mRoot.getLayoutParams().height != kin) {
                bVar.kix = true;
                e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.readProgressBar.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cTG();
                    }
                }, 1600L);
            }
            this.kip.setText(at.getFormatTimeShort(bVar.mTimeStamp) + this.kiq);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
