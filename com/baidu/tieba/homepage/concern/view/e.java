package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e extends d {
    private ThreadLinkView fHz;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void bQ(View view) {
        if (view != null) {
            this.fHz = (ThreadLinkView) view.findViewById(d.g.card_recommend_god_link_therad);
            this.fHz.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_link;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ao(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(bgVar.getTid())) {
            if (getView() != null) {
                getView().setOnClickListener(this.fHw);
            }
            this.fHz.setData(bgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void blB() {
        super.blB();
        this.fHz.nt(this.bTk.getId());
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        this.fHz.onChangeSkinType();
    }
}
