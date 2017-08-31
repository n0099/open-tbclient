package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends d {
    private ThreadLinkView bLS;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ab(View view) {
        if (view != null) {
            this.bLS = (ThreadLinkView) view.findViewById(d.h.card_recommend_god_link_therad);
            this.bLS.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void V(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(bjVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.cZt);
            }
            this.bLS.setData(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void XF() {
        super.XF();
        this.bLS.es(this.bgI.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bLS.onChangeSkinType();
    }
}
