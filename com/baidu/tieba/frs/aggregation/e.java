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
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Ze;
    private b iOL;
    private boolean iOM;
    private a iON;
    private boolean iOO;
    private ab<g> iOP;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.iOU);
        this.Ze = new ArrayList();
        this.mHandler = new Handler();
        this.iOP = new ab<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.iOL != null && e.this.iOL != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.iOL.cBc();
                        }
                        if (e.this.iOL != bVar) {
                            e.this.iOL = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iON = aVar;
        this.iOO = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.iOL != null) {
            this.iOM = true;
            this.iOL.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.iOM) {
                            e.this.iOM = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<b> c(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.iOO);
        bVar.c(this.iOP);
        this.Ze.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.iOM) {
            aVar.coY().a(gVar, i, this.iON);
            aVar.coY().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean rx() {
        if (this.iOL != null) {
            return this.iOL.isPlaying();
        }
        return false;
    }

    public void rv() {
        if (this.iOL != null) {
            this.iOL.pauseVideo();
        }
    }

    public void rw() {
        if (this.iOL != null) {
            this.iOL.cBc();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Ze) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean zm(int i) {
        if (this.iOL == null) {
            return false;
        }
        return this.iOL.zm(i);
    }
}
