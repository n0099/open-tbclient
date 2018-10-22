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
    private View aix;
    private View eoN;
    private View eoO;
    private TextView eoP;
    private String eoQ;
    private c eoR;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aix = getView();
        this.eoP = (TextView) this.aix.findViewById(e.g.read_progress_bar_time);
        this.eoN = this.aix.findViewById(e.g.divider_line_under_homepage_read_progress);
        this.eoO = this.aix.findViewById(e.g.divider_line_under_homepage_read_time);
        this.eoQ = this.mPageContext.getResources().getString(e.j.read_here);
        this.aix.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view, a.this.eoR);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.eoP, e.d.cp_link_tip_a);
            al.i(this.aix, e.f.addresslist_item_bg);
            al.j(this.eoN, e.d.cp_bg_line_c);
            al.j(this.eoO, e.d.cp_bg_line_c);
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
            this.eoR = cVar;
            this.eoP.setText(ao.E(cVar.mTimeStamp) + this.eoQ);
            if (cVar.showBottomDivider) {
                this.eoO.setVisibility(0);
            } else {
                this.eoO.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
