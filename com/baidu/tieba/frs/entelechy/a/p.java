package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.UserRecommendLayout;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.frs.d<com.baidu.tieba.frs.q, a> {
    private com.baidu.adp.lib.e.b<com.baidu.tieba.frs.view.g> cwZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cwZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tieba.frs.view.g>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajn */
            public com.baidu.tieba.frs.view.g fI() {
                return new com.baidu.tieba.frs.view.g(p.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(com.baidu.tieba.frs.view.g gVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public com.baidu.tieba.frs.view.g o(com.baidu.tieba.frs.view.g gVar) {
                return gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tieba.frs.view.g p(com.baidu.tieba.frs.view.g gVar) {
                return gVar;
            }
        }, 10, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.mContext).inflate(d.j.card_user_recommend_layout, (ViewGroup) null, true));
        aVar.cxc.setViewPool(this.cwZ);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.q qVar, a aVar) {
        if (qVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aVar.cxd.setText(qVar.ahZ());
            aVar.cxc.setPageContext(this.mG);
            aVar.cxc.setData(qVar.getUserInfo());
            aVar.cxb.setMaxOverScrollDistance(aVar.cxc.getChildItemWidth());
            aVar.cxd.setTextColor(aj.getColor(skinType, d.e.cp_cont_b));
            aVar.aLj.setBackgroundColor(aj.getColor(skinType, d.e.cp_bg_line_e));
            if (!qVar.aia()) {
                for (MetaData metaData : qVar.getUserInfo()) {
                    if (metaData != null && !am.isEmpty(metaData.getUserId())) {
                        u.XR().a(new ak("c12530").ad("obj_id", metaData.getUserId()));
                    }
                }
                qVar.eJ(true);
            }
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        LinearLayout aLj;
        FlexibleHorizontalScrollView cxb;
        UserRecommendLayout cxc;
        TextView cxd;
        View.OnClickListener cxe;
        View.OnClickListener cxf;

        public a(View view) {
            super(view);
            this.cxe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.p.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.core.view.userLike.a wR;
                    if (a.this.cxb != null && a.this.cxc != null) {
                        a.this.cxb.smoothScrollBy(a.this.cxc.getChildItemWidth(), 0);
                        if ((view2.getTag() instanceof com.baidu.tbadk.core.view.userLike.c) && (wR = ((com.baidu.tbadk.core.view.userLike.c) view2.getTag()).wR()) != null) {
                            a.this.L(wR.getUserId(), 2);
                        }
                    }
                }
            };
            this.cxf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.p.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        a.this.L(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                }
            };
            this.cxb = (FlexibleHorizontalScrollView) view.findViewById(d.h.user_recommend_scroll_container);
            this.cxc = (UserRecommendLayout) view.findViewById(d.h.user_recommend_container);
            this.cxc.setItemSpace(com.baidu.adp.lib.util.l.f(view.getContext(), d.f.ds16));
            this.cxc.setAfterLikeBtnClickListener(this.cxe);
            this.cxc.setAfterHeaderLickListener(this.cxf);
            this.cxd = (TextView) view.findViewById(d.h.user_recommend_document);
            this.aLj = (LinearLayout) view.findViewById(d.h.user_recommend_root);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L(String str, int i) {
            if (!am.isEmpty(str)) {
                TiebaStatic.log(new ak("c12531").r("obj_locate", i).ad("obj_id", str));
            }
        }
    }
}
