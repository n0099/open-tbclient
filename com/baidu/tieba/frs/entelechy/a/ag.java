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
/* loaded from: classes21.dex */
public class ag extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.y, a> {
    private boolean ilk;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> ill;
    private String mForumId;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ilk = false;
        this.ill = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: ctd */
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

    public void ctc() {
        this.ilk = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.ilk, this.mForumId);
        aVar.ilo.setViewPool(this.ill);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.y yVar, a aVar) {
        if (yVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.ilp.setText(yVar.cqW());
            aVar.ilo.setPageContext(this.mPageContext);
            aVar.ilo.setData(yVar.getUserInfo());
            aVar.iln.setMaxOverScrollDistance(aVar.ilo.getChildItemWidth());
            aVar.ilp.setTextColor(ap.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(ap.getColor(skinType, R.color.cp_bg_line_e));
            if (!yVar.cqX()) {
                for (MetaData metaData : yVar.getUserInfo()) {
                    if (metaData != null && !at.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.cfn().e(new aq("c12530").dF("obj_id", metaData.getUserId()));
                    }
                }
                yVar.oB(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        private final String forumId;
        private boolean ilk;
        FlexibleHorizontalScrollView iln;
        UserRecommendLayout ilo;
        TextView ilp;
        View.OnClickListener ilq;
        View.OnClickListener ilr;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.ilk = false;
            this.ilq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a bmF;
                    if (a.this.iln != null && a.this.ilo != null) {
                        a.this.iln.smoothScrollBy(a.this.ilo.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (bmF = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).bmF()) != null) {
                            a.this.aM(bmF.getUserId(), 2);
                        }
                        if (a.this.ilk) {
                            TiebaStatic.log(new aq("c13047").ai("obj_locate", 9).dF("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.ilr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ag.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aM(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.ilk) {
                        TiebaStatic.log(new aq("c13047").ai("obj_locate", 9).dF("fid", a.this.forumId));
                    }
                }
            };
            this.ilk = z;
            this.forumId = str;
            this.iln = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.ilo = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.ilo.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.ilo.setAfterLikeBtnClickListener(this.ilq);
            this.ilo.setAfterHeaderLickListener(this.ilr);
            this.ilp = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aM(String str, int i) {
            if (!at.isEmpty(str)) {
                TiebaStatic.log(new aq("c12531").ai("obj_locate", i).dF("obj_id", str));
            }
        }
    }
}
