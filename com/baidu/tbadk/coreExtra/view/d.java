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
    private TbPageContext<?> aRI;
    private Drawable bmU;
    private Drawable bmV;
    private int size;
    private View bmB = null;
    private Dialog bmC = null;
    private EditText bmD = null;
    private RadioGroup bmE = null;
    private RadioGroup bmF = null;
    private CompoundButton.OnCheckedChangeListener bmG = null;
    private RadioButton bmH = null;
    private RadioButton bmI = null;
    private RadioButton bmJ = null;
    private TextView bmK = null;
    private c bmL = null;
    private b bmM = null;
    private TextView bmN = null;
    private TextView bmO = null;
    private ProgressBar bmP = null;
    private TextView bmQ = null;
    private String mPhoneNum = null;
    private AccountData bmR = null;
    private a bmS = null;
    private a bmT = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aRI = null;
        this.bmU = null;
        this.bmV = null;
        this.size = 0;
        this.aRI = tbPageContext;
        this.bmU = aj.getDrawable(d.f.icon_tips_names_s);
        this.bmV = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.aRI.getResources().getDimensionPixelSize(d.e.ds26);
        this.bmU.setBounds(0, 0, this.size, this.size);
        this.bmV.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.bmR = accountData;
    }

    public void a(a aVar) {
        this.bmS = aVar;
    }

    public void Jf() {
        if (this.bmC == null) {
            this.bmB = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.bmD = (EditText) this.bmB.findViewById(d.g.account);
            this.bmD.setHint(this.aRI.getString(d.j.input_alias_limit_length_tip));
            this.bmK = (TextView) this.bmB.findViewById(d.g.back);
            this.bmK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Jj();
                    d.this.Jh();
                }
            });
            this.bmO = (TextView) this.bmB.findViewById(d.g.confirm);
            this.bmO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Jg();
                }
            });
            this.bmP = (ProgressBar) this.bmB.findViewById(d.g.confirm_progress);
            this.bmN = (TextView) this.bmB.findViewById(d.g.error_info);
            this.bmE = (RadioGroup) this.bmB.findViewById(d.g.names_group1);
            this.bmF = (RadioGroup) this.bmB.findViewById(d.g.names_group2);
            this.bmH = (RadioButton) this.bmB.findViewById(d.g.name1);
            this.bmI = (RadioButton) this.bmB.findViewById(d.g.name2);
            this.bmJ = (RadioButton) this.bmB.findViewById(d.g.name3);
            this.bmG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.bmH) {
                            d.this.bmF.clearCheck();
                            d.this.bmH.setChecked(true);
                            d.this.bmH.setCompoundDrawables(d.this.bmU, null, null, null);
                            d.this.bmI.setChecked(false);
                            d.this.bmI.setCompoundDrawables(d.this.bmV, null, null, null);
                            d.this.bmJ.setChecked(false);
                            d.this.bmJ.setCompoundDrawables(d.this.bmV, null, null, null);
                        } else if (compoundButton == d.this.bmI) {
                            d.this.bmF.clearCheck();
                            d.this.bmH.setChecked(false);
                            d.this.bmH.setCompoundDrawables(d.this.bmV, null, null, null);
                            d.this.bmI.setChecked(true);
                            d.this.bmI.setCompoundDrawables(d.this.bmU, null, null, null);
                            d.this.bmJ.setChecked(false);
                            d.this.bmJ.setCompoundDrawables(d.this.bmV, null, null, null);
                        } else if (compoundButton == d.this.bmJ) {
                            d.this.bmE.clearCheck();
                            d.this.bmH.setChecked(false);
                            d.this.bmH.setCompoundDrawables(d.this.bmV, null, null, null);
                            d.this.bmI.setChecked(false);
                            d.this.bmI.setCompoundDrawables(d.this.bmV, null, null, null);
                            d.this.bmJ.setChecked(true);
                            d.this.bmJ.setCompoundDrawables(d.this.bmU, null, null, null);
                        }
                        d.this.bmD.setText(compoundButton.getText());
                    }
                }
            };
            this.bmH.setOnCheckedChangeListener(this.bmG);
            this.bmI.setOnCheckedChangeListener(this.bmG);
            this.bmJ.setOnCheckedChangeListener(this.bmG);
            this.bmQ = (TextView) this.bmB.findViewById(d.g.phone_info);
            Ji();
            this.bmC = new Dialog(this.aRI.getPageActivity(), d.k.input_username_dialog);
            this.bmC.setCanceledOnTouchOutside(false);
            this.bmC.setCancelable(false);
            this.bmC.setCanceledOnTouchOutside(false);
            Jb();
        }
        if (!this.bmC.isShowing()) {
            this.bmD.setText((CharSequence) null);
            Ji();
            fK(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.bmQ.setText("Hi," + this.aRI.getString(d.j.bar_friend));
            } else {
                this.bmQ.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aRI.getPageActivity().isFinishing()) {
                this.bmC.setContentView(this.bmB);
                g.a(this.bmC, this.aRI);
                if (this.aRI.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aRI.getOrignalPage()).ShowSoftKeyPadDelay(this.bmD, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Jg() {
        String obj = this.bmD.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fK(this.aRI.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fK(this.aRI.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.bmM != null) {
                this.bmM.cancel();
            }
            if (this.bmL == null) {
                this.bmL = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.bmL.setPriority(3);
                this.bmL.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        if (this.bmT != null) {
            this.bmT.i(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fK(this.aRI.getString(d.j.suggest_no_name));
            return;
        }
        fK(this.aRI.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.bmE.clearCheck();
        this.bmF.clearCheck();
        this.bmE.setVisibility(0);
        this.bmF.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.bmH.setText(arrayList.get(0));
            this.bmH.setChecked(false);
            this.bmH.setCompoundDrawables(this.bmV, null, null, null);
            this.bmH.setVisibility(0);
            this.bmE.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.bmI.setText(arrayList.get(1));
            this.bmI.setChecked(false);
            this.bmI.setCompoundDrawables(this.bmV, null, null, null);
            this.bmI.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.bmJ.setText(arrayList.get(2));
            this.bmJ.setChecked(false);
            this.bmJ.setCompoundDrawables(this.bmV, null, null, null);
            this.bmJ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.bmL != null) {
            this.bmL.cancel();
            this.bmL = null;
        }
        if (this.bmM != null) {
            this.bmM.cancel();
            this.bmM = null;
        }
        Jj();
    }

    public void Ji() {
        this.bmE.setVisibility(8);
        this.bmE.clearCheck();
        this.bmF.setVisibility(8);
        this.bmF.clearCheck();
        this.bmH.setVisibility(8);
        this.bmI.setVisibility(8);
        this.bmJ.setVisibility(8);
        this.bmH.setChecked(false);
        this.bmI.setChecked(false);
        this.bmJ.setChecked(false);
    }

    public void Jj() {
        if (this.bmC != null && this.bmC.isShowing()) {
            g.b(this.bmC, this.aRI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(String str) {
        if (str == null) {
            this.bmN.setVisibility(4);
            this.bmN.setText((CharSequence) null);
            return;
        }
        this.bmN.setVisibility(0);
        this.bmN.setText(str);
    }

    public void Jb() {
        this.aRI.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aRI.getLayoutMode().aM(this.bmB);
        this.bmD.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        this.bmH.setCompoundDrawables(this.bmV, null, null, null);
        this.bmI.setCompoundDrawables(this.bmV, null, null, null);
        this.bmJ.setCompoundDrawables(this.bmV, null, null, null);
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
            d.this.bmL = null;
            d.this.bmP.setVisibility(8);
            d.this.bmO.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            d.this.bmL = null;
            d.this.bmP.setVisibility(8);
            d.this.bmO.setEnabled(true);
            if (hVar == null) {
                d.this.fK(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                d.this.Jj();
                TbadkCoreApplication.setCurrentAccount(d.this.bmR, d.this.aRI.getPageActivity());
                if (d.this.bmS != null) {
                    d.this.bmS.i(d.this.bmR);
                }
            } else {
                d.this.o(hVar.FI());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bmP.setVisibility(0);
            d.this.bmO.setEnabled(false);
            d.this.fK(null);
            d.this.Ji();
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
                this.mNetwork.n("BDUSS", d.this.bmR.getBDUSS());
                this.mNetwork.Cz().Dw().aYa = false;
                String Cb = this.mNetwork.Cb();
                if (this.mNetwork.CC()) {
                    hVar = this.mNetwork.CD();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(Cb);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (d.this.bmR != null) {
                                    d.this.bmR.setAccount(userName);
                                    d.this.bmR.setBDUSS(bduss);
                                    d.this.bmR.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.bmR);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.CD() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(Cb);
                            hVar = hVar3;
                        } else if (this.mNetwork.CD() == 1) {
                            d.this.Jj();
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
        final /* synthetic */ d bmW;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.bmW.bmM = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String Cb = this.mNetwork.Cb();
            if (!this.mNetwork.CC() || this.mNetwork.CD() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(Cb);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.bmW.bmM = null;
            if (!this.mNetwork.CC()) {
                this.bmW.fK(this.mNetwork.getErrorString());
            } else if (this.mNetwork.CD() == 0) {
                this.bmW.fK(this.bmW.aRI.getString(d.j.name_not_use));
            } else if (this.mNetwork.CD() == 36) {
                this.bmW.fK(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.bmW.o(hVar.FI());
                }
            } else {
                this.bmW.fK(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bmW.fK(null);
            this.bmW.Ji();
            super.onPreExecute();
        }
    }
}
