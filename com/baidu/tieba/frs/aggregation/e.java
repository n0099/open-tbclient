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
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> YM;
    private b ihv;
    private boolean ihw;
    private a ihx;
    private boolean ihy;
    private aa<g> ihz;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.ihE);
        this.YM = new ArrayList();
        this.mHandler = new Handler();
        this.ihz = new aa<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.ihv != null && e.this.ihv != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.ihv.crX();
                        }
                        if (e.this.ihv != bVar) {
                            e.this.ihv = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dF("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dF("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dF("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dF("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dF("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dF("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ihx = aVar;
        this.ihy = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.ihv != null) {
            this.ihw = true;
            this.ihv.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.ihw) {
                            e.this.ihw = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<b> c(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.ihy);
        bVar.c(this.ihz);
        this.YM.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.ihw) {
            aVar.cfU().a(gVar, i, this.ihx);
            aVar.cfU().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean rx() {
        if (this.ihv != null) {
            return this.ihv.isPlaying();
        }
        return false;
    }

    public void rv() {
        if (this.ihv != null) {
            this.ihv.crW();
        }
    }

    public void rw() {
        if (this.ihv != null) {
            this.ihv.crX();
        }
    }

    public void onDestroy() {
        for (b bVar : this.YM) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean ya(int i) {
        if (this.ihv == null) {
            return false;
        }
        return this.ihv.ya(i);
    }
}
