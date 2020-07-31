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
/* loaded from: classes4.dex */
public class a extends Dialog {
    private static final int aTn = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int gHJ = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView gHK;
    private FrameLayout gHL;
    private TextView gHM;
    private RelativeLayout gHN;
    private TextView gHO;
    private TextView gHP;
    private MarkLevelGroup gHQ;
    private TextView gHR;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b gHS;
    private d gHT;
    private AlaUpdateMarkStatusModel gHU;
    private InterfaceC0603a gHV;
    private LinearLayout gHW;
    private TextView gHX;
    private TextView gHY;
    private LinearLayout gHZ;
    private TextView gIa;
    private com.baidu.tieba.ala.personcenter.privilege.b gIb;
    private com.baidu.tieba.ala.personcenter.privilege.a gIc;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0603a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0603a interfaceC0603a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gHV = interfaceC0603a;
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
        BE();
    }

    private void BE() {
        this.gHU = new AlaUpdateMarkStatusModel(getContext());
        this.gHU.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.gHR.setEnabled(true);
                if (z) {
                    if (a.this.gHV != null) {
                        a.this.gHV.a(true, a.this.gHS);
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
        this.gIb = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.gIb.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void mn(boolean z) {
                if (z && a.this.gHS.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bOG();
                    a.this.bOH();
                    a.this.bOF();
                }
            }
        });
        this.gIc = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0602a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0602a
            public void o(boolean z, String str) {
                if (z) {
                    if (a.this.gHS != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.gHV != null) {
                            a.this.gHV.a(true, a.this.gHS);
                        }
                        a.this.gHS.sF(2);
                        a.this.bOG();
                        a.this.bOH();
                        a.this.bOF();
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
                if (a.this.gHV != null) {
                    a.this.gHV.a(false, a.this.gHS);
                }
                a.this.dismiss();
            }
        });
        this.gHK = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.gHK.setDefaultBgResource(R.color.transparent);
        this.gHK.setDefaultResource(R.drawable.pic_live_honor);
        this.gHK.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.gHL = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.gHM = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.gHN = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.gHO = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.gHP = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.gHQ = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.gHQ.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void dS(String str, String str2) {
                a.this.dR(str, str2);
            }
        });
        this.gHR = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.gHY = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.gHW = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.gHX = (TextView) findViewById(R.id.mark_tdou_price);
        this.gHZ = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.gIa = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOF() {
        this.gHO.setVisibility(4);
        this.gHP.setVisibility(4);
        this.gHW.setVisibility(4);
        this.gHQ.setVisibility(4);
        this.gHZ.setVisibility(8);
        if (this.gHS.bOU()) {
            this.gHW.setVisibility(0);
            this.gHZ.setVisibility(0);
            this.gHX.setText(AlaStringHelper.formatLowercasekDou(this.gHS.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.gIa.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.gIa.setCompoundDrawables(drawable, null, null, null);
            this.gIa.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.gHS.bOQ() == 1) {
                this.gHZ.setVisibility(8);
            }
        } else if (this.gHS.bOV()) {
            this.gHO.setVisibility(0);
            this.gHO.setText(this.gHS.getDescription());
        } else {
            this.gHQ.setVisibility(0);
            this.gHO.setVisibility(0);
            this.gHP.setVisibility(0);
            this.gHO.setText(this.gHS.getDescription());
            this.gHP.setText(this.gHS.bOR());
            this.gHQ.c(this.gHS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dR(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.gHK.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.gHK.startLoad(str, 10, false);
        }
        this.gHM.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOG() {
        switch (this.gHS.bOQ()) {
            case 0:
                if (this.gHS.bOU()) {
                    this.gHR.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gHR.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gHS.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gHR.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gHS.bOV()) {
                    this.gHR.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_nobility_open);
                    this.gHR.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gHR.setBackgroundResource(R.drawable.transparent_bg);
                    this.gHR.setTextSize(0, aTn);
                    this.gHR.setText(R.string.ala_achievement_mark_status_unlock);
                    this.gHR.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.gHS.bOU()) {
                    this.gHR.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_achievement_unwear_mark);
                    this.gHR.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.gHS.bOV()) {
                    this.gHR.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_achievement_unwear_mark);
                    this.gHR.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.gHR.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_achievement_unwear_mark);
                    this.gHR.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.gHS.bOU()) {
                    this.gHR.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_achievement_wear_mark);
                    this.gHR.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.gHS.bOV()) {
                    this.gHR.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_achievement_wear_mark);
                    this.gHR.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gHR.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_achievement_wear_mark);
                    this.gHR.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.gHS.bOU()) {
                    this.gHR.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gHR.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gHS.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gHR.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gHS.bOV()) {
                    this.gHR.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gHR.setTextSize(0, gHJ);
                    this.gHR.setText(R.string.ala_nobility_open);
                    this.gHR.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gHR.setBackgroundResource(R.drawable.transparent_bg);
                    this.gHR.setTextSize(0, aTn);
                    this.gHR.setText(R.string.ala_achievement_mark_status_expired);
                    this.gHR.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.gHR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gHS.bOQ() == 0 || 3 == a.this.gHS.bOQ()) {
                    if (a.this.gHS.bOU()) {
                        if (a.this.gHS.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.gIb != null) {
                                a.this.gIb.ed(a.this.gHS.price);
                            }
                        } else if (a.this.gIc != null) {
                            a.this.gIc.l(a.this.gHS.bON(), a.this.gHS.propId, false);
                        }
                    } else if (!a.this.gHS.bOV()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.gHS.bOM() || 2 != a.this.gHS.bOQ()) {
                    a.this.bOJ();
                } else {
                    a.this.bOI();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        if (this.gHS.bOQ() == 1 || this.gHS.bOQ() == 2) {
            this.gHY.setVisibility(0);
            this.gHY.setText(this.gHS.bOT());
            return;
        }
        this.gHY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.hK(false);
        aVar.lm(R.string.ala_achievement_ops_alert_title);
        aVar.ln(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.gHR.setEnabled(false);
                a.this.bOJ();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOJ() {
        if (1 == this.gHS.bOQ()) {
            this.gHU.w(false, this.gHS.bON());
        } else if (2 == this.gHS.bOQ()) {
            this.gHU.w(true, this.gHS.bON());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.gHT = null;
    }

    public void onDestroy() {
        if (this.gHU != null) {
            this.gHU.onDestroy();
        }
    }
}
