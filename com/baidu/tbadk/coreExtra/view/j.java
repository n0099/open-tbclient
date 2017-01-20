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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> Fp;
    private View anO = null;
    private Dialog anP = null;
    private EditText anQ = null;
    private RadioGroup anR = null;
    private RadioGroup anS = null;
    private CompoundButton.OnCheckedChangeListener anT = null;
    private RadioButton anU = null;
    private RadioButton anV = null;
    private RadioButton anW = null;
    private TextView anX = null;
    private c anY = null;
    private b anZ = null;
    private TextView aoa = null;
    private TextView aob = null;
    private ProgressBar aoc = null;
    private TextView aod = null;
    private String aoe = null;
    private AccountData aof = null;
    private a aog = null;
    private a aoh = null;
    private Drawable aoi;
    private Drawable aoj;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.Fp = null;
        this.aoi = null;
        this.aoj = null;
        this.size = 0;
        this.Fp = tbPageContext;
        this.aoi = ap.getDrawable(r.g.icon_tips_names_s);
        this.aoj = ap.getDrawable(r.g.icon_tips_names_n);
        this.size = this.Fp.getResources().getDimensionPixelSize(r.f.ds26);
        this.aoi.setBounds(0, 0, this.size, this.size);
        this.aoj.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.aof = accountData;
    }

    public void a(a aVar) {
        this.aog = aVar;
    }

    public void b(a aVar) {
        this.aoh = aVar;
    }

    public void Az() {
        if (this.anP == null) {
            this.anO = LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.main_input_username, (ViewGroup) null);
            this.anQ = (EditText) this.anO.findViewById(r.h.account);
            this.anQ.setHint(this.Fp.getString(r.l.input_alias_limit_length_tip));
            this.anX = (TextView) this.anO.findViewById(r.h.back);
            this.anX.setOnClickListener(new k(this));
            this.aob = (TextView) this.anO.findViewById(r.h.confirm);
            this.aob.setOnClickListener(new l(this));
            this.aoc = (ProgressBar) this.anO.findViewById(r.h.confirm_progress);
            this.aoa = (TextView) this.anO.findViewById(r.h.error_info);
            this.anR = (RadioGroup) this.anO.findViewById(r.h.names_group1);
            this.anS = (RadioGroup) this.anO.findViewById(r.h.names_group2);
            this.anU = (RadioButton) this.anO.findViewById(r.h.name1);
            this.anV = (RadioButton) this.anO.findViewById(r.h.name2);
            this.anW = (RadioButton) this.anO.findViewById(r.h.name3);
            this.anT = new m(this);
            this.anU.setOnCheckedChangeListener(this.anT);
            this.anV.setOnCheckedChangeListener(this.anT);
            this.anW.setOnCheckedChangeListener(this.anT);
            this.aod = (TextView) this.anO.findViewById(r.h.phone_info);
            AC();
            this.anP = new Dialog(this.Fp.getPageActivity(), r.m.input_username_dialog);
            this.anP.setCanceledOnTouchOutside(false);
            this.anP.setCancelable(false);
            this.anP.setCanceledOnTouchOutside(false);
            lJ();
        }
        if (!this.anP.isShowing()) {
            this.anQ.setText((CharSequence) null);
            AC();
            eM(null);
            if (this.aoe == null || this.aoe.length() <= 0) {
                this.aod.setText("Hi," + this.Fp.getString(r.l.bar_friend));
            } else {
                this.aod.setText("Hi," + this.aoe);
            }
            if (!this.Fp.getPageActivity().isFinishing()) {
                this.anP.setContentView(this.anO);
                com.baidu.adp.lib.g.j.a(this.anP, this.Fp);
                if (this.Fp.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.Fp.getOrignalPage()).ShowSoftKeyPadDelay(this.anQ, 150);
                }
            }
        }
    }

    public void AA() {
        String editable = this.anQ.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eM(this.Fp.getString(r.l.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eM(this.Fp.getString(r.l.input_alias_limit_length_tip));
        } else {
            if (this.anZ != null) {
                this.anZ.cancel();
            }
            if (this.anY == null) {
                this.anY = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.anY.setPriority(3);
                this.anY.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB() {
        if (this.aoh != null) {
            this.aoh.j(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eM(this.Fp.getString(r.l.suggest_no_name));
            return;
        }
        eM(this.Fp.getString(r.l.suggest_some_names));
        int size = arrayList.size();
        this.anR.clearCheck();
        this.anS.clearCheck();
        this.anR.setVisibility(0);
        this.anS.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.anU.setText(arrayList.get(0));
            this.anU.setChecked(false);
            this.anU.setCompoundDrawables(this.aoj, null, null, null);
            this.anU.setVisibility(0);
            this.anR.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.anV.setText(arrayList.get(1));
            this.anV.setChecked(false);
            this.anV.setCompoundDrawables(this.aoj, null, null, null);
            this.anV.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.anW.setText(arrayList.get(2));
            this.anW.setChecked(false);
            this.anW.setCompoundDrawables(this.aoj, null, null, null);
            this.anW.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.anY != null) {
            this.anY.cancel();
            this.anY = null;
        }
        if (this.anZ != null) {
            this.anZ.cancel();
            this.anZ = null;
        }
        AD();
    }

    public void AC() {
        this.anR.setVisibility(8);
        this.anR.clearCheck();
        this.anS.setVisibility(8);
        this.anS.clearCheck();
        this.anU.setVisibility(8);
        this.anV.setVisibility(8);
        this.anW.setVisibility(8);
        this.anU.setChecked(false);
        this.anV.setChecked(false);
        this.anW.setChecked(false);
    }

    public void AD() {
        if (this.anP != null && this.anP.isShowing()) {
            com.baidu.adp.lib.g.j.b(this.anP, this.Fp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(String str) {
        if (str == null) {
            this.aoa.setVisibility(4);
            this.aoa.setText((CharSequence) null);
            return;
        }
        this.aoa.setVisibility(0);
        this.aoa.setText(str);
    }

    public void lJ() {
        this.Fp.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Fp.getLayoutMode().v(this.anO);
        this.anQ.setHintTextColor(ap.getColor(r.e.cp_cont_e));
        this.anU.setCompoundDrawables(this.aoj, null, null, null);
        this.anV.setCompoundDrawables(this.aoj, null, null, null);
        this.anW.setCompoundDrawables(this.aoj, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private String mAccount;
        private com.baidu.tbadk.core.util.y mNetwork = null;
        private String mUrl;

        public c(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            j.this.anY = null;
            j.this.aoc.setVisibility(8);
            j.this.aob.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            j.this.anY = null;
            j.this.aoc.setVisibility(8);
            j.this.aob.setEnabled(true);
            if (fVar == null) {
                j.this.eM(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                j.this.AD();
                TbadkCoreApplication.setCurrentAccount(j.this.aof, j.this.Fp.getPageActivity());
                if (j.this.aog != null) {
                    j.this.aog.j(j.this.aof);
                }
            } else {
                j.this.o(fVar.xy());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.aoc.setVisibility(0);
            j.this.aob.setEnabled(false);
            j.this.eM(null);
            j.this.AC();
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
            String ud;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.y(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", j.this.aof.getBDUSS());
                this.mNetwork.uC().vv().abD = false;
                ud = this.mNetwork.ud();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.mNetwork.uF()) {
                str = this.mNetwork.uG();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(ud);
                    String userName = fVar.getUser().getUserName();
                    String bduss = fVar.getUser().getBDUSS();
                    str = fVar;
                    str = fVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = fVar;
                        str2 = userName;
                        if (j.this.aof != null) {
                            j.this.aof.setAccount(userName);
                            j.this.aof.setBDUSS(bduss);
                            j.this.aof.setPortrait(fVar.getUser().getPortrait());
                            ?? r1 = j.this.aof;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = fVar;
                            str2 = r1;
                        }
                    }
                } else if (this.mNetwork.uG() == 36) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(ud);
                    str = fVar2;
                } else if (this.mNetwork.uG() == 1) {
                    j.this.AD();
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
        final /* synthetic */ j aok;
        private String mAccount;
        private com.baidu.tbadk.core.util.y mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aok.anZ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.y(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String ud = this.mNetwork.ud();
            if (!this.mNetwork.uF() || this.mNetwork.uG() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(ud);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.aok.anZ = null;
            if (!this.mNetwork.uF()) {
                this.aok.eM(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uG() == 0) {
                this.aok.eM(this.aok.Fp.getString(r.l.name_not_use));
            } else if (this.mNetwork.uG() == 36) {
                this.aok.eM(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.aok.o(fVar.xy());
                }
            } else {
                this.aok.eM(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aok.eM(null);
            this.aok.AC();
            super.onPreExecute();
        }
    }
}
