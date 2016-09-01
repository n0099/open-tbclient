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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> Gd;
    private View aoE = null;
    private Dialog aoF = null;
    private EditText aoG = null;
    private RadioGroup aoH = null;
    private RadioGroup aoI = null;
    private CompoundButton.OnCheckedChangeListener aoJ = null;
    private RadioButton aoK = null;
    private RadioButton aoL = null;
    private RadioButton aoM = null;
    private TextView aoN = null;
    private c aoO = null;
    private b aoP = null;
    private TextView aoQ = null;
    private TextView aoR = null;
    private ProgressBar aoS = null;
    private TextView aoT = null;
    private String aoU = null;
    private AccountData aoV = null;
    private a aoW = null;
    private a aoX = null;
    private Drawable aoY;
    private Drawable aoZ;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.Gd = null;
        this.aoY = null;
        this.aoZ = null;
        this.size = 0;
        this.Gd = tbPageContext;
        this.aoY = av.getDrawable(t.f.icon_tips_names_s);
        this.aoZ = av.getDrawable(t.f.icon_tips_names_n);
        this.size = this.Gd.getResources().getDimensionPixelSize(t.e.ds26);
        this.aoY.setBounds(0, 0, this.size, this.size);
        this.aoZ.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.aoV = accountData;
    }

    public void a(a aVar) {
        this.aoW = aVar;
    }

    public void b(a aVar) {
        this.aoX = aVar;
    }

    public void AH() {
        if (this.aoF == null) {
            this.aoE = LayoutInflater.from(this.Gd.getPageActivity()).inflate(t.h.main_input_username, (ViewGroup) null);
            this.aoG = (EditText) this.aoE.findViewById(t.g.account);
            this.aoG.setHint(this.Gd.getString(t.j.input_alias_limit_length_tip));
            this.aoN = (TextView) this.aoE.findViewById(t.g.back);
            this.aoN.setOnClickListener(new k(this));
            this.aoR = (TextView) this.aoE.findViewById(t.g.confirm);
            this.aoR.setOnClickListener(new l(this));
            this.aoS = (ProgressBar) this.aoE.findViewById(t.g.confirm_progress);
            this.aoQ = (TextView) this.aoE.findViewById(t.g.error_info);
            this.aoH = (RadioGroup) this.aoE.findViewById(t.g.names_group1);
            this.aoI = (RadioGroup) this.aoE.findViewById(t.g.names_group2);
            this.aoK = (RadioButton) this.aoE.findViewById(t.g.name1);
            this.aoL = (RadioButton) this.aoE.findViewById(t.g.name2);
            this.aoM = (RadioButton) this.aoE.findViewById(t.g.name3);
            this.aoJ = new m(this);
            this.aoK.setOnCheckedChangeListener(this.aoJ);
            this.aoL.setOnCheckedChangeListener(this.aoJ);
            this.aoM.setOnCheckedChangeListener(this.aoJ);
            this.aoT = (TextView) this.aoE.findViewById(t.g.phone_info);
            AK();
            this.aoF = new Dialog(this.Gd.getPageActivity(), t.k.input_username_dialog);
            this.aoF.setCanceledOnTouchOutside(false);
            this.aoF.setCancelable(false);
            this.aoF.setCanceledOnTouchOutside(false);
            lO();
        }
        if (!this.aoF.isShowing()) {
            this.aoG.setText((CharSequence) null);
            AK();
            eO(null);
            if (this.aoU == null || this.aoU.length() <= 0) {
                this.aoT.setText("Hi," + this.Gd.getString(t.j.bar_friend));
            } else {
                this.aoT.setText("Hi," + this.aoU);
            }
            if (!this.Gd.getPageActivity().isFinishing()) {
                this.aoF.setContentView(this.aoE);
                com.baidu.adp.lib.h.j.a(this.aoF, this.Gd);
                if (this.Gd.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.Gd.getOrignalPage()).ShowSoftKeyPadDelay(this.aoG, 150);
                }
            }
        }
    }

    public void AI() {
        String editable = this.aoG.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eO(this.Gd.getString(t.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eO(this.Gd.getString(t.j.input_alias_limit_length_tip));
        } else {
            if (this.aoP != null) {
                this.aoP.cancel();
            }
            if (this.aoO == null) {
                this.aoO = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.aoO.setPriority(3);
                this.aoO.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ() {
        if (this.aoX != null) {
            this.aoX.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eO(this.Gd.getString(t.j.suggest_no_name));
            return;
        }
        eO(this.Gd.getString(t.j.suggest_some_names));
        int size = arrayList.size();
        this.aoH.clearCheck();
        this.aoI.clearCheck();
        this.aoH.setVisibility(0);
        this.aoI.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aoK.setText(arrayList.get(0));
            this.aoK.setChecked(false);
            this.aoK.setCompoundDrawables(this.aoZ, null, null, null);
            this.aoK.setVisibility(0);
            this.aoH.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aoL.setText(arrayList.get(1));
            this.aoL.setChecked(false);
            this.aoL.setCompoundDrawables(this.aoZ, null, null, null);
            this.aoL.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aoM.setText(arrayList.get(2));
            this.aoM.setChecked(false);
            this.aoM.setCompoundDrawables(this.aoZ, null, null, null);
            this.aoM.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aoO != null) {
            this.aoO.cancel();
            this.aoO = null;
        }
        if (this.aoP != null) {
            this.aoP.cancel();
            this.aoP = null;
        }
        AL();
    }

    public void AK() {
        this.aoH.setVisibility(8);
        this.aoH.clearCheck();
        this.aoI.setVisibility(8);
        this.aoI.clearCheck();
        this.aoK.setVisibility(8);
        this.aoL.setVisibility(8);
        this.aoM.setVisibility(8);
        this.aoK.setChecked(false);
        this.aoL.setChecked(false);
        this.aoM.setChecked(false);
    }

    public void AL() {
        if (this.aoF != null && this.aoF.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.aoF, this.Gd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(String str) {
        if (str == null) {
            this.aoQ.setVisibility(4);
            this.aoQ.setText((CharSequence) null);
            return;
        }
        this.aoQ.setVisibility(0);
        this.aoQ.setText(str);
    }

    public void lO() {
        this.Gd.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gd.getLayoutMode().x(this.aoE);
        this.aoG.setHintTextColor(av.getColor(t.d.cp_cont_e));
        this.aoK.setCompoundDrawables(this.aoZ, null, null, null);
        this.aoL.setCompoundDrawables(this.aoZ, null, null, null);
        this.aoM.setCompoundDrawables(this.aoZ, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private com.baidu.tbadk.core.util.ab aiS = null;
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
            j.this.aoO = null;
            j.this.aoS.setVisibility(8);
            j.this.aoR.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.aoO = null;
            j.this.aoS.setVisibility(8);
            j.this.aoR.setEnabled(true);
            if (fVar == null) {
                j.this.eO(this.aiS.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.AL();
                TbadkCoreApplication.setCurrentAccount(j.this.aoV, j.this.Gd.getPageActivity());
                if (j.this.aoW != null) {
                    j.this.aoW.j(j.this.aoV);
                }
            } else {
                j.this.n(fVar.xF());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.aoS.setVisibility(0);
            j.this.aoR.setEnabled(false);
            j.this.eO(null);
            j.this.AK();
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
            String ue;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.aiS = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.aiS.n("un", this.mAccount);
                this.aiS.n("BDUSS", j.this.aoV.getBDUSS());
                this.aiS.uD().vz().acp = false;
                ue = this.aiS.ue();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.aiS.uG()) {
                str = this.aiS.uH();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(ue);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.aoV != null) {
                            j.this.aoV.setAccount(userName);
                            j.this.aoV.setBDUSS(bduss);
                            j.this.aoV.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.aoV;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.aiS.uH() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(ue);
                    str = fVar2;
                } else if (this.aiS.uH() == 1) {
                    j.this.AL();
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
        private com.baidu.tbadk.core.util.ab aiS;
        final /* synthetic */ j apa;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.apa.aoP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.aiS = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.aiS.n("un", this.mAccount);
            String ue = this.aiS.ue();
            if (!this.aiS.uG() || this.aiS.uH() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(ue);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.apa.aoP = null;
            if (!this.aiS.uG()) {
                this.apa.eO(this.aiS.getErrorString());
            } else if (this.aiS.uH() == 0) {
                this.apa.eO(this.apa.Gd.getString(t.j.name_not_use));
            } else if (this.aiS.uH() == 36) {
                this.apa.eO(this.aiS.getErrorString());
                if (fVar != null) {
                    this.apa.n(fVar.xF());
                }
            } else {
                this.apa.eO(this.aiS.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.apa.eO(null);
            this.apa.AK();
            super.onPreExecute();
        }
    }
}
