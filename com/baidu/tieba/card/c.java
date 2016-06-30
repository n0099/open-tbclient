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
        this.aRL = (TbImageView) view.findViewById(u.g.advert_app_img_left);
        this.aRM = (TbImageView) view.findViewById(u.g.advert_app_img_center);
        this.aRN = (TbImageView) view.findViewById(u.g.advert_app_img_right);
        this.aRO = view.findViewById(u.g.advert_app_img_container);
        this.aRL.setDrawBorder(true);
        this.aRL.setBorderWidth(1);
        this.aRM.setDrawBorder(true);
        this.aRM.setBorderWidth(1);
        this.aRN.setDrawBorder(true);
        this.aRN.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.f
    protected void a(boolean z, com.baidu.tieba.card.a.d dVar) {
        List<String> Lr = dVar.Lr();
        int size = Lr != null ? Lr.size() : 0;
        if (c(z, size)) {
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                this.aRL.c(Lr.get(0), i, false);
            } else if (size == 2) {
                this.aRL.c(Lr.get(0), i, false);
                this.aRM.c(Lr.get(1), i, false);
            } else if (size >= 3) {
                this.aRL.c(Lr.get(0), i, false);
                this.aRM.c(Lr.get(1), i, false);
                this.aRN.c(Lr.get(2), i, false);
            }
        }
    }

    private boolean c(boolean z, int i) {
        if (!z || i == 0) {
            this.aRO.setVisibility(8);
            return false;
        }
        this.aRO.setVisibility(0);
        if (i == 1) {
            this.aRL.setVisibility(0);
            this.aRM.setVisibility(4);
            this.aRN.setVisibility(4);
            return true;
        } else if (i == 2) {
            this.aRL.setVisibility(0);
            this.aRM.setVisibility(0);
            this.aRN.setVisibility(4);
            return true;
        } else {
            this.aRL.setVisibility(0);
            this.aRM.setVisibility(0);
            this.aRN.setVisibility(0);
            return true;
        }
    }

    @Override // com.baidu.tieba.card.f
    protected String KQ() {
        return "FRS";
    }
}
