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
    private View Ry;
    private View diD;
    private View diE;
    private TextView diF;
    private String diG;
    private c diH;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.Ry = getView();
        this.diF = (TextView) this.Ry.findViewById(d.g.read_progress_bar_time);
        this.diD = this.Ry.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.diE = this.Ry.findViewById(d.g.divider_line_under_homepage_read_time);
        this.diG = this.mPageContext.getResources().getString(d.j.read_here);
        this.Ry.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ZJ() != null) {
                    a.this.ZJ().a(view, a.this.diH);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.diF, d.C0080d.cp_link_tip_a);
            aj.j(this.Ry, d.f.addresslist_item_bg);
            aj.k(this.diD, d.C0080d.cp_bg_line_c);
            aj.k(this.diE, d.C0080d.cp_bg_line_c);
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
            this.diH = cVar;
            this.diF.setText(am.s(cVar.diL) + this.diG);
            if (cVar.showBottomDivider) {
                this.diE.setVisibility(0);
            } else {
                this.diE.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
