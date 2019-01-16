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
    private boolean aKl;
    private bb bOk;
    private com.baidu.tbadk.core.dialog.a cZc;
    private ForumManageModel cZj;
    private final com.baidu.adp.base.d cZn;
    private final com.baidu.tieba.view.a daD;
    private com.baidu.tbadk.core.dialog.a daE;
    private Dialog daF;
    private final List<a.C0333a> daG;
    private String daH;
    private String daI;
    private List<BlueCheckRadioButton> daJ;
    final CompoundButton.OnCheckedChangeListener daK;
    private final a.d daL;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.daH = "0";
        this.daI = this.daH;
        this.aKl = false;
        this.daK = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.daI = (String) compoundButton.getTag();
                    if (ae.this.daJ != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.daJ) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.daI != null && !str.equals(ae.this.daI)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cZn = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ae.this.cZj != null) {
                    switch (ae.this.cZj.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hsa != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.HZ) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.bOk.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.hsc) ? bVar.hsc : ae.this.getString(e.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.daE == null) {
                                        ae.this.daE = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.daE.eK(string);
                                        ae.this.daE.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.daE.bg(true);
                                        ae.this.daE.b(ae.this.mPageContext);
                                    }
                                    ae.this.daE.BS();
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
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hsc) ? dVar.hsc : ae.this.getString(e.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hsc) ? dVar.hsc : ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.cZj.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.HZ) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.hsf);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.daL = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void hR(int i) {
                ae.this.aqS();
                if (!com.baidu.adp.lib.util.j.kV()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.bOk != null && ae.this.bOk.zT() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.bOk.zT().getUserId())) {
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
                    ae.this.C(ae.this.daH, true);
                } else if (i == 5) {
                    ae.this.aqY();
                }
                ae.this.kO(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.daG = new ArrayList();
        this.daD = new com.baidu.tieba.view.a(this.mContext);
        this.daD.setTitleText(getString(e.j.thread_manager, new Object[0]));
        this.daD.a(this.daL);
        this.cZj = new ForumManageModel(this.mPageContext);
        this.cZj.setLoadDataCallBack(this.cZn);
        this.aKl = z;
        setContentView(this.daD.bNw());
    }

    public void onChangeSkinType() {
        if (this.daD != null) {
            this.daD.onChangeSkinType();
        }
        if (this.cZc != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cZc.BT());
        }
        if (this.daE != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.daE.BT());
        }
    }

    private void createView() {
        if (this.bOk != null && this.daG != null && this.daD != null) {
            this.daG.clear();
            this.daG.add(new a.C0333a(1, getString(e.j.delete_page, new Object[0]), this.daD));
            String str = "";
            if (this.bOk.zT() != null) {
                str = this.bOk.zT().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.daG.add(new a.C0333a(2, getString(e.j.thread_forbid, new Object[0]), this.daD));
            }
            if (com.baidu.tieba.frs.g.aBI()) {
                this.daG.add(new a.C0333a(3, getString(this.bOk.zO() == 1 ? e.j.cancel_top : e.j.top, new Object[0]), this.daD));
                this.daG.add(new a.C0333a(4, getString(this.bOk.zP() == 1 ? e.j.cancel_good : e.j.commit_good, new Object[0]), this.daD));
            }
            if (com.baidu.tieba.frs.a.aBg().aBk() && this.aKl) {
                this.daG.add(new a.C0333a(5, getString(e.j.multi_delete, new Object[0]), this.daD));
            }
            this.daD.ef(this.daG);
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
        this.bOk = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqS() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void aqT() {
        if (this.cZc != null && this.cZc.isShowing()) {
            this.cZc.dismiss();
        }
    }

    public void aqU() {
        if (this.daF != null && this.daF.isShowing()) {
            this.daF.dismiss();
        }
    }

    public void aqV() {
        aqT();
        if (this.mPageContext != null) {
            if (this.cZc == null) {
                this.cZc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cZc.db(e.j.del_thread_confirm);
                this.cZc.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
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
                this.cZc.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cZc.bg(true);
                this.cZc.b(this.mPageContext);
            }
            this.cZc.BS();
        }
    }

    public void kN(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.daD.akV());
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
        if (this.daF == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.commit_good, (ViewGroup) null);
            this.daF = new Dialog(this.mContext, e.k.common_alert_dialog);
            this.daF.setCanceledOnTouchOutside(true);
            this.daF.setCancelable(true);
            this.daF.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.daF.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds540);
            this.daF.getWindow().setAttributes(attributes);
            inflate.findViewById(e.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.daF, ae.this.mPageContext);
                }
            });
            inflate.findViewById(e.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.daF, ae.this.mPageContext);
                    ae.this.C(ae.this.daI, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.daF.findViewById(e.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.daF.findViewById(e.g.good_class_group);
        linearLayout.removeAllViews();
        this.daJ = new ArrayList();
        BlueCheckRadioButton bo = bo(this.daH, getString(e.j.thread_good_class, new Object[0]));
        bo.setChecked(true);
        linearLayout.addView(bo);
        this.daJ.add(bo);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.yI()) && aaVar.yJ() > 0) {
                    BlueCheckRadioButton bo2 = bo(String.valueOf(aaVar.yJ()), aaVar.yI());
                    this.daJ.add(bo2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(bo2);
                    al.j(view, e.d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.daF.findViewById(e.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.daF, this.mPageContext);
    }

    private BlueCheckRadioButton bo(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.daK);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bOk != null && gVar != null && gVar.HZ) {
            String str = "";
            if (i == 2) {
                this.bOk.cS(1);
                str = aa(gVar.hsc, e.j.operation_success);
            } else if (i == 3) {
                this.bOk.cS(0);
                str = aa(gVar.hsc, e.j.operation_success);
            } else if (i == 4) {
                this.bOk.cR(1);
                str = aa(gVar.hsc, e.j.top_success);
            } else if (i == 5) {
                this.bOk.cR(0);
                str = aa(gVar.hsc, e.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bOk.getId();
            eVar.forumName = this.bOk.zZ();
            eVar.forumId = String.valueOf(this.bOk.getFid());
            eVar.hsd = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hsc)) {
            string = gVar.hsc;
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
        if (this.mContext != null && this.bOk != null && this.bOk.zT() != null) {
            String userId = this.bOk.zT().getUserId();
            String userName = this.bOk.zT().getUserName();
            String name_show = this.bOk.zT().getName_show();
            String id = this.bOk.getId();
            String zZ = this.bOk.zZ();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bOk.getFid()), zZ, id, userId, userName, name_show, null, this.bOk.zT().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONArray jSONArray) {
        if (this.cZj != null && this.bOk != null && this.bOk.zT() != null) {
            String userId = this.bOk.zT().getUserId();
            String id = this.bOk.getId();
            String zZ = this.bOk.zZ();
            String valueOf = String.valueOf(this.bOk.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.cZj.wc(ao.i(jSONArray));
            }
            this.cZj.a(valueOf, zZ, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, boolean z) {
        int i;
        if (this.bOk != null && this.cZj != null) {
            if (this.bOk.zP() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bOk.getId();
            String zZ = this.bOk.zZ();
            this.cZj.a(String.valueOf(this.bOk.getFid()), zZ, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqX() {
        int i;
        if (this.bOk != null && this.cZj != null) {
            if (this.bOk.zO() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bOk.getId();
            String zZ = this.bOk.zZ();
            this.cZj.a(String.valueOf(this.bOk.getFid()), zZ, id, i, null);
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
