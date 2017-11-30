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
    private View Sh;
    private View drA;
    private TextView drB;
    private String drC;
    private c drD;
    private View drz;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.Sh = getView();
        this.drB = (TextView) this.Sh.findViewById(d.g.read_progress_bar_time);
        this.drz = this.Sh.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.drA = this.Sh.findViewById(d.g.divider_line_under_homepage_read_time);
        this.drC = this.mPageContext.getResources().getString(d.j.read_here);
        this.Sh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abs() != null) {
                    a.this.abs().a(view, a.this.drD);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.drB, d.C0082d.cp_link_tip_a);
            aj.j(this.Sh, d.f.addresslist_item_bg);
            aj.k(this.drz, d.C0082d.cp_bg_line_c);
            aj.k(this.drA, d.C0082d.cp_bg_line_c);
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
            this.drD = cVar;
            this.drB.setText(am.s(cVar.drH) + this.drC);
            if (cVar.showBottomDivider) {
                this.drA.setVisibility(0);
            } else {
                this.drA.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
