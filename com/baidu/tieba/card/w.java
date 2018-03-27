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
    private bd bZU;
    private com.baidu.tbadk.core.dialog.a cXI;
    private ForumManageModel cXP;
    private final com.baidu.adp.base.d cXT;
    private final com.baidu.tieba.view.c cZa;
    private Dialog cZb;
    private final List<c.a> cZc;
    private String cZd;
    private String cZe;
    private List<com.baidu.tbadk.core.view.a> cZf;
    final CompoundButton.OnCheckedChangeListener cZg;
    private final c.d cZh;
    private Context mContext;
    private TbPageContext mPageContext;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cZd = "0";
        this.cZe = this.cZd;
        this.cZg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.w.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    w.this.cZe = (String) compoundButton.getTag();
                    if (w.this.cZf != null) {
                        for (com.baidu.tbadk.core.view.a aVar : w.this.cZf) {
                            String str = (String) aVar.getTag();
                            if (str != null && w.this.cZe != null && !str.equals(w.this.cZe)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cXT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.w.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj != null && w.this.cXP != null) {
                    switch (w.this.cXP.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hdr != 0) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.aoo) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(bVar.hdt) ? bVar.hdt : w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, w.this.bZU.getId()));
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.aoo) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.hdt) ? dVar.hdt : w.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.hdt) ? dVar.hdt : w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            w.this.a(w.this.cXP.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.aoo) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                w.this.C(gVar.hdw);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cZh = new c.d() { // from class: com.baidu.tieba.card.w.7
            @Override // com.baidu.tieba.view.c.d
            public void lC(int i) {
                w.this.abk();
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    w.this.tg();
                } else if (i == 2) {
                    w.this.aly();
                } else if (i == 3) {
                    w.this.alA();
                } else if (i == 4) {
                    w.this.v(w.this.cZd, true);
                }
                w.this.lB(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cZc = new ArrayList();
        this.cZa = new com.baidu.tieba.view.c(this.mContext);
        this.cZa.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.cZa.a(this.cZh);
        this.cXP = new ForumManageModel(this.mPageContext);
        this.cXP.setLoadDataCallBack(this.cXT);
        setContentView(this.cZa.bEP());
    }

    public void onChangeSkinType() {
        if (this.cZa != null) {
            this.cZa.onChangeSkinType();
        }
        if (this.cXI != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cXI.AW());
        }
    }

    private void createView() {
        if (this.bZU != null && this.cZc != null && this.cZa != null) {
            this.cZc.clear();
            this.cZc.add(new c.a(1, getString(d.j.delete_page, new Object[0]), this.cZa));
            String str = "";
            if (this.bZU.zn() != null) {
                str = this.bZU.zn().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cZc.add(new c.a(2, getString(d.j.thread_forbid, new Object[0]), this.cZa));
            }
            if (com.baidu.tieba.frs.f.auH()) {
                this.cZc.add(new c.a(3, getString(this.bZU.zi() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.cZa));
                this.cZc.add(new c.a(4, getString(this.bZU.zj() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.cZa));
            }
            this.cZa.dO(this.cZc);
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
        this.bZU = bdVar;
        createView();
    }

    public void abk() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void alw() {
        if (this.cXI != null && this.cXI.isShowing()) {
            this.cXI.dismiss();
        }
    }

    public void alx() {
        if (this.cZb != null && this.cZb.isShowing()) {
            this.cZb.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        alw();
        if (this.mPageContext != null) {
            if (this.cXI == null) {
                this.cXI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cXI.fb(d.j.del_thread_confirm);
                this.cXI.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.w.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.ox()) {
                            com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.neterror);
                        } else {
                            w.this.alz();
                        }
                    }
                });
                this.cXI.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.w.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cXI.aZ(true);
                this.cXI.b(this.mPageContext);
            }
            this.cXI.AV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<aa> arrayList) {
        if (this.cZb == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.cZb = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.cZb.setCanceledOnTouchOutside(true);
            this.cZb.setCancelable(true);
            this.cZb.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cZb.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds540);
            this.cZb.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cZb, w.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cZb, w.this.mPageContext);
                    w.this.v(w.this.cZe, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cZb.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cZb.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cZf = new ArrayList();
        com.baidu.tbadk.core.view.a aJ = aJ(this.cZd, getString(d.j.thread_good_class, new Object[0]));
        aJ.setChecked(true);
        linearLayout.addView(aJ);
        this.cZf.add(aJ);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.ye()) && aaVar.yf() > 0) {
                    com.baidu.tbadk.core.view.a aJ2 = aJ(String.valueOf(aaVar.yf()), aaVar.ye());
                    this.cZf.add(aJ2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aJ2);
                    aj.t(view, d.C0141d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cZb.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cZb, this.mPageContext);
    }

    private com.baidu.tbadk.core.view.a aJ(String str, String str2) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cZg);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bZU != null && gVar != null && gVar.aoo) {
            String str = "";
            if (i == 2) {
                this.bZU.eS(1);
                str = T(gVar.hdt, d.j.operation_success);
            } else if (i == 3) {
                this.bZU.eS(0);
                str = T(gVar.hdt, d.j.operation_success);
            } else if (i == 4) {
                this.bZU.eR(1);
                str = T(gVar.hdt, d.j.top_success);
            } else if (i == 5) {
                this.bZU.eR(0);
                str = T(gVar.hdt, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bZU.getId();
            eVar.forumName = this.bZU.zt();
            eVar.forumId = String.valueOf(this.bZU.getFid());
            eVar.hdu = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hdt)) {
            string = gVar.hdt;
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
    public void lB(int i) {
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
    public void aly() {
        if (this.mContext != null && this.bZU != null && this.bZU.zn() != null) {
            String userId = this.bZU.zn().getUserId();
            String userName = this.bZU.zn().getUserName();
            String id = this.bZU.getId();
            String zt = this.bZU.zt();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bZU.getFid()), zt, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alz() {
        if (this.cXP != null && this.bZU != null && this.bZU.zn() != null) {
            String userId = this.bZU.zn().getUserId();
            String id = this.bZU.getId();
            String zt = this.bZU.zt();
            this.cXP.a(String.valueOf(this.bZU.getFid()), zt, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, boolean z) {
        int i;
        if (this.bZU != null && this.cXP != null) {
            if (this.bZU.zj() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bZU.getId();
            String zt = this.bZU.zt();
            this.cXP.a(String.valueOf(this.bZU.getFid()), zt, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alA() {
        int i;
        if (this.bZU != null && this.cXP != null) {
            if (this.bZU.zi() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bZU.getId();
            String zt = this.bZU.zt();
            this.cXP.a(String.valueOf(this.bZU.getFid()), zt, id, i, null);
        }
    }

    public void dismissAllDialog() {
        alw();
        alx();
        abk();
    }

    public void destory() {
        dismissAllDialog();
    }
}
