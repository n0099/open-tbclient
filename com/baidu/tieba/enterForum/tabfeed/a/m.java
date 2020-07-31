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
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class m extends com.baidu.adp.widget.ListView.a<bp, com.baidu.tieba.card.a.a<a>> {
    private v ajt;
    public BdUniqueId eEU;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.eEU = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new z() { // from class: com.baidu.tieba.enterForum.tabfeed.a.m.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.bWm();
                ap apVar = new ap("c13647");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.ah("obj_id", m.this.getPositionByType(i) + 1);
                apVar.dn("resource_id", m.this.mTabName);
                TiebaStatic.log(apVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bp bpVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (bpVar == null || aVar == null || aVar.bSs() == null) {
            return null;
        }
        aVar.bSs().a(bpVar);
        ap apVar = new ap("c13646");
        apVar.t("uid", TbadkApplication.getCurrentAccountId());
        apVar.ah("obj_id", getPositionByType(i) + 1);
        apVar.dn("resource_id", this.mTabName);
        TiebaStatic.log(apVar);
        return aVar.bSs().getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends com.baidu.tieba.card.b<bp> {
        private TbImageView hoq;
        private String hor;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.hoq = (TbImageView) getView().findViewById(R.id.image);
            this.hoq.setOnClickListener(this);
            this.hoq.setConrers(15);
            this.hoq.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hoq.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.hoq.setDrawCorner(true);
            this.hoq.setAutoChangeStyle(true);
            this.hoq.setPlaceHolder(2);
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
        public void a(bp bpVar) {
            if (bpVar != null) {
                this.hor = bpVar.res_link;
                this.hoq.setScaleType(ImageView.ScaleType.FIT_XY);
                this.hoq.setPlaceHolder(2);
                this.hoq.startLoad(bpVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void bWm() {
            if (!TextUtils.isEmpty(this.hor)) {
                bd.baV().b(this.mPageContext, new String[]{this.hor});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.hoq) {
                bWm();
            }
        }
    }
}
