package com.baidu.tieba.card;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.person.e {
    private bd bXU;
    private com.baidu.tbadk.core.dialog.a cVg;
    private ForumManageModel cVn;
    private final com.baidu.adp.base.d cVr;
    private String cWA;
    private List<com.baidu.tbadk.core.view.a> cWB;
    final CompoundButton.OnCheckedChangeListener cWC;
    private final c.d cWD;
    private final com.baidu.tieba.view.c cWw;
    private Dialog cWx;
    private final List<c.a> cWy;
    private String cWz;
    private Context mContext;
    private TbPageContext mPageContext;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cWz = "0";
        this.cWA = this.cWz;
        this.cWC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.w.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    w.this.cWA = (String) compoundButton.getTag();
                    if (w.this.cWB != null) {
                        for (com.baidu.tbadk.core.view.a aVar : w.this.cWB) {
                            String str = (String) aVar.getTag();
                            if (str != null && w.this.cWA != null && !str.equals(w.this.cWA)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cVr = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.w.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj != null && w.this.cVn != null) {
                    switch (w.this.cVn.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.haU != 0) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.aov) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(bVar.haW) ? bVar.haW : w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, w.this.bXU.getId()));
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.aov) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.haW) ? dVar.haW : w.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.haW) ? dVar.haW : w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            w.this.a(w.this.cVn.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.aov) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                w.this.C(gVar.haZ);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cWD = new c.d() { // from class: com.baidu.tieba.card.w.7
            @Override // com.baidu.tieba.view.c.d
            public void lG(int i) {
                w.this.ais();
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    w.this.th();
                } else if (i == 2) {
                    w.this.akP();
                } else if (i == 3) {
                    w.this.akR();
                } else if (i == 4) {
                    w.this.y(w.this.cWz, true);
                }
                w.this.lF(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cWy = new ArrayList();
        this.cWw = new com.baidu.tieba.view.c(this.mContext);
        this.cWw.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.cWw.a(this.cWD);
        this.cVn = new ForumManageModel(this.mPageContext);
        this.cVn.setLoadDataCallBack(this.cVr);
        setContentView(this.cWw.bDV());
    }

    public void onChangeSkinType() {
        if (this.cWw != null) {
            this.cWw.onChangeSkinType();
        }
        if (this.cVg != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cVg.AC());
        }
    }

    private void createView() {
        if (this.bXU != null && this.cWy != null && this.cWw != null) {
            this.cWy.clear();
            this.cWy.add(new c.a(1, getString(d.j.delete_page, new Object[0]), this.cWw));
            String str = "";
            if (this.bXU.yT() != null) {
                str = this.bXU.yT().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cWy.add(new c.a(2, getString(d.j.thread_forbid, new Object[0]), this.cWw));
            }
            if (com.baidu.tieba.frs.f.atR()) {
                this.cWy.add(new c.a(3, getString(this.bXU.yO() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.cWw));
                this.cWy.add(new c.a(4, getString(this.bXU.yP() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.cWw));
            }
            this.cWw.dI(this.cWy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bd bdVar) {
        this.bXU = bdVar;
        createView();
    }

    public void ais() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void akN() {
        if (this.cVg != null && this.cVg.isShowing()) {
            this.cVg.dismiss();
        }
    }

    public void akO() {
        if (this.cWx != null && this.cWx.isShowing()) {
            this.cWx.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        akN();
        if (this.mPageContext != null) {
            if (this.cVg == null) {
                this.cVg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cVg.fb(d.j.del_thread_confirm);
                this.cVg.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.w.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.ox()) {
                            com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.neterror);
                        } else {
                            w.this.akQ();
                        }
                    }
                });
                this.cVg.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.w.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cVg.aW(true);
                this.cVg.b(this.mPageContext);
            }
            this.cVg.AB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<aa> arrayList) {
        if (this.cWx == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.cWx = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.cWx.setCanceledOnTouchOutside(true);
            this.cWx.setCancelable(true);
            this.cWx.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cWx.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds540);
            this.cWx.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cWx, w.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cWx, w.this.mPageContext);
                    w.this.y(w.this.cWA, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cWx.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cWx.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cWB = new ArrayList();
        com.baidu.tbadk.core.view.a aH = aH(this.cWz, getString(d.j.thread_good_class, new Object[0]));
        aH.setChecked(true);
        linearLayout.addView(aH);
        this.cWB.add(aH);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xy()) && aaVar.xz() > 0) {
                    com.baidu.tbadk.core.view.a aH2 = aH(String.valueOf(aaVar.xz()), aaVar.xy());
                    this.cWB.add(aH2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aH2);
                    aj.t(view, d.C0108d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cWx.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cWx, this.mPageContext);
    }

    private com.baidu.tbadk.core.view.a aH(String str, String str2) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cWC);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bXU != null && gVar != null && gVar.aov) {
            String str = "";
            if (i == 2) {
                this.bXU.eS(1);
                str = V(gVar.haW, d.j.operation_success);
            } else if (i == 3) {
                this.bXU.eS(0);
                str = V(gVar.haW, d.j.operation_success);
            } else if (i == 4) {
                this.bXU.eR(1);
                str = V(gVar.haW, d.j.top_success);
            } else if (i == 5) {
                this.bXU.eR(0);
                str = V(gVar.haW, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bXU.getId();
            eVar.forumName = this.bXU.yZ();
            eVar.forumId = String.valueOf(this.bXU.getFid());
            eVar.haX = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.haW)) {
            string = gVar.haW;
        } else {
            string = getString(d.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String V(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(int i) {
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
        TiebaStatic.log(new ak("c12713").s("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akP() {
        if (this.mContext != null && this.bXU != null && this.bXU.yT() != null) {
            String userId = this.bXU.yT().getUserId();
            String userName = this.bXU.yT().getUserName();
            String id = this.bXU.getId();
            String yZ = this.bXU.yZ();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.bXU.getFid()), yZ, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akQ() {
        if (this.cVn != null && this.bXU != null && this.bXU.yT() != null) {
            String userId = this.bXU.yT().getUserId();
            String id = this.bXU.getId();
            String yZ = this.bXU.yZ();
            this.cVn.a(String.valueOf(this.bXU.getFid()), yZ, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        int i;
        if (this.bXU != null && this.cVn != null) {
            if (this.bXU.yP() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bXU.getId();
            String yZ = this.bXU.yZ();
            this.cVn.a(String.valueOf(this.bXU.getFid()), yZ, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akR() {
        int i;
        if (this.bXU != null && this.cVn != null) {
            if (this.bXU.yO() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bXU.getId();
            String yZ = this.bXU.yZ();
            this.cVn.a(String.valueOf(this.bXU.getFid()), yZ, id, i, null);
        }
    }

    public void dismissAllDialog() {
        akN();
        akO();
        ais();
    }

    public void destory() {
        dismissAllDialog();
    }
}
