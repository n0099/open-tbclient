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
    private Drawable akG;
    private Drawable akH;
    private TbPageContext<?> mContext;
    private int size;
    private View akm = null;
    private Dialog akn = null;
    private EditText ako = null;
    private RadioGroup akp = null;
    private RadioGroup akq = null;
    private CompoundButton.OnCheckedChangeListener akr = null;
    private RadioButton aks = null;
    private RadioButton akt = null;
    private RadioButton aku = null;
    private TextView akv = null;
    private c akw = null;
    private b akx = null;
    private TextView aky = null;
    private TextView akz = null;
    private ProgressBar akA = null;
    private TextView akB = null;
    private String akC = null;
    private AccountData akD = null;
    private a akE = null;
    private a akF = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public k(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.akG = null;
        this.akH = null;
        this.size = 0;
        this.mContext = tbPageContext;
        this.akG = an.getDrawable(i.e.icon_tips_names_s);
        this.akH = an.getDrawable(i.e.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(i.d.ds26);
        this.akG.setBounds(0, 0, this.size, this.size);
        this.akH.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.akD = accountData;
    }

    public void a(a aVar) {
        this.akE = aVar;
    }

    public void b(a aVar) {
        this.akF = aVar;
    }

    public void yP() {
        if (this.akn == null) {
            this.akm = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.main_input_username, (ViewGroup) null);
            this.ako = (EditText) this.akm.findViewById(i.f.account);
            this.ako.setHint(this.mContext.getString(i.h.input_alias_limit_length_tip));
            this.akv = (TextView) this.akm.findViewById(i.f.back);
            this.akv.setOnClickListener(new l(this));
            this.akz = (TextView) this.akm.findViewById(i.f.confirm);
            this.akz.setOnClickListener(new m(this));
            this.akA = (ProgressBar) this.akm.findViewById(i.f.confirm_progress);
            this.aky = (TextView) this.akm.findViewById(i.f.error_info);
            this.akp = (RadioGroup) this.akm.findViewById(i.f.names_group1);
            this.akq = (RadioGroup) this.akm.findViewById(i.f.names_group2);
            this.aks = (RadioButton) this.akm.findViewById(i.f.name1);
            this.akt = (RadioButton) this.akm.findViewById(i.f.name2);
            this.aku = (RadioButton) this.akm.findViewById(i.f.name3);
            this.akr = new n(this);
            this.aks.setOnCheckedChangeListener(this.akr);
            this.akt.setOnCheckedChangeListener(this.akr);
            this.aku.setOnCheckedChangeListener(this.akr);
            this.akB = (TextView) this.akm.findViewById(i.f.phone_info);
            yS();
            this.akn = new Dialog(this.mContext.getPageActivity(), i.C0057i.input_username_dialog);
            this.akn.setCanceledOnTouchOutside(false);
            this.akn.setCancelable(false);
            this.akn.setCanceledOnTouchOutside(false);
            oP();
        }
        if (!this.akn.isShowing()) {
            this.ako.setText((CharSequence) null);
            yS();
            et(null);
            if (this.akC == null || this.akC.length() <= 0) {
                this.akB.setText("Hi," + this.mContext.getString(i.h.bar_friend));
            } else {
                this.akB.setText("Hi," + this.akC);
            }
            if (!this.mContext.getPageActivity().isFinishing()) {
                this.akn.setContentView(this.akm);
                com.baidu.adp.lib.g.j.a(this.akn, this.mContext);
                if (this.mContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.mContext.getOrignalPage()).ShowSoftKeyPadDelay(this.ako, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
                }
            }
        }
    }

    public void yQ() {
        String editable = this.ako.getText().toString();
        if (editable == null || editable.length() <= 0) {
            et(this.mContext.getString(i.h.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            et(this.mContext.getString(i.h.input_alias_limit_length_tip));
        } else {
            if (this.akx != null) {
                this.akx.cancel();
            }
            if (this.akw == null) {
                this.akw = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.akw.setPriority(3);
                this.akw.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR() {
        if (this.akF != null) {
            this.akF.i(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            et(this.mContext.getString(i.h.suggest_no_name));
            return;
        }
        et(this.mContext.getString(i.h.suggest_some_names));
        int size = arrayList.size();
        this.akp.clearCheck();
        this.akq.clearCheck();
        this.akp.setVisibility(0);
        this.akq.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aks.setText(arrayList.get(0));
            this.aks.setChecked(false);
            this.aks.setCompoundDrawables(this.akH, null, null, null);
            this.aks.setVisibility(0);
            this.akp.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.akt.setText(arrayList.get(1));
            this.akt.setChecked(false);
            this.akt.setCompoundDrawables(this.akH, null, null, null);
            this.akt.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aku.setText(arrayList.get(2));
            this.aku.setChecked(false);
            this.aku.setCompoundDrawables(this.akH, null, null, null);
            this.aku.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.akw != null) {
            this.akw.cancel();
            this.akw = null;
        }
        if (this.akx != null) {
            this.akx.cancel();
            this.akx = null;
        }
        yT();
    }

    public void yS() {
        this.akp.setVisibility(8);
        this.akp.clearCheck();
        this.akq.setVisibility(8);
        this.akq.clearCheck();
        this.aks.setVisibility(8);
        this.akt.setVisibility(8);
        this.aku.setVisibility(8);
        this.aks.setChecked(false);
        this.akt.setChecked(false);
        this.aku.setChecked(false);
    }

    public void yT() {
        if (this.akn != null && this.akn.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.akn, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(String str) {
        if (str == null) {
            this.aky.setVisibility(4);
            this.aky.setText((CharSequence) null);
            return;
        }
        this.aky.setVisibility(0);
        this.aky.setText(str);
    }

    public void oP() {
        this.mContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(this.akm);
        this.ako.setHintTextColor(an.getColor(i.c.cp_cont_e));
        this.aks.setCompoundDrawables(this.akH, null, null, null);
        this.akt.setCompoundDrawables(this.akH, null, null, null);
        this.aku.setCompoundDrawables(this.akH, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
        private com.baidu.tbadk.core.util.w afm = null;
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
            k.this.akw = null;
            k.this.akA.setVisibility(8);
            k.this.akz.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
            super.onPostExecute(aVar);
            k.this.akw = null;
            k.this.akA.setVisibility(8);
            k.this.akz.setEnabled(true);
            if (aVar == null) {
                k.this.et(this.afm.getErrorString());
            } else if (aVar.getUser().getUserName() != null) {
                k.this.yT();
                TbadkCoreApplication.setCurrentAccount(k.this.akD, k.this.mContext.getPageActivity());
                if (k.this.akE != null) {
                    k.this.akE.i(k.this.akD);
                }
            } else {
                k.this.n(aVar.wg());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.akA.setVisibility(0);
            k.this.akz.setEnabled(false);
            k.this.et(null);
            k.this.yS();
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
                this.afm = new com.baidu.tbadk.core.util.w(this.mUrl);
                this.afm.o("un", this.mAccount);
                this.afm.o("BDUSS", k.this.akD.getBDUSS());
                this.afm.uh().uZ().abT = false;
                tG = this.afm.tG();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.afm.uk()) {
                str = this.afm.ul();
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
                        if (k.this.akD != null) {
                            k.this.akD.setAccount(userName);
                            k.this.akD.setBDUSS(bduss);
                            k.this.akD.setPortrait(aVar.getUser().getPortrait());
                            ?? r1 = k.this.akD;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = aVar;
                            str2 = r1;
                        }
                    }
                } else if (this.afm.ul() == 36) {
                    com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                    aVar2.parserJson(tG);
                    str = aVar2;
                } else if (this.afm.ul() == 1) {
                    k.this.yT();
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
        private com.baidu.tbadk.core.util.w afm;
        final /* synthetic */ k akI;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.akI.akx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
            this.afm = new com.baidu.tbadk.core.util.w(this.mUrl);
            this.afm.o("un", this.mAccount);
            String tG = this.afm.tG();
            if (!this.afm.uk() || this.afm.ul() != 36) {
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
            this.akI.akx = null;
            if (!this.afm.uk()) {
                this.akI.et(this.afm.getErrorString());
            } else if (this.afm.ul() == 0) {
                this.akI.et(this.akI.mContext.getString(i.h.name_not_use));
            } else if (this.afm.ul() == 36) {
                this.akI.et(this.afm.getErrorString());
                if (aVar != null) {
                    this.akI.n(aVar.wg());
                }
            } else {
                this.akI.et(this.afm.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.akI.et(null);
            this.akI.yS();
            super.onPreExecute();
        }
    }
}
