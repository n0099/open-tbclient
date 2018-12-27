package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class r extends c {
    private View byS;
    private TextView cYo;
    private ThreadLinkView cYp;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void aA(View view) {
        if (view != null) {
            this.cYp = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cYp.setTag(getTag());
            this.cYo = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.byS = view.findViewById(e.g.divider_line);
            if (this.caM != null) {
                this.caM.setShareReportFrom(3);
                this.caM.setFrom(1);
                this.caM.setDisPraiseFrom(1);
            }
            if (this.cbz != null) {
                this.cbz.setShareReportFrom(3);
                this.cbz.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.ZT() != null) {
            bb ZT = kVar.ZT();
            o.b(ZT, this.cYo);
            if ((StringUtils.isNull(ZT.getTitle()) && (ZT.zE() == null || ZT.zE().size() == 0)) || ZT.zW() == 1) {
                ZT.g(false, true);
                if (ZT.Ag() == null || StringUtils.isNull(ZT.Ag().toString())) {
                    this.cYo.setVisibility(8);
                } else {
                    this.cYo.setVisibility(0);
                    this.cYo.setText(ZT.Ag());
                }
            } else {
                this.cYo.setVisibility(0);
            }
            this.cYp.setData(ZT);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cYp.onChangeSkinType();
        al.j(this.byS, e.d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void apX() {
        super.apX();
        o.a(this.cYo, this.cVi.ZT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cYp.gu(this.cVi.ZT().getId());
    }

    public void kL(int i) {
        if (this.caM != null) {
            this.caM.aJD = String.valueOf(i);
        }
    }
}
