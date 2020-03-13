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
    private static final int fvg = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int fvh = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private com.baidu.tieba.ala.personcenter.privilege.a fvA;
    private TbImageView fvi;
    private FrameLayout fvj;
    private TextView fvk;
    private RelativeLayout fvl;
    private TextView fvm;
    private TextView fvn;
    private MarkLevelGroup fvo;
    private TextView fvp;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b fvq;
    private d fvr;
    private AlaUpdateMarkStatusModel fvs;
    private InterfaceC0478a fvt;
    private LinearLayout fvu;
    private TextView fvv;
    private TextView fvw;
    private LinearLayout fvx;
    private TextView fvy;
    private com.baidu.tieba.ala.personcenter.privilege.b fvz;
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
        this.fvt = interfaceC0478a;
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
        this.fvs = new AlaUpdateMarkStatusModel(getContext());
        this.fvs.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.fvp.setEnabled(true);
                if (z) {
                    if (a.this.fvt != null) {
                        a.this.fvt.a(true, a.this.fvq);
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
        this.fvz = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.fvz.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jX(boolean z) {
                if (z && a.this.fvq.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bsl();
                    a.this.bsm();
                    a.this.bsk();
                }
            }
        });
        this.fvA = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0477a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0477a
            public void l(boolean z, String str) {
                if (z) {
                    if (a.this.fvq != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.fvt != null) {
                            a.this.fvt.a(true, a.this.fvq);
                        }
                        a.this.fvq.qP(2);
                        a.this.bsl();
                        a.this.bsm();
                        a.this.bsk();
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
                if (a.this.fvt != null) {
                    a.this.fvt.a(false, a.this.fvq);
                }
                a.this.dismiss();
            }
        });
        this.fvi = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.fvi.setDefaultBgResource(R.color.transparent);
        this.fvi.setDefaultResource(R.drawable.pic_live_honor);
        this.fvi.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.fvj = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.fvk = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.fvl = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.fvm = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.fvn = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.fvo = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.fvo.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void cY(String str, String str2) {
                a.this.cX(str, str2);
            }
        });
        this.fvp = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.fvw = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.fvu = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.fvv = (TextView) findViewById(R.id.mark_tdou_price);
        this.fvx = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.fvy = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsk() {
        this.fvm.setVisibility(4);
        this.fvn.setVisibility(4);
        this.fvu.setVisibility(4);
        this.fvo.setVisibility(4);
        this.fvx.setVisibility(8);
        if (this.fvq.bsy()) {
            this.fvu.setVisibility(0);
            this.fvx.setVisibility(0);
            this.fvv.setText(AlaStringHelper.formatLowercasekDou(this.fvq.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.fvy.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.fvy.setCompoundDrawables(drawable, null, null, null);
            this.fvy.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.fvq.bsu() == 1) {
                this.fvx.setVisibility(8);
            }
        } else if (this.fvq.bsz()) {
            this.fvm.setVisibility(0);
            this.fvm.setText(this.fvq.getDescription());
        } else {
            this.fvo.setVisibility(0);
            this.fvm.setVisibility(0);
            this.fvn.setVisibility(0);
            this.fvm.setText(this.fvq.getDescription());
            this.fvn.setText(this.fvq.bsv());
            this.fvo.c(this.fvq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.fvi.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.fvi.startLoad(str, 10, false);
        }
        this.fvk.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsl() {
        switch (this.fvq.bsu()) {
            case 0:
                if (this.fvq.bsy()) {
                    this.fvp.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fvp.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fvq.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fvp.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fvq.bsz()) {
                    this.fvp.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_nobility_open);
                    this.fvp.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvp.setBackgroundResource(R.drawable.transparent_bg);
                    this.fvp.setTextSize(0, fvg);
                    this.fvp.setText(R.string.ala_achievement_mark_status_unlock);
                    this.fvp.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.fvq.bsy()) {
                    this.fvp.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_achievement_unwear_mark);
                    this.fvp.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.fvq.bsz()) {
                    this.fvp.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_achievement_unwear_mark);
                    this.fvp.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.fvp.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_achievement_unwear_mark);
                    this.fvp.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.fvq.bsy()) {
                    this.fvp.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_achievement_wear_mark);
                    this.fvp.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.fvq.bsz()) {
                    this.fvp.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_achievement_wear_mark);
                    this.fvp.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvp.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_achievement_wear_mark);
                    this.fvp.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.fvq.bsy()) {
                    this.fvp.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fvp.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fvq.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fvp.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fvq.bsz()) {
                    this.fvp.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fvp.setTextSize(0, fvh);
                    this.fvp.setText(R.string.ala_nobility_open);
                    this.fvp.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fvp.setBackgroundResource(R.drawable.transparent_bg);
                    this.fvp.setTextSize(0, fvg);
                    this.fvp.setText(R.string.ala_achievement_mark_status_expired);
                    this.fvp.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.fvp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fvq.bsu() == 0 || 3 == a.this.fvq.bsu()) {
                    if (a.this.fvq.bsy()) {
                        if (a.this.fvq.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.fvz != null) {
                                a.this.fvz.de(a.this.fvq.price);
                            }
                        } else if (a.this.fvA != null) {
                            a.this.fvA.l(a.this.fvq.bsr(), a.this.fvq.propId, false);
                        }
                    } else if (!a.this.fvq.bsz()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.fvq.bsq() || 2 != a.this.fvq.bsu()) {
                    a.this.bsn();
                } else {
                    a.this.NA();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsm() {
        if (this.fvq.bsu() == 1 || this.fvq.bsu() == 2) {
            this.fvw.setVisibility(0);
            this.fvw.setText(this.fvq.bsx());
            return;
        }
        this.fvw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.fH(false);
        aVar.jV(R.string.ala_achievement_ops_alert_title);
        aVar.jW(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.fvp.setEnabled(false);
                a.this.bsn();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsn() {
        if (1 == this.fvq.bsu()) {
            this.fvs.q(false, this.fvq.bsr());
        } else if (2 == this.fvq.bsu()) {
            this.fvs.q(true, this.fvq.bsr());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.fvr = null;
    }

    public void onDestroy() {
        if (this.fvs != null) {
            this.fvs.onDestroy();
        }
    }
}
