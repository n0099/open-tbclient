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
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> bGb;
    private com.baidu.tbadk.h.a cck;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> eNy;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> fIy;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.bGb = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void y(int i, String str) {
                if (AutoBannerView.this.fIy != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.fIy.y(i, str);
                }
                AutoBannerView.this.wj(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.fIy != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.fIy.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.eNy = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e abn() {
                e eVar = new e();
                eVar.setHeight((int) (l.aO(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c abm() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.gU(d.f.icon_banner_gray_n);
                cVar.gV(d.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.gW(d.e.tbds26);
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
            public View abo() {
                return null;
            }
        };
        this.eNy.setIndicatorNoOffet(true);
        this.eNy.setDisableParentEvent(false);
        this.eNy.setCoverFlowFactory(bVar);
        this.eNy.setCallback(this.bGb);
        addView(this.eNy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.S(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.adD().c((TbPageContext) i.aK(getContext()), new String[]{str});
        }
    }

    public void afm() {
        if (this.eNy != null) {
            this.eNy.abq();
        }
    }

    public void afl() {
        if (this.eNy != null) {
            this.eNy.abp();
        }
    }

    public void cx(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.eNy.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.a aVar) {
        this.cck = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.fIy = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.eNy != null) {
            this.eNy.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.cck != null) {
            this.cck.a(this, i == 0, null);
        }
    }
}
