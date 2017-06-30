package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bt extends c {
    private TextView bAg;
    private ThreadLinkView bCY;

    public bt(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void U(View view) {
        if (view != null) {
            this.bCY = (ThreadLinkView) view.findViewById(w.h.link_thread_root);
            this.bCY.setTag(getTag());
            this.bAg = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.Mv() != null) {
            com.baidu.tbadk.core.data.bm Mv = lVar.Mv();
            at.a(Mv, this.bAg);
            if ((StringUtils.isNull(Mv.getTitle()) && (Mv.rp() == null || Mv.rp().size() == 0)) || Mv.rG() == 1) {
                Mv.e(false, true);
                if (Mv.rR() == null || StringUtils.isNull(Mv.rR().toString())) {
                    this.bAg.setVisibility(8);
                } else {
                    this.bAg.setVisibility(0);
                    this.bAg.setText(Mv.rR());
                }
            } else {
                this.bAg.setVisibility(0);
            }
            this.bCY.setData(Mv);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bCY.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void Vx() {
        super.Vx();
        at.a(this.bAg, this.bAA.Mv().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        this.bCY.em(this.bAA.Mv().getId());
    }
}
