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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes2.dex */
public class m extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.q, a> {
    private boolean drF;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> drG;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.drF = false;
        this.drG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awE */
            public UserRecommendItemView mo9if() {
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

    public void awD() {
        this.drF = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_user_recommend_layout, viewGroup, false), this.drF, this.mForumId);
        aVar.drJ.setViewPool(this.drG);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.drK.setText(qVar.avb());
            aVar.drJ.setPageContext(this.mPageContext);
            aVar.drJ.setData(qVar.getUserInfo());
            aVar.drI.setMaxOverScrollDistance(aVar.drJ.getChildItemWidth());
            aVar.drK.setTextColor(am.getColor(skinType, d.C0142d.cp_cont_f));
            aVar.aya.setBackgroundColor(am.getColor(skinType, d.C0142d.cp_bg_line_e));
            if (!qVar.avc()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ap.isEmpty(metaData.getUserId())) {
                        v.aiz().a(new an("c12530").ah(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.fK(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        LinearLayout aya;
        private boolean drF;
        FlexibleHorizontalScrollView drI;
        UserRecommendLayout drJ;
        TextView drK;
        View.OnClickListener drL;
        View.OnClickListener drM;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.drF = false;
            this.drL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a Bg;
                    if (a.this.drI != null && a.this.drJ != null) {
                        a.this.drI.smoothScrollBy(a.this.drJ.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (Bg = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).Bg()) != null) {
                            a.this.X(Bg.getUserId(), 2);
                        }
                        if (a.this.drF) {
                            TiebaStatic.log(new an("c13047").r("obj_locate", 9).ah(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.drM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.X(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.drF) {
                        TiebaStatic.log(new an("c13047").r("obj_locate", 9).ah(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.drF = z;
            this.forumId = str;
            this.drI = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.drJ = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.drJ.setItemSpace(com.baidu.adp.lib.util.l.e(view.getContext(), d.e.ds16));
            this.drJ.setAfterLikeBtnClickListener(this.drL);
            this.drJ.setAfterHeaderLickListener(this.drM);
            this.drK = (TextView) view.findViewById(d.g.user_recommend_document);
            this.aya = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X(String str, int i) {
            if (!ap.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").r("obj_locate", i).ah(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
