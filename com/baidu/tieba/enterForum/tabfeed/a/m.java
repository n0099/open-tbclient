package com.baidu.tieba.enterForum.tabfeed.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.widget.ListView.a<bt, CardViewHolder<a>> {
    private s anl;
    public BdUniqueId fJu;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.fJu = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(s sVar) {
        this.anl = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<a> e(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new w() { // from class: com.baidu.tieba.enterForum.tabfeed.a.m.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.czG();
                aq aqVar = new aq("c13647");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.an("obj_id", m.this.getPositionByType(i) + 1);
                aqVar.dX("resource_id", m.this.mTabName);
                TiebaStatic.log(aqVar);
            }
        });
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, CardViewHolder<a> cardViewHolder) {
        if (btVar == null || cardViewHolder == null || cardViewHolder.cvH() == null) {
            return null;
        }
        cardViewHolder.cvH().a(btVar);
        aq aqVar = new aq("c13646");
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        aqVar.an("obj_id", getPositionByType(i) + 1);
        aqVar.dX("resource_id", this.mTabName);
        TiebaStatic.log(aqVar);
        return cardViewHolder.cvH().getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.tieba.card.b<bt> {
        private TbImageView iND;
        private String iNE;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.iND = (TbImageView) getView().findViewById(R.id.image);
            this.iND.setOnClickListener(this);
            this.iND.setConrers(15);
            this.iND.setScaleType(ImageView.ScaleType.FIT_XY);
            this.iND.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.iND.setDrawCorner(true);
            this.iND.setAutoChangeStyle(true);
            this.iND.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.card.b
        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        }

        @Override // com.baidu.tieba.card.b
        public int getLayout() {
            return R.layout.card_resources_item;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.b
        public void a(bt btVar) {
            if (btVar != null) {
                this.iNE = btVar.res_link;
                this.iND.setScaleType(ImageView.ScaleType.FIT_XY);
                this.iND.setPlaceHolder(2);
                this.iND.startLoad(btVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void czG() {
            if (!TextUtils.isEmpty(this.iNE)) {
                be.bwv().b(this.mPageContext, new String[]{this.iNE});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.iND) {
                czG();
            }
        }
    }
}
