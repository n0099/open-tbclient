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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> Gf;
    private View aoI = null;
    private Dialog aoJ = null;
    private EditText aoK = null;
    private RadioGroup aoL = null;
    private RadioGroup aoM = null;
    private CompoundButton.OnCheckedChangeListener aoN = null;
    private RadioButton aoO = null;
    private RadioButton aoP = null;
    private RadioButton aoQ = null;
    private TextView aoR = null;
    private c aoS = null;
    private b aoT = null;
    private TextView aoU = null;
    private TextView aoV = null;
    private ProgressBar aoW = null;
    private TextView aoX = null;
    private String aoY = null;
    private AccountData aoZ = null;
    private a apa = null;
    private a apb = null;
    private Drawable apc;
    private Drawable apd;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.Gf = null;
        this.apc = null;
        this.apd = null;
        this.size = 0;
        this.Gf = tbPageContext;
        this.apc = ar.getDrawable(r.f.icon_tips_names_s);
        this.apd = ar.getDrawable(r.f.icon_tips_names_n);
        this.size = this.Gf.getResources().getDimensionPixelSize(r.e.ds26);
        this.apc.setBounds(0, 0, this.size, this.size);
        this.apd.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.aoZ = accountData;
    }

    public void a(a aVar) {
        this.apa = aVar;
    }

    public void b(a aVar) {
        this.apb = aVar;
    }

    public void AE() {
        if (this.aoJ == null) {
            this.aoI = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.main_input_username, (ViewGroup) null);
            this.aoK = (EditText) this.aoI.findViewById(r.g.account);
            this.aoK.setHint(this.Gf.getString(r.j.input_alias_limit_length_tip));
            this.aoR = (TextView) this.aoI.findViewById(r.g.back);
            this.aoR.setOnClickListener(new k(this));
            this.aoV = (TextView) this.aoI.findViewById(r.g.confirm);
            this.aoV.setOnClickListener(new l(this));
            this.aoW = (ProgressBar) this.aoI.findViewById(r.g.confirm_progress);
            this.aoU = (TextView) this.aoI.findViewById(r.g.error_info);
            this.aoL = (RadioGroup) this.aoI.findViewById(r.g.names_group1);
            this.aoM = (RadioGroup) this.aoI.findViewById(r.g.names_group2);
            this.aoO = (RadioButton) this.aoI.findViewById(r.g.name1);
            this.aoP = (RadioButton) this.aoI.findViewById(r.g.name2);
            this.aoQ = (RadioButton) this.aoI.findViewById(r.g.name3);
            this.aoN = new m(this);
            this.aoO.setOnCheckedChangeListener(this.aoN);
            this.aoP.setOnCheckedChangeListener(this.aoN);
            this.aoQ.setOnCheckedChangeListener(this.aoN);
            this.aoX = (TextView) this.aoI.findViewById(r.g.phone_info);
            AH();
            this.aoJ = new Dialog(this.Gf.getPageActivity(), r.k.input_username_dialog);
            this.aoJ.setCanceledOnTouchOutside(false);
            this.aoJ.setCancelable(false);
            this.aoJ.setCanceledOnTouchOutside(false);
            lR();
        }
        if (!this.aoJ.isShowing()) {
            this.aoK.setText((CharSequence) null);
            AH();
            eP(null);
            if (this.aoY == null || this.aoY.length() <= 0) {
                this.aoX.setText("Hi," + this.Gf.getString(r.j.bar_friend));
            } else {
                this.aoX.setText("Hi," + this.aoY);
            }
            if (!this.Gf.getPageActivity().isFinishing()) {
                this.aoJ.setContentView(this.aoI);
                com.baidu.adp.lib.h.j.a(this.aoJ, this.Gf);
                if (this.Gf.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.Gf.getOrignalPage()).ShowSoftKeyPadDelay(this.aoK, 150);
                }
            }
        }
    }

    public void AF() {
        String editable = this.aoK.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eP(this.Gf.getString(r.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eP(this.Gf.getString(r.j.input_alias_limit_length_tip));
        } else {
            if (this.aoT != null) {
                this.aoT.cancel();
            }
            if (this.aoS == null) {
                this.aoS = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.aoS.setPriority(3);
                this.aoS.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AG() {
        if (this.apb != null) {
            this.apb.j(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eP(this.Gf.getString(r.j.suggest_no_name));
            return;
        }
        eP(this.Gf.getString(r.j.suggest_some_names));
        int size = arrayList.size();
        this.aoL.clearCheck();
        this.aoM.clearCheck();
        this.aoL.setVisibility(0);
        this.aoM.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aoO.setText(arrayList.get(0));
            this.aoO.setChecked(false);
            this.aoO.setCompoundDrawables(this.apd, null, null, null);
            this.aoO.setVisibility(0);
            this.aoL.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aoP.setText(arrayList.get(1));
            this.aoP.setChecked(false);
            this.aoP.setCompoundDrawables(this.apd, null, null, null);
            this.aoP.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aoQ.setText(arrayList.get(2));
            this.aoQ.setChecked(false);
            this.aoQ.setCompoundDrawables(this.apd, null, null, null);
            this.aoQ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aoS != null) {
            this.aoS.cancel();
            this.aoS = null;
        }
        if (this.aoT != null) {
            this.aoT.cancel();
            this.aoT = null;
        }
        AI();
    }

    public void AH() {
        this.aoL.setVisibility(8);
        this.aoL.clearCheck();
        this.aoM.setVisibility(8);
        this.aoM.clearCheck();
        this.aoO.setVisibility(8);
        this.aoP.setVisibility(8);
        this.aoQ.setVisibility(8);
        this.aoO.setChecked(false);
        this.aoP.setChecked(false);
        this.aoQ.setChecked(false);
    }

    public void AI() {
        if (this.aoJ != null && this.aoJ.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.aoJ, this.Gf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(String str) {
        if (str == null) {
            this.aoU.setVisibility(4);
            this.aoU.setText((CharSequence) null);
            return;
        }
        this.aoU.setVisibility(0);
        this.aoU.setText(str);
    }

    public void lR() {
        this.Gf.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gf.getLayoutMode().x(this.aoI);
        this.aoK.setHintTextColor(ar.getColor(r.d.cp_cont_e));
        this.aoO.setCompoundDrawables(this.apd, null, null, null);
        this.aoP.setCompoundDrawables(this.apd, null, null, null);
        this.aoQ.setCompoundDrawables(this.apd, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private com.baidu.tbadk.core.util.z aiN = null;
        private String mAccount;
        private String mUrl;

        public c(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.aoS = null;
            j.this.aoW.setVisibility(8);
            j.this.aoV.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.aoS = null;
            j.this.aoW.setVisibility(8);
            j.this.aoV.setEnabled(true);
            if (fVar == null) {
                j.this.eP(this.aiN.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.AI();
                TbadkCoreApplication.setCurrentAccount(j.this.aoZ, j.this.Gf.getPageActivity());
                if (j.this.apa != null) {
                    j.this.apa.j(j.this.aoZ);
                }
            } else {
                j.this.o(fVar.xC());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.aoW.setVisibility(0);
            j.this.aoV.setEnabled(false);
            j.this.eP(null);
            j.this.AH();
            super.onPreExecute();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00ab */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0097 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0045 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0097 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0001 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v28 */
        /* JADX WARN: Type inference failed for: r0v29 */
        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tbadk.coreExtra.data.f] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v31 */
        /* JADX WARN: Type inference failed for: r1v15, types: [com.baidu.tbadk.core.data.AccountData] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            String str;
            Exception e;
            String uk;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.aiN = new com.baidu.tbadk.core.util.z(this.mUrl);
                this.aiN.n("un", this.mAccount);
                this.aiN.n("BDUSS", j.this.aoZ.getBDUSS());
                this.aiN.uI().vB().acr = false;
                uk = this.aiN.uk();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.aiN.uL()) {
                str = this.aiN.uM();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(uk);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.aoZ != null) {
                            j.this.aoZ.setAccount(userName);
                            j.this.aoZ.setBDUSS(bduss);
                            j.this.aoZ.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.aoZ;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.aiN.uM() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(uk);
                    str = fVar2;
                } else if (this.aiN.uM() == 1) {
                    j.this.AI();
                    str = 0;
                    return str;
                }
                return str;
            }
            str = 0;
            return str;
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private com.baidu.tbadk.core.util.z aiN;
        final /* synthetic */ j ape;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.ape.aoT = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.aiN = new com.baidu.tbadk.core.util.z(this.mUrl);
            this.aiN.n("un", this.mAccount);
            String uk = this.aiN.uk();
            if (!this.aiN.uL() || this.aiN.uM() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uk);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.ape.aoT = null;
            if (!this.aiN.uL()) {
                this.ape.eP(this.aiN.getErrorString());
            } else if (this.aiN.uM() == 0) {
                this.ape.eP(this.ape.Gf.getString(r.j.name_not_use));
            } else if (this.aiN.uM() == 36) {
                this.ape.eP(this.aiN.getErrorString());
                if (fVar != null) {
                    this.ape.o(fVar.xC());
                }
            } else {
                this.ape.eP(this.aiN.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ape.eP(null);
            this.ape.AH();
            super.onPreExecute();
        }
    }
}
