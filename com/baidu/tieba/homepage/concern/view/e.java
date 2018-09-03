package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class e extends d {
    private ThreadLinkView czA;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ah(View view) {
        if (view != null) {
            this.czA = (ThreadLinkView) view.findViewById(f.g.card_recommend_god_link_therad);
            this.czA.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void af(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(bbVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.dTZ);
            }
            this.czA.setData(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void aiH() {
        super.aiH();
        this.czA.fq(this.buy.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czA.onChangeSkinType();
    }
}
