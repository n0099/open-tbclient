package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> XU;
    private b hGh;
    private boolean hGi;
    private a hGj;
    private boolean hGk;
    private aa<g> hGl;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.hGq);
        this.XU = new ArrayList();
        this.mHandler = new Handler();
        this.hGl = new aa<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.hGh != null && e.this.hGh != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.hGh.caG();
                        }
                        if (e.this.hGh != bVar) {
                            e.this.hGh = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ao aoVar = new ao("c12411");
                        aoVar.dk("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        ao aoVar2 = new ao("c12414");
                        aoVar2.dk("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        ao aoVar3 = new ao("c12415");
                        aoVar3.dk("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar3.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ao aoVar4 = new ao("c12412");
                        aoVar4.dk("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar4.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar4);
                    } else if (view.getId() == R.id.attention) {
                        ao aoVar5 = new ao("c12413");
                        aoVar5.dk("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar5.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        ao aoVar6 = new ao("c12416");
                        aoVar6.dk("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aoVar6.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aoVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hGj = aVar;
        this.hGk = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hGh != null) {
            this.hGi = true;
            this.hGh.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hGi) {
                            e.this.hGi = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<b> b(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.hGk);
        bVar.c(this.hGl);
        this.XU.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.hGi) {
            aVar.bPg().a(gVar, i, this.hGj);
            aVar.bPg().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean pS() {
        if (this.hGh != null) {
            return this.hGh.isPlaying();
        }
        return false;
    }

    public void pQ() {
        if (this.hGh != null) {
            this.hGh.caF();
        }
    }

    public void pR() {
        if (this.hGh != null) {
            this.hGh.caG();
        }
    }

    public void onDestroy() {
        for (b bVar : this.XU) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean uR(int i) {
        if (this.hGh == null) {
            return false;
        }
        return this.hGh.uR(i);
    }
}
