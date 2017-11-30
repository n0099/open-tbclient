package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends c {
    private TextView bZQ;
    private View bam;
    private ThreadLinkView cbs;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ae(View view) {
        if (view != null) {
            this.cbs = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cbs.setTag(getTag());
            this.bZQ = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bam = view.findViewById(d.g.divider_line);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.Ox() != null) {
            bd Ox = lVar.Ox();
            k.b(Ox, this.bZQ);
            if ((StringUtils.isNull(Ox.getTitle()) && (Ox.rv() == null || Ox.rv().size() == 0)) || Ox.rN() == 1) {
                Ox.e(false, true);
                if (Ox.rX() == null || StringUtils.isNull(Ox.rX().toString())) {
                    this.bZQ.setVisibility(8);
                } else {
                    this.bZQ.setVisibility(0);
                    this.bZQ.setText(Ox.rX());
                }
            } else {
                this.bZQ.setVisibility(0);
            }
            this.cbs.setData(Ox);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cbs.onChangeSkinType();
        aj.k(this.bam, d.C0082d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void abx() {
        super.abx();
        k.a(this.bZQ, this.bZe.Ox().getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        this.cbs.ew(this.bZe.Ox().getId());
    }
}
