package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends c {
    private TextView bJb;
    private ThreadLinkView bLS;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ab(View view) {
        if (view != null) {
            this.bLS = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bLS.setTag(getTag());
            this.bJb = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.MR() != null) {
            bj MR = lVar.MR();
            m.b(MR, this.bJb);
            if ((StringUtils.isNull(MR.getTitle()) && (MR.rz() == null || MR.rz().size() == 0)) || MR.rQ() == 1) {
                MR.e(false, true);
                if (MR.sb() == null || StringUtils.isNull(MR.sb().toString())) {
                    this.bJb.setVisibility(8);
                } else {
                    this.bJb.setVisibility(0);
                    this.bJb.setText(MR.sb());
                }
            } else {
                this.bJb.setVisibility(0);
            }
            this.bLS.setData(MR);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bLS.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void XF() {
        super.XF();
        m.a(this.bJb, this.bJv.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bLS.es(this.bJv.MR().getId());
    }
}
