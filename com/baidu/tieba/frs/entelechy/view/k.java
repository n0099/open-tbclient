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
    private TextView bZU;
    private ThreadLinkView cbw;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void af(View view) {
        if (view != null) {
            this.cbw = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cbw.setTag(getTag());
            this.bZU = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar != null) {
            super.a(bdVar);
            if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rt() == null || bdVar.rt().size() == 0)) || bdVar.rL() == 1) {
                bdVar.e(false, true);
                if (bdVar.rV() == null || StringUtils.isNull(bdVar.rV().toString())) {
                    this.bZU.setVisibility(8);
                } else {
                    this.bZU.setVisibility(0);
                    this.bZU.setText(bdVar.rV());
                }
            } else {
                this.bZU.setVisibility(0);
                bdVar.YP = 0;
                bdVar.e(false, bdVar.st());
                SpannableStringBuilder rV = bdVar.rV();
                this.bZU.setOnTouchListener(new com.baidu.tieba.view.l(rV));
                this.bZU.setText(rV);
                com.baidu.tieba.card.k.a(this.bZU, bdVar.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            }
            this.cbw.setData(this.ajJ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cbw.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void aby() {
        super.aby();
        com.baidu.tieba.card.k.a(this.bZU, this.ajJ.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        this.cbw.ew(this.ajJ.getId());
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void fn(boolean z) {
        super.fn(z);
        if (this.biS != null) {
            this.biS.setVisibility(0);
        }
        if (this.ban != null) {
            this.ban.setVisibility(8);
        }
        if (this.bvI != null) {
            this.bvI.setVisibility(8);
        }
        if (this.cbw != null && (this.cbw.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbw.getLayoutParams();
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds40);
            this.cbw.setLayoutParams(layoutParams);
        }
    }
}
