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
    private TbPageContext<?> aas;
    private Drawable atJ;
    private Drawable atK;
    private int size;
    private View atp = null;
    private Dialog atq = null;
    private EditText atr = null;
    private RadioGroup ats = null;
    private RadioGroup att = null;
    private CompoundButton.OnCheckedChangeListener atu = null;
    private RadioButton atv = null;
    private RadioButton atw = null;
    private RadioButton atx = null;
    private TextView aty = null;
    private c atz = null;
    private b atA = null;
    private TextView atB = null;
    private TextView atC = null;
    private ProgressBar atD = null;
    private TextView atE = null;
    private String atF = null;
    private AccountData atG = null;
    private a atH = null;
    private a atI = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.aas = null;
        this.atJ = null;
        this.atK = null;
        this.size = 0;
        this.aas = tbPageContext;
        this.atJ = aq.getDrawable(w.g.icon_tips_names_s);
        this.atK = aq.getDrawable(w.g.icon_tips_names_n);
        this.size = this.aas.getResources().getDimensionPixelSize(w.f.ds26);
        this.atJ.setBounds(0, 0, this.size, this.size);
        this.atK.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.atG = accountData;
    }

    public void a(a aVar) {
        this.atH = aVar;
    }

    public void b(a aVar) {
        this.atI = aVar;
    }

    public void Av() {
        if (this.atq == null) {
            this.atp = LayoutInflater.from(this.aas.getPageActivity()).inflate(w.j.main_input_username, (ViewGroup) null);
            this.atr = (EditText) this.atp.findViewById(w.h.account);
            this.atr.setHint(this.aas.getString(w.l.input_alias_limit_length_tip));
            this.aty = (TextView) this.atp.findViewById(w.h.back);
            this.aty.setOnClickListener(new k(this));
            this.atC = (TextView) this.atp.findViewById(w.h.confirm);
            this.atC.setOnClickListener(new l(this));
            this.atD = (ProgressBar) this.atp.findViewById(w.h.confirm_progress);
            this.atB = (TextView) this.atp.findViewById(w.h.error_info);
            this.ats = (RadioGroup) this.atp.findViewById(w.h.names_group1);
            this.att = (RadioGroup) this.atp.findViewById(w.h.names_group2);
            this.atv = (RadioButton) this.atp.findViewById(w.h.name1);
            this.atw = (RadioButton) this.atp.findViewById(w.h.name2);
            this.atx = (RadioButton) this.atp.findViewById(w.h.name3);
            this.atu = new m(this);
            this.atv.setOnCheckedChangeListener(this.atu);
            this.atw.setOnCheckedChangeListener(this.atu);
            this.atx.setOnCheckedChangeListener(this.atu);
            this.atE = (TextView) this.atp.findViewById(w.h.phone_info);
            Ay();
            this.atq = new Dialog(this.aas.getPageActivity(), w.m.input_username_dialog);
            this.atq.setCanceledOnTouchOutside(false);
            this.atq.setCancelable(false);
            this.atq.setCanceledOnTouchOutside(false);
            Ar();
        }
        if (!this.atq.isShowing()) {
            this.atr.setText((CharSequence) null);
            Ay();
            eE(null);
            if (this.atF == null || this.atF.length() <= 0) {
                this.atE.setText("Hi," + this.aas.getString(w.l.bar_friend));
            } else {
                this.atE.setText("Hi," + this.atF);
            }
            if (!this.aas.getPageActivity().isFinishing()) {
                this.atq.setContentView(this.atp);
                com.baidu.adp.lib.g.j.a(this.atq, this.aas);
                if (this.aas.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aas.getOrignalPage()).ShowSoftKeyPadDelay(this.atr, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Aw() {
        String editable = this.atr.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eE(this.aas.getString(w.l.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eE(this.aas.getString(w.l.input_alias_limit_length_tip));
        } else {
            if (this.atA != null) {
                this.atA.cancel();
            }
            if (this.atz == null) {
                this.atz = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.atz.setPriority(3);
                this.atz.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ax() {
        if (this.atI != null) {
            this.atI.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eE(this.aas.getString(w.l.suggest_no_name));
            return;
        }
        eE(this.aas.getString(w.l.suggest_some_names));
        int size = arrayList.size();
        this.ats.clearCheck();
        this.att.clearCheck();
        this.ats.setVisibility(0);
        this.att.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.atv.setText(arrayList.get(0));
            this.atv.setChecked(false);
            this.atv.setCompoundDrawables(this.atK, null, null, null);
            this.atv.setVisibility(0);
            this.ats.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.atw.setText(arrayList.get(1));
            this.atw.setChecked(false);
            this.atw.setCompoundDrawables(this.atK, null, null, null);
            this.atw.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.atx.setText(arrayList.get(2));
            this.atx.setChecked(false);
            this.atx.setCompoundDrawables(this.atK, null, null, null);
            this.atx.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.atz != null) {
            this.atz.cancel();
            this.atz = null;
        }
        if (this.atA != null) {
            this.atA.cancel();
            this.atA = null;
        }
        Az();
    }

    public void Ay() {
        this.ats.setVisibility(8);
        this.ats.clearCheck();
        this.att.setVisibility(8);
        this.att.clearCheck();
        this.atv.setVisibility(8);
        this.atw.setVisibility(8);
        this.atx.setVisibility(8);
        this.atv.setChecked(false);
        this.atw.setChecked(false);
        this.atx.setChecked(false);
    }

    public void Az() {
        if (this.atq != null && this.atq.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.atq, this.aas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(String str) {
        if (str == null) {
            this.atB.setVisibility(4);
            this.atB.setText((CharSequence) null);
            return;
        }
        this.atB.setVisibility(0);
        this.atB.setText(str);
    }

    public void Ar() {
        this.aas.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aas.getLayoutMode().t(this.atp);
        this.atr.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.atv.setCompoundDrawables(this.atK, null, null, null);
        this.atw.setCompoundDrawables(this.atK, null, null, null);
        this.atx.setCompoundDrawables(this.atK, null, null, null);
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
            j.this.atz = null;
            j.this.atD.setVisibility(8);
            j.this.atC.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.atz = null;
            j.this.atD.setVisibility(8);
            j.this.atC.setEnabled(true);
            if (fVar == null) {
                j.this.eE(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.Az();
                TbadkCoreApplication.setCurrentAccount(j.this.atG, j.this.aas.getPageActivity());
                if (j.this.atH != null) {
                    j.this.atH.j(j.this.atG);
                }
            } else {
                j.this.n(fVar.xz());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.atD.setVisibility(0);
            j.this.atC.setEnabled(false);
            j.this.eE(null);
            j.this.Ay();
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
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            String str;
            Exception e;
            String ug;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.z(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", j.this.atG.getBDUSS());
                this.mNetwork.uF().vA().agr = false;
                ug = this.mNetwork.ug();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.mNetwork.uI()) {
                str = this.mNetwork.uJ();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(ug);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.atG != null) {
                            j.this.atG.setAccount(userName);
                            j.this.atG.setBDUSS(bduss);
                            j.this.atG.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.atG;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.mNetwork.uJ() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(ug);
                    str = fVar2;
                } else if (this.mNetwork.uJ() == 1) {
                    j.this.Az();
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
        final /* synthetic */ j atL;
        private String mAccount;
        private com.baidu.tbadk.core.util.z mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.atL.atA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String ug = this.mNetwork.ug();
            if (!this.mNetwork.uI() || this.mNetwork.uJ() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(ug);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.atL.atA = null;
            if (!this.mNetwork.uI()) {
                this.atL.eE(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uJ() == 0) {
                this.atL.eE(this.atL.aas.getString(w.l.name_not_use));
            } else if (this.mNetwork.uJ() == 36) {
                this.atL.eE(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.atL.n(fVar.xz());
                }
            } else {
                this.atL.eE(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.atL.eE(null);
            this.atL.Ay();
            super.onPreExecute();
        }
    }
}
