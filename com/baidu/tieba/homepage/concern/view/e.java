package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends d {
    private ThreadLinkView cbs;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ae(View view) {
        if (view != null) {
            this.cbs = (ThreadLinkView) view.findViewById(d.g.card_recommend_god_link_therad);
            this.cbs.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void U(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(bdVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.dnV);
            }
            this.cbs.setData(bdVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void abx() {
        super.abx();
        this.cbs.ew(this.bkp.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cbs.onChangeSkinType();
    }
}
