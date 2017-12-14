package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends c {
    private TextView bZU;
    private View ban;
    private ThreadLinkView cbw;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void af(View view) {
        if (view != null) {
            this.cbw = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cbw.setTag(getTag());
            this.bZU = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.ban = view.findViewById(d.g.divider_line);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.Ox() != null) {
            bd Ox = lVar.Ox();
            k.b(Ox, this.bZU);
            if ((StringUtils.isNull(Ox.getTitle()) && (Ox.rt() == null || Ox.rt().size() == 0)) || Ox.rL() == 1) {
                Ox.e(false, true);
                if (Ox.rV() == null || StringUtils.isNull(Ox.rV().toString())) {
                    this.bZU.setVisibility(8);
                } else {
                    this.bZU.setVisibility(0);
                    this.bZU.setText(Ox.rV());
                }
            } else {
                this.bZU.setVisibility(0);
            }
            this.cbw.setData(Ox);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cbw.onChangeSkinType();
        aj.k(this.ban, d.C0096d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aby() {
        super.aby();
        k.a(this.bZU, this.bZi.Ox().getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        this.cbw.ew(this.bZi.Ox().getId());
    }
}
