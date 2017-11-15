package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k extends j {
    private TextView bRS;
    private ThreadLinkView bTL;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void ad(View view) {
        if (view != null) {
            this.bTL = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.bTL.setTag(getTag());
            this.bRS = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        if (bhVar != null) {
            super.a(bhVar);
            if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rr() == null || bhVar.rr().size() == 0)) || bhVar.rJ() == 1) {
                bhVar.e(false, true);
                if (bhVar.rU() == null || StringUtils.isNull(bhVar.rU().toString())) {
                    this.bRS.setVisibility(8);
                } else {
                    this.bRS.setVisibility(0);
                    this.bRS.setText(bhVar.rU());
                }
            } else {
                this.bRS.setVisibility(0);
                bhVar.YC = 0;
                bhVar.e(false, bhVar.ss());
                SpannableStringBuilder rU = bhVar.rU();
                this.bRS.setOnTouchListener(new com.baidu.tieba.view.l(rU));
                this.bRS.setText(rU);
                m.a(this.bRS, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            }
            this.bTL.setData(this.ajq);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bTL.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void ZO() {
        super.ZO();
        m.a(this.bRS, this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        this.bTL.er(this.ajq.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void eV(boolean z) {
        super.eV(z);
        if (this.cGj != null) {
            this.cGj.setVisibility(0);
        }
        if (this.aXj != null) {
            this.aXj.setVisibility(8);
        }
        if (this.boM != null) {
            this.boM.setVisibility(8);
        }
        if (this.bTL != null && (this.bTL.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTL.getLayoutParams();
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds40);
            this.bTL.setLayoutParams(layoutParams);
        }
    }
}
