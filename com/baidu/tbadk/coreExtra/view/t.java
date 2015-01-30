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
    private BaseActivity<?> UJ;
    private View UB = null;
    private Dialog UC = null;
    private EditText UD = null;
    private RadioGroup Ag = null;
    private CompoundButton.OnCheckedChangeListener UE = null;
    private RadioButton UF = null;
    private RadioButton UG = null;
    private RadioButton UH = null;
    private Button UI = null;
    private Button UK = null;
    private aa UL = null;
    private z UM = null;
    private TextView UN = null;
    private Button mConfirm = null;
    private ProgressBar UO = null;
    private ProgressBar UQ = null;
    private TextView UR = null;
    private String US = null;
    private AccountData QF = null;
    private y UT = null;
    private y UU = null;

    public t(BaseActivity<?> baseActivity) {
        this.UJ = null;
        this.UJ = baseActivity;
    }

    public void setPhone(String str) {
        this.US = str;
    }

    public void g(AccountData accountData) {
        this.QF = accountData;
    }

    public void a(y yVar) {
        this.UT = yVar;
    }

    public void tJ() {
        if (this.UC == null) {
            this.UB = com.baidu.adp.lib.g.b.ei().inflate(this.UJ.getPageContext().getPageActivity(), com.baidu.tieba.x.main_input_username, null);
            this.UD = (EditText) this.UB.findViewById(com.baidu.tieba.w.account);
            this.UD.setHint(String.valueOf(this.UJ.getPageContext().getString(com.baidu.tieba.z.input_name)) + ":");
            this.UI = (Button) this.UB.findViewById(com.baidu.tieba.w.back);
            this.UI.setOnClickListener(new u(this));
            this.UK = (Button) this.UB.findViewById(com.baidu.tieba.w.check_username);
            this.UK.setOnClickListener(new v(this));
            this.UO = (ProgressBar) this.UB.findViewById(com.baidu.tieba.w.check_progress);
            this.mConfirm = (Button) this.UB.findViewById(com.baidu.tieba.w.confirm);
            this.mConfirm.setOnClickListener(new w(this));
            this.UQ = (ProgressBar) this.UB.findViewById(com.baidu.tieba.w.confirm_progress);
            this.UN = (TextView) this.UB.findViewById(com.baidu.tieba.w.error_info);
            this.Ag = (RadioGroup) this.UB.findViewById(com.baidu.tieba.w.names_group);
            this.UF = (RadioButton) this.UB.findViewById(com.baidu.tieba.w.name1);
            this.UG = (RadioButton) this.UB.findViewById(com.baidu.tieba.w.name2);
            this.UH = (RadioButton) this.UB.findViewById(com.baidu.tieba.w.name3);
            this.UE = new x(this);
            this.UF.setOnCheckedChangeListener(this.UE);
            this.UG.setOnCheckedChangeListener(this.UE);
            this.UH.setOnCheckedChangeListener(this.UE);
            this.UR = (TextView) this.UB.findViewById(com.baidu.tieba.w.phone_info);
            tL();
            this.UC = new Dialog(this.UJ.getPageContext().getPageActivity(), com.baidu.tieba.aa.input_username_dialog);
            this.UC.setCanceledOnTouchOutside(false);
            this.UC.getWindow().setSoftInputMode(20);
            this.UC.setCancelable(false);
            this.UC.setCanceledOnTouchOutside(false);
        }
        if (!this.UC.isShowing()) {
            this.UD.setText((CharSequence) null);
            tL();
            dH(null);
            if (this.US == null || this.US.length() <= 0) {
                this.UR.setText("Hi," + this.UJ.getPageContext().getString(com.baidu.tieba.z.bar_friend));
            } else {
                this.UR.setText("Hi," + this.US);
            }
            if (!this.UJ.isFinishing()) {
                com.baidu.adp.lib.g.k.a(this.UC, this.UJ.getPageContext());
                this.UC.setContentView(this.UB);
                WindowManager.LayoutParams attributes = this.UC.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -1;
                this.UC.getWindow().setAttributes(attributes);
                this.UJ.ShowSoftKeyPadDelay(this.UD, 150);
                this.UD.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tK() {
        if (this.UU != null) {
            this.UU.f(null);
        }
    }

    public void u(ArrayList<String> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.Ag.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.UF.setText(arrayList.get(0));
                this.UF.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.UG.setText(arrayList.get(1));
                this.UG.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.UH.setText(arrayList.get(2));
                this.UH.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.UL != null) {
            this.UL.cancel();
            this.UL = null;
        }
        if (this.UM != null) {
            this.UM.cancel();
            this.UM = null;
        }
        tM();
    }

    public boolean isShowing() {
        return this.UC != null && this.UC.isShowing();
    }

    public void tL() {
        this.Ag.setVisibility(8);
        this.Ag.clearCheck();
        this.UF.setVisibility(8);
        this.UG.setVisibility(8);
        this.UH.setVisibility(8);
        this.UF.setChecked(false);
        this.UG.setChecked(false);
        this.UH.setChecked(false);
    }

    public void tM() {
        if (this.UC != null && this.UC.isShowing()) {
            com.baidu.adp.lib.g.k.b(this.UC, this.UJ.getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(String str) {
        if (str == null) {
            this.UN.setVisibility(8);
            this.UN.setText((CharSequence) null);
            return;
        }
        this.UN.setVisibility(0);
        this.UN.setText(str);
    }
}
