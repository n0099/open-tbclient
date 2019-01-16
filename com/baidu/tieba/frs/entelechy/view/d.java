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
    private TextView cYZ;
    private ThreadLinkView cZa;
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
            this.cZa = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cZa.setTag(getTag());
            this.cYZ = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
            this.cbx.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void bK(boolean z) {
                    al.j(d.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            });
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.cbx.changeSelectStatus();
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
                    this.cYZ.setVisibility(8);
                } else {
                    this.cYZ.setVisibility(0);
                    this.cYZ.setText(bbVar.At());
                }
            } else {
                this.cYZ.setVisibility(0);
                bbVar.aua = 0;
                bbVar.g(false, bbVar.AP());
                SpannableStringBuilder At = bbVar.At();
                this.cYZ.setOnTouchListener(new k(At));
                this.cYZ.setText(At);
                o.a(this.cYZ, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            this.cZa.setData(this.aFI);
            if (this.cbx.isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
                this.mMaskView.setVisibility(0);
                if (this.aFI.Bu() || this.aFI.Bv()) {
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
        this.cZa.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void aqu() {
        super.aqu();
        o.a(this.cYZ, this.aFI.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cZa.gH(this.aFI.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void iK(int i) {
        this.currentPageType = i;
        if (this.cbx != null) {
            this.cbx.awo = i;
            if (i == 15) {
                this.cbx.setFrom(10);
            } else {
                this.cbx.setFrom(2);
                this.cbx.setDisPraiseFrom(2);
            }
        }
        if (this.cbw != null) {
            if (i == 15) {
                this.cbw.setFrom(5);
            } else {
                this.cbw.setFrom(3);
            }
        }
    }
}
