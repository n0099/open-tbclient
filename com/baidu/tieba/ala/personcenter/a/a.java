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
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.c.c, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.personcenter.c.c.exO);
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.c.c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a> aVar) {
        if (aVar.baZ() == null) {
            return null;
        }
        a(cVar, aVar.baZ());
        aVar.baZ().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.zg();
            }
        });
        return aVar.baZ().getView();
    }

    private void a(com.baidu.tieba.ala.personcenter.c.c cVar, com.baidu.tieba.ala.personcenter.d.a aVar) {
        aVar.om(8);
        aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_forbidden));
        aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaForbiddenListActivityConfig(this.mPageContext.getPageActivity())));
    }
}
