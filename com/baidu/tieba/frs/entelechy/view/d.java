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
    private TextView cNL;
    private ThreadLinkView cNM;
    private View mMaskView;

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
            this.cNM = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cNM.setTag(getTag());
            this.cNL = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
            this.bWf.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void br(boolean z) {
                    al.j(d.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            });
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.bWf.changeSelectStatus();
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
            if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.yt() == null || bbVar.yt().size() == 0)) || bbVar.yL() == 1) {
                bbVar.g(false, true);
                if (bbVar.yV() == null || StringUtils.isNull(bbVar.yV().toString())) {
                    this.cNL.setVisibility(8);
                } else {
                    this.cNL.setVisibility(0);
                    this.cNL.setText(bbVar.yV());
                }
            } else {
                this.cNL.setVisibility(0);
                bbVar.apk = 0;
                bbVar.g(false, bbVar.zr());
                SpannableStringBuilder yV = bbVar.yV();
                this.cNL.setOnTouchListener(new k(yV));
                this.cNL.setText(yV);
                o.a(this.cNL, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            this.cNM.setData(this.aAQ);
            if (this.bWf.isInFrsAllThread() && com.baidu.tieba.frs.a.ayM().ayN()) {
                this.mMaskView.setVisibility(0);
                if (this.aAQ.zW() || this.aAQ.zX()) {
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
        this.cNM.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void anT() {
        super.anT();
        o.a(this.cNL, this.aAQ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cNM.fZ(this.aAQ.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void ii(int i) {
        this.currentPageType = i;
        if (this.bWf != null) {
            this.bWf.ary = i;
            if (i == 15) {
                this.bWf.setFrom(10);
            } else {
                this.bWf.setFrom(2);
                this.bWf.setDisPraiseFrom(2);
            }
        }
        if (this.bWe != null) {
            if (i == 15) {
                this.bWe.setFrom(5);
            } else {
                this.bWe.setFrom(3);
            }
        }
    }
}
