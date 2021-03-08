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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes.dex */
public class ac extends com.baidu.tbadk.core.dialog.i {
    private cb amn;
    private boolean fmc;
    private ForumManageModel gfY;
    private final com.baidu.tbadk.core.dialog.k iBk;
    private com.baidu.tbadk.core.dialog.a iBl;
    private Dialog iBm;
    private final List<com.baidu.tbadk.core.dialog.g> iBn;
    private String iBo;
    private String iBp;
    private List<BlueCheckRadioButton> iBq;
    final CompoundButton.OnCheckedChangeListener iBr;
    private final k.c iBs;
    private com.baidu.tbadk.core.dialog.a izA;
    private final com.baidu.adp.base.e izO;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.iBo = "0";
        this.iBp = this.iBo;
        this.fmc = false;
        this.iBr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.iBp = (String) compoundButton.getTag();
                    if (ac.this.iBq != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.iBq) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.iBp != null && !str.equals(ac.this.iBp)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.izO = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.ac.6
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj != null && ac.this.gfY != null) {
                    switch (ac.this.gfY.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.iPc != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ac.this.amn.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.nCc) ? bVar.nCc : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.iBl == null) {
                                        ac.this.iBl = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.iBl.AB(string);
                                        ac.this.iBl.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.6.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.iBl.jF(true);
                                        ac.this.iBl.b(ac.this.mPageContext);
                                    }
                                    ac.this.iBl.bqz();
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
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.nCc) ? dVar.nCc : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.nCc) ? dVar.nCc : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.gfY.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.ak(gVar.nCf);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.iBs = new k.c() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.amn != null && ac.this.amn.bnS() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.amn.bnS().getUserId())) {
                            ac.this.csM();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new com.baidu.tieba.NEGFeedBack.g(1, ac.this.gfY, ac.this.amn)));
                        }
                    }
                } else if (i == 2) {
                    ac.this.csN();
                } else if (i == 3) {
                    ac.this.csO();
                } else if (i == 4) {
                    ac.this.aI(ac.this.iBo, true);
                } else if (i == 5) {
                    ac.this.csP();
                } else if (i == 6) {
                    ac.this.csR();
                } else if (i == 7) {
                    ac.this.csQ();
                } else if (i == 8) {
                    ac.this.csS();
                }
                ac.this.xd(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.iBn = new ArrayList();
        this.iBk = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.iBk.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.iBk.a(this.iBs);
        this.gfY = new ForumManageModel(this.mPageContext);
        this.gfY.setLoadDataCallBack(this.izO);
        this.fmc = z;
        a(this.iBk);
    }

    public void onChangeSkinType() {
        if (this.iBk != null) {
            this.iBk.onChangeSkinType();
        }
        if (this.izA != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.izA.getRealView());
        }
        if (this.iBl != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.iBl.getRealView());
        }
    }

    private void createView() {
        if (this.amn != null && this.iBn != null && this.iBk != null) {
            this.iBn.clear();
            if (com.baidu.tieba.frs.j.a(com.baidu.tieba.frs.j.cCp()) && !com.baidu.tieba.frs.j.cCr()) {
                if (!this.amn.isBjh() && (this.amn.bnS() == null || !this.amn.bnS().isForumBusinessAccount() || this.amn.isSelf() || au.isOn())) {
                    this.iBn.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.iBk));
                }
                String str = "";
                if (this.amn.bnS() != null) {
                    str = this.amn.bnS().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str) && (this.amn.bnS() == null || !this.amn.bnS().isForumBusinessAccount())) {
                    this.iBn.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.iBk));
                }
            }
            if (com.baidu.tieba.frs.j.cCq() || com.baidu.tieba.frs.j.cCr()) {
                this.iBn.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.amn.bnN() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.iBk));
            }
            if (com.baidu.tieba.frs.j.cCq() || com.baidu.tieba.frs.j.cCs()) {
                this.iBn.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.amn.bnO() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.iBk));
            }
            if (com.baidu.tieba.frs.j.cCq()) {
                this.iBn.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.iBk));
            }
            if (com.baidu.tieba.frs.j.cCq() && this.fmc) {
                this.iBn.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.iBk));
            }
            if (com.baidu.tieba.frs.j.cCq() || com.baidu.tieba.frs.j.cCr()) {
                this.iBn.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.iBk));
            }
            if (!com.baidu.tieba.frs.j.cCr() && com.baidu.tieba.frs.b.cBE().cBG() && this.fmc && (this.amn.bnS() == null || !this.amn.bnS().isForumBusinessAccount() || this.amn.isSelf() || au.isOn())) {
                this.iBn.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.iBk));
            }
            this.iBk.bw(this.iBn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(cb cbVar) {
        this.amn = cbVar;
        createView();
    }

    public void csK() {
        if (this.izA != null && this.izA.isShowing()) {
            this.izA.dismiss();
        }
    }

    public void csL() {
        if (this.iBm != null && this.iBm.isShowing()) {
            this.iBm.dismiss();
        }
    }

    public void csM() {
        csK();
        if (this.mPageContext != null) {
            if (this.izA == null) {
                this.izA = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.izA.ny(R.string.del_thread_confirm);
                this.izA.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.neterror);
                        } else {
                            ac.this.X(null);
                        }
                    }
                });
                this.izA.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.izA.jF(true);
                this.izA.b(this.mPageContext);
            }
            this.izA.bqz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(ArrayList<al> arrayList) {
        if (this.iBm == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.iBm = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.iBm.setCanceledOnTouchOutside(true);
            this.iBm.setCancelable(true);
            this.iBm.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.iBm.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.iBm.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.iBm, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.iBm, ac.this.mPageContext);
                    ac.this.aI(ac.this.iBp, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.iBm.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.iBm.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.iBq = new ArrayList();
        BlueCheckRadioButton eK = eK(this.iBo, getString(R.string.thread_good_class, new Object[0]));
        eK.setChecked(true);
        linearLayout.addView(eK);
        this.iBq.add(eK);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                al alVar = arrayList.get(i);
                if (alVar != null && !TextUtils.isEmpty(alVar.bmd()) && alVar.bme() > 0) {
                    BlueCheckRadioButton eK2 = eK(String.valueOf(alVar.bme()), alVar.bmd());
                    this.iBq.add(eK2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(eK2);
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                }
            }
            ScrollView scrollView = (ScrollView) this.iBm.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.iBm, this.mPageContext);
    }

    private BlueCheckRadioButton eK(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.iBr);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.amn != null && gVar != null && gVar.mSuccess) {
            String str = "";
            if (i == 2) {
                this.amn.no(1);
                com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                zVar.type = 2;
                zVar.tid = this.amn.getTid();
                if (com.baidu.tieba.frs.j.cCq()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, zVar));
                } else {
                    str = aV(gVar.nCc, R.string.set_good_success);
                    z = false;
                }
            } else if (i == 3) {
                this.amn.no(0);
                str = aV(gVar.nCc, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.amn.nn(1);
                com.baidu.tbadk.core.data.z zVar2 = new com.baidu.tbadk.core.data.z();
                zVar2.type = 1;
                zVar2.tid = this.amn.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, zVar2));
            } else if (i == 5) {
                this.amn.nn(0);
                str = aV(gVar.nCc, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.amn.getId();
            eVar.forumName = this.amn.bnW();
            eVar.forumId = String.valueOf(this.amn.getFid());
            eVar.nCd = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.nCc)) {
            string = gVar.nCc;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aV(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        if (this.amn != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).aq("obj_type", i).v("uid", TbadkCoreApplication.getCurrentAccountId()).v("fid", this.amn.getFid()).dR("tid", this.amn.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csN() {
        if (this.mContext != null && this.amn != null && this.amn.bnS() != null) {
            String userId = this.amn.bnS().getUserId();
            String userName = this.amn.bnS().getUserName();
            String name_show = this.amn.bnS().getName_show();
            String id = this.amn.getId();
            String bnW = this.amn.bnW();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.amn.getFid()), bnW, id, userId, userName, name_show, null, this.amn.bnS().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.gfY != null && this.amn != null && this.amn.bnS() != null) {
            String userId = this.amn.bnS().getUserId();
            String id = this.amn.getId();
            String bnW = this.amn.bnW();
            String valueOf = String.valueOf(this.amn.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.gfY.TL(com.baidu.tbadk.core.util.au.R(jSONArray));
            }
            this.gfY.a(valueOf, bnW, id, null, 0, 1, isCurrentAccount, this.amn.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, boolean z) {
        int i;
        if (this.amn != null && this.gfY != null) {
            if (this.amn.bnO() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.amn.getId();
            String bnW = this.amn.bnW();
            this.gfY.c(String.valueOf(this.amn.getFid()), bnW, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csO() {
        int i;
        if (this.amn != null && this.gfY != null) {
            if (this.amn.bnN() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.amn.getId();
            String bnW = this.amn.bnW();
            this.gfY.c(String.valueOf(this.amn.getFid()), bnW, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csP() {
        com.baidu.tieba.frs.b.cBE().X(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csQ() {
        com.baidu.tieba.frs.a.cBx().X(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csR() {
        if (this.mPageContext != null && this.amn != null) {
            BawuThrones cBJ = com.baidu.tieba.frs.c.cBI().cBJ();
            if (cBJ == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (cBJ.total_recommend_num.intValue() == cBJ.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.cBI().b(this.mPageContext, String.valueOf(this.amn.getFid()), this.amn.getId());
            } else {
                com.baidu.tieba.frs.c.cBI().eX(String.valueOf(this.amn.getFid()), this.amn.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.amn));
    }

    public void dismissAllDialog() {
        csK();
        csL();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
