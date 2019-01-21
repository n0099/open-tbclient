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
    private View anp;
    private View eAF;
    private View eAG;
    private TextView eAH;
    private String eAI;
    private c eAJ;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.anp = getView();
        this.eAH = (TextView) this.anp.findViewById(e.g.read_progress_bar_time);
        this.eAF = this.anp.findViewById(e.g.divider_line_under_homepage_read_progress);
        this.eAG = this.anp.findViewById(e.g.divider_line_under_homepage_read_time);
        this.eAI = this.mPageContext.getResources().getString(e.j.read_here);
        this.anp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.eAJ);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.eAH, e.d.cp_link_tip_a);
            al.i(this.anp, e.f.addresslist_item_bg);
            al.j(this.eAF, e.d.cp_bg_line_c);
            al.j(this.eAG, e.d.cp_bg_line_c);
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
            this.eAJ = cVar;
            this.eAH.setText(ao.O(cVar.mTimeStamp) + this.eAI);
            if (cVar.showBottomDivider) {
                this.eAG.setVisibility(0);
            } else {
                this.eAG.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
