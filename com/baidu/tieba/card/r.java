package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends c {
    private View aWX;
    private TextView bKl;
    private ThreadLinkView bMg;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void aa(View view) {
        if (view != null) {
            this.bMg = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bMg.setTag(getTag());
            this.bKl = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
            this.aWX = view.findViewById(d.h.divider_line);
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.Nj() != null) {
            bh Nj = lVar.Nj();
            m.b(Nj, this.bKl);
            if ((StringUtils.isNull(Nj.getTitle()) && (Nj.rt() == null || Nj.rt().size() == 0)) || Nj.rK() == 1) {
                Nj.e(false, true);
                if (Nj.rV() == null || StringUtils.isNull(Nj.rV().toString())) {
                    this.bKl.setVisibility(8);
                } else {
                    this.bKl.setVisibility(0);
                    this.bKl.setText(Nj.rV());
                }
            } else {
                this.bKl.setVisibility(0);
            }
            this.bMg.setData(Nj);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bMg.onChangeSkinType();
        aj.k(this.aWX, d.e.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void Xw() {
        super.Xw();
        m.a(this.bKl, this.bJz.Nj().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bMg.em(this.bJz.Nj().getId());
    }
}
