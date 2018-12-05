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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        setOnAdapterItemClickListener(new n() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !ao.isEmpty(aVar.bBc)) {
                    TiebaStatic.log(new am("c12885"));
                    ay.Ef().c(k.this.mPageContext, new String[]{aVar.bBc});
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
        if (gVar == null || aVar == null || aVar.aqe() == null) {
            return null;
        }
        TiebaStatic.log(new am("c12884"));
        aVar.aqe().a(gVar);
        return aVar.aqe().getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.personalize.data.g> {
        private ImageView aSH;
        private String bBc;
        private TbImageView evX;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.evX = (TbImageView) getView().findViewById(e.g.quiz_entrance_img);
            this.evX.setAutoChangeStyle(true);
            this.evX.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evX.getLayoutParams();
            layoutParams.height = (int) (com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), e.C0210e.tbds236) * ((com.baidu.adp.lib.util.l.aO(tbPageContext.getPageActivity()) * 1.0f) / 1080.0f));
            this.evX.setLayoutParams(layoutParams);
            this.evX.setDefaultBgResource(e.f.pic_quiz_banner_default);
            this.aSH = (ImageView) getView().findViewById(e.g.close);
            this.aSH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.k.a.1
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
            return e.h.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.a
        public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
            if (gVar.ewT >= 0 && gVar.ewS >= 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evX.getLayoutParams();
                layoutParams.height = (int) (((com.baidu.adp.lib.util.l.aO(this.mTbPageContext.getPageActivity()) * 1.0f) / gVar.ewT) * gVar.ewS);
                this.evX.setLayoutParams(layoutParams);
            }
            this.evX.startLoad(gVar.imgUrl, 10, false);
            this.bBc = gVar.aou;
            al.c(this.aSH, e.f.icon_live_close_n);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
