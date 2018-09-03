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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes2.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aGE;
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> alV;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dMq;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> dbe;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.alV = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (AutoBannerView.this.dMq != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dMq.h(i, str);
                }
                AutoBannerView.this.ni(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.dMq != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dMq.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dbe = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e xq() {
                e eVar = new e();
                eVar.setHeight((int) (l.ah(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c xp() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.cw(f.C0146f.icon_banner_gray_n);
                cVar.cx(f.C0146f.icon_banner_s);
                cVar.setGravity(81);
                cVar.cy(f.e.tbds26);
                cVar.setSpacing(f.e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView aC(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(f.C0146f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View xr() {
                return null;
            }
        };
        this.dbe.setIndicatorNoOffet(true);
        this.dbe.setDisableParentEvent(false);
        this.dbe.setCoverFlowFactory(bVar);
        this.dbe.setCallback(this.alV);
        addView(this.dbe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= w.y(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(String str) {
        if (!TextUtils.isEmpty(str)) {
            az.zI().c((TbPageContext) i.ad(getContext()), new String[]{str});
        }
    }

    public void AZ() {
        if (this.dbe != null) {
            this.dbe.xt();
        }
    }

    public void AY() {
        if (this.dbe != null) {
            this.dbe.xs();
        }
    }

    public void bE(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.dbe.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aGE = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.dMq = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dbe != null) {
            this.dbe.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aGE != null) {
            this.aGE.a(this, i == 0, null);
        }
    }
}
