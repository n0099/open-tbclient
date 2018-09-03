package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class r extends c {
    private View bkJ;
    private ThreadLinkView czA;
    private TextView czz;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.card.c
    protected void ah(View view) {
        if (view != null) {
            this.czA = (ThreadLinkView) view.findViewById(f.g.link_thread_root);
            this.czA.setTag(getTag());
            this.czz = (TextView) view.findViewById(f.g.card_home_page_normal_thread_title);
            this.bkJ = view.findViewById(f.g.divider_line);
            if (this.bHO != null) {
                this.bHO.setShareReportFrom(3);
                this.bHO.setFrom(1);
            }
            if (this.bIC != null) {
                this.bIC.setShareReportFrom(3);
                this.bIC.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.Tg() != null) {
            bb Tg = kVar.Tg();
            o.b(Tg, this.czz);
            if ((StringUtils.isNull(Tg.getTitle()) && (Tg.vh() == null || Tg.vh().size() == 0)) || Tg.vz() == 1) {
                Tg.e(false, true);
                if (Tg.vI() == null || StringUtils.isNull(Tg.vI().toString())) {
                    this.czz.setVisibility(8);
                } else {
                    this.czz.setVisibility(0);
                    this.czz.setText(Tg.vI());
                }
            } else {
                this.czz.setVisibility(0);
            }
            this.czA.setData(Tg);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czA.onChangeSkinType();
        am.j(this.bkJ, f.d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aiH() {
        super.aiH();
        o.a(this.czz, this.cwu.Tg().getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        this.czA.fq(this.cwu.Tg().getId());
    }
}
