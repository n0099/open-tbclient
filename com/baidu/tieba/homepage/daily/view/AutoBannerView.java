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
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> cgr;
    private com.baidu.tbadk.h.c czH;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> fnn;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> ggl;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.cgr = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void F(int i, String str) {
                if (AutoBannerView.this.ggl != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ggl.F(i, str);
                }
                AutoBannerView.this.wV(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.ggl != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ggl.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.fnn = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e alh() {
                e eVar = new e();
                eVar.setHeight((int) (l.getEquipmentWidth(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c alg() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.ii(R.drawable.icon_banner_gray_n);
                cVar.ij(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.ik(R.dimen.tbds26);
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
            public View ali() {
                return null;
            }
        };
        this.fnn.setIndicatorNoOffet(true);
        this.fnn.setDisableParentEvent(false);
        this.fnn.setCoverFlowFactory(bVar);
        this.fnn.setCallback(this.cgr);
        addView(this.fnn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.getCount(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.amQ().b((TbPageContext) i.ab(getContext()), new String[]{str});
        }
    }

    public void aop() {
        if (this.fnn != null) {
            this.fnn.alk();
        }
    }

    public void aoo() {
        if (this.fnn != null) {
            this.fnn.alj();
        }
    }

    public void cP(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.fnn.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.czH = cVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.ggl = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.fnn != null) {
            this.fnn.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.czH != null) {
            this.czH.a(this, i == 0, null);
        }
    }
}
