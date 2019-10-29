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
    private boolean fEK;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> fEL;
    private String mForumId;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fEK = false;
        this.fEL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bnh */
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

    public void bng() {
        this.fEK = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.fEK, this.mForumId);
        aVar.fEO.setViewPool(this.fEL);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fEP.setText(qVar.blq());
            aVar.fEO.setPageContext(this.mPageContext);
            aVar.fEO.setData(qVar.getUserInfo());
            aVar.fEN.setMaxOverScrollDistance(aVar.fEO.getChildItemWidth());
            aVar.fEP.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!qVar.blr()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.baw().c(new an("c12530").bS("obj_id", metaData.getUserId()));
                    }
                }
                qVar.jV(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        private boolean fEK;
        FlexibleHorizontalScrollView fEN;
        UserRecommendLayout fEO;
        TextView fEP;
        View.OnClickListener fEQ;
        View.OnClickListener fER;
        private final String forumId;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.fEK = false;
            this.fEQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a aok;
                    if (a.this.fEN != null && a.this.fEO != null) {
                        a.this.fEN.smoothScrollBy(a.this.fEO.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (aok = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).aok()) != null) {
                            a.this.as(aok.getUserId(), 2);
                        }
                        if (a.this.fEK) {
                            TiebaStatic.log(new an("c13047").O("obj_locate", 9).bS("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.fER = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.as(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.fEK) {
                        TiebaStatic.log(new an("c13047").O("obj_locate", 9).bS("fid", a.this.forumId));
                    }
                }
            };
            this.fEK = z;
            this.forumId = str;
            this.fEN = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.fEO = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.fEO.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.fEO.setAfterLikeBtnClickListener(this.fEQ);
            this.fEO.setAfterHeaderLickListener(this.fER);
            this.fEP = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void as(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").O("obj_locate", i).bS("obj_id", str));
            }
        }
    }
}
