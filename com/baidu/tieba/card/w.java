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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.person.e {
    private bd bku;
    private com.baidu.tbadk.core.dialog.a cbD;
    private ForumManageModel cbL;
    private final com.baidu.adp.base.d cbP;
    private final com.baidu.tieba.view.b ccW;
    private Dialog ccX;
    private final List<b.a> ccY;
    private String ccZ;
    private String cda;
    private List<com.baidu.tbadk.core.view.a> cdb;
    final CompoundButton.OnCheckedChangeListener cdc;
    private final b.c cdd;
    private Context mContext;
    private TbPageContext mPageContext;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.ccZ = "0";
        this.cda = this.ccZ;
        this.cdc = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.w.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    w.this.cda = (String) compoundButton.getTag();
                    if (w.this.cdb != null) {
                        for (com.baidu.tbadk.core.view.a aVar : w.this.cdb) {
                            String str = (String) aVar.getTag();
                            if (str != null && w.this.cda != null && !str.equals(w.this.cda)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cbP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.w.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && w.this.cbL != null) {
                    switch (w.this.cbL.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gEl != 0) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.Aj) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(bVar.gEn) ? bVar.gEn : w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, w.this.bku.getId()));
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.Aj) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.gEn) ? dVar.gEn : w.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.gEn) ? dVar.gEn : w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            w.this.a(w.this.cbL.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Aj) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                w.this.B(gVar.gEq);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cdd = new b.c() { // from class: com.baidu.tieba.card.w.7
            @Override // com.baidu.tieba.view.b.c
            public void iF(int i) {
                w.this.abY();
                if (i != 0) {
                    if (!com.baidu.adp.lib.util.j.hh()) {
                        com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.network_not_available);
                        return;
                    }
                    if (i == 1) {
                        w.this.lD();
                    } else if (i == 2) {
                        w.this.acb();
                    } else if (i == 3) {
                        w.this.acd();
                    } else if (i == 4) {
                        w.this.y(w.this.ccZ, true);
                    }
                    w.this.iE(i);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ccY = new ArrayList();
        this.ccW = new com.baidu.tieba.view.b(this.mContext);
        this.ccW.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.ccW.a(this.cdd);
        this.cbL = new ForumManageModel(this.mPageContext);
        this.cbL.setLoadDataCallBack(this.cbP);
        setContentView(this.ccW.bEJ());
    }

    public void onChangeSkinType() {
        if (this.ccW != null) {
            this.ccW.onChangeSkinType();
        }
        if (this.cbD != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cbD.ti());
        }
    }

    private void createView() {
        if (this.bku != null && this.ccY != null && this.ccW != null) {
            this.ccY.clear();
            this.ccY.add(new b.a(1, getString(d.j.delete_page, new Object[0]), this.ccW));
            String str = "";
            if (this.bku.rv() != null) {
                str = this.bku.rv().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.ccY.add(new b.a(2, getString(d.j.thread_forbid, new Object[0]), this.ccW));
            }
            if (com.baidu.tieba.frs.d.ala()) {
                this.ccY.add(new b.a(3, getString(this.bku.rq() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.ccW));
                this.ccY.add(new b.a(4, getString(this.bku.rr() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.ccW));
            }
            this.ccY.add(new b.a(0, getString(d.j.cancel, new Object[0]), this.ccW));
            this.ccW.dT(this.ccY);
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
        this.bku = bdVar;
        createView();
    }

    public void abY() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void abZ() {
        if (this.cbD != null && this.cbD.isShowing()) {
            this.cbD.dismiss();
        }
    }

    public void aca() {
        if (this.ccX != null && this.ccX.isShowing()) {
            this.ccX.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD() {
        abZ();
        if (this.mPageContext != null) {
            if (this.cbD == null) {
                this.cbD = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cbD.cd(d.j.del_thread_confirm);
                this.cbD.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.w.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.gV()) {
                            com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.neterror);
                        } else {
                            w.this.acc();
                        }
                    }
                });
                this.cbD.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.w.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cbD.ao(true);
                this.cbD.b(this.mPageContext);
            }
            this.cbD.th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(ArrayList<z> arrayList) {
        if (this.ccX == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.ccX = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.ccX.setCanceledOnTouchOutside(true);
            this.ccX.setCancelable(true);
            this.ccX.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ccX.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds540);
            this.ccX.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.ccX, w.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.ccX, w.this.mPageContext);
                    w.this.y(w.this.cda, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.ccX.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.ccX.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cdb = new ArrayList();
        com.baidu.tbadk.core.view.a aJ = aJ(this.ccZ, getString(d.j.thread_good_class, new Object[0]));
        aJ.setChecked(true);
        linearLayout.addView(aJ);
        this.cdb.add(aJ);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                z zVar = arrayList.get(i);
                if (zVar != null && !TextUtils.isEmpty(zVar.pV()) && zVar.pW() > 0) {
                    com.baidu.tbadk.core.view.a aJ2 = aJ(String.valueOf(zVar.pW()), zVar.pV());
                    this.cdb.add(aJ2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aJ2);
                    aj.k(view, d.C0095d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.ccX.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.ccX, this.mPageContext);
    }

    private com.baidu.tbadk.core.view.a aJ(String str, String str2) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cdc);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bku != null && gVar != null && gVar.Aj) {
            String str = "";
            if (i == 2) {
                this.bku.bT(1);
                str = R(gVar.gEn, d.j.operation_success);
            } else if (i == 3) {
                this.bku.bT(0);
                str = R(gVar.gEn, d.j.operation_success);
            } else if (i == 4) {
                this.bku.bS(1);
                str = R(gVar.gEn, d.j.top_success);
            } else if (i == 5) {
                this.bku.bS(0);
                str = R(gVar.gEn, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bku.getId();
            eVar.forumName = this.bku.rB();
            eVar.forumId = String.valueOf(this.bku.getFid());
            eVar.gEo = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gEn)) {
            string = gVar.gEn;
        } else {
            string = getString(d.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String R(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE(int i) {
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
        TiebaStatic.log(new ak("c12713").r("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acb() {
        if (this.mContext != null && this.bku != null && this.bku.rv() != null) {
            String userId = this.bku.rv().getUserId();
            String userName = this.bku.rv().getUserName();
            String id = this.bku.getId();
            String rB = this.bku.rB();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.bku.getFid()), rB, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acc() {
        if (this.cbL != null && this.bku != null && this.bku.rv() != null) {
            String userId = this.bku.rv().getUserId();
            String id = this.bku.getId();
            String rB = this.bku.rB();
            this.cbL.a(String.valueOf(this.bku.getFid()), rB, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        int i;
        if (this.bku != null && this.cbL != null) {
            if (this.bku.rr() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bku.getId();
            String rB = this.bku.rB();
            this.cbL.a(String.valueOf(this.bku.getFid()), rB, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acd() {
        int i;
        if (this.bku != null && this.cbL != null) {
            if (this.bku.rq() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bku.getId();
            String rB = this.bku.rB();
            this.cbL.a(String.valueOf(this.bku.getFid()), rB, id, i, null);
        }
    }

    public void dismissAllDialog() {
        abZ();
        aca();
        abY();
    }

    public void destory() {
        dismissAllDialog();
    }
}
