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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Pp;
    private b dlG;
    private boolean dlH;
    private a dlI;
    private boolean dlJ;
    private ab<g> dlK;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.dlP);
        this.Pp = new ArrayList();
        this.mHandler = new Handler();
        this.dlK = new ab<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.dlG != null && e.this.dlG != bVar && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            e.this.dlG.auW();
                        }
                        if (e.this.dlG != bVar) {
                            e.this.dlG = bVar;
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
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dlG != null) {
            this.dlH = true;
            this.dlG.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dlH) {
                            e.this.dlH = false;
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
    public com.baidu.tieba.card.a.a<b> onCreateViewHolder(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.dlJ);
        bVar.b(this.dlK);
        this.Pp.add(bVar);
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
        if (!this.dlH) {
            aVar.ajG().a(gVar, i, this.dlI);
            aVar.ajG().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean or() {
        if (this.dlG != null) {
            return this.dlG.isPlaying();
        }
        return false;
    }

    public void op() {
        if (this.dlG != null) {
            this.dlG.auV();
        }
    }

    public void oq() {
        if (this.dlG != null) {
            this.dlG.auW();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Pp) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean ku(int i) {
        if (this.dlG == null) {
            return false;
        }
        return this.dlG.ku(i);
    }
}
