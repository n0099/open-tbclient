package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View aaV;
    private View dZA;
    private TextView dZB;
    private String dZC;
    private c dZD;
    private View dZz;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aaV = getView();
        this.dZB = (TextView) this.aaV.findViewById(d.g.read_progress_bar_time);
        this.dZz = this.aaV.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.dZA = this.aaV.findViewById(d.g.divider_line_under_homepage_read_time);
        this.dZC = this.mPageContext.getResources().getString(d.j.read_here);
        this.aaV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.dZD);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.dZB, d.C0140d.cp_link_tip_a);
            am.i(this.aaV, d.f.addresslist_item_bg);
            am.j(this.dZz, d.C0140d.cp_bg_line_c);
            am.j(this.dZA, d.C0140d.cp_bg_line_c);
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
            this.dZD = cVar;
            this.dZB.setText(ap.y(cVar.dZI) + this.dZC);
            if (cVar.showBottomDivider) {
                this.dZA.setVisibility(0);
            } else {
                this.dZA.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
