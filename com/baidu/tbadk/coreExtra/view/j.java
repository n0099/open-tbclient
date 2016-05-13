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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> Do;
    private View akc = null;
    private Dialog akd = null;
    private EditText ake = null;
    private RadioGroup akf = null;
    private RadioGroup akg = null;
    private CompoundButton.OnCheckedChangeListener akh = null;
    private RadioButton aki = null;
    private RadioButton akj = null;
    private RadioButton akk = null;
    private TextView akl = null;
    private c akm = null;
    private b akn = null;
    private TextView ako = null;
    private TextView akp = null;
    private ProgressBar akq = null;
    private TextView akr = null;
    private String aks = null;
    private AccountData akt = null;
    private a aku = null;
    private a akv = null;
    private Drawable akw;
    private Drawable akx;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.Do = null;
        this.akw = null;
        this.akx = null;
        this.size = 0;
        this.Do = tbPageContext;
        this.akw = at.getDrawable(t.f.icon_tips_names_s);
        this.akx = at.getDrawable(t.f.icon_tips_names_n);
        this.size = this.Do.getResources().getDimensionPixelSize(t.e.ds26);
        this.akw.setBounds(0, 0, this.size, this.size);
        this.akx.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.akt = accountData;
    }

    public void a(a aVar) {
        this.aku = aVar;
    }

    public void b(a aVar) {
        this.akv = aVar;
    }

    public void zn() {
        if (this.akd == null) {
            this.akc = LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.main_input_username, (ViewGroup) null);
            this.ake = (EditText) this.akc.findViewById(t.g.account);
            this.ake.setHint(this.Do.getString(t.j.input_alias_limit_length_tip));
            this.akl = (TextView) this.akc.findViewById(t.g.back);
            this.akl.setOnClickListener(new k(this));
            this.akp = (TextView) this.akc.findViewById(t.g.confirm);
            this.akp.setOnClickListener(new l(this));
            this.akq = (ProgressBar) this.akc.findViewById(t.g.confirm_progress);
            this.ako = (TextView) this.akc.findViewById(t.g.error_info);
            this.akf = (RadioGroup) this.akc.findViewById(t.g.names_group1);
            this.akg = (RadioGroup) this.akc.findViewById(t.g.names_group2);
            this.aki = (RadioButton) this.akc.findViewById(t.g.name1);
            this.akj = (RadioButton) this.akc.findViewById(t.g.name2);
            this.akk = (RadioButton) this.akc.findViewById(t.g.name3);
            this.akh = new m(this);
            this.aki.setOnCheckedChangeListener(this.akh);
            this.akj.setOnCheckedChangeListener(this.akh);
            this.akk.setOnCheckedChangeListener(this.akh);
            this.akr = (TextView) this.akc.findViewById(t.g.phone_info);
            zq();
            this.akd = new Dialog(this.Do.getPageActivity(), t.k.input_username_dialog);
            this.akd.setCanceledOnTouchOutside(false);
            this.akd.setCancelable(false);
            this.akd.setCanceledOnTouchOutside(false);
            kU();
        }
        if (!this.akd.isShowing()) {
            this.ake.setText((CharSequence) null);
            zq();
            eJ(null);
            if (this.aks == null || this.aks.length() <= 0) {
                this.akr.setText("Hi," + this.Do.getString(t.j.bar_friend));
            } else {
                this.akr.setText("Hi," + this.aks);
            }
            if (!this.Do.getPageActivity().isFinishing()) {
                this.akd.setContentView(this.akc);
                com.baidu.adp.lib.h.j.a(this.akd, this.Do);
                if (this.Do.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.Do.getOrignalPage()).ShowSoftKeyPadDelay(this.ake, 150);
                }
            }
        }
    }

    public void zo() {
        String editable = this.ake.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eJ(this.Do.getString(t.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eJ(this.Do.getString(t.j.input_alias_limit_length_tip));
        } else {
            if (this.akn != null) {
                this.akn.cancel();
            }
            if (this.akm == null) {
                this.akm = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.akm.setPriority(3);
                this.akm.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zp() {
        if (this.akv != null) {
            this.akv.i(null);
        }
    }

    public void m(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eJ(this.Do.getString(t.j.suggest_no_name));
            return;
        }
        eJ(this.Do.getString(t.j.suggest_some_names));
        int size = arrayList.size();
        this.akf.clearCheck();
        this.akg.clearCheck();
        this.akf.setVisibility(0);
        this.akg.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aki.setText(arrayList.get(0));
            this.aki.setChecked(false);
            this.aki.setCompoundDrawables(this.akx, null, null, null);
            this.aki.setVisibility(0);
            this.akf.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.akj.setText(arrayList.get(1));
            this.akj.setChecked(false);
            this.akj.setCompoundDrawables(this.akx, null, null, null);
            this.akj.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.akk.setText(arrayList.get(2));
            this.akk.setChecked(false);
            this.akk.setCompoundDrawables(this.akx, null, null, null);
            this.akk.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.akm != null) {
            this.akm.cancel();
            this.akm = null;
        }
        if (this.akn != null) {
            this.akn.cancel();
            this.akn = null;
        }
        zr();
    }

    public void zq() {
        this.akf.setVisibility(8);
        this.akf.clearCheck();
        this.akg.setVisibility(8);
        this.akg.clearCheck();
        this.aki.setVisibility(8);
        this.akj.setVisibility(8);
        this.akk.setVisibility(8);
        this.aki.setChecked(false);
        this.akj.setChecked(false);
        this.akk.setChecked(false);
    }

    public void zr() {
        if (this.akd != null && this.akd.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.akd, this.Do);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(String str) {
        if (str == null) {
            this.ako.setVisibility(4);
            this.ako.setText((CharSequence) null);
            return;
        }
        this.ako.setVisibility(0);
        this.ako.setText(str);
    }

    public void kU() {
        this.Do.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.Do.getLayoutMode().x(this.akc);
        this.ake.setHintTextColor(at.getColor(t.d.cp_cont_e));
        this.aki.setCompoundDrawables(this.akx, null, null, null);
        this.akj.setCompoundDrawables(this.akx, null, null, null);
        this.akk.setCompoundDrawables(this.akx, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.b> {
        private com.baidu.tbadk.core.util.ab aeI = null;
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
            j.this.akm = null;
            j.this.akq.setVisibility(8);
            j.this.akp.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            j.this.akm = null;
            j.this.akq.setVisibility(8);
            j.this.akp.setEnabled(true);
            if (bVar == null) {
                j.this.eJ(this.aeI.getErrorString());
            } else if (bVar.getUser().getUserName() != null) {
                j.this.zr();
                TbadkCoreApplication.setCurrentAccount(j.this.akt, j.this.Do.getPageActivity());
                if (j.this.aku != null) {
                    j.this.aku.i(j.this.akt);
                }
            } else {
                j.this.m(bVar.ws());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.akq.setVisibility(0);
            j.this.akp.setEnabled(false);
            j.this.eJ(null);
            j.this.zq();
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
        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tbadk.coreExtra.data.b] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v31 */
        /* JADX WARN: Type inference failed for: r1v15, types: [com.baidu.tbadk.core.data.AccountData] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            String str;
            Exception e;
            String td;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.aeI = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.aeI.n("un", this.mAccount);
                this.aeI.n("BDUSS", j.this.akt.getBDUSS());
                this.aeI.tB().uv().YA = false;
                td = this.aeI.td();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.aeI.tE()) {
                str = this.aeI.tF();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
                    bVar.parserJson(td);
                    String userName = bVar.getUser().getUserName();
                    String bduss = bVar.getUser().getBDUSS();
                    str = bVar;
                    str = bVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = bVar;
                        str2 = userName;
                        if (j.this.akt != null) {
                            j.this.akt.setAccount(userName);
                            j.this.akt.setBDUSS(bduss);
                            j.this.akt.setPortrait(bVar.getUser().getPortrait());
                            ?? r1 = j.this.akt;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = bVar;
                            str2 = r1;
                        }
                    }
                } else if (this.aeI.tF() == 36) {
                    com.baidu.tbadk.coreExtra.data.b bVar2 = new com.baidu.tbadk.coreExtra.data.b();
                    bVar2.parserJson(td);
                    str = bVar2;
                } else if (this.aeI.tF() == 1) {
                    j.this.zr();
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
    private class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.b> {
        private com.baidu.tbadk.core.util.ab aeI;
        final /* synthetic */ j aky;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aky.akn = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            this.aeI = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.aeI.n("un", this.mAccount);
            String td = this.aeI.td();
            if (!this.aeI.tE() || this.aeI.tF() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
            bVar.parserJson(td);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            this.aky.akn = null;
            if (!this.aeI.tE()) {
                this.aky.eJ(this.aeI.getErrorString());
            } else if (this.aeI.tF() == 0) {
                this.aky.eJ(this.aky.Do.getString(t.j.name_not_use));
            } else if (this.aeI.tF() == 36) {
                this.aky.eJ(this.aeI.getErrorString());
                if (bVar != null) {
                    this.aky.m(bVar.ws());
                }
            } else {
                this.aky.eJ(this.aeI.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aky.eJ(null);
            this.aky.zq();
            super.onPreExecute();
        }
    }
}
