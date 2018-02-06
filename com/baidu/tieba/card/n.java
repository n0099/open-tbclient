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
    private View bQA;
    private ThreadLinkView cXO;
    private TextView cXs;

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
            this.cXO = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cXO.setTag(getTag());
            this.cXs = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bQA = view.findViewById(d.g.divider_line);
            if (this.cmk != null) {
                this.cmk.setShareReportFrom(3);
                this.cmk.setFrom(1);
            }
            if (this.cmX != null) {
                this.cmX.setShareReportFrom(3);
                this.cmX.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.WE() != null) {
            bd WE = kVar.WE();
            j.b(WE, this.cXs);
            if ((StringUtils.isNull(WE.getTitle()) && (WE.zl() == null || WE.zl().size() == 0)) || WE.zD() == 1) {
                WE.h(false, true);
                if (WE.zN() == null || StringUtils.isNull(WE.zN().toString())) {
                    this.cXs.setVisibility(8);
                } else {
                    this.cXs.setVisibility(0);
                    this.cXs.setText(WE.zN());
                }
            } else {
                this.cXs.setVisibility(0);
            }
            this.cXO.setData(WE);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cXO.onChangeSkinType();
        aj.t(this.bQA, d.C0140d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void akU() {
        super.akU();
        j.a(this.cXs, this.cVI.WE().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        this.cXO.eW(this.cVI.WE().getId());
    }
}
