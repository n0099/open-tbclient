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
    private View ane = null;
    private Dialog anf = null;
    private EditText ang = null;
    private RadioGroup anh = null;
    private RadioGroup ani = null;
    private CompoundButton.OnCheckedChangeListener anj = null;
    private RadioButton ank = null;
    private RadioButton anl = null;
    private RadioButton anm = null;
    private TextView ann = null;
    private c ano = null;
    private b anp = null;
    private TextView anq = null;
    private TextView anr = null;
    private ProgressBar ans = null;
    private TextView ant = null;
    private String anu = null;
    private AccountData anv = null;
    private a anw = null;
    private a anx = null;
    private Drawable any;
    private Drawable anz;
    private TbPageContext<?> mContext;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public k(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.any = null;
        this.anz = null;
        this.size = 0;
        this.mContext = tbPageContext;
        this.any = as.getDrawable(n.f.icon_tips_names_s);
        this.anz = as.getDrawable(n.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(n.e.ds26);
        this.any.setBounds(0, 0, this.size, this.size);
        this.anz.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.anv = accountData;
    }

    public void a(a aVar) {
        this.anw = aVar;
    }

    public void b(a aVar) {
        this.anx = aVar;
    }

    public void zx() {
        if (this.anf == null) {
            this.ane = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.main_input_username, (ViewGroup) null);
            this.ang = (EditText) this.ane.findViewById(n.g.account);
            this.ang.setHint(this.mContext.getString(n.j.input_alias_limit_length_tip));
            this.ann = (TextView) this.ane.findViewById(n.g.back);
            this.ann.setOnClickListener(new l(this));
            this.anr = (TextView) this.ane.findViewById(n.g.confirm);
            this.anr.setOnClickListener(new m(this));
            this.ans = (ProgressBar) this.ane.findViewById(n.g.confirm_progress);
            this.anq = (TextView) this.ane.findViewById(n.g.error_info);
            this.anh = (RadioGroup) this.ane.findViewById(n.g.names_group1);
            this.ani = (RadioGroup) this.ane.findViewById(n.g.names_group2);
            this.ank = (RadioButton) this.ane.findViewById(n.g.name1);
            this.anl = (RadioButton) this.ane.findViewById(n.g.name2);
            this.anm = (RadioButton) this.ane.findViewById(n.g.name3);
            this.anj = new n(this);
            this.ank.setOnCheckedChangeListener(this.anj);
            this.anl.setOnCheckedChangeListener(this.anj);
            this.anm.setOnCheckedChangeListener(this.anj);
            this.ant = (TextView) this.ane.findViewById(n.g.phone_info);
            zA();
            this.anf = new Dialog(this.mContext.getPageActivity(), n.k.input_username_dialog);
            this.anf.setCanceledOnTouchOutside(false);
            this.anf.setCancelable(false);
            this.anf.setCanceledOnTouchOutside(false);
            ot();
        }
        if (!this.anf.isShowing()) {
            this.ang.setText((CharSequence) null);
            zA();
            eG(null);
            if (this.anu == null || this.anu.length() <= 0) {
                this.ant.setText("Hi," + this.mContext.getString(n.j.bar_friend));
            } else {
                this.ant.setText("Hi," + this.anu);
            }
            if (!this.mContext.getPageActivity().isFinishing()) {
                this.anf.setContentView(this.ane);
                com.baidu.adp.lib.h.j.a(this.anf, this.mContext);
                if (this.mContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.mContext.getOrignalPage()).ShowSoftKeyPadDelay(this.ang, 150);
                }
            }
        }
    }

    public void zy() {
        String editable = this.ang.getText().toString();
        if (editable == null || editable.length() <= 0) {
            eG(this.mContext.getString(n.j.input_name));
        } else if (UtilHelper.getFixedTextSize(editable) > 14) {
            eG(this.mContext.getString(n.j.input_alias_limit_length_tip));
        } else {
            if (this.anp != null) {
                this.anp.cancel();
            }
            if (this.ano == null) {
                this.ano = new c(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                this.ano.setPriority(3);
                this.ano.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz() {
        if (this.anx != null) {
            this.anx.i(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eG(this.mContext.getString(n.j.suggest_no_name));
            return;
        }
        eG(this.mContext.getString(n.j.suggest_some_names));
        int size = arrayList.size();
        this.anh.clearCheck();
        this.ani.clearCheck();
        this.anh.setVisibility(0);
        this.ani.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.ank.setText(arrayList.get(0));
            this.ank.setChecked(false);
            this.ank.setCompoundDrawables(this.anz, null, null, null);
            this.ank.setVisibility(0);
            this.anh.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.anl.setText(arrayList.get(1));
            this.anl.setChecked(false);
            this.anl.setCompoundDrawables(this.anz, null, null, null);
            this.anl.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.anm.setText(arrayList.get(2));
            this.anm.setChecked(false);
            this.anm.setCompoundDrawables(this.anz, null, null, null);
            this.anm.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.ano != null) {
            this.ano.cancel();
            this.ano = null;
        }
        if (this.anp != null) {
            this.anp.cancel();
            this.anp = null;
        }
        zB();
    }

    public void zA() {
        this.anh.setVisibility(8);
        this.anh.clearCheck();
        this.ani.setVisibility(8);
        this.ani.clearCheck();
        this.ank.setVisibility(8);
        this.anl.setVisibility(8);
        this.anm.setVisibility(8);
        this.ank.setChecked(false);
        this.anl.setChecked(false);
        this.anm.setChecked(false);
    }

    public void zB() {
        if (this.anf != null && this.anf.isShowing()) {
            com.baidu.adp.lib.h.j.b(this.anf, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eG(String str) {
        if (str == null) {
            this.anq.setVisibility(4);
            this.anq.setText((CharSequence) null);
            return;
        }
        this.anq.setVisibility(0);
        this.anq.setText(str);
    }

    public void ot() {
        this.mContext.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().k(this.ane);
        this.ang.setHintTextColor(as.getColor(n.d.cp_cont_e));
        this.ank.setCompoundDrawables(this.anz, null, null, null);
        this.anl.setCompoundDrawables(this.anz, null, null, null);
        this.anm.setCompoundDrawables(this.anz, null, null, null);
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.b> {
        private com.baidu.tbadk.core.util.ab ahV = null;
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
            k.this.ano = null;
            k.this.ans.setVisibility(8);
            k.this.anr.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            k.this.ano = null;
            k.this.ans.setVisibility(8);
            k.this.anr.setEnabled(true);
            if (bVar == null) {
                k.this.eG(this.ahV.getErrorString());
            } else if (bVar.getUser().getUserName() != null) {
                k.this.zB();
                TbadkCoreApplication.setCurrentAccount(k.this.anv, k.this.mContext.getPageActivity());
                if (k.this.anw != null) {
                    k.this.anw.i(k.this.anv);
                }
            } else {
                k.this.o(bVar.wJ());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            k.this.ans.setVisibility(0);
            k.this.anr.setEnabled(false);
            k.this.eG(null);
            k.this.zA();
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
            String tV;
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            try {
                this.ahV = new com.baidu.tbadk.core.util.ab(this.mUrl);
                this.ahV.o("un", this.mAccount);
                this.ahV.o("BDUSS", k.this.anv.getBDUSS());
                this.ahV.uw().vp().adq = false;
                tV = this.ahV.tV();
            } catch (Exception e2) {
                str = str2;
                e = e2;
            }
            if (this.ahV.uz()) {
                str = this.ahV.uA();
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (str == 0) {
                    com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
                    bVar.parserJson(tV);
                    String userName = bVar.getUser().getUserName();
                    String bduss = bVar.getUser().getBDUSS();
                    str = bVar;
                    str = bVar;
                    str2 = userName;
                    str2 = userName;
                    if (userName != null && bduss != null) {
                        str = bVar;
                        str2 = userName;
                        if (k.this.anv != null) {
                            k.this.anv.setAccount(userName);
                            k.this.anv.setBDUSS(bduss);
                            k.this.anv.setPortrait(bVar.getUser().getPortrait());
                            ?? r1 = k.this.anv;
                            com.baidu.tbadk.core.a.b.b(r1);
                            str = bVar;
                            str2 = r1;
                        }
                    }
                } else if (this.ahV.uA() == 36) {
                    com.baidu.tbadk.coreExtra.data.b bVar2 = new com.baidu.tbadk.coreExtra.data.b();
                    bVar2.parserJson(tV);
                    str = bVar2;
                } else if (this.ahV.uA() == 1) {
                    k.this.zB();
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
        private com.baidu.tbadk.core.util.ab ahV;
        final /* synthetic */ k anA;
        private String mAccount;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.anA.anp = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public com.baidu.tbadk.coreExtra.data.b doInBackground(String... strArr) {
            this.ahV = new com.baidu.tbadk.core.util.ab(this.mUrl);
            this.ahV.o("un", this.mAccount);
            String tV = this.ahV.tV();
            if (!this.ahV.uz() || this.ahV.uA() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.b bVar = new com.baidu.tbadk.coreExtra.data.b();
            bVar.parserJson(tV);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.b bVar) {
            super.onPostExecute(bVar);
            this.anA.anp = null;
            if (!this.ahV.uz()) {
                this.anA.eG(this.ahV.getErrorString());
            } else if (this.ahV.uA() == 0) {
                this.anA.eG(this.anA.mContext.getString(n.j.name_not_use));
            } else if (this.ahV.uA() == 36) {
                this.anA.eG(this.ahV.getErrorString());
                if (bVar != null) {
                    this.anA.o(bVar.wJ());
                }
            } else {
                this.anA.eG(this.ahV.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.anA.eG(null);
            this.anA.zA();
            super.onPreExecute();
        }
    }
}
