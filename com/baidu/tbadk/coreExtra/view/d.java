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
    private TbPageContext<?> acp;
    private View awB = null;
    private Dialog awC = null;
    private EditText awD = null;
    private RadioGroup awE = null;
    private RadioGroup awF = null;
    private CompoundButton.OnCheckedChangeListener awG = null;
    private RadioButton awH = null;
    private RadioButton awI = null;
    private RadioButton awJ = null;
    private TextView awK = null;
    private c awL = null;
    private b awM = null;
    private TextView awN = null;
    private TextView awO = null;
    private ProgressBar awP = null;
    private TextView awQ = null;
    private String awR = null;
    private AccountData awS = null;
    private a awT = null;
    private a awU = null;
    private Drawable awV;
    private Drawable awW;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.acp = null;
        this.awV = null;
        this.awW = null;
        this.size = 0;
        this.acp = tbPageContext;
        this.awV = ai.getDrawable(d.g.icon_tips_names_s);
        this.awW = ai.getDrawable(d.g.icon_tips_names_n);
        this.size = this.acp.getResources().getDimensionPixelSize(d.f.ds26);
        this.awV.setBounds(0, 0, this.size, this.size);
        this.awW.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.awS = accountData;
    }

    public void a(a aVar) {
        this.awT = aVar;
    }

    public void b(a aVar) {
        this.awU = aVar;
    }

    public void Bj() {
        if (this.awC == null) {
            this.awB = LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.main_input_username, (ViewGroup) null);
            this.awD = (EditText) this.awB.findViewById(d.h.account);
            this.awD.setHint(this.acp.getString(d.l.input_alias_limit_length_tip));
            this.awK = (TextView) this.awB.findViewById(d.h.back);
            this.awK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bn();
                    d.this.Bl();
                }
            });
            this.awO = (TextView) this.awB.findViewById(d.h.confirm);
            this.awO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bk();
                }
            });
            this.awP = (ProgressBar) this.awB.findViewById(d.h.confirm_progress);
            this.awN = (TextView) this.awB.findViewById(d.h.error_info);
            this.awE = (RadioGroup) this.awB.findViewById(d.h.names_group1);
            this.awF = (RadioGroup) this.awB.findViewById(d.h.names_group2);
            this.awH = (RadioButton) this.awB.findViewById(d.h.name1);
            this.awI = (RadioButton) this.awB.findViewById(d.h.name2);
            this.awJ = (RadioButton) this.awB.findViewById(d.h.name3);
            this.awG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.awH) {
                            d.this.awF.clearCheck();
                            d.this.awH.setChecked(true);
                            d.this.awH.setCompoundDrawables(d.this.awV, null, null, null);
                            d.this.awI.setChecked(false);
                            d.this.awI.setCompoundDrawables(d.this.awW, null, null, null);
                            d.this.awJ.setChecked(false);
                            d.this.awJ.setCompoundDrawables(d.this.awW, null, null, null);
                        } else if (compoundButton == d.this.awI) {
                            d.this.awF.clearCheck();
                            d.this.awH.setChecked(false);
                            d.this.awH.setCompoundDrawables(d.this.awW, null, null, null);
                            d.this.awI.setChecked(true);
                            d.this.awI.setCompoundDrawables(d.this.awV, null, null, null);
                            d.this.awJ.setChecked(false);
                            d.this.awJ.setCompoundDrawables(d.this.awW, null, null, null);
                        } else if (compoundButton == d.this.awJ) {
                            d.this.awE.clearCheck();
                            d.this.awH.setChecked(false);
                            d.this.awH.setCompoundDrawables(d.this.awW, null, null, null);
                            d.this.awI.setChecked(false);
                            d.this.awI.setCompoundDrawables(d.this.awW, null, null, null);
                            d.this.awJ.setChecked(true);
                            d.this.awJ.setCompoundDrawables(d.this.awV, null, null, null);
                        }
                        d.this.awD.setText(compoundButton.getText());
                    }
                }
            };
            this.awH.setOnCheckedChangeListener(this.awG);
            this.awI.setOnCheckedChangeListener(this.awG);
            this.awJ.setOnCheckedChangeListener(this.awG);
            this.awQ = (TextView) this.awB.findViewById(d.h.phone_info);
            Bm();
            this.awC = new Dialog(this.acp.getPageActivity(), d.m.input_username_dialog);
            this.awC.setCanceledOnTouchOutside(false);
            this.awC.setCancelable(false);
            this.awC.setCanceledOnTouchOutside(false);
            Bf();
        }
        if (!this.awC.isShowing()) {
            this.awD.setText((CharSequence) null);
            Bm();
            fi(null);
            if (this.awR == null || this.awR.length() <= 0) {
                this.awQ.setText("Hi," + this.acp.getString(d.l.bar_friend));
            } else {
                this.awQ.setText("Hi," + this.awR);
            }
            if (!this.acp.getPageActivity().isFinishing()) {
                this.awC.setContentView(this.awB);
                g.a(this.awC, this.acp);
                if (this.acp.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.acp.getOrignalPage()).ShowSoftKeyPadDelay(this.awD, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bk() {
        String obj = this.awD.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fi(this.acp.getString(d.l.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fi(this.acp.getString(d.l.input_alias_limit_length_tip));
        } else {
            if (this.awM != null) {
                this.awM.cancel();
            }
            if (this.awL == null) {
                this.awL = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.awL.setPriority(3);
                this.awL.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl() {
        if (this.awU != null) {
            this.awU.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fi(this.acp.getString(d.l.suggest_no_name));
            return;
        }
        fi(this.acp.getString(d.l.suggest_some_names));
        int size = arrayList.size();
        this.awE.clearCheck();
        this.awF.clearCheck();
        this.awE.setVisibility(0);
        this.awF.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.awH.setText(arrayList.get(0));
            this.awH.setChecked(false);
            this.awH.setCompoundDrawables(this.awW, null, null, null);
            this.awH.setVisibility(0);
            this.awE.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.awI.setText(arrayList.get(1));
            this.awI.setChecked(false);
            this.awI.setCompoundDrawables(this.awW, null, null, null);
            this.awI.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.awJ.setText(arrayList.get(2));
            this.awJ.setChecked(false);
            this.awJ.setCompoundDrawables(this.awW, null, null, null);
            this.awJ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.awL != null) {
            this.awL.cancel();
            this.awL = null;
        }
        if (this.awM != null) {
            this.awM.cancel();
            this.awM = null;
        }
        Bn();
    }

    public void Bm() {
        this.awE.setVisibility(8);
        this.awE.clearCheck();
        this.awF.setVisibility(8);
        this.awF.clearCheck();
        this.awH.setVisibility(8);
        this.awI.setVisibility(8);
        this.awJ.setVisibility(8);
        this.awH.setChecked(false);
        this.awI.setChecked(false);
        this.awJ.setChecked(false);
    }

    public void Bn() {
        if (this.awC != null && this.awC.isShowing()) {
            g.b(this.awC, this.acp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(String str) {
        if (str == null) {
            this.awN.setVisibility(4);
            this.awN.setText((CharSequence) null);
            return;
        }
        this.awN.setVisibility(0);
        this.awN.setText(str);
    }

    public void Bf() {
        this.acp.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acp.getLayoutMode().t(this.awB);
        this.awD.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.awH.setCompoundDrawables(this.awW, null, null, null);
        this.awI.setCompoundDrawables(this.awW, null, null, null);
        this.awJ.setCompoundDrawables(this.awW, null, null, null);
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
            d.this.awL = null;
            d.this.awP.setVisibility(8);
            d.this.awO.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.awL = null;
            d.this.awP.setVisibility(8);
            d.this.awO.setEnabled(true);
            if (fVar == null) {
                d.this.fi(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.Bn();
                TbadkCoreApplication.setCurrentAccount(d.this.awS, d.this.acp.getPageActivity());
                if (d.this.awT != null) {
                    d.this.awT.j(d.this.awS);
                }
            } else {
                d.this.n(fVar.yj());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.awP.setVisibility(0);
            d.this.awO.setEnabled(false);
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
                this.mNetwork.n("BDUSS", d.this.awS.getBDUSS());
                this.mNetwork.vl().wh().aiO = false;
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
                                if (d.this.awS != null) {
                                    d.this.awS.setAccount(userName);
                                    d.this.awS.setBDUSS(bduss);
                                    d.this.awS.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.awS);
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
        final /* synthetic */ d awX;
        private String mAccount;
        private w mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.awX.awM = null;
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
            this.awX.awM = null;
            if (!this.mNetwork.vo()) {
                this.awX.fi(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vp() == 0) {
                this.awX.fi(this.awX.acp.getString(d.l.name_not_use));
            } else if (this.mNetwork.vp() == 36) {
                this.awX.fi(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.awX.n(fVar.yj());
                }
            } else {
                this.awX.fi(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.awX.fi(null);
            this.awX.Bm();
            super.onPreExecute();
        }
    }
}
