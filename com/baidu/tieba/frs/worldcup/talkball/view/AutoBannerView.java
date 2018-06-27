package com.baidu.tieba.frs.worldcup.talkball.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.b;
import com.baidu.tbadk.core.flow.a.c;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.e.a aGF;
    private final d<com.baidu.tieba.frs.worldcup.talkball.b.a> amu;
    private CoverFlowView<com.baidu.tieba.frs.worldcup.talkball.b.a> cYr;
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> dJE;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> mData;
    private RelativeLayout mTitleLayout;
    private TextView mTitleView;

    public AutoBannerView(Context context) {
        super(context);
        this.cYr = null;
        this.mData = null;
        this.amu = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                if (AutoBannerView.this.dJE != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dJE.f(i, str);
                }
                AutoBannerView.this.nh(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
                if (AutoBannerView.this.dJE != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dJE.a(i, aVar);
                }
                if (aVar != null && AutoBannerView.this.mTitleView != null) {
                    AutoBannerView.this.mTitleView.setText(aVar.getTitle());
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.cYr = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e xz() {
                e eVar = new e();
                eVar.setHeight(l.e(AutoBannerView.this.getContext(), d.e.tbds418));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c xy() {
                c cVar = new c();
                cVar.cu(d.f.icon_banner_gray_n);
                cVar.cv(d.f.icon_banner_s);
                cVar.setGravity(85);
                cVar.cw(d.e.tbds26);
                cVar.cx(d.e.tbds44);
                cVar.setSpacing(d.e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView aC(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(d.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View xA() {
                RelativeLayout relativeLayout = new RelativeLayout(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout = new RelativeLayout(AutoBannerView.this.getContext());
                relativeLayout.addView(AutoBannerView.this.mTitleLayout);
                AutoBannerView.this.mTitleView = new TextView(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout.addView(AutoBannerView.this.mTitleView);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.e(AutoBannerView.this.getContext(), d.e.tbds150));
                layoutParams.addRule(12, -1);
                AutoBannerView.this.mTitleLayout.setLayoutParams(layoutParams);
                AutoBannerView.this.mTitleView.setTextSize(0, l.e(AutoBannerView.this.getContext(), d.e.tbfontsize46));
                AutoBannerView.this.mTitleView.setSingleLine(true);
                AutoBannerView.this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.e(AutoBannerView.this.getContext(), d.e.tbds741), -2);
                layoutParams2.addRule(12, -1);
                layoutParams2.leftMargin = l.e(AutoBannerView.this.getContext(), d.e.tbds44);
                layoutParams2.bottomMargin = l.e(AutoBannerView.this.getContext(), d.e.tbds26);
                AutoBannerView.this.mTitleView.setLayoutParams(layoutParams2);
                AutoBannerView.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return relativeLayout;
            }
        };
        this.cYr.setIndicatorNoOffet(true);
        this.cYr.setDisableParentEvent(false);
        this.cYr.setCoverFlowFactory(bVar);
        this.cYr.setCallback(this.amu);
        addView(this.cYr);
    }

    public CoverFlowView getCoverFlowView() {
        return this.cYr;
    }

    public com.baidu.tieba.frs.worldcup.talkball.b.a lX(int i) {
        return (com.baidu.tieba.frs.worldcup.talkball.b.a) w.d(this.mData, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= w.z(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nh(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                az.zV().c((TbPageContext) i.ad(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Bl() {
        if (this.cYr != null) {
            this.cYr.xC();
        }
    }

    public void Bk() {
        if (this.cYr != null) {
            this.cYr.xB();
        }
    }

    public void bF(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        this.mData = list;
        this.cYr.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.e.a aVar) {
        this.aGF = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.frs.worldcup.talkball.b.a> dVar) {
        this.dJE = dVar;
    }

    public void onChangeSkinType(int i) {
        am.b(this.mTitleView, d.C0142d.cp_cont_i, 1, i);
        am.d(this.mTitleLayout, d.f.bg_frs_auto_banner_mask, i);
        if (this.cYr != null) {
            this.cYr.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aGF != null) {
            this.aGF.a(this, i == 0, null);
        }
    }
}
