package com.baidu.tieba.enterForum.tabfeed.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class m extends com.baidu.adp.widget.ListView.a<bo, com.baidu.tieba.card.a.a<a>> {
    private v ajy;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.eyE = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.ajy = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new z() { // from class: com.baidu.tieba.enterForum.tabfeed.a.m.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.bSU();
                ao aoVar = new ao("c13647");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.ag("obj_id", m.this.getPositionByType(i) + 1);
                aoVar.dk("resource_id", m.this.mTabName);
                TiebaStatic.log(aoVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bo boVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (boVar == null || aVar == null || aVar.bPg() == null) {
            return null;
        }
        aVar.bPg().a(boVar);
        ao aoVar = new ao("c13646");
        aoVar.s("uid", TbadkApplication.getCurrentAccountId());
        aoVar.ag("obj_id", getPositionByType(i) + 1);
        aoVar.dk("resource_id", this.mTabName);
        TiebaStatic.log(aoVar);
        return aVar.bPg().getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.tieba.card.b<bo> {
        private TbImageView hiH;
        private String hiI;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.hiH = (TbImageView) getView().findViewById(R.id.image);
            this.hiH.setOnClickListener(this);
            this.hiH.setConrers(15);
            this.hiH.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hiH.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.hiH.setDrawCorner(true);
            this.hiH.setAutoChangeStyle(true);
            this.hiH.setPlaceHolder(2);
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
        public void a(bo boVar) {
            if (boVar != null) {
                this.hiI = boVar.res_link;
                this.hiH.setScaleType(ImageView.ScaleType.FIT_XY);
                this.hiH.setPlaceHolder(2);
                this.hiH.startLoad(boVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void bSU() {
            if (!TextUtils.isEmpty(this.hiI)) {
                bc.aWU().b(this.mPageContext, new String[]{this.hiI});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.hiH) {
                bSU();
            }
        }
    }
}
