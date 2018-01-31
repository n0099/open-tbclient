package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaQuestionHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
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
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new a(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null || aVar.alp() == null) {
            return null;
        }
        TiebaStatic.log(new ak("c12884"));
        aVar.alp().a(gVar);
        return aVar.alp().getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.personalize.data.g> {
        private TbImageView efO;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.efO = (TbImageView) getView().findViewById(d.g.quiz_entrance_img);
            this.efO.setAutoChangeStyle(true);
            this.efO.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efO.getLayoutParams();
            layoutParams.height = (int) (com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.tbds236) * ((com.baidu.adp.lib.util.l.ao(tbPageContext.getPageActivity()) * 1.0f) / 1080.0f));
            this.efO.setLayoutParams(layoutParams);
            this.efO.setDefaultErrorResource(d.f.pic_quiz_banner_default);
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
            if (gVar.egt >= 0 && gVar.egs >= 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efO.getLayoutParams();
                layoutParams.height = (int) (((com.baidu.adp.lib.util.l.ao(this.mTbPageContext.getPageActivity()) * 1.0f) / gVar.egt) * gVar.egs);
                this.efO.setLayoutParams(layoutParams);
            }
            this.efO.startLoad(gVar.imgUrl, 10, false);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ak("c12885"));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaQuestionHomeActivityConfig(this.mTbPageContext.getPageActivity())));
        }
    }
}
