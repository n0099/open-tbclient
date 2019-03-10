package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes4.dex */
public class v extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.q, a> {
    private boolean fhO;
    private b<UserRecommendItemView> fhP;
    private String mForumId;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fhO = false;
        this.fhP = new b<>(new c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bfK */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(v.this.mContext);
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

    public void bfJ() {
        this.fhO = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_user_recommend_layout, viewGroup, false), this.fhO, this.mForumId);
        aVar.fhS.setViewPool(this.fhP);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fhT.setText(qVar.bdY());
            aVar.fhS.setPageContext(this.mPageContext);
            aVar.fhS.setData(qVar.getUserInfo());
            aVar.fhR.setMaxOverScrollDistance(aVar.fhS.getChildItemWidth());
            aVar.fhT.setTextColor(al.getColor(skinType, d.C0236d.cp_cont_f));
            aVar.bFu.setBackgroundColor(al.getColor(skinType, d.C0236d.cp_bg_line_e));
            if (!qVar.bdZ()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ap.isEmpty(metaData.getUserId())) {
                        t.aQG().b(new am("c12530").bJ(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.jk(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        LinearLayout bFu;
        private boolean fhO;
        FlexibleHorizontalScrollView fhR;
        UserRecommendLayout fhS;
        TextView fhT;
        View.OnClickListener fhU;
        View.OnClickListener fhV;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.fhO = false;
            this.fhU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.v.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a afh;
                    if (a.this.fhR != null && a.this.fhS != null) {
                        a.this.fhR.smoothScrollBy(a.this.fhS.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (afh = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).afh()) != null) {
                            a.this.ay(afh.getUserId(), 2);
                        }
                        if (a.this.fhO) {
                            TiebaStatic.log(new am("c13047").T("obj_locate", 9).bJ(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.fhV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.v.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.ay(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.fhO) {
                        TiebaStatic.log(new am("c13047").T("obj_locate", 9).bJ(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.fhO = z;
            this.forumId = str;
            this.fhR = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.fhS = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.fhS.setItemSpace(com.baidu.adp.lib.util.l.h(view.getContext(), d.e.ds16));
            this.fhS.setAfterLikeBtnClickListener(this.fhU);
            this.fhS.setAfterHeaderLickListener(this.fhV);
            this.fhT = (TextView) view.findViewById(d.g.user_recommend_document);
            this.bFu = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ay(String str, int i) {
            if (!ap.isEmpty(str)) {
                TiebaStatic.log(new am("c12531").T("obj_locate", i).bJ(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
