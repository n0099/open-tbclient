package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.card.a.a<p>> {
    public BdUniqueId aPy;
    private c.a aVM;
    private x bon;
    private p dhM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVM = null;
        this.bon = new x<m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, m mVar) {
                u.aaj().cw(true);
                if (view != null && b.this.dhM != null && b.this.dhM.getView() != null && b.this.dhM.bTn != null && mVar != null && mVar.NA() != null && !StringUtils.isNull(mVar.NA().getTid())) {
                    if (view.getId() != b.this.dhM.getView().getId()) {
                        if (b.this.dhM.aag() == null || view.getId() != b.this.dhM.aag().getId()) {
                            if (b.this.dhM.getHeaderImg() == null || view.getId() != b.this.dhM.getHeaderImg().getId()) {
                                if (b.this.dhM.ZM() != null && b.this.dhM.ZM().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.aaF());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.aaF());
                            return;
                        }
                        TiebaStatic.log(mVar.aaE());
                        return;
                    }
                    TiebaStatic.log(mVar.aaC());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dhM = new p(this.mPageContext);
        this.dhM.aad();
        this.dhM.h(this.aPy);
        return new com.baidu.tieba.card.a.a(this.dhM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (aVar == null || aVar.aaJ() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.ih(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.aaJ().a(mVar);
        aVar.aaJ().a(this.aVM);
        if (mVar != null) {
            u.aaj().a(mVar.aaD());
        }
        aVar.aaJ().b(this.bon);
        return aVar.getView();
    }

    private ak b(m mVar) {
        if (mVar == null || mVar.NA() == null) {
            return null;
        }
        return new ak("c10732").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.NA().getFid())).ac("tid", String.valueOf(mVar.NA().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.aam()).r("obj_type", mVar.aaB()).ac("obj_id", mVar.getExtra());
    }

    private ak c(m mVar) {
        if (mVar == null || mVar.NA() == null) {
            return null;
        }
        ak ac = new ak("c10707").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.NA().getFid())).ac("tid", String.valueOf(mVar.NA().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.aam()).r("obj_type", mVar.aaB()).ac("obj_id", mVar.getExtra());
        if (mVar.NA() != null) {
            bh NA = mVar.NA();
            ac.r("obj_name", NA.sL() != null && (NA.sL().aEx() != null || NA.sL().Jb() != null) ? 1 : 0);
        }
        return ac;
    }

    private ak d(m mVar) {
        if (mVar == null || mVar.NA() == null) {
            return null;
        }
        return new ak("c10733").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.NA().getFid())).ac("tid", String.valueOf(mVar.NA().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.aam()).r("obj_type", mVar.aaB()).ac("obj_id", mVar.getExtra());
    }

    private ak e(m mVar) {
        if (mVar == null || mVar.NA() == null) {
            return null;
        }
        return new ak("c10706").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.NA().getFid())).ac("tid", String.valueOf(mVar.NA().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.aam()).r("obj_type", mVar.aaB()).ac("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.aVM = aVar;
    }
}
