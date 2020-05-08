package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.c> {
    public AlaBannerAutoScrollView<com.baidu.tieba.ala.alasquare.special_forum.data.b> eXd;
    private com.baidu.tieba.ala.alasquare.widget.banner.c eXe;
    private TbPageContext mTbPageContext;

    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eXe = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.h.2
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(h.this.mTbPageContext.getPageActivity()).inflate(R.layout.special_bar_recommend_activity, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.h.2.1
                    public TbImageView eXg;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void ag(View view) {
                        this.eXg = (TbImageView) view.findViewById(R.id.cover);
                        this.eXg.setDefaultErrorResource(0);
                        this.eXg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.eXg != null && !StringUtils.isNull(bVar.pic)) {
                            this.eXg.startLoad(bVar.pic, 10, false);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                    }
                };
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eXd = (AlaBannerAutoScrollView) getView().findViewById(R.id.banner_container);
        this.eXd.setViewHolderAdapter(this.eXe);
        this.eXd.setOnBannerClickListener(new com.baidu.tieba.ala.alasquare.widget.banner.d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.h.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public void as(Object obj) {
                if (obj != null && (obj instanceof com.baidu.tieba.ala.alasquare.special_forum.data.b)) {
                    com.baidu.tieba.ala.alasquare.special_forum.data.b bVar = (com.baidu.tieba.ala.alasquare.special_forum.data.b) obj;
                    if (!StringUtils.isNull(bVar.url)) {
                        ba.aOV().a((TbPageContext) com.baidu.adp.base.i.G(h.this.mTbPageContext.getPageActivity()), new String[]{bVar.url}, true);
                    }
                    TiebaStatic.log("c12902");
                }
            }
        });
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eXd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.special_bar_recommend_banner;
    }

    @Override // com.baidu.tieba.card.a
    public View getView() {
        return super.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.c cVar) {
        if (cVar != null && !v.isEmpty(cVar.eVA)) {
            this.eXd.a(cVar.eVA, this.eXe);
            TiebaStatic.log("c12901");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends y.a {
        public View cTu;
        public h eXi;

        public a(h hVar) {
            super(hVar.getView());
            this.eXi = hVar;
            this.cTu = hVar.getView();
        }
    }
}
