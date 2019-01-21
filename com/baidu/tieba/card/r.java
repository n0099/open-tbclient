package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class r extends c {
    private View bzH;
    private TextView cZa;
    private ThreadLinkView cZb;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void aA(View view) {
        if (view != null) {
            this.cZb = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cZb.setTag(getTag());
            this.cZa = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.bzH = view.findViewById(e.g.divider_line);
            if (this.cby != null) {
                this.cby.setShareReportFrom(3);
                this.cby.setFrom(1);
                this.cby.setDisPraiseFrom(1);
            }
            if (this.ccl != null) {
                this.ccl.setShareReportFrom(3);
                this.ccl.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.aaq() != null) {
            bb aaq = kVar.aaq();
            o.b(aaq, this.cZa);
            if ((StringUtils.isNull(aaq.getTitle()) && (aaq.zR() == null || aaq.zR().size() == 0)) || aaq.Aj() == 1) {
                aaq.g(false, true);
                if (aaq.At() == null || StringUtils.isNull(aaq.At().toString())) {
                    this.cZa.setVisibility(8);
                } else {
                    this.cZa.setVisibility(0);
                    this.cZa.setText(aaq.At());
                }
            } else {
                this.cZa.setVisibility(0);
            }
            this.cZb.setData(aaq);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cZb.onChangeSkinType();
        al.j(this.bzH, e.d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aqu() {
        super.aqu();
        o.a(this.cZa, this.cVU.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cZb.gH(this.cVU.aaq().getId());
    }

    public void kL(int i) {
        if (this.cby != null) {
            this.cby.aKg = String.valueOf(i);
        }
    }
}
