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
    private static final int fvM = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int fvN = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView fvO;
    private FrameLayout fvP;
    private TextView fvQ;
    private RelativeLayout fvR;
    private TextView fvS;
    private TextView fvT;
    private MarkLevelGroup fvU;
    private TextView fvV;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b fvW;
    private d fvX;
    private AlaUpdateMarkStatusModel fvY;
    private InterfaceC0478a fvZ;
    private LinearLayout fwa;
    private TextView fwb;
    private TextView fwc;
    private LinearLayout fwd;
    private TextView fwe;
    private com.baidu.tieba.ala.personcenter.privilege.b fwf;
    private com.baidu.tieba.ala.personcenter.privilege.a fwg;
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
        this.fvZ = interfaceC0478a;
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
        this.fvY = new AlaUpdateMarkStatusModel(getContext());
        this.fvY.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.fvV.setEnabled(true);
                if (z) {
                    if (a.this.fvZ != null) {
                        a.this.fvZ.a(true, a.this.fvW);
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
        this.fwf = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.fwf.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void ka(boolean z) {
                if (z && a.this.fvW.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bsr();
                    a.this.bss();
                    a.this.bsq();
                }
            }
        });
        this.fwg = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0477a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0477a
            public void l(boolean z, String str) {
                if (z) {
                    if (a.this.fvW != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.fvZ != null) {
                            a.this.fvZ.a(true, a.this.fvW);
                        }
                        a.this.fvW.qR(2);
                        a.this.bsr();
                        a.this.bss();
                        a.this.bsq();
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
                if (a.this.fvZ != null) {
                    a.this.fvZ.a(false, a.this.fvW);
                }
                a.this.dismiss();
            }
        });
        this.fvO = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.fvO.setDefaultBgResource(R.color.transparent);
        this.fvO.setDefaultResource(R.drawable.pic_live_honor);
        this.fvO.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.fvP = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.fvQ = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.fvR = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.fvS = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.fvT = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.fvU = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.fvU.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void cX(String str, String str2) {
                a.this.cW(str, str2);
            }
        });
        this.fvV = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.fwc = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.fwa = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.fwb = (TextView) findViewById(R.id.mark_tdou_price);
        this.fwd = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.fwe = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsq() {
        this.fvS.setVisibility(4);
        this.fvT.setVisibility(4);
        this.fwa.setVisibility(4);
        this.fvU.setVisibility(4);
        this.fwd.setVisibility(8);
        if (this.fvW.bsE()) {
            this.fwa.setVisibility(0);
            this.fwd.setVisibility(0);
            this.fwb.setText(AlaStringHelper.formatLowercasekDou(this.fvW.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.fwe.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.fwe.setCompoundDrawables(drawable, null, null, null);
            this.fwe.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.fvW.bsA() == 1) {
                this.fwd.setVisibility(8);
            }
        } else if (this.fvW.bsF()) {
            this.fvS.setVisibility(0);
            this.fvS.setText(this.fvW.getDescription());
        } else {
            this.fvU.setVisibility(0);
            this.fvS.setVisibility(0);
            this.fvT.setVisibility(0);
            this.fvS.setText(this.fvW.getDescription());
            this.fvT.setText(this.fvW.bsB());
            this.fvU.c(this.fvW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.fvO.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.fvO.startLoad(str, 10, false);
        }
        this.fvQ.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsr() {
        switch (this.fvW.bsA()) {
            case 0:
                if (this.fvW.bsE()) {
                    this.fvV.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fvV.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fvW.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fvV.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fvW.bsF()) {
                    this.fvV.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_nobility_open);
                    this.fvV.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvV.setBackgroundResource(R.drawable.transparent_bg);
                    this.fvV.setTextSize(0, fvM);
                    this.fvV.setText(R.string.ala_achievement_mark_status_unlock);
                    this.fvV.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.fvW.bsE()) {
                    this.fvV.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_achievement_unwear_mark);
                    this.fvV.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.fvW.bsF()) {
                    this.fvV.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_achievement_unwear_mark);
                    this.fvV.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.fvV.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_achievement_unwear_mark);
                    this.fvV.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.fvW.bsE()) {
                    this.fvV.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_achievement_wear_mark);
                    this.fvV.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.fvW.bsF()) {
                    this.fvV.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_achievement_wear_mark);
                    this.fvV.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvV.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_achievement_wear_mark);
                    this.fvV.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.fvW.bsE()) {
                    this.fvV.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fvV.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fvW.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fvV.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fvW.bsF()) {
                    this.fvV.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvV.setTextSize(0, fvN);
                    this.fvV.setText(R.string.ala_nobility_open);
                    this.fvV.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvV.setBackgroundResource(R.drawable.transparent_bg);
                    this.fvV.setTextSize(0, fvM);
                    this.fvV.setText(R.string.ala_achievement_mark_status_expired);
                    this.fvV.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.fvV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fvW.bsA() == 0 || 3 == a.this.fvW.bsA()) {
                    if (a.this.fvW.bsE()) {
                        if (a.this.fvW.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.fwf != null) {
                                a.this.fwf.de(a.this.fvW.price);
                            }
                        } else if (a.this.fwg != null) {
                            a.this.fwg.l(a.this.fvW.bsx(), a.this.fvW.propId, false);
                        }
                    } else if (!a.this.fvW.bsF()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.fvW.bsw() || 2 != a.this.fvW.bsA()) {
                    a.this.bst();
                } else {
                    a.this.ND();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bss() {
        if (this.fvW.bsA() == 1 || this.fvW.bsA() == 2) {
            this.fwc.setVisibility(0);
            this.fwc.setText(this.fvW.bsD());
            return;
        }
        this.fwc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.fI(false);
        aVar.jV(R.string.ala_achievement_ops_alert_title);
        aVar.jW(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.fvV.setEnabled(false);
                a.this.bst();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bst() {
        if (1 == this.fvW.bsA()) {
            this.fvY.q(false, this.fvW.bsx());
        } else if (2 == this.fvW.bsA()) {
            this.fvY.q(true, this.fvW.bsx());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.fvX = null;
    }

    public void onDestroy() {
        if (this.fvY != null) {
            this.fvY.onDestroy();
        }
    }
}
