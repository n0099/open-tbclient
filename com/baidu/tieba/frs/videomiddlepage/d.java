package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.afd.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Po;
    private com.baidu.tieba.lego.card.view.f Pp;
    private String afx;
    private com.baidu.tieba.frs.videomiddlepage.a.a dHA;
    private a dHV;
    private boolean dHW;
    private boolean dHX;
    private b dHz;
    private boolean drj;
    private com.baidu.tieba.frs.aggregation.a drk;
    private boolean drl;
    private ad<com.baidu.tieba.frs.aggregation.g> drm;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.drr);
        this.Po = new ArrayList();
        this.mHandler = new Handler();
        this.dHW = true;
        this.drm = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == f.g.video_container || view.getId() == f.g.video_agg_container || view.getId() == f.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.dHV != null && d.this.dHV != aVar2 && (view.getId() == f.g.video_container || view.getId() == f.g.mobile_network_play)) {
                            d.this.dHV.awe();
                        }
                        if (d.this.dHV != aVar2) {
                            d.this.dHV = aVar2;
                        }
                        if (d.this.dHV != null) {
                            d.this.dHV.gq(d.this.dHW);
                        }
                    }
                    if (view.getId() == f.g.title) {
                        an anVar = new an("c12411");
                        anVar.ae(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == f.g.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.ae(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.ae("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == f.g.thread_info_commont_container || view.getId() == f.g.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.ae(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.ae("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == f.g.user_icon || view.getId() == f.g.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.ae(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.ae("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == f.g.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.ae(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.ae("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == f.g.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.ae(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.ae("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.drk = aVar;
        this.drl = z;
        this.dHz = bVar;
        this.mFrom = str;
        this.dHA = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.afx = str2;
        this.Pp = fVar;
    }

    public void gs(boolean z) {
        this.dHX = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dHV != null) {
            this.drj = true;
            this.dHV.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.drj) {
                            d.this.drj = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.drl, this.mFrom, this.afx);
        if (this.dHA.gt(false)) {
            aVar.dHA = this.dHA;
        }
        aVar.b(this.drm);
        this.Po.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.dHX) {
            if (!this.drj) {
                aVar.ajC().a(gVar, i, this.drk);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.om();
                }
                aVar.ajC().mPosition = i;
                aVar.ajC().setOnVideoContainerForegroundClickListener(this.dHz);
            } else {
                aVar.ajC().c(gVar, i, this.drk);
            }
        }
        if (aVar.ajC() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.ajC().setCurrentPlayCallBack(this.Pp);
        }
        return aVar.getView();
    }

    public boolean oq() {
        if (this.dHV != null) {
            return this.dHV.isPlaying();
        }
        return false;
    }

    public void gq(boolean z) {
        this.dHW = z;
        if (this.dHV != null) {
            this.dHV.gq(z);
        }
    }

    public void oo() {
        if (this.dHV != null) {
            this.dHV.awd();
        }
    }

    public void op() {
        if (this.dHV != null) {
            this.dHV.awe();
        }
    }

    public void onDestroy() {
        if (this.dHA != null) {
            this.dHA.aBd();
        }
        for (a aVar : this.Po) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean kL(int i) {
        if (this.dHV == null) {
            return false;
        }
        return this.dHV.kL(i);
    }
}
