package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes22.dex */
public class ag extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.y, a> {
    private boolean iSA;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> iSB;
    private String mForumId;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iSA = false;
        this.iSB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cCi */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(ag.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(UserRecommendItemView userRecommendItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public UserRecommendItemView activateObject(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public UserRecommendItemView passivateObject(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }
        }, 10, 0);
    }

    public void cCh() {
        this.iSA = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.iSA, this.mForumId);
        aVar.iSE.setViewPool(this.iSB);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.y yVar, a aVar) {
        if (yVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iSF.setText(yVar.cAc());
            aVar.iSE.setPageContext(this.mPageContext);
            aVar.iSE.setData(yVar.getUserInfo());
            aVar.iSD.setMaxOverScrollDistance(aVar.iSE.getChildItemWidth());
            aVar.iSF.setTextColor(ap.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_e));
            if (!yVar.cAd()) {
                for (MetaData metaData : yVar.getUserInfo()) {
                    if (metaData != null && !at.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.cor().e(new aq("c12530").dR("obj_id", metaData.getUserId()));
                    }
                }
                yVar.pH(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private final String forumId;
        private boolean iSA;
        FlexibleHorizontalScrollView iSD;
        UserRecommendLayout iSE;
        TextView iSF;
        View.OnClickListener iSG;
        View.OnClickListener iSH;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.iSA = false;
            this.iSG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a btI;
                    if (a.this.iSD != null && a.this.iSE != null) {
                        a.this.iSD.smoothScrollBy(a.this.iSE.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (btI = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).btI()) != null) {
                            a.this.aQ(btI.getUserId(), 2);
                        }
                        if (a.this.iSA) {
                            TiebaStatic.log(new aq("c13047").al("obj_locate", 9).dR("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.iSH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aQ(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.iSA) {
                        TiebaStatic.log(new aq("c13047").al("obj_locate", 9).dR("fid", a.this.forumId));
                    }
                }
            };
            this.iSA = z;
            this.forumId = str;
            this.iSD = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.iSE = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.iSE.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.iSE.setAfterLikeBtnClickListener(this.iSG);
            this.iSE.setAfterHeaderLickListener(this.iSH);
            this.iSF = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aQ(String str, int i) {
            if (!at.isEmpty(str)) {
                TiebaStatic.log(new aq("c12531").al("obj_locate", i).dR("obj_id", str));
            }
        }
    }
}
