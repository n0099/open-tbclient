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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    private Drawable alF;
    private Drawable alG;
    private TbPageContext<?> mContext;
    private int size;
    private View all = null;
    private Dialog alm = null;
    private EditText aln = null;
    private RadioGroup alo = null;
    private RadioGroup alp = null;
    private CompoundButton.OnCheckedChangeListener alq = null;
    private RadioButton alr = null;
    private RadioButton als = null;
    private RadioButton alt = null;
    private TextView alu = null;
    private c alv = null;
    private b alw = null;
    private TextView alx = null;
    private TextView aly = null;
    private ProgressBar alz = null;
    private TextView alA = null;
    private String alB = null;
    private AccountData alC = null;
    private a alD = null;
    private a alE = null;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public k(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.alF = null;
        this.alG = null;
        this.size = 0;
        this.mContext = tbPageContext;
        this.alF = al.getDrawable(i.e.icon_tips_names_s);
        this.alG = al.getDrawable(i.e.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(i.d.ds26);
        this.alF.setBounds(0, 0, this.size, this.size);
        this.alG.setBounds(0, 0, this.size, this.size);
    }

    public void k(AccountData accountData) {
        this.alC = accountData;
    }

    public void a(a aVar) {
        this.alD = aVar;
    }

    public void b(a aVar) {
        this.alE = aVar;
    }

    public void ze() {
        if (this.alm == null) {
            this.all = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.main_input_username, (ViewGroup) null);
            this.aln = (EditText) this.all.findViewById(i.f.account);
            this.aln.setHint(this.mContext.getString(i.h.input_alias_limit_length_tip));
            this.alu = (TextView) this.all.findViewById(i.f.back);
            this.alu.setOnClickListener(new l(this));
            this.aly = (TextView) this.all.findViewById(i.f.confirm);
            this.aly.setOnClickListener(new m(this));
            this.alz = (ProgressBar) this.all.findViewById(i.f.confirm_progress);
            this.alx = (TextView) this.all.findViewById(i.f.error_info);
            this.alo = (RadioGroup) this.all.findViewById(i.f.names_group1);
            this.alp = (RadioGroup) this.all.findViewById(i.f.names_group2);
            this.alr = (RadioButton) this.all.findViewById(i.f.name1);
            this.als = (RadioButton) this.all.findViewById(i.f.name2);
            this.alt = (RadioButton) this.all.findViewById(i.f.name3);
            this.alq = new n(this);
            this.alr.setOnCheckedChangeListener(this.alq);
            this.als.setOnCheckedChangeListener(this.alq);
            this.alt.setOnCheckedChangeListener(this.alq);
            this.alA = (TextView) this.all.findViewById(i.f.phone_info);
            zh();
            this.alm = new Dialog(this.mContext.getPageActivity(), i.C0057i.input_username_dialog);
            this.alm.setCanceledOnTouchOutside(false);
            this.alm.setCancelable(false);
            this.alm.setCanceledOnTouchOutside(false);
            oN();
        }
        if (!this.alm.isShowing()) {
            this.aln.setText((CharSequence) null);
            zh();
            er(null);
            if (this.alB == null || this.alB.length() <= 0) {
                this.alA.setText("Hi," + this.mContext.getString(i.h.bar_friend));
            } else {
                this.alA.setText("Hi," + this.alB);
            }
            if (!this.mContext.getPageActivity().isFinishing()) {
                this.alm.setContentView(this.all);
                com.baidu.adp.lib.g.j.a(this.alm, this.mContext);
                if (this.mContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.mContext.getOrignalPage()).ShowSoftKeyPadDelay(this.aln, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
                }
            }
        }
    }

    public void zf() {
        String editable = this.aln.getText().toString();
        if (editable == null || editable.length() <= 0) {
            er(this.mContext.getString(i.h.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            er(this.mContext.getString(i.h.input_alias_limit_length_tip));
        } else {
            if (this.alw != null) {
                this.alw.cancel();
            }
            if (this.alv == null) {
                this.alv = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.alv.setPriority(3);
                this.alv.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg() {
        if (this.alE != null) {
            this.alE.g(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            er(this.mContext.getString(i.h.suggest_no_name));
            return;
        }
        er(this.mContext.getString(i.h.suggest_some_names));
        int size = arrayList.size();
        this.alo.clearCheck();
        this.alp.clearCheck();
        this.alo.setVisibility(0);
        this.alp.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.alr.setText(arrayList.get(0));
            this.alr.setChecked(false);
            this.alr.setCompoundDrawables(this.alG, null, null, null);
            this.alr.setVisibility(0);
            this.alo.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.als.setText(arrayList.get(1));
            this.als.setChecked(false);
            this.als.setCompoundDrawables(this.alG, null, null, null);
            this.als.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.alt.setText(arrayList.get(2));
            this.alt.setChecked(false);
            this.alt.setCompoundDrawables(this.alG, null, null, null);
            this.alt.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.alv != null) {
            this.alv.cancel();
            this.alv = null;
        }
        if (this.alw != null) {
            this.alw.cancel();
            this.alw = null;
        }
        zi();
    }

    public void zh() {
        this.alo.setVisibility(8);
        this.alo.clearCheck();
        this.alp.setVisibility(8);
        this.alp.clearCheck();
        this.alr.setVisibility(8);
        this.als.setVisibility(8);
        this.alt.setVisibility(8);
        this.alr.setChecked(false);
        this.als.setChecked(false);
        this.alt.setChecked(false);
    }

    public void zi() {
        if (this.alm != null && this.alm.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.alm, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(String str) {
        if (str == null) {
            this.alx.setVisibility(4);
            this.alx.setText((CharSequence) null);
            return;
        }
        this.alx.setVisibility(0);
        this.alx.setText(str);
    }

    public void oN() {
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(this.all);
        this.aln.setHintTextColor(al.getColor(i.c.cp_cont_e));
        this.alr.setCompoundDrawables(this.alG, null, null, null);
        this.als.setCompoundDrawables(this.alG, null, null, null);
        this.alt.setCompoundDrawables(this.alG, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
        private com.baidu.tbadk.core.util.v afT = null;
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
            k.this.alv = null;
            k.this.alz.setVisibility(8);
            k.this.aly.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
            super.onPostExecute(aVar);
            k.this.alv = null;
            k.this.alz.setVisibility(8);
            k.this.aly.setEnabled(true);
            if (aVar == null) {
                k.this.er(this.afT.getErrorString());
            } else if (aVar.getUser().getUserName() != null) {
                k.this.zi();
                TbadkCoreApplication.setCurrentAccount(k.this.alC, k.this.mContext.getPageActivity());
                if (k.this.alD != null) {
                    k.this.alD.g(k.this.alC);
                }
            } else {
                k.this.n(aVar.wt());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.alz.setVisibility(0);
            k.this.aly.setEnabled(false);
            k.this.er(null);
            k.this.zh();
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
        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tbadk.coreExtra.data.a] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v31 */
        /* JADX WARN: Type inference failed for: r1v15, types: [com.baidu.tbadk.core.data.AccountData] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
            String str;
            Exception e;
            String tI;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.afT = new com.baidu.tbadk.core.util.v(this.mUrl);
                this.afT.o("un", this.mAccount);
                this.afT.o("BDUSS", k.this.alC.getBDUSS());
                this.afT.uj().uZ().abM = false;
                tI = this.afT.tI();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.afT.um()) {
                str = this.afT.un();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
                    aVar.parserJson(tI);
                    String userName = aVar.getUser().getUserName();
                    String bduss = aVar.getUser().getBDUSS();
                    str = aVar;
                    str = aVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = aVar;
                        str2 = userName;
                        if (k.this.alC != null) {
                            k.this.alC.setAccount(userName);
                            k.this.alC.setBDUSS(bduss);
                            k.this.alC.setPortrait(aVar.getUser().getPortrait());
                            ?? r1 = k.this.alC;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = aVar;
                            str2 = r1;
                        }
                    }
                } else if (this.afT.un() == 36) {
                    com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                    aVar2.parserJson(tI);
                    str = aVar2;
                } else if (this.afT.un() == 1) {
                    k.this.zi();
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
    private class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
        private com.baidu.tbadk.core.util.v afT;
        final /* synthetic */ k alH;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.alH.alw = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
            this.afT = new com.baidu.tbadk.core.util.v(this.mUrl);
            this.afT.o("un", this.mAccount);
            String tI = this.afT.tI();
            if (!this.afT.um() || this.afT.un() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
            aVar.parserJson(tI);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
            super.onPostExecute(aVar);
            this.alH.alw = null;
            if (!this.afT.um()) {
                this.alH.er(this.afT.getErrorString());
            } else if (this.afT.un() == 0) {
                this.alH.er(this.alH.mContext.getString(i.h.name_not_use));
            } else if (this.afT.un() == 36) {
                this.alH.er(this.afT.getErrorString());
                if (aVar != null) {
                    this.alH.n(aVar.wt());
                }
            } else {
                this.alH.er(this.afT.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.alH.er(null);
            this.alH.zh();
            super.onPreExecute();
        }
    }
}
