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
    private TbPageContext<?> aca;
    private Drawable aws;
    private Drawable awt;
    private int size;
    private View avZ = null;
    private Dialog awa = null;
    private EditText awb = null;
    private RadioGroup awc = null;
    private RadioGroup awd = null;
    private CompoundButton.OnCheckedChangeListener awe = null;
    private RadioButton awf = null;
    private RadioButton awg = null;
    private RadioButton awh = null;
    private TextView awi = null;
    private c awj = null;
    private b awk = null;
    private TextView awl = null;
    private TextView awm = null;
    private ProgressBar awn = null;
    private TextView awo = null;
    private String mPhoneNum = null;
    private AccountData awp = null;
    private a awq = null;
    private a awr = null;

    /* loaded from: classes.dex */
    public interface a {
        void j(AccountData accountData);
    }

    public d(TbPageContext<?> tbPageContext) {
        this.aca = null;
        this.aws = null;
        this.awt = null;
        this.size = 0;
        this.aca = tbPageContext;
        this.aws = aj.getDrawable(d.f.icon_tips_names_s);
        this.awt = aj.getDrawable(d.f.icon_tips_names_n);
        this.size = this.aca.getResources().getDimensionPixelSize(d.e.ds26);
        this.aws.setBounds(0, 0, this.size, this.size);
        this.awt.setBounds(0, 0, this.size, this.size);
    }

    public void i(AccountData accountData) {
        this.awp = accountData;
    }

    public void a(a aVar) {
        this.awq = aVar;
    }

    public void b(a aVar) {
        this.awr = aVar;
    }

    public void Bc() {
        if (this.awa == null) {
            this.avZ = LayoutInflater.from(this.aca.getPageActivity()).inflate(d.h.main_input_username, (ViewGroup) null);
            this.awb = (EditText) this.avZ.findViewById(d.g.account);
            this.awb.setHint(this.aca.getString(d.j.input_alias_limit_length_tip));
            this.awi = (TextView) this.avZ.findViewById(d.g.back);
            this.awi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bg();
                    d.this.Be();
                }
            });
            this.awm = (TextView) this.avZ.findViewById(d.g.confirm);
            this.awm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Bd();
                }
            });
            this.awn = (ProgressBar) this.avZ.findViewById(d.g.confirm_progress);
            this.awl = (TextView) this.avZ.findViewById(d.g.error_info);
            this.awc = (RadioGroup) this.avZ.findViewById(d.g.names_group1);
            this.awd = (RadioGroup) this.avZ.findViewById(d.g.names_group2);
            this.awf = (RadioButton) this.avZ.findViewById(d.g.name1);
            this.awg = (RadioButton) this.avZ.findViewById(d.g.name2);
            this.awh = (RadioButton) this.avZ.findViewById(d.g.name3);
            this.awe = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.d.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == d.this.awf) {
                            d.this.awd.clearCheck();
                            d.this.awf.setChecked(true);
                            d.this.awf.setCompoundDrawables(d.this.aws, null, null, null);
                            d.this.awg.setChecked(false);
                            d.this.awg.setCompoundDrawables(d.this.awt, null, null, null);
                            d.this.awh.setChecked(false);
                            d.this.awh.setCompoundDrawables(d.this.awt, null, null, null);
                        } else if (compoundButton == d.this.awg) {
                            d.this.awd.clearCheck();
                            d.this.awf.setChecked(false);
                            d.this.awf.setCompoundDrawables(d.this.awt, null, null, null);
                            d.this.awg.setChecked(true);
                            d.this.awg.setCompoundDrawables(d.this.aws, null, null, null);
                            d.this.awh.setChecked(false);
                            d.this.awh.setCompoundDrawables(d.this.awt, null, null, null);
                        } else if (compoundButton == d.this.awh) {
                            d.this.awc.clearCheck();
                            d.this.awf.setChecked(false);
                            d.this.awf.setCompoundDrawables(d.this.awt, null, null, null);
                            d.this.awg.setChecked(false);
                            d.this.awg.setCompoundDrawables(d.this.awt, null, null, null);
                            d.this.awh.setChecked(true);
                            d.this.awh.setCompoundDrawables(d.this.aws, null, null, null);
                        }
                        d.this.awb.setText(compoundButton.getText());
                    }
                }
            };
            this.awf.setOnCheckedChangeListener(this.awe);
            this.awg.setOnCheckedChangeListener(this.awe);
            this.awh.setOnCheckedChangeListener(this.awe);
            this.awo = (TextView) this.avZ.findViewById(d.g.phone_info);
            Bf();
            this.awa = new Dialog(this.aca.getPageActivity(), d.k.input_username_dialog);
            this.awa.setCanceledOnTouchOutside(false);
            this.awa.setCancelable(false);
            this.awa.setCanceledOnTouchOutside(false);
            AY();
        }
        if (!this.awa.isShowing()) {
            this.awb.setText((CharSequence) null);
            Bf();
            fm(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.awo.setText("Hi," + this.aca.getString(d.j.bar_friend));
            } else {
                this.awo.setText("Hi," + this.mPhoneNum);
            }
            if (!this.aca.getPageActivity().isFinishing()) {
                this.awa.setContentView(this.avZ);
                g.a(this.awa, this.aca);
                if (this.aca.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.aca.getOrignalPage()).ShowSoftKeyPadDelay(this.awb, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                }
            }
        }
    }

    public void Bd() {
        String obj = this.awb.getText().toString();
        if (obj == null || obj.length() <= 0) {
            fm(this.aca.getString(d.j.input_name));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            fm(this.aca.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.awk != null) {
                this.awk.cancel();
            }
            if (this.awj == null) {
                this.awj = new c(TbConfig.SERVER_ADDRESS + TbConfig.INPUT_USERNAME_ADDRESS, obj);
                this.awj.setPriority(3);
                this.awj.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be() {
        if (this.awr != null) {
            this.awr.j(null);
        }
    }

    public void n(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            fm(this.aca.getString(d.j.suggest_no_name));
            return;
        }
        fm(this.aca.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.awc.clearCheck();
        this.awd.clearCheck();
        this.awc.setVisibility(0);
        this.awd.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.awf.setText(arrayList.get(0));
            this.awf.setChecked(false);
            this.awf.setCompoundDrawables(this.awt, null, null, null);
            this.awf.setVisibility(0);
            this.awc.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.awg.setText(arrayList.get(1));
            this.awg.setChecked(false);
            this.awg.setCompoundDrawables(this.awt, null, null, null);
            this.awg.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.awh.setText(arrayList.get(2));
            this.awh.setChecked(false);
            this.awh.setCompoundDrawables(this.awt, null, null, null);
            this.awh.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.awj != null) {
            this.awj.cancel();
            this.awj = null;
        }
        if (this.awk != null) {
            this.awk.cancel();
            this.awk = null;
        }
        Bg();
    }

    public void Bf() {
        this.awc.setVisibility(8);
        this.awc.clearCheck();
        this.awd.setVisibility(8);
        this.awd.clearCheck();
        this.awf.setVisibility(8);
        this.awg.setVisibility(8);
        this.awh.setVisibility(8);
        this.awf.setChecked(false);
        this.awg.setChecked(false);
        this.awh.setChecked(false);
    }

    public void Bg() {
        if (this.awa != null && this.awa.isShowing()) {
            g.b(this.awa, this.aca);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(String str) {
        if (str == null) {
            this.awl.setVisibility(4);
            this.awl.setText((CharSequence) null);
            return;
        }
        this.awl.setVisibility(0);
        this.awl.setText(str);
    }

    public void AY() {
        this.aca.getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.aca.getLayoutMode().t(this.avZ);
        this.awb.setHintTextColor(aj.getColor(d.C0095d.cp_cont_e));
        this.awf.setCompoundDrawables(this.awt, null, null, null);
        this.awg.setCompoundDrawables(this.awt, null, null, null);
        this.awh.setCompoundDrawables(this.awt, null, null, null);
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
            d.this.awj = null;
            d.this.awn.setVisibility(8);
            d.this.awm.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            d.this.awj = null;
            d.this.awn.setVisibility(8);
            d.this.awm.setEnabled(true);
            if (hVar == null) {
                d.this.fm(this.mNetwork.getErrorString());
            } else if (hVar.getUser().getUserName() != null) {
                d.this.Bg();
                TbadkCoreApplication.setCurrentAccount(d.this.awp, d.this.aca.getPageActivity());
                if (d.this.awq != null) {
                    d.this.awq.j(d.this.awp);
                }
            } else {
                d.this.n(hVar.xU());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            d.this.awn.setVisibility(0);
            d.this.awm.setEnabled(false);
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
                this.mNetwork.n("BDUSS", d.this.awp.getBDUSS());
                this.mNetwork.uN().vK().aiq = false;
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
                                if (d.this.awp != null) {
                                    d.this.awp.setAccount(userName);
                                    d.this.awp.setBDUSS(bduss);
                                    d.this.awp.setPortrait(hVar2.getUser().getPortrait());
                                    com.baidu.tbadk.core.a.b.b(d.this.awp);
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
        final /* synthetic */ d awu;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.awu.awk = null;
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
            this.awu.awk = null;
            if (!this.mNetwork.uQ()) {
                this.awu.fm(this.mNetwork.getErrorString());
            } else if (this.mNetwork.uR() == 0) {
                this.awu.fm(this.awu.aca.getString(d.j.name_not_use));
            } else if (this.mNetwork.uR() == 36) {
                this.awu.fm(this.mNetwork.getErrorString());
                if (hVar != null) {
                    this.awu.n(hVar.xU());
                }
            } else {
                this.awu.fm(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.awu.fm(null);
            this.awu.Bf();
            super.onPreExecute();
        }
    }
}
