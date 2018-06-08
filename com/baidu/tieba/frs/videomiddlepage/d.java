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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Pp;
    private com.baidu.tieba.lego.card.view.f Pq;
    private String afO;
    private b dBC;
    private com.baidu.tieba.frs.videomiddlepage.a.a dBD;
    private a dBX;
    private boolean dBY;
    private boolean dBZ;
    private boolean dlH;
    private com.baidu.tieba.frs.aggregation.a dlI;
    private boolean dlJ;
    private ab<com.baidu.tieba.frs.aggregation.g> dlK;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dlP);
        this.Pp = new ArrayList();
        this.mHandler = new Handler();
        this.dBY = true;
        this.dlK = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.dBX != null && d.this.dBX != aVar2 && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            d.this.dBX.auW();
                        }
                        if (d.this.dBX != aVar2) {
                            d.this.dBX = aVar2;
                        }
                        if (d.this.dBX != null) {
                            d.this.dBX.ge(d.this.dBY);
                        }
                    }
                    if (view.getId() == d.g.title) {
                        am amVar = new am("c12411");
                        amVar.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == d.g.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == d.g.thread_info_commont_container || view.getId() == d.g.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                    } else if (view.getId() == d.g.user_icon || view.getId() == d.g.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                    } else if (view.getId() == d.g.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == d.g.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dlI = aVar;
        this.dlJ = z;
        this.dBC = bVar;
        this.mFrom = str;
        this.dBD = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.afO = str2;
        this.Pq = fVar;
    }

    public void gg(boolean z) {
        this.dBZ = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dBX != null) {
            this.dlH = true;
            this.dBX.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dlH) {
                            d.this.dlH = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.dlJ, this.mFrom, this.afO);
        if (this.dBD.gh(false)) {
            aVar.dBD = this.dBD;
        }
        aVar.b(this.dlK);
        this.Pp.add(aVar);
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
        if (!this.dBZ) {
            if (!this.dlH) {
                aVar.ajG().a(gVar, i, this.dlI);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.on();
                }
                aVar.ajG().mPosition = i;
                aVar.ajG().setOnVideoContainerForegroundClickListener(this.dBC);
            } else {
                aVar.ajG().c(gVar, i, this.dlI);
            }
        }
        if (aVar.ajG() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.ajG().setCurrentPlayCallBack(this.Pq);
        }
        return aVar.getView();
    }

    public boolean or() {
        if (this.dBX != null) {
            return this.dBX.isPlaying();
        }
        return false;
    }

    public void ge(boolean z) {
        this.dBY = z;
        if (this.dBX != null) {
            this.dBX.ge(z);
        }
    }

    public void op() {
        if (this.dBX != null) {
            this.dBX.auV();
        }
    }

    public void oq() {
        if (this.dBX != null) {
            this.dBX.auW();
        }
    }

    public void onDestroy() {
        if (this.dBD != null) {
            this.dBD.azQ();
        }
        for (a aVar : this.Pp) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean ku(int i) {
        if (this.dBX == null) {
            return false;
        }
        return this.dBX.ku(i);
    }
}
