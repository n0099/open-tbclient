package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.m;
/* loaded from: classes2.dex */
public class k extends j {
    private TextView cOD;
    private ThreadLinkView cQg;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void bx(View view) {
        if (view != null) {
            this.cQg = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cQg.setTag(getTag());
            this.cOD = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(be beVar) {
        if (beVar != null) {
            super.a(beVar);
            if ((StringUtils.isNull(beVar.getTitle()) && (beVar.yV() == null || beVar.yV().size() == 0)) || beVar.zn() == 1) {
                beVar.h(false, true);
                if (beVar.zx() == null || StringUtils.isNull(beVar.zx().toString())) {
                    this.cOD.setVisibility(8);
                } else {
                    this.cOD.setVisibility(0);
                    this.cOD.setText(beVar.zx());
                }
            } else {
                this.cOD.setVisibility(0);
                beVar.aNr = 0;
                beVar.h(false, beVar.zV());
                SpannableStringBuilder zx = beVar.zx();
                this.cOD.setOnTouchListener(new m(zx));
                this.cOD.setText(zx);
                com.baidu.tieba.card.k.a(this.cOD, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            }
            this.cQg.setData(this.aXV);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cQg.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void ajd() {
        super.ajd();
        com.baidu.tieba.card.k.a(this.cOD, this.aXV.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        this.cQg.eD(this.aXV.getId());
    }
}
