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
    private bd bXM;
    private com.baidu.tbadk.core.dialog.a cUL;
    private ForumManageModel cUS;
    private final com.baidu.adp.base.d cUW;
    private final com.baidu.tieba.view.c cWb;
    private Dialog cWc;
    private final List<c.a> cWd;
    private String cWe;
    private String cWf;
    private List<com.baidu.tbadk.core.view.a> cWg;
    final CompoundButton.OnCheckedChangeListener cWh;
    private final c.d cWi;
    private Context mContext;
    private TbPageContext mPageContext;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cWe = "0";
        this.cWf = this.cWe;
        this.cWh = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.w.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    w.this.cWf = (String) compoundButton.getTag();
                    if (w.this.cWg != null) {
                        for (com.baidu.tbadk.core.view.a aVar : w.this.cWg) {
                            String str = (String) aVar.getTag();
                            if (str != null && w.this.cWf != null && !str.equals(w.this.cWf)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cUW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.w.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj != null && w.this.cUS != null) {
                    switch (w.this.cUS.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.haA != 0) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.aos) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(bVar.haC) ? bVar.haC : w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, w.this.bXM.getId()));
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.aos) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.haC) ? dVar.haC : w.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.haC) ? dVar.haC : w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            w.this.a(w.this.cUS.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.aos) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                w.this.C(gVar.haF);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cWi = new c.d() { // from class: com.baidu.tieba.card.w.7
            @Override // com.baidu.tieba.view.c.d
            public void lG(int i) {
                w.this.aio();
                if (!com.baidu.adp.lib.util.j.oI()) {
                    com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    w.this.tg();
                } else if (i == 2) {
                    w.this.akK();
                } else if (i == 3) {
                    w.this.akM();
                } else if (i == 4) {
                    w.this.y(w.this.cWe, true);
                }
                w.this.lF(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cWd = new ArrayList();
        this.cWb = new com.baidu.tieba.view.c(this.mContext);
        this.cWb.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.cWb.a(this.cWi);
        this.cUS = new ForumManageModel(this.mPageContext);
        this.cUS.setLoadDataCallBack(this.cUW);
        setContentView(this.cWb.bDT());
    }

    public void onChangeSkinType() {
        if (this.cWb != null) {
            this.cWb.onChangeSkinType();
        }
        if (this.cUL != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cUL.AB());
        }
    }

    private void createView() {
        if (this.bXM != null && this.cWd != null && this.cWb != null) {
            this.cWd.clear();
            this.cWd.add(new c.a(1, getString(d.j.delete_page, new Object[0]), this.cWb));
            String str = "";
            if (this.bXM.yS() != null) {
                str = this.bXM.yS().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cWd.add(new c.a(2, getString(d.j.thread_forbid, new Object[0]), this.cWb));
            }
            if (com.baidu.tieba.frs.f.atM()) {
                this.cWd.add(new c.a(3, getString(this.bXM.yN() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.cWb));
                this.cWd.add(new c.a(4, getString(this.bXM.yO() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.cWb));
            }
            this.cWb.dI(this.cWd);
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
        this.bXM = bdVar;
        createView();
    }

    public void aio() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void akI() {
        if (this.cUL != null && this.cUL.isShowing()) {
            this.cUL.dismiss();
        }
    }

    public void akJ() {
        if (this.cWc != null && this.cWc.isShowing()) {
            this.cWc.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        akI();
        if (this.mPageContext != null) {
            if (this.cUL == null) {
                this.cUL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cUL.fb(d.j.del_thread_confirm);
                this.cUL.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.w.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.ow()) {
                            com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.neterror);
                        } else {
                            w.this.akL();
                        }
                    }
                });
                this.cUL.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.w.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cUL.aV(true);
                this.cUL.b(this.mPageContext);
            }
            this.cUL.AA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<aa> arrayList) {
        if (this.cWc == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.cWc = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.cWc.setCanceledOnTouchOutside(true);
            this.cWc.setCancelable(true);
            this.cWc.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cWc.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds540);
            this.cWc.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cWc, w.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cWc, w.this.mPageContext);
                    w.this.y(w.this.cWf, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cWc.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cWc.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cWg = new ArrayList();
        com.baidu.tbadk.core.view.a aI = aI(this.cWe, getString(d.j.thread_good_class, new Object[0]));
        aI.setChecked(true);
        linearLayout.addView(aI);
        this.cWg.add(aI);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xx()) && aaVar.xy() > 0) {
                    com.baidu.tbadk.core.view.a aI2 = aI(String.valueOf(aaVar.xy()), aaVar.xx());
                    this.cWg.add(aI2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aI2);
                    aj.t(view, d.C0107d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cWc.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cWc, this.mPageContext);
    }

    private com.baidu.tbadk.core.view.a aI(String str, String str2) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cWh);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bXM != null && gVar != null && gVar.aos) {
            String str = "";
            if (i == 2) {
                this.bXM.eS(1);
                str = V(gVar.haC, d.j.operation_success);
            } else if (i == 3) {
                this.bXM.eS(0);
                str = V(gVar.haC, d.j.operation_success);
            } else if (i == 4) {
                this.bXM.eR(1);
                str = V(gVar.haC, d.j.top_success);
            } else if (i == 5) {
                this.bXM.eR(0);
                str = V(gVar.haC, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bXM.getId();
            eVar.forumName = this.bXM.yY();
            eVar.forumId = String.valueOf(this.bXM.getFid());
            eVar.haD = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.haC)) {
            string = gVar.haC;
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
    public void akK() {
        if (this.mContext != null && this.bXM != null && this.bXM.yS() != null) {
            String userId = this.bXM.yS().getUserId();
            String userName = this.bXM.yS().getUserName();
            String id = this.bXM.getId();
            String yY = this.bXM.yY();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.bXM.getFid()), yY, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        if (this.cUS != null && this.bXM != null && this.bXM.yS() != null) {
            String userId = this.bXM.yS().getUserId();
            String id = this.bXM.getId();
            String yY = this.bXM.yY();
            this.cUS.a(String.valueOf(this.bXM.getFid()), yY, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        int i;
        if (this.bXM != null && this.cUS != null) {
            if (this.bXM.yO() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bXM.getId();
            String yY = this.bXM.yY();
            this.cUS.a(String.valueOf(this.bXM.getFid()), yY, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akM() {
        int i;
        if (this.bXM != null && this.cUS != null) {
            if (this.bXM.yN() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bXM.getId();
            String yY = this.bXM.yY();
            this.cUS.a(String.valueOf(this.bXM.getFid()), yY, id, i, null);
        }
    }

    public void dismissAllDialog() {
        akI();
        akJ();
        aio();
    }

    public void destory() {
        dismissAllDialog();
    }
}
