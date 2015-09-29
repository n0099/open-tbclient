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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    private Drawable akA;
    private Drawable akB;
    private View akg = null;
    private Dialog akh = null;
    private EditText aki = null;
    private RadioGroup akj = null;
    private RadioGroup akk = null;
    private CompoundButton.OnCheckedChangeListener akl = null;
    private RadioButton akm = null;
    private RadioButton akn = null;
    private RadioButton ako = null;
    private TextView akp = null;
    private c akq = null;
    private b akr = null;
    private TextView aks = null;
    private TextView akt = null;
    private ProgressBar aku = null;
    private TextView akv = null;
    private String akw = null;
    private AccountData akx = null;
    private a aky = null;
    private a akz = null;
    private TbPageContext<?> mContext;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public k(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.akA = null;
        this.akB = null;
        this.size = 0;
        this.mContext = tbPageContext;
        this.akA = am.getDrawable(i.e.icon_tips_names_s);
        this.akB = am.getDrawable(i.e.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(i.d.ds26);
        this.akA.setBounds(0, 0, this.size, this.size);
        this.akB.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.akx = accountData;
    }

    public void a(a aVar) {
        this.aky = aVar;
    }

    public void b(a aVar) {
        this.akz = aVar;
    }

    public void yN() {
        if (this.akh == null) {
            this.akg = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.main_input_username, (ViewGroup) null);
            this.aki = (EditText) this.akg.findViewById(i.f.account);
            this.aki.setHint(this.mContext.getString(i.h.input_alias_limit_length_tip));
            this.akp = (TextView) this.akg.findViewById(i.f.back);
            this.akp.setOnClickListener(new l(this));
            this.akt = (TextView) this.akg.findViewById(i.f.confirm);
            this.akt.setOnClickListener(new m(this));
            this.aku = (ProgressBar) this.akg.findViewById(i.f.confirm_progress);
            this.aks = (TextView) this.akg.findViewById(i.f.error_info);
            this.akj = (RadioGroup) this.akg.findViewById(i.f.names_group1);
            this.akk = (RadioGroup) this.akg.findViewById(i.f.names_group2);
            this.akm = (RadioButton) this.akg.findViewById(i.f.name1);
            this.akn = (RadioButton) this.akg.findViewById(i.f.name2);
            this.ako = (RadioButton) this.akg.findViewById(i.f.name3);
            this.akl = new n(this);
            this.akm.setOnCheckedChangeListener(this.akl);
            this.akn.setOnCheckedChangeListener(this.akl);
            this.ako.setOnCheckedChangeListener(this.akl);
            this.akv = (TextView) this.akg.findViewById(i.f.phone_info);
            yQ();
            this.akh = new Dialog(this.mContext.getPageActivity(), i.C0057i.input_username_dialog);
            this.akh.setCanceledOnTouchOutside(false);
            this.akh.setCancelable(false);
            this.akh.setCanceledOnTouchOutside(false);
            oO();
        }
        if (!this.akh.isShowing()) {
            this.aki.setText((CharSequence) null);
            yQ();
            et(null);
            if (this.akw == null || this.akw.length() <= 0) {
                this.akv.setText("Hi," + this.mContext.getString(i.h.bar_friend));
            } else {
                this.akv.setText("Hi," + this.akw);
            }
            if (!this.mContext.getPageActivity().isFinishing()) {
                this.akh.setContentView(this.akg);
                com.baidu.adp.lib.g.j.a(this.akh, this.mContext);
                if (this.mContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.mContext.getOrignalPage()).ShowSoftKeyPadDelay(this.aki, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
                }
            }
        }
    }

    public void yO() {
        String editable = this.aki.getText().toString();
        if (editable == null || editable.length() <= 0) {
            et(this.mContext.getString(i.h.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            et(this.mContext.getString(i.h.input_alias_limit_length_tip));
        } else {
            if (this.akr != null) {
                this.akr.cancel();
            }
            if (this.akq == null) {
                this.akq = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.akq.setPriority(3);
                this.akq.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP() {
        if (this.akz != null) {
            this.akz.i(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            et(this.mContext.getString(i.h.suggest_no_name));
            return;
        }
        et(this.mContext.getString(i.h.suggest_some_names));
        int size = arrayList.size();
        this.akj.clearCheck();
        this.akk.clearCheck();
        this.akj.setVisibility(0);
        this.akk.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.akm.setText(arrayList.get(0));
            this.akm.setChecked(false);
            this.akm.setCompoundDrawables(this.akB, null, null, null);
            this.akm.setVisibility(0);
            this.akj.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.akn.setText(arrayList.get(1));
            this.akn.setChecked(false);
            this.akn.setCompoundDrawables(this.akB, null, null, null);
            this.akn.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.ako.setText(arrayList.get(2));
            this.ako.setChecked(false);
            this.ako.setCompoundDrawables(this.akB, null, null, null);
            this.ako.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.akq != null) {
            this.akq.cancel();
            this.akq = null;
        }
        if (this.akr != null) {
            this.akr.cancel();
            this.akr = null;
        }
        yR();
    }

    public void yQ() {
        this.akj.setVisibility(8);
        this.akj.clearCheck();
        this.akk.setVisibility(8);
        this.akk.clearCheck();
        this.akm.setVisibility(8);
        this.akn.setVisibility(8);
        this.ako.setVisibility(8);
        this.akm.setChecked(false);
        this.akn.setChecked(false);
        this.ako.setChecked(false);
    }

    public void yR() {
        if (this.akh != null && this.akh.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.akh, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(String str) {
        if (str == null) {
            this.aks.setVisibility(4);
            this.aks.setText((CharSequence) null);
            return;
        }
        this.aks.setVisibility(0);
        this.aks.setText(str);
    }

    public void oO() {
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(this.akg);
        this.aki.setHintTextColor(am.getColor(i.c.cp_cont_e));
        this.akm.setCompoundDrawables(this.akB, null, null, null);
        this.akn.setCompoundDrawables(this.akB, null, null, null);
        this.ako.setCompoundDrawables(this.akB, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
        private com.baidu.tbadk.core.util.w afg = null;
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
            k.this.akq = null;
            k.this.aku.setVisibility(8);
            k.this.akt.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
            super.onPostExecute(aVar);
            k.this.akq = null;
            k.this.aku.setVisibility(8);
            k.this.akt.setEnabled(true);
            if (aVar == null) {
                k.this.et(this.afg.getErrorString());
            } else if (aVar.getUser().getUserName() != null) {
                k.this.yR();
                TbadkCoreApplication.setCurrentAccount(k.this.akx, k.this.mContext.getPageActivity());
                if (k.this.aky != null) {
                    k.this.aky.i(k.this.akx);
                }
            } else {
                k.this.n(aVar.we());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.aku.setVisibility(0);
            k.this.akt.setEnabled(false);
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
                this.afg = new com.baidu.tbadk.core.util.w(this.mUrl);
                this.afg.o("un", this.mAccount);
                this.afg.o("BDUSS", k.this.akx.getBDUSS());
                this.afg.uh().uX().abL = false;
                tG = this.afg.tG();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.afg.uk()) {
                str = this.afg.ul();
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
                        if (k.this.akx != null) {
                            k.this.akx.setAccount(userName);
                            k.this.akx.setBDUSS(bduss);
                            k.this.akx.setPortrait(aVar.getUser().getPortrait());
                            ?? r1 = k.this.akx;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = aVar;
                            str2 = r1;
                        }
                    }
                } else if (this.afg.ul() == 36) {
                    com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                    aVar2.parserJson(tG);
                    str = aVar2;
                } else if (this.afg.ul() == 1) {
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
        private com.baidu.tbadk.core.util.w afg;
        final /* synthetic */ k akC;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.akC.akr = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
            this.afg = new com.baidu.tbadk.core.util.w(this.mUrl);
            this.afg.o("un", this.mAccount);
            String tG = this.afg.tG();
            if (!this.afg.uk() || this.afg.ul() != 36) {
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
            this.akC.akr = null;
            if (!this.afg.uk()) {
                this.akC.et(this.afg.getErrorString());
            } else if (this.afg.ul() == 0) {
                this.akC.et(this.akC.mContext.getString(i.h.name_not_use));
            } else if (this.afg.ul() == 36) {
                this.akC.et(this.afg.getErrorString());
                if (aVar != null) {
                    this.akC.n(aVar.we());
                }
            } else {
                this.akC.et(this.afg.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.akC.et(null);
            this.akC.yQ();
            super.onPreExecute();
        }
    }
}
