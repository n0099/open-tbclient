package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.view.k;
/* loaded from: classes6.dex */
public class d extends c {
    private TextView cYo;
    private ThreadLinkView cYp;
    private View mMaskView;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void aA(View view) {
        if (view != null) {
            this.cYp = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cYp.setTag(getTag());
            this.cYo = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
            this.caM.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void bJ(boolean z) {
                    al.j(d.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            });
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.caM.changeSelectStatus();
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar != null) {
            super.a(bbVar);
            if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.zE() == null || bbVar.zE().size() == 0)) || bbVar.zW() == 1) {
                bbVar.g(false, true);
                if (bbVar.Ag() == null || StringUtils.isNull(bbVar.Ag().toString())) {
                    this.cYo.setVisibility(8);
                } else {
                    this.cYo.setVisibility(0);
                    this.cYo.setText(bbVar.Ag());
                }
            } else {
                this.cYo.setVisibility(0);
                bbVar.aty = 0;
                bbVar.g(false, bbVar.AC());
                SpannableStringBuilder Ag = bbVar.Ag();
                this.cYo.setOnTouchListener(new k(Ag));
                this.cYo.setText(Ag);
                o.a(this.cYo, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            this.cYp.setData(this.aFg);
            if (this.caM.isInFrsAllThread() && com.baidu.tieba.frs.a.aAJ().aAK()) {
                this.mMaskView.setVisibility(0);
                if (this.aFg.Bh() || this.aFg.Bi()) {
                    al.j(this.mMaskView, e.d.cp_bg_line_d);
                    return;
                } else {
                    this.mMaskView.setBackgroundResource(e.d.transparent);
                    return;
                }
            }
            this.mMaskView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cYp.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void apX() {
        super.apX();
        o.a(this.cYo, this.aFg.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cYp.gu(this.aFg.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void iK(int i) {
        this.currentPageType = i;
        if (this.caM != null) {
            this.caM.avM = i;
            if (i == 15) {
                this.caM.setFrom(10);
            } else {
                this.caM.setFrom(2);
                this.caM.setDisPraiseFrom(2);
            }
        }
        if (this.caL != null) {
            if (i == 15) {
                this.caL.setFrom(5);
            } else {
                this.caL.setFrom(3);
            }
        }
    }
}
