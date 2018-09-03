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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes2.dex */
public class m extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.q, a> {
    private boolean dup;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> duq;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dup = false;
        this.duq = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axi */
            public UserRecommendItemView ig() {
                return new UserRecommendItemView(m.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(UserRecommendItemView userRecommendItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public UserRecommendItemView r(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public UserRecommendItemView s(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }
        }, 10, 0);
    }

    public void axh() {
        this.dup = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(f.h.card_user_recommend_layout, viewGroup, false), this.dup, this.mForumId);
        aVar.dut.setViewPool(this.duq);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.duu.setText(qVar.avF());
            aVar.dut.setPageContext(this.mPageContext);
            aVar.dut.setData(qVar.getUserInfo());
            aVar.dus.setMaxOverScrollDistance(aVar.dut.getChildItemWidth());
            aVar.duu.setTextColor(am.getColor(skinType, f.d.cp_cont_f));
            aVar.axD.setBackgroundColor(am.getColor(skinType, f.d.cp_bg_line_e));
            if (!qVar.avG()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ap.isEmpty(metaData.getUserId())) {
                        v.ajb().a(new an("c12530").ae(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.fM(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        LinearLayout axD;
        private boolean dup;
        FlexibleHorizontalScrollView dus;
        UserRecommendLayout dut;
        TextView duu;
        View.OnClickListener duv;
        View.OnClickListener duw;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.dup = false;
            this.duv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a AU;
                    if (a.this.dus != null && a.this.dut != null) {
                        a.this.dus.smoothScrollBy(a.this.dut.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (AU = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).AU()) != null) {
                            a.this.T(AU.getUserId(), 2);
                        }
                        if (a.this.dup) {
                            TiebaStatic.log(new an("c13047").r("obj_locate", 9).ae(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.duw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.T(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.dup) {
                        TiebaStatic.log(new an("c13047").r("obj_locate", 9).ae(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.dup = z;
            this.forumId = str;
            this.dus = (FlexibleHorizontalScrollView) view.findViewById(f.g.user_recommend_scroll_container);
            this.dut = (UserRecommendLayout) view.findViewById(f.g.user_recommend_container);
            this.dut.setItemSpace(com.baidu.adp.lib.util.l.f(view.getContext(), f.e.ds16));
            this.dut.setAfterLikeBtnClickListener(this.duv);
            this.dut.setAfterHeaderLickListener(this.duw);
            this.duu = (TextView) view.findViewById(f.g.user_recommend_document);
            this.axD = (LinearLayout) view.findViewById(f.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T(String str, int i) {
            if (!ap.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").r("obj_locate", i).ae(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
