package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.view.k;
/* loaded from: classes2.dex */
public class d extends c {
    private TextView czf;
    private ThreadLinkView czg;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c
    protected void ac(View view) {
        if (view != null) {
            this.czg = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.czg.setTag(getTag());
            this.czf = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar != null) {
            super.a(bdVar);
            if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.vk() == null || bdVar.vk().size() == 0)) || bdVar.vB() == 1) {
                bdVar.e(false, true);
                if (bdVar.vK() == null || StringUtils.isNull(bdVar.vK().toString())) {
                    this.czf.setVisibility(8);
                } else {
                    this.czf.setVisibility(0);
                    this.czf.setText(bdVar.vK());
                }
            } else {
                this.czf.setVisibility(0);
                bdVar.aia = 0;
                bdVar.e(false, bdVar.wf());
                SpannableStringBuilder vK = bdVar.vK();
                this.czf.setOnTouchListener(new k(vK));
                this.czf.setText(vK);
                o.a(this.czf, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            }
            this.czg.setData(this.atn);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.c, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czg.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.c
    public void aiN() {
        super.aiN();
        o.a(this.czf, this.atn.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        this.czg.fn(this.atn.getId());
    }
}
