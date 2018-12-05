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
    private boolean dQD;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> dQE;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dQD = false;
        this.dQE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDV */
            public UserRecommendItemView jz() {
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

    public void aDU() {
        this.dQD = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_user_recommend_layout, viewGroup, false), this.dQD, this.mForumId);
        aVar.dQH.setViewPool(this.dQE);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dQI.setText(qVar.aCc());
            aVar.dQH.setPageContext(this.mPageContext);
            aVar.dQH.setData(qVar.getUserInfo());
            aVar.dQG.setMaxOverScrollDistance(aVar.dQH.getChildItemWidth());
            aVar.dQI.setTextColor(al.getColor(skinType, e.d.cp_cont_f));
            aVar.aJG.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_e));
            if (!qVar.aCd()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ao.isEmpty(metaData.getUserId())) {
                        v.apD().a(new am("c12530").aA(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.gG(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        LinearLayout aJG;
        private boolean dQD;
        FlexibleHorizontalScrollView dQG;
        UserRecommendLayout dQH;
        TextView dQI;
        View.OnClickListener dQJ;
        View.OnClickListener dQK;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.dQD = false;
            this.dQJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a Fz;
                    if (a.this.dQG != null && a.this.dQH != null) {
                        a.this.dQG.smoothScrollBy(a.this.dQH.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (Fz = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).Fz()) != null) {
                            a.this.ad(Fz.getUserId(), 2);
                        }
                        if (a.this.dQD) {
                            TiebaStatic.log(new am("c13047").x("obj_locate", 9).aA(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.dQK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.ad(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.dQD) {
                        TiebaStatic.log(new am("c13047").x("obj_locate", 9).aA(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.dQD = z;
            this.forumId = str;
            this.dQG = (FlexibleHorizontalScrollView) view.findViewById(e.g.user_recommend_scroll_container);
            this.dQH = (UserRecommendLayout) view.findViewById(e.g.user_recommend_container);
            this.dQH.setItemSpace(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0210e.ds16));
            this.dQH.setAfterLikeBtnClickListener(this.dQJ);
            this.dQH.setAfterHeaderLickListener(this.dQK);
            this.dQI = (TextView) view.findViewById(e.g.user_recommend_document);
            this.aJG = (LinearLayout) view.findViewById(e.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ad(String str, int i) {
            if (!ao.isEmpty(str)) {
                TiebaStatic.log(new am("c12531").x("obj_locate", i).aA(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
