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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> Gf;
    private Drawable apB;
    private Drawable apC;
    private int size;
    private View apg = null;
    private Dialog aph = null;
    private EditText api = null;
    private RadioGroup apj = null;
    private RadioGroup apk = null;
    private CompoundButton.OnCheckedChangeListener apl = null;
    private RadioButton apm = null;
    private RadioButton apn = null;
    private RadioButton apo = null;
    private TextView apq = null;
    private c apr = null;
    private b aps = null;
    private TextView apt = null;
    private TextView apu = null;
    private ProgressBar apv = null;
    private TextView apw = null;
    private String apx = null;
    private AccountData apy = null;
    private a apz = null;
    private a apA = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.Gf = null;
        this.apB = null;
        this.apC = null;
        this.size = 0;
        this.Gf = tbPageContext;
        this.apB = at.getDrawable(r.f.icon_tips_names_s);
        this.apC = at.getDrawable(r.f.icon_tips_names_n);
        this.size = this.Gf.getResources().getDimensionPixelSize(r.e.ds26);
        this.apB.setBounds(0, 0, this.size, this.size);
        this.apC.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.apy = accountData;
    }

    public void a(a aVar) {
        this.apz = aVar;
    }

    public void b(a aVar) {
        this.apA = aVar;
    }

    public void AR() {
        if (this.aph == null) {
            this.apg = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.main_input_username, (ViewGroup) null);
            this.api = (EditText) this.apg.findViewById(r.g.account);
            this.api.setHint(this.Gf.getString(r.j.input_alias_limit_length_tip));
            this.apq = (TextView) this.apg.findViewById(r.g.back);
            this.apq.setOnClickListener(new k(this));
            this.apu = (TextView) this.apg.findViewById(r.g.confirm);
            this.apu.setOnClickListener(new l(this));
            this.apv = (ProgressBar) this.apg.findViewById(r.g.confirm_progress);
            this.apt = (TextView) this.apg.findViewById(r.g.error_info);
            this.apj = (RadioGroup) this.apg.findViewById(r.g.names_group1);
            this.apk = (RadioGroup) this.apg.findViewById(r.g.names_group2);
            this.apm = (RadioButton) this.apg.findViewById(r.g.name1);
            this.apn = (RadioButton) this.apg.findViewById(r.g.name2);
            this.apo = (RadioButton) this.apg.findViewById(r.g.name3);
            this.apl = new m(this);
            this.apm.setOnCheckedChangeListener(this.apl);
            this.apn.setOnCheckedChangeListener(this.apl);
            this.apo.setOnCheckedChangeListener(this.apl);
            this.apw = (TextView) this.apg.findViewById(r.g.phone_info);
            AU();
            this.aph = new Dialog(this.Gf.getPageActivity(), r.k.input_username_dialog);
            this.aph.setCanceledOnTouchOutside(false);
            this.aph.setCancelable(false);
            this.aph.setCanceledOnTouchOutside(false);
            lR();
        }
        if (!this.aph.isShowing()) {
            this.api.setText((CharSequence) null);
            AU();
            eT(null);
            if (this.apx == null || this.apx.length() <= 0) {
                this.apw.setText("Hi," + this.Gf.getString(r.j.bar_friend));
            } else {
                this.apw.setText("Hi," + this.apx);
            }
            if (!this.Gf.getPageActivity().isFinishing()) {
                this.aph.setContentView(this.apg);
                com.baidu.adp.lib.h.j.a(this.aph, this.Gf);
                if (this.Gf.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.Gf.getOrignalPage()).ShowSoftKeyPadDelay(this.api, 150);
                }
            }
        }
    }

    public void AS() {
        String editable = this.api.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eT(this.Gf.getString(r.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eT(this.Gf.getString(r.j.input_alias_limit_length_tip));
        } else {
            if (this.aps != null) {
                this.aps.cancel();
            }
            if (this.apr == null) {
                this.apr = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.apr.setPriority(3);
                this.apr.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AT() {
        if (this.apA != null) {
            this.apA.j(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eT(this.Gf.getString(r.j.suggest_no_name));
            return;
        }
        eT(this.Gf.getString(r.j.suggest_some_names));
        int size = arrayList.size();
        this.apj.clearCheck();
        this.apk.clearCheck();
        this.apj.setVisibility(0);
        this.apk.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.apm.setText(arrayList.get(0));
            this.apm.setChecked(false);
            this.apm.setCompoundDrawables(this.apC, null, null, null);
            this.apm.setVisibility(0);
            this.apj.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.apn.setText(arrayList.get(1));
            this.apn.setChecked(false);
            this.apn.setCompoundDrawables(this.apC, null, null, null);
            this.apn.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.apo.setText(arrayList.get(2));
            this.apo.setChecked(false);
            this.apo.setCompoundDrawables(this.apC, null, null, null);
            this.apo.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.apr != null) {
            this.apr.cancel();
            this.apr = null;
        }
        if (this.aps != null) {
            this.aps.cancel();
            this.aps = null;
        }
        AV();
    }

    public void AU() {
        this.apj.setVisibility(8);
        this.apj.clearCheck();
        this.apk.setVisibility(8);
        this.apk.clearCheck();
        this.apm.setVisibility(8);
        this.apn.setVisibility(8);
        this.apo.setVisibility(8);
        this.apm.setChecked(false);
        this.apn.setChecked(false);
        this.apo.setChecked(false);
    }

    public void AV() {
        if (this.aph != null && this.aph.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.aph, this.Gf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(String str) {
        if (str == null) {
            this.apt.setVisibility(4);
            this.apt.setText((CharSequence) null);
            return;
        }
        this.apt.setVisibility(0);
        this.apt.setText(str);
    }

    public void lR() {
        this.Gf.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gf.getLayoutMode().x(this.apg);
        this.api.setHintTextColor(at.getColor(r.d.cp_cont_e));
        this.apm.setCompoundDrawables(this.apC, null, null, null);
        this.apn.setCompoundDrawables(this.apC, null, null, null);
        this.apo.setCompoundDrawables(this.apC, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private com.baidu.tbadk.core.util.z ajm = null;
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
            j.this.apr = null;
            j.this.apv.setVisibility(8);
            j.this.apu.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.apr = null;
            j.this.apv.setVisibility(8);
            j.this.apu.setEnabled(true);
            if (fVar == null) {
                j.this.eT(this.ajm.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.AV();
                TbadkCoreApplication.setCurrentAccount(j.this.apy, j.this.Gf.getPageActivity());
                if (j.this.apz != null) {
                    j.this.apz.j(j.this.apy);
                }
            } else {
                j.this.o(fVar.xO());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.apv.setVisibility(0);
            j.this.apu.setEnabled(false);
            j.this.eT(null);
            j.this.AU();
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
            String uy;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.ajm = new com.baidu.tbadk.core.util.z(this.mUrl);
                this.ajm.n("un", this.mAccount);
                this.ajm.n("BDUSS", j.this.apy.getBDUSS());
                this.ajm.uW().vR().acY = false;
                uy = this.ajm.uy();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.ajm.uZ()) {
                str = this.ajm.va();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(uy);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.apy != null) {
                            j.this.apy.setAccount(userName);
                            j.this.apy.setBDUSS(bduss);
                            j.this.apy.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.apy;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.ajm.va() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(uy);
                    str = fVar2;
                } else if (this.ajm.va() == 1) {
                    j.this.AV();
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
        private com.baidu.tbadk.core.util.z ajm;
        final /* synthetic */ j apD;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.apD.aps = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.ajm = new com.baidu.tbadk.core.util.z(this.mUrl);
            this.ajm.n("un", this.mAccount);
            String uy = this.ajm.uy();
            if (!this.ajm.uZ() || this.ajm.va() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uy);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.apD.aps = null;
            if (!this.ajm.uZ()) {
                this.apD.eT(this.ajm.getErrorString());
            } else if (this.ajm.va() == 0) {
                this.apD.eT(this.apD.Gf.getString(r.j.name_not_use));
            } else if (this.ajm.va() == 36) {
                this.apD.eT(this.ajm.getErrorString());
                if (fVar != null) {
                    this.apD.o(fVar.xO());
                }
            } else {
                this.apD.eT(this.ajm.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.apD.eT(null);
            this.apD.AU();
            super.onPreExecute();
        }
    }
}
