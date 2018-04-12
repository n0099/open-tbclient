package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View Tl;
    private View dFv;
    private View dFw;
    private TextView dFx;
    private String dFy;
    private c dFz;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.Tl = getView();
        this.dFx = (TextView) this.Tl.findViewById(d.g.read_progress_bar_time);
        this.dFv = this.Tl.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.dFw = this.Tl.findViewById(d.g.divider_line_under_homepage_read_time);
        this.dFy = this.mPageContext.getResources().getString(d.k.read_here);
        this.Tl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.dFz);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.h(this.dFx, d.C0126d.cp_link_tip_a);
            ak.i(this.Tl, d.f.addresslist_item_bg);
            ak.j(this.dFv, d.C0126d.cp_bg_line_c);
            ak.j(this.dFw, d.C0126d.cp_bg_line_c);
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
            this.dFz = cVar;
            this.dFx.setText(an.t(cVar.dFD) + this.dFy);
            if (cVar.showBottomDivider) {
                this.dFw.setVisibility(0);
            } else {
                this.dFw.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
