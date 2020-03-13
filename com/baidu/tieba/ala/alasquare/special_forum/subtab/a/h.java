package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
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
    public AlaBannerAutoScrollView<com.baidu.tieba.ala.alasquare.special_forum.data.b> eth;
    private com.baidu.tieba.ala.alasquare.widget.banner.c eti;
    private TbPageContext mTbPageContext;

    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eti = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.h.2
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<com.baidu.tieba.ala.alasquare.special_forum.data.b>(LayoutInflater.from(h.this.mTbPageContext.getPageActivity()).inflate(R.layout.special_bar_recommend_activity, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.h.2.1
                    public TbImageView etk;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.etk = (TbImageView) view.findViewById(R.id.cover);
                        this.etk.setDefaultErrorResource(0);
                        this.etk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, com.baidu.tieba.ala.alasquare.special_forum.data.b bVar) {
                        if (bVar != null && this.etk != null && !StringUtils.isNull(bVar.pic)) {
                            this.etk.startLoad(bVar.pic, 10, false);
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
        this.eth = (AlaBannerAutoScrollView) getView().findViewById(R.id.banner_container);
        this.eth.setViewHolderAdapter(this.eti);
        this.eth.setOnBannerClickListener(new com.baidu.tieba.ala.alasquare.widget.banner.d() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.h.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.d
            public void ap(Object obj) {
                if (obj != null && (obj instanceof com.baidu.tieba.ala.alasquare.special_forum.data.b)) {
                    com.baidu.tieba.ala.alasquare.special_forum.data.b bVar = (com.baidu.tieba.ala.alasquare.special_forum.data.b) obj;
                    if (!StringUtils.isNull(bVar.url)) {
                        ba.aGG().a((TbPageContext) com.baidu.adp.base.i.ab(h.this.mTbPageContext.getPageActivity()), new String[]{bVar.url}, true);
                    }
                    TiebaStatic.log("c12902");
                }
            }
        });
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eth.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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
        if (cVar != null && !v.isEmpty(cVar.erD)) {
            this.eth.a(cVar.erD, this.eti);
            TiebaStatic.log("c12901");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public View cug;
        public h etm;

        public a(h hVar) {
            super(hVar.getView());
            this.etm = hVar;
            this.cug = hVar.getView();
        }
    }
}
