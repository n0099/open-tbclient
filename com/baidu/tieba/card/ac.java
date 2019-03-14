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
    private boolean bSN;
    private bg bTl;
    private com.baidu.tbadk.core.dialog.a eiP;
    private ForumManageModel eiW;
    private final com.baidu.adp.base.d eja;
    private final com.baidu.tbadk.core.dialog.i ekn;
    private com.baidu.tbadk.core.dialog.a eko;
    private Dialog ekp;
    private final List<com.baidu.tbadk.core.dialog.f> ekq;
    private String ekr;
    private String eks;
    private List<BlueCheckRadioButton> ekt;
    final CompoundButton.OnCheckedChangeListener eku;
    private final i.c ekv;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.ekr = "0";
        this.eks = this.ekr;
        this.bSN = false;
        this.eku = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.eks = (String) compoundButton.getTag();
                    if (ac.this.ekt != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.ekt) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.eks != null && !str.equals(ac.this.eks)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.eja = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ac.this.eiW != null) {
                    switch (ac.this.eiW.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.eFN != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Id) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.bTl.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.iIC) ? bVar.iIC : ac.this.getString(d.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.eko == null) {
                                        ac.this.eko = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.eko.ly(string);
                                        ac.this.eko.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.eko.dq(true);
                                        ac.this.eko.b(ac.this.mPageContext);
                                    }
                                    ac.this.eko.aaZ();
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
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.iIC) ? dVar.iIC : ac.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.iIC) ? dVar.iIC : ac.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.eiW.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Id) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.I(gVar.iIF);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.ekv = new i.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.kY()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.bTl != null && ac.this.bTl.YR() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.bTl.YR().getUserId())) {
                            ac.this.aQK();
                        } else {
                            ac.this.oq(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.aQL();
                } else if (i == 3) {
                    ac.this.aQM();
                } else if (i == 4) {
                    ac.this.W(ac.this.ekr, true);
                } else if (i == 5) {
                    ac.this.aQN();
                }
                ac.this.or(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ekq = new ArrayList();
        this.ekn = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.ekn.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.ekn.a(this.ekv);
        this.eiW = new ForumManageModel(this.mPageContext);
        this.eiW.setLoadDataCallBack(this.eja);
        this.bSN = z;
        setContentView(this.ekn.abk());
    }

    public void onChangeSkinType() {
        if (this.ekn != null) {
            this.ekn.onChangeSkinType();
        }
        if (this.eiP != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eiP.aba());
        }
        if (this.eko != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eko.aba());
        }
    }

    private void createView() {
        if (this.bTl != null && this.ekq != null && this.ekn != null) {
            this.ekq.clear();
            if (!com.baidu.tieba.frs.g.bci()) {
                this.ekq.add(new com.baidu.tbadk.core.dialog.f(1, getString(d.j.delete_page, new Object[0]), this.ekn));
                String str = "";
                if (this.bTl.YR() != null) {
                    str = this.bTl.YR().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.ekq.add(new com.baidu.tbadk.core.dialog.f(2, getString(d.j.thread_forbid, new Object[0]), this.ekn));
                }
            }
            if (com.baidu.tieba.frs.g.bch() || com.baidu.tieba.frs.g.bci()) {
                this.ekq.add(new com.baidu.tbadk.core.dialog.f(3, getString(this.bTl.YM() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.ekn));
                this.ekq.add(new com.baidu.tbadk.core.dialog.f(4, getString(this.bTl.YN() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.ekn));
            }
            if (!com.baidu.tieba.frs.g.bci() && com.baidu.tieba.frs.a.bbF().bbJ() && this.bSN) {
                this.ekq.add(new com.baidu.tbadk.core.dialog.f(5, getString(d.j.multi_delete, new Object[0]), this.ekn));
            }
            this.ekn.P(this.ekq);
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
        this.bTl = bgVar;
        createView();
    }

    public void aQI() {
        if (this.eiP != null && this.eiP.isShowing()) {
            this.eiP.dismiss();
        }
    }

    public void aQJ() {
        if (this.ekp != null && this.ekp.isShowing()) {
            this.ekp.dismiss();
        }
    }

    public void aQK() {
        aQI();
        if (this.mPageContext != null) {
            if (this.eiP == null) {
                this.eiP = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.eiP.gD(d.j.del_thread_confirm);
                this.eiP.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
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
                this.eiP.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.eiP.dq(true);
                this.eiP.b(this.mPageContext);
            }
            this.eiP.aaZ();
        }
    }

    public void oq(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bbI = com.baidu.tieba.frs.a.bbF().bbI();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bbI != null && bbI.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbI.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bg> bbH = com.baidu.tieba.frs.a.bbF().bbH();
            for (int i3 = 0; i3 < bbH.size(); i3++) {
                jSONArray.put(bbH.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gg(i);
            ajVar.w(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.bbF().getForumId());
            eVar.setData(ajVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(d.j.delete_thread_reason_1), getContext().getString(d.j.delete_thread_reason_2), getContext().getString(d.j.delete_thread_reason_3), getContext().getString(d.j.delete_thread_reason_4), getContext().getString(d.j.delete_thread_reason_5)});
            eVar.qi("1");
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
        if (this.ekp == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.ekp = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.ekp.setCanceledOnTouchOutside(true);
            this.ekp.setCancelable(true);
            this.ekp.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ekp.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds540);
            this.ekp.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ekp, ac.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ekp, ac.this.mPageContext);
                    ac.this.W(ac.this.eks, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.ekp.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.ekp.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.ekt = new ArrayList();
        BlueCheckRadioButton ct = ct(this.ekr, getString(d.j.thread_good_class, new Object[0]));
        ct.setChecked(true);
        linearLayout.addView(ct);
        this.ekt.add(ct);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.Xr()) && acVar.Xs() > 0) {
                    BlueCheckRadioButton ct2 = ct(String.valueOf(acVar.Xs()), acVar.Xr());
                    this.ekt.add(ct2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(ct2);
                    al.l(view, d.C0277d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.ekp.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.ekp, this.mPageContext);
    }

    private BlueCheckRadioButton ct(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.eku);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bTl != null && gVar != null && gVar.Id) {
            String str = "";
            if (i == 2) {
                this.bTl.gu(1);
                str = au(gVar.iIC, d.j.operation_success);
            } else if (i == 3) {
                this.bTl.gu(0);
                str = au(gVar.iIC, d.j.operation_success);
            } else if (i == 4) {
                this.bTl.gt(1);
                str = au(gVar.iIC, d.j.top_success);
            } else if (i == 5) {
                this.bTl.gt(0);
                str = au(gVar.iIC, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bTl.getId();
            eVar.forumName = this.bTl.YW();
            eVar.forumId = String.valueOf(this.bTl.getFid());
            eVar.iID = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.iIC)) {
            string = gVar.iIC;
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
    public void or(int i) {
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
    public void aQL() {
        if (this.mContext != null && this.bTl != null && this.bTl.YR() != null) {
            String userId = this.bTl.YR().getUserId();
            String userName = this.bTl.YR().getUserName();
            String name_show = this.bTl.YR().getName_show();
            String id = this.bTl.getId();
            String YW = this.bTl.YW();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bTl.getFid()), YW, id, userId, userName, name_show, null, this.bTl.YR().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(JSONArray jSONArray) {
        if (this.eiW != null && this.bTl != null && this.bTl.YR() != null) {
            String userId = this.bTl.YR().getUserId();
            String id = this.bTl.getId();
            String YW = this.bTl.YW();
            String valueOf = String.valueOf(this.bTl.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.eiW.CF(ap.x(jSONArray));
            }
            this.eiW.a(valueOf, YW, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, boolean z) {
        int i;
        if (this.bTl != null && this.eiW != null) {
            if (this.bTl.YN() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bTl.getId();
            String YW = this.bTl.YW();
            this.eiW.a(String.valueOf(this.bTl.getFid()), YW, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQM() {
        int i;
        if (this.bTl != null && this.eiW != null) {
            if (this.bTl.YM() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bTl.getId();
            String YW = this.bTl.YW();
            this.eiW.a(String.valueOf(this.bTl.getFid()), YW, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQN() {
        com.baidu.tieba.frs.a.bbF().B(true, false);
        TiebaStatic.log(new am("c13125").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aQI();
        aQJ();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
