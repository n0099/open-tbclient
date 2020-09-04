package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes16.dex */
public class ag extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.y, a> {
    private boolean iek;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> iel;
    private String mForumId;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iek = false;
        this.iel = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cpQ */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(ag.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(UserRecommendItemView userRecommendItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public UserRecommendItemView activateObject(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public UserRecommendItemView passivateObject(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }
        }, 10, 0);
    }

    public void cpP() {
        this.iek = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.iek, this.mForumId);
        aVar.ieo.setViewPool(this.iel);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.y yVar, a aVar) {
        if (yVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iep.setText(yVar.cnJ());
            aVar.ieo.setPageContext(this.mPageContext);
            aVar.ieo.setData(yVar.getUserInfo());
            aVar.ien.setMaxOverScrollDistance(aVar.ieo.getChildItemWidth());
            aVar.iep.setTextColor(ap.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_e));
            if (!yVar.cnK()) {
                for (MetaData metaData : yVar.getUserInfo()) {
                    if (metaData != null && !at.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.cbY().e(new aq("c12530").dD("obj_id", metaData.getUserId()));
                    }
                }
                yVar.ov(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        private final String forumId;
        private boolean iek;
        FlexibleHorizontalScrollView ien;
        UserRecommendLayout ieo;
        TextView iep;
        View.OnClickListener ieq;
        View.OnClickListener ier;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.iek = false;
            this.ieq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a blL;
                    if (a.this.ien != null && a.this.ieo != null) {
                        a.this.ien.smoothScrollBy(a.this.ieo.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (blL = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).blL()) != null) {
                            a.this.aM(blL.getUserId(), 2);
                        }
                        if (a.this.iek) {
                            TiebaStatic.log(new aq("c13047").ai("obj_locate", 9).dD("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.ier = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aM(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.iek) {
                        TiebaStatic.log(new aq("c13047").ai("obj_locate", 9).dD("fid", a.this.forumId));
                    }
                }
            };
            this.iek = z;
            this.forumId = str;
            this.ien = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.ieo = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.ieo.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.ieo.setAfterLikeBtnClickListener(this.ieq);
            this.ieo.setAfterHeaderLickListener(this.ier);
            this.iep = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aM(String str, int i) {
            if (!at.isEmpty(str)) {
                TiebaStatic.log(new aq("c12531").ai("obj_locate", i).dD("obj_id", str));
            }
        }
    }
}
