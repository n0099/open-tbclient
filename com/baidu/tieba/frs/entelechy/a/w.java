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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes4.dex */
public class w extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.q, a> {
    private boolean fDG;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> fDH;
    private String mForumId;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fDG = false;
        this.fDH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bpr */
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

    public void bpq() {
        this.fDG = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.fDG, this.mForumId);
        aVar.fDK.setViewPool(this.fDH);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fDL.setText(qVar.bnB());
            aVar.fDK.setPageContext(this.mPageContext);
            aVar.fDK.setData(qVar.getUserInfo());
            aVar.fDJ.setMaxOverScrollDistance(aVar.fDK.getChildItemWidth());
            aVar.fDL.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.bOg.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!qVar.bnC()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.aZP().c(new an("c12530").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.ke(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        LinearLayout bOg;
        private boolean fDG;
        FlexibleHorizontalScrollView fDJ;
        UserRecommendLayout fDK;
        TextView fDL;
        View.OnClickListener fDM;
        View.OnClickListener fDN;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.fDG = false;
            this.fDM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a alk;
                    if (a.this.fDJ != null && a.this.fDK != null) {
                        a.this.fDJ.smoothScrollBy(a.this.fDK.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (alk = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).alk()) != null) {
                            a.this.av(alk.getUserId(), 2);
                        }
                        if (a.this.fDG) {
                            TiebaStatic.log(new an("c13047").P("obj_locate", 9).bT("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.fDN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.av(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.fDG) {
                        TiebaStatic.log(new an("c13047").P("obj_locate", 9).bT("fid", a.this.forumId));
                    }
                }
            };
            this.fDG = z;
            this.forumId = str;
            this.fDJ = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.fDK = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.fDK.setItemSpace(com.baidu.adp.lib.util.l.g(view.getContext(), R.dimen.ds16));
            this.fDK.setAfterLikeBtnClickListener(this.fDM);
            this.fDK.setAfterHeaderLickListener(this.fDN);
            this.fDL = (TextView) view.findViewById(R.id.user_recommend_document);
            this.bOg = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void av(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").P("obj_locate", i).bT(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
