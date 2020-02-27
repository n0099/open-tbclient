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
    private static final int fuS = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int fuT = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView fuU;
    private FrameLayout fuV;
    private TextView fuW;
    private RelativeLayout fuX;
    private TextView fuY;
    private TextView fuZ;
    private MarkLevelGroup fva;
    private TextView fvb;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b fvc;
    private d fvd;
    private AlaUpdateMarkStatusModel fve;
    private InterfaceC0478a fvf;
    private LinearLayout fvg;
    private TextView fvh;
    private TextView fvi;
    private LinearLayout fvj;
    private TextView fvk;
    private com.baidu.tieba.ala.personcenter.privilege.b fvl;
    private com.baidu.tieba.ala.personcenter.privilege.a fvm;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0478a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0478a interfaceC0478a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fvf = interfaceC0478a;
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
        dQ();
    }

    private void dQ() {
        this.fve = new AlaUpdateMarkStatusModel(getContext());
        this.fve.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.fvb.setEnabled(true);
                if (z) {
                    if (a.this.fvf != null) {
                        a.this.fvf.a(true, a.this.fvc);
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
        this.fvl = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.fvl.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jX(boolean z) {
                if (z && a.this.fvc.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bsi();
                    a.this.bsj();
                    a.this.bsh();
                }
            }
        });
        this.fvm = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0477a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0477a
            public void l(boolean z, String str) {
                if (z) {
                    if (a.this.fvc != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.fvf != null) {
                            a.this.fvf.a(true, a.this.fvc);
                        }
                        a.this.fvc.qP(2);
                        a.this.bsi();
                        a.this.bsj();
                        a.this.bsh();
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
                if (a.this.fvf != null) {
                    a.this.fvf.a(false, a.this.fvc);
                }
                a.this.dismiss();
            }
        });
        this.fuU = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.fuU.setDefaultBgResource(R.color.transparent);
        this.fuU.setDefaultResource(R.drawable.pic_live_honor);
        this.fuU.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.fuV = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.fuW = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.fuX = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.fuY = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.fuZ = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.fva = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.fva.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void cY(String str, String str2) {
                a.this.cX(str, str2);
            }
        });
        this.fvb = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.fvi = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.fvg = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.fvh = (TextView) findViewById(R.id.mark_tdou_price);
        this.fvj = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.fvk = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsh() {
        this.fuY.setVisibility(4);
        this.fuZ.setVisibility(4);
        this.fvg.setVisibility(4);
        this.fva.setVisibility(4);
        this.fvj.setVisibility(8);
        if (this.fvc.bsv()) {
            this.fvg.setVisibility(0);
            this.fvj.setVisibility(0);
            this.fvh.setText(AlaStringHelper.formatLowercasekDou(this.fvc.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.fvk.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.fvk.setCompoundDrawables(drawable, null, null, null);
            this.fvk.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.fvc.bsr() == 1) {
                this.fvj.setVisibility(8);
            }
        } else if (this.fvc.bsw()) {
            this.fuY.setVisibility(0);
            this.fuY.setText(this.fvc.getDescription());
        } else {
            this.fva.setVisibility(0);
            this.fuY.setVisibility(0);
            this.fuZ.setVisibility(0);
            this.fuY.setText(this.fvc.getDescription());
            this.fuZ.setText(this.fvc.bss());
            this.fva.c(this.fvc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.fuU.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.fuU.startLoad(str, 10, false);
        }
        this.fuW.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsi() {
        switch (this.fvc.bsr()) {
            case 0:
                if (this.fvc.bsv()) {
                    this.fvb.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fvb.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fvc.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fvb.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fvc.bsw()) {
                    this.fvb.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_nobility_open);
                    this.fvb.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvb.setBackgroundResource(R.drawable.transparent_bg);
                    this.fvb.setTextSize(0, fuS);
                    this.fvb.setText(R.string.ala_achievement_mark_status_unlock);
                    this.fvb.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.fvc.bsv()) {
                    this.fvb.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_achievement_unwear_mark);
                    this.fvb.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.fvc.bsw()) {
                    this.fvb.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_achievement_unwear_mark);
                    this.fvb.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.fvb.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_achievement_unwear_mark);
                    this.fvb.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.fvc.bsv()) {
                    this.fvb.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_achievement_wear_mark);
                    this.fvb.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.fvc.bsw()) {
                    this.fvb.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_achievement_wear_mark);
                    this.fvb.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvb.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_achievement_wear_mark);
                    this.fvb.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.fvc.bsv()) {
                    this.fvb.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fvb.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fvc.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fvb.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fvc.bsw()) {
                    this.fvb.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvb.setTextSize(0, fuT);
                    this.fvb.setText(R.string.ala_nobility_open);
                    this.fvb.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvb.setBackgroundResource(R.drawable.transparent_bg);
                    this.fvb.setTextSize(0, fuS);
                    this.fvb.setText(R.string.ala_achievement_mark_status_expired);
                    this.fvb.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.fvb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fvc.bsr() == 0 || 3 == a.this.fvc.bsr()) {
                    if (a.this.fvc.bsv()) {
                        if (a.this.fvc.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.fvl != null) {
                                a.this.fvl.de(a.this.fvc.price);
                            }
                        } else if (a.this.fvm != null) {
                            a.this.fvm.l(a.this.fvc.bso(), a.this.fvc.propId, false);
                        }
                    } else if (!a.this.fvc.bsw()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.fvc.bsn() || 2 != a.this.fvc.bsr()) {
                    a.this.bsk();
                } else {
                    a.this.Ny();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsj() {
        if (this.fvc.bsr() == 1 || this.fvc.bsr() == 2) {
            this.fvi.setVisibility(0);
            this.fvi.setText(this.fvc.bsu());
            return;
        }
        this.fvi.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ny() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.fH(false);
        aVar.jV(R.string.ala_achievement_ops_alert_title);
        aVar.jW(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.fvb.setEnabled(false);
                a.this.bsk();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsk() {
        if (1 == this.fvc.bsr()) {
            this.fve.q(false, this.fvc.bso());
        } else if (2 == this.fvc.bsr()) {
            this.fve.q(true, this.fvc.bso());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.fvd = null;
    }

    public void onDestroy() {
        if (this.fve != null) {
            this.fve.onDestroy();
        }
    }
}
