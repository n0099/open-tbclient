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
    private com.baidu.tbadk.f.a aSJ;
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> axF;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> dwH;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> ejz;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.axF = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void g(int i, String str) {
                if (AutoBannerView.this.ejz != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ejz.g(i, str);
                }
                AutoBannerView.this.oR(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.ejz != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ejz.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dwH = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e BQ() {
                e eVar = new e();
                eVar.setHeight((int) (l.aO(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c BP() {
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
            public View BR() {
                return null;
            }
        };
        this.dwH.setIndicatorNoOffet(true);
        this.dwH.setDisableParentEvent(false);
        this.dwH.setCoverFlowFactory(bVar);
        this.dwH.setCallback(this.axF);
        addView(this.dwH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.H(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(String str) {
        if (!TextUtils.isEmpty(str)) {
            ay.Ef().c((TbPageContext) i.aK(getContext()), new String[]{str});
        }
    }

    public void FE() {
        if (this.dwH != null) {
            this.dwH.BT();
        }
    }

    public void FD() {
        if (this.dwH != null) {
            this.dwH.BS();
        }
    }

    public void bV(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.dwH.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aSJ = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.ejz = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dwH != null) {
            this.dwH.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aSJ != null) {
            this.aSJ.a(this, i == 0, null);
        }
    }
}
