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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.core.dialog.i {
    private bz ale;
    private boolean fik;
    private ForumManageModel gca;
    private com.baidu.tbadk.core.dialog.a irV;
    private final com.baidu.adp.base.e isj;
    private final com.baidu.tbadk.core.dialog.k itD;
    private com.baidu.tbadk.core.dialog.a itE;
    private Dialog itF;
    private final List<com.baidu.tbadk.core.dialog.g> itG;
    private String itH;
    private String itI;
    private List<BlueCheckRadioButton> itJ;
    final CompoundButton.OnCheckedChangeListener itK;
    private final k.c itL;
    private Context mContext;
    private TbPageContext mPageContext;

    public ab(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.itH = "0";
        this.itI = this.itH;
        this.fik = false;
        this.itK = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ab.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ab.this.itI = (String) compoundButton.getTag();
                    if (ab.this.itJ != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ab.this.itJ) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ab.this.itI != null && !str.equals(ab.this.itI)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.isj = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.ab.6
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj != null && ab.this.gca != null) {
                    switch (ab.this.gca.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.iHw != 0) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ab.this.ale.getId()));
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.npO) ? bVar.npO : ab.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ab.this.itE == null) {
                                        ab.this.itE = new com.baidu.tbadk.core.dialog.a(ab.this.mPageContext.getPageActivity());
                                        ab.this.itE.Ad(string);
                                        ab.this.itE.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ab.6.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ab.this.itE.jD(true);
                                        ab.this.itE.b(ab.this.mPageContext);
                                    }
                                    ab.this.itE.bqe();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.npO) ? dVar.npO : ab.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.npO) ? dVar.npO : ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ab.this.a(ab.this.gca.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ab.this.al(gVar.npR);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.itL = new k.c() { // from class: com.baidu.tieba.card.ab.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ab.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ab.this.ale != null && ab.this.ale.bnx() != null) {
                        if (UtilHelper.isCurrentAccount(ab.this.ale.bnx().getUserId())) {
                            ab.this.crn();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new com.baidu.tieba.NEGFeedBack.g(1, ab.this.gca, ab.this.ale)));
                        }
                    }
                } else if (i == 2) {
                    ab.this.cro();
                } else if (i == 3) {
                    ab.this.crp();
                } else if (i == 4) {
                    ab.this.aJ(ab.this.itH, true);
                } else if (i == 5) {
                    ab.this.crq();
                } else if (i == 6) {
                    ab.this.crs();
                } else if (i == 7) {
                    ab.this.crr();
                } else if (i == 8) {
                    ab.this.crt();
                }
                ab.this.wS(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.itG = new ArrayList();
        this.itD = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.itD.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.itD.a(this.itL);
        this.gca = new ForumManageModel(this.mPageContext);
        this.gca.setLoadDataCallBack(this.isj);
        this.fik = z;
        a(this.itD);
    }

    public void onChangeSkinType() {
        if (this.itD != null) {
            this.itD.onChangeSkinType();
        }
        if (this.irV != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.irV.getRealView());
        }
        if (this.itE != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.itE.getRealView());
        }
    }

    private void createView() {
        if (this.ale != null && this.itG != null && this.itD != null) {
            this.itG.clear();
            if (com.baidu.tieba.frs.j.a(com.baidu.tieba.frs.j.cAR()) && !com.baidu.tieba.frs.j.cAT()) {
                if (!this.ale.isBjh() && (this.ale.bnx() == null || !this.ale.bnx().isForumBusinessAccount() || au.isOn())) {
                    this.itG.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.itD));
                }
                String str = "";
                if (this.ale.bnx() != null) {
                    str = this.ale.bnx().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.itG.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.itD));
                }
            }
            if (com.baidu.tieba.frs.j.cAS() || com.baidu.tieba.frs.j.cAT()) {
                this.itG.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.ale.bns() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.itD));
            }
            if (com.baidu.tieba.frs.j.cAS() || com.baidu.tieba.frs.j.cAU()) {
                this.itG.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.ale.bnt() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.itD));
            }
            if (com.baidu.tieba.frs.j.cAS()) {
                this.itG.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.itD));
            }
            if (com.baidu.tieba.frs.j.cAS() && this.fik) {
                this.itG.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.itD));
            }
            if (com.baidu.tieba.frs.j.cAS() || com.baidu.tieba.frs.j.cAT()) {
                this.itG.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.itD));
            }
            if (!com.baidu.tieba.frs.j.cAT() && com.baidu.tieba.frs.b.cAg().cAi() && this.fik && (this.ale.bnx() == null || !this.ale.bnx().isForumBusinessAccount() || au.isOn())) {
                this.itG.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.itD));
            }
            this.itD.bB(this.itG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bz bzVar) {
        this.ale = bzVar;
        createView();
    }

    public void crl() {
        if (this.irV != null && this.irV.isShowing()) {
            this.irV.dismiss();
        }
    }

    public void crm() {
        if (this.itF != null && this.itF.isShowing()) {
            this.itF.dismiss();
        }
    }

    public void crn() {
        crl();
        if (this.mPageContext != null) {
            if (this.irV == null) {
                this.irV = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.irV.nu(R.string.del_thread_confirm);
                this.irV.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ab.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.neterror);
                        } else {
                            ab.this.Y(null);
                        }
                    }
                });
                this.irV.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ab.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.irV.jD(true);
                this.irV.b(this.mPageContext);
            }
            this.irV.bqe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(ArrayList<ak> arrayList) {
        if (this.itF == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.itF = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.itF.setCanceledOnTouchOutside(true);
            this.itF.setCancelable(true);
            this.itF.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.itF.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.itF.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.itF, ab.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.itF, ab.this.mPageContext);
                    ab.this.aJ(ab.this.itI, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.itF.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.itF.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.itJ = new ArrayList();
        BlueCheckRadioButton eJ = eJ(this.itH, getString(R.string.thread_good_class, new Object[0]));
        eJ.setChecked(true);
        linearLayout.addView(eJ);
        this.itJ.add(eJ);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ak akVar = arrayList.get(i);
                if (akVar != null && !TextUtils.isEmpty(akVar.blJ()) && akVar.blK() > 0) {
                    BlueCheckRadioButton eJ2 = eJ(String.valueOf(akVar.blK()), akVar.blJ());
                    this.itJ.add(eJ2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(eJ2);
                    ao.setBackgroundColor(view, R.color.CAM_X0204);
                }
            }
            ScrollView scrollView = (ScrollView) this.itF.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.itF, this.mPageContext);
    }

    private BlueCheckRadioButton eJ(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.itK);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.ale != null && gVar != null && gVar.mSuccess) {
            String str = "";
            if (i == 2) {
                this.ale.nk(1);
                com.baidu.tbadk.core.data.y yVar = new com.baidu.tbadk.core.data.y();
                yVar.type = 2;
                yVar.tid = this.ale.getTid();
                if (com.baidu.tieba.frs.j.cAS()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, yVar));
                } else {
                    str = aU(gVar.npO, R.string.set_good_success);
                    z = false;
                }
            } else if (i == 3) {
                this.ale.nk(0);
                str = aU(gVar.npO, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.ale.nj(1);
                com.baidu.tbadk.core.data.y yVar2 = new com.baidu.tbadk.core.data.y();
                yVar2.type = 1;
                yVar2.tid = this.ale.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, yVar2));
            } else if (i == 5) {
                this.ale.nj(0);
                str = aU(gVar.npO, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.ale.getId();
            eVar.forumName = this.ale.bnB();
            eVar.forumId = String.valueOf(this.ale.getFid());
            eVar.npP = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.npO)) {
            string = gVar.npO;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aU(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wS(int i) {
        if (this.ale != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).an("obj_type", i).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.ale.getFid()).dW("tid", this.ale.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cro() {
        if (this.mContext != null && this.ale != null && this.ale.bnx() != null) {
            String userId = this.ale.bnx().getUserId();
            String userName = this.ale.bnx().getUserName();
            String name_show = this.ale.bnx().getName_show();
            String id = this.ale.getId();
            String bnB = this.ale.bnB();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.ale.getFid()), bnB, id, userId, userName, name_show, null, this.ale.bnx().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(JSONArray jSONArray) {
        if (this.gca != null && this.ale != null && this.ale.bnx() != null) {
            String userId = this.ale.bnx().getUserId();
            String id = this.ale.getId();
            String bnB = this.ale.bnB();
            String valueOf = String.valueOf(this.ale.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.gca.Sv(at.S(jSONArray));
            }
            this.gca.a(valueOf, bnB, id, null, 0, 1, isCurrentAccount, this.ale.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(String str, boolean z) {
        int i;
        if (this.ale != null && this.gca != null) {
            if (this.ale.bnt() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.ale.getId();
            String bnB = this.ale.bnB();
            this.gca.c(String.valueOf(this.ale.getFid()), bnB, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crp() {
        int i;
        if (this.ale != null && this.gca != null) {
            if (this.ale.bns() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.ale.getId();
            String bnB = this.ale.bnB();
            this.gca.c(String.valueOf(this.ale.getFid()), bnB, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crq() {
        com.baidu.tieba.frs.b.cAg().X(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crr() {
        com.baidu.tieba.frs.a.czZ().X(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crs() {
        if (this.mPageContext != null && this.ale != null) {
            BawuThrones cAl = com.baidu.tieba.frs.c.cAk().cAl();
            if (cAl == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (cAl.total_recommend_num.intValue() == cAl.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.cAk().b(this.mPageContext, String.valueOf(this.ale.getFid()), this.ale.getId());
            } else {
                com.baidu.tieba.frs.c.cAk().eX(String.valueOf(this.ale.getFid()), this.ale.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.ale));
    }

    public void dismissAllDialog() {
        crl();
        crm();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
