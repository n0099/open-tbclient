package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveDoubleView;
/* loaded from: classes10.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder> {
    private com.baidu.tieba.ala.g gWT;
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
    /* renamed from: au */
    public AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder e(ViewGroup viewGroup) {
        AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView = new AlaGameFrsLiveDoubleView(this.mPageContext);
        alaGameFrsLiveDoubleView.setLabelName(this.labelName);
        return new AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder(alaGameFrsLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder alaGameFrsLiveDoubleViewHolder) {
        alaGameFrsLiveDoubleViewHolder.gYw.a(aVar);
        alaGameFrsLiveDoubleViewHolder.gYw.c(this.gWT);
        String str = "";
        if (!StringUtils.isNull(aVar.gZa.brJ().appId)) {
            str = aVar.gZa.brJ().appId;
        }
        com.baidu.tieba.ala.d.bRR().e(new aq("c12115").w("obj_id", aVar.gZa.brJ().live_id).dX(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.gZb != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.gZb.brJ().appId)) {
                str2 = aVar.gZb.brJ().appId;
            }
            com.baidu.tieba.ala.d.bRR().e(new aq("c12115").w("obj_id", aVar.gZb.brJ().live_id).dX(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return alaGameFrsLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.g gVar) {
        this.gWT = gVar;
    }
}
