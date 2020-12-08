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
/* loaded from: classes6.dex */
public class a extends Dialog {
    private static final int bjY = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int hOe = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView hOf;
    private FrameLayout hOg;
    private TextView hOh;
    private RelativeLayout hOi;
    private TextView hOj;
    private TextView hOk;
    private MarkLevelGroup hOl;
    private TextView hOm;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b hOn;
    private d hOo;
    private AlaUpdateMarkStatusModel hOp;
    private InterfaceC0711a hOq;
    private LinearLayout hOr;
    private TextView hOs;
    private TextView hOt;
    private LinearLayout hOu;
    private TextView hOv;
    private com.baidu.tieba.ala.personcenter.privilege.b hOw;
    private com.baidu.tieba.ala.personcenter.privilege.a hOx;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0711a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0711a interfaceC0711a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.hOq = interfaceC0711a;
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
        KR();
    }

    private void KR() {
        this.hOp = new AlaUpdateMarkStatusModel(getContext());
        this.hOp.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.hOm.setEnabled(true);
                if (z) {
                    if (a.this.hOq != null) {
                        a.this.hOq.a(true, a.this.hOn);
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
        this.hOw = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.hOw.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void ou(boolean z) {
                if (z && a.this.hOn.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.cmS();
                    a.this.cmT();
                    a.this.cmR();
                }
            }
        });
        this.hOx = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0710a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0710a
            public void r(boolean z, String str) {
                if (z) {
                    if (a.this.hOn != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.hOq != null) {
                            a.this.hOq.a(true, a.this.hOn);
                        }
                        a.this.hOn.xC(2);
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
                if (a.this.hOq != null) {
                    a.this.hOq.a(false, a.this.hOn);
                }
                a.this.dismiss();
            }
        });
        this.hOf = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.hOf.setDefaultBgResource(R.color.transparent);
        this.hOf.setDefaultResource(R.drawable.pic_live_honor);
        this.hOf.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.hOg = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.hOh = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.hOi = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.hOj = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.hOk = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.hOl = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.hOl.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eF(String str, String str2) {
                a.this.eE(str, str2);
            }
        });
        this.hOm = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.hOt = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.hOr = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.hOs = (TextView) findViewById(R.id.mark_tdou_price);
        this.hOu = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.hOv = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmR() {
        this.hOj.setVisibility(4);
        this.hOk.setVisibility(4);
        this.hOr.setVisibility(4);
        this.hOl.setVisibility(4);
        this.hOu.setVisibility(8);
        if (this.hOn.cng()) {
            this.hOr.setVisibility(0);
            this.hOu.setVisibility(0);
            this.hOs.setText(AlaStringHelper.formatLowercasekDou(this.hOn.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.hOv.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.hOv.setCompoundDrawables(drawable, null, null, null);
            this.hOv.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.hOn.cnc() == 1) {
                this.hOu.setVisibility(8);
            }
        } else if (this.hOn.cnh()) {
            this.hOj.setVisibility(0);
            this.hOj.setText(this.hOn.getDescription());
        } else {
            this.hOl.setVisibility(0);
            this.hOj.setVisibility(0);
            this.hOk.setVisibility(0);
            this.hOj.setText(this.hOn.getDescription());
            this.hOk.setText(this.hOn.cnd());
            this.hOl.c(this.hOn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.hOf.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.hOf.startLoad(str, 10, false);
        }
        this.hOh.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmS() {
        switch (this.hOn.cnc()) {
            case 0:
                if (this.hOn.cng()) {
                    this.hOm.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hOm.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.hOn.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hOm.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hOn.cnh()) {
                    this.hOm.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_nobility_open);
                    this.hOm.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hOm.setBackgroundResource(R.drawable.transparent_bg);
                    this.hOm.setTextSize(0, bjY);
                    this.hOm.setText(R.string.ala_achievement_mark_status_unlock);
                    this.hOm.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.hOn.cng()) {
                    this.hOm.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_achievement_unwear_mark);
                    this.hOm.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.hOn.cnh()) {
                    this.hOm.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_achievement_unwear_mark);
                    this.hOm.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.hOm.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_achievement_unwear_mark);
                    this.hOm.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.hOn.cng()) {
                    this.hOm.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_achievement_wear_mark);
                    this.hOm.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    break;
                } else if (this.hOn.cnh()) {
                    this.hOm.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_achievement_wear_mark);
                    this.hOm.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hOm.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_achievement_wear_mark);
                    this.hOm.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.hOn.cng()) {
                    this.hOm.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hOm.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.hOn.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hOm.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hOn.cnh()) {
                    this.hOm.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hOm.setTextSize(0, hOe);
                    this.hOm.setText(R.string.ala_nobility_open);
                    this.hOm.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hOm.setBackgroundResource(R.drawable.transparent_bg);
                    this.hOm.setTextSize(0, bjY);
                    this.hOm.setText(R.string.ala_achievement_mark_status_expired);
                    this.hOm.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.hOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hOn.cnc() == 0 || 3 == a.this.hOn.cnc()) {
                    if (a.this.hOn.cng()) {
                        if (a.this.hOn.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.hOw != null) {
                                a.this.hOw.fN(a.this.hOn.price);
                            }
                        } else if (a.this.hOx != null) {
                            a.this.hOx.k(a.this.hOn.cmZ(), a.this.hOn.propId, false);
                        }
                    } else if (!a.this.hOn.cnh()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.hOn.cmY() || 2 != a.this.hOn.cnc()) {
                    a.this.cmV();
                } else {
                    a.this.cmU();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmT() {
        if (this.hOn.cnc() == 1 || this.hOn.cnc() == 2) {
            this.hOt.setVisibility(0);
            this.hOt.setText(this.hOn.cnf());
            return;
        }
        this.hOt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.jm(false);
        aVar.oP(R.string.ala_achievement_ops_alert_title);
        aVar.oQ(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.hOm.setEnabled(false);
                a.this.cmV();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmV() {
        if (1 == this.hOn.cnc()) {
            this.hOp.z(false, this.hOn.cmZ());
        } else if (2 == this.hOn.cnc()) {
            this.hOp.z(true, this.hOn.cmZ());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.hOo = null;
    }

    public void onDestroy() {
        if (this.hOp != null) {
            this.hOp.onDestroy();
        }
    }
}
