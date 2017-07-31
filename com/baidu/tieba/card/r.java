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
    private TextView bFx;
    private ThreadLinkView bIp;

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
            this.bIp = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bIp.setTag(getTag());
            this.bFx = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.MF() != null) {
            bl MF = lVar.MF();
            m.b(MF, this.bFx);
            if ((StringUtils.isNull(MF.getTitle()) && (MF.rD() == null || MF.rD().size() == 0)) || MF.rU() == 1) {
                MF.e(false, true);
                if (MF.sf() == null || StringUtils.isNull(MF.sf().toString())) {
                    this.bFx.setVisibility(8);
                } else {
                    this.bFx.setVisibility(0);
                    this.bFx.setText(MF.sf());
                }
            } else {
                this.bFx.setVisibility(0);
            }
            this.bIp.setData(MF);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bIp.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void Wj() {
        super.Wj();
        m.a(this.bFx, this.bFR.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bIp.ev(this.bFR.MF().getId());
    }
}
