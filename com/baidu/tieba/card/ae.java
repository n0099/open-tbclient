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
    private boolean aKm;
    private bb bOl;
    private com.baidu.tbadk.core.dialog.a cZd;
    private ForumManageModel cZk;
    private final com.baidu.adp.base.d cZo;
    private final com.baidu.tieba.view.a daE;
    private com.baidu.tbadk.core.dialog.a daF;
    private Dialog daG;
    private final List<a.C0333a> daH;
    private String daI;
    private String daJ;
    private List<BlueCheckRadioButton> daK;
    final CompoundButton.OnCheckedChangeListener daL;
    private final a.d daM;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.daI = "0";
        this.daJ = this.daI;
        this.aKm = false;
        this.daL = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.daJ = (String) compoundButton.getTag();
                    if (ae.this.daK != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.daK) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.daJ != null && !str.equals(ae.this.daJ)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cZo = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ae.this.cZk != null) {
                    switch (ae.this.cZk.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hsb != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.HZ) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.bOl.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.hsd) ? bVar.hsd : ae.this.getString(e.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.daF == null) {
                                        ae.this.daF = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.daF.eK(string);
                                        ae.this.daF.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.daF.bg(true);
                                        ae.this.daF.b(ae.this.mPageContext);
                                    }
                                    ae.this.daF.BS();
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
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hsd) ? dVar.hsd : ae.this.getString(e.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hsd) ? dVar.hsd : ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.cZk.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.HZ) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.hsg);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.daM = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void hR(int i) {
                ae.this.aqS();
                if (!com.baidu.adp.lib.util.j.kV()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.bOl != null && ae.this.bOl.zT() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.bOl.zT().getUserId())) {
                            ae.this.aqV();
                        } else {
                            ae.this.kN(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.aqW();
                } else if (i == 3) {
                    ae.this.aqX();
                } else if (i == 4) {
                    ae.this.C(ae.this.daI, true);
                } else if (i == 5) {
                    ae.this.aqY();
                }
                ae.this.kO(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.daH = new ArrayList();
        this.daE = new com.baidu.tieba.view.a(this.mContext);
        this.daE.setTitleText(getString(e.j.thread_manager, new Object[0]));
        this.daE.a(this.daM);
        this.cZk = new ForumManageModel(this.mPageContext);
        this.cZk.setLoadDataCallBack(this.cZo);
        this.aKm = z;
        setContentView(this.daE.bNw());
    }

    public void onChangeSkinType() {
        if (this.daE != null) {
            this.daE.onChangeSkinType();
        }
        if (this.cZd != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cZd.BT());
        }
        if (this.daF != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.daF.BT());
        }
    }

    private void createView() {
        if (this.bOl != null && this.daH != null && this.daE != null) {
            this.daH.clear();
            this.daH.add(new a.C0333a(1, getString(e.j.delete_page, new Object[0]), this.daE));
            String str = "";
            if (this.bOl.zT() != null) {
                str = this.bOl.zT().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.daH.add(new a.C0333a(2, getString(e.j.thread_forbid, new Object[0]), this.daE));
            }
            if (com.baidu.tieba.frs.g.aBI()) {
                this.daH.add(new a.C0333a(3, getString(this.bOl.zO() == 1 ? e.j.cancel_top : e.j.top, new Object[0]), this.daE));
                this.daH.add(new a.C0333a(4, getString(this.bOl.zP() == 1 ? e.j.cancel_good : e.j.commit_good, new Object[0]), this.daE));
            }
            if (com.baidu.tieba.frs.a.aBg().aBk() && this.aKm) {
                this.daH.add(new a.C0333a(5, getString(e.j.multi_delete, new Object[0]), this.daE));
            }
            this.daE.ef(this.daH);
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
        this.bOl = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqS() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void aqT() {
        if (this.cZd != null && this.cZd.isShowing()) {
            this.cZd.dismiss();
        }
    }

    public void aqU() {
        if (this.daG != null && this.daG.isShowing()) {
            this.daG.dismiss();
        }
    }

    public void aqV() {
        aqT();
        if (this.mPageContext != null) {
            if (this.cZd == null) {
                this.cZd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cZd.db(e.j.del_thread_confirm);
                this.cZd.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
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
                this.cZd.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cZd.bg(true);
                this.cZd.b(this.mPageContext);
            }
            this.cZd.BS();
        }
    }

    public void kN(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.daE.akV());
            AntiData aBj = com.baidu.tieba.frs.a.aBg().aBj();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (aBj != null && aBj.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aBj.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> aBi = com.baidu.tieba.frs.a.aBg().aBi();
            for (int i3 = 0; i3 < aBi.size(); i3++) {
                jSONArray.put(aBi.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cE(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.aBg().getForumId());
            eVar.setData(ahVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            eVar.jy("1");
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
        if (this.daG == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.commit_good, (ViewGroup) null);
            this.daG = new Dialog(this.mContext, e.k.common_alert_dialog);
            this.daG.setCanceledOnTouchOutside(true);
            this.daG.setCancelable(true);
            this.daG.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.daG.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds540);
            this.daG.getWindow().setAttributes(attributes);
            inflate.findViewById(e.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.daG, ae.this.mPageContext);
                }
            });
            inflate.findViewById(e.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.daG, ae.this.mPageContext);
                    ae.this.C(ae.this.daJ, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.daG.findViewById(e.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.daG.findViewById(e.g.good_class_group);
        linearLayout.removeAllViews();
        this.daK = new ArrayList();
        BlueCheckRadioButton bo = bo(this.daI, getString(e.j.thread_good_class, new Object[0]));
        bo.setChecked(true);
        linearLayout.addView(bo);
        this.daK.add(bo);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.yI()) && aaVar.yJ() > 0) {
                    BlueCheckRadioButton bo2 = bo(String.valueOf(aaVar.yJ()), aaVar.yI());
                    this.daK.add(bo2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(bo2);
                    al.j(view, e.d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.daG.findViewById(e.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.daG, this.mPageContext);
    }

    private BlueCheckRadioButton bo(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.daL);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bOl != null && gVar != null && gVar.HZ) {
            String str = "";
            if (i == 2) {
                this.bOl.cS(1);
                str = aa(gVar.hsd, e.j.operation_success);
            } else if (i == 3) {
                this.bOl.cS(0);
                str = aa(gVar.hsd, e.j.operation_success);
            } else if (i == 4) {
                this.bOl.cR(1);
                str = aa(gVar.hsd, e.j.top_success);
            } else if (i == 5) {
                this.bOl.cR(0);
                str = aa(gVar.hsd, e.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bOl.getId();
            eVar.forumName = this.bOl.zZ();
            eVar.forumId = String.valueOf(this.bOl.getFid());
            eVar.hse = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hsd)) {
            string = gVar.hsd;
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
        TiebaStatic.log(new am("c12713").y("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqW() {
        if (this.mContext != null && this.bOl != null && this.bOl.zT() != null) {
            String userId = this.bOl.zT().getUserId();
            String userName = this.bOl.zT().getUserName();
            String name_show = this.bOl.zT().getName_show();
            String id = this.bOl.getId();
            String zZ = this.bOl.zZ();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bOl.getFid()), zZ, id, userId, userName, name_show, null, this.bOl.zT().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONArray jSONArray) {
        if (this.cZk != null && this.bOl != null && this.bOl.zT() != null) {
            String userId = this.bOl.zT().getUserId();
            String id = this.bOl.getId();
            String zZ = this.bOl.zZ();
            String valueOf = String.valueOf(this.bOl.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.cZk.wc(ao.i(jSONArray));
            }
            this.cZk.a(valueOf, zZ, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, boolean z) {
        int i;
        if (this.bOl != null && this.cZk != null) {
            if (this.bOl.zP() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bOl.getId();
            String zZ = this.bOl.zZ();
            this.cZk.a(String.valueOf(this.bOl.getFid()), zZ, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqX() {
        int i;
        if (this.bOl != null && this.cZk != null) {
            if (this.bOl.zO() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bOl.getId();
            String zZ = this.bOl.zZ();
            this.cZk.a(String.valueOf(this.bOl.getFid()), zZ, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqY() {
        com.baidu.tieba.frs.a.aBg().x(true, false);
        TiebaStatic.log(new am("c13125").aB("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aqT();
        aqU();
        aqS();
    }

    public void destory() {
        dismissAllDialog();
    }
}
