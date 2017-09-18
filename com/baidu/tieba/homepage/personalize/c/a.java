package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View Rh;
    private View det;
    private View deu;
    private TextView dev;
    private String dew;
    private c dex;
    private final TbPageContext<?> mF;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mF = tbPageContext;
        this.Rh = getView();
        this.dev = (TextView) this.Rh.findViewById(d.h.read_progress_bar_time);
        this.det = this.Rh.findViewById(d.h.divider_line_under_homepage_read_progress);
        this.deu = this.Rh.findViewById(d.h.divider_line_under_homepage_read_time);
        this.dew = this.mF.getResources().getString(d.l.read_here);
        this.Rh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XL() != null) {
                    a.this.XL().a(view, a.this.dex);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.dev, d.e.cp_link_tip_a);
            aj.j(this.Rh, d.g.addresslist_item_bg);
            aj.k(this.det, d.e.cp_bg_line_c);
            aj.k(this.deu, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dex = cVar;
            this.dev.setText(am.s(cVar.deB) + this.dew);
            if (cVar.showBottomDivider) {
                this.deu.setVisibility(0);
            } else {
                this.deu.setVisibility(8);
            }
            d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
