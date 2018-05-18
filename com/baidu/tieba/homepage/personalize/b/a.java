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
    private View Th;
    private TextView dGA;
    private String dGB;
    private c dGC;
    private View dGy;
    private View dGz;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.Th = getView();
        this.dGA = (TextView) this.Th.findViewById(d.g.read_progress_bar_time);
        this.dGy = this.Th.findViewById(d.g.divider_line_under_homepage_read_progress);
        this.dGz = this.Th.findViewById(d.g.divider_line_under_homepage_read_time);
        this.dGB = this.mPageContext.getResources().getString(d.k.read_here);
        this.Th.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.dGC);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.h(this.dGA, d.C0126d.cp_link_tip_a);
            ak.i(this.Th, d.f.addresslist_item_bg);
            ak.j(this.dGy, d.C0126d.cp_bg_line_c);
            ak.j(this.dGz, d.C0126d.cp_bg_line_c);
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
            this.dGC = cVar;
            this.dGA.setText(an.t(cVar.dGG) + this.dGB);
            if (cVar.showBottomDivider) {
                this.dGz.setVisibility(0);
            } else {
                this.dGz.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
