package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends d {
    private ThreadLinkView cUI;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void bz(View view) {
        if (view != null) {
            this.cUI = (ThreadLinkView) view.findViewById(d.g.card_recommend_god_link_therad);
            this.cUI.setTag(getTag());
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
                getView().setOnClickListener(this.ecx);
            }
            this.cUI.setData(bdVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void akg() {
        super.akg();
        this.cUI.eD(this.bXM.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cUI.onChangeSkinType();
    }
}
