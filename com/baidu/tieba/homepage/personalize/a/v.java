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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
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
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.v.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !aq.isEmpty(aVar.cWJ)) {
                    TiebaStatic.log(new an("c12885"));
                    bb.ajC().c(v.this.mPageContext, new String[]{aVar.cWJ});
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
        if (gVar == null || aVar == null || aVar.bar() == null) {
            return null;
        }
        TiebaStatic.log(new an("c12884"));
        aVar.bar().a(gVar);
        return aVar.bar().getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.personalize.data.g> {
        private String cWJ;
        private ImageView clD;
        private TbImageView gjv;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.gjv = (TbImageView) getView().findViewById(R.id.quiz_entrance_img);
            this.gjv.setAutoChangeStyle(true);
            this.gjv.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gjv.getLayoutParams();
            layoutParams.height = (int) (com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds236) * ((com.baidu.adp.lib.util.l.af(tbPageContext.getPageActivity()) * 1.0f) / 1080.0f));
            this.gjv.setLayoutParams(layoutParams);
            this.gjv.setDefaultBgResource(R.drawable.pic_quiz_banner_default);
            this.clD = (ImageView) getView().findViewById(R.id.close);
            this.clD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.v.a.1
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
            if (gVar.Yw >= 0 && gVar.gkF >= 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gjv.getLayoutParams();
                layoutParams.height = (int) (((com.baidu.adp.lib.util.l.af(this.mTbPageContext.getPageActivity()) * 1.0f) / gVar.Yw) * gVar.gkF);
                this.gjv.setLayoutParams(layoutParams);
            }
            this.gjv.startLoad(gVar.imgUrl, 10, false);
            this.cWJ = gVar.bDN;
            am.c(this.clD, (int) R.drawable.icon_live_close_n);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
