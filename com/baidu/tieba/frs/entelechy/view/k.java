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
    private TextView bJZ;
    private ThreadLinkView bLU;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void aa(View view) {
        if (view != null) {
            this.bLU = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bLU.setTag(getTag());
            this.bJZ = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        if (bhVar != null) {
            super.a(bhVar);
            if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rm() == null || bhVar.rm().size() == 0)) || bhVar.rD() == 1) {
                bhVar.e(false, true);
                if (bhVar.rO() == null || StringUtils.isNull(bhVar.rO().toString())) {
                    this.bJZ.setVisibility(8);
                } else {
                    this.bJZ.setVisibility(0);
                    this.bJZ.setText(bhVar.rO());
                }
            } else {
                this.bJZ.setVisibility(0);
                bhVar.Yk = 0;
                bhVar.e(false, bhVar.sl());
                SpannableStringBuilder rO = bhVar.rO();
                this.bJZ.setOnTouchListener(new com.baidu.tieba.view.k(rO));
                this.bJZ.setText(rO);
                m.a(this.bJZ, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            this.bLU.setData(this.aiU);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bLU.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void Xs() {
        super.Xs();
        m.a(this.bJZ, this.aiU.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bLU.el(this.aiU.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void eV(boolean z) {
        super.eV(z);
        if (this.cxX != null) {
            this.cxX.setVisibility(0);
        }
        if (this.aWK != null) {
            this.aWK.setVisibility(8);
        }
        if (this.bmV != null) {
            this.bmV.setVisibility(8);
        }
        if (this.bLU != null && (this.bLU.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLU.getLayoutParams();
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds40);
            this.bLU.setLayoutParams(layoutParams);
        }
    }
}
