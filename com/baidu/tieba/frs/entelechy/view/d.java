package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class d extends c {
    private View axY;
    private TextView cwZ;
    private ThreadLinkView cxa;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void ae(View view) {
        if (view != null) {
            this.cxa = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cxa.setTag(getTag());
            this.cwZ = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.axY = view.findViewById(d.g.thread_multi_del_mask_view);
            this.bGZ.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void aW(boolean z) {
                    am.j(d.this.axY, z ? d.C0142d.cp_bg_line_d : d.C0142d.transparent);
                }
            });
            this.axY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.bGZ.changeSelectStatus();
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    /* renamed from: C */
    public void a(bc bcVar) {
        if (bcVar != null) {
            super.a(bcVar);
            if ((StringUtils.isNull(bcVar.getTitle()) && (bcVar.vu() == null || bcVar.vu().size() == 0)) || bcVar.vL() == 1) {
                bcVar.e(false, true);
                if (bcVar.vU() == null || StringUtils.isNull(bcVar.vU().toString())) {
                    this.cwZ.setVisibility(8);
                } else {
                    this.cwZ.setVisibility(0);
                    this.cwZ.setText(bcVar.vU());
                }
            } else {
                this.cwZ.setVisibility(0);
                bcVar.ait = 0;
                bcVar.e(false, bcVar.wp());
                SpannableStringBuilder vU = bcVar.vU();
                this.cwZ.setOnTouchListener(new k(vU));
                this.cwZ.setText(vU);
                o.a(this.cwZ, bcVar.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            }
            this.cxa.setData(this.atZ);
            if (this.bGZ.isInFrsAllThread() && com.baidu.tieba.frs.a.asZ().ata()) {
                this.axY.setVisibility(0);
                if (this.atZ.wS() || this.atZ.wT()) {
                    am.j(this.axY, d.C0142d.cp_bg_line_d);
                    return;
                } else {
                    this.axY.setBackgroundResource(d.C0142d.transparent);
                    return;
                }
            }
            this.axY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cxa.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void aif() {
        super.aif();
        o.a(this.cwZ, this.atZ.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        this.cxa.fr(this.atZ.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void hf(int i) {
        this.currentPageType = i;
        if (this.bGZ != null) {
            this.bGZ.akz = i;
            if (i == 15) {
                this.bGZ.setFrom(10);
            } else {
                this.bGZ.setFrom(2);
            }
        }
        if (this.bGY != null) {
            if (i == 15) {
                this.bGY.setFrom(5);
            } else {
                this.bGY.setFrom(3);
            }
        }
    }
}
