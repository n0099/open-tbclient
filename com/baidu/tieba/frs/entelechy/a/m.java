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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes2.dex */
public class m extends com.baidu.tieba.frs.f<com.baidu.tieba.frs.o, a> {
    private boolean dow;
    private com.baidu.adp.lib.e.b<UserRecommendItemView> dox;
    private String mForumId;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dow = false;
        this.dox = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<UserRecommendItemView>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awa */
            public UserRecommendItemView mo9if() {
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

    public void avZ() {
        this.dow = true;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.i.card_user_recommend_layout, viewGroup, false), this.dow, this.mForumId);
        aVar.doA.setViewPool(this.dox);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.o oVar, a aVar) {
        if (oVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.doB.setText(oVar.auH());
            aVar.doA.setPageContext(this.mPageContext);
            aVar.doA.setData(oVar.getUserInfo());
            aVar.doz.setMaxOverScrollDistance(aVar.doA.getChildItemWidth());
            aVar.doB.setTextColor(al.getColor(skinType, d.C0141d.cp_cont_f));
            aVar.aUT.setBackgroundColor(al.getColor(skinType, d.C0141d.cp_bg_line_e));
            if (!oVar.auI()) {
                for (MetaData metaData : oVar.getUserInfo()) {
                    if (metaData != null && !ao.isEmpty(metaData.getUserId())) {
                        v.ajh().a(new am("c12530").ah(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()));
                    }
                }
                oVar.fG(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        LinearLayout aUT;
        UserRecommendLayout doA;
        TextView doB;
        View.OnClickListener doC;
        View.OnClickListener doD;
        private boolean dow;
        FlexibleHorizontalScrollView doz;
        private final String forumId;

        public a(View view, boolean z, String str) {
            super(view);
            this.dow = false;
            this.doC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a AO;
                    if (a.this.doz != null && a.this.doA != null) {
                        a.this.doz.smoothScrollBy(a.this.doA.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (AO = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).AO()) != null) {
                            a.this.Y(AO.getUserId(), 2);
                        }
                        if (a.this.dow) {
                            TiebaStatic.log(new am("c13047").r("obj_locate", 9).ah(ImageViewerConfig.FORUM_ID, a.this.forumId));
                        }
                    }
                }
            };
            this.doD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.Y(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (a.this.dow) {
                        TiebaStatic.log(new am("c13047").r("obj_locate", 9).ah(ImageViewerConfig.FORUM_ID, a.this.forumId));
                    }
                }
            };
            this.dow = z;
            this.forumId = str;
            this.doz = (FlexibleHorizontalScrollView) view.findViewById(d.g.user_recommend_scroll_container);
            this.doA = (UserRecommendLayout) view.findViewById(d.g.user_recommend_container);
            this.doA.setItemSpace(com.baidu.adp.lib.util.l.e(view.getContext(), d.e.ds16));
            this.doA.setAfterLikeBtnClickListener(this.doC);
            this.doA.setAfterHeaderLickListener(this.doD);
            this.doB = (TextView) view.findViewById(d.g.user_recommend_document);
            this.aUT = (LinearLayout) view.findViewById(d.g.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y(String str, int i) {
            if (!ao.isEmpty(str)) {
                TiebaStatic.log(new am("c12531").r("obj_locate", i).ah(VideoPlayActivityConfig.OBJ_ID, str));
            }
        }
    }
}
