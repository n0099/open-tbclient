package com.baidu.tieba.frs.aggregation;

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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<f, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.aggregation.a>> {
    private com.baidu.tieba.frs.aggregation.a dIr;
    private boolean dIs;
    private List<com.baidu.tieba.frs.aggregation.a> dIt;
    private a dIu;
    private boolean dIv;
    private v<f> dIw;
    private Handler mHandler;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void cancel();

        void nd(int i);
    }

    public d(TbPageContext<?> tbPageContext, a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), f.dIB);
        this.dIt = new ArrayList();
        this.mHandler = new Handler();
        this.dIw = new v<f>() { // from class: com.baidu.tieba.frs.aggregation.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, f fVar) {
                if (view != null && fVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.frs.aggregation.a)) {
                        com.baidu.tieba.frs.aggregation.a aVar2 = (com.baidu.tieba.frs.aggregation.a) view.getTag();
                        if (d.this.dIr != null && d.this.dIr != aVar2 && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            d.this.dIr.awx();
                        }
                        if (d.this.dIr != aVar2) {
                            d.this.dIr = aVar2;
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
        this.dIu = aVar;
        this.dIv = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dIr != null) {
            this.dIs = true;
            this.dIr.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.aggregation.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dIs) {
                            d.this.dIs = false;
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.aggregation.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.aggregation.a aVar = new com.baidu.tieba.frs.aggregation.a(this.mPageContext, this.dIv);
        aVar.b(this.dIw);
        this.dIt.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.aggregation.a> aVar) {
        if (fVar == null || aVar == null) {
            return null;
        }
        if (!this.dIs) {
            aVar.alX().a(fVar, i, this.dIu);
            aVar.alX().mPosition = i;
        }
        return aVar.getView();
    }

    public boolean awG() {
        if (this.dIr != null) {
            return this.dIr.isPlaying();
        }
        return false;
    }

    public void awH() {
        if (this.dIr != null) {
            this.dIr.aww();
        }
    }

    public void awI() {
        if (this.dIr != null) {
            this.dIr.awx();
        }
    }

    public void onDestroy() {
        for (com.baidu.tieba.frs.aggregation.a aVar : this.dIt) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean nc(int i) {
        if (this.dIr == null) {
            return false;
        }
        return this.dIr.nc(i);
    }
}
