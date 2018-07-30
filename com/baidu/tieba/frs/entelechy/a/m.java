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
    private boolean dus;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> dut;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dus = false;
        this.dut = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axj */
            public UserRecommendItemView ig() {
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

    public void axi() {
        this.dus = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.h.card_user_recommend_layout, viewGroup, false), this.dus, this.mForumId);
        aVar.duw.setViewPool(this.dut);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dux.setText(qVar.avG());
            aVar.duw.setPageContext(this.mPageContext);
            aVar.duw.setData(qVar.getUserInfo());
            aVar.duv.setMaxOverScrollDistance(aVar.duw.getChildItemWidth());
            aVar.dux.setTextColor(am.getColor(skinType, d.C0140d.cp_cont_f));
            aVar.axG.setBackgroundColor(am.getColor(skinType, d.C0140d.cp_bg_line_e));
            if (!qVar.avH()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ap.isEmpty(metaData.getUserId())) {
                        v.aiY().a(new an("c12530").af(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.fM(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        LinearLayout axG;
        private boolean dus;
        FlexibleHorizontalScrollView duv;
        UserRecommendLayout duw;
        TextView dux;
        View.OnClickListener duy;
        View.OnClickListener duz;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.dus = false;
            this.duy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a AX;
                    if (a.this.duv != null && a.this.duw != null) {
                        a.this.duv.smoothScrollBy(a.this.duw.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (AX = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).AX()) != null) {
                            a.this.T(AX.getUserId(), 2);
                        }
                        if (a.this.dus) {
                            TiebaStatic.log(new an("c13047").r("obj_locate", 9).af(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.duz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.T(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.dus) {
                        TiebaStatic.log(new an("c13047").r("obj_locate", 9).af(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.dus = z;
            this.forumId = str;
            this.duv = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.duw = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.duw.setItemSpace(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds16));
            this.duw.setAfterLikeBtnClickListener(this.duy);
            this.duw.setAfterHeaderLickListener(this.duz);
            this.dux = (TextView) view.findViewById(d.g.user_recommend_document);
            this.axG = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T(String str, int i) {
            if (!ap.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").r("obj_locate", i).af(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
