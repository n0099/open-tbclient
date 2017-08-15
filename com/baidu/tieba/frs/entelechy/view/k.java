package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k extends j {
    private TextView bGg;
    private ThreadLinkView bIY;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void U(View view) {
        if (view != null) {
            this.bIY = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bIY.setTag(getTag());
            this.bGg = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        if (blVar != null) {
            super.a(blVar);
            if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rD() == null || blVar.rD().size() == 0)) || blVar.rU() == 1) {
                blVar.e(false, true);
                if (blVar.sf() == null || StringUtils.isNull(blVar.sf().toString())) {
                    this.bGg.setVisibility(8);
                } else {
                    this.bGg.setVisibility(0);
                    this.bGg.setText(blVar.sf());
                }
            } else {
                this.bGg.setVisibility(0);
                blVar.Zq = 0;
                blVar.e(false, blVar.sC());
                SpannableStringBuilder sf = blVar.sf();
                this.bGg.setOnTouchListener(new com.baidu.tieba.view.l(sf));
                this.bGg.setText(sf);
                m.a(this.bGg, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            this.bIY.setData(this.akl);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bIY.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void WF() {
        super.WF();
        m.a(this.bGg, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bIY.ev(this.akl.getId());
    }
}
