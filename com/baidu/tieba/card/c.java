package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class c extends f {
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_advert_app_multipic_item;
    }

    @Override // com.baidu.tieba.card.f
    protected void R(View view) {
        this.aSF = (TbImageView) view.findViewById(u.g.advert_app_img_left);
        this.aSG = (TbImageView) view.findViewById(u.g.advert_app_img_center);
        this.aSH = (TbImageView) view.findViewById(u.g.advert_app_img_right);
        this.aSI = view.findViewById(u.g.advert_app_img_container);
        this.aSF.setDrawBorder(true);
        this.aSF.setBorderWidth(1);
        this.aSG.setDrawBorder(true);
        this.aSG.setBorderWidth(1);
        this.aSH.setDrawBorder(true);
        this.aSH.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.f
    protected void a(boolean z, com.baidu.tieba.card.a.d dVar) {
        List<String> Lq = dVar.Lq();
        int size = Lq != null ? Lq.size() : 0;
        if (d(z, size)) {
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                this.aSF.c(Lq.get(0), i, false);
            } else if (size == 2) {
                this.aSF.c(Lq.get(0), i, false);
                this.aSG.c(Lq.get(1), i, false);
            } else if (size >= 3) {
                this.aSF.c(Lq.get(0), i, false);
                this.aSG.c(Lq.get(1), i, false);
                this.aSH.c(Lq.get(2), i, false);
            }
        }
    }

    private boolean d(boolean z, int i) {
        if (!z || i == 0) {
            this.aSI.setVisibility(8);
            return false;
        }
        this.aSI.setVisibility(0);
        if (i == 1) {
            this.aSF.setVisibility(0);
            this.aSG.setVisibility(4);
            this.aSH.setVisibility(4);
            return true;
        } else if (i == 2) {
            this.aSF.setVisibility(0);
            this.aSG.setVisibility(0);
            this.aSH.setVisibility(4);
            return true;
        } else {
            this.aSF.setVisibility(0);
            this.aSG.setVisibility(0);
            this.aSH.setVisibility(0);
            return true;
        }
    }

    @Override // com.baidu.tieba.card.f
    protected String KP() {
        return "FRS";
    }
}
