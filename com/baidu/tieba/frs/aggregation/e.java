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
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Dk;
    private b gsi;
    private boolean gsj;
    private a gsk;
    private boolean gsl;
    private z<g> gsm;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.gsr);
        this.Dk = new ArrayList();
        this.mHandler = new Handler();
        this.gsm = new z<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.gsi != null && e.this.gsi != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.gsi.bEG();
                        }
                        if (e.this.gsi != bVar) {
                            e.this.gsi = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cp("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.cp("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.cp("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cp("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.cp("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.cp("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gsk = aVar;
        this.gsl = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.gsi != null) {
            this.gsj = true;
            this.gsi.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.gsj) {
                            e.this.gsj = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<b> b(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.gsl);
        bVar.c(this.gsm);
        this.Dk.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.gsj) {
            aVar.bue().a(gVar, i, this.gsk);
            aVar.bue().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean kC() {
        if (this.gsi != null) {
            return this.gsi.isPlaying();
        }
        return false;
    }

    public void kA() {
        if (this.gsi != null) {
            this.gsi.bEF();
        }
    }

    public void kB() {
        if (this.gsi != null) {
            this.gsi.bEG();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Dk) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean sZ(int i) {
        if (this.gsi == null) {
            return false;
        }
        return this.gsi.sZ(i);
    }
}
