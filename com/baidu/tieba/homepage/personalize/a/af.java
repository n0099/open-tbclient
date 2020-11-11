package com.baidu.tieba.homepage.personalize.a;

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class af extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, com.baidu.tieba.card.a.a<a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public af(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.af.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !at.isEmpty(aVar.fRs)) {
                    TiebaStatic.log(new aq("c12885"));
                    be.brr().b(af.this.mPageContext, new String[]{aVar.fRs});
                }
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (hVar == null || aVar == null || aVar.coY() == null) {
            return null;
        }
        TiebaStatic.log(new aq("c12884"));
        aVar.coY().a(hVar);
        return aVar.coY().getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.h> {
        private View evj;
        private ImageView evk;
        private String fRs;
        private TbImageView jEM;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
            getView().setPadding(dimens, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21), dimens, 0);
            this.jEM = (TbImageView) getView().findViewById(R.id.quiz_entrance_img);
            this.jEM.setAutoChangeStyle(true);
            this.jEM.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
            this.jEM.setConrers(15);
            this.jEM.setScaleType(ImageView.ScaleType.FIT_XY);
            this.jEM.setPlaceHolder(2);
            this.evj = getView().findViewById(R.id.close_layout);
            this.evk = (ImageView) getView().findViewById(R.id.close);
            this.evj.setOnClickListener(this);
            getView().setOnClickListener(this);
            ap.setImageResource(this.evk, R.drawable.pic_home_ad_delete16);
            onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        private void cG(int i, int i2) {
            int i3;
            if (this.jEM != null) {
                Context context = TbadkCoreApplication.getInst().getContext();
                ViewGroup.LayoutParams layoutParams = this.jEM.getLayoutParams();
                if (context != null && layoutParams != null) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2);
                    if (i > 0 && i2 > 0) {
                        i3 = (int) (((equipmentWidth * 1.0f) * i2) / i);
                    } else {
                        i3 = (int) (((equipmentWidth * 1.0f) * 182.0f) / 988.0f);
                    }
                    layoutParams.width = -1;
                    layoutParams.height = i3;
                    this.jEM.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // com.baidu.tieba.card.b
        public void onChangeSkinType(TbPageContext tbPageContext, int i) {
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        }

        @Override // com.baidu.tieba.card.b
        public int getLayout() {
            return R.layout.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.b
        public void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                cG(hVar.akJ, hVar.jGd);
                this.jEM.setPlaceHolder(2);
                this.jEM.startLoad(hVar.imgUrl, 10, false);
                this.fRs = hVar.aIk;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.evj) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }
    }
}
