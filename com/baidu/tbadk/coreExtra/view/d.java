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
    private TbPageContext<?> aRR;
    private Drawable bne;
    private Drawable bnf;
    private int size;
    private View bmL = null;
    private Dialog bmM = null;
    private EditText bmN = null;
    private RadioGroup bmO = null;
    private RadioGroup bmP = null;
    private CompoundButton.OnCheckedChangeListener bmQ = null;
    private RadioButton bmR = null;
    private RadioButton bmS = null;
    private RadioButton bmT = null;
    private TextView bmU = null;
    private c bmV = null;
    private b bmW = null;
    private TextView bmX = null;
    private TextView bmY = null;
    private ProgressBar bmZ = null;
    private TextView bna = null;
    private String mPhoneNum = null;
    private AccountData bnb = null;
    private a bnc = null;
    private a bnd = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aRR = null;
        this.bne = null;
        this.bnf = null;
        this.size = 0;
        this.aRR = tbPageContext;
        this.bne = aj.getDrawable(d.f.icon_tips_names_s);
        this.bnf = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.aRR.getResources().getDimensionPixelSize(d.e.ds26);
        this.bne.setBounds(0, 0, this.size, this.size);
        this.bnf.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.bnb = accountData;
    }

    public void a(a aVar) {
        this.bnc = aVar;
    }

    public void Jf() {
        if (this.bmM == null) {
            this.bmL = LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.bmN = (EditText) this.bmL.findViewById(d.g.account);
            this.bmN.setHint(this.aRR.getString(d.j.input_alias_limit_length_tip));
            this.bmU = (TextView) this.bmL.findViewById(d.g.back);
            this.bmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Jj();
                    d.this.Jh();
                }
            });
            this.bmY = (TextView) this.bmL.findViewById(d.g.confirm);
            this.bmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Jg();
                }
            });
            this.bmZ = (ProgressBar) this.bmL.findViewById(d.g.confirm_progress);
            this.bmX = (TextView) this.bmL.findViewById(d.g.error_info);
            this.bmO = (RadioGroup) this.bmL.findViewById(d.g.names_group1);
            this.bmP = (RadioGroup) this.bmL.findViewById(d.g.names_group2);
            this.bmR = (RadioButton) this.bmL.findViewById(d.g.name1);
            this.bmS = (RadioButton) this.bmL.findViewById(d.g.name2);
            this.bmT = (RadioButton) this.bmL.findViewById(d.g.name3);
            this.bmQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.bmR) {
                            d.this.bmP.clearCheck();
                            d.this.bmR.setChecked(true);
                            d.this.bmR.setCompoundDrawables(d.this.bne, null, null, null);
                            d.this.bmS.setChecked(false);
                            d.this.bmS.setCompoundDrawables(d.this.bnf, null, null, null);
                            d.this.bmT.setChecked(false);
                            d.this.bmT.setCompoundDrawables(d.this.bnf, null, null, null);
                        } else if (compoundButton == d.this.bmS) {
                            d.this.bmP.clearCheck();
                            d.this.bmR.setChecked(false);
                            d.this.bmR.setCompoundDrawables(d.this.bnf, null, null, null);
                            d.this.bmS.setChecked(true);
                            d.this.bmS.setCompoundDrawables(d.this.bne, null, null, null);
                            d.this.bmT.setChecked(false);
                            d.this.bmT.setCompoundDrawables(d.this.bnf, null, null, null);
                        } else if (compoundButton == d.this.bmT) {
                            d.this.bmO.clearCheck();
                            d.this.bmR.setChecked(false);
                            d.this.bmR.setCompoundDrawables(d.this.bnf, null, null, null);
                            d.this.bmS.setChecked(false);
                            d.this.bmS.setCompoundDrawables(d.this.bnf, null, null, null);
                            d.this.bmT.setChecked(true);
                            d.this.bmT.setCompoundDrawables(d.this.bne, null, null, null);
                        }
                        d.this.bmN.setText(compoundButton.getText());
                    }
                }
            };
            this.bmR.setOnCheckedChangeListener(this.bmQ);
            this.bmS.setOnCheckedChangeListener(this.bmQ);
            this.bmT.setOnCheckedChangeListener(this.bmQ);
            this.bna = (TextView) this.bmL.findViewById(d.g.phone_info);
            Ji();
            this.bmM = new Dialog(this.aRR.getPageActivity(), d.k.input_username_dialog);
            this.bmM.setCanceledOnTouchOutside(false);
            this.bmM.setCancelable(false);
            this.bmM.setCanceledOnTouchOutside(false);
            Jb();
        }
        if (!this.bmM.isShowing()) {
            this.bmN.setText((CharSequence) null);
            Ji();
            fK(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.bna.setText("Hi," + this.aRR.getString(d.j.bar_friend));
            } else {
                this.bna.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aRR.getPageActivity().isFinishing()) {
                this.bmM.setContentView(this.bmL);
                g.a(this.bmM, this.aRR);
                if (this.aRR.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aRR.getOrignalPage()).ShowSoftKeyPadDelay(this.bmN, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Jg() {
        String obj = this.bmN.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fK(this.aRR.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fK(this.aRR.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.bmW != null) {
                this.bmW.cancel();
            }
            if (this.bmV == null) {
                this.bmV = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.bmV.setPriority(3);
                this.bmV.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        if (this.bnd != null) {
            this.bnd.i(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fK(this.aRR.getString(d.j.suggest_no_name));
            return;
        }
        fK(this.aRR.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.bmO.clearCheck();
        this.bmP.clearCheck();
        this.bmO.setVisibility(0);
        this.bmP.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.bmR.setText(arrayList.get(0));
            this.bmR.setChecked(false);
            this.bmR.setCompoundDrawables(this.bnf, null, null, null);
            this.bmR.setVisibility(0);
            this.bmO.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.bmS.setText(arrayList.get(1));
            this.bmS.setChecked(false);
            this.bmS.setCompoundDrawables(this.bnf, null, null, null);
            this.bmS.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.bmT.setText(arrayList.get(2));
            this.bmT.setChecked(false);
            this.bmT.setCompoundDrawables(this.bnf, null, null, null);
            this.bmT.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.bmV != null) {
            this.bmV.cancel();
            this.bmV = null;
        }
        if (this.bmW != null) {
            this.bmW.cancel();
            this.bmW = null;
        }
        Jj();
    }

    public void Ji() {
        this.bmO.setVisibility(8);
        this.bmO.clearCheck();
        this.bmP.setVisibility(8);
        this.bmP.clearCheck();
        this.bmR.setVisibility(8);
        this.bmS.setVisibility(8);
        this.bmT.setVisibility(8);
        this.bmR.setChecked(false);
        this.bmS.setChecked(false);
        this.bmT.setChecked(false);
    }

    public void Jj() {
        if (this.bmM != null && this.bmM.isShowing()) {
            g.b(this.bmM, this.aRR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(String str) {
        if (str == null) {
            this.bmX.setVisibility(4);
            this.bmX.setText((CharSequence) null);
            return;
        }
        this.bmX.setVisibility(0);
        this.bmX.setText(str);
    }

    public void Jb() {
        this.aRR.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aRR.getLayoutMode().aM(this.bmL);
        this.bmN.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        this.bmR.setCompoundDrawables(this.bnf, null, null, null);
        this.bmS.setCompoundDrawables(this.bnf, null, null, null);
        this.bmT.setCompoundDrawables(this.bnf, null, null, null);
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
            d.this.bmV = null;
            d.this.bmZ.setVisibility(8);
            d.this.bmY.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            d.this.bmV = null;
            d.this.bmZ.setVisibility(8);
            d.this.bmY.setEnabled(true);
            if (hVar == null) {
                d.this.fK(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                d.this.Jj();
                TbadkCoreApplication.setCurrentAccount(d.this.bnb, d.this.aRR.getPageActivity());
                if (d.this.bnc != null) {
                    d.this.bnc.i(d.this.bnb);
                }
            } else {
                d.this.o(hVar.FI());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bmZ.setVisibility(0);
            d.this.bmY.setEnabled(false);
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
                this.mNetwork.n("BDUSS", d.this.bnb.getBDUSS());
                this.mNetwork.Cz().Dw().aYk = false;
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
                                if (d.this.bnb != null) {
                                    d.this.bnb.setAccount(userName);
                                    d.this.bnb.setBDUSS(bduss);
                                    d.this.bnb.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.bnb);
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
        final /* synthetic */ d bng;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.bng.bmW = null;
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
            this.bng.bmW = null;
            if (!this.mNetwork.CC()) {
                this.bng.fK(this.mNetwork.getErrorString());
            } else if (this.mNetwork.CD() == 0) {
                this.bng.fK(this.bng.aRR.getString(d.j.name_not_use));
            } else if (this.mNetwork.CD() == 36) {
                this.bng.fK(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.bng.o(hVar.FI());
                }
            } else {
                this.bng.fK(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bng.fK(null);
            this.bng.Ji();
            super.onPreExecute();
        }
    }
}
