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
/* loaded from: classes2.dex */
public class ae extends com.baidu.tieba.person.e {
    private boolean aAK;
    private bb bAn;
    private ForumManageModel cFB;
    private final com.baidu.adp.base.d cFF;
    private com.baidu.tbadk.core.dialog.a cFu;
    private final com.baidu.tieba.view.a cGT;
    private com.baidu.tbadk.core.dialog.a cGU;
    private Dialog cGV;
    private final List<a.C0257a> cGW;
    private String cGX;
    private String cGY;
    private List<BlueCheckRadioButton> cGZ;
    final CompoundButton.OnCheckedChangeListener cHa;
    private final a.d cHb;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.cGX = "0";
        this.cGY = this.cGX;
        this.aAK = false;
        this.cHa = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.cGY = (String) compoundButton.getTag();
                    if (ae.this.cGZ != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.cGZ) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.cGY != null && !str.equals(ae.this.cGY)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cFF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void j(Object obj) {
                if (obj != null && ae.this.cFB != null) {
                    switch (ae.this.cFB.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gXV != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Hs) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.bAn.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.gXX) ? bVar.gXX : ae.this.getString(e.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.cGU == null) {
                                        ae.this.cGU = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.cGU.dT(string);
                                        ae.this.cGU.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.cGU.aE(true);
                                        ae.this.cGU.b(ae.this.mPageContext);
                                    }
                                    ae.this.cGU.yl();
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
                            } else if (dVar.Hs) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.gXX) ? dVar.gXX : ae.this.getString(e.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.gXX) ? dVar.gXX : ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.cFB.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Hs) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.gYa);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cHb = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void ju(int i) {
                ae.this.akP();
                if (!com.baidu.adp.lib.util.j.kK()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.bAn != null && ae.this.bAn.wm() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.bAn.wm().getUserId())) {
                            ae.this.akS();
                        } else {
                            ae.this.js(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.akT();
                } else if (i == 3) {
                    ae.this.akU();
                } else if (i == 4) {
                    ae.this.t(ae.this.cGX, true);
                } else if (i == 5) {
                    ae.this.akV();
                }
                ae.this.jt(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cGW = new ArrayList();
        this.cGT = new com.baidu.tieba.view.a(this.mContext);
        this.cGT.setTitleText(getString(e.j.thread_manager, new Object[0]));
        this.cGT.a(this.cHb);
        this.cFB = new ForumManageModel(this.mPageContext);
        this.cFB.setLoadDataCallBack(this.cFF);
        this.aAK = z;
        setContentView(this.cGT.bHj());
    }

    public void onChangeSkinType() {
        if (this.cGT != null) {
            this.cGT.onChangeSkinType();
        }
        if (this.cFu != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cFu.ym());
        }
        if (this.cGU != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cGU.ym());
        }
    }

    private void createView() {
        if (this.bAn != null && this.cGW != null && this.cGT != null) {
            this.cGW.clear();
            this.cGW.add(new a.C0257a(1, getString(e.j.delete_page, new Object[0]), this.cGT));
            String str = "";
            if (this.bAn.wm() != null) {
                str = this.bAn.wm().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cGW.add(new a.C0257a(2, getString(e.j.thread_forbid, new Object[0]), this.cGT));
            }
            if (com.baidu.tieba.frs.g.avS()) {
                this.cGW.add(new a.C0257a(3, getString(this.bAn.wh() == 1 ? e.j.cancel_top : e.j.top, new Object[0]), this.cGT));
                this.cGW.add(new a.C0257a(4, getString(this.bAn.wi() == 1 ? e.j.cancel_good : e.j.commit_good, new Object[0]), this.cGT));
            }
            if (com.baidu.tieba.frs.a.avq().avu() && this.aAK) {
                this.cGW.add(new a.C0257a(5, getString(e.j.multi_delete, new Object[0]), this.cGT));
            }
            this.cGT.dN(this.cGW);
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
        this.bAn = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akP() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void akQ() {
        if (this.cFu != null && this.cFu.isShowing()) {
            this.cFu.dismiss();
        }
    }

    public void akR() {
        if (this.cGV != null && this.cGV.isShowing()) {
            this.cGV.dismiss();
        }
    }

    public void akS() {
        akQ();
        if (this.mPageContext != null) {
            if (this.cFu == null) {
                this.cFu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cFu.cp(e.j.del_thread_confirm);
                this.cFu.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.ky()) {
                            com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.neterror);
                        } else {
                            ae.this.k((JSONArray) null);
                        }
                    }
                });
                this.cFu.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cFu.aE(true);
                this.cFu.b(this.mPageContext);
            }
            this.cFu.yl();
        }
    }

    public void js(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.cGT.afQ());
            AntiData avt = com.baidu.tieba.frs.a.avq().avt();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (avt != null && avt.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = avt.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> avs = com.baidu.tieba.frs.a.avq().avs();
            for (int i3 = 0; i3 < avs.size(); i3++) {
                jSONArray.put(avs.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.bQ(i);
            ahVar.g(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.avq().getForumId());
            eVar.setData(ahVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            eVar.iA("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ae.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void j(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.ky()) {
                        com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.neterror);
                    } else {
                        ae.this.k(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.cGV == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.commit_good, (ViewGroup) null);
            this.cGV = new Dialog(this.mContext, e.k.common_alert_dialog);
            this.cGV.setCanceledOnTouchOutside(true);
            this.cGV.setCancelable(true);
            this.cGV.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cGV.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds540);
            this.cGV.getWindow().setAttributes(attributes);
            inflate.findViewById(e.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cGV, ae.this.mPageContext);
                }
            });
            inflate.findViewById(e.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cGV, ae.this.mPageContext);
                    ae.this.t(ae.this.cGY, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.cGV.findViewById(e.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cGV.findViewById(e.g.good_class_group);
        linearLayout.removeAllViews();
        this.cGZ = new ArrayList();
        BlueCheckRadioButton aV = aV(this.cGX, getString(e.j.thread_good_class, new Object[0]));
        aV.setChecked(true);
        linearLayout.addView(aV);
        this.cGZ.add(aV);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.va()) && aaVar.vb() > 0) {
                    BlueCheckRadioButton aV2 = aV(String.valueOf(aaVar.vb()), aaVar.va());
                    this.cGZ.add(aV2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aV2);
                    al.j(view, e.d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cGV.findViewById(e.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cGV, this.mPageContext);
    }

    private BlueCheckRadioButton aV(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cHa);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bAn != null && gVar != null && gVar.Hs) {
            String str = "";
            if (i == 2) {
                this.bAn.cf(1);
                str = U(gVar.gXX, e.j.operation_success);
            } else if (i == 3) {
                this.bAn.cf(0);
                str = U(gVar.gXX, e.j.operation_success);
            } else if (i == 4) {
                this.bAn.ce(1);
                str = U(gVar.gXX, e.j.top_success);
            } else if (i == 5) {
                this.bAn.ce(0);
                str = U(gVar.gXX, e.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bAn.getId();
            eVar.forumName = this.bAn.ws();
            eVar.forumId = String.valueOf(this.bAn.getFid());
            eVar.gXY = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gXX)) {
            string = gVar.gXX;
        } else {
            string = getString(e.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String U(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jt(int i) {
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
        TiebaStatic.log(new am("c12713").w("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akT() {
        if (this.mContext != null && this.bAn != null && this.bAn.wm() != null) {
            String userId = this.bAn.wm().getUserId();
            String userName = this.bAn.wm().getUserName();
            String name_show = this.bAn.wm().getName_show();
            String id = this.bAn.getId();
            String ws = this.bAn.ws();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bAn.getFid()), ws, id, userId, userName, name_show, null, this.bAn.wm().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(JSONArray jSONArray) {
        if (this.cFB != null && this.bAn != null && this.bAn.wm() != null) {
            String userId = this.bAn.wm().getUserId();
            String id = this.bAn.getId();
            String ws = this.bAn.ws();
            String valueOf = String.valueOf(this.bAn.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.cFB.uB(ao.h(jSONArray));
            }
            this.cFB.a(valueOf, ws, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        int i;
        if (this.bAn != null && this.cFB != null) {
            if (this.bAn.wi() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bAn.getId();
            String ws = this.bAn.ws();
            this.cFB.a(String.valueOf(this.bAn.getFid()), ws, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akU() {
        int i;
        if (this.bAn != null && this.cFB != null) {
            if (this.bAn.wh() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bAn.getId();
            String ws = this.bAn.ws();
            this.cFB.a(String.valueOf(this.bAn.getFid()), ws, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akV() {
        com.baidu.tieba.frs.a.avq().u(true, false);
        TiebaStatic.log(new am("c13125").al("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        akQ();
        akR();
        akP();
    }

    public void destory() {
        dismissAllDialog();
    }
}
