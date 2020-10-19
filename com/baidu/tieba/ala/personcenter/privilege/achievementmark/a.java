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
    private static final int beK = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int hmY = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView hmZ;
    private FrameLayout hna;
    private TextView hnb;
    private RelativeLayout hnc;
    private TextView hnd;
    private TextView hne;
    private MarkLevelGroup hnf;
    private TextView hng;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b hnh;
    private d hni;
    private AlaUpdateMarkStatusModel hnj;
    private InterfaceC0668a hnk;
    private LinearLayout hnl;
    private TextView hnm;
    private TextView hnn;
    private LinearLayout hno;
    private TextView hnp;
    private com.baidu.tieba.ala.personcenter.privilege.b hnq;
    private com.baidu.tieba.ala.personcenter.privilege.a hnr;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0668a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0668a interfaceC0668a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.hnk = interfaceC0668a;
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
        IF();
    }

    private void IF() {
        this.hnj = new AlaUpdateMarkStatusModel(getContext());
        this.hnj.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.hng.setEnabled(true);
                if (z) {
                    if (a.this.hnk != null) {
                        a.this.hnk.a(true, a.this.hnh);
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
        this.hnq = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.hnq.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void ny(boolean z) {
                if (z && a.this.hnh.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.ceb();
                    a.this.cec();
                    a.this.cea();
                }
            }
        });
        this.hnr = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0667a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0667a
            public void p(boolean z, String str) {
                if (z) {
                    if (a.this.hnh != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.hnk != null) {
                            a.this.hnk.a(true, a.this.hnh);
                        }
                        a.this.hnh.vS(2);
                        a.this.ceb();
                        a.this.cec();
                        a.this.cea();
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
                if (a.this.hnk != null) {
                    a.this.hnk.a(false, a.this.hnh);
                }
                a.this.dismiss();
            }
        });
        this.hmZ = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.hmZ.setDefaultBgResource(R.color.transparent);
        this.hmZ.setDefaultResource(R.drawable.pic_live_honor);
        this.hmZ.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.hna = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.hnb = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.hnc = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.hnd = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.hne = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.hnf = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.hnf.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void ev(String str, String str2) {
                a.this.eu(str, str2);
            }
        });
        this.hng = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.hnn = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.hnl = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.hnm = (TextView) findViewById(R.id.mark_tdou_price);
        this.hno = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.hnp = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cea() {
        this.hnd.setVisibility(4);
        this.hne.setVisibility(4);
        this.hnl.setVisibility(4);
        this.hnf.setVisibility(4);
        this.hno.setVisibility(8);
        if (this.hnh.cep()) {
            this.hnl.setVisibility(0);
            this.hno.setVisibility(0);
            this.hnm.setText(AlaStringHelper.formatLowercasekDou(this.hnh.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.hnp.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.hnp.setCompoundDrawables(drawable, null, null, null);
            this.hnp.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.hnh.cel() == 1) {
                this.hno.setVisibility(8);
            }
        } else if (this.hnh.ceq()) {
            this.hnd.setVisibility(0);
            this.hnd.setText(this.hnh.getDescription());
        } else {
            this.hnf.setVisibility(0);
            this.hnd.setVisibility(0);
            this.hne.setVisibility(0);
            this.hnd.setText(this.hnh.getDescription());
            this.hne.setText(this.hnh.cem());
            this.hnf.c(this.hnh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.hmZ.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.hmZ.startLoad(str, 10, false);
        }
        this.hnb.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceb() {
        switch (this.hnh.cel()) {
            case 0:
                if (this.hnh.cep()) {
                    this.hng.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hng.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.hnh.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hng.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hnh.ceq()) {
                    this.hng.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_nobility_open);
                    this.hng.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hng.setBackgroundResource(R.drawable.transparent_bg);
                    this.hng.setTextSize(0, beK);
                    this.hng.setText(R.string.ala_achievement_mark_status_unlock);
                    this.hng.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.hnh.cep()) {
                    this.hng.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_achievement_unwear_mark);
                    this.hng.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.hnh.ceq()) {
                    this.hng.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_achievement_unwear_mark);
                    this.hng.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.hng.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_achievement_unwear_mark);
                    this.hng.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.hnh.cep()) {
                    this.hng.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_achievement_wear_mark);
                    this.hng.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.hnh.ceq()) {
                    this.hng.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_achievement_wear_mark);
                    this.hng.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hng.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_achievement_wear_mark);
                    this.hng.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.hnh.cep()) {
                    this.hng.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hng.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.hnh.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hng.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hnh.ceq()) {
                    this.hng.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hng.setTextSize(0, hmY);
                    this.hng.setText(R.string.ala_nobility_open);
                    this.hng.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hng.setBackgroundResource(R.drawable.transparent_bg);
                    this.hng.setTextSize(0, beK);
                    this.hng.setText(R.string.ala_achievement_mark_status_expired);
                    this.hng.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.hng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hnh.cel() == 0 || 3 == a.this.hnh.cel()) {
                    if (a.this.hnh.cep()) {
                        if (a.this.hnh.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.hnq != null) {
                                a.this.hnq.eM(a.this.hnh.price);
                            }
                        } else if (a.this.hnr != null) {
                            a.this.hnr.k(a.this.hnh.cei(), a.this.hnh.propId, false);
                        }
                    } else if (!a.this.hnh.ceq()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.hnh.ceh() || 2 != a.this.hnh.cel()) {
                    a.this.cee();
                } else {
                    a.this.ced();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cec() {
        if (this.hnh.cel() == 1 || this.hnh.cel() == 2) {
            this.hnn.setVisibility(0);
            this.hnn.setText(this.hnh.ceo());
            return;
        }
        this.hnn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ced() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.iA(false);
        aVar.oa(R.string.ala_achievement_ops_alert_title);
        aVar.ob(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.hng.setEnabled(false);
                a.this.cee();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cee() {
        if (1 == this.hnh.cel()) {
            this.hnj.z(false, this.hnh.cei());
        } else if (2 == this.hnh.cel()) {
            this.hnj.z(true, this.hnh.cei());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.hni = null;
    }

    public void onDestroy() {
        if (this.hnj != null) {
            this.hnj.onDestroy();
        }
    }
}
