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
    private View byP;
    private TextView cVy;
    private ThreadLinkView cVz;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ax(View view) {
        if (view != null) {
            this.cVz = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cVz.setTag(getTag());
            this.cVy = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.byP = view.findViewById(e.g.divider_line);
            if (this.caJ != null) {
                this.caJ.setShareReportFrom(3);
                this.caJ.setFrom(1);
                this.caJ.setDisPraiseFrom(1);
            }
            if (this.cbw != null) {
                this.cbw.setShareReportFrom(3);
                this.cbw.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.ZR() != null) {
            bb ZR = kVar.ZR();
            o.b(ZR, this.cVy);
            if ((StringUtils.isNull(ZR.getTitle()) && (ZR.zE() == null || ZR.zE().size() == 0)) || ZR.zW() == 1) {
                ZR.g(false, true);
                if (ZR.Ag() == null || StringUtils.isNull(ZR.Ag().toString())) {
                    this.cVy.setVisibility(8);
                } else {
                    this.cVy.setVisibility(0);
                    this.cVy.setText(ZR.Ag());
                }
            } else {
                this.cVy.setVisibility(0);
            }
            this.cVz.setData(ZR);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cVz.onChangeSkinType();
        al.j(this.byP, e.d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aph() {
        super.aph();
        o.a(this.cVy, this.cSs.ZR().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cVz.gt(this.cSs.ZR().getId());
    }
}
