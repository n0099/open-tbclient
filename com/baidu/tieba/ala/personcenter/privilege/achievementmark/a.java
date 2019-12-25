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
/* loaded from: classes2.dex */
public class a extends Dialog {
    private static final int fpg = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int fph = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private com.baidu.tieba.ala.personcenter.privilege.b fpA;
    private com.baidu.tieba.ala.personcenter.privilege.a fpB;
    private TbImageView fpi;
    private FrameLayout fpj;
    private TextView fpk;
    private RelativeLayout fpl;
    private TextView fpm;
    private TextView fpn;
    private MarkLevelGroup fpo;
    private TextView fpp;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b fpq;
    private d fpr;
    private AlaUpdateMarkStatusModel fpt;
    private InterfaceC0466a fpu;
    private LinearLayout fpv;
    private TextView fpw;
    private TextView fpx;
    private LinearLayout fpy;
    private TextView fpz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0466a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0466a interfaceC0466a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fpu = interfaceC0466a;
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
        dP();
    }

    private void dP() {
        this.fpt = new AlaUpdateMarkStatusModel(getContext());
        this.fpt.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.fpp.setEnabled(true);
                if (z) {
                    if (a.this.fpu != null) {
                        a.this.fpu.a(true, a.this.fpq);
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
        this.fpA = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.fpA.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jK(boolean z) {
                if (z && a.this.fpq.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bpD();
                    a.this.bpE();
                    a.this.bpC();
                }
            }
        });
        this.fpB = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0465a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0465a
            public void k(boolean z, String str) {
                if (z) {
                    if (a.this.fpq != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.fpu != null) {
                            a.this.fpu.a(true, a.this.fpq);
                        }
                        a.this.fpq.qD(2);
                        a.this.bpD();
                        a.this.bpE();
                        a.this.bpC();
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
                if (a.this.fpu != null) {
                    a.this.fpu.a(false, a.this.fpq);
                }
                a.this.dismiss();
            }
        });
        this.fpi = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.fpi.setDefaultBgResource(R.color.transparent);
        this.fpi.setDefaultResource(R.drawable.pic_live_honor);
        this.fpi.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.fpj = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.fpk = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.fpl = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.fpm = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.fpn = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.fpo = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.fpo.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void cO(String str, String str2) {
                a.this.cN(str, str2);
            }
        });
        this.fpp = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.fpx = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.fpv = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.fpw = (TextView) findViewById(R.id.mark_tdou_price);
        this.fpy = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.fpz = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpC() {
        this.fpm.setVisibility(4);
        this.fpn.setVisibility(4);
        this.fpv.setVisibility(4);
        this.fpo.setVisibility(4);
        this.fpy.setVisibility(8);
        if (this.fpq.bpQ()) {
            this.fpv.setVisibility(0);
            this.fpy.setVisibility(0);
            this.fpw.setText(AlaStringHelper.formatLowercasekDou(this.fpq.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.fpz.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.fpz.setCompoundDrawables(drawable, null, null, null);
            this.fpz.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.fpq.bpM() == 1) {
                this.fpy.setVisibility(8);
            }
        } else if (this.fpq.bpR()) {
            this.fpm.setVisibility(0);
            this.fpm.setText(this.fpq.getDescription());
        } else {
            this.fpo.setVisibility(0);
            this.fpm.setVisibility(0);
            this.fpn.setVisibility(0);
            this.fpm.setText(this.fpq.getDescription());
            this.fpn.setText(this.fpq.bpN());
            this.fpo.c(this.fpq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.fpi.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.fpi.startLoad(str, 10, false);
        }
        this.fpk.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpD() {
        switch (this.fpq.bpM()) {
            case 0:
                if (this.fpq.bpQ()) {
                    this.fpp.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fpp.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fpq.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fpp.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fpq.bpR()) {
                    this.fpp.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_nobility_open);
                    this.fpp.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fpp.setBackgroundResource(R.drawable.transparent_bg);
                    this.fpp.setTextSize(0, fpg);
                    this.fpp.setText(R.string.ala_achievement_mark_status_unlock);
                    this.fpp.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.fpq.bpQ()) {
                    this.fpp.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_achievement_unwear_mark);
                    this.fpp.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.fpq.bpR()) {
                    this.fpp.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_achievement_unwear_mark);
                    this.fpp.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.fpp.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_achievement_unwear_mark);
                    this.fpp.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.fpq.bpQ()) {
                    this.fpp.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_achievement_wear_mark);
                    this.fpp.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.fpq.bpR()) {
                    this.fpp.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_achievement_wear_mark);
                    this.fpp.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fpp.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_achievement_wear_mark);
                    this.fpp.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.fpq.bpQ()) {
                    this.fpp.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fpp.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fpq.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fpp.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fpq.bpR()) {
                    this.fpp.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fpp.setTextSize(0, fph);
                    this.fpp.setText(R.string.ala_nobility_open);
                    this.fpp.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fpp.setBackgroundResource(R.drawable.transparent_bg);
                    this.fpp.setTextSize(0, fpg);
                    this.fpp.setText(R.string.ala_achievement_mark_status_expired);
                    this.fpp.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.fpp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fpq.bpM() == 0 || 3 == a.this.fpq.bpM()) {
                    if (a.this.fpq.bpQ()) {
                        if (a.this.fpq.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.fpA != null) {
                                a.this.fpA.cX(a.this.fpq.price);
                            }
                        } else if (a.this.fpB != null) {
                            a.this.fpB.l(a.this.fpq.bpJ(), a.this.fpq.propId, false);
                        }
                    } else if (!a.this.fpq.bpR()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.fpq.bpI() || 2 != a.this.fpq.bpM()) {
                    a.this.bpF();
                } else {
                    a.this.KO();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpE() {
        if (this.fpq.bpM() == 1 || this.fpq.bpM() == 2) {
            this.fpx.setVisibility(0);
            this.fpx.setText(this.fpq.bpP());
            return;
        }
        this.fpx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KO() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.fv(false);
        aVar.jE(R.string.ala_achievement_ops_alert_title);
        aVar.jF(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.fpp.setEnabled(false);
                a.this.bpF();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpF() {
        if (1 == this.fpq.bpM()) {
            this.fpt.o(false, this.fpq.bpJ());
        } else if (2 == this.fpq.bpM()) {
            this.fpt.o(true, this.fpq.bpJ());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.fpr = null;
    }

    public void onDestroy() {
        if (this.fpt != null) {
            this.fpt.onDestroy();
        }
    }
}
