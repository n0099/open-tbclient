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
    private static final int aYB = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int gUm = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TextView gUA;
    private TextView gUB;
    private LinearLayout gUC;
    private TextView gUD;
    private com.baidu.tieba.ala.personcenter.privilege.b gUE;
    private com.baidu.tieba.ala.personcenter.privilege.a gUF;
    private TbImageView gUn;
    private FrameLayout gUo;
    private TextView gUp;
    private RelativeLayout gUq;
    private TextView gUr;
    private TextView gUs;
    private MarkLevelGroup gUt;
    private TextView gUu;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b gUv;
    private d gUw;
    private AlaUpdateMarkStatusModel gUx;
    private InterfaceC0653a gUy;
    private LinearLayout gUz;
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
        this.gUy = interfaceC0653a;
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
        this.gUx = new AlaUpdateMarkStatusModel(getContext());
        this.gUx.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.gUu.setEnabled(true);
                if (z) {
                    if (a.this.gUy != null) {
                        a.this.gUy.a(true, a.this.gUv);
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
        this.gUE = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.gUE.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void mP(boolean z) {
                if (z && a.this.gUv.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bYG();
                    a.this.bYH();
                    a.this.bYF();
                }
            }
        });
        this.gUF = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0652a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0652a
            public void p(boolean z, String str) {
                if (z) {
                    if (a.this.gUv != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.gUy != null) {
                            a.this.gUy.a(true, a.this.gUv);
                        }
                        a.this.gUv.uT(2);
                        a.this.bYG();
                        a.this.bYH();
                        a.this.bYF();
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
                if (a.this.gUy != null) {
                    a.this.gUy.a(false, a.this.gUv);
                }
                a.this.dismiss();
            }
        });
        this.gUn = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.gUn.setDefaultBgResource(R.color.transparent);
        this.gUn.setDefaultResource(R.drawable.pic_live_honor);
        this.gUn.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.gUo = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.gUp = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.gUq = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.gUr = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.gUs = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.gUt = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.gUt.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void ej(String str, String str2) {
                a.this.ei(str, str2);
            }
        });
        this.gUu = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.gUB = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.gUz = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.gUA = (TextView) findViewById(R.id.mark_tdou_price);
        this.gUC = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.gUD = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYF() {
        this.gUr.setVisibility(4);
        this.gUs.setVisibility(4);
        this.gUz.setVisibility(4);
        this.gUt.setVisibility(4);
        this.gUC.setVisibility(8);
        if (this.gUv.bYU()) {
            this.gUz.setVisibility(0);
            this.gUC.setVisibility(0);
            this.gUA.setText(AlaStringHelper.formatLowercasekDou(this.gUv.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.gUD.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.gUD.setCompoundDrawables(drawable, null, null, null);
            this.gUD.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.gUv.bYQ() == 1) {
                this.gUC.setVisibility(8);
            }
        } else if (this.gUv.bYV()) {
            this.gUr.setVisibility(0);
            this.gUr.setText(this.gUv.getDescription());
        } else {
            this.gUt.setVisibility(0);
            this.gUr.setVisibility(0);
            this.gUs.setVisibility(0);
            this.gUr.setText(this.gUv.getDescription());
            this.gUs.setText(this.gUv.bYR());
            this.gUt.c(this.gUv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.gUn.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.gUn.startLoad(str, 10, false);
        }
        this.gUp.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYG() {
        switch (this.gUv.bYQ()) {
            case 0:
                if (this.gUv.bYU()) {
                    this.gUu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gUu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gUv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gUu.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gUv.bYV()) {
                    this.gUu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_nobility_open);
                    this.gUu.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gUu.setBackgroundResource(R.drawable.transparent_bg);
                    this.gUu.setTextSize(0, aYB);
                    this.gUu.setText(R.string.ala_achievement_mark_status_unlock);
                    this.gUu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.gUv.bYU()) {
                    this.gUu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_achievement_unwear_mark);
                    this.gUu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.gUv.bYV()) {
                    this.gUu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_achievement_unwear_mark);
                    this.gUu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.gUu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_achievement_unwear_mark);
                    this.gUu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.gUv.bYU()) {
                    this.gUu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_achievement_wear_mark);
                    this.gUu.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.gUv.bYV()) {
                    this.gUu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_achievement_wear_mark);
                    this.gUu.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gUu.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_achievement_wear_mark);
                    this.gUu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.gUv.bYU()) {
                    this.gUu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gUu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gUv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gUu.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gUv.bYV()) {
                    this.gUu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gUu.setTextSize(0, gUm);
                    this.gUu.setText(R.string.ala_nobility_open);
                    this.gUu.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gUu.setBackgroundResource(R.drawable.transparent_bg);
                    this.gUu.setTextSize(0, aYB);
                    this.gUu.setText(R.string.ala_achievement_mark_status_expired);
                    this.gUu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.gUu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gUv.bYQ() == 0 || 3 == a.this.gUv.bYQ()) {
                    if (a.this.gUv.bYU()) {
                        if (a.this.gUv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.gUE != null) {
                                a.this.gUE.eo(a.this.gUv.price);
                            }
                        } else if (a.this.gUF != null) {
                            a.this.gUF.k(a.this.gUv.bYN(), a.this.gUv.propId, false);
                        }
                    } else if (!a.this.gUv.bYV()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.gUv.bYM() || 2 != a.this.gUv.bYQ()) {
                    a.this.bYJ();
                } else {
                    a.this.bYI();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYH() {
        if (this.gUv.bYQ() == 1 || this.gUv.bYQ() == 2) {
            this.gUB.setVisibility(0);
            this.gUB.setText(this.gUv.bYT());
            return;
        }
        this.gUB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.ig(false);
        aVar.ns(R.string.ala_achievement_ops_alert_title);
        aVar.nt(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.gUu.setEnabled(false);
                a.this.bYJ();
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
    public void bYJ() {
        if (1 == this.gUv.bYQ()) {
            this.gUx.w(false, this.gUv.bYN());
        } else if (2 == this.gUv.bYQ()) {
            this.gUx.w(true, this.gUv.bYN());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.gUw = null;
    }

    public void onDestroy() {
        if (this.gUx != null) {
            this.gUx.onDestroy();
        }
    }
}
