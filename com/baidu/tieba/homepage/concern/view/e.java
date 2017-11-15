package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends d {
    private ThreadLinkView bTL;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ad(View view) {
        if (view != null) {
            this.bTL = (ThreadLinkView) view.findViewById(d.g.card_recommend_god_link_therad);
            this.bTL.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void S(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(bhVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.dfo);
            }
            this.bTL.setData(bhVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void ZO() {
        super.ZO();
        this.bTL.er(this.biZ.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bTL.onChangeSkinType();
    }
}
