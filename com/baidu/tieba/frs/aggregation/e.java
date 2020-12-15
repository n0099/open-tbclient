package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> aaf;
    private b jar;
    private boolean jas;
    private a jat;
    private boolean jau;
    private ab<g> jav;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.jaA);
        this.aaf = new ArrayList();
        this.mHandler = new Handler();
        this.jav = new ab<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.jar != null && e.this.jar != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.jar.cEW();
                        }
                        if (e.this.jar != bVar) {
                            e.this.jar = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ar arVar = new ar("c12411");
                        arVar.dY("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        ar arVar2 = new ar("c12414");
                        arVar2.dY("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        ar arVar3 = new ar("c12415");
                        arVar3.dY("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar3.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ar arVar4 = new ar("c12412");
                        arVar4.dY("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar4);
                    } else if (view.getId() == R.id.attention) {
                        ar arVar5 = new ar("c12413");
                        arVar5.dY("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar5.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        ar arVar6 = new ar("c12416");
                        arVar6.dY("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar6.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jat = aVar;
        this.jau = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jar != null) {
            this.jas = true;
            this.jar.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.jas) {
                            e.this.jas = false;
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
        b bVar = new b(this.mPageContext, this.jau);
        bVar.c(this.jav);
        this.aaf.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.jas) {
            aVar.csN().a(gVar, i, this.jat);
            aVar.csN().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean rz() {
        if (this.jar != null) {
            return this.jar.isPlaying();
        }
        return false;
    }

    public void rx() {
        if (this.jar != null) {
            this.jar.pauseVideo();
        }
    }

    public void ry() {
        if (this.jar != null) {
            this.jar.cEW();
        }
    }

    public void onDestroy() {
        for (b bVar : this.aaf) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean Ap(int i) {
        if (this.jar == null) {
            return false;
        }
        return this.jar.Ap(i);
    }
}
