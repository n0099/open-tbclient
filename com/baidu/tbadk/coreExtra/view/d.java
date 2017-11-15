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
    private TbPageContext<?> abI;
    private Drawable avJ;
    private Drawable avK;
    private int size;
    private View avq = null;
    private Dialog avr = null;
    private EditText avs = null;
    private RadioGroup avt = null;
    private RadioGroup avu = null;
    private CompoundButton.OnCheckedChangeListener avv = null;
    private RadioButton avw = null;
    private RadioButton avx = null;
    private RadioButton avy = null;
    private TextView avz = null;
    private c avA = null;
    private b avB = null;
    private TextView avC = null;
    private TextView avD = null;
    private ProgressBar avE = null;
    private TextView avF = null;
    private String mPhoneNum = null;
    private AccountData avG = null;
    private a avH = null;
    private a avI = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.abI = null;
        this.avJ = null;
        this.avK = null;
        this.size = 0;
        this.abI = tbPageContext;
        this.avJ = aj.getDrawable(d.f.icon_tips_names_s);
        this.avK = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.abI.getResources().getDimensionPixelSize(d.e.ds26);
        this.avJ.setBounds(0, 0, this.size, this.size);
        this.avK.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.avG = accountData;
    }

    public void a(a aVar) {
        this.avH = aVar;
    }

    public void b(a aVar) {
        this.avI = aVar;
    }

    public void AR() {
        if (this.avr == null) {
            this.avq = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.avs = (EditText) this.avq.findViewById(d.g.account);
            this.avs.setHint(this.abI.getString(d.j.input_alias_limit_length_tip));
            this.avz = (TextView) this.avq.findViewById(d.g.back);
            this.avz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.AV();
                    d.this.AT();
                }
            });
            this.avD = (TextView) this.avq.findViewById(d.g.confirm);
            this.avD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.AS();
                }
            });
            this.avE = (ProgressBar) this.avq.findViewById(d.g.confirm_progress);
            this.avC = (TextView) this.avq.findViewById(d.g.error_info);
            this.avt = (RadioGroup) this.avq.findViewById(d.g.names_group1);
            this.avu = (RadioGroup) this.avq.findViewById(d.g.names_group2);
            this.avw = (RadioButton) this.avq.findViewById(d.g.name1);
            this.avx = (RadioButton) this.avq.findViewById(d.g.name2);
            this.avy = (RadioButton) this.avq.findViewById(d.g.name3);
            this.avv = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.avw) {
                            d.this.avu.clearCheck();
                            d.this.avw.setChecked(true);
                            d.this.avw.setCompoundDrawables(d.this.avJ, null, null, null);
                            d.this.avx.setChecked(false);
                            d.this.avx.setCompoundDrawables(d.this.avK, null, null, null);
                            d.this.avy.setChecked(false);
                            d.this.avy.setCompoundDrawables(d.this.avK, null, null, null);
                        } else if (compoundButton == d.this.avx) {
                            d.this.avu.clearCheck();
                            d.this.avw.setChecked(false);
                            d.this.avw.setCompoundDrawables(d.this.avK, null, null, null);
                            d.this.avx.setChecked(true);
                            d.this.avx.setCompoundDrawables(d.this.avJ, null, null, null);
                            d.this.avy.setChecked(false);
                            d.this.avy.setCompoundDrawables(d.this.avK, null, null, null);
                        } else if (compoundButton == d.this.avy) {
                            d.this.avt.clearCheck();
                            d.this.avw.setChecked(false);
                            d.this.avw.setCompoundDrawables(d.this.avK, null, null, null);
                            d.this.avx.setChecked(false);
                            d.this.avx.setCompoundDrawables(d.this.avK, null, null, null);
                            d.this.avy.setChecked(true);
                            d.this.avy.setCompoundDrawables(d.this.avJ, null, null, null);
                        }
                        d.this.avs.setText(compoundButton.getText());
                    }
                }
            };
            this.avw.setOnCheckedChangeListener(this.avv);
            this.avx.setOnCheckedChangeListener(this.avv);
            this.avy.setOnCheckedChangeListener(this.avv);
            this.avF = (TextView) this.avq.findViewById(d.g.phone_info);
            AU();
            this.avr = new Dialog(this.abI.getPageActivity(), d.k.input_username_dialog);
            this.avr.setCanceledOnTouchOutside(false);
            this.avr.setCancelable(false);
            this.avr.setCanceledOnTouchOutside(false);
            AN();
        }
        if (!this.avr.isShowing()) {
            this.avs.setText((CharSequence) null);
            AU();
            fh(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.avF.setText("Hi," + this.abI.getString(d.j.bar_friend));
            } else {
                this.avF.setText("Hi," + this.mPhoneNum);
            }
            if (!this.abI.getPageActivity().isFinishing()) {
                this.avr.setContentView(this.avq);
                g.a(this.avr, this.abI);
                if (this.abI.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.abI.getOrignalPage()).ShowSoftKeyPadDelay(this.avs, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void AS() {
        String obj = this.avs.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fh(this.abI.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fh(this.abI.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.avB != null) {
                this.avB.cancel();
            }
            if (this.avA == null) {
                this.avA = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.avA.setPriority(3);
                this.avA.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AT() {
        if (this.avI != null) {
            this.avI.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fh(this.abI.getString(d.j.suggest_no_name));
            return;
        }
        fh(this.abI.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.avt.clearCheck();
        this.avu.clearCheck();
        this.avt.setVisibility(0);
        this.avu.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.avw.setText(arrayList.get(0));
            this.avw.setChecked(false);
            this.avw.setCompoundDrawables(this.avK, null, null, null);
            this.avw.setVisibility(0);
            this.avt.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.avx.setText(arrayList.get(1));
            this.avx.setChecked(false);
            this.avx.setCompoundDrawables(this.avK, null, null, null);
            this.avx.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.avy.setText(arrayList.get(2));
            this.avy.setChecked(false);
            this.avy.setCompoundDrawables(this.avK, null, null, null);
            this.avy.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.avA != null) {
            this.avA.cancel();
            this.avA = null;
        }
        if (this.avB != null) {
            this.avB.cancel();
            this.avB = null;
        }
        AV();
    }

    public void AU() {
        this.avt.setVisibility(8);
        this.avt.clearCheck();
        this.avu.setVisibility(8);
        this.avu.clearCheck();
        this.avw.setVisibility(8);
        this.avx.setVisibility(8);
        this.avy.setVisibility(8);
        this.avw.setChecked(false);
        this.avx.setChecked(false);
        this.avy.setChecked(false);
    }

    public void AV() {
        if (this.avr != null && this.avr.isShowing()) {
            g.b(this.avr, this.abI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(String str) {
        if (str == null) {
            this.avC.setVisibility(4);
            this.avC.setText((CharSequence) null);
            return;
        }
        this.avC.setVisibility(0);
        this.avC.setText(str);
    }

    public void AN() {
        this.abI.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abI.getLayoutMode().t(this.avq);
        this.avs.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        this.avw.setCompoundDrawables(this.avK, null, null, null);
        this.avx.setCompoundDrawables(this.avK, null, null, null);
        this.avy.setCompoundDrawables(this.avK, null, null, null);
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
            d.this.avA = null;
            d.this.avE.setVisibility(8);
            d.this.avD.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.g gVar) {
            super.onPostExecute(gVar);
            d.this.avA = null;
            d.this.avE.setVisibility(8);
            d.this.avD.setEnabled(true);
            if (gVar == null) {
                d.this.fh(this.mNetwork.getErrorString());
            } else if (gVar.getUser().getUserName() != null) {
                d.this.AV();
                TbadkCoreApplication.setCurrentAccount(d.this.avG, d.this.abI.getPageActivity());
                if (d.this.avH != null) {
                    d.this.avH.j(d.this.avG);
                }
            } else {
                d.this.n(gVar.xS());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.avE.setVisibility(0);
            d.this.avD.setEnabled(false);
            d.this.fh(null);
            d.this.AU();
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
                this.mNetwork.n("BDUSS", d.this.avG.getBDUSS());
                this.mNetwork.uN().vK().ahW = false;
                String up = this.mNetwork.up();
                if (this.mNetwork.uQ()) {
                    gVar = this.mNetwork.uR();
                    try {
                        if (gVar == 0) {
                            com.baidu.tbadk.coreExtra.data.g gVar2 = new com.baidu.tbadk.coreExtra.data.g();
                            gVar2.parserJson(up);
                            String userName = gVar2.getUser().getUserName();
                            String bduss = gVar2.getUser().getBDUSS();
                            gVar = gVar2;
                            gVar = gVar2;
                            if (userName != null && bduss != null) {
                                gVar = gVar2;
                                if (d.this.avG != null) {
                                    d.this.avG.setAccount(userName);
                                    d.this.avG.setBDUSS(bduss);
                                    d.this.avG.setPortrait(gVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.avG);
                                    gVar = gVar2;
                                }
                            }
                        } else if (this.mNetwork.uR() == 36) {
                            com.baidu.tbadk.coreExtra.data.g gVar3 = new com.baidu.tbadk.coreExtra.data.g();
                            gVar3.parserJson(up);
                            gVar = gVar3;
                        } else if (this.mNetwork.uR() == 1) {
                            d.this.AV();
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
        final /* synthetic */ d avL;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.avL.avB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.g doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String up = this.mNetwork.up();
            if (!this.mNetwork.uQ() || this.mNetwork.uR() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.g gVar = new com.baidu.tbadk.coreExtra.data.g();
            gVar.parserJson(up);
            return gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.g gVar) {
            super.onPostExecute(gVar);
            this.avL.avB = null;
            if (!this.mNetwork.uQ()) {
                this.avL.fh(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uR() == 0) {
                this.avL.fh(this.avL.abI.getString(d.j.name_not_use));
            } else if (this.mNetwork.uR() == 36) {
                this.avL.fh(this.mNetwork.getErrorString());
                if (gVar != null) {
                    this.avL.n(gVar.xS());
                }
            } else {
                this.avL.fh(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.avL.fh(null);
            this.avL.AU();
            super.onPreExecute();
        }
    }
}
