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
    private List<b> RC;
    private b fCd;
    private boolean fCe;
    private a fCf;
    private boolean fCg;
    private ab<g> fCh;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.fCm);
        this.RC = new ArrayList();
        this.mHandler = new Handler();
        this.fCh = new ab<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.fCd != null && e.this.fCd != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fCd.bpe();
                        }
                        if (e.this.fCd != bVar) {
                            e.this.fCd = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.bT("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fCf = aVar;
        this.fCg = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fCd != null) {
            this.fCe = true;
            this.fCd.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fCe) {
                            e.this.fCe = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a<b> onCreateViewHolder(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.fCg);
        bVar.d(this.fCh);
        this.RC.add(bVar);
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
        if (!this.fCe) {
            aVar.baX().a(gVar, i, this.fCf);
            aVar.baX().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean pp() {
        if (this.fCd != null) {
            return this.fCd.isPlaying();
        }
        return false;
    }

    public void pn() {
        if (this.fCd != null) {
            this.fCd.bpd();
        }
    }

    public void po() {
        if (this.fCd != null) {
            this.fCd.bpe();
        }
    }

    public void onDestroy() {
        for (b bVar : this.RC) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean rW(int i) {
        if (this.fCd == null) {
            return false;
        }
        return this.fCd.rW(i);
    }
}
