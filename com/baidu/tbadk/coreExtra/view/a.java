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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> adf;
    private Drawable ayG;
    private Drawable ayH;
    private int size;
    private View ayn = null;
    private Dialog ayo = null;
    private EditText ayp = null;
    private RadioGroup ayq = null;
    private RadioGroup ayr = null;
    private CompoundButton.OnCheckedChangeListener ays = null;
    private RadioButton ayt = null;
    private RadioButton ayu = null;
    private RadioButton ayv = null;
    private TextView ayw = null;
    private c ayx = null;
    private b ayy = null;
    private TextView ayz = null;
    private TextView ayA = null;
    private ProgressBar ayB = null;
    private TextView ayC = null;
    private String mPhoneNum = null;
    private AccountData ayD = null;
    private InterfaceC0092a ayE = null;
    private InterfaceC0092a ayF = null;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0092a {
        void i(AccountData accountData);
    }

    public a(TbPageContext<?> tbPageContext) {
        this.adf = null;
        this.ayG = null;
        this.ayH = null;
        this.size = 0;
        this.adf = tbPageContext;
        this.ayG = ak.getDrawable(d.f.icon_tips_names_s);
        this.ayH = ak.getDrawable(d.f.icon_tips_names_n);
        this.size = this.adf.getResources().getDimensionPixelSize(d.e.ds26);
        this.ayG.setBounds(0, 0, this.size, this.size);
        this.ayH.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.ayD = accountData;
    }

    public void a(InterfaceC0092a interfaceC0092a) {
        this.ayE = interfaceC0092a;
    }

    public void BU() {
        if (this.ayo == null) {
            this.ayn = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.main_input_username, (ViewGroup) null);
            this.ayp = (EditText) this.ayn.findViewById(d.g.account);
            this.ayp.setHint(this.adf.getString(d.k.input_alias_limit_length_tip));
            this.ayw = (TextView) this.ayn.findViewById(d.g.back);
            this.ayw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.BY();
                    a.this.BW();
                }
            });
            this.ayA = (TextView) this.ayn.findViewById(d.g.confirm);
            this.ayA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.BV();
                }
            });
            this.ayB = (ProgressBar) this.ayn.findViewById(d.g.confirm_progress);
            this.ayz = (TextView) this.ayn.findViewById(d.g.error_info);
            this.ayq = (RadioGroup) this.ayn.findViewById(d.g.names_group1);
            this.ayr = (RadioGroup) this.ayn.findViewById(d.g.names_group2);
            this.ayt = (RadioButton) this.ayn.findViewById(d.g.name1);
            this.ayu = (RadioButton) this.ayn.findViewById(d.g.name2);
            this.ayv = (RadioButton) this.ayn.findViewById(d.g.name3);
            this.ays = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.ayt) {
                            a.this.ayr.clearCheck();
                            a.this.ayt.setChecked(true);
                            a.this.ayt.setCompoundDrawables(a.this.ayG, null, null, null);
                            a.this.ayu.setChecked(false);
                            a.this.ayu.setCompoundDrawables(a.this.ayH, null, null, null);
                            a.this.ayv.setChecked(false);
                            a.this.ayv.setCompoundDrawables(a.this.ayH, null, null, null);
                        } else if (compoundButton == a.this.ayu) {
                            a.this.ayr.clearCheck();
                            a.this.ayt.setChecked(false);
                            a.this.ayt.setCompoundDrawables(a.this.ayH, null, null, null);
                            a.this.ayu.setChecked(true);
                            a.this.ayu.setCompoundDrawables(a.this.ayG, null, null, null);
                            a.this.ayv.setChecked(false);
                            a.this.ayv.setCompoundDrawables(a.this.ayH, null, null, null);
                        } else if (compoundButton == a.this.ayv) {
                            a.this.ayq.clearCheck();
                            a.this.ayt.setChecked(false);
                            a.this.ayt.setCompoundDrawables(a.this.ayH, null, null, null);
                            a.this.ayu.setChecked(false);
                            a.this.ayu.setCompoundDrawables(a.this.ayH, null, null, null);
                            a.this.ayv.setChecked(true);
                            a.this.ayv.setCompoundDrawables(a.this.ayG, null, null, null);
                        }
                        a.this.ayp.setText(compoundButton.getText());
                    }
                }
            };
            this.ayt.setOnCheckedChangeListener(this.ays);
            this.ayu.setOnCheckedChangeListener(this.ays);
            this.ayv.setOnCheckedChangeListener(this.ays);
            this.ayC = (TextView) this.ayn.findViewById(d.g.phone_info);
            BX();
            this.ayo = new Dialog(this.adf.getPageActivity(), d.l.input_username_dialog);
            this.ayo.setCanceledOnTouchOutside(false);
            this.ayo.setCancelable(false);
            this.ayo.setCanceledOnTouchOutside(false);
            BR();
        }
        if (!this.ayo.isShowing()) {
            this.ayp.setText((CharSequence) null);
            BX();
            fC(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.ayC.setText("Hi," + this.adf.getString(d.k.bar_friend));
            } else {
                this.ayC.setText("Hi," + this.mPhoneNum);
            }
            if (!this.adf.getPageActivity().isFinishing()) {
                this.ayo.setContentView(this.ayn);
                g.a(this.ayo, this.adf);
                if (this.adf.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.adf.getOrignalPage()).ShowSoftKeyPadDelay(this.ayp, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void BV() {
        String obj = this.ayp.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fC(this.adf.getString(d.k.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fC(this.adf.getString(d.k.input_alias_limit_length_tip));
        } else {
            if (this.ayy != null) {
                this.ayy.cancel();
            }
            if (this.ayx == null) {
                this.ayx = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.ayx.setPriority(3);
                this.ayx.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW() {
        if (this.ayF != null) {
            this.ayF.i(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fC(this.adf.getString(d.k.suggest_no_name));
            return;
        }
        fC(this.adf.getString(d.k.suggest_some_names));
        int size = arrayList.size();
        this.ayq.clearCheck();
        this.ayr.clearCheck();
        this.ayq.setVisibility(0);
        this.ayr.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.ayt.setText(arrayList.get(0));
            this.ayt.setChecked(false);
            this.ayt.setCompoundDrawables(this.ayH, null, null, null);
            this.ayt.setVisibility(0);
            this.ayq.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.ayu.setText(arrayList.get(1));
            this.ayu.setChecked(false);
            this.ayu.setCompoundDrawables(this.ayH, null, null, null);
            this.ayu.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.ayv.setText(arrayList.get(2));
            this.ayv.setChecked(false);
            this.ayv.setCompoundDrawables(this.ayH, null, null, null);
            this.ayv.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.ayx != null) {
            this.ayx.cancel();
            this.ayx = null;
        }
        if (this.ayy != null) {
            this.ayy.cancel();
            this.ayy = null;
        }
        BY();
    }

    public void BX() {
        this.ayq.setVisibility(8);
        this.ayq.clearCheck();
        this.ayr.setVisibility(8);
        this.ayr.clearCheck();
        this.ayt.setVisibility(8);
        this.ayu.setVisibility(8);
        this.ayv.setVisibility(8);
        this.ayt.setChecked(false);
        this.ayu.setChecked(false);
        this.ayv.setChecked(false);
    }

    public void BY() {
        if (this.ayo != null && this.ayo.isShowing()) {
            g.b(this.ayo, this.adf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fC(String str) {
        if (str == null) {
            this.ayz.setVisibility(4);
            this.ayz.setText((CharSequence) null);
            return;
        }
        this.ayz.setVisibility(0);
        this.ayz.setText(str);
    }

    public void BR() {
        this.adf.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.adf.getLayoutMode().u(this.ayn);
        this.ayp.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        this.ayt.setCompoundDrawables(this.ayH, null, null, null);
        this.ayu.setCompoundDrawables(this.ayH, null, null, null);
        this.ayv.setCompoundDrawables(this.ayH, null, null, null);
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
            a.this.ayx = null;
            a.this.ayB.setVisibility(8);
            a.this.ayA.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            a.this.ayx = null;
            a.this.ayB.setVisibility(8);
            a.this.ayA.setEnabled(true);
            if (hVar == null) {
                a.this.fC(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                a.this.BY();
                TbadkCoreApplication.setCurrentAccount(a.this.ayD, a.this.adf.getPageActivity());
                if (a.this.ayE != null) {
                    a.this.ayE.i(a.this.ayD);
                }
            } else {
                a.this.n(hVar.yv());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.ayB.setVisibility(0);
            a.this.ayA.setEnabled(false);
            a.this.fC(null);
            a.this.BX();
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
                this.mNetwork.n("BDUSS", a.this.ayD.getBDUSS());
                this.mNetwork.vj().wi().ajD = false;
                String uL = this.mNetwork.uL();
                if (this.mNetwork.vm()) {
                    hVar = this.mNetwork.vn();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(uL);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (a.this.ayD != null) {
                                    a.this.ayD.setAccount(userName);
                                    a.this.ayD.setBDUSS(bduss);
                                    a.this.ayD.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(a.this.ayD);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.vn() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(uL);
                            hVar = hVar3;
                        } else if (this.mNetwork.vn() == 1) {
                            a.this.BY();
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
        final /* synthetic */ a ayI;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.ayI.ayy = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uL = this.mNetwork.uL();
            if (!this.mNetwork.vm() || this.mNetwork.vn() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(uL);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.ayI.ayy = null;
            if (!this.mNetwork.vm()) {
                this.ayI.fC(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vn() == 0) {
                this.ayI.fC(this.ayI.adf.getString(d.k.name_not_use));
            } else if (this.mNetwork.vn() == 36) {
                this.ayI.fC(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.ayI.n(hVar.yv());
                }
            } else {
                this.ayI.fC(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ayI.fC(null);
            this.ayI.BX();
            super.onPreExecute();
        }
    }
}
