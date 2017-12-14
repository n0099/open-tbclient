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
    private TbPageContext<?> abX;
    private Drawable awp;
    private Drawable awq;
    private int size;
    private View avW = null;
    private Dialog avX = null;
    private EditText avY = null;
    private RadioGroup avZ = null;
    private RadioGroup awa = null;
    private CompoundButton.OnCheckedChangeListener awb = null;
    private RadioButton awc = null;
    private RadioButton awd = null;
    private RadioButton awe = null;
    private TextView awf = null;
    private c awg = null;
    private b awh = null;
    private TextView awi = null;
    private TextView awj = null;
    private ProgressBar awk = null;
    private TextView awl = null;
    private String mPhoneNum = null;
    private AccountData awm = null;
    private a awn = null;
    private a awo = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.abX = null;
        this.awp = null;
        this.awq = null;
        this.size = 0;
        this.abX = tbPageContext;
        this.awp = aj.getDrawable(d.f.icon_tips_names_s);
        this.awq = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.abX.getResources().getDimensionPixelSize(d.e.ds26);
        this.awp.setBounds(0, 0, this.size, this.size);
        this.awq.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.awm = accountData;
    }

    public void a(a aVar) {
        this.awn = aVar;
    }

    public void b(a aVar) {
        this.awo = aVar;
    }

    public void Bc() {
        if (this.avX == null) {
            this.avW = LayoutInflater.from(this.abX.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.avY = (EditText) this.avW.findViewById(d.g.account);
            this.avY.setHint(this.abX.getString(d.j.input_alias_limit_length_tip));
            this.awf = (TextView) this.avW.findViewById(d.g.back);
            this.awf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bg();
                    d.this.Be();
                }
            });
            this.awj = (TextView) this.avW.findViewById(d.g.confirm);
            this.awj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bd();
                }
            });
            this.awk = (ProgressBar) this.avW.findViewById(d.g.confirm_progress);
            this.awi = (TextView) this.avW.findViewById(d.g.error_info);
            this.avZ = (RadioGroup) this.avW.findViewById(d.g.names_group1);
            this.awa = (RadioGroup) this.avW.findViewById(d.g.names_group2);
            this.awc = (RadioButton) this.avW.findViewById(d.g.name1);
            this.awd = (RadioButton) this.avW.findViewById(d.g.name2);
            this.awe = (RadioButton) this.avW.findViewById(d.g.name3);
            this.awb = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.awc) {
                            d.this.awa.clearCheck();
                            d.this.awc.setChecked(true);
                            d.this.awc.setCompoundDrawables(d.this.awp, null, null, null);
                            d.this.awd.setChecked(false);
                            d.this.awd.setCompoundDrawables(d.this.awq, null, null, null);
                            d.this.awe.setChecked(false);
                            d.this.awe.setCompoundDrawables(d.this.awq, null, null, null);
                        } else if (compoundButton == d.this.awd) {
                            d.this.awa.clearCheck();
                            d.this.awc.setChecked(false);
                            d.this.awc.setCompoundDrawables(d.this.awq, null, null, null);
                            d.this.awd.setChecked(true);
                            d.this.awd.setCompoundDrawables(d.this.awp, null, null, null);
                            d.this.awe.setChecked(false);
                            d.this.awe.setCompoundDrawables(d.this.awq, null, null, null);
                        } else if (compoundButton == d.this.awe) {
                            d.this.avZ.clearCheck();
                            d.this.awc.setChecked(false);
                            d.this.awc.setCompoundDrawables(d.this.awq, null, null, null);
                            d.this.awd.setChecked(false);
                            d.this.awd.setCompoundDrawables(d.this.awq, null, null, null);
                            d.this.awe.setChecked(true);
                            d.this.awe.setCompoundDrawables(d.this.awp, null, null, null);
                        }
                        d.this.avY.setText(compoundButton.getText());
                    }
                }
            };
            this.awc.setOnCheckedChangeListener(this.awb);
            this.awd.setOnCheckedChangeListener(this.awb);
            this.awe.setOnCheckedChangeListener(this.awb);
            this.awl = (TextView) this.avW.findViewById(d.g.phone_info);
            Bf();
            this.avX = new Dialog(this.abX.getPageActivity(), d.k.input_username_dialog);
            this.avX.setCanceledOnTouchOutside(false);
            this.avX.setCancelable(false);
            this.avX.setCanceledOnTouchOutside(false);
            AY();
        }
        if (!this.avX.isShowing()) {
            this.avY.setText((CharSequence) null);
            Bf();
            fm(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.awl.setText("Hi," + this.abX.getString(d.j.bar_friend));
            } else {
                this.awl.setText("Hi," + this.mPhoneNum);
            }
            if (!this.abX.getPageActivity().isFinishing()) {
                this.avX.setContentView(this.avW);
                g.a(this.avX, this.abX);
                if (this.abX.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.abX.getOrignalPage()).ShowSoftKeyPadDelay(this.avY, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bd() {
        String obj = this.avY.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fm(this.abX.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fm(this.abX.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.awh != null) {
                this.awh.cancel();
            }
            if (this.awg == null) {
                this.awg = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.awg.setPriority(3);
                this.awg.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be() {
        if (this.awo != null) {
            this.awo.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fm(this.abX.getString(d.j.suggest_no_name));
            return;
        }
        fm(this.abX.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.avZ.clearCheck();
        this.awa.clearCheck();
        this.avZ.setVisibility(0);
        this.awa.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.awc.setText(arrayList.get(0));
            this.awc.setChecked(false);
            this.awc.setCompoundDrawables(this.awq, null, null, null);
            this.awc.setVisibility(0);
            this.avZ.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.awd.setText(arrayList.get(1));
            this.awd.setChecked(false);
            this.awd.setCompoundDrawables(this.awq, null, null, null);
            this.awd.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.awe.setText(arrayList.get(2));
            this.awe.setChecked(false);
            this.awe.setCompoundDrawables(this.awq, null, null, null);
            this.awe.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.awg != null) {
            this.awg.cancel();
            this.awg = null;
        }
        if (this.awh != null) {
            this.awh.cancel();
            this.awh = null;
        }
        Bg();
    }

    public void Bf() {
        this.avZ.setVisibility(8);
        this.avZ.clearCheck();
        this.awa.setVisibility(8);
        this.awa.clearCheck();
        this.awc.setVisibility(8);
        this.awd.setVisibility(8);
        this.awe.setVisibility(8);
        this.awc.setChecked(false);
        this.awd.setChecked(false);
        this.awe.setChecked(false);
    }

    public void Bg() {
        if (this.avX != null && this.avX.isShowing()) {
            g.b(this.avX, this.abX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(String str) {
        if (str == null) {
            this.awi.setVisibility(4);
            this.awi.setText((CharSequence) null);
            return;
        }
        this.awi.setVisibility(0);
        this.awi.setText(str);
    }

    public void AY() {
        this.abX.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.abX.getLayoutMode().t(this.avW);
        this.avY.setHintTextColor(aj.getColor(d.C0096d.cp_cont_e));
        this.awc.setCompoundDrawables(this.awq, null, null, null);
        this.awd.setCompoundDrawables(this.awq, null, null, null);
        this.awe.setCompoundDrawables(this.awq, null, null, null);
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
            d.this.awg = null;
            d.this.awk.setVisibility(8);
            d.this.awj.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            d.this.awg = null;
            d.this.awk.setVisibility(8);
            d.this.awj.setEnabled(true);
            if (hVar == null) {
                d.this.fm(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                d.this.Bg();
                TbadkCoreApplication.setCurrentAccount(d.this.awm, d.this.abX.getPageActivity());
                if (d.this.awn != null) {
                    d.this.awn.j(d.this.awm);
                }
            } else {
                d.this.n(hVar.xU());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.awk.setVisibility(0);
            d.this.awj.setEnabled(false);
            d.this.fm(null);
            d.this.Bf();
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
                this.mNetwork.n("BDUSS", d.this.awm.getBDUSS());
                this.mNetwork.uN().vK().ain = false;
                String up = this.mNetwork.up();
                if (this.mNetwork.uQ()) {
                    hVar = this.mNetwork.uR();
                    try {
                        if (hVar == 0) {
                            h hVar2 = new h();
                            hVar2.parserJson(up);
                            String userName = hVar2.getUser().getUserName();
                            String bduss = hVar2.getUser().getBDUSS();
                            hVar = hVar2;
                            hVar = hVar2;
                            if (userName != null && bduss != null) {
                                hVar = hVar2;
                                if (d.this.awm != null) {
                                    d.this.awm.setAccount(userName);
                                    d.this.awm.setBDUSS(bduss);
                                    d.this.awm.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.awm);
                                    hVar = hVar2;
                                }
                            }
                        } else if (this.mNetwork.uR() == 36) {
                            h hVar3 = new h();
                            hVar3.parserJson(up);
                            hVar = hVar3;
                        } else if (this.mNetwork.uR() == 1) {
                            d.this.Bg();
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
        final /* synthetic */ d awr;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.awr.awh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public h doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.n("un", this.mAccount);
            String up = this.mNetwork.up();
            if (!this.mNetwork.uQ() || this.mNetwork.uR() != 36) {
                return null;
            }
            h hVar = new h();
            hVar.parserJson(up);
            return hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            this.awr.awh = null;
            if (!this.mNetwork.uQ()) {
                this.awr.fm(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uR() == 0) {
                this.awr.fm(this.awr.abX.getString(d.j.name_not_use));
            } else if (this.mNetwork.uR() == 36) {
                this.awr.fm(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.awr.n(hVar.xU());
                }
            } else {
                this.awr.fm(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.awr.fm(null);
            this.awr.Bf();
            super.onPreExecute();
        }
    }
}
