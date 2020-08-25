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
    private boolean iee;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> ief;
    private String mForumId;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iee = false;
        this.ief = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cpP */
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

    public void cpO() {
        this.iee = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.iee, this.mForumId);
        aVar.iei.setViewPool(this.ief);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.y yVar, a aVar) {
        if (yVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.iej.setText(yVar.cnI());
            aVar.iei.setPageContext(this.mPageContext);
            aVar.iei.setData(yVar.getUserInfo());
            aVar.ieh.setMaxOverScrollDistance(aVar.iei.getChildItemWidth());
            aVar.iej.setTextColor(ap.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_e));
            if (!yVar.cnJ()) {
                for (MetaData metaData : yVar.getUserInfo()) {
                    if (metaData != null && !at.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.cbX().e(new aq("c12530").dD("obj_id", metaData.getUserId()));
                    }
                }
                yVar.ot(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        private final String forumId;
        private boolean iee;
        FlexibleHorizontalScrollView ieh;
        UserRecommendLayout iei;
        TextView iej;
        View.OnClickListener iek;
        View.OnClickListener iel;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.iee = false;
            this.iek = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a blL;
                    if (a.this.ieh != null && a.this.iei != null) {
                        a.this.ieh.smoothScrollBy(a.this.iei.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (blL = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).blL()) != null) {
                            a.this.aM(blL.getUserId(), 2);
                        }
                        if (a.this.iee) {
                            TiebaStatic.log(new aq("c13047").ai("obj_locate", 9).dD("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.iel = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aM(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.iee) {
                        TiebaStatic.log(new aq("c13047").ai("obj_locate", 9).dD("fid", a.this.forumId));
                    }
                }
            };
            this.iee = z;
            this.forumId = str;
            this.ieh = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.iei = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.iei.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.iei.setAfterLikeBtnClickListener(this.iek);
            this.iei.setAfterHeaderLickListener(this.iel);
            this.iej = (TextView) view.findViewById(R.id.user_recommend_document);
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
