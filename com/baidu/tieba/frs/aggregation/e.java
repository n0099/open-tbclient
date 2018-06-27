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
    private List<b> Pr;
    private b dos;
    private boolean dot;
    private a dou;
    private boolean dov;
    private ad<g> dow;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.doB);
        this.Pr = new ArrayList();
        this.mHandler = new Handler();
        this.dow = new ad<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.dos != null && e.this.dos != bVar && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            e.this.dos.avA();
                        }
                        if (e.this.dos != bVar) {
                            e.this.dos = bVar;
                        }
                    }
                    if (view.getId() == d.g.title) {
                        an anVar = new an("c12411");
                        anVar.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == d.g.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == d.g.thread_info_commont_container || view.getId() == d.g.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == d.g.user_icon || view.getId() == d.g.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == d.g.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == d.g.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dou = aVar;
        this.dov = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dos != null) {
            this.dot = true;
            this.dos.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dot) {
                            e.this.dot = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<b> onCreateViewHolder(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.dov);
        bVar.b(this.dow);
        this.Pr.add(bVar);
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
        if (!this.dot) {
            aVar.aja().a(gVar, i, this.dou);
            aVar.aja().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean or() {
        if (this.dos != null) {
            return this.dos.isPlaying();
        }
        return false;
    }

    public void op() {
        if (this.dos != null) {
            this.dos.avz();
        }
    }

    public void oq() {
        if (this.dos != null) {
            this.dos.avA();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Pr) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean kB(int i) {
        if (this.dos == null) {
            return false;
        }
        return this.dos.kB(i);
    }
}
