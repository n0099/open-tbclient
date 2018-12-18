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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes6.dex */
public class ae extends com.baidu.tieba.person.e {
    private boolean aJH;
    private bb bNv;
    private com.baidu.tbadk.core.dialog.a cVB;
    private ForumManageModel cVI;
    private final com.baidu.adp.base.d cVM;
    private final com.baidu.tieba.view.a cXa;
    private com.baidu.tbadk.core.dialog.a cXb;
    private Dialog cXc;
    private final List<a.C0334a> cXd;
    private String cXe;
    private String cXf;
    private List<BlueCheckRadioButton> cXg;
    final CompoundButton.OnCheckedChangeListener cXh;
    private final a.d cXi;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.cXe = "0";
        this.cXf = this.cXe;
        this.aJH = false;
        this.cXh = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.cXf = (String) compoundButton.getTag();
                    if (ae.this.cXg != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.cXg) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.cXf != null && !str.equals(ae.this.cXf)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cVM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ae.this.cVI != null) {
                    switch (ae.this.cVI.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hnG != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.HZ) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.bNv.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.hnI) ? bVar.hnI : ae.this.getString(e.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.cXb == null) {
                                        ae.this.cXb = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.cXb.eB(string);
                                        ae.this.cXb.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.cXb.bf(true);
                                        ae.this.cXb.b(ae.this.mPageContext);
                                    }
                                    ae.this.cXb.BF();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.HZ) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hnI) ? dVar.hnI : ae.this.getString(e.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hnI) ? dVar.hnI : ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.cVI.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.HZ) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.hnL);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cXi = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void hQ(int i) {
                ae.this.apG();
                if (!com.baidu.adp.lib.util.j.kV()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.bNv != null && ae.this.bNv.zG() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.bNv.zG().getUserId())) {
                            ae.this.apJ();
                        } else {
                            ae.this.kA(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.apK();
                } else if (i == 3) {
                    ae.this.apL();
                } else if (i == 4) {
                    ae.this.C(ae.this.cXe, true);
                } else if (i == 5) {
                    ae.this.apM();
                }
                ae.this.kB(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cXd = new ArrayList();
        this.cXa = new com.baidu.tieba.view.a(this.mContext);
        this.cXa.setTitleText(getString(e.j.thread_manager, new Object[0]));
        this.cXa.a(this.cXi);
        this.cVI = new ForumManageModel(this.mPageContext);
        this.cVI.setLoadDataCallBack(this.cVM);
        this.aJH = z;
        setContentView(this.cXa.bLY());
    }

    public void onChangeSkinType() {
        if (this.cXa != null) {
            this.cXa.onChangeSkinType();
        }
        if (this.cVB != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cVB.BG());
        }
        if (this.cXb != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cXb.BG());
        }
    }

    private void createView() {
        if (this.bNv != null && this.cXd != null && this.cXa != null) {
            this.cXd.clear();
            this.cXd.add(new a.C0334a(1, getString(e.j.delete_page, new Object[0]), this.cXa));
            String str = "";
            if (this.bNv.zG() != null) {
                str = this.bNv.zG().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cXd.add(new a.C0334a(2, getString(e.j.thread_forbid, new Object[0]), this.cXa));
            }
            if (com.baidu.tieba.frs.g.aAw()) {
                this.cXd.add(new a.C0334a(3, getString(this.bNv.zB() == 1 ? e.j.cancel_top : e.j.top, new Object[0]), this.cXa));
                this.cXd.add(new a.C0334a(4, getString(this.bNv.zC() == 1 ? e.j.cancel_good : e.j.commit_good, new Object[0]), this.cXa));
            }
            if (com.baidu.tieba.frs.a.azU().azY() && this.aJH) {
                this.cXd.add(new a.C0334a(5, getString(e.j.multi_delete, new Object[0]), this.cXa));
            }
            this.cXa.ed(this.cXd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bb bbVar) {
        this.bNv = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apG() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void apH() {
        if (this.cVB != null && this.cVB.isShowing()) {
            this.cVB.dismiss();
        }
    }

    public void apI() {
        if (this.cXc != null && this.cXc.isShowing()) {
            this.cXc.dismiss();
        }
    }

    public void apJ() {
        apH();
        if (this.mPageContext != null) {
            if (this.cVB == null) {
                this.cVB = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cVB.db(e.j.del_thread_confirm);
                this.cVB.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.kK()) {
                            com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.neterror);
                        } else {
                            ae.this.q(null);
                        }
                    }
                });
                this.cVB.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cVB.bf(true);
                this.cVB.b(this.mPageContext);
            }
            this.cVB.BF();
        }
    }

    public void kA(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.cXa.akg());
            AntiData azX = com.baidu.tieba.frs.a.azU().azX();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (azX != null && azX.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = azX.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> azW = com.baidu.tieba.frs.a.azU().azW();
            for (int i3 = 0; i3 < azW.size(); i3++) {
                jSONArray.put(azW.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cE(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.azU().getForumId());
            eVar.setData(ahVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            eVar.jh("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ae.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.neterror);
                    } else {
                        ae.this.q(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.cXc == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.commit_good, (ViewGroup) null);
            this.cXc = new Dialog(this.mContext, e.k.common_alert_dialog);
            this.cXc.setCanceledOnTouchOutside(true);
            this.cXc.setCancelable(true);
            this.cXc.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cXc.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds540);
            this.cXc.getWindow().setAttributes(attributes);
            inflate.findViewById(e.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cXc, ae.this.mPageContext);
                }
            });
            inflate.findViewById(e.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cXc, ae.this.mPageContext);
                    ae.this.C(ae.this.cXf, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.cXc.findViewById(e.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cXc.findViewById(e.g.good_class_group);
        linearLayout.removeAllViews();
        this.cXg = new ArrayList();
        BlueCheckRadioButton bn = bn(this.cXe, getString(e.j.thread_good_class, new Object[0]));
        bn.setChecked(true);
        linearLayout.addView(bn);
        this.cXg.add(bn);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.yv()) && aaVar.yw() > 0) {
                    BlueCheckRadioButton bn2 = bn(String.valueOf(aaVar.yw()), aaVar.yv());
                    this.cXg.add(bn2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(bn2);
                    al.j(view, e.d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cXc.findViewById(e.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cXc, this.mPageContext);
    }

    private BlueCheckRadioButton bn(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cXh);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bNv != null && gVar != null && gVar.HZ) {
            String str = "";
            if (i == 2) {
                this.bNv.cS(1);
                str = Z(gVar.hnI, e.j.operation_success);
            } else if (i == 3) {
                this.bNv.cS(0);
                str = Z(gVar.hnI, e.j.operation_success);
            } else if (i == 4) {
                this.bNv.cR(1);
                str = Z(gVar.hnI, e.j.top_success);
            } else if (i == 5) {
                this.bNv.cR(0);
                str = Z(gVar.hnI, e.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bNv.getId();
            eVar.forumName = this.bNv.zM();
            eVar.forumId = String.valueOf(this.bNv.getFid());
            eVar.hnJ = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hnI)) {
            string = gVar.hnI;
        } else {
            string = getString(e.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String Z(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(int i) {
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
        TiebaStatic.log(new am("c12713").x("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apK() {
        if (this.mContext != null && this.bNv != null && this.bNv.zG() != null) {
            String userId = this.bNv.zG().getUserId();
            String userName = this.bNv.zG().getUserName();
            String name_show = this.bNv.zG().getName_show();
            String id = this.bNv.getId();
            String zM = this.bNv.zM();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bNv.getFid()), zM, id, userId, userName, name_show, null, this.bNv.zG().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONArray jSONArray) {
        if (this.cVI != null && this.bNv != null && this.bNv.zG() != null) {
            String userId = this.bNv.zG().getUserId();
            String id = this.bNv.getId();
            String zM = this.bNv.zM();
            String valueOf = String.valueOf(this.bNv.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.cVI.vJ(ao.i(jSONArray));
            }
            this.cVI.a(valueOf, zM, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, boolean z) {
        int i;
        if (this.bNv != null && this.cVI != null) {
            if (this.bNv.zC() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bNv.getId();
            String zM = this.bNv.zM();
            this.cVI.a(String.valueOf(this.bNv.getFid()), zM, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apL() {
        int i;
        if (this.bNv != null && this.cVI != null) {
            if (this.bNv.zB() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bNv.getId();
            String zM = this.bNv.zM();
            this.cVI.a(String.valueOf(this.bNv.getFid()), zM, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apM() {
        com.baidu.tieba.frs.a.azU().x(true, false);
        TiebaStatic.log(new am("c13125").aA("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        apH();
        apI();
        apG();
    }

    public void destory() {
        dismissAllDialog();
    }
}
