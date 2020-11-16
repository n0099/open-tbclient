package com.baidu.tieba.frs.gametab;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes21.dex */
public class c {
    private final ViewGroup bIc;
    private View.OnClickListener fUG;
    private com.baidu.adp.lib.guide.c goX;
    private final Handler handler = new Handler();
    private com.baidu.adp.lib.guide.b jaV;
    private String jaW;
    private Runnable jaX;
    private final Activity mActivity;

    public c(Activity activity, int i) {
        this.mActivity = activity;
        this.bIc = (ViewGroup) activity.findViewById(i);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.fUG = onClickListener;
    }

    public void Kg(String str) {
        this.jaW = str;
    }

    public void ckB() {
        if (this.bIc != null) {
            if (this.goX != null) {
                this.goX.b(this.bIc);
            }
            this.jaX = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.goX != null) {
                        c.this.goX.b(c.this.bIc);
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ae(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    c.this.goX = null;
                    c.this.handler.removeCallbacks(c.this.jaX);
                }
            });
            if (this.jaV == null) {
                this.jaV = cCU();
            }
            dVar.a(this.jaV);
            dVar.am(R.anim.frs_guide_tip_enter);
            dVar.an(R.anim.frs_guide_tip_out);
            this.goX = dVar.mi();
            this.goX.a(this.mActivity, this.bIc, false);
            this.handler.postDelayed(this.jaX, 4000L);
        }
    }

    public void cCT() {
        if (this.goX != null) {
            this.goX.b(this.bIc);
        }
    }

    private com.baidu.adp.lib.guide.b cCU() {
        return new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.gametab.c.3
            @Override // com.baidu.adp.lib.guide.b
            public View getView(LayoutInflater layoutInflater) {
                View inflate = layoutInflater.inflate(R.layout.frs_guide_tip, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.frs_guide_bg);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.frs_guide_bar_icon);
                final FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(R.id.frs_guide_concern_btn);
                ap.setViewTextColor((TextView) inflate.findViewById(R.id.frs_guide_text), R.color.CAM_X0302);
                barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                barImageView.setContentDescription(c.this.mActivity.getResources().getString(R.string.bar_header));
                barImageView.setStrokeWith(l.getDimens(c.this.mActivity, R.dimen.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(1);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
                if (!StringUtils.isNull(c.this.jaW)) {
                    barImageView.startLoad(c.this.jaW, 10, false);
                }
                final com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
                aVar.qG(R.color.CAM_X0302);
                aVar.qB(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                aVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.qF(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(c.this.mActivity.getString(R.string.attention));
                followUserButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.fUG != null) {
                            c.this.fUG.onClick(view);
                        }
                        aVar.qG(R.color.CAM_X0109);
                        aVar.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                        followUserButton.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                        followUserButton.setClickable(false);
                        if (c.this.jaX != null) {
                            c.this.handler.removeCallbacks(c.this.jaX);
                            c.this.handler.postDelayed(c.this.jaX, 1000L);
                        }
                    }
                });
                com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0207).pS(l.getDimens(c.this.mActivity, R.dimen.tbds21)).pT(R.color.CAM_X0803).pR(4369).pU(l.getDimens(c.this.mActivity, R.dimen.tbds10)).pV(0).pW(l.getDimens(c.this.mActivity, R.dimen.tbds5)).bn(findViewById);
                return inflate;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getAnchor() {
                return 3;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getFitPosition() {
                return 32;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getXOffset() {
                return 0;
            }

            @Override // com.baidu.adp.lib.guide.b
            public int getYOffset() {
                return 0;
            }
        };
    }
}
