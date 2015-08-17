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
public class l {
    private TbPageContext<?> LS;
    private View akT = null;
    private Dialog akU = null;
    private EditText akV = null;
    private RadioGroup akW = null;
    private RadioGroup akX = null;
    private CompoundButton.OnCheckedChangeListener akY = null;
    private RadioButton akZ = null;
    private RadioButton ala = null;
    private RadioButton alb = null;
    private TextView alc = null;
    private c ald = null;
    private b ale = null;
    private TextView alf = null;
    private TextView alg = null;
    private ProgressBar alh = null;
    private TextView ali = null;
    private String alj = null;
    private AccountData alk = null;
    private a all = null;
    private a alm = null;
    private Drawable aln;
    private Drawable alo;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public l(TbPageContext<?> tbPageContext) {
        this.LS = null;
        this.aln = null;
        this.alo = null;
        this.size = 0;
        this.LS = tbPageContext;
        this.aln = al.getDrawable(i.e.icon_tips_names_s);
        this.alo = al.getDrawable(i.e.icon_tips_names_n);
        this.size = this.LS.getResources().getDimensionPixelSize(i.d.ds26);
        this.aln.setBounds(0, 0, this.size, this.size);
        this.alo.setBounds(0, 0, this.size, this.size);
    }

    public void setPhone(String str) {
        this.alj = str;
    }

    public void l(AccountData accountData) {
        this.alk = accountData;
    }

    public void a(a aVar) {
        this.all = aVar;
    }

    public void b(a aVar) {
        this.alm = aVar;
    }

    public void yY() {
        if (this.akU == null) {
            this.akT = LayoutInflater.from(this.LS.getPageActivity()).inflate(i.g.main_input_username, (ViewGroup) null);
            this.akV = (EditText) this.akT.findViewById(i.f.account);
            this.akV.setHint(this.LS.getString(i.C0057i.input_alias_limit_length_tip));
            this.alc = (TextView) this.akT.findViewById(i.f.back);
            this.alc.setOnClickListener(new m(this));
            this.alg = (TextView) this.akT.findViewById(i.f.confirm);
            this.alg.setOnClickListener(new n(this));
            this.alh = (ProgressBar) this.akT.findViewById(i.f.confirm_progress);
            this.alf = (TextView) this.akT.findViewById(i.f.error_info);
            this.akW = (RadioGroup) this.akT.findViewById(i.f.names_group1);
            this.akX = (RadioGroup) this.akT.findViewById(i.f.names_group2);
            this.akZ = (RadioButton) this.akT.findViewById(i.f.name1);
            this.ala = (RadioButton) this.akT.findViewById(i.f.name2);
            this.alb = (RadioButton) this.akT.findViewById(i.f.name3);
            this.akY = new o(this);
            this.akZ.setOnCheckedChangeListener(this.akY);
            this.ala.setOnCheckedChangeListener(this.akY);
            this.alb.setOnCheckedChangeListener(this.akY);
            this.ali = (TextView) this.akT.findViewById(i.f.phone_info);
            zb();
            this.akU = new Dialog(this.LS.getPageActivity(), i.j.input_username_dialog);
            this.akU.setCanceledOnTouchOutside(false);
            this.akU.setCancelable(false);
            this.akU.setCanceledOnTouchOutside(false);
            oQ();
        }
        if (!this.akU.isShowing()) {
            this.akV.setText((CharSequence) null);
            zb();
            ek(null);
            if (this.alj == null || this.alj.length() <= 0) {
                this.ali.setText("Hi," + this.LS.getString(i.C0057i.bar_friend));
            } else {
                this.ali.setText("Hi," + this.alj);
            }
            if (!this.LS.getPageActivity().isFinishing()) {
                this.akU.setContentView(this.akT);
                com.baidu.adp.lib.g.j.a(this.akU, this.LS);
                if (this.LS.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.LS.getOrignalPage()).ShowSoftKeyPadDelay(this.akV, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
                }
            }
        }
    }

    public void yZ() {
        String editable = this.akV.getText().toString();
        if (editable == null || editable.length() <= 0) {
            ek(this.LS.getString(i.C0057i.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            ek(this.LS.getString(i.C0057i.input_alias_limit_length_tip));
        } else {
            if (this.ale != null) {
                this.ale.cancel();
            }
            if (this.ald == null) {
                this.ald = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.ald.setPriority(3);
                this.ald.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za() {
        if (this.alm != null) {
            this.alm.g(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            ek(this.LS.getString(i.C0057i.suggest_no_name));
            return;
        }
        ek(this.LS.getString(i.C0057i.suggest_some_names));
        int size = arrayList.size();
        this.akW.clearCheck();
        this.akX.clearCheck();
        this.akW.setVisibility(0);
        this.akX.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.akZ.setText(arrayList.get(0));
            this.akZ.setChecked(false);
            this.akZ.setCompoundDrawables(this.alo, null, null, null);
            this.akZ.setVisibility(0);
            this.akW.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.ala.setText(arrayList.get(1));
            this.ala.setChecked(false);
            this.ala.setCompoundDrawables(this.alo, null, null, null);
            this.ala.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.alb.setText(arrayList.get(2));
            this.alb.setChecked(false);
            this.alb.setCompoundDrawables(this.alo, null, null, null);
            this.alb.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.ald != null) {
            this.ald.cancel();
            this.ald = null;
        }
        if (this.ale != null) {
            this.ale.cancel();
            this.ale = null;
        }
        zc();
    }

    public boolean isShowing() {
        return this.akU != null && this.akU.isShowing();
    }

    public void zb() {
        this.akW.setVisibility(8);
        this.akW.clearCheck();
        this.akX.setVisibility(8);
        this.akX.clearCheck();
        this.akZ.setVisibility(8);
        this.ala.setVisibility(8);
        this.alb.setVisibility(8);
        this.akZ.setChecked(false);
        this.ala.setChecked(false);
        this.alb.setChecked(false);
    }

    public void zc() {
        if (this.akU != null && this.akU.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.akU, this.LS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ek(String str) {
        if (str == null) {
            this.alf.setVisibility(4);
            this.alf.setText((CharSequence) null);
            return;
        }
        this.alf.setVisibility(0);
        this.alf.setText(str);
    }

    public void oQ() {
        this.LS.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.LS.getLayoutMode().k(this.akT);
        this.akV.setHintTextColor(al.getColor(i.c.cp_cont_e));
        this.akZ.setCompoundDrawables(this.alo, null, null, null);
        this.ala.setCompoundDrawables(this.alo, null, null, null);
        this.alb.setCompoundDrawables(this.alo, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
        private com.baidu.tbadk.core.util.v afJ = null;
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
            l.this.ald = null;
            l.this.alh.setVisibility(8);
            l.this.alg.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
            super.onPostExecute(aVar);
            l.this.ald = null;
            l.this.alh.setVisibility(8);
            l.this.alg.setEnabled(true);
            if (aVar == null) {
                l.this.ek(this.afJ.getErrorString());
            } else if (aVar.getUser().getUserName() != null) {
                l.this.zc();
                TbadkCoreApplication.setCurrentAccount(l.this.alk, l.this.LS.getPageActivity());
                if (l.this.all != null) {
                    l.this.all.g(l.this.alk);
                }
            } else {
                l.this.o(aVar.rN());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            l.this.alh.setVisibility(0);
            l.this.alg.setEnabled(false);
            l.this.ek(null);
            l.this.zb();
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
        /* renamed from: j */
        public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
            String str;
            Exception e;
            String tD;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.afJ = new com.baidu.tbadk.core.util.v(this.mUrl);
                this.afJ.o("un", this.mAccount);
                this.afJ.o("BDUSS", l.this.alk.getBDUSS());
                this.afJ.ue().uV().abE = false;
                tD = this.afJ.tD();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.afJ.uh()) {
                str = this.afJ.ui();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
                    aVar.parserJson(tD);
                    String userName = aVar.getUser().getUserName();
                    String bduss = aVar.getUser().getBDUSS();
                    str = aVar;
                    str = aVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = aVar;
                        str2 = userName;
                        if (l.this.alk != null) {
                            l.this.alk.setAccount(userName);
                            l.this.alk.setBDUSS(bduss);
                            l.this.alk.setPortrait(aVar.getUser().getPortrait());
                            ?? r1 = l.this.alk;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = aVar;
                            str2 = r1;
                        }
                    }
                } else if (this.afJ.ui() == 36) {
                    com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                    aVar2.parserJson(tD);
                    str = aVar2;
                } else if (this.afJ.ui() == 1) {
                    l.this.zc();
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
        private com.baidu.tbadk.core.util.v afJ;
        final /* synthetic */ l alp;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.alp.ale = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
            this.afJ = new com.baidu.tbadk.core.util.v(this.mUrl);
            this.afJ.o("un", this.mAccount);
            String tD = this.afJ.tD();
            if (!this.afJ.uh() || this.afJ.ui() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
            aVar.parserJson(tD);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
            super.onPostExecute(aVar);
            this.alp.ale = null;
            if (!this.afJ.uh()) {
                this.alp.ek(this.afJ.getErrorString());
            } else if (this.afJ.ui() == 0) {
                this.alp.ek(this.alp.LS.getString(i.C0057i.name_not_use));
            } else if (this.afJ.ui() == 36) {
                this.alp.ek(this.afJ.getErrorString());
                if (aVar != null) {
                    this.alp.o(aVar.rN());
                }
            } else {
                this.alp.ek(this.afJ.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.alp.ek(null);
            this.alp.zb();
            super.onPreExecute();
        }
    }
}
