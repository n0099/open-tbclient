package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class r extends c {
    private View bqy;
    private TextView cFr;
    private ThreadLinkView cFs;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void av(View view) {
        if (view != null) {
            this.cFs = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cFs.setTag(getTag());
            this.cFr = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.bqy = view.findViewById(e.g.divider_line);
            if (this.bND != null) {
                this.bND.setShareReportFrom(3);
                this.bND.setFrom(1);
                this.bND.setDisPraiseFrom(1);
            }
            if (this.bOr != null) {
                this.bOr.setShareReportFrom(3);
                this.bOr.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.UT() != null) {
            bb UT = kVar.UT();
            o.b(UT, this.cFr);
            if ((StringUtils.isNull(UT.getTitle()) && (UT.wk() == null || UT.wk().size() == 0)) || UT.wC() == 1) {
                UT.g(false, true);
                if (UT.wM() == null || StringUtils.isNull(UT.wM().toString())) {
                    this.cFr.setVisibility(8);
                } else {
                    this.cFr.setVisibility(0);
                    this.cFr.setText(UT.wM());
                }
            } else {
                this.cFr.setVisibility(0);
            }
            this.cFs.setData(UT);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cFs.onChangeSkinType();
        al.j(this.bqy, e.d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void akr() {
        super.akr();
        o.a(this.cFr, this.cCk.UT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cFs.fL(this.cCk.UT().getId());
    }
}
