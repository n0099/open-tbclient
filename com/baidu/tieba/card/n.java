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
public class n extends c {
    private View bQq;
    private ThreadLinkView cXF;
    private TextView cXj;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void by(View view) {
        if (view != null) {
            this.cXF = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cXF.setTag(getTag());
            this.cXj = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bQq = view.findViewById(d.g.divider_line);
            if (this.cma != null) {
                this.cma.setShareReportFrom(3);
                this.cma.setFrom(1);
            }
            if (this.cmO != null) {
                this.cmO.setShareReportFrom(3);
                this.cmO.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.WE() != null) {
            bd WE = kVar.WE();
            j.b(WE, this.cXj);
            if ((StringUtils.isNull(WE.getTitle()) && (WE.zl() == null || WE.zl().size() == 0)) || WE.zD() == 1) {
                WE.h(false, true);
                if (WE.zN() == null || StringUtils.isNull(WE.zN().toString())) {
                    this.cXj.setVisibility(8);
                } else {
                    this.cXj.setVisibility(0);
                    this.cXj.setText(WE.zN());
                }
            } else {
                this.cXj.setVisibility(0);
            }
            this.cXF.setData(WE);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cXF.onChangeSkinType();
        aj.t(this.bQq, d.C0141d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void akU() {
        super.akU();
        j.a(this.cXj, this.cVz.WE().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        this.cXF.eW(this.cVz.WE().getId());
    }
}
