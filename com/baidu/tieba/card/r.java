package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class r extends c {
    private View bkE;
    private TextView czC;
    private ThreadLinkView czD;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ah(View view) {
        if (view != null) {
            this.czD = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.czD.setTag(getTag());
            this.czC = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bkE = view.findViewById(d.g.divider_line);
            if (this.bHO != null) {
                this.bHO.setShareReportFrom(3);
                this.bHO.setFrom(1);
            }
            if (this.bIC != null) {
                this.bIC.setShareReportFrom(3);
                this.bIC.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.Td() != null) {
            bb Td = kVar.Td();
            o.b(Td, this.czC);
            if ((StringUtils.isNull(Td.getTitle()) && (Td.vi() == null || Td.vi().size() == 0)) || Td.vA() == 1) {
                Td.e(false, true);
                if (Td.vJ() == null || StringUtils.isNull(Td.vJ().toString())) {
                    this.czC.setVisibility(8);
                } else {
                    this.czC.setVisibility(0);
                    this.czC.setText(Td.vJ());
                }
            } else {
                this.czC.setVisibility(0);
            }
            this.czD.setData(Td);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czD.onChangeSkinType();
        am.j(this.bkE, d.C0140d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aiE() {
        super.aiE();
        o.a(this.czC, this.cwx.Td().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        this.czD.fq(this.cwx.Td().getId());
    }
}
