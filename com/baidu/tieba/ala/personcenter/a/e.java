package com.baidu.tieba.ala.personcenter.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.f, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.f.frK);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.f fVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.bue() == null) {
            return null;
        }
        a(fVar, aVar.bue());
        aVar.bue().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.click();
            }
        });
        return aVar.bue().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.f fVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        aVar.qJ(8);
        aVar.setTitle(this.mContext.getResources().getString(R.string.ala_income_value));
        aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void click() {
        com.baidu.tbadk.browser.a.startWebActivity((Context) this.mPageContext.getPageActivity(), true, com.baidu.tbadk.core.sharedPref.b.aDr().getString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives"), this.mContext.getResources().getString(R.string.ala_income_value));
    }
}
