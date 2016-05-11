package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class c extends f {
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_advert_app_multipic_item;
    }

    @Override // com.baidu.tieba.card.f
    protected void Q(View view) {
        this.aOo = (TbImageView) view.findViewById(t.g.advert_app_img_left);
        this.aOp = (TbImageView) view.findViewById(t.g.advert_app_img_center);
        this.aOq = (TbImageView) view.findViewById(t.g.advert_app_img_right);
        this.aOr = view.findViewById(t.g.advert_app_img_container);
        this.aOo.setDrawBorder(true);
        this.aOo.setBorderWidth(1);
        this.aOp.setDrawBorder(true);
        this.aOp.setBorderWidth(1);
        this.aOq.setDrawBorder(true);
        this.aOq.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.f
    protected void a(boolean z, com.baidu.tieba.card.a.d dVar) {
        List<String> Ks = dVar.Ks();
        int size = Ks != null ? Ks.size() : 0;
        if (d(z, size)) {
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                this.aOo.c(Ks.get(0), i, false);
            } else if (size == 2) {
                this.aOo.c(Ks.get(0), i, false);
                this.aOp.c(Ks.get(1), i, false);
            } else if (size >= 3) {
                this.aOo.c(Ks.get(0), i, false);
                this.aOp.c(Ks.get(1), i, false);
                this.aOq.c(Ks.get(2), i, false);
            }
        }
    }

    private boolean d(boolean z, int i) {
        if (!z || i == 0) {
            this.aOr.setVisibility(8);
            return false;
        }
        this.aOr.setVisibility(0);
        if (i == 1) {
            this.aOo.setVisibility(0);
            this.aOp.setVisibility(4);
            this.aOq.setVisibility(4);
            return true;
        } else if (i == 2) {
            this.aOo.setVisibility(0);
            this.aOp.setVisibility(0);
            this.aOq.setVisibility(4);
            return true;
        } else {
            this.aOo.setVisibility(0);
            this.aOp.setVisibility(0);
            this.aOq.setVisibility(0);
            return true;
        }
    }

    @Override // com.baidu.tieba.card.f
    protected String JP() {
        return "FRS";
    }
}
