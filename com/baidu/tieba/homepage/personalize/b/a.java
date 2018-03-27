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
    private View aHT;
    private View ekQ;
    private View ekR;
    private TextView ekS;
    private String ekT;
    private c ekU;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aHT = getView();
        this.ekS = (TextView) this.aHT.findViewById(d.g.read_progress_bar_time);
        this.ekQ = this.aHT.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.ekR = this.aHT.findViewById(d.g.divider_line_under_homepage_read_time);
        this.ekT = this.mPageContext.getResources().getString(d.j.read_here);
        this.aHT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.ekU);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.r(this.ekS, d.C0141d.cp_link_tip_a);
            aj.s(this.aHT, d.f.addresslist_item_bg);
            aj.t(this.ekQ, d.C0141d.cp_bg_line_c);
            aj.t(this.ekR, d.C0141d.cp_bg_line_c);
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
            this.ekU = cVar;
            this.ekS.setText(am.A(cVar.ekY) + this.ekT);
            if (cVar.showBottomDivider) {
                this.ekR.setVisibility(0);
            } else {
                this.ekR.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
