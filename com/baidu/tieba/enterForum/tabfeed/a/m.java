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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class m extends com.baidu.adp.widget.ListView.a<bs, com.baidu.tieba.card.a.a<a>> {
    private v amH;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
        this.fzO = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.amH = vVar;
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
                aVar.cwL();
                ar arVar = new ar("c13647");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.al("obj_id", m.this.getPositionByType(i) + 1);
                arVar.dY("resource_id", m.this.mTabName);
                TiebaStatic.log(arVar);
            }
        });
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bs bsVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (bsVar == null || aVar == null || aVar.csM() == null) {
            return null;
        }
        aVar.csM().a(bsVar);
        ar arVar = new ar("c13646");
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        arVar.al("obj_id", getPositionByType(i) + 1);
        arVar.dY("resource_id", this.mTabName);
        TiebaStatic.log(arVar);
        return aVar.csM().getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends com.baidu.tieba.card.b<bs> {
        private TbImageView iBp;
        private String iBq;
        private TbPageContext<?> mPageContext;

        public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            this.mPageContext = tbPageContext;
            this.iBp = (TbImageView) getView().findViewById(R.id.image);
            this.iBp.setOnClickListener(this);
            this.iBp.setConrers(15);
            this.iBp.setScaleType(ImageView.ScaleType.FIT_XY);
            this.iBp.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.iBp.setDrawCorner(true);
            this.iBp.setAutoChangeStyle(true);
            this.iBp.setPlaceHolder(2);
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
        public void a(bs bsVar) {
            if (bsVar != null) {
                this.iBq = bsVar.res_link;
                this.iBp.setScaleType(ImageView.ScaleType.FIT_XY);
                this.iBp.setPlaceHolder(2);
                this.iBp.startLoad(bsVar.res_image, 10, false);
            }
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        public void cwL() {
            if (!TextUtils.isEmpty(this.iBq)) {
                bf.bua().b(this.mPageContext, new String[]{this.iBq});
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.iBp) {
                cwL();
            }
        }
    }
}
