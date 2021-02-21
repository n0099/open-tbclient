package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveDoubleView;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder> {
    private com.baidu.tieba.ala.h gVl;
    private String labelName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder e(ViewGroup viewGroup) {
        AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView = new AlaGameFrsLiveDoubleView(this.mPageContext);
        alaGameFrsLiveDoubleView.setLabelName(this.labelName);
        return new AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder(alaGameFrsLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder alaGameFrsLiveDoubleViewHolder) {
        alaGameFrsLiveDoubleViewHolder.gWO.a(aVar);
        alaGameFrsLiveDoubleViewHolder.gWO.c(this.gVl);
        String str = "";
        if (!StringUtils.isNull(aVar.gXs.boj().appId)) {
            str = aVar.gXs.boj().appId;
        }
        com.baidu.tieba.ala.d.bOL().e(new ar("c12115").v("obj_id", aVar.gXs.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.gXt != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.gXt.boj().appId)) {
                str2 = aVar.gXt.boj().appId;
            }
            com.baidu.tieba.ala.d.bOL().e(new ar("c12115").v("obj_id", aVar.gXt.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return alaGameFrsLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.h hVar) {
        this.gVl = hVar;
    }
}
