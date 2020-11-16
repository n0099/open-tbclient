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
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class m extends com.baidu.adp.widget.ListView.a<br, com.baidu.tieba.card.a.a<a>> {
    private v alH;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.fsa = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        final a aVar = new a(this.mPageContext, viewGroup);
        a(new ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.m.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                aVar.csw();
                ar arVar = new ar("c13647");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.ak("obj_id", m.this.getPositionByType(i) + 1);
                arVar.dR("resource_id", m.this.mTabName);
                TiebaStatic.log(arVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, br brVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (brVar == null || aVar == null || aVar.coz() == null) {
            return null;
        }
        aVar.coz().a(brVar);
        ar arVar = new ar("c13646");
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        arVar.ak("obj_id", getPositionByType(i) + 1);
        arVar.dR("resource_id", this.mTabName);
        TiebaStatic.log(arVar);
        return aVar.coz().getView();
    }

    /* loaded from: classes21.dex */
    public static class a extends com.baidu.tieba.card.b<br> {
        private TbImageView iqx;
        private String iqy;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.iqx = (TbImageView) getView().findViewById(R.id.image);
            this.iqx.setOnClickListener(this);
            this.iqx.setConrers(15);
            this.iqx.setScaleType(ImageView.ScaleType.FIT_XY);
            this.iqx.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.iqx.setDrawCorner(true);
            this.iqx.setAutoChangeStyle(true);
            this.iqx.setPlaceHolder(2);
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
        public void a(br brVar) {
            if (brVar != null) {
                this.iqy = brVar.res_link;
                this.iqx.setScaleType(ImageView.ScaleType.FIT_XY);
                this.iqx.setPlaceHolder(2);
                this.iqx.startLoad(brVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void csw() {
            if (!TextUtils.isEmpty(this.iqy)) {
                bf.bqF().b(this.mPageContext, new String[]{this.iqy});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.iqx) {
                csw();
            }
        }
    }
}
