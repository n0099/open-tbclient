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
    private com.baidu.tbadk.f.a aPk;
    private final d<com.baidu.tieba.frs.worldcup.talkball.b.a> auf;
    private CoverFlowView<com.baidu.tieba.frs.worldcup.talkball.b.a> dqh;
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> ecW;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> mData;
    private RelativeLayout mTitleLayout;
    private TextView mTitleView;

    public AutoBannerView(Context context) {
        super(context);
        this.dqh = null;
        this.mData = null;
        this.auf = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void g(int i, String str) {
                if (AutoBannerView.this.ecW != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ecW.g(i, str);
                }
                AutoBannerView.this.os(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
                if (AutoBannerView.this.ecW != null && AutoBannerView.this.checkIndex(i)) {
                    AutoBannerView.this.ecW.a(i, aVar);
                }
                if (aVar != null && AutoBannerView.this.mTitleView != null) {
                    AutoBannerView.this.mTitleView.setText(aVar.getTitle());
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.dqh = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e AM() {
                e eVar = new e();
                eVar.setHeight(l.h(AutoBannerView.this.getContext(), e.C0200e.tbds418));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public c AL() {
                c cVar = new c();
                cVar.de(e.f.icon_banner_gray_n);
                cVar.df(e.f.icon_banner_s);
                cVar.setGravity(85);
                cVar.dg(e.C0200e.tbds26);
                cVar.dh(e.C0200e.tbds44);
                cVar.setSpacing(e.C0200e.tbds10);
                return cVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView bp(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public View AN() {
                RelativeLayout relativeLayout = new RelativeLayout(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout = new RelativeLayout(AutoBannerView.this.getContext());
                relativeLayout.addView(AutoBannerView.this.mTitleLayout);
                AutoBannerView.this.mTitleView = new TextView(AutoBannerView.this.getContext());
                AutoBannerView.this.mTitleLayout.addView(AutoBannerView.this.mTitleView);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.h(AutoBannerView.this.getContext(), e.C0200e.tbds150));
                layoutParams.addRule(12, -1);
                AutoBannerView.this.mTitleLayout.setLayoutParams(layoutParams);
                AutoBannerView.this.mTitleView.setTextSize(0, l.h(AutoBannerView.this.getContext(), e.C0200e.tbfontsize46));
                AutoBannerView.this.mTitleView.setSingleLine(true);
                AutoBannerView.this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.h(AutoBannerView.this.getContext(), e.C0200e.tbds741), -2);
                layoutParams2.addRule(12, -1);
                layoutParams2.leftMargin = l.h(AutoBannerView.this.getContext(), e.C0200e.tbds44);
                layoutParams2.bottomMargin = l.h(AutoBannerView.this.getContext(), e.C0200e.tbds26);
                AutoBannerView.this.mTitleView.setLayoutParams(layoutParams2);
                AutoBannerView.this.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return relativeLayout;
            }
        };
        this.dqh.setIndicatorNoOffet(true);
        this.dqh.setDisableParentEvent(false);
        this.dqh.setCoverFlowFactory(bVar);
        this.dqh.setCallback(this.auf);
        addView(this.dqh);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dqh;
    }

    public com.baidu.tieba.frs.worldcup.talkball.b.a nD(int i) {
        return (com.baidu.tieba.frs.worldcup.talkball.b.a) v.d(this.mData, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIndex(int i) {
        return i > 0 && i <= v.H(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void os(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ay.Db().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EA() {
        if (this.dqh != null) {
            this.dqh.AP();
        }
    }

    public void Ez() {
        if (this.dqh != null) {
            this.dqh.AO();
        }
    }

    public void bT(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        this.mData = list;
        this.dqh.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aPk = aVar;
    }

    public void setOutOnCoverViewCallback(d<com.baidu.tieba.frs.worldcup.talkball.b.a> dVar) {
        this.ecW = dVar;
    }

    public void onChangeSkinType(int i) {
        al.b(this.mTitleView, e.d.cp_cont_i, 1, i);
        al.d(this.mTitleLayout, e.f.bg_frs_auto_banner_mask, i);
        if (this.dqh != null) {
            this.dqh.onChangeSkinType();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aPk != null) {
            this.aPk.a(this, i == 0, null);
        }
    }
}
