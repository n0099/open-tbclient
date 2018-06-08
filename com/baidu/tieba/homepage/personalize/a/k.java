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
import com.baidu.tbadk.core.util.ao;
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new a(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null || aVar.ajG() == null) {
            return null;
        }
        TiebaStatic.log(new am("c12884"));
        aVar.ajG().a(gVar);
        return aVar.ajG().getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.personalize.data.g> {
        private ImageView aFK;
        private String bkR;
        private TbImageView dRb;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.dRb = (TbImageView) getView().findViewById(d.g.quiz_entrance_img);
            this.dRb.setAutoChangeStyle(true);
            this.dRb.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dRb.getLayoutParams();
            layoutParams.height = (int) (com.baidu.adp.lib.util.l.e(tbPageContext.getPageActivity(), d.e.tbds236) * ((com.baidu.adp.lib.util.l.ah(tbPageContext.getPageActivity()) * 1.0f) / 1080.0f));
            this.dRb.setLayoutParams(layoutParams);
            this.dRb.setDefaultBgResource(d.f.pic_quiz_banner_default);
            this.aFK = (ImageView) getView().findViewById(d.g.close);
            this.aFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.k.a.1
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
            return d.i.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.a
        public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
            if (gVar.dRH >= 0 && gVar.dRG >= 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dRb.getLayoutParams();
                layoutParams.height = (int) (((com.baidu.adp.lib.util.l.ah(this.mTbPageContext.getPageActivity()) * 1.0f) / gVar.dRH) * gVar.dRG);
                this.dRb.setLayoutParams(layoutParams);
            }
            this.dRb.startLoad(gVar.imgUrl, 10, false);
            this.bkR = gVar.dJm;
            al.c(this.aFK, d.f.icon_live_close_n);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ao.isEmpty(this.bkR)) {
                TiebaStatic.log(new am("c12885"));
                ay.zG().c(this.mTbPageContext, new String[]{this.bkR});
            }
        }
    }
}
