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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    private View alX = null;
    private Dialog alY = null;
    private EditText alZ = null;
    private RadioGroup ama = null;
    private RadioGroup amb = null;
    private CompoundButton.OnCheckedChangeListener amc = null;
    private RadioButton amd = null;
    private RadioButton ame = null;
    private RadioButton amf = null;
    private TextView amg = null;
    private c amh = null;
    private b ami = null;
    private TextView amj = null;
    private TextView amk = null;
    private ProgressBar aml = null;
    private TextView amm = null;
    private String amn = null;
    private AccountData amo = null;
    private a amp = null;
    private a amq = null;
    private Drawable amr;
    private Drawable ams;
    private TbPageContext<?> mContext;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public k(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.amr = null;
        this.ams = null;
        this.size = 0;
        this.mContext = tbPageContext;
        this.amr = as.getDrawable(n.e.icon_tips_names_s);
        this.ams = as.getDrawable(n.e.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(n.d.ds26);
        this.amr.setBounds(0, 0, this.size, this.size);
        this.ams.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.amo = accountData;
    }

    public void a(a aVar) {
        this.amp = aVar;
    }

    public void b(a aVar) {
        this.amq = aVar;
    }

    public void zL() {
        if (this.alY == null) {
            this.alX = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.main_input_username, (ViewGroup) null);
            this.alZ = (EditText) this.alX.findViewById(n.f.account);
            this.alZ.setHint(this.mContext.getString(n.i.input_alias_limit_length_tip));
            this.amg = (TextView) this.alX.findViewById(n.f.back);
            this.amg.setOnClickListener(new l(this));
            this.amk = (TextView) this.alX.findViewById(n.f.confirm);
            this.amk.setOnClickListener(new m(this));
            this.aml = (ProgressBar) this.alX.findViewById(n.f.confirm_progress);
            this.amj = (TextView) this.alX.findViewById(n.f.error_info);
            this.ama = (RadioGroup) this.alX.findViewById(n.f.names_group1);
            this.amb = (RadioGroup) this.alX.findViewById(n.f.names_group2);
            this.amd = (RadioButton) this.alX.findViewById(n.f.name1);
            this.ame = (RadioButton) this.alX.findViewById(n.f.name2);
            this.amf = (RadioButton) this.alX.findViewById(n.f.name3);
            this.amc = new n(this);
            this.amd.setOnCheckedChangeListener(this.amc);
            this.ame.setOnCheckedChangeListener(this.amc);
            this.amf.setOnCheckedChangeListener(this.amc);
            this.amm = (TextView) this.alX.findViewById(n.f.phone_info);
            zO();
            this.alY = new Dialog(this.mContext.getPageActivity(), n.j.input_username_dialog);
            this.alY.setCanceledOnTouchOutside(false);
            this.alY.setCancelable(false);
            this.alY.setCanceledOnTouchOutside(false);
            oV();
        }
        if (!this.alY.isShowing()) {
            this.alZ.setText((CharSequence) null);
            zO();
            eD(null);
            if (this.amn == null || this.amn.length() <= 0) {
                this.amm.setText("Hi," + this.mContext.getString(n.i.bar_friend));
            } else {
                this.amm.setText("Hi," + this.amn);
            }
            if (!this.mContext.getPageActivity().isFinishing()) {
                this.alY.setContentView(this.alX);
                com.baidu.adp.lib.h.j.a(this.alY, this.mContext);
                if (this.mContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.mContext.getOrignalPage()).ShowSoftKeyPadDelay(this.alZ, 150);
                }
            }
        }
    }

    public void zM() {
        String editable = this.alZ.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eD(this.mContext.getString(n.i.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eD(this.mContext.getString(n.i.input_alias_limit_length_tip));
        } else {
            if (this.ami != null) {
                this.ami.cancel();
            }
            if (this.amh == null) {
                this.amh = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.amh.setPriority(3);
                this.amh.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN() {
        if (this.amq != null) {
            this.amq.i(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eD(this.mContext.getString(n.i.suggest_no_name));
            return;
        }
        eD(this.mContext.getString(n.i.suggest_some_names));
        int size = arrayList.size();
        this.ama.clearCheck();
        this.amb.clearCheck();
        this.ama.setVisibility(0);
        this.amb.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.amd.setText(arrayList.get(0));
            this.amd.setChecked(false);
            this.amd.setCompoundDrawables(this.ams, null, null, null);
            this.amd.setVisibility(0);
            this.ama.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.ame.setText(arrayList.get(1));
            this.ame.setChecked(false);
            this.ame.setCompoundDrawables(this.ams, null, null, null);
            this.ame.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.amf.setText(arrayList.get(2));
            this.amf.setChecked(false);
            this.amf.setCompoundDrawables(this.ams, null, null, null);
            this.amf.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.amh != null) {
            this.amh.cancel();
            this.amh = null;
        }
        if (this.ami != null) {
            this.ami.cancel();
            this.ami = null;
        }
        zP();
    }

    public void zO() {
        this.ama.setVisibility(8);
        this.ama.clearCheck();
        this.amb.setVisibility(8);
        this.amb.clearCheck();
        this.amd.setVisibility(8);
        this.ame.setVisibility(8);
        this.amf.setVisibility(8);
        this.amd.setChecked(false);
        this.ame.setChecked(false);
        this.amf.setChecked(false);
    }

    public void zP() {
        if (this.alY != null && this.alY.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.alY, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(String str) {
        if (str == null) {
            this.amj.setVisibility(4);
            this.amj.setText((CharSequence) null);
            return;
        }
        this.amj.setVisibility(0);
        this.amj.setText(str);
    }

    public void oV() {
        this.mContext.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(this.alX);
        this.alZ.setHintTextColor(as.getColor(n.c.cp_cont_e));
        this.amd.setCompoundDrawables(this.ams, null, null, null);
        this.ame.setCompoundDrawables(this.ams, null, null, null);
        this.amf.setCompoundDrawables(this.ams, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.b> {
        private com.baidu.tbadk.core.util.ab agS = null;
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
            k.this.amh = null;
            k.this.aml.setVisibility(8);
            k.this.amk.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            k.this.amh = null;
            k.this.aml.setVisibility(8);
            k.this.amk.setEnabled(true);
            if (bVar == null) {
                k.this.eD(this.agS.getErrorString());
            } else if (bVar.getUser().getUserName() != null) {
                k.this.zP();
                TbadkCoreApplication.setCurrentAccount(k.this.amo, k.this.mContext.getPageActivity());
                if (k.this.amp != null) {
                    k.this.amp.i(k.this.amo);
                }
            } else {
                k.this.o(bVar.xa());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.aml.setVisibility(0);
            k.this.amk.setEnabled(false);
            k.this.eD(null);
            k.this.zO();
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
        /* renamed from: j */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            String str;
            Exception e;
            String ul;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.agS = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.agS.o("un", this.mAccount);
                this.agS.o("BDUSS", k.this.amo.getBDUSS());
                this.agS.uM().vF().acL = false;
                ul = this.agS.ul();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.agS.uP()) {
                str = this.agS.uQ();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
                    bVar.parserJson(ul);
                    String userName = bVar.getUser().getUserName();
                    String bduss = bVar.getUser().getBDUSS();
                    str = bVar;
                    str = bVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = bVar;
                        str2 = userName;
                        if (k.this.amo != null) {
                            k.this.amo.setAccount(userName);
                            k.this.amo.setBDUSS(bduss);
                            k.this.amo.setPortrait(bVar.getUser().getPortrait());
                            ?? r1 = k.this.amo;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = bVar;
                            str2 = r1;
                        }
                    }
                } else if (this.agS.uQ() == 36) {
                    com.baidu.tbadk.coreExtra.data.b bVar2 = new com.baidu.tbadk.coreExtra.data.b();
                    bVar2.parserJson(ul);
                    str = bVar2;
                } else if (this.agS.uQ() == 1) {
                    k.this.zP();
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
        private com.baidu.tbadk.core.util.ab agS;
        final /* synthetic */ k amt;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.amt.ami = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            this.agS = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.agS.o("un", this.mAccount);
            String ul = this.agS.ul();
            if (!this.agS.uP() || this.agS.uQ() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
            bVar.parserJson(ul);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            this.amt.ami = null;
            if (!this.agS.uP()) {
                this.amt.eD(this.agS.getErrorString());
            } else if (this.agS.uQ() == 0) {
                this.amt.eD(this.amt.mContext.getString(n.i.name_not_use));
            } else if (this.agS.uQ() == 36) {
                this.amt.eD(this.agS.getErrorString());
                if (bVar != null) {
                    this.amt.o(bVar.xa());
                }
            } else {
                this.amt.eD(this.agS.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.amt.eD(null);
            this.amt.zO();
            super.onPreExecute();
        }
    }
}
