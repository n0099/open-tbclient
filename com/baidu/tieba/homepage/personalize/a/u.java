package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.g, com.baidu.tieba.card.a.a<a>> {
    TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.u.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !ap.isEmpty(aVar.cNa)) {
                    TiebaStatic.log(new am("c12885"));
                    ba.adA().c(u.this.mPageContext, new String[]{aVar.cNa});
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
        if (gVar == null || aVar == null || aVar.aRg() == null) {
            return null;
        }
        TiebaStatic.log(new am("c12884"));
        aVar.aRg().a(gVar);
        return aVar.aRg().getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.personalize.data.g> {
        private String cNa;
        private ImageView ccl;
        private TbImageView fLZ;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.fLZ = (TbImageView) getView().findViewById(d.g.quiz_entrance_img);
            this.fLZ.setAutoChangeStyle(true);
            this.fLZ.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLZ.getLayoutParams();
            layoutParams.height = (int) (com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds236) * ((com.baidu.adp.lib.util.l.aO(tbPageContext.getPageActivity()) * 1.0f) / 1080.0f));
            this.fLZ.setLayoutParams(layoutParams);
            this.fLZ.setDefaultBgResource(d.f.pic_quiz_banner_default);
            this.ccl = (ImageView) getView().findViewById(d.g.close);
            this.ccl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.u.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
                }
            });
            getView().setOnClickListener(this);
        }

        @Override // com.baidu.tieba.card.a
        public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        }

        @Override // com.baidu.tieba.card.a
        public int getLayout() {
            return d.h.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.a
        public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
            if (gVar.aam >= 0 && gVar.fNi >= 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLZ.getLayoutParams();
                layoutParams.height = (int) (((com.baidu.adp.lib.util.l.aO(this.mTbPageContext.getPageActivity()) * 1.0f) / gVar.aam) * gVar.fNi);
                this.fLZ.setLayoutParams(layoutParams);
            }
            this.fLZ.startLoad(gVar.imgUrl, 10, false);
            this.cNa = gVar.bvM;
            al.c(this.ccl, d.f.icon_live_close_n);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
