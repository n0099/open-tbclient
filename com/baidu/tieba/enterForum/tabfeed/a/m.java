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
/* loaded from: classes16.dex */
public class m extends com.baidu.adp.widget.ListView.a<bq, com.baidu.tieba.card.a.a<a>> {
    private v akK;
    public BdUniqueId ePz;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.ePz = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.akK = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.m.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.cgA();
                aq aqVar = new aq("c13647");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.ai("obj_id", m.this.getPositionByType(i) + 1);
                aqVar.dD("resource_id", m.this.mTabName);
                TiebaStatic.log(aqVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bq bqVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (bqVar == null || aVar == null || aVar.ccF() == null) {
            return null;
        }
        aVar.ccF().a(bqVar);
        aq aqVar = new aq("c13646");
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        aqVar.ai("obj_id", getPositionByType(i) + 1);
        aqVar.dD("resource_id", this.mTabName);
        TiebaStatic.log(aqVar);
        return aVar.ccF().getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends com.baidu.tieba.card.b<bq> {
        private TbImageView hBn;
        private String hBo;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.hBn = (TbImageView) getView().findViewById(R.id.image);
            this.hBn.setOnClickListener(this);
            this.hBn.setConrers(15);
            this.hBn.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hBn.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.hBn.setDrawCorner(true);
            this.hBn.setAutoChangeStyle(true);
            this.hBn.setPlaceHolder(2);
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
                this.hBo = bqVar.res_link;
                this.hBn.setScaleType(ImageView.ScaleType.FIT_XY);
                this.hBn.setPlaceHolder(2);
                this.hBn.startLoad(bqVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void cgA() {
            if (!TextUtils.isEmpty(this.hBo)) {
                be.bju().b(this.mPageContext, new String[]{this.hBo});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.hBn) {
                cgA();
            }
        }
    }
}
