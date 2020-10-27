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
    private static final int bga = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final int hyT = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
    private TbImageView hyU;
    private FrameLayout hyV;
    private TextView hyW;
    private RelativeLayout hyX;
    private TextView hyY;
    private TextView hyZ;
    private MarkLevelGroup hza;
    private TextView hzb;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b hzc;
    private d hzd;
    private AlaUpdateMarkStatusModel hze;
    private InterfaceC0684a hzf;
    private LinearLayout hzg;
    private TextView hzh;
    private TextView hzi;
    private LinearLayout hzj;
    private TextView hzk;
    private com.baidu.tieba.ala.personcenter.privilege.b hzl;
    private com.baidu.tieba.ala.personcenter.privilege.a hzm;
    private TbPageContext mPageContext;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0684a {
        void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext tbPageContext, InterfaceC0684a interfaceC0684a) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.hzf = interfaceC0684a;
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
        IY();
    }

    private void IY() {
        this.hze = new AlaUpdateMarkStatusModel(getContext());
        this.hze.a(new AlaUpdateMarkStatusModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.a
            public void onResult(boolean z, String str) {
                a.this.hzb.setEnabled(true);
                if (z) {
                    if (a.this.hzf != null) {
                        a.this.hzf.a(true, a.this.hzc);
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
        this.hzl = new com.baidu.tieba.ala.personcenter.privilege.b(this.mPageContext);
        this.hzl.a(new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.2
            @Override // com.baidu.tieba.ala.personcenter.privilege.b.a
            public void nP(boolean z) {
                if (z && a.this.hzc.price <= TbadkCoreApplication.getInst().currentAccountTdouNum) {
                    a.this.chd();
                    a.this.che();
                    a.this.chc();
                }
            }
        });
        this.hzm = new com.baidu.tieba.ala.personcenter.privilege.a(this.mPageContext, new a.InterfaceC0683a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.3
            @Override // com.baidu.tieba.ala.personcenter.privilege.a.InterfaceC0683a
            public void r(boolean z, String str) {
                if (z) {
                    if (a.this.hzc != null) {
                        a.this.mPageContext.showToast(R.string.ala_achievement_tdou_buy_success);
                        if (a.this.hzf != null) {
                            a.this.hzf.a(true, a.this.hzc);
                        }
                        a.this.hzc.wm(2);
                        a.this.chd();
                        a.this.che();
                        a.this.chc();
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
                if (a.this.hzf != null) {
                    a.this.hzf.a(false, a.this.hzc);
                }
                a.this.dismiss();
            }
        });
        this.hyU = (TbImageView) this.mRootView.findViewById(R.id.mark_img);
        this.hyU.setDefaultBgResource(R.color.transparent);
        this.hyU.setDefaultResource(R.drawable.pic_live_honor);
        this.hyU.setDefaultErrorResource(R.drawable.pic_live_honor);
        this.hyV = (FrameLayout) this.mRootView.findViewById(R.id.mark_img_layout);
        this.hyW = (TextView) this.mRootView.findViewById(R.id.mark_title);
        this.hyX = (RelativeLayout) this.mRootView.findViewById(R.id.mark_desc_layout);
        this.hyY = (TextView) this.mRootView.findViewById(R.id.mark_desc);
        this.hyZ = (TextView) this.mRootView.findViewById(R.id.mark_upgrade_desc);
        this.hza = (MarkLevelGroup) this.mRootView.findViewById(R.id.mark_level_view);
        this.hza.setCallback(new MarkLevelGroup.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.5
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.MarkLevelGroup.a
            public void eA(String str, String str2) {
                a.this.ez(str, str2);
            }
        });
        this.hzb = (TextView) this.mRootView.findViewById(R.id.mark_ops_btn);
        this.hzi = (TextView) this.mRootView.findViewById(R.id.mark_limit_time);
        this.hzg = (LinearLayout) findViewById(R.id.mark_tdou_layout);
        this.hzh = (TextView) findViewById(R.id.mark_tdou_price);
        this.hzj = (LinearLayout) findViewById(R.id.user_tdou_layout);
        this.hzk = (TextView) findViewById(R.id.user_tdou_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chc() {
        this.hyY.setVisibility(4);
        this.hyZ.setVisibility(4);
        this.hzg.setVisibility(4);
        this.hza.setVisibility(4);
        this.hzj.setVisibility(8);
        if (this.hzc.chr()) {
            this.hzg.setVisibility(0);
            this.hzj.setVisibility(0);
            this.hzh.setText(AlaStringHelper.formatLowercasekDou(this.hzc.price));
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.hzk.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.ds4));
            this.hzk.setCompoundDrawables(drawable, null, null, null);
            this.hzk.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
            if (this.hzc.chn() == 1) {
                this.hzj.setVisibility(8);
            }
        } else if (this.hzc.chs()) {
            this.hyY.setVisibility(0);
            this.hyY.setText(this.hzc.getDescription());
        } else {
            this.hza.setVisibility(0);
            this.hyY.setVisibility(0);
            this.hyZ.setVisibility(0);
            this.hyY.setText(this.hzc.getDescription());
            this.hyZ.setText(this.hzc.cho());
            this.hza.c(this.hzc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(String str, String str2) {
        if (StringUtils.isNull(str)) {
            this.hyU.startLoad(String.valueOf(R.drawable.pic_live_honor), 24, false);
        } else {
            this.hyU.startLoad(str, 10, false);
        }
        this.hyW.setText(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chd() {
        switch (this.hzc.chn()) {
            case 0:
                if (this.hzc.chr()) {
                    this.hzb.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hzb.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.hzc.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hzb.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hzc.chs()) {
                    this.hzb.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_nobility_open);
                    this.hzb.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hzb.setBackgroundResource(R.drawable.transparent_bg);
                    this.hzb.setTextSize(0, bga);
                    this.hzb.setText(R.string.ala_achievement_mark_status_unlock);
                    this.hzb.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
            case 1:
                if (this.hzc.chr()) {
                    this.hzb.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_achievement_unwear_mark);
                    this.hzb.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else if (this.hzc.chs()) {
                    this.hzb.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_achievement_unwear_mark);
                    this.hzb.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                } else {
                    this.hzb.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_achievement_unwear_mark);
                    this.hzb.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    break;
                }
            case 2:
                if (this.hzc.chr()) {
                    this.hzb.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_achievement_wear_mark);
                    this.hzb.setTextColor(getContext().getResources().getColorStateList(R.color.cp_bg_line_d));
                    break;
                } else if (this.hzc.chs()) {
                    this.hzb.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_achievement_wear_mark);
                    this.hzb.setTextColor(getContext().getResources().getColorStateList(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hzb.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_achievement_wear_mark);
                    this.hzb.setTextColor(getContext().getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                    break;
                }
            case 3:
                if (this.hzc.chr()) {
                    this.hzb.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_enter_effect_tdou_buy);
                    this.hzb.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
                    if (this.hzc.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                        this.hzb.setText(R.string.ala_achievement_get_tdou_label);
                        break;
                    }
                } else if (this.hzc.chs()) {
                    this.hzb.setBackgroundResource(R.drawable.ala_nobility_bottom_btn_bg);
                    this.hzb.setTextSize(0, hyT);
                    this.hzb.setText(R.string.ala_nobility_open);
                    this.hzb.setTextColor(getContext().getResources().getColor(R.color.ala_nobility_bottom_btn_color));
                    break;
                } else {
                    this.hzb.setBackgroundResource(R.drawable.transparent_bg);
                    this.hzb.setTextSize(0, bga);
                    this.hzb.setText(R.string.ala_achievement_mark_status_expired);
                    this.hzb.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d_alpha60));
                    break;
                }
                break;
        }
        this.hzb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hzc.chn() == 0 || 3 == a.this.hzc.chn()) {
                    if (a.this.hzc.chr()) {
                        if (a.this.hzc.price > TbadkCoreApplication.getInst().currentAccountTdouNum) {
                            if (a.this.hzl != null) {
                                a.this.hzl.eN(a.this.hzc.price);
                            }
                        } else if (a.this.hzm != null) {
                            a.this.hzm.k(a.this.hzc.chk(), a.this.hzc.propId, false);
                        }
                    } else if (!a.this.hzc.chs()) {
                        a.this.dismiss();
                    }
                } else if (!a.this.hzc.chj() || 2 != a.this.hzc.chn()) {
                    a.this.chg();
                } else {
                    a.this.chf();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void che() {
        if (this.hzc.chn() == 1 || this.hzc.chn() == 2) {
            this.hzi.setVisibility(0);
            this.hzi.setText(this.hzc.chq());
            return;
        }
        this.hzi.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.setMessageShowCenter(true);
        aVar.iN(false);
        aVar.ol(R.string.ala_achievement_ops_alert_title);
        aVar.om(R.string.ala_achievement_ops_alert_content);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                a.this.hzb.setEnabled(false);
                a.this.chg();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mPageContext).bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chg() {
        if (1 == this.hzc.chn()) {
            this.hze.z(false, this.hzc.chk());
        } else if (2 == this.hzc.chn()) {
            this.hze.z(true, this.hzc.chk());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.hzd = null;
    }

    public void onDestroy() {
        if (this.hze != null) {
            this.hze.onDestroy();
        }
    }
}
