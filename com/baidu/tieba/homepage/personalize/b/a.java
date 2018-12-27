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
    private View amM;
    private View ezT;
    private View ezU;
    private TextView ezV;
    private String ezW;
    private c ezX;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.amM = getView();
        this.ezV = (TextView) this.amM.findViewById(e.g.read_progress_bar_time);
        this.ezT = this.amM.findViewById(e.g.divider_line_under_homepage_read_progress);
        this.ezU = this.amM.findViewById(e.g.divider_line_under_homepage_read_time);
        this.ezW = this.mPageContext.getResources().getString(e.j.read_here);
        this.amM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view, a.this.ezX);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.ezV, e.d.cp_link_tip_a);
            al.i(this.amM, e.f.addresslist_item_bg);
            al.j(this.ezT, e.d.cp_bg_line_c);
            al.j(this.ezU, e.d.cp_bg_line_c);
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
            this.ezX = cVar;
            this.ezV.setText(ao.O(cVar.mTimeStamp) + this.ezW);
            if (cVar.showBottomDivider) {
                this.ezU.setVisibility(0);
            } else {
                this.ezU.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
