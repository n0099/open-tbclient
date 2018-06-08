package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends d {
    private ThreadLinkView czg;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ac(View view) {
        if (view != null) {
            this.czg = (ThreadLinkView) view.findViewById(d.g.card_recommend_god_link_therad);
            this.czg.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void Y(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.dOa);
            }
            this.czg.setData(bdVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void aiN() {
        super.aiN();
        this.czg.fn(this.bso.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czg.onChangeSkinType();
    }
}
