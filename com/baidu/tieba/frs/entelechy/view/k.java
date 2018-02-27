package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class k extends j {
    private ThreadLinkView cXC;
    private TextView cXg;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void by(View view) {
        if (view != null) {
            this.cXC = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cXC.setTag(getTag());
            this.cXg = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        if (bdVar != null) {
            super.a(bdVar);
            if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.zl() == null || bdVar.zl().size() == 0)) || bdVar.zD() == 1) {
                bdVar.h(false, true);
                if (bdVar.zN() == null || StringUtils.isNull(bdVar.zN().toString())) {
                    this.cXg.setVisibility(8);
                } else {
                    this.cXg.setVisibility(0);
                    this.cXg.setText(bdVar.zN());
                }
            } else {
                this.cXg.setVisibility(0);
                bdVar.aOy = 0;
                bdVar.h(false, bdVar.Ah());
                SpannableStringBuilder zN = bdVar.zN();
                this.cXg.setOnTouchListener(new com.baidu.tieba.view.m(zN));
                this.cXg.setText(zN);
                com.baidu.tieba.card.j.a(this.cXg, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            }
            this.cXC.setData(this.aZA);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cXC.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void akT() {
        super.akT();
        com.baidu.tieba.card.j.a(this.cXg, this.aZA.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        this.cXC.eW(this.aZA.getId());
    }
}
