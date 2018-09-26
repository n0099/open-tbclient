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
/* loaded from: classes2.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aJS;
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> aoA;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dTI;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> dgZ;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.aoA = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (AutoBannerView.this.dTI != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dTI.h(i, str);
                }
                AutoBannerView.this.nN(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.dTI != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dTI.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dgZ = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e yx() {
                e eVar = new e();
                eVar.setHeight((int) (l.aO(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c yw() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.cG(e.f.icon_banner_gray_n);
                cVar.cH(e.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.cI(e.C0141e.tbds26);
                cVar.setSpacing(e.C0141e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView bi(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View yy() {
                return null;
            }
        };
        this.dgZ.setIndicatorNoOffet(true);
        this.dgZ.setDisableParentEvent(false);
        this.dgZ.setCoverFlowFactory(bVar);
        this.dgZ.setCallback(this.aoA);
        addView(this.dgZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.y(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(String str) {
        if (!TextUtils.isEmpty(str)) {
            ay.AN().c((TbPageContext) i.aK(getContext()), new String[]{str});
        }
    }

    public void Cl() {
        if (this.dgZ != null) {
            this.dgZ.yA();
        }
    }

    public void Ck() {
        if (this.dgZ != null) {
            this.dgZ.yz();
        }
    }

    public void bF(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.dgZ.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aJS = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.dTI = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dgZ != null) {
            this.dgZ.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aJS != null) {
            this.aJS.a(this, i == 0, null);
        }
    }
}
