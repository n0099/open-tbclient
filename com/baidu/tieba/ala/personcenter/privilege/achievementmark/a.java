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
    private static final int bke = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int iaD = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView iaE;
    private FrameLayout iaF;
    private TextView iaG;
    private RelativeLayout iaH;
    private TextView iaI;
    private TextView iaJ;
    private MarkLevelGroup iaK;
    private TextView iaL;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b iaM;
    private d iaN;
    private AlaUpdateMarkStatusModel iaO;
    private InterfaceC0687a iaP;
    private LinearLayout iaQ;
    private TextView iaR;
    private TextView iaS;
    private LinearLayout iaT;
    private TextView iaU;
    private com.baidu.tieba.ala.personcenter.privilege.b iaV;
    private com.baidu.tieba.ala.personcenter.privilege.a iaW;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0687a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0687a interfaceC0687a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.iaP = interfaceC0687a;
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
        this.iaO = new AlaUpdateMarkStatusModel(getContext());
        this.iaO.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.iaL.setEnabled(true);
                if (z) {
                    if (a.this.iaP != null) {
                        a.this.iaP.a(true, a.this.iaM);
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
        this.iaV = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.iaV.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oZ(boolean z) {
                if (z && a.this.iaM.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.cmZ();
                    a.this.cna();
                    a.this.cmY();
                }
            }
        });
        this.iaW = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0686a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0686a
            public void y(boolean z, String str) {
                if (z) {
                    if (a.this.iaM != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.iaP != null) {
                            a.this.iaP.a(true, a.this.iaM);
                        }
                        a.this.iaM.wu(2);
                        a.this.cmZ();
                        a.this.cna();
                        a.this.cmY();
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
                if (a.this.iaP != null) {
                    a.this.iaP.a(false, a.this.iaM);
                }
                a.this.dismiss();
            }
        });
        this.iaE = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.iaE.setDefaultBgResource(R.color.transparent);
        this.iaE.setDefaultResource(R.drawable.pic_live_honor);
        this.iaF = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.iaG = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.iaH = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.iaI = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.iaJ = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.iaK = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.iaK.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eE(String str, String str2) {
                a.this.eD(str, str2);
            }
        });
        this.iaL = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.iaS = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.iaQ = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.iaR = (TextView) findViewById(R.id.mark_tdou_price);
        this.iaT = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.iaU = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmY() {
        this.iaI.setVisibility(4);
        this.iaJ.setVisibility(4);
        this.iaQ.setVisibility(4);
        this.iaK.setVisibility(4);
        this.iaT.setVisibility(8);
        if (this.iaM.cnn()) {
            this.iaQ.setVisibility(0);
            this.iaT.setVisibility(0);
            this.iaR.setText(AlaStringHelper.formatLowercasekDou(this.iaM.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.iaU.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.iaU.setCompoundDrawables(drawable, null, null, null);
            this.iaU.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.iaM.cnj() == 1) {
                this.iaT.setVisibility(8);
            }
        } else if (this.iaM.cno()) {
            this.iaI.setVisibility(0);
            this.iaI.setText(this.iaM.getDescription());
        } else {
            this.iaK.setVisibility(0);
            this.iaI.setVisibility(0);
            this.iaJ.setVisibility(0);
            this.iaI.setText(this.iaM.getDescription());
            this.iaJ.setText(this.iaM.cnk());
            this.iaK.c(this.iaM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.iaE.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.iaE.startLoad(str, 10, false);
        }
        this.iaG.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmZ() {
        switch (this.iaM.cnj()) {
            case 0:
                if (this.iaM.cnn()) {
                    this.iaL.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_enter_effect_tdou_buy);
                    this.iaL.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.iaM.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.iaL.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.iaM.cno()) {
                    this.iaL.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_nobility_open);
                    this.iaL.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iaL.setBackgroundResource(R.drawable.transparent_bg);
                    this.iaL.setTextSize(0, bke);
                    this.iaL.setText(R.string.ala_achievement_mark_status_unlock);
                    this.iaL.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.iaM.cnn()) {
                    this.iaL.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_achievement_unwear_mark);
                    this.iaL.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.iaM.cno()) {
                    this.iaL.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_achievement_unwear_mark);
                    this.iaL.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.iaL.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_achievement_unwear_mark);
                    this.iaL.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.iaM.cnn()) {
                    this.iaL.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_achievement_wear_mark);
                    this.iaL.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    break;
                } else if (this.iaM.cno()) {
                    this.iaL.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_achievement_wear_mark);
                    this.iaL.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iaL.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_achievement_wear_mark);
                    this.iaL.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.iaM.cnn()) {
                    this.iaL.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_enter_effect_tdou_buy);
                    this.iaL.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.iaM.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.iaL.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.iaM.cno()) {
                    this.iaL.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iaL.setTextSize(0, iaD);
                    this.iaL.setText(R.string.ala_nobility_open);
                    this.iaL.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iaL.setBackgroundResource(R.drawable.transparent_bg);
                    this.iaL.setTextSize(0, bke);
                    this.iaL.setText(R.string.ala_achievement_mark_status_expired);
                    this.iaL.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.iaL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iaM.cnj() == 0 || 3 == a.this.iaM.cnj()) {
                    if (a.this.iaM.cnn()) {
                        if (a.this.iaM.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.iaV != null) {
                                a.this.iaV.fT(a.this.iaM.price);
                            }
                        } else if (a.this.iaW != null) {
                            a.this.iaW.l(a.this.iaM.cng(), a.this.iaM.propId, false);
                        }
                    } else if (!a.this.iaM.cno()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.iaM.cnf() || 2 != a.this.iaM.cnj()) {
                    a.this.cnc();
                } else {
                    a.this.cnb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cna() {
        if (this.iaM.cnj() == 1 || this.iaM.cnj() == 2) {
            this.iaS.setVisibility(0);
            this.iaS.setText(this.iaM.cnm());
            return;
        }
        this.iaS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.jG(false);
        aVar.nw(R.string.ala_achievement_ops_alert_title);
        aVar.nx(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.iaL.setEnabled(false);
                a.this.cnc();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnc() {
        if (1 == this.iaM.cnj()) {
            this.iaO.y(false, this.iaM.cng());
        } else if (2 == this.iaM.cnj()) {
            this.iaO.y(true, this.iaM.cng());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.iaN = null;
    }

    public void onDestroy() {
        if (this.iaO != null) {
            this.iaO.onDestroy();
        }
    }
}
