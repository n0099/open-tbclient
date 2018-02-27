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
    private View bQn;
    private ThreadLinkView cXC;
    private TextView cXg;

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
            this.cXC = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cXC.setTag(getTag());
            this.cXg = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bQn = view.findViewById(d.g.divider_line);
            if (this.clX != null) {
                this.clX.setShareReportFrom(3);
                this.clX.setFrom(1);
            }
            if (this.cmL != null) {
                this.cmL.setShareReportFrom(3);
                this.cmL.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.WD() != null) {
            bd WD = kVar.WD();
            j.b(WD, this.cXg);
            if ((StringUtils.isNull(WD.getTitle()) && (WD.zl() == null || WD.zl().size() == 0)) || WD.zD() == 1) {
                WD.h(false, true);
                if (WD.zN() == null || StringUtils.isNull(WD.zN().toString())) {
                    this.cXg.setVisibility(8);
                } else {
                    this.cXg.setVisibility(0);
                    this.cXg.setText(WD.zN());
                }
            } else {
                this.cXg.setVisibility(0);
            }
            this.cXC.setData(WD);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cXC.onChangeSkinType();
        aj.t(this.bQn, d.C0141d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void akT() {
        super.akT();
        j.a(this.cXg, this.cVw.WD().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        this.cXC.eW(this.cVw.WD().getId());
    }
}
