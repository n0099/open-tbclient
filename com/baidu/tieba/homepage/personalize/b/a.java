package com.baidu.tieba.homepage.personalize.b;

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
    private View das;
    private View dau;
    private TextView dav;
    private String daw;
    private c dax;
    private final TbPageContext<?> mH;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mH = tbPageContext;
        this.Rh = getView();
        this.dav = (TextView) this.Rh.findViewById(d.h.read_progress_bar_time);
        this.das = this.Rh.findViewById(d.h.divider_line_under_homepage_read_progress);
        this.dau = this.Rh.findViewById(d.h.divider_line_under_homepage_read_time);
        this.daw = this.mH.getResources().getString(d.l.read_here);
        this.Rh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xn() != null) {
                    a.this.Xn().a(view, a.this.dax);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.dav, d.e.cp_link_tip_a);
            aj.j(this.Rh, d.g.addresslist_item_bg);
            aj.k(this.das, d.e.cp_bg_line_c);
            aj.k(this.dau, d.e.cp_bg_line_c);
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
            this.dax = cVar;
            this.dav.setText(am.s(cVar.daC) + this.daw);
            if (cVar.showBottomDivider) {
                this.dau.setVisibility(0);
            } else {
                this.dau.setVisibility(8);
            }
            d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
