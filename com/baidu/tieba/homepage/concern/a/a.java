package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> {
    public BdUniqueId aSv;
    private com.baidu.tieba.homepage.concern.view.e dmY;
    private v<com.baidu.tieba.homepage.concern.b.b> dmZ;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dmZ = new v<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.dmY != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.cBr.getFid());
                    akVar.ac("tid", bVar.cBr.getTid());
                    akVar.r("obj_type", 4);
                    akVar.ac("obj_id", bVar.dnA.getUserId());
                    if ((a.this.dmY.dnR == null || view.getId() != a.this.dmY.dnR.getId()) && (a.this.dmY.bvD.getHeaderImg() == null || view.getId() != a.this.dmY.bvD.getHeaderImg().getId())) {
                        if (a.this.dmY.dnO != null && view.getId() == a.this.dmY.dnO.getId()) {
                            akVar.r("obj_locate", 3);
                        } else {
                            akVar.r("obj_locate", 2);
                        }
                    } else {
                        akVar.r("obj_locate", 1);
                    }
                    akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.atE());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.dmY = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aSv != null) {
            this.dmY.k(this.aSv);
        }
        return new com.baidu.tieba.card.a.a<>(this.dmY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.dnA == null || aVar == null || StringUtils.isNull(bVar.dnA.getName()) || StringUtils.isNull(bVar.dnA.getUserId())) {
            return null;
        }
        aVar.acs().a(bVar);
        aVar.acs().b(this.dmZ);
        aVar.acs().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        s.abU().a(new ak("c12353").f(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccountId()).ac("obj_id", bVar.dnA.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.atE()).ac("tid", bVar.cBr.getTid()));
        return aVar.getView();
    }
}
