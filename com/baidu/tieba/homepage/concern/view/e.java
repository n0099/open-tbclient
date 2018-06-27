package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends d {
    private ThreadLinkView cxa;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ae(View view) {
        if (view != null) {
            this.cxa = (ThreadLinkView) view.findViewById(d.g.card_recommend_god_link_therad);
            this.cxa.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ad(bc bcVar) {
        if (bcVar != null && !StringUtils.isNull(bcVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.dRr);
            }
            this.cxa.setData(bcVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void aif() {
        super.aif();
        this.cxa.fr(this.btP.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cxa.onChangeSkinType();
    }
}
