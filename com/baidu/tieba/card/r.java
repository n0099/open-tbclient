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
    private View aXj;
    private TextView bRS;
    private ThreadLinkView bTL;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ad(View view) {
        if (view != null) {
            this.bTL = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.bTL.setTag(getTag());
            this.bRS = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.aXj = view.findViewById(d.g.divider_line);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.NA() != null) {
            bh NA = lVar.NA();
            m.b(NA, this.bRS);
            if ((StringUtils.isNull(NA.getTitle()) && (NA.rr() == null || NA.rr().size() == 0)) || NA.rJ() == 1) {
                NA.e(false, true);
                if (NA.rU() == null || StringUtils.isNull(NA.rU().toString())) {
                    this.bRS.setVisibility(8);
                } else {
                    this.bRS.setVisibility(0);
                    this.bRS.setText(NA.rU());
                }
            } else {
                this.bRS.setVisibility(0);
            }
            this.bTL.setData(NA);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bTL.onChangeSkinType();
        aj.k(this.aXj, d.C0080d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void ZO() {
        super.ZO();
        m.a(this.bRS, this.bRg.NA().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        this.bTL.er(this.bRg.NA().getId());
    }
}
