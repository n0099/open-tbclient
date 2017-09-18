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
    private Drawable awf;
    private Drawable awg;
    private int size;
    private View avM = null;
    private Dialog avN = null;
    private EditText avO = null;
    private RadioGroup avP = null;
    private RadioGroup avQ = null;
    private CompoundButton.OnCheckedChangeListener avR = null;
    private RadioButton avS = null;
    private RadioButton avT = null;
    private RadioButton avU = null;
    private TextView avV = null;
    private c avW = null;
    private b avX = null;
    private TextView avY = null;
    private TextView avZ = null;
    private ProgressBar awa = null;
    private TextView awb = null;
    private String mPhoneNum = null;
    private AccountData awc = null;
    private a awd = null;
    private a awe = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aby = null;
        this.awf = null;
        this.awg = null;
        this.size = 0;
        this.aby = tbPageContext;
        this.awf = aj.getDrawable(d.g.icon_tips_names_s);
        this.awg = aj.getDrawable(d.g.icon_tips_names_n);
        this.size = this.aby.getResources().getDimensionPixelSize(d.f.ds26);
        this.awf.setBounds(0, 0, this.size, this.size);
        this.awg.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.awc = accountData;
    }

    public void a(a aVar) {
        this.awd = aVar;
    }

    public void b(a aVar) {
        this.awe = aVar;
    }

    public void Be() {
        if (this.avN == null) {
            this.avM = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.main_input_username, (ViewGroup) null);
            this.avO = (EditText) this.avM.findViewById(d.h.account);
            this.avO.setHint(this.aby.getString(d.l.input_alias_limit_length_tip));
            this.avV = (TextView) this.avM.findViewById(d.h.back);
            this.avV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bi();
                    d.this.Bg();
                }
            });
            this.avZ = (TextView) this.avM.findViewById(d.h.confirm);
            this.avZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bf();
                }
            });
            this.awa = (ProgressBar) this.avM.findViewById(d.h.confirm_progress);
            this.avY = (TextView) this.avM.findViewById(d.h.error_info);
            this.avP = (RadioGroup) this.avM.findViewById(d.h.names_group1);
            this.avQ = (RadioGroup) this.avM.findViewById(d.h.names_group2);
            this.avS = (RadioButton) this.avM.findViewById(d.h.name1);
            this.avT = (RadioButton) this.avM.findViewById(d.h.name2);
            this.avU = (RadioButton) this.avM.findViewById(d.h.name3);
            this.avR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.avS) {
                            d.this.avQ.clearCheck();
                            d.this.avS.setChecked(true);
                            d.this.avS.setCompoundDrawables(d.this.awf, null, null, null);
                            d.this.avT.setChecked(false);
                            d.this.avT.setCompoundDrawables(d.this.awg, null, null, null);
                            d.this.avU.setChecked(false);
                            d.this.avU.setCompoundDrawables(d.this.awg, null, null, null);
                        } else if (compoundButton == d.this.avT) {
                            d.this.avQ.clearCheck();
                            d.this.avS.setChecked(false);
                            d.this.avS.setCompoundDrawables(d.this.awg, null, null, null);
                            d.this.avT.setChecked(true);
                            d.this.avT.setCompoundDrawables(d.this.awf, null, null, null);
                            d.this.avU.setChecked(false);
                            d.this.avU.setCompoundDrawables(d.this.awg, null, null, null);
                        } else if (compoundButton == d.this.avU) {
                            d.this.avP.clearCheck();
                            d.this.avS.setChecked(false);
                            d.this.avS.setCompoundDrawables(d.this.awg, null, null, null);
                            d.this.avT.setChecked(false);
                            d.this.avT.setCompoundDrawables(d.this.awg, null, null, null);
                            d.this.avU.setChecked(true);
                            d.this.avU.setCompoundDrawables(d.this.awf, null, null, null);
                        }
                        d.this.avO.setText(compoundButton.getText());
                    }
                }
            };
            this.avS.setOnCheckedChangeListener(this.avR);
            this.avT.setOnCheckedChangeListener(this.avR);
            this.avU.setOnCheckedChangeListener(this.avR);
            this.awb = (TextView) this.avM.findViewById(d.h.phone_info);
            Bh();
            this.avN = new Dialog(this.aby.getPageActivity(), d.m.input_username_dialog);
            this.avN.setCanceledOnTouchOutside(false);
            this.avN.setCancelable(false);
            this.avN.setCanceledOnTouchOutside(false);
            Ba();
        }
        if (!this.avN.isShowing()) {
            this.avO.setText((CharSequence) null);
            Bh();
            fh(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.awb.setText("Hi," + this.aby.getString(d.l.bar_friend));
            } else {
                this.awb.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aby.getPageActivity().isFinishing()) {
                this.avN.setContentView(this.avM);
                g.a(this.avN, this.aby);
                if (this.aby.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aby.getOrignalPage()).ShowSoftKeyPadDelay(this.avO, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bf() {
        String obj = this.avO.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fh(this.aby.getString(d.l.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fh(this.aby.getString(d.l.input_alias_limit_length_tip));
        } else {
            if (this.avX != null) {
                this.avX.cancel();
            }
            if (this.avW == null) {
                this.avW = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.avW.setPriority(3);
                this.avW.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg() {
        if (this.awe != null) {
            this.awe.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fh(this.aby.getString(d.l.suggest_no_name));
            return;
        }
        fh(this.aby.getString(d.l.suggest_some_names));
        int size = arrayList.size();
        this.avP.clearCheck();
        this.avQ.clearCheck();
        this.avP.setVisibility(0);
        this.avQ.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.avS.setText(arrayList.get(0));
            this.avS.setChecked(false);
            this.avS.setCompoundDrawables(this.awg, null, null, null);
            this.avS.setVisibility(0);
            this.avP.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.avT.setText(arrayList.get(1));
            this.avT.setChecked(false);
            this.avT.setCompoundDrawables(this.awg, null, null, null);
            this.avT.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.avU.setText(arrayList.get(2));
            this.avU.setChecked(false);
            this.avU.setCompoundDrawables(this.awg, null, null, null);
            this.avU.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.avW != null) {
            this.avW.cancel();
            this.avW = null;
        }
        if (this.avX != null) {
            this.avX.cancel();
            this.avX = null;
        }
        Bi();
    }

    public void Bh() {
        this.avP.setVisibility(8);
        this.avP.clearCheck();
        this.avQ.setVisibility(8);
        this.avQ.clearCheck();
        this.avS.setVisibility(8);
        this.avT.setVisibility(8);
        this.avU.setVisibility(8);
        this.avS.setChecked(false);
        this.avT.setChecked(false);
        this.avU.setChecked(false);
    }

    public void Bi() {
        if (this.avN != null && this.avN.isShowing()) {
            g.b(this.avN, this.aby);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(String str) {
        if (str == null) {
            this.avY.setVisibility(4);
            this.avY.setText((CharSequence) null);
            return;
        }
        this.avY.setVisibility(0);
        this.avY.setText(str);
    }

    public void Ba() {
        this.aby.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aby.getLayoutMode().t(this.avM);
        this.avO.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.avS.setCompoundDrawables(this.awg, null, null, null);
        this.avT.setCompoundDrawables(this.awg, null, null, null);
        this.avU.setCompoundDrawables(this.awg, null, null, null);
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
            d.this.avW = null;
            d.this.awa.setVisibility(8);
            d.this.avZ.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.avW = null;
            d.this.awa.setVisibility(8);
            d.this.avZ.setEnabled(true);
            if (fVar == null) {
                d.this.fh(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.Bi();
                TbadkCoreApplication.setCurrentAccount(d.this.awc, d.this.aby.getPageActivity());
                if (d.this.awd != null) {
                    d.this.awd.j(d.this.awc);
                }
            } else {
                d.this.n(fVar.yl());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.awa.setVisibility(0);
            d.this.avZ.setEnabled(false);
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
                this.mNetwork.n("BDUSS", d.this.awc.getBDUSS());
                this.mNetwork.vj().wf().aij = false;
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
                                if (d.this.awc != null) {
                                    d.this.awc.setAccount(userName);
                                    d.this.awc.setBDUSS(bduss);
                                    d.this.awc.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.awc);
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
        final /* synthetic */ d awh;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.awh.avX = null;
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
            this.awh.avX = null;
            if (!this.mNetwork.vm()) {
                this.awh.fh(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vn() == 0) {
                this.awh.fh(this.awh.aby.getString(d.l.name_not_use));
            } else if (this.mNetwork.vn() == 36) {
                this.awh.fh(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.awh.n(fVar.yl());
                }
            } else {
                this.awh.fh(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.awh.fh(null);
            this.awh.Bh();
            super.onPreExecute();
        }
    }
}
