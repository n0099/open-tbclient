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
    private bd bjU;
    private com.baidu.tbadk.core.dialog.a cpA;
    private ForumManageModel cpH;
    private final com.baidu.adp.base.d cpL;
    private final com.baidu.tieba.view.a cqX;
    private Dialog cqY;
    private final List<a.C0232a> cqZ;
    private String cra;
    private String crb;
    private List<BlueCheckRadioButton> crd;
    final CompoundButton.OnCheckedChangeListener cre;
    private final a.d crf;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cra = "0";
        this.crb = this.cra;
        this.cre = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    ac.this.crb = (String) compoundButton.getTag();
                    if (ac.this.crd != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.crd) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.crb != null && !str.equals(ac.this.crb)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cpL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && ac.this.cpH != null) {
                    switch (ac.this.cpH.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gyM != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.yR) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(bVar.gyO) ? bVar.gyO : ac.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.bjU.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.k.delete_success);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.yR) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.gyO) ? dVar.gyO : ac.this.getString(d.k.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.gyO) ? dVar.gyO : ac.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.cpH.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.yR) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.C(gVar.gyR);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.crf = new a.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.tieba.view.a.d
            public void onItemClick(int i) {
                ac.this.Vl();
                if (!com.baidu.adp.lib.util.j.gP()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, d.k.network_not_available);
                    return;
                }
                if (i == 1) {
                    ac.this.lM();
                } else if (i == 2) {
                    ac.this.afF();
                } else if (i == 3) {
                    ac.this.afH();
                } else if (i == 4) {
                    ac.this.t(ac.this.cra, true);
                }
                ac.this.iM(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cqZ = new ArrayList();
        this.cqX = new com.baidu.tieba.view.a(this.mContext);
        this.cqX.setTitleText(getString(d.k.thread_manager, new Object[0]));
        this.cqX.a(this.crf);
        this.cpH = new ForumManageModel(this.mPageContext);
        this.cpH.setLoadDataCallBack(this.cpL);
        setContentView(this.cqX.bAc());
    }

    public void onChangeSkinType() {
        if (this.cqX != null) {
            this.cqX.onChangeSkinType();
        }
        if (this.cpA != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cpA.tE());
        }
    }

    private void createView() {
        if (this.bjU != null && this.cqZ != null && this.cqX != null) {
            this.cqZ.clear();
            this.cqZ.add(new a.C0232a(1, getString(d.k.delete_page, new Object[0]), this.cqX));
            String str = "";
            if (this.bjU.rQ() != null) {
                str = this.bjU.rQ().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cqZ.add(new a.C0232a(2, getString(d.k.thread_forbid, new Object[0]), this.cqX));
            }
            if (com.baidu.tieba.frs.e.apa()) {
                this.cqZ.add(new a.C0232a(3, getString(this.bjU.rL() == 1 ? d.k.cancel_top : d.k.top, new Object[0]), this.cqX));
                this.cqZ.add(new a.C0232a(4, getString(this.bjU.rM() == 1 ? d.k.cancel_good : d.k.commit_good, new Object[0]), this.cqX));
            }
            this.cqX.dF(this.cqZ);
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
        this.bjU = bdVar;
        createView();
    }

    public void Vl() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void afD() {
        if (this.cpA != null && this.cpA.isShowing()) {
            this.cpA.dismiss();
        }
    }

    public void afE() {
        if (this.cqY != null && this.cqY.isShowing()) {
            this.cqY.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM() {
        afD();
        if (this.mPageContext != null) {
            if (this.cpA == null) {
                this.cpA = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cpA.bZ(d.k.del_thread_confirm);
                this.cpA.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
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
                this.cpA.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cpA.ar(true);
                this.cpA.b(this.mPageContext);
            }
            this.cpA.tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.cqY == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.commit_good, (ViewGroup) null);
            this.cqY = new Dialog(this.mContext, d.l.common_alert_dialog);
            this.cqY.setCanceledOnTouchOutside(true);
            this.cqY.setCancelable(true);
            this.cqY.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cqY.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds540);
            this.cqY.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.adp.lib.g.g.b(ac.this.cqY, ac.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.adp.lib.g.g.b(ac.this.cqY, ac.this.mPageContext);
                    ac.this.t(ac.this.crb, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cqY.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cqY.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.crd = new ArrayList();
        BlueCheckRadioButton aI = aI(this.cra, getString(d.k.thread_good_class, new Object[0]));
        aI.setChecked(true);
        linearLayout.addView(aI);
        this.crd.add(aI);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i);
                if (abVar != null && !TextUtils.isEmpty(abVar.qK()) && abVar.qL() > 0) {
                    BlueCheckRadioButton aI2 = aI(String.valueOf(abVar.qL()), abVar.qK());
                    this.crd.add(aI2);
                    View view2 = new View(this.mContext);
                    view2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1)));
                    linearLayout.addView(view2);
                    linearLayout.addView(aI2);
                    ak.j(view2, d.C0126d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cqY.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cqY, this.mPageContext);
    }

    private BlueCheckRadioButton aI(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cre);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bjU != null && gVar != null && gVar.yR) {
            String str = "";
            if (i == 2) {
                this.bjU.bQ(1);
                str = T(gVar.gyO, d.k.operation_success);
            } else if (i == 3) {
                this.bjU.bQ(0);
                str = T(gVar.gyO, d.k.operation_success);
            } else if (i == 4) {
                this.bjU.bP(1);
                str = T(gVar.gyO, d.k.top_success);
            } else if (i == 5) {
                this.bjU.bP(0);
                str = T(gVar.gyO, d.k.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bjU.getId();
            eVar.forumName = this.bjU.rV();
            eVar.forumId = String.valueOf(this.bjU.getFid());
            eVar.gyP = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.k.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gyO)) {
            string = gVar.gyO;
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
        TiebaStatic.log(new al("c12713").r("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afF() {
        if (this.mContext != null && this.bjU != null && this.bjU.rQ() != null) {
            String userId = this.bjU.rQ().getUserId();
            String userName = this.bjU.rQ().getUserName();
            String id = this.bjU.getId();
            String rV = this.bjU.rV();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bjU.getFid()), rV, id, userId, userName, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afG() {
        if (this.cpH != null && this.bjU != null && this.bjU.rQ() != null) {
            String userId = this.bjU.rQ().getUserId();
            String id = this.bjU.getId();
            String rV = this.bjU.rV();
            this.cpH.a(String.valueOf(this.bjU.getFid()), rV, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        int i;
        if (this.bjU != null && this.cpH != null) {
            if (this.bjU.rM() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bjU.getId();
            String rV = this.bjU.rV();
            this.cpH.a(String.valueOf(this.bjU.getFid()), rV, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afH() {
        int i;
        if (this.bjU != null && this.cpH != null) {
            if (this.bjU.rL() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bjU.getId();
            String rV = this.bjU.rV();
            this.cpH.a(String.valueOf(this.bjU.getFid()), rV, id, i, null);
        }
    }

    public void dismissAllDialog() {
        afD();
        afE();
        Vl();
    }

    public void destory() {
        dismissAllDialog();
    }
}
