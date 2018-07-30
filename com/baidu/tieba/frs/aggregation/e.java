package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Po;
    private b drl;
    private boolean drm;
    private a drn;
    private boolean dro;
    private ad<g> drp;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.dru);
        this.Po = new ArrayList();
        this.mHandler = new Handler();
        this.drp = new ad<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.drl != null && e.this.drl != bVar && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            e.this.drl.awf();
                        }
                        if (e.this.drl != bVar) {
                            e.this.drl = bVar;
                        }
                    }
                    if (view.getId() == d.g.title) {
                        an anVar = new an("c12411");
                        anVar.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == d.g.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == d.g.thread_info_commont_container || view.getId() == d.g.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == d.g.user_icon || view.getId() == d.g.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == d.g.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == d.g.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.drn = aVar;
        this.dro = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.drl != null) {
            this.drm = true;
            this.drl.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.drm) {
                            e.this.drm = false;
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
        b bVar = new b(this.mPageContext, this.dro);
        bVar.b(this.drp);
        this.Po.add(bVar);
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
        if (!this.drm) {
            aVar.ajz().a(gVar, i, this.drn);
            aVar.ajz().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean ot() {
        if (this.drl != null) {
            return this.drl.isPlaying();
        }
        return false;
    }

    public void or() {
        if (this.drl != null) {
            this.drl.awe();
        }
    }

    public void os() {
        if (this.drl != null) {
            this.drl.awf();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Po) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean kM(int i) {
        if (this.drl == null) {
            return false;
        }
        return this.drl.kM(i);
    }
}
