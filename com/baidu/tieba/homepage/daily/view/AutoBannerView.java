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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class AutoBannerView extends RelativeLayout {
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> bNG;
    private com.baidu.tbadk.h.c cks;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> fZg;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> fdp;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.bNG = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void B(int i, String str) {
                if (AutoBannerView.this.fZg != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.fZg.B(i, str);
                }
                AutoBannerView.this.xv(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.fZg != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.fZg.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.fdp = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e agc() {
                e eVar = new e();
                eVar.setHeight((int) (l.af(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c agb() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.hH(R.drawable.icon_banner_gray_n);
                cVar.hI(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.hJ(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView cl(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(R.drawable.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View agd() {
                return null;
            }
        };
        this.fdp.setIndicatorNoOffet(true);
        this.fdp.setDisableParentEvent(false);
        this.fdp.setCoverFlowFactory(bVar);
        this.fdp.setCallback(this.bNG);
        addView(this.fdp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.Z(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aiz().c((TbPageContext) i.ab(getContext()), new String[]{str});
        }
    }

    public void aki() {
        if (this.fdp != null) {
            this.fdp.agf();
        }
    }

    public void akh() {
        if (this.fdp != null) {
            this.fdp.age();
        }
    }

    public void cC(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.fdp.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.cks = cVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.fZg = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.fdp != null) {
            this.fdp.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.cks != null) {
            this.cks.a(this, i == 0, null);
        }
    }
}
