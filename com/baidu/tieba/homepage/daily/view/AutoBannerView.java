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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aGF;
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> alU;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dMu;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> dbi;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.alU = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (AutoBannerView.this.dMu != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dMu.h(i, str);
                }
                AutoBannerView.this.ng(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.dMu != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dMu.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dbi = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e xr() {
                e eVar = new e();
                eVar.setHeight((int) (l.ah(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c xq() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.cw(d.f.icon_banner_gray_n);
                cVar.cx(d.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.cy(d.e.tbds26);
                cVar.setSpacing(d.e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView aD(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(d.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View xs() {
                return null;
            }
        };
        this.dbi.setIndicatorNoOffet(true);
        this.dbi.setDisableParentEvent(false);
        this.dbi.setCoverFlowFactory(bVar);
        this.dbi.setCallback(this.alU);
        addView(this.dbi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= w.y(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(String str) {
        if (!TextUtils.isEmpty(str)) {
            ay.zK().c((TbPageContext) i.ad(getContext()), new String[]{str});
        }
    }

    public void Bc() {
        if (this.dbi != null) {
            this.dbi.xu();
        }
    }

    public void Bb() {
        if (this.dbi != null) {
            this.dbi.xt();
        }
    }

    public void bE(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.dbi.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aGF = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.dMu = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dbi != null) {
            this.dbi.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aGF != null) {
            this.aGF.a(this, i == 0, null);
        }
    }
}
