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
    private TextView cpw;
    private ThreadLinkView cpx;

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
            this.cpx = (ThreadLinkView) view2.findViewById(d.g.link_thread_root);
            this.cpx.setTag(getTag());
            this.cpw = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar != null) {
            super.a(bdVar);
            if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rO() == null || bdVar.rO().size() == 0)) || bdVar.sf() == 1) {
                bdVar.e(false, true);
                if (bdVar.so() == null || StringUtils.isNull(bdVar.so().toString())) {
                    this.cpw.setVisibility(8);
                } else {
                    this.cpw.setVisibility(0);
                    this.cpw.setText(bdVar.so());
                }
            } else {
                this.cpw.setVisibility(0);
                bdVar.ZV = 0;
                bdVar.e(false, bdVar.sJ());
                SpannableStringBuilder so = bdVar.so();
                this.cpw.setOnTouchListener(new com.baidu.tieba.view.j(so));
                this.cpw.setText(so);
                o.a(this.cpw, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            }
            this.cpx.setData(this.alf);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cpx.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void afe() {
        super.afe();
        o.a(this.cpw, this.alf.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        this.cpx.eO(this.alf.getId());
    }
}
