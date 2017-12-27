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
import com.baidu.tbadk.core.data.be;
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
    private be bXF;
    private com.baidu.tbadk.core.dialog.a cQj;
    private ForumManageModel cQq;
    private final com.baidu.adp.base.d cQu;
    private Dialog cRA;
    private final List<c.a> cRB;
    private String cRC;
    private String cRD;
    private List<com.baidu.tbadk.core.view.a> cRE;
    final CompoundButton.OnCheckedChangeListener cRF;
    private final c.d cRG;
    private final com.baidu.tieba.view.c cRz;
    private Context mContext;
    private TbPageContext mPageContext;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cRC = "0";
        this.cRD = this.cRC;
        this.cRF = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.w.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    w.this.cRD = (String) compoundButton.getTag();
                    if (w.this.cRE != null) {
                        for (com.baidu.tbadk.core.view.a aVar : w.this.cRE) {
                            String str = (String) aVar.getTag();
                            if (str != null && w.this.cRD != null && !str.equals(w.this.cRD)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cQu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.w.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj != null && w.this.cQq != null) {
                    switch (w.this.cQq.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hkZ != 0) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.aot) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(bVar.hlb) ? bVar.hlb : w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, w.this.bXF.getId()));
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.aot) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.hlb) ? dVar.hlb : w.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.hlb) ? dVar.hlb : w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            w.this.a(w.this.cQq.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.aot) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                w.this.C(gVar.hle);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cRG = new c.d() { // from class: com.baidu.tieba.card.w.7
            @Override // com.baidu.tieba.view.c.d
            public void lD(int i) {
                w.this.ajE();
                if (!com.baidu.adp.lib.util.j.oI()) {
                    com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    w.this.tg();
                } else if (i == 2) {
                    w.this.ajH();
                } else if (i == 3) {
                    w.this.ajJ();
                } else if (i == 4) {
                    w.this.y(w.this.cRC, true);
                }
                w.this.lC(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cRB = new ArrayList();
        this.cRz = new com.baidu.tieba.view.c(this.mContext);
        this.cRz.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.cRz.a(this.cRG);
        this.cQq = new ForumManageModel(this.mPageContext);
        this.cQq.setLoadDataCallBack(this.cQu);
        setContentView(this.cRz.bKt());
    }

    public void onChangeSkinType() {
        if (this.cRz != null) {
            this.cRz.onChangeSkinType();
        }
        if (this.cQj != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cQj.AJ());
        }
    }

    private void createView() {
        if (this.bXF != null && this.cRB != null && this.cRz != null) {
            this.cRB.clear();
            this.cRB.add(new c.a(1, getString(d.j.delete_page, new Object[0]), this.cRz));
            String str = "";
            if (this.bXF.yX() != null) {
                str = this.bXF.yX().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cRB.add(new c.a(2, getString(d.j.thread_forbid, new Object[0]), this.cRz));
            }
            if (com.baidu.tieba.frs.f.asJ()) {
                this.cRB.add(new c.a(3, getString(this.bXF.yS() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.cRz));
                this.cRB.add(new c.a(4, getString(this.bXF.yT() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.cRz));
            }
            this.cRz.dZ(this.cRB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(be beVar) {
        this.bXF = beVar;
        createView();
    }

    public void ajE() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void ajF() {
        if (this.cQj != null && this.cQj.isShowing()) {
            this.cQj.dismiss();
        }
    }

    public void ajG() {
        if (this.cRA != null && this.cRA.isShowing()) {
            this.cRA.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        ajF();
        if (this.mPageContext != null) {
            if (this.cQj == null) {
                this.cQj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cQj.fd(d.j.del_thread_confirm);
                this.cQj.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.w.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.ow()) {
                            com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.neterror);
                        } else {
                            w.this.ajI();
                        }
                    }
                });
                this.cQj.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.w.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cQj.aV(true);
                this.cQj.b(this.mPageContext);
            }
            this.cQj.AI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<aa> arrayList) {
        if (this.cRA == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.cRA = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.cRA.setCanceledOnTouchOutside(true);
            this.cRA.setCancelable(true);
            this.cRA.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cRA.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds540);
            this.cRA.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cRA, w.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cRA, w.this.mPageContext);
                    w.this.y(w.this.cRD, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cRA.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cRA.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cRE = new ArrayList();
        com.baidu.tbadk.core.view.a aI = aI(this.cRC, getString(d.j.thread_good_class, new Object[0]));
        aI.setChecked(true);
        linearLayout.addView(aI);
        this.cRE.add(aI);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xy()) && aaVar.xz() > 0) {
                    com.baidu.tbadk.core.view.a aI2 = aI(String.valueOf(aaVar.xz()), aaVar.xy());
                    this.cRE.add(aI2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aI2);
                    aj.t(view, d.C0108d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cRA.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cRA, this.mPageContext);
    }

    private com.baidu.tbadk.core.view.a aI(String str, String str2) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cRF);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bXF != null && gVar != null && gVar.aot) {
            String str = "";
            if (i == 2) {
                this.bXF.eT(1);
                str = T(gVar.hlb, d.j.operation_success);
            } else if (i == 3) {
                this.bXF.eT(0);
                str = T(gVar.hlb, d.j.operation_success);
            } else if (i == 4) {
                this.bXF.eS(1);
                str = T(gVar.hlb, d.j.top_success);
            } else if (i == 5) {
                this.bXF.eS(0);
                str = T(gVar.hlb, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bXF.getId();
            eVar.forumName = this.bXF.zd();
            eVar.forumId = String.valueOf(this.bXF.getFid());
            eVar.hlc = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hlb)) {
            string = gVar.hlb;
        } else {
            string = getString(d.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String T(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lC(int i) {
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
    public void ajH() {
        if (this.mContext != null && this.bXF != null && this.bXF.yX() != null) {
            String userId = this.bXF.yX().getUserId();
            String userName = this.bXF.yX().getUserName();
            String id = this.bXF.getId();
            String zd = this.bXF.zd();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.bXF.getFid()), zd, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajI() {
        if (this.cQq != null && this.bXF != null && this.bXF.yX() != null) {
            String userId = this.bXF.yX().getUserId();
            String id = this.bXF.getId();
            String zd = this.bXF.zd();
            this.cQq.a(String.valueOf(this.bXF.getFid()), zd, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        int i;
        if (this.bXF != null && this.cQq != null) {
            if (this.bXF.yT() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bXF.getId();
            String zd = this.bXF.zd();
            this.cQq.a(String.valueOf(this.bXF.getFid()), zd, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajJ() {
        int i;
        if (this.bXF != null && this.cQq != null) {
            if (this.bXF.yS() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bXF.getId();
            String zd = this.bXF.zd();
            this.cQq.a(String.valueOf(this.bXF.getFid()), zd, id, i, null);
        }
    }

    public void dismissAllDialog() {
        ajF();
        ajG();
        ajE();
    }

    public void destory() {
        dismissAllDialog();
    }
}
