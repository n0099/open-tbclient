package com.baidu.tieba.enterForum.tabfeed.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.v;
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
    private r ahy;
    public BdUniqueId ebA;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.ebA = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(r rVar) {
        this.ahy = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new v() { // from class: com.baidu.tieba.enterForum.tabfeed.a.j.1
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.bJw();
                an anVar = new an("c13647");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.af("obj_id", j.this.getPositionByType(i) + 1);
                anVar.cI("resource_id", j.this.mTabName);
                TiebaStatic.log(anVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.tabfeed.b.d dVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (dVar == null || aVar == null || aVar.bFA() == null) {
            return null;
        }
        aVar.bFA().a(dVar);
        an anVar = new an("c13646");
        anVar.t("uid", TbadkApplication.getCurrentAccountId());
        anVar.af("obj_id", getPositionByType(i) + 1);
        anVar.cI("resource_id", this.mTabName);
        TiebaStatic.log(anVar);
        return aVar.bFA().getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.tabfeed.b.d> {
        private TbImageView gGY;
        private String gGZ;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.gGY = (TbImageView) getView().findViewById(R.id.image);
            this.gGY.setOnClickListener(this);
            this.gGY.setConrers(15);
            this.gGY.setScaleType(ImageView.ScaleType.FIT_XY);
            this.gGY.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.gGY.setDrawCorner(true);
            this.gGY.setAutoChangeStyle(true);
            this.gGY.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.card.a
        public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        }

        @Override // com.baidu.tieba.card.a
        public int getLayout() {
            return R.layout.card_resources_item;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.a
        public void a(com.baidu.tieba.enterForum.tabfeed.b.d dVar) {
            if (dVar != null) {
                this.gGZ = dVar.res_link;
                this.gGY.setScaleType(ImageView.ScaleType.FIT_XY);
                this.gGY.setPlaceHolder(2);
                this.gGY.startLoad(dVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void bJw() {
            if (!TextUtils.isEmpty(this.gGZ)) {
                ba.aOV().b(this.mPageContext, new String[]{this.gGZ});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.gGY) {
                bJw();
            }
        }
    }
}
