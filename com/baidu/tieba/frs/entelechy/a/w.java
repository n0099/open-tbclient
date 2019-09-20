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
    private boolean fFt;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> fFu;
    private String mForumId;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fFt = false;
        this.fFu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bqc */
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

    public void bqb() {
        this.fFt = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.fFt, this.mForumId);
        aVar.fFx.setViewPool(this.fFu);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.fFy.setText(qVar.bom());
            aVar.fFx.setPageContext(this.mPageContext);
            aVar.fFx.setData(qVar.getUserInfo());
            aVar.fFw.setMaxOverScrollDistance(aVar.fFx.getChildItemWidth());
            aVar.fFy.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.bOF.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!qVar.bon()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.bat().c(new an("c12530").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                qVar.kh(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        LinearLayout bOF;
        View.OnClickListener fFA;
        private boolean fFt;
        FlexibleHorizontalScrollView fFw;
        UserRecommendLayout fFx;
        TextView fFy;
        View.OnClickListener fFz;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.fFt = false;
            this.fFz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a alw;
                    if (a.this.fFw != null && a.this.fFx != null) {
                        a.this.fFw.smoothScrollBy(a.this.fFx.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (alw = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).alw()) != null) {
                            a.this.ax(alw.getUserId(), 2);
                        }
                        if (a.this.fFt) {
                            TiebaStatic.log(new an("c13047").P("obj_locate", 9).bT("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.fFA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.w.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.ax(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.fFt) {
                        TiebaStatic.log(new an("c13047").P("obj_locate", 9).bT("fid", a.this.forumId));
                    }
                }
            };
            this.fFt = z;
            this.forumId = str;
            this.fFw = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.fFx = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.fFx.setItemSpace(com.baidu.adp.lib.util.l.g(view.getContext(), R.dimen.ds16));
            this.fFx.setAfterLikeBtnClickListener(this.fFz);
            this.fFx.setAfterHeaderLickListener(this.fFA);
            this.fFy = (TextView) view.findViewById(R.id.user_recommend_document);
            this.bOF = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ax(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").P("obj_locate", i).bT(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
