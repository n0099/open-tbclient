package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View Rh;
    private String ddA;
    private c ddB;
    private View ddx;
    private View ddy;
    private TextView ddz;
    private final TbPageContext<?> mF;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mF = tbPageContext;
        this.Rh = getView();
        this.ddz = (TextView) this.Rh.findViewById(d.h.read_progress_bar_time);
        this.ddx = this.Rh.findViewById(d.h.divider_line_under_homepage_read_progress);
        this.ddy = this.Rh.findViewById(d.h.divider_line_under_homepage_read_time);
        this.ddA = this.mF.getResources().getString(d.l.read_here);
        this.Rh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XA() != null) {
                    a.this.XA().a(view, a.this.ddB);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.i(this.ddz, d.e.cp_link_tip_a);
            aj.j(this.Rh, d.g.addresslist_item_bg);
            aj.k(this.ddx, d.e.cp_bg_line_c);
            aj.k(this.ddy, d.e.cp_bg_line_c);
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
            this.ddB = cVar;
            this.ddz.setText(am.s(cVar.ddF) + this.ddA);
            if (cVar.showBottomDivider) {
                this.ddy.setVisibility(0);
            } else {
                this.ddy.setVisibility(8);
            }
            d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
