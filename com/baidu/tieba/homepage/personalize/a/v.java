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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.g, com.baidu.tieba.card.a.a<a>> {
    TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.v.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !ap.isEmpty(aVar.cVn)) {
                    TiebaStatic.log(new am("c12885"));
                    ba.aiz().c(v.this.mPageContext, new String[]{aVar.cVn});
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
        if (gVar == null || aVar == null || aVar.aYs() == null) {
            return null;
        }
        TiebaStatic.log(new am("c12884"));
        aVar.aYs().a(gVar);
        return aVar.aYs().getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.personalize.data.g> {
        private String cVn;
        private ImageView ckr;
        private TbImageView gdj;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.gdj = (TbImageView) getView().findViewById(R.id.quiz_entrance_img);
            this.gdj.setAutoChangeStyle(true);
            this.gdj.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdj.getLayoutParams();
            layoutParams.height = (int) (com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds236) * ((com.baidu.adp.lib.util.l.af(tbPageContext.getPageActivity()) * 1.0f) / 1080.0f));
            this.gdj.setLayoutParams(layoutParams);
            this.gdj.setDefaultBgResource(R.drawable.pic_quiz_banner_default);
            this.ckr = (ImageView) getView().findViewById(R.id.close);
            this.ckr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.v.a.1
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
            return R.layout.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.a
        public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
            if (gVar.Yb >= 0 && gVar.geu >= 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdj.getLayoutParams();
                layoutParams.height = (int) (((com.baidu.adp.lib.util.l.af(this.mTbPageContext.getPageActivity()) * 1.0f) / gVar.Yb) * gVar.geu);
                this.gdj.setLayoutParams(layoutParams);
            }
            this.gdj.startLoad(gVar.imgUrl, 10, false);
            this.cVn = gVar.bCQ;
            al.c(this.ckr, (int) R.drawable.icon_live_close_n);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
