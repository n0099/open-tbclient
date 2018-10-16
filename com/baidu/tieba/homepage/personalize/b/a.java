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
    private View eoM;
    private View eoN;
    private TextView eoO;
    private String eoP;
    private c eoQ;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aix = getView();
        this.eoO = (TextView) this.aix.findViewById(e.g.read_progress_bar_time);
        this.eoM = this.aix.findViewById(e.g.divider_line_under_homepage_read_progress);
        this.eoN = this.aix.findViewById(e.g.divider_line_under_homepage_read_time);
        this.eoP = this.mPageContext.getResources().getString(e.j.read_here);
        this.aix.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anO() != null) {
                    a.this.anO().a(view, a.this.eoQ);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.eoO, e.d.cp_link_tip_a);
            al.i(this.aix, e.f.addresslist_item_bg);
            al.j(this.eoM, e.d.cp_bg_line_c);
            al.j(this.eoN, e.d.cp_bg_line_c);
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
            this.eoQ = cVar;
            this.eoO.setText(ao.E(cVar.mTimeStamp) + this.eoP);
            if (cVar.showBottomDivider) {
                this.eoN.setVisibility(0);
            } else {
                this.eoN.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
