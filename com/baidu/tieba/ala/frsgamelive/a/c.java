package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.frsgamelive.c.c;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, c.a> {
    private com.baidu.tieba.ala.f gwN;
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
    /* renamed from: ai */
    public c.a c(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.c cVar = new com.baidu.tieba.ala.frsgamelive.c.c(this.mPageContext);
        cVar.setLabelName(this.labelName);
        return new c.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, c.a aVar2) {
        aVar2.gye.a(aVar);
        aVar2.gye.c(this.gwN);
        String str = "";
        if (!StringUtils.isNull(aVar.gyW.bku().appId)) {
            str = aVar.gyW.bku().appId;
        }
        com.baidu.tieba.ala.c.bJP().e(new aq("c12115").w("obj_id", aVar.gyW.bku().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.gyX != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.gyX.bku().appId)) {
                str2 = aVar.gyX.bku().appId;
            }
            com.baidu.tieba.ala.c.bJP().e(new aq("c12115").w("obj_id", aVar.gyX.bku().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.f fVar) {
        this.gwN = fVar;
    }
}
