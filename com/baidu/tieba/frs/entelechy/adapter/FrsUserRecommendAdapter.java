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
    private boolean jmd;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> jme;
    private String mForumId;

    public FrsUserRecommendAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jmd = false;
        this.jme = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFn */
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

    public void cFm() {
        this.jmd = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public FrsUserRecommendViewHolder e(ViewGroup viewGroup) {
        FrsUserRecommendViewHolder frsUserRecommendViewHolder = new FrsUserRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.jmd, this.mForumId);
        frsUserRecommendViewHolder.jmh.setViewPool(this.jme);
        return frsUserRecommendViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.w wVar, FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            frsUserRecommendViewHolder.jmi.setText(wVar.cDa());
            frsUserRecommendViewHolder.jmh.setPageContext(this.mPageContext);
            frsUserRecommendViewHolder.jmh.setData(wVar.getUserInfo());
            frsUserRecommendViewHolder.jmg.setMaxOverScrollDistance(frsUserRecommendViewHolder.jmh.getChildItemWidth());
            frsUserRecommendViewHolder.jmi.setTextColor(ao.getColor(skinType, R.color.CAM_X0106));
            frsUserRecommendViewHolder.mRootView.setBackgroundColor(ao.getColor(skinType, R.color.CAM_X0205));
            if (!wVar.cDb()) {
                for (MetaData metaData : wVar.getUserInfo()) {
                    if (metaData != null && !at.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.crj().e(new aq("c12530").dW("obj_id", metaData.getUserId()));
                    }
                }
                wVar.qB(true);
            }
        }
        return frsUserRecommendViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class FrsUserRecommendViewHolder extends TypeAdapter.ViewHolder {
        private final String forumId;
        private boolean jmd;
        FlexibleHorizontalScrollView jmg;
        UserRecommendLayout jmh;
        TextView jmi;
        View.OnClickListener jmj;
        View.OnClickListener jmk;
        LinearLayout mRootView;

        public FrsUserRecommendViewHolder(View view, boolean z, String str) {
            super(view);
            this.jmd = false;
            this.jmj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.FrsUserRecommendViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a buY;
                    if (FrsUserRecommendViewHolder.this.jmg != null && FrsUserRecommendViewHolder.this.jmh != null) {
                        FrsUserRecommendViewHolder.this.jmg.smoothScrollBy(FrsUserRecommendViewHolder.this.jmh.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (buY = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).buY()) != null) {
                            FrsUserRecommendViewHolder.this.aY(buY.getUserId(), 2);
                        }
                        if (FrsUserRecommendViewHolder.this.jmd) {
                            TiebaStatic.log(new aq("c13047").an("obj_locate", 9).dW("fid", FrsUserRecommendViewHolder.this.forumId));
                        }
                    }
                }
            };
            this.jmk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.FrsUserRecommendViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        FrsUserRecommendViewHolder.this.aY(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (FrsUserRecommendViewHolder.this.jmd) {
                        TiebaStatic.log(new aq("c13047").an("obj_locate", 9).dW("fid", FrsUserRecommendViewHolder.this.forumId));
                    }
                }
            };
            this.jmd = z;
            this.forumId = str;
            this.jmg = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.jmh = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.jmh.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.jmh.setAfterLikeBtnClickListener(this.jmj);
            this.jmh.setAfterHeaderLickListener(this.jmk);
            this.jmi = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aY(String str, int i) {
            if (!at.isEmpty(str)) {
                TiebaStatic.log(new aq("c12531").an("obj_locate", i).dW("obj_id", str));
            }
        }
    }
}
