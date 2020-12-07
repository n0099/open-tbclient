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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ae extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, com.baidu.tieba.card.a.a<a>> {
    private static final int jTm = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
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
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        if (com.baidu.tbadk.a.d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            aVar.getView().setPadding(dimenPixelSize2, dimenPixelSize, dimenPixelSize2, dimenPixelSize);
        } else {
            aVar.getView().setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
        }
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.ae.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !au.isEmpty(aVar.fZj)) {
                    TiebaStatic.log(new ar("c12885"));
                    bf.bua().b(ae.this.mPageContext, new String[]{aVar.fZj});
                }
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (hVar == null || aVar == null || aVar.csM() == null) {
            return null;
        }
        TiebaStatic.log(new ar("c12884"));
        aVar.csM().a(hVar);
        return aVar.csM().getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.h> {
        private View eAC;
        private ImageView eAD;
        private String fZj;
        private TbImageView jTp;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.jTp = (TbImageView) getView().findViewById(R.id.quiz_entrance_img);
            this.jTp.setAutoChangeStyle(true);
            this.jTp.setRadiusById(R.string.J_X06);
            this.jTp.setConrers(15);
            this.jTp.setScaleType(ImageView.ScaleType.FIT_XY);
            this.jTp.setPlaceHolder(2);
            this.eAC = getView().findViewById(R.id.close_layout);
            this.eAD = (ImageView) getView().findViewById(R.id.close);
            this.eAC.setOnClickListener(this);
            getView().setOnClickListener(this);
            WebPManager.a(this.eAD, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        private void cL(int i, int i2) {
            int i3;
            if (this.jTp != null) {
                Context context = TbadkCoreApplication.getInst().getContext();
                ViewGroup.LayoutParams layoutParams = this.jTp.getLayoutParams();
                if (context != null && layoutParams != null) {
                    int i4 = ae.jTm;
                    if (i > 0 && i2 > 0) {
                        i3 = (int) (((i4 * 1.0f) * i2) / i);
                    } else {
                        i3 = (int) (((i4 * 1.0f) * 182.0f) / 988.0f);
                    }
                    layoutParams.width = -1;
                    layoutParams.height = i3;
                    this.jTp.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // com.baidu.tieba.card.b
        public void onChangeSkinType(TbPageContext tbPageContext, int i) {
            if (com.baidu.tbadk.a.d.bkA()) {
                ap.setBackgroundColor(getView(), R.color.CAM_X0205);
            } else {
                ap.setBackgroundColor(getView(), R.color.transparent);
            }
            WebPManager.a(this.eAD, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
        }

        @Override // com.baidu.tieba.card.b
        public int getLayout() {
            return R.layout.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.b
        public void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                cL(hVar.alO, hVar.jUF);
                this.jTp.setPlaceHolder(2);
                this.jTp.startLoad(hVar.imgUrl, 10, false);
                this.fZj = hVar.aJj;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.eAC) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }
    }
}
