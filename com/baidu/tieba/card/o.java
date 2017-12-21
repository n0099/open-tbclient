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
    private TextView bZY;
    private View bas;
    private ThreadLinkView cbA;

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
            this.cbA = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cbA.setTag(getTag());
            this.bZY = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bas = view.findViewById(d.g.divider_line);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.Ox() != null) {
            bd Ox = lVar.Ox();
            k.b(Ox, this.bZY);
            if ((StringUtils.isNull(Ox.getTitle()) && (Ox.rt() == null || Ox.rt().size() == 0)) || Ox.rL() == 1) {
                Ox.e(false, true);
                if (Ox.rV() == null || StringUtils.isNull(Ox.rV().toString())) {
                    this.bZY.setVisibility(8);
                } else {
                    this.bZY.setVisibility(0);
                    this.bZY.setText(Ox.rV());
                }
            } else {
                this.bZY.setVisibility(0);
            }
            this.cbA.setData(Ox);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cbA.onChangeSkinType();
        aj.k(this.bas, d.C0095d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aby() {
        super.aby();
        k.a(this.bZY, this.bZm.Ox().getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        this.cbA.ew(this.bZm.Ox().getId());
    }
}
