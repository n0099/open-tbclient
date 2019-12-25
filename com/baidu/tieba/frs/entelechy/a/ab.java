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
/* loaded from: classes6.dex */
public class ab extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.r, a> {
    private boolean gsm;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> gsn;
    private String mForumId;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gsm = false;
        this.gsn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bED */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(ab.this.mContext);
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

    public void bEC() {
        this.gsm = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.gsm, this.mForumId);
        aVar.gsq.setViewPool(this.gsn);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.r rVar, a aVar) {
        if (rVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.gsr.setText(rVar.bCL());
            aVar.gsq.setPageContext(this.mPageContext);
            aVar.gsq.setData(rVar.getUserInfo());
            aVar.gsp.setMaxOverScrollDistance(aVar.gsq.getChildItemWidth());
            aVar.gsr.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!rVar.bCM()) {
                for (MetaData metaData : rVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.r.bsy().c(new an("c12530").cp("obj_id", metaData.getUserId()));
                    }
                }
                rVar.lh(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        private final String forumId;
        private boolean gsm;
        FlexibleHorizontalScrollView gsp;
        UserRecommendLayout gsq;
        TextView gsr;
        View.OnClickListener gss;
        View.OnClickListener gst;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.gsm = false;
            this.gss = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ab.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a aFL;
                    if (a.this.gsp != null && a.this.gsq != null) {
                        a.this.gsp.smoothScrollBy(a.this.gsq.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (aFL = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).aFL()) != null) {
                            a.this.aB(aFL.getUserId(), 2);
                        }
                        if (a.this.gsm) {
                            TiebaStatic.log(new an("c13047").Z("obj_locate", 9).cp("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.gst = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ab.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aB(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.gsm) {
                        TiebaStatic.log(new an("c13047").Z("obj_locate", 9).cp("fid", a.this.forumId));
                    }
                }
            };
            this.gsm = z;
            this.forumId = str;
            this.gsp = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.gsq = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.gsq.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.gsq.setAfterLikeBtnClickListener(this.gss);
            this.gsq.setAfterHeaderLickListener(this.gst);
            this.gsr = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aB(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").Z("obj_locate", i).cp("obj_id", str));
            }
        }
    }
}
