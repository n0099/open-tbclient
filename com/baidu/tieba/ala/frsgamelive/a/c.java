package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.frsgamelive.c.c;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, c.a> {
    private com.baidu.tieba.ala.d fgx;
    private String labelName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public c.a b(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.c cVar = new com.baidu.tieba.ala.frsgamelive.c.c(this.mPageContext);
        cVar.setLabelName(this.labelName);
        return new c.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, c.a aVar2) {
        aVar2.fhO.a(aVar);
        aVar2.fhO.c(this.fgx);
        String str = "";
        if (!StringUtils.isNull(aVar.fiI.aKX().appId)) {
            str = aVar.fiI.aKX().appId;
        }
        com.baidu.tieba.ala.c.bjY().e(new an("c12115").t("obj_id", aVar.fiI.aKX().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.fiJ != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.fiJ.aKX().appId)) {
                str2 = aVar.fiJ.aKX().appId;
            }
            com.baidu.tieba.ala.c.bjY().e(new an("c12115").t("obj_id", aVar.fiJ.aKX().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.d dVar) {
        this.fgx = dVar;
    }
}
