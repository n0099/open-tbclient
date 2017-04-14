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
    private TbPageContext<?> aaX;
    private Drawable atT;
    private Drawable atU;
    private int size;
    private View atz = null;
    private Dialog atA = null;
    private EditText atB = null;
    private RadioGroup atC = null;
    private RadioGroup atD = null;
    private CompoundButton.OnCheckedChangeListener atE = null;
    private RadioButton atF = null;
    private RadioButton atG = null;
    private RadioButton atH = null;
    private TextView atI = null;
    private c atJ = null;
    private b atK = null;
    private TextView atL = null;
    private TextView atM = null;
    private ProgressBar atN = null;
    private TextView atO = null;
    private String atP = null;
    private AccountData atQ = null;
    private a atR = null;
    private a atS = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.aaX = null;
        this.atT = null;
        this.atU = null;
        this.size = 0;
        this.aaX = tbPageContext;
        this.atT = aq.getDrawable(w.g.icon_tips_names_s);
        this.atU = aq.getDrawable(w.g.icon_tips_names_n);
        this.size = this.aaX.getResources().getDimensionPixelSize(w.f.ds26);
        this.atT.setBounds(0, 0, this.size, this.size);
        this.atU.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.atQ = accountData;
    }

    public void a(a aVar) {
        this.atR = aVar;
    }

    public void b(a aVar) {
        this.atS = aVar;
    }

    public void Br() {
        if (this.atA == null) {
            this.atz = LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.main_input_username, (ViewGroup) null);
            this.atB = (EditText) this.atz.findViewById(w.h.account);
            this.atB.setHint(this.aaX.getString(w.l.input_alias_limit_length_tip));
            this.atI = (TextView) this.atz.findViewById(w.h.back);
            this.atI.setOnClickListener(new k(this));
            this.atM = (TextView) this.atz.findViewById(w.h.confirm);
            this.atM.setOnClickListener(new l(this));
            this.atN = (ProgressBar) this.atz.findViewById(w.h.confirm_progress);
            this.atL = (TextView) this.atz.findViewById(w.h.error_info);
            this.atC = (RadioGroup) this.atz.findViewById(w.h.names_group1);
            this.atD = (RadioGroup) this.atz.findViewById(w.h.names_group2);
            this.atF = (RadioButton) this.atz.findViewById(w.h.name1);
            this.atG = (RadioButton) this.atz.findViewById(w.h.name2);
            this.atH = (RadioButton) this.atz.findViewById(w.h.name3);
            this.atE = new m(this);
            this.atF.setOnCheckedChangeListener(this.atE);
            this.atG.setOnCheckedChangeListener(this.atE);
            this.atH.setOnCheckedChangeListener(this.atE);
            this.atO = (TextView) this.atz.findViewById(w.h.phone_info);
            Bu();
            this.atA = new Dialog(this.aaX.getPageActivity(), w.m.input_username_dialog);
            this.atA.setCanceledOnTouchOutside(false);
            this.atA.setCancelable(false);
            this.atA.setCanceledOnTouchOutside(false);
            Bn();
        }
        if (!this.atA.isShowing()) {
            this.atB.setText((CharSequence) null);
            Bu();
            eH(null);
            if (this.atP == null || this.atP.length() <= 0) {
                this.atO.setText("Hi," + this.aaX.getString(w.l.bar_friend));
            } else {
                this.atO.setText("Hi," + this.atP);
            }
            if (!this.aaX.getPageActivity().isFinishing()) {
                this.atA.setContentView(this.atz);
                com.baidu.adp.lib.g.j.a(this.atA, this.aaX);
                if (this.aaX.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aaX.getOrignalPage()).ShowSoftKeyPadDelay(this.atB, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bs() {
        String editable = this.atB.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eH(this.aaX.getString(w.l.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eH(this.aaX.getString(w.l.input_alias_limit_length_tip));
        } else {
            if (this.atK != null) {
                this.atK.cancel();
            }
            if (this.atJ == null) {
                this.atJ = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.atJ.setPriority(3);
                this.atJ.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt() {
        if (this.atS != null) {
            this.atS.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eH(this.aaX.getString(w.l.suggest_no_name));
            return;
        }
        eH(this.aaX.getString(w.l.suggest_some_names));
        int size = arrayList.size();
        this.atC.clearCheck();
        this.atD.clearCheck();
        this.atC.setVisibility(0);
        this.atD.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.atF.setText(arrayList.get(0));
            this.atF.setChecked(false);
            this.atF.setCompoundDrawables(this.atU, null, null, null);
            this.atF.setVisibility(0);
            this.atC.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.atG.setText(arrayList.get(1));
            this.atG.setChecked(false);
            this.atG.setCompoundDrawables(this.atU, null, null, null);
            this.atG.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.atH.setText(arrayList.get(2));
            this.atH.setChecked(false);
            this.atH.setCompoundDrawables(this.atU, null, null, null);
            this.atH.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.atJ != null) {
            this.atJ.cancel();
            this.atJ = null;
        }
        if (this.atK != null) {
            this.atK.cancel();
            this.atK = null;
        }
        Bv();
    }

    public void Bu() {
        this.atC.setVisibility(8);
        this.atC.clearCheck();
        this.atD.setVisibility(8);
        this.atD.clearCheck();
        this.atF.setVisibility(8);
        this.atG.setVisibility(8);
        this.atH.setVisibility(8);
        this.atF.setChecked(false);
        this.atG.setChecked(false);
        this.atH.setChecked(false);
    }

    public void Bv() {
        if (this.atA != null && this.atA.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.atA, this.aaX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(String str) {
        if (str == null) {
            this.atL.setVisibility(4);
            this.atL.setText((CharSequence) null);
            return;
        }
        this.atL.setVisibility(0);
        this.atL.setText(str);
    }

    public void Bn() {
        this.aaX.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaX.getLayoutMode().t(this.atz);
        this.atB.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.atF.setCompoundDrawables(this.atU, null, null, null);
        this.atG.setCompoundDrawables(this.atU, null, null, null);
        this.atH.setCompoundDrawables(this.atU, null, null, null);
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
            j.this.atJ = null;
            j.this.atN.setVisibility(8);
            j.this.atM.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.atJ = null;
            j.this.atN.setVisibility(8);
            j.this.atM.setEnabled(true);
            if (fVar == null) {
                j.this.eH(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.Bv();
                TbadkCoreApplication.setCurrentAccount(j.this.atQ, j.this.aaX.getPageActivity());
                if (j.this.atR != null) {
                    j.this.atR.j(j.this.atQ);
                }
            } else {
                j.this.n(fVar.ys());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.atN.setVisibility(0);
            j.this.atM.setEnabled(false);
            j.this.eH(null);
            j.this.Bu();
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
            String uY;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.z(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", j.this.atQ.getBDUSS());
                this.mNetwork.vw().wp().ahh = false;
                uY = this.mNetwork.uY();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.mNetwork.vz()) {
                str = this.mNetwork.vA();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(uY);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.atQ != null) {
                            j.this.atQ.setAccount(userName);
                            j.this.atQ.setBDUSS(bduss);
                            j.this.atQ.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.atQ;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.mNetwork.vA() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(uY);
                    str = fVar2;
                } else if (this.mNetwork.vA() == 1) {
                    j.this.Bv();
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
        final /* synthetic */ j atV;
        private String mAccount;
        private com.baidu.tbadk.core.util.z mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.atV.atK = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uY = this.mNetwork.uY();
            if (!this.mNetwork.vz() || this.mNetwork.vA() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uY);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.atV.atK = null;
            if (!this.mNetwork.vz()) {
                this.atV.eH(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vA() == 0) {
                this.atV.eH(this.atV.aaX.getString(w.l.name_not_use));
            } else if (this.mNetwork.vA() == 36) {
                this.atV.eH(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.atV.n(fVar.ys());
                }
            } else {
                this.atV.eH(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.atV.eH(null);
            this.atV.Bu();
            super.onPreExecute();
        }
    }
}
