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
    private boolean aJJ;
    private bb bNy;
    private final com.baidu.adp.base.d cYC;
    private com.baidu.tbadk.core.dialog.a cYr;
    private ForumManageModel cYy;
    private final com.baidu.tieba.view.a cZQ;
    private com.baidu.tbadk.core.dialog.a cZR;
    private Dialog cZS;
    private final List<a.C0334a> cZT;
    private String cZU;
    private String cZV;
    private List<BlueCheckRadioButton> cZW;
    final CompoundButton.OnCheckedChangeListener cZX;
    private final a.d cZY;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.cZU = "0";
        this.cZV = this.cZU;
        this.aJJ = false;
        this.cZX = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.cZV = (String) compoundButton.getTag();
                    if (ae.this.cZW != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.cZW) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.cZV != null && !str.equals(ae.this.cZV)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cYC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ae.this.cYy != null) {
                    switch (ae.this.cYy.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hqS != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.HZ) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.bNy.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.hqU) ? bVar.hqU : ae.this.getString(e.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.cZR == null) {
                                        ae.this.cZR = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.cZR.eB(string);
                                        ae.this.cZR.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.cZR.bf(true);
                                        ae.this.cZR.b(ae.this.mPageContext);
                                    }
                                    ae.this.cZR.BF();
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
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hqU) ? dVar.hqU : ae.this.getString(e.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hqU) ? dVar.hqU : ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.cYy.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.HZ) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.hqX);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cZY = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void hR(int i) {
                ae.this.aqv();
                if (!com.baidu.adp.lib.util.j.kV()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.bNy != null && ae.this.bNy.zG() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.bNy.zG().getUserId())) {
                            ae.this.aqy();
                        } else {
                            ae.this.kN(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.aqz();
                } else if (i == 3) {
                    ae.this.aqA();
                } else if (i == 4) {
                    ae.this.C(ae.this.cZU, true);
                } else if (i == 5) {
                    ae.this.aqB();
                }
                ae.this.kO(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cZT = new ArrayList();
        this.cZQ = new com.baidu.tieba.view.a(this.mContext);
        this.cZQ.setTitleText(getString(e.j.thread_manager, new Object[0]));
        this.cZQ.a(this.cZY);
        this.cYy = new ForumManageModel(this.mPageContext);
        this.cYy.setLoadDataCallBack(this.cYC);
        this.aJJ = z;
        setContentView(this.cZQ.bMO());
    }

    public void onChangeSkinType() {
        if (this.cZQ != null) {
            this.cZQ.onChangeSkinType();
        }
        if (this.cYr != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cYr.BG());
        }
        if (this.cZR != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cZR.BG());
        }
    }

    private void createView() {
        if (this.bNy != null && this.cZT != null && this.cZQ != null) {
            this.cZT.clear();
            this.cZT.add(new a.C0334a(1, getString(e.j.delete_page, new Object[0]), this.cZQ));
            String str = "";
            if (this.bNy.zG() != null) {
                str = this.bNy.zG().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cZT.add(new a.C0334a(2, getString(e.j.thread_forbid, new Object[0]), this.cZQ));
            }
            if (com.baidu.tieba.frs.g.aBl()) {
                this.cZT.add(new a.C0334a(3, getString(this.bNy.zB() == 1 ? e.j.cancel_top : e.j.top, new Object[0]), this.cZQ));
                this.cZT.add(new a.C0334a(4, getString(this.bNy.zC() == 1 ? e.j.cancel_good : e.j.commit_good, new Object[0]), this.cZQ));
            }
            if (com.baidu.tieba.frs.a.aAJ().aAN() && this.aJJ) {
                this.cZT.add(new a.C0334a(5, getString(e.j.multi_delete, new Object[0]), this.cZQ));
            }
            this.cZQ.ee(this.cZT);
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
        this.bNy = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqv() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void aqw() {
        if (this.cYr != null && this.cYr.isShowing()) {
            this.cYr.dismiss();
        }
    }

    public void aqx() {
        if (this.cZS != null && this.cZS.isShowing()) {
            this.cZS.dismiss();
        }
    }

    public void aqy() {
        aqw();
        if (this.mPageContext != null) {
            if (this.cYr == null) {
                this.cYr = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cYr.db(e.j.del_thread_confirm);
                this.cYr.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
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
                this.cYr.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cYr.bf(true);
                this.cYr.b(this.mPageContext);
            }
            this.cYr.BF();
        }
    }

    public void kN(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.cZQ.aky());
            AntiData aAM = com.baidu.tieba.frs.a.aAJ().aAM();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (aAM != null && aAM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aAM.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> aAL = com.baidu.tieba.frs.a.aAJ().aAL();
            for (int i3 = 0; i3 < aAL.size(); i3++) {
                jSONArray.put(aAL.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cE(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.aAJ().getForumId());
            eVar.setData(ahVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            eVar.ji("1");
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
        if (this.cZS == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.commit_good, (ViewGroup) null);
            this.cZS = new Dialog(this.mContext, e.k.common_alert_dialog);
            this.cZS.setCanceledOnTouchOutside(true);
            this.cZS.setCancelable(true);
            this.cZS.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cZS.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds540);
            this.cZS.getWindow().setAttributes(attributes);
            inflate.findViewById(e.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cZS, ae.this.mPageContext);
                }
            });
            inflate.findViewById(e.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cZS, ae.this.mPageContext);
                    ae.this.C(ae.this.cZV, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.cZS.findViewById(e.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cZS.findViewById(e.g.good_class_group);
        linearLayout.removeAllViews();
        this.cZW = new ArrayList();
        BlueCheckRadioButton bn = bn(this.cZU, getString(e.j.thread_good_class, new Object[0]));
        bn.setChecked(true);
        linearLayout.addView(bn);
        this.cZW.add(bn);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.yv()) && aaVar.yw() > 0) {
                    BlueCheckRadioButton bn2 = bn(String.valueOf(aaVar.yw()), aaVar.yv());
                    this.cZW.add(bn2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(bn2);
                    al.j(view, e.d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cZS.findViewById(e.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cZS, this.mPageContext);
    }

    private BlueCheckRadioButton bn(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cZX);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bNy != null && gVar != null && gVar.HZ) {
            String str = "";
            if (i == 2) {
                this.bNy.cS(1);
                str = aa(gVar.hqU, e.j.operation_success);
            } else if (i == 3) {
                this.bNy.cS(0);
                str = aa(gVar.hqU, e.j.operation_success);
            } else if (i == 4) {
                this.bNy.cR(1);
                str = aa(gVar.hqU, e.j.top_success);
            } else if (i == 5) {
                this.bNy.cR(0);
                str = aa(gVar.hqU, e.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bNy.getId();
            eVar.forumName = this.bNy.zM();
            eVar.forumId = String.valueOf(this.bNy.getFid());
            eVar.hqV = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hqU)) {
            string = gVar.hqU;
        } else {
            string = getString(e.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aa(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(int i) {
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
    public void aqz() {
        if (this.mContext != null && this.bNy != null && this.bNy.zG() != null) {
            String userId = this.bNy.zG().getUserId();
            String userName = this.bNy.zG().getUserName();
            String name_show = this.bNy.zG().getName_show();
            String id = this.bNy.getId();
            String zM = this.bNy.zM();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bNy.getFid()), zM, id, userId, userName, name_show, null, this.bNy.zG().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONArray jSONArray) {
        if (this.cYy != null && this.bNy != null && this.bNy.zG() != null) {
            String userId = this.bNy.zG().getUserId();
            String id = this.bNy.getId();
            String zM = this.bNy.zM();
            String valueOf = String.valueOf(this.bNy.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.cYy.vM(ao.i(jSONArray));
            }
            this.cYy.a(valueOf, zM, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, boolean z) {
        int i;
        if (this.bNy != null && this.cYy != null) {
            if (this.bNy.zC() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bNy.getId();
            String zM = this.bNy.zM();
            this.cYy.a(String.valueOf(this.bNy.getFid()), zM, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqA() {
        int i;
        if (this.bNy != null && this.cYy != null) {
            if (this.bNy.zB() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bNy.getId();
            String zM = this.bNy.zM();
            this.cYy.a(String.valueOf(this.bNy.getFid()), zM, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqB() {
        com.baidu.tieba.frs.a.aAJ().x(true, false);
        TiebaStatic.log(new am("c13125").aA("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aqw();
        aqx();
        aqv();
    }

    public void destory() {
        dismissAllDialog();
    }
}
