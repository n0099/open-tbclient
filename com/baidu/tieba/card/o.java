package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends c {
    private View bOc;
    private TextView cOD;
    private ThreadLinkView cQg;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void bx(View view) {
        if (view != null) {
            this.cQg = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cQg.setTag(getTag());
            this.cOD = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bOc = view.findViewById(d.g.divider_line);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.VW() != null) {
            be VW = lVar.VW();
            k.b(VW, this.cOD);
            if ((StringUtils.isNull(VW.getTitle()) && (VW.yV() == null || VW.yV().size() == 0)) || VW.zn() == 1) {
                VW.h(false, true);
                if (VW.zx() == null || StringUtils.isNull(VW.zx().toString())) {
                    this.cOD.setVisibility(8);
                } else {
                    this.cOD.setVisibility(0);
                    this.cOD.setText(VW.zx());
                }
            } else {
                this.cOD.setVisibility(0);
            }
            this.cQg.setData(VW);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cQg.onChangeSkinType();
        aj.t(this.bOc, d.C0108d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void ajd() {
        super.ajd();
        k.a(this.cOD, this.cNR.VW().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        this.cQg.eD(this.cNR.VW().getId());
    }
}
