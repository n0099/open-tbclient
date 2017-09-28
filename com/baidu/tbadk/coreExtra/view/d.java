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
    private TbPageContext<?> abz;
    private Drawable avp;
    private Drawable avq;
    private int size;
    private View auW = null;
    private Dialog auX = null;
    private EditText auY = null;
    private RadioGroup auZ = null;
    private RadioGroup ava = null;
    private CompoundButton.OnCheckedChangeListener avb = null;
    private RadioButton avc = null;
    private RadioButton avd = null;
    private RadioButton ave = null;
    private TextView avf = null;
    private c avg = null;
    private b avh = null;
    private TextView avi = null;
    private TextView avj = null;
    private ProgressBar avk = null;
    private TextView avl = null;
    private String mPhoneNum = null;
    private AccountData avm = null;
    private a avn = null;
    private a avo = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.abz = null;
        this.avp = null;
        this.avq = null;
        this.size = 0;
        this.abz = tbPageContext;
        this.avp = aj.getDrawable(d.g.icon_tips_names_s);
        this.avq = aj.getDrawable(d.g.icon_tips_names_n);
        this.size = this.abz.getResources().getDimensionPixelSize(d.f.ds26);
        this.avp.setBounds(0, 0, this.size, this.size);
        this.avq.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.avm = accountData;
    }

    public void a(a aVar) {
        this.avn = aVar;
    }

    public void b(a aVar) {
        this.avo = aVar;
    }

    public void AC() {
        if (this.auX == null) {
            this.auW = LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.main_input_username, (ViewGroup) null);
            this.auY = (EditText) this.auW.findViewById(d.h.account);
            this.auY.setHint(this.abz.getString(d.l.input_alias_limit_length_tip));
            this.avf = (TextView) this.auW.findViewById(d.h.back);
            this.avf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.AG();
                    d.this.AE();
                }
            });
            this.avj = (TextView) this.auW.findViewById(d.h.confirm);
            this.avj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.AD();
                }
            });
            this.avk = (ProgressBar) this.auW.findViewById(d.h.confirm_progress);
            this.avi = (TextView) this.auW.findViewById(d.h.error_info);
            this.auZ = (RadioGroup) this.auW.findViewById(d.h.names_group1);
            this.ava = (RadioGroup) this.auW.findViewById(d.h.names_group2);
            this.avc = (RadioButton) this.auW.findViewById(d.h.name1);
            this.avd = (RadioButton) this.auW.findViewById(d.h.name2);
            this.ave = (RadioButton) this.auW.findViewById(d.h.name3);
            this.avb = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.avc) {
                            d.this.ava.clearCheck();
                            d.this.avc.setChecked(true);
                            d.this.avc.setCompoundDrawables(d.this.avp, null, null, null);
                            d.this.avd.setChecked(false);
                            d.this.avd.setCompoundDrawables(d.this.avq, null, null, null);
                            d.this.ave.setChecked(false);
                            d.this.ave.setCompoundDrawables(d.this.avq, null, null, null);
                        } else if (compoundButton == d.this.avd) {
                            d.this.ava.clearCheck();
                            d.this.avc.setChecked(false);
                            d.this.avc.setCompoundDrawables(d.this.avq, null, null, null);
                            d.this.avd.setChecked(true);
                            d.this.avd.setCompoundDrawables(d.this.avp, null, null, null);
                            d.this.ave.setChecked(false);
                            d.this.ave.setCompoundDrawables(d.this.avq, null, null, null);
                        } else if (compoundButton == d.this.ave) {
                            d.this.auZ.clearCheck();
                            d.this.avc.setChecked(false);
                            d.this.avc.setCompoundDrawables(d.this.avq, null, null, null);
                            d.this.avd.setChecked(false);
                            d.this.avd.setCompoundDrawables(d.this.avq, null, null, null);
                            d.this.ave.setChecked(true);
                            d.this.ave.setCompoundDrawables(d.this.avp, null, null, null);
                        }
                        d.this.auY.setText(compoundButton.getText());
                    }
                }
            };
            this.avc.setOnCheckedChangeListener(this.avb);
            this.avd.setOnCheckedChangeListener(this.avb);
            this.ave.setOnCheckedChangeListener(this.avb);
            this.avl = (TextView) this.auW.findViewById(d.h.phone_info);
            AF();
            this.auX = new Dialog(this.abz.getPageActivity(), d.m.input_username_dialog);
            this.auX.setCanceledOnTouchOutside(false);
            this.auX.setCancelable(false);
            this.auX.setCanceledOnTouchOutside(false);
            Ay();
        }
        if (!this.auX.isShowing()) {
            this.auY.setText((CharSequence) null);
            AF();
            fa(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.avl.setText("Hi," + this.abz.getString(d.l.bar_friend));
            } else {
                this.avl.setText("Hi," + this.mPhoneNum);
            }
            if (!this.abz.getPageActivity().isFinishing()) {
                this.auX.setContentView(this.auW);
                g.a(this.auX, this.abz);
                if (this.abz.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.abz.getOrignalPage()).ShowSoftKeyPadDelay(this.auY, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void AD() {
        String obj = this.auY.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fa(this.abz.getString(d.l.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fa(this.abz.getString(d.l.input_alias_limit_length_tip));
        } else {
            if (this.avh != null) {
                this.avh.cancel();
            }
            if (this.avg == null) {
                this.avg = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.avg.setPriority(3);
                this.avg.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE() {
        if (this.avo != null) {
            this.avo.j(null);
        }
    }

    public void m(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fa(this.abz.getString(d.l.suggest_no_name));
            return;
        }
        fa(this.abz.getString(d.l.suggest_some_names));
        int size = arrayList.size();
        this.auZ.clearCheck();
        this.ava.clearCheck();
        this.auZ.setVisibility(0);
        this.ava.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.avc.setText(arrayList.get(0));
            this.avc.setChecked(false);
            this.avc.setCompoundDrawables(this.avq, null, null, null);
            this.avc.setVisibility(0);
            this.auZ.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.avd.setText(arrayList.get(1));
            this.avd.setChecked(false);
            this.avd.setCompoundDrawables(this.avq, null, null, null);
            this.avd.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.ave.setText(arrayList.get(2));
            this.ave.setChecked(false);
            this.ave.setCompoundDrawables(this.avq, null, null, null);
            this.ave.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.avg != null) {
            this.avg.cancel();
            this.avg = null;
        }
        if (this.avh != null) {
            this.avh.cancel();
            this.avh = null;
        }
        AG();
    }

    public void AF() {
        this.auZ.setVisibility(8);
        this.auZ.clearCheck();
        this.ava.setVisibility(8);
        this.ava.clearCheck();
        this.avc.setVisibility(8);
        this.avd.setVisibility(8);
        this.ave.setVisibility(8);
        this.avc.setChecked(false);
        this.avd.setChecked(false);
        this.ave.setChecked(false);
    }

    public void AG() {
        if (this.auX != null && this.auX.isShowing()) {
            g.b(this.auX, this.abz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(String str) {
        if (str == null) {
            this.avi.setVisibility(4);
            this.avi.setText((CharSequence) null);
            return;
        }
        this.avi.setVisibility(0);
        this.avi.setText(str);
    }

    public void Ay() {
        this.abz.getLayoutMode().ai(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abz.getLayoutMode().t(this.auW);
        this.auY.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.avc.setCompoundDrawables(this.avq, null, null, null);
        this.avd.setCompoundDrawables(this.avq, null, null, null);
        this.ave.setCompoundDrawables(this.avq, null, null, null);
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
            d.this.avg = null;
            d.this.avk.setVisibility(8);
            d.this.avj.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.avg = null;
            d.this.avk.setVisibility(8);
            d.this.avj.setEnabled(true);
            if (fVar == null) {
                d.this.fa(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.AG();
                TbadkCoreApplication.setCurrentAccount(d.this.avm, d.this.abz.getPageActivity());
                if (d.this.avn != null) {
                    d.this.avn.j(d.this.avm);
                }
            } else {
                d.this.m(fVar.xK());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.avk.setVisibility(0);
            d.this.avj.setEnabled(false);
            d.this.fa(null);
            d.this.AF();
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
                this.mNetwork.n("BDUSS", d.this.avm.getBDUSS());
                this.mNetwork.uN().vJ().ahL = false;
                String up = this.mNetwork.up();
                if (this.mNetwork.uQ()) {
                    fVar = this.mNetwork.uR();
                    try {
                        if (fVar == 0) {
                            com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar2.parserJson(up);
                            String userName = fVar2.getUser().getUserName();
                            String bduss = fVar2.getUser().getBDUSS();
                            fVar = fVar2;
                            fVar = fVar2;
                            if (userName != null && bduss != null) {
                                fVar = fVar2;
                                if (d.this.avm != null) {
                                    d.this.avm.setAccount(userName);
                                    d.this.avm.setBDUSS(bduss);
                                    d.this.avm.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.avm);
                                    fVar = fVar2;
                                }
                            }
                        } else if (this.mNetwork.uR() == 36) {
                            com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar3.parserJson(up);
                            fVar = fVar3;
                        } else if (this.mNetwork.uR() == 1) {
                            d.this.AG();
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
        final /* synthetic */ d avr;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.avr.avh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String up = this.mNetwork.up();
            if (!this.mNetwork.uQ() || this.mNetwork.uR() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(up);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.avr.avh = null;
            if (!this.mNetwork.uQ()) {
                this.avr.fa(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uR() == 0) {
                this.avr.fa(this.avr.abz.getString(d.l.name_not_use));
            } else if (this.mNetwork.uR() == 36) {
                this.avr.fa(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.avr.m(fVar.xK());
                }
            } else {
                this.avr.fa(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.avr.fa(null);
            this.avr.AF();
            super.onPreExecute();
        }
    }
}
