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
    private TbPageContext<?> aaY;
    private View atB = null;
    private Dialog atC = null;
    private EditText atD = null;
    private RadioGroup atE = null;
    private RadioGroup atF = null;
    private CompoundButton.OnCheckedChangeListener atG = null;
    private RadioButton atH = null;
    private RadioButton atI = null;
    private RadioButton atJ = null;
    private TextView atK = null;
    private c atL = null;
    private b atM = null;
    private TextView atN = null;
    private TextView atO = null;
    private ProgressBar atP = null;
    private TextView atQ = null;
    private String atR = null;
    private AccountData atS = null;
    private a atT = null;
    private a atU = null;
    private Drawable atV;
    private Drawable atW;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.aaY = null;
        this.atV = null;
        this.atW = null;
        this.size = 0;
        this.aaY = tbPageContext;
        this.atV = aq.getDrawable(w.g.icon_tips_names_s);
        this.atW = aq.getDrawable(w.g.icon_tips_names_n);
        this.size = this.aaY.getResources().getDimensionPixelSize(w.f.ds26);
        this.atV.setBounds(0, 0, this.size, this.size);
        this.atW.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.atS = accountData;
    }

    public void a(a aVar) {
        this.atT = aVar;
    }

    public void b(a aVar) {
        this.atU = aVar;
    }

    public void Br() {
        if (this.atC == null) {
            this.atB = LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.main_input_username, (ViewGroup) null);
            this.atD = (EditText) this.atB.findViewById(w.h.account);
            this.atD.setHint(this.aaY.getString(w.l.input_alias_limit_length_tip));
            this.atK = (TextView) this.atB.findViewById(w.h.back);
            this.atK.setOnClickListener(new k(this));
            this.atO = (TextView) this.atB.findViewById(w.h.confirm);
            this.atO.setOnClickListener(new l(this));
            this.atP = (ProgressBar) this.atB.findViewById(w.h.confirm_progress);
            this.atN = (TextView) this.atB.findViewById(w.h.error_info);
            this.atE = (RadioGroup) this.atB.findViewById(w.h.names_group1);
            this.atF = (RadioGroup) this.atB.findViewById(w.h.names_group2);
            this.atH = (RadioButton) this.atB.findViewById(w.h.name1);
            this.atI = (RadioButton) this.atB.findViewById(w.h.name2);
            this.atJ = (RadioButton) this.atB.findViewById(w.h.name3);
            this.atG = new m(this);
            this.atH.setOnCheckedChangeListener(this.atG);
            this.atI.setOnCheckedChangeListener(this.atG);
            this.atJ.setOnCheckedChangeListener(this.atG);
            this.atQ = (TextView) this.atB.findViewById(w.h.phone_info);
            Bu();
            this.atC = new Dialog(this.aaY.getPageActivity(), w.m.input_username_dialog);
            this.atC.setCanceledOnTouchOutside(false);
            this.atC.setCancelable(false);
            this.atC.setCanceledOnTouchOutside(false);
            Bn();
        }
        if (!this.atC.isShowing()) {
            this.atD.setText((CharSequence) null);
            Bu();
            eH(null);
            if (this.atR == null || this.atR.length() <= 0) {
                this.atQ.setText("Hi," + this.aaY.getString(w.l.bar_friend));
            } else {
                this.atQ.setText("Hi," + this.atR);
            }
            if (!this.aaY.getPageActivity().isFinishing()) {
                this.atC.setContentView(this.atB);
                com.baidu.adp.lib.g.j.a(this.atC, this.aaY);
                if (this.aaY.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aaY.getOrignalPage()).ShowSoftKeyPadDelay(this.atD, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bs() {
        String editable = this.atD.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eH(this.aaY.getString(w.l.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eH(this.aaY.getString(w.l.input_alias_limit_length_tip));
        } else {
            if (this.atM != null) {
                this.atM.cancel();
            }
            if (this.atL == null) {
                this.atL = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.atL.setPriority(3);
                this.atL.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt() {
        if (this.atU != null) {
            this.atU.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eH(this.aaY.getString(w.l.suggest_no_name));
            return;
        }
        eH(this.aaY.getString(w.l.suggest_some_names));
        int size = arrayList.size();
        this.atE.clearCheck();
        this.atF.clearCheck();
        this.atE.setVisibility(0);
        this.atF.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.atH.setText(arrayList.get(0));
            this.atH.setChecked(false);
            this.atH.setCompoundDrawables(this.atW, null, null, null);
            this.atH.setVisibility(0);
            this.atE.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.atI.setText(arrayList.get(1));
            this.atI.setChecked(false);
            this.atI.setCompoundDrawables(this.atW, null, null, null);
            this.atI.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.atJ.setText(arrayList.get(2));
            this.atJ.setChecked(false);
            this.atJ.setCompoundDrawables(this.atW, null, null, null);
            this.atJ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.atL != null) {
            this.atL.cancel();
            this.atL = null;
        }
        if (this.atM != null) {
            this.atM.cancel();
            this.atM = null;
        }
        Bv();
    }

    public void Bu() {
        this.atE.setVisibility(8);
        this.atE.clearCheck();
        this.atF.setVisibility(8);
        this.atF.clearCheck();
        this.atH.setVisibility(8);
        this.atI.setVisibility(8);
        this.atJ.setVisibility(8);
        this.atH.setChecked(false);
        this.atI.setChecked(false);
        this.atJ.setChecked(false);
    }

    public void Bv() {
        if (this.atC != null && this.atC.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.atC, this.aaY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(String str) {
        if (str == null) {
            this.atN.setVisibility(4);
            this.atN.setText((CharSequence) null);
            return;
        }
        this.atN.setVisibility(0);
        this.atN.setText(str);
    }

    public void Bn() {
        this.aaY.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaY.getLayoutMode().t(this.atB);
        this.atD.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.atH.setCompoundDrawables(this.atW, null, null, null);
        this.atI.setCompoundDrawables(this.atW, null, null, null);
        this.atJ.setCompoundDrawables(this.atW, null, null, null);
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
            j.this.atL = null;
            j.this.atP.setVisibility(8);
            j.this.atO.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.atL = null;
            j.this.atP.setVisibility(8);
            j.this.atO.setEnabled(true);
            if (fVar == null) {
                j.this.eH(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.Bv();
                TbadkCoreApplication.setCurrentAccount(j.this.atS, j.this.aaY.getPageActivity());
                if (j.this.atT != null) {
                    j.this.atT.j(j.this.atS);
                }
            } else {
                j.this.n(fVar.ys());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.atP.setVisibility(0);
            j.this.atO.setEnabled(false);
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
        /* renamed from: o */
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
                this.mNetwork.n("BDUSS", j.this.atS.getBDUSS());
                this.mNetwork.vw().wp().ahi = false;
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
                        if (j.this.atS != null) {
                            j.this.atS.setAccount(userName);
                            j.this.atS.setBDUSS(bduss);
                            j.this.atS.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.atS;
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
        final /* synthetic */ j atX;
        private String mAccount;
        private com.baidu.tbadk.core.util.z mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.atX.atM = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
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
            this.atX.atM = null;
            if (!this.mNetwork.vz()) {
                this.atX.eH(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vA() == 0) {
                this.atX.eH(this.atX.aaY.getString(w.l.name_not_use));
            } else if (this.mNetwork.vA() == 36) {
                this.atX.eH(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.atX.n(fVar.ys());
                }
            } else {
                this.atX.eH(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.atX.eH(null);
            this.atX.Bu();
            super.onPreExecute();
        }
    }
}
