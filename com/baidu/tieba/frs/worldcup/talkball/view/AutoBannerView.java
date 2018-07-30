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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aGF;
    private final d<com.baidu.tieba.frs.worldcup.talkball.b.a> alU;
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> dMu;
    private CoverFlowView<com.baidu.tieba.frs.worldcup.talkball.b.a> dbi;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> mData;
    private RelativeLayout mTitleLayout;
    private TextView mTitleView;

    public AutoBannerView(Context context) {
        super(context);
        this.dbi = null;
        this.mData = null;
        this.alU = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (AutoBannerView.this.dMu != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dMu.h(i, str);
                }
                AutoBannerView.this.ng(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
                if (AutoBannerView.this.dMu != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dMu.a(i, aVar);
                }
                if (aVar != null && AutoBannerView.this.mTitleView != null) {
                    AutoBannerView.this.mTitleView.setText(aVar.getTitle());
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dbi = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e xr() {
                e eVar = new e();
                eVar.setHeight(l.f(AutoBannerView.this.getContext(), d.e.tbds418));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c xq() {
                c cVar = new c();
                cVar.cw(d.f.icon_banner_gray_n);
                cVar.cx(d.f.icon_banner_s);
                cVar.setGravity(85);
                cVar.cy(d.e.tbds26);
                cVar.cz(d.e.tbds44);
                cVar.setSpacing(d.e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView aD(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(d.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View xs() {
                RelativeLayout relativeLayout = new RelativeLayout(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout = new RelativeLayout(AutoBannerView.this.getContext());
                relativeLayout.addView(AutoBannerView.this.mTitleLayout);
                AutoBannerView.this.mTitleView = new TextView(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout.addView(AutoBannerView.this.mTitleView);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(AutoBannerView.this.getContext(), d.e.tbds150));
                layoutParams.addRule(12, -1);
                AutoBannerView.this.mTitleLayout.setLayoutParams(layoutParams);
                AutoBannerView.this.mTitleView.setTextSize(0, l.f(AutoBannerView.this.getContext(), d.e.tbfontsize46));
                AutoBannerView.this.mTitleView.setSingleLine(true);
                AutoBannerView.this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.f(AutoBannerView.this.getContext(), d.e.tbds741), -2);
                layoutParams2.addRule(12, -1);
                layoutParams2.leftMargin = l.f(AutoBannerView.this.getContext(), d.e.tbds44);
                layoutParams2.bottomMargin = l.f(AutoBannerView.this.getContext(), d.e.tbds26);
                AutoBannerView.this.mTitleView.setLayoutParams(layoutParams2);
                AutoBannerView.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return relativeLayout;
            }
        };
        this.dbi.setIndicatorNoOffet(true);
        this.dbi.setDisableParentEvent(false);
        this.dbi.setCoverFlowFactory(bVar);
        this.dbi.setCallback(this.alU);
        addView(this.dbi);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dbi;
    }

    public com.baidu.tieba.frs.worldcup.talkball.b.a mj(int i) {
        return (com.baidu.tieba.frs.worldcup.talkball.b.a) w.d(this.mData, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= w.y(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ay.zK().c((TbPageContext) i.ad(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Bc() {
        if (this.dbi != null) {
            this.dbi.xu();
        }
    }

    public void Bb() {
        if (this.dbi != null) {
            this.dbi.xt();
        }
    }

    public void bE(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        this.mData = list;
        this.dbi.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aGF = aVar;
    }

    public void setOutOnCoverViewCallback(com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.frs.worldcup.talkball.b.a> dVar) {
        this.dMu = dVar;
    }

    public void onChangeSkinType(int i) {
        am.b(this.mTitleView, d.C0140d.cp_cont_i, 1, i);
        am.d(this.mTitleLayout, d.f.bg_frs_auto_banner_mask, i);
        if (this.dbi != null) {
            this.dbi.onChangeSkinType();
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
