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
    private TbPageContext<?> aat;
    private View atF = null;
    private Dialog atG = null;
    private EditText atH = null;
    private RadioGroup atI = null;
    private RadioGroup atJ = null;
    private CompoundButton.OnCheckedChangeListener atK = null;
    private RadioButton atL = null;
    private RadioButton atM = null;
    private RadioButton atN = null;
    private TextView atO = null;
    private c atP = null;
    private b atQ = null;
    private TextView atR = null;
    private TextView atS = null;
    private ProgressBar atT = null;
    private TextView atU = null;
    private String atV = null;
    private AccountData atW = null;
    private a atX = null;
    private a atY = null;
    private Drawable atZ;
    private Drawable aua;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.aat = null;
        this.atZ = null;
        this.aua = null;
        this.size = 0;
        this.aat = tbPageContext;
        this.atZ = aq.getDrawable(w.g.icon_tips_names_s);
        this.aua = aq.getDrawable(w.g.icon_tips_names_n);
        this.size = this.aat.getResources().getDimensionPixelSize(w.f.ds26);
        this.atZ.setBounds(0, 0, this.size, this.size);
        this.aua.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.atW = accountData;
    }

    public void a(a aVar) {
        this.atX = aVar;
    }

    public void b(a aVar) {
        this.atY = aVar;
    }

    public void AC() {
        if (this.atG == null) {
            this.atF = LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.main_input_username, (ViewGroup) null);
            this.atH = (EditText) this.atF.findViewById(w.h.account);
            this.atH.setHint(this.aat.getString(w.l.input_alias_limit_length_tip));
            this.atO = (TextView) this.atF.findViewById(w.h.back);
            this.atO.setOnClickListener(new k(this));
            this.atS = (TextView) this.atF.findViewById(w.h.confirm);
            this.atS.setOnClickListener(new l(this));
            this.atT = (ProgressBar) this.atF.findViewById(w.h.confirm_progress);
            this.atR = (TextView) this.atF.findViewById(w.h.error_info);
            this.atI = (RadioGroup) this.atF.findViewById(w.h.names_group1);
            this.atJ = (RadioGroup) this.atF.findViewById(w.h.names_group2);
            this.atL = (RadioButton) this.atF.findViewById(w.h.name1);
            this.atM = (RadioButton) this.atF.findViewById(w.h.name2);
            this.atN = (RadioButton) this.atF.findViewById(w.h.name3);
            this.atK = new m(this);
            this.atL.setOnCheckedChangeListener(this.atK);
            this.atM.setOnCheckedChangeListener(this.atK);
            this.atN.setOnCheckedChangeListener(this.atK);
            this.atU = (TextView) this.atF.findViewById(w.h.phone_info);
            AF();
            this.atG = new Dialog(this.aat.getPageActivity(), w.m.input_username_dialog);
            this.atG.setCanceledOnTouchOutside(false);
            this.atG.setCancelable(false);
            this.atG.setCanceledOnTouchOutside(false);
            Ay();
        }
        if (!this.atG.isShowing()) {
            this.atH.setText((CharSequence) null);
            AF();
            eG(null);
            if (this.atV == null || this.atV.length() <= 0) {
                this.atU.setText("Hi," + this.aat.getString(w.l.bar_friend));
            } else {
                this.atU.setText("Hi," + this.atV);
            }
            if (!this.aat.getPageActivity().isFinishing()) {
                this.atG.setContentView(this.atF);
                com.baidu.adp.lib.g.j.a(this.atG, this.aat);
                if (this.aat.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aat.getOrignalPage()).ShowSoftKeyPadDelay(this.atH, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void AD() {
        String editable = this.atH.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eG(this.aat.getString(w.l.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eG(this.aat.getString(w.l.input_alias_limit_length_tip));
        } else {
            if (this.atQ != null) {
                this.atQ.cancel();
            }
            if (this.atP == null) {
                this.atP = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.atP.setPriority(3);
                this.atP.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE() {
        if (this.atY != null) {
            this.atY.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eG(this.aat.getString(w.l.suggest_no_name));
            return;
        }
        eG(this.aat.getString(w.l.suggest_some_names));
        int size = arrayList.size();
        this.atI.clearCheck();
        this.atJ.clearCheck();
        this.atI.setVisibility(0);
        this.atJ.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.atL.setText(arrayList.get(0));
            this.atL.setChecked(false);
            this.atL.setCompoundDrawables(this.aua, null, null, null);
            this.atL.setVisibility(0);
            this.atI.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.atM.setText(arrayList.get(1));
            this.atM.setChecked(false);
            this.atM.setCompoundDrawables(this.aua, null, null, null);
            this.atM.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.atN.setText(arrayList.get(2));
            this.atN.setChecked(false);
            this.atN.setCompoundDrawables(this.aua, null, null, null);
            this.atN.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.atP != null) {
            this.atP.cancel();
            this.atP = null;
        }
        if (this.atQ != null) {
            this.atQ.cancel();
            this.atQ = null;
        }
        AG();
    }

    public void AF() {
        this.atI.setVisibility(8);
        this.atI.clearCheck();
        this.atJ.setVisibility(8);
        this.atJ.clearCheck();
        this.atL.setVisibility(8);
        this.atM.setVisibility(8);
        this.atN.setVisibility(8);
        this.atL.setChecked(false);
        this.atM.setChecked(false);
        this.atN.setChecked(false);
    }

    public void AG() {
        if (this.atG != null && this.atG.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.atG, this.aat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eG(String str) {
        if (str == null) {
            this.atR.setVisibility(4);
            this.atR.setText((CharSequence) null);
            return;
        }
        this.atR.setVisibility(0);
        this.atR.setText(str);
    }

    public void Ay() {
        this.aat.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aat.getLayoutMode().t(this.atF);
        this.atH.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.atL.setCompoundDrawables(this.aua, null, null, null);
        this.atM.setCompoundDrawables(this.aua, null, null, null);
        this.atN.setCompoundDrawables(this.aua, null, null, null);
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
            j.this.atP = null;
            j.this.atT.setVisibility(8);
            j.this.atS.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.atP = null;
            j.this.atT.setVisibility(8);
            j.this.atS.setEnabled(true);
            if (fVar == null) {
                j.this.eG(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.AG();
                TbadkCoreApplication.setCurrentAccount(j.this.atW, j.this.aat.getPageActivity());
                if (j.this.atX != null) {
                    j.this.atX.j(j.this.atW);
                }
            } else {
                j.this.n(fVar.xG());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.atT.setVisibility(0);
            j.this.atS.setEnabled(false);
            j.this.eG(null);
            j.this.AF();
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
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            String str;
            Exception e;
            String ul;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.z(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", j.this.atW.getBDUSS());
                this.mNetwork.uJ().vD().agA = false;
                ul = this.mNetwork.ul();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.mNetwork.uM()) {
                str = this.mNetwork.uN();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(ul);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.atW != null) {
                            j.this.atW.setAccount(userName);
                            j.this.atW.setBDUSS(bduss);
                            j.this.atW.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.atW;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.mNetwork.uN() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(ul);
                    str = fVar2;
                } else if (this.mNetwork.uN() == 1) {
                    j.this.AG();
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
        final /* synthetic */ j aub;
        private String mAccount;
        private com.baidu.tbadk.core.util.z mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aub.atQ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String ul = this.mNetwork.ul();
            if (!this.mNetwork.uM() || this.mNetwork.uN() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(ul);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.aub.atQ = null;
            if (!this.mNetwork.uM()) {
                this.aub.eG(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uN() == 0) {
                this.aub.eG(this.aub.aat.getString(w.l.name_not_use));
            } else if (this.mNetwork.uN() == 36) {
                this.aub.eG(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.aub.n(fVar.xG());
                }
            } else {
                this.aub.eG(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aub.eG(null);
            this.aub.AF();
            super.onPreExecute();
        }
    }
}
