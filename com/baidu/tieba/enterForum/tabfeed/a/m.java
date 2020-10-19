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
    private v alC;
    public BdUniqueId fey;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.fey = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alC = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.m.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.cnl();
                aq aqVar = new aq("c13647");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.aj("obj_id", m.this.getPositionByType(i) + 1);
                aqVar.dK("resource_id", m.this.mTabName);
                TiebaStatic.log(aqVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bq bqVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (bqVar == null || aVar == null || aVar.cjq() == null) {
            return null;
        }
        aVar.cjq().a(bqVar);
        aq aqVar = new aq("c13646");
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        aqVar.aj("obj_id", getPositionByType(i) + 1);
        aqVar.dK("resource_id", this.mTabName);
        TiebaStatic.log(aqVar);
        return aVar.cjq().getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends com.baidu.tieba.card.b<bq> {
        private TbImageView hXk;
        private String hXl;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.hXk = (TbImageView) getView().findViewById(R.id.image);
            this.hXk.setOnClickListener(this);
            this.hXk.setConrers(15);
            this.hXk.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hXk.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.hXk.setDrawCorner(true);
            this.hXk.setAutoChangeStyle(true);
            this.hXk.setPlaceHolder(2);
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
                this.hXl = bqVar.res_link;
                this.hXk.setScaleType(ImageView.ScaleType.FIT_XY);
                this.hXk.setPlaceHolder(2);
                this.hXk.startLoad(bqVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void cnl() {
            if (!TextUtils.isEmpty(this.hXl)) {
                be.bmY().b(this.mPageContext, new String[]{this.hXl});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.hXk) {
                cnl();
            }
        }
    }
}
