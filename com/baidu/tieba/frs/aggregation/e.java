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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Po;
    private b dri;
    private boolean drj;
    private a drk;
    private boolean drl;
    private ad<g> drm;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.drr);
        this.Po = new ArrayList();
        this.mHandler = new Handler();
        this.drm = new ad<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == f.g.video_container || view.getId() == f.g.video_agg_container || view.getId() == f.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.dri != null && e.this.dri != bVar && (view.getId() == f.g.video_container || view.getId() == f.g.mobile_network_play)) {
                            e.this.dri.awe();
                        }
                        if (e.this.dri != bVar) {
                            e.this.dri = bVar;
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
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dri != null) {
            this.drj = true;
            this.dri.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.drj) {
                            e.this.drj = false;
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
        b bVar = new b(this.mPageContext, this.drl);
        bVar.b(this.drm);
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
        if (!this.drj) {
            aVar.ajC().a(gVar, i, this.drk);
            aVar.ajC().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean oq() {
        if (this.dri != null) {
            return this.dri.isPlaying();
        }
        return false;
    }

    public void oo() {
        if (this.dri != null) {
            this.dri.awd();
        }
    }

    public void op() {
        if (this.dri != null) {
            this.dri.awe();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Po) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean kL(int i) {
        if (this.dri == null) {
            return false;
        }
        return this.dri.kL(i);
    }
}
