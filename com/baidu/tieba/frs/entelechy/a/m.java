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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes6.dex */
public class m extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.q, a> {
    private boolean dTu;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> dTv;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dTu = false;
        this.dTv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aEK */
            public UserRecommendItemView jz() {
                return new UserRecommendItemView(m.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(UserRecommendItemView userRecommendItemView) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public UserRecommendItemView v(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public UserRecommendItemView w(UserRecommendItemView userRecommendItemView) {
                return userRecommendItemView;
            }
        }, 10, 0);
    }

    public void aEJ() {
        this.dTu = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(e.h.card_user_recommend_layout, viewGroup, false), this.dTu, this.mForumId);
        aVar.dTy.setViewPool(this.dTv);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.dTz.setText(qVar.aCR());
            aVar.dTy.setPageContext(this.mPageContext);
            aVar.dTy.setData(qVar.getUserInfo());
            aVar.dTx.setMaxOverScrollDistance(aVar.dTy.getChildItemWidth());
            aVar.dTz.setTextColor(al.getColor(skinType, e.d.cp_cont_f));
            aVar.aJI.setBackgroundColor(al.getColor(skinType, e.d.cp_bg_line_e));
            if (!qVar.aCS()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !ao.isEmpty(metaData.getUserId())) {
                        v.aqs().a(new am("c12530").aA(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.gJ(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        LinearLayout aJI;
        View.OnClickListener dTA;
        View.OnClickListener dTB;
        private boolean dTu;
        FlexibleHorizontalScrollView dTx;
        UserRecommendLayout dTy;
        TextView dTz;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.dTu = false;
            this.dTA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a FA;
                    if (a.this.dTx != null && a.this.dTy != null) {
                        a.this.dTx.smoothScrollBy(a.this.dTy.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (FA = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).FA()) != null) {
                            a.this.ae(FA.getUserId(), 2);
                        }
                        if (a.this.dTu) {
                            TiebaStatic.log(new am("c13047").x("obj_locate", 9).aA(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.dTB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.ae(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.dTu) {
                        TiebaStatic.log(new am("c13047").x("obj_locate", 9).aA(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.dTu = z;
            this.forumId = str;
            this.dTx = (FlexibleHorizontalScrollView) view.findViewById(e.g.user_recommend_scroll_container);
            this.dTy = (UserRecommendLayout) view.findViewById(e.g.user_recommend_container);
            this.dTy.setItemSpace(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0210e.ds16));
            this.dTy.setAfterLikeBtnClickListener(this.dTA);
            this.dTy.setAfterHeaderLickListener(this.dTB);
            this.dTz = (TextView) view.findViewById(e.g.user_recommend_document);
            this.aJI = (LinearLayout) view.findViewById(e.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ae(String str, int i) {
            if (!ao.isEmpty(str)) {
                TiebaStatic.log(new am("c12531").x("obj_locate", i).aA(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
