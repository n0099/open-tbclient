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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ac extends com.baidu.tieba.person.e {
    private bd bso;
    private final com.baidu.tieba.view.a cAH;
    private Dialog cAI;
    private final List<a.C0249a> cAJ;
    private String cAK;
    private String cAL;
    private List<BlueCheckRadioButton> cAM;
    final CompoundButton.OnCheckedChangeListener cAN;
    private final a.d cAO;
    private com.baidu.tbadk.core.dialog.a czj;
    private ForumManageModel czq;
    private final com.baidu.adp.base.d czu;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cAK = "0";
        this.cAL = this.cAK;
        this.cAN = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    ac.this.cAL = (String) compoundButton.getTag();
                    if (ac.this.cAM != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.cAM) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.cAL != null && !str.equals(ac.this.cAL)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.czu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.6
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj != null && ac.this.czq != null) {
                    switch (ac.this.czq.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gLp != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.EY) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(bVar.gLr) ? bVar.gLr : ac.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.bso.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.k.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.EY) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.gLr) ? dVar.gLr : ac.this.getString(d.k.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.gLr) ? dVar.gLr : ac.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.czq.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.EY) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.B(gVar.gLu);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cAO = new a.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.tieba.view.a.d
            public void onItemClick(int i) {
                ac.this.YO();
                if (!com.baidu.adp.lib.util.j.jD()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.k.network_not_available);
                    return;
                }
                if (i == 1) {
                    ac.this.oC();
                } else if (i == 2) {
                    ac.this.ajm();
                } else if (i == 3) {
                    ac.this.ajo();
                } else if (i == 4) {
                    ac.this.t(ac.this.cAK, true);
                }
                ac.this.iM(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cAJ = new ArrayList();
        this.cAH = new com.baidu.tieba.view.a(this.mContext);
        this.cAH.setTitleText(getString(d.k.thread_manager, new Object[0]));
        this.cAH.a(this.cAO);
        this.czq = new ForumManageModel(this.mPageContext);
        this.czq.setLoadDataCallBack(this.czu);
        setContentView(this.cAH.bFf());
    }

    public void onChangeSkinType() {
        if (this.cAH != null) {
            this.cAH.onChangeSkinType();
        }
        if (this.czj != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.czj.xb());
        }
    }

    private void createView() {
        if (this.bso != null && this.cAJ != null && this.cAH != null) {
            this.cAJ.clear();
            this.cAJ.add(new a.C0249a(1, getString(d.k.delete_page, new Object[0]), this.cAH));
            String str = "";
            if (this.bso.vm() != null) {
                str = this.bso.vm().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cAJ.add(new a.C0249a(2, getString(d.k.thread_forbid, new Object[0]), this.cAH));
            }
            if (com.baidu.tieba.frs.e.atf()) {
                this.cAJ.add(new a.C0249a(3, getString(this.bso.vh() == 1 ? d.k.cancel_top : d.k.top, new Object[0]), this.cAH));
                this.cAJ.add(new a.C0249a(4, getString(this.bso.vi() == 1 ? d.k.cancel_good : d.k.commit_good, new Object[0]), this.cAH));
            }
            this.cAH.dN(this.cAJ);
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
        this.bso = bdVar;
        createView();
    }

    public void YO() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void ajk() {
        if (this.czj != null && this.czj.isShowing()) {
            this.czj.dismiss();
        }
    }

    public void ajl() {
        if (this.cAI != null && this.cAI.isShowing()) {
            this.cAI.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC() {
        ajk();
        if (this.mPageContext != null) {
            if (this.czj == null) {
                this.czj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.czj.cc(d.k.del_thread_confirm);
                this.czj.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.jr()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.k.neterror);
                        } else {
                            ac.this.ajn();
                        }
                    }
                });
                this.czj.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.czj.au(true);
                this.czj.b(this.mPageContext);
            }
            this.czj.xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.cAI == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.commit_good, (ViewGroup) null);
            this.cAI = new Dialog(this.mContext, d.l.common_alert_dialog);
            this.cAI.setCanceledOnTouchOutside(true);
            this.cAI.setCancelable(true);
            this.cAI.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cAI.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds540);
            this.cAI.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.cAI, ac.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.cAI, ac.this.mPageContext);
                    ac.this.t(ac.this.cAL, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cAI.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cAI.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cAM = new ArrayList();
        BlueCheckRadioButton aP = aP(this.cAK, getString(d.k.thread_good_class, new Object[0]));
        aP.setChecked(true);
        linearLayout.addView(aP);
        this.cAM.add(aP);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i);
                if (abVar != null && !TextUtils.isEmpty(abVar.uf()) && abVar.ug() > 0) {
                    BlueCheckRadioButton aP2 = aP(String.valueOf(abVar.ug()), abVar.uf());
                    this.cAM.add(aP2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aP2);
                    al.j(view, d.C0141d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cAI.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cAI, this.mPageContext);
    }

    private BlueCheckRadioButton aP(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cAN);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bso != null && gVar != null && gVar.EY) {
            String str = "";
            if (i == 2) {
                this.bso.bT(1);
                str = V(gVar.gLr, d.k.operation_success);
            } else if (i == 3) {
                this.bso.bT(0);
                str = V(gVar.gLr, d.k.operation_success);
            } else if (i == 4) {
                this.bso.bS(1);
                str = V(gVar.gLr, d.k.top_success);
            } else if (i == 5) {
                this.bso.bS(0);
                str = V(gVar.gLr, d.k.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bso.getId();
            eVar.forumName = this.bso.vr();
            eVar.forumId = String.valueOf(this.bso.getFid());
            eVar.gLs = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.k.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gLr)) {
            string = gVar.gLr;
        } else {
            string = getString(d.k.operation_failed, new Object[0]);
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
    public void iM(int i) {
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
        TiebaStatic.log(new am("c12713").r("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajm() {
        if (this.mContext != null && this.bso != null && this.bso.vm() != null) {
            String userId = this.bso.vm().getUserId();
            String userName = this.bso.vm().getUserName();
            String name_show = this.bso.vm().getName_show();
            String id = this.bso.getId();
            String vr = this.bso.vr();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bso.getFid()), vr, id, userId, userName, name_show, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajn() {
        if (this.czq != null && this.bso != null && this.bso.vm() != null) {
            String userId = this.bso.vm().getUserId();
            String id = this.bso.getId();
            String vr = this.bso.vr();
            this.czq.a(String.valueOf(this.bso.getFid()), vr, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        int i;
        if (this.bso != null && this.czq != null) {
            if (this.bso.vi() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bso.getId();
            String vr = this.bso.vr();
            this.czq.a(String.valueOf(this.bso.getFid()), vr, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajo() {
        int i;
        if (this.bso != null && this.czq != null) {
            if (this.bso.vh() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bso.getId();
            String vr = this.bso.vr();
            this.czq.a(String.valueOf(this.bso.getFid()), vr, id, i, null);
        }
    }

    public void dismissAllDialog() {
        ajk();
        ajl();
        YO();
    }

    public void destory() {
        dismissAllDialog();
    }
}
