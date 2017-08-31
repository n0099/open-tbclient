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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private TbPageContext<?> aby;
    private Drawable awi;
    private Drawable awj;
    private int size;
    private View avP = null;
    private Dialog avQ = null;
    private EditText avR = null;
    private RadioGroup avS = null;
    private RadioGroup avT = null;
    private CompoundButton.OnCheckedChangeListener avU = null;
    private RadioButton avV = null;
    private RadioButton avW = null;
    private RadioButton avX = null;
    private TextView avY = null;
    private c avZ = null;
    private b awa = null;
    private TextView awb = null;
    private TextView awc = null;
    private ProgressBar awd = null;
    private TextView awe = null;
    private String mPhoneNum = null;
    private AccountData awf = null;
    private a awg = null;
    private a awh = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aby = null;
        this.awi = null;
        this.awj = null;
        this.size = 0;
        this.aby = tbPageContext;
        this.awi = aj.getDrawable(d.g.icon_tips_names_s);
        this.awj = aj.getDrawable(d.g.icon_tips_names_n);
        this.size = this.aby.getResources().getDimensionPixelSize(d.f.ds26);
        this.awi.setBounds(0, 0, this.size, this.size);
        this.awj.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.awf = accountData;
    }

    public void a(a aVar) {
        this.awg = aVar;
    }

    public void b(a aVar) {
        this.awh = aVar;
    }

    public void Be() {
        if (this.avQ == null) {
            this.avP = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.main_input_username, (ViewGroup) null);
            this.avR = (EditText) this.avP.findViewById(d.h.account);
            this.avR.setHint(this.aby.getString(d.l.input_alias_limit_length_tip));
            this.avY = (TextView) this.avP.findViewById(d.h.back);
            this.avY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bi();
                    d.this.Bg();
                }
            });
            this.awc = (TextView) this.avP.findViewById(d.h.confirm);
            this.awc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bf();
                }
            });
            this.awd = (ProgressBar) this.avP.findViewById(d.h.confirm_progress);
            this.awb = (TextView) this.avP.findViewById(d.h.error_info);
            this.avS = (RadioGroup) this.avP.findViewById(d.h.names_group1);
            this.avT = (RadioGroup) this.avP.findViewById(d.h.names_group2);
            this.avV = (RadioButton) this.avP.findViewById(d.h.name1);
            this.avW = (RadioButton) this.avP.findViewById(d.h.name2);
            this.avX = (RadioButton) this.avP.findViewById(d.h.name3);
            this.avU = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.avV) {
                            d.this.avT.clearCheck();
                            d.this.avV.setChecked(true);
                            d.this.avV.setCompoundDrawables(d.this.awi, null, null, null);
                            d.this.avW.setChecked(false);
                            d.this.avW.setCompoundDrawables(d.this.awj, null, null, null);
                            d.this.avX.setChecked(false);
                            d.this.avX.setCompoundDrawables(d.this.awj, null, null, null);
                        } else if (compoundButton == d.this.avW) {
                            d.this.avT.clearCheck();
                            d.this.avV.setChecked(false);
                            d.this.avV.setCompoundDrawables(d.this.awj, null, null, null);
                            d.this.avW.setChecked(true);
                            d.this.avW.setCompoundDrawables(d.this.awi, null, null, null);
                            d.this.avX.setChecked(false);
                            d.this.avX.setCompoundDrawables(d.this.awj, null, null, null);
                        } else if (compoundButton == d.this.avX) {
                            d.this.avS.clearCheck();
                            d.this.avV.setChecked(false);
                            d.this.avV.setCompoundDrawables(d.this.awj, null, null, null);
                            d.this.avW.setChecked(false);
                            d.this.avW.setCompoundDrawables(d.this.awj, null, null, null);
                            d.this.avX.setChecked(true);
                            d.this.avX.setCompoundDrawables(d.this.awi, null, null, null);
                        }
                        d.this.avR.setText(compoundButton.getText());
                    }
                }
            };
            this.avV.setOnCheckedChangeListener(this.avU);
            this.avW.setOnCheckedChangeListener(this.avU);
            this.avX.setOnCheckedChangeListener(this.avU);
            this.awe = (TextView) this.avP.findViewById(d.h.phone_info);
            Bh();
            this.avQ = new Dialog(this.aby.getPageActivity(), d.m.input_username_dialog);
            this.avQ.setCanceledOnTouchOutside(false);
            this.avQ.setCancelable(false);
            this.avQ.setCanceledOnTouchOutside(false);
            Ba();
        }
        if (!this.avQ.isShowing()) {
            this.avR.setText((CharSequence) null);
            Bh();
            fh(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.awe.setText("Hi," + this.aby.getString(d.l.bar_friend));
            } else {
                this.awe.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aby.getPageActivity().isFinishing()) {
                this.avQ.setContentView(this.avP);
                g.a(this.avQ, this.aby);
                if (this.aby.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aby.getOrignalPage()).ShowSoftKeyPadDelay(this.avR, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bf() {
        String obj = this.avR.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fh(this.aby.getString(d.l.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fh(this.aby.getString(d.l.input_alias_limit_length_tip));
        } else {
            if (this.awa != null) {
                this.awa.cancel();
            }
            if (this.avZ == null) {
                this.avZ = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.avZ.setPriority(3);
                this.avZ.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg() {
        if (this.awh != null) {
            this.awh.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fh(this.aby.getString(d.l.suggest_no_name));
            return;
        }
        fh(this.aby.getString(d.l.suggest_some_names));
        int size = arrayList.size();
        this.avS.clearCheck();
        this.avT.clearCheck();
        this.avS.setVisibility(0);
        this.avT.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.avV.setText(arrayList.get(0));
            this.avV.setChecked(false);
            this.avV.setCompoundDrawables(this.awj, null, null, null);
            this.avV.setVisibility(0);
            this.avS.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.avW.setText(arrayList.get(1));
            this.avW.setChecked(false);
            this.avW.setCompoundDrawables(this.awj, null, null, null);
            this.avW.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.avX.setText(arrayList.get(2));
            this.avX.setChecked(false);
            this.avX.setCompoundDrawables(this.awj, null, null, null);
            this.avX.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.avZ != null) {
            this.avZ.cancel();
            this.avZ = null;
        }
        if (this.awa != null) {
            this.awa.cancel();
            this.awa = null;
        }
        Bi();
    }

    public void Bh() {
        this.avS.setVisibility(8);
        this.avS.clearCheck();
        this.avT.setVisibility(8);
        this.avT.clearCheck();
        this.avV.setVisibility(8);
        this.avW.setVisibility(8);
        this.avX.setVisibility(8);
        this.avV.setChecked(false);
        this.avW.setChecked(false);
        this.avX.setChecked(false);
    }

    public void Bi() {
        if (this.avQ != null && this.avQ.isShowing()) {
            g.b(this.avQ, this.aby);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(String str) {
        if (str == null) {
            this.awb.setVisibility(4);
            this.awb.setText((CharSequence) null);
            return;
        }
        this.awb.setVisibility(0);
        this.awb.setText(str);
    }

    public void Ba() {
        this.aby.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aby.getLayoutMode().t(this.avP);
        this.avR.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.avV.setCompoundDrawables(this.awj, null, null, null);
        this.avW.setCompoundDrawables(this.awj, null, null, null);
        this.avX.setCompoundDrawables(this.awj, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
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
            d.this.avZ = null;
            d.this.awd.setVisibility(8);
            d.this.awc.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.avZ = null;
            d.this.awd.setVisibility(8);
            d.this.awc.setEnabled(true);
            if (fVar == null) {
                d.this.fh(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.Bi();
                TbadkCoreApplication.setCurrentAccount(d.this.awf, d.this.aby.getPageActivity());
                if (d.this.awg != null) {
                    d.this.awg.j(d.this.awf);
                }
            } else {
                d.this.n(fVar.yl());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.awd.setVisibility(0);
            d.this.awc.setEnabled(false);
            d.this.fh(null);
            d.this.Bh();
            super.onPreExecute();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00ad */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0047 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.tbadk.coreExtra.data.f */
        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tbadk.coreExtra.data.f */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tbadk.coreExtra.data.f */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [com.baidu.tbadk.coreExtra.data.f] */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v28 */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.data.f fVar;
            Exception e;
            try {
                this.mNetwork = new x(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", d.this.awf.getBDUSS());
                this.mNetwork.vj().wf().aik = false;
                String uM = this.mNetwork.uM();
                if (this.mNetwork.vm()) {
                    fVar = this.mNetwork.vn();
                    try {
                        if (fVar == 0) {
                            com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar2.parserJson(uM);
                            String userName = fVar2.getUser().getUserName();
                            String bduss = fVar2.getUser().getBDUSS();
                            fVar = fVar2;
                            fVar = fVar2;
                            if (userName != null && bduss != null) {
                                fVar = fVar2;
                                if (d.this.awf != null) {
                                    d.this.awf.setAccount(userName);
                                    d.this.awf.setBDUSS(bduss);
                                    d.this.awf.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.awf);
                                    fVar = fVar2;
                                }
                            }
                        } else if (this.mNetwork.vn() == 36) {
                            com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar3.parserJson(uM);
                            fVar = fVar3;
                        } else if (this.mNetwork.vn() == 1) {
                            d.this.Bi();
                        }
                        return fVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return fVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                fVar = 0;
                e = e3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        final /* synthetic */ d awk;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.awk.awa = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uM = this.mNetwork.uM();
            if (!this.mNetwork.vm() || this.mNetwork.vn() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uM);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.awk.awa = null;
            if (!this.mNetwork.vm()) {
                this.awk.fh(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vn() == 0) {
                this.awk.fh(this.awk.aby.getString(d.l.name_not_use));
            } else if (this.mNetwork.vn() == 36) {
                this.awk.fh(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.awk.n(fVar.yl());
                }
            } else {
                this.awk.fh(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.awk.fh(null);
            this.awk.Bh();
            super.onPreExecute();
        }
    }
}
