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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class AutoBannerView extends RelativeLayout {
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> bGf;
    private com.baidu.tbadk.h.a ccm;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> eNg;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> fIl;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.bGf = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void y(int i, String str) {
                if (AutoBannerView.this.fIl != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.fIl.y(i, str);
                }
                AutoBannerView.this.wg(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.fIl != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.fIl.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.eNg = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e abk() {
                e eVar = new e();
                eVar.setHeight((int) (l.aO(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c abj() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.gT(d.f.icon_banner_gray_n);
                cVar.gU(d.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.gV(d.e.tbds26);
                cVar.setSpacing(d.e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView cG(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(d.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View abl() {
                return null;
            }
        };
        this.eNg.setIndicatorNoOffet(true);
        this.eNg.setDisableParentEvent(false);
        this.eNg.setCoverFlowFactory(bVar);
        this.eNg.setCallback(this.bGf);
        addView(this.eNg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.S(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.adA().c((TbPageContext) i.aK(getContext()), new String[]{str});
        }
    }

    public void afj() {
        if (this.eNg != null) {
            this.eNg.abn();
        }
    }

    public void afi() {
        if (this.eNg != null) {
            this.eNg.abm();
        }
    }

    public void cu(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.eNg.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.a aVar) {
        this.ccm = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.fIl = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.eNg != null) {
            this.eNg.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.ccm != null) {
            this.ccm.a(this, i == 0, null);
        }
    }
}
