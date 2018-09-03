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
import com.baidu.tieba.f;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class d extends c {
    private View axB;
    private ThreadLinkView czA;
    private TextView czz;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void ah(View view) {
        if (view != null) {
            this.czA = (ThreadLinkView) view.findViewById(f.g.link_thread_root);
            this.czA.setTag(getTag());
            this.czz = (TextView) view.findViewById(f.g.card_home_page_normal_thread_title);
            this.axB = view.findViewById(f.g.thread_multi_del_mask_view);
            this.bHO.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void aV(boolean z) {
                    am.j(d.this.axB, z ? f.d.cp_bg_line_d : f.d.transparent);
                }
            });
            this.axB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
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
            if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.vh() == null || bbVar.vh().size() == 0)) || bbVar.vz() == 1) {
                bbVar.e(false, true);
                if (bbVar.vI() == null || StringUtils.isNull(bbVar.vI().toString())) {
                    this.czz.setVisibility(8);
                } else {
                    this.czz.setVisibility(0);
                    this.czz.setText(bbVar.vI());
                }
            } else {
                this.czz.setVisibility(0);
                bbVar.ahP = 0;
                bbVar.e(false, bbVar.wd());
                SpannableStringBuilder vI = bbVar.vI();
                this.czz.setOnTouchListener(new k(vI));
                this.czz.setText(vI);
                o.a(this.czz, bbVar.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            }
            this.czA.setData(this.atE);
            if (this.bHO.isInFrsAllThread() && com.baidu.tieba.frs.a.atC().atD()) {
                this.axB.setVisibility(0);
                if (this.atE.wG() || this.atE.wH()) {
                    am.j(this.axB, f.d.cp_bg_line_d);
                    return;
                } else {
                    this.axB.setBackgroundResource(f.d.transparent);
                    return;
                }
            }
            this.axB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czA.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void aiH() {
        super.aiH();
        o.a(this.czz, this.atE.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        this.czA.fq(this.atE.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void hk(int i) {
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
