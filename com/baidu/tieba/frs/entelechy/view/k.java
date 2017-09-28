package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k extends j {
    private TextView bKl;
    private ThreadLinkView bMg;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void aa(View view) {
        if (view != null) {
            this.bMg = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bMg.setTag(getTag());
            this.bKl = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        if (bhVar != null) {
            super.a(bhVar);
            if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rt() == null || bhVar.rt().size() == 0)) || bhVar.rK() == 1) {
                bhVar.e(false, true);
                if (bhVar.rV() == null || StringUtils.isNull(bhVar.rV().toString())) {
                    this.bKl.setVisibility(8);
                } else {
                    this.bKl.setVisibility(0);
                    this.bKl.setText(bhVar.rV());
                }
            } else {
                this.bKl.setVisibility(0);
                bhVar.Yw = 0;
                bhVar.e(false, bhVar.ss());
                SpannableStringBuilder rV = bhVar.rV();
                this.bKl.setOnTouchListener(new com.baidu.tieba.view.k(rV));
                this.bKl.setText(rV);
                m.a(this.bKl, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            this.bMg.setData(this.ajg);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bMg.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void Xw() {
        super.Xw();
        m.a(this.bKl, this.ajg.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bMg.em(this.ajg.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void eW(boolean z) {
        super.eW(z);
        if (this.cyj != null) {
            this.cyj.setVisibility(0);
        }
        if (this.aWX != null) {
            this.aWX.setVisibility(8);
        }
        if (this.bnj != null) {
            this.bnj.setVisibility(8);
        }
        if (this.bMg != null && (this.bMg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMg.getLayoutParams();
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds40);
            this.bMg.setLayoutParams(layoutParams);
        }
    }
}
