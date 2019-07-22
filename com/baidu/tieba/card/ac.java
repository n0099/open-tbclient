package com.baidu.tieba.card;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes3.dex */
public class ac extends com.baidu.tbadk.core.dialog.i {
    private boolean cbL;
    private bg ccj;
    private com.baidu.tbadk.core.dialog.a eDo;
    private ForumManageModel eDv;
    private final com.baidu.adp.base.d eDz;
    private final com.baidu.tbadk.core.dialog.k eEL;
    private com.baidu.tbadk.core.dialog.a eEM;
    private Dialog eEN;
    private final List<com.baidu.tbadk.core.dialog.g> eEO;
    private String eEP;
    private String eEQ;
    private List<BlueCheckRadioButton> eER;
    final CompoundButton.OnCheckedChangeListener eES;
    private final k.c eET;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.eEP = "0";
        this.eEQ = this.eEP;
        this.cbL = false;
        this.eES = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.eEQ = (String) compoundButton.getTag();
                    if (ac.this.eER != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.eER) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.eEQ != null && !str.equals(ac.this.eEQ)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.eDz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ac.this.eDv != null) {
                    switch (ac.this.eDv.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.fau != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.FU) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.ccj.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.jhE) ? bVar.jhE : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.eEM == null) {
                                        ac.this.eEM = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.eEM.mO(string);
                                        ac.this.eEM.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.eEM.dQ(true);
                                        ac.this.eEM.b(ac.this.mPageContext);
                                    }
                                    ac.this.eEM.agI();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.FU) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jhE) ? dVar.jhE : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jhE) ? dVar.jhE : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.eDv.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.FU) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.M(gVar.jhH);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.eET = new k.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.kc()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.ccj != null && ac.this.ccj.aex() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.ccj.aex().getUserId())) {
                            ac.this.aZS();
                        } else {
                            ac.this.pG(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.aZT();
                } else if (i == 3) {
                    ac.this.aZU();
                } else if (i == 4) {
                    ac.this.ac(ac.this.eEP, true);
                } else if (i == 5) {
                    ac.this.aZV();
                }
                ac.this.pH(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eEO = new ArrayList();
        this.eEL = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.eEL.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.eEL.a(this.eET);
        this.eDv = new ForumManageModel(this.mPageContext);
        this.eDv.setLoadDataCallBack(this.eDz);
        this.cbL = z;
        setContentView(this.eEL.ahb());
    }

    public void onChangeSkinType() {
        if (this.eEL != null) {
            this.eEL.onChangeSkinType();
        }
        if (this.eDo != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eDo.agJ());
        }
        if (this.eEM != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eEM.agJ());
        }
    }

    private void createView() {
        if (this.ccj != null && this.eEO != null && this.eEL != null) {
            this.eEO.clear();
            if (!com.baidu.tieba.frs.g.blF()) {
                this.eEO.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.eEL));
                String str = "";
                if (this.ccj.aex() != null) {
                    str = this.ccj.aex().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.eEO.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.eEL));
                }
            }
            if (com.baidu.tieba.frs.g.blE() || com.baidu.tieba.frs.g.blF()) {
                this.eEO.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.ccj.aes() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.eEL));
                this.eEO.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.ccj.aet() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.eEL));
            }
            if (!com.baidu.tieba.frs.g.blF() && com.baidu.tieba.frs.a.bkY().bld() && this.cbL && !com.baidu.tieba.frs.a.bkY().blc()) {
                this.eEO.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.eEL));
            }
            this.eEL.W(this.eEO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bg bgVar) {
        this.ccj = bgVar;
        createView();
    }

    public void aZQ() {
        if (this.eDo != null && this.eDo.isShowing()) {
            this.eDo.dismiss();
        }
    }

    public void aZR() {
        if (this.eEN != null && this.eEN.isShowing()) {
            this.eEN.dismiss();
        }
    }

    public void aZS() {
        aZQ();
        if (this.mPageContext != null) {
            if (this.eDo == null) {
                this.eDo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.eDo.hu(R.string.del_thread_confirm);
                this.eDo.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.jQ()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.neterror);
                        } else {
                            ac.this.G(null);
                        }
                    }
                });
                this.eDo.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.eDo.dQ(true);
                this.eDo.b(this.mPageContext);
            }
            this.eDo.agI();
        }
    }

    public void pG(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData blb = com.baidu.tieba.frs.a.bkY().blb();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (blb != null && blb.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = blb.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bg> bla = com.baidu.tieba.frs.a.bkY().bla();
            for (int i3 = 0; i3 < bla.size(); i3++) {
                jSONArray.put(bla.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gW(i);
            ajVar.x(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.bkY().getForumId());
            eVar.setData(ajVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.rJ("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ac.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.jQ()) {
                        com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.neterror);
                    } else {
                        ac.this.G(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.eEN == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.eEN = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.eEN.setCanceledOnTouchOutside(true);
            this.eEN.setCancelable(true);
            this.eEN.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eEN.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds540);
            this.eEN.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.eEN, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.eEN, ac.this.mPageContext);
                    ac.this.ac(ac.this.eEQ, false);
                }
            });
        }
        com.baidu.tbadk.s.a.a(this.mPageContext, this.eEN.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.eEN.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.eER = new ArrayList();
        BlueCheckRadioButton cH = cH(this.eEP, getString(R.string.thread_good_class, new Object[0]));
        cH.setChecked(true);
        linearLayout.addView(cH);
        this.eER.add(cH);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.acX()) && acVar.acY() > 0) {
                    BlueCheckRadioButton cH2 = cH(String.valueOf(acVar.acY()), acVar.acX());
                    this.eER.add(cH2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(cH2);
                    am.l(view, R.color.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.eEN.findViewById(R.id.good_scroll);
            ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams.height = com.baidu.adp.lib.util.l.dip2px(this.mContext, 120.0f);
                    break;
                case 2:
                    layoutParams.height = com.baidu.adp.lib.util.l.dip2px(this.mContext, 186.0f);
                    break;
                default:
                    layoutParams.height = com.baidu.adp.lib.util.l.dip2px(this.mContext, 220.0f);
                    break;
            }
            scrollView.setLayoutParams(layoutParams);
            scrollView.removeAllViews();
            scrollView.addView(linearLayout);
        }
        com.baidu.adp.lib.g.g.a(this.eEN, this.mPageContext);
    }

    private BlueCheckRadioButton cH(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.eES);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.ccj != null && gVar != null && gVar.FU) {
            String str = "";
            if (i == 2) {
                this.ccj.hl(1);
                str = ar(gVar.jhE, R.string.operation_success);
            } else if (i == 3) {
                this.ccj.hl(0);
                str = ar(gVar.jhE, R.string.operation_success);
            } else if (i == 4) {
                this.ccj.hk(1);
                str = ar(gVar.jhE, R.string.top_success);
            } else if (i == 5) {
                this.ccj.hk(0);
                str = ar(gVar.jhE, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.ccj.getId();
            eVar.forumName = this.ccj.aeC();
            eVar.forumId = String.valueOf(this.ccj.getFid());
            eVar.jhF = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.jhE)) {
            string = gVar.jhE;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String ar(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pH(int i) {
        int i2 = 1;
        if (i != 1) {
            if (i == 2) {
                i2 = 2;
            } else if (i == 3) {
                i2 = 3;
            } else {
                i2 = i == 4 ? 4 : 0;
            }
        }
        TiebaStatic.log(new an("c12713").P("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZT() {
        if (this.mContext != null && this.ccj != null && this.ccj.aex() != null) {
            String userId = this.ccj.aex().getUserId();
            String userName = this.ccj.aex().getUserName();
            String name_show = this.ccj.aex().getName_show();
            String id = this.ccj.getId();
            String aeC = this.ccj.aeC();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.ccj.getFid()), aeC, id, userId, userName, name_show, null, this.ccj.aex().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(JSONArray jSONArray) {
        if (this.eDv != null && this.ccj != null && this.ccj.aex() != null) {
            String userId = this.ccj.aex().getUserId();
            String id = this.ccj.getId();
            String aeC = this.ccj.aeC();
            String valueOf = String.valueOf(this.ccj.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.eDv.EP(aq.y(jSONArray));
            }
            this.eDv.a(valueOf, aeC, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(String str, boolean z) {
        int i;
        if (this.ccj != null && this.eDv != null) {
            if (this.ccj.aet() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.ccj.getId();
            String aeC = this.ccj.aeC();
            this.eDv.a(String.valueOf(this.ccj.getFid()), aeC, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZU() {
        int i;
        if (this.ccj != null && this.eDv != null) {
            if (this.ccj.aes() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.ccj.getId();
            String aeC = this.ccj.aeC();
            this.eDv.a(String.valueOf(this.ccj.getFid()), aeC, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZV() {
        com.baidu.tieba.frs.a.bkY().D(true, false);
        TiebaStatic.log(new an("c13125").bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aZQ();
        aZR();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
