package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b>> {
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private x cQm;
    private com.baidu.tieba.homepage.concern.view.b cQo;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cnQ;
    private com.baidu.adp.lib.e.b<TbImageView> cnR;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cnQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agV */
            public com.baidu.tbadk.widget.layout.b fT() {
                return new com.baidu.tbadk.widget.layout.b(c.this.alI.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void o(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b q(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cnR = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.homepage.concern.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xm */
            public TbImageView fT() {
                TbImageView tbImageView = new TbImageView(c.this.alI.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ai.getColor(d.e.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView p(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.cQm = new x<l>() { // from class: com.baidu.tieba.homepage.concern.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, l lVar) {
                if (view != null && c.this.cQo != null && c.this.cQo.getView() != null && lVar != null && lVar.MF() != null && !StringUtils.isNull(lVar.MF().getTid())) {
                    aj ajVar = new aj("c12352");
                    if ((c.this.cQo.getHeaderImg() != null && view.getId() == c.this.cQo.getHeaderImg().getId()) || (c.this.cQo.Wh() != null && view.getId() == c.this.cQo.Wh().getId())) {
                        ajVar.r("obj_locate", 1);
                    } else {
                        ajVar.r("obj_locate", 2);
                    }
                    ajVar.aa("obj_type", lVar.WI());
                    ajVar.aa("tid", lVar.threadData.getTid());
                    ajVar.g("fid", lVar.threadData.getFid());
                    ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> onCreateViewHolder(ViewGroup viewGroup) {
        this.cQo = new com.baidu.tieba.homepage.concern.view.b(this.alI);
        this.cQo.setConstrainLayoutPool(this.cnQ);
        this.cQo.setConstrainImagePool(this.cnR);
        this.cQo.j(this.aOM);
        return new com.baidu.tieba.card.a.a<>(this.cQo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.b> aVar) {
        if (lVar == null || aVar == null || aVar.Xc() == null) {
            return null;
        }
        lVar.hv(i + 1);
        u.WB().a(lVar.jk("c12351"));
        aVar.Xc().a(lVar);
        aVar.Xc().a(this.cQm);
        return aVar.getView();
    }
}
