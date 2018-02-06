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
    private com.baidu.tbadk.core.dialog.a cXR;
    private ForumManageModel cXY;
    private final com.baidu.adp.base.d cYc;
    private final com.baidu.tieba.view.c cZj;
    private Dialog cZk;
    private final List<c.a> cZl;
    private String cZm;
    private String cZn;
    private List<com.baidu.tbadk.core.view.a> cZo;
    final CompoundButton.OnCheckedChangeListener cZp;
    private final c.d cZq;
    private bd cad;
    private Context mContext;
    private TbPageContext mPageContext;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cZm = "0";
        this.cZn = this.cZm;
        this.cZp = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.w.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    w.this.cZn = (String) compoundButton.getTag();
                    if (w.this.cZo != null) {
                        for (com.baidu.tbadk.core.view.a aVar : w.this.cZo) {
                            String str = (String) aVar.getTag();
                            if (str != null && w.this.cZn != null && !str.equals(w.this.cZn)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cYc = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.w.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj != null && w.this.cXY != null) {
                    switch (w.this.cXY.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hdi != 0) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.aou) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(bVar.hdk) ? bVar.hdk : w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, w.this.cad.getId()));
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.aou) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.hdk) ? dVar.hdk : w.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.hdk) ? dVar.hdk : w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            w.this.a(w.this.cXY.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.aou) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                w.this.C(gVar.hdn);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cZq = new c.d() { // from class: com.baidu.tieba.card.w.7
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
                    w.this.w(w.this.cZm, true);
                }
                w.this.lB(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cZl = new ArrayList();
        this.cZj = new com.baidu.tieba.view.c(this.mContext);
        this.cZj.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.cZj.a(this.cZq);
        this.cXY = new ForumManageModel(this.mPageContext);
        this.cXY.setLoadDataCallBack(this.cYc);
        setContentView(this.cZj.bEL());
    }

    public void onChangeSkinType() {
        if (this.cZj != null) {
            this.cZj.onChangeSkinType();
        }
        if (this.cXR != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cXR.AV());
        }
    }

    private void createView() {
        if (this.cad != null && this.cZl != null && this.cZj != null) {
            this.cZl.clear();
            this.cZl.add(new c.a(1, getString(d.j.delete_page, new Object[0]), this.cZj));
            String str = "";
            if (this.cad.zn() != null) {
                str = this.cad.zn().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cZl.add(new c.a(2, getString(d.j.thread_forbid, new Object[0]), this.cZj));
            }
            if (com.baidu.tieba.frs.f.auH()) {
                this.cZl.add(new c.a(3, getString(this.cad.zi() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.cZj));
                this.cZl.add(new c.a(4, getString(this.cad.zj() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.cZj));
            }
            this.cZj.dO(this.cZl);
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
        this.cad = bdVar;
        createView();
    }

    public void abk() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void alw() {
        if (this.cXR != null && this.cXR.isShowing()) {
            this.cXR.dismiss();
        }
    }

    public void alx() {
        if (this.cZk != null && this.cZk.isShowing()) {
            this.cZk.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        alw();
        if (this.mPageContext != null) {
            if (this.cXR == null) {
                this.cXR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cXR.fb(d.j.del_thread_confirm);
                this.cXR.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.w.1
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
                this.cXR.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.w.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cXR.aZ(true);
                this.cXR.b(this.mPageContext);
            }
            this.cXR.AU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<aa> arrayList) {
        if (this.cZk == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.cZk = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.cZk.setCanceledOnTouchOutside(true);
            this.cZk.setCancelable(true);
            this.cZk.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cZk.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds540);
            this.cZk.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cZk, w.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cZk, w.this.mPageContext);
                    w.this.w(w.this.cZn, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cZk.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cZk.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cZo = new ArrayList();
        com.baidu.tbadk.core.view.a aJ = aJ(this.cZm, getString(d.j.thread_good_class, new Object[0]));
        aJ.setChecked(true);
        linearLayout.addView(aJ);
        this.cZo.add(aJ);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.ye()) && aaVar.yf() > 0) {
                    com.baidu.tbadk.core.view.a aJ2 = aJ(String.valueOf(aaVar.yf()), aaVar.ye());
                    this.cZo.add(aJ2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aJ2);
                    aj.t(view, d.C0140d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cZk.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cZk, this.mPageContext);
    }

    private com.baidu.tbadk.core.view.a aJ(String str, String str2) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cZp);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.cad != null && gVar != null && gVar.aou) {
            String str = "";
            if (i == 2) {
                this.cad.eS(1);
                str = T(gVar.hdk, d.j.operation_success);
            } else if (i == 3) {
                this.cad.eS(0);
                str = T(gVar.hdk, d.j.operation_success);
            } else if (i == 4) {
                this.cad.eR(1);
                str = T(gVar.hdk, d.j.top_success);
            } else if (i == 5) {
                this.cad.eR(0);
                str = T(gVar.hdk, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.cad.getId();
            eVar.forumName = this.cad.zt();
            eVar.forumId = String.valueOf(this.cad.getFid());
            eVar.hdl = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hdk)) {
            string = gVar.hdk;
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
        if (this.mContext != null && this.cad != null && this.cad.zn() != null) {
            String userId = this.cad.zn().getUserId();
            String userName = this.cad.zn().getUserName();
            String id = this.cad.getId();
            String zt = this.cad.zt();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.cad.getFid()), zt, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alz() {
        if (this.cXY != null && this.cad != null && this.cad.zn() != null) {
            String userId = this.cad.zn().getUserId();
            String id = this.cad.getId();
            String zt = this.cad.zt();
            this.cXY.a(String.valueOf(this.cad.getFid()), zt, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        int i;
        if (this.cad != null && this.cXY != null) {
            if (this.cad.zj() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.cad.getId();
            String zt = this.cad.zt();
            this.cXY.a(String.valueOf(this.cad.getFid()), zt, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alA() {
        int i;
        if (this.cad != null && this.cXY != null) {
            if (this.cad.zi() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.cad.getId();
            String zt = this.cad.zt();
            this.cXY.a(String.valueOf(this.cad.getFid()), zt, id, i, null);
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
