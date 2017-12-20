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
    private bd bkq;
    private ForumManageModel cbH;
    private final com.baidu.adp.base.d cbL;
    private com.baidu.tbadk.core.dialog.a cbz;
    private final com.baidu.tieba.view.b ccS;
    private Dialog ccT;
    private final List<b.a> ccU;
    private String ccV;
    private String ccW;
    private List<com.baidu.tbadk.core.view.a> ccX;
    final CompoundButton.OnCheckedChangeListener ccY;
    private final b.c ccZ;
    private Context mContext;
    private TbPageContext mPageContext;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.ccV = "0";
        this.ccW = this.ccV;
        this.ccY = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.w.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    w.this.ccW = (String) compoundButton.getTag();
                    if (w.this.ccX != null) {
                        for (com.baidu.tbadk.core.view.a aVar : w.this.ccX) {
                            String str = (String) aVar.getTag();
                            if (str != null && w.this.ccW != null && !str.equals(w.this.ccW)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cbL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.w.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && w.this.cbH != null) {
                    switch (w.this.cbH.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gEg != 0) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.Ai) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(bVar.gEi) ? bVar.gEi : w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, w.this.bkq.getId()));
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.Ai) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.gEi) ? dVar.gEi : w.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.gEi) ? dVar.gEi : w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            w.this.a(w.this.cbH.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Ai) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                w.this.B(gVar.gEl);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.ccZ = new b.c() { // from class: com.baidu.tieba.card.w.7
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
                        w.this.y(w.this.ccV, true);
                    }
                    w.this.iE(i);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ccU = new ArrayList();
        this.ccS = new com.baidu.tieba.view.b(this.mContext);
        this.ccS.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.ccS.a(this.ccZ);
        this.cbH = new ForumManageModel(this.mPageContext);
        this.cbH.setLoadDataCallBack(this.cbL);
        setContentView(this.ccS.bEI());
    }

    public void onChangeSkinType() {
        if (this.ccS != null) {
            this.ccS.onChangeSkinType();
        }
        if (this.cbz != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cbz.ti());
        }
    }

    private void createView() {
        if (this.bkq != null && this.ccU != null && this.ccS != null) {
            this.ccU.clear();
            this.ccU.add(new b.a(1, getString(d.j.delete_page, new Object[0]), this.ccS));
            String str = "";
            if (this.bkq.rv() != null) {
                str = this.bkq.rv().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.ccU.add(new b.a(2, getString(d.j.thread_forbid, new Object[0]), this.ccS));
            }
            if (com.baidu.tieba.frs.d.ala()) {
                this.ccU.add(new b.a(3, getString(this.bkq.rq() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.ccS));
                this.ccU.add(new b.a(4, getString(this.bkq.rr() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.ccS));
            }
            this.ccU.add(new b.a(0, getString(d.j.cancel, new Object[0]), this.ccS));
            this.ccS.dT(this.ccU);
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
        this.bkq = bdVar;
        createView();
    }

    public void abY() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void abZ() {
        if (this.cbz != null && this.cbz.isShowing()) {
            this.cbz.dismiss();
        }
    }

    public void aca() {
        if (this.ccT != null && this.ccT.isShowing()) {
            this.ccT.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD() {
        abZ();
        if (this.mPageContext != null) {
            if (this.cbz == null) {
                this.cbz = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cbz.cd(d.j.del_thread_confirm);
                this.cbz.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.w.1
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
                this.cbz.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.w.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cbz.ao(true);
                this.cbz.b(this.mPageContext);
            }
            this.cbz.th();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(ArrayList<z> arrayList) {
        if (this.ccT == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.ccT = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.ccT.setCanceledOnTouchOutside(true);
            this.ccT.setCancelable(true);
            this.ccT.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ccT.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds540);
            this.ccT.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.ccT, w.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.ccT, w.this.mPageContext);
                    w.this.y(w.this.ccW, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.ccT.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.ccT.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.ccX = new ArrayList();
        com.baidu.tbadk.core.view.a aJ = aJ(this.ccV, getString(d.j.thread_good_class, new Object[0]));
        aJ.setChecked(true);
        linearLayout.addView(aJ);
        this.ccX.add(aJ);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                z zVar = arrayList.get(i);
                if (zVar != null && !TextUtils.isEmpty(zVar.pV()) && zVar.pW() > 0) {
                    com.baidu.tbadk.core.view.a aJ2 = aJ(String.valueOf(zVar.pW()), zVar.pV());
                    this.ccX.add(aJ2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aJ2);
                    aj.k(view, d.C0096d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.ccT.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.ccT, this.mPageContext);
    }

    private com.baidu.tbadk.core.view.a aJ(String str, String str2) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.ccY);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bkq != null && gVar != null && gVar.Ai) {
            String str = "";
            if (i == 2) {
                this.bkq.bT(1);
                str = R(gVar.gEi, d.j.operation_success);
            } else if (i == 3) {
                this.bkq.bT(0);
                str = R(gVar.gEi, d.j.operation_success);
            } else if (i == 4) {
                this.bkq.bS(1);
                str = R(gVar.gEi, d.j.top_success);
            } else if (i == 5) {
                this.bkq.bS(0);
                str = R(gVar.gEi, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bkq.getId();
            eVar.forumName = this.bkq.rB();
            eVar.forumId = String.valueOf(this.bkq.getFid());
            eVar.gEj = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gEi)) {
            string = gVar.gEi;
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
        if (this.mContext != null && this.bkq != null && this.bkq.rv() != null) {
            String userId = this.bkq.rv().getUserId();
            String userName = this.bkq.rv().getUserName();
            String id = this.bkq.getId();
            String rB = this.bkq.rB();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.bkq.getFid()), rB, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acc() {
        if (this.cbH != null && this.bkq != null && this.bkq.rv() != null) {
            String userId = this.bkq.rv().getUserId();
            String id = this.bkq.getId();
            String rB = this.bkq.rB();
            this.cbH.a(String.valueOf(this.bkq.getFid()), rB, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        int i;
        if (this.bkq != null && this.cbH != null) {
            if (this.bkq.rr() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bkq.getId();
            String rB = this.bkq.rB();
            this.cbH.a(String.valueOf(this.bkq.getFid()), rB, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acd() {
        int i;
        if (this.bkq != null && this.cbH != null) {
            if (this.bkq.rq() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bkq.getId();
            String rB = this.bkq.rB();
            this.cbH.a(String.valueOf(this.bkq.getFid()), rB, id, i, null);
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
