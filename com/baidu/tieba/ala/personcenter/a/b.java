package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaForbiddenListActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.e, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.e.hEf);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new com.baidu.tieba.ala.personcenter.e.a(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.e.a> aVar) {
        if (aVar.coY() == null) {
            return null;
        }
        a(eVar, aVar.coY());
        aVar.coY().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.click();
            }
        });
        return aVar.coY().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.e eVar, com.baidu.tieba.ala.personcenter.e.a aVar) {
        aVar.wA(8);
        aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_forbidden));
        aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void click() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaForbiddenListActivityConfig(this.mPageContext.getPageActivity())));
    }
}
