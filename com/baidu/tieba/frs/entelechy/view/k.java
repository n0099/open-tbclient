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
    private ThreadLinkView cXO;
    private TextView cXs;

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
            this.cXO = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cXO.setTag(getTag());
            this.cXs = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
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
                    this.cXs.setVisibility(8);
                } else {
                    this.cXs.setVisibility(0);
                    this.cXs.setText(bdVar.zN());
                }
            } else {
                this.cXs.setVisibility(0);
                bdVar.aOJ = 0;
                bdVar.h(false, bdVar.Ah());
                SpannableStringBuilder zN = bdVar.zN();
                this.cXs.setOnTouchListener(new com.baidu.tieba.view.m(zN));
                this.cXs.setText(zN);
                com.baidu.tieba.card.j.a(this.cXs, bdVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            }
            this.cXO.setData(this.aZM);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cXO.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void akU() {
        super.akU();
        com.baidu.tieba.card.j.a(this.cXs, this.aZM.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        this.cXO.eW(this.aZM.getId());
    }
}
