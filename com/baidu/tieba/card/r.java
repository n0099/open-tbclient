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
    private View buH;
    private TextView cNL;
    private ThreadLinkView cNM;

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
            this.cNM = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cNM.setTag(getTag());
            this.cNL = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.buH = view.findViewById(e.g.divider_line);
            if (this.bWf != null) {
                this.bWf.setShareReportFrom(3);
                this.bWf.setFrom(1);
                this.bWf.setDisPraiseFrom(1);
            }
            if (this.bWS != null) {
                this.bWS.setShareReportFrom(3);
                this.bWS.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.YA() != null) {
            bb YA = kVar.YA();
            o.b(YA, this.cNL);
            if ((StringUtils.isNull(YA.getTitle()) && (YA.yt() == null || YA.yt().size() == 0)) || YA.yL() == 1) {
                YA.g(false, true);
                if (YA.yV() == null || StringUtils.isNull(YA.yV().toString())) {
                    this.cNL.setVisibility(8);
                } else {
                    this.cNL.setVisibility(0);
                    this.cNL.setText(YA.yV());
                }
            } else {
                this.cNL.setVisibility(0);
            }
            this.cNM.setData(YA);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cNM.onChangeSkinType();
        al.j(this.buH, e.d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void anT() {
        super.anT();
        o.a(this.cNL, this.cKF.YA().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cNM.fZ(this.cKF.YA().getId());
    }
}
