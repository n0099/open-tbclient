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
/* loaded from: classes2.dex */
public class m extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.q, a> {
    private boolean dAW;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> dAX;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dAW = false;
        this.dAX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: azv */
            public UserRecommendItemView jm() {
                return new UserRecommendItemView(m.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void r(UserRecommendItemView userRecommendItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public UserRecommendItemView s(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public UserRecommendItemView t(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }
        }, 10, 0);
    }

    public void azu() {
        this.dAW = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_user_recommend_layout, viewGroup, false), this.dAW, this.mForumId);
        aVar.dBa.setViewPool(this.dAX);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dBb.setText(qVar.axz());
            aVar.dBa.setPageContext(this.mPageContext);
            aVar.dBa.setData(qVar.getUserInfo());
            aVar.dAZ.setMaxOverScrollDistance(aVar.dBa.getChildItemWidth());
            aVar.dBb.setTextColor(al.getColor(skinType, e.d.cp_cont_f));
            aVar.aAJ.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_e));
            if (!qVar.axA()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ao.isEmpty(metaData.getUserId())) {
                        v.akM().a(new am("c12530").al(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.gd(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        LinearLayout aAJ;
        private boolean dAW;
        FlexibleHorizontalScrollView dAZ;
        UserRecommendLayout dBa;
        TextView dBb;
        View.OnClickListener dBc;
        View.OnClickListener dBd;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.dAW = false;
            this.dBc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a Cg;
                    if (a.this.dAZ != null && a.this.dBa != null) {
                        a.this.dAZ.smoothScrollBy(a.this.dBa.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (Cg = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).Cg()) != null) {
                            a.this.Y(Cg.getUserId(), 2);
                        }
                        if (a.this.dAW) {
                            TiebaStatic.log(new am("c13047").w("obj_locate", 9).al(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.dBd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.Y(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.dAW) {
                        TiebaStatic.log(new am("c13047").w("obj_locate", 9).al(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.dAW = z;
            this.forumId = str;
            this.dAZ = (FlexibleHorizontalScrollView) view.findViewById(e.g.user_recommend_scroll_container);
            this.dBa = (UserRecommendLayout) view.findViewById(e.g.user_recommend_container);
            this.dBa.setItemSpace(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0141e.ds16));
            this.dBa.setAfterLikeBtnClickListener(this.dBc);
            this.dBa.setAfterHeaderLickListener(this.dBd);
            this.dBb = (TextView) view.findViewById(e.g.user_recommend_document);
            this.aAJ = (LinearLayout) view.findViewById(e.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y(String str, int i) {
            if (!ao.isEmpty(str)) {
                TiebaStatic.log(new am("c12531").w("obj_locate", i).al(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
