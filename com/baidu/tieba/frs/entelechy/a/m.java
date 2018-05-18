package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes2.dex */
public class m extends com.baidu.tieba.frs.f<com.baidu.tieba.frs.o, a> {
    private boolean dfh;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> dfi;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dfh = false;
        this.dfi = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: arV */
            public UserRecommendItemView fo() {
                return new UserRecommendItemView(m.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(UserRecommendItemView userRecommendItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public UserRecommendItemView o(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public UserRecommendItemView p(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }
        }, 10, 0);
    }

    public void arU() {
        this.dfh = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_user_recommend_layout, viewGroup, false), this.dfh, this.mForumId);
        aVar.dfl.setViewPool(this.dfi);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.frs.o oVar, a aVar) {
        if (oVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dfm.setText(oVar.aqC());
            aVar.dfl.setPageContext(this.mPageContext);
            aVar.dfl.setData(oVar.getUserInfo());
            aVar.dfk.setMaxOverScrollDistance(aVar.dfl.getChildItemWidth());
            aVar.dfm.setTextColor(ak.getColor(skinType, d.C0126d.cp_cont_f));
            aVar.aMV.setBackgroundColor(ak.getColor(skinType, d.C0126d.cp_bg_line_e));
            if (!oVar.aqD()) {
                for (MetaData metaData : oVar.getUserInfo()) {
                    if (metaData != null && !an.isEmpty(metaData.getUserId())) {
                        v.afy().a(new al("c12530").ac(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                oVar.fB(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        LinearLayout aMV;
        private boolean dfh;
        FlexibleHorizontalScrollView dfk;
        UserRecommendLayout dfl;
        TextView dfm;
        View.OnClickListener dfn;
        View.OnClickListener dfo;
        private final String forumId;

        public a(View view2, boolean z, String str) {
            super(view2);
            this.dfh = false;
            this.dfn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    com.baidu.tbadk.core.view.userLike.a xn;
                    if (a.this.dfk != null && a.this.dfl != null) {
                        a.this.dfk.smoothScrollBy(a.this.dfl.getChildItemWidth(), 0);
                        if ((view3.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (xn = ((com.baidu.tbadk.core.view.userLike.c) view3.getTag()).xn()) != null) {
                            a.this.W(xn.getUserId(), 2);
                        }
                        if (a.this.dfh) {
                            TiebaStatic.log(new al("c13047").r("obj_locate", 9).ac(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.dfo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (view3 instanceof ClickableHeaderImageView) {
                        a.this.W(((ClickableHeaderImageView) view3).getUserId(), 1);
                    }
                    if (a.this.dfh) {
                        TiebaStatic.log(new al("c13047").r("obj_locate", 9).ac(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.dfh = z;
            this.forumId = str;
            this.dfk = (FlexibleHorizontalScrollView) view2.findViewById(d.g.user_recommend_scroll_container);
            this.dfl = (UserRecommendLayout) view2.findViewById(d.g.user_recommend_container);
            this.dfl.setItemSpace(com.baidu.adp.lib.util.l.e(view2.getContext(), d.e.ds16));
            this.dfl.setAfterLikeBtnClickListener(this.dfn);
            this.dfl.setAfterHeaderLickListener(this.dfo);
            this.dfm = (TextView) view2.findViewById(d.g.user_recommend_document);
            this.aMV = (LinearLayout) view2.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W(String str, int i) {
            if (!an.isEmpty(str)) {
                TiebaStatic.log(new al("c12531").r("obj_locate", i).ac(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
