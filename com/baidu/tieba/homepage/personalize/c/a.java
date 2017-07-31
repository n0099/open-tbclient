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
    private View Sd;
    private final TbPageContext<?> alI;
    private View cUS;
    private View cUT;
    private TextView cUU;
    private String cUV;
    private c cUW;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.alI = tbPageContext;
        this.Sd = getView();
        this.cUU = (TextView) this.Sd.findViewById(d.h.read_progress_bar_time);
        this.cUS = this.Sd.findViewById(d.h.divider_line_under_homepage_read_progress);
        this.cUT = this.Sd.findViewById(d.h.divider_line_under_homepage_read_time);
        this.cUV = this.alI.getResources().getString(d.l.read_here);
        this.Sd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We() != null) {
                    a.this.We().a(view, a.this.cUW);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.i(this.cUU, d.e.cp_link_tip_a);
            ai.j(this.Sd, d.g.addresslist_item_bg);
            ai.k(this.cUS, d.e.cp_bg_line_c);
            ai.k(this.cUT, d.e.cp_bg_line_c);
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
            this.cUW = cVar;
            this.cUU.setText(al.s(cVar.mTimeStamp) + this.cUV);
            if (cVar.showBottomDivider) {
                this.cUT.setVisibility(0);
            } else {
                this.cUT.setVisibility(8);
            }
            d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
