package com.baidu.tieba.ala.personcenter.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.f, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.f.ewZ);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.d.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.f fVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a> aVar) {
        if (aVar.baX() == null) {
            return null;
        }
        a(fVar, aVar.baX());
        aVar.baX().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.zh();
            }
        });
        return aVar.baX().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.f fVar, com.baidu.tieba.ala.personcenter.d.a aVar) {
        aVar.ol(8);
        aVar.setTitle(this.mContext.getResources().getString(R.string.ala_income_value));
        aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        com.baidu.tbadk.browser.a.startWebActivity((Context) this.mPageContext.getPageActivity(), true, com.baidu.tbadk.core.sharedPref.b.alP().getString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives"), this.mContext.getResources().getString(R.string.ala_income_value));
    }
}
