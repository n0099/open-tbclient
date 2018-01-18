package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View aGH;
    private View egf;
    private View egg;
    private TextView egh;
    private String egi;
    private c egj;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aGH = getView();
        this.egh = (TextView) this.aGH.findViewById(d.g.read_progress_bar_time);
        this.egf = this.aGH.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.egg = this.aGH.findViewById(d.g.divider_line_under_homepage_read_time);
        this.egi = this.mPageContext.getResources().getString(d.j.read_here);
        this.aGH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akb() != null) {
                    a.this.akb().a(view, a.this.egj);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.egh, d.C0107d.cp_link_tip_a);
            aj.s(this.aGH, d.f.addresslist_item_bg);
            aj.t(this.egf, d.C0107d.cp_bg_line_c);
            aj.t(this.egg, d.C0107d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.egj = cVar;
            this.egh.setText(am.A(cVar.egn) + this.egi);
            if (cVar.showBottomDivider) {
                this.egg.setVisibility(0);
            } else {
                this.egg.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
