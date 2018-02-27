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
    private View aHS;
    private View ekA;
    private View ekB;
    private TextView ekC;
    private String ekD;
    private c ekE;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aHS = getView();
        this.ekC = (TextView) this.aHS.findViewById(d.g.read_progress_bar_time);
        this.ekA = this.aHS.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.ekB = this.aHS.findViewById(d.g.divider_line_under_homepage_read_time);
        this.ekD = this.mPageContext.getResources().getString(d.j.read_here);
        this.aHS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akO() != null) {
                    a.this.akO().a(view, a.this.ekE);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.ekC, d.C0141d.cp_link_tip_a);
            aj.s(this.aHS, d.f.addresslist_item_bg);
            aj.t(this.ekA, d.C0141d.cp_bg_line_c);
            aj.t(this.ekB, d.C0141d.cp_bg_line_c);
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
            this.ekE = cVar;
            this.ekC.setText(am.A(cVar.ekI) + this.ekD);
            if (cVar.showBottomDivider) {
                this.ekB.setVisibility(0);
            } else {
                this.ekB.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
