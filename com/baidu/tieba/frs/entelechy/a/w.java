package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes4.dex */
public class w extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.q, a> {
    private boolean fxW;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> fxX;
    private String mForumId;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fxW = false;
        this.fxX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bnd */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(w.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(UserRecommendItemView userRecommendItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public UserRecommendItemView activateObject(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public UserRecommendItemView passivateObject(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }
        }, 10, 0);
    }

    public void bnc() {
        this.fxW = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.fxW, this.mForumId);
        aVar.fya.setViewPool(this.fxX);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fyb.setText(qVar.blq());
            aVar.fya.setPageContext(this.mPageContext);
            aVar.fya.setData(qVar.getUserInfo());
            aVar.fxZ.setMaxOverScrollDistance(aVar.fya.getChildItemWidth());
            aVar.fyb.setTextColor(al.getColor(skinType, R.color.cp_cont_f));
            aVar.bMZ.setBackgroundColor(al.getColor(skinType, R.color.cp_bg_line_e));
            if (!qVar.blr()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ap.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.aXP().b(new am("c12530").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.jU(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        LinearLayout bMZ;
        private final String forumId;
        private boolean fxW;
        FlexibleHorizontalScrollView fxZ;
        UserRecommendLayout fya;
        TextView fyb;
        View.OnClickListener fyc;
        View.OnClickListener fyd;

        public a(View view, boolean z, String str) {
            super(view);
            this.fxW = false;
            this.fyc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a akd;
                    if (a.this.fxZ != null && a.this.fya != null) {
                        a.this.fxZ.smoothScrollBy(a.this.fya.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (akd = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).akd()) != null) {
                            a.this.au(akd.getUserId(), 2);
                        }
                        if (a.this.fxW) {
                            TiebaStatic.log(new am("c13047").P("obj_locate", 9).bT("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.fyd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.au(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.fxW) {
                        TiebaStatic.log(new am("c13047").P("obj_locate", 9).bT("fid", a.this.forumId));
                    }
                }
            };
            this.fxW = z;
            this.forumId = str;
            this.fxZ = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.fya = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.fya.setItemSpace(com.baidu.adp.lib.util.l.g(view.getContext(), R.dimen.ds16));
            this.fya.setAfterLikeBtnClickListener(this.fyc);
            this.fya.setAfterHeaderLickListener(this.fyd);
            this.fyb = (TextView) view.findViewById(R.id.user_recommend_document);
            this.bMZ = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void au(String str, int i) {
            if (!ap.isEmpty(str)) {
                TiebaStatic.log(new am("c12531").P("obj_locate", i).bT(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
