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
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Bb;
    private b fBu;
    private boolean fBv;
    private a fBw;
    private boolean fBx;
    private ab<g> fBy;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.fBD);
        this.Bb = new ArrayList();
        this.mHandler = new Handler();
        this.fBy = new ab<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.fBu != null && e.this.fBu != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fBu.bmj();
                        }
                        if (e.this.fBu != bVar) {
                            e.this.fBu = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.bS("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.bS("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.bS("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.bS("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.bS("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.bS("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fBw = aVar;
        this.fBx = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fBu != null) {
            this.fBv = true;
            this.fBu.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fBv) {
                            e.this.fBv = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<b> b(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.fBx);
        bVar.d(this.fBy);
        this.Bb.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.fBv) {
            aVar.baZ().a(gVar, i, this.fBw);
            aVar.baZ().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean kk() {
        if (this.fBu != null) {
            return this.fBu.isPlaying();
        }
        return false;
    }

    public void ki() {
        if (this.fBu != null) {
            this.fBu.bmi();
        }
    }

    public void kj() {
        if (this.fBu != null) {
            this.fBu.bmj();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Bb) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean qP(int i) {
        if (this.fBu == null) {
            return false;
        }
        return this.fBu.qP(i);
    }
}
