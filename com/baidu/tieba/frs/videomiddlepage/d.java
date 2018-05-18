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
    private List<a> Je;
    private com.baidu.tieba.lego.card.view.f Jf;
    private String XN;
    private boolean dcr;
    private com.baidu.tieba.frs.aggregation.a dcs;
    private boolean dct;
    private ab<com.baidu.tieba.frs.aggregation.g> dcv;
    private a dsK;
    private boolean dsL;
    private boolean dsM;
    private b dsp;
    private com.baidu.tieba.frs.videomiddlepage.a.a dsq;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dcA);
        this.Je = new ArrayList();
        this.mHandler = new Handler();
        this.dsL = true;
        this.dcv = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view2 != null && gVar != null) {
                    if ((view2.getId() == d.g.video_container || view2.getId() == d.g.video_agg_container || view2.getId() == d.g.mobile_network_play) && view2.getTag() != null && (view2.getTag() instanceof a)) {
                        a aVar2 = (a) view2.getTag();
                        if (d.this.dsK != null && d.this.dsK != aVar2 && (view2.getId() == d.g.video_container || view2.getId() == d.g.mobile_network_play)) {
                            d.this.dsK.aqR();
                        }
                        if (d.this.dsK != aVar2) {
                            d.this.dsK = aVar2;
                        }
                        if (d.this.dsK != null) {
                            d.this.dsK.fZ(d.this.dsL);
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
        this.dcs = aVar;
        this.dct = z;
        this.dsp = bVar;
        this.mFrom = str;
        this.dsq = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.XN = str2;
        this.Jf = fVar;
    }

    public void gb(boolean z) {
        this.dsM = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dsK != null) {
            this.dcr = true;
            this.dsK.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dcr) {
                            d.this.dcr = false;
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
        a aVar = new a(this.mPageContext, this.dct, this.mFrom, this.XN);
        if (this.dsq.gc(false)) {
            aVar.dsq = this.dsq;
        }
        aVar.b(this.dcv);
        this.Je.add(aVar);
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
        if (!this.dsM) {
            if (!this.dcr) {
                aVar.afY().a(gVar, i, this.dcs);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.lx();
                }
                aVar.afY().mPosition = i;
                aVar.afY().setOnVideoContainerForegroundClickListener(this.dsp);
            } else {
                aVar.afY().c(gVar, i, this.dcs);
            }
        }
        if (aVar.afY() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.afY().setCurrentPlayCallBack(this.Jf);
        }
        return aVar.getView();
    }

    public boolean lB() {
        if (this.dsK != null) {
            return this.dsK.isPlaying();
        }
        return false;
    }

    public void fZ(boolean z) {
        this.dsL = z;
        if (this.dsK != null) {
            this.dsK.fZ(z);
        }
    }

    public void lz() {
        if (this.dsK != null) {
            this.dsK.aqQ();
        }
    }

    public void lA() {
        if (this.dsK != null) {
            this.dsK.aqR();
        }
    }

    public void onDestroy() {
        if (this.dsq != null) {
            this.dsq.avH();
        }
        for (a aVar : this.Je) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean kp(int i) {
        if (this.dsK == null) {
            return false;
        }
        return this.dsK.kp(i);
    }
}
