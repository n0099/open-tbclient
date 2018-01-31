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
    private View bOs;
    private TextView cTz;
    private ThreadLinkView cVd;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void bz(View view) {
        if (view != null) {
            this.cVd = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cVd.setTag(getTag());
            this.cTz = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bOs = view.findViewById(d.g.divider_line);
            if (this.ciT != null) {
                this.ciT.setShareReportFrom(3);
                this.ciT.setFrom(1);
            }
            if (this.cSM != null) {
                this.cSM.setShareReportFrom(3);
                this.cSM.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.VM() != null) {
            bd VM = lVar.VM();
            k.b(VM, this.cTz);
            if ((StringUtils.isNull(VM.getTitle()) && (VM.yR() == null || VM.yR().size() == 0)) || VM.zj() == 1) {
                VM.h(false, true);
                if (VM.zt() == null || StringUtils.isNull(VM.zt().toString())) {
                    this.cTz.setVisibility(8);
                } else {
                    this.cTz.setVisibility(0);
                    this.cTz.setText(VM.zt());
                }
            } else {
                this.cTz.setVisibility(0);
            }
            this.cVd.setData(VM);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cVd.onChangeSkinType();
        aj.t(this.bOs, d.C0108d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void akl() {
        super.akl();
        k.a(this.cTz, this.cSN.VM().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        this.cVd.eK(this.cSN.VM().getId());
    }
}
