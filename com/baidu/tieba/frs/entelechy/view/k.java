package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k extends j {
    private TextView bZQ;
    private ThreadLinkView cbs;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void ae(View view) {
        if (view != null) {
            this.cbs = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cbs.setTag(getTag());
            this.bZQ = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: y */
    public void a(bd bdVar) {
        if (bdVar != null) {
            super.a(bdVar);
            if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rv() == null || bdVar.rv().size() == 0)) || bdVar.rN() == 1) {
                bdVar.e(false, true);
                if (bdVar.rX() == null || StringUtils.isNull(bdVar.rX().toString())) {
                    this.bZQ.setVisibility(8);
                } else {
                    this.bZQ.setVisibility(0);
                    this.bZQ.setText(bdVar.rX());
                }
            } else {
                this.bZQ.setVisibility(0);
                bdVar.YV = 0;
                bdVar.e(false, bdVar.sv());
                SpannableStringBuilder rX = bdVar.rX();
                this.bZQ.setOnTouchListener(new com.baidu.tieba.view.l(rX));
                this.bZQ.setText(rX);
                com.baidu.tieba.card.k.a(this.bZQ, bdVar.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            }
            this.cbs.setData(this.ajM);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cbs.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void abx() {
        super.abx();
        com.baidu.tieba.card.k.a(this.bZQ, this.ajM.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        this.cbs.ew(this.ajM.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void fm(boolean z) {
        super.fm(z);
        if (this.biR != null) {
            this.biR.setVisibility(0);
        }
        if (this.bam != null) {
            this.bam.setVisibility(8);
        }
        if (this.bvH != null) {
            this.bvH.setVisibility(8);
        }
        if (this.cbs != null && (this.cbs.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbs.getLayoutParams();
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds40);
            this.cbs.setLayoutParams(layoutParams);
        }
    }
}
