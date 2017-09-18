package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.m;
/* loaded from: classes.dex */
public class k extends j {
    private TextView bJS;
    private ThreadLinkView bMJ;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void ab(View view) {
        if (view != null) {
            this.bMJ = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bMJ.setTag(getTag());
            this.bJS = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bj bjVar) {
        if (bjVar != null) {
            super.a(bjVar);
            if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.rz() == null || bjVar.rz().size() == 0)) || bjVar.rQ() == 1) {
                bjVar.e(false, true);
                if (bjVar.sb() == null || StringUtils.isNull(bjVar.sb().toString())) {
                    this.bJS.setVisibility(8);
                } else {
                    this.bJS.setVisibility(0);
                    this.bJS.setText(bjVar.sb());
                }
            } else {
                this.bJS.setVisibility(0);
                bjVar.Yv = 0;
                bjVar.e(false, bjVar.sy());
                SpannableStringBuilder sb = bjVar.sb();
                this.bJS.setOnTouchListener(new m(sb));
                this.bJS.setText(sb);
                com.baidu.tieba.card.m.a(this.bJS, bjVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            this.bMJ.setData(this.ajE);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bMJ.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void XQ() {
        super.XQ();
        com.baidu.tieba.card.m.a(this.bJS, this.ajE.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bMJ.es(this.ajE.getId());
    }

    public void ajz() {
        View view = getView();
        if (view != null) {
            view.findViewById(d.h.top_divider_line).setVisibility(0);
        }
    }
}
