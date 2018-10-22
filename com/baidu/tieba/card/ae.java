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
    private boolean aFr;
    private bb bIV;
    private com.baidu.tbadk.core.dialog.a cNO;
    private ForumManageModel cNV;
    private final com.baidu.adp.base.d cNZ;
    private final com.baidu.tieba.view.a cPn;
    private com.baidu.tbadk.core.dialog.a cPo;
    private Dialog cPp;
    private final List<a.C0292a> cPq;
    private String cPr;
    private String cPs;
    private List<BlueCheckRadioButton> cPt;
    final CompoundButton.OnCheckedChangeListener cPu;
    private final a.d cPv;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.cPr = "0";
        this.cPs = this.cPr;
        this.aFr = false;
        this.cPu = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.cPs = (String) compoundButton.getTag();
                    if (ae.this.cPt != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.cPt) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.cPs != null && !str.equals(ae.this.cPs)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cNZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ae.this.cNV != null) {
                    switch (ae.this.cNV.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hfp != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.HV) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.bIV.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.hfr) ? bVar.hfr : ae.this.getString(e.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.cPo == null) {
                                        ae.this.cPo = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.cPo.ej(string);
                                        ae.this.cPo.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.cPo.aO(true);
                                        ae.this.cPo.b(ae.this.mPageContext);
                                    }
                                    ae.this.cPo.Au();
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
                            } else if (dVar.HV) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hfr) ? dVar.hfr : ae.this.getString(e.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hfr) ? dVar.hfr : ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.cNV.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.HV) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.hfu);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cPv = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void hp(int i) {
                ae.this.aos();
                if (!com.baidu.adp.lib.util.j.kX()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.bIV != null && ae.this.bIV.yv() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.bIV.yv().getUserId())) {
                            ae.this.aov();
                        } else {
                            ae.this.jR(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.aow();
                } else if (i == 3) {
                    ae.this.aox();
                } else if (i == 4) {
                    ae.this.A(ae.this.cPr, true);
                } else if (i == 5) {
                    ae.this.aoy();
                }
                ae.this.jS(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cPq = new ArrayList();
        this.cPn = new com.baidu.tieba.view.a(this.mContext);
        this.cPn.setTitleText(getString(e.j.thread_manager, new Object[0]));
        this.cPn.a(this.cPv);
        this.cNV = new ForumManageModel(this.mPageContext);
        this.cNV.setLoadDataCallBack(this.cNZ);
        this.aFr = z;
        setContentView(this.cPn.bKv());
    }

    public void onChangeSkinType() {
        if (this.cPn != null) {
            this.cPn.onChangeSkinType();
        }
        if (this.cNO != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cNO.Av());
        }
        if (this.cPo != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cPo.Av());
        }
    }

    private void createView() {
        if (this.bIV != null && this.cPq != null && this.cPn != null) {
            this.cPq.clear();
            this.cPq.add(new a.C0292a(1, getString(e.j.delete_page, new Object[0]), this.cPn));
            String str = "";
            if (this.bIV.yv() != null) {
                str = this.bIV.yv().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cPq.add(new a.C0292a(2, getString(e.j.thread_forbid, new Object[0]), this.cPn));
            }
            if (com.baidu.tieba.frs.g.azp()) {
                this.cPq.add(new a.C0292a(3, getString(this.bIV.yq() == 1 ? e.j.cancel_top : e.j.top, new Object[0]), this.cPn));
                this.cPq.add(new a.C0292a(4, getString(this.bIV.yr() == 1 ? e.j.cancel_good : e.j.commit_good, new Object[0]), this.cPn));
            }
            if (com.baidu.tieba.frs.a.ayN().ayR() && this.aFr) {
                this.cPq.add(new a.C0292a(5, getString(e.j.multi_delete, new Object[0]), this.cPn));
            }
            this.cPn.eb(this.cPq);
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
        this.bIV = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aos() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void aot() {
        if (this.cNO != null && this.cNO.isShowing()) {
            this.cNO.dismiss();
        }
    }

    public void aou() {
        if (this.cPp != null && this.cPp.isShowing()) {
            this.cPp.dismiss();
        }
    }

    public void aov() {
        aot();
        if (this.mPageContext != null) {
            if (this.cNO == null) {
                this.cNO = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cNO.cz(e.j.del_thread_confirm);
                this.cNO.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.kM()) {
                            com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.neterror);
                        } else {
                            ae.this.o(null);
                        }
                    }
                });
                this.cNO.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cNO.aO(true);
                this.cNO.b(this.mPageContext);
            }
            this.cNO.Au();
        }
    }

    public void jR(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.cPn.ajx());
            AntiData ayQ = com.baidu.tieba.frs.a.ayN().ayQ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ayQ != null && ayQ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayQ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> ayP = com.baidu.tieba.frs.a.ayN().ayP();
            for (int i3 = 0; i3 < ayP.size(); i3++) {
                jSONArray.put(ayP.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cb(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.ayN().getForumId());
            eVar.setData(ahVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            eVar.iN("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ae.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void k(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.kM()) {
                        com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.neterror);
                    } else {
                        ae.this.o(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.cPp == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.commit_good, (ViewGroup) null);
            this.cPp = new Dialog(this.mContext, e.k.common_alert_dialog);
            this.cPp.setCanceledOnTouchOutside(true);
            this.cPp.setCancelable(true);
            this.cPp.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cPp.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds540);
            this.cPp.getWindow().setAttributes(attributes);
            inflate.findViewById(e.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cPp, ae.this.mPageContext);
                }
            });
            inflate.findViewById(e.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cPp, ae.this.mPageContext);
                    ae.this.A(ae.this.cPs, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.cPp.findViewById(e.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cPp.findViewById(e.g.good_class_group);
        linearLayout.removeAllViews();
        this.cPt = new ArrayList();
        BlueCheckRadioButton bi = bi(this.cPr, getString(e.j.thread_good_class, new Object[0]));
        bi.setChecked(true);
        linearLayout.addView(bi);
        this.cPt.add(bi);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xj()) && aaVar.xk() > 0) {
                    BlueCheckRadioButton bi2 = bi(String.valueOf(aaVar.xk()), aaVar.xj());
                    this.cPt.add(bi2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(bi2);
                    al.j(view, e.d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cPp.findViewById(e.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cPp, this.mPageContext);
    }

    private BlueCheckRadioButton bi(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cPu);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bIV != null && gVar != null && gVar.HV) {
            String str = "";
            if (i == 2) {
                this.bIV.cq(1);
                str = Y(gVar.hfr, e.j.operation_success);
            } else if (i == 3) {
                this.bIV.cq(0);
                str = Y(gVar.hfr, e.j.operation_success);
            } else if (i == 4) {
                this.bIV.cp(1);
                str = Y(gVar.hfr, e.j.top_success);
            } else if (i == 5) {
                this.bIV.cp(0);
                str = Y(gVar.hfr, e.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bIV.getId();
            eVar.forumName = this.bIV.yB();
            eVar.forumId = String.valueOf(this.bIV.getFid());
            eVar.hfs = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hfr)) {
            string = gVar.hfr;
        } else {
            string = getString(e.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String Y(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(int i) {
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
    public void aow() {
        if (this.mContext != null && this.bIV != null && this.bIV.yv() != null) {
            String userId = this.bIV.yv().getUserId();
            String userName = this.bIV.yv().getUserName();
            String name_show = this.bIV.yv().getName_show();
            String id = this.bIV.getId();
            String yB = this.bIV.yB();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bIV.getFid()), yB, id, userId, userName, name_show, null, this.bIV.yv().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(JSONArray jSONArray) {
        if (this.cNV != null && this.bIV != null && this.bIV.yv() != null) {
            String userId = this.bIV.yv().getUserId();
            String id = this.bIV.getId();
            String yB = this.bIV.yB();
            String valueOf = String.valueOf(this.bIV.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.cNV.vd(ao.i(jSONArray));
            }
            this.cNV.a(valueOf, yB, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, boolean z) {
        int i;
        if (this.bIV != null && this.cNV != null) {
            if (this.bIV.yr() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bIV.getId();
            String yB = this.bIV.yB();
            this.cNV.a(String.valueOf(this.bIV.getFid()), yB, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aox() {
        int i;
        if (this.bIV != null && this.cNV != null) {
            if (this.bIV.yq() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bIV.getId();
            String yB = this.bIV.yB();
            this.cNV.a(String.valueOf(this.bIV.getFid()), yB, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoy() {
        com.baidu.tieba.frs.a.ayN().v(true, false);
        TiebaStatic.log(new am("c13125").ax("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aot();
        aou();
        aos();
    }

    public void destory() {
        dismissAllDialog();
    }
}
