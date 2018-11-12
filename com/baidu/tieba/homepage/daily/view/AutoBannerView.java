package com.baidu.tieba.homepage.daily.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes6.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aPk;
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> auf;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> dqh;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> ecW;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.auf = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void g(int i, String str) {
                if (AutoBannerView.this.ecW != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ecW.g(i, str);
                }
                AutoBannerView.this.os(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.ecW != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ecW.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dqh = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e AM() {
                e eVar = new e();
                eVar.setHeight((int) (l.aO(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c AL() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.de(e.f.icon_banner_gray_n);
                cVar.df(e.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.dg(e.C0200e.tbds26);
                cVar.setSpacing(e.C0200e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView bp(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View AN() {
                return null;
            }
        };
        this.dqh.setIndicatorNoOffet(true);
        this.dqh.setDisableParentEvent(false);
        this.dqh.setCoverFlowFactory(bVar);
        this.dqh.setCallback(this.auf);
        addView(this.dqh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.H(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void os(String str) {
        if (!TextUtils.isEmpty(str)) {
            ay.Db().c((TbPageContext) i.aK(getContext()), new String[]{str});
        }
    }

    public void EA() {
        if (this.dqh != null) {
            this.dqh.AP();
        }
    }

    public void Ez() {
        if (this.dqh != null) {
            this.dqh.AO();
        }
    }

    public void bT(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.dqh.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aPk = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.ecW = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dqh != null) {
            this.dqh.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aPk != null) {
            this.aPk.a(this, i == 0, null);
        }
    }
}
