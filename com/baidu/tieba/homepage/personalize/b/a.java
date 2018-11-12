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
    private View ajk;
    private View eqg;
    private View eqh;
    private TextView eqi;
    private String eqj;
    private c eqk;
    private final TbPageContext<?> mPageContext;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.ajk = getView();
        this.eqi = (TextView) this.ajk.findViewById(e.g.read_progress_bar_time);
        this.eqg = this.ajk.findViewById(e.g.divider_line_under_homepage_read_progress);
        this.eqh = this.ajk.findViewById(e.g.divider_line_under_homepage_read_time);
        this.eqj = this.mPageContext.getResources().getString(e.j.read_here);
        this.ajk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view, a.this.eqk);
                }
            }
        });
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.h(this.eqi, e.d.cp_link_tip_a);
            al.i(this.ajk, e.f.addresslist_item_bg);
            al.j(this.eqg, e.d.cp_bg_line_c);
            al.j(this.eqh, e.d.cp_bg_line_c);
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
            this.eqk = cVar;
            this.eqi.setText(ao.G(cVar.mTimeStamp) + this.eqj);
            if (cVar.showBottomDivider) {
                this.eqh.setVisibility(0);
            } else {
                this.eqh.setVisibility(8);
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
