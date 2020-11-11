package com.baidu.tieba.enterForum.tabfeed.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class m extends com.baidu.adp.widget.ListView.a<bq, com.baidu.tieba.card.a.a<a>> {
    private v alD;
    public BdUniqueId fsQ;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.fsQ = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.m.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.csT();
                aq aqVar = new aq("c13647");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.al("obj_id", m.this.getPositionByType(i) + 1);
                aqVar.dR("resource_id", m.this.mTabName);
                TiebaStatic.log(aqVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bq bqVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (bqVar == null || aVar == null || aVar.coY() == null) {
            return null;
        }
        aVar.coY().a(bqVar);
        aq aqVar = new aq("c13646");
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        aqVar.al("obj_id", getPositionByType(i) + 1);
        aqVar.dR("resource_id", this.mTabName);
        TiebaStatic.log(aqVar);
        return aVar.coY().getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends com.baidu.tieba.card.b<bq> {
        private TbImageView ipJ;
        private String ipK;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.ipJ = (TbImageView) getView().findViewById(R.id.image);
            this.ipJ.setOnClickListener(this);
            this.ipJ.setConrers(15);
            this.ipJ.setScaleType(ImageView.ScaleType.FIT_XY);
            this.ipJ.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.ipJ.setDrawCorner(true);
            this.ipJ.setAutoChangeStyle(true);
            this.ipJ.setPlaceHolder(2);
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
        public void a(bq bqVar) {
            if (bqVar != null) {
                this.ipK = bqVar.res_link;
                this.ipJ.setScaleType(ImageView.ScaleType.FIT_XY);
                this.ipJ.setPlaceHolder(2);
                this.ipJ.startLoad(bqVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void csT() {
            if (!TextUtils.isEmpty(this.ipK)) {
                be.brr().b(this.mPageContext, new String[]{this.ipK});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.ipJ) {
                csT();
            }
        }
    }
}
