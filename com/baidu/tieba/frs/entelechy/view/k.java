package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k extends j {
    private TextView bGh;
    private ThreadLinkView bIZ;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void T(View view) {
        if (view != null) {
            this.bIZ = (ThreadLinkView) view.findViewById(d.h.link_thread_root);
            this.bIZ.setTag(getTag());
            this.bGh = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        if (blVar != null) {
            super.a(blVar);
            if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rE() == null || blVar.rE().size() == 0)) || blVar.rV() == 1) {
                blVar.e(false, true);
                if (blVar.sg() == null || StringUtils.isNull(blVar.sg().toString())) {
                    this.bGh.setVisibility(8);
                } else {
                    this.bGh.setVisibility(0);
                    this.bGh.setText(blVar.sg());
                }
            } else {
                this.bGh.setVisibility(0);
                blVar.Zr = 0;
                blVar.e(false, blVar.sD());
                SpannableStringBuilder sg = blVar.sg();
                this.bGh.setOnTouchListener(new com.baidu.tieba.view.l(sg));
                this.bGh.setText(sg);
                m.a(this.bGh, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            this.bIZ.setData(this.akl);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bIZ.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void WC() {
        super.WC();
        m.a(this.bGh, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        this.bIZ.ez(this.akl.getId());
    }
}
