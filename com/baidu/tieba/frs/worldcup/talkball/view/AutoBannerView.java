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
    private com.baidu.tbadk.f.a aSJ;
    private final d<com.baidu.tieba.frs.worldcup.talkball.b.a> axF;
    private CoverFlowView<com.baidu.tieba.frs.worldcup.talkball.b.a> dwH;
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> ejz;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> mData;
    private RelativeLayout mTitleLayout;
    private TextView mTitleView;

    public AutoBannerView(Context context) {
        super(context);
        this.dwH = null;
        this.mData = null;
        this.axF = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void g(int i, String str) {
                if (AutoBannerView.this.ejz != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ejz.g(i, str);
                }
                AutoBannerView.this.oR(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
                if (AutoBannerView.this.ejz != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ejz.a(i, aVar);
                }
                if (aVar != null && AutoBannerView.this.mTitleView != null) {
                    AutoBannerView.this.mTitleView.setText(aVar.getTitle());
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dwH = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e BQ() {
                e eVar = new e();
                eVar.setHeight(l.h(AutoBannerView.this.getContext(), e.C0210e.tbds418));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c BP() {
                c cVar = new c();
                cVar.ds(e.f.icon_banner_gray_n);
                cVar.dt(e.f.icon_banner_s);
                cVar.setGravity(85);
                cVar.du(e.C0210e.tbds26);
                cVar.dv(e.C0210e.tbds44);
                cVar.setSpacing(e.C0210e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView bs(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View BR() {
                RelativeLayout relativeLayout = new RelativeLayout(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout = new RelativeLayout(AutoBannerView.this.getContext());
                relativeLayout.addView(AutoBannerView.this.mTitleLayout);
                AutoBannerView.this.mTitleView = new TextView(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout.addView(AutoBannerView.this.mTitleView);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(AutoBannerView.this.getContext(), e.C0210e.tbds150));
                layoutParams.addRule(12, -1);
                AutoBannerView.this.mTitleLayout.setLayoutParams(layoutParams);
                AutoBannerView.this.mTitleView.setTextSize(0, l.h(AutoBannerView.this.getContext(), e.C0210e.tbfontsize46));
                AutoBannerView.this.mTitleView.setSingleLine(true);
                AutoBannerView.this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.h(AutoBannerView.this.getContext(), e.C0210e.tbds741), -2);
                layoutParams2.addRule(12, -1);
                layoutParams2.leftMargin = l.h(AutoBannerView.this.getContext(), e.C0210e.tbds44);
                layoutParams2.bottomMargin = l.h(AutoBannerView.this.getContext(), e.C0210e.tbds26);
                AutoBannerView.this.mTitleView.setLayoutParams(layoutParams2);
                AutoBannerView.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return relativeLayout;
            }
        };
        this.dwH.setIndicatorNoOffet(true);
        this.dwH.setDisableParentEvent(false);
        this.dwH.setCoverFlowFactory(bVar);
        this.dwH.setCallback(this.axF);
        addView(this.dwH);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dwH;
    }

    public com.baidu.tieba.frs.worldcup.talkball.b.a nT(int i) {
        return (com.baidu.tieba.frs.worldcup.talkball.b.a) v.d(this.mData, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.H(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ay.Ef().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FE() {
        if (this.dwH != null) {
            this.dwH.BT();
        }
    }

    public void FD() {
        if (this.dwH != null) {
            this.dwH.BS();
        }
    }

    public void bV(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        this.mData = list;
        this.dwH.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aSJ = aVar;
    }

    public void setOutOnCoverViewCallback(d<com.baidu.tieba.frs.worldcup.talkball.b.a> dVar) {
        this.ejz = dVar;
    }

    public void onChangeSkinType(int i) {
        al.b(this.mTitleView, e.d.cp_cont_i, 1, i);
        al.d(this.mTitleLayout, e.f.bg_frs_auto_banner_mask, i);
        if (this.dwH != null) {
            this.dwH.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aSJ != null) {
            this.aSJ.a(this, i == 0, null);
        }
    }
}
