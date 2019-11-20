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
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> cfA;
    private com.baidu.tbadk.h.c cyQ;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> fmw;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> gfu;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.cfA = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void E(int i, String str) {
                if (AutoBannerView.this.gfu != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.gfu.E(i, str);
                }
                AutoBannerView.this.wV(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.gfu != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.gfu.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.fmw = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e alf() {
                e eVar = new e();
                eVar.setHeight((int) (l.getEquipmentWidth(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c ale() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.ih(R.drawable.icon_banner_gray_n);
                cVar.ii(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.ij(R.dimen.tbds26);
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
            public View alg() {
                return null;
            }
        };
        this.fmw.setIndicatorNoOffet(true);
        this.fmw.setDisableParentEvent(false);
        this.fmw.setCoverFlowFactory(bVar);
        this.fmw.setCallback(this.cfA);
        addView(this.fmw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.getCount(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.amO().b((TbPageContext) i.ab(getContext()), new String[]{str});
        }
    }

    public void aon() {
        if (this.fmw != null) {
            this.fmw.ali();
        }
    }

    public void aom() {
        if (this.fmw != null) {
            this.fmw.alh();
        }
    }

    public void cP(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.fmw.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.cyQ = cVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.gfu = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.fmw != null) {
            this.fmw.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.cyQ != null) {
            this.cyQ.a(this, i == 0, null);
        }
    }
}
