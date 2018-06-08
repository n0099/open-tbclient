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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private View aGJ = null;
    private Dialog aGK = null;
    private EditText aGL = null;
    private RadioGroup aGM = null;
    private RadioGroup aGN = null;
    private CompoundButton.OnCheckedChangeListener aGO = null;
    private RadioButton aGP = null;
    private RadioButton aGQ = null;
    private RadioButton aGR = null;
    private TextView aGS = null;
    private c aGT = null;
    private b aGU = null;
    private TextView aGV = null;
    private TextView aGW = null;
    private ProgressBar aGX = null;
    private TextView aGY = null;
    private AccountData aGZ = null;
    private InterfaceC0109a aHa = null;
    private InterfaceC0109a aHb = null;
    private Drawable aHc;
    private Drawable aHd;
    private TbPageContext<?> mContext;
    private int size;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109a {
        void f(AccountData accountData);
    }

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.aHc = null;
        this.aHd = null;
        this.size = 0;
        this.mContext = tbPageContext;
        this.aHc = al.getDrawable(d.f.icon_tips_names_s);
        this.aHd = al.getDrawable(d.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(d.e.ds26);
        this.aHc.setBounds(0, 0, this.size, this.size);
        this.aHd.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.aGZ = accountData;
    }

    public void a(InterfaceC0109a interfaceC0109a) {
        this.aHa = interfaceC0109a;
    }

    public void b(InterfaceC0109a interfaceC0109a) {
        this.aHb = interfaceC0109a;
    }

    public void Fv() {
        er(0);
    }

    public void er(int i) {
        if (this.aGK == null) {
            this.aGJ = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.main_input_username, (ViewGroup) null);
            this.aGL = (EditText) this.aGJ.findViewById(d.g.account);
            this.aGL.setHint(this.mContext.getString(d.k.hint_tip_input_name));
            this.aGS = (TextView) this.aGJ.findViewById(d.g.back);
            this.aGS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Fz();
                    a.this.Fx();
                }
            });
            this.aGW = (TextView) this.aGJ.findViewById(d.g.confirm);
            this.aGW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Fw();
                }
            });
            this.aGX = (ProgressBar) this.aGJ.findViewById(d.g.confirm_progress);
            this.aGV = (TextView) this.aGJ.findViewById(d.g.error_info);
            this.aGM = (RadioGroup) this.aGJ.findViewById(d.g.names_group1);
            this.aGN = (RadioGroup) this.aGJ.findViewById(d.g.names_group2);
            this.aGP = (RadioButton) this.aGJ.findViewById(d.g.name1);
            this.aGQ = (RadioButton) this.aGJ.findViewById(d.g.name2);
            this.aGR = (RadioButton) this.aGJ.findViewById(d.g.name3);
            this.aGO = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aGP) {
                            a.this.aGN.clearCheck();
                            a.this.aGP.setChecked(true);
                            a.this.aGP.setCompoundDrawables(a.this.aHc, null, null, null);
                            a.this.aGQ.setChecked(false);
                            a.this.aGQ.setCompoundDrawables(a.this.aHd, null, null, null);
                            a.this.aGR.setChecked(false);
                            a.this.aGR.setCompoundDrawables(a.this.aHd, null, null, null);
                        } else if (compoundButton == a.this.aGQ) {
                            a.this.aGN.clearCheck();
                            a.this.aGP.setChecked(false);
                            a.this.aGP.setCompoundDrawables(a.this.aHd, null, null, null);
                            a.this.aGQ.setChecked(true);
                            a.this.aGQ.setCompoundDrawables(a.this.aHc, null, null, null);
                            a.this.aGR.setChecked(false);
                            a.this.aGR.setCompoundDrawables(a.this.aHd, null, null, null);
                        } else if (compoundButton == a.this.aGR) {
                            a.this.aGM.clearCheck();
                            a.this.aGP.setChecked(false);
                            a.this.aGP.setCompoundDrawables(a.this.aHd, null, null, null);
                            a.this.aGQ.setChecked(false);
                            a.this.aGQ.setCompoundDrawables(a.this.aHd, null, null, null);
                            a.this.aGR.setChecked(true);
                            a.this.aGR.setCompoundDrawables(a.this.aHc, null, null, null);
                        }
                        a.this.aGL.setText(compoundButton.getText());
                    }
                }
            };
            this.aGP.setOnCheckedChangeListener(this.aGO);
            this.aGQ.setOnCheckedChangeListener(this.aGO);
            this.aGR.setOnCheckedChangeListener(this.aGO);
            this.aGY = (TextView) this.aGJ.findViewById(d.g.phone_info);
            Fy();
            this.aGK = new Dialog(this.mContext.getPageActivity(), d.l.input_username_dialog);
            this.aGK.setCanceledOnTouchOutside(false);
            this.aGK.setCancelable(false);
            this.aGK.setCanceledOnTouchOutside(false);
            Fs();
        }
        if (i == 1) {
            this.aGY.setText(d.k.tip_init_user_name);
        } else {
            this.aGY.setText(d.k.bar_friend);
        }
        if (!this.aGK.isShowing()) {
            this.aGL.setText((CharSequence) null);
            Fy();
            ga(null);
            if (!this.mContext.getPageActivity().isFinishing()) {
                this.aGK.setContentView(this.aGJ);
                g.a(this.aGK, this.mContext);
                if (this.mContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.mContext.getOrignalPage()).ShowSoftKeyPadDelay(this.aGL, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Fw() {
        String obj = this.aGL.getText().toString();
        if (obj == null || obj.length() <= 0) {
            ga(this.mContext.getString(d.k.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            ga(this.mContext.getString(d.k.input_alias_limit_length_tip));
        } else {
            if (this.aGU != null) {
                this.aGU.cancel();
            }
            if (this.aGT == null) {
                this.aGT = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.aGT.setPriority(3);
                this.aGT.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fx() {
        if (this.aHb != null) {
            this.aHb.f(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            ga(this.mContext.getString(d.k.suggest_no_name));
            return;
        }
        ga(this.mContext.getString(d.k.suggest_some_names));
        int size = arrayList.size();
        this.aGM.clearCheck();
        this.aGN.clearCheck();
        this.aGM.setVisibility(0);
        this.aGN.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aGP.setText(arrayList.get(0));
            this.aGP.setChecked(false);
            this.aGP.setCompoundDrawables(this.aHd, null, null, null);
            this.aGP.setVisibility(0);
            this.aGM.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aGQ.setText(arrayList.get(1));
            this.aGQ.setChecked(false);
            this.aGQ.setCompoundDrawables(this.aHd, null, null, null);
            this.aGQ.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aGR.setText(arrayList.get(2));
            this.aGR.setChecked(false);
            this.aGR.setCompoundDrawables(this.aHd, null, null, null);
            this.aGR.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aGT != null) {
            this.aGT.cancel();
            this.aGT = null;
        }
        if (this.aGU != null) {
            this.aGU.cancel();
            this.aGU = null;
        }
        Fz();
    }

    public void Fy() {
        this.aGM.setVisibility(8);
        this.aGM.clearCheck();
        this.aGN.setVisibility(8);
        this.aGN.clearCheck();
        this.aGP.setVisibility(8);
        this.aGQ.setVisibility(8);
        this.aGR.setVisibility(8);
        this.aGP.setChecked(false);
        this.aGQ.setChecked(false);
        this.aGR.setChecked(false);
    }

    public void Fz() {
        if (this.aGK != null && this.aGK.isShowing()) {
            g.b(this.aGK, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (str == null) {
            this.aGV.setVisibility(4);
            this.aGV.setText((CharSequence) null);
            return;
        }
        this.aGV.setVisibility(0);
        this.aGV.setText(str);
    }

    private void Fs() {
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().onModeChanged(this.aGJ);
        this.aGL.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        this.aGP.setCompoundDrawables(this.aHd, null, null, null);
        this.aGQ.setCompoundDrawables(this.aHd, null, null, null);
        this.aGR.setCompoundDrawables(this.aHd, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, h> {
        private String mAccount;
        private y mNetwork = null;
        private String mUrl;

        public c(String str, String str2) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = str;
            this.mAccount = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            a.this.aGT = null;
            a.this.aGX.setVisibility(8);
            a.this.aGW.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            a.this.aGT = null;
            a.this.aGX.setVisibility(8);
            a.this.aGW.setEnabled(true);
            if (hVar != null) {
                if (this.mNetwork.yN() == 0 && hVar.getUser().getUserName() != null) {
                    a.this.Fz();
                    l.showToast(a.this.mContext.getPageActivity(), d.k.reset_success);
                    TbadkCoreApplication.setCurrentAccount(a.this.aGZ, a.this.mContext.getPageActivity());
                    if (a.this.aHa != null) {
                        a.this.aHa.f(a.this.aGZ);
                        return;
                    }
                    return;
                }
                a.this.n(hVar.BU());
            } else if (!StringUtils.isNull(this.mNetwork.getErrorString())) {
                a.this.ga(this.mNetwork.getErrorString());
            } else if (!l.jU()) {
                l.showToast(a.this.mContext.getPageActivity(), d.k.neterror);
            } else {
                l.showToast(a.this.mContext.getPageActivity(), d.k.tip_init_name_failed);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.aGX.setVisibility(0);
            a.this.aGW.setEnabled(false);
            a.this.ga(null);
            a.this.Fy();
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
                this.mNetwork = new y(this.mUrl);
                this.mNetwork.o("un", this.mAccount);
                this.mNetwork.o("BDUSS", a.this.aGZ.getBDUSS());
                this.mNetwork.yJ().zI().arL = false;
                String yl = this.mNetwork.yl();
                if (this.mNetwork.yM()) {
                    hVar = this.mNetwork.yN();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(yl);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (a.this.aGZ != null) {
                                    a.this.aGZ.setAccount(userName);
                                    a.this.aGZ.setBDUSS(bduss);
                                    a.this.aGZ.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(a.this.aGZ);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.yN() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(yl);
                            hVar = hVar3;
                        } else if (this.mNetwork.yN() == 1) {
                            a.this.Fz();
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
        final /* synthetic */ a aHe;
        private String mAccount;
        private y mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aHe.aGU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new y(this.mUrl);
            this.mNetwork.o("un", this.mAccount);
            String yl = this.mNetwork.yl();
            if (!this.mNetwork.yM() || this.mNetwork.yN() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(yl);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.aHe.aGU = null;
            if (!this.mNetwork.yM()) {
                this.aHe.ga(this.mNetwork.getErrorString());
            } else if (this.mNetwork.yN() == 0) {
                this.aHe.ga(this.aHe.mContext.getString(d.k.name_not_use));
            } else if (this.mNetwork.yN() == 36) {
                this.aHe.ga(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.aHe.n(hVar.BU());
                }
            } else {
                this.aHe.ga(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aHe.ga(null);
            this.aHe.Fy();
            super.onPreExecute();
        }
    }
}
