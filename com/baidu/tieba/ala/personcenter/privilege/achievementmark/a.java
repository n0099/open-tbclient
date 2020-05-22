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
    private static final int gpm = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TextView gpA;
    private TextView gpB;
    private LinearLayout gpC;
    private TextView gpD;
    private com.baidu.tieba.ala.personcenter.privilege.b gpE;
    private com.baidu.tieba.ala.personcenter.privilege.a gpF;
    private TbImageView gpn;
    private FrameLayout gpo;
    private TextView gpp;
    private RelativeLayout gpq;
    private TextView gpr;
    private TextView gps;
    private MarkLevelGroup gpt;
    private TextView gpu;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b gpv;
    private d gpw;
    private AlaUpdateMarkStatusModel gpx;
    private InterfaceC0585a gpy;
    private LinearLayout gpz;
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
        this.gpy = interfaceC0585a;
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
        this.gpx = new AlaUpdateMarkStatusModel(getContext());
        this.gpx.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.gpu.setEnabled(true);
                if (z) {
                    if (a.this.gpy != null) {
                        a.this.gpy.a(true, a.this.gpv);
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
        this.gpE = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.gpE.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void lA(boolean z) {
                if (z && a.this.gpv.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bIq();
                    a.this.bIr();
                    a.this.bIp();
                }
            }
        });
        this.gpF = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0584a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0584a
            public void m(boolean z, String str) {
                if (z) {
                    if (a.this.gpv != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.gpy != null) {
                            a.this.gpy.a(true, a.this.gpv);
                        }
                        a.this.gpv.rN(2);
                        a.this.bIq();
                        a.this.bIr();
                        a.this.bIp();
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
                if (a.this.gpy != null) {
                    a.this.gpy.a(false, a.this.gpv);
                }
                a.this.dismiss();
            }
        });
        this.gpn = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.gpn.setDefaultBgResource(R.color.transparent);
        this.gpn.setDefaultResource(R.drawable.pic_live_honor);
        this.gpn.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.gpo = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.gpp = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.gpq = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.gpr = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.gps = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.gpt = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.gpt.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void dL(String str, String str2) {
                a.this.dK(str, str2);
            }
        });
        this.gpu = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.gpB = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.gpz = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.gpA = (TextView) findViewById(R.id.mark_tdou_price);
        this.gpC = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.gpD = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIp() {
        this.gpr.setVisibility(4);
        this.gps.setVisibility(4);
        this.gpz.setVisibility(4);
        this.gpt.setVisibility(4);
        this.gpC.setVisibility(8);
        if (this.gpv.bIE()) {
            this.gpz.setVisibility(0);
            this.gpC.setVisibility(0);
            this.gpA.setText(AlaStringHelper.formatLowercasekDou(this.gpv.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.gpD.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.gpD.setCompoundDrawables(drawable, null, null, null);
            this.gpD.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.gpv.bIA() == 1) {
                this.gpC.setVisibility(8);
            }
        } else if (this.gpv.bIF()) {
            this.gpr.setVisibility(0);
            this.gpr.setText(this.gpv.getDescription());
        } else {
            this.gpt.setVisibility(0);
            this.gpr.setVisibility(0);
            this.gps.setVisibility(0);
            this.gpr.setText(this.gpv.getDescription());
            this.gps.setText(this.gpv.bIB());
            this.gpt.c(this.gpv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dK(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.gpn.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.gpn.startLoad(str, 10, false);
        }
        this.gpp.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIq() {
        switch (this.gpv.bIA()) {
            case 0:
                if (this.gpv.bIE()) {
                    this.gpu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gpu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gpv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gpu.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gpv.bIF()) {
                    this.gpu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_nobility_open);
                    this.gpu.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gpu.setBackgroundResource(R.drawable.transparent_bg);
                    this.gpu.setTextSize(0, aPo);
                    this.gpu.setText(R.string.ala_achievement_mark_status_unlock);
                    this.gpu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.gpv.bIE()) {
                    this.gpu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_achievement_unwear_mark);
                    this.gpu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.gpv.bIF()) {
                    this.gpu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_achievement_unwear_mark);
                    this.gpu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.gpu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_achievement_unwear_mark);
                    this.gpu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.gpv.bIE()) {
                    this.gpu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_achievement_wear_mark);
                    this.gpu.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.gpv.bIF()) {
                    this.gpu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_achievement_wear_mark);
                    this.gpu.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gpu.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_achievement_wear_mark);
                    this.gpu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.gpv.bIE()) {
                    this.gpu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gpu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gpv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gpu.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gpv.bIF()) {
                    this.gpu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gpu.setTextSize(0, gpm);
                    this.gpu.setText(R.string.ala_nobility_open);
                    this.gpu.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gpu.setBackgroundResource(R.drawable.transparent_bg);
                    this.gpu.setTextSize(0, aPo);
                    this.gpu.setText(R.string.ala_achievement_mark_status_expired);
                    this.gpu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.gpu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gpv.bIA() == 0 || 3 == a.this.gpv.bIA()) {
                    if (a.this.gpv.bIE()) {
                        if (a.this.gpv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.gpE != null) {
                                a.this.gpE.dN(a.this.gpv.price);
                            }
                        } else if (a.this.gpF != null) {
                            a.this.gpF.l(a.this.gpv.bIx(), a.this.gpv.propId, false);
                        }
                    } else if (!a.this.gpv.bIF()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.gpv.bIw() || 2 != a.this.gpv.bIA()) {
                    a.this.bIt();
                } else {
                    a.this.bIs();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIr() {
        if (this.gpv.bIA() == 1 || this.gpv.bIA() == 2) {
            this.gpB.setVisibility(0);
            this.gpB.setText(this.gpv.bID());
            return;
        }
        this.gpB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIs() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.gX(false);
        aVar.kC(R.string.ala_achievement_ops_alert_title);
        aVar.kD(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.gpu.setEnabled(false);
                a.this.bIt();
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
    public void bIt() {
        if (1 == this.gpv.bIA()) {
            this.gpx.u(false, this.gpv.bIx());
        } else if (2 == this.gpv.bIA()) {
            this.gpx.u(true, this.gpv.bIx());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.gpw = null;
    }

    public void onDestroy() {
        if (this.gpx != null) {
            this.gpx.onDestroy();
        }
    }
}
