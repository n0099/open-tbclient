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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class ae extends com.baidu.tieba.person.e {
    private boolean ayb;
    private bc btP;
    private com.baidu.tbadk.core.dialog.a cxc;
    private ForumManageModel cxj;
    private final com.baidu.adp.base.d cxn;
    private final com.baidu.tieba.view.a cyB;
    private Dialog cyC;
    private final List<a.C0251a> cyD;
    private String cyE;
    private String cyF;
    private List<BlueCheckRadioButton> cyG;
    final CompoundButton.OnCheckedChangeListener cyH;
    private final a.d cyI;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.cyE = "0";
        this.cyF = this.cyE;
        this.ayb = false;
        this.cyH = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.cyF = (String) compoundButton.getTag();
                    if (ae.this.cyG != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.cyG) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.cyF != null && !str.equals(ae.this.cyF)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cxn = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj != null && ae.this.cxj != null) {
                    switch (ae.this.cxj.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gPr != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.Fa) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(bVar.gPt) ? bVar.gPt : ae.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.btP.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, d.k.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.Fa) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.gPt) ? dVar.gPt : ae.this.getString(d.k.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.gPt) ? dVar.gPt : ae.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.cxj.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Fa) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(d.k.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.gPw);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cyI = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void onItemClick(int i) {
                ae.this.aiC();
                if (!com.baidu.adp.lib.util.j.jD()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, d.k.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.btP != null && ae.this.btP.vw() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.btP.vw().getUserId())) {
                            ae.this.aiF();
                        } else {
                            ae.this.iJ(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.aiG();
                } else if (i == 3) {
                    ae.this.aiH();
                } else if (i == 4) {
                    ae.this.t(ae.this.cyE, true);
                } else if (i == 5) {
                    ae.this.aiI();
                }
                ae.this.iK(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cyD = new ArrayList();
        this.cyB = new com.baidu.tieba.view.a(this.mContext);
        this.cyB.setTitleText(getString(d.k.thread_manager, new Object[0]));
        this.cyB.a(this.cyI);
        this.cxj = new ForumManageModel(this.mPageContext);
        this.cxj.setLoadDataCallBack(this.cxn);
        this.ayb = z;
        setContentView(this.cyB.bFF());
    }

    public void onChangeSkinType() {
        if (this.cyB != null) {
            this.cyB.onChangeSkinType();
        }
        if (this.cxc != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cxc.xo());
        }
    }

    private void createView() {
        if (this.btP != null && this.cyD != null && this.cyB != null) {
            this.cyD.clear();
            this.cyD.add(new a.C0251a(1, getString(d.k.delete_page, new Object[0]), this.cyB));
            String str = "";
            if (this.btP.vw() != null) {
                str = this.btP.vw().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cyD.add(new a.C0251a(2, getString(d.k.thread_forbid, new Object[0]), this.cyB));
            }
            if (com.baidu.tieba.frs.g.atw()) {
                this.cyD.add(new a.C0251a(3, getString(this.btP.vr() == 1 ? d.k.cancel_top : d.k.top, new Object[0]), this.cyB));
                this.cyD.add(new a.C0251a(4, getString(this.btP.vs() == 1 ? d.k.cancel_good : d.k.commit_good, new Object[0]), this.cyB));
            }
            if (com.baidu.tieba.frs.a.asZ().atc() && this.ayb) {
                this.cyD.add(new a.C0251a(5, getString(d.k.multi_delete, new Object[0]), this.cyB));
            }
            this.cyB.dQ(this.cyD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bc bcVar) {
        this.btP = bcVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void aiD() {
        if (this.cxc != null && this.cxc.isShowing()) {
            this.cxc.dismiss();
        }
    }

    public void aiE() {
        if (this.cyC != null && this.cyC.isShowing()) {
            this.cyC.dismiss();
        }
    }

    public void aiF() {
        aiD();
        if (this.mPageContext != null) {
            if (this.cxc == null) {
                this.cxc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cxc.cd(d.k.del_thread_confirm);
                this.cxc.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.jr()) {
                            com.baidu.adp.lib.util.l.showToast(ae.this.mContext, d.k.neterror);
                        } else {
                            ae.this.g((JSONArray) null);
                        }
                    }
                });
                this.cxc.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cxc.aw(true);
                this.cxc.b(this.mPageContext);
            }
            this.cxc.xn();
        }
    }

    public void iJ(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.cyB.adO());
            AntiData Cm = com.baidu.tieba.frs.a.asZ().Cm();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (Cm != null && Cm.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Cm.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bc> atb = com.baidu.tieba.frs.a.asZ().atb();
            for (int i3 = 0; i3 < atb.size(); i3++) {
                jSONArray.put(atb.get(i3).getTid());
            }
            ai aiVar = new ai();
            aiVar.a(sparseArray);
            aiVar.bF(i);
            aiVar.c(jSONArray);
            aiVar.setFid(com.baidu.tieba.frs.a.asZ().getForumId());
            eVar.setData(aiVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(d.k.delete_thread_reason_1), getContext().getString(d.k.delete_thread_reason_2), getContext().getString(d.k.delete_thread_reason_3), getContext().getString(d.k.delete_thread_reason_4), getContext().getString(d.k.delete_thread_reason_5)});
            eVar.ib("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ae.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.jr()) {
                        com.baidu.adp.lib.util.l.showToast(ae.this.mContext, d.k.neterror);
                    } else {
                        ae.this.g(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.cyC == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.commit_good, (ViewGroup) null);
            this.cyC = new Dialog(this.mContext, d.l.common_alert_dialog);
            this.cyC.setCanceledOnTouchOutside(true);
            this.cyC.setCancelable(true);
            this.cyC.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cyC.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds540);
            this.cyC.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cyC, ae.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cyC, ae.this.mPageContext);
                    ae.this.t(ae.this.cyF, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cyC.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cyC.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cyG = new ArrayList();
        BlueCheckRadioButton aP = aP(this.cyE, getString(d.k.thread_good_class, new Object[0]));
        aP.setChecked(true);
        linearLayout.addView(aP);
        this.cyG.add(aP);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i);
                if (abVar != null && !TextUtils.isEmpty(abVar.ul()) && abVar.um() > 0) {
                    BlueCheckRadioButton aP2 = aP(String.valueOf(abVar.um()), abVar.ul());
                    this.cyG.add(aP2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aP2);
                    am.j(view, d.C0142d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cyC.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cyC, this.mPageContext);
    }

    private BlueCheckRadioButton aP(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cyH);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.btP != null && gVar != null && gVar.Fa) {
            String str = "";
            if (i == 2) {
                this.btP.bU(1);
                str = T(gVar.gPt, d.k.operation_success);
            } else if (i == 3) {
                this.btP.bU(0);
                str = T(gVar.gPt, d.k.operation_success);
            } else if (i == 4) {
                this.btP.bT(1);
                str = T(gVar.gPt, d.k.top_success);
            } else if (i == 5) {
                this.btP.bT(0);
                str = T(gVar.gPt, d.k.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.btP.getId();
            eVar.forumName = this.btP.vB();
            eVar.forumId = String.valueOf(this.btP.getFid());
            eVar.gPu = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.k.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gPt)) {
            string = gVar.gPt;
        } else {
            string = getString(d.k.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String T(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iK(int i) {
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
        TiebaStatic.log(new an("c12713").r("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiG() {
        if (this.mContext != null && this.btP != null && this.btP.vw() != null) {
            String userId = this.btP.vw().getUserId();
            String userName = this.btP.vw().getUserName();
            String name_show = this.btP.vw().getName_show();
            String id = this.btP.getId();
            String vB = this.btP.vB();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.btP.getFid()), vB, id, userId, userName, name_show, null, this.btP.vw().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONArray jSONArray) {
        if (this.cxj != null && this.btP != null && this.btP.vw() != null) {
            String userId = this.btP.vw().getUserId();
            String id = this.btP.getId();
            String vB = this.btP.vB();
            String valueOf = String.valueOf(this.btP.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.cxj.tS(ap.d(jSONArray));
            }
            this.cxj.a(valueOf, vB, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        int i;
        if (this.btP != null && this.cxj != null) {
            if (this.btP.vs() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.btP.getId();
            String vB = this.btP.vB();
            this.cxj.a(String.valueOf(this.btP.getFid()), vB, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        int i;
        if (this.btP != null && this.cxj != null) {
            if (this.btP.vr() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.btP.getId();
            String vB = this.btP.vB();
            this.cxj.a(String.valueOf(this.btP.getFid()), vB, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        com.baidu.tieba.frs.a.asZ().s(true, false);
        TiebaStatic.log(new an("c13125").ah("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aiD();
        aiE();
        aiC();
    }

    public void destory() {
        dismissAllDialog();
    }
}
