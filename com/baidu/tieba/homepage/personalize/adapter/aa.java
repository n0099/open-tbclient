package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class aa extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, CardViewHolder<a>> {
    private static final int kbT = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<a> e(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        aVar.getView().setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.aa.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !at.isEmpty(aVar.gej)) {
                    TiebaStatic.log(new aq("c12885"));
                    be.bsB().b(aa.this.mPageContext, new String[]{aVar.gej});
                }
            }
        });
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, CardViewHolder<a> cardViewHolder) {
        if (hVar == null || cardViewHolder == null || cardViewHolder.crP() == null) {
            return null;
        }
        TiebaStatic.log(new aq("c12884"));
        cardViewHolder.crP().a(hVar);
        return cardViewHolder.crP().getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.h> {
        private View eFu;
        private ImageView eFv;
        private String gej;
        private TbImageView kbW;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.kbW = (TbImageView) getView().findViewById(R.id.quiz_entrance_img);
            this.kbW.setAutoChangeStyle(true);
            this.kbW.setRadiusById(R.string.J_X06);
            this.kbW.setConrers(15);
            this.kbW.setScaleType(ImageView.ScaleType.FIT_XY);
            this.kbW.setPlaceHolder(2);
            this.eFu = getView().findViewById(R.id.close_layout);
            this.eFv = (ImageView) getView().findViewById(R.id.close);
            this.eFu.setOnClickListener(this);
            getView().setOnClickListener(this);
            WebPManager.a(this.eFv, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        private void cI(int i, int i2) {
            int i3;
            if (this.kbW != null) {
                Context context = TbadkCoreApplication.getInst().getContext();
                ViewGroup.LayoutParams layoutParams = this.kbW.getLayoutParams();
                if (context != null && layoutParams != null) {
                    int i4 = aa.kbT;
                    if (i > 0 && i2 > 0) {
                        i3 = (int) (((i4 * 1.0f) * i2) / i);
                    } else {
                        i3 = (int) (((i4 * 1.0f) * 182.0f) / 988.0f);
                    }
                    layoutParams.width = -1;
                    layoutParams.height = i3;
                    this.kbW.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // com.baidu.tieba.card.b
        public void onChangeSkinType(TbPageContext tbPageContext, int i) {
            ao.setBackgroundColor(getView(), R.color.transparent);
            WebPManager.a(this.eFv, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
        }

        @Override // com.baidu.tieba.card.b
        public int getLayout() {
            return R.layout.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.b
        public void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                cI(hVar.alz, hVar.kdm);
                this.kbW.setPlaceHolder(2);
                this.kbW.startLoad(hVar.imgUrl, 10, false);
                this.gej = hVar.aEU;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.eFu) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }
    }
}
