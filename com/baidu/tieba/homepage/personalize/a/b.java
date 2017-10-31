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
    public BdUniqueId aPq;
    private c.a aVE;
    private x boe;
    private p dhs;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVE = null;
        this.boe = new x<m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, m mVar) {
                u.ZX().cv(true);
                if (view != null && b.this.dhs != null && b.this.dhs.getView() != null && b.this.dhs.bTa != null && mVar != null && mVar.Np() != null && !StringUtils.isNull(mVar.Np().getTid())) {
                    if (view.getId() != b.this.dhs.getView().getId()) {
                        if (b.this.dhs.ZU() == null || view.getId() != b.this.dhs.ZU().getId()) {
                            if (b.this.dhs.getHeaderImg() == null || view.getId() != b.this.dhs.getHeaderImg().getId()) {
                                if (b.this.dhs.ZA() != null && b.this.dhs.ZA().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.aat());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.aat());
                            return;
                        }
                        TiebaStatic.log(mVar.aas());
                        return;
                    }
                    TiebaStatic.log(mVar.aaq());
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
        this.dhs = new p(this.mPageContext);
        this.dhs.ZR();
        this.dhs.h(this.aPq);
        return new com.baidu.tieba.card.a.a(this.dhs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (aVar == null || aVar.aax() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.ij(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.aax().a(mVar);
        aVar.aax().a(this.aVE);
        if (mVar != null) {
            u.ZX().a(mVar.aar());
        }
        aVar.aax().b(this.boe);
        return aVar.getView();
    }

    private ak b(m mVar) {
        if (mVar == null || mVar.Np() == null) {
            return null;
        }
        return new ak("c10732").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Np().getFid())).ac("tid", String.valueOf(mVar.Np().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.aaa()).r("obj_type", mVar.aap()).ac("obj_id", mVar.getExtra());
    }

    private ak c(m mVar) {
        if (mVar == null || mVar.Np() == null) {
            return null;
        }
        ak ac = new ak("c10707").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Np().getFid())).ac("tid", String.valueOf(mVar.Np().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.aaa()).r("obj_type", mVar.aap()).ac("obj_id", mVar.getExtra());
        if (mVar.Np() != null) {
            bh Np = mVar.Np();
            ac.r("obj_name", Np.sL() != null && (Np.sL().aEt() != null || Np.sL().IQ() != null) ? 1 : 0);
        }
        return ac;
    }

    private ak d(m mVar) {
        if (mVar == null || mVar.Np() == null) {
            return null;
        }
        return new ak("c10733").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Np().getFid())).ac("tid", String.valueOf(mVar.Np().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.aaa()).r("obj_type", mVar.aap()).ac("obj_id", mVar.getExtra());
    }

    private ak e(m mVar) {
        if (mVar == null || mVar.Np() == null) {
            return null;
        }
        return new ak("c10706").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Np().getFid())).ac("tid", String.valueOf(mVar.Np().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.aaa()).r("obj_type", mVar.aap()).ac("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.aVE = aVar;
    }
}
