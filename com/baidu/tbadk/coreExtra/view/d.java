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
    private View awD = null;
    private Dialog awE = null;
    private EditText awF = null;
    private RadioGroup awG = null;
    private RadioGroup awH = null;
    private CompoundButton.OnCheckedChangeListener awI = null;
    private RadioButton awJ = null;
    private RadioButton awK = null;
    private RadioButton awL = null;
    private TextView awM = null;
    private c awN = null;
    private b awO = null;
    private TextView awP = null;
    private TextView awQ = null;
    private ProgressBar awR = null;
    private TextView awS = null;
    private String awT = null;
    private AccountData awU = null;
    private a awV = null;
    private a awW = null;
    private Drawable awX;
    private Drawable awY;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.acr = null;
        this.awX = null;
        this.awY = null;
        this.size = 0;
        this.acr = tbPageContext;
        this.awX = ai.getDrawable(d.g.icon_tips_names_s);
        this.awY = ai.getDrawable(d.g.icon_tips_names_n);
        this.size = this.acr.getResources().getDimensionPixelSize(d.f.ds26);
        this.awX.setBounds(0, 0, this.size, this.size);
        this.awY.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.awU = accountData;
    }

    public void a(a aVar) {
        this.awV = aVar;
    }

    public void b(a aVar) {
        this.awW = aVar;
    }

    public void Bj() {
        if (this.awE == null) {
            this.awD = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.main_input_username, (ViewGroup) null);
            this.awF = (EditText) this.awD.findViewById(d.h.account);
            this.awF.setHint(this.acr.getString(d.l.input_alias_limit_length_tip));
            this.awM = (TextView) this.awD.findViewById(d.h.back);
            this.awM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bn();
                    d.this.Bl();
                }
            });
            this.awQ = (TextView) this.awD.findViewById(d.h.confirm);
            this.awQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bk();
                }
            });
            this.awR = (ProgressBar) this.awD.findViewById(d.h.confirm_progress);
            this.awP = (TextView) this.awD.findViewById(d.h.error_info);
            this.awG = (RadioGroup) this.awD.findViewById(d.h.names_group1);
            this.awH = (RadioGroup) this.awD.findViewById(d.h.names_group2);
            this.awJ = (RadioButton) this.awD.findViewById(d.h.name1);
            this.awK = (RadioButton) this.awD.findViewById(d.h.name2);
            this.awL = (RadioButton) this.awD.findViewById(d.h.name3);
            this.awI = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.awJ) {
                            d.this.awH.clearCheck();
                            d.this.awJ.setChecked(true);
                            d.this.awJ.setCompoundDrawables(d.this.awX, null, null, null);
                            d.this.awK.setChecked(false);
                            d.this.awK.setCompoundDrawables(d.this.awY, null, null, null);
                            d.this.awL.setChecked(false);
                            d.this.awL.setCompoundDrawables(d.this.awY, null, null, null);
                        } else if (compoundButton == d.this.awK) {
                            d.this.awH.clearCheck();
                            d.this.awJ.setChecked(false);
                            d.this.awJ.setCompoundDrawables(d.this.awY, null, null, null);
                            d.this.awK.setChecked(true);
                            d.this.awK.setCompoundDrawables(d.this.awX, null, null, null);
                            d.this.awL.setChecked(false);
                            d.this.awL.setCompoundDrawables(d.this.awY, null, null, null);
                        } else if (compoundButton == d.this.awL) {
                            d.this.awG.clearCheck();
                            d.this.awJ.setChecked(false);
                            d.this.awJ.setCompoundDrawables(d.this.awY, null, null, null);
                            d.this.awK.setChecked(false);
                            d.this.awK.setCompoundDrawables(d.this.awY, null, null, null);
                            d.this.awL.setChecked(true);
                            d.this.awL.setCompoundDrawables(d.this.awX, null, null, null);
                        }
                        d.this.awF.setText(compoundButton.getText());
                    }
                }
            };
            this.awJ.setOnCheckedChangeListener(this.awI);
            this.awK.setOnCheckedChangeListener(this.awI);
            this.awL.setOnCheckedChangeListener(this.awI);
            this.awS = (TextView) this.awD.findViewById(d.h.phone_info);
            Bm();
            this.awE = new Dialog(this.acr.getPageActivity(), d.m.input_username_dialog);
            this.awE.setCanceledOnTouchOutside(false);
            this.awE.setCancelable(false);
            this.awE.setCanceledOnTouchOutside(false);
            Bf();
        }
        if (!this.awE.isShowing()) {
            this.awF.setText((CharSequence) null);
            Bm();
            fm(null);
            if (this.awT == null || this.awT.length() <= 0) {
                this.awS.setText("Hi," + this.acr.getString(d.l.bar_friend));
            } else {
                this.awS.setText("Hi," + this.awT);
            }
            if (!this.acr.getPageActivity().isFinishing()) {
                this.awE.setContentView(this.awD);
                g.a(this.awE, this.acr);
                if (this.acr.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.acr.getOrignalPage()).ShowSoftKeyPadDelay(this.awF, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bk() {
        String obj = this.awF.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fm(this.acr.getString(d.l.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fm(this.acr.getString(d.l.input_alias_limit_length_tip));
        } else {
            if (this.awO != null) {
                this.awO.cancel();
            }
            if (this.awN == null) {
                this.awN = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.awN.setPriority(3);
                this.awN.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl() {
        if (this.awW != null) {
            this.awW.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fm(this.acr.getString(d.l.suggest_no_name));
            return;
        }
        fm(this.acr.getString(d.l.suggest_some_names));
        int size = arrayList.size();
        this.awG.clearCheck();
        this.awH.clearCheck();
        this.awG.setVisibility(0);
        this.awH.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.awJ.setText(arrayList.get(0));
            this.awJ.setChecked(false);
            this.awJ.setCompoundDrawables(this.awY, null, null, null);
            this.awJ.setVisibility(0);
            this.awG.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.awK.setText(arrayList.get(1));
            this.awK.setChecked(false);
            this.awK.setCompoundDrawables(this.awY, null, null, null);
            this.awK.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.awL.setText(arrayList.get(2));
            this.awL.setChecked(false);
            this.awL.setCompoundDrawables(this.awY, null, null, null);
            this.awL.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.awN != null) {
            this.awN.cancel();
            this.awN = null;
        }
        if (this.awO != null) {
            this.awO.cancel();
            this.awO = null;
        }
        Bn();
    }

    public void Bm() {
        this.awG.setVisibility(8);
        this.awG.clearCheck();
        this.awH.setVisibility(8);
        this.awH.clearCheck();
        this.awJ.setVisibility(8);
        this.awK.setVisibility(8);
        this.awL.setVisibility(8);
        this.awJ.setChecked(false);
        this.awK.setChecked(false);
        this.awL.setChecked(false);
    }

    public void Bn() {
        if (this.awE != null && this.awE.isShowing()) {
            g.b(this.awE, this.acr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(String str) {
        if (str == null) {
            this.awP.setVisibility(4);
            this.awP.setText((CharSequence) null);
            return;
        }
        this.awP.setVisibility(0);
        this.awP.setText(str);
    }

    public void Bf() {
        this.acr.getLayoutMode().ah(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.acr.getLayoutMode().t(this.awD);
        this.awF.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.awJ.setCompoundDrawables(this.awY, null, null, null);
        this.awK.setCompoundDrawables(this.awY, null, null, null);
        this.awL.setCompoundDrawables(this.awY, null, null, null);
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
            d.this.awN = null;
            d.this.awR.setVisibility(8);
            d.this.awQ.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            d.this.awN = null;
            d.this.awR.setVisibility(8);
            d.this.awQ.setEnabled(true);
            if (fVar == null) {
                d.this.fm(this.mNetwork.getErrorString());
            } else if (fVar.getUser().getUserName() != null) {
                d.this.Bn();
                TbadkCoreApplication.setCurrentAccount(d.this.awU, d.this.acr.getPageActivity());
                if (d.this.awV != null) {
                    d.this.awV.j(d.this.awU);
                }
            } else {
                d.this.n(fVar.yj());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.awR.setVisibility(0);
            d.this.awQ.setEnabled(false);
            d.this.fm(null);
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
                this.mNetwork.n("BDUSS", d.this.awU.getBDUSS());
                this.mNetwork.vm().wi().aiQ = false;
                String uP = this.mNetwork.uP();
                if (this.mNetwork.vp()) {
                    fVar = this.mNetwork.vq();
                    try {
                        if (fVar == 0) {
                            com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar2.parserJson(uP);
                            String userName = fVar2.getUser().getUserName();
                            String bduss = fVar2.getUser().getBDUSS();
                            fVar = fVar2;
                            fVar = fVar2;
                            if (userName != null && bduss != null) {
                                fVar = fVar2;
                                if (d.this.awU != null) {
                                    d.this.awU.setAccount(userName);
                                    d.this.awU.setBDUSS(bduss);
                                    d.this.awU.setPortrait(fVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.awU);
                                    fVar = fVar2;
                                }
                            }
                        } else if (this.mNetwork.vq() == 36) {
                            com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
                            fVar3.parserJson(uP);
                            fVar = fVar3;
                        } else if (this.mNetwork.vq() == 1) {
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
        final /* synthetic */ d awZ;
        private String mAccount;
        private w mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.awZ.awO = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetwork = new w(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uP = this.mNetwork.uP();
            if (!this.mNetwork.vp() || this.mNetwork.vq() != 36) {
                return null;
            }
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.parserJson(uP);
            return fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            super.onPostExecute(fVar);
            this.awZ.awO = null;
            if (!this.mNetwork.vp()) {
                this.awZ.fm(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vq() == 0) {
                this.awZ.fm(this.awZ.acr.getString(d.l.name_not_use));
            } else if (this.mNetwork.vq() == 36) {
                this.awZ.fm(this.mNetwork.getErrorString());
                if (fVar != null) {
                    this.awZ.n(fVar.yj());
                }
            } else {
                this.awZ.fm(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.awZ.fm(null);
            this.awZ.Bm();
            super.onPreExecute();
        }
    }
}
