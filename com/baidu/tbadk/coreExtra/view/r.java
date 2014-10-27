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
public class r {
    private BaseActivity On;
    private View Oe = null;
    private Dialog Of = null;
    private EditText Og = null;
    private RadioGroup Oh = null;
    private CompoundButton.OnCheckedChangeListener Oi = null;
    private RadioButton Oj = null;
    private RadioButton Ok = null;
    private RadioButton Ol = null;
    private Button Om = null;
    private Button Oo = null;
    private y Op = null;
    private x Oq = null;
    private TextView Or = null;
    private Button mConfirm = null;
    private ProgressBar Os = null;
    private ProgressBar Ot = null;
    private TextView Ou = null;
    private String Ov = null;
    private AccountData KS = null;
    private w Ow = null;
    private w Ox = null;

    public r(BaseActivity baseActivity) {
        this.On = null;
        this.On = baseActivity;
    }

    public void setPhone(String str) {
        this.Ov = str;
    }

    public void g(AccountData accountData) {
        this.KS = accountData;
    }

    public void a(w wVar) {
        this.Ow = wVar;
    }

    public void pX() {
        if (this.Of == null) {
            this.Oe = com.baidu.adp.lib.g.b.ek().inflate(this.On, com.baidu.tieba.w.main_input_username, null);
            this.Og = (EditText) this.Oe.findViewById(com.baidu.tieba.v.account);
            this.Og.setHint(String.valueOf(this.On.getString(com.baidu.tieba.y.input_name)) + ":");
            this.Om = (Button) this.Oe.findViewById(com.baidu.tieba.v.back);
            this.Om.setOnClickListener(new s(this));
            this.Oo = (Button) this.Oe.findViewById(com.baidu.tieba.v.check_username);
            this.Oo.setOnClickListener(new t(this));
            this.Os = (ProgressBar) this.Oe.findViewById(com.baidu.tieba.v.check_progress);
            this.mConfirm = (Button) this.Oe.findViewById(com.baidu.tieba.v.confirm);
            this.mConfirm.setOnClickListener(new u(this));
            this.Ot = (ProgressBar) this.Oe.findViewById(com.baidu.tieba.v.confirm_progress);
            this.Or = (TextView) this.Oe.findViewById(com.baidu.tieba.v.error_info);
            this.Oh = (RadioGroup) this.Oe.findViewById(com.baidu.tieba.v.names_group);
            this.Oj = (RadioButton) this.Oe.findViewById(com.baidu.tieba.v.name1);
            this.Ok = (RadioButton) this.Oe.findViewById(com.baidu.tieba.v.name2);
            this.Ol = (RadioButton) this.Oe.findViewById(com.baidu.tieba.v.name3);
            this.Oi = new v(this);
            this.Oj.setOnCheckedChangeListener(this.Oi);
            this.Ok.setOnCheckedChangeListener(this.Oi);
            this.Ol.setOnCheckedChangeListener(this.Oi);
            this.Ou = (TextView) this.Oe.findViewById(com.baidu.tieba.v.phone_info);
            pZ();
            this.Of = new Dialog(this.On, com.baidu.tieba.z.input_username_dialog);
            this.Of.setCanceledOnTouchOutside(false);
            this.Of.getWindow().setSoftInputMode(20);
            this.Of.setCancelable(false);
            this.Of.setCanceledOnTouchOutside(false);
        }
        if (!this.Of.isShowing()) {
            this.Og.setText((CharSequence) null);
            pZ();
            cM(null);
            if (this.Ov == null || this.Ov.length() <= 0) {
                this.Ou.setText("Hi," + this.On.getString(com.baidu.tieba.y.bar_friend));
            } else {
                this.Ou.setText("Hi," + this.Ov);
            }
            if (!this.On.isFinishing()) {
                com.baidu.adp.lib.g.j.a(this.Of, this.On);
                this.Of.setContentView(this.Oe);
                WindowManager.LayoutParams attributes = this.Of.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -1;
                this.Of.getWindow().setAttributes(attributes);
                this.On.ShowSoftKeyPadDelay(this.Og, 150);
                this.Og.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY() {
        if (this.Ox != null) {
            this.Ox.f(null);
        }
    }

    public void i(ArrayList<String> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.Oh.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.Oj.setText(arrayList.get(0));
                this.Oj.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.Ok.setText(arrayList.get(1));
                this.Ok.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.Ol.setText(arrayList.get(2));
                this.Ol.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.Op != null) {
            this.Op.cancel();
            this.Op = null;
        }
        if (this.Oq != null) {
            this.Oq.cancel();
            this.Oq = null;
        }
        qa();
    }

    public boolean isShowing() {
        return this.Of != null && this.Of.isShowing();
    }

    public void pZ() {
        this.Oh.setVisibility(8);
        this.Oh.clearCheck();
        this.Oj.setVisibility(8);
        this.Ok.setVisibility(8);
        this.Ol.setVisibility(8);
        this.Oj.setChecked(false);
        this.Ok.setChecked(false);
        this.Ol.setChecked(false);
    }

    public void qa() {
        if (this.Of != null && this.Of.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.Of, this.On);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(String str) {
        if (str == null) {
            this.Or.setVisibility(8);
            this.Or.setText((CharSequence) null);
            return;
        }
        this.Or.setVisibility(0);
        this.Or.setText(str);
    }
}
