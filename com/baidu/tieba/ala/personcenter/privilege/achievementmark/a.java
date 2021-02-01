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
    private static final int iap = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private AlaUpdateMarkStatusModel iaA;
    private InterfaceC0686a iaB;
    private LinearLayout iaC;
    private TextView iaD;
    private TextView iaE;
    private LinearLayout iaF;
    private TextView iaG;
    private com.baidu.tieba.ala.personcenter.privilege.b iaH;
    private com.baidu.tieba.ala.personcenter.privilege.a iaI;
    private TbImageView iaq;
    private FrameLayout iar;
    private TextView ias;
    private RelativeLayout iat;
    private TextView iau;
    private TextView iav;
    private MarkLevelGroup iaw;
    private TextView iax;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b iay;
    private d iaz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0686a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0686a interfaceC0686a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.iaB = interfaceC0686a;
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
        this.iaA = new AlaUpdateMarkStatusModel(getContext());
        this.iaA.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.iax.setEnabled(true);
                if (z) {
                    if (a.this.iaB != null) {
                        a.this.iaB.a(true, a.this.iay);
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
        this.iaH = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.iaH.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oZ(boolean z) {
                if (z && a.this.iay.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.cmS();
                    a.this.cmT();
                    a.this.cmR();
                }
            }
        });
        this.iaI = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0685a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0685a
            public void y(boolean z, String str) {
                if (z) {
                    if (a.this.iay != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.iaB != null) {
                            a.this.iaB.a(true, a.this.iay);
                        }
                        a.this.iay.wu(2);
                        a.this.cmS();
                        a.this.cmT();
                        a.this.cmR();
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
                if (a.this.iaB != null) {
                    a.this.iaB.a(false, a.this.iay);
                }
                a.this.dismiss();
            }
        });
        this.iaq = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.iaq.setDefaultBgResource(R.color.transparent);
        this.iaq.setDefaultResource(R.drawable.pic_live_honor);
        this.iar = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.ias = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.iat = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.iau = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.iav = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.iaw = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.iaw.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eE(String str, String str2) {
                a.this.eD(str, str2);
            }
        });
        this.iax = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.iaE = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.iaC = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.iaD = (TextView) findViewById(R.id.mark_tdou_price);
        this.iaF = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.iaG = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmR() {
        this.iau.setVisibility(4);
        this.iav.setVisibility(4);
        this.iaC.setVisibility(4);
        this.iaw.setVisibility(4);
        this.iaF.setVisibility(8);
        if (this.iay.cng()) {
            this.iaC.setVisibility(0);
            this.iaF.setVisibility(0);
            this.iaD.setText(AlaStringHelper.formatLowercasekDou(this.iay.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.iaG.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.iaG.setCompoundDrawables(drawable, null, null, null);
            this.iaG.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.iay.cnc() == 1) {
                this.iaF.setVisibility(8);
            }
        } else if (this.iay.cnh()) {
            this.iau.setVisibility(0);
            this.iau.setText(this.iay.getDescription());
        } else {
            this.iaw.setVisibility(0);
            this.iau.setVisibility(0);
            this.iav.setVisibility(0);
            this.iau.setText(this.iay.getDescription());
            this.iav.setText(this.iay.cnd());
            this.iaw.c(this.iay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.iaq.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.iaq.startLoad(str, 10, false);
        }
        this.ias.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmS() {
        switch (this.iay.cnc()) {
            case 0:
                if (this.iay.cng()) {
                    this.iax.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_enter_effect_tdou_buy);
                    this.iax.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.iay.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.iax.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.iay.cnh()) {
                    this.iax.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_nobility_open);
                    this.iax.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iax.setBackgroundResource(R.drawable.transparent_bg);
                    this.iax.setTextSize(0, bke);
                    this.iax.setText(R.string.ala_achievement_mark_status_unlock);
                    this.iax.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.iay.cng()) {
                    this.iax.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_achievement_unwear_mark);
                    this.iax.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.iay.cnh()) {
                    this.iax.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_achievement_unwear_mark);
                    this.iax.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.iax.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_achievement_unwear_mark);
                    this.iax.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.iay.cng()) {
                    this.iax.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_achievement_wear_mark);
                    this.iax.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    break;
                } else if (this.iay.cnh()) {
                    this.iax.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_achievement_wear_mark);
                    this.iax.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iax.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_achievement_wear_mark);
                    this.iax.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.iay.cng()) {
                    this.iax.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_enter_effect_tdou_buy);
                    this.iax.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.iay.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.iax.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.iay.cnh()) {
                    this.iax.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.iax.setTextSize(0, iap);
                    this.iax.setText(R.string.ala_nobility_open);
                    this.iax.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.iax.setBackgroundResource(R.drawable.transparent_bg);
                    this.iax.setTextSize(0, bke);
                    this.iax.setText(R.string.ala_achievement_mark_status_expired);
                    this.iax.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.iax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iay.cnc() == 0 || 3 == a.this.iay.cnc()) {
                    if (a.this.iay.cng()) {
                        if (a.this.iay.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.iaH != null) {
                                a.this.iaH.fT(a.this.iay.price);
                            }
                        } else if (a.this.iaI != null) {
                            a.this.iaI.l(a.this.iay.cmZ(), a.this.iay.propId, false);
                        }
                    } else if (!a.this.iay.cnh()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.iay.cmY() || 2 != a.this.iay.cnc()) {
                    a.this.cmV();
                } else {
                    a.this.cmU();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmT() {
        if (this.iay.cnc() == 1 || this.iay.cnc() == 2) {
            this.iaE.setVisibility(0);
            this.iaE.setText(this.iay.cnf());
            return;
        }
        this.iaE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.jG(false);
        aVar.nw(R.string.ala_achievement_ops_alert_title);
        aVar.nx(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.iax.setEnabled(false);
                a.this.cmV();
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
    public void cmV() {
        if (1 == this.iay.cnc()) {
            this.iaA.y(false, this.iay.cmZ());
        } else if (2 == this.iay.cnc()) {
            this.iaA.y(true, this.iay.cmZ());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.iaz = null;
    }

    public void onDestroy() {
        if (this.iaA != null) {
            this.iaA.onDestroy();
        }
    }
}
