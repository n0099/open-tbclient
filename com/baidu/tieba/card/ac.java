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
import com.baidu.adp.base.d;
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
import com.baidu.tbadk.core.dialog.f;
import com.baidu.tbadk.core.dialog.g;
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
public class ac extends g {
    private boolean bSM;
    private bg bTk;
    private com.baidu.tbadk.core.dialog.a eiT;
    private ForumManageModel eja;
    private final d eje;
    private final com.baidu.tbadk.core.dialog.i ekr;
    private com.baidu.tbadk.core.dialog.a eks;
    private Dialog ekt;
    private final List<f> eku;
    private String ekv;
    private String ekw;
    private List<BlueCheckRadioButton> ekx;
    final CompoundButton.OnCheckedChangeListener eky;
    private final i.c ekz;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.ekv = "0";
        this.ekw = this.ekv;
        this.bSM = false;
        this.eky = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.ekw = (String) compoundButton.getTag();
                    if (ac.this.ekx != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.ekx) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.ekw != null && !str.equals(ac.this.ekw)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.eje = new d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ac.this.eja != null) {
                    switch (ac.this.eja.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.eFR != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Id) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.bTk.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.iIJ) ? bVar.iIJ : ac.this.getString(d.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.eks == null) {
                                        ac.this.eks = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.eks.ly(string);
                                        ac.this.eks.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.eks.dq(true);
                                        ac.this.eks.b(ac.this.mPageContext);
                                    }
                                    ac.this.eks.aaZ();
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
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.iIJ) ? dVar.iIJ : ac.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.iIJ) ? dVar.iIJ : ac.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.eja.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Id) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.I(gVar.iIM);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.ekz = new i.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.kY()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.bTk != null && ac.this.bTk.YR() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.bTk.YR().getUserId())) {
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
                    ac.this.V(ac.this.ekv, true);
                } else if (i == 5) {
                    ac.this.aQN();
                }
                ac.this.or(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eku = new ArrayList();
        this.ekr = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.ekr.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.ekr.a(this.ekz);
        this.eja = new ForumManageModel(this.mPageContext);
        this.eja.setLoadDataCallBack(this.eje);
        this.bSM = z;
        setContentView(this.ekr.abk());
    }

    public void onChangeSkinType() {
        if (this.ekr != null) {
            this.ekr.onChangeSkinType();
        }
        if (this.eiT != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eiT.aba());
        }
        if (this.eks != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.eks.aba());
        }
    }

    private void createView() {
        if (this.bTk != null && this.eku != null && this.ekr != null) {
            this.eku.clear();
            if (!com.baidu.tieba.frs.g.bci()) {
                this.eku.add(new f(1, getString(d.j.delete_page, new Object[0]), this.ekr));
                String str = "";
                if (this.bTk.YR() != null) {
                    str = this.bTk.YR().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.eku.add(new f(2, getString(d.j.thread_forbid, new Object[0]), this.ekr));
                }
            }
            if (com.baidu.tieba.frs.g.bch() || com.baidu.tieba.frs.g.bci()) {
                this.eku.add(new f(3, getString(this.bTk.YM() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.ekr));
                this.eku.add(new f(4, getString(this.bTk.YN() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.ekr));
            }
            if (!com.baidu.tieba.frs.g.bci() && com.baidu.tieba.frs.a.bbF().bbJ() && this.bSM) {
                this.eku.add(new f(5, getString(d.j.multi_delete, new Object[0]), this.ekr));
            }
            this.ekr.P(this.eku);
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
        this.bTk = bgVar;
        createView();
    }

    public void aQI() {
        if (this.eiT != null && this.eiT.isShowing()) {
            this.eiT.dismiss();
        }
    }

    public void aQJ() {
        if (this.ekt != null && this.ekt.isShowing()) {
            this.ekt.dismiss();
        }
    }

    public void aQK() {
        aQI();
        if (this.mPageContext != null) {
            if (this.eiT == null) {
                this.eiT = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.eiT.gD(d.j.del_thread_confirm);
                this.eiT.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
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
                this.eiT.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.eiT.dq(true);
                this.eiT.b(this.mPageContext);
            }
            this.eiT.aaZ();
        }
    }

    public void oq(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            e eVar = new e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
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
        if (this.ekt == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.ekt = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.ekt.setCanceledOnTouchOutside(true);
            this.ekt.setCancelable(true);
            this.ekt.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ekt.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds540);
            this.ekt.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ekt, ac.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ekt, ac.this.mPageContext);
                    ac.this.V(ac.this.ekw, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.ekt.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.ekt.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.ekx = new ArrayList();
        BlueCheckRadioButton ct = ct(this.ekv, getString(d.j.thread_good_class, new Object[0]));
        ct.setChecked(true);
        linearLayout.addView(ct);
        this.ekx.add(ct);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.Xr()) && acVar.Xs() > 0) {
                    BlueCheckRadioButton ct2 = ct(String.valueOf(acVar.Xs()), acVar.Xr());
                    this.ekx.add(ct2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(ct2);
                    al.l(view, d.C0236d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.ekt.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.ekt, this.mPageContext);
    }

    private BlueCheckRadioButton ct(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.eky);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bTk != null && gVar != null && gVar.Id) {
            String str = "";
            if (i == 2) {
                this.bTk.gu(1);
                str = au(gVar.iIJ, d.j.operation_success);
            } else if (i == 3) {
                this.bTk.gu(0);
                str = au(gVar.iIJ, d.j.operation_success);
            } else if (i == 4) {
                this.bTk.gt(1);
                str = au(gVar.iIJ, d.j.top_success);
            } else if (i == 5) {
                this.bTk.gt(0);
                str = au(gVar.iIJ, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bTk.getId();
            eVar.forumName = this.bTk.YW();
            eVar.forumId = String.valueOf(this.bTk.getFid());
            eVar.iIK = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.iIJ)) {
            string = gVar.iIJ;
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
        if (this.mContext != null && this.bTk != null && this.bTk.YR() != null) {
            String userId = this.bTk.YR().getUserId();
            String userName = this.bTk.YR().getUserName();
            String name_show = this.bTk.YR().getName_show();
            String id = this.bTk.getId();
            String YW = this.bTk.YW();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bTk.getFid()), YW, id, userId, userName, name_show, null, this.bTk.YR().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(JSONArray jSONArray) {
        if (this.eja != null && this.bTk != null && this.bTk.YR() != null) {
            String userId = this.bTk.YR().getUserId();
            String id = this.bTk.getId();
            String YW = this.bTk.YW();
            String valueOf = String.valueOf(this.bTk.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.eja.CG(ap.x(jSONArray));
            }
            this.eja.a(valueOf, YW, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str, boolean z) {
        int i;
        if (this.bTk != null && this.eja != null) {
            if (this.bTk.YN() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bTk.getId();
            String YW = this.bTk.YW();
            this.eja.a(String.valueOf(this.bTk.getFid()), YW, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQM() {
        int i;
        if (this.bTk != null && this.eja != null) {
            if (this.bTk.YM() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bTk.getId();
            String YW = this.bTk.YW();
            this.eja.a(String.valueOf(this.bTk.getFid()), YW, id, i, null);
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
