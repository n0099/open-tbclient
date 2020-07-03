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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ae extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, com.baidu.tieba.card.a.a<a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public ae(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.ae.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !ar.isEmpty(aVar.eXQ)) {
                    TiebaStatic.log(new ao("c12885"));
                    bc.aWU().b(ae.this.mPageContext, new String[]{aVar.eXQ});
                }
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (hVar == null || aVar == null || aVar.bPg() == null) {
            return null;
        }
        TiebaStatic.log(new ao("c12884"));
        aVar.bPg().a(hVar);
        return aVar.bPg().getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.h> {
        private View dDx;
        private ImageView dDy;
        private String eXQ;
        private TbImageView itH;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
            getView().setPadding(dimens, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21), dimens, 0);
            this.itH = (TbImageView) getView().findViewById(R.id.quiz_entrance_img);
            this.itH.setAutoChangeStyle(true);
            this.itH.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
            this.itH.setConrers(15);
            this.itH.setScaleType(ImageView.ScaleType.FIT_XY);
            this.itH.setPlaceHolder(2);
            this.dDx = getView().findViewById(R.id.close_layout);
            this.dDy = (ImageView) getView().findViewById(R.id.close);
            this.dDx.setOnClickListener(this);
            getView().setOnClickListener(this);
            an.setImageResource(this.dDy, R.drawable.pic_home_ad_delete16);
            onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        private void co(int i, int i2) {
            int i3;
            if (this.itH != null) {
                Context context = TbadkCoreApplication.getInst().getContext();
                ViewGroup.LayoutParams layoutParams = this.itH.getLayoutParams();
                if (context != null && layoutParams != null) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2);
                    if (i > 0 && i2 > 0) {
                        i3 = (int) (((equipmentWidth * 1.0f) * i2) / i);
                    } else {
                        i3 = (int) (((equipmentWidth * 1.0f) * 182.0f) / 988.0f);
                    }
                    layoutParams.width = -1;
                    layoutParams.height = i3;
                    this.itH.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // com.baidu.tieba.card.b
        public void onChangeSkinType(TbPageContext tbPageContext, int i) {
            an.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        }

        @Override // com.baidu.tieba.card.b
        public int getLayout() {
            return R.layout.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.b
        public void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                co(hVar.aiG, hVar.iuX);
                this.itH.setPlaceHolder(2);
                this.itH.startLoad(hVar.imgUrl, 10, false);
                this.eXQ = hVar.awR;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.dDx) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }
    }
}
