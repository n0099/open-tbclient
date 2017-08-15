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
    private TbPageContext<?> acr;
    private View awC = null;
    private Dialog awD = null;
    private EditText awE = null;
    private RadioGroup awF = null;
    private RadioGroup awG = null;
    private CompoundButton.OnCheckedChangeListener awH = null;
    private RadioButton awI = null;
    private RadioButton awJ = null;
    private RadioButton awK = null;
    private TextView awL = null;
    private c awM = null;
    private b awN = null;
    private TextView awO = null;
    private TextView awP = null;
    private ProgressBar awQ = null;
    private TextView awR = null;
    private String awS = null;
    private AccountData awT = null;
    private a awU = null;
    private a awV = null;
    private Drawable awW;
    private Drawable awX;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.acr = null;
        this.awW = null;
        this.awX = null;
        this.size = 0;
        this.acr = tbPageContext;
        this.awW = ai.getDrawable(d.g.icon_tips_names_s);
        this.awX = ai.getDrawable(d.g.icon_tips_names_n);
        this.size = this.acr.getResources().getDimensionPixelSize(d.f.ds26);
        this.awW.setBounds(0, 0, this.size, this.size);
        this.awX.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.awT = accountData;
    }

    public void a(a aVar) {
        this.awU = aVar;
    }

    public void b(a aVar) {
        this.awV = aVar;
    }

    public void Bj() {
        if (this.awD == null) {
            this.awC = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.main_input_username, (ViewGroup) null);
            this.awE = (EditText) this.awC.findViewById(d.h.account);
            this.awE.setHint(this.acr.getString(d.l.input_alias_limit_length_tip));
            this.awL = (TextView) this.awC.findViewById(d.h.back);
            this.awL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bn();
                    d.this.Bl();
                }
            });
            this.awP = (TextView) this.awC.findViewById(d.h.confirm);
            this.awP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bk();
                }
            });
            this.awQ = (ProgressBar) this.awC.findViewById(d.h.confirm_progress);
            this.awO = (TextView) this.awC.findViewById(d.h.error_info);
            this.awF = (RadioGroup) this.awC.findViewById(d.h.names_group1);
            this.awG = (RadioGroup) this.awC.findViewById(d.h.names_group2);
            this.awI = (RadioButton) this.awC.findViewById(d.h.name1);
            this.awJ = (RadioButton) this.awC.findViewById(d.h.name2);
            this.awK = (RadioButton) this.awC.findViewById(d.h.name3);
            this.awH = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.awI) {
                            d.this.awG.clearCheck();
                            d.this.awI.setChecked(true);
                            d.this.awI.setCompoundDrawables(d.this.awW, null, null, null);
                            d.this.awJ.setChecked(false);
                            d.this.awJ.setCompoundDrawables(d.this.awX, null, null, null);
                            d.this.awK.setChecked(false);
                            d.this.awK.setCompoundDrawables(d.this.awX, null, null, null);
                        } else if (compoundButton == d.this.awJ) {
                            d.this.awG.clearCheck();
                            d.this.awI.setChecked(false);
                            d.this.awI.setCompoundDrawables(d.this.awX, null, null, null);
                            d.this.awJ.setChecked(true);
                            d.this.awJ.setCompoundDrawables(d.this.awW, null, null, null);
                            d.this.awK.setChecked(false);
                            d.this.awK.setCompoundDrawables(d.this.awX, null, null, null);
                        } else if (compoundButton == d.this.awK) {
                            d.this.awF.clearCheck();
                            d.this.awI.setChecked(false);
                            d.this.awI.setCompoundDrawables(d.this.awX, null, null, null);
                            d.this.awJ.setChecked(false);
                            d.this.awJ.setCompoundDrawables(d.this.awX, null, null, null);
                            d.this.awK.setChecked(true);
                            d.this.awK.setCompoundDrawables(d.this.awW, null, null, null);
                        }
                        d.this.awE.setText(compoundButton.getText());
                    }
                }
            };
            this.awI.setOnCheckedChangeListener(this.awH);
            this.awJ.setOnCheckedChangeListener(this.awH);
            this.awK.setOnCheckedChangeListener(this.awH);
            this.awR = (TextView) this.awC.findViewById(d.h.phone_info);
            Bm();
            this.awD = new Dialog(this.acr.getPageActivity(), d.m.input_username_dialog);
            this.awD.setCanceledOnTouchOutside(false);
            this.awD.setCancelable(false);
            this.awD.setCanceledOnTouchOutside(false);
            Bf();
        }
        if (!this.awD.isShowing()) {
            this.awE.setText((CharSequence) null);
            Bm();
            fi(null);
            if (this.awS == null || this.awS.length() <= 0) {
                this.awR.setText("Hi," + this.acr.getString(d.l.bar_friend));
            } else {
                this.awR.setText("Hi," + this.awS);
            }
            if (!this.acr.getPageActivity().isFinishing()) {
                this.awD.setContentView(this.awC);
                g.a(this.awD, this.acr);
                if (this.acr.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.acr.getOrignalPage()).ShowSoftKeyPadDelay(this.awE, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bk() {
        String obj = this.awE.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fi(this.acr.getString(d.l.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fi(this.acr.getString(d.l.input_alias_limit_length_tip));
        } else {
            if (this.awN != null) {
                this.awN.cancel();
            }
            if (this.awM == null) {
                this.awM = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.awM.setPriority(3);
                this.awM.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl() {
        if (this.awV != null) {
            this.awV.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fi(this.acr.getString(d.l.suggest_no_name));
            return;
        }
        fi(this.acr.getString(d.l.suggest_some_names));
        int size = arrayList.size();
        this.awF.clearCheck();
        this.awG.clearCheck();
        this.awF.setVisibility(0);
        this.awG.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.awI.setText(arrayList.get(0));
            this.awI.setChecked(false);
            this.awI.setCompoundDrawables(this.awX, null, null, null);
            this.awI.setVisibility(0);
            this.awF.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.awJ.setText(arrayList.get(1));
            this.awJ.setChecked(false);
            this.awJ.setCompoundDrawables(this.awX, null, null, null);
            this.awJ.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.awK.setText(arrayList.get(2));
            this.awK.setChecked(false);
            this.awK.setCompoundDrawables(this.awX, null, null, null);
            this.awK.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.awM != null) {
            this.awM.cancel();
            this.awM = null;
        }
        if (this.awN != null) {
            this.awN.cancel();
            this.awN = null;
        }
        Bn();
    }

    public void Bm() {
        this.awF.setVisibility(8);
        this.awF.clearCheck();
        this.awG.setVisibility(8);
        this.awG.clearCheck();
        this.awI.setVisibility(8);
        this.awJ.setVisibility(8);
        this.awK.setVisibility(8);
        this.awI.setChecked(false);
        this.awJ.setChecked(false);
        this.awK.setChecked(false);
    }

    public void Bn() {
        if (this.awD != null && this.awD.isShowing()) {
            g.b(this.awD, this.acr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(String str) {
        if (str == null) {
            this.awO.setVisibility(4);
            this.awO.setText((CharSequence) null);
            return;
        }
        this.awO.setVisibility(0);
        this.awO.setText(str);
    }

    public void Bf() {
        this.acr.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acr.getLayoutMode().t(this.awC);
        this.awE.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.awI.setCompoundDrawables(this.awX, null, null, null);
        this.awJ.setCompoundDrawables(this.awX, null, null, null);
        this.awK.setCompoundDrawables(this.awX, null, null, null);
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
            d.this.awM = null;
            d.this.awQ.setVisibility(8);
            d.this.awP.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.awM = null;
            d.this.awQ.setVisibility(8);
            d.this.awP.setEnabled(true);
            if (fVar == null) {
                d.this.fi(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.Bn();
                TbadkCoreApplication.setCurrentAccount(d.this.awT, d.this.acr.getPageActivity());
                if (d.this.awU != null) {
                    d.this.awU.j(d.this.awT);
                }
            } else {
                d.this.n(fVar.yj());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.awQ.setVisibility(0);
            d.this.awP.setEnabled(false);
            d.this.fi(null);
            d.this.Bm();
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
                this.mNetwork.n("BDUSS", d.this.awT.getBDUSS());
                this.mNetwork.vl().wh().aiQ = false;
                String uO = this.mNetwork.uO();
                if (this.mNetwork.vo()) {
                    fVar = this.mNetwork.vp();
                    try {
                        if (fVar == 0) {
                            com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar2.parserJson(uO);
                            String userName = fVar2.getUser().getUserName();
                            String bduss = fVar2.getUser().getBDUSS();
                            fVar = fVar2;
                            fVar = fVar2;
                            if (userName != null && bduss != null) {
                                fVar = fVar2;
                                if (d.this.awT != null) {
                                    d.this.awT.setAccount(userName);
                                    d.this.awT.setBDUSS(bduss);
                                    d.this.awT.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.awT);
                                    fVar = fVar2;
                                }
                            }
                        } else if (this.mNetwork.vp() == 36) {
                            com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar3.parserJson(uO);
                            fVar = fVar3;
                        } else if (this.mNetwork.vp() == 1) {
                            d.this.Bn();
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
        final /* synthetic */ d awY;
        private String mAccount;
        private w mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.awY.awN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new w(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uO = this.mNetwork.uO();
            if (!this.mNetwork.vo() || this.mNetwork.vp() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uO);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.awY.awN = null;
            if (!this.mNetwork.vo()) {
                this.awY.fi(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vp() == 0) {
                this.awY.fi(this.awY.acr.getString(d.l.name_not_use));
            } else if (this.mNetwork.vp() == 36) {
                this.awY.fi(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.awY.n(fVar.yj());
                }
            } else {
                this.awY.fi(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.awY.fi(null);
            this.awY.Bm();
            super.onPreExecute();
        }
    }
}
