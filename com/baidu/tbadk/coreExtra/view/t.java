package com.baidu.tbadk.coreExtra.view;

import android.app.Dialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    private BaseActivity<?> UG;
    private View Ux = null;
    private Dialog Uy = null;
    private EditText Uz = null;
    private RadioGroup Ac = null;
    private CompoundButton.OnCheckedChangeListener UB = null;
    private RadioButton UC = null;
    private RadioButton UD = null;
    private RadioButton UE = null;
    private Button UF = null;
    private Button UH = null;
    private aa UI = null;
    private z UJ = null;
    private TextView UK = null;
    private Button mConfirm = null;
    private ProgressBar UL = null;
    private ProgressBar UM = null;
    private TextView UN = null;
    private String UO = null;
    private AccountData QC = null;
    private y UQ = null;
    private y UR = null;

    public t(BaseActivity<?> baseActivity) {
        this.UG = null;
        this.UG = baseActivity;
    }

    public void setPhone(String str) {
        this.UO = str;
    }

    public void g(AccountData accountData) {
        this.QC = accountData;
    }

    public void a(y yVar) {
        this.UQ = yVar;
    }

    public void tD() {
        if (this.Uy == null) {
            this.Ux = com.baidu.adp.lib.g.b.ei().inflate(this.UG.getPageContext().getPageActivity(), com.baidu.tieba.x.main_input_username, null);
            this.Uz = (EditText) this.Ux.findViewById(com.baidu.tieba.w.account);
            this.Uz.setHint(String.valueOf(this.UG.getPageContext().getString(com.baidu.tieba.z.input_name)) + ":");
            this.UF = (Button) this.Ux.findViewById(com.baidu.tieba.w.back);
            this.UF.setOnClickListener(new u(this));
            this.UH = (Button) this.Ux.findViewById(com.baidu.tieba.w.check_username);
            this.UH.setOnClickListener(new v(this));
            this.UL = (ProgressBar) this.Ux.findViewById(com.baidu.tieba.w.check_progress);
            this.mConfirm = (Button) this.Ux.findViewById(com.baidu.tieba.w.confirm);
            this.mConfirm.setOnClickListener(new w(this));
            this.UM = (ProgressBar) this.Ux.findViewById(com.baidu.tieba.w.confirm_progress);
            this.UK = (TextView) this.Ux.findViewById(com.baidu.tieba.w.error_info);
            this.Ac = (RadioGroup) this.Ux.findViewById(com.baidu.tieba.w.names_group);
            this.UC = (RadioButton) this.Ux.findViewById(com.baidu.tieba.w.name1);
            this.UD = (RadioButton) this.Ux.findViewById(com.baidu.tieba.w.name2);
            this.UE = (RadioButton) this.Ux.findViewById(com.baidu.tieba.w.name3);
            this.UB = new x(this);
            this.UC.setOnCheckedChangeListener(this.UB);
            this.UD.setOnCheckedChangeListener(this.UB);
            this.UE.setOnCheckedChangeListener(this.UB);
            this.UN = (TextView) this.Ux.findViewById(com.baidu.tieba.w.phone_info);
            tF();
            this.Uy = new Dialog(this.UG.getPageContext().getPageActivity(), com.baidu.tieba.aa.input_username_dialog);
            this.Uy.setCanceledOnTouchOutside(false);
            this.Uy.getWindow().setSoftInputMode(20);
            this.Uy.setCancelable(false);
            this.Uy.setCanceledOnTouchOutside(false);
        }
        if (!this.Uy.isShowing()) {
            this.Uz.setText((CharSequence) null);
            tF();
            dE(null);
            if (this.UO == null || this.UO.length() <= 0) {
                this.UN.setText("Hi," + this.UG.getPageContext().getString(com.baidu.tieba.z.bar_friend));
            } else {
                this.UN.setText("Hi," + this.UO);
            }
            if (!this.UG.isFinishing()) {
                com.baidu.adp.lib.g.k.a(this.Uy, this.UG.getPageContext());
                this.Uy.setContentView(this.Ux);
                WindowManager.LayoutParams attributes = this.Uy.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -1;
                this.Uy.getWindow().setAttributes(attributes);
                this.UG.ShowSoftKeyPadDelay(this.Uz, 150);
                this.Uz.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE() {
        if (this.UR != null) {
            this.UR.f(null);
        }
    }

    public void u(ArrayList<String> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.Ac.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.UC.setText(arrayList.get(0));
                this.UC.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.UD.setText(arrayList.get(1));
                this.UD.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.UE.setText(arrayList.get(2));
                this.UE.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.UI != null) {
            this.UI.cancel();
            this.UI = null;
        }
        if (this.UJ != null) {
            this.UJ.cancel();
            this.UJ = null;
        }
        tG();
    }

    public boolean isShowing() {
        return this.Uy != null && this.Uy.isShowing();
    }

    public void tF() {
        this.Ac.setVisibility(8);
        this.Ac.clearCheck();
        this.UC.setVisibility(8);
        this.UD.setVisibility(8);
        this.UE.setVisibility(8);
        this.UC.setChecked(false);
        this.UD.setChecked(false);
        this.UE.setChecked(false);
    }

    public void tG() {
        if (this.Uy != null && this.Uy.isShowing()) {
            com.baidu.adp.lib.g.k.b(this.Uy, this.UG.getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(String str) {
        if (str == null) {
            this.UK.setVisibility(8);
            this.UK.setText((CharSequence) null);
            return;
        }
        this.UK.setVisibility(0);
        this.UK.setText(str);
    }
}
