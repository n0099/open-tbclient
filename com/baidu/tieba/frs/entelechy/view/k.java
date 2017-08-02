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
    private TextView bEn;
    private ThreadLinkView bHf;

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
            this.bHf = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bHf.setTag(getTag());
            this.bEn = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        if (blVar != null) {
            super.a(blVar);
            if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rt() == null || blVar.rt().size() == 0)) || blVar.rK() == 1) {
                blVar.e(false, true);
                if (blVar.rV() == null || StringUtils.isNull(blVar.rV().toString())) {
                    this.bEn.setVisibility(8);
                } else {
                    this.bEn.setVisibility(0);
                    this.bEn.setText(blVar.rV());
                }
            } else {
                this.bEn.setVisibility(0);
                blVar.XS = 0;
                blVar.e(false, blVar.ss());
                SpannableStringBuilder rV = blVar.rV();
                this.bEn.setOnTouchListener(new com.baidu.tieba.view.l(rV));
                this.bEn.setText(rV);
                m.a(this.bEn, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            this.bHf.setData(this.aiQ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bHf.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void We() {
        super.We();
        m.a(this.bEn, this.aiQ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bHf.ep(this.aiQ.getId());
    }
}
