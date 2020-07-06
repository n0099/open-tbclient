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
    private static final int aRU = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int gCm = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TextView gCA;
    private TextView gCB;
    private LinearLayout gCC;
    private TextView gCD;
    private com.baidu.tieba.ala.personcenter.privilege.b gCE;
    private com.baidu.tieba.ala.personcenter.privilege.a gCF;
    private TbImageView gCn;
    private FrameLayout gCo;
    private TextView gCp;
    private RelativeLayout gCq;
    private TextView gCr;
    private TextView gCs;
    private MarkLevelGroup gCt;
    private TextView gCu;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b gCv;
    private d gCw;
    private AlaUpdateMarkStatusModel gCx;
    private InterfaceC0594a gCy;
    private LinearLayout gCz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0594a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0594a interfaceC0594a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gCy = interfaceC0594a;
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
        Bc();
    }

    private void Bc() {
        this.gCx = new AlaUpdateMarkStatusModel(getContext());
        this.gCx.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.gCu.setEnabled(true);
                if (z) {
                    if (a.this.gCy != null) {
                        a.this.gCy.a(true, a.this.gCv);
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
        this.gCE = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.gCE.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void lJ(boolean z) {
                if (z && a.this.gCv.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bLy();
                    a.this.bLz();
                    a.this.bLx();
                }
            }
        });
        this.gCF = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0593a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0593a
            public void o(boolean z, String str) {
                if (z) {
                    if (a.this.gCv != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.gCy != null) {
                            a.this.gCy.a(true, a.this.gCv);
                        }
                        a.this.gCv.sn(2);
                        a.this.bLy();
                        a.this.bLz();
                        a.this.bLx();
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
                if (a.this.gCy != null) {
                    a.this.gCy.a(false, a.this.gCv);
                }
                a.this.dismiss();
            }
        });
        this.gCn = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.gCn.setDefaultBgResource(R.color.transparent);
        this.gCn.setDefaultResource(R.drawable.pic_live_honor);
        this.gCn.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.gCo = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.gCp = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.gCq = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.gCr = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.gCs = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.gCt = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.gCt.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void dQ(String str, String str2) {
                a.this.dP(str, str2);
            }
        });
        this.gCu = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.gCB = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.gCz = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.gCA = (TextView) findViewById(R.id.mark_tdou_price);
        this.gCC = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.gCD = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLx() {
        this.gCr.setVisibility(4);
        this.gCs.setVisibility(4);
        this.gCz.setVisibility(4);
        this.gCt.setVisibility(4);
        this.gCC.setVisibility(8);
        if (this.gCv.bLM()) {
            this.gCz.setVisibility(0);
            this.gCC.setVisibility(0);
            this.gCA.setText(AlaStringHelper.formatLowercasekDou(this.gCv.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.gCD.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.gCD.setCompoundDrawables(drawable, null, null, null);
            this.gCD.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.gCv.bLI() == 1) {
                this.gCC.setVisibility(8);
            }
        } else if (this.gCv.bLN()) {
            this.gCr.setVisibility(0);
            this.gCr.setText(this.gCv.getDescription());
        } else {
            this.gCt.setVisibility(0);
            this.gCr.setVisibility(0);
            this.gCs.setVisibility(0);
            this.gCr.setText(this.gCv.getDescription());
            this.gCs.setText(this.gCv.bLJ());
            this.gCt.c(this.gCv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.gCn.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.gCn.startLoad(str, 10, false);
        }
        this.gCp.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        switch (this.gCv.bLI()) {
            case 0:
                if (this.gCv.bLM()) {
                    this.gCu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gCu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gCv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gCu.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gCv.bLN()) {
                    this.gCu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_nobility_open);
                    this.gCu.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gCu.setBackgroundResource(R.drawable.transparent_bg);
                    this.gCu.setTextSize(0, aRU);
                    this.gCu.setText(R.string.ala_achievement_mark_status_unlock);
                    this.gCu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.gCv.bLM()) {
                    this.gCu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_achievement_unwear_mark);
                    this.gCu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.gCv.bLN()) {
                    this.gCu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_achievement_unwear_mark);
                    this.gCu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.gCu.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_achievement_unwear_mark);
                    this.gCu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.gCv.bLM()) {
                    this.gCu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_achievement_wear_mark);
                    this.gCu.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.gCv.bLN()) {
                    this.gCu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_achievement_wear_mark);
                    this.gCu.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gCu.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_achievement_wear_mark);
                    this.gCu.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.gCv.bLM()) {
                    this.gCu.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gCu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gCv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gCu.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gCv.bLN()) {
                    this.gCu.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gCu.setTextSize(0, gCm);
                    this.gCu.setText(R.string.ala_nobility_open);
                    this.gCu.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gCu.setBackgroundResource(R.drawable.transparent_bg);
                    this.gCu.setTextSize(0, aRU);
                    this.gCu.setText(R.string.ala_achievement_mark_status_expired);
                    this.gCu.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.gCu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCv.bLI() == 0 || 3 == a.this.gCv.bLI()) {
                    if (a.this.gCv.bLM()) {
                        if (a.this.gCv.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.gCE != null) {
                                a.this.gCE.dQ(a.this.gCv.price);
                            }
                        } else if (a.this.gCF != null) {
                            a.this.gCF.l(a.this.gCv.bLF(), a.this.gCv.propId, false);
                        }
                    } else if (!a.this.gCv.bLN()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.gCv.bLE() || 2 != a.this.gCv.bLI()) {
                    a.this.bLB();
                } else {
                    a.this.bLA();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLz() {
        if (this.gCv.bLI() == 1 || this.gCv.bLI() == 2) {
            this.gCB.setVisibility(0);
            this.gCB.setText(this.gCv.bLL());
            return;
        }
        this.gCB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.hg(false);
        aVar.kS(R.string.ala_achievement_ops_alert_title);
        aVar.kT(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.gCu.setEnabled(false);
                a.this.bLB();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLB() {
        if (1 == this.gCv.bLI()) {
            this.gCx.w(false, this.gCv.bLF());
        } else if (2 == this.gCv.bLI()) {
            this.gCx.w(true, this.gCv.bLF());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.gCw = null;
    }

    public void onDestroy() {
        if (this.gCx != null) {
            this.gCx.onDestroy();
        }
    }
}
