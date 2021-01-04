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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes2.dex */
public class FrsUserRecommendAdapter extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.w, FrsUserRecommendViewHolder> {
    private boolean jqK;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> jqL;
    private String mForumId;

    public FrsUserRecommendAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jqK = false;
        this.jqL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cJe */
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

    public void cJd() {
        this.jqK = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public FrsUserRecommendViewHolder e(ViewGroup viewGroup) {
        FrsUserRecommendViewHolder frsUserRecommendViewHolder = new FrsUserRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.jqK, this.mForumId);
        frsUserRecommendViewHolder.jqO.setViewPool(this.jqL);
        return frsUserRecommendViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.w wVar, FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            frsUserRecommendViewHolder.jqP.setText(wVar.cGR());
            frsUserRecommendViewHolder.jqO.setPageContext(this.mPageContext);
            frsUserRecommendViewHolder.jqO.setData(wVar.getUserInfo());
            frsUserRecommendViewHolder.jqN.setMaxOverScrollDistance(frsUserRecommendViewHolder.jqO.getChildItemWidth());
            frsUserRecommendViewHolder.jqP.setTextColor(ao.getColor(skinType, R.color.CAM_X0106));
            frsUserRecommendViewHolder.mRootView.setBackgroundColor(ao.getColor(skinType, R.color.CAM_X0205));
            if (!wVar.cGS()) {
                for (MetaData metaData : wVar.getUserInfo()) {
                    if (metaData != null && !at.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.cva().e(new aq("c12530").dX("obj_id", metaData.getUserId()));
                    }
                }
                wVar.qF(true);
            }
        }
        return frsUserRecommendViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class FrsUserRecommendViewHolder extends TypeAdapter.ViewHolder {
        private final String forumId;
        private boolean jqK;
        FlexibleHorizontalScrollView jqN;
        UserRecommendLayout jqO;
        TextView jqP;
        View.OnClickListener jqQ;
        View.OnClickListener jqR;
        LinearLayout mRootView;

        public FrsUserRecommendViewHolder(View view, boolean z, String str) {
            super(view);
            this.jqK = false;
            this.jqQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.FrsUserRecommendViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a byR;
                    if (FrsUserRecommendViewHolder.this.jqN != null && FrsUserRecommendViewHolder.this.jqO != null) {
                        FrsUserRecommendViewHolder.this.jqN.smoothScrollBy(FrsUserRecommendViewHolder.this.jqO.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (byR = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).byR()) != null) {
                            FrsUserRecommendViewHolder.this.aY(byR.getUserId(), 2);
                        }
                        if (FrsUserRecommendViewHolder.this.jqK) {
                            TiebaStatic.log(new aq("c13047").an("obj_locate", 9).dX("fid", FrsUserRecommendViewHolder.this.forumId));
                        }
                    }
                }
            };
            this.jqR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.FrsUserRecommendViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        FrsUserRecommendViewHolder.this.aY(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (FrsUserRecommendViewHolder.this.jqK) {
                        TiebaStatic.log(new aq("c13047").an("obj_locate", 9).dX("fid", FrsUserRecommendViewHolder.this.forumId));
                    }
                }
            };
            this.jqK = z;
            this.forumId = str;
            this.jqN = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.jqO = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.jqO.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.jqO.setAfterLikeBtnClickListener(this.jqQ);
            this.jqO.setAfterHeaderLickListener(this.jqR);
            this.jqP = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aY(String str, int i) {
            if (!at.isEmpty(str)) {
                TiebaStatic.log(new aq("c12531").an("obj_locate", i).dX("obj_id", str));
            }
        }
    }
}
