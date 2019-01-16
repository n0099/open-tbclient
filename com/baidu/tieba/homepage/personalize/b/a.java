package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View ano;
    private View eAE;
    private View eAF;
    private TextView eAG;
    private String eAH;
    private c eAI;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.ano = getView();
        this.eAG = (TextView) this.ano.findViewById(e.g.read_progress_bar_time);
        this.eAE = this.ano.findViewById(e.g.divider_line_under_homepage_read_progress);
        this.eAF = this.ano.findViewById(e.g.divider_line_under_homepage_read_time);
        this.eAH = this.mPageContext.getResources().getString(e.j.read_here);
        this.ano.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.eAI);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.eAG, e.d.cp_link_tip_a);
            al.i(this.ano, e.f.addresslist_item_bg);
            al.j(this.eAE, e.d.cp_bg_line_c);
            al.j(this.eAF, e.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.eAI = cVar;
            this.eAG.setText(ao.O(cVar.mTimeStamp) + this.eAH);
            if (cVar.showBottomDivider) {
                this.eAF.setVisibility(0);
            } else {
                this.eAF.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
