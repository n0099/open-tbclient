package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.a;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.d;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup;
import com.baidu.tieba.ala.personcenter.privilege.b;
/* loaded from: classes6.dex */
public class a extends Dialog {
    private static final int exF = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int exG = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView exH;
    private FrameLayout exI;
    private TextView exJ;
    private RelativeLayout exK;
    private TextView exL;
    private TextView exM;
    private MarkLevelGroup exN;
    private TextView exO;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b exP;
    private d exQ;
    private AlaUpdateMarkStatusModel exR;
    private InterfaceC0382a exS;
    private LinearLayout exT;
    private TextView exU;
    private TextView exV;
    private LinearLayout exW;
    private TextView exX;
    private com.baidu.tieba.ala.personcenter.privilege.b exY;
    private com.baidu.tieba.ala.personcenter.privilege.a exZ;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0382a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0382a interfaceC0382a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.exS = interfaceC0382a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
        }
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        initView();
        initDialog();
        dv();
    }

    private void dv() {
        this.exR = new AlaUpdateMarkStatusModel(getContext());
        this.exR.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void k(boolean z, String str) {
                a.this.exO.setEnabled(true);
                if (z) {
                    if (a.this.exS != null) {
                        a.this.exS.a(true, a.this.exP);
                    }
                    a.this.dismiss();
                    return;
                }
                if (StringUtils.isNull(str)) {
                    str = a.this.getContext().getResources().getString(R.string.ala_achievement_ops_failed_tip);
                }
                a.this.mPageContext.showToast(str);
            }
        });
        this.exY = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.exY.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void it(boolean z) {
                if (z && a.this.exP.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.aXF();
                    a.this.aXG();
                    a.this.aXE();
                }
            }
        });
        this.exZ = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0381a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0381a
            public void j(boolean z, String str) {
                if (z) {
                    if (a.this.exP != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.exS != null) {
                            a.this.exS.a(true, a.this.exP);
                        }
                        a.this.exP.ok(2);
                        a.this.aXF();
                        a.this.aXG();
                        a.this.aXE();
                    }
                } else if (!StringUtils.isNull(str)) {
                    a.this.mPageContext.showToast(str);
                } else {
                    a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_fail);
                }
            }
        });
    }

    private void initDialog() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    private void initView() {
        this.mRootView = getLayoutInflater().inflate(R.layout.ala_achievement_mark_mask_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.exS != null) {
                    a.this.exS.a(false, a.this.exP);
                }
                a.this.dismiss();
            }
        });
        this.exH = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.exH.setDefaultBgResource(R.color.transparent);
        this.exH.setDefaultResource(R.drawable.pic_live_honor);
        this.exH.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.exI = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.exJ = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.exK = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.exL = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.exM = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.exN = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.exN.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void cu(String str, String str2) {
                a.this.ct(str, str2);
            }
        });
        this.exO = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.exV = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.exT = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.exU = (TextView) findViewById(R.id.mark_tdou_price);
        this.exW = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.exX = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXE() {
        this.exL.setVisibility(4);
        this.exM.setVisibility(4);
        this.exT.setVisibility(4);
        this.exN.setVisibility(4);
        this.exW.setVisibility(8);
        if (this.exP.aXT()) {
            this.exT.setVisibility(0);
            this.exW.setVisibility(0);
            this.exU.setText(AlaStringHelper.formatLowercasekDou(this.exP.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.exX.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.exX.setCompoundDrawables(drawable, null, null, null);
            this.exX.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.exP.aXP() == 1) {
                this.exW.setVisibility(8);
            }
        } else if (this.exP.aXU()) {
            this.exL.setVisibility(0);
            this.exL.setText(this.exP.getDescription());
        } else {
            this.exN.setVisibility(0);
            this.exL.setVisibility(0);
            this.exM.setVisibility(0);
            this.exL.setText(this.exP.getDescription());
            this.exM.setText(this.exP.aXQ());
            this.exN.c(this.exP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.exH.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.exH.startLoad(str, 10, false);
        }
        this.exJ.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXF() {
        switch (this.exP.aXP()) {
            case 0:
                if (this.exP.aXT()) {
                    this.exO.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_enter_effect_tdou_buy);
                    this.exO.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.exP.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.exO.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.exP.aXU()) {
                    this.exO.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_nobility_open);
                    this.exO.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.exO.setBackgroundResource(R.drawable.transparent_bg);
                    this.exO.setTextSize(0, exF);
                    this.exO.setText(R.string.ala_achievement_mark_status_unlock);
                    this.exO.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.exP.aXT()) {
                    this.exO.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_achievement_unwear_mark);
                    this.exO.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.exP.aXU()) {
                    this.exO.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_achievement_unwear_mark);
                    this.exO.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.exO.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_achievement_unwear_mark);
                    this.exO.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.exP.aXT()) {
                    this.exO.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_achievement_wear_mark);
                    this.exO.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.exP.aXU()) {
                    this.exO.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_achievement_wear_mark);
                    this.exO.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.exO.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_achievement_wear_mark);
                    this.exO.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.exP.aXT()) {
                    this.exO.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_enter_effect_tdou_buy);
                    this.exO.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.exP.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.exO.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.exP.aXU()) {
                    this.exO.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.exO.setTextSize(0, exG);
                    this.exO.setText(R.string.ala_nobility_open);
                    this.exO.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.exO.setBackgroundResource(R.drawable.transparent_bg);
                    this.exO.setTextSize(0, exF);
                    this.exO.setText(R.string.ala_achievement_mark_status_expired);
                    this.exO.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.exO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.exP.aXP() == 0 || 3 == a.this.exP.aXP()) {
                    if (a.this.exP.aXT()) {
                        if (a.this.exP.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.exY != null) {
                                a.this.exY.cp(a.this.exP.price);
                            }
                        } else if (a.this.exZ != null) {
                            a.this.exZ.j(a.this.exP.aXM(), a.this.exP.propId, false);
                        }
                    } else if (!a.this.exP.aXU()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.exP.aXL() || 2 != a.this.exP.aXP()) {
                    a.this.aXI();
                } else {
                    a.this.aXH();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXG() {
        if (this.exP.aXP() == 1 || this.exP.aXP() == 2) {
            this.exV.setVisibility(0);
            this.exV.setText(this.exP.aXS());
            return;
        }
        this.exV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.eh(false);
        aVar.hS(R.string.ala_achievement_ops_alert_title);
        aVar.hT(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.exO.setEnabled(false);
                a.this.aXI();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXI() {
        if (1 == this.exP.aXP()) {
            this.exR.l(false, this.exP.aXM());
        } else if (2 == this.exP.aXP()) {
            this.exR.l(true, this.exP.aXM());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.exQ = null;
    }

    public void onDestroy() {
        if (this.exR != null) {
            this.exR.onDestroy();
        }
    }
}
