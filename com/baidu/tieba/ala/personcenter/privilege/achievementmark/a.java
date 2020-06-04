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
/* loaded from: classes3.dex */
public class a extends Dialog {
    private static final int aPo = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int gpx = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TextView gpA;
    private RelativeLayout gpB;
    private TextView gpC;
    private TextView gpD;
    private MarkLevelGroup gpE;
    private TextView gpF;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b gpG;
    private d gpH;
    private AlaUpdateMarkStatusModel gpI;
    private InterfaceC0585a gpJ;
    private LinearLayout gpK;
    private TextView gpL;
    private TextView gpM;
    private LinearLayout gpN;
    private TextView gpO;
    private com.baidu.tieba.ala.personcenter.privilege.b gpP;
    private com.baidu.tieba.ala.personcenter.privilege.a gpQ;
    private TbImageView gpy;
    private FrameLayout gpz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0585a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0585a interfaceC0585a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gpJ = interfaceC0585a;
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
        AC();
    }

    private void AC() {
        this.gpI = new AlaUpdateMarkStatusModel(getContext());
        this.gpI.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.gpF.setEnabled(true);
                if (z) {
                    if (a.this.gpJ != null) {
                        a.this.gpJ.a(true, a.this.gpG);
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
        this.gpP = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.gpP.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void lA(boolean z) {
                if (z && a.this.gpG.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bIs();
                    a.this.bIt();
                    a.this.bIr();
                }
            }
        });
        this.gpQ = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0584a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0584a
            public void m(boolean z, String str) {
                if (z) {
                    if (a.this.gpG != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.gpJ != null) {
                            a.this.gpJ.a(true, a.this.gpG);
                        }
                        a.this.gpG.rP(2);
                        a.this.bIs();
                        a.this.bIt();
                        a.this.bIr();
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
                if (a.this.gpJ != null) {
                    a.this.gpJ.a(false, a.this.gpG);
                }
                a.this.dismiss();
            }
        });
        this.gpy = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.gpy.setDefaultBgResource(R.color.transparent);
        this.gpy.setDefaultResource(R.drawable.pic_live_honor);
        this.gpy.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.gpz = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.gpA = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.gpB = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.gpC = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.gpD = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.gpE = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.gpE.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void dL(String str, String str2) {
                a.this.dK(str, str2);
            }
        });
        this.gpF = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.gpM = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.gpK = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.gpL = (TextView) findViewById(R.id.mark_tdou_price);
        this.gpN = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.gpO = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIr() {
        this.gpC.setVisibility(4);
        this.gpD.setVisibility(4);
        this.gpK.setVisibility(4);
        this.gpE.setVisibility(4);
        this.gpN.setVisibility(8);
        if (this.gpG.bIG()) {
            this.gpK.setVisibility(0);
            this.gpN.setVisibility(0);
            this.gpL.setText(AlaStringHelper.formatLowercasekDou(this.gpG.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.gpO.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.gpO.setCompoundDrawables(drawable, null, null, null);
            this.gpO.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.gpG.bIC() == 1) {
                this.gpN.setVisibility(8);
            }
        } else if (this.gpG.bIH()) {
            this.gpC.setVisibility(0);
            this.gpC.setText(this.gpG.getDescription());
        } else {
            this.gpE.setVisibility(0);
            this.gpC.setVisibility(0);
            this.gpD.setVisibility(0);
            this.gpC.setText(this.gpG.getDescription());
            this.gpD.setText(this.gpG.bID());
            this.gpE.c(this.gpG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dK(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.gpy.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.gpy.startLoad(str, 10, false);
        }
        this.gpA.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIs() {
        switch (this.gpG.bIC()) {
            case 0:
                if (this.gpG.bIG()) {
                    this.gpF.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gpF.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gpG.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gpF.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gpG.bIH()) {
                    this.gpF.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_nobility_open);
                    this.gpF.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gpF.setBackgroundResource(R.drawable.transparent_bg);
                    this.gpF.setTextSize(0, aPo);
                    this.gpF.setText(R.string.ala_achievement_mark_status_unlock);
                    this.gpF.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.gpG.bIG()) {
                    this.gpF.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_achievement_unwear_mark);
                    this.gpF.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.gpG.bIH()) {
                    this.gpF.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_achievement_unwear_mark);
                    this.gpF.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.gpF.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_achievement_unwear_mark);
                    this.gpF.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.gpG.bIG()) {
                    this.gpF.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_achievement_wear_mark);
                    this.gpF.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.gpG.bIH()) {
                    this.gpF.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_achievement_wear_mark);
                    this.gpF.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gpF.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_achievement_wear_mark);
                    this.gpF.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.gpG.bIG()) {
                    this.gpF.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gpF.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gpG.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gpF.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gpG.bIH()) {
                    this.gpF.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gpF.setTextSize(0, gpx);
                    this.gpF.setText(R.string.ala_nobility_open);
                    this.gpF.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gpF.setBackgroundResource(R.drawable.transparent_bg);
                    this.gpF.setTextSize(0, aPo);
                    this.gpF.setText(R.string.ala_achievement_mark_status_expired);
                    this.gpF.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.gpF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gpG.bIC() == 0 || 3 == a.this.gpG.bIC()) {
                    if (a.this.gpG.bIG()) {
                        if (a.this.gpG.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.gpP != null) {
                                a.this.gpP.dN(a.this.gpG.price);
                            }
                        } else if (a.this.gpQ != null) {
                            a.this.gpQ.l(a.this.gpG.bIz(), a.this.gpG.propId, false);
                        }
                    } else if (!a.this.gpG.bIH()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.gpG.bIy() || 2 != a.this.gpG.bIC()) {
                    a.this.bIv();
                } else {
                    a.this.bIu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIt() {
        if (this.gpG.bIC() == 1 || this.gpG.bIC() == 2) {
            this.gpM.setVisibility(0);
            this.gpM.setText(this.gpG.bIF());
            return;
        }
        this.gpM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.gX(false);
        aVar.kE(R.string.ala_achievement_ops_alert_title);
        aVar.kF(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.gpF.setEnabled(false);
                a.this.bIv();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIv() {
        if (1 == this.gpG.bIC()) {
            this.gpI.u(false, this.gpG.bIz());
        } else if (2 == this.gpG.bIC()) {
            this.gpI.u(true, this.gpG.bIz());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.gpH = null;
    }

    public void onDestroy() {
        if (this.gpI != null) {
            this.gpI.onDestroy();
        }
    }
}
