package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsGameLiveDoubleView;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder> {
    private com.baidu.tieba.ala.g gSn;
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
    /* renamed from: as */
    public AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder e(ViewGroup viewGroup) {
        AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView = new AlaGameFrsGameLiveDoubleView(this.mPageContext);
        alaGameFrsGameLiveDoubleView.setLabelName(this.labelName);
        return new AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder(alaGameFrsGameLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder alaGameFrsGameLiveDoubleViewHolder) {
        alaGameFrsGameLiveDoubleViewHolder.gTE.a(aVar);
        alaGameFrsGameLiveDoubleViewHolder.gTE.c(this.gSn);
        String str = "";
        if (!StringUtils.isNull(aVar.gUu.bnQ().appId)) {
            str = aVar.gUu.bnQ().appId;
        }
        com.baidu.tieba.ala.d.bOa().e(new aq("c12115").w("obj_id", aVar.gUu.bnQ().live_id).dW(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.gUv != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.gUv.bnQ().appId)) {
                str2 = aVar.gUv.bnQ().appId;
            }
            com.baidu.tieba.ala.d.bOa().e(new aq("c12115").w("obj_id", aVar.gUv.bnQ().live_id).dW(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return alaGameFrsGameLiveDoubleViewHolder.getView();
    }

    public void a(com.baidu.tieba.ala.g gVar) {
        this.gSn = gVar;
    }
}
