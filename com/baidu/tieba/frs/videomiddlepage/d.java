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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Ji;
    private com.baidu.tieba.lego.card.view.f Jj;
    private String XM;
    private boolean dbk;
    private com.baidu.tieba.frs.aggregation.a dbl;
    private boolean dbm;
    private ab<com.baidu.tieba.frs.aggregation.g> dbn;
    private a drC;
    private boolean drD;
    private boolean drE;
    private b drh;
    private com.baidu.tieba.frs.videomiddlepage.a.a dri;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dbs);
        this.Ji = new ArrayList();
        this.mHandler = new Handler();
        this.drD = true;
        this.dbn = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view2 != null && gVar != null) {
                    if ((view2.getId() == d.g.video_container || view2.getId() == d.g.video_agg_container || view2.getId() == d.g.mobile_network_play) && view2.getTag() != null && (view2.getTag() instanceof a)) {
                        a aVar2 = (a) view2.getTag();
                        if (d.this.drC != null && d.this.drC != aVar2 && (view2.getId() == d.g.video_container || view2.getId() == d.g.mobile_network_play)) {
                            d.this.drC.aqS();
                        }
                        if (d.this.drC != aVar2) {
                            d.this.drC = aVar2;
                        }
                        if (d.this.drC != null) {
                            d.this.drC.fY(d.this.drD);
                        }
                    }
                    if (view2.getId() == d.g.title) {
                        al alVar = new al("c12411");
                        alVar.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            alVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(alVar);
                    } else if (view2.getId() == d.g.agree_view_container) {
                        al alVar2 = new al("c12414");
                        alVar2.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            alVar2.ac("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(alVar2);
                    } else if (view2.getId() == d.g.thread_info_commont_container || view2.getId() == d.g.card_root_view) {
                        al alVar3 = new al("c12415");
                        alVar3.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            alVar3.ac("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(alVar3);
                    } else if (view2.getId() == d.g.user_icon || view2.getId() == d.g.user_name) {
                        al alVar4 = new al("c12412");
                        alVar4.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            alVar4.ac("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(alVar4);
                    } else if (view2.getId() == d.g.attention) {
                        al alVar5 = new al("c12413");
                        alVar5.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            alVar5.ac("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(alVar5);
                    } else if (view2.getId() == d.g.mobile_network_play) {
                        al alVar6 = new al("c12416");
                        alVar6.ac(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            alVar6.ac("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(alVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dbl = aVar;
        this.dbm = z;
        this.drh = bVar;
        this.mFrom = str;
        this.dri = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.XM = str2;
        this.Jj = fVar;
    }

    public void ga(boolean z) {
        this.drE = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.drC != null) {
            this.dbk = true;
            this.drC.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dbk) {
                            d.this.dbk = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.dbm, this.mFrom, this.XM);
        if (this.dri.gb(false)) {
            aVar.dri = this.dri;
        }
        aVar.b(this.dbn);
        this.Ji.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.drE) {
            if (!this.dbk) {
                aVar.afY().a(gVar, i, this.dbl);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.ly();
                }
                aVar.afY().mPosition = i;
                aVar.afY().setOnVideoContainerForegroundClickListener(this.drh);
            } else {
                aVar.afY().c(gVar, i, this.dbl);
            }
        }
        if (aVar.afY() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.afY().setCurrentPlayCallBack(this.Jj);
        }
        return aVar.getView();
    }

    public boolean lC() {
        if (this.drC != null) {
            return this.drC.isPlaying();
        }
        return false;
    }

    public void fY(boolean z) {
        this.drD = z;
        if (this.drC != null) {
            this.drC.fY(z);
        }
    }

    public void lA() {
        if (this.drC != null) {
            this.drC.aqR();
        }
    }

    public void lB() {
        if (this.drC != null) {
            this.drC.aqS();
        }
    }

    public void onDestroy() {
        if (this.dri != null) {
            this.dri.avI();
        }
        for (a aVar : this.Ji) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean kq(int i) {
        if (this.drC == null) {
            return false;
        }
        return this.drC.kq(i);
    }
}
