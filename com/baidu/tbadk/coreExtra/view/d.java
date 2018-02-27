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
    private TbPageContext<?> aRG;
    private Drawable bmR;
    private Drawable bmS;
    private int size;
    private View bmy = null;
    private Dialog bmz = null;
    private EditText bmA = null;
    private RadioGroup bmB = null;
    private RadioGroup bmC = null;
    private CompoundButton.OnCheckedChangeListener bmD = null;
    private RadioButton bmE = null;
    private RadioButton bmF = null;
    private RadioButton bmG = null;
    private TextView bmH = null;
    private c bmI = null;
    private b bmJ = null;
    private TextView bmK = null;
    private TextView bmL = null;
    private ProgressBar bmM = null;
    private TextView bmN = null;
    private String mPhoneNum = null;
    private AccountData bmO = null;
    private a bmP = null;
    private a bmQ = null;

    /* loaded from: classes.dex */
    public interface a {
        void i(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aRG = null;
        this.bmR = null;
        this.bmS = null;
        this.size = 0;
        this.aRG = tbPageContext;
        this.bmR = aj.getDrawable(d.f.icon_tips_names_s);
        this.bmS = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.aRG.getResources().getDimensionPixelSize(d.e.ds26);
        this.bmR.setBounds(0, 0, this.size, this.size);
        this.bmS.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.bmO = accountData;
    }

    public void a(a aVar) {
        this.bmP = aVar;
    }

    public void Je() {
        if (this.bmz == null) {
            this.bmy = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.bmA = (EditText) this.bmy.findViewById(d.g.account);
            this.bmA.setHint(this.aRG.getString(d.j.input_alias_limit_length_tip));
            this.bmH = (TextView) this.bmy.findViewById(d.g.back);
            this.bmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Ji();
                    d.this.Jg();
                }
            });
            this.bmL = (TextView) this.bmy.findViewById(d.g.confirm);
            this.bmL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Jf();
                }
            });
            this.bmM = (ProgressBar) this.bmy.findViewById(d.g.confirm_progress);
            this.bmK = (TextView) this.bmy.findViewById(d.g.error_info);
            this.bmB = (RadioGroup) this.bmy.findViewById(d.g.names_group1);
            this.bmC = (RadioGroup) this.bmy.findViewById(d.g.names_group2);
            this.bmE = (RadioButton) this.bmy.findViewById(d.g.name1);
            this.bmF = (RadioButton) this.bmy.findViewById(d.g.name2);
            this.bmG = (RadioButton) this.bmy.findViewById(d.g.name3);
            this.bmD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.bmE) {
                            d.this.bmC.clearCheck();
                            d.this.bmE.setChecked(true);
                            d.this.bmE.setCompoundDrawables(d.this.bmR, null, null, null);
                            d.this.bmF.setChecked(false);
                            d.this.bmF.setCompoundDrawables(d.this.bmS, null, null, null);
                            d.this.bmG.setChecked(false);
                            d.this.bmG.setCompoundDrawables(d.this.bmS, null, null, null);
                        } else if (compoundButton == d.this.bmF) {
                            d.this.bmC.clearCheck();
                            d.this.bmE.setChecked(false);
                            d.this.bmE.setCompoundDrawables(d.this.bmS, null, null, null);
                            d.this.bmF.setChecked(true);
                            d.this.bmF.setCompoundDrawables(d.this.bmR, null, null, null);
                            d.this.bmG.setChecked(false);
                            d.this.bmG.setCompoundDrawables(d.this.bmS, null, null, null);
                        } else if (compoundButton == d.this.bmG) {
                            d.this.bmB.clearCheck();
                            d.this.bmE.setChecked(false);
                            d.this.bmE.setCompoundDrawables(d.this.bmS, null, null, null);
                            d.this.bmF.setChecked(false);
                            d.this.bmF.setCompoundDrawables(d.this.bmS, null, null, null);
                            d.this.bmG.setChecked(true);
                            d.this.bmG.setCompoundDrawables(d.this.bmR, null, null, null);
                        }
                        d.this.bmA.setText(compoundButton.getText());
                    }
                }
            };
            this.bmE.setOnCheckedChangeListener(this.bmD);
            this.bmF.setOnCheckedChangeListener(this.bmD);
            this.bmG.setOnCheckedChangeListener(this.bmD);
            this.bmN = (TextView) this.bmy.findViewById(d.g.phone_info);
            Jh();
            this.bmz = new Dialog(this.aRG.getPageActivity(), d.k.input_username_dialog);
            this.bmz.setCanceledOnTouchOutside(false);
            this.bmz.setCancelable(false);
            this.bmz.setCanceledOnTouchOutside(false);
            Ja();
        }
        if (!this.bmz.isShowing()) {
            this.bmA.setText((CharSequence) null);
            Jh();
            fK(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.bmN.setText("Hi," + this.aRG.getString(d.j.bar_friend));
            } else {
                this.bmN.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aRG.getPageActivity().isFinishing()) {
                this.bmz.setContentView(this.bmy);
                g.a(this.bmz, this.aRG);
                if (this.aRG.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aRG.getOrignalPage()).ShowSoftKeyPadDelay(this.bmA, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Jf() {
        String obj = this.bmA.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fK(this.aRG.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fK(this.aRG.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.bmJ != null) {
                this.bmJ.cancel();
            }
            if (this.bmI == null) {
                this.bmI = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.bmI.setPriority(3);
                this.bmI.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jg() {
        if (this.bmQ != null) {
            this.bmQ.i(null);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fK(this.aRG.getString(d.j.suggest_no_name));
            return;
        }
        fK(this.aRG.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.bmB.clearCheck();
        this.bmC.clearCheck();
        this.bmB.setVisibility(0);
        this.bmC.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.bmE.setText(arrayList.get(0));
            this.bmE.setChecked(false);
            this.bmE.setCompoundDrawables(this.bmS, null, null, null);
            this.bmE.setVisibility(0);
            this.bmB.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.bmF.setText(arrayList.get(1));
            this.bmF.setChecked(false);
            this.bmF.setCompoundDrawables(this.bmS, null, null, null);
            this.bmF.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.bmG.setText(arrayList.get(2));
            this.bmG.setChecked(false);
            this.bmG.setCompoundDrawables(this.bmS, null, null, null);
            this.bmG.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.bmI != null) {
            this.bmI.cancel();
            this.bmI = null;
        }
        if (this.bmJ != null) {
            this.bmJ.cancel();
            this.bmJ = null;
        }
        Ji();
    }

    public void Jh() {
        this.bmB.setVisibility(8);
        this.bmB.clearCheck();
        this.bmC.setVisibility(8);
        this.bmC.clearCheck();
        this.bmE.setVisibility(8);
        this.bmF.setVisibility(8);
        this.bmG.setVisibility(8);
        this.bmE.setChecked(false);
        this.bmF.setChecked(false);
        this.bmG.setChecked(false);
    }

    public void Ji() {
        if (this.bmz != null && this.bmz.isShowing()) {
            g.b(this.bmz, this.aRG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(String str) {
        if (str == null) {
            this.bmK.setVisibility(4);
            this.bmK.setText((CharSequence) null);
            return;
        }
        this.bmK.setVisibility(0);
        this.bmK.setText(str);
    }

    public void Ja() {
        this.aRG.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aRG.getLayoutMode().aM(this.bmy);
        this.bmA.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        this.bmE.setCompoundDrawables(this.bmS, null, null, null);
        this.bmF.setCompoundDrawables(this.bmS, null, null, null);
        this.bmG.setCompoundDrawables(this.bmS, null, null, null);
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
            d.this.bmI = null;
            d.this.bmM.setVisibility(8);
            d.this.bmL.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            d.this.bmI = null;
            d.this.bmM.setVisibility(8);
            d.this.bmL.setEnabled(true);
            if (hVar == null) {
                d.this.fK(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                d.this.Ji();
                TbadkCoreApplication.setCurrentAccount(d.this.bmO, d.this.aRG.getPageActivity());
                if (d.this.bmP != null) {
                    d.this.bmP.i(d.this.bmO);
                }
            } else {
                d.this.o(hVar.FH());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.bmM.setVisibility(0);
            d.this.bmL.setEnabled(false);
            d.this.fK(null);
            d.this.Jh();
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
                this.mNetwork.n("BDUSS", d.this.bmO.getBDUSS());
                this.mNetwork.Cy().Dv().aXY = false;
                String Ca = this.mNetwork.Ca();
                if (this.mNetwork.CB()) {
                    hVar = this.mNetwork.CC();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(Ca);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (d.this.bmO != null) {
                                    d.this.bmO.setAccount(userName);
                                    d.this.bmO.setBDUSS(bduss);
                                    d.this.bmO.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.bmO);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.CC() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(Ca);
                            hVar = hVar3;
                        } else if (this.mNetwork.CC() == 1) {
                            d.this.Ji();
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
        final /* synthetic */ d bmT;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.bmT.bmJ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String Ca = this.mNetwork.Ca();
            if (!this.mNetwork.CB() || this.mNetwork.CC() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(Ca);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.bmT.bmJ = null;
            if (!this.mNetwork.CB()) {
                this.bmT.fK(this.mNetwork.getErrorString());
            } else if (this.mNetwork.CC() == 0) {
                this.bmT.fK(this.bmT.aRG.getString(d.j.name_not_use));
            } else if (this.mNetwork.CC() == 36) {
                this.bmT.fK(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.bmT.o(hVar.FH());
                }
            } else {
                this.bmT.fK(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bmT.fK(null);
            this.bmT.Jh();
            super.onPreExecute();
        }
    }
}
