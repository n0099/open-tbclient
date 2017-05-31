package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class av extends as {
    private ThreadLinkView bCf;
    private TextView bzn;

    public av(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void T(View view) {
        if (view != null) {
            this.bCf = (ThreadLinkView) view.findViewById(w.h.link_thread_root);
            this.bCf.setTag(getTag());
            this.bzn = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void r(bl blVar) {
        if (blVar != null) {
            super.a(blVar);
            if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rt() == null || blVar.rt().size() == 0)) || blVar.rJ() == 1) {
                this.bzn.setVisibility(8);
            } else {
                this.bzn.setVisibility(0);
                blVar.XB = 0;
                blVar.e(false, blVar.sr());
                SpannableStringBuilder rU = blVar.rU();
                this.bzn.setOnTouchListener(new com.baidu.tieba.view.aa(rU));
                this.bzn.setText(rU);
                com.baidu.tieba.card.at.a(this.bzn, blVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            }
            this.bCf.setData(this.ahM);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bCf.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void Ui() {
        super.Ui();
        com.baidu.tieba.card.at.a(this.bzn, this.ahM.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        this.bCf.dS(this.ahM.getId());
    }
}
