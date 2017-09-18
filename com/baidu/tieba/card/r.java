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
    private TextView bJS;
    private ThreadLinkView bMJ;

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
            this.bMJ = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bMJ.setTag(getTag());
            this.bJS = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.MR() != null) {
            bj MR = lVar.MR();
            m.b(MR, this.bJS);
            if ((StringUtils.isNull(MR.getTitle()) && (MR.rz() == null || MR.rz().size() == 0)) || MR.rQ() == 1) {
                MR.e(false, true);
                if (MR.sb() == null || StringUtils.isNull(MR.sb().toString())) {
                    this.bJS.setVisibility(8);
                } else {
                    this.bJS.setVisibility(0);
                    this.bJS.setText(MR.sb());
                }
            } else {
                this.bJS.setVisibility(0);
            }
            this.bMJ.setData(MR);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bMJ.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void XQ() {
        super.XQ();
        m.a(this.bJS, this.bKm.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bMJ.es(this.bKm.MR().getId());
    }
}
