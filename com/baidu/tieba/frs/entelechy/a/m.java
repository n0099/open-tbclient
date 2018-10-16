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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes6.dex */
public class m extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.q, a> {
    private boolean dIW;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> dIX;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dIW = false;
        this.dIX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aCO */
            public UserRecommendItemView jB() {
                return new UserRecommendItemView(m.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(UserRecommendItemView userRecommendItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public UserRecommendItemView v(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public UserRecommendItemView w(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }
        }, 10, 0);
    }

    public void aCN() {
        this.dIW = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_user_recommend_layout, viewGroup, false), this.dIW, this.mForumId);
        aVar.dJa.setViewPool(this.dIX);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dJb.setText(qVar.aAU());
            aVar.dJa.setPageContext(this.mPageContext);
            aVar.dJa.setData(qVar.getUserInfo());
            aVar.dIZ.setMaxOverScrollDistance(aVar.dJa.getChildItemWidth());
            aVar.dJb.setTextColor(al.getColor(skinType, e.d.cp_cont_f));
            aVar.aFq.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_e));
            if (!qVar.aAV()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ao.isEmpty(metaData.getUserId())) {
                        v.aoo().a(new am("c12530").ax(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.gv(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        LinearLayout aFq;
        private boolean dIW;
        FlexibleHorizontalScrollView dIZ;
        UserRecommendLayout dJa;
        TextView dJb;
        View.OnClickListener dJc;
        View.OnClickListener dJd;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.dIW = false;
            this.dJc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a El;
                    if (a.this.dIZ != null && a.this.dJa != null) {
                        a.this.dIZ.smoothScrollBy(a.this.dJa.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (El = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).El()) != null) {
                            a.this.ac(El.getUserId(), 2);
                        }
                        if (a.this.dIW) {
                            TiebaStatic.log(new am("c13047").x("obj_locate", 9).ax(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.dJd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.ac(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.dIW) {
                        TiebaStatic.log(new am("c13047").x("obj_locate", 9).ax(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.dIW = z;
            this.forumId = str;
            this.dIZ = (FlexibleHorizontalScrollView) view.findViewById(e.g.user_recommend_scroll_container);
            this.dJa = (UserRecommendLayout) view.findViewById(e.g.user_recommend_container);
            this.dJa.setItemSpace(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0175e.ds16));
            this.dJa.setAfterLikeBtnClickListener(this.dJc);
            this.dJa.setAfterHeaderLickListener(this.dJd);
            this.dJb = (TextView) view.findViewById(e.g.user_recommend_document);
            this.aFq = (LinearLayout) view.findViewById(e.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ac(String str, int i) {
            if (!ao.isEmpty(str)) {
                TiebaStatic.log(new am("c12531").x("obj_locate", i).ax(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
