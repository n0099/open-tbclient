package com.baidu.tieba.enterForum.tabfeed.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.enterForum.tabfeed.b.d, com.baidu.tieba.card.a.a<a>> {
    private t aib;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.epM = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(t tVar) {
        this.aib = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new x() { // from class: com.baidu.tieba.enterForum.tabfeed.a.j.1
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.bPR();
                an anVar = new an("c13647");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.ag("obj_id", j.this.getPositionByType(i) + 1);
                anVar.dh("resource_id", j.this.mTabName);
                TiebaStatic.log(anVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.tabfeed.b.d dVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (dVar == null || aVar == null || aVar.bLW() == null) {
            return null;
        }
        aVar.bLW().a(dVar);
        an anVar = new an("c13646");
        anVar.s("uid", TbadkApplication.getCurrentAccountId());
        anVar.ag("obj_id", getPositionByType(i) + 1);
        anVar.dh("resource_id", this.mTabName);
        TiebaStatic.log(anVar);
        return aVar.bLW().getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.tabfeed.b.d> {
        private TbImageView gVQ;
        private String gVR;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.gVQ = (TbImageView) getView().findViewById(R.id.image);
            this.gVQ.setOnClickListener(this);
            this.gVQ.setConrers(15);
            this.gVQ.setScaleType(ImageView.ScaleType.FIT_XY);
            this.gVQ.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.gVQ.setDrawCorner(true);
            this.gVQ.setAutoChangeStyle(true);
            this.gVQ.setPlaceHolder(2);
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
        public void a(com.baidu.tieba.enterForum.tabfeed.b.d dVar) {
            if (dVar != null) {
                this.gVR = dVar.res_link;
                this.gVQ.setScaleType(ImageView.ScaleType.FIT_XY);
                this.gVQ.setPlaceHolder(2);
                this.gVQ.startLoad(dVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void bPR() {
            if (!TextUtils.isEmpty(this.gVR)) {
                ba.aVa().b(this.mPageContext, new String[]{this.gVR});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gVQ) {
                bPR();
            }
        }
    }
}
