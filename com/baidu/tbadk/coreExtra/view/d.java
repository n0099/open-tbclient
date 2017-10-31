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
    private Drawable avB;
    private Drawable avC;
    private int size;
    private View avi = null;
    private Dialog avj = null;
    private EditText avk = null;
    private RadioGroup avl = null;
    private RadioGroup avm = null;
    private CompoundButton.OnCheckedChangeListener avn = null;
    private RadioButton avo = null;
    private RadioButton avp = null;
    private RadioButton avq = null;
    private TextView avr = null;
    private c avs = null;
    private b avt = null;
    private TextView avu = null;
    private TextView avv = null;
    private ProgressBar avw = null;
    private TextView avx = null;
    private String mPhoneNum = null;
    private AccountData avy = null;
    private a avz = null;
    private a avA = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.abI = null;
        this.avB = null;
        this.avC = null;
        this.size = 0;
        this.abI = tbPageContext;
        this.avB = aj.getDrawable(d.f.icon_tips_names_s);
        this.avC = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.abI.getResources().getDimensionPixelSize(d.e.ds26);
        this.avB.setBounds(0, 0, this.size, this.size);
        this.avC.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.avy = accountData;
    }

    public void a(a aVar) {
        this.avz = aVar;
    }

    public void b(a aVar) {
        this.avA = aVar;
    }

    public void AF() {
        if (this.avj == null) {
            this.avi = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.avk = (EditText) this.avi.findViewById(d.g.account);
            this.avk.setHint(this.abI.getString(d.j.input_alias_limit_length_tip));
            this.avr = (TextView) this.avi.findViewById(d.g.back);
            this.avr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.AJ();
                    d.this.AH();
                }
            });
            this.avv = (TextView) this.avi.findViewById(d.g.confirm);
            this.avv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.AG();
                }
            });
            this.avw = (ProgressBar) this.avi.findViewById(d.g.confirm_progress);
            this.avu = (TextView) this.avi.findViewById(d.g.error_info);
            this.avl = (RadioGroup) this.avi.findViewById(d.g.names_group1);
            this.avm = (RadioGroup) this.avi.findViewById(d.g.names_group2);
            this.avo = (RadioButton) this.avi.findViewById(d.g.name1);
            this.avp = (RadioButton) this.avi.findViewById(d.g.name2);
            this.avq = (RadioButton) this.avi.findViewById(d.g.name3);
            this.avn = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.avo) {
                            d.this.avm.clearCheck();
                            d.this.avo.setChecked(true);
                            d.this.avo.setCompoundDrawables(d.this.avB, null, null, null);
                            d.this.avp.setChecked(false);
                            d.this.avp.setCompoundDrawables(d.this.avC, null, null, null);
                            d.this.avq.setChecked(false);
                            d.this.avq.setCompoundDrawables(d.this.avC, null, null, null);
                        } else if (compoundButton == d.this.avp) {
                            d.this.avm.clearCheck();
                            d.this.avo.setChecked(false);
                            d.this.avo.setCompoundDrawables(d.this.avC, null, null, null);
                            d.this.avp.setChecked(true);
                            d.this.avp.setCompoundDrawables(d.this.avB, null, null, null);
                            d.this.avq.setChecked(false);
                            d.this.avq.setCompoundDrawables(d.this.avC, null, null, null);
                        } else if (compoundButton == d.this.avq) {
                            d.this.avl.clearCheck();
                            d.this.avo.setChecked(false);
                            d.this.avo.setCompoundDrawables(d.this.avC, null, null, null);
                            d.this.avp.setChecked(false);
                            d.this.avp.setCompoundDrawables(d.this.avC, null, null, null);
                            d.this.avq.setChecked(true);
                            d.this.avq.setCompoundDrawables(d.this.avB, null, null, null);
                        }
                        d.this.avk.setText(compoundButton.getText());
                    }
                }
            };
            this.avo.setOnCheckedChangeListener(this.avn);
            this.avp.setOnCheckedChangeListener(this.avn);
            this.avq.setOnCheckedChangeListener(this.avn);
            this.avx = (TextView) this.avi.findViewById(d.g.phone_info);
            AI();
            this.avj = new Dialog(this.abI.getPageActivity(), d.k.input_username_dialog);
            this.avj.setCanceledOnTouchOutside(false);
            this.avj.setCancelable(false);
            this.avj.setCanceledOnTouchOutside(false);
            AB();
        }
        if (!this.avj.isShowing()) {
            this.avk.setText((CharSequence) null);
            AI();
            fg(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.avx.setText("Hi," + this.abI.getString(d.j.bar_friend));
            } else {
                this.avx.setText("Hi," + this.mPhoneNum);
            }
            if (!this.abI.getPageActivity().isFinishing()) {
                this.avj.setContentView(this.avi);
                g.a(this.avj, this.abI);
                if (this.abI.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.abI.getOrignalPage()).ShowSoftKeyPadDelay(this.avk, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void AG() {
        String obj = this.avk.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fg(this.abI.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fg(this.abI.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.avt != null) {
                this.avt.cancel();
            }
            if (this.avs == null) {
                this.avs = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.avs.setPriority(3);
                this.avs.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH() {
        if (this.avA != null) {
            this.avA.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fg(this.abI.getString(d.j.suggest_no_name));
            return;
        }
        fg(this.abI.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.avl.clearCheck();
        this.avm.clearCheck();
        this.avl.setVisibility(0);
        this.avm.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.avo.setText(arrayList.get(0));
            this.avo.setChecked(false);
            this.avo.setCompoundDrawables(this.avC, null, null, null);
            this.avo.setVisibility(0);
            this.avl.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.avp.setText(arrayList.get(1));
            this.avp.setChecked(false);
            this.avp.setCompoundDrawables(this.avC, null, null, null);
            this.avp.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.avq.setText(arrayList.get(2));
            this.avq.setChecked(false);
            this.avq.setCompoundDrawables(this.avC, null, null, null);
            this.avq.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.avs != null) {
            this.avs.cancel();
            this.avs = null;
        }
        if (this.avt != null) {
            this.avt.cancel();
            this.avt = null;
        }
        AJ();
    }

    public void AI() {
        this.avl.setVisibility(8);
        this.avl.clearCheck();
        this.avm.setVisibility(8);
        this.avm.clearCheck();
        this.avo.setVisibility(8);
        this.avp.setVisibility(8);
        this.avq.setVisibility(8);
        this.avo.setChecked(false);
        this.avp.setChecked(false);
        this.avq.setChecked(false);
    }

    public void AJ() {
        if (this.avj != null && this.avj.isShowing()) {
            g.b(this.avj, this.abI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(String str) {
        if (str == null) {
            this.avu.setVisibility(4);
            this.avu.setText((CharSequence) null);
            return;
        }
        this.avu.setVisibility(0);
        this.avu.setText(str);
    }

    public void AB() {
        this.abI.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abI.getLayoutMode().t(this.avi);
        this.avk.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        this.avo.setCompoundDrawables(this.avC, null, null, null);
        this.avp.setCompoundDrawables(this.avC, null, null, null);
        this.avq.setCompoundDrawables(this.avC, null, null, null);
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
            d.this.avs = null;
            d.this.avw.setVisibility(8);
            d.this.avv.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.avs = null;
            d.this.avw.setVisibility(8);
            d.this.avv.setEnabled(true);
            if (fVar == null) {
                d.this.fg(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.AJ();
                TbadkCoreApplication.setCurrentAccount(d.this.avy, d.this.abI.getPageActivity());
                if (d.this.avz != null) {
                    d.this.avz.j(d.this.avy);
                }
            } else {
                d.this.n(fVar.xK());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.avw.setVisibility(0);
            d.this.avv.setEnabled(false);
            d.this.fg(null);
            d.this.AI();
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
                this.mNetwork.n("BDUSS", d.this.avy.getBDUSS());
                this.mNetwork.uN().vK().ahW = false;
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
                                if (d.this.avy != null) {
                                    d.this.avy.setAccount(userName);
                                    d.this.avy.setBDUSS(bduss);
                                    d.this.avy.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.avy);
                                    fVar = fVar2;
                                }
                            }
                        } else if (this.mNetwork.uR() == 36) {
                            com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar3.parserJson(up);
                            fVar = fVar3;
                        } else if (this.mNetwork.uR() == 1) {
                            d.this.AJ();
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
        final /* synthetic */ d avD;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.avD.avt = null;
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
            this.avD.avt = null;
            if (!this.mNetwork.uQ()) {
                this.avD.fg(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uR() == 0) {
                this.avD.fg(this.avD.abI.getString(d.j.name_not_use));
            } else if (this.mNetwork.uR() == 36) {
                this.avD.fg(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.avD.n(fVar.xK());
                }
            } else {
                this.avD.fg(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.avD.fg(null);
            this.avD.AI();
            super.onPreExecute();
        }
    }
}
