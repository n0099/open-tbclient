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
    private boolean fCS;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> fCT;
    private String mForumId;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fCS = false;
        this.fCT = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bpe */
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

    public void bpd() {
        this.fCS = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.fCS, this.mForumId);
        aVar.fCW.setViewPool(this.fCT);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fCX.setText(qVar.bnr());
            aVar.fCW.setPageContext(this.mPageContext);
            aVar.fCW.setData(qVar.getUserInfo());
            aVar.fCV.setMaxOverScrollDistance(aVar.fCW.getChildItemWidth());
            aVar.fCX.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.bOb.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!qVar.bns()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.aZN().c(new an("c12530").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.ke(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        LinearLayout bOb;
        private boolean fCS;
        FlexibleHorizontalScrollView fCV;
        UserRecommendLayout fCW;
        TextView fCX;
        View.OnClickListener fCY;
        View.OnClickListener fCZ;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.fCS = false;
            this.fCY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a ali;
                    if (a.this.fCV != null && a.this.fCW != null) {
                        a.this.fCV.smoothScrollBy(a.this.fCW.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (ali = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).ali()) != null) {
                            a.this.av(ali.getUserId(), 2);
                        }
                        if (a.this.fCS) {
                            TiebaStatic.log(new an("c13047").P("obj_locate", 9).bT("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.fCZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.av(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.fCS) {
                        TiebaStatic.log(new an("c13047").P("obj_locate", 9).bT("fid", a.this.forumId));
                    }
                }
            };
            this.fCS = z;
            this.forumId = str;
            this.fCV = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.fCW = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.fCW.setItemSpace(com.baidu.adp.lib.util.l.g(view.getContext(), R.dimen.ds16));
            this.fCW.setAfterLikeBtnClickListener(this.fCY);
            this.fCW.setAfterHeaderLickListener(this.fCZ);
            this.fCX = (TextView) view.findViewById(R.id.user_recommend_document);
            this.bOb = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void av(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").P("obj_locate", i).bT(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
