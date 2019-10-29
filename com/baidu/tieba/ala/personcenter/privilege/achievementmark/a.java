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
    private static final int eyx = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int eyy = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private FrameLayout eyA;
    private TextView eyB;
    private RelativeLayout eyC;
    private TextView eyD;
    private TextView eyE;
    private MarkLevelGroup eyF;
    private TextView eyG;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b eyH;
    private d eyI;
    private AlaUpdateMarkStatusModel eyJ;
    private InterfaceC0382a eyK;
    private LinearLayout eyL;
    private TextView eyM;
    private TextView eyN;
    private LinearLayout eyO;
    private TextView eyP;
    private com.baidu.tieba.ala.personcenter.privilege.b eyQ;
    private com.baidu.tieba.ala.personcenter.privilege.a eyR;
    private TbImageView eyz;
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
        this.eyK = interfaceC0382a;
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
        this.eyJ = new AlaUpdateMarkStatusModel(getContext());
        this.eyJ.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void k(boolean z, String str) {
                a.this.eyG.setEnabled(true);
                if (z) {
                    if (a.this.eyK != null) {
                        a.this.eyK.a(true, a.this.eyH);
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
        this.eyQ = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.eyQ.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void it(boolean z) {
                if (z && a.this.eyH.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.aXH();
                    a.this.aXI();
                    a.this.aXG();
                }
            }
        });
        this.eyR = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0381a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0381a
            public void j(boolean z, String str) {
                if (z) {
                    if (a.this.eyH != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.eyK != null) {
                            a.this.eyK.a(true, a.this.eyH);
                        }
                        a.this.eyH.ol(2);
                        a.this.aXH();
                        a.this.aXI();
                        a.this.aXG();
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
                if (a.this.eyK != null) {
                    a.this.eyK.a(false, a.this.eyH);
                }
                a.this.dismiss();
            }
        });
        this.eyz = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.eyz.setDefaultBgResource(R.color.transparent);
        this.eyz.setDefaultResource(R.drawable.pic_live_honor);
        this.eyz.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.eyA = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.eyB = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.eyC = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.eyD = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.eyE = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.eyF = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.eyF.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void cu(String str, String str2) {
                a.this.ct(str, str2);
            }
        });
        this.eyG = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.eyN = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.eyL = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.eyM = (TextView) findViewById(R.id.mark_tdou_price);
        this.eyO = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.eyP = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXG() {
        this.eyD.setVisibility(4);
        this.eyE.setVisibility(4);
        this.eyL.setVisibility(4);
        this.eyF.setVisibility(4);
        this.eyO.setVisibility(8);
        if (this.eyH.aXV()) {
            this.eyL.setVisibility(0);
            this.eyO.setVisibility(0);
            this.eyM.setText(AlaStringHelper.formatLowercasekDou(this.eyH.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.eyP.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.eyP.setCompoundDrawables(drawable, null, null, null);
            this.eyP.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.eyH.aXR() == 1) {
                this.eyO.setVisibility(8);
            }
        } else if (this.eyH.aXW()) {
            this.eyD.setVisibility(0);
            this.eyD.setText(this.eyH.getDescription());
        } else {
            this.eyF.setVisibility(0);
            this.eyD.setVisibility(0);
            this.eyE.setVisibility(0);
            this.eyD.setText(this.eyH.getDescription());
            this.eyE.setText(this.eyH.aXS());
            this.eyF.c(this.eyH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.eyz.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.eyz.startLoad(str, 10, false);
        }
        this.eyB.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXH() {
        switch (this.eyH.aXR()) {
            case 0:
                if (this.eyH.aXV()) {
                    this.eyG.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_enter_effect_tdou_buy);
                    this.eyG.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.eyH.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.eyG.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.eyH.aXW()) {
                    this.eyG.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_nobility_open);
                    this.eyG.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.eyG.setBackgroundResource(R.drawable.transparent_bg);
                    this.eyG.setTextSize(0, eyx);
                    this.eyG.setText(R.string.ala_achievement_mark_status_unlock);
                    this.eyG.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.eyH.aXV()) {
                    this.eyG.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_achievement_unwear_mark);
                    this.eyG.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.eyH.aXW()) {
                    this.eyG.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_achievement_unwear_mark);
                    this.eyG.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.eyG.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_achievement_unwear_mark);
                    this.eyG.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.eyH.aXV()) {
                    this.eyG.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_achievement_wear_mark);
                    this.eyG.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.eyH.aXW()) {
                    this.eyG.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_achievement_wear_mark);
                    this.eyG.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.eyG.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_achievement_wear_mark);
                    this.eyG.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.eyH.aXV()) {
                    this.eyG.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_enter_effect_tdou_buy);
                    this.eyG.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.eyH.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.eyG.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.eyH.aXW()) {
                    this.eyG.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.eyG.setTextSize(0, eyy);
                    this.eyG.setText(R.string.ala_nobility_open);
                    this.eyG.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.eyG.setBackgroundResource(R.drawable.transparent_bg);
                    this.eyG.setTextSize(0, eyx);
                    this.eyG.setText(R.string.ala_achievement_mark_status_expired);
                    this.eyG.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.eyG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eyH.aXR() == 0 || 3 == a.this.eyH.aXR()) {
                    if (a.this.eyH.aXV()) {
                        if (a.this.eyH.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.eyQ != null) {
                                a.this.eyQ.cq(a.this.eyH.price);
                            }
                        } else if (a.this.eyR != null) {
                            a.this.eyR.j(a.this.eyH.aXO(), a.this.eyH.propId, false);
                        }
                    } else if (!a.this.eyH.aXW()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.eyH.aXN() || 2 != a.this.eyH.aXR()) {
                    a.this.aXK();
                } else {
                    a.this.aXJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXI() {
        if (this.eyH.aXR() == 1 || this.eyH.aXR() == 2) {
            this.eyN.setVisibility(0);
            this.eyN.setText(this.eyH.aXU());
            return;
        }
        this.eyN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.eh(false);
        aVar.hT(R.string.ala_achievement_ops_alert_title);
        aVar.hU(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.eyG.setEnabled(false);
                a.this.aXK();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXK() {
        if (1 == this.eyH.aXR()) {
            this.eyJ.l(false, this.eyH.aXO());
        } else if (2 == this.eyH.aXR()) {
            this.eyJ.l(true, this.eyH.aXO());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.eyI = null;
    }

    public void onDestroy() {
        if (this.eyJ != null) {
            this.eyJ.onDestroy();
        }
    }
}
