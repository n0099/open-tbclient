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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class AutoBannerView extends RelativeLayout {
    private final com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> bON;
    private com.baidu.tbadk.h.c clM;
    private CoverFlowView<com.baidu.tieba.homepage.daily.b.a> fiS;
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> geX;
    private List<com.baidu.tieba.homepage.daily.b.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.bON = new com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void B(int i, String str) {
                if (AutoBannerView.this.geX != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.geX.B(i, str);
                }
                AutoBannerView.this.yd(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
                if (AutoBannerView.this.geX != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.geX.a(i, aVar);
                }
                if (aVar == null) {
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.fiS = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.homepage.daily.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e ahg() {
                e eVar = new e();
                eVar.setHeight((int) (l.af(AutoBannerView.this.getContext()) / 2.5f));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c ahf() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.hN(R.drawable.icon_banner_gray_n);
                cVar.hO(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.hP(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView cm(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(R.drawable.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View ahh() {
                return null;
            }
        };
        this.fiS.setIndicatorNoOffet(true);
        this.fiS.setDisableParentEvent(false);
        this.fiS.setCoverFlowFactory(bVar);
        this.fiS.setCallback(this.bON);
        addView(this.fiS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.Z(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yd(String str) {
        if (!TextUtils.isEmpty(str)) {
            bb.ajE().c((TbPageContext) i.ab(getContext()), new String[]{str});
        }
    }

    public void alp() {
        if (this.fiS != null) {
            this.fiS.ahj();
        }
    }

    public void alo() {
        if (this.fiS != null) {
            this.fiS.ahi();
        }
    }

    public void cC(List<com.baidu.tieba.homepage.daily.b.a> list) {
        this.mData = list;
        this.fiS.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.clM = cVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.homepage.daily.b.a> dVar) {
        this.geX = dVar;
    }

    public void onChangeSkinType(int i) {
        if (this.fiS != null) {
            this.fiS.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.clM != null) {
            this.clM.a(this, i == 0, null);
        }
    }
}
