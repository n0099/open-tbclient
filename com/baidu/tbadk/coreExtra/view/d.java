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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private TbPageContext<?> aQq;
    private Drawable bkx;
    private Drawable bky;
    private int size;
    private View bke = null;
    private Dialog bkf = null;
    private EditText bkg = null;
    private RadioGroup bkh = null;
    private RadioGroup bki = null;
    private CompoundButton.OnCheckedChangeListener bkj = null;
    private RadioButton bkk = null;
    private RadioButton bkl = null;
    private RadioButton bkm = null;
    private TextView bkn = null;
    private c bko = null;
    private b bkp = null;
    private TextView bkq = null;
    private TextView bkr = null;
    private ProgressBar bks = null;
    private TextView bkt = null;
    private String mPhoneNum = null;
    private AccountData bku = null;
    private a bkv = null;
    private a bkw = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aQq = null;
        this.bkx = null;
        this.bky = null;
        this.size = 0;
        this.aQq = tbPageContext;
        this.bkx = aj.getDrawable(d.f.icon_tips_names_s);
        this.bky = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.aQq.getResources().getDimensionPixelSize(d.e.ds26);
        this.bkx.setBounds(0, 0, this.size, this.size);
        this.bky.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.bku = accountData;
    }

    public void a(a aVar) {
        this.bkv = aVar;
    }

    public void IE() {
        if (this.bkf == null) {
            this.bke = LayoutInflater.from(this.aQq.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.bkg = (EditText) this.bke.findViewById(d.g.account);
            this.bkg.setHint(this.aQq.getString(d.j.input_alias_limit_length_tip));
            this.bkn = (TextView) this.bke.findViewById(d.g.back);
            this.bkn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.II();
                    d.this.IG();
                }
            });
            this.bkr = (TextView) this.bke.findViewById(d.g.confirm);
            this.bkr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.IF();
                }
            });
            this.bks = (ProgressBar) this.bke.findViewById(d.g.confirm_progress);
            this.bkq = (TextView) this.bke.findViewById(d.g.error_info);
            this.bkh = (RadioGroup) this.bke.findViewById(d.g.names_group1);
            this.bki = (RadioGroup) this.bke.findViewById(d.g.names_group2);
            this.bkk = (RadioButton) this.bke.findViewById(d.g.name1);
            this.bkl = (RadioButton) this.bke.findViewById(d.g.name2);
            this.bkm = (RadioButton) this.bke.findViewById(d.g.name3);
            this.bkj = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.bkk) {
                            d.this.bki.clearCheck();
                            d.this.bkk.setChecked(true);
                            d.this.bkk.setCompoundDrawables(d.this.bkx, null, null, null);
                            d.this.bkl.setChecked(false);
                            d.this.bkl.setCompoundDrawables(d.this.bky, null, null, null);
                            d.this.bkm.setChecked(false);
                            d.this.bkm.setCompoundDrawables(d.this.bky, null, null, null);
                        } else if (compoundButton == d.this.bkl) {
                            d.this.bki.clearCheck();
                            d.this.bkk.setChecked(false);
                            d.this.bkk.setCompoundDrawables(d.this.bky, null, null, null);
                            d.this.bkl.setChecked(true);
                            d.this.bkl.setCompoundDrawables(d.this.bkx, null, null, null);
                            d.this.bkm.setChecked(false);
                            d.this.bkm.setCompoundDrawables(d.this.bky, null, null, null);
                        } else if (compoundButton == d.this.bkm) {
                            d.this.bkh.clearCheck();
                            d.this.bkk.setChecked(false);
                            d.this.bkk.setCompoundDrawables(d.this.bky, null, null, null);
                            d.this.bkl.setChecked(false);
                            d.this.bkl.setCompoundDrawables(d.this.bky, null, null, null);
                            d.this.bkm.setChecked(true);
                            d.this.bkm.setCompoundDrawables(d.this.bkx, null, null, null);
                        }
                        d.this.bkg.setText(compoundButton.getText());
                    }
                }
            };
            this.bkk.setOnCheckedChangeListener(this.bkj);
            this.bkl.setOnCheckedChangeListener(this.bkj);
            this.bkm.setOnCheckedChangeListener(this.bkj);
            this.bkt = (TextView) this.bke.findViewById(d.g.phone_info);
            IH();
            this.bkf = new Dialog(this.aQq.getPageActivity(), d.k.input_username_dialog);
            this.bkf.setCanceledOnTouchOutside(false);
            this.bkf.setCancelable(false);
            this.bkf.setCanceledOnTouchOutside(false);
            IA();
        }
        if (!this.bkf.isShowing()) {
            this.bkg.setText((CharSequence) null);
            IH();
            ft(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.bkt.setText("Hi," + this.aQq.getString(d.j.bar_friend));
            } else {
                this.bkt.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aQq.getPageActivity().isFinishing()) {
                this.bkf.setContentView(this.bke);
                g.a(this.bkf, this.aQq);
                if (this.aQq.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aQq.getOrignalPage()).ShowSoftKeyPadDelay(this.bkg, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void IF() {
        String obj = this.bkg.getText().toString();
        if (obj == null || obj.length() <= 0) {
            ft(this.aQq.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            ft(this.aQq.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.bkp != null) {
                this.bkp.cancel();
            }
            if (this.bko == null) {
                this.bko = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.bko.setPriority(3);
                this.bko.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IG() {
        if (this.bkw != null) {
            this.bkw.i(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            ft(this.aQq.getString(d.j.suggest_no_name));
            return;
        }
        ft(this.aQq.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.bkh.clearCheck();
        this.bki.clearCheck();
        this.bkh.setVisibility(0);
        this.bki.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.bkk.setText(arrayList.get(0));
            this.bkk.setChecked(false);
            this.bkk.setCompoundDrawables(this.bky, null, null, null);
            this.bkk.setVisibility(0);
            this.bkh.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.bkl.setText(arrayList.get(1));
            this.bkl.setChecked(false);
            this.bkl.setCompoundDrawables(this.bky, null, null, null);
            this.bkl.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.bkm.setText(arrayList.get(2));
            this.bkm.setChecked(false);
            this.bkm.setCompoundDrawables(this.bky, null, null, null);
            this.bkm.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.bko != null) {
            this.bko.cancel();
            this.bko = null;
        }
        if (this.bkp != null) {
            this.bkp.cancel();
            this.bkp = null;
        }
        II();
    }

    public void IH() {
        this.bkh.setVisibility(8);
        this.bkh.clearCheck();
        this.bki.setVisibility(8);
        this.bki.clearCheck();
        this.bkk.setVisibility(8);
        this.bkl.setVisibility(8);
        this.bkm.setVisibility(8);
        this.bkk.setChecked(false);
        this.bkl.setChecked(false);
        this.bkm.setChecked(false);
    }

    public void II() {
        if (this.bkf != null && this.bkf.isShowing()) {
            g.b(this.bkf, this.aQq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ft(String str) {
        if (str == null) {
            this.bkq.setVisibility(4);
            this.bkq.setText((CharSequence) null);
            return;
        }
        this.bkq.setVisibility(0);
        this.bkq.setText(str);
    }

    public void IA() {
        this.aQq.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aQq.getLayoutMode().aM(this.bke);
        this.bkg.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        this.bkk.setCompoundDrawables(this.bky, null, null, null);
        this.bkl.setCompoundDrawables(this.bky, null, null, null);
        this.bkm.setCompoundDrawables(this.bky, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, h> {
        private String mAccount;
        private x mNetwork = null;
        private String mUrl;

        public c(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            d.this.bko = null;
            d.this.bks.setVisibility(8);
            d.this.bkr.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            d.this.bko = null;
            d.this.bks.setVisibility(8);
            d.this.bkr.setEnabled(true);
            if (hVar == null) {
                d.this.ft(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                d.this.II();
                TbadkCoreApplication.setCurrentAccount(d.this.bku, d.this.aQq.getPageActivity());
                if (d.this.bkv != null) {
                    d.this.bkv.i(d.this.bku);
                }
            } else {
                d.this.o(hVar.Ft());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bks.setVisibility(0);
            d.this.bkr.setEnabled(false);
            d.this.ft(null);
            d.this.IH();
            super.onPreExecute();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00ad */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0047 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.tbadk.coreExtra.data.h */
        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tbadk.coreExtra.data.h */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tbadk.coreExtra.data.h */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [com.baidu.tbadk.coreExtra.data.h] */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v28 */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            h hVar;
            Exception e;
            try {
                this.mNetwork = new x(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", d.this.bku.getBDUSS());
                this.mNetwork.Cn().Dk().aWz = false;
                String BP = this.mNetwork.BP();
                if (this.mNetwork.Cq()) {
                    hVar = this.mNetwork.Cr();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(BP);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (d.this.bku != null) {
                                    d.this.bku.setAccount(userName);
                                    d.this.bku.setBDUSS(bduss);
                                    d.this.bku.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.bku);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.Cr() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(BP);
                            hVar = hVar3;
                        } else if (this.mNetwork.Cr() == 1) {
                            d.this.II();
                        }
                        return hVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return hVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                hVar = 0;
                e = e3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, h> {
        final /* synthetic */ d bkz;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.bkz.bkp = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String BP = this.mNetwork.BP();
            if (!this.mNetwork.Cq() || this.mNetwork.Cr() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(BP);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.bkz.bkp = null;
            if (!this.mNetwork.Cq()) {
                this.bkz.ft(this.mNetwork.getErrorString());
            } else if (this.mNetwork.Cr() == 0) {
                this.bkz.ft(this.bkz.aQq.getString(d.j.name_not_use));
            } else if (this.mNetwork.Cr() == 36) {
                this.bkz.ft(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.bkz.o(hVar.Ft());
                }
            } else {
                this.bkz.ft(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bkz.ft(null);
            this.bkz.IH();
            super.onPreExecute();
        }
    }
}
