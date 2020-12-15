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
    private static final int hOg = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView hOh;
    private FrameLayout hOi;
    private TextView hOj;
    private RelativeLayout hOk;
    private TextView hOl;
    private TextView hOm;
    private MarkLevelGroup hOn;
    private TextView hOo;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b hOp;
    private d hOq;
    private AlaUpdateMarkStatusModel hOr;
    private InterfaceC0711a hOs;
    private LinearLayout hOt;
    private TextView hOu;
    private TextView hOv;
    private LinearLayout hOw;
    private TextView hOx;
    private com.baidu.tieba.ala.personcenter.privilege.b hOy;
    private com.baidu.tieba.ala.personcenter.privilege.a hOz;
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
        this.hOs = interfaceC0711a;
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
        this.hOr = new AlaUpdateMarkStatusModel(getContext());
        this.hOr.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.hOo.setEnabled(true);
                if (z) {
                    if (a.this.hOs != null) {
                        a.this.hOs.a(true, a.this.hOp);
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
        this.hOy = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.hOy.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void ou(boolean z) {
                if (z && a.this.hOp.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.cmT();
                    a.this.cmU();
                    a.this.cmS();
                }
            }
        });
        this.hOz = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0710a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0710a
            public void r(boolean z, String str) {
                if (z) {
                    if (a.this.hOp != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.hOs != null) {
                            a.this.hOs.a(true, a.this.hOp);
                        }
                        a.this.hOp.xC(2);
                        a.this.cmT();
                        a.this.cmU();
                        a.this.cmS();
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
                if (a.this.hOs != null) {
                    a.this.hOs.a(false, a.this.hOp);
                }
                a.this.dismiss();
            }
        });
        this.hOh = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.hOh.setDefaultBgResource(R.color.transparent);
        this.hOh.setDefaultResource(R.drawable.pic_live_honor);
        this.hOh.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.hOi = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.hOj = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.hOk = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.hOl = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.hOm = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.hOn = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.hOn.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eF(String str, String str2) {
                a.this.eE(str, str2);
            }
        });
        this.hOo = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.hOv = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.hOt = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.hOu = (TextView) findViewById(R.id.mark_tdou_price);
        this.hOw = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.hOx = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmS() {
        this.hOl.setVisibility(4);
        this.hOm.setVisibility(4);
        this.hOt.setVisibility(4);
        this.hOn.setVisibility(4);
        this.hOw.setVisibility(8);
        if (this.hOp.cnh()) {
            this.hOt.setVisibility(0);
            this.hOw.setVisibility(0);
            this.hOu.setText(AlaStringHelper.formatLowercasekDou(this.hOp.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.hOx.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.hOx.setCompoundDrawables(drawable, null, null, null);
            this.hOx.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.hOp.cnd() == 1) {
                this.hOw.setVisibility(8);
            }
        } else if (this.hOp.cni()) {
            this.hOl.setVisibility(0);
            this.hOl.setText(this.hOp.getDescription());
        } else {
            this.hOn.setVisibility(0);
            this.hOl.setVisibility(0);
            this.hOm.setVisibility(0);
            this.hOl.setText(this.hOp.getDescription());
            this.hOm.setText(this.hOp.cne());
            this.hOn.c(this.hOp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.hOh.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.hOh.startLoad(str, 10, false);
        }
        this.hOj.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmT() {
        switch (this.hOp.cnd()) {
            case 0:
                if (this.hOp.cnh()) {
                    this.hOo.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hOo.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.hOp.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hOo.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hOp.cni()) {
                    this.hOo.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_nobility_open);
                    this.hOo.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hOo.setBackgroundResource(R.drawable.transparent_bg);
                    this.hOo.setTextSize(0, bjY);
                    this.hOo.setText(R.string.ala_achievement_mark_status_unlock);
                    this.hOo.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.hOp.cnh()) {
                    this.hOo.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_achievement_unwear_mark);
                    this.hOo.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.hOp.cni()) {
                    this.hOo.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_achievement_unwear_mark);
                    this.hOo.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.hOo.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_achievement_unwear_mark);
                    this.hOo.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.hOp.cnh()) {
                    this.hOo.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_achievement_wear_mark);
                    this.hOo.setTextColor(getContext().getResources().getColorStateList(R.color.CAM_X0201));
                    break;
                } else if (this.hOp.cni()) {
                    this.hOo.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_achievement_wear_mark);
                    this.hOo.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hOo.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_achievement_wear_mark);
                    this.hOo.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.hOp.cnh()) {
                    this.hOo.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hOo.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
                    if (this.hOp.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hOo.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hOp.cni()) {
                    this.hOo.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hOo.setTextSize(0, hOg);
                    this.hOo.setText(R.string.ala_nobility_open);
                    this.hOo.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hOo.setBackgroundResource(R.drawable.transparent_bg);
                    this.hOo.setTextSize(0, bjY);
                    this.hOo.setText(R.string.ala_achievement_mark_status_expired);
                    this.hOo.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.hOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hOp.cnd() == 0 || 3 == a.this.hOp.cnd()) {
                    if (a.this.hOp.cnh()) {
                        if (a.this.hOp.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.hOy != null) {
                                a.this.hOy.fN(a.this.hOp.price);
                            }
                        } else if (a.this.hOz != null) {
                            a.this.hOz.k(a.this.hOp.cna(), a.this.hOp.propId, false);
                        }
                    } else if (!a.this.hOp.cni()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.hOp.cmZ() || 2 != a.this.hOp.cnd()) {
                    a.this.cmW();
                } else {
                    a.this.cmV();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (this.hOp.cnd() == 1 || this.hOp.cnd() == 2) {
            this.hOv.setVisibility(0);
            this.hOv.setText(this.hOp.cng());
            return;
        }
        this.hOv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.jm(false);
        aVar.oP(R.string.ala_achievement_ops_alert_title);
        aVar.oQ(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.hOo.setEnabled(false);
                a.this.cmW();
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
    public void cmW() {
        if (1 == this.hOp.cnd()) {
            this.hOr.z(false, this.hOp.cna());
        } else if (2 == this.hOp.cnd()) {
            this.hOr.z(true, this.hOp.cna());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.hOq = null;
    }

    public void onDestroy() {
        if (this.hOr != null) {
            this.hOr.onDestroy();
        }
    }
}
