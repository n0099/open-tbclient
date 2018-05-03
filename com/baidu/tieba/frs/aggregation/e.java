package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
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
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Ji;
    private b dbj;
    private boolean dbk;
    private a dbl;
    private boolean dbm;
    private ab<g> dbn;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.dbs);
        this.Ji = new ArrayList();
        this.mHandler = new Handler();
        this.dbn = new ab<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, g gVar) {
                if (view2 != null && gVar != null) {
                    if ((view2.getId() == d.g.video_container || view2.getId() == d.g.video_agg_container || view2.getId() == d.g.mobile_network_play) && view2.getTag() != null && (view2.getTag() instanceof b)) {
                        b bVar = (b) view2.getTag();
                        if (e.this.dbj != null && e.this.dbj != bVar && (view2.getId() == d.g.video_container || view2.getId() == d.g.mobile_network_play)) {
                            e.this.dbj.aqS();
                        }
                        if (e.this.dbj != bVar) {
                            e.this.dbj = bVar;
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
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dbj != null) {
            this.dbk = true;
            this.dbj.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dbk) {
                            e.this.dbk = false;
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
        b bVar = new b(this.mPageContext, this.dbm);
        bVar.b(this.dbn);
        this.Ji.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.dbk) {
            aVar.afY().a(gVar, i, this.dbl);
            aVar.afY().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean lC() {
        if (this.dbj != null) {
            return this.dbj.isPlaying();
        }
        return false;
    }

    public void lA() {
        if (this.dbj != null) {
            this.dbj.aqR();
        }
    }

    public void lB() {
        if (this.dbj != null) {
            this.dbj.aqS();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Ji) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean kq(int i) {
        if (this.dbj == null) {
            return false;
        }
        return this.dbj.kq(i);
    }
}
