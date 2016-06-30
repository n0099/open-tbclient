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
    private final int aRA;
    private final int aRz;
    private final int maxHeight;
    private final int maxWidth;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Resources resources = tbPageContext.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(u.e.ds160);
        this.aRz = (int) (resources.getDimension(u.e.ds594) - resources.getDimension(u.e.ds20));
        this.aRA = (int) (resources.getDimension(u.e.ds260) - resources.getDimension(u.e.ds10));
        this.maxWidth = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst().getContext()) - dimensionPixelSize;
        this.maxHeight = resources.getDimensionPixelSize(u.e.ds321);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_advert_app_item;
    }

    @Override // com.baidu.tieba.card.f
    protected void R(View view) {
        this.aRK = (TbImageView) view.findViewById(u.g.advert_app_img);
        this.aRK.setDrawBorder(true);
        this.aRK.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.f
    protected void a(boolean z, com.baidu.tieba.card.a.d dVar) {
        String Lq = dVar.Lq();
        boolean a = a(this.aRK, dVar.Ls());
        if (z && !TextUtils.isEmpty(Lq) && a) {
            this.aRK.setVisibility(0);
            this.aRK.c(Lq, this.mIsFromCDN ? 30 : 31, false);
            return;
        }
        this.aRK.setVisibility(8);
    }

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || bVar.MW == null || tbImageView == null) {
            a(tbImageView, this.aRA, this.aRz);
            return true;
        }
        int i = this.maxWidth;
        if (!bVar.MW.Nm) {
            a(tbImageView, (this.aRA * i) / this.aRz, i);
            return true;
        }
        int i2 = bVar.MW.height;
        int i3 = bVar.MW.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.aRA, this.aRz);
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
    protected String KQ() {
        return "FRS";
    }
}
