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
    private View aGK;
    private View egA;
    private View egB;
    private TextView egC;
    private String egD;
    private c egE;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aGK = getView();
        this.egC = (TextView) this.aGK.findViewById(d.g.read_progress_bar_time);
        this.egA = this.aGK.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.egB = this.aGK.findViewById(d.g.divider_line_under_homepage_read_time);
        this.egD = this.mPageContext.getResources().getString(d.j.read_here);
        this.aGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akg() != null) {
                    a.this.akg().a(view, a.this.egE);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.egC, d.C0108d.cp_link_tip_a);
            aj.s(this.aGK, d.f.addresslist_item_bg);
            aj.t(this.egA, d.C0108d.cp_bg_line_c);
            aj.t(this.egB, d.C0108d.cp_bg_line_c);
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
            this.egE = cVar;
            this.egC.setText(am.A(cVar.egI) + this.egD);
            if (cVar.showBottomDivider) {
                this.egB.setVisibility(0);
            } else {
                this.egB.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
