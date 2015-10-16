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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    private Drawable akB;
    private Drawable akC;
    private TbPageContext<?> mContext;
    private int size;
    private View akh = null;
    private Dialog aki = null;
    private EditText akj = null;
    private RadioGroup akk = null;
    private RadioGroup akl = null;
    private CompoundButton.OnCheckedChangeListener akm = null;
    private RadioButton akn = null;
    private RadioButton ako = null;
    private RadioButton akp = null;
    private TextView akq = null;
    private c akr = null;
    private b aks = null;
    private TextView akt = null;
    private TextView aku = null;
    private ProgressBar akv = null;
    private TextView akw = null;
    private String akx = null;
    private AccountData aky = null;
    private a akz = null;
    private a akA = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public k(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.akB = null;
        this.akC = null;
        this.size = 0;
        this.mContext = tbPageContext;
        this.akB = an.getDrawable(i.e.icon_tips_names_s);
        this.akC = an.getDrawable(i.e.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(i.d.ds26);
        this.akB.setBounds(0, 0, this.size, this.size);
        this.akC.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.aky = accountData;
    }

    public void a(a aVar) {
        this.akz = aVar;
    }

    public void b(a aVar) {
        this.akA = aVar;
    }

    public void yN() {
        if (this.aki == null) {
            this.akh = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.main_input_username, (ViewGroup) null);
            this.akj = (EditText) this.akh.findViewById(i.f.account);
            this.akj.setHint(this.mContext.getString(i.h.input_alias_limit_length_tip));
            this.akq = (TextView) this.akh.findViewById(i.f.back);
            this.akq.setOnClickListener(new l(this));
            this.aku = (TextView) this.akh.findViewById(i.f.confirm);
            this.aku.setOnClickListener(new m(this));
            this.akv = (ProgressBar) this.akh.findViewById(i.f.confirm_progress);
            this.akt = (TextView) this.akh.findViewById(i.f.error_info);
            this.akk = (RadioGroup) this.akh.findViewById(i.f.names_group1);
            this.akl = (RadioGroup) this.akh.findViewById(i.f.names_group2);
            this.akn = (RadioButton) this.akh.findViewById(i.f.name1);
            this.ako = (RadioButton) this.akh.findViewById(i.f.name2);
            this.akp = (RadioButton) this.akh.findViewById(i.f.name3);
            this.akm = new n(this);
            this.akn.setOnCheckedChangeListener(this.akm);
            this.ako.setOnCheckedChangeListener(this.akm);
            this.akp.setOnCheckedChangeListener(this.akm);
            this.akw = (TextView) this.akh.findViewById(i.f.phone_info);
            yQ();
            this.aki = new Dialog(this.mContext.getPageActivity(), i.C0057i.input_username_dialog);
            this.aki.setCanceledOnTouchOutside(false);
            this.aki.setCancelable(false);
            this.aki.setCanceledOnTouchOutside(false);
            oO();
        }
        if (!this.aki.isShowing()) {
            this.akj.setText((CharSequence) null);
            yQ();
            et(null);
            if (this.akx == null || this.akx.length() <= 0) {
                this.akw.setText("Hi," + this.mContext.getString(i.h.bar_friend));
            } else {
                this.akw.setText("Hi," + this.akx);
            }
            if (!this.mContext.getPageActivity().isFinishing()) {
                this.aki.setContentView(this.akh);
                com.baidu.adp.lib.g.j.a(this.aki, this.mContext);
                if (this.mContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.mContext.getOrignalPage()).ShowSoftKeyPadDelay(this.akj, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
                }
            }
        }
    }

    public void yO() {
        String editable = this.akj.getText().toString();
        if (editable == null || editable.length() <= 0) {
            et(this.mContext.getString(i.h.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            et(this.mContext.getString(i.h.input_alias_limit_length_tip));
        } else {
            if (this.aks != null) {
                this.aks.cancel();
            }
            if (this.akr == null) {
                this.akr = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.akr.setPriority(3);
                this.akr.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP() {
        if (this.akA != null) {
            this.akA.i(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            et(this.mContext.getString(i.h.suggest_no_name));
            return;
        }
        et(this.mContext.getString(i.h.suggest_some_names));
        int size = arrayList.size();
        this.akk.clearCheck();
        this.akl.clearCheck();
        this.akk.setVisibility(0);
        this.akl.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.akn.setText(arrayList.get(0));
            this.akn.setChecked(false);
            this.akn.setCompoundDrawables(this.akC, null, null, null);
            this.akn.setVisibility(0);
            this.akk.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.ako.setText(arrayList.get(1));
            this.ako.setChecked(false);
            this.ako.setCompoundDrawables(this.akC, null, null, null);
            this.ako.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.akp.setText(arrayList.get(2));
            this.akp.setChecked(false);
            this.akp.setCompoundDrawables(this.akC, null, null, null);
            this.akp.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.akr != null) {
            this.akr.cancel();
            this.akr = null;
        }
        if (this.aks != null) {
            this.aks.cancel();
            this.aks = null;
        }
        yR();
    }

    public void yQ() {
        this.akk.setVisibility(8);
        this.akk.clearCheck();
        this.akl.setVisibility(8);
        this.akl.clearCheck();
        this.akn.setVisibility(8);
        this.ako.setVisibility(8);
        this.akp.setVisibility(8);
        this.akn.setChecked(false);
        this.ako.setChecked(false);
        this.akp.setChecked(false);
    }

    public void yR() {
        if (this.aki != null && this.aki.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.aki, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(String str) {
        if (str == null) {
            this.akt.setVisibility(4);
            this.akt.setText((CharSequence) null);
            return;
        }
        this.akt.setVisibility(0);
        this.akt.setText(str);
    }

    public void oO() {
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(this.akh);
        this.akj.setHintTextColor(an.getColor(i.c.cp_cont_e));
        this.akn.setCompoundDrawables(this.akC, null, null, null);
        this.ako.setCompoundDrawables(this.akC, null, null, null);
        this.akp.setCompoundDrawables(this.akC, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
        private com.baidu.tbadk.core.util.w afh = null;
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
            k.this.akr = null;
            k.this.akv.setVisibility(8);
            k.this.aku.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
            super.onPostExecute(aVar);
            k.this.akr = null;
            k.this.akv.setVisibility(8);
            k.this.aku.setEnabled(true);
            if (aVar == null) {
                k.this.et(this.afh.getErrorString());
            } else if (aVar.getUser().getUserName() != null) {
                k.this.yR();
                TbadkCoreApplication.setCurrentAccount(k.this.aky, k.this.mContext.getPageActivity());
                if (k.this.akz != null) {
                    k.this.akz.i(k.this.aky);
                }
            } else {
                k.this.n(aVar.we());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.akv.setVisibility(0);
            k.this.aku.setEnabled(false);
            k.this.et(null);
            k.this.yQ();
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
            String tG;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.afh = new com.baidu.tbadk.core.util.w(this.mUrl);
                this.afh.o("un", this.mAccount);
                this.afh.o("BDUSS", k.this.aky.getBDUSS());
                this.afh.uh().uY().abO = false;
                tG = this.afh.tG();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.afh.uk()) {
                str = this.afh.ul();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
                    aVar.parserJson(tG);
                    String userName = aVar.getUser().getUserName();
                    String bduss = aVar.getUser().getBDUSS();
                    str = aVar;
                    str = aVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = aVar;
                        str2 = userName;
                        if (k.this.aky != null) {
                            k.this.aky.setAccount(userName);
                            k.this.aky.setBDUSS(bduss);
                            k.this.aky.setPortrait(aVar.getUser().getPortrait());
                            ?? r1 = k.this.aky;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = aVar;
                            str2 = r1;
                        }
                    }
                } else if (this.afh.ul() == 36) {
                    com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                    aVar2.parserJson(tG);
                    str = aVar2;
                } else if (this.afh.ul() == 1) {
                    k.this.yR();
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
        private com.baidu.tbadk.core.util.w afh;
        final /* synthetic */ k akD;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.akD.aks = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
            this.afh = new com.baidu.tbadk.core.util.w(this.mUrl);
            this.afh.o("un", this.mAccount);
            String tG = this.afh.tG();
            if (!this.afh.uk() || this.afh.ul() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
            aVar.parserJson(tG);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
            super.onPostExecute(aVar);
            this.akD.aks = null;
            if (!this.afh.uk()) {
                this.akD.et(this.afh.getErrorString());
            } else if (this.afh.ul() == 0) {
                this.akD.et(this.akD.mContext.getString(i.h.name_not_use));
            } else if (this.afh.ul() == 36) {
                this.akD.et(this.afh.getErrorString());
                if (aVar != null) {
                    this.akD.n(aVar.we());
                }
            } else {
                this.akD.et(this.afh.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.akD.et(null);
            this.akD.yQ();
            super.onPreExecute();
        }
    }
}
