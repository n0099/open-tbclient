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
    private static final int bhu = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int hEQ = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView hER;
    private FrameLayout hES;
    private TextView hET;
    private RelativeLayout hEU;
    private TextView hEV;
    private TextView hEW;
    private MarkLevelGroup hEX;
    private TextView hEY;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b hEZ;
    private d hFa;
    private AlaUpdateMarkStatusModel hFb;
    private InterfaceC0698a hFc;
    private LinearLayout hFd;
    private TextView hFe;
    private TextView hFf;
    private LinearLayout hFg;
    private TextView hFh;
    private com.baidu.tieba.ala.personcenter.privilege.b hFi;
    private com.baidu.tieba.ala.personcenter.privilege.a hFj;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0698a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0698a interfaceC0698a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.hFc = interfaceC0698a;
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
        Jz();
    }

    private void Jz() {
        this.hFb = new AlaUpdateMarkStatusModel(getContext());
        this.hFb.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.hEY.setEnabled(true);
                if (z) {
                    if (a.this.hFc != null) {
                        a.this.hFc.a(true, a.this.hEZ);
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
        this.hFi = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.hFi.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void nY(boolean z) {
                if (z && a.this.hEZ.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.cjF();
                    a.this.cjG();
                    a.this.cjE();
                }
            }
        });
        this.hFj = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0697a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0697a
            public void r(boolean z, String str) {
                if (z) {
                    if (a.this.hEZ != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.hFc != null) {
                            a.this.hFc.a(true, a.this.hEZ);
                        }
                        a.this.hEZ.wz(2);
                        a.this.cjF();
                        a.this.cjG();
                        a.this.cjE();
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
                if (a.this.hFc != null) {
                    a.this.hFc.a(false, a.this.hEZ);
                }
                a.this.dismiss();
            }
        });
        this.hER = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.hER.setDefaultBgResource(R.color.transparent);
        this.hER.setDefaultResource(R.drawable.pic_live_honor);
        this.hER.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.hES = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.hET = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.hEU = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.hEV = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.hEW = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.hEX = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.hEX.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eA(String str, String str2) {
                a.this.ez(str, str2);
            }
        });
        this.hEY = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.hFf = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.hFd = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.hFe = (TextView) findViewById(R.id.mark_tdou_price);
        this.hFg = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.hFh = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjE() {
        this.hEV.setVisibility(4);
        this.hEW.setVisibility(4);
        this.hFd.setVisibility(4);
        this.hEX.setVisibility(4);
        this.hFg.setVisibility(8);
        if (this.hEZ.cjT()) {
            this.hFd.setVisibility(0);
            this.hFg.setVisibility(0);
            this.hFe.setText(AlaStringHelper.formatLowercasekDou(this.hEZ.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.hFh.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.hFh.setCompoundDrawables(drawable, null, null, null);
            this.hFh.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.hEZ.cjP() == 1) {
                this.hFg.setVisibility(8);
            }
        } else if (this.hEZ.cjU()) {
            this.hEV.setVisibility(0);
            this.hEV.setText(this.hEZ.getDescription());
        } else {
            this.hEX.setVisibility(0);
            this.hEV.setVisibility(0);
            this.hEW.setVisibility(0);
            this.hEV.setText(this.hEZ.getDescription());
            this.hEW.setText(this.hEZ.cjQ());
            this.hEX.c(this.hEZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.hER.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.hER.startLoad(str, 10, false);
        }
        this.hET.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjF() {
        switch (this.hEZ.cjP()) {
            case 0:
                if (this.hEZ.cjT()) {
                    this.hEY.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hEY.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.hEZ.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hEY.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hEZ.cjU()) {
                    this.hEY.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_nobility_open);
                    this.hEY.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hEY.setBackgroundResource(R.drawable.transparent_bg);
                    this.hEY.setTextSize(0, bhu);
                    this.hEY.setText(R.string.ala_achievement_mark_status_unlock);
                    this.hEY.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.hEZ.cjT()) {
                    this.hEY.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_achievement_unwear_mark);
                    this.hEY.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.hEZ.cjU()) {
                    this.hEY.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_achievement_unwear_mark);
                    this.hEY.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.hEY.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_achievement_unwear_mark);
                    this.hEY.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.hEZ.cjT()) {
                    this.hEY.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_achievement_wear_mark);
                    this.hEY.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.hEZ.cjU()) {
                    this.hEY.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_achievement_wear_mark);
                    this.hEY.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hEY.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_achievement_wear_mark);
                    this.hEY.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.hEZ.cjT()) {
                    this.hEY.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hEY.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.hEZ.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hEY.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hEZ.cjU()) {
                    this.hEY.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hEY.setTextSize(0, hEQ);
                    this.hEY.setText(R.string.ala_nobility_open);
                    this.hEY.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hEY.setBackgroundResource(R.drawable.transparent_bg);
                    this.hEY.setTextSize(0, bhu);
                    this.hEY.setText(R.string.ala_achievement_mark_status_expired);
                    this.hEY.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.hEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hEZ.cjP() == 0 || 3 == a.this.hEZ.cjP()) {
                    if (a.this.hEZ.cjT()) {
                        if (a.this.hEZ.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.hFi != null) {
                                a.this.hFi.fj(a.this.hEZ.price);
                            }
                        } else if (a.this.hFj != null) {
                            a.this.hFj.k(a.this.hEZ.cjM(), a.this.hEZ.propId, false);
                        }
                    } else if (!a.this.hEZ.cjU()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.hEZ.cjL() || 2 != a.this.hEZ.cjP()) {
                    a.this.cjI();
                } else {
                    a.this.cjH();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjG() {
        if (this.hEZ.cjP() == 1 || this.hEZ.cjP() == 2) {
            this.hFf.setVisibility(0);
            this.hFf.setText(this.hEZ.cjS());
            return;
        }
        this.hFf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjH() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.iW(false);
        aVar.ov(R.string.ala_achievement_ops_alert_title);
        aVar.ow(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.hEY.setEnabled(false);
                a.this.cjI();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjI() {
        if (1 == this.hEZ.cjP()) {
            this.hFb.z(false, this.hEZ.cjM());
        } else if (2 == this.hEZ.cjP()) {
            this.hFb.z(true, this.hEZ.cjM());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.hFa = null;
    }

    public void onDestroy() {
        if (this.hFb != null) {
            this.hFb.onDestroy();
        }
    }
}
