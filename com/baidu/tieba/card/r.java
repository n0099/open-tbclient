package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class r extends c {
    private View bjZ;
    private TextView cwZ;
    private ThreadLinkView cxa;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ae(View view) {
        if (view != null) {
            this.cxa = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cxa.setTag(getTag());
            this.cwZ = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bjZ = view.findViewById(d.g.divider_line);
            if (this.bGZ != null) {
                this.bGZ.setShareReportFrom(3);
                this.bGZ.setFrom(1);
            }
            if (this.bHN != null) {
                this.bHN.setShareReportFrom(3);
                this.bHN.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.SV() != null) {
            bc SV = kVar.SV();
            o.b(SV, this.cwZ);
            if ((StringUtils.isNull(SV.getTitle()) && (SV.vu() == null || SV.vu().size() == 0)) || SV.vL() == 1) {
                SV.e(false, true);
                if (SV.vU() == null || StringUtils.isNull(SV.vU().toString())) {
                    this.cwZ.setVisibility(8);
                } else {
                    this.cwZ.setVisibility(0);
                    this.cwZ.setText(SV.vU());
                }
            } else {
                this.cwZ.setVisibility(0);
            }
            this.cxa.setData(SV);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cxa.onChangeSkinType();
        am.j(this.bjZ, d.C0142d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aif() {
        super.aif();
        o.a(this.cwZ, this.ctU.SV().getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        this.cxa.fr(this.ctU.SV().getId());
    }
}
