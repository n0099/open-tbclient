package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
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
    private boolean hwV;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> hwW;
    private String mForumId;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hwV = false;
        this.hwW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bYx */
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

    public void bYw() {
        this.hwV = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.hwV, this.mForumId);
        aVar.hwZ.setViewPool(this.hwW);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.u uVar, a aVar) {
        if (uVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hxa.setText(uVar.bWD());
            aVar.hwZ.setPageContext(this.mPageContext);
            aVar.hwZ.setData(uVar.getUserInfo());
            aVar.hwY.setMaxOverScrollDistance(aVar.hwZ.getChildItemWidth());
            aVar.hxa.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!uVar.bWE()) {
                for (MetaData metaData : uVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.bLs().e(new an("c12530").dh("obj_id", metaData.getUserId()));
                    }
                }
                uVar.mZ(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        private final String forumId;
        private boolean hwV;
        FlexibleHorizontalScrollView hwY;
        UserRecommendLayout hwZ;
        TextView hxa;
        View.OnClickListener hxb;
        View.OnClickListener hxc;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.hwV = false;
            this.hxb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ad.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a aXc;
                    if (a.this.hwY != null && a.this.hwZ != null) {
                        a.this.hwY.smoothScrollBy(a.this.hwZ.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (aXc = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).aXc()) != null) {
                            a.this.aL(aXc.getUserId(), 2);
                        }
                        if (a.this.hwV) {
                            TiebaStatic.log(new an("c13047").ag("obj_locate", 9).dh("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.hxc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aL(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.hwV) {
                        TiebaStatic.log(new an("c13047").ag("obj_locate", 9).dh("fid", a.this.forumId));
                    }
                }
            };
            this.hwV = z;
            this.forumId = str;
            this.hwY = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.hwZ = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.hwZ.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.hwZ.setAfterLikeBtnClickListener(this.hxb);
            this.hwZ.setAfterHeaderLickListener(this.hxc);
            this.hxa = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aL(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").ag("obj_locate", i).dh("obj_id", str));
            }
        }
    }
}
