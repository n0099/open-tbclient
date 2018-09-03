package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<c> {
    private View aaW;
    private c dZA;
    private View dZw;
    private View dZx;
    private TextView dZy;
    private String dZz;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.aaW = getView();
        this.dZy = (TextView) this.aaW.findViewById(f.g.read_progress_bar_time);
        this.dZw = this.aaW.findViewById(f.g.divider_line_under_homepage_read_progress);
        this.dZx = this.aaW.findViewById(f.g.divider_line_under_homepage_read_time);
        this.dZz = this.mPageContext.getResources().getString(f.j.read_here);
        this.aaW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.dZA);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.h(this.dZy, f.d.cp_link_tip_a);
            am.i(this.aaW, f.C0146f.addresslist_item_bg);
            am.j(this.dZw, f.d.cp_bg_line_c);
            am.j(this.dZx, f.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_read_progress_bar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.dZA = cVar;
            this.dZy.setText(ap.y(cVar.dZF) + this.dZz);
            if (cVar.showBottomDivider) {
                this.dZx.setVisibility(0);
            } else {
                this.dZx.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
