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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> aaI;
    private Drawable atD;
    private Drawable atE;
    private int size;
    private View atj = null;
    private Dialog atk = null;
    private EditText atl = null;
    private RadioGroup atm = null;
    private RadioGroup atn = null;
    private CompoundButton.OnCheckedChangeListener ato = null;
    private RadioButton atp = null;
    private RadioButton atq = null;
    private RadioButton atr = null;
    private TextView ats = null;
    private c att = null;
    private b atu = null;
    private TextView atv = null;
    private TextView atw = null;
    private ProgressBar atx = null;
    private TextView aty = null;
    private String atz = null;
    private AccountData atA = null;
    private a atB = null;
    private a atC = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.aaI = null;
        this.atD = null;
        this.atE = null;
        this.size = 0;
        this.aaI = tbPageContext;
        this.atD = aq.getDrawable(w.g.icon_tips_names_s);
        this.atE = aq.getDrawable(w.g.icon_tips_names_n);
        this.size = this.aaI.getResources().getDimensionPixelSize(w.f.ds26);
        this.atD.setBounds(0, 0, this.size, this.size);
        this.atE.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.atA = accountData;
    }

    public void a(a aVar) {
        this.atB = aVar;
    }

    public void b(a aVar) {
        this.atC = aVar;
    }

    public void AS() {
        if (this.atk == null) {
            this.atj = LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.main_input_username, (ViewGroup) null);
            this.atl = (EditText) this.atj.findViewById(w.h.account);
            this.atl.setHint(this.aaI.getString(w.l.input_alias_limit_length_tip));
            this.ats = (TextView) this.atj.findViewById(w.h.back);
            this.ats.setOnClickListener(new k(this));
            this.atw = (TextView) this.atj.findViewById(w.h.confirm);
            this.atw.setOnClickListener(new l(this));
            this.atx = (ProgressBar) this.atj.findViewById(w.h.confirm_progress);
            this.atv = (TextView) this.atj.findViewById(w.h.error_info);
            this.atm = (RadioGroup) this.atj.findViewById(w.h.names_group1);
            this.atn = (RadioGroup) this.atj.findViewById(w.h.names_group2);
            this.atp = (RadioButton) this.atj.findViewById(w.h.name1);
            this.atq = (RadioButton) this.atj.findViewById(w.h.name2);
            this.atr = (RadioButton) this.atj.findViewById(w.h.name3);
            this.ato = new m(this);
            this.atp.setOnCheckedChangeListener(this.ato);
            this.atq.setOnCheckedChangeListener(this.ato);
            this.atr.setOnCheckedChangeListener(this.ato);
            this.aty = (TextView) this.atj.findViewById(w.h.phone_info);
            AV();
            this.atk = new Dialog(this.aaI.getPageActivity(), w.m.input_username_dialog);
            this.atk.setCanceledOnTouchOutside(false);
            this.atk.setCancelable(false);
            this.atk.setCanceledOnTouchOutside(false);
            AO();
        }
        if (!this.atk.isShowing()) {
            this.atl.setText((CharSequence) null);
            AV();
            eB(null);
            if (this.atz == null || this.atz.length() <= 0) {
                this.aty.setText("Hi," + this.aaI.getString(w.l.bar_friend));
            } else {
                this.aty.setText("Hi," + this.atz);
            }
            if (!this.aaI.getPageActivity().isFinishing()) {
                this.atk.setContentView(this.atj);
                com.baidu.adp.lib.g.j.a(this.atk, this.aaI);
                if (this.aaI.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aaI.getOrignalPage()).ShowSoftKeyPadDelay(this.atl, 150);
                }
            }
        }
    }

    public void AT() {
        String editable = this.atl.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eB(this.aaI.getString(w.l.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eB(this.aaI.getString(w.l.input_alias_limit_length_tip));
        } else {
            if (this.atu != null) {
                this.atu.cancel();
            }
            if (this.att == null) {
                this.att = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.att.setPriority(3);
                this.att.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        if (this.atC != null) {
            this.atC.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eB(this.aaI.getString(w.l.suggest_no_name));
            return;
        }
        eB(this.aaI.getString(w.l.suggest_some_names));
        int size = arrayList.size();
        this.atm.clearCheck();
        this.atn.clearCheck();
        this.atm.setVisibility(0);
        this.atn.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.atp.setText(arrayList.get(0));
            this.atp.setChecked(false);
            this.atp.setCompoundDrawables(this.atE, null, null, null);
            this.atp.setVisibility(0);
            this.atm.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.atq.setText(arrayList.get(1));
            this.atq.setChecked(false);
            this.atq.setCompoundDrawables(this.atE, null, null, null);
            this.atq.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.atr.setText(arrayList.get(2));
            this.atr.setChecked(false);
            this.atr.setCompoundDrawables(this.atE, null, null, null);
            this.atr.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.att != null) {
            this.att.cancel();
            this.att = null;
        }
        if (this.atu != null) {
            this.atu.cancel();
            this.atu = null;
        }
        AW();
    }

    public void AV() {
        this.atm.setVisibility(8);
        this.atm.clearCheck();
        this.atn.setVisibility(8);
        this.atn.clearCheck();
        this.atp.setVisibility(8);
        this.atq.setVisibility(8);
        this.atr.setVisibility(8);
        this.atp.setChecked(false);
        this.atq.setChecked(false);
        this.atr.setChecked(false);
    }

    public void AW() {
        if (this.atk != null && this.atk.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.atk, this.aaI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(String str) {
        if (str == null) {
            this.atv.setVisibility(4);
            this.atv.setText((CharSequence) null);
            return;
        }
        this.atv.setVisibility(0);
        this.atv.setText(str);
    }

    public void AO() {
        this.aaI.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaI.getLayoutMode().t(this.atj);
        this.atl.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.atp.setCompoundDrawables(this.atE, null, null, null);
        this.atq.setCompoundDrawables(this.atE, null, null, null);
        this.atr.setCompoundDrawables(this.atE, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private String mAccount;
        private com.baidu.tbadk.core.util.z mNetwork = null;
        private String mUrl;

        public c(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.att = null;
            j.this.atx.setVisibility(8);
            j.this.atw.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.att = null;
            j.this.atx.setVisibility(8);
            j.this.atw.setEnabled(true);
            if (fVar == null) {
                j.this.eB(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.AW();
                TbadkCoreApplication.setCurrentAccount(j.this.atA, j.this.aaI.getPageActivity());
                if (j.this.atB != null) {
                    j.this.atB.j(j.this.atA);
                }
            } else {
                j.this.n(fVar.xU());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.atx.setVisibility(0);
            j.this.atw.setEnabled(false);
            j.this.eB(null);
            j.this.AV();
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
            String uB;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.z(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", j.this.atA.getBDUSS());
                this.mNetwork.uZ().vS().agT = false;
                uB = this.mNetwork.uB();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.mNetwork.vc()) {
                str = this.mNetwork.vd();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(uB);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.atA != null) {
                            j.this.atA.setAccount(userName);
                            j.this.atA.setBDUSS(bduss);
                            j.this.atA.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.atA;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.mNetwork.vd() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(uB);
                    str = fVar2;
                } else if (this.mNetwork.vd() == 1) {
                    j.this.AW();
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
        final /* synthetic */ j atF;
        private String mAccount;
        private com.baidu.tbadk.core.util.z mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.atF.atu = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uB = this.mNetwork.uB();
            if (!this.mNetwork.vc() || this.mNetwork.vd() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uB);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.atF.atu = null;
            if (!this.mNetwork.vc()) {
                this.atF.eB(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vd() == 0) {
                this.atF.eB(this.atF.aaI.getString(w.l.name_not_use));
            } else if (this.mNetwork.vd() == 36) {
                this.atF.eB(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.atF.n(fVar.xU());
                }
            } else {
                this.atF.eB(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.atF.eB(null);
            this.atF.AV();
            super.onPreExecute();
        }
    }
}
