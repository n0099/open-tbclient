package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.g, com.baidu.tieba.card.a.a<a>> {
    TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        setOnAdapterItemClickListener(new n() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !ap.isEmpty(aVar.bmW)) {
                    TiebaStatic.log(new an("c12885"));
                    ay.zK().c(k.this.mPageContext, new String[]{aVar.bmW});
                }
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null || aVar.ajz() == null) {
            return null;
        }
        TiebaStatic.log(new an("c12884"));
        aVar.ajz().a(gVar);
        return aVar.ajz().getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.personalize.data.g> {
        private ImageView aGD;
        private String bmW;
        private TbImageView dYw;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.dYw = (TbImageView) getView().findViewById(d.g.quiz_entrance_img);
            this.dYw.setAutoChangeStyle(true);
            this.dYw.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dYw.getLayoutParams();
            layoutParams.height = (int) (com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.tbds236) * ((com.baidu.adp.lib.util.l.ah(tbPageContext.getPageActivity()) * 1.0f) / 1080.0f));
            this.dYw.setLayoutParams(layoutParams);
            this.dYw.setDefaultBgResource(d.f.pic_quiz_banner_default);
            this.aGD = (ImageView) getView().findViewById(d.g.close);
            this.aGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.k.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
                }
            });
            getView().setOnClickListener(this);
        }

        @Override // com.baidu.tieba.card.a
        public void d(TbPageContext tbPageContext, int i) {
        }

        @Override // com.baidu.tieba.card.a
        public int getLayout() {
            return d.h.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.a
        public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
            if (gVar.dZs >= 0 && gVar.dZr >= 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dYw.getLayoutParams();
                layoutParams.height = (int) (((com.baidu.adp.lib.util.l.ah(this.mTbPageContext.getPageActivity()) * 1.0f) / gVar.dZs) * gVar.dZr);
                this.dYw.setLayoutParams(layoutParams);
            }
            this.dYw.startLoad(gVar.imgUrl, 10, false);
            this.bmW = gVar.acG;
            am.c(this.aGD, d.f.icon_live_close_n);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
