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
import com.baidu.tieba.view.m;
/* loaded from: classes2.dex */
public class k extends j {
    private TextView cTe;
    private ThreadLinkView cUI;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void bz(View view) {
        if (view != null) {
            this.cUI = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cUI.setTag(getTag());
            this.cTe = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        if (bdVar != null) {
            super.a(bdVar);
            if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.yQ() == null || bdVar.yQ().size() == 0)) || bdVar.zi() == 1) {
                bdVar.h(false, true);
                if (bdVar.zs() == null || StringUtils.isNull(bdVar.zs().toString())) {
                    this.cTe.setVisibility(8);
                } else {
                    this.cTe.setVisibility(0);
                    this.cTe.setText(bdVar.zs());
                }
            } else {
                this.cTe.setVisibility(0);
                bdVar.aNn = 0;
                bdVar.h(false, bdVar.zN());
                SpannableStringBuilder zs = bdVar.zs();
                this.cTe.setOnTouchListener(new m(zs));
                this.cTe.setText(zs);
                com.baidu.tieba.card.k.a(this.cTe, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            }
            this.cUI.setData(this.aXU);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cUI.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void akg() {
        super.akg();
        com.baidu.tieba.card.k.a(this.cTe, this.aXU.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        this.cUI.eD(this.aXU.getId());
    }
}
