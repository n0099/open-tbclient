package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.ala.frsgamelive.c.c;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, c.a> {
    private com.baidu.tieba.ala.e fLb;
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
    /* renamed from: ae */
    public c.a b(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.c cVar = new com.baidu.tieba.ala.frsgamelive.c.c(this.mPageContext);
        cVar.setLabelName(this.labelName);
        return new c.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, c.a aVar2) {
        aVar2.fMs.a(aVar);
        aVar2.fMs.c(this.fLb);
        String str = "";
        if (!StringUtils.isNull(aVar.fNk.aWF().appId)) {
            str = aVar.fNk.aWF().appId;
        }
        com.baidu.tieba.ala.c.buZ().e(new ap("c12115").t("obj_id", aVar.fNk.aWF().live_id).dn(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.fNl != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.fNl.aWF().appId)) {
                str2 = aVar.fNl.aWF().appId;
            }
            com.baidu.tieba.ala.c.buZ().e(new ap("c12115").t("obj_id", aVar.fNl.aWF().live_id).dn(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.e eVar) {
        this.fLb = eVar;
    }
}
