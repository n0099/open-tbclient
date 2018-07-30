package com.baidu.tbadk.coreExtra.view;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private Activity aHL;
    private Drawable aHV;
    private Drawable aHW;
    private TextView aHX;
    private View aHY;
    private View aHZ;
    private View aIa;
    private int size;
    private View aHB = null;
    private Dialog aHC = null;
    private EditText aHD = null;
    private RadioGroup aHE = null;
    private RadioGroup aHF = null;
    private CompoundButton.OnCheckedChangeListener aHG = null;
    private RadioButton aHH = null;
    private RadioButton aHI = null;
    private RadioButton aHJ = null;
    private TextView aHK = null;
    private d aHM = null;
    private b aHN = null;
    private TextView aHO = null;
    private TextView aHP = null;
    private ProgressBar aHQ = null;
    private TextView aHR = null;
    private AccountData aHS = null;
    private InterfaceC0107a aHT = null;
    private InterfaceC0107a aHU = null;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0107a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.aHL = null;
        this.aHV = null;
        this.aHW = null;
        this.size = 0;
        this.aHL = activity;
        this.aHV = am.getDrawable(d.f.icon_tips_names_s);
        this.aHW = am.getDrawable(d.f.icon_tips_names_n);
        this.size = this.aHL.getResources().getDimensionPixelSize(d.e.ds26);
        this.aHV.setBounds(0, 0, this.size, this.size);
        this.aHW.setBounds(0, 0, this.size, this.size);
    }

    public void setAccountData(AccountData accountData) {
        this.aHS = accountData;
    }

    public void a(InterfaceC0107a interfaceC0107a) {
        this.aHT = interfaceC0107a;
    }

    public void b(InterfaceC0107a interfaceC0107a) {
        this.aHU = interfaceC0107a;
    }

    public void FJ() {
        ev(0);
    }

    public void ev(int i) {
        if (this.aHC == null) {
            this.aHB = LayoutInflater.from(this.aHL).inflate(d.h.main_input_username, (ViewGroup) null);
            this.aHX = (TextView) this.aHB.findViewById(d.g.tip_info);
            this.aHY = this.aHB.findViewById(d.g.divider_under_account);
            this.aHZ = this.aHB.findViewById(d.g.divider_under_radiongroup);
            this.aIa = this.aHB.findViewById(d.g.divider_with_yes_no_button);
            this.aHD = (EditText) this.aHB.findViewById(d.g.account);
            this.aHD.setHint(this.aHL.getString(d.j.hint_tip_input_name));
            this.aHK = (TextView) this.aHB.findViewById(d.g.back);
            this.aHK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.FN();
                    a.this.FL();
                }
            });
            this.aHP = (TextView) this.aHB.findViewById(d.g.confirm);
            this.aHP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.FK();
                }
            });
            this.aHQ = (ProgressBar) this.aHB.findViewById(d.g.confirm_progress);
            this.aHO = (TextView) this.aHB.findViewById(d.g.error_info);
            this.aHE = (RadioGroup) this.aHB.findViewById(d.g.names_group1);
            this.aHF = (RadioGroup) this.aHB.findViewById(d.g.names_group2);
            this.aHH = (RadioButton) this.aHB.findViewById(d.g.name1);
            this.aHI = (RadioButton) this.aHB.findViewById(d.g.name2);
            this.aHJ = (RadioButton) this.aHB.findViewById(d.g.name3);
            this.aHG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aHH) {
                            a.this.aHF.clearCheck();
                            a.this.aHH.setChecked(true);
                            a.this.aHH.setCompoundDrawables(a.this.aHV, null, null, null);
                            a.this.aHI.setChecked(false);
                            a.this.aHI.setCompoundDrawables(a.this.aHW, null, null, null);
                            a.this.aHJ.setChecked(false);
                            a.this.aHJ.setCompoundDrawables(a.this.aHW, null, null, null);
                        } else if (compoundButton == a.this.aHI) {
                            a.this.aHF.clearCheck();
                            a.this.aHH.setChecked(false);
                            a.this.aHH.setCompoundDrawables(a.this.aHW, null, null, null);
                            a.this.aHI.setChecked(true);
                            a.this.aHI.setCompoundDrawables(a.this.aHV, null, null, null);
                            a.this.aHJ.setChecked(false);
                            a.this.aHJ.setCompoundDrawables(a.this.aHW, null, null, null);
                        } else if (compoundButton == a.this.aHJ) {
                            a.this.aHE.clearCheck();
                            a.this.aHH.setChecked(false);
                            a.this.aHH.setCompoundDrawables(a.this.aHW, null, null, null);
                            a.this.aHI.setChecked(false);
                            a.this.aHI.setCompoundDrawables(a.this.aHW, null, null, null);
                            a.this.aHJ.setChecked(true);
                            a.this.aHJ.setCompoundDrawables(a.this.aHV, null, null, null);
                        }
                        a.this.aHD.setText(compoundButton.getText());
                    }
                }
            };
            this.aHH.setOnCheckedChangeListener(this.aHG);
            this.aHI.setOnCheckedChangeListener(this.aHG);
            this.aHJ.setOnCheckedChangeListener(this.aHG);
            this.aHR = (TextView) this.aHB.findViewById(d.g.phone_info);
            FM();
            this.aHC = new Dialog(this.aHL, d.k.input_username_dialog);
            this.aHC.setCanceledOnTouchOutside(false);
            this.aHC.setCancelable(false);
            this.aHC.setCanceledOnTouchOutside(false);
            FG();
        }
        if (i == 1) {
            this.aHR.setText(d.j.tip_init_user_name);
        } else {
            this.aHR.setText(d.j.bar_friend);
        }
        if (!this.aHC.isShowing()) {
            this.aHD.setText((CharSequence) null);
            FM();
            gc(null);
            if (!this.aHL.isFinishing()) {
                this.aHC.setContentView(this.aHB);
                g.a(this.aHC, this.aHL);
                if (this.aHL instanceof BaseActivity) {
                    ((BaseActivity) this.aHL).ShowSoftKeyPadDelay(this.aHD, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aHD), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        private View mView;

        public c(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.aHL.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) a.this.aHL.getSystemService("input_method");
                try {
                    if (this.mView != null && inputMethodManager != null) {
                        inputMethodManager.showSoftInput(this.mView, 0);
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public void FK() {
        String obj = this.aHD.getText().toString();
        if (obj == null || obj.length() <= 0) {
            gc(this.aHL.getString(d.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            gc(this.aHL.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.aHN != null) {
                this.aHN.cancel();
            }
            if (this.aHM == null) {
                this.aHM = new d(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.aHM.setPriority(3);
                this.aHM.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL() {
        if (this.aHU != null) {
            this.aHU.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            gc(this.aHL.getString(d.j.suggest_no_name));
            return;
        }
        gc(this.aHL.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.aHE.clearCheck();
        this.aHF.clearCheck();
        this.aHE.setVisibility(0);
        this.aHF.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aHH.setText(arrayList.get(0));
            this.aHH.setChecked(false);
            this.aHH.setCompoundDrawables(this.aHW, null, null, null);
            this.aHH.setVisibility(0);
            this.aHE.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aHI.setText(arrayList.get(1));
            this.aHI.setChecked(false);
            this.aHI.setCompoundDrawables(this.aHW, null, null, null);
            this.aHI.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aHJ.setText(arrayList.get(2));
            this.aHJ.setChecked(false);
            this.aHJ.setCompoundDrawables(this.aHW, null, null, null);
            this.aHJ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aHM != null) {
            this.aHM.cancel();
            this.aHM = null;
        }
        if (this.aHN != null) {
            this.aHN.cancel();
            this.aHN = null;
        }
        FN();
    }

    public void FM() {
        this.aHE.setVisibility(8);
        this.aHE.clearCheck();
        this.aHF.setVisibility(8);
        this.aHF.clearCheck();
        this.aHH.setVisibility(8);
        this.aHI.setVisibility(8);
        this.aHJ.setVisibility(8);
        this.aHH.setChecked(false);
        this.aHI.setChecked(false);
        this.aHJ.setChecked(false);
    }

    public void FN() {
        if (this.aHC != null && this.aHC.isShowing()) {
            g.b(this.aHC, this.aHL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            this.aHO.setVisibility(4);
            this.aHO.setText((CharSequence) null);
            return;
        }
        this.aHO.setVisibility(0);
        this.aHO.setText(str);
    }

    private void FG() {
        am.i(this.aHB, d.f.dialog_background);
        am.h(this.aHR, d.C0140d.cp_cont_b);
        am.h(this.aHX, d.C0140d.cp_cont_f);
        am.h(this.aHD, d.C0140d.cp_cont_b);
        am.i(this.aHY, d.f.bg_search_input);
        am.h(this.aHO, d.C0140d.cp_cont_h);
        am.h(this.aHH, d.C0140d.cp_cont_b);
        am.h(this.aHI, d.C0140d.cp_cont_b);
        am.h(this.aHJ, d.C0140d.cp_cont_b);
        am.j(this.aHZ, d.C0140d.cp_bg_line_a);
        am.i(this.aHK, d.f.dialog_left_button_selector);
        am.h(this.aHK, d.C0140d.cp_link_tip_a);
        am.j(this.aIa, d.C0140d.cp_bg_line_a);
        am.i(this.aHP, d.f.dialog_right_button_selector);
        am.h(this.aHP, d.C0140d.cp_link_tip_a);
        this.aHD.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        this.aHH.setCompoundDrawables(this.aHW, null, null, null);
        this.aHI.setCompoundDrawables(this.aHW, null, null, null);
        this.aHJ.setCompoundDrawables(this.aHW, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<String, Integer, h> {
        private String mAccount;
        private y mNetwork = null;
        private String mUrl;

        public d(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            a.this.aHM = null;
            a.this.aHQ.setVisibility(8);
            a.this.aHP.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            a.this.aHM = null;
            a.this.aHQ.setVisibility(8);
            a.this.aHP.setEnabled(true);
            if (hVar != null) {
                if (this.mNetwork.yS() == 0 && hVar.getUser().getUserName() != null) {
                    a.this.FN();
                    l.showToast(a.this.aHL, d.j.reset_success);
                    TbadkCoreApplication.setCurrentAccount(a.this.aHS, a.this.aHL);
                    if (a.this.aHT != null) {
                        a.this.aHT.g(a.this.aHS);
                        return;
                    }
                    return;
                }
                a.this.r(hVar.Cd());
            } else if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                a.this.gc(this.mNetwork.getErrorString());
            } else if (!l.jV()) {
                l.showToast(a.this.aHL, d.j.neterror);
            } else {
                l.showToast(a.this.aHL, d.j.tip_init_name_failed);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.aHQ.setVisibility(0);
            a.this.aHP.setEnabled(false);
            a.this.gc(null);
            a.this.FM();
            super.onPreExecute();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00e0 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tbadk.coreExtra.data.h */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public h doInBackground(String... strArr) {
            h hVar;
            Exception e;
            String str;
            String str2;
            try {
                this.mNetwork = new y(this.mUrl);
                this.mNetwork.o("un", this.mAccount);
                if (a.this.aHS != null) {
                    this.mNetwork.o("BDUSS", a.this.aHS.getBDUSS());
                }
                this.mNetwork.yO().zM().arR = false;
                String yq = this.mNetwork.yq();
                if (this.mNetwork.yR()) {
                    hVar = this.mNetwork.yS();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(yq);
                            if (hVar2.getUser() != null) {
                                str2 = hVar2.getUser().getUserName();
                                str = hVar2.getUser().getBDUSS();
                            } else {
                                str = null;
                                str2 = null;
                            }
                            String tbs = hVar2.Ce() != null ? hVar2.Ce().getTbs() : null;
                            if (a.this.aHS != null) {
                                if (!StringUtils.isNull(str2)) {
                                    a.this.aHS.setAccount(str2);
                                }
                                if (!StringUtils.isNull(str)) {
                                    a.this.aHS.setBDUSS(str);
                                }
                                if (!StringUtils.isNull(tbs)) {
                                    a.this.aHS.setTbs(tbs);
                                }
                                a.this.aHS.setPortrait(hVar2.getUser().getPortrait());
                                com.baidu.tbadk.core.a.b.b(a.this.aHS);
                                return hVar2;
                            }
                            return hVar2;
                        } else if (this.mNetwork.yS() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(yq);
                            return hVar3;
                        } else if (this.mNetwork.yS() == 1) {
                            a.this.FN();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return hVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                hVar = 0;
                e = e3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, h> {
        final /* synthetic */ a aIb;
        private String mAccount;
        private y mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aIb.aHN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public h doInBackground(String... strArr) {
            this.mNetwork = new y(this.mUrl);
            this.mNetwork.o("un", this.mAccount);
            String yq = this.mNetwork.yq();
            if (!this.mNetwork.yR() || this.mNetwork.yS() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(yq);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.aIb.aHN = null;
            if (!this.mNetwork.yR()) {
                this.aIb.gc(this.mNetwork.getErrorString());
            } else if (this.mNetwork.yS() == 0) {
                this.aIb.gc(this.aIb.aHL.getString(d.j.name_not_use));
            } else if (this.mNetwork.yS() == 36) {
                this.aIb.gc(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.aIb.r(hVar.Cd());
                }
            } else {
                this.aIb.gc(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aIb.gc(null);
            this.aIb.FM();
            super.onPreExecute();
        }
    }
}
