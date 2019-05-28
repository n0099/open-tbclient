package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> Rm;
    private b fuG;
    private boolean fuH;
    private a fuI;
    private boolean fuJ;
    private ab<g> fuK;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.fuP);
        this.Rm = new ArrayList();
        this.mHandler = new Handler();
        this.fuK = new ab<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.fuG != null && e.this.fuG != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fuG.bmf();
                        }
                        if (e.this.fuG != bVar) {
                            e.this.fuG = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        am amVar = new am("c12411");
                        amVar.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                    } else if (view.getId() == R.id.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fuI = aVar;
        this.fuJ = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fuG != null) {
            this.fuH = true;
            this.fuG.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fuH) {
                            e.this.fuH = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<b> onCreateViewHolder(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.fuJ);
        bVar.d(this.fuK);
        this.Rm.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.fuH) {
            aVar.aYs().a(gVar, i, this.fuI);
            aVar.aYs().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean oT() {
        if (this.fuG != null) {
            return this.fuG.isPlaying();
        }
        return false;
    }

    public void oR() {
        if (this.fuG != null) {
            this.fuG.bme();
        }
    }

    public void oS() {
        if (this.fuG != null) {
            this.fuG.bmf();
        }
    }

    public void onDestroy() {
        for (b bVar : this.Rm) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean rz(int i) {
        if (this.fuG == null) {
            return false;
        }
        return this.fuG.rz(i);
    }
}
