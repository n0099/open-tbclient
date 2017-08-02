package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View QE;
    private final TbPageContext<?> ako;
    private View cTA;
    private TextView cTB;
    private String cTC;
    private c cTD;
    private View cTz;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ako = tbPageContext;
        this.QE = getView();
        this.cTB = (TextView) this.QE.findViewById(d.h.read_progress_bar_time);
        this.cTz = this.QE.findViewById(d.h.divider_line_under_homepage_read_progress);
        this.cTA = this.QE.findViewById(d.h.divider_line_under_homepage_read_time);
        this.cTC = this.ako.getResources().getString(d.l.read_here);
        this.QE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.VZ() != null) {
                    a.this.VZ().a(view, a.this.cTD);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.i(this.cTB, d.e.cp_link_tip_a);
            ai.j(this.QE, d.g.addresslist_item_bg);
            ai.k(this.cTz, d.e.cp_bg_line_c);
            ai.k(this.cTA, d.e.cp_bg_line_c);
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
            this.cTD = cVar;
            this.cTB.setText(al.s(cVar.mTimeStamp) + this.cTC);
            if (cVar.showBottomDivider) {
                this.cTA.setVisibility(0);
            } else {
                this.cTA.setVisibility(8);
            }
            d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
