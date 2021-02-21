package com.baidu.tieba.frs.gametab;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FollowUserButton;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {
    private final ViewGroup bRb;
    private String forumId;
    private com.baidu.adp.lib.guide.c gGE;
    private View.OnClickListener gkd;
    private final Handler handler = new Handler();
    private com.baidu.adp.lib.guide.b jCi;
    private String jCj;
    private Runnable jCk;
    private String jCl;
    private final Activity mActivity;

    public c(Activity activity, int i) {
        this.mActivity = activity;
        this.bRb = (ViewGroup) activity.findViewById(i);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.gkd = onClickListener;
    }

    public void KN(String str) {
        this.jCj = str;
    }

    public void KO(String str) {
        this.jCl = str;
    }

    public void cpf() {
        if (this.bRb != null) {
            this.bRb.setVisibility(0);
            if (this.gGE != null) {
                this.gGE.d(this.bRb);
            }
            this.jCk = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gGE != null) {
                        c.this.gGE.d(c.this.bRb);
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.frs.gametab.c.2
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    c.this.gGE = null;
                    c.this.handler.removeCallbacks(c.this.jCk);
                }
            });
            if (this.jCi == null) {
                this.jCi = cIJ();
            }
            dVar.a(this.jCi);
            dVar.ap(R.anim.frs_guide_tip_enter);
            dVar.aq(R.anim.frs_guide_tip_out);
            this.gGE = dVar.lF();
            this.gGE.a(this.mActivity, this.bRb, false);
            this.handler.postDelayed(this.jCk, 4000L);
        }
    }

    public void cII() {
        if (this.gGE != null) {
            this.gGE.d(this.bRb);
            this.bRb.setVisibility(8);
        }
    }

    private com.baidu.adp.lib.guide.b cIJ() {
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
                if (!StringUtils.isNull(c.this.jCj)) {
                    barImageView.startLoad(c.this.jCj, 10, false);
                }
                final com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
                aVar.pR(R.color.CAM_X0302);
                aVar.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
                aVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                aVar.pQ(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
                followUserButton.setConfig(aVar);
                followUserButton.setText(c.this.mActivity.getString(R.string.attention));
                followUserButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.gkd != null) {
                            c.this.gkd.onClick(view);
                        }
                        aVar.pR(R.color.CAM_X0109);
                        aVar.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                        followUserButton.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                        followUserButton.setClickable(false);
                        if (c.this.jCk != null) {
                            c.this.handler.removeCallbacks(c.this.jCk);
                            c.this.handler.postDelayed(c.this.jCk, 1000L);
                        }
                    }
                });
                com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0207).pb(l.getDimens(c.this.mActivity, R.dimen.tbds21)).pc(R.color.CAM_X0803).pa(4369).pd(l.getDimens(c.this.mActivity, R.dimen.tbds10)).pe(0).pf(l.getDimens(c.this.mActivity, R.dimen.tbds5)).bv(findViewById);
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

    public void cIK() {
        if (this.bRb != null) {
            this.bRb.setVisibility(0);
            if (this.gGE != null) {
                this.gGE.d(this.bRb);
            }
            this.jCk = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gGE != null) {
                        c.this.gGE.d(c.this.bRb);
                        c.this.bRb.setVisibility(8);
                    }
                }
            };
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.ab(true);
            dVar.b(new d.a() { // from class: com.baidu.tieba.frs.gametab.c.5
                @Override // com.baidu.adp.lib.guide.d.a
                public void onShown() {
                }

                @Override // com.baidu.adp.lib.guide.d.a
                public void onDismiss() {
                    c.this.gGE = null;
                    c.this.handler.removeCallbacks(c.this.jCk);
                }
            });
            if (this.jCi == null) {
                this.jCi = cIL();
            }
            dVar.a(this.jCi);
            dVar.ap(R.anim.frs_guide_tip_enter);
            dVar.aq(R.anim.frs_guide_tip_out);
            this.gGE = dVar.lF();
            this.gGE.a(this.mActivity, this.bRb, false);
            com.baidu.tbadk.core.elementsMaven.c.br(this.bRb).og(R.string.J_X05).oh(R.array.S_O_X004).setBackGroundColor(R.color.CAM_X0207);
            this.handler.postDelayed(this.jCk, 5000L);
        }
    }

    private com.baidu.adp.lib.guide.b cIL() {
        return new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.gametab.c.6
            @Override // com.baidu.adp.lib.guide.b
            public View getView(LayoutInflater layoutInflater) {
                View inflate = layoutInflater.inflate(R.layout.frs_guide_delete_thread_tip, (ViewGroup) null);
                EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.frs_guide_delete_thread_tip_describe);
                ap.setViewTextColor(eMTextView, R.color.CAM_X0302);
                eMTextView.setText(c.this.jCl);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.frs_guide_delete_thread_tip_button);
                com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
                bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
                tBSpecificationBtn.setConfig(bVar);
                tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.frs_guide_delete_thread_tip_button));
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (MessageManager.getInstance().findTask(2002015) != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", c.this.forumId);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkCoreApplication.getInst().getApplicationContext(), "ForumAppealPage", hashMap)));
                        }
                        if (c.this.jCk != null) {
                            c.this.handler.removeCallbacks(c.this.jCk);
                            c.this.handler.postDelayed(c.this.jCk, 1000L);
                        }
                    }
                });
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

    public void setForumId(String str) {
        this.forumId = str;
    }
}
