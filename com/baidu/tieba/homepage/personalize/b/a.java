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
    private View Rt;
    private View daH;
    private View daI;
    private TextView daJ;
    private String daK;
    private c daL;
    private final TbPageContext<?> mG;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mG = tbPageContext;
        this.Rt = getView();
        this.daJ = (TextView) this.Rt.findViewById(d.h.read_progress_bar_time);
        this.daH = this.Rt.findViewById(d.h.divider_line_under_homepage_read_progress);
        this.daI = this.Rt.findViewById(d.h.divider_line_under_homepage_read_time);
        this.daK = this.mG.getResources().getString(d.l.read_here);
        this.Rt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xr() != null) {
                    a.this.Xr().a(view, a.this.daL);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.daJ, d.e.cp_link_tip_a);
            aj.j(this.Rt, d.g.addresslist_item_bg);
            aj.k(this.daH, d.e.cp_bg_line_c);
            aj.k(this.daI, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.daL = cVar;
            this.daJ.setText(am.r(cVar.daP) + this.daK);
            if (cVar.showBottomDivider) {
                this.daI.setVisibility(0);
            } else {
                this.daI.setVisibility(8);
            }
            d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
