package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends d {
    private ThreadLinkView cQg;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void bx(View view) {
        if (view != null) {
            this.cQg = (ThreadLinkView) view.findViewById(d.g.card_recommend_god_link_therad);
            this.cQg.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void U(be beVar) {
        if (beVar != null && !StringUtils.isNull(beVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.ebn);
            }
            this.cQg.setData(beVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void ajd() {
        super.ajd();
        this.cQg.eD(this.bXF.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cQg.onChangeSkinType();
    }
}
