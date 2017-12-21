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
    private View Sf;
    private View dsI;
    private View dsJ;
    private TextView dsK;
    private String dsL;
    private c dsM;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.Sf = getView();
        this.dsK = (TextView) this.Sf.findViewById(d.g.read_progress_bar_time);
        this.dsI = this.Sf.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.dsJ = this.Sf.findViewById(d.g.divider_line_under_homepage_read_time);
        this.dsL = this.mPageContext.getResources().getString(d.j.read_here);
        this.Sf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.dsM);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.dsK, d.C0095d.cp_link_tip_a);
            aj.j(this.Sf, d.f.addresslist_item_bg);
            aj.k(this.dsI, d.C0095d.cp_bg_line_c);
            aj.k(this.dsJ, d.C0095d.cp_bg_line_c);
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
            this.dsM = cVar;
            this.dsK.setText(am.s(cVar.dsQ) + this.dsL);
            if (cVar.showBottomDivider) {
                this.dsJ.setVisibility(0);
            } else {
                this.dsJ.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
