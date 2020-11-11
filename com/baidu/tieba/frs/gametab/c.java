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
    private final ViewGroup bJN;
    private View.OnClickListener fUZ;
    private com.baidu.adp.lib.guide.c gpq;
    private final Handler handler = new Handler();
    private com.baidu.adp.lib.guide.b jaj;
    private String jak;
    private Runnable jal;
    private final Activity mActivity;

    public c(Activity activity, int i) {
        this.mActivity = activity;
        this.bJN = (ViewGroup) activity.findViewById(i);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.fUZ = onClickListener;
    }

    public void KF(String str) {
        this.jak = str;
    }

    public void cli() {
        if (this.bJN != null) {
            if (this.gpq != null) {
                this.gpq.b(this.bJN);
            }
            this.jal = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gpq != null) {
                        c.this.gpq.b(c.this.bJN);
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
                    c.this.gpq = null;
                    c.this.handler.removeCallbacks(c.this.jal);
                }
            });
            if (this.jaj == null) {
                this.jaj = cDq();
            }
            dVar.a(this.jaj);
            dVar.am(R.anim.frs_guide_tip_enter);
            dVar.an(R.anim.frs_guide_tip_out);
            this.gpq = dVar.mi();
            this.gpq.a(this.mActivity, this.bJN, false);
            this.handler.postDelayed(this.jal, 4000L);
        }
    }

    public void cDp() {
        if (this.gpq != null) {
            this.gpq.b(this.bJN);
        }
    }

    private com.baidu.adp.lib.guide.b cDq() {
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
                if (!StringUtils.isNull(c.this.jak)) {
                    barImageView.startLoad(c.this.jak, 10, false);
                }
                final com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
                aVar.qi(R.color.cp_link_tip_a);
                aVar.qd(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                aVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.qh(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(c.this.mActivity.getString(R.string.attention));
                followUserButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.fUZ != null) {
                            c.this.fUZ.onClick(view);
                        }
                        aVar.qi(R.color.cp_cont_d);
                        aVar.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                        followUserButton.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                        followUserButton.setClickable(false);
                        if (c.this.jal != null) {
                            c.this.handler.removeCallbacks(c.this.jal);
                            c.this.handler.postDelayed(c.this.jal, 1000L);
                        }
                    }
                });
                com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_bg_line_h).pv(l.getDimens(c.this.mActivity, R.dimen.tbds21)).pw(R.color.cp_shadow_a_alpha12).pu(4369).px(l.getDimens(c.this.mActivity, R.dimen.tbds10)).py(0).pz(l.getDimens(c.this.mActivity, R.dimen.tbds5)).bk(findViewById);
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
