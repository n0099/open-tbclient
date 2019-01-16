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
    private com.baidu.tbadk.f.a aTt;
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> ayi;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> dAd;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> emV;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.ayi = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void i(int i, String str) {
                if (AutoBannerView.this.emV != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.emV.i(i, str);
                }
                AutoBannerView.this.pk(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.emV != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.emV.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dAd = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e Cd() {
                e eVar = new e();
                eVar.setHeight((int) (l.aO(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c Cc() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.ds(e.f.icon_banner_gray_n);
                cVar.dt(e.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.du(e.C0210e.tbds26);
                cVar.setSpacing(e.C0210e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView bs(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View Ce() {
                return null;
            }
        };
        this.dAd.setIndicatorNoOffet(true);
        this.dAd.setDisableParentEvent(false);
        this.dAd.setCoverFlowFactory(bVar);
        this.dAd.setCallback(this.ayi);
        addView(this.dAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.H(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(String str) {
        if (!TextUtils.isEmpty(str)) {
            ay.Es().c((TbPageContext) i.aK(getContext()), new String[]{str});
        }
    }

    public void FS() {
        if (this.dAd != null) {
            this.dAd.Cg();
        }
    }

    public void FR() {
        if (this.dAd != null) {
            this.dAd.Cf();
        }
    }

    public void bX(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.dAd.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aTt = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.emV = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dAd != null) {
            this.dAd.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aTt != null) {
            this.aTt.a(this, i == 0, null);
        }
    }
}
