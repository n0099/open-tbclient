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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aOu;
    private final d<com.baidu.tieba.frs.worldcup.talkball.b.a> ats;
    private CoverFlowView<com.baidu.tieba.frs.worldcup.talkball.b.a> dpd;
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> ebB;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> mData;
    private RelativeLayout mTitleLayout;
    private TextView mTitleView;

    public AutoBannerView(Context context) {
        super(context);
        this.dpd = null;
        this.mData = null;
        this.ats = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (AutoBannerView.this.ebB != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ebB.h(i, str);
                }
                AutoBannerView.this.or(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
                if (AutoBannerView.this.ebB != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ebB.a(i, aVar);
                }
                if (aVar != null && AutoBannerView.this.mTitleView != null) {
                    AutoBannerView.this.mTitleView.setText(aVar.getTitle());
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dpd = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e AF() {
                e eVar = new e();
                eVar.setHeight(l.h(AutoBannerView.this.getContext(), e.C0175e.tbds418));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c AE() {
                c cVar = new c();
                cVar.cQ(e.f.icon_banner_gray_n);
                cVar.cR(e.f.icon_banner_s);
                cVar.setGravity(85);
                cVar.cS(e.C0175e.tbds26);
                cVar.cT(e.C0175e.tbds44);
                cVar.setSpacing(e.C0175e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView br(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View AG() {
                RelativeLayout relativeLayout = new RelativeLayout(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout = new RelativeLayout(AutoBannerView.this.getContext());
                relativeLayout.addView(AutoBannerView.this.mTitleLayout);
                AutoBannerView.this.mTitleView = new TextView(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout.addView(AutoBannerView.this.mTitleView);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(AutoBannerView.this.getContext(), e.C0175e.tbds150));
                layoutParams.addRule(12, -1);
                AutoBannerView.this.mTitleLayout.setLayoutParams(layoutParams);
                AutoBannerView.this.mTitleView.setTextSize(0, l.h(AutoBannerView.this.getContext(), e.C0175e.tbfontsize46));
                AutoBannerView.this.mTitleView.setSingleLine(true);
                AutoBannerView.this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.h(AutoBannerView.this.getContext(), e.C0175e.tbds741), -2);
                layoutParams2.addRule(12, -1);
                layoutParams2.leftMargin = l.h(AutoBannerView.this.getContext(), e.C0175e.tbds44);
                layoutParams2.bottomMargin = l.h(AutoBannerView.this.getContext(), e.C0175e.tbds26);
                AutoBannerView.this.mTitleView.setLayoutParams(layoutParams2);
                AutoBannerView.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return relativeLayout;
            }
        };
        this.dpd.setIndicatorNoOffet(true);
        this.dpd.setDisableParentEvent(false);
        this.dpd.setCoverFlowFactory(bVar);
        this.dpd.setCallback(this.ats);
        addView(this.dpd);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dpd;
    }

    public com.baidu.tieba.frs.worldcup.talkball.b.a nl(int i) {
        return (com.baidu.tieba.frs.worldcup.talkball.b.a) v.d(this.mData, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.I(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void or(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ay.CU().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Eq() {
        if (this.dpd != null) {
            this.dpd.AI();
        }
    }

    public void Ep() {
        if (this.dpd != null) {
            this.dpd.AH();
        }
    }

    public void bV(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        this.mData = list;
        this.dpd.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aOu = aVar;
    }

    public void setOutOnCoverViewCallback(d<com.baidu.tieba.frs.worldcup.talkball.b.a> dVar) {
        this.ebB = dVar;
    }

    public void onChangeSkinType(int i) {
        al.b(this.mTitleView, e.d.cp_cont_i, 1, i);
        al.d(this.mTitleLayout, e.f.bg_frs_auto_banner_mask, i);
        if (this.dpd != null) {
            this.dpd.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aOu != null) {
            this.aOu.a(this, i == 0, null);
        }
    }
}
