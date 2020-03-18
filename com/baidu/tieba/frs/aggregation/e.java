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
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> DE;
    private b gvb;
    private boolean gvc;
    private a gvd;
    private boolean gve;
    private z<g> gvf;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.gvk);
        this.DE = new ArrayList();
        this.mHandler = new Handler();
        this.gvf = new z<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.gvb != null && e.this.gvb != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.gvb.bGx();
                        }
                        if (e.this.gvb != bVar) {
                            e.this.gvb = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cx("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.cx("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.cx("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cx("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.cx("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.cx("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gvd = aVar;
        this.gve = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.gvb != null) {
            this.gvc = true;
            this.gvb.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.gvc) {
                            e.this.gvc = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public com.baidu.tieba.card.a.a<b> b(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.gve);
        bVar.c(this.gvf);
        this.DE.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.gvc) {
            aVar.bvQ().a(gVar, i, this.gvd);
            aVar.bvQ().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean kR() {
        if (this.gvb != null) {
            return this.gvb.isPlaying();
        }
        return false;
    }

    public void kP() {
        if (this.gvb != null) {
            this.gvb.bGw();
        }
    }

    public void kQ() {
        if (this.gvb != null) {
            this.gvb.bGx();
        }
    }

    public void onDestroy() {
        for (b bVar : this.DE) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean th(int i) {
        if (this.gvb == null) {
            return false;
        }
        return this.gvb.th(i);
    }
}
