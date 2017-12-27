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
    private View aGJ;
    private View eeO;
    private View eeP;
    private TextView eeQ;
    private String eeR;
    private c eeS;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aGJ = getView();
        this.eeQ = (TextView) this.aGJ.findViewById(d.g.read_progress_bar_time);
        this.eeO = this.aGJ.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.eeP = this.aGJ.findViewById(d.g.divider_line_under_homepage_read_time);
        this.eeR = this.mPageContext.getResources().getString(d.j.read_here);
        this.aGJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiY() != null) {
                    a.this.aiY().a(view, a.this.eeS);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.eeQ, d.C0108d.cp_link_tip_a);
            aj.s(this.aGJ, d.f.addresslist_item_bg);
            aj.t(this.eeO, d.C0108d.cp_bg_line_c);
            aj.t(this.eeP, d.C0108d.cp_bg_line_c);
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
            this.eeS = cVar;
            this.eeQ.setText(am.A(cVar.eeW) + this.eeR);
            if (cVar.showBottomDivider) {
                this.eeP.setVisibility(0);
            } else {
                this.eeP.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
