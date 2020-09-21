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
    private static final int bba = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int gXX = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView gXY;
    private FrameLayout gXZ;
    private TextView gYa;
    private RelativeLayout gYb;
    private TextView gYc;
    private TextView gYd;
    private MarkLevelGroup gYe;
    private TextView gYf;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b gYg;
    private d gYh;
    private AlaUpdateMarkStatusModel gYi;
    private InterfaceC0650a gYj;
    private LinearLayout gYk;
    private TextView gYl;
    private TextView gYm;
    private LinearLayout gYn;
    private TextView gYo;
    private com.baidu.tieba.ala.personcenter.privilege.b gYp;
    private com.baidu.tieba.ala.personcenter.privilege.a gYq;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0650a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0650a interfaceC0650a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gYj = interfaceC0650a;
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
        HI();
    }

    private void HI() {
        this.gYi = new AlaUpdateMarkStatusModel(getContext());
        this.gYi.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.gYf.setEnabled(true);
                if (z) {
                    if (a.this.gYj != null) {
                        a.this.gYj.a(true, a.this.gYg);
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
        this.gYp = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.gYp.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void mV(boolean z) {
                if (z && a.this.gYg.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.caD();
                    a.this.caE();
                    a.this.caC();
                }
            }
        });
        this.gYq = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0649a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0649a
            public void p(boolean z, String str) {
                if (z) {
                    if (a.this.gYg != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.gYj != null) {
                            a.this.gYj.a(true, a.this.gYg);
                        }
                        a.this.gYg.vm(2);
                        a.this.caD();
                        a.this.caE();
                        a.this.caC();
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
                if (a.this.gYj != null) {
                    a.this.gYj.a(false, a.this.gYg);
                }
                a.this.dismiss();
            }
        });
        this.gXY = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.gXY.setDefaultBgResource(R.color.transparent);
        this.gXY.setDefaultResource(R.drawable.pic_live_honor);
        this.gXY.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.gXZ = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.gYa = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.gYb = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.gYc = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.gYd = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.gYe = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.gYe.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eo(String str, String str2) {
                a.this.en(str, str2);
            }
        });
        this.gYf = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.gYm = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.gYk = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.gYl = (TextView) findViewById(R.id.mark_tdou_price);
        this.gYn = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.gYo = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caC() {
        this.gYc.setVisibility(4);
        this.gYd.setVisibility(4);
        this.gYk.setVisibility(4);
        this.gYe.setVisibility(4);
        this.gYn.setVisibility(8);
        if (this.gYg.caR()) {
            this.gYk.setVisibility(0);
            this.gYn.setVisibility(0);
            this.gYl.setText(AlaStringHelper.formatLowercasekDou(this.gYg.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.gYo.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.gYo.setCompoundDrawables(drawable, null, null, null);
            this.gYo.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.gYg.caN() == 1) {
                this.gYn.setVisibility(8);
            }
        } else if (this.gYg.caS()) {
            this.gYc.setVisibility(0);
            this.gYc.setText(this.gYg.getDescription());
        } else {
            this.gYe.setVisibility(0);
            this.gYc.setVisibility(0);
            this.gYd.setVisibility(0);
            this.gYc.setText(this.gYg.getDescription());
            this.gYd.setText(this.gYg.caO());
            this.gYe.c(this.gYg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.gXY.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.gXY.startLoad(str, 10, false);
        }
        this.gYa.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caD() {
        switch (this.gYg.caN()) {
            case 0:
                if (this.gYg.caR()) {
                    this.gYf.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gYf.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gYg.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gYf.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gYg.caS()) {
                    this.gYf.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_nobility_open);
                    this.gYf.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gYf.setBackgroundResource(R.drawable.transparent_bg);
                    this.gYf.setTextSize(0, bba);
                    this.gYf.setText(R.string.ala_achievement_mark_status_unlock);
                    this.gYf.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.gYg.caR()) {
                    this.gYf.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_achievement_unwear_mark);
                    this.gYf.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.gYg.caS()) {
                    this.gYf.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_achievement_unwear_mark);
                    this.gYf.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.gYf.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_achievement_unwear_mark);
                    this.gYf.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.gYg.caR()) {
                    this.gYf.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_achievement_wear_mark);
                    this.gYf.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.gYg.caS()) {
                    this.gYf.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_achievement_wear_mark);
                    this.gYf.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gYf.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_achievement_wear_mark);
                    this.gYf.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.gYg.caR()) {
                    this.gYf.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_enter_effect_tdou_buy);
                    this.gYf.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.gYg.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.gYf.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.gYg.caS()) {
                    this.gYf.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.gYf.setTextSize(0, gXX);
                    this.gYf.setText(R.string.ala_nobility_open);
                    this.gYf.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.gYf.setBackgroundResource(R.drawable.transparent_bg);
                    this.gYf.setTextSize(0, bba);
                    this.gYf.setText(R.string.ala_achievement_mark_status_expired);
                    this.gYf.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.gYf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gYg.caN() == 0 || 3 == a.this.gYg.caN()) {
                    if (a.this.gYg.caR()) {
                        if (a.this.gYg.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.gYp != null) {
                                a.this.gYp.ev(a.this.gYg.price);
                            }
                        } else if (a.this.gYq != null) {
                            a.this.gYq.k(a.this.gYg.caK(), a.this.gYg.propId, false);
                        }
                    } else if (!a.this.gYg.caS()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.gYg.caJ() || 2 != a.this.gYg.caN()) {
                    a.this.caG();
                } else {
                    a.this.caF();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caE() {
        if (this.gYg.caN() == 1 || this.gYg.caN() == 2) {
            this.gYm.setVisibility(0);
            this.gYm.setText(this.gYg.caQ());
            return;
        }
        this.gYm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.ie(false);
        aVar.nD(R.string.ala_achievement_ops_alert_title);
        aVar.nE(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.gYf.setEnabled(false);
                a.this.caG();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caG() {
        if (1 == this.gYg.caN()) {
            this.gYi.w(false, this.gYg.caK());
        } else if (2 == this.gYg.caN()) {
            this.gYi.w(true, this.gYg.caK());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.gYh = null;
    }

    public void onDestroy() {
        if (this.gYi != null) {
            this.gYi.onDestroy();
        }
    }
}
