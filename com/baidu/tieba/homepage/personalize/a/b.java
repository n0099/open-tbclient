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
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m>> {
    public BdUniqueId bGw;
    private c.a bMO;
    private v ciz;
    private com.baidu.tieba.card.m efe;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMO = null;
        this.ciz = new v<m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                s.akF().de(true);
                if (view != null && b.this.efe != null && b.this.efe.getView() != null && b.this.efe.cUj != null && mVar != null && mVar.VK() != null && !StringUtils.isNull(mVar.VK().getTid())) {
                    if (view.getId() != b.this.efe.getView().getId()) {
                        if (b.this.efe.akz() == null || view.getId() != b.this.efe.akz().getId()) {
                            if (b.this.efe.getHeaderImg() == null || view.getId() != b.this.efe.getHeaderImg().getId()) {
                                if (b.this.efe.ake() != null && b.this.efe.ake().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.alg());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.alg());
                            return;
                        }
                        TiebaStatic.log(mVar.alf());
                        return;
                    }
                    TiebaStatic.log(mVar.ald());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.efe = new com.baidu.tieba.card.m(this.mPageContext);
        this.efe.akw();
        this.efe.h(this.bGw);
        this.efe.currentPageType = 2;
        return new com.baidu.tieba.card.a.a(this.efe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m> aVar) {
        if (aVar == null || aVar.alk() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.lH(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.alk().a(mVar);
        aVar.alk().a(this.bMO);
        if (mVar != null) {
            s.akF().a(mVar.ale());
        }
        aVar.alk().b(this.ciz);
        return aVar.getView();
    }

    private ak b(m mVar) {
        if (mVar == null || mVar.VK() == null) {
            return null;
        }
        return new ak("c10732").ab(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VK().getFid())).ab("tid", String.valueOf(mVar.VK().getTid())).ab("obj_param1", mVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.akN()).s("obj_type", mVar.alc()).ab("obj_id", mVar.getExtra());
    }

    private ak c(m mVar) {
        if (mVar == null || mVar.VK() == null) {
            return null;
        }
        ak ab = new ak("c10707").ab(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VK().getFid())).ab("tid", String.valueOf(mVar.VK().getTid())).ab("obj_param1", mVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.akN()).s("obj_type", mVar.alc()).ab("obj_id", mVar.getExtra());
        if (mVar.VK() != null) {
            bd VK = mVar.VK();
            ab.s("obj_name", VK.Ag() != null && (VK.Ag().bvK() != null || VK.Ag().QJ() != null) ? 1 : 0);
            if (VK.yS() != null) {
                ab.s("ab_type", VK.yS().hadConcerned() ? 1 : 0);
            }
        }
        return ab;
    }

    private ak d(m mVar) {
        if (mVar == null || mVar.VK() == null) {
            return null;
        }
        return new ak("c10733").ab(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VK().getFid())).ab("tid", String.valueOf(mVar.VK().getTid())).ab("obj_param1", mVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.akN()).s("obj_type", mVar.alc()).ab("obj_id", mVar.getExtra());
    }

    private ak e(m mVar) {
        if (mVar == null || mVar.VK() == null) {
            return null;
        }
        return new ak("c10706").ab(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VK().getFid())).ab("tid", String.valueOf(mVar.VK().getTid())).ab("obj_param1", mVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.akN()).s("obj_type", mVar.alc()).ab("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.bMO = aVar;
    }
}
