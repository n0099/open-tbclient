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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> aat;
    private Drawable auM;
    private Drawable auN;
    private int size;
    private View aus = null;
    private Dialog aut = null;
    private EditText auu = null;
    private RadioGroup auv = null;
    private RadioGroup auw = null;
    private CompoundButton.OnCheckedChangeListener aux = null;
    private RadioButton auy = null;
    private RadioButton auz = null;
    private RadioButton auA = null;
    private TextView auB = null;
    private c auC = null;
    private b auD = null;
    private TextView auE = null;
    private TextView auF = null;
    private ProgressBar auG = null;
    private TextView auH = null;
    private String auI = null;
    private AccountData auJ = null;
    private a auK = null;
    private a auL = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.aat = null;
        this.auM = null;
        this.auN = null;
        this.size = 0;
        this.aat = tbPageContext;
        this.auM = as.getDrawable(w.g.icon_tips_names_s);
        this.auN = as.getDrawable(w.g.icon_tips_names_n);
        this.size = this.aat.getResources().getDimensionPixelSize(w.f.ds26);
        this.auM.setBounds(0, 0, this.size, this.size);
        this.auN.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.auJ = accountData;
    }

    public void a(a aVar) {
        this.auK = aVar;
    }

    public void b(a aVar) {
        this.auL = aVar;
    }

    public void AQ() {
        if (this.aut == null) {
            this.aus = LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.main_input_username, (ViewGroup) null);
            this.auu = (EditText) this.aus.findViewById(w.h.account);
            this.auu.setHint(this.aat.getString(w.l.input_alias_limit_length_tip));
            this.auB = (TextView) this.aus.findViewById(w.h.back);
            this.auB.setOnClickListener(new k(this));
            this.auF = (TextView) this.aus.findViewById(w.h.confirm);
            this.auF.setOnClickListener(new l(this));
            this.auG = (ProgressBar) this.aus.findViewById(w.h.confirm_progress);
            this.auE = (TextView) this.aus.findViewById(w.h.error_info);
            this.auv = (RadioGroup) this.aus.findViewById(w.h.names_group1);
            this.auw = (RadioGroup) this.aus.findViewById(w.h.names_group2);
            this.auy = (RadioButton) this.aus.findViewById(w.h.name1);
            this.auz = (RadioButton) this.aus.findViewById(w.h.name2);
            this.auA = (RadioButton) this.aus.findViewById(w.h.name3);
            this.aux = new m(this);
            this.auy.setOnCheckedChangeListener(this.aux);
            this.auz.setOnCheckedChangeListener(this.aux);
            this.auA.setOnCheckedChangeListener(this.aux);
            this.auH = (TextView) this.aus.findViewById(w.h.phone_info);
            AT();
            this.aut = new Dialog(this.aat.getPageActivity(), w.m.input_username_dialog);
            this.aut.setCanceledOnTouchOutside(false);
            this.aut.setCancelable(false);
            this.aut.setCanceledOnTouchOutside(false);
            AM();
        }
        if (!this.aut.isShowing()) {
            this.auu.setText((CharSequence) null);
            AT();
            eY(null);
            if (this.auI == null || this.auI.length() <= 0) {
                this.auH.setText("Hi," + this.aat.getString(w.l.bar_friend));
            } else {
                this.auH.setText("Hi," + this.auI);
            }
            if (!this.aat.getPageActivity().isFinishing()) {
                this.aut.setContentView(this.aus);
                com.baidu.adp.lib.g.j.a(this.aut, this.aat);
                if (this.aat.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aat.getOrignalPage()).ShowSoftKeyPadDelay(this.auu, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void AR() {
        String editable = this.auu.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eY(this.aat.getString(w.l.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eY(this.aat.getString(w.l.input_alias_limit_length_tip));
        } else {
            if (this.auD != null) {
                this.auD.cancel();
            }
            if (this.auC == null) {
                this.auC = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.auC.setPriority(3);
                this.auC.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS() {
        if (this.auL != null) {
            this.auL.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eY(this.aat.getString(w.l.suggest_no_name));
            return;
        }
        eY(this.aat.getString(w.l.suggest_some_names));
        int size = arrayList.size();
        this.auv.clearCheck();
        this.auw.clearCheck();
        this.auv.setVisibility(0);
        this.auw.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.auy.setText(arrayList.get(0));
            this.auy.setChecked(false);
            this.auy.setCompoundDrawables(this.auN, null, null, null);
            this.auy.setVisibility(0);
            this.auv.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.auz.setText(arrayList.get(1));
            this.auz.setChecked(false);
            this.auz.setCompoundDrawables(this.auN, null, null, null);
            this.auz.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.auA.setText(arrayList.get(2));
            this.auA.setChecked(false);
            this.auA.setCompoundDrawables(this.auN, null, null, null);
            this.auA.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.auC != null) {
            this.auC.cancel();
            this.auC = null;
        }
        if (this.auD != null) {
            this.auD.cancel();
            this.auD = null;
        }
        AU();
    }

    public void AT() {
        this.auv.setVisibility(8);
        this.auv.clearCheck();
        this.auw.setVisibility(8);
        this.auw.clearCheck();
        this.auy.setVisibility(8);
        this.auz.setVisibility(8);
        this.auA.setVisibility(8);
        this.auy.setChecked(false);
        this.auz.setChecked(false);
        this.auA.setChecked(false);
    }

    public void AU() {
        if (this.aut != null && this.aut.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.aut, this.aat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(String str) {
        if (str == null) {
            this.auE.setVisibility(4);
            this.auE.setText((CharSequence) null);
            return;
        }
        this.auE.setVisibility(0);
        this.auE.setText(str);
    }

    public void AM() {
        this.aat.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aat.getLayoutMode().t(this.aus);
        this.auu.setHintTextColor(as.getColor(w.e.cp_cont_e));
        this.auy.setCompoundDrawables(this.auN, null, null, null);
        this.auz.setCompoundDrawables(this.auN, null, null, null);
        this.auA.setCompoundDrawables(this.auN, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private String mAccount;
        private com.baidu.tbadk.core.util.ab mNetwork = null;
        private String mUrl;

        public c(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.auC = null;
            j.this.auG.setVisibility(8);
            j.this.auF.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.auC = null;
            j.this.auG.setVisibility(8);
            j.this.auF.setEnabled(true);
            if (fVar == null) {
                j.this.eY(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.AU();
                TbadkCoreApplication.setCurrentAccount(j.this.auJ, j.this.aat.getPageActivity());
                if (j.this.auK != null) {
                    j.this.auK.j(j.this.auJ);
                }
            } else {
                j.this.n(fVar.xQ());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.auG.setVisibility(0);
            j.this.auF.setEnabled(false);
            j.this.eY(null);
            j.this.AT();
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
            String uy;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", j.this.auJ.getBDUSS());
                this.mNetwork.uV().vR().agZ = false;
                uy = this.mNetwork.uy();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.mNetwork.uY()) {
                str = this.mNetwork.uZ();
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
                        if (j.this.auJ != null) {
                            j.this.auJ.setAccount(userName);
                            j.this.auJ.setBDUSS(bduss);
                            j.this.auJ.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.auJ;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.mNetwork.uZ() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(uy);
                    str = fVar2;
                } else if (this.mNetwork.uZ() == 1) {
                    j.this.AU();
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
        final /* synthetic */ j auO;
        private String mAccount;
        private com.baidu.tbadk.core.util.ab mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.auO.auD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uy = this.mNetwork.uy();
            if (!this.mNetwork.uY() || this.mNetwork.uZ() != 36) {
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
            this.auO.auD = null;
            if (!this.mNetwork.uY()) {
                this.auO.eY(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uZ() == 0) {
                this.auO.eY(this.auO.aat.getString(w.l.name_not_use));
            } else if (this.mNetwork.uZ() == 36) {
                this.auO.eY(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.auO.n(fVar.xQ());
                }
            } else {
                this.auO.eY(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.auO.eY(null);
            this.auO.AT();
            super.onPreExecute();
        }
    }
}
