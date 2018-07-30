package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class d extends c {
    private View axE;
    private TextView czC;
    private ThreadLinkView czD;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void ah(View view) {
        if (view != null) {
            this.czD = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.czD.setTag(getTag());
            this.czC = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
            this.axE = view.findViewById(d.g.thread_multi_del_mask_view);
            this.bHO.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void aU(boolean z) {
                    am.j(d.this.axE, z ? d.C0140d.cp_bg_line_d : d.C0140d.transparent);
                }
            });
            this.axE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.bHO.changeSelectStatus();
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        if (bbVar != null) {
            super.a(bbVar);
            if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.vi() == null || bbVar.vi().size() == 0)) || bbVar.vA() == 1) {
                bbVar.e(false, true);
                if (bbVar.vJ() == null || StringUtils.isNull(bbVar.vJ().toString())) {
                    this.czC.setVisibility(8);
                } else {
                    this.czC.setVisibility(0);
                    this.czC.setText(bbVar.vJ());
                }
            } else {
                this.czC.setVisibility(0);
                bbVar.ahP = 0;
                bbVar.e(false, bbVar.we());
                SpannableStringBuilder vJ = bbVar.vJ();
                this.czC.setOnTouchListener(new k(vJ));
                this.czC.setText(vJ);
                o.a(this.czC, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            }
            this.czD.setData(this.atD);
            if (this.bHO.isInFrsAllThread() && com.baidu.tieba.frs.a.atD().atE()) {
                this.axE.setVisibility(0);
                if (this.atD.wH() || this.atD.wI()) {
                    am.j(this.axE, d.C0140d.cp_bg_line_d);
                    return;
                } else {
                    this.axE.setBackgroundResource(d.C0140d.transparent);
                    return;
                }
            }
            this.axE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czD.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void aiE() {
        super.aiE();
        o.a(this.czC, this.atD.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        this.czD.fq(this.atD.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void hl(int i) {
        this.currentPageType = i;
        if (this.bHO != null) {
            this.bHO.ajY = i;
            if (i == 15) {
                this.bHO.setFrom(10);
            } else {
                this.bHO.setFrom(2);
            }
        }
        if (this.bHN != null) {
            if (i == 15) {
                this.bHN.setFrom(5);
            } else {
                this.bHN.setFrom(3);
            }
        }
    }
}
