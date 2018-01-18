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
    private View bOk;
    private TextView cTe;
    private ThreadLinkView cUI;

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
            this.cUI = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cUI.setTag(getTag());
            this.cTe = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.bOk = view.findViewById(d.g.divider_line);
            if (this.ciL != null) {
                this.ciL.setShareReportFrom(3);
                this.ciL.setFrom(1);
            }
            if (this.cSr != null) {
                this.cSr.setShareReportFrom(3);
                this.cSr.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.VK() != null) {
            bd VK = lVar.VK();
            k.b(VK, this.cTe);
            if ((StringUtils.isNull(VK.getTitle()) && (VK.yQ() == null || VK.yQ().size() == 0)) || VK.zi() == 1) {
                VK.h(false, true);
                if (VK.zs() == null || StringUtils.isNull(VK.zs().toString())) {
                    this.cTe.setVisibility(8);
                } else {
                    this.cTe.setVisibility(0);
                    this.cTe.setText(VK.zs());
                }
            } else {
                this.cTe.setVisibility(0);
            }
            this.cUI.setData(VK);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cUI.onChangeSkinType();
        aj.t(this.bOk, d.C0107d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void akg() {
        super.akg();
        k.a(this.cTe, this.cSs.VK().getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        this.cUI.eD(this.cSs.VK().getId());
    }
}
