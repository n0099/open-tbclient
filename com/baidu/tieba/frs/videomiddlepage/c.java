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
    private String aMr;
    private boolean dIA;
    private v<com.baidu.tieba.frs.aggregation.f> dIB;
    private boolean dIx;
    private List<a> dIy;
    private d.a dIz;
    private a dWJ;
    private boolean dWK;
    private a.InterfaceC0159a dWj;
    private com.baidu.tieba.frs.videomiddlepage.a.a dWk;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public c(TbPageContext<?> tbPageContext, d.a aVar, a.InterfaceC0159a interfaceC0159a, boolean z, String str, String str2) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.f.dIG);
        this.dIy = new ArrayList();
        this.mHandler = new Handler();
        this.dWK = true;
        this.dIB = new v<com.baidu.tieba.frs.aggregation.f>() { // from class: com.baidu.tieba.frs.videomiddlepage.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.frs.aggregation.f fVar) {
                if (view != null && fVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (c.this.dWJ != null && c.this.dWJ != aVar2 && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            c.this.dWJ.awz();
                        }
                        if (c.this.dWJ != aVar2) {
                            c.this.dWJ = aVar2;
                        }
                        if (c.this.dWJ != null) {
                            c.this.dWJ.gw(c.this.dWK);
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
        this.dIz = aVar;
        this.dIA = z;
        this.dWj = interfaceC0159a;
        this.mFrom = str;
        this.dWk = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.aMr = str2;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dWJ != null) {
            this.dIx = true;
            this.dWJ.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.dIx) {
                            c.this.dIx = false;
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
        a aVar = new a(this.mPageContext, this.dIA, this.mFrom, this.aMr);
        if (this.dWk.gy(false)) {
            aVar.dWk = this.dWk;
        }
        aVar.b(this.dIB);
        this.dIy.add(aVar);
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
        if (!this.dIx) {
            aVar.alY().a(fVar, i, this.dIz);
            aVar.alY().mPosition = i;
            aVar.alY().a(this.dWj);
        }
        return aVar.getView();
    }

    public boolean awI() {
        if (this.dWJ != null) {
            return this.dWJ.isPlaying();
        }
        return false;
    }

    public void gw(boolean z) {
        this.dWK = z;
        if (this.dWJ != null) {
            this.dWJ.gw(z);
        }
    }

    public void awJ() {
        if (this.dWJ != null) {
            this.dWJ.awy();
        }
    }

    public void awK() {
        if (this.dWJ != null) {
            this.dWJ.awz();
        }
    }

    public void onDestroy() {
        if (this.dWk != null) {
            this.dWk.aAM();
        }
        for (a aVar : this.dIy) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean nc(int i) {
        if (this.dWJ == null) {
            return false;
        }
        return this.dWJ.nc(i);
    }
}
