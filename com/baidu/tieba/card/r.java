package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class r extends c {
    private View bam;
    private TextView cpw;
    private ThreadLinkView cpx;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ac(View view2) {
        if (view2 != null) {
            this.cpx = (ThreadLinkView) view2.findViewById(d.g.link_thread_root);
            this.cpx.setTag(getTag());
            this.cpw = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_title);
            this.bam = view2.findViewById(d.g.divider_line);
            if (this.bwk != null) {
                this.bwk.setShareReportFrom(3);
                this.bwk.setFrom(1);
            }
            if (this.bwZ != null) {
                this.bwZ.setShareReportFrom(3);
                this.bwZ.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.Pe() != null) {
            bd Pe = kVar.Pe();
            o.b(Pe, this.cpw);
            if ((StringUtils.isNull(Pe.getTitle()) && (Pe.rO() == null || Pe.rO().size() == 0)) || Pe.sf() == 1) {
                Pe.e(false, true);
                if (Pe.so() == null || StringUtils.isNull(Pe.so().toString())) {
                    this.cpw.setVisibility(8);
                } else {
                    this.cpw.setVisibility(0);
                    this.cpw.setText(Pe.so());
                }
            } else {
                this.cpw.setVisibility(0);
            }
            this.cpx.setData(Pe);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cpx.onChangeSkinType();
        ak.j(this.bam, d.C0126d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void afe() {
        super.afe();
        o.a(this.cpw, this.cmc.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        this.cpx.eO(this.cmc.Pe().getId());
    }
}
