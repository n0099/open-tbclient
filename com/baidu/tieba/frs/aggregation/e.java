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
import com.baidu.tieba.card.holder.CardViewHolder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, CardViewHolder<b>> {
    private List<b> acc;
    private b jpB;
    private boolean jpC;
    private a jpD;
    private boolean jpE;
    private ab<g> jpF;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.jpK);
        this.acc = new ArrayList();
        this.mHandler = new Handler();
        this.jpF = new ab<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.jpB != null && e.this.jpB != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.jpB.stopVideo();
                        }
                        if (e.this.jpB != bVar) {
                            e.this.jpB = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ar arVar = new ar("c12411");
                        arVar.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        ar arVar2 = new ar("c12414");
                        arVar2.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        ar arVar3 = new ar("c12415");
                        arVar3.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ar arVar4 = new ar("c12412");
                        arVar4.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar4);
                    } else if (view.getId() == R.id.attention) {
                        ar arVar5 = new ar("c12413");
                        arVar5.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        ar arVar6 = new ar("c12416");
                        arVar6.dR("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(arVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jpD = aVar;
        this.jpE = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.jpB != null) {
            this.jpC = true;
            this.jpB.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.jpC) {
                            e.this.jpC = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<b> e(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.jpE);
        bVar.c(this.jpF);
        this.acc.add(bVar);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, CardViewHolder<b> cardViewHolder) {
        if (gVar == null || cardViewHolder == null) {
            return null;
        }
        if (!this.jpC) {
            cardViewHolder.cto().a(gVar, i, this.jpD);
            cardViewHolder.cto().mPosition = i;
        }
        return cardViewHolder.getView();
    }

    public boolean qZ() {
        if (this.jpB != null) {
            return this.jpB.isPlaying();
        }
        return false;
    }

    public void qX() {
        if (this.jpB != null) {
            this.jpB.pauseVideo();
        }
    }

    public void qY() {
        if (this.jpB != null) {
            this.jpB.stopVideo();
        }
    }

    public void onDestroy() {
        for (b bVar : this.acc) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean zg(int i) {
        if (this.jpB == null) {
            return false;
        }
        return this.jpB.zg(i);
    }
}
