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
    private View bvs;
    private TextView cOR;
    private ThreadLinkView cOS;

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
            this.cOS = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cOS.setTag(getTag());
            this.cOR = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.bvs = view.findViewById(e.g.divider_line);
            if (this.bWR != null) {
                this.bWR.setShareReportFrom(3);
                this.bWR.setFrom(1);
                this.bWR.setDisPraiseFrom(1);
            }
            if (this.bXE != null) {
                this.bXE.setShareReportFrom(3);
                this.bXE.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.YL() != null) {
            bb YL = kVar.YL();
            o.b(YL, this.cOR);
            if ((StringUtils.isNull(YL.getTitle()) && (YL.yA() == null || YL.yA().size() == 0)) || YL.yS() == 1) {
                YL.g(false, true);
                if (YL.zc() == null || StringUtils.isNull(YL.zc().toString())) {
                    this.cOR.setVisibility(8);
                } else {
                    this.cOR.setVisibility(0);
                    this.cOR.setText(YL.zc());
                }
            } else {
                this.cOR.setVisibility(0);
            }
            this.cOS.setData(YL);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cOS.onChangeSkinType();
        al.j(this.bvs, e.d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void anv() {
        super.anv();
        o.a(this.cOR, this.cLL.YL().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cOS.ga(this.cLL.YL().getId());
    }
}
