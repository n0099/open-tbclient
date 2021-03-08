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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.widget.ListView.a<bv, CardViewHolder<a>> {
    private s anC;
    public BdUniqueId fIy;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.fIy = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(s sVar) {
        this.anC = sVar;
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
                aVar.cxn();
                ar arVar = new ar("c13647");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.aq("obj_id", m.this.getPositionByType(i) + 1);
                arVar.dR("resource_id", m.this.mTabName);
                TiebaStatic.log(arVar);
            }
        });
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, CardViewHolder<a> cardViewHolder) {
        if (bvVar == null || cardViewHolder == null || cardViewHolder.cto() == null) {
            return null;
        }
        cardViewHolder.cto().a(bvVar);
        ar arVar = new ar("c13646");
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        arVar.aq("obj_id", getPositionByType(i) + 1);
        arVar.dR("resource_id", this.mTabName);
        TiebaStatic.log(arVar);
        return cardViewHolder.cto().getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.tieba.card.b<bv> {
        private TbImageView iQB;
        private String iQC;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.iQB = (TbImageView) getView().findViewById(R.id.image);
            this.iQB.setOnClickListener(this);
            this.iQB.setConrers(15);
            this.iQB.setScaleType(ImageView.ScaleType.FIT_XY);
            this.iQB.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.iQB.setDrawCorner(true);
            this.iQB.setAutoChangeStyle(true);
            this.iQB.setPlaceHolder(2);
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
        public void a(bv bvVar) {
            if (bvVar != null) {
                this.iQC = bvVar.res_link;
                this.iQB.setScaleType(ImageView.ScaleType.FIT_XY);
                this.iQB.setPlaceHolder(2);
                this.iQB.startLoad(bvVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void cxn() {
            if (!TextUtils.isEmpty(this.iQC)) {
                bf.bsY().b(this.mPageContext, new String[]{this.iQC});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.iQB) {
                cxn();
            }
        }
    }
}
