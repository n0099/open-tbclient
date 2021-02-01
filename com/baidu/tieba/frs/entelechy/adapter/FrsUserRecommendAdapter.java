package com.baidu.tieba.frs.entelechy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes2.dex */
public class FrsUserRecommendAdapter extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.w, FrsUserRecommendViewHolder> {
    private boolean jrK;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> jrL;
    private String mForumId;

    public FrsUserRecommendAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jrK = false;
        this.jrL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cGA */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(FrsUserRecommendAdapter.this.mContext);
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

    public void cGz() {
        this.jrK = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public FrsUserRecommendViewHolder e(ViewGroup viewGroup) {
        FrsUserRecommendViewHolder frsUserRecommendViewHolder = new FrsUserRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.jrK, this.mForumId);
        frsUserRecommendViewHolder.jrO.setViewPool(this.jrL);
        return frsUserRecommendViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.w wVar, FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            frsUserRecommendViewHolder.jrP.setText(wVar.cEm());
            frsUserRecommendViewHolder.jrO.setPageContext(this.mPageContext);
            frsUserRecommendViewHolder.jrO.setData(wVar.getUserInfo());
            frsUserRecommendViewHolder.jrN.setMaxOverScrollDistance(frsUserRecommendViewHolder.jrO.getChildItemWidth());
            frsUserRecommendViewHolder.jrP.setTextColor(ap.getColor(skinType, R.color.CAM_X0106));
            frsUserRecommendViewHolder.mRootView.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0205));
            if (!wVar.cEn()) {
                for (MetaData metaData : wVar.getUserInfo()) {
                    if (metaData != null && !au.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.csu().e(new ar("c12530").dR("obj_id", metaData.getUserId()));
                    }
                }
                wVar.qL(true);
            }
        }
        return frsUserRecommendViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class FrsUserRecommendViewHolder extends TypeAdapter.ViewHolder {
        private final String forumId;
        private boolean jrK;
        FlexibleHorizontalScrollView jrN;
        UserRecommendLayout jrO;
        TextView jrP;
        View.OnClickListener jrQ;
        View.OnClickListener jrR;
        LinearLayout mRootView;

        public FrsUserRecommendViewHolder(View view, boolean z, String str) {
            super(view);
            this.jrK = false;
            this.jrQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.FrsUserRecommendViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a bvs;
                    if (FrsUserRecommendViewHolder.this.jrN != null && FrsUserRecommendViewHolder.this.jrO != null) {
                        FrsUserRecommendViewHolder.this.jrN.smoothScrollBy(FrsUserRecommendViewHolder.this.jrO.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (bvs = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).bvs()) != null) {
                            FrsUserRecommendViewHolder.this.aY(bvs.getUserId(), 2);
                        }
                        if (FrsUserRecommendViewHolder.this.jrK) {
                            TiebaStatic.log(new ar("c13047").ap("obj_locate", 9).dR("fid", FrsUserRecommendViewHolder.this.forumId));
                        }
                    }
                }
            };
            this.jrR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.FrsUserRecommendViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        FrsUserRecommendViewHolder.this.aY(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (FrsUserRecommendViewHolder.this.jrK) {
                        TiebaStatic.log(new ar("c13047").ap("obj_locate", 9).dR("fid", FrsUserRecommendViewHolder.this.forumId));
                    }
                }
            };
            this.jrK = z;
            this.forumId = str;
            this.jrN = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.jrO = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.jrO.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.jrO.setAfterLikeBtnClickListener(this.jrQ);
            this.jrO.setAfterHeaderLickListener(this.jrR);
            this.jrP = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aY(String str, int i) {
            if (!au.isEmpty(str)) {
                TiebaStatic.log(new ar("c12531").ap("obj_locate", i).dR("obj_id", str));
            }
        }
    }
}
