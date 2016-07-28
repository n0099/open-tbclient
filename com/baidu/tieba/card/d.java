package com.baidu.tieba.card;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends f {
    private final int aSt;
    private final int aSu;
    private final int maxHeight;
    private final int maxWidth;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Resources resources = tbPageContext.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(u.e.ds160);
        this.aSt = (int) (resources.getDimension(u.e.ds594) - resources.getDimension(u.e.ds20));
        this.aSu = (int) (resources.getDimension(u.e.ds260) - resources.getDimension(u.e.ds10));
        this.maxWidth = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m10getInst().getContext()) - dimensionPixelSize;
        this.maxHeight = resources.getDimensionPixelSize(u.e.ds321);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_advert_app_item;
    }

    @Override // com.baidu.tieba.card.f
    protected void R(View view) {
        this.aSE = (TbImageView) view.findViewById(u.g.advert_app_img);
        this.aSE.setDrawBorder(true);
        this.aSE.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.f
    protected void a(boolean z, com.baidu.tieba.card.a.d dVar) {
        String Lp = dVar.Lp();
        boolean a = a(this.aSE, dVar.Lr());
        if (z && !TextUtils.isEmpty(Lp) && a) {
            this.aSE.setVisibility(0);
            this.aSE.c(Lp, this.mIsFromCDN ? 30 : 31, false);
            return;
        }
        this.aSE.setVisibility(8);
    }

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || bVar.MU == null || tbImageView == null) {
            a(tbImageView, this.aSu, this.aSt);
            return true;
        }
        int i = this.maxWidth;
        if (!bVar.MU.Nk) {
            a(tbImageView, (this.aSu * i) / this.aSt, i);
            return true;
        }
        int i2 = bVar.MU.height;
        int i3 = bVar.MU.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.aSu, this.aSt);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > this.maxHeight) {
            return false;
        }
        a(tbImageView, i4, i);
        return true;
    }

    private void a(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i2, i);
            } else {
                layoutParams.height = i;
                layoutParams.width = i2;
            }
            tbImageView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.card.f
    protected String KP() {
        return "FRS";
    }
}
