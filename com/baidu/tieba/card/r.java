package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends c {
    private TextView bGg;
    private ThreadLinkView bIY;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void U(View view) {
        if (view != null) {
            this.bIY = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bIY.setTag(getTag());
            this.bGg = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.MF() != null) {
            bl MF = lVar.MF();
            m.b(MF, this.bGg);
            if ((StringUtils.isNull(MF.getTitle()) && (MF.rD() == null || MF.rD().size() == 0)) || MF.rU() == 1) {
                MF.e(false, true);
                if (MF.sf() == null || StringUtils.isNull(MF.sf().toString())) {
                    this.bGg.setVisibility(8);
                } else {
                    this.bGg.setVisibility(0);
                    this.bGg.setText(MF.sf());
                }
            } else {
                this.bGg.setVisibility(0);
            }
            this.bIY.setData(MF);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bIY.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void WF() {
        super.WF();
        m.a(this.bGg, this.bGA.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bIY.ev(this.bGA.MF().getId());
    }
}
