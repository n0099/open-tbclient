package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes9.dex */
public class ab extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.r, a> {
    private boolean gxK;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> gxL;
    private String mForumId;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gxK = false;
        this.gxL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bHk */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(ab.this.mContext);
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

    public void bHj() {
        this.gxK = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.gxK, this.mForumId);
        aVar.gxO.setViewPool(this.gxL);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.r rVar, a aVar) {
        if (rVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.gxP.setText(rVar.bFt());
            aVar.gxO.setPageContext(this.mPageContext);
            aVar.gxO.setData(rVar.getUserInfo());
            aVar.gxN.setMaxOverScrollDistance(aVar.gxO.getChildItemWidth());
            aVar.gxP.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!rVar.bFu()) {
                for (MetaData metaData : rVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.r.bvh().d(new an("c12530").cy("obj_id", metaData.getUserId()));
                    }
                }
                rVar.lv(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        private final String forumId;
        private boolean gxK;
        FlexibleHorizontalScrollView gxN;
        UserRecommendLayout gxO;
        TextView gxP;
        View.OnClickListener gxQ;
        View.OnClickListener gxR;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.gxK = false;
            this.gxQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ab.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a aIw;
                    if (a.this.gxN != null && a.this.gxO != null) {
                        a.this.gxN.smoothScrollBy(a.this.gxO.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (aIw = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).aIw()) != null) {
                            a.this.aA(aIw.getUserId(), 2);
                        }
                        if (a.this.gxK) {
                            TiebaStatic.log(new an("c13047").X("obj_locate", 9).cy("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.gxR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ab.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aA(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.gxK) {
                        TiebaStatic.log(new an("c13047").X("obj_locate", 9).cy("fid", a.this.forumId));
                    }
                }
            };
            this.gxK = z;
            this.forumId = str;
            this.gxN = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.gxO = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.gxO.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.gxO.setAfterLikeBtnClickListener(this.gxQ);
            this.gxO.setAfterHeaderLickListener(this.gxR);
            this.gxP = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aA(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").X("obj_locate", i).cy("obj_id", str));
            }
        }
    }
}
