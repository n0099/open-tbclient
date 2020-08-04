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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes16.dex */
public class ag extends com.baidu.tieba.frs.j<com.baidu.tieba.frs.x, a> {
    private boolean hPV;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> hPW;
    private String mForumId;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hPV = false;
        this.hPW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cfk */
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

    public void cfj() {
        this.hPV = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.hPV, this.mForumId);
        aVar.hPZ.setViewPool(this.hPW);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.x xVar, a aVar) {
        if (xVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hQa.setText(xVar.cdl());
            aVar.hPZ.setPageContext(this.mPageContext);
            aVar.hPZ.setData(xVar.getUserInfo());
            aVar.hPY.setMaxOverScrollDistance(aVar.hPZ.getChildItemWidth());
            aVar.hQa.setTextColor(ao.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(ao.getColor(skinType, R.color.cp_bg_line_e));
            if (!xVar.cdm()) {
                for (MetaData metaData : xVar.getUserInfo()) {
                    if (metaData != null && !as.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.bRL().e(new ap("c12530").dn("obj_id", metaData.getUserId()));
                    }
                }
                xVar.nP(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        private final String forumId;
        private boolean hPV;
        FlexibleHorizontalScrollView hPY;
        UserRecommendLayout hPZ;
        TextView hQa;
        View.OnClickListener hQb;
        View.OnClickListener hQc;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.hPV = false;
            this.hQb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a bdf;
                    if (a.this.hPY != null && a.this.hPZ != null) {
                        a.this.hPY.smoothScrollBy(a.this.hPZ.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (bdf = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).bdf()) != null) {
                            a.this.aJ(bdf.getUserId(), 2);
                        }
                        if (a.this.hPV) {
                            TiebaStatic.log(new ap("c13047").ah("obj_locate", 9).dn("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.hQc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aJ(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.hPV) {
                        TiebaStatic.log(new ap("c13047").ah("obj_locate", 9).dn("fid", a.this.forumId));
                    }
                }
            };
            this.hPV = z;
            this.forumId = str;
            this.hPY = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.hPZ = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.hPZ.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.hPZ.setAfterLikeBtnClickListener(this.hQb);
            this.hPZ.setAfterHeaderLickListener(this.hQc);
            this.hQa = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aJ(String str, int i) {
            if (!as.isEmpty(str)) {
                TiebaStatic.log(new ap("c12531").ah("obj_locate", i).dn("obj_id", str));
            }
        }
    }
}
