package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class r extends c {
    private View biz;
    private TextView czf;
    private ThreadLinkView czg;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ac(View view) {
        if (view != null) {
            this.czg = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.czg.setTag(getTag());
            this.czf = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.biz = view.findViewById(d.g.divider_line);
            if (this.bFe != null) {
                this.bFe.setShareReportFrom(3);
                this.bFe.setFrom(1);
            }
            if (this.bFT != null) {
                this.bFT.setShareReportFrom(3);
                this.bFT.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.Sz() != null) {
            bd Sz = kVar.Sz();
            o.b(Sz, this.czf);
            if ((StringUtils.isNull(Sz.getTitle()) && (Sz.vk() == null || Sz.vk().size() == 0)) || Sz.vB() == 1) {
                Sz.e(false, true);
                if (Sz.vK() == null || StringUtils.isNull(Sz.vK().toString())) {
                    this.czf.setVisibility(8);
                } else {
                    this.czf.setVisibility(0);
                    this.czf.setText(Sz.vK());
                }
            } else {
                this.czf.setVisibility(0);
            }
            this.czg.setData(Sz);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czg.onChangeSkinType();
        al.j(this.biz, d.C0141d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aiN() {
        super.aiN();
        o.a(this.czf, this.cvO.Sz().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        this.czg.fn(this.cvO.Sz().getId());
    }
}
