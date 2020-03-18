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
public class ad extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.s, a> {
    private boolean gyv;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> gyw;
    private String mForumId;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gyv = false;
        this.gyw = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bHz */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(ad.this.mContext);
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

    public void bHy() {
        this.gyv = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.gyv, this.mForumId);
        aVar.gyz.setViewPool(this.gyw);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.s sVar, a aVar) {
        if (sVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.gyA.setText(sVar.bFD());
            aVar.gyz.setPageContext(this.mPageContext);
            aVar.gyz.setData(sVar.getUserInfo());
            aVar.gyy.setMaxOverScrollDistance(aVar.gyz.getChildItemWidth());
            aVar.gyA.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!sVar.bFE()) {
                for (MetaData metaData : sVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.r.bvm().e(new an("c12530").cx("obj_id", metaData.getUserId()));
                    }
                }
                sVar.lB(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        private final String forumId;
        TextView gyA;
        View.OnClickListener gyB;
        View.OnClickListener gyC;
        private boolean gyv;
        FlexibleHorizontalScrollView gyy;
        UserRecommendLayout gyz;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.gyv = false;
            this.gyB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ad.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a aIA;
                    if (a.this.gyy != null && a.this.gyz != null) {
                        a.this.gyy.smoothScrollBy(a.this.gyz.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (aIA = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).aIA()) != null) {
                            a.this.aA(aIA.getUserId(), 2);
                        }
                        if (a.this.gyv) {
                            TiebaStatic.log(new an("c13047").X("obj_locate", 9).cx("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.gyC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aA(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.gyv) {
                        TiebaStatic.log(new an("c13047").X("obj_locate", 9).cx("fid", a.this.forumId));
                    }
                }
            };
            this.gyv = z;
            this.forumId = str;
            this.gyy = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.gyz = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.gyz.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.gyz.setAfterLikeBtnClickListener(this.gyB);
            this.gyz.setAfterHeaderLickListener(this.gyC);
            this.gyA = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aA(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").X("obj_locate", i).cx("obj_id", str));
            }
        }
    }
}
