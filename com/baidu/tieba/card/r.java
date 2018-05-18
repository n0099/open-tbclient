package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class r extends c {
    private View ban;
    private TextView cqC;
    private ThreadLinkView cqD;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ac(View view2) {
        if (view2 != null) {
            this.cqD = (ThreadLinkView) view2.findViewById(d.g.link_thread_root);
            this.cqD.setTag(getTag());
            this.cqC = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_title);
            this.ban = view2.findViewById(d.g.divider_line);
            if (this.bxb != null) {
                this.bxb.setShareReportFrom(3);
                this.bxb.setFrom(1);
            }
            if (this.bxQ != null) {
                this.bxQ.setShareReportFrom(3);
                this.bxQ.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.Pb() != null) {
            bd Pb = kVar.Pb();
            o.b(Pb, this.cqC);
            if ((StringUtils.isNull(Pb.getTitle()) && (Pb.rN() == null || Pb.rN().size() == 0)) || Pb.se() == 1) {
                Pb.e(false, true);
                if (Pb.sn() == null || StringUtils.isNull(Pb.sn().toString())) {
                    this.cqC.setVisibility(8);
                } else {
                    this.cqC.setVisibility(0);
                    this.cqC.setText(Pb.sn());
                }
            } else {
                this.cqC.setVisibility(0);
            }
            this.cqD.setData(Pb);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cqD.onChangeSkinType();
        ak.j(this.ban, d.C0126d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void afe() {
        super.afe();
        o.a(this.cqC, this.cnj.Pb().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        this.cqD.eO(this.cnj.Pb().getId());
    }
}
