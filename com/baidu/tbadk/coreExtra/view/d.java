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
    private TbPageContext<?> aQp;
    private Drawable bkH;
    private Drawable bkI;
    private int size;
    private View bko = null;
    private Dialog bkp = null;
    private EditText bkq = null;
    private RadioGroup bkr = null;
    private RadioGroup bks = null;
    private CompoundButton.OnCheckedChangeListener bkt = null;
    private RadioButton bku = null;
    private RadioButton bkv = null;
    private RadioButton bkw = null;
    private TextView bkx = null;
    private c bky = null;
    private b bkz = null;
    private TextView bkA = null;
    private TextView bkB = null;
    private ProgressBar bkC = null;
    private TextView bkD = null;
    private String mPhoneNum = null;
    private AccountData bkE = null;
    private a bkF = null;
    private a bkG = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aQp = null;
        this.bkH = null;
        this.bkI = null;
        this.size = 0;
        this.aQp = tbPageContext;
        this.bkH = aj.getDrawable(d.f.icon_tips_names_s);
        this.bkI = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.aQp.getResources().getDimensionPixelSize(d.e.ds26);
        this.bkH.setBounds(0, 0, this.size, this.size);
        this.bkI.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.bkE = accountData;
    }

    public void a(a aVar) {
        this.bkF = aVar;
    }

    public void Ix() {
        if (this.bkp == null) {
            this.bko = LayoutInflater.from(this.aQp.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.bkq = (EditText) this.bko.findViewById(d.g.account);
            this.bkq.setHint(this.aQp.getString(d.j.input_alias_limit_length_tip));
            this.bkx = (TextView) this.bko.findViewById(d.g.back);
            this.bkx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.IB();
                    d.this.Iz();
                }
            });
            this.bkB = (TextView) this.bko.findViewById(d.g.confirm);
            this.bkB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Iy();
                }
            });
            this.bkC = (ProgressBar) this.bko.findViewById(d.g.confirm_progress);
            this.bkA = (TextView) this.bko.findViewById(d.g.error_info);
            this.bkr = (RadioGroup) this.bko.findViewById(d.g.names_group1);
            this.bks = (RadioGroup) this.bko.findViewById(d.g.names_group2);
            this.bku = (RadioButton) this.bko.findViewById(d.g.name1);
            this.bkv = (RadioButton) this.bko.findViewById(d.g.name2);
            this.bkw = (RadioButton) this.bko.findViewById(d.g.name3);
            this.bkt = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.bku) {
                            d.this.bks.clearCheck();
                            d.this.bku.setChecked(true);
                            d.this.bku.setCompoundDrawables(d.this.bkH, null, null, null);
                            d.this.bkv.setChecked(false);
                            d.this.bkv.setCompoundDrawables(d.this.bkI, null, null, null);
                            d.this.bkw.setChecked(false);
                            d.this.bkw.setCompoundDrawables(d.this.bkI, null, null, null);
                        } else if (compoundButton == d.this.bkv) {
                            d.this.bks.clearCheck();
                            d.this.bku.setChecked(false);
                            d.this.bku.setCompoundDrawables(d.this.bkI, null, null, null);
                            d.this.bkv.setChecked(true);
                            d.this.bkv.setCompoundDrawables(d.this.bkH, null, null, null);
                            d.this.bkw.setChecked(false);
                            d.this.bkw.setCompoundDrawables(d.this.bkI, null, null, null);
                        } else if (compoundButton == d.this.bkw) {
                            d.this.bkr.clearCheck();
                            d.this.bku.setChecked(false);
                            d.this.bku.setCompoundDrawables(d.this.bkI, null, null, null);
                            d.this.bkv.setChecked(false);
                            d.this.bkv.setCompoundDrawables(d.this.bkI, null, null, null);
                            d.this.bkw.setChecked(true);
                            d.this.bkw.setCompoundDrawables(d.this.bkH, null, null, null);
                        }
                        d.this.bkq.setText(compoundButton.getText());
                    }
                }
            };
            this.bku.setOnCheckedChangeListener(this.bkt);
            this.bkv.setOnCheckedChangeListener(this.bkt);
            this.bkw.setOnCheckedChangeListener(this.bkt);
            this.bkD = (TextView) this.bko.findViewById(d.g.phone_info);
            IA();
            this.bkp = new Dialog(this.aQp.getPageActivity(), d.k.input_username_dialog);
            this.bkp.setCanceledOnTouchOutside(false);
            this.bkp.setCancelable(false);
            this.bkp.setCanceledOnTouchOutside(false);
            It();
        }
        if (!this.bkp.isShowing()) {
            this.bkq.setText((CharSequence) null);
            IA();
            ft(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.bkD.setText("Hi," + this.aQp.getString(d.j.bar_friend));
            } else {
                this.bkD.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aQp.getPageActivity().isFinishing()) {
                this.bkp.setContentView(this.bko);
                g.a(this.bkp, this.aQp);
                if (this.aQp.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aQp.getOrignalPage()).ShowSoftKeyPadDelay(this.bkq, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Iy() {
        String obj = this.bkq.getText().toString();
        if (obj == null || obj.length() <= 0) {
            ft(this.aQp.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            ft(this.aQp.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.bkz != null) {
                this.bkz.cancel();
            }
            if (this.bky == null) {
                this.bky = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.bky.setPriority(3);
                this.bky.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iz() {
        if (this.bkG != null) {
            this.bkG.i(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            ft(this.aQp.getString(d.j.suggest_no_name));
            return;
        }
        ft(this.aQp.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.bkr.clearCheck();
        this.bks.clearCheck();
        this.bkr.setVisibility(0);
        this.bks.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.bku.setText(arrayList.get(0));
            this.bku.setChecked(false);
            this.bku.setCompoundDrawables(this.bkI, null, null, null);
            this.bku.setVisibility(0);
            this.bkr.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.bkv.setText(arrayList.get(1));
            this.bkv.setChecked(false);
            this.bkv.setCompoundDrawables(this.bkI, null, null, null);
            this.bkv.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.bkw.setText(arrayList.get(2));
            this.bkw.setChecked(false);
            this.bkw.setCompoundDrawables(this.bkI, null, null, null);
            this.bkw.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.bky != null) {
            this.bky.cancel();
            this.bky = null;
        }
        if (this.bkz != null) {
            this.bkz.cancel();
            this.bkz = null;
        }
        IB();
    }

    public void IA() {
        this.bkr.setVisibility(8);
        this.bkr.clearCheck();
        this.bks.setVisibility(8);
        this.bks.clearCheck();
        this.bku.setVisibility(8);
        this.bkv.setVisibility(8);
        this.bkw.setVisibility(8);
        this.bku.setChecked(false);
        this.bkv.setChecked(false);
        this.bkw.setChecked(false);
    }

    public void IB() {
        if (this.bkp != null && this.bkp.isShowing()) {
            g.b(this.bkp, this.aQp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ft(String str) {
        if (str == null) {
            this.bkA.setVisibility(4);
            this.bkA.setText((CharSequence) null);
            return;
        }
        this.bkA.setVisibility(0);
        this.bkA.setText(str);
    }

    public void It() {
        this.aQp.getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aQp.getLayoutMode().aM(this.bko);
        this.bkq.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
        this.bku.setCompoundDrawables(this.bkI, null, null, null);
        this.bkv.setCompoundDrawables(this.bkI, null, null, null);
        this.bkw.setCompoundDrawables(this.bkI, null, null, null);
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
            d.this.bky = null;
            d.this.bkC.setVisibility(8);
            d.this.bkB.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            d.this.bky = null;
            d.this.bkC.setVisibility(8);
            d.this.bkB.setEnabled(true);
            if (hVar == null) {
                d.this.ft(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                d.this.IB();
                TbadkCoreApplication.setCurrentAccount(d.this.bkE, d.this.aQp.getPageActivity());
                if (d.this.bkF != null) {
                    d.this.bkF.i(d.this.bkE);
                }
            } else {
                d.this.o(hVar.Fk());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bkC.setVisibility(0);
            d.this.bkB.setEnabled(false);
            d.this.ft(null);
            d.this.IA();
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
                this.mNetwork.n("BDUSS", d.this.bkE.getBDUSS());
                this.mNetwork.Cf().Db().aWy = false;
                String BH = this.mNetwork.BH();
                if (this.mNetwork.Ci()) {
                    hVar = this.mNetwork.Cj();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(BH);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (d.this.bkE != null) {
                                    d.this.bkE.setAccount(userName);
                                    d.this.bkE.setBDUSS(bduss);
                                    d.this.bkE.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.bkE);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.Cj() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(BH);
                            hVar = hVar3;
                        } else if (this.mNetwork.Cj() == 1) {
                            d.this.IB();
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
        final /* synthetic */ d bkJ;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.bkJ.bkz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String BH = this.mNetwork.BH();
            if (!this.mNetwork.Ci() || this.mNetwork.Cj() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(BH);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.bkJ.bkz = null;
            if (!this.mNetwork.Ci()) {
                this.bkJ.ft(this.mNetwork.getErrorString());
            } else if (this.mNetwork.Cj() == 0) {
                this.bkJ.ft(this.bkJ.aQp.getString(d.j.name_not_use));
            } else if (this.mNetwork.Cj() == 36) {
                this.bkJ.ft(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.bkJ.o(hVar.Fk());
                }
            } else {
                this.bkJ.ft(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bkJ.ft(null);
            this.bkJ.IA();
            super.onPreExecute();
        }
    }
}
