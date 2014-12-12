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
    private BaseActivity<?> Ud;
    private View TV = null;
    private Dialog TW = null;
    private EditText TX = null;
    private RadioGroup Ag = null;
    private CompoundButton.OnCheckedChangeListener TY = null;
    private RadioButton TZ = null;
    private RadioButton Ua = null;
    private RadioButton Ub = null;
    private Button Uc = null;
    private Button Ue = null;
    private aa Uf = null;
    private z Ug = null;
    private TextView Uh = null;
    private Button mConfirm = null;
    private ProgressBar Ui = null;
    private ProgressBar Uj = null;
    private TextView Uk = null;
    private String Ul = null;
    private AccountData Qe = null;
    private y Um = null;
    private y Un = null;

    public t(BaseActivity<?> baseActivity) {
        this.Ud = null;
        this.Ud = baseActivity;
    }

    public void setPhone(String str) {
        this.Ul = str;
    }

    public void g(AccountData accountData) {
        this.Qe = accountData;
    }

    public void a(y yVar) {
        this.Um = yVar;
    }

    public void ts() {
        if (this.TW == null) {
            this.TV = com.baidu.adp.lib.g.b.ek().inflate(this.Ud.getPageContext().getPageActivity(), com.baidu.tieba.x.main_input_username, null);
            this.TX = (EditText) this.TV.findViewById(com.baidu.tieba.w.account);
            this.TX.setHint(String.valueOf(this.Ud.getPageContext().getString(com.baidu.tieba.z.input_name)) + ":");
            this.Uc = (Button) this.TV.findViewById(com.baidu.tieba.w.back);
            this.Uc.setOnClickListener(new u(this));
            this.Ue = (Button) this.TV.findViewById(com.baidu.tieba.w.check_username);
            this.Ue.setOnClickListener(new v(this));
            this.Ui = (ProgressBar) this.TV.findViewById(com.baidu.tieba.w.check_progress);
            this.mConfirm = (Button) this.TV.findViewById(com.baidu.tieba.w.confirm);
            this.mConfirm.setOnClickListener(new w(this));
            this.Uj = (ProgressBar) this.TV.findViewById(com.baidu.tieba.w.confirm_progress);
            this.Uh = (TextView) this.TV.findViewById(com.baidu.tieba.w.error_info);
            this.Ag = (RadioGroup) this.TV.findViewById(com.baidu.tieba.w.names_group);
            this.TZ = (RadioButton) this.TV.findViewById(com.baidu.tieba.w.name1);
            this.Ua = (RadioButton) this.TV.findViewById(com.baidu.tieba.w.name2);
            this.Ub = (RadioButton) this.TV.findViewById(com.baidu.tieba.w.name3);
            this.TY = new x(this);
            this.TZ.setOnCheckedChangeListener(this.TY);
            this.Ua.setOnCheckedChangeListener(this.TY);
            this.Ub.setOnCheckedChangeListener(this.TY);
            this.Uk = (TextView) this.TV.findViewById(com.baidu.tieba.w.phone_info);
            tu();
            this.TW = new Dialog(this.Ud.getPageContext().getPageActivity(), com.baidu.tieba.aa.input_username_dialog);
            this.TW.setCanceledOnTouchOutside(false);
            this.TW.getWindow().setSoftInputMode(20);
            this.TW.setCancelable(false);
            this.TW.setCanceledOnTouchOutside(false);
        }
        if (!this.TW.isShowing()) {
            this.TX.setText((CharSequence) null);
            tu();
            dI(null);
            if (this.Ul == null || this.Ul.length() <= 0) {
                this.Uk.setText("Hi," + this.Ud.getPageContext().getString(com.baidu.tieba.z.bar_friend));
            } else {
                this.Uk.setText("Hi," + this.Ul);
            }
            if (!this.Ud.isFinishing()) {
                com.baidu.adp.lib.g.k.a(this.TW, this.Ud.getPageContext());
                this.TW.setContentView(this.TV);
                WindowManager.LayoutParams attributes = this.TW.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -1;
                this.TW.getWindow().setAttributes(attributes);
                this.Ud.ShowSoftKeyPadDelay(this.TX, 150);
                this.TX.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        if (this.Un != null) {
            this.Un.f(null);
        }
    }

    public void t(ArrayList<String> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.Ag.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.TZ.setText(arrayList.get(0));
                this.TZ.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.Ua.setText(arrayList.get(1));
                this.Ua.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.Ub.setText(arrayList.get(2));
                this.Ub.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.Uf != null) {
            this.Uf.cancel();
            this.Uf = null;
        }
        if (this.Ug != null) {
            this.Ug.cancel();
            this.Ug = null;
        }
        tv();
    }

    public boolean isShowing() {
        return this.TW != null && this.TW.isShowing();
    }

    public void tu() {
        this.Ag.setVisibility(8);
        this.Ag.clearCheck();
        this.TZ.setVisibility(8);
        this.Ua.setVisibility(8);
        this.Ub.setVisibility(8);
        this.TZ.setChecked(false);
        this.Ua.setChecked(false);
        this.Ub.setChecked(false);
    }

    public void tv() {
        if (this.TW != null && this.TW.isShowing()) {
            com.baidu.adp.lib.g.k.b(this.TW, this.Ud.getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(String str) {
        if (str == null) {
            this.Uh.setVisibility(8);
            this.Uh.setText((CharSequence) null);
            return;
        }
        this.Uh.setVisibility(0);
        this.Uh.setText(str);
    }
}
