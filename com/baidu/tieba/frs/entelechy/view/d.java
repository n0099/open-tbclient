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
    private TextView cZa;
    private ThreadLinkView cZb;
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
            this.cZb = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cZb.setTag(getTag());
            this.cZa = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
            this.cby.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void bK(boolean z) {
                    al.j(d.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            });
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.cby.changeSelectStatus();
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
            if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.zR() == null || bbVar.zR().size() == 0)) || bbVar.Aj() == 1) {
                bbVar.g(false, true);
                if (bbVar.At() == null || StringUtils.isNull(bbVar.At().toString())) {
                    this.cZa.setVisibility(8);
                } else {
                    this.cZa.setVisibility(0);
                    this.cZa.setText(bbVar.At());
                }
            } else {
                this.cZa.setVisibility(0);
                bbVar.aub = 0;
                bbVar.g(false, bbVar.AP());
                SpannableStringBuilder At = bbVar.At();
                this.cZa.setOnTouchListener(new k(At));
                this.cZa.setText(At);
                o.a(this.cZa, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            this.cZb.setData(this.aFJ);
            if (this.cby.isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
                this.mMaskView.setVisibility(0);
                if (this.aFJ.Bu() || this.aFJ.Bv()) {
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
        this.cZb.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void aqu() {
        super.aqu();
        o.a(this.cZa, this.aFJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cZb.gH(this.aFJ.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void iK(int i) {
        this.currentPageType = i;
        if (this.cby != null) {
            this.cby.awp = i;
            if (i == 15) {
                this.cby.setFrom(10);
            } else {
                this.cby.setFrom(2);
                this.cby.setDisPraiseFrom(2);
            }
        }
        if (this.cbx != null) {
            if (i == 15) {
                this.cbx.setFrom(5);
            } else {
                this.cbx.setFrom(3);
            }
        }
    }
}
