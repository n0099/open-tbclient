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
    private static final int bgN = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int hVU = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView hVV;
    private FrameLayout hVW;
    private TextView hVX;
    private RelativeLayout hVY;
    private TextView hVZ;
    private TextView hWa;
    private MarkLevelGroup hWb;
    private TextView hWc;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b hWd;
    private d hWe;
    private AlaUpdateMarkStatusModel hWf;
    private InterfaceC0686a hWg;
    private LinearLayout hWh;
    private TextView hWi;
    private TextView hWj;
    private LinearLayout hWk;
    private TextView hWl;
    private com.baidu.tieba.ala.personcenter.privilege.b hWm;
    private com.baidu.tieba.ala.personcenter.privilege.a hWn;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0686a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0686a interfaceC0686a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.hWg = interfaceC0686a;
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
        this.hWf = new AlaUpdateMarkStatusModel(getContext());
        this.hWf.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.hWc.setEnabled(true);
                if (z) {
                    if (a.this.hWg != null) {
                        a.this.hWg.a(true, a.this.hWd);
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
        this.hWm = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.hWm.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void oP(boolean z) {
                if (z && a.this.hWd.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.clU();
                    a.this.clV();
                    a.this.clT();
                }
            }
        });
        this.hWn = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0685a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0685a
            public void r(boolean z, String str) {
                if (z) {
                    if (a.this.hWd != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.hWg != null) {
                            a.this.hWg.a(true, a.this.hWd);
                        }
                        a.this.hWd.wj(2);
                        a.this.clU();
                        a.this.clV();
                        a.this.clT();
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
                if (a.this.hWg != null) {
                    a.this.hWg.a(false, a.this.hWd);
                }
                a.this.dismiss();
            }
        });
        this.hVV = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.hVV.setDefaultBgResource(R.color.transparent);
        this.hVV.setDefaultResource(R.drawable.pic_live_honor);
        this.hVW = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.hVX = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.hVY = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.hVZ = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.hWa = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.hWb = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.hWb.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eF(String str, String str2) {
                a.this.eE(str, str2);
            }
        });
        this.hWc = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.hWj = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.hWh = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.hWi = (TextView) findViewById(R.id.mark_tdou_price);
        this.hWk = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.hWl = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clT() {
        this.hVZ.setVisibility(4);
        this.hWa.setVisibility(4);
        this.hWh.setVisibility(4);
        this.hWb.setVisibility(4);
        this.hWk.setVisibility(8);
        if (this.hWd.cmi()) {
            this.hWh.setVisibility(0);
            this.hWk.setVisibility(0);
            this.hWi.setText(AlaStringHelper.formatLowercasekDou(this.hWd.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.hWl.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.hWl.setCompoundDrawables(drawable, null, null, null);
            this.hWl.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.hWd.cme() == 1) {
                this.hWk.setVisibility(8);
            }
        } else if (this.hWd.cmj()) {
            this.hVZ.setVisibility(0);
            this.hVZ.setText(this.hWd.getDescription());
        } else {
            this.hWb.setVisibility(0);
            this.hVZ.setVisibility(0);
            this.hWa.setVisibility(0);
            this.hVZ.setText(this.hWd.getDescription());
            this.hWa.setText(this.hWd.cmf());
            this.hWb.c(this.hWd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.hVV.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.hVV.startLoad(str, 10, false);
        }
        this.hVX.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clU() {
        switch (this.hWd.cme()) {
            case 0:
                if (this.hWd.cmi()) {
                    this.hWc.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hWc.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.hWd.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hWc.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hWd.cmj()) {
                    this.hWc.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_nobility_open);
                    this.hWc.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hWc.setBackgroundResource(R.drawable.transparent_bg);
                    this.hWc.setTextSize(0, bgN);
                    this.hWc.setText(R.string.ala_achievement_mark_status_unlock);
                    this.hWc.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.hWd.cmi()) {
                    this.hWc.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_achievement_unwear_mark);
                    this.hWc.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.hWd.cmj()) {
                    this.hWc.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_achievement_unwear_mark);
                    this.hWc.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.hWc.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_achievement_unwear_mark);
                    this.hWc.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.hWd.cmi()) {
                    this.hWc.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_achievement_wear_mark);
                    this.hWc.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    break;
                } else if (this.hWd.cmj()) {
                    this.hWc.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_achievement_wear_mark);
                    this.hWc.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hWc.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_achievement_wear_mark);
                    this.hWc.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.hWd.cmi()) {
                    this.hWc.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hWc.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.hWd.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hWc.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hWd.cmj()) {
                    this.hWc.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hWc.setTextSize(0, hVU);
                    this.hWc.setText(R.string.ala_nobility_open);
                    this.hWc.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hWc.setBackgroundResource(R.drawable.transparent_bg);
                    this.hWc.setTextSize(0, bgN);
                    this.hWc.setText(R.string.ala_achievement_mark_status_expired);
                    this.hWc.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.hWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hWd.cme() == 0 || 3 == a.this.hWd.cme()) {
                    if (a.this.hWd.cmi()) {
                        if (a.this.hWd.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.hWm != null) {
                                a.this.hWm.fN(a.this.hWd.price);
                            }
                        } else if (a.this.hWn != null) {
                            a.this.hWn.k(a.this.hWd.cmb(), a.this.hWd.propId, false);
                        }
                    } else if (!a.this.hWd.cmj()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.hWd.cma() || 2 != a.this.hWd.cme()) {
                    a.this.clX();
                } else {
                    a.this.clW();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clV() {
        if (this.hWd.cme() == 1 || this.hWd.cme() == 2) {
            this.hWj.setVisibility(0);
            this.hWj.setText(this.hWd.cmh());
            return;
        }
        this.hWj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.jE(false);
        aVar.nt(R.string.ala_achievement_ops_alert_title);
        aVar.nu(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.hWc.setEnabled(false);
                a.this.clX();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clX() {
        if (1 == this.hWd.cme()) {
            this.hWf.y(false, this.hWd.cmb());
        } else if (2 == this.hWd.cme()) {
            this.hWf.y(true, this.hWd.cmb());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.hWe = null;
    }

    public void onDestroy() {
        if (this.hWf != null) {
            this.hWf.onDestroy();
        }
    }
}
