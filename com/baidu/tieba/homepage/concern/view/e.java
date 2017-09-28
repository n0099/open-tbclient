package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends d {
    private ThreadLinkView bMg;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void aa(View view) {
        if (view != null) {
            this.bMg = (ThreadLinkView) view.findViewById(d.h.card_recommend_god_link_therad);
            this.bMg.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void Q(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(bhVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.cWQ);
            }
            this.bMg.setData(bhVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void Xw() {
        super.Xw();
        this.bMg.em(this.bit.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bMg.onChangeSkinType();
    }
}
