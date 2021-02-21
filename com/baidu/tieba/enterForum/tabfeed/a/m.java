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
    private s amk;
    public BdUniqueId fGZ;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.fGZ = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(s sVar) {
        this.amk = sVar;
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
                aVar.cxh();
                ar arVar = new ar("c13647");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.ap("obj_id", m.this.getPositionByType(i) + 1);
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
        if (bvVar == null || cardViewHolder == null || cardViewHolder.cti() == null) {
            return null;
        }
        cardViewHolder.cti().a(bvVar);
        ar arVar = new ar("c13646");
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        arVar.ap("obj_id", getPositionByType(i) + 1);
        arVar.dR("resource_id", this.mTabName);
        TiebaStatic.log(arVar);
        return cardViewHolder.cti().getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends com.baidu.tieba.card.b<bv> {
        private TbImageView iOS;
        private String iOT;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.iOS = (TbImageView) getView().findViewById(R.id.image);
            this.iOS.setOnClickListener(this);
            this.iOS.setConrers(15);
            this.iOS.setScaleType(ImageView.ScaleType.FIT_XY);
            this.iOS.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.iOS.setDrawCorner(true);
            this.iOS.setAutoChangeStyle(true);
            this.iOS.setPlaceHolder(2);
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
                this.iOT = bvVar.res_link;
                this.iOS.setScaleType(ImageView.ScaleType.FIT_XY);
                this.iOS.setPlaceHolder(2);
                this.iOS.startLoad(bvVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void cxh() {
            if (!TextUtils.isEmpty(this.iOT)) {
                bf.bsV().b(this.mPageContext, new String[]{this.iOT});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.iOS) {
                cxh();
            }
        }
    }
}
