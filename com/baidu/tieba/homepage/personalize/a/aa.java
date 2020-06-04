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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class aa extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.g, com.baidu.tieba.card.a.a<a>> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public aa(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.aa.1
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (view != null && aVar != null && !aq.isEmpty(aVar.eNF)) {
                    TiebaStatic.log(new an("c12885"));
                    ba.aVa().b(aa.this.mPageContext, new String[]{aVar.eNF});
                }
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null || aVar.bLW() == null) {
            return null;
        }
        TiebaStatic.log(new an("c12884"));
        aVar.bLW().a(gVar);
        return aVar.bLW().getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.g> {
        private View dyr;
        private ImageView dys;
        private String eNF;
        private TbImageView ieA;

        public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
            getView().setPadding(dimens, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21), dimens, 0);
            this.ieA = (TbImageView) getView().findViewById(R.id.quiz_entrance_img);
            this.ieA.setAutoChangeStyle(true);
            this.ieA.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
            this.ieA.setConrers(15);
            this.ieA.setScaleType(ImageView.ScaleType.FIT_XY);
            this.ieA.setPlaceHolder(2);
            this.dyr = getView().findViewById(R.id.close_layout);
            this.dys = (ImageView) getView().findViewById(R.id.close);
            this.dyr.setOnClickListener(this);
            getView().setOnClickListener(this);
            am.setImageResource(this.dys, R.drawable.pic_home_ad_delete16);
            onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        private void ci(int i, int i2) {
            int i3;
            if (this.ieA != null) {
                Context context = TbadkCoreApplication.getInst().getContext();
                ViewGroup.LayoutParams layoutParams = this.ieA.getLayoutParams();
                if (context != null && layoutParams != null) {
                    int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(context) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44) * 2);
                    if (i > 0 && i2 > 0) {
                        i3 = (int) (((equipmentWidth * 1.0f) * i2) / i);
                    } else {
                        i3 = (int) (((equipmentWidth * 1.0f) * 182.0f) / 988.0f);
                    }
                    layoutParams.width = -1;
                    layoutParams.height = i3;
                    this.ieA.setLayoutParams(layoutParams);
                }
            }
        }

        @Override // com.baidu.tieba.card.b
        public void onChangeSkinType(TbPageContext tbPageContext, int i) {
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        }

        @Override // com.baidu.tieba.card.b
        public int getLayout() {
            return R.layout.card_quiz_entrance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.b
        public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
            if (gVar != null) {
                ci(gVar.ahw, gVar.ifM);
                this.ieA.setPlaceHolder(2);
                this.ieA.startLoad(gVar.imgUrl, 10, false);
                this.eNF = gVar.auL;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.dyr) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }
    }
}
