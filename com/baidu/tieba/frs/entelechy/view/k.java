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
    private TextView bRF;
    private ThreadLinkView bTy;

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
            this.bTy = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.bTy.setTag(getTag());
            this.bRF = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
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
                    this.bRF.setVisibility(8);
                } else {
                    this.bRF.setVisibility(0);
                    this.bRF.setText(bhVar.rU());
                }
            } else {
                this.bRF.setVisibility(0);
                bhVar.YC = 0;
                bhVar.e(false, bhVar.ss());
                SpannableStringBuilder rU = bhVar.rU();
                this.bRF.setOnTouchListener(new com.baidu.tieba.view.l(rU));
                this.bRF.setText(rU);
                m.a(this.bRF, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            }
            this.bTy.setData(this.ajq);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bTy.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void ZC() {
        super.ZC();
        m.a(this.bRF, this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        this.bTy.er(this.ajq.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void eQ(boolean z) {
        super.eQ(z);
        if (this.cFQ != null) {
            this.cFQ.setVisibility(0);
        }
        if (this.aXa != null) {
            this.aXa.setVisibility(8);
        }
        if (this.boD != null) {
            this.boD.setVisibility(8);
        }
        if (this.bTy != null && (this.bTy.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTy.getLayoutParams();
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds40);
            this.bTy.setLayoutParams(layoutParams);
        }
    }
}
