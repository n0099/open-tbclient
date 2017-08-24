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
    private TextView bGh;
    private ThreadLinkView bIZ;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void T(View view) {
        if (view != null) {
            this.bIZ = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bIZ.setTag(getTag());
            this.bGh = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.MF() != null) {
            bl MF = lVar.MF();
            m.b(MF, this.bGh);
            if ((StringUtils.isNull(MF.getTitle()) && (MF.rE() == null || MF.rE().size() == 0)) || MF.rV() == 1) {
                MF.e(false, true);
                if (MF.sg() == null || StringUtils.isNull(MF.sg().toString())) {
                    this.bGh.setVisibility(8);
                } else {
                    this.bGh.setVisibility(0);
                    this.bGh.setText(MF.sg());
                }
            } else {
                this.bGh.setVisibility(0);
            }
            this.bIZ.setData(MF);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bIZ.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void WC() {
        super.WC();
        m.a(this.bGh, this.bGB.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bIZ.ez(this.bGB.MF().getId());
    }
}
