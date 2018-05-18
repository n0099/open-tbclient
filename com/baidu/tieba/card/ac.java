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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ac extends com.baidu.tieba.person.e {
    private bd bkk;
    private com.baidu.tbadk.core.dialog.a cqG;
    private ForumManageModel cqN;
    private final com.baidu.adp.base.d cqR;
    private final com.baidu.tieba.view.a cse;
    private Dialog csf;
    private final List<a.C0232a> csg;
    private String csh;
    private String csi;
    private List<BlueCheckRadioButton> csj;
    final CompoundButton.OnCheckedChangeListener csk;
    private final a.d csl;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.csh = "0";
        this.csi = this.csh;
        this.csk = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    ac.this.csi = (String) compoundButton.getTag();
                    if (ac.this.csj != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.csj) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.csi != null && !str.equals(ac.this.csi)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cqR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && ac.this.cqN != null) {
                    switch (ac.this.cqN.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gzN != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.yQ) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(bVar.gzP) ? bVar.gzP : ac.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.bkk.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.k.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.yQ) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.gzP) ? dVar.gzP : ac.this.getString(d.k.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.gzP) ? dVar.gzP : ac.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.cqN.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.yQ) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.C(gVar.gzS);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.csl = new a.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.tieba.view.a.d
            public void onItemClick(int i) {
                ac.this.Vp();
                if (!com.baidu.adp.lib.util.j.gP()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.k.network_not_available);
                    return;
                }
                if (i == 1) {
                    ac.this.lL();
                } else if (i == 2) {
                    ac.this.afF();
                } else if (i == 3) {
                    ac.this.afH();
                } else if (i == 4) {
                    ac.this.t(ac.this.csh, true);
                }
                ac.this.iL(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.csg = new ArrayList();
        this.cse = new com.baidu.tieba.view.a(this.mContext);
        this.cse.setTitleText(getString(d.k.thread_manager, new Object[0]));
        this.cse.a(this.csl);
        this.cqN = new ForumManageModel(this.mPageContext);
        this.cqN.setLoadDataCallBack(this.cqR);
        setContentView(this.cse.bAa());
    }

    public void onChangeSkinType() {
        if (this.cse != null) {
            this.cse.onChangeSkinType();
        }
        if (this.cqG != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cqG.tD());
        }
    }

    private void createView() {
        if (this.bkk != null && this.csg != null && this.cse != null) {
            this.csg.clear();
            this.csg.add(new a.C0232a(1, getString(d.k.delete_page, new Object[0]), this.cse));
            String str = "";
            if (this.bkk.rP() != null) {
                str = this.bkk.rP().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.csg.add(new a.C0232a(2, getString(d.k.thread_forbid, new Object[0]), this.cse));
            }
            if (com.baidu.tieba.frs.e.aoZ()) {
                this.csg.add(new a.C0232a(3, getString(this.bkk.rK() == 1 ? d.k.cancel_top : d.k.top, new Object[0]), this.cse));
                this.csg.add(new a.C0232a(4, getString(this.bkk.rL() == 1 ? d.k.cancel_good : d.k.commit_good, new Object[0]), this.cse));
            }
            this.cse.dI(this.csg);
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
        this.bkk = bdVar;
        createView();
    }

    public void Vp() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void afD() {
        if (this.cqG != null && this.cqG.isShowing()) {
            this.cqG.dismiss();
        }
    }

    public void afE() {
        if (this.csf != null && this.csf.isShowing()) {
            this.csf.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL() {
        afD();
        if (this.mPageContext != null) {
            if (this.cqG == null) {
                this.cqG = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cqG.ca(d.k.del_thread_confirm);
                this.cqG.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.gD()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.k.neterror);
                        } else {
                            ac.this.afG();
                        }
                    }
                });
                this.cqG.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cqG.ar(true);
                this.cqG.b(this.mPageContext);
            }
            this.cqG.tC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.csf == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.commit_good, (ViewGroup) null);
            this.csf = new Dialog(this.mContext, d.l.common_alert_dialog);
            this.csf.setCanceledOnTouchOutside(true);
            this.csf.setCancelable(true);
            this.csf.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.csf.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds540);
            this.csf.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.adp.lib.g.g.b(ac.this.csf, ac.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.adp.lib.g.g.b(ac.this.csf, ac.this.mPageContext);
                    ac.this.t(ac.this.csi, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.csf.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.csf.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.csj = new ArrayList();
        BlueCheckRadioButton aI = aI(this.csh, getString(d.k.thread_good_class, new Object[0]));
        aI.setChecked(true);
        linearLayout.addView(aI);
        this.csj.add(aI);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i);
                if (abVar != null && !TextUtils.isEmpty(abVar.qJ()) && abVar.qK() > 0) {
                    BlueCheckRadioButton aI2 = aI(String.valueOf(abVar.qK()), abVar.qJ());
                    this.csj.add(aI2);
                    View view2 = new View(this.mContext);
                    view2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1)));
                    linearLayout.addView(view2);
                    linearLayout.addView(aI2);
                    ak.j(view2, d.C0126d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.csf.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.csf, this.mPageContext);
    }

    private BlueCheckRadioButton aI(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.csk);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bkk != null && gVar != null && gVar.yQ) {
            String str = "";
            if (i == 2) {
                this.bkk.bR(1);
                str = T(gVar.gzP, d.k.operation_success);
            } else if (i == 3) {
                this.bkk.bR(0);
                str = T(gVar.gzP, d.k.operation_success);
            } else if (i == 4) {
                this.bkk.bQ(1);
                str = T(gVar.gzP, d.k.top_success);
            } else if (i == 5) {
                this.bkk.bQ(0);
                str = T(gVar.gzP, d.k.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bkk.getId();
            eVar.forumName = this.bkk.rU();
            eVar.forumId = String.valueOf(this.bkk.getFid());
            eVar.gzQ = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.k.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gzP)) {
            string = gVar.gzP;
        } else {
            string = getString(d.k.operation_failed, new Object[0]);
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
    public void iL(int i) {
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
        TiebaStatic.log(new al("c12713").r("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afF() {
        if (this.mContext != null && this.bkk != null && this.bkk.rP() != null) {
            String userId = this.bkk.rP().getUserId();
            String userName = this.bkk.rP().getUserName();
            String id = this.bkk.getId();
            String rU = this.bkk.rU();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bkk.getFid()), rU, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afG() {
        if (this.cqN != null && this.bkk != null && this.bkk.rP() != null) {
            String userId = this.bkk.rP().getUserId();
            String id = this.bkk.getId();
            String rU = this.bkk.rU();
            this.cqN.a(String.valueOf(this.bkk.getFid()), rU, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        int i;
        if (this.bkk != null && this.cqN != null) {
            if (this.bkk.rL() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bkk.getId();
            String rU = this.bkk.rU();
            this.cqN.a(String.valueOf(this.bkk.getFid()), rU, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afH() {
        int i;
        if (this.bkk != null && this.cqN != null) {
            if (this.bkk.rK() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bkk.getId();
            String rU = this.bkk.rU();
            this.cqN.a(String.valueOf(this.bkk.getFid()), rU, id, i, null);
        }
    }

    public void dismissAllDialog() {
        afD();
        afE();
        Vp();
    }

    public void destory() {
        dismissAllDialog();
    }
}
