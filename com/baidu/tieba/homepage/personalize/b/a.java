package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View abp;
    private View dRO;
    private View dRP;
    private TextView dRQ;
    private String dRR;
    private c dRS;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.abp = getView();
        this.dRQ = (TextView) this.abp.findViewById(d.g.read_progress_bar_time);
        this.dRO = this.abp.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.dRP = this.abp.findViewById(d.g.divider_line_under_homepage_read_time);
        this.dRR = this.mPageContext.getResources().getString(d.k.read_here);
        this.abp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiI() != null) {
                    a.this.aiI().a(view, a.this.dRS);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.dRQ, d.C0141d.cp_link_tip_a);
            al.i(this.abp, d.f.addresslist_item_bg);
            al.j(this.dRO, d.C0141d.cp_bg_line_c);
            al.j(this.dRP, d.C0141d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dRS = cVar;
            this.dRQ.setText(ao.w(cVar.dRW) + this.dRR);
            if (cVar.showBottomDivider) {
                this.dRP.setVisibility(0);
            } else {
                this.dRP.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
