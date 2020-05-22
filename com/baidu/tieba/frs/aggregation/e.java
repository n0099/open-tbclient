package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Xq;
    private b htg;
    private boolean hth;
    private a hti;
    private boolean htj;
    private aa<g> htk;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.htp);
        this.Xq = new ArrayList();
        this.mHandler = new Handler();
        this.htk = new aa<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.htg != null && e.this.htg != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.htg.bXt();
                        }
                        if (e.this.htg != bVar) {
                            e.this.htg = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.dh("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.dh("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.dh("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.dh("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.dh("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.dh("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hti = aVar;
        this.htj = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.htg != null) {
            this.hth = true;
            this.htg.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hth) {
                            e.this.hth = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<b> b(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.htj);
        bVar.c(this.htk);
        this.Xq.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.hth) {
            aVar.bLU().a(gVar, i, this.hti);
            aVar.bLU().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean pB() {
        if (this.htg != null) {
            return this.htg.isPlaying();
        }
        return false;
    }

    public void pz() {
        if (this.htg != null) {
            this.htg.bXs();
        }
    }

    public void pA() {
        if (this.htg != null) {
            this.htg.bXt();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Xq) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean uk(int i) {
        if (this.htg == null) {
            return false;
        }
        return this.htg.uk(i);
    }
}
