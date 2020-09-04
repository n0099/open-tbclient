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
    private static final int aYD = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int gUq = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private d gUA;
    private AlaUpdateMarkStatusModel gUB;
    private InterfaceC0653a gUC;
    private LinearLayout gUD;
    private TextView gUE;
    private TextView gUF;
    private LinearLayout gUG;
    private TextView gUH;
    private com.baidu.tieba.ala.personcenter.privilege.b gUI;
    private com.baidu.tieba.ala.personcenter.privilege.a gUJ;
    private TbImageView gUr;
    private FrameLayout gUs;
    private TextView gUt;
    private RelativeLayout gUu;
    private TextView gUv;
    private TextView gUw;
    private MarkLevelGroup gUx;
    private TextView gUy;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b gUz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0653a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0653a interfaceC0653a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gUC = interfaceC0653a;
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
        Hh();
    }

    private void Hh() {
        this.gUB = new AlaUpdateMarkStatusModel(getContext());
        this.gUB.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.gUy.setEnabled(true);
                if (z) {
                    if (a.this.gUC != null) {
                        a.this.gUC.a(true, a.this.gUz);
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
        this.gUI = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.gUI.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void mR(boolean z) {
                if (z && a.this.gUz.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bYH();
                    a.this.bYI();
                    a.this.bYG();
                }
            }
        });
        this.gUJ = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0652a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0652a
            public void p(boolean z, String str) {
                if (z) {
                    if (a.this.gUz != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.gUC != null) {
                            a.this.gUC.a(true, a.this.gUz);
                        }
                        a.this.gUz.uT(2);
                        a.this.bYH();
                        a.this.bYI();
                        a.this.bYG();
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
                if (a.this.gUC != null) {
                    a.this.gUC.a(false, a.this.gUz);
                }
                a.this.dismiss();
            }
        });
        this.gUr = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.gUr.setDefaultBgResource(R.color.transparent);
        this.gUr.setDefaultResource(R.drawable.pic_live_honor);
        this.gUr.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.gUs = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.gUt = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.gUu = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.gUv = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.gUw = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.gUx = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.gUx.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void ek(String str, String str2) {
                a.this.ej(str, str2);
            }
        });
        this.gUy = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.gUF = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.gUD = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.gUE = (TextView) findViewById(R.id.mark_tdou_price);
        this.gUG = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.gUH = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYG() {
        this.gUv.setVisibility(4);
        this.gUw.setVisibility(4);
        this.gUD.setVisibility(4);
        this.gUx.setVisibility(4);
        this.gUG.setVisibility(8);
        if (this.gUz.bYV()) {
            this.gUD.setVisibility(0);
            this.gUG.setVisibility(0);
            this.gUE.setText(AlaStringHelper.formatLowercasekDou(this.gUz.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.gUH.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.gUH.setCompoundDrawables(drawable, null, null, null);
            this.gUH.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.gUz.bYR() == 1) {
                this.gUG.setVisibility(8);
            }
        } else if (this.gUz.bYW()) {
            this.gUv.setVisibility(0);
            this.gUv.setText(this.gUz.getDescription());
        } else {
            this.gUx.setVisibility(0);
            this.gUv.setVisibility(0);
            this.gUw.setVisibility(0);
            this.gUv.setText(this.gUz.getDescription());
            this.gUw.setText(this.gUz.bYS());
            this.gUx.c(this.gUz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.gUr.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.gUr.startLoad(str, 10, false);
        }
        this.gUt.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYH() {
        switch (this.gUz.bYR()) {
            case 0:
                if (this.gUz.bYV()) {
                    this.gUy.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gUy.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gUz.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gUy.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gUz.bYW()) {
                    this.gUy.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_nobility_open);
                    this.gUy.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gUy.setBackgroundResource(R.drawable.transparent_bg);
                    this.gUy.setTextSize(0, aYD);
                    this.gUy.setText(R.string.ala_achievement_mark_status_unlock);
                    this.gUy.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.gUz.bYV()) {
                    this.gUy.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_achievement_unwear_mark);
                    this.gUy.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.gUz.bYW()) {
                    this.gUy.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_achievement_unwear_mark);
                    this.gUy.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.gUy.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_achievement_unwear_mark);
                    this.gUy.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.gUz.bYV()) {
                    this.gUy.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_achievement_wear_mark);
                    this.gUy.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.gUz.bYW()) {
                    this.gUy.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_achievement_wear_mark);
                    this.gUy.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gUy.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_achievement_wear_mark);
                    this.gUy.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.gUz.bYV()) {
                    this.gUy.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gUy.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gUz.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gUy.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gUz.bYW()) {
                    this.gUy.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gUy.setTextSize(0, gUq);
                    this.gUy.setText(R.string.ala_nobility_open);
                    this.gUy.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gUy.setBackgroundResource(R.drawable.transparent_bg);
                    this.gUy.setTextSize(0, aYD);
                    this.gUy.setText(R.string.ala_achievement_mark_status_expired);
                    this.gUy.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.gUy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gUz.bYR() == 0 || 3 == a.this.gUz.bYR()) {
                    if (a.this.gUz.bYV()) {
                        if (a.this.gUz.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.gUI != null) {
                                a.this.gUI.eo(a.this.gUz.price);
                            }
                        } else if (a.this.gUJ != null) {
                            a.this.gUJ.k(a.this.gUz.bYO(), a.this.gUz.propId, false);
                        }
                    } else if (!a.this.gUz.bYW()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.gUz.bYN() || 2 != a.this.gUz.bYR()) {
                    a.this.bYK();
                } else {
                    a.this.bYJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYI() {
        if (this.gUz.bYR() == 1 || this.gUz.bYR() == 2) {
            this.gUF.setVisibility(0);
            this.gUF.setText(this.gUz.bYU());
            return;
        }
        this.gUF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.ih(false);
        aVar.ns(R.string.ala_achievement_ops_alert_title);
        aVar.nt(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.gUy.setEnabled(false);
                a.this.bYK();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYK() {
        if (1 == this.gUz.bYR()) {
            this.gUB.w(false, this.gUz.bYO());
        } else if (2 == this.gUz.bYR()) {
            this.gUB.w(true, this.gUz.bYO());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.gUA = null;
    }

    public void onDestroy() {
        if (this.gUB != null) {
            this.gUB.onDestroy();
        }
    }
}
