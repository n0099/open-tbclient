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
    private List<b> Sh;
    private boolean dFA;
    private ad<g> dFB;
    private b dFx;
    private boolean dFy;
    private a dFz;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.dFG);
        this.Sh = new ArrayList();
        this.mHandler = new Handler();
        this.dFB = new ad<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.dFx != null && e.this.dFx != bVar && (view.getId() == e.g.video_container || view.getId() == e.g.mobile_network_play)) {
                            e.this.dFx.aBJ();
                        }
                        if (e.this.dFx != bVar) {
                            e.this.dFx = bVar;
                        }
                    }
                    if (view.getId() == e.g.title) {
                        am amVar = new am("c12411");
                        amVar.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == e.g.thread_info_commont_container || view.getId() == e.g.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                    } else if (view.getId() == e.g.user_icon || view.getId() == e.g.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                    } else if (view.getId() == e.g.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == e.g.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dFz = aVar;
        this.dFA = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dFx != null) {
            this.dFy = true;
            this.dFx.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dFy) {
                            e.this.dFy = false;
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
    public com.baidu.tieba.card.a.a<b> onCreateViewHolder(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.dFA);
        bVar.b(this.dFB);
        this.Sh.add(bVar);
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
        if (!this.dFy) {
            aVar.aoP().a(gVar, i, this.dFz);
            aVar.aoP().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean pE() {
        if (this.dFx != null) {
            return this.dFx.isPlaying();
        }
        return false;
    }

    public void pC() {
        if (this.dFx != null) {
            this.dFx.aBI();
        }
    }

    public void pD() {
        if (this.dFx != null) {
            this.dFx.aBJ();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Sh) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean lM(int i) {
        if (this.dFx == null) {
            return false;
        }
        return this.dFx.lM(i);
    }
}
