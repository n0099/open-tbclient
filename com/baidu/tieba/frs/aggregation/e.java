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
    private b gul;
    private boolean gum;
    private a gun;
    private boolean guo;
    private z<g> gup;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.guu);
        this.DE = new ArrayList();
        this.mHandler = new Handler();
        this.gup = new z<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.gul != null && e.this.gul != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.gul.bGk();
                        }
                        if (e.this.gul != bVar) {
                            e.this.gul = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cy("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.cy("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.cy("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cy("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.cy("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.cy("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.cy("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gun = aVar;
        this.guo = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.gul != null) {
            this.gum = true;
            this.gul.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.gum) {
                            e.this.gum = false;
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
        b bVar = new b(this.mPageContext, this.guo);
        bVar.c(this.gup);
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
        if (!this.gum) {
            aVar.bvK().a(gVar, i, this.gun);
            aVar.bvK().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean kR() {
        if (this.gul != null) {
            return this.gul.isPlaying();
        }
        return false;
    }

    public void kP() {
        if (this.gul != null) {
            this.gul.bGj();
        }
    }

    public void kQ() {
        if (this.gul != null) {
            this.gul.bGk();
        }
    }

    public void onDestroy() {
        for (b bVar : this.DE) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean tf(int i) {
        if (this.gul == null) {
            return false;
        }
        return this.gul.tf(i);
    }
}
