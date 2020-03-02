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
    private static final int fuT = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int fuU = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView fuV;
    private FrameLayout fuW;
    private TextView fuX;
    private RelativeLayout fuY;
    private TextView fuZ;
    private TextView fva;
    private MarkLevelGroup fvb;
    private TextView fvc;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b fvd;
    private d fve;
    private AlaUpdateMarkStatusModel fvf;
    private InterfaceC0478a fvg;
    private LinearLayout fvh;
    private TextView fvi;
    private TextView fvj;
    private LinearLayout fvk;
    private TextView fvl;
    private com.baidu.tieba.ala.personcenter.privilege.b fvm;
    private com.baidu.tieba.ala.personcenter.privilege.a fvn;
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
        this.fvg = interfaceC0478a;
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
        this.fvf = new AlaUpdateMarkStatusModel(getContext());
        this.fvf.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.fvc.setEnabled(true);
                if (z) {
                    if (a.this.fvg != null) {
                        a.this.fvg.a(true, a.this.fvd);
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
        this.fvm = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.fvm.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jX(boolean z) {
                if (z && a.this.fvd.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bsk();
                    a.this.bsl();
                    a.this.bsj();
                }
            }
        });
        this.fvn = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0477a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0477a
            public void l(boolean z, String str) {
                if (z) {
                    if (a.this.fvd != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.fvg != null) {
                            a.this.fvg.a(true, a.this.fvd);
                        }
                        a.this.fvd.qP(2);
                        a.this.bsk();
                        a.this.bsl();
                        a.this.bsj();
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
                if (a.this.fvg != null) {
                    a.this.fvg.a(false, a.this.fvd);
                }
                a.this.dismiss();
            }
        });
        this.fuV = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.fuV.setDefaultBgResource(R.color.transparent);
        this.fuV.setDefaultResource(R.drawable.pic_live_honor);
        this.fuV.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.fuW = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.fuX = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.fuY = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.fuZ = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.fva = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.fvb = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.fvb.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void cY(String str, String str2) {
                a.this.cX(str, str2);
            }
        });
        this.fvc = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.fvj = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.fvh = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.fvi = (TextView) findViewById(R.id.mark_tdou_price);
        this.fvk = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.fvl = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsj() {
        this.fuZ.setVisibility(4);
        this.fva.setVisibility(4);
        this.fvh.setVisibility(4);
        this.fvb.setVisibility(4);
        this.fvk.setVisibility(8);
        if (this.fvd.bsx()) {
            this.fvh.setVisibility(0);
            this.fvk.setVisibility(0);
            this.fvi.setText(AlaStringHelper.formatLowercasekDou(this.fvd.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.fvl.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.fvl.setCompoundDrawables(drawable, null, null, null);
            this.fvl.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.fvd.bst() == 1) {
                this.fvk.setVisibility(8);
            }
        } else if (this.fvd.bsy()) {
            this.fuZ.setVisibility(0);
            this.fuZ.setText(this.fvd.getDescription());
        } else {
            this.fvb.setVisibility(0);
            this.fuZ.setVisibility(0);
            this.fva.setVisibility(0);
            this.fuZ.setText(this.fvd.getDescription());
            this.fva.setText(this.fvd.bsu());
            this.fvb.c(this.fvd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.fuV.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.fuV.startLoad(str, 10, false);
        }
        this.fuX.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsk() {
        switch (this.fvd.bst()) {
            case 0:
                if (this.fvd.bsx()) {
                    this.fvc.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fvc.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fvd.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fvc.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fvd.bsy()) {
                    this.fvc.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_nobility_open);
                    this.fvc.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvc.setBackgroundResource(R.drawable.transparent_bg);
                    this.fvc.setTextSize(0, fuT);
                    this.fvc.setText(R.string.ala_achievement_mark_status_unlock);
                    this.fvc.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.fvd.bsx()) {
                    this.fvc.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_achievement_unwear_mark);
                    this.fvc.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.fvd.bsy()) {
                    this.fvc.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_achievement_unwear_mark);
                    this.fvc.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.fvc.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_achievement_unwear_mark);
                    this.fvc.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.fvd.bsx()) {
                    this.fvc.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_achievement_wear_mark);
                    this.fvc.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.fvd.bsy()) {
                    this.fvc.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_achievement_wear_mark);
                    this.fvc.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvc.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_achievement_wear_mark);
                    this.fvc.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.fvd.bsx()) {
                    this.fvc.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fvc.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fvd.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fvc.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fvd.bsy()) {
                    this.fvc.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvc.setTextSize(0, fuU);
                    this.fvc.setText(R.string.ala_nobility_open);
                    this.fvc.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvc.setBackgroundResource(R.drawable.transparent_bg);
                    this.fvc.setTextSize(0, fuT);
                    this.fvc.setText(R.string.ala_achievement_mark_status_expired);
                    this.fvc.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.fvc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fvd.bst() == 0 || 3 == a.this.fvd.bst()) {
                    if (a.this.fvd.bsx()) {
                        if (a.this.fvd.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.fvm != null) {
                                a.this.fvm.de(a.this.fvd.price);
                            }
                        } else if (a.this.fvn != null) {
                            a.this.fvn.l(a.this.fvd.bsq(), a.this.fvd.propId, false);
                        }
                    } else if (!a.this.fvd.bsy()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.fvd.bsp() || 2 != a.this.fvd.bst()) {
                    a.this.bsm();
                } else {
                    a.this.NA();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsl() {
        if (this.fvd.bst() == 1 || this.fvd.bst() == 2) {
            this.fvj.setVisibility(0);
            this.fvj.setText(this.fvd.bsw());
            return;
        }
        this.fvj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.fH(false);
        aVar.jV(R.string.ala_achievement_ops_alert_title);
        aVar.jW(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.fvc.setEnabled(false);
                a.this.bsm();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsm() {
        if (1 == this.fvd.bst()) {
            this.fvf.q(false, this.fvd.bsq());
        } else if (2 == this.fvd.bst()) {
            this.fvf.q(true, this.fvd.bsq());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.fve = null;
    }

    public void onDestroy() {
        if (this.fvf != null) {
            this.fvf.onDestroy();
        }
    }
}
