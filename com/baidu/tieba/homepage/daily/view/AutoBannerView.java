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
    private com.baidu.tbadk.f.a aOu;
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> ats;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> dpd;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> ebC;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.ats = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (AutoBannerView.this.ebC != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ebC.h(i, str);
                }
                AutoBannerView.this.or(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.ebC != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ebC.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dpd = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e AF() {
                e eVar = new e();
                eVar.setHeight((int) (l.aO(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c AE() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.cQ(e.f.icon_banner_gray_n);
                cVar.cR(e.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.cS(e.C0175e.tbds26);
                cVar.setSpacing(e.C0175e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView br(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View AG() {
                return null;
            }
        };
        this.dpd.setIndicatorNoOffet(true);
        this.dpd.setDisableParentEvent(false);
        this.dpd.setCoverFlowFactory(bVar);
        this.dpd.setCallback(this.ats);
        addView(this.dpd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.I(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void or(String str) {
        if (!TextUtils.isEmpty(str)) {
            ay.CU().c((TbPageContext) i.aK(getContext()), new String[]{str});
        }
    }

    public void Eq() {
        if (this.dpd != null) {
            this.dpd.AI();
        }
    }

    public void Ep() {
        if (this.dpd != null) {
            this.dpd.AH();
        }
    }

    public void bV(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.dpd.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aOu = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.ebC = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dpd != null) {
            this.dpd.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aOu != null) {
            this.aOu.a(this, i == 0, null);
        }
    }
}
