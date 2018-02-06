package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.d;
import com.baidu.tieba.frs.videomiddlepage.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.f, com.baidu.tieba.card.a.a<a>> {
    private String aMB;
    private boolean dIE;
    private List<a> dIF;
    private d.a dIG;
    private boolean dIH;
    private v<com.baidu.tieba.frs.aggregation.f> dII;
    private a dWP;
    private boolean dWQ;
    private a.InterfaceC0158a dWp;
    private com.baidu.tieba.frs.videomiddlepage.a.a dWq;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public c(TbPageContext<?> tbPageContext, d.a aVar, a.InterfaceC0158a interfaceC0158a, boolean z, String str, String str2) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.f.dIN);
        this.dIF = new ArrayList();
        this.mHandler = new Handler();
        this.dWQ = true;
        this.dII = new v<com.baidu.tieba.frs.aggregation.f>() { // from class: com.baidu.tieba.frs.videomiddlepage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.frs.aggregation.f fVar) {
                if (view != null && fVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (c.this.dWP != null && c.this.dWP != aVar2 && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            c.this.dWP.awy();
                        }
                        if (c.this.dWP != aVar2) {
                            c.this.dWP = aVar2;
                        }
                        if (c.this.dWP != null) {
                            c.this.dWP.gu(c.this.dWQ);
                        }
                    }
                    if (view.getId() == d.g.title) {
                        ak akVar = new ak("c12411");
                        akVar.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(akVar);
                    } else if (view.getId() == d.g.agree_view_container) {
                        ak akVar2 = new ak("c12414");
                        akVar2.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            akVar2.ab("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(akVar2);
                    } else if (view.getId() == d.g.thread_info_commont_container || view.getId() == d.g.card_root_view) {
                        ak akVar3 = new ak("c12415");
                        akVar3.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            akVar3.ab("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(akVar3);
                    } else if (view.getId() == d.g.user_icon || view.getId() == d.g.user_name) {
                        ak akVar4 = new ak("c12412");
                        akVar4.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            akVar4.ab("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(akVar4);
                    } else if (view.getId() == d.g.attention) {
                        ak akVar5 = new ak("c12413");
                        akVar5.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            akVar5.ab("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(akVar5);
                    } else if (view.getId() == d.g.mobile_network_play) {
                        ak akVar6 = new ak("c12416");
                        akVar6.ab(ImageViewerConfig.FORUM_ID, fVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            akVar6.ab("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(akVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dIG = aVar;
        this.dIH = z;
        this.dWp = interfaceC0158a;
        this.mFrom = str;
        this.dWq = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.aMB = str2;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dWP != null) {
            this.dIE = true;
            this.dWP.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.dIE) {
                            c.this.dIE = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.dIH, this.mFrom, this.aMB);
        if (this.dWq.gw(false)) {
            aVar.dWq = this.dWq;
        }
        aVar.b(this.dII);
        this.dIF.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.f fVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (fVar == null || aVar == null) {
            return null;
        }
        if (!this.dIE) {
            aVar.alY().a(fVar, i, this.dIG);
            aVar.alY().mPosition = i;
            aVar.alY().a(this.dWp);
        }
        return aVar.getView();
    }

    public boolean awH() {
        if (this.dWP != null) {
            return this.dWP.isPlaying();
        }
        return false;
    }

    public void gu(boolean z) {
        this.dWQ = z;
        if (this.dWP != null) {
            this.dWP.gu(z);
        }
    }

    public void awI() {
        if (this.dWP != null) {
            this.dWP.awx();
        }
    }

    public void awJ() {
        if (this.dWP != null) {
            this.dWP.awy();
        }
    }

    public void onDestroy() {
        if (this.dWq != null) {
            this.dWq.aAL();
        }
        for (a aVar : this.dIF) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean nc(int i) {
        if (this.dWP == null) {
            return false;
        }
        return this.dWP.nc(i);
    }
}
