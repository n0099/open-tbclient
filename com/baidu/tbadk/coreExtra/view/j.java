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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> DQ;
    private Drawable alS;
    private Drawable alT;
    private int size;
    private View aly = null;
    private Dialog alz = null;
    private EditText alA = null;
    private RadioGroup alB = null;
    private RadioGroup alC = null;
    private CompoundButton.OnCheckedChangeListener alD = null;
    private RadioButton alE = null;
    private RadioButton alF = null;
    private RadioButton alG = null;
    private TextView alH = null;
    private c alI = null;
    private b alJ = null;
    private TextView alK = null;
    private TextView alL = null;
    private ProgressBar alM = null;
    private TextView alN = null;
    private String alO = null;
    private AccountData alP = null;
    private a alQ = null;
    private a alR = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.DQ = null;
        this.alS = null;
        this.alT = null;
        this.size = 0;
        this.DQ = tbPageContext;
        this.alS = av.getDrawable(u.f.icon_tips_names_s);
        this.alT = av.getDrawable(u.f.icon_tips_names_n);
        this.size = this.DQ.getResources().getDimensionPixelSize(u.e.ds26);
        this.alS.setBounds(0, 0, this.size, this.size);
        this.alT.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.alP = accountData;
    }

    public void a(a aVar) {
        this.alQ = aVar;
    }

    public void b(a aVar) {
        this.alR = aVar;
    }

    public void zs() {
        if (this.alz == null) {
            this.aly = LayoutInflater.from(this.DQ.getPageActivity()).inflate(u.h.main_input_username, (ViewGroup) null);
            this.alA = (EditText) this.aly.findViewById(u.g.account);
            this.alA.setHint(this.DQ.getString(u.j.input_alias_limit_length_tip));
            this.alH = (TextView) this.aly.findViewById(u.g.back);
            this.alH.setOnClickListener(new k(this));
            this.alL = (TextView) this.aly.findViewById(u.g.confirm);
            this.alL.setOnClickListener(new l(this));
            this.alM = (ProgressBar) this.aly.findViewById(u.g.confirm_progress);
            this.alK = (TextView) this.aly.findViewById(u.g.error_info);
            this.alB = (RadioGroup) this.aly.findViewById(u.g.names_group1);
            this.alC = (RadioGroup) this.aly.findViewById(u.g.names_group2);
            this.alE = (RadioButton) this.aly.findViewById(u.g.name1);
            this.alF = (RadioButton) this.aly.findViewById(u.g.name2);
            this.alG = (RadioButton) this.aly.findViewById(u.g.name3);
            this.alD = new m(this);
            this.alE.setOnCheckedChangeListener(this.alD);
            this.alF.setOnCheckedChangeListener(this.alD);
            this.alG.setOnCheckedChangeListener(this.alD);
            this.alN = (TextView) this.aly.findViewById(u.g.phone_info);
            zv();
            this.alz = new Dialog(this.DQ.getPageActivity(), u.k.input_username_dialog);
            this.alz.setCanceledOnTouchOutside(false);
            this.alz.setCancelable(false);
            this.alz.setCanceledOnTouchOutside(false);
            kT();
        }
        if (!this.alz.isShowing()) {
            this.alA.setText((CharSequence) null);
            zv();
            eL(null);
            if (this.alO == null || this.alO.length() <= 0) {
                this.alN.setText("Hi," + this.DQ.getString(u.j.bar_friend));
            } else {
                this.alN.setText("Hi," + this.alO);
            }
            if (!this.DQ.getPageActivity().isFinishing()) {
                this.alz.setContentView(this.aly);
                com.baidu.adp.lib.h.j.a(this.alz, this.DQ);
                if (this.DQ.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.DQ.getOrignalPage()).ShowSoftKeyPadDelay(this.alA, 150);
                }
            }
        }
    }

    public void zt() {
        String editable = this.alA.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eL(this.DQ.getString(u.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eL(this.DQ.getString(u.j.input_alias_limit_length_tip));
        } else {
            if (this.alJ != null) {
                this.alJ.cancel();
            }
            if (this.alI == null) {
                this.alI = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.alI.setPriority(3);
                this.alI.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zu() {
        if (this.alR != null) {
            this.alR.i(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eL(this.DQ.getString(u.j.suggest_no_name));
            return;
        }
        eL(this.DQ.getString(u.j.suggest_some_names));
        int size = arrayList.size();
        this.alB.clearCheck();
        this.alC.clearCheck();
        this.alB.setVisibility(0);
        this.alC.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.alE.setText(arrayList.get(0));
            this.alE.setChecked(false);
            this.alE.setCompoundDrawables(this.alT, null, null, null);
            this.alE.setVisibility(0);
            this.alB.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.alF.setText(arrayList.get(1));
            this.alF.setChecked(false);
            this.alF.setCompoundDrawables(this.alT, null, null, null);
            this.alF.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.alG.setText(arrayList.get(2));
            this.alG.setChecked(false);
            this.alG.setCompoundDrawables(this.alT, null, null, null);
            this.alG.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.alI != null) {
            this.alI.cancel();
            this.alI = null;
        }
        if (this.alJ != null) {
            this.alJ.cancel();
            this.alJ = null;
        }
        zw();
    }

    public void zv() {
        this.alB.setVisibility(8);
        this.alB.clearCheck();
        this.alC.setVisibility(8);
        this.alC.clearCheck();
        this.alE.setVisibility(8);
        this.alF.setVisibility(8);
        this.alG.setVisibility(8);
        this.alE.setChecked(false);
        this.alF.setChecked(false);
        this.alG.setChecked(false);
    }

    public void zw() {
        if (this.alz != null && this.alz.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.alz, this.DQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(String str) {
        if (str == null) {
            this.alK.setVisibility(4);
            this.alK.setText((CharSequence) null);
            return;
        }
        this.alK.setVisibility(0);
        this.alK.setText(str);
    }

    public void kT() {
        this.DQ.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
        this.DQ.getLayoutMode().w(this.aly);
        this.alA.setHintTextColor(av.getColor(u.d.cp_cont_e));
        this.alE.setCompoundDrawables(this.alT, null, null, null);
        this.alF.setCompoundDrawables(this.alT, null, null, null);
        this.alG.setCompoundDrawables(this.alT, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.c> {
        private com.baidu.tbadk.core.util.ab afX = null;
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
            j.this.alI = null;
            j.this.alM.setVisibility(8);
            j.this.alL.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.c cVar) {
            super.onPostExecute(cVar);
            j.this.alI = null;
            j.this.alM.setVisibility(8);
            j.this.alL.setEnabled(true);
            if (cVar == null) {
                j.this.eL(this.afX.getErrorString());
            } else if (cVar.getUser().getUserName() != null) {
                j.this.zw();
                TbadkCoreApplication.setCurrentAccount(j.this.alP, j.this.DQ.getPageActivity());
                if (j.this.alQ != null) {
                    j.this.alQ.i(j.this.alP);
                }
            } else {
                j.this.n(cVar.wv());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.alM.setVisibility(0);
            j.this.alL.setEnabled(false);
            j.this.eL(null);
            j.this.zv();
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
        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tbadk.coreExtra.data.c] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v31 */
        /* JADX WARN: Type inference failed for: r1v15, types: [com.baidu.tbadk.core.data.AccountData] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.c doInBackground(String... strArr) {
            String str;
            Exception e;
            String sZ;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.afX = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.afX.n("un", this.mAccount);
                this.afX.n("BDUSS", j.this.alP.getBDUSS());
                this.afX.tx().uu().ZA = false;
                sZ = this.afX.sZ();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.afX.tA()) {
                str = this.afX.tB();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
                    cVar.parserJson(sZ);
                    String userName = cVar.getUser().getUserName();
                    String bduss = cVar.getUser().getBDUSS();
                    str = cVar;
                    str = cVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = cVar;
                        str2 = userName;
                        if (j.this.alP != null) {
                            j.this.alP.setAccount(userName);
                            j.this.alP.setBDUSS(bduss);
                            j.this.alP.setPortrait(cVar.getUser().getPortrait());
                            ?? r1 = j.this.alP;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = cVar;
                            str2 = r1;
                        }
                    }
                } else if (this.afX.tB() == 36) {
                    com.baidu.tbadk.coreExtra.data.c cVar2 = new com.baidu.tbadk.coreExtra.data.c();
                    cVar2.parserJson(sZ);
                    str = cVar2;
                } else if (this.afX.tB() == 1) {
                    j.this.zw();
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
    private class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.c> {
        private com.baidu.tbadk.core.util.ab afX;
        final /* synthetic */ j alU;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.alU.alJ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.c doInBackground(String... strArr) {
            this.afX = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.afX.n("un", this.mAccount);
            String sZ = this.afX.sZ();
            if (!this.afX.tA() || this.afX.tB() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
            cVar.parserJson(sZ);
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.c cVar) {
            super.onPostExecute(cVar);
            this.alU.alJ = null;
            if (!this.afX.tA()) {
                this.alU.eL(this.afX.getErrorString());
            } else if (this.afX.tB() == 0) {
                this.alU.eL(this.alU.DQ.getString(u.j.name_not_use));
            } else if (this.afX.tB() == 36) {
                this.alU.eL(this.afX.getErrorString());
                if (cVar != null) {
                    this.alU.n(cVar.wv());
                }
            } else {
                this.alU.eL(this.afX.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.alU.eL(null);
            this.alU.zv();
            super.onPreExecute();
        }
    }
}
