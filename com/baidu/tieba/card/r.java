package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends c {
    private View aWK;
    private TextView bJZ;
    private ThreadLinkView bLU;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void aa(View view) {
        if (view != null) {
            this.bLU = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bLU.setTag(getTag());
            this.bJZ = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
            this.aWK = view.findViewById(d.h.divider_line);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.Nd() != null) {
            bh Nd = lVar.Nd();
            m.b(Nd, this.bJZ);
            if ((StringUtils.isNull(Nd.getTitle()) && (Nd.rm() == null || Nd.rm().size() == 0)) || Nd.rD() == 1) {
                Nd.e(false, true);
                if (Nd.rO() == null || StringUtils.isNull(Nd.rO().toString())) {
                    this.bJZ.setVisibility(8);
                } else {
                    this.bJZ.setVisibility(0);
                    this.bJZ.setText(Nd.rO());
                }
            } else {
                this.bJZ.setVisibility(0);
            }
            this.bLU.setData(Nd);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bLU.onChangeSkinType();
        aj.k(this.aWK, d.e.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void Xs() {
        super.Xs();
        m.a(this.bJZ, this.bJn.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bLU.el(this.bJn.Nd().getId());
    }
}
