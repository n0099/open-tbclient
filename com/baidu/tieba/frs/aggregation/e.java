package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Ys;
    private b iak;
    private boolean ial;
    private a iam;
    private boolean ian;
    private aa<g> iao;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.iat);
        this.Ys = new ArrayList();
        this.mHandler = new Handler();
        this.iao = new aa<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.iak != null && e.this.iak != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.iak.coJ();
                        }
                        if (e.this.iak != bVar) {
                            e.this.iak = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dD("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dD("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dD("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dD("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dD("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dD("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iam = aVar;
        this.ian = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iak != null) {
            this.ial = true;
            this.iak.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.ial) {
                            e.this.ial = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<b> b(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.ian);
        bVar.c(this.iao);
        this.Ys.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.ial) {
            aVar.ccE().a(gVar, i, this.iam);
            aVar.ccE().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean rs() {
        if (this.iak != null) {
            return this.iak.isPlaying();
        }
        return false;
    }

    public void rq() {
        if (this.iak != null) {
            this.iak.coI();
        }
    }

    public void rr() {
        if (this.iak != null) {
            this.iak.coJ();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Ys) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean xB(int i) {
        if (this.iak == null) {
            return false;
        }
        return this.iak.xB(i);
    }
}
