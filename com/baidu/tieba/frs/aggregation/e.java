package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends com.baidu.adp.widget.ListView.a<g, com.baidu.tieba.card.a.a<b>> {
    private List<b> XM;
    private b hMd;
    private boolean hMe;
    private a hMf;
    private boolean hMg;
    private aa<g> hMh;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.hMm);
        this.XM = new ArrayList();
        this.mHandler = new Handler();
        this.hMh = new aa<g>() { // from class: com.baidu.tieba.frs.aggregation.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof b)) {
                        b bVar = (b) view.getTag();
                        if (e.this.hMd != null && e.this.hMd != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.hMd.cef();
                        }
                        if (e.this.hMd != bVar) {
                            e.this.hMd = bVar;
                        }
                    }
                    if (view.getId() == R.id.title) {
                        ap apVar = new ap("c12411");
                        apVar.dn("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar);
                    } else if (view.getId() == R.id.agree_view_container) {
                        ap apVar2 = new ap("c12414");
                        apVar2.dn("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        ap apVar3 = new ap("c12415");
                        apVar3.dn("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar3.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar3);
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        ap apVar4 = new ap("c12412");
                        apVar4.dn("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar4.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar4);
                    } else if (view.getId() == R.id.attention) {
                        ap apVar5 = new ap("c12413");
                        apVar5.dn("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar5.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        ap apVar6 = new ap("c12416");
                        apVar6.dn("fid", gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            apVar6.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(apVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hMf = aVar;
        this.hMg = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hMd != null) {
            this.hMe = true;
            this.hMd.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.hMe) {
                            e.this.hMe = false;
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
    public com.baidu.tieba.card.a.a<b> b(ViewGroup viewGroup) {
        b bVar = new b(this.mPageContext, this.hMg);
        bVar.c(this.hMh);
        this.XM.add(bVar);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.card.a.a<b> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.hMe) {
            aVar.bSs().a(gVar, i, this.hMf);
            aVar.bSs().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean pT() {
        if (this.hMd != null) {
            return this.hMd.isPlaying();
        }
        return false;
    }

    public void pR() {
        if (this.hMd != null) {
            this.hMd.cee();
        }
    }

    public void pS() {
        if (this.hMd != null) {
            this.hMd.cef();
        }
    }

    public void onDestroy() {
        for (b bVar : this.XM) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public boolean vj(int i) {
        if (this.hMd == null) {
            return false;
        }
        return this.hMd.vj(i);
    }
}
