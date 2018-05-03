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
    private ForumManageModel cpE;
    private final com.baidu.adp.base.d cpI;
    private com.baidu.tbadk.core.dialog.a cpx;
    private final com.baidu.tieba.view.a cqU;
    private Dialog cqV;
    private final List<a.C0232a> cqW;
    private String cqX;
    private String cqY;
    private List<BlueCheckRadioButton> cqZ;
    final CompoundButton.OnCheckedChangeListener cra;
    private final a.d crb;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cqX = "0";
        this.cqY = this.cqX;
        this.cra = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && (compoundButton.getTag() instanceof String)) {
                    ac.this.cqY = (String) compoundButton.getTag();
                    if (ac.this.cqZ != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.cqZ) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.cqY != null && !str.equals(ac.this.cqY)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cpI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.6
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && ac.this.cpE != null) {
                    switch (ac.this.cpE.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gyJ != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.delete_fail, new Object[0]));
                                return;
                            } else if (!bVar.yR) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(bVar.gyL) ? bVar.gyL : ac.this.getString(d.k.delete_fail, new Object[0]));
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
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.gyL) ? dVar.gyL : ac.this.getString(d.k.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.gyL) ? dVar.gyL : ac.this.getString(d.k.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.cpE.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.yR) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(d.k.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.C(gVar.gyO);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.crb = new a.d() { // from class: com.baidu.tieba.card.ac.7
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
                    ac.this.t(ac.this.cqX, true);
                }
                ac.this.iM(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cqW = new ArrayList();
        this.cqU = new com.baidu.tieba.view.a(this.mContext);
        this.cqU.setTitleText(getString(d.k.thread_manager, new Object[0]));
        this.cqU.a(this.crb);
        this.cpE = new ForumManageModel(this.mPageContext);
        this.cpE.setLoadDataCallBack(this.cpI);
        setContentView(this.cqU.bAc());
    }

    public void onChangeSkinType() {
        if (this.cqU != null) {
            this.cqU.onChangeSkinType();
        }
        if (this.cpx != null) {
            com.baidu.tbadk.n.a.a(this.mPageContext, this.cpx.tE());
        }
    }

    private void createView() {
        if (this.bjU != null && this.cqW != null && this.cqU != null) {
            this.cqW.clear();
            this.cqW.add(new a.C0232a(1, getString(d.k.delete_page, new Object[0]), this.cqU));
            String str = "";
            if (this.bjU.rQ() != null) {
                str = this.bjU.rQ().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cqW.add(new a.C0232a(2, getString(d.k.thread_forbid, new Object[0]), this.cqU));
            }
            if (com.baidu.tieba.frs.e.apa()) {
                this.cqW.add(new a.C0232a(3, getString(this.bjU.rL() == 1 ? d.k.cancel_top : d.k.top, new Object[0]), this.cqU));
                this.cqW.add(new a.C0232a(4, getString(this.bjU.rM() == 1 ? d.k.cancel_good : d.k.commit_good, new Object[0]), this.cqU));
            }
            this.cqU.dF(this.cqW);
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
        if (this.cpx != null && this.cpx.isShowing()) {
            this.cpx.dismiss();
        }
    }

    public void afE() {
        if (this.cqV != null && this.cqV.isShowing()) {
            this.cqV.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM() {
        afD();
        if (this.mPageContext != null) {
            if (this.cpx == null) {
                this.cpx = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cpx.bZ(d.k.del_thread_confirm);
                this.cpx.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
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
                this.cpx.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cpx.ar(true);
                this.cpx.b(this.mPageContext);
            }
            this.cpx.tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.cqV == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.commit_good, (ViewGroup) null);
            this.cqV = new Dialog(this.mContext, d.l.common_alert_dialog);
            this.cqV.setCanceledOnTouchOutside(true);
            this.cqV.setCancelable(true);
            this.cqV.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cqV.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds540);
            this.cqV.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.adp.lib.g.g.b(ac.this.cqV, ac.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.adp.lib.g.g.b(ac.this.cqV, ac.this.mPageContext);
                    ac.this.t(ac.this.cqY, false);
                }
            });
        }
        com.baidu.tbadk.n.a.a(this.mPageContext, this.cqV.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cqV.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cqZ = new ArrayList();
        BlueCheckRadioButton aI = aI(this.cqX, getString(d.k.thread_good_class, new Object[0]));
        aI.setChecked(true);
        linearLayout.addView(aI);
        this.cqZ.add(aI);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ab abVar = arrayList.get(i);
                if (abVar != null && !TextUtils.isEmpty(abVar.qK()) && abVar.qL() > 0) {
                    BlueCheckRadioButton aI2 = aI(String.valueOf(abVar.qL()), abVar.qK());
                    this.cqZ.add(aI2);
                    View view2 = new View(this.mContext);
                    view2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1)));
                    linearLayout.addView(view2);
                    linearLayout.addView(aI2);
                    ak.j(view2, d.C0126d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cqV.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cqV, this.mPageContext);
    }

    private BlueCheckRadioButton aI(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cra);
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
                str = T(gVar.gyL, d.k.operation_success);
            } else if (i == 3) {
                this.bjU.bQ(0);
                str = T(gVar.gyL, d.k.operation_success);
            } else if (i == 4) {
                this.bjU.bP(1);
                str = T(gVar.gyL, d.k.top_success);
            } else if (i == 5) {
                this.bjU.bP(0);
                str = T(gVar.gyL, d.k.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bjU.getId();
            eVar.forumName = this.bjU.rV();
            eVar.forumId = String.valueOf(this.bjU.getFid());
            eVar.gyM = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.k.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gyL)) {
            string = gVar.gyL;
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
        if (this.cpE != null && this.bjU != null && this.bjU.rQ() != null) {
            String userId = this.bjU.rQ().getUserId();
            String id = this.bjU.getId();
            String rV = this.bjU.rV();
            this.cpE.a(String.valueOf(this.bjU.getFid()), rV, id, null, 0, 1, UtilHelper.isCurrentAccount(userId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        int i;
        if (this.bjU != null && this.cpE != null) {
            if (this.bjU.rM() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bjU.getId();
            String rV = this.bjU.rV();
            this.cpE.a(String.valueOf(this.bjU.getFid()), rV, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afH() {
        int i;
        if (this.bjU != null && this.cpE != null) {
            if (this.bjU.rL() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bjU.getId();
            String rV = this.bjU.rV();
            this.cpE.a(String.valueOf(this.bjU.getFid()), rV, id, i, null);
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
