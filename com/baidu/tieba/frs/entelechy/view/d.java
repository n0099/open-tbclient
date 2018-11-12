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
    private TextView cOR;
    private ThreadLinkView cOS;
    private View mMaskView;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void ax(View view) {
        if (view != null) {
            this.cOS = (ThreadLinkView) view.findViewById(e.g.link_thread_root);
            this.cOS.setTag(getTag());
            this.cOR = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
            this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
            this.bWR.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void bI(boolean z) {
                    al.j(d.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            });
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.bWR.changeSelectStatus();
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
            if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.yA() == null || bbVar.yA().size() == 0)) || bbVar.yS() == 1) {
                bbVar.g(false, true);
                if (bbVar.zc() == null || StringUtils.isNull(bbVar.zc().toString())) {
                    this.cOR.setVisibility(8);
                } else {
                    this.cOR.setVisibility(0);
                    this.cOR.setText(bbVar.zc());
                }
            } else {
                this.cOR.setVisibility(0);
                bbVar.apY = 0;
                bbVar.g(false, bbVar.zy());
                SpannableStringBuilder zc = bbVar.zc();
                this.cOR.setOnTouchListener(new k(zc));
                this.cOR.setText(zc);
                o.a(this.cOR, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            this.cOS.setData(this.aBF);
            if (this.bWR.isInFrsAllThread() && com.baidu.tieba.frs.a.ayk().ayl()) {
                this.mMaskView.setVisibility(0);
                if (this.aBF.Ad() || this.aBF.Ae()) {
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
        this.cOS.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void anv() {
        super.anv();
        o.a(this.cOR, this.aBF.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        this.cOS.ga(this.aBF.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.ab
    public void iv(int i) {
        this.currentPageType = i;
        if (this.bWR != null) {
            this.bWR.asl = i;
            if (i == 15) {
                this.bWR.setFrom(10);
            } else {
                this.bWR.setFrom(2);
                this.bWR.setDisPraiseFrom(2);
            }
        }
        if (this.bWQ != null) {
            if (i == 15) {
                this.bWQ.setFrom(5);
            } else {
                this.bWQ.setFrom(3);
            }
        }
    }
}
