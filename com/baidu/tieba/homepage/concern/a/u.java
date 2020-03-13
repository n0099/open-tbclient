package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, a> implements com.baidu.tieba.a.f {
    private String LC;
    public BdUniqueId dBx;
    private z fWU;
    private com.baidu.tieba.homepage.concern.view.b gYk;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWU = new z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && u.this.gYk != null && u.this.gYk.getView() != null && lVar != null && lVar.aAg() != null && !StringUtils.isNull(lVar.aAg().getTid())) {
                    if (view.getId() == R.id.user_avatar || view.getId() == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 1);
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 4);
                    } else if (view.getId() == R.id.layout_root) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
                    } else if (view.getId() == R.id.text_title) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public a b(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.b bVar = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        if (this.dBx != null) {
            bVar.m(this.dBx);
        }
        if (!ah(1)) {
            bVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.concern.a.u.2
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    u.this.g(i, i2, i3);
                    if (u.this.ah(1)) {
                        bVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.gYk = bVar;
        return new a(this.gYk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.gYn == null) {
            return null;
        }
        lVar.rt(i + 1);
        com.baidu.tieba.card.r.bvh().d(lVar.zZ("c12351"));
        if (aVar.gYn instanceof com.baidu.tieba.a.e) {
            aVar.gYn.setPage(this.LC);
        }
        aVar.gYn.a(lVar);
        aVar.gYn.c(this.fWU);
        return aVar.getView();
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public com.baidu.tieba.homepage.concern.view.b gYn;

        public a(com.baidu.tieba.homepage.concern.view.b bVar) {
            super(bVar.getView());
            this.gYn = bVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }
}
