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
/* loaded from: classes9.dex */
public class a extends Dialog {
    private static final int blE = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int icm = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TextView icA;
    private TextView icB;
    private LinearLayout icC;
    private TextView icD;
    private com.baidu.tieba.ala.personcenter.privilege.b icE;
    private com.baidu.tieba.ala.personcenter.privilege.a icF;
    private TbImageView icn;
    private FrameLayout ico;
    private TextView icp;
    private RelativeLayout icq;
    private TextView icr;
    private TextView ics;
    private MarkLevelGroup ict;
    private TextView icu;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b icv;
    private d icw;
    private AlaUpdateMarkStatusModel icx;
    private InterfaceC0693a icy;
    private LinearLayout icz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0693a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0693a interfaceC0693a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.icy = interfaceC0693a;
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
        this.icx = new AlaUpdateMarkStatusModel(getContext());
        this.icx.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.icu.setEnabled(true);
                if (z) {
                    if (a.this.icy != null) {
                        a.this.icy.a(true, a.this.icv);
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
        this.icE = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.icE.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oZ(boolean z) {
                if (z && a.this.icv.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.cnf();
                    a.this.cng();
                    a.this.cne();
                }
            }
        });
        this.icF = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0692a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0692a
            public void y(boolean z, String str) {
                if (z) {
                    if (a.this.icv != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.icy != null) {
                            a.this.icy.a(true, a.this.icv);
                        }
                        a.this.icv.wv(2);
                        a.this.cnf();
                        a.this.cng();
                        a.this.cne();
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
                if (a.this.icy != null) {
                    a.this.icy.a(false, a.this.icv);
                }
                a.this.dismiss();
            }
        });
        this.icn = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.icn.setDefaultBgResource(R.color.transparent);
        this.icn.setDefaultResource(R.drawable.pic_live_honor);
        this.ico = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.icp = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.icq = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.icr = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.ics = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.ict = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.ict.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eE(String str, String str2) {
                a.this.eD(str, str2);
            }
        });
        this.icu = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.icB = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.icz = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.icA = (TextView) findViewById(R.id.mark_tdou_price);
        this.icC = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.icD = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cne() {
        this.icr.setVisibility(4);
        this.ics.setVisibility(4);
        this.icz.setVisibility(4);
        this.ict.setVisibility(4);
        this.icC.setVisibility(8);
        if (this.icv.cnt()) {
            this.icz.setVisibility(0);
            this.icC.setVisibility(0);
            this.icA.setText(AlaStringHelper.formatLowercasekDou(this.icv.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.icD.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.icD.setCompoundDrawables(drawable, null, null, null);
            this.icD.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.icv.cnp() == 1) {
                this.icC.setVisibility(8);
            }
        } else if (this.icv.cnu()) {
            this.icr.setVisibility(0);
            this.icr.setText(this.icv.getDescription());
        } else {
            this.ict.setVisibility(0);
            this.icr.setVisibility(0);
            this.ics.setVisibility(0);
            this.icr.setText(this.icv.getDescription());
            this.ics.setText(this.icv.cnq());
            this.ict.c(this.icv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.icn.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.icn.startLoad(str, 10, false);
        }
        this.icp.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnf() {
        switch (this.icv.cnp()) {
            case 0:
                if (this.icv.cnt()) {
                    this.icu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_enter_effect_tdou_buy);
                    this.icu.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.icv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.icu.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.icv.cnu()) {
                    this.icu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_nobility_open);
                    this.icu.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.icu.setBackgroundResource(R.drawable.transparent_bg);
                    this.icu.setTextSize(0, blE);
                    this.icu.setText(R.string.ala_achievement_mark_status_unlock);
                    this.icu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.icv.cnt()) {
                    this.icu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_achievement_unwear_mark);
                    this.icu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.icv.cnu()) {
                    this.icu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_achievement_unwear_mark);
                    this.icu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.icu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_achievement_unwear_mark);
                    this.icu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.icv.cnt()) {
                    this.icu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_achievement_wear_mark);
                    this.icu.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    break;
                } else if (this.icv.cnu()) {
                    this.icu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_achievement_wear_mark);
                    this.icu.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.icu.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_achievement_wear_mark);
                    this.icu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.icv.cnt()) {
                    this.icu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_enter_effect_tdou_buy);
                    this.icu.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.icv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.icu.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.icv.cnu()) {
                    this.icu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.icu.setTextSize(0, icm);
                    this.icu.setText(R.string.ala_nobility_open);
                    this.icu.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.icu.setBackgroundResource(R.drawable.transparent_bg);
                    this.icu.setTextSize(0, blE);
                    this.icu.setText(R.string.ala_achievement_mark_status_expired);
                    this.icu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.icu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.icv.cnp() == 0 || 3 == a.this.icv.cnp()) {
                    if (a.this.icv.cnt()) {
                        if (a.this.icv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.icE != null) {
                                a.this.icE.fT(a.this.icv.price);
                            }
                        } else if (a.this.icF != null) {
                            a.this.icF.l(a.this.icv.cnm(), a.this.icv.propId, false);
                        }
                    } else if (!a.this.icv.cnu()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.icv.cnl() || 2 != a.this.icv.cnp()) {
                    a.this.cni();
                } else {
                    a.this.cnh();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cng() {
        if (this.icv.cnp() == 1 || this.icv.cnp() == 2) {
            this.icB.setVisibility(0);
            this.icB.setText(this.icv.cns());
            return;
        }
        this.icB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.jG(false);
        aVar.nx(R.string.ala_achievement_ops_alert_title);
        aVar.ny(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.icu.setEnabled(false);
                a.this.cni();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cni() {
        if (1 == this.icv.cnp()) {
            this.icx.y(false, this.icv.cnm());
        } else if (2 == this.icv.cnp()) {
            this.icx.y(true, this.icv.cnm());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.icw = null;
    }

    public void onDestroy() {
        if (this.icx != null) {
            this.icx.onDestroy();
        }
    }
}
