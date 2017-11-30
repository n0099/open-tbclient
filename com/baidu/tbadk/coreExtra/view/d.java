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
    private TbPageContext<?> acd;
    private Drawable awk;
    private Drawable awl;
    private int size;
    private View avR = null;
    private Dialog avS = null;
    private EditText avT = null;
    private RadioGroup avU = null;
    private RadioGroup avV = null;
    private CompoundButton.OnCheckedChangeListener avW = null;
    private RadioButton avX = null;
    private RadioButton avY = null;
    private RadioButton avZ = null;
    private TextView awa = null;
    private c awb = null;
    private b awc = null;
    private TextView awd = null;
    private TextView awe = null;
    private ProgressBar awf = null;
    private TextView awg = null;
    private String mPhoneNum = null;
    private AccountData awh = null;
    private a awi = null;
    private a awj = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.acd = null;
        this.awk = null;
        this.awl = null;
        this.size = 0;
        this.acd = tbPageContext;
        this.awk = aj.getDrawable(d.f.icon_tips_names_s);
        this.awl = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.acd.getResources().getDimensionPixelSize(d.e.ds26);
        this.awk.setBounds(0, 0, this.size, this.size);
        this.awl.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.awh = accountData;
    }

    public void a(a aVar) {
        this.awi = aVar;
    }

    public void b(a aVar) {
        this.awj = aVar;
    }

    public void Bb() {
        if (this.avS == null) {
            this.avR = LayoutInflater.from(this.acd.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.avT = (EditText) this.avR.findViewById(d.g.account);
            this.avT.setHint(this.acd.getString(d.j.input_alias_limit_length_tip));
            this.awa = (TextView) this.avR.findViewById(d.g.back);
            this.awa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bf();
                    d.this.Bd();
                }
            });
            this.awe = (TextView) this.avR.findViewById(d.g.confirm);
            this.awe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bc();
                }
            });
            this.awf = (ProgressBar) this.avR.findViewById(d.g.confirm_progress);
            this.awd = (TextView) this.avR.findViewById(d.g.error_info);
            this.avU = (RadioGroup) this.avR.findViewById(d.g.names_group1);
            this.avV = (RadioGroup) this.avR.findViewById(d.g.names_group2);
            this.avX = (RadioButton) this.avR.findViewById(d.g.name1);
            this.avY = (RadioButton) this.avR.findViewById(d.g.name2);
            this.avZ = (RadioButton) this.avR.findViewById(d.g.name3);
            this.avW = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.avX) {
                            d.this.avV.clearCheck();
                            d.this.avX.setChecked(true);
                            d.this.avX.setCompoundDrawables(d.this.awk, null, null, null);
                            d.this.avY.setChecked(false);
                            d.this.avY.setCompoundDrawables(d.this.awl, null, null, null);
                            d.this.avZ.setChecked(false);
                            d.this.avZ.setCompoundDrawables(d.this.awl, null, null, null);
                        } else if (compoundButton == d.this.avY) {
                            d.this.avV.clearCheck();
                            d.this.avX.setChecked(false);
                            d.this.avX.setCompoundDrawables(d.this.awl, null, null, null);
                            d.this.avY.setChecked(true);
                            d.this.avY.setCompoundDrawables(d.this.awk, null, null, null);
                            d.this.avZ.setChecked(false);
                            d.this.avZ.setCompoundDrawables(d.this.awl, null, null, null);
                        } else if (compoundButton == d.this.avZ) {
                            d.this.avU.clearCheck();
                            d.this.avX.setChecked(false);
                            d.this.avX.setCompoundDrawables(d.this.awl, null, null, null);
                            d.this.avY.setChecked(false);
                            d.this.avY.setCompoundDrawables(d.this.awl, null, null, null);
                            d.this.avZ.setChecked(true);
                            d.this.avZ.setCompoundDrawables(d.this.awk, null, null, null);
                        }
                        d.this.avT.setText(compoundButton.getText());
                    }
                }
            };
            this.avX.setOnCheckedChangeListener(this.avW);
            this.avY.setOnCheckedChangeListener(this.avW);
            this.avZ.setOnCheckedChangeListener(this.avW);
            this.awg = (TextView) this.avR.findViewById(d.g.phone_info);
            Be();
            this.avS = new Dialog(this.acd.getPageActivity(), d.k.input_username_dialog);
            this.avS.setCanceledOnTouchOutside(false);
            this.avS.setCancelable(false);
            this.avS.setCanceledOnTouchOutside(false);
            AX();
        }
        if (!this.avS.isShowing()) {
            this.avT.setText((CharSequence) null);
            Be();
            fn(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.awg.setText("Hi," + this.acd.getString(d.j.bar_friend));
            } else {
                this.awg.setText("Hi," + this.mPhoneNum);
            }
            if (!this.acd.getPageActivity().isFinishing()) {
                this.avS.setContentView(this.avR);
                g.a(this.avS, this.acd);
                if (this.acd.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.acd.getOrignalPage()).ShowSoftKeyPadDelay(this.avT, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bc() {
        String obj = this.avT.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fn(this.acd.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fn(this.acd.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.awc != null) {
                this.awc.cancel();
            }
            if (this.awb == null) {
                this.awb = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.awb.setPriority(3);
                this.awb.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd() {
        if (this.awj != null) {
            this.awj.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fn(this.acd.getString(d.j.suggest_no_name));
            return;
        }
        fn(this.acd.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.avU.clearCheck();
        this.avV.clearCheck();
        this.avU.setVisibility(0);
        this.avV.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.avX.setText(arrayList.get(0));
            this.avX.setChecked(false);
            this.avX.setCompoundDrawables(this.awl, null, null, null);
            this.avX.setVisibility(0);
            this.avU.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.avY.setText(arrayList.get(1));
            this.avY.setChecked(false);
            this.avY.setCompoundDrawables(this.awl, null, null, null);
            this.avY.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.avZ.setText(arrayList.get(2));
            this.avZ.setChecked(false);
            this.avZ.setCompoundDrawables(this.awl, null, null, null);
            this.avZ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.awb != null) {
            this.awb.cancel();
            this.awb = null;
        }
        if (this.awc != null) {
            this.awc.cancel();
            this.awc = null;
        }
        Bf();
    }

    public void Be() {
        this.avU.setVisibility(8);
        this.avU.clearCheck();
        this.avV.setVisibility(8);
        this.avV.clearCheck();
        this.avX.setVisibility(8);
        this.avY.setVisibility(8);
        this.avZ.setVisibility(8);
        this.avX.setChecked(false);
        this.avY.setChecked(false);
        this.avZ.setChecked(false);
    }

    public void Bf() {
        if (this.avS != null && this.avS.isShowing()) {
            g.b(this.avS, this.acd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(String str) {
        if (str == null) {
            this.awd.setVisibility(4);
            this.awd.setText((CharSequence) null);
            return;
        }
        this.awd.setVisibility(0);
        this.awd.setText(str);
    }

    public void AX() {
        this.acd.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acd.getLayoutMode().t(this.avR);
        this.avT.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
        this.avX.setCompoundDrawables(this.awl, null, null, null);
        this.avY.setCompoundDrawables(this.awl, null, null, null);
        this.avZ.setCompoundDrawables(this.awl, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.g> {
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
            d.this.awb = null;
            d.this.awf.setVisibility(8);
            d.this.awe.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.g gVar) {
            super.onPostExecute(gVar);
            d.this.awb = null;
            d.this.awf.setVisibility(8);
            d.this.awe.setEnabled(true);
            if (gVar == null) {
                d.this.fn(this.mNetwork.getErrorString());
            } else if (gVar.getUser().getUserName() != null) {
                d.this.Bf();
                TbadkCoreApplication.setCurrentAccount(d.this.awh, d.this.acd.getPageActivity());
                if (d.this.awi != null) {
                    d.this.awi.j(d.this.awh);
                }
            } else {
                d.this.n(gVar.xT());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.awf.setVisibility(0);
            d.this.awe.setEnabled(false);
            d.this.fn(null);
            d.this.Be();
            super.onPreExecute();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00ad */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0047 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.tbadk.coreExtra.data.g */
        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tbadk.coreExtra.data.g */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tbadk.coreExtra.data.g */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [com.baidu.tbadk.coreExtra.data.g] */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v28 */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.g doInBackground(String... strArr) {
            com.baidu.tbadk.coreExtra.data.g gVar;
            Exception e;
            try {
                this.mNetwork = new x(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", d.this.awh.getBDUSS());
                this.mNetwork.uQ().vN().ait = false;
                String us = this.mNetwork.us();
                if (this.mNetwork.uT()) {
                    gVar = this.mNetwork.uU();
                    try {
                        if (gVar == 0) {
                            com.baidu.tbadk.coreExtra.data.g gVar2 = new com.baidu.tbadk.coreExtra.data.g();
                            gVar2.parserJson(us);
                            String userName = gVar2.getUser().getUserName();
                            String bduss = gVar2.getUser().getBDUSS();
                            gVar = gVar2;
                            gVar = gVar2;
                            if (userName != null && bduss != null) {
                                gVar = gVar2;
                                if (d.this.awh != null) {
                                    d.this.awh.setAccount(userName);
                                    d.this.awh.setBDUSS(bduss);
                                    d.this.awh.setPortrait(gVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.awh);
                                    gVar = gVar2;
                                }
                            }
                        } else if (this.mNetwork.uU() == 36) {
                            com.baidu.tbadk.coreExtra.data.g gVar3 = new com.baidu.tbadk.coreExtra.data.g();
                            gVar3.parserJson(us);
                            gVar = gVar3;
                        } else if (this.mNetwork.uU() == 1) {
                            d.this.Bf();
                        }
                        return gVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return gVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                gVar = 0;
                e = e3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.g> {
        final /* synthetic */ d awm;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.awm.awc = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.g doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String us = this.mNetwork.us();
            if (!this.mNetwork.uT() || this.mNetwork.uU() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.g gVar = new com.baidu.tbadk.coreExtra.data.g();
            gVar.parserJson(us);
            return gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.g gVar) {
            super.onPostExecute(gVar);
            this.awm.awc = null;
            if (!this.mNetwork.uT()) {
                this.awm.fn(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uU() == 0) {
                this.awm.fn(this.awm.acd.getString(d.j.name_not_use));
            } else if (this.mNetwork.uU() == 36) {
                this.awm.fn(this.mNetwork.getErrorString());
                if (gVar != null) {
                    this.awm.n(gVar.xT());
                }
            } else {
                this.awm.fn(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.awm.fn(null);
            this.awm.Be();
            super.onPreExecute();
        }
    }
}
