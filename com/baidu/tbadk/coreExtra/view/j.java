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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> Gd;
    private Drawable aoG;
    private Drawable aoH;
    private int size;
    private View aom = null;
    private Dialog aon = null;
    private EditText aoo = null;
    private RadioGroup aop = null;
    private RadioGroup aoq = null;
    private CompoundButton.OnCheckedChangeListener aor = null;
    private RadioButton aos = null;
    private RadioButton aot = null;
    private RadioButton aou = null;
    private TextView aov = null;
    private c aow = null;
    private b aox = null;
    private TextView aoy = null;
    private TextView aoz = null;
    private ProgressBar aoA = null;
    private TextView aoB = null;
    private String aoC = null;
    private AccountData aoD = null;
    private a aoE = null;
    private a aoF = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.Gd = null;
        this.aoG = null;
        this.aoH = null;
        this.size = 0;
        this.Gd = tbPageContext;
        this.aoG = av.getDrawable(r.f.icon_tips_names_s);
        this.aoH = av.getDrawable(r.f.icon_tips_names_n);
        this.size = this.Gd.getResources().getDimensionPixelSize(r.e.ds26);
        this.aoG.setBounds(0, 0, this.size, this.size);
        this.aoH.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.aoD = accountData;
    }

    public void a(a aVar) {
        this.aoE = aVar;
    }

    public void b(a aVar) {
        this.aoF = aVar;
    }

    public void AK() {
        if (this.aon == null) {
            this.aom = LayoutInflater.from(this.Gd.getPageActivity()).inflate(r.h.main_input_username, (ViewGroup) null);
            this.aoo = (EditText) this.aom.findViewById(r.g.account);
            this.aoo.setHint(this.Gd.getString(r.j.input_alias_limit_length_tip));
            this.aov = (TextView) this.aom.findViewById(r.g.back);
            this.aov.setOnClickListener(new k(this));
            this.aoz = (TextView) this.aom.findViewById(r.g.confirm);
            this.aoz.setOnClickListener(new l(this));
            this.aoA = (ProgressBar) this.aom.findViewById(r.g.confirm_progress);
            this.aoy = (TextView) this.aom.findViewById(r.g.error_info);
            this.aop = (RadioGroup) this.aom.findViewById(r.g.names_group1);
            this.aoq = (RadioGroup) this.aom.findViewById(r.g.names_group2);
            this.aos = (RadioButton) this.aom.findViewById(r.g.name1);
            this.aot = (RadioButton) this.aom.findViewById(r.g.name2);
            this.aou = (RadioButton) this.aom.findViewById(r.g.name3);
            this.aor = new m(this);
            this.aos.setOnCheckedChangeListener(this.aor);
            this.aot.setOnCheckedChangeListener(this.aor);
            this.aou.setOnCheckedChangeListener(this.aor);
            this.aoB = (TextView) this.aom.findViewById(r.g.phone_info);
            AN();
            this.aon = new Dialog(this.Gd.getPageActivity(), r.k.input_username_dialog);
            this.aon.setCanceledOnTouchOutside(false);
            this.aon.setCancelable(false);
            this.aon.setCanceledOnTouchOutside(false);
            lO();
        }
        if (!this.aon.isShowing()) {
            this.aoo.setText((CharSequence) null);
            AN();
            eR(null);
            if (this.aoC == null || this.aoC.length() <= 0) {
                this.aoB.setText("Hi," + this.Gd.getString(r.j.bar_friend));
            } else {
                this.aoB.setText("Hi," + this.aoC);
            }
            if (!this.Gd.getPageActivity().isFinishing()) {
                this.aon.setContentView(this.aom);
                com.baidu.adp.lib.h.j.a(this.aon, this.Gd);
                if (this.Gd.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.Gd.getOrignalPage()).ShowSoftKeyPadDelay(this.aoo, 150);
                }
            }
        }
    }

    public void AL() {
        String editable = this.aoo.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eR(this.Gd.getString(r.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eR(this.Gd.getString(r.j.input_alias_limit_length_tip));
        } else {
            if (this.aox != null) {
                this.aox.cancel();
            }
            if (this.aow == null) {
                this.aow = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.aow.setPriority(3);
                this.aow.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM() {
        if (this.aoF != null) {
            this.aoF.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eR(this.Gd.getString(r.j.suggest_no_name));
            return;
        }
        eR(this.Gd.getString(r.j.suggest_some_names));
        int size = arrayList.size();
        this.aop.clearCheck();
        this.aoq.clearCheck();
        this.aop.setVisibility(0);
        this.aoq.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aos.setText(arrayList.get(0));
            this.aos.setChecked(false);
            this.aos.setCompoundDrawables(this.aoH, null, null, null);
            this.aos.setVisibility(0);
            this.aop.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aot.setText(arrayList.get(1));
            this.aot.setChecked(false);
            this.aot.setCompoundDrawables(this.aoH, null, null, null);
            this.aot.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aou.setText(arrayList.get(2));
            this.aou.setChecked(false);
            this.aou.setCompoundDrawables(this.aoH, null, null, null);
            this.aou.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aow != null) {
            this.aow.cancel();
            this.aow = null;
        }
        if (this.aox != null) {
            this.aox.cancel();
            this.aox = null;
        }
        AO();
    }

    public void AN() {
        this.aop.setVisibility(8);
        this.aop.clearCheck();
        this.aoq.setVisibility(8);
        this.aoq.clearCheck();
        this.aos.setVisibility(8);
        this.aot.setVisibility(8);
        this.aou.setVisibility(8);
        this.aos.setChecked(false);
        this.aot.setChecked(false);
        this.aou.setChecked(false);
    }

    public void AO() {
        if (this.aon != null && this.aon.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.aon, this.Gd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR(String str) {
        if (str == null) {
            this.aoy.setVisibility(4);
            this.aoy.setText((CharSequence) null);
            return;
        }
        this.aoy.setVisibility(0);
        this.aoy.setText(str);
    }

    public void lO() {
        this.Gd.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gd.getLayoutMode().x(this.aom);
        this.aoo.setHintTextColor(av.getColor(r.d.cp_cont_e));
        this.aos.setCompoundDrawables(this.aoH, null, null, null);
        this.aot.setCompoundDrawables(this.aoH, null, null, null);
        this.aou.setCompoundDrawables(this.aoH, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private com.baidu.tbadk.core.util.ab aiu = null;
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
            j.this.aow = null;
            j.this.aoA.setVisibility(8);
            j.this.aoz.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.aow = null;
            j.this.aoA.setVisibility(8);
            j.this.aoz.setEnabled(true);
            if (fVar == null) {
                j.this.eR(this.aiu.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.AO();
                TbadkCoreApplication.setCurrentAccount(j.this.aoD, j.this.Gd.getPageActivity());
                if (j.this.aoE != null) {
                    j.this.aoE.j(j.this.aoD);
                }
            } else {
                j.this.n(fVar.xI());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.aoA.setVisibility(0);
            j.this.aoz.setEnabled(false);
            j.this.eR(null);
            j.this.AN();
            super.onPreExecute();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00ac */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0098 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0046 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0098 */
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
            String uu;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.aiu = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.aiu.n("un", this.mAccount);
                this.aiu.n("BDUSS", j.this.aoD.getBDUSS());
                this.aiu.uS().vN().acA = false;
                uu = this.aiu.uu();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.aiu.uV()) {
                str = this.aiu.uW();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(uu);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.aoD != null) {
                            j.this.aoD.setAccount(userName);
                            j.this.aoD.setBDUSS(bduss);
                            j.this.aoD.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.aoD;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.aiu.uW() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(uu);
                    str = fVar2;
                } else if (this.aiu.uW() == 1) {
                    j.this.AO();
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
        private com.baidu.tbadk.core.util.ab aiu;
        final /* synthetic */ j aoI;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aoI.aox = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.aiu = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.aiu.n("un", this.mAccount);
            String uu = this.aiu.uu();
            if (!this.aiu.uV() || this.aiu.uW() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uu);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.aoI.aox = null;
            if (!this.aiu.uV()) {
                this.aoI.eR(this.aiu.getErrorString());
            } else if (this.aiu.uW() == 0) {
                this.aoI.eR(this.aoI.Gd.getString(r.j.name_not_use));
            } else if (this.aiu.uW() == 36) {
                this.aoI.eR(this.aiu.getErrorString());
                if (fVar != null) {
                    this.aoI.n(fVar.xI());
                }
            } else {
                this.aoI.eR(this.aiu.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aoI.eR(null);
            this.aoI.AN();
            super.onPreExecute();
        }
    }
}
