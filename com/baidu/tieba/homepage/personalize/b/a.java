package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View adA;
    private View egS;
    private View egT;
    private TextView egU;
    private String egV;
    private c egW;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.adA = getView();
        this.egU = (TextView) this.adA.findViewById(e.g.read_progress_bar_time);
        this.egS = this.adA.findViewById(e.g.divider_line_under_homepage_read_progress);
        this.egT = this.adA.findViewById(e.g.divider_line_under_homepage_read_time);
        this.egV = this.mPageContext.getResources().getString(e.j.read_here);
        this.adA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view, a.this.egW);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.egU, e.d.cp_link_tip_a);
            al.i(this.adA, e.f.addresslist_item_bg);
            al.j(this.egS, e.d.cp_bg_line_c);
            al.j(this.egT, e.d.cp_bg_line_c);
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
            this.egW = cVar;
            this.egU.setText(ao.C(cVar.ehb) + this.egV);
            if (cVar.showBottomDivider) {
                this.egT.setVisibility(0);
            } else {
                this.egT.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
