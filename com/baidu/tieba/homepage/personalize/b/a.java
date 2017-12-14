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
    private View Se;
    private View dsE;
    private View dsF;
    private TextView dsG;
    private String dsH;
    private c dsI;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.Se = getView();
        this.dsG = (TextView) this.Se.findViewById(d.g.read_progress_bar_time);
        this.dsE = this.Se.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.dsF = this.Se.findViewById(d.g.divider_line_under_homepage_read_time);
        this.dsH = this.mPageContext.getResources().getString(d.j.read_here);
        this.Se.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.dsI);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.dsG, d.C0096d.cp_link_tip_a);
            aj.j(this.Se, d.f.addresslist_item_bg);
            aj.k(this.dsE, d.C0096d.cp_bg_line_c);
            aj.k(this.dsF, d.C0096d.cp_bg_line_c);
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
            this.dsI = cVar;
            this.dsG.setText(am.s(cVar.dsM) + this.dsH);
            if (cVar.showBottomDivider) {
                this.dsF.setVisibility(0);
            } else {
                this.dsF.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
