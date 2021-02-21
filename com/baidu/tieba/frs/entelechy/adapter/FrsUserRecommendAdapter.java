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
    private boolean jrY;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> jrZ;
    private String mForumId;

    public FrsUserRecommendAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jrY = false;
        this.jrZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cGH */
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

    public void cGG() {
        this.jrY = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public FrsUserRecommendViewHolder e(ViewGroup viewGroup) {
        FrsUserRecommendViewHolder frsUserRecommendViewHolder = new FrsUserRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.jrY, this.mForumId);
        frsUserRecommendViewHolder.jsc.setViewPool(this.jrZ);
        return frsUserRecommendViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.w wVar, FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
        if (wVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            frsUserRecommendViewHolder.jsd.setText(wVar.cEt());
            frsUserRecommendViewHolder.jsc.setPageContext(this.mPageContext);
            frsUserRecommendViewHolder.jsc.setData(wVar.getUserInfo());
            frsUserRecommendViewHolder.jsb.setMaxOverScrollDistance(frsUserRecommendViewHolder.jsc.getChildItemWidth());
            frsUserRecommendViewHolder.jsd.setTextColor(ap.getColor(skinType, R.color.CAM_X0106));
            frsUserRecommendViewHolder.mRootView.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0205));
            if (!wVar.cEu()) {
                for (MetaData metaData : wVar.getUserInfo()) {
                    if (metaData != null && !au.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.csB().e(new ar("c12530").dR("obj_id", metaData.getUserId()));
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
        private boolean jrY;
        FlexibleHorizontalScrollView jsb;
        UserRecommendLayout jsc;
        TextView jsd;
        View.OnClickListener jse;
        View.OnClickListener jsf;
        LinearLayout mRootView;

        public FrsUserRecommendViewHolder(View view, boolean z, String str) {
            super(view);
            this.jrY = false;
            this.jse = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.FrsUserRecommendViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a bvs;
                    if (FrsUserRecommendViewHolder.this.jsb != null && FrsUserRecommendViewHolder.this.jsc != null) {
                        FrsUserRecommendViewHolder.this.jsb.smoothScrollBy(FrsUserRecommendViewHolder.this.jsc.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (bvs = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).bvs()) != null) {
                            FrsUserRecommendViewHolder.this.aY(bvs.getUserId(), 2);
                        }
                        if (FrsUserRecommendViewHolder.this.jrY) {
                            TiebaStatic.log(new ar("c13047").ap("obj_locate", 9).dR("fid", FrsUserRecommendViewHolder.this.forumId));
                        }
                    }
                }
            };
            this.jsf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter.FrsUserRecommendViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        FrsUserRecommendViewHolder.this.aY(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (FrsUserRecommendViewHolder.this.jrY) {
                        TiebaStatic.log(new ar("c13047").ap("obj_locate", 9).dR("fid", FrsUserRecommendViewHolder.this.forumId));
                    }
                }
            };
            this.jrY = z;
            this.forumId = str;
            this.jsb = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.jsc = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.jsc.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.jsc.setAfterLikeBtnClickListener(this.jse);
            this.jsc.setAfterHeaderLickListener(this.jsf);
            this.jsd = (TextView) view.findViewById(R.id.user_recommend_document);
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
