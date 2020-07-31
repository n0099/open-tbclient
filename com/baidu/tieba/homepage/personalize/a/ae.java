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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
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
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.ae.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !as.isEmpty(aVar.fcs)) {
                    TiebaStatic.log(new ap("c12885"));
                    bd.baV().b(ae.this.mPageContext, new String[]{aVar.fcs});
                }
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (hVar == null || aVar == null || aVar.bSs() == null) {
            return null;
        }
        TiebaStatic.log(new ap("c12884"));
        aVar.bSs().a(hVar);
        return aVar.bSs().getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.h> {
        private View dJu;
        private ImageView dJv;
        private String fcs;
        private TbImageView izL;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
            getView().setPadding(dimens, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21), dimens, 0);
            this.izL = (TbImageView) getView().findViewById(R.id.quiz_entrance_img);
            this.izL.setAutoChangeStyle(true);
            this.izL.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
            this.izL.setConrers(15);
            this.izL.setScaleType(ImageView.ScaleType.FIT_XY);
            this.izL.setPlaceHolder(2);
            this.dJu = getView().findViewById(R.id.close_layout);
            this.dJv = (ImageView) getView().findViewById(R.id.close);
            this.dJu.setOnClickListener(this);
            getView().setOnClickListener(this);
            ao.setImageResource(this.dJv, R.drawable.pic_home_ad_delete16);
            onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        private void cr(int i, int i2) {
            int i3;
            if (this.izL != null) {
                Context context = TbadkCoreApplication.getInst().getContext();
                ViewGroup.LayoutParams layoutParams = this.izL.getLayoutParams();
                if (context != null && layoutParams != null) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2);
                    if (i > 0 && i2 > 0) {
                        i3 = (int) (((equipmentWidth * 1.0f) * i2) / i);
                    } else {
                        i3 = (int) (((equipmentWidth * 1.0f) * 182.0f) / 988.0f);
                    }
                    layoutParams.width = -1;
                    layoutParams.height = i3;
                    this.izL.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // com.baidu.tieba.card.b
        public void onChangeSkinType(TbPageContext tbPageContext, int i) {
            ao.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        }

        @Override // com.baidu.tieba.card.b
        public int getLayout() {
            return R.layout.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.b
        public void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                cr(hVar.aiy, hVar.iBb);
                this.izL.setPlaceHolder(2);
                this.izL.startLoad(hVar.imgUrl, 10, false);
                this.fcs = hVar.aye;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.dJu) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }
    }
}
