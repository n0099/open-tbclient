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
    private static final int bfI = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int hEx = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TextView hEA;
    private RelativeLayout hEB;
    private TextView hEC;
    private TextView hED;
    private MarkLevelGroup hEE;
    private TextView hEF;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b hEG;
    private d hEH;
    private AlaUpdateMarkStatusModel hEI;
    private InterfaceC0698a hEJ;
    private LinearLayout hEK;
    private TextView hEL;
    private TextView hEM;
    private LinearLayout hEN;
    private TextView hEO;
    private com.baidu.tieba.ala.personcenter.privilege.b hEP;
    private com.baidu.tieba.ala.personcenter.privilege.a hEQ;
    private TbImageView hEy;
    private FrameLayout hEz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0698a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0698a interfaceC0698a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.hEJ = interfaceC0698a;
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
        IQ();
    }

    private void IQ() {
        this.hEI = new AlaUpdateMarkStatusModel(getContext());
        this.hEI.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.hEF.setEnabled(true);
                if (z) {
                    if (a.this.hEJ != null) {
                        a.this.hEJ.a(true, a.this.hEG);
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
        this.hEP = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.hEP.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void nZ(boolean z) {
                if (z && a.this.hEG.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.ciY();
                    a.this.ciZ();
                    a.this.ciX();
                }
            }
        });
        this.hEQ = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0697a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0697a
            public void s(boolean z, String str) {
                if (z) {
                    if (a.this.hEG != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.hEJ != null) {
                            a.this.hEJ.a(true, a.this.hEG);
                        }
                        a.this.hEG.wX(2);
                        a.this.ciY();
                        a.this.ciZ();
                        a.this.ciX();
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
                if (a.this.hEJ != null) {
                    a.this.hEJ.a(false, a.this.hEG);
                }
                a.this.dismiss();
            }
        });
        this.hEy = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.hEy.setDefaultBgResource(R.color.transparent);
        this.hEy.setDefaultResource(R.drawable.pic_live_honor);
        this.hEy.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.hEz = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.hEA = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.hEB = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.hEC = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.hED = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.hEE = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.hEE.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eA(String str, String str2) {
                a.this.ez(str, str2);
            }
        });
        this.hEF = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.hEM = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.hEK = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.hEL = (TextView) findViewById(R.id.mark_tdou_price);
        this.hEN = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.hEO = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciX() {
        this.hEC.setVisibility(4);
        this.hED.setVisibility(4);
        this.hEK.setVisibility(4);
        this.hEE.setVisibility(4);
        this.hEN.setVisibility(8);
        if (this.hEG.cjm()) {
            this.hEK.setVisibility(0);
            this.hEN.setVisibility(0);
            this.hEL.setText(AlaStringHelper.formatLowercasekDou(this.hEG.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.hEO.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.hEO.setCompoundDrawables(drawable, null, null, null);
            this.hEO.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.hEG.cji() == 1) {
                this.hEN.setVisibility(8);
            }
        } else if (this.hEG.cjn()) {
            this.hEC.setVisibility(0);
            this.hEC.setText(this.hEG.getDescription());
        } else {
            this.hEE.setVisibility(0);
            this.hEC.setVisibility(0);
            this.hED.setVisibility(0);
            this.hEC.setText(this.hEG.getDescription());
            this.hED.setText(this.hEG.cjj());
            this.hEE.c(this.hEG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.hEy.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.hEy.startLoad(str, 10, false);
        }
        this.hEA.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciY() {
        switch (this.hEG.cji()) {
            case 0:
                if (this.hEG.cjm()) {
                    this.hEF.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hEF.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.hEG.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hEF.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hEG.cjn()) {
                    this.hEF.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_nobility_open);
                    this.hEF.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hEF.setBackgroundResource(R.drawable.transparent_bg);
                    this.hEF.setTextSize(0, bfI);
                    this.hEF.setText(R.string.ala_achievement_mark_status_unlock);
                    this.hEF.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.hEG.cjm()) {
                    this.hEF.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_achievement_unwear_mark);
                    this.hEF.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.hEG.cjn()) {
                    this.hEF.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_achievement_unwear_mark);
                    this.hEF.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.hEF.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_achievement_unwear_mark);
                    this.hEF.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.hEG.cjm()) {
                    this.hEF.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_achievement_wear_mark);
                    this.hEF.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    break;
                } else if (this.hEG.cjn()) {
                    this.hEF.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_achievement_wear_mark);
                    this.hEF.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hEF.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_achievement_wear_mark);
                    this.hEF.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.hEG.cjm()) {
                    this.hEF.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hEF.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.hEG.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hEF.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hEG.cjn()) {
                    this.hEF.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hEF.setTextSize(0, hEx);
                    this.hEF.setText(R.string.ala_nobility_open);
                    this.hEF.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hEF.setBackgroundResource(R.drawable.transparent_bg);
                    this.hEF.setTextSize(0, bfI);
                    this.hEF.setText(R.string.ala_achievement_mark_status_expired);
                    this.hEF.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.hEF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hEG.cji() == 0 || 3 == a.this.hEG.cji()) {
                    if (a.this.hEG.cjm()) {
                        if (a.this.hEG.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.hEP != null) {
                                a.this.hEP.fj(a.this.hEG.price);
                            }
                        } else if (a.this.hEQ != null) {
                            a.this.hEQ.k(a.this.hEG.cjf(), a.this.hEG.propId, false);
                        }
                    } else if (!a.this.hEG.cjn()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.hEG.cje() || 2 != a.this.hEG.cji()) {
                    a.this.cjb();
                } else {
                    a.this.cja();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciZ() {
        if (this.hEG.cji() == 1 || this.hEG.cji() == 2) {
            this.hEM.setVisibility(0);
            this.hEM.setText(this.hEG.cjl());
            return;
        }
        this.hEM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cja() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.iX(false);
        aVar.or(R.string.ala_achievement_ops_alert_title);
        aVar.os(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.hEF.setEnabled(false);
                a.this.cjb();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjb() {
        if (1 == this.hEG.cji()) {
            this.hEI.z(false, this.hEG.cjf());
        } else if (2 == this.hEG.cji()) {
            this.hEI.z(true, this.hEG.cjf());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.hEH = null;
    }

    public void onDestroy() {
        if (this.hEI != null) {
            this.hEI.onDestroy();
        }
    }
}
