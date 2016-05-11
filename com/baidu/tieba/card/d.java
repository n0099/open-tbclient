package com.baidu.tieba.card;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends f {
    private final int aOc;
    private final int aOd;
    private final int maxHeight;
    private final int maxWidth;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Resources resources = tbPageContext.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(t.e.ds160);
        this.aOc = (int) (resources.getDimension(t.e.ds594) - resources.getDimension(t.e.ds20));
        this.aOd = (int) (resources.getDimension(t.e.ds260) - resources.getDimension(t.e.ds10));
        this.maxWidth = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst().getContext()) - dimensionPixelSize;
        this.maxHeight = resources.getDimensionPixelSize(t.e.ds321);
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_advert_app_item;
    }

    @Override // com.baidu.tieba.card.f
    protected void Q(View view) {
        this.aOn = (TbImageView) view.findViewById(t.g.advert_app_img);
        this.aOn.setDrawBorder(true);
        this.aOn.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.f
    protected void a(boolean z, com.baidu.tieba.card.a.d dVar) {
        String Kr = dVar.Kr();
        boolean a = a(this.aOn, dVar.Kt());
        if (z && !TextUtils.isEmpty(Kr) && a) {
            this.aOn.setVisibility(0);
            this.aOn.c(Kr, this.mIsFromCDN ? 30 : 31, false);
            return;
        }
        this.aOn.setVisibility(8);
    }

    private boolean a(TbImageView tbImageView, com.baidu.tbadk.core.data.c cVar) {
        if (cVar == null || cVar.Nb == null || tbImageView == null) {
            a(tbImageView, this.aOd, this.aOc);
            return true;
        }
        int i = this.maxWidth;
        if (!cVar.Nb.Nq) {
            a(tbImageView, (this.aOd * i) / this.aOc, i);
            return true;
        }
        int i2 = cVar.Nb.height;
        int i3 = cVar.Nb.width;
        if (this.maxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            a(tbImageView, this.aOd, this.aOc);
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
    protected String JP() {
        return "FRS";
    }
}
