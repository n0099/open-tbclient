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
    private TbPageContext<?> LN;
    private View aeA = null;
    private Dialog aeB = null;
    private EditText aeC = null;
    private View aeD = null;
    private View aeE = null;
    private RadioGroup aeF = null;
    private RadioGroup aeG = null;
    private CompoundButton.OnCheckedChangeListener aeH = null;
    private RadioButton aeI = null;
    private RadioButton aeJ = null;
    private RadioButton aeK = null;
    private TextView aeL = null;
    private z aeM = null;
    private y aeN = null;
    private TextView aeO = null;
    private TextView aeP = null;
    private ProgressBar aeQ = null;
    private TextView aeR = null;
    private TextView aeS = null;
    private String aeT = null;
    private AccountData aeU = null;
    private x aeV = null;
    private x aeW = null;
    private Drawable aeX;
    private Drawable aeY;
    private int size;

    public t(TbPageContext<?> tbPageContext) {
        this.LN = null;
        this.aeX = null;
        this.aeY = null;
        this.size = 0;
        this.LN = tbPageContext;
        this.aeX = ba.getDrawable(com.baidu.tieba.u.icon_tips_names_s);
        this.aeY = ba.getDrawable(com.baidu.tieba.u.icon_tips_names_n);
        this.size = this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26);
        this.aeX.setBounds(0, 0, this.size, this.size);
        this.aeY.setBounds(0, 0, this.size, this.size);
    }

    public void setPhone(String str) {
        this.aeT = str;
    }

    public void k(AccountData accountData) {
        this.aeU = accountData;
    }

    public void a(x xVar) {
        this.aeV = xVar;
    }

    public void wW() {
        if (this.aeB == null) {
            this.aeA = com.baidu.adp.lib.g.b.hH().inflate(this.LN.getPageActivity(), com.baidu.tieba.w.main_input_username, null);
            this.aeC = (EditText) this.aeA.findViewById(com.baidu.tieba.v.account);
            this.aeC.setHint(this.LN.getString(com.baidu.tieba.y.input_alias_limit_length_tip));
            this.aeL = (TextView) this.aeA.findViewById(com.baidu.tieba.v.back);
            this.aeL.setOnClickListener(new u(this));
            this.aeP = (TextView) this.aeA.findViewById(com.baidu.tieba.v.confirm);
            this.aeP.setOnClickListener(new v(this));
            this.aeQ = (ProgressBar) this.aeA.findViewById(com.baidu.tieba.v.confirm_progress);
            this.aeO = (TextView) this.aeA.findViewById(com.baidu.tieba.v.error_info);
            this.aeF = (RadioGroup) this.aeA.findViewById(com.baidu.tieba.v.names_group1);
            this.aeG = (RadioGroup) this.aeA.findViewById(com.baidu.tieba.v.names_group2);
            this.aeI = (RadioButton) this.aeA.findViewById(com.baidu.tieba.v.name1);
            this.aeJ = (RadioButton) this.aeA.findViewById(com.baidu.tieba.v.name2);
            this.aeK = (RadioButton) this.aeA.findViewById(com.baidu.tieba.v.name3);
            this.aeH = new w(this);
            this.aeI.setOnCheckedChangeListener(this.aeH);
            this.aeJ.setOnCheckedChangeListener(this.aeH);
            this.aeK.setOnCheckedChangeListener(this.aeH);
            this.aeR = (TextView) this.aeA.findViewById(com.baidu.tieba.v.phone_info);
            this.aeS = (TextView) this.aeA.findViewById(com.baidu.tieba.v.tip_info);
            this.aeD = this.aeA.findViewById(com.baidu.tieba.v.divider_under_account);
            this.aeE = this.aeA.findViewById(com.baidu.tieba.v.divider_under_radiongroup);
            wZ();
            this.aeB = new Dialog(this.LN.getPageActivity(), com.baidu.tieba.z.input_username_dialog);
            this.aeB.setCanceledOnTouchOutside(false);
            this.aeB.setCancelable(false);
            this.aeB.setCanceledOnTouchOutside(false);
            oq();
        }
        if (!this.aeB.isShowing()) {
            this.aeC.setText((CharSequence) null);
            wZ();
            dN(null);
            if (this.aeT == null || this.aeT.length() <= 0) {
                this.aeR.setText("Hi," + this.LN.getString(com.baidu.tieba.y.bar_friend));
            } else {
                this.aeR.setText("Hi," + this.aeT);
            }
            if (!this.LN.getPageActivity().isFinishing()) {
                this.aeB.setContentView(this.aeA);
                com.baidu.adp.lib.g.k.a(this.aeB, this.LN);
                if (this.LN.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.LN.getOrignalPage()).ShowSoftKeyPadDelay(this.aeC, 150);
                }
            }
        }
    }

    public void wX() {
        String editable = this.aeC.getText().toString();
        if (editable == null || editable.length() <= 0) {
            dN(this.LN.getString(com.baidu.tieba.y.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            dN(this.LN.getString(com.baidu.tieba.y.input_alias_limit_length_tip));
        } else {
            if (this.aeN != null) {
                this.aeN.cancel();
            }
            if (this.aeM == null) {
                this.aeM = new z(this, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.aeM.setPriority(3);
                this.aeM.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY() {
        if (this.aeW != null) {
            this.aeW.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            dN(this.LN.getString(com.baidu.tieba.y.suggest_no_name));
            return;
        }
        dN(this.LN.getString(com.baidu.tieba.y.suggest_some_names));
        int size = arrayList.size();
        this.aeF.clearCheck();
        this.aeG.clearCheck();
        this.aeF.setVisibility(0);
        this.aeG.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aeI.setText(arrayList.get(0));
            this.aeI.setChecked(false);
            this.aeI.setCompoundDrawables(this.aeY, null, null, null);
            this.aeI.setVisibility(0);
            this.aeF.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aeJ.setText(arrayList.get(1));
            this.aeJ.setChecked(false);
            this.aeJ.setCompoundDrawables(this.aeY, null, null, null);
            this.aeJ.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aeK.setText(arrayList.get(2));
            this.aeK.setChecked(false);
            this.aeK.setCompoundDrawables(this.aeY, null, null, null);
            this.aeK.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aeM != null) {
            this.aeM.cancel();
            this.aeM = null;
        }
        if (this.aeN != null) {
            this.aeN.cancel();
            this.aeN = null;
        }
        xa();
    }

    public boolean isShowing() {
        return this.aeB != null && this.aeB.isShowing();
    }

    public void wZ() {
        this.aeF.setVisibility(8);
        this.aeF.clearCheck();
        this.aeG.setVisibility(8);
        this.aeG.clearCheck();
        this.aeI.setVisibility(8);
        this.aeJ.setVisibility(8);
        this.aeK.setVisibility(8);
        this.aeI.setChecked(false);
        this.aeJ.setChecked(false);
        this.aeK.setChecked(false);
    }

    public void xa() {
        if (this.aeB != null && this.aeB.isShowing()) {
            com.baidu.adp.lib.g.k.b(this.aeB, this.LN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(String str) {
        if (str == null) {
            this.aeO.setVisibility(4);
            this.aeO.setText((CharSequence) null);
            return;
        }
        this.aeO.setVisibility(0);
        this.aeO.setText(str);
    }

    public void oq() {
        ba.i(this.aeA, com.baidu.tieba.u.bg_dailog);
        ba.b(this.aeR, com.baidu.tieba.s.cp_cont_b, 1);
        ba.b(this.aeS, com.baidu.tieba.s.cp_cont_f, 1);
        ba.b(this.aeC, com.baidu.tieba.s.cp_cont_b, 2);
        this.aeC.setHintTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_e));
        ba.i(this.aeD, com.baidu.tieba.u.bg_search_input);
        ba.j(this.aeE, com.baidu.tieba.s.cp_bg_line_b);
        ba.b(this.aeO, com.baidu.tieba.s.cp_cont_h, 1);
        ba.b(this.aeI, com.baidu.tieba.s.cp_cont_b, 3);
        ba.b(this.aeJ, com.baidu.tieba.s.cp_cont_b, 3);
        ba.b(this.aeK, com.baidu.tieba.s.cp_cont_b, 3);
        ba.b(this.aeL, com.baidu.tieba.s.cp_cont_b, 1);
        ba.i((View) this.aeL, com.baidu.tieba.u.btn_dialog_cancel);
        ba.b(this.aeP, com.baidu.tieba.s.cp_cont_b, 1);
        ba.i((View) this.aeP, com.baidu.tieba.u.btn_dialog_cancel);
        this.aeI.setCompoundDrawables(this.aeY, null, null, null);
        this.aeJ.setCompoundDrawables(this.aeY, null, null, null);
        this.aeK.setCompoundDrawables(this.aeY, null, null, null);
    }
}
