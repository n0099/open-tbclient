package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m>> {
    public BdUniqueId aSy;
    private c.a aYP;
    private v buW;
    private com.baidu.tieba.card.m drG;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.buW = new v<m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                s.abW().cC(true);
                if (view != null && b.this.drG != null && b.this.drG.getView() != null && b.this.drG.caX != null && mVar != null && mVar.Ox() != null && !StringUtils.isNull(mVar.Ox().getTid())) {
                    if (view.getId() != b.this.drG.getView().getId()) {
                        if (b.this.drG.abQ() == null || view.getId() != b.this.drG.abQ().getId()) {
                            if (b.this.drG.getHeaderImg() == null || view.getId() != b.this.drG.getHeaderImg().getId()) {
                                if (b.this.drG.abw() != null && b.this.drG.abw().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.acx());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.acx());
                            return;
                        }
                        TiebaStatic.log(mVar.acw());
                        return;
                    }
                    TiebaStatic.log(mVar.acu());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.drG = new com.baidu.tieba.card.m(this.mPageContext);
        this.drG.abN();
        this.drG.h(this.aSy);
        this.drG.currentPageType = 2;
        return new com.baidu.tieba.card.a.a(this.drG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m> aVar) {
        if (aVar == null || aVar.acB() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.iG(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.acB().a(mVar);
        aVar.acB().a(this.aYP);
        if (mVar != null) {
            s.abW().a(mVar.acv());
        }
        aVar.acB().b(this.buW);
        return aVar.getView();
    }

    private ak b(m mVar) {
        if (mVar == null || mVar.Ox() == null) {
            return null;
        }
        return new ak("c10732").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Ox().getFid())).ac("tid", String.valueOf(mVar.Ox().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.ace()).r("obj_type", mVar.act()).ac("obj_id", mVar.getExtra());
    }

    private ak c(m mVar) {
        if (mVar == null || mVar.Ox() == null) {
            return null;
        }
        ak ac = new ak("c10707").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Ox().getFid())).ac("tid", String.valueOf(mVar.Ox().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.ace()).r("obj_type", mVar.act()).ac("obj_id", mVar.getExtra());
        if (mVar.Ox() != null) {
            bd Ox = mVar.Ox();
            ac.r("obj_name", Ox.sM() != null && (Ox.sM().bwX() != null || Ox.sM().Jz() != null) ? 1 : 0);
            if (Ox.rv() != null) {
                ac.r("ab_type", Ox.rv().hadConcerned() ? 1 : 0);
            }
        }
        return ac;
    }

    private ak d(m mVar) {
        if (mVar == null || mVar.Ox() == null) {
            return null;
        }
        return new ak("c10733").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Ox().getFid())).ac("tid", String.valueOf(mVar.Ox().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.ace()).r("obj_type", mVar.act()).ac("obj_id", mVar.getExtra());
    }

    private ak e(m mVar) {
        if (mVar == null || mVar.Ox() == null) {
            return null;
        }
        return new ak("c10706").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Ox().getFid())).ac("tid", String.valueOf(mVar.Ox().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.ace()).r("obj_type", mVar.act()).ac("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.aYP = aVar;
    }
}
