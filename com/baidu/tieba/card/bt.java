package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bt extends c {
    private ThreadLinkView bCf;
    private TextView bzn;

    public bt(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void T(View view) {
        if (view != null) {
            this.bCf = (ThreadLinkView) view.findViewById(w.h.link_thread_root);
            this.bCf.setTag(getTag());
            this.bzn = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.LH() != null) {
            com.baidu.tbadk.core.data.bl LH = lVar.LH();
            at.a(LH, this.bzn);
            if ((StringUtils.isNull(LH.getTitle()) && (LH.rt() == null || LH.rt().size() == 0)) || LH.rJ() == 1) {
                this.bzn.setVisibility(8);
            } else {
                this.bzn.setVisibility(0);
            }
            this.bCf.setData(LH);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bCf.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void Ui() {
        super.Ui();
        at.a(this.bzn, this.bzH.LH().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        this.bCf.dS(this.bzH.LH().getId());
    }
}
