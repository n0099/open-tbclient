package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class av extends as {
    private TextView bAg;
    private ThreadLinkView bCY;

    public av(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void U(View view) {
        if (view != null) {
            this.bCY = (ThreadLinkView) view.findViewById(w.h.link_thread_root);
            this.bCY.setTag(getTag());
            this.bAg = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void t(bm bmVar) {
        if (bmVar != null) {
            super.a(bmVar);
            if ((StringUtils.isNull(bmVar.getTitle()) && (bmVar.rp() == null || bmVar.rp().size() == 0)) || bmVar.rG() == 1) {
                bmVar.e(false, true);
                if (bmVar.rR() == null || StringUtils.isNull(bmVar.rR().toString())) {
                    this.bAg.setVisibility(8);
                } else {
                    this.bAg.setVisibility(0);
                    this.bAg.setText(bmVar.rR());
                }
            } else {
                this.bAg.setVisibility(0);
                bmVar.XB = 0;
                bmVar.e(false, bmVar.so());
                SpannableStringBuilder rR = bmVar.rR();
                this.bAg.setOnTouchListener(new com.baidu.tieba.view.aa(rR));
                this.bAg.setText(rR);
                com.baidu.tieba.card.at.a(this.bAg, bmVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            }
            this.bCY.setData(this.aiu);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bCY.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void Vx() {
        super.Vx();
        com.baidu.tieba.card.at.a(this.bAg, this.aiu.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        this.bCY.em(this.aiu.getId());
    }
}
