package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes9.dex */
public class ag extends com.baidu.tieba.frs.j<com.baidu.tieba.frs.x, a> {
    private boolean hJT;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> hJU;
    private String mForumId;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hJT = false;
        this.hJU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cbM */
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

    public void cbL() {
        this.hJT = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.hJT, this.mForumId);
        aVar.hJX.setViewPool(this.hJU);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.x xVar, a aVar) {
        if (xVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hJY.setText(xVar.bZO());
            aVar.hJX.setPageContext(this.mPageContext);
            aVar.hJX.setData(xVar.getUserInfo());
            aVar.hJW.setMaxOverScrollDistance(aVar.hJX.getChildItemWidth());
            aVar.hJY.setTextColor(an.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(an.getColor(skinType, R.color.cp_bg_line_e));
            if (!xVar.bZP()) {
                for (MetaData metaData : xVar.getUserInfo()) {
                    if (metaData != null && !ar.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.bOB().e(new ao("c12530").dk("obj_id", metaData.getUserId()));
                    }
                }
                xVar.nk(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        private final String forumId;
        private boolean hJT;
        FlexibleHorizontalScrollView hJW;
        UserRecommendLayout hJX;
        TextView hJY;
        View.OnClickListener hJZ;
        View.OnClickListener hKa;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.hJT = false;
            this.hJZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a aZi;
                    if (a.this.hJW != null && a.this.hJX != null) {
                        a.this.hJW.smoothScrollBy(a.this.hJX.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (aZi = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).aZi()) != null) {
                            a.this.aK(aZi.getUserId(), 2);
                        }
                        if (a.this.hJT) {
                            TiebaStatic.log(new ao("c13047").ag("obj_locate", 9).dk("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.hKa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aK(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.hJT) {
                        TiebaStatic.log(new ao("c13047").ag("obj_locate", 9).dk("fid", a.this.forumId));
                    }
                }
            };
            this.hJT = z;
            this.forumId = str;
            this.hJW = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.hJX = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.hJX.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.hJX.setAfterLikeBtnClickListener(this.hJZ);
            this.hJX.setAfterHeaderLickListener(this.hKa);
            this.hJY = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aK(String str, int i) {
            if (!ar.isEmpty(str)) {
                TiebaStatic.log(new ao("c12531").ag("obj_locate", i).dk("obj_id", str));
            }
        }
    }
}
