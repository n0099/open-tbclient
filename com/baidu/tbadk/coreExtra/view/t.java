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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    private TbPageContext<?> LH;
    private View afM = null;
    private Dialog afN = null;
    private EditText afO = null;
    private RadioGroup afP = null;
    private RadioGroup afQ = null;
    private CompoundButton.OnCheckedChangeListener afR = null;
    private RadioButton afS = null;
    private RadioButton afT = null;
    private RadioButton afU = null;
    private TextView afV = null;
    private z afW = null;
    private y afX = null;
    private TextView afY = null;
    private TextView afZ = null;
    private ProgressBar aga = null;
    private TextView agb = null;
    private String agc = null;
    private AccountData agd = null;
    private x age = null;
    private x agf = null;
    private Drawable agg;
    private Drawable agh;
    private int size;

    public t(TbPageContext<?> tbPageContext) {
        this.LH = null;
        this.agg = null;
        this.agh = null;
        this.size = 0;
        this.LH = tbPageContext;
        this.agg = com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_tips_names_s);
        this.agh = com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_tips_names_n);
        this.size = this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds26);
        this.agg.setBounds(0, 0, this.size, this.size);
        this.agh.setBounds(0, 0, this.size, this.size);
    }

    public void setPhone(String str) {
        this.agc = str;
    }

    public void k(AccountData accountData) {
        this.agd = accountData;
    }

    public void a(x xVar) {
        this.age = xVar;
    }

    public void xO() {
        if (this.afN == null) {
            this.afM = com.baidu.adp.lib.g.b.hr().inflate(this.LH.getPageActivity(), com.baidu.tieba.r.main_input_username, null);
            this.afO = (EditText) this.afM.findViewById(com.baidu.tieba.q.account);
            this.afO.setHint(this.LH.getString(com.baidu.tieba.t.input_alias_limit_length_tip));
            this.afV = (TextView) this.afM.findViewById(com.baidu.tieba.q.back);
            this.afV.setOnClickListener(new u(this));
            this.afZ = (TextView) this.afM.findViewById(com.baidu.tieba.q.confirm);
            this.afZ.setOnClickListener(new v(this));
            this.aga = (ProgressBar) this.afM.findViewById(com.baidu.tieba.q.confirm_progress);
            this.afY = (TextView) this.afM.findViewById(com.baidu.tieba.q.error_info);
            this.afP = (RadioGroup) this.afM.findViewById(com.baidu.tieba.q.names_group1);
            this.afQ = (RadioGroup) this.afM.findViewById(com.baidu.tieba.q.names_group2);
            this.afS = (RadioButton) this.afM.findViewById(com.baidu.tieba.q.name1);
            this.afT = (RadioButton) this.afM.findViewById(com.baidu.tieba.q.name2);
            this.afU = (RadioButton) this.afM.findViewById(com.baidu.tieba.q.name3);
            this.afR = new w(this);
            this.afS.setOnCheckedChangeListener(this.afR);
            this.afT.setOnCheckedChangeListener(this.afR);
            this.afU.setOnCheckedChangeListener(this.afR);
            this.agb = (TextView) this.afM.findViewById(com.baidu.tieba.q.phone_info);
            xR();
            this.afN = new Dialog(this.LH.getPageActivity(), com.baidu.tieba.u.input_username_dialog);
            this.afN.setCanceledOnTouchOutside(false);
            this.afN.setCancelable(false);
            this.afN.setCanceledOnTouchOutside(false);
            oG();
        }
        if (!this.afN.isShowing()) {
            this.afO.setText((CharSequence) null);
            xR();
            eh(null);
            if (this.agc == null || this.agc.length() <= 0) {
                this.agb.setText("Hi," + this.LH.getString(com.baidu.tieba.t.bar_friend));
            } else {
                this.agb.setText("Hi," + this.agc);
            }
            if (!this.LH.getPageActivity().isFinishing()) {
                this.afN.setContentView(this.afM);
                com.baidu.adp.lib.g.k.a(this.afN, this.LH);
                if (this.LH.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.LH.getOrignalPage()).ShowSoftKeyPadDelay(this.afO, 150);
                }
            }
        }
    }

    public void xP() {
        String editable = this.afO.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eh(this.LH.getString(com.baidu.tieba.t.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eh(this.LH.getString(com.baidu.tieba.t.input_alias_limit_length_tip));
        } else {
            if (this.afX != null) {
                this.afX.cancel();
            }
            if (this.afW == null) {
                this.afW = new z(this, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.afW.setPriority(3);
                this.afW.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xQ() {
        if (this.agf != null) {
            this.agf.g(null);
        }
    }

    public void p(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eh(this.LH.getString(com.baidu.tieba.t.suggest_no_name));
            return;
        }
        eh(this.LH.getString(com.baidu.tieba.t.suggest_some_names));
        int size = arrayList.size();
        this.afP.clearCheck();
        this.afQ.clearCheck();
        this.afP.setVisibility(0);
        this.afQ.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.afS.setText(arrayList.get(0));
            this.afS.setChecked(false);
            this.afS.setCompoundDrawables(this.agh, null, null, null);
            this.afS.setVisibility(0);
            this.afP.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.afT.setText(arrayList.get(1));
            this.afT.setChecked(false);
            this.afT.setCompoundDrawables(this.agh, null, null, null);
            this.afT.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.afU.setText(arrayList.get(2));
            this.afU.setChecked(false);
            this.afU.setCompoundDrawables(this.agh, null, null, null);
            this.afU.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.afW != null) {
            this.afW.cancel();
            this.afW = null;
        }
        if (this.afX != null) {
            this.afX.cancel();
            this.afX = null;
        }
        xS();
    }

    public boolean isShowing() {
        return this.afN != null && this.afN.isShowing();
    }

    public void xR() {
        this.afP.setVisibility(8);
        this.afP.clearCheck();
        this.afQ.setVisibility(8);
        this.afQ.clearCheck();
        this.afS.setVisibility(8);
        this.afT.setVisibility(8);
        this.afU.setVisibility(8);
        this.afS.setChecked(false);
        this.afT.setChecked(false);
        this.afU.setChecked(false);
    }

    public void xS() {
        if (this.afN != null && this.afN.isShowing()) {
            com.baidu.adp.lib.g.k.b(this.afN, this.LH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh(String str) {
        if (str == null) {
            this.afY.setVisibility(4);
            this.afY.setText((CharSequence) null);
            return;
        }
        this.afY.setVisibility(0);
        this.afY.setText(str);
    }

    public void oG() {
        this.LH.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.LH.getLayoutMode().j(this.afM);
        this.afO.setHintTextColor(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_e));
        this.afS.setCompoundDrawables(this.agh, null, null, null);
        this.afT.setCompoundDrawables(this.agh, null, null, null);
        this.afU.setCompoundDrawables(this.agh, null, null, null);
    }
}
