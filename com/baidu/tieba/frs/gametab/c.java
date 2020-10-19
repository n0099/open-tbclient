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
/* loaded from: classes22.dex */
public class c {
    private final ViewGroup bBk;
    private View.OnClickListener fGO;
    private com.baidu.adp.lib.guide.c fZy;
    private final Handler handler = new Handler();
    private com.baidu.adp.lib.guide.b iHQ;
    private String iHR;
    private Runnable iHS;
    private final Activity mActivity;

    public c(Activity activity, int i) {
        this.mActivity = activity;
        this.bBk = (ViewGroup) activity.findViewById(i);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.fGO = onClickListener;
    }

    public void JP(String str) {
        this.iHR = str;
    }

    public void cfF() {
        if (this.bBk != null) {
            if (this.fZy != null) {
                this.fZy.b(this.bBk);
            }
            this.iHS = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fZy != null) {
                        c.this.fZy.b(c.this.bBk);
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
                    c.this.fZy = null;
                    c.this.handler.removeCallbacks(c.this.iHS);
                }
            });
            if (this.iHQ == null) {
                this.iHQ = cxI();
            }
            dVar.a(this.iHQ);
            dVar.am(R.anim.frs_guide_tip_enter);
            dVar.an(R.anim.frs_guide_tip_out);
            this.fZy = dVar.mi();
            this.fZy.a(this.mActivity, this.bBk, false);
            this.handler.postDelayed(this.iHS, 4000L);
        }
    }

    public void cxH() {
        if (this.fZy != null) {
            this.fZy.b(this.bBk);
        }
    }

    private com.baidu.adp.lib.guide.b cxI() {
        return new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.gametab.c.3
            @Override // com.baidu.adp.lib.guide.b
            public View getView(LayoutInflater layoutInflater) {
                View inflate = layoutInflater.inflate(R.layout.frs_guide_tip, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.frs_guide_bg);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.frs_guide_bar_icon);
                final FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(R.id.frs_guide_concern_btn);
                ap.setViewTextColor((TextView) inflate.findViewById(R.id.frs_guide_text), R.color.cp_link_tip_a);
                barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                barImageView.setContentDescription(c.this.mActivity.getResources().getString(R.string.bar_header));
                barImageView.setStrokeWith(l.getDimens(c.this.mActivity, R.dimen.tbds1));
                barImageView.setShowOval(true);
                barImageView.setPlaceHolder(2);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeColorResId(R.color.cp_border_a);
                if (!StringUtils.isNull(c.this.iHR)) {
                    barImageView.startLoad(c.this.iHR, 10, false);
                }
                final com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
                aVar.pN(R.color.cp_link_tip_a);
                aVar.pI(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                aVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.pM(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(c.this.mActivity.getString(R.string.attention));
                followUserButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.fGO != null) {
                            c.this.fGO.onClick(view);
                        }
                        aVar.pN(R.color.cp_cont_d);
                        aVar.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                        followUserButton.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                        followUserButton.setClickable(false);
                        if (c.this.iHS != null) {
                            c.this.handler.removeCallbacks(c.this.iHS);
                            c.this.handler.postDelayed(c.this.iHS, 1000L);
                        }
                    }
                });
                com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_bg_line_h).oZ(l.getDimens(c.this.mActivity, R.dimen.tbds21)).pa(R.color.cp_shadow_a_alpha12).oY(4369).pb(l.getDimens(c.this.mActivity, R.dimen.tbds10)).pc(0).pd(l.getDimens(c.this.mActivity, R.dimen.tbds5)).bf(findViewById);
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
