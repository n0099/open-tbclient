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
/* loaded from: classes2.dex */
public class d extends c {
    private View aAH;
    private TextView cFr;
    private ThreadLinkView cFs;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void av(View view) {
        if (view != null) {
            this.cFs = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cFs.setTag(getTag());
            this.cFr = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.aAH = view.findViewById(e.g.thread_multi_del_mask_view);
            this.bND.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void bh(boolean z) {
                    al.j(d.this.aAH, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            });
            this.aAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.bND.changeSelectStatus();
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
            if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.wk() == null || bbVar.wk().size() == 0)) || bbVar.wC() == 1) {
                bbVar.g(false, true);
                if (bbVar.wM() == null || StringUtils.isNull(bbVar.wM().toString())) {
                    this.cFr.setVisibility(8);
                } else {
                    this.cFr.setVisibility(0);
                    this.cFr.setText(bbVar.wM());
                }
            } else {
                this.cFr.setVisibility(0);
                bbVar.akp = 0;
                bbVar.g(false, bbVar.xi());
                SpannableStringBuilder wM = bbVar.wM();
                this.cFr.setOnTouchListener(new k(wM));
                this.cFr.setText(wM);
                o.a(this.cFr, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            this.cFs.setData(this.awf);
            if (this.bND.isInFrsAllThread() && com.baidu.tieba.frs.a.avq().avr()) {
                this.aAH.setVisibility(0);
                if (this.awf.xN() || this.awf.xO()) {
                    al.j(this.aAH, e.d.cp_bg_line_d);
                    return;
                } else {
                    this.aAH.setBackgroundResource(e.d.transparent);
                    return;
                }
            }
            this.aAH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cFs.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void akr() {
        super.akr();
        o.a(this.cFr, this.awf.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cFs.fL(this.awf.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void hK(int i) {
        this.currentPageType = i;
        if (this.bND != null) {
            this.bND.amD = i;
            if (i == 15) {
                this.bND.setFrom(10);
            } else {
                this.bND.setFrom(2);
                this.bND.setDisPraiseFrom(2);
            }
        }
        if (this.bNC != null) {
            if (i == 15) {
                this.bNC.setFrom(5);
            } else {
                this.bNC.setFrom(3);
            }
        }
    }
}
