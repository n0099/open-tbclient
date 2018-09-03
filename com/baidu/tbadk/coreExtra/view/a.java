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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private View aHA = null;
    private Dialog aHB = null;
    private EditText aHC = null;
    private RadioGroup aHD = null;
    private RadioGroup aHE = null;
    private CompoundButton.OnCheckedChangeListener aHF = null;
    private RadioButton aHG = null;
    private RadioButton aHH = null;
    private RadioButton aHI = null;
    private TextView aHJ = null;
    private d aHK = null;
    private b aHL = null;
    private TextView aHM = null;
    private TextView aHN = null;
    private ProgressBar aHO = null;
    private TextView aHP = null;
    private AccountData aHQ = null;
    private InterfaceC0107a aHR = null;
    private InterfaceC0107a aHS = null;
    private Drawable aHT;
    private Drawable aHU;
    private TextView aHV;
    private View aHW;
    private View aHX;
    private View aHY;
    private Activity mContext;
    private int size;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0107a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.mContext = null;
        this.aHT = null;
        this.aHU = null;
        this.size = 0;
        this.mContext = activity;
        this.aHT = am.getDrawable(f.C0146f.icon_tips_names_s);
        this.aHU = am.getDrawable(f.C0146f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(f.e.ds26);
        this.aHT.setBounds(0, 0, this.size, this.size);
        this.aHU.setBounds(0, 0, this.size, this.size);
    }

    public void setAccountData(AccountData accountData) {
        this.aHQ = accountData;
    }

    public void a(InterfaceC0107a interfaceC0107a) {
        this.aHR = interfaceC0107a;
    }

    public void b(InterfaceC0107a interfaceC0107a) {
        this.aHS = interfaceC0107a;
    }

    public void FJ() {
        eu(0);
    }

    public void eu(int i) {
        if (this.aHB == null) {
            this.aHA = LayoutInflater.from(this.mContext).inflate(f.h.main_input_username, (ViewGroup) null);
            this.aHV = (TextView) this.aHA.findViewById(f.g.tip_info);
            this.aHW = this.aHA.findViewById(f.g.divider_under_account);
            this.aHX = this.aHA.findViewById(f.g.divider_under_radiongroup);
            this.aHY = this.aHA.findViewById(f.g.divider_with_yes_no_button);
            this.aHC = (EditText) this.aHA.findViewById(f.g.account);
            this.aHC.setHint(this.mContext.getString(f.j.hint_tip_input_name));
            this.aHJ = (TextView) this.aHA.findViewById(f.g.back);
            this.aHJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.FN();
                    a.this.FL();
                }
            });
            this.aHN = (TextView) this.aHA.findViewById(f.g.confirm);
            this.aHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.FK();
                }
            });
            this.aHO = (ProgressBar) this.aHA.findViewById(f.g.confirm_progress);
            this.aHM = (TextView) this.aHA.findViewById(f.g.error_info);
            this.aHD = (RadioGroup) this.aHA.findViewById(f.g.names_group1);
            this.aHE = (RadioGroup) this.aHA.findViewById(f.g.names_group2);
            this.aHG = (RadioButton) this.aHA.findViewById(f.g.name1);
            this.aHH = (RadioButton) this.aHA.findViewById(f.g.name2);
            this.aHI = (RadioButton) this.aHA.findViewById(f.g.name3);
            this.aHF = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aHG) {
                            a.this.aHE.clearCheck();
                            a.this.aHG.setChecked(true);
                            a.this.aHG.setCompoundDrawables(a.this.aHT, null, null, null);
                            a.this.aHH.setChecked(false);
                            a.this.aHH.setCompoundDrawables(a.this.aHU, null, null, null);
                            a.this.aHI.setChecked(false);
                            a.this.aHI.setCompoundDrawables(a.this.aHU, null, null, null);
                        } else if (compoundButton == a.this.aHH) {
                            a.this.aHE.clearCheck();
                            a.this.aHG.setChecked(false);
                            a.this.aHG.setCompoundDrawables(a.this.aHU, null, null, null);
                            a.this.aHH.setChecked(true);
                            a.this.aHH.setCompoundDrawables(a.this.aHT, null, null, null);
                            a.this.aHI.setChecked(false);
                            a.this.aHI.setCompoundDrawables(a.this.aHU, null, null, null);
                        } else if (compoundButton == a.this.aHI) {
                            a.this.aHD.clearCheck();
                            a.this.aHG.setChecked(false);
                            a.this.aHG.setCompoundDrawables(a.this.aHU, null, null, null);
                            a.this.aHH.setChecked(false);
                            a.this.aHH.setCompoundDrawables(a.this.aHU, null, null, null);
                            a.this.aHI.setChecked(true);
                            a.this.aHI.setCompoundDrawables(a.this.aHT, null, null, null);
                        }
                        a.this.aHC.setText(compoundButton.getText());
                    }
                }
            };
            this.aHG.setOnCheckedChangeListener(this.aHF);
            this.aHH.setOnCheckedChangeListener(this.aHF);
            this.aHI.setOnCheckedChangeListener(this.aHF);
            this.aHP = (TextView) this.aHA.findViewById(f.g.phone_info);
            FM();
            this.aHB = new Dialog(this.mContext, f.k.input_username_dialog);
            this.aHB.setCanceledOnTouchOutside(false);
            this.aHB.setCancelable(false);
            this.aHB.setCanceledOnTouchOutside(false);
            FG();
        }
        if (i == 1) {
            this.aHP.setText(f.j.tip_init_user_name);
        } else {
            this.aHP.setText(f.j.bar_friend);
        }
        if (!this.aHB.isShowing()) {
            this.aHC.setText((CharSequence) null);
            FM();
            gc(null);
            if (!this.mContext.isFinishing()) {
                this.aHB.setContentView(this.aHA);
                g.a(this.aHB, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.aHC, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aHC), 150L);
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
            if (!a.this.mContext.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) a.this.mContext.getSystemService("input_method");
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
        String obj = this.aHC.getText().toString();
        if (obj == null || obj.length() <= 0) {
            gc(this.mContext.getString(f.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            gc(this.mContext.getString(f.j.input_alias_limit_length_tip));
        } else {
            if (this.aHL != null) {
                this.aHL.cancel();
            }
            if (this.aHK == null) {
                this.aHK = new d(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.aHK.setPriority(3);
                this.aHK.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL() {
        if (this.aHS != null) {
            this.aHS.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            gc(this.mContext.getString(f.j.suggest_no_name));
            return;
        }
        gc(this.mContext.getString(f.j.suggest_some_names));
        int size = arrayList.size();
        this.aHD.clearCheck();
        this.aHE.clearCheck();
        this.aHD.setVisibility(0);
        this.aHE.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aHG.setText(arrayList.get(0));
            this.aHG.setChecked(false);
            this.aHG.setCompoundDrawables(this.aHU, null, null, null);
            this.aHG.setVisibility(0);
            this.aHD.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aHH.setText(arrayList.get(1));
            this.aHH.setChecked(false);
            this.aHH.setCompoundDrawables(this.aHU, null, null, null);
            this.aHH.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aHI.setText(arrayList.get(2));
            this.aHI.setChecked(false);
            this.aHI.setCompoundDrawables(this.aHU, null, null, null);
            this.aHI.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aHK != null) {
            this.aHK.cancel();
            this.aHK = null;
        }
        if (this.aHL != null) {
            this.aHL.cancel();
            this.aHL = null;
        }
        FN();
    }

    public void FM() {
        this.aHD.setVisibility(8);
        this.aHD.clearCheck();
        this.aHE.setVisibility(8);
        this.aHE.clearCheck();
        this.aHG.setVisibility(8);
        this.aHH.setVisibility(8);
        this.aHI.setVisibility(8);
        this.aHG.setChecked(false);
        this.aHH.setChecked(false);
        this.aHI.setChecked(false);
    }

    public void FN() {
        if (this.aHB != null && this.aHB.isShowing()) {
            g.b(this.aHB, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (str == null) {
            this.aHM.setVisibility(4);
            this.aHM.setText((CharSequence) null);
            return;
        }
        this.aHM.setVisibility(0);
        this.aHM.setText(str);
    }

    private void FG() {
        am.i(this.aHA, f.C0146f.dialog_background);
        am.h(this.aHP, f.d.cp_cont_b);
        am.h(this.aHV, f.d.cp_cont_f);
        am.h(this.aHC, f.d.cp_cont_b);
        am.i(this.aHW, f.C0146f.bg_search_input);
        am.h(this.aHM, f.d.cp_cont_h);
        am.h(this.aHG, f.d.cp_cont_b);
        am.h(this.aHH, f.d.cp_cont_b);
        am.h(this.aHI, f.d.cp_cont_b);
        am.j(this.aHX, f.d.cp_bg_line_a);
        am.i(this.aHJ, f.C0146f.dialog_left_button_selector);
        am.h(this.aHJ, f.d.cp_link_tip_a);
        am.j(this.aHY, f.d.cp_bg_line_a);
        am.i(this.aHN, f.C0146f.dialog_right_button_selector);
        am.h(this.aHN, f.d.cp_link_tip_a);
        this.aHC.setHintTextColor(am.getColor(f.d.cp_cont_e));
        this.aHG.setCompoundDrawables(this.aHU, null, null, null);
        this.aHH.setCompoundDrawables(this.aHU, null, null, null);
        this.aHI.setCompoundDrawables(this.aHU, null, null, null);
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
            a.this.aHK = null;
            a.this.aHO.setVisibility(8);
            a.this.aHN.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            a.this.aHK = null;
            a.this.aHO.setVisibility(8);
            a.this.aHN.setEnabled(true);
            if (hVar != null) {
                if (this.mNetwork.yQ() == 0 && hVar.getUser().getUserName() != null) {
                    a.this.FN();
                    l.showToast(a.this.mContext, f.j.reset_success);
                    TbadkCoreApplication.setCurrentAccount(a.this.aHQ, a.this.mContext);
                    if (a.this.aHR != null) {
                        a.this.aHR.g(a.this.aHQ);
                        return;
                    }
                    return;
                }
                a.this.r(hVar.Ca());
            } else if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                a.this.gc(this.mNetwork.getErrorString());
            } else if (!l.jV()) {
                l.showToast(a.this.mContext, f.j.neterror);
            } else {
                l.showToast(a.this.mContext, f.j.tip_init_name_failed);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.aHO.setVisibility(0);
            a.this.aHN.setEnabled(false);
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
        /* renamed from: m */
        public h doInBackground(String... strArr) {
            h hVar;
            Exception e;
            String str;
            String str2;
            try {
                this.mNetwork = new y(this.mUrl);
                this.mNetwork.o("un", this.mAccount);
                if (a.this.aHQ != null) {
                    this.mNetwork.o("BDUSS", a.this.aHQ.getBDUSS());
                }
                this.mNetwork.yM().zK().arS = false;
                String yo = this.mNetwork.yo();
                if (this.mNetwork.yP()) {
                    hVar = this.mNetwork.yQ();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(yo);
                            if (hVar2.getUser() != null) {
                                str2 = hVar2.getUser().getUserName();
                                str = hVar2.getUser().getBDUSS();
                            } else {
                                str = null;
                                str2 = null;
                            }
                            String tbs = hVar2.Cb() != null ? hVar2.Cb().getTbs() : null;
                            if (a.this.aHQ != null) {
                                if (!StringUtils.isNull(str2)) {
                                    a.this.aHQ.setAccount(str2);
                                }
                                if (!StringUtils.isNull(str)) {
                                    a.this.aHQ.setBDUSS(str);
                                }
                                if (!StringUtils.isNull(tbs)) {
                                    a.this.aHQ.setTbs(tbs);
                                }
                                a.this.aHQ.setPortrait(hVar2.getUser().getPortrait());
                                com.baidu.tbadk.core.a.b.b(a.this.aHQ);
                                return hVar2;
                            }
                            return hVar2;
                        } else if (this.mNetwork.yQ() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(yo);
                            return hVar3;
                        } else if (this.mNetwork.yQ() == 1) {
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
        final /* synthetic */ a aHZ;
        private String mAccount;
        private y mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aHZ.aHL = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public h doInBackground(String... strArr) {
            this.mNetwork = new y(this.mUrl);
            this.mNetwork.o("un", this.mAccount);
            String yo = this.mNetwork.yo();
            if (!this.mNetwork.yP() || this.mNetwork.yQ() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(yo);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.aHZ.aHL = null;
            if (!this.mNetwork.yP()) {
                this.aHZ.gc(this.mNetwork.getErrorString());
            } else if (this.mNetwork.yQ() == 0) {
                this.aHZ.gc(this.aHZ.mContext.getString(f.j.name_not_use));
            } else if (this.mNetwork.yQ() == 36) {
                this.aHZ.gc(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.aHZ.r(hVar.Ca());
                }
            } else {
                this.aHZ.gc(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aHZ.gc(null);
            this.aHZ.FM();
            super.onPreExecute();
        }
    }
}
