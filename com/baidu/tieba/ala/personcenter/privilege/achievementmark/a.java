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
    private static final int aJz = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int gan = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private LinearLayout gaA;
    private TextView gaB;
    private TextView gaC;
    private LinearLayout gaD;
    private TextView gaE;
    private com.baidu.tieba.ala.personcenter.privilege.b gaF;
    private com.baidu.tieba.ala.personcenter.privilege.a gaG;
    private TbImageView gao;
    private FrameLayout gap;
    private TextView gaq;
    private RelativeLayout gar;
    private TextView gas;
    private TextView gat;
    private MarkLevelGroup gau;
    private TextView gav;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b gaw;
    private d gax;
    private AlaUpdateMarkStatusModel gay;
    private InterfaceC0514a gaz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0514a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0514a interfaceC0514a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gaz = interfaceC0514a;
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
        zq();
    }

    private void zq() {
        this.gay = new AlaUpdateMarkStatusModel(getContext());
        this.gay.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.gav.setEnabled(true);
                if (z) {
                    if (a.this.gaz != null) {
                        a.this.gaz.a(true, a.this.gaw);
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
        this.gaF = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.gaF.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void le(boolean z) {
                if (z && a.this.gaw.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bBZ();
                    a.this.bCa();
                    a.this.bBY();
                }
            }
        });
        this.gaG = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0513a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0513a
            public void m(boolean z, String str) {
                if (z) {
                    if (a.this.gaw != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.gaz != null) {
                            a.this.gaz.a(true, a.this.gaw);
                        }
                        a.this.gaw.rk(2);
                        a.this.bBZ();
                        a.this.bCa();
                        a.this.bBY();
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
                if (a.this.gaz != null) {
                    a.this.gaz.a(false, a.this.gaw);
                }
                a.this.dismiss();
            }
        });
        this.gao = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.gao.setDefaultBgResource(R.color.transparent);
        this.gao.setDefaultResource(R.drawable.pic_live_honor);
        this.gao.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.gap = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.gaq = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.gar = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.gas = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.gat = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.gau = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.gau.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void dl(String str, String str2) {
                a.this.dk(str, str2);
            }
        });
        this.gav = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.gaC = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.gaA = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.gaB = (TextView) findViewById(R.id.mark_tdou_price);
        this.gaD = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.gaE = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBY() {
        this.gas.setVisibility(4);
        this.gat.setVisibility(4);
        this.gaA.setVisibility(4);
        this.gau.setVisibility(4);
        this.gaD.setVisibility(8);
        if (this.gaw.bCm()) {
            this.gaA.setVisibility(0);
            this.gaD.setVisibility(0);
            this.gaB.setText(AlaStringHelper.formatLowercasekDou(this.gaw.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.gaE.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.gaE.setCompoundDrawables(drawable, null, null, null);
            this.gaE.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.gaw.bCi() == 1) {
                this.gaD.setVisibility(8);
            }
        } else if (this.gaw.bCn()) {
            this.gas.setVisibility(0);
            this.gas.setText(this.gaw.getDescription());
        } else {
            this.gau.setVisibility(0);
            this.gas.setVisibility(0);
            this.gat.setVisibility(0);
            this.gas.setText(this.gaw.getDescription());
            this.gat.setText(this.gaw.bCj());
            this.gau.c(this.gaw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.gao.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.gao.startLoad(str, 10, false);
        }
        this.gaq.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBZ() {
        switch (this.gaw.bCi()) {
            case 0:
                if (this.gaw.bCm()) {
                    this.gav.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gav.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gaw.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gav.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gaw.bCn()) {
                    this.gav.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_nobility_open);
                    this.gav.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gav.setBackgroundResource(R.drawable.transparent_bg);
                    this.gav.setTextSize(0, aJz);
                    this.gav.setText(R.string.ala_achievement_mark_status_unlock);
                    this.gav.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.gaw.bCm()) {
                    this.gav.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_achievement_unwear_mark);
                    this.gav.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.gaw.bCn()) {
                    this.gav.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_achievement_unwear_mark);
                    this.gav.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.gav.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_achievement_unwear_mark);
                    this.gav.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.gaw.bCm()) {
                    this.gav.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_achievement_wear_mark);
                    this.gav.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.gaw.bCn()) {
                    this.gav.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_achievement_wear_mark);
                    this.gav.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gav.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_achievement_wear_mark);
                    this.gav.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.gaw.bCm()) {
                    this.gav.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gav.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gaw.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gav.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gaw.bCn()) {
                    this.gav.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gav.setTextSize(0, gan);
                    this.gav.setText(R.string.ala_nobility_open);
                    this.gav.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gav.setBackgroundResource(R.drawable.transparent_bg);
                    this.gav.setTextSize(0, aJz);
                    this.gav.setText(R.string.ala_achievement_mark_status_expired);
                    this.gav.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.gav.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gaw.bCi() == 0 || 3 == a.this.gaw.bCi()) {
                    if (a.this.gaw.bCm()) {
                        if (a.this.gaw.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.gaF != null) {
                                a.this.gaF.dM(a.this.gaw.price);
                            }
                        } else if (a.this.gaG != null) {
                            a.this.gaG.l(a.this.gaw.bCf(), a.this.gaw.propId, false);
                        }
                    } else if (!a.this.gaw.bCn()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.gaw.bCe() || 2 != a.this.gaw.bCi()) {
                    a.this.bCb();
                } else {
                    a.this.Vq();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCa() {
        if (this.gaw.bCi() == 1 || this.gaw.bCi() == 2) {
            this.gaC.setVisibility(0);
            this.gaC.setText(this.gaw.bCl());
            return;
        }
        this.gaC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.gF(false);
        aVar.kc(R.string.ala_achievement_ops_alert_title);
        aVar.kd(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.gav.setEnabled(false);
                a.this.bCb();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCb() {
        if (1 == this.gaw.bCi()) {
            this.gay.r(false, this.gaw.bCf());
        } else if (2 == this.gaw.bCi()) {
            this.gay.r(true, this.gaw.bCf());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.gax = null;
    }

    public void onDestroy() {
        if (this.gay != null) {
            this.gay.onDestroy();
        }
    }
}
