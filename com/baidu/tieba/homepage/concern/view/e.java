package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends d {
    private ThreadLinkView cVz;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ax(View view) {
        if (view != null) {
            this.cVz = (ThreadLinkView) view.findViewById(e.g.card_recommend_god_link_therad);
            this.cVz.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ag(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(bbVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.erB);
            }
            this.cVz.setData(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void aph() {
        super.aph();
        this.cVz.gt(this.bNv.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cVz.onChangeSkinType();
    }
}
