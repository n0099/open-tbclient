package com.baidu.tieba.ala.personcenter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaLoveFamilyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.i;
/* loaded from: classes6.dex */
public class g extends com.baidu.adp.widget.ListView.a<i, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), i.exc);
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
    public View a(int i, View view, ViewGroup viewGroup, final i iVar, com.baidu.tieba.card.a.a<com.baidu.tieba.ala.personcenter.d.a> aVar) {
        if (aVar.baX() == null) {
            return null;
        }
        a(iVar, aVar.baX());
        aVar.baX().getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.a.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.a(iVar);
            }
        });
        return aVar.baX().getView();
    }

    private void a(i iVar, com.baidu.tieba.ala.personcenter.d.a aVar) {
        if (iVar.getPersonCenterData() != null) {
            aVar.ol(8);
            aVar.setTitle(this.mContext.getResources().getString(R.string.ala_person_live_my_love_family));
            aVar.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar != null && iVar.getPersonCenterData() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLoveFamilyActivityConfig(this.mContext, iVar.getPersonCenterData().aXC().user_id)));
        }
    }
}
