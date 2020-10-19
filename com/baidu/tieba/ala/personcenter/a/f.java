package com.baidu.tieba.ala.personcenter.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.h, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.h.hmq);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.cjq() == null) {
            return null;
        }
        a(hVar, aVar.cjq());
        aVar.cjq().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                f.this.click();
            }
        });
        return aVar.cjq().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.h hVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        aVar.vT(8);
        aVar.setTitle(this.mContext.getResources().getString(R.string.ala_income_value));
        aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void click() {
        com.baidu.tbadk.browser.a.startWebActivity((Context) this.mPageContext.getPageActivity(), true, com.baidu.tbadk.core.sharedPref.b.blO().getString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives"), this.mContext.getResources().getString(R.string.ala_income_value));
    }
}
