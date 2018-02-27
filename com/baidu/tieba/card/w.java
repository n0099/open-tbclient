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
    private bd bZR;
    private com.baidu.tbadk.core.dialog.a cXF;
    private ForumManageModel cXM;
    private final com.baidu.adp.base.d cXQ;
    private final com.baidu.tieba.view.c cYX;
    private Dialog cYY;
    private final List<c.a> cYZ;
    private String cZa;
    private String cZb;
    private List<com.baidu.tbadk.core.view.a> cZc;
    final CompoundButton.OnCheckedChangeListener cZd;
    private final c.d cZe;
    private Context mContext;
    private TbPageContext mPageContext;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cZa = "0";
        this.cZb = this.cZa;
        this.cZd = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.w.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    w.this.cZb = (String) compoundButton.getTag();
                    if (w.this.cZc != null) {
                        for (com.baidu.tbadk.core.view.a aVar : w.this.cZc) {
                            String str = (String) aVar.getTag();
                            if (str != null && w.this.cZb != null && !str.equals(w.this.cZb)) {
                                aVar.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cXQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.w.6
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj != null && w.this.cXM != null) {
                    switch (w.this.cXM.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hcT != 0) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.aoo) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(bVar.hcV) ? bVar.hcV : w.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, w.this.bZR.getId()));
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.aoo) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.hcV) ? dVar.hcV : w.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, !TextUtils.isEmpty(dVar.hcV) ? dVar.hcV : w.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            w.this.a(w.this.cXM.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.aoo) {
                                com.baidu.adp.lib.util.l.showToast(w.this.mContext, w.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                w.this.C(gVar.hcY);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cZe = new c.d() { // from class: com.baidu.tieba.card.w.7
            @Override // com.baidu.tieba.view.c.d
            public void lC(int i) {
                w.this.abj();
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    w.this.tg();
                } else if (i == 2) {
                    w.this.alx();
                } else if (i == 3) {
                    w.this.alz();
                } else if (i == 4) {
                    w.this.v(w.this.cZa, true);
                }
                w.this.lB(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cYZ = new ArrayList();
        this.cYX = new com.baidu.tieba.view.c(this.mContext);
        this.cYX.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.cYX.a(this.cZe);
        this.cXM = new ForumManageModel(this.mPageContext);
        this.cXM.setLoadDataCallBack(this.cXQ);
        setContentView(this.cYX.bEK());
    }

    public void onChangeSkinType() {
        if (this.cYX != null) {
            this.cYX.onChangeSkinType();
        }
        if (this.cXF != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cXF.AV());
        }
    }

    private void createView() {
        if (this.bZR != null && this.cYZ != null && this.cYX != null) {
            this.cYZ.clear();
            this.cYZ.add(new c.a(1, getString(d.j.delete_page, new Object[0]), this.cYX));
            String str = "";
            if (this.bZR.zn() != null) {
                str = this.bZR.zn().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cYZ.add(new c.a(2, getString(d.j.thread_forbid, new Object[0]), this.cYX));
            }
            if (com.baidu.tieba.frs.f.auG()) {
                this.cYZ.add(new c.a(3, getString(this.bZR.zi() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.cYX));
                this.cYZ.add(new c.a(4, getString(this.bZR.zj() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.cYX));
            }
            this.cYX.dO(this.cYZ);
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
        this.bZR = bdVar;
        createView();
    }

    public void abj() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void alv() {
        if (this.cXF != null && this.cXF.isShowing()) {
            this.cXF.dismiss();
        }
    }

    public void alw() {
        if (this.cYY != null && this.cYY.isShowing()) {
            this.cYY.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        alv();
        if (this.mPageContext != null) {
            if (this.cXF == null) {
                this.cXF = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cXF.fb(d.j.del_thread_confirm);
                this.cXF.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.w.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.ox()) {
                            com.baidu.adp.lib.util.l.showToast(w.this.mContext, d.j.neterror);
                        } else {
                            w.this.aly();
                        }
                    }
                });
                this.cXF.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.w.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cXF.aZ(true);
                this.cXF.b(this.mPageContext);
            }
            this.cXF.AU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<aa> arrayList) {
        if (this.cYY == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.cYY = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.cYY.setCanceledOnTouchOutside(true);
            this.cYY.setCancelable(true);
            this.cYY.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cYY.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds540);
            this.cYY.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cYY, w.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.w.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(w.this.cYY, w.this.mPageContext);
                    w.this.v(w.this.cZb, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cYY.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cYY.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cZc = new ArrayList();
        com.baidu.tbadk.core.view.a aJ = aJ(this.cZa, getString(d.j.thread_good_class, new Object[0]));
        aJ.setChecked(true);
        linearLayout.addView(aJ);
        this.cZc.add(aJ);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.ye()) && aaVar.yf() > 0) {
                    com.baidu.tbadk.core.view.a aJ2 = aJ(String.valueOf(aaVar.yf()), aaVar.ye());
                    this.cZc.add(aJ2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aJ2);
                    aj.t(view, d.C0141d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cYY.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cYY, this.mPageContext);
    }

    private com.baidu.tbadk.core.view.a aJ(String str, String str2) {
        com.baidu.tbadk.core.view.a aVar = new com.baidu.tbadk.core.view.a(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cZd);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bZR != null && gVar != null && gVar.aoo) {
            String str = "";
            if (i == 2) {
                this.bZR.eS(1);
                str = T(gVar.hcV, d.j.operation_success);
            } else if (i == 3) {
                this.bZR.eS(0);
                str = T(gVar.hcV, d.j.operation_success);
            } else if (i == 4) {
                this.bZR.eR(1);
                str = T(gVar.hcV, d.j.top_success);
            } else if (i == 5) {
                this.bZR.eR(0);
                str = T(gVar.hcV, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bZR.getId();
            eVar.forumName = this.bZR.zt();
            eVar.forumId = String.valueOf(this.bZR.getFid());
            eVar.hcW = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hcV)) {
            string = gVar.hcV;
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
    public void alx() {
        if (this.mContext != null && this.bZR != null && this.bZR.zn() != null) {
            String userId = this.bZR.zn().getUserId();
            String userName = this.bZR.zn().getUserName();
            String id = this.bZR.getId();
            String zt = this.bZR.zt();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bZR.getFid()), zt, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aly() {
        if (this.cXM != null && this.bZR != null && this.bZR.zn() != null) {
            String userId = this.bZR.zn().getUserId();
            String id = this.bZR.getId();
            String zt = this.bZR.zt();
            this.cXM.a(String.valueOf(this.bZR.getFid()), zt, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, boolean z) {
        int i;
        if (this.bZR != null && this.cXM != null) {
            if (this.bZR.zj() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bZR.getId();
            String zt = this.bZR.zt();
            this.cXM.a(String.valueOf(this.bZR.getFid()), zt, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alz() {
        int i;
        if (this.bZR != null && this.cXM != null) {
            if (this.bZR.zi() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bZR.getId();
            String zt = this.bZR.zt();
            this.cXM.a(String.valueOf(this.bZR.getFid()), zt, id, i, null);
        }
    }

    public void dismissAllDialog() {
        alv();
        alw();
        abj();
    }

    public void destory() {
        dismissAllDialog();
    }
}
