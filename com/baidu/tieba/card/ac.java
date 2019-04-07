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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes3.dex */
public class ac extends com.baidu.tbadk.core.dialog.g {
    private boolean bSP;
    private bg bTn;
    private com.baidu.tbadk.core.dialog.a eiB;
    private ForumManageModel eiI;
    private final com.baidu.adp.base.d eiM;
    private final com.baidu.tbadk.core.dialog.i ejZ;
    private com.baidu.tbadk.core.dialog.a eka;
    private Dialog ekb;
    private final List<com.baidu.tbadk.core.dialog.f> ekc;
    private String ekd;
    private String eke;
    private List<BlueCheckRadioButton> ekf;
    final CompoundButton.OnCheckedChangeListener ekg;
    private final i.c ekh;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.ekd = "0";
        this.eke = this.ekd;
        this.bSP = false;
        this.ekg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.eke = (String) compoundButton.getTag();
                    if (ac.this.ekf != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.ekf) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.eke != null && !str.equals(ac.this.eke)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.eiM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ac.this.eiI != null) {
                    switch (ac.this.eiI.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.eFy != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Id) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.bTn.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.iIn) ? bVar.iIn : ac.this.getString(d.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.eka == null) {
                                        ac.this.eka = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.eka.lz(string);
                                        ac.this.eka.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.eka.dq(true);
                                        ac.this.eka.b(ac.this.mPageContext);
                                    }
                                    ac.this.eka.aaW();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.Id) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.iIn) ? dVar.iIn : ac.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.iIn) ? dVar.iIn : ac.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.eiI.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Id) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.I(gVar.iIq);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.ekh = new i.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.kY()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.bTn != null && ac.this.bTn.YO() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.bTn.YO().getUserId())) {
                            ac.this.aQI();
                        } else {
                            ac.this.om(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.aQJ();
                } else if (i == 3) {
                    ac.this.aQK();
                } else if (i == 4) {
                    ac.this.W(ac.this.ekd, true);
                } else if (i == 5) {
                    ac.this.aQL();
                }
                ac.this.on(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ekc = new ArrayList();
        this.ejZ = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.ejZ.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.ejZ.a(this.ekh);
        this.eiI = new ForumManageModel(this.mPageContext);
        this.eiI.setLoadDataCallBack(this.eiM);
        this.bSP = z;
        setContentView(this.ejZ.abh());
    }

    public void onChangeSkinType() {
        if (this.ejZ != null) {
            this.ejZ.onChangeSkinType();
        }
        if (this.eiB != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eiB.aaX());
        }
        if (this.eka != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eka.aaX());
        }
    }

    private void createView() {
        if (this.bTn != null && this.ekc != null && this.ejZ != null) {
            this.ekc.clear();
            if (!com.baidu.tieba.frs.g.bcg()) {
                this.ekc.add(new com.baidu.tbadk.core.dialog.f(1, getString(d.j.delete_page, new Object[0]), this.ejZ));
                String str = "";
                if (this.bTn.YO() != null) {
                    str = this.bTn.YO().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.ekc.add(new com.baidu.tbadk.core.dialog.f(2, getString(d.j.thread_forbid, new Object[0]), this.ejZ));
                }
            }
            if (com.baidu.tieba.frs.g.bcf() || com.baidu.tieba.frs.g.bcg()) {
                this.ekc.add(new com.baidu.tbadk.core.dialog.f(3, getString(this.bTn.YJ() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.ejZ));
                this.ekc.add(new com.baidu.tbadk.core.dialog.f(4, getString(this.bTn.YK() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.ejZ));
            }
            if (!com.baidu.tieba.frs.g.bcg() && com.baidu.tieba.frs.a.bbD().bbH() && this.bSP) {
                this.ekc.add(new com.baidu.tbadk.core.dialog.f(5, getString(d.j.multi_delete, new Object[0]), this.ejZ));
            }
            this.ejZ.P(this.ekc);
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
        this.bTn = bgVar;
        createView();
    }

    public void aQG() {
        if (this.eiB != null && this.eiB.isShowing()) {
            this.eiB.dismiss();
        }
    }

    public void aQH() {
        if (this.ekb != null && this.ekb.isShowing()) {
            this.ekb.dismiss();
        }
    }

    public void aQI() {
        aQG();
        if (this.mPageContext != null) {
            if (this.eiB == null) {
                this.eiB = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.eiB.gC(d.j.del_thread_confirm);
                this.eiB.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.kM()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.j.neterror);
                        } else {
                            ac.this.F(null);
                        }
                    }
                });
                this.eiB.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.eiB.dq(true);
                this.eiB.b(this.mPageContext);
            }
            this.eiB.aaW();
        }
    }

    public void om(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bbG = com.baidu.tieba.frs.a.bbD().bbG();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bbG != null && bbG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbG.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bg> bbF = com.baidu.tieba.frs.a.bbD().bbF();
            for (int i3 = 0; i3 < bbF.size(); i3++) {
                jSONArray.put(bbF.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gf(i);
            ajVar.w(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.bbD().getForumId());
            eVar.setData(ajVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(d.j.delete_thread_reason_1), getContext().getString(d.j.delete_thread_reason_2), getContext().getString(d.j.delete_thread_reason_3), getContext().getString(d.j.delete_thread_reason_4), getContext().getString(d.j.delete_thread_reason_5)});
            eVar.qj("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ac.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.j.neterror);
                    } else {
                        ac.this.F(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.ekb == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.ekb = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.ekb.setCanceledOnTouchOutside(true);
            this.ekb.setCancelable(true);
            this.ekb.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ekb.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds540);
            this.ekb.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ekb, ac.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ekb, ac.this.mPageContext);
                    ac.this.W(ac.this.eke, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.ekb.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.ekb.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.ekf = new ArrayList();
        BlueCheckRadioButton cu = cu(this.ekd, getString(d.j.thread_good_class, new Object[0]));
        cu.setChecked(true);
        linearLayout.addView(cu);
        this.ekf.add(cu);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.Xo()) && acVar.Xp() > 0) {
                    BlueCheckRadioButton cu2 = cu(String.valueOf(acVar.Xp()), acVar.Xo());
                    this.ekf.add(cu2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(cu2);
                    al.l(view, d.C0277d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.ekb.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.ekb, this.mPageContext);
    }

    private BlueCheckRadioButton cu(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.ekg);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bTn != null && gVar != null && gVar.Id) {
            String str = "";
            if (i == 2) {
                this.bTn.gt(1);
                str = au(gVar.iIn, d.j.operation_success);
            } else if (i == 3) {
                this.bTn.gt(0);
                str = au(gVar.iIn, d.j.operation_success);
            } else if (i == 4) {
                this.bTn.gs(1);
                str = au(gVar.iIn, d.j.top_success);
            } else if (i == 5) {
                this.bTn.gs(0);
                str = au(gVar.iIn, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bTn.getId();
            eVar.forumName = this.bTn.YT();
            eVar.forumId = String.valueOf(this.bTn.getFid());
            eVar.iIo = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.iIn)) {
            string = gVar.iIn;
        } else {
            string = getString(d.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String au(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
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
        TiebaStatic.log(new am("c12713").T("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQJ() {
        if (this.mContext != null && this.bTn != null && this.bTn.YO() != null) {
            String userId = this.bTn.YO().getUserId();
            String userName = this.bTn.YO().getUserName();
            String name_show = this.bTn.YO().getName_show();
            String id = this.bTn.getId();
            String YT = this.bTn.YT();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bTn.getFid()), YT, id, userId, userName, name_show, null, this.bTn.YO().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(JSONArray jSONArray) {
        if (this.eiI != null && this.bTn != null && this.bTn.YO() != null) {
            String userId = this.bTn.YO().getUserId();
            String id = this.bTn.getId();
            String YT = this.bTn.YT();
            String valueOf = String.valueOf(this.bTn.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.eiI.CE(ap.x(jSONArray));
            }
            this.eiI.a(valueOf, YT, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, boolean z) {
        int i;
        if (this.bTn != null && this.eiI != null) {
            if (this.bTn.YK() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bTn.getId();
            String YT = this.bTn.YT();
            this.eiI.a(String.valueOf(this.bTn.getFid()), YT, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        int i;
        if (this.bTn != null && this.eiI != null) {
            if (this.bTn.YJ() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bTn.getId();
            String YT = this.bTn.YT();
            this.eiI.a(String.valueOf(this.bTn.getFid()), YT, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQL() {
        com.baidu.tieba.frs.a.bbD().z(true, false);
        TiebaStatic.log(new am("c13125").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aQG();
        aQH();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
