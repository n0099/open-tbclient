package com.baidu.tbadk.coreExtra.view;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private TbPageContext<?> aQs;
    private Drawable bkP;
    private Drawable bkQ;
    private int size;
    private View bkw = null;
    private Dialog bkx = null;
    private EditText bky = null;
    private RadioGroup bkz = null;
    private RadioGroup bkA = null;
    private CompoundButton.OnCheckedChangeListener bkB = null;
    private RadioButton bkC = null;
    private RadioButton bkD = null;
    private RadioButton bkE = null;
    private TextView bkF = null;
    private c bkG = null;
    private b bkH = null;
    private TextView bkI = null;
    private TextView bkJ = null;
    private ProgressBar bkK = null;
    private TextView bkL = null;
    private String mPhoneNum = null;
    private AccountData bkM = null;
    private a bkN = null;
    private a bkO = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aQs = null;
        this.bkP = null;
        this.bkQ = null;
        this.size = 0;
        this.aQs = tbPageContext;
        this.bkP = aj.getDrawable(d.f.icon_tips_names_s);
        this.bkQ = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.aQs.getResources().getDimensionPixelSize(d.e.ds26);
        this.bkP.setBounds(0, 0, this.size, this.size);
        this.bkQ.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.bkM = accountData;
    }

    public void a(a aVar) {
        this.bkN = aVar;
    }

    public void Iz() {
        if (this.bkx == null) {
            this.bkw = LayoutInflater.from(this.aQs.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.bky = (EditText) this.bkw.findViewById(d.g.account);
            this.bky.setHint(this.aQs.getString(d.j.input_alias_limit_length_tip));
            this.bkF = (TextView) this.bkw.findViewById(d.g.back);
            this.bkF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ID();
                    d.this.IB();
                }
            });
            this.bkJ = (TextView) this.bkw.findViewById(d.g.confirm);
            this.bkJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.IA();
                }
            });
            this.bkK = (ProgressBar) this.bkw.findViewById(d.g.confirm_progress);
            this.bkI = (TextView) this.bkw.findViewById(d.g.error_info);
            this.bkz = (RadioGroup) this.bkw.findViewById(d.g.names_group1);
            this.bkA = (RadioGroup) this.bkw.findViewById(d.g.names_group2);
            this.bkC = (RadioButton) this.bkw.findViewById(d.g.name1);
            this.bkD = (RadioButton) this.bkw.findViewById(d.g.name2);
            this.bkE = (RadioButton) this.bkw.findViewById(d.g.name3);
            this.bkB = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.bkC) {
                            d.this.bkA.clearCheck();
                            d.this.bkC.setChecked(true);
                            d.this.bkC.setCompoundDrawables(d.this.bkP, null, null, null);
                            d.this.bkD.setChecked(false);
                            d.this.bkD.setCompoundDrawables(d.this.bkQ, null, null, null);
                            d.this.bkE.setChecked(false);
                            d.this.bkE.setCompoundDrawables(d.this.bkQ, null, null, null);
                        } else if (compoundButton == d.this.bkD) {
                            d.this.bkA.clearCheck();
                            d.this.bkC.setChecked(false);
                            d.this.bkC.setCompoundDrawables(d.this.bkQ, null, null, null);
                            d.this.bkD.setChecked(true);
                            d.this.bkD.setCompoundDrawables(d.this.bkP, null, null, null);
                            d.this.bkE.setChecked(false);
                            d.this.bkE.setCompoundDrawables(d.this.bkQ, null, null, null);
                        } else if (compoundButton == d.this.bkE) {
                            d.this.bkz.clearCheck();
                            d.this.bkC.setChecked(false);
                            d.this.bkC.setCompoundDrawables(d.this.bkQ, null, null, null);
                            d.this.bkD.setChecked(false);
                            d.this.bkD.setCompoundDrawables(d.this.bkQ, null, null, null);
                            d.this.bkE.setChecked(true);
                            d.this.bkE.setCompoundDrawables(d.this.bkP, null, null, null);
                        }
                        d.this.bky.setText(compoundButton.getText());
                    }
                }
            };
            this.bkC.setOnCheckedChangeListener(this.bkB);
            this.bkD.setOnCheckedChangeListener(this.bkB);
            this.bkE.setOnCheckedChangeListener(this.bkB);
            this.bkL = (TextView) this.bkw.findViewById(d.g.phone_info);
            IC();
            this.bkx = new Dialog(this.aQs.getPageActivity(), d.k.input_username_dialog);
            this.bkx.setCanceledOnTouchOutside(false);
            this.bkx.setCancelable(false);
            this.bkx.setCanceledOnTouchOutside(false);
            Iv();
        }
        if (!this.bkx.isShowing()) {
            this.bky.setText((CharSequence) null);
            IC();
            fA(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.bkL.setText("Hi," + this.aQs.getString(d.j.bar_friend));
            } else {
                this.bkL.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aQs.getPageActivity().isFinishing()) {
                this.bkx.setContentView(this.bkw);
                g.a(this.bkx, this.aQs);
                if (this.aQs.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aQs.getOrignalPage()).ShowSoftKeyPadDelay(this.bky, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void IA() {
        String obj = this.bky.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fA(this.aQs.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fA(this.aQs.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.bkH != null) {
                this.bkH.cancel();
            }
            if (this.bkG == null) {
                this.bkG = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.bkG.setPriority(3);
                this.bkG.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IB() {
        if (this.bkO != null) {
            this.bkO.i(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fA(this.aQs.getString(d.j.suggest_no_name));
            return;
        }
        fA(this.aQs.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.bkz.clearCheck();
        this.bkA.clearCheck();
        this.bkz.setVisibility(0);
        this.bkA.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.bkC.setText(arrayList.get(0));
            this.bkC.setChecked(false);
            this.bkC.setCompoundDrawables(this.bkQ, null, null, null);
            this.bkC.setVisibility(0);
            this.bkz.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.bkD.setText(arrayList.get(1));
            this.bkD.setChecked(false);
            this.bkD.setCompoundDrawables(this.bkQ, null, null, null);
            this.bkD.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.bkE.setText(arrayList.get(2));
            this.bkE.setChecked(false);
            this.bkE.setCompoundDrawables(this.bkQ, null, null, null);
            this.bkE.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.bkG != null) {
            this.bkG.cancel();
            this.bkG = null;
        }
        if (this.bkH != null) {
            this.bkH.cancel();
            this.bkH = null;
        }
        ID();
    }

    public void IC() {
        this.bkz.setVisibility(8);
        this.bkz.clearCheck();
        this.bkA.setVisibility(8);
        this.bkA.clearCheck();
        this.bkC.setVisibility(8);
        this.bkD.setVisibility(8);
        this.bkE.setVisibility(8);
        this.bkC.setChecked(false);
        this.bkD.setChecked(false);
        this.bkE.setChecked(false);
    }

    public void ID() {
        if (this.bkx != null && this.bkx.isShowing()) {
            g.b(this.bkx, this.aQs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA(String str) {
        if (str == null) {
            this.bkI.setVisibility(4);
            this.bkI.setText((CharSequence) null);
            return;
        }
        this.bkI.setVisibility(0);
        this.bkI.setText(str);
    }

    public void Iv() {
        this.aQs.getLayoutMode().aN(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aQs.getLayoutMode().aM(this.bkw);
        this.bky.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        this.bkC.setCompoundDrawables(this.bkQ, null, null, null);
        this.bkD.setCompoundDrawables(this.bkQ, null, null, null);
        this.bkE.setCompoundDrawables(this.bkQ, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, h> {
        private String mAccount;
        private x mNetwork = null;
        private String mUrl;

        public c(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            d.this.bkG = null;
            d.this.bkK.setVisibility(8);
            d.this.bkJ.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            d.this.bkG = null;
            d.this.bkK.setVisibility(8);
            d.this.bkJ.setEnabled(true);
            if (hVar == null) {
                d.this.fA(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                d.this.ID();
                TbadkCoreApplication.setCurrentAccount(d.this.bkM, d.this.aQs.getPageActivity());
                if (d.this.bkN != null) {
                    d.this.bkN.i(d.this.bkM);
                }
            } else {
                d.this.o(hVar.Fm());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bkK.setVisibility(0);
            d.this.bkJ.setEnabled(false);
            d.this.fA(null);
            d.this.IC();
            super.onPreExecute();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00ad */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0047 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.tbadk.coreExtra.data.h */
        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tbadk.coreExtra.data.h */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tbadk.coreExtra.data.h */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [com.baidu.tbadk.coreExtra.data.h] */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v28 */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            h hVar;
            Exception e;
            try {
                this.mNetwork = new x(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", d.this.bkM.getBDUSS());
                this.mNetwork.Cg().Dc().aWB = false;
                String BI = this.mNetwork.BI();
                if (this.mNetwork.Cj()) {
                    hVar = this.mNetwork.Ck();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(BI);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (d.this.bkM != null) {
                                    d.this.bkM.setAccount(userName);
                                    d.this.bkM.setBDUSS(bduss);
                                    d.this.bkM.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.bkM);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.Ck() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(BI);
                            hVar = hVar3;
                        } else if (this.mNetwork.Ck() == 1) {
                            d.this.ID();
                        }
                        return hVar;
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
        final /* synthetic */ d bkR;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.bkR.bkH = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String BI = this.mNetwork.BI();
            if (!this.mNetwork.Cj() || this.mNetwork.Ck() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(BI);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.bkR.bkH = null;
            if (!this.mNetwork.Cj()) {
                this.bkR.fA(this.mNetwork.getErrorString());
            } else if (this.mNetwork.Ck() == 0) {
                this.bkR.fA(this.bkR.aQs.getString(d.j.name_not_use));
            } else if (this.mNetwork.Ck() == 36) {
                this.bkR.fA(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.bkR.o(hVar.Fm());
                }
            } else {
                this.bkR.fA(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bkR.fA(null);
            this.bkR.IC();
            super.onPreExecute();
        }
    }
}
