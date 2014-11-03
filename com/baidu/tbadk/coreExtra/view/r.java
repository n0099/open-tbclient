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
    private BaseActivity Or;
    private View Oi = null;
    private Dialog Oj = null;
    private EditText Ok = null;
    private RadioGroup Ol = null;
    private CompoundButton.OnCheckedChangeListener Om = null;
    private RadioButton On = null;
    private RadioButton Oo = null;
    private RadioButton Op = null;
    private Button Oq = null;
    private Button Os = null;
    private y Ot = null;
    private x Ou = null;
    private TextView Ov = null;
    private Button mConfirm = null;
    private ProgressBar Ow = null;
    private ProgressBar Ox = null;
    private TextView Oy = null;
    private String Oz = null;
    private AccountData KT = null;
    private w OA = null;
    private w OB = null;

    public r(BaseActivity baseActivity) {
        this.Or = null;
        this.Or = baseActivity;
    }

    public void setPhone(String str) {
        this.Oz = str;
    }

    public void g(AccountData accountData) {
        this.KT = accountData;
    }

    public void a(w wVar) {
        this.OA = wVar;
    }

    public void pZ() {
        if (this.Oj == null) {
            this.Oi = com.baidu.adp.lib.g.b.ek().inflate(this.Or, com.baidu.tieba.w.main_input_username, null);
            this.Ok = (EditText) this.Oi.findViewById(com.baidu.tieba.v.account);
            this.Ok.setHint(String.valueOf(this.Or.getString(com.baidu.tieba.y.input_name)) + ":");
            this.Oq = (Button) this.Oi.findViewById(com.baidu.tieba.v.back);
            this.Oq.setOnClickListener(new s(this));
            this.Os = (Button) this.Oi.findViewById(com.baidu.tieba.v.check_username);
            this.Os.setOnClickListener(new t(this));
            this.Ow = (ProgressBar) this.Oi.findViewById(com.baidu.tieba.v.check_progress);
            this.mConfirm = (Button) this.Oi.findViewById(com.baidu.tieba.v.confirm);
            this.mConfirm.setOnClickListener(new u(this));
            this.Ox = (ProgressBar) this.Oi.findViewById(com.baidu.tieba.v.confirm_progress);
            this.Ov = (TextView) this.Oi.findViewById(com.baidu.tieba.v.error_info);
            this.Ol = (RadioGroup) this.Oi.findViewById(com.baidu.tieba.v.names_group);
            this.On = (RadioButton) this.Oi.findViewById(com.baidu.tieba.v.name1);
            this.Oo = (RadioButton) this.Oi.findViewById(com.baidu.tieba.v.name2);
            this.Op = (RadioButton) this.Oi.findViewById(com.baidu.tieba.v.name3);
            this.Om = new v(this);
            this.On.setOnCheckedChangeListener(this.Om);
            this.Oo.setOnCheckedChangeListener(this.Om);
            this.Op.setOnCheckedChangeListener(this.Om);
            this.Oy = (TextView) this.Oi.findViewById(com.baidu.tieba.v.phone_info);
            qb();
            this.Oj = new Dialog(this.Or, com.baidu.tieba.z.input_username_dialog);
            this.Oj.setCanceledOnTouchOutside(false);
            this.Oj.getWindow().setSoftInputMode(20);
            this.Oj.setCancelable(false);
            this.Oj.setCanceledOnTouchOutside(false);
        }
        if (!this.Oj.isShowing()) {
            this.Ok.setText((CharSequence) null);
            qb();
            cM(null);
            if (this.Oz == null || this.Oz.length() <= 0) {
                this.Oy.setText("Hi," + this.Or.getString(com.baidu.tieba.y.bar_friend));
            } else {
                this.Oy.setText("Hi," + this.Oz);
            }
            if (!this.Or.isFinishing()) {
                com.baidu.adp.lib.g.j.a(this.Oj, this.Or);
                this.Oj.setContentView(this.Oi);
                WindowManager.LayoutParams attributes = this.Oj.getWindow().getAttributes();
                attributes.gravity = 51;
                attributes.x = 0;
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -1;
                this.Oj.getWindow().setAttributes(attributes);
                this.Or.ShowSoftKeyPadDelay(this.Ok, 150);
                this.Ok.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        if (this.OB != null) {
            this.OB.f(null);
        }
    }

    public void j(ArrayList<String> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.Ol.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.On.setText(arrayList.get(0));
                this.On.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.Oo.setText(arrayList.get(1));
                this.Oo.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.Op.setText(arrayList.get(2));
                this.Op.setVisibility(0);
            }
        }
    }

    public void onDestroy() {
        if (this.Ot != null) {
            this.Ot.cancel();
            this.Ot = null;
        }
        if (this.Ou != null) {
            this.Ou.cancel();
            this.Ou = null;
        }
        qc();
    }

    public boolean isShowing() {
        return this.Oj != null && this.Oj.isShowing();
    }

    public void qb() {
        this.Ol.setVisibility(8);
        this.Ol.clearCheck();
        this.On.setVisibility(8);
        this.Oo.setVisibility(8);
        this.Op.setVisibility(8);
        this.On.setChecked(false);
        this.Oo.setChecked(false);
        this.Op.setChecked(false);
    }

    public void qc() {
        if (this.Oj != null && this.Oj.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.Oj, this.Or);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(String str) {
        if (str == null) {
            this.Ov.setVisibility(8);
            this.Ov.setText((CharSequence) null);
            return;
        }
        this.Ov.setVisibility(0);
        this.Ov.setText(str);
    }
}
