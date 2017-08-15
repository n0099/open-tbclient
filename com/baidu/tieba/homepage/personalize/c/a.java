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
    private View Sf;
    private View cWR;
    private View cWS;
    private TextView cWT;
    private String cWU;
    private c cWV;
    private int mSkinType;
    private final TbPageContext<?> oV;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.oV = tbPageContext;
        this.Sf = getView();
        this.cWT = (TextView) this.Sf.findViewById(d.h.read_progress_bar_time);
        this.cWR = this.Sf.findViewById(d.h.divider_line_under_homepage_read_progress);
        this.cWS = this.Sf.findViewById(d.h.divider_line_under_homepage_read_time);
        this.cWU = this.oV.getResources().getString(d.l.read_here);
        this.Sf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.WA() != null) {
                    a.this.WA().a(view, a.this.cWV);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.i(this.cWT, d.e.cp_link_tip_a);
            ai.j(this.Sf, d.g.addresslist_item_bg);
            ai.k(this.cWR, d.e.cp_bg_line_c);
            ai.k(this.cWS, d.e.cp_bg_line_c);
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
            this.cWV = cVar;
            this.cWT.setText(al.s(cVar.mTimeStamp) + this.cWU);
            if (cVar.showBottomDivider) {
                this.cWS.setVisibility(0);
            } else {
                this.cWS.setVisibility(8);
            }
            d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
