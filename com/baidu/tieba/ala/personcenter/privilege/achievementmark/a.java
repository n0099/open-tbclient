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
/* loaded from: classes10.dex */
public class a extends Dialog {
    private static final int blC = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int iaB = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView iaC;
    private FrameLayout iaD;
    private TextView iaE;
    private RelativeLayout iaF;
    private TextView iaG;
    private TextView iaH;
    private MarkLevelGroup iaI;
    private TextView iaJ;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b iaK;
    private d iaL;
    private AlaUpdateMarkStatusModel iaM;
    private InterfaceC0703a iaN;
    private LinearLayout iaO;
    private TextView iaP;
    private TextView iaQ;
    private LinearLayout iaR;
    private TextView iaS;
    private com.baidu.tieba.ala.personcenter.privilege.b iaT;
    private com.baidu.tieba.ala.personcenter.privilege.a iaU;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0703a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0703a interfaceC0703a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.iaN = interfaceC0703a;
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
        initModel();
    }

    private void initModel() {
        this.iaM = new AlaUpdateMarkStatusModel(getContext());
        this.iaM.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.iaJ.setEnabled(true);
                if (z) {
                    if (a.this.iaN != null) {
                        a.this.iaN.a(true, a.this.iaK);
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
        this.iaT = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.iaT.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oT(boolean z) {
                if (z && a.this.iaK.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.cpL();
                    a.this.cpM();
                    a.this.cpK();
                }
            }
        });
        this.iaU = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0702a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0702a
            public void r(boolean z, String str) {
                if (z) {
                    if (a.this.iaK != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.iaN != null) {
                            a.this.iaN.a(true, a.this.iaK);
                        }
                        a.this.iaK.xP(2);
                        a.this.cpL();
                        a.this.cpM();
                        a.this.cpK();
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
                if (a.this.iaN != null) {
                    a.this.iaN.a(false, a.this.iaK);
                }
                a.this.dismiss();
            }
        });
        this.iaC = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.iaC.setDefaultBgResource(R.color.transparent);
        this.iaC.setDefaultResource(R.drawable.pic_live_honor);
        this.iaD = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.iaE = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.iaF = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.iaG = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.iaH = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.iaI = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.iaI.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eG(String str, String str2) {
                a.this.eF(str, str2);
            }
        });
        this.iaJ = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.iaQ = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.iaO = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.iaP = (TextView) findViewById(R.id.mark_tdou_price);
        this.iaR = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.iaS = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpK() {
        this.iaG.setVisibility(4);
        this.iaH.setVisibility(4);
        this.iaO.setVisibility(4);
        this.iaI.setVisibility(4);
        this.iaR.setVisibility(8);
        if (this.iaK.cpZ()) {
            this.iaO.setVisibility(0);
            this.iaR.setVisibility(0);
            this.iaP.setText(AlaStringHelper.formatLowercasekDou(this.iaK.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.iaS.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.iaS.setCompoundDrawables(drawable, null, null, null);
            this.iaS.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.iaK.cpV() == 1) {
                this.iaR.setVisibility(8);
            }
        } else if (this.iaK.cqa()) {
            this.iaG.setVisibility(0);
            this.iaG.setText(this.iaK.getDescription());
        } else {
            this.iaI.setVisibility(0);
            this.iaG.setVisibility(0);
            this.iaH.setVisibility(0);
            this.iaG.setText(this.iaK.getDescription());
            this.iaH.setText(this.iaK.cpW());
            this.iaI.c(this.iaK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.iaC.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.iaC.startLoad(str, 10, false);
        }
        this.iaE.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpL() {
        switch (this.iaK.cpV()) {
            case 0:
                if (this.iaK.cpZ()) {
                    this.iaJ.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_enter_effect_tdou_buy);
                    this.iaJ.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.iaK.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.iaJ.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.iaK.cqa()) {
                    this.iaJ.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_nobility_open);
                    this.iaJ.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iaJ.setBackgroundResource(R.drawable.transparent_bg);
                    this.iaJ.setTextSize(0, blC);
                    this.iaJ.setText(R.string.ala_achievement_mark_status_unlock);
                    this.iaJ.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.iaK.cpZ()) {
                    this.iaJ.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_achievement_unwear_mark);
                    this.iaJ.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.iaK.cqa()) {
                    this.iaJ.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_achievement_unwear_mark);
                    this.iaJ.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.iaJ.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_achievement_unwear_mark);
                    this.iaJ.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.iaK.cpZ()) {
                    this.iaJ.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_achievement_wear_mark);
                    this.iaJ.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    break;
                } else if (this.iaK.cqa()) {
                    this.iaJ.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_achievement_wear_mark);
                    this.iaJ.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iaJ.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_achievement_wear_mark);
                    this.iaJ.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.iaK.cpZ()) {
                    this.iaJ.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_enter_effect_tdou_buy);
                    this.iaJ.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.iaK.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.iaJ.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.iaK.cqa()) {
                    this.iaJ.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iaJ.setTextSize(0, iaB);
                    this.iaJ.setText(R.string.ala_nobility_open);
                    this.iaJ.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iaJ.setBackgroundResource(R.drawable.transparent_bg);
                    this.iaJ.setTextSize(0, blC);
                    this.iaJ.setText(R.string.ala_achievement_mark_status_expired);
                    this.iaJ.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.iaJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iaK.cpV() == 0 || 3 == a.this.iaK.cpV()) {
                    if (a.this.iaK.cpZ()) {
                        if (a.this.iaK.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.iaT != null) {
                                a.this.iaT.fN(a.this.iaK.price);
                            }
                        } else if (a.this.iaU != null) {
                            a.this.iaU.k(a.this.iaK.cpS(), a.this.iaK.propId, false);
                        }
                    } else if (!a.this.iaK.cqa()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.iaK.cpR() || 2 != a.this.iaK.cpV()) {
                    a.this.cpO();
                } else {
                    a.this.cpN();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpM() {
        if (this.iaK.cpV() == 1 || this.iaK.cpV() == 2) {
            this.iaQ.setVisibility(0);
            this.iaQ.setText(this.iaK.cpY());
            return;
        }
        this.iaQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.jI(false);
        aVar.oZ(R.string.ala_achievement_ops_alert_title);
        aVar.pa(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.iaJ.setEnabled(false);
                a.this.cpO();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpO() {
        if (1 == this.iaK.cpV()) {
            this.iaM.y(false, this.iaK.cpS());
        } else if (2 == this.iaK.cpV()) {
            this.iaM.y(true, this.iaK.cpS());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.iaL = null;
    }

    public void onDestroy() {
        if (this.iaM != null) {
            this.iaM.onDestroy();
        }
    }
}
