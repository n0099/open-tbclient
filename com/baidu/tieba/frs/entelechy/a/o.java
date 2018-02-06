package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes2.dex */
public class o extends com.baidu.tieba.frs.g<com.baidu.tieba.frs.s, a> {
    private com.baidu.adp.lib.e.b<com.baidu.tieba.frs.view.i> dLh;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dLh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.frs.view.i>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axx */
            public com.baidu.tieba.frs.view.i nl() {
                return new com.baidu.tieba.frs.view.i(o.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(com.baidu.tieba.frs.view.i iVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public com.baidu.tieba.frs.view.i at(com.baidu.tieba.frs.view.i iVar) {
                return iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tieba.frs.view.i au(com.baidu.tieba.frs.view.i iVar) {
                return iVar;
            }
        }, 10, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_user_recommend_layout, viewGroup, false));
        aVar.dLk.setViewPool(this.dLh);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.s sVar, a aVar) {
        if (sVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dLl.setText(sVar.awj());
            aVar.dLk.setPageContext(this.mPageContext);
            aVar.dLk.setData(sVar.getUserInfo());
            aVar.dLj.setMaxOverScrollDistance(aVar.dLk.getChildItemWidth());
            aVar.dLl.setTextColor(aj.getColor(skinType, d.C0140d.cp_cont_b));
            aVar.bCE.setBackgroundColor(aj.getColor(skinType, d.C0140d.cp_bg_line_e));
            if (!sVar.awk()) {
                for (MetaData metaData : sVar.getUserInfo()) {
                    if (metaData != null && !am.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.r.alt().a(new ak("c12530").ab("obj_id", metaData.getUserId()));
                    }
                }
                sVar.fV(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends r.a {
        LinearLayout bCE;
        FlexibleHorizontalScrollView dLj;
        UserRecommendLayout dLk;
        TextView dLl;
        View.OnClickListener dLm;
        View.OnClickListener dLn;

        public a(View view) {
            super(view);
            this.dLm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.o.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a EE;
                    if (a.this.dLj != null && a.this.dLk != null) {
                        a.this.dLj.smoothScrollBy(a.this.dLk.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (EE = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).EE()) != null) {
                            a.this.W(EE.getUserId(), 2);
                        }
                    }
                }
            };
            this.dLn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.o.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.W(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                }
            };
            this.dLj = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.dLk = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.dLk.setItemSpace(com.baidu.adp.lib.util.l.t(view.getContext(), d.e.ds16));
            this.dLk.setAfterLikeBtnClickListener(this.dLm);
            this.dLk.setAfterHeaderLickListener(this.dLn);
            this.dLl = (TextView) view.findViewById(d.g.user_recommend_document);
            this.bCE = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W(String str, int i) {
            if (!am.isEmpty(str)) {
                TiebaStatic.log(new ak("c12531").s("obj_locate", i).ab("obj_id", str));
            }
        }
    }
}
