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
    private View bzG;
    private TextView cYZ;
    private ThreadLinkView cZa;

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
            this.cZa = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cZa.setTag(getTag());
            this.cYZ = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.bzG = view.findViewById(e.g.divider_line);
            if (this.cbx != null) {
                this.cbx.setShareReportFrom(3);
                this.cbx.setFrom(1);
                this.cbx.setDisPraiseFrom(1);
            }
            if (this.cck != null) {
                this.cck.setShareReportFrom(3);
                this.cck.setFrom(1);
            }
        }
    }

    @Override // com.baidu.tieba.card.c
    protected void b(com.baidu.tieba.card.data.k kVar) {
        if (kVar != null && kVar.aaq() != null) {
            bb aaq = kVar.aaq();
            o.b(aaq, this.cYZ);
            if ((StringUtils.isNull(aaq.getTitle()) && (aaq.zR() == null || aaq.zR().size() == 0)) || aaq.Aj() == 1) {
                aaq.g(false, true);
                if (aaq.At() == null || StringUtils.isNull(aaq.At().toString())) {
                    this.cYZ.setVisibility(8);
                } else {
                    this.cYZ.setVisibility(0);
                    this.cYZ.setText(aaq.At());
                }
            } else {
                this.cYZ.setVisibility(0);
            }
            this.cZa.setData(aaq);
        }
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cZa.onChangeSkinType();
        al.j(this.bzG, e.d.cp_bg_line_e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.card.c
    public void aqu() {
        super.aqu();
        o.a(this.cYZ, this.cVT.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cZa.gH(this.cVT.aaq().getId());
    }

    public void kL(int i) {
        if (this.cbx != null) {
            this.cbx.aKf = String.valueOf(i);
        }
    }
}
