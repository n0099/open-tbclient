package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends c {
    private TextView cqC;
    private ThreadLinkView cqD;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void ac(View view2) {
        if (view2 != null) {
            this.cqD = (ThreadLinkView) view2.findViewById(d.g.link_thread_root);
            this.cqD.setTag(getTag());
            this.cqC = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar != null) {
            super.a(bdVar);
            if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rN() == null || bdVar.rN().size() == 0)) || bdVar.se() == 1) {
                bdVar.e(false, true);
                if (bdVar.sn() == null || StringUtils.isNull(bdVar.sn().toString())) {
                    this.cqC.setVisibility(8);
                } else {
                    this.cqC.setVisibility(0);
                    this.cqC.setText(bdVar.sn());
                }
            } else {
                this.cqC.setVisibility(0);
                bdVar.ZV = 0;
                bdVar.e(false, bdVar.sI());
                SpannableStringBuilder sn = bdVar.sn();
                this.cqC.setOnTouchListener(new com.baidu.tieba.view.j(sn));
                this.cqC.setText(sn);
                o.a(this.cqC, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            }
            this.cqD.setData(this.alf);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cqD.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void afe() {
        super.afe();
        o.a(this.cqC, this.alf.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        this.cqD.eO(this.alf.getId());
    }
}
