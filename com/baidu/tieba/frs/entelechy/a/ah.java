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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes22.dex */
public class ah extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.x, a> {
    private boolean jel;
    private com.baidu.adp.lib.d.b<UserRecommendItemView> jem;
    private String mForumId;

    public ah(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jel = false;
        this.jem = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.ah.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cGf */
            public UserRecommendItemView makeObject() {
                return new UserRecommendItemView(ah.this.mContext);
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

    public void cGe() {
        this.jel = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public a c(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.card_user_recommend_layout, viewGroup, false), this.jel, this.mForumId);
        aVar.jep.setViewPool(this.jem);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.x xVar, a aVar) {
        if (xVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.jeq.setText(xVar.cDW());
            aVar.jep.setPageContext(this.mPageContext);
            aVar.jep.setData(xVar.getUserInfo());
            aVar.jeo.setMaxOverScrollDistance(aVar.jep.getChildItemWidth());
            aVar.jeq.setTextColor(ap.getColor(skinType, R.color.CAM_X0106));
            aVar.mRootView.setBackgroundColor(ap.getColor(skinType, R.color.CAM_X0205));
            if (!xVar.cDX()) {
                for (MetaData metaData : xVar.getUserInfo()) {
                    if (metaData != null && !au.isEmpty(metaData.getUserId())) {
                        com.baidu.tieba.card.t.csh().e(new ar("c12530").dY("obj_id", metaData.getUserId()));
                    }
                }
                xVar.qh(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        private final String forumId;
        private boolean jel;
        FlexibleHorizontalScrollView jeo;
        UserRecommendLayout jep;
        TextView jeq;
        View.OnClickListener jer;
        View.OnClickListener jes;
        LinearLayout mRootView;

        public a(View view, boolean z, String str) {
            super(view);
            this.jel = false;
            this.jer = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ah.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a bwy;
                    if (a.this.jeo != null && a.this.jep != null) {
                        a.this.jeo.smoothScrollBy(a.this.jep.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (bwy = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).bwy()) != null) {
                            a.this.aQ(bwy.getUserId(), 2);
                        }
                        if (a.this.jel) {
                            TiebaStatic.log(new ar("c13047").al("obj_locate", 9).dY("fid", a.this.forumId));
                        }
                    }
                }
            };
            this.jes = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.ah.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.aQ(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.jel) {
                        TiebaStatic.log(new ar("c13047").al("obj_locate", 9).dY("fid", a.this.forumId));
                    }
                }
            };
            this.jel = z;
            this.forumId = str;
            this.jeo = (FlexibleHorizontalScrollView) view.findViewById(R.id.user_recommend_scroll_container);
            this.jep = (UserRecommendLayout) view.findViewById(R.id.user_recommend_container);
            this.jep.setItemSpace(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds16));
            this.jep.setAfterLikeBtnClickListener(this.jer);
            this.jep.setAfterHeaderLickListener(this.jes);
            this.jeq = (TextView) view.findViewById(R.id.user_recommend_document);
            this.mRootView = (LinearLayout) view.findViewById(R.id.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aQ(String str, int i) {
            if (!au.isEmpty(str)) {
                TiebaStatic.log(new ar("c12531").al("obj_locate", i).dY("obj_id", str));
            }
        }
    }
}
