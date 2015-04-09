package com.baidu.tbadk.coreExtra.view;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    private TbPageContext<?> LP;
    private View aeI = null;
    private Dialog aeJ = null;
    private EditText aeK = null;
    private View aeL = null;
    private View aeM = null;
    private RadioGroup aeN = null;
    private RadioGroup aeO = null;
    private CompoundButton.OnCheckedChangeListener aeP = null;
    private RadioButton aeQ = null;
    private RadioButton aeR = null;
    private RadioButton aeS = null;
    private TextView aeT = null;
    private z aeU = null;
    private y aeV = null;
    private TextView aeW = null;
    private TextView aeX = null;
    private ProgressBar aeY = null;
    private TextView aeZ = null;
    private TextView afa = null;
    private String afb = null;
    private AccountData afc = null;
    private x afd = null;
    private x afe = null;
    private Drawable aff;
    private Drawable afg;
    private int size;

    public t(TbPageContext<?> tbPageContext) {
        this.LP = null;
        this.aff = null;
        this.afg = null;
        this.size = 0;
        this.LP = tbPageContext;
        this.aff = ba.getDrawable(com.baidu.tieba.u.icon_tips_names_s);
        this.afg = ba.getDrawable(com.baidu.tieba.u.icon_tips_names_n);
        this.size = this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
        this.aff.setBounds(0, 0, this.size, this.size);
        this.afg.setBounds(0, 0, this.size, this.size);
    }

    public void setPhone(String str) {
        this.afb = str;
    }

    public void k(AccountData accountData) {
        this.afc = accountData;
    }

    public void a(x xVar) {
        this.afd = xVar;
    }

    public void xc() {
        if (this.aeJ == null) {
            this.aeI = com.baidu.adp.lib.g.b.hH().inflate(this.LP.getPageActivity(), com.baidu.tieba.w.main_input_username, null);
            this.aeK = (EditText) this.aeI.findViewById(com.baidu.tieba.v.account);
            this.aeK.setHint(this.LP.getString(com.baidu.tieba.y.input_alias_limit_length_tip));
            this.aeT = (TextView) this.aeI.findViewById(com.baidu.tieba.v.back);
            this.aeT.setOnClickListener(new u(this));
            this.aeX = (TextView) this.aeI.findViewById(com.baidu.tieba.v.confirm);
            this.aeX.setOnClickListener(new v(this));
            this.aeY = (ProgressBar) this.aeI.findViewById(com.baidu.tieba.v.confirm_progress);
            this.aeW = (TextView) this.aeI.findViewById(com.baidu.tieba.v.error_info);
            this.aeN = (RadioGroup) this.aeI.findViewById(com.baidu.tieba.v.names_group1);
            this.aeO = (RadioGroup) this.aeI.findViewById(com.baidu.tieba.v.names_group2);
            this.aeQ = (RadioButton) this.aeI.findViewById(com.baidu.tieba.v.name1);
            this.aeR = (RadioButton) this.aeI.findViewById(com.baidu.tieba.v.name2);
            this.aeS = (RadioButton) this.aeI.findViewById(com.baidu.tieba.v.name3);
            this.aeP = new w(this);
            this.aeQ.setOnCheckedChangeListener(this.aeP);
            this.aeR.setOnCheckedChangeListener(this.aeP);
            this.aeS.setOnCheckedChangeListener(this.aeP);
            this.aeZ = (TextView) this.aeI.findViewById(com.baidu.tieba.v.phone_info);
            this.afa = (TextView) this.aeI.findViewById(com.baidu.tieba.v.tip_info);
            this.aeL = this.aeI.findViewById(com.baidu.tieba.v.divider_under_account);
            this.aeM = this.aeI.findViewById(com.baidu.tieba.v.divider_under_radiongroup);
            xf();
            this.aeJ = new Dialog(this.LP.getPageActivity(), com.baidu.tieba.z.input_username_dialog);
            this.aeJ.setCanceledOnTouchOutside(false);
            this.aeJ.setCancelable(false);
            this.aeJ.setCanceledOnTouchOutside(false);
            oq();
        }
        if (!this.aeJ.isShowing()) {
            this.aeK.setText((CharSequence) null);
            xf();
            dQ(null);
            if (this.afb == null || this.afb.length() <= 0) {
                this.aeZ.setText("Hi," + this.LP.getString(com.baidu.tieba.y.bar_friend));
            } else {
                this.aeZ.setText("Hi," + this.afb);
            }
            if (!this.LP.getPageActivity().isFinishing()) {
                this.aeJ.setContentView(this.aeI);
                com.baidu.adp.lib.g.k.a(this.aeJ, this.LP);
                if (this.LP.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.LP.getOrignalPage()).ShowSoftKeyPadDelay(this.aeK, 150);
                }
            }
        }
    }

    public void xd() {
        String editable = this.aeK.getText().toString();
        if (editable == null || editable.length() <= 0) {
            dQ(this.LP.getString(com.baidu.tieba.y.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            dQ(this.LP.getString(com.baidu.tieba.y.input_alias_limit_length_tip));
        } else {
            if (this.aeV != null) {
                this.aeV.cancel();
            }
            if (this.aeU == null) {
                this.aeU = new z(this, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.aeU.setPriority(3);
                this.aeU.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe() {
        if (this.afe != null) {
            this.afe.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            dQ(this.LP.getString(com.baidu.tieba.y.suggest_no_name));
            return;
        }
        dQ(this.LP.getString(com.baidu.tieba.y.suggest_some_names));
        int size = arrayList.size();
        this.aeN.clearCheck();
        this.aeO.clearCheck();
        this.aeN.setVisibility(0);
        this.aeO.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aeQ.setText(arrayList.get(0));
            this.aeQ.setChecked(false);
            this.aeQ.setCompoundDrawables(this.afg, null, null, null);
            this.aeQ.setVisibility(0);
            this.aeN.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aeR.setText(arrayList.get(1));
            this.aeR.setChecked(false);
            this.aeR.setCompoundDrawables(this.afg, null, null, null);
            this.aeR.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aeS.setText(arrayList.get(2));
            this.aeS.setChecked(false);
            this.aeS.setCompoundDrawables(this.afg, null, null, null);
            this.aeS.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aeU != null) {
            this.aeU.cancel();
            this.aeU = null;
        }
        if (this.aeV != null) {
            this.aeV.cancel();
            this.aeV = null;
        }
        xg();
    }

    public boolean isShowing() {
        return this.aeJ != null && this.aeJ.isShowing();
    }

    public void xf() {
        this.aeN.setVisibility(8);
        this.aeN.clearCheck();
        this.aeO.setVisibility(8);
        this.aeO.clearCheck();
        this.aeQ.setVisibility(8);
        this.aeR.setVisibility(8);
        this.aeS.setVisibility(8);
        this.aeQ.setChecked(false);
        this.aeR.setChecked(false);
        this.aeS.setChecked(false);
    }

    public void xg() {
        if (this.aeJ != null && this.aeJ.isShowing()) {
            com.baidu.adp.lib.g.k.b(this.aeJ, this.LP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(String str) {
        if (str == null) {
            this.aeW.setVisibility(4);
            this.aeW.setText((CharSequence) null);
            return;
        }
        this.aeW.setVisibility(0);
        this.aeW.setText(str);
    }

    public void oq() {
        ba.i(this.aeI, com.baidu.tieba.u.bg_dailog);
        ba.b(this.aeZ, com.baidu.tieba.s.cp_cont_b, 1);
        ba.b(this.afa, com.baidu.tieba.s.cp_cont_f, 1);
        ba.b(this.aeK, com.baidu.tieba.s.cp_cont_b, 2);
        this.aeK.setHintTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_e));
        ba.i(this.aeL, com.baidu.tieba.u.bg_search_input);
        ba.j(this.aeM, com.baidu.tieba.s.cp_bg_line_b);
        ba.b(this.aeW, com.baidu.tieba.s.cp_cont_h, 1);
        ba.b(this.aeQ, com.baidu.tieba.s.cp_cont_b, 3);
        ba.b(this.aeR, com.baidu.tieba.s.cp_cont_b, 3);
        ba.b(this.aeS, com.baidu.tieba.s.cp_cont_b, 3);
        ba.b(this.aeT, com.baidu.tieba.s.cp_cont_b, 1);
        ba.i((View) this.aeT, com.baidu.tieba.u.btn_dialog_cancel);
        ba.b(this.aeX, com.baidu.tieba.s.cp_cont_b, 1);
        ba.i((View) this.aeX, com.baidu.tieba.u.btn_dialog_cancel);
        this.aeQ.setCompoundDrawables(this.afg, null, null, null);
        this.aeR.setCompoundDrawables(this.afg, null, null, null);
        this.aeS.setCompoundDrawables(this.afg, null, null, null);
    }
}
