package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes22.dex */
public class ag extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.y, a> {
    private boolean iAh;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> iAi;
    private String mForumId;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iAh = false;
        this.iAi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cwA */
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

    public void cwz() {
        this.iAh = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.iAh, this.mForumId);
        aVar.iAl.setViewPool(this.iAi);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.y yVar, a aVar) {
        if (yVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iAm.setText(yVar.cuu());
            aVar.iAl.setPageContext(this.mPageContext);
            aVar.iAl.setData(yVar.getUserInfo());
            aVar.iAk.setMaxOverScrollDistance(aVar.iAl.getChildItemWidth());
            aVar.iAm.setTextColor(ap.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_e));
            if (!yVar.cuv()) {
                for (MetaData metaData : yVar.getUserInfo()) {
                    if (metaData != null && !at.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.ciJ().e(new aq("c12530").dK("obj_id", metaData.getUserId()));
                    }
                }
                yVar.pg(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private final String forumId;
        private boolean iAh;
        FlexibleHorizontalScrollView iAk;
        UserRecommendLayout iAl;
        TextView iAm;
        View.OnClickListener iAn;
        View.OnClickListener iAo;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.iAh = false;
            this.iAn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a bpp;
                    if (a.this.iAk != null && a.this.iAl != null) {
                        a.this.iAk.smoothScrollBy(a.this.iAl.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (bpp = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).bpp()) != null) {
                            a.this.aN(bpp.getUserId(), 2);
                        }
                        if (a.this.iAh) {
                            TiebaStatic.log(new aq("c13047").aj("obj_locate", 9).dK("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.iAo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aN(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.iAh) {
                        TiebaStatic.log(new aq("c13047").aj("obj_locate", 9).dK("fid", a.this.forumId));
                    }
                }
            };
            this.iAh = z;
            this.forumId = str;
            this.iAk = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.iAl = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.iAl.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.iAl.setAfterLikeBtnClickListener(this.iAn);
            this.iAl.setAfterHeaderLickListener(this.iAo);
            this.iAm = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aN(String str, int i) {
            if (!at.isEmpty(str)) {
                TiebaStatic.log(new aq("c12531").aj("obj_locate", i).dK("obj_id", str));
            }
        }
    }
}
