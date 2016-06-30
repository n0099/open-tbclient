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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {
    private TbPageContext<?> Dp;
    private View akI = null;
    private Dialog akJ = null;
    private EditText akK = null;
    private RadioGroup akL = null;
    private RadioGroup akM = null;
    private CompoundButton.OnCheckedChangeListener akN = null;
    private RadioButton akO = null;
    private RadioButton akP = null;
    private RadioButton akQ = null;
    private TextView akR = null;
    private c akS = null;
    private b akT = null;
    private TextView akU = null;
    private TextView akV = null;
    private ProgressBar akW = null;
    private TextView akX = null;
    private String akY = null;
    private AccountData akZ = null;
    private a ala = null;
    private a alb = null;
    private Drawable alc;
    private Drawable ald;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public j(TbPageContext<?> tbPageContext) {
        this.Dp = null;
        this.alc = null;
        this.ald = null;
        this.size = 0;
        this.Dp = tbPageContext;
        this.alc = av.getDrawable(u.f.icon_tips_names_s);
        this.ald = av.getDrawable(u.f.icon_tips_names_n);
        this.size = this.Dp.getResources().getDimensionPixelSize(u.e.ds26);
        this.alc.setBounds(0, 0, this.size, this.size);
        this.ald.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.akZ = accountData;
    }

    public void a(a aVar) {
        this.ala = aVar;
    }

    public void b(a aVar) {
        this.alb = aVar;
    }

    public void zs() {
        if (this.akJ == null) {
            this.akI = LayoutInflater.from(this.Dp.getPageActivity()).inflate(u.h.main_input_username, (ViewGroup) null);
            this.akK = (EditText) this.akI.findViewById(u.g.account);
            this.akK.setHint(this.Dp.getString(u.j.input_alias_limit_length_tip));
            this.akR = (TextView) this.akI.findViewById(u.g.back);
            this.akR.setOnClickListener(new k(this));
            this.akV = (TextView) this.akI.findViewById(u.g.confirm);
            this.akV.setOnClickListener(new l(this));
            this.akW = (ProgressBar) this.akI.findViewById(u.g.confirm_progress);
            this.akU = (TextView) this.akI.findViewById(u.g.error_info);
            this.akL = (RadioGroup) this.akI.findViewById(u.g.names_group1);
            this.akM = (RadioGroup) this.akI.findViewById(u.g.names_group2);
            this.akO = (RadioButton) this.akI.findViewById(u.g.name1);
            this.akP = (RadioButton) this.akI.findViewById(u.g.name2);
            this.akQ = (RadioButton) this.akI.findViewById(u.g.name3);
            this.akN = new m(this);
            this.akO.setOnCheckedChangeListener(this.akN);
            this.akP.setOnCheckedChangeListener(this.akN);
            this.akQ.setOnCheckedChangeListener(this.akN);
            this.akX = (TextView) this.akI.findViewById(u.g.phone_info);
            zv();
            this.akJ = new Dialog(this.Dp.getPageActivity(), u.k.input_username_dialog);
            this.akJ.setCanceledOnTouchOutside(false);
            this.akJ.setCancelable(false);
            this.akJ.setCanceledOnTouchOutside(false);
            kX();
        }
        if (!this.akJ.isShowing()) {
            this.akK.setText((CharSequence) null);
            zv();
            eN(null);
            if (this.akY == null || this.akY.length() <= 0) {
                this.akX.setText("Hi," + this.Dp.getString(u.j.bar_friend));
            } else {
                this.akX.setText("Hi," + this.akY);
            }
            if (!this.Dp.getPageActivity().isFinishing()) {
                this.akJ.setContentView(this.akI);
                com.baidu.adp.lib.h.j.a(this.akJ, this.Dp);
                if (this.Dp.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.Dp.getOrignalPage()).ShowSoftKeyPadDelay(this.akK, 150);
                }
            }
        }
    }

    public void zt() {
        String editable = this.akK.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eN(this.Dp.getString(u.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eN(this.Dp.getString(u.j.input_alias_limit_length_tip));
        } else {
            if (this.akT != null) {
                this.akT.cancel();
            }
            if (this.akS == null) {
                this.akS = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.akS.setPriority(3);
                this.akS.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zu() {
        if (this.alb != null) {
            this.alb.i(null);
        }
    }

    public void m(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eN(this.Dp.getString(u.j.suggest_no_name));
            return;
        }
        eN(this.Dp.getString(u.j.suggest_some_names));
        int size = arrayList.size();
        this.akL.clearCheck();
        this.akM.clearCheck();
        this.akL.setVisibility(0);
        this.akM.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.akO.setText(arrayList.get(0));
            this.akO.setChecked(false);
            this.akO.setCompoundDrawables(this.ald, null, null, null);
            this.akO.setVisibility(0);
            this.akL.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.akP.setText(arrayList.get(1));
            this.akP.setChecked(false);
            this.akP.setCompoundDrawables(this.ald, null, null, null);
            this.akP.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.akQ.setText(arrayList.get(2));
            this.akQ.setChecked(false);
            this.akQ.setCompoundDrawables(this.ald, null, null, null);
            this.akQ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.akS != null) {
            this.akS.cancel();
            this.akS = null;
        }
        if (this.akT != null) {
            this.akT.cancel();
            this.akT = null;
        }
        zw();
    }

    public void zv() {
        this.akL.setVisibility(8);
        this.akL.clearCheck();
        this.akM.setVisibility(8);
        this.akM.clearCheck();
        this.akO.setVisibility(8);
        this.akP.setVisibility(8);
        this.akQ.setVisibility(8);
        this.akO.setChecked(false);
        this.akP.setChecked(false);
        this.akQ.setChecked(false);
    }

    public void zw() {
        if (this.akJ != null && this.akJ.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.akJ, this.Dp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(String str) {
        if (str == null) {
            this.akU.setVisibility(4);
            this.akU.setText((CharSequence) null);
            return;
        }
        this.akU.setVisibility(0);
        this.akU.setText(str);
    }

    public void kX() {
        this.Dp.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Dp.getLayoutMode().w(this.akI);
        this.akK.setHintTextColor(av.getColor(u.d.cp_cont_e));
        this.akO.setCompoundDrawables(this.ald, null, null, null);
        this.akP.setCompoundDrawables(this.ald, null, null, null);
        this.akQ.setCompoundDrawables(this.ald, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.c> {
        private com.baidu.tbadk.core.util.ab afj = null;
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
            j.this.akS = null;
            j.this.akW.setVisibility(8);
            j.this.akV.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.c cVar) {
            super.onPostExecute(cVar);
            j.this.akS = null;
            j.this.akW.setVisibility(8);
            j.this.akV.setEnabled(true);
            if (cVar == null) {
                j.this.eN(this.afj.getErrorString());
            } else if (cVar.getUser().getUserName() != null) {
                j.this.zw();
                TbadkCoreApplication.setCurrentAccount(j.this.akZ, j.this.Dp.getPageActivity());
                if (j.this.ala != null) {
                    j.this.ala.i(j.this.akZ);
                }
            } else {
                j.this.m(cVar.wv());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            j.this.akW.setVisibility(0);
            j.this.akV.setEnabled(false);
            j.this.eN(null);
            j.this.zv();
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
        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tbadk.coreExtra.data.c] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v31 */
        /* JADX WARN: Type inference failed for: r1v15, types: [com.baidu.tbadk.core.data.AccountData] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.c doInBackground(String... strArr) {
            String str;
            Exception e;
            String ta;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.afj = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.afj.n("un", this.mAccount);
                this.afj.n("BDUSS", j.this.akZ.getBDUSS());
                this.afj.ty().uu().YR = false;
                ta = this.afj.ta();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.afj.tB()) {
                str = this.afj.tC();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
                    cVar.parserJson(ta);
                    String userName = cVar.getUser().getUserName();
                    String bduss = cVar.getUser().getBDUSS();
                    str = cVar;
                    str = cVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = cVar;
                        str2 = userName;
                        if (j.this.akZ != null) {
                            j.this.akZ.setAccount(userName);
                            j.this.akZ.setBDUSS(bduss);
                            j.this.akZ.setPortrait(cVar.getUser().getPortrait());
                            ?? r1 = j.this.akZ;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = cVar;
                            str2 = r1;
                        }
                    }
                } else if (this.afj.tC() == 36) {
                    com.baidu.tbadk.coreExtra.data.c cVar2 = new com.baidu.tbadk.coreExtra.data.c();
                    cVar2.parserJson(ta);
                    str = cVar2;
                } else if (this.afj.tC() == 1) {
                    j.this.zw();
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
    private class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.c> {
        private com.baidu.tbadk.core.util.ab afj;
        final /* synthetic */ j ale;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.ale.akT = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tbadk.coreExtra.data.c doInBackground(String... strArr) {
            this.afj = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.afj.n("un", this.mAccount);
            String ta = this.afj.ta();
            if (!this.afj.tB() || this.afj.tC() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
            cVar.parserJson(ta);
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.c cVar) {
            super.onPostExecute(cVar);
            this.ale.akT = null;
            if (!this.afj.tB()) {
                this.ale.eN(this.afj.getErrorString());
            } else if (this.afj.tC() == 0) {
                this.ale.eN(this.ale.Dp.getString(u.j.name_not_use));
            } else if (this.afj.tC() == 36) {
                this.ale.eN(this.afj.getErrorString());
                if (cVar != null) {
                    this.ale.m(cVar.wv());
                }
            } else {
                this.ale.eN(this.afj.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ale.eN(null);
            this.ale.zv();
            super.onPreExecute();
        }
    }
}
