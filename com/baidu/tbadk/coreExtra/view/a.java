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
    private Drawable ayH;
    private Drawable ayI;
    private TbPageContext<?> mContext;
    private int size;
    private View ayo = null;
    private Dialog ayp = null;
    private EditText ayq = null;
    private RadioGroup ayr = null;
    private RadioGroup ays = null;
    private CompoundButton.OnCheckedChangeListener ayt = null;
    private RadioButton ayu = null;
    private RadioButton ayv = null;
    private RadioButton ayw = null;
    private TextView ayx = null;
    private c ayy = null;
    private b ayz = null;
    private TextView ayA = null;
    private TextView ayB = null;
    private ProgressBar ayC = null;
    private TextView ayD = null;
    private String mPhoneNum = null;
    private AccountData ayE = null;
    private InterfaceC0092a ayF = null;
    private InterfaceC0092a ayG = null;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0092a {
        void i(AccountData accountData);
    }

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.ayH = null;
        this.ayI = null;
        this.size = 0;
        this.mContext = tbPageContext;
        this.ayH = ak.getDrawable(d.f.icon_tips_names_s);
        this.ayI = ak.getDrawable(d.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(d.e.ds26);
        this.ayH.setBounds(0, 0, this.size, this.size);
        this.ayI.setBounds(0, 0, this.size, this.size);
    }

    public void h(AccountData accountData) {
        this.ayE = accountData;
    }

    public void a(InterfaceC0092a interfaceC0092a) {
        this.ayF = interfaceC0092a;
    }

    public void BS() {
        if (this.ayp == null) {
            this.ayo = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.main_input_username, (ViewGroup) null);
            this.ayq = (EditText) this.ayo.findViewById(d.g.account);
            this.ayq.setHint(this.mContext.getString(d.k.input_alias_limit_length_tip));
            this.ayx = (TextView) this.ayo.findViewById(d.g.back);
            this.ayx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.BW();
                    a.this.BU();
                }
            });
            this.ayB = (TextView) this.ayo.findViewById(d.g.confirm);
            this.ayB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.BT();
                }
            });
            this.ayC = (ProgressBar) this.ayo.findViewById(d.g.confirm_progress);
            this.ayA = (TextView) this.ayo.findViewById(d.g.error_info);
            this.ayr = (RadioGroup) this.ayo.findViewById(d.g.names_group1);
            this.ays = (RadioGroup) this.ayo.findViewById(d.g.names_group2);
            this.ayu = (RadioButton) this.ayo.findViewById(d.g.name1);
            this.ayv = (RadioButton) this.ayo.findViewById(d.g.name2);
            this.ayw = (RadioButton) this.ayo.findViewById(d.g.name3);
            this.ayt = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.ayu) {
                            a.this.ays.clearCheck();
                            a.this.ayu.setChecked(true);
                            a.this.ayu.setCompoundDrawables(a.this.ayH, null, null, null);
                            a.this.ayv.setChecked(false);
                            a.this.ayv.setCompoundDrawables(a.this.ayI, null, null, null);
                            a.this.ayw.setChecked(false);
                            a.this.ayw.setCompoundDrawables(a.this.ayI, null, null, null);
                        } else if (compoundButton == a.this.ayv) {
                            a.this.ays.clearCheck();
                            a.this.ayu.setChecked(false);
                            a.this.ayu.setCompoundDrawables(a.this.ayI, null, null, null);
                            a.this.ayv.setChecked(true);
                            a.this.ayv.setCompoundDrawables(a.this.ayH, null, null, null);
                            a.this.ayw.setChecked(false);
                            a.this.ayw.setCompoundDrawables(a.this.ayI, null, null, null);
                        } else if (compoundButton == a.this.ayw) {
                            a.this.ayr.clearCheck();
                            a.this.ayu.setChecked(false);
                            a.this.ayu.setCompoundDrawables(a.this.ayI, null, null, null);
                            a.this.ayv.setChecked(false);
                            a.this.ayv.setCompoundDrawables(a.this.ayI, null, null, null);
                            a.this.ayw.setChecked(true);
                            a.this.ayw.setCompoundDrawables(a.this.ayH, null, null, null);
                        }
                        a.this.ayq.setText(compoundButton.getText());
                    }
                }
            };
            this.ayu.setOnCheckedChangeListener(this.ayt);
            this.ayv.setOnCheckedChangeListener(this.ayt);
            this.ayw.setOnCheckedChangeListener(this.ayt);
            this.ayD = (TextView) this.ayo.findViewById(d.g.phone_info);
            BV();
            this.ayp = new Dialog(this.mContext.getPageActivity(), d.l.input_username_dialog);
            this.ayp.setCanceledOnTouchOutside(false);
            this.ayp.setCancelable(false);
            this.ayp.setCanceledOnTouchOutside(false);
            BP();
        }
        if (!this.ayp.isShowing()) {
            this.ayq.setText((CharSequence) null);
            BV();
            fC(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.ayD.setText("Hi," + this.mContext.getString(d.k.bar_friend));
            } else {
                this.ayD.setText("Hi," + this.mPhoneNum);
            }
            if (!this.mContext.getPageActivity().isFinishing()) {
                this.ayp.setContentView(this.ayo);
                g.a(this.ayp, this.mContext);
                if (this.mContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.mContext.getOrignalPage()).ShowSoftKeyPadDelay(this.ayq, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void BT() {
        String obj = this.ayq.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fC(this.mContext.getString(d.k.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fC(this.mContext.getString(d.k.input_alias_limit_length_tip));
        } else {
            if (this.ayz != null) {
                this.ayz.cancel();
            }
            if (this.ayy == null) {
                this.ayy = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.ayy.setPriority(3);
                this.ayy.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU() {
        if (this.ayG != null) {
            this.ayG.i(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fC(this.mContext.getString(d.k.suggest_no_name));
            return;
        }
        fC(this.mContext.getString(d.k.suggest_some_names));
        int size = arrayList.size();
        this.ayr.clearCheck();
        this.ays.clearCheck();
        this.ayr.setVisibility(0);
        this.ays.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.ayu.setText(arrayList.get(0));
            this.ayu.setChecked(false);
            this.ayu.setCompoundDrawables(this.ayI, null, null, null);
            this.ayu.setVisibility(0);
            this.ayr.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.ayv.setText(arrayList.get(1));
            this.ayv.setChecked(false);
            this.ayv.setCompoundDrawables(this.ayI, null, null, null);
            this.ayv.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.ayw.setText(arrayList.get(2));
            this.ayw.setChecked(false);
            this.ayw.setCompoundDrawables(this.ayI, null, null, null);
            this.ayw.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.ayy != null) {
            this.ayy.cancel();
            this.ayy = null;
        }
        if (this.ayz != null) {
            this.ayz.cancel();
            this.ayz = null;
        }
        BW();
    }

    public void BV() {
        this.ayr.setVisibility(8);
        this.ayr.clearCheck();
        this.ays.setVisibility(8);
        this.ays.clearCheck();
        this.ayu.setVisibility(8);
        this.ayv.setVisibility(8);
        this.ayw.setVisibility(8);
        this.ayu.setChecked(false);
        this.ayv.setChecked(false);
        this.ayw.setChecked(false);
    }

    public void BW() {
        if (this.ayp != null && this.ayp.isShowing()) {
            g.b(this.ayp, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fC(String str) {
        if (str == null) {
            this.ayA.setVisibility(4);
            this.ayA.setText((CharSequence) null);
            return;
        }
        this.ayA.setVisibility(0);
        this.ayA.setText(str);
    }

    public void BP() {
        this.mContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().u(this.ayo);
        this.ayq.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        this.ayu.setCompoundDrawables(this.ayI, null, null, null);
        this.ayv.setCompoundDrawables(this.ayI, null, null, null);
        this.ayw.setCompoundDrawables(this.ayI, null, null, null);
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
            a.this.ayy = null;
            a.this.ayC.setVisibility(8);
            a.this.ayB.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            a.this.ayy = null;
            a.this.ayC.setVisibility(8);
            a.this.ayB.setEnabled(true);
            if (hVar == null) {
                a.this.fC(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                a.this.BW();
                TbadkCoreApplication.setCurrentAccount(a.this.ayE, a.this.mContext.getPageActivity());
                if (a.this.ayF != null) {
                    a.this.ayF.i(a.this.ayE);
                }
            } else {
                a.this.n(hVar.yu());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            a.this.ayC.setVisibility(0);
            a.this.ayB.setEnabled(false);
            a.this.fC(null);
            a.this.BV();
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
                this.mNetwork.n("BDUSS", a.this.ayE.getBDUSS());
                this.mNetwork.vi().wh().ajD = false;
                String uK = this.mNetwork.uK();
                if (this.mNetwork.vl()) {
                    hVar = this.mNetwork.vm();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(uK);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (a.this.ayE != null) {
                                    a.this.ayE.setAccount(userName);
                                    a.this.ayE.setBDUSS(bduss);
                                    a.this.ayE.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(a.this.ayE);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.vm() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(uK);
                            hVar = hVar3;
                        } else if (this.mNetwork.vm() == 1) {
                            a.this.BW();
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
        final /* synthetic */ a ayJ;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.ayJ.ayz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String uK = this.mNetwork.uK();
            if (!this.mNetwork.vl() || this.mNetwork.vm() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(uK);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.ayJ.ayz = null;
            if (!this.mNetwork.vl()) {
                this.ayJ.fC(this.mNetwork.getErrorString());
            } else if (this.mNetwork.vm() == 0) {
                this.ayJ.fC(this.ayJ.mContext.getString(d.k.name_not_use));
            } else if (this.mNetwork.vm() == 36) {
                this.ayJ.fC(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.ayJ.n(hVar.yu());
                }
            } else {
                this.ayJ.fC(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ayJ.fC(null);
            this.ayJ.BV();
            super.onPreExecute();
        }
    }
}
