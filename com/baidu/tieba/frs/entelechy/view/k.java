package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.m;
/* loaded from: classes2.dex */
public class k extends j {
    private TextView cTz;
    private ThreadLinkView cVd;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_link_thread;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j
    protected void bz(View view) {
        if (view != null) {
            this.cVd = (ThreadLinkView) view.findViewById(d.g.link_thread_root);
            this.cVd.setTag(getTag());
            this.cTz = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        if (bdVar != null) {
            super.a(bdVar);
            if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.yR() == null || bdVar.yR().size() == 0)) || bdVar.zj() == 1) {
                bdVar.h(false, true);
                if (bdVar.zt() == null || StringUtils.isNull(bdVar.zt().toString())) {
                    this.cTz.setVisibility(8);
                } else {
                    this.cTz.setVisibility(0);
                    this.cTz.setText(bdVar.zt());
                }
            } else {
                this.cTz.setVisibility(0);
                bdVar.aNq = 0;
                bdVar.h(false, bdVar.zO());
                SpannableStringBuilder zt = bdVar.zt();
                this.cTz.setOnTouchListener(new m(zt));
                this.cTz.setText(zt);
                com.baidu.tieba.card.k.a(this.cTz, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            }
            this.cVd.setData(this.aYc);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.j, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cVd.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.view.j
    public void akl() {
        super.akl();
        com.baidu.tieba.card.k.a(this.cTz, this.aYc.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        this.cVd.eL(this.aYc.getId());
    }
}
