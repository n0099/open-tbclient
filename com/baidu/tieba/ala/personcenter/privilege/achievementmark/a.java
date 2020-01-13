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
    private static final int fsq = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int fsr = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b fsA;
    private d fsB;
    private AlaUpdateMarkStatusModel fsC;
    private InterfaceC0470a fsD;
    private LinearLayout fsE;
    private TextView fsF;
    private TextView fsG;
    private LinearLayout fsH;
    private TextView fsI;
    private com.baidu.tieba.ala.personcenter.privilege.b fsJ;
    private com.baidu.tieba.ala.personcenter.privilege.a fsK;
    private TbImageView fss;
    private FrameLayout fst;
    private TextView fsu;
    private RelativeLayout fsv;
    private TextView fsw;
    private TextView fsx;
    private MarkLevelGroup fsy;
    private TextView fsz;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0470a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0470a interfaceC0470a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fsD = interfaceC0470a;
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
        this.fsC = new AlaUpdateMarkStatusModel(getContext());
        this.fsC.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.fsz.setEnabled(true);
                if (z) {
                    if (a.this.fsD != null) {
                        a.this.fsD.a(true, a.this.fsA);
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
        this.fsJ = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.fsJ.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void jV(boolean z) {
                if (z && a.this.fsA.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.bqE();
                    a.this.bqF();
                    a.this.bqD();
                }
            }
        });
        this.fsK = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0469a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0469a
            public void k(boolean z, String str) {
                if (z) {
                    if (a.this.fsA != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.fsD != null) {
                            a.this.fsD.a(true, a.this.fsA);
                        }
                        a.this.fsA.qI(2);
                        a.this.bqE();
                        a.this.bqF();
                        a.this.bqD();
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
                if (a.this.fsD != null) {
                    a.this.fsD.a(false, a.this.fsA);
                }
                a.this.dismiss();
            }
        });
        this.fss = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.fss.setDefaultBgResource(R.color.transparent);
        this.fss.setDefaultResource(R.drawable.pic_live_honor);
        this.fss.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.fst = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.fsu = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.fsv = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.fsw = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.fsx = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.fsy = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.fsy.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void cP(String str, String str2) {
                a.this.cO(str, str2);
            }
        });
        this.fsz = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.fsG = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.fsE = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.fsF = (TextView) findViewById(R.id.mark_tdou_price);
        this.fsH = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.fsI = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqD() {
        this.fsw.setVisibility(4);
        this.fsx.setVisibility(4);
        this.fsE.setVisibility(4);
        this.fsy.setVisibility(4);
        this.fsH.setVisibility(8);
        if (this.fsA.bqR()) {
            this.fsE.setVisibility(0);
            this.fsH.setVisibility(0);
            this.fsF.setText(AlaStringHelper.formatLowercasekDou(this.fsA.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.fsI.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.fsI.setCompoundDrawables(drawable, null, null, null);
            this.fsI.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.fsA.bqN() == 1) {
                this.fsH.setVisibility(8);
            }
        } else if (this.fsA.bqS()) {
            this.fsw.setVisibility(0);
            this.fsw.setText(this.fsA.getDescription());
        } else {
            this.fsy.setVisibility(0);
            this.fsw.setVisibility(0);
            this.fsx.setVisibility(0);
            this.fsw.setText(this.fsA.getDescription());
            this.fsx.setText(this.fsA.bqO());
            this.fsy.c(this.fsA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.fss.startLoad(String.valueOf((int) R.drawable.pic_live_honor), 24, false);
        } else {
            this.fss.startLoad(str, 10, false);
        }
        this.fsu.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqE() {
        switch (this.fsA.bqN()) {
            case 0:
                if (this.fsA.bqR()) {
                    this.fsz.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fsz.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fsA.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fsz.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fsA.bqS()) {
                    this.fsz.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_nobility_open);
                    this.fsz.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fsz.setBackgroundResource(R.drawable.transparent_bg);
                    this.fsz.setTextSize(0, fsq);
                    this.fsz.setText(R.string.ala_achievement_mark_status_unlock);
                    this.fsz.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.fsA.bqR()) {
                    this.fsz.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_achievement_unwear_mark);
                    this.fsz.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.fsA.bqS()) {
                    this.fsz.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_achievement_unwear_mark);
                    this.fsz.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.fsz.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_achievement_unwear_mark);
                    this.fsz.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.fsA.bqR()) {
                    this.fsz.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_achievement_wear_mark);
                    this.fsz.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.fsA.bqS()) {
                    this.fsz.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_achievement_wear_mark);
                    this.fsz.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fsz.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_achievement_wear_mark);
                    this.fsz.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.fsA.bqR()) {
                    this.fsz.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_enter_effect_tdou_buy);
                    this.fsz.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.fsA.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.fsz.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.fsA.bqS()) {
                    this.fsz.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.fsz.setTextSize(0, fsr);
                    this.fsz.setText(R.string.ala_nobility_open);
                    this.fsz.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.fsz.setBackgroundResource(R.drawable.transparent_bg);
                    this.fsz.setTextSize(0, fsq);
                    this.fsz.setText(R.string.ala_achievement_mark_status_expired);
                    this.fsz.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.fsz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fsA.bqN() == 0 || 3 == a.this.fsA.bqN()) {
                    if (a.this.fsA.bqR()) {
                        if (a.this.fsA.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.fsJ != null) {
                                a.this.fsJ.dc(a.this.fsA.price);
                            }
                        } else if (a.this.fsK != null) {
                            a.this.fsK.l(a.this.fsA.bqK(), a.this.fsA.propId, false);
                        }
                    } else if (!a.this.fsA.bqS()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.fsA.bqJ() || 2 != a.this.fsA.bqN()) {
                    a.this.bqG();
                } else {
                    a.this.Lk();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqF() {
        if (this.fsA.bqN() == 1 || this.fsA.bqN() == 2) {
            this.fsG.setVisibility(0);
            this.fsG.setText(this.fsA.bqQ());
            return;
        }
        this.fsG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.fA(false);
        aVar.jE(R.string.ala_achievement_ops_alert_title);
        aVar.jF(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.fsz.setEnabled(false);
                a.this.bqG();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqG() {
        if (1 == this.fsA.bqN()) {
            this.fsC.p(false, this.fsA.bqK());
        } else if (2 == this.fsA.bqN()) {
            this.fsC.p(true, this.fsA.bqK());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.fsB = null;
    }

    public void onDestroy() {
        if (this.fsC != null) {
            this.fsC.onDestroy();
        }
    }
}
