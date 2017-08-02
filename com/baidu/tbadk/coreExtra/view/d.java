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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private TbPageContext<?> aaS;
    private Drawable avE;
    private Drawable avF;
    private int size;
    private View avk = null;
    private Dialog avl = null;
    private EditText avm = null;
    private RadioGroup avn = null;
    private RadioGroup avo = null;
    private CompoundButton.OnCheckedChangeListener avp = null;
    private RadioButton avq = null;
    private RadioButton avr = null;
    private RadioButton avs = null;
    private TextView avt = null;
    private c avu = null;
    private b avv = null;
    private TextView avw = null;
    private TextView avx = null;
    private ProgressBar avy = null;
    private TextView avz = null;
    private String avA = null;
    private AccountData avB = null;
    private a avC = null;
    private a avD = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aaS = null;
        this.avE = null;
        this.avF = null;
        this.size = 0;
        this.aaS = tbPageContext;
        this.avE = ai.getDrawable(d.g.icon_tips_names_s);
        this.avF = ai.getDrawable(d.g.icon_tips_names_n);
        this.size = this.aaS.getResources().getDimensionPixelSize(d.f.ds26);
        this.avE.setBounds(0, 0, this.size, this.size);
        this.avF.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.avB = accountData;
    }

    public void a(a aVar) {
        this.avC = aVar;
    }

    public void b(a aVar) {
        this.avD = aVar;
    }

    public void Bb() {
        if (this.avl == null) {
            this.avk = LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.main_input_username, (ViewGroup) null);
            this.avm = (EditText) this.avk.findViewById(d.h.account);
            this.avm.setHint(this.aaS.getString(d.l.input_alias_limit_length_tip));
            this.avt = (TextView) this.avk.findViewById(d.h.back);
            this.avt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bf();
                    d.this.Bd();
                }
            });
            this.avx = (TextView) this.avk.findViewById(d.h.confirm);
            this.avx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bc();
                }
            });
            this.avy = (ProgressBar) this.avk.findViewById(d.h.confirm_progress);
            this.avw = (TextView) this.avk.findViewById(d.h.error_info);
            this.avn = (RadioGroup) this.avk.findViewById(d.h.names_group1);
            this.avo = (RadioGroup) this.avk.findViewById(d.h.names_group2);
            this.avq = (RadioButton) this.avk.findViewById(d.h.name1);
            this.avr = (RadioButton) this.avk.findViewById(d.h.name2);
            this.avs = (RadioButton) this.avk.findViewById(d.h.name3);
            this.avp = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.avq) {
                            d.this.avo.clearCheck();
                            d.this.avq.setChecked(true);
                            d.this.avq.setCompoundDrawables(d.this.avE, null, null, null);
                            d.this.avr.setChecked(false);
                            d.this.avr.setCompoundDrawables(d.this.avF, null, null, null);
                            d.this.avs.setChecked(false);
                            d.this.avs.setCompoundDrawables(d.this.avF, null, null, null);
                        } else if (compoundButton == d.this.avr) {
                            d.this.avo.clearCheck();
                            d.this.avq.setChecked(false);
                            d.this.avq.setCompoundDrawables(d.this.avF, null, null, null);
                            d.this.avr.setChecked(true);
                            d.this.avr.setCompoundDrawables(d.this.avE, null, null, null);
                            d.this.avs.setChecked(false);
                            d.this.avs.setCompoundDrawables(d.this.avF, null, null, null);
                        } else if (compoundButton == d.this.avs) {
                            d.this.avn.clearCheck();
                            d.this.avq.setChecked(false);
                            d.this.avq.setCompoundDrawables(d.this.avF, null, null, null);
                            d.this.avr.setChecked(false);
                            d.this.avr.setCompoundDrawables(d.this.avF, null, null, null);
                            d.this.avs.setChecked(true);
                            d.this.avs.setCompoundDrawables(d.this.avE, null, null, null);
                        }
                        d.this.avm.setText(compoundButton.getText());
                    }
                }
            };
            this.avq.setOnCheckedChangeListener(this.avp);
            this.avr.setOnCheckedChangeListener(this.avp);
            this.avs.setOnCheckedChangeListener(this.avp);
            this.avz = (TextView) this.avk.findViewById(d.h.phone_info);
            Be();
            this.avl = new Dialog(this.aaS.getPageActivity(), d.m.input_username_dialog);
            this.avl.setCanceledOnTouchOutside(false);
            this.avl.setCancelable(false);
            this.avl.setCanceledOnTouchOutside(false);
            AX();
        }
        if (!this.avl.isShowing()) {
            this.avm.setText((CharSequence) null);
            Be();
            fc(null);
            if (this.avA == null || this.avA.length() <= 0) {
                this.avz.setText("Hi," + this.aaS.getString(d.l.bar_friend));
            } else {
                this.avz.setText("Hi," + this.avA);
            }
            if (!this.aaS.getPageActivity().isFinishing()) {
                this.avl.setContentView(this.avk);
                g.a(this.avl, this.aaS);
                if (this.aaS.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aaS.getOrignalPage()).ShowSoftKeyPadDelay(this.avm, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bc() {
        String obj = this.avm.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fc(this.aaS.getString(d.l.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fc(this.aaS.getString(d.l.input_alias_limit_length_tip));
        } else {
            if (this.avv != null) {
                this.avv.cancel();
            }
            if (this.avu == null) {
                this.avu = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.avu.setPriority(3);
                this.avu.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd() {
        if (this.avD != null) {
            this.avD.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fc(this.aaS.getString(d.l.suggest_no_name));
            return;
        }
        fc(this.aaS.getString(d.l.suggest_some_names));
        int size = arrayList.size();
        this.avn.clearCheck();
        this.avo.clearCheck();
        this.avn.setVisibility(0);
        this.avo.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.avq.setText(arrayList.get(0));
            this.avq.setChecked(false);
            this.avq.setCompoundDrawables(this.avF, null, null, null);
            this.avq.setVisibility(0);
            this.avn.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.avr.setText(arrayList.get(1));
            this.avr.setChecked(false);
            this.avr.setCompoundDrawables(this.avF, null, null, null);
            this.avr.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.avs.setText(arrayList.get(2));
            this.avs.setChecked(false);
            this.avs.setCompoundDrawables(this.avF, null, null, null);
            this.avs.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.avu != null) {
            this.avu.cancel();
            this.avu = null;
        }
        if (this.avv != null) {
            this.avv.cancel();
            this.avv = null;
        }
        Bf();
    }

    public void Be() {
        this.avn.setVisibility(8);
        this.avn.clearCheck();
        this.avo.setVisibility(8);
        this.avo.clearCheck();
        this.avq.setVisibility(8);
        this.avr.setVisibility(8);
        this.avs.setVisibility(8);
        this.avq.setChecked(false);
        this.avr.setChecked(false);
        this.avs.setChecked(false);
    }

    public void Bf() {
        if (this.avl != null && this.avl.isShowing()) {
            g.b(this.avl, this.aaS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(String str) {
        if (str == null) {
            this.avw.setVisibility(4);
            this.avw.setText((CharSequence) null);
            return;
        }
        this.avw.setVisibility(0);
        this.avw.setText(str);
    }

    public void AX() {
        this.aaS.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aaS.getLayoutMode().t(this.avk);
        this.avm.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.avq.setCompoundDrawables(this.avF, null, null, null);
        this.avr.setCompoundDrawables(this.avF, null, null, null);
        this.avs.setCompoundDrawables(this.avF, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        private String mAccount;
        private w mNetwork = null;
        private String mUrl;

        public c(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            d.this.avu = null;
            d.this.avy.setVisibility(8);
            d.this.avx.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.avu = null;
            d.this.avy.setVisibility(8);
            d.this.avx.setEnabled(true);
            if (fVar == null) {
                d.this.fc(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.Bf();
                TbadkCoreApplication.setCurrentAccount(d.this.avB, d.this.aaS.getPageActivity());
                if (d.this.avC != null) {
                    d.this.avC.j(d.this.avB);
                }
            } else {
                d.this.n(fVar.yb());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.avy.setVisibility(0);
            d.this.avx.setEnabled(false);
            d.this.fc(null);
            d.this.Be();
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
                this.mNetwork = new w(this.mUrl);
                this.mNetwork.n("un", this.mAccount);
                this.mNetwork.n("BDUSS", d.this.avB.getBDUSS());
                this.mNetwork.vb().vX().ahv = false;
                String uE = this.mNetwork.uE();
                if (this.mNetwork.ve()) {
                    fVar = this.mNetwork.vf();
                    try {
                        if (fVar == 0) {
                            com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar2.parserJson(uE);
                            String userName = fVar2.getUser().getUserName();
                            String bduss = fVar2.getUser().getBDUSS();
                            fVar = fVar2;
                            fVar = fVar2;
                            if (userName != null && bduss != null) {
                                fVar = fVar2;
                                if (d.this.avB != null) {
                                    d.this.avB.setAccount(userName);
                                    d.this.avB.setBDUSS(bduss);
                                    d.this.avB.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.avB);
                                    fVar = fVar2;
                                }
                            }
                        } else if (this.mNetwork.vf() == 36) {
                            com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar3.parserJson(uE);
                            fVar = fVar3;
                        } else if (this.mNetwork.vf() == 1) {
                            d.this.Bf();
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
        final /* synthetic */ d avG;
        private String mAccount;
        private w mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.avG.avv = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new w(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uE = this.mNetwork.uE();
            if (!this.mNetwork.ve() || this.mNetwork.vf() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uE);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.avG.avv = null;
            if (!this.mNetwork.ve()) {
                this.avG.fc(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vf() == 0) {
                this.avG.fc(this.avG.aaS.getString(d.l.name_not_use));
            } else if (this.mNetwork.vf() == 36) {
                this.avG.fc(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.avG.n(fVar.yb());
                }
            } else {
                this.avG.fc(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.avG.fc(null);
            this.avG.Be();
            super.onPreExecute();
        }
    }
}
