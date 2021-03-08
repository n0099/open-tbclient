package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsGameLiveDoubleView;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder> {
    private com.baidu.tieba.ala.h gWU;
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
    /* renamed from: aq */
    public AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder e(ViewGroup viewGroup) {
        AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView = new AlaGameFrsGameLiveDoubleView(this.mPageContext);
        alaGameFrsGameLiveDoubleView.setLabelName(this.labelName);
        return new AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder(alaGameFrsGameLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder alaGameFrsGameLiveDoubleViewHolder) {
        alaGameFrsGameLiveDoubleViewHolder.gYl.a(aVar);
        alaGameFrsGameLiveDoubleViewHolder.gYl.c(this.gWU);
        String str = "";
        if (!StringUtils.isNull(aVar.gZb.bol().appId)) {
            str = aVar.gZb.bol().appId;
        }
        com.baidu.tieba.ala.d.bOR().e(new ar("c12115").v("obj_id", aVar.gZb.bol().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.gZc != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.gZc.bol().appId)) {
                str2 = aVar.gZc.bol().appId;
            }
            com.baidu.tieba.ala.d.bOR().e(new ar("c12115").v("obj_id", aVar.gZc.bol().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return alaGameFrsGameLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.h hVar) {
        this.gWU = hVar;
    }
}
