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
    private TbPageContext<?> abm;
    private Drawable avd;
    private Drawable ave;
    private int size;
    private View auK = null;
    private Dialog auL = null;
    private EditText auM = null;
    private RadioGroup auN = null;
    private RadioGroup auO = null;
    private CompoundButton.OnCheckedChangeListener auP = null;
    private RadioButton auQ = null;
    private RadioButton auR = null;
    private RadioButton auS = null;
    private TextView auT = null;
    private c auU = null;
    private b auV = null;
    private TextView auW = null;
    private TextView auX = null;
    private ProgressBar auY = null;
    private TextView auZ = null;
    private String mPhoneNum = null;
    private AccountData ava = null;
    private a avb = null;
    private a avc = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.abm = null;
        this.avd = null;
        this.ave = null;
        this.size = 0;
        this.abm = tbPageContext;
        this.avd = aj.getDrawable(d.g.icon_tips_names_s);
        this.ave = aj.getDrawable(d.g.icon_tips_names_n);
        this.size = this.abm.getResources().getDimensionPixelSize(d.f.ds26);
        this.avd.setBounds(0, 0, this.size, this.size);
        this.ave.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.ava = accountData;
    }

    public void a(a aVar) {
        this.avb = aVar;
    }

    public void b(a aVar) {
        this.avc = aVar;
    }

    public void Aw() {
        if (this.auL == null) {
            this.auK = LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.main_input_username, (ViewGroup) null);
            this.auM = (EditText) this.auK.findViewById(d.h.account);
            this.auM.setHint(this.abm.getString(d.l.input_alias_limit_length_tip));
            this.auT = (TextView) this.auK.findViewById(d.h.back);
            this.auT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.AA();
                    d.this.Ay();
                }
            });
            this.auX = (TextView) this.auK.findViewById(d.h.confirm);
            this.auX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Ax();
                }
            });
            this.auY = (ProgressBar) this.auK.findViewById(d.h.confirm_progress);
            this.auW = (TextView) this.auK.findViewById(d.h.error_info);
            this.auN = (RadioGroup) this.auK.findViewById(d.h.names_group1);
            this.auO = (RadioGroup) this.auK.findViewById(d.h.names_group2);
            this.auQ = (RadioButton) this.auK.findViewById(d.h.name1);
            this.auR = (RadioButton) this.auK.findViewById(d.h.name2);
            this.auS = (RadioButton) this.auK.findViewById(d.h.name3);
            this.auP = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.auQ) {
                            d.this.auO.clearCheck();
                            d.this.auQ.setChecked(true);
                            d.this.auQ.setCompoundDrawables(d.this.avd, null, null, null);
                            d.this.auR.setChecked(false);
                            d.this.auR.setCompoundDrawables(d.this.ave, null, null, null);
                            d.this.auS.setChecked(false);
                            d.this.auS.setCompoundDrawables(d.this.ave, null, null, null);
                        } else if (compoundButton == d.this.auR) {
                            d.this.auO.clearCheck();
                            d.this.auQ.setChecked(false);
                            d.this.auQ.setCompoundDrawables(d.this.ave, null, null, null);
                            d.this.auR.setChecked(true);
                            d.this.auR.setCompoundDrawables(d.this.avd, null, null, null);
                            d.this.auS.setChecked(false);
                            d.this.auS.setCompoundDrawables(d.this.ave, null, null, null);
                        } else if (compoundButton == d.this.auS) {
                            d.this.auN.clearCheck();
                            d.this.auQ.setChecked(false);
                            d.this.auQ.setCompoundDrawables(d.this.ave, null, null, null);
                            d.this.auR.setChecked(false);
                            d.this.auR.setCompoundDrawables(d.this.ave, null, null, null);
                            d.this.auS.setChecked(true);
                            d.this.auS.setCompoundDrawables(d.this.avd, null, null, null);
                        }
                        d.this.auM.setText(compoundButton.getText());
                    }
                }
            };
            this.auQ.setOnCheckedChangeListener(this.auP);
            this.auR.setOnCheckedChangeListener(this.auP);
            this.auS.setOnCheckedChangeListener(this.auP);
            this.auZ = (TextView) this.auK.findViewById(d.h.phone_info);
            Az();
            this.auL = new Dialog(this.abm.getPageActivity(), d.m.input_username_dialog);
            this.auL.setCanceledOnTouchOutside(false);
            this.auL.setCancelable(false);
            this.auL.setCanceledOnTouchOutside(false);
            As();
        }
        if (!this.auL.isShowing()) {
            this.auM.setText((CharSequence) null);
            Az();
            eZ(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.auZ.setText("Hi," + this.abm.getString(d.l.bar_friend));
            } else {
                this.auZ.setText("Hi," + this.mPhoneNum);
            }
            if (!this.abm.getPageActivity().isFinishing()) {
                this.auL.setContentView(this.auK);
                g.a(this.auL, this.abm);
                if (this.abm.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.abm.getOrignalPage()).ShowSoftKeyPadDelay(this.auM, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Ax() {
        String obj = this.auM.getText().toString();
        if (obj == null || obj.length() <= 0) {
            eZ(this.abm.getString(d.l.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            eZ(this.abm.getString(d.l.input_alias_limit_length_tip));
        } else {
            if (this.auV != null) {
                this.auV.cancel();
            }
            if (this.auU == null) {
                this.auU = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.auU.setPriority(3);
                this.auU.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        if (this.avc != null) {
            this.avc.j(null);
        }
    }

    public void m(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            eZ(this.abm.getString(d.l.suggest_no_name));
            return;
        }
        eZ(this.abm.getString(d.l.suggest_some_names));
        int size = arrayList.size();
        this.auN.clearCheck();
        this.auO.clearCheck();
        this.auN.setVisibility(0);
        this.auO.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.auQ.setText(arrayList.get(0));
            this.auQ.setChecked(false);
            this.auQ.setCompoundDrawables(this.ave, null, null, null);
            this.auQ.setVisibility(0);
            this.auN.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.auR.setText(arrayList.get(1));
            this.auR.setChecked(false);
            this.auR.setCompoundDrawables(this.ave, null, null, null);
            this.auR.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.auS.setText(arrayList.get(2));
            this.auS.setChecked(false);
            this.auS.setCompoundDrawables(this.ave, null, null, null);
            this.auS.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.auU != null) {
            this.auU.cancel();
            this.auU = null;
        }
        if (this.auV != null) {
            this.auV.cancel();
            this.auV = null;
        }
        AA();
    }

    public void Az() {
        this.auN.setVisibility(8);
        this.auN.clearCheck();
        this.auO.setVisibility(8);
        this.auO.clearCheck();
        this.auQ.setVisibility(8);
        this.auR.setVisibility(8);
        this.auS.setVisibility(8);
        this.auQ.setChecked(false);
        this.auR.setChecked(false);
        this.auS.setChecked(false);
    }

    public void AA() {
        if (this.auL != null && this.auL.isShowing()) {
            g.b(this.auL, this.abm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eZ(String str) {
        if (str == null) {
            this.auW.setVisibility(4);
            this.auW.setText((CharSequence) null);
            return;
        }
        this.auW.setVisibility(0);
        this.auW.setText(str);
    }

    public void As() {
        this.abm.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abm.getLayoutMode().t(this.auK);
        this.auM.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.auQ.setCompoundDrawables(this.ave, null, null, null);
        this.auR.setCompoundDrawables(this.ave, null, null, null);
        this.auS.setCompoundDrawables(this.ave, null, null, null);
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
            d.this.auU = null;
            d.this.auY.setVisibility(8);
            d.this.auX.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.auU = null;
            d.this.auY.setVisibility(8);
            d.this.auX.setEnabled(true);
            if (fVar == null) {
                d.this.eZ(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.AA();
                TbadkCoreApplication.setCurrentAccount(d.this.ava, d.this.abm.getPageActivity());
                if (d.this.avb != null) {
                    d.this.avb.j(d.this.ava);
                }
            } else {
                d.this.m(fVar.xD());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.auY.setVisibility(0);
            d.this.auX.setEnabled(false);
            d.this.eZ(null);
            d.this.Az();
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
                this.mNetwork.n("BDUSS", d.this.ava.getBDUSS());
                this.mNetwork.uG().vC().ahz = false;
                String ui = this.mNetwork.ui();
                if (this.mNetwork.uJ()) {
                    fVar = this.mNetwork.uK();
                    try {
                        if (fVar == 0) {
                            com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar2.parserJson(ui);
                            String userName = fVar2.getUser().getUserName();
                            String bduss = fVar2.getUser().getBDUSS();
                            fVar = fVar2;
                            fVar = fVar2;
                            if (userName != null && bduss != null) {
                                fVar = fVar2;
                                if (d.this.ava != null) {
                                    d.this.ava.setAccount(userName);
                                    d.this.ava.setBDUSS(bduss);
                                    d.this.ava.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.ava);
                                    fVar = fVar2;
                                }
                            }
                        } else if (this.mNetwork.uK() == 36) {
                            com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar3.parserJson(ui);
                            fVar = fVar3;
                        } else if (this.mNetwork.uK() == 1) {
                            d.this.AA();
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
        final /* synthetic */ d avf;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.avf.auV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String ui = this.mNetwork.ui();
            if (!this.mNetwork.uJ() || this.mNetwork.uK() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(ui);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.avf.auV = null;
            if (!this.mNetwork.uJ()) {
                this.avf.eZ(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uK() == 0) {
                this.avf.eZ(this.avf.abm.getString(d.l.name_not_use));
            } else if (this.mNetwork.uK() == 36) {
                this.avf.eZ(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.avf.m(fVar.xD());
                }
            } else {
                this.avf.eZ(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.avf.eZ(null);
            this.avf.Az();
            super.onPreExecute();
        }
    }
}
