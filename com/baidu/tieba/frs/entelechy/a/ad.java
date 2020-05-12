package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
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
public class ad extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.u, a> {
    private boolean hhW;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> hhX;
    private String mForumId;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hhW = false;
        this.hhX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bRZ */
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

    public void bRY() {
        this.hhW = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.hhW, this.mForumId);
        aVar.hia.setViewPool(this.hhX);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.u uVar, a aVar) {
        if (uVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hib.setText(uVar.bQf());
            aVar.hia.setPageContext(this.mPageContext);
            aVar.hia.setData(uVar.getUserInfo());
            aVar.hhZ.setMaxOverScrollDistance(aVar.hia.getChildItemWidth());
            aVar.hib.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!uVar.bQg()) {
                for (MetaData metaData : uVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.r.bEX().e(new an("c12530").cI("obj_id", metaData.getUserId()));
                    }
                }
                uVar.mE(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        private final String forumId;
        private boolean hhW;
        FlexibleHorizontalScrollView hhZ;
        UserRecommendLayout hia;
        TextView hib;
        View.OnClickListener hic;
        View.OnClickListener hie;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.hhW = false;
            this.hic = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ad.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a aQT;
                    if (a.this.hhZ != null && a.this.hia != null) {
                        a.this.hhZ.smoothScrollBy(a.this.hia.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (aQT = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).aQT()) != null) {
                            a.this.aK(aQT.getUserId(), 2);
                        }
                        if (a.this.hhW) {
                            TiebaStatic.log(new an("c13047").af("obj_locate", 9).cI("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.hie = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aK(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.hhW) {
                        TiebaStatic.log(new an("c13047").af("obj_locate", 9).cI("fid", a.this.forumId));
                    }
                }
            };
            this.hhW = z;
            this.forumId = str;
            this.hhZ = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.hia = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.hia.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.hia.setAfterLikeBtnClickListener(this.hic);
            this.hia.setAfterHeaderLickListener(this.hie);
            this.hib = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aK(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").af("obj_locate", i).cI("obj_id", str));
            }
        }
    }
}
