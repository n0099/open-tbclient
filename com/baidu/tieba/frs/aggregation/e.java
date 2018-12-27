package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Sj;
    private b dPZ;
    private boolean dQa;
    private a dQb;
    private boolean dQc;
    private ad<g> dQd;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.dQi);
        this.Sj = new ArrayList();
        this.mHandler = new Handler();
        this.dQd = new ad<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.dPZ != null && e.this.dPZ != bVar && (view.getId() == e.g.video_container || view.getId() == e.g.mobile_network_play)) {
                            e.this.dPZ.aDG();
                        }
                        if (e.this.dPZ != bVar) {
                            e.this.dPZ = bVar;
                        }
                    }
                    if (view.getId() == e.g.title) {
                        am amVar = new am("c12411");
                        amVar.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == e.g.thread_info_commont_container || view.getId() == e.g.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                    } else if (view.getId() == e.g.user_icon || view.getId() == e.g.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                    } else if (view.getId() == e.g.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == e.g.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dQb = aVar;
        this.dQc = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dPZ != null) {
            this.dQa = true;
            this.dPZ.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dQa) {
                            e.this.dQa = false;
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
    public com.baidu.tieba.card.a.a<b> onCreateViewHolder(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.dQc);
        bVar.b(this.dQd);
        this.Sj.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.dQa) {
            aVar.aqT().a(gVar, i, this.dQb);
            aVar.aqT().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean pB() {
        if (this.dPZ != null) {
            return this.dPZ.isPlaying();
        }
        return false;
    }

    public void pz() {
        if (this.dPZ != null) {
            this.dPZ.aDF();
        }
    }

    public void pA() {
        if (this.dPZ != null) {
            this.dPZ.aDG();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Sj) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean mH(int i) {
        if (this.dPZ == null) {
            return false;
        }
        return this.dPZ.mH(i);
    }
}
