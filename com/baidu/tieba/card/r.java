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
    private View aXa;
    private TextView bRF;
    private ThreadLinkView bTy;

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
            this.bTy = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.bTy.setTag(getTag());
            this.bRF = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.aXa = view.findViewById(d.g.divider_line);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.Np() != null) {
            bh Np = lVar.Np();
            m.b(Np, this.bRF);
            if ((StringUtils.isNull(Np.getTitle()) && (Np.rr() == null || Np.rr().size() == 0)) || Np.rJ() == 1) {
                Np.e(false, true);
                if (Np.rU() == null || StringUtils.isNull(Np.rU().toString())) {
                    this.bRF.setVisibility(8);
                } else {
                    this.bRF.setVisibility(0);
                    this.bRF.setText(Np.rU());
                }
            } else {
                this.bRF.setVisibility(0);
            }
            this.bTy.setData(Np);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bTy.onChangeSkinType();
        aj.k(this.aXa, d.C0080d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void ZC() {
        super.ZC();
        m.a(this.bRF, this.bQT.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        this.bTy.er(this.bQT.Np().getId());
    }
}
