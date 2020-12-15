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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes21.dex */
public class ac extends com.baidu.tbadk.core.dialog.i {
    private by alu;
    private ForumManageModel fXd;
    private boolean fdm;
    private com.baidu.tbadk.core.dialog.a ikh;
    private final com.baidu.adp.base.d ikv;
    private final com.baidu.tbadk.core.dialog.k ilP;
    private com.baidu.tbadk.core.dialog.a ilQ;
    private Dialog ilR;
    private final List<com.baidu.tbadk.core.dialog.g> ilS;
    private String ilT;
    private String ilU;
    private List<BlueCheckRadioButton> ilV;
    final CompoundButton.OnCheckedChangeListener ilW;
    private final k.c ilX;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.ilT = "0";
        this.ilU = this.ilT;
        this.fdm = false;
        this.ilW = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.ilU = (String) compoundButton.getTag();
                    if (ac.this.ilV != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.ilV) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.ilU != null && !str.equals(ac.this.ilU)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.ikv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ac.this.fXd != null) {
                    switch (ac.this.fXd.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.izQ != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ac.this.alu.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.noK) ? bVar.noK : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.ilQ == null) {
                                        ac.this.ilQ = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.ilQ.Bq(string);
                                        ac.this.ilQ.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.6.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.ilQ.jl(true);
                                        ac.this.ilQ.b(ac.this.mPageContext);
                                    }
                                    ac.this.ilQ.brv();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.noK) ? dVar.noK : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.noK) ? dVar.noK : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.fXd.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.aq(gVar.noN);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.ilX = new k.c() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.alu != null && ac.this.alu.boP() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.alu.boP().getUserId())) {
                            ac.this.csl();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new com.baidu.tieba.NEGFeedBack.g(1, ac.this.fXd, ac.this.alu)));
                        }
                    }
                } else if (i == 2) {
                    ac.this.csm();
                } else if (i == 3) {
                    ac.this.csn();
                } else if (i == 4) {
                    ac.this.aI(ac.this.ilT, true);
                } else if (i == 5) {
                    ac.this.cso();
                } else if (i == 6) {
                    ac.this.csq();
                } else if (i == 7) {
                    ac.this.csp();
                } else if (i == 8) {
                    ac.this.csr();
                }
                ac.this.yl(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ilS = new ArrayList();
        this.ilP = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.ilP.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.ilP.a(this.ilX);
        this.fXd = new ForumManageModel(this.mPageContext);
        this.fXd.setLoadDataCallBack(this.ikv);
        this.fdm = z;
        a(this.ilP);
    }

    public void onChangeSkinType() {
        if (this.ilP != null) {
            this.ilP.onChangeSkinType();
        }
        if (this.ikh != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.ikh.getRealView());
        }
        if (this.ilQ != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.ilQ.getRealView());
        }
    }

    private void createView() {
        if (this.alu != null && this.ilS != null && this.ilP != null) {
            this.ilS.clear();
            if (!com.baidu.tieba.frs.j.cBR()) {
                if (!this.alu.isBjh() && (this.alu.boP() == null || !this.alu.boP().isForumBusinessAccount() || ax.isOn())) {
                    this.ilS.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.ilP));
                }
                String str = "";
                if (this.alu.boP() != null) {
                    str = this.alu.boP().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.ilS.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.ilP));
                }
            }
            if (com.baidu.tieba.frs.j.cBQ() || com.baidu.tieba.frs.j.cBR()) {
                this.ilS.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.alu.boK() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.ilP));
                this.ilS.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.alu.boL() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.ilP));
            }
            if (com.baidu.tieba.frs.j.cBQ()) {
                this.ilS.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.ilP));
            }
            if (com.baidu.tieba.frs.j.cBQ() && this.fdm) {
                this.ilS.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.ilP));
            }
            if (com.baidu.tieba.frs.j.cBQ() || com.baidu.tieba.frs.j.cBR()) {
                this.ilS.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.ilP));
            }
            if (!com.baidu.tieba.frs.j.cBR() && com.baidu.tieba.frs.b.cBe().cBg() && this.fdm && (this.alu.boP() == null || !this.alu.boP().isForumBusinessAccount() || ax.isOn())) {
                this.ilS.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.ilP));
            }
            this.ilP.bu(this.ilS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(by byVar) {
        this.alu = byVar;
        createView();
    }

    public void csj() {
        if (this.ikh != null && this.ikh.isShowing()) {
            this.ikh.dismiss();
        }
    }

    public void csk() {
        if (this.ilR != null && this.ilR.isShowing()) {
            this.ilR.dismiss();
        }
    }

    public void csl() {
        csj();
        if (this.mPageContext != null) {
            if (this.ikh == null) {
                this.ikh = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.ikh.oQ(R.string.del_thread_confirm);
                this.ikh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.neterror);
                        } else {
                            ac.this.Y(null);
                        }
                    }
                });
                this.ikh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.ikh.jl(true);
                this.ikh.b(this.mPageContext);
            }
            this.ikh.brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(ArrayList<ak> arrayList) {
        if (this.ilR == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.ilR = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.ilR.setCanceledOnTouchOutside(true);
            this.ilR.setCancelable(true);
            this.ilR.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ilR.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.ilR.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.ilR, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.ilR, ac.this.mPageContext);
                    ac.this.aI(ac.this.ilU, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.ilR.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.ilR.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.ilV = new ArrayList();
        BlueCheckRadioButton eJ = eJ(this.ilT, getString(R.string.thread_good_class, new Object[0]));
        eJ.setChecked(true);
        linearLayout.addView(eJ);
        this.ilV.add(eJ);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ak akVar = arrayList.get(i);
                if (akVar != null && !TextUtils.isEmpty(akVar.bnd()) && akVar.bne() > 0) {
                    BlueCheckRadioButton eJ2 = eJ(String.valueOf(akVar.bne()), akVar.bnd());
                    this.ilV.add(eJ2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(eJ2);
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                }
            }
            ScrollView scrollView = (ScrollView) this.ilR.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.ilR, this.mPageContext);
    }

    private BlueCheckRadioButton eJ(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.ilW);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.alu != null && gVar != null && gVar.mSuccess) {
            String str = "";
            if (i == 2) {
                this.alu.oG(1);
                com.baidu.tbadk.core.data.y yVar = new com.baidu.tbadk.core.data.y();
                yVar.type = 2;
                yVar.tid = this.alu.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, yVar));
            } else if (i == 3) {
                this.alu.oG(0);
                str = aM(gVar.noK, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.alu.oF(1);
                com.baidu.tbadk.core.data.y yVar2 = new com.baidu.tbadk.core.data.y();
                yVar2.type = 1;
                yVar2.tid = this.alu.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, yVar2));
            } else if (i == 5) {
                this.alu.oF(0);
                str = aM(gVar.noK, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.alu.getId();
            eVar.forumName = this.alu.boT();
            eVar.forumId = String.valueOf(this.alu.getFid());
            eVar.noL = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            if (!z) {
                com.baidu.adp.lib.util.l.showToast(this.mContext, str);
                return;
            }
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.noK)) {
            string = gVar.noK;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aM(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(int i) {
        if (this.alu != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).al("obj_type", i).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.alu.getFid()).dY("tid", this.alu.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csm() {
        if (this.mContext != null && this.alu != null && this.alu.boP() != null) {
            String userId = this.alu.boP().getUserId();
            String userName = this.alu.boP().getUserName();
            String name_show = this.alu.boP().getName_show();
            String id = this.alu.getId();
            String boT = this.alu.boT();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.alu.getFid()), boT, id, userId, userName, name_show, null, this.alu.boP().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(JSONArray jSONArray) {
        if (this.fXd != null && this.alu != null && this.alu.boP() != null) {
            String userId = this.alu.boP().getUserId();
            String id = this.alu.getId();
            String boT = this.alu.boT();
            String valueOf = String.valueOf(this.alu.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.fXd.TT(au.S(jSONArray));
            }
            this.fXd.a(valueOf, boT, id, null, 0, 1, isCurrentAccount, this.alu.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, boolean z) {
        int i;
        if (this.alu != null && this.fXd != null) {
            if (this.alu.boL() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.alu.getId();
            String boT = this.alu.boT();
            this.fXd.c(String.valueOf(this.alu.getFid()), boT, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        int i;
        if (this.alu != null && this.fXd != null) {
            if (this.alu.boK() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.alu.getId();
            String boT = this.alu.boT();
            this.fXd.c(String.valueOf(this.alu.getFid()), boT, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        com.baidu.tieba.frs.b.cBe().V(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csp() {
        com.baidu.tieba.frs.a.cAX().V(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csq() {
        if (this.mPageContext != null && this.alu != null) {
            BawuThrones cBj = com.baidu.tieba.frs.c.cBi().cBj();
            if (cBj == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (cBj.total_recommend_num.intValue() == cBj.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.cBi().b(this.mPageContext, String.valueOf(this.alu.getFid()), this.alu.getId());
            } else {
                com.baidu.tieba.frs.c.cBi().eX(String.valueOf(this.alu.getFid()), this.alu.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.alu));
    }

    public void dismissAllDialog() {
        csj();
        csk();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
