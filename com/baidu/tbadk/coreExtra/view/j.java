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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> MR;
    private View anX = null;
    private Dialog anY = null;
    private EditText anZ = null;
    private RadioGroup aoa = null;
    private RadioGroup aob = null;
    private CompoundButton.OnCheckedChangeListener aoc = null;
    private RadioButton aod = null;
    private RadioButton aoe = null;
    private RadioButton aof = null;
    private TextView aog = null;
    private c aoh = null;
    private b aoi = null;
    private TextView aoj = null;
    private TextView aok = null;
    private ProgressBar aol = null;
    private TextView aom = null;
    private String aon = null;
    private AccountData aoo = null;
    private a aop = null;
    private a aoq = null;
    private Drawable aor;
    private Drawable aos;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.MR = null;
        this.aor = null;
        this.aos = null;
        this.size = 0;
        this.MR = tbPageContext;
        this.aor = ar.getDrawable(t.f.icon_tips_names_s);
        this.aos = ar.getDrawable(t.f.icon_tips_names_n);
        this.size = this.MR.getResources().getDimensionPixelSize(t.e.ds26);
        this.aor.setBounds(0, 0, this.size, this.size);
        this.aos.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.aoo = accountData;
    }

    public void a(a aVar) {
        this.aop = aVar;
    }

    public void b(a aVar) {
        this.aoq = aVar;
    }

    public void AP() {
        if (this.anY == null) {
            this.anX = LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.main_input_username, (ViewGroup) null);
            this.anZ = (EditText) this.anX.findViewById(t.g.account);
            this.anZ.setHint(this.MR.getString(t.j.input_alias_limit_length_tip));
            this.aog = (TextView) this.anX.findViewById(t.g.back);
            this.aog.setOnClickListener(new k(this));
            this.aok = (TextView) this.anX.findViewById(t.g.confirm);
            this.aok.setOnClickListener(new l(this));
            this.aol = (ProgressBar) this.anX.findViewById(t.g.confirm_progress);
            this.aoj = (TextView) this.anX.findViewById(t.g.error_info);
            this.aoa = (RadioGroup) this.anX.findViewById(t.g.names_group1);
            this.aob = (RadioGroup) this.anX.findViewById(t.g.names_group2);
            this.aod = (RadioButton) this.anX.findViewById(t.g.name1);
            this.aoe = (RadioButton) this.anX.findViewById(t.g.name2);
            this.aof = (RadioButton) this.anX.findViewById(t.g.name3);
            this.aoc = new m(this);
            this.aod.setOnCheckedChangeListener(this.aoc);
            this.aoe.setOnCheckedChangeListener(this.aoc);
            this.aof.setOnCheckedChangeListener(this.aoc);
            this.aom = (TextView) this.anX.findViewById(t.g.phone_info);
            AS();
            this.anY = new Dialog(this.MR.getPageActivity(), t.k.input_username_dialog);
            this.anY.setCanceledOnTouchOutside(false);
            this.anY.setCancelable(false);
            this.anY.setCanceledOnTouchOutside(false);
            oO();
        }
        if (!this.anY.isShowing()) {
            this.anZ.setText((CharSequence) null);
            AS();
            eF(null);
            if (this.aon == null || this.aon.length() <= 0) {
                this.aom.setText("Hi," + this.MR.getString(t.j.bar_friend));
            } else {
                this.aom.setText("Hi," + this.aon);
            }
            if (!this.MR.getPageActivity().isFinishing()) {
                this.anY.setContentView(this.anX);
                com.baidu.adp.lib.h.j.a(this.anY, this.MR);
                if (this.MR.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.MR.getOrignalPage()).ShowSoftKeyPadDelay(this.anZ, 150);
                }
            }
        }
    }

    public void AQ() {
        String editable = this.anZ.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eF(this.MR.getString(t.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eF(this.MR.getString(t.j.input_alias_limit_length_tip));
        } else {
            if (this.aoi != null) {
                this.aoi.cancel();
            }
            if (this.aoh == null) {
                this.aoh = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.aoh.setPriority(3);
                this.aoh.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR() {
        if (this.aoq != null) {
            this.aoq.i(null);
        }
    }

    public void p(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eF(this.MR.getString(t.j.suggest_no_name));
            return;
        }
        eF(this.MR.getString(t.j.suggest_some_names));
        int size = arrayList.size();
        this.aoa.clearCheck();
        this.aob.clearCheck();
        this.aoa.setVisibility(0);
        this.aob.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aod.setText(arrayList.get(0));
            this.aod.setChecked(false);
            this.aod.setCompoundDrawables(this.aos, null, null, null);
            this.aod.setVisibility(0);
            this.aoa.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aoe.setText(arrayList.get(1));
            this.aoe.setChecked(false);
            this.aoe.setCompoundDrawables(this.aos, null, null, null);
            this.aoe.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aof.setText(arrayList.get(2));
            this.aof.setChecked(false);
            this.aof.setCompoundDrawables(this.aos, null, null, null);
            this.aof.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aoh != null) {
            this.aoh.cancel();
            this.aoh = null;
        }
        if (this.aoi != null) {
            this.aoi.cancel();
            this.aoi = null;
        }
        AT();
    }

    public void AS() {
        this.aoa.setVisibility(8);
        this.aoa.clearCheck();
        this.aob.setVisibility(8);
        this.aob.clearCheck();
        this.aod.setVisibility(8);
        this.aoe.setVisibility(8);
        this.aof.setVisibility(8);
        this.aod.setChecked(false);
        this.aoe.setChecked(false);
        this.aof.setChecked(false);
    }

    public void AT() {
        if (this.anY != null && this.anY.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.anY, this.MR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(String str) {
        if (str == null) {
            this.aoj.setVisibility(4);
            this.aoj.setText((CharSequence) null);
            return;
        }
        this.aoj.setVisibility(0);
        this.aoj.setText(str);
    }

    public void oO() {
        this.MR.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.MR.getLayoutMode().x(this.anX);
        this.anZ.setHintTextColor(ar.getColor(t.d.cp_cont_e));
        this.aod.setCompoundDrawables(this.aos, null, null, null);
        this.aoe.setCompoundDrawables(this.aos, null, null, null);
        this.aof.setCompoundDrawables(this.aos, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.b> {
        private com.baidu.tbadk.core.util.aa aiG = null;
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
            j.this.aoh = null;
            j.this.aol.setVisibility(8);
            j.this.aok.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            j.this.aoh = null;
            j.this.aol.setVisibility(8);
            j.this.aok.setEnabled(true);
            if (bVar == null) {
                j.this.eF(this.aiG.getErrorString());
            } else if (bVar.getUser().getUserName() != null) {
                j.this.AT();
                TbadkCoreApplication.setCurrentAccount(j.this.aoo, j.this.MR.getPageActivity());
                if (j.this.aop != null) {
                    j.this.aop.i(j.this.aoo);
                }
            } else {
                j.this.p(bVar.xX());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.aol.setVisibility(0);
            j.this.aok.setEnabled(false);
            j.this.eF(null);
            j.this.AS();
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
        /* renamed from: n */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            String str;
            Exception e;
            String uZ;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.aiG = new com.baidu.tbadk.core.util.aa(this.mUrl);
                this.aiG.p("un", this.mAccount);
                this.aiG.p("BDUSS", j.this.aoo.getBDUSS());
                this.aiG.vB().wv().adM = false;
                uZ = this.aiG.uZ();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.aiG.vE()) {
                str = this.aiG.vF();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
                    bVar.parserJson(uZ);
                    String userName = bVar.getUser().getUserName();
                    String bduss = bVar.getUser().getBDUSS();
                    str = bVar;
                    str = bVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = bVar;
                        str2 = userName;
                        if (j.this.aoo != null) {
                            j.this.aoo.setAccount(userName);
                            j.this.aoo.setBDUSS(bduss);
                            j.this.aoo.setPortrait(bVar.getUser().getPortrait());
                            ?? r1 = j.this.aoo;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = bVar;
                            str2 = r1;
                        }
                    }
                } else if (this.aiG.vF() == 36) {
                    com.baidu.tbadk.coreExtra.data.b bVar2 = new com.baidu.tbadk.coreExtra.data.b();
                    bVar2.parserJson(uZ);
                    str = bVar2;
                } else if (this.aiG.vF() == 1) {
                    j.this.AT();
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
        private com.baidu.tbadk.core.util.aa aiG;
        final /* synthetic */ j aot;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aot.aoi = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            this.aiG = new com.baidu.tbadk.core.util.aa(this.mUrl);
            this.aiG.p("un", this.mAccount);
            String uZ = this.aiG.uZ();
            if (!this.aiG.vE() || this.aiG.vF() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
            bVar.parserJson(uZ);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            this.aot.aoi = null;
            if (!this.aiG.vE()) {
                this.aot.eF(this.aiG.getErrorString());
            } else if (this.aiG.vF() == 0) {
                this.aot.eF(this.aot.MR.getString(t.j.name_not_use));
            } else if (this.aiG.vF() == 36) {
                this.aot.eF(this.aiG.getErrorString());
                if (bVar != null) {
                    this.aot.p(bVar.xX());
                }
            } else {
                this.aot.eF(this.aiG.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aot.eF(null);
            this.aot.AS();
            super.onPreExecute();
        }
    }
}
