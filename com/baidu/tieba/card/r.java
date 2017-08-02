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
    private TextView bEn;
    private ThreadLinkView bHf;

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
            this.bHf = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bHf.setTag(getTag());
            this.bEn = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.MA() != null) {
            bl MA = lVar.MA();
            m.b(MA, this.bEn);
            if ((StringUtils.isNull(MA.getTitle()) && (MA.rt() == null || MA.rt().size() == 0)) || MA.rK() == 1) {
                MA.e(false, true);
                if (MA.rV() == null || StringUtils.isNull(MA.rV().toString())) {
                    this.bEn.setVisibility(8);
                } else {
                    this.bEn.setVisibility(0);
                    this.bEn.setText(MA.rV());
                }
            } else {
                this.bEn.setVisibility(0);
            }
            this.bHf.setData(MA);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bHf.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void We() {
        super.We();
        m.a(this.bEn, this.bEH.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bHf.ep(this.bEH.MA().getId());
    }
}
