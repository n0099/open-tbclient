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
    private TbPageContext<?> MX;
    private Drawable aoI;
    private Drawable aoJ;
    private int size;
    private View aoo = null;
    private Dialog aop = null;
    private EditText aoq = null;
    private RadioGroup aor = null;
    private RadioGroup aos = null;
    private CompoundButton.OnCheckedChangeListener aot = null;
    private RadioButton aou = null;
    private RadioButton aov = null;
    private RadioButton aow = null;
    private TextView aox = null;
    private c aoy = null;
    private b aoz = null;
    private TextView aoA = null;
    private TextView aoB = null;
    private ProgressBar aoC = null;
    private TextView aoD = null;
    private String aoE = null;
    private AccountData aoF = null;
    private a aoG = null;
    private a aoH = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.MX = null;
        this.aoI = null;
        this.aoJ = null;
        this.size = 0;
        this.MX = tbPageContext;
        this.aoI = at.getDrawable(t.f.icon_tips_names_s);
        this.aoJ = at.getDrawable(t.f.icon_tips_names_n);
        this.size = this.MX.getResources().getDimensionPixelSize(t.e.ds26);
        this.aoI.setBounds(0, 0, this.size, this.size);
        this.aoJ.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.aoF = accountData;
    }

    public void a(a aVar) {
        this.aoG = aVar;
    }

    public void b(a aVar) {
        this.aoH = aVar;
    }

    public void Bs() {
        if (this.aop == null) {
            this.aoo = LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.main_input_username, (ViewGroup) null);
            this.aoq = (EditText) this.aoo.findViewById(t.g.account);
            this.aoq.setHint(this.MX.getString(t.j.input_alias_limit_length_tip));
            this.aox = (TextView) this.aoo.findViewById(t.g.back);
            this.aox.setOnClickListener(new k(this));
            this.aoB = (TextView) this.aoo.findViewById(t.g.confirm);
            this.aoB.setOnClickListener(new l(this));
            this.aoC = (ProgressBar) this.aoo.findViewById(t.g.confirm_progress);
            this.aoA = (TextView) this.aoo.findViewById(t.g.error_info);
            this.aor = (RadioGroup) this.aoo.findViewById(t.g.names_group1);
            this.aos = (RadioGroup) this.aoo.findViewById(t.g.names_group2);
            this.aou = (RadioButton) this.aoo.findViewById(t.g.name1);
            this.aov = (RadioButton) this.aoo.findViewById(t.g.name2);
            this.aow = (RadioButton) this.aoo.findViewById(t.g.name3);
            this.aot = new m(this);
            this.aou.setOnCheckedChangeListener(this.aot);
            this.aov.setOnCheckedChangeListener(this.aot);
            this.aow.setOnCheckedChangeListener(this.aot);
            this.aoD = (TextView) this.aoo.findViewById(t.g.phone_info);
            Bv();
            this.aop = new Dialog(this.MX.getPageActivity(), t.k.input_username_dialog);
            this.aop.setCanceledOnTouchOutside(false);
            this.aop.setCancelable(false);
            this.aop.setCanceledOnTouchOutside(false);
            oH();
        }
        if (!this.aop.isShowing()) {
            this.aoq.setText((CharSequence) null);
            Bv();
            eM(null);
            if (this.aoE == null || this.aoE.length() <= 0) {
                this.aoD.setText("Hi," + this.MX.getString(t.j.bar_friend));
            } else {
                this.aoD.setText("Hi," + this.aoE);
            }
            if (!this.MX.getPageActivity().isFinishing()) {
                this.aop.setContentView(this.aoo);
                com.baidu.adp.lib.h.j.a(this.aop, this.MX);
                if (this.MX.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.MX.getOrignalPage()).ShowSoftKeyPadDelay(this.aoq, 150);
                }
            }
        }
    }

    public void Bt() {
        String editable = this.aoq.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eM(this.MX.getString(t.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eM(this.MX.getString(t.j.input_alias_limit_length_tip));
        } else {
            if (this.aoz != null) {
                this.aoz.cancel();
            }
            if (this.aoy == null) {
                this.aoy = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.aoy.setPriority(3);
                this.aoy.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu() {
        if (this.aoH != null) {
            this.aoH.i(null);
        }
    }

    public void m(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eM(this.MX.getString(t.j.suggest_no_name));
            return;
        }
        eM(this.MX.getString(t.j.suggest_some_names));
        int size = arrayList.size();
        this.aor.clearCheck();
        this.aos.clearCheck();
        this.aor.setVisibility(0);
        this.aos.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aou.setText(arrayList.get(0));
            this.aou.setChecked(false);
            this.aou.setCompoundDrawables(this.aoJ, null, null, null);
            this.aou.setVisibility(0);
            this.aor.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aov.setText(arrayList.get(1));
            this.aov.setChecked(false);
            this.aov.setCompoundDrawables(this.aoJ, null, null, null);
            this.aov.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aow.setText(arrayList.get(2));
            this.aow.setChecked(false);
            this.aow.setCompoundDrawables(this.aoJ, null, null, null);
            this.aow.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aoy != null) {
            this.aoy.cancel();
            this.aoy = null;
        }
        if (this.aoz != null) {
            this.aoz.cancel();
            this.aoz = null;
        }
        Bw();
    }

    public void Bv() {
        this.aor.setVisibility(8);
        this.aor.clearCheck();
        this.aos.setVisibility(8);
        this.aos.clearCheck();
        this.aou.setVisibility(8);
        this.aov.setVisibility(8);
        this.aow.setVisibility(8);
        this.aou.setChecked(false);
        this.aov.setChecked(false);
        this.aow.setChecked(false);
    }

    public void Bw() {
        if (this.aop != null && this.aop.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.aop, this.MX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(String str) {
        if (str == null) {
            this.aoA.setVisibility(4);
            this.aoA.setText((CharSequence) null);
            return;
        }
        this.aoA.setVisibility(0);
        this.aoA.setText(str);
    }

    public void oH() {
        this.MX.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.MX.getLayoutMode().x(this.aoo);
        this.aoq.setHintTextColor(at.getColor(t.d.cp_cont_e));
        this.aou.setCompoundDrawables(this.aoJ, null, null, null);
        this.aov.setCompoundDrawables(this.aoJ, null, null, null);
        this.aow.setCompoundDrawables(this.aoJ, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.b> {
        private com.baidu.tbadk.core.util.ab aiW = null;
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
            j.this.aoy = null;
            j.this.aoC.setVisibility(8);
            j.this.aoB.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            j.this.aoy = null;
            j.this.aoC.setVisibility(8);
            j.this.aoB.setEnabled(true);
            if (bVar == null) {
                j.this.eM(this.aiW.getErrorString());
            } else if (bVar.getUser().getUserName() != null) {
                j.this.Bw();
                TbadkCoreApplication.setCurrentAccount(j.this.aoF, j.this.MX.getPageActivity());
                if (j.this.aoG != null) {
                    j.this.aoG.i(j.this.aoF);
                }
            } else {
                j.this.m(bVar.yy());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.aoC.setVisibility(0);
            j.this.aoB.setEnabled(false);
            j.this.eM(null);
            j.this.Bv();
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
        /* renamed from: n */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            String str;
            Exception e;
            String vw;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.aiW = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.aiW.p("un", this.mAccount);
                this.aiW.p("BDUSS", j.this.aoF.getBDUSS());
                this.aiW.vU().wO().adb = false;
                vw = this.aiW.vw();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.aiW.vX()) {
                str = this.aiW.vY();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
                    bVar.parserJson(vw);
                    String userName = bVar.getUser().getUserName();
                    String bduss = bVar.getUser().getBDUSS();
                    str = bVar;
                    str = bVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = bVar;
                        str2 = userName;
                        if (j.this.aoF != null) {
                            j.this.aoF.setAccount(userName);
                            j.this.aoF.setBDUSS(bduss);
                            j.this.aoF.setPortrait(bVar.getUser().getPortrait());
                            ?? r1 = j.this.aoF;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = bVar;
                            str2 = r1;
                        }
                    }
                } else if (this.aiW.vY() == 36) {
                    com.baidu.tbadk.coreExtra.data.b bVar2 = new com.baidu.tbadk.coreExtra.data.b();
                    bVar2.parserJson(vw);
                    str = bVar2;
                } else if (this.aiW.vY() == 1) {
                    j.this.Bw();
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
        private com.baidu.tbadk.core.util.ab aiW;
        final /* synthetic */ j aoK;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aoK.aoz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            this.aiW = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.aiW.p("un", this.mAccount);
            String vw = this.aiW.vw();
            if (!this.aiW.vX() || this.aiW.vY() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
            bVar.parserJson(vw);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            this.aoK.aoz = null;
            if (!this.aiW.vX()) {
                this.aoK.eM(this.aiW.getErrorString());
            } else if (this.aiW.vY() == 0) {
                this.aoK.eM(this.aoK.MX.getString(t.j.name_not_use));
            } else if (this.aiW.vY() == 36) {
                this.aoK.eM(this.aiW.getErrorString());
                if (bVar != null) {
                    this.aoK.m(bVar.yy());
                }
            } else {
                this.aoK.eM(this.aiW.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aoK.eM(null);
            this.aoK.Bv();
            super.onPreExecute();
        }
    }
}
