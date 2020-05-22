package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
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
/* loaded from: classes9.dex */
public class ad extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.u, a> {
    private boolean hwK;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> hwL;
    private String mForumId;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hwK = false;
        this.hwL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bYu */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(ad.this.mContext);
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

    public void bYt() {
        this.hwK = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a b(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.hwK, this.mForumId);
        aVar.hwO.setViewPool(this.hwL);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.u uVar, a aVar) {
        if (uVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.hwP.setText(uVar.bWB());
            aVar.hwO.setPageContext(this.mPageContext);
            aVar.hwO.setData(uVar.getUserInfo());
            aVar.hwN.setMaxOverScrollDistance(aVar.hwO.getChildItemWidth());
            aVar.hwP.setTextColor(am.getColor(skinType, R.color.cp_cont_f));
            aVar.mRootView.setBackgroundColor(am.getColor(skinType, R.color.cp_bg_line_e));
            if (!uVar.bWC()) {
                for (MetaData metaData : uVar.getUserInfo()) {
                    if (metaData != null && !aq.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.s.bLq().e(new an("c12530").dh("obj_id", metaData.getUserId()));
                    }
                }
                uVar.mZ(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        private final String forumId;
        private boolean hwK;
        FlexibleHorizontalScrollView hwN;
        UserRecommendLayout hwO;
        TextView hwP;
        View.OnClickListener hwQ;
        View.OnClickListener hwR;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.hwK = false;
            this.hwQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ad.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a aXb;
                    if (a.this.hwN != null && a.this.hwO != null) {
                        a.this.hwN.smoothScrollBy(a.this.hwO.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (aXb = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).aXb()) != null) {
                            a.this.aL(aXb.getUserId(), 2);
                        }
                        if (a.this.hwK) {
                            TiebaStatic.log(new an("c13047").ag("obj_locate", 9).dh("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.hwR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aL(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.hwK) {
                        TiebaStatic.log(new an("c13047").ag("obj_locate", 9).dh("fid", a.this.forumId));
                    }
                }
            };
            this.hwK = z;
            this.forumId = str;
            this.hwN = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.hwO = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.hwO.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.hwO.setAfterLikeBtnClickListener(this.hwQ);
            this.hwO.setAfterHeaderLickListener(this.hwR);
            this.hwP = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aL(String str, int i) {
            if (!aq.isEmpty(str)) {
                TiebaStatic.log(new an("c12531").ag("obj_locate", i).dh("obj_id", str));
            }
        }
    }
}
