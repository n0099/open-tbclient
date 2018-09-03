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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aGE;
    private final d<com.baidu.tieba.frs.worldcup.talkball.b.a> alV;
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> dMq;
    private CoverFlowView<com.baidu.tieba.frs.worldcup.talkball.b.a> dbe;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> mData;
    private RelativeLayout mTitleLayout;
    private TextView mTitleView;

    public AutoBannerView(Context context) {
        super(context);
        this.dbe = null;
        this.mData = null;
        this.alV = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void h(int i, String str) {
                if (AutoBannerView.this.dMq != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dMq.h(i, str);
                }
                AutoBannerView.this.ni(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
                if (AutoBannerView.this.dMq != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.dMq.a(i, aVar);
                }
                if (aVar != null && AutoBannerView.this.mTitleView != null) {
                    AutoBannerView.this.mTitleView.setText(aVar.getTitle());
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dbe = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e xq() {
                e eVar = new e();
                eVar.setHeight(l.f(AutoBannerView.this.getContext(), f.e.tbds418));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c xp() {
                c cVar = new c();
                cVar.cw(f.C0146f.icon_banner_gray_n);
                cVar.cx(f.C0146f.icon_banner_s);
                cVar.setGravity(85);
                cVar.cy(f.e.tbds26);
                cVar.cz(f.e.tbds44);
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
                RelativeLayout relativeLayout = new RelativeLayout(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout = new RelativeLayout(AutoBannerView.this.getContext());
                relativeLayout.addView(AutoBannerView.this.mTitleLayout);
                AutoBannerView.this.mTitleView = new TextView(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout.addView(AutoBannerView.this.mTitleView);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.f(AutoBannerView.this.getContext(), f.e.tbds150));
                layoutParams.addRule(12, -1);
                AutoBannerView.this.mTitleLayout.setLayoutParams(layoutParams);
                AutoBannerView.this.mTitleView.setTextSize(0, l.f(AutoBannerView.this.getContext(), f.e.tbfontsize46));
                AutoBannerView.this.mTitleView.setSingleLine(true);
                AutoBannerView.this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.f(AutoBannerView.this.getContext(), f.e.tbds741), -2);
                layoutParams2.addRule(12, -1);
                layoutParams2.leftMargin = l.f(AutoBannerView.this.getContext(), f.e.tbds44);
                layoutParams2.bottomMargin = l.f(AutoBannerView.this.getContext(), f.e.tbds26);
                AutoBannerView.this.mTitleView.setLayoutParams(layoutParams2);
                AutoBannerView.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return relativeLayout;
            }
        };
        this.dbe.setIndicatorNoOffet(true);
        this.dbe.setDisableParentEvent(false);
        this.dbe.setCoverFlowFactory(bVar);
        this.dbe.setCallback(this.alV);
        addView(this.dbe);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dbe;
    }

    public com.baidu.tieba.frs.worldcup.talkball.b.a mj(int i) {
        return (com.baidu.tieba.frs.worldcup.talkball.b.a) w.d(this.mData, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= w.y(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                az.zI().c((TbPageContext) i.ad(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public void bE(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        this.mData = list;
        this.dbe.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aGE = aVar;
    }

    public void setOutOnCoverViewCallback(d<com.baidu.tieba.frs.worldcup.talkball.b.a> dVar) {
        this.dMq = dVar;
    }

    public void onChangeSkinType(int i) {
        am.b(this.mTitleView, f.d.cp_cont_i, 1, i);
        am.d(this.mTitleLayout, f.C0146f.bg_frs_auto_banner_mask, i);
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
