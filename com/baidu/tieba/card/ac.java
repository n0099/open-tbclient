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
    private cb akU;
    private boolean fkD;
    private ForumManageModel geq;
    private com.baidu.tbadk.core.dialog.a ixD;
    private final com.baidu.adp.base.e ixR;
    private final com.baidu.tbadk.core.dialog.k izn;
    private com.baidu.tbadk.core.dialog.a izo;
    private Dialog izp;
    private final List<com.baidu.tbadk.core.dialog.g> izq;
    private String izr;
    private String izs;
    private List<BlueCheckRadioButton> izt;
    final CompoundButton.OnCheckedChangeListener izu;
    private final k.c izv;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.izr = "0";
        this.izs = this.izr;
        this.fkD = false;
        this.izu = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.izs = (String) compoundButton.getTag();
                    if (ac.this.izt != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.izt) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.izs != null && !str.equals(ac.this.izs)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.ixR = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.ac.6
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj != null && ac.this.geq != null) {
                    switch (ac.this.geq.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.iNf != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ac.this.akU.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.nzx) ? bVar.nzx : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.izo == null) {
                                        ac.this.izo = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.izo.Au(string);
                                        ac.this.izo.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.6.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.izo.jF(true);
                                        ac.this.izo.b(ac.this.mPageContext);
                                    }
                                    ac.this.izo.bqx();
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
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.nzx) ? dVar.nzx : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.nzx) ? dVar.nzx : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.geq.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.ak(gVar.nzA);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.izv = new k.c() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.akU != null && ac.this.akU.bnQ() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.akU.bnQ().getUserId())) {
                            ac.this.csz();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new com.baidu.tieba.NEGFeedBack.g(1, ac.this.geq, ac.this.akU)));
                        }
                    }
                } else if (i == 2) {
                    ac.this.csA();
                } else if (i == 3) {
                    ac.this.csB();
                } else if (i == 4) {
                    ac.this.aI(ac.this.izr, true);
                } else if (i == 5) {
                    ac.this.csC();
                } else if (i == 6) {
                    ac.this.csE();
                } else if (i == 7) {
                    ac.this.csD();
                } else if (i == 8) {
                    ac.this.csF();
                }
                ac.this.xc(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.izq = new ArrayList();
        this.izn = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.izn.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.izn.a(this.izv);
        this.geq = new ForumManageModel(this.mPageContext);
        this.geq.setLoadDataCallBack(this.ixR);
        this.fkD = z;
        a(this.izn);
    }

    public void onChangeSkinType() {
        if (this.izn != null) {
            this.izn.onChangeSkinType();
        }
        if (this.ixD != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.ixD.getRealView());
        }
        if (this.izo != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.izo.getRealView());
        }
    }

    private void createView() {
        if (this.akU != null && this.izq != null && this.izn != null) {
            this.izq.clear();
            if (com.baidu.tieba.frs.j.a(com.baidu.tieba.frs.j.cCc()) && !com.baidu.tieba.frs.j.cCe()) {
                if (!this.akU.isBjh() && (this.akU.bnQ() == null || !this.akU.bnQ().isForumBusinessAccount() || this.akU.isSelf() || au.isOn())) {
                    this.izq.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.izn));
                }
                String str = "";
                if (this.akU.bnQ() != null) {
                    str = this.akU.bnQ().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str) && (this.akU.bnQ() == null || !this.akU.bnQ().isForumBusinessAccount())) {
                    this.izq.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.izn));
                }
            }
            if (com.baidu.tieba.frs.j.cCd() || com.baidu.tieba.frs.j.cCe()) {
                this.izq.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.akU.bnL() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.izn));
            }
            if (com.baidu.tieba.frs.j.cCd() || com.baidu.tieba.frs.j.cCf()) {
                this.izq.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.akU.bnM() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.izn));
            }
            if (com.baidu.tieba.frs.j.cCd()) {
                this.izq.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.izn));
            }
            if (com.baidu.tieba.frs.j.cCd() && this.fkD) {
                this.izq.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.izn));
            }
            if (com.baidu.tieba.frs.j.cCd() || com.baidu.tieba.frs.j.cCe()) {
                this.izq.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.izn));
            }
            if (!com.baidu.tieba.frs.j.cCe() && com.baidu.tieba.frs.b.cBr().cBt() && this.fkD && (this.akU.bnQ() == null || !this.akU.bnQ().isForumBusinessAccount() || this.akU.isSelf() || au.isOn())) {
                this.izq.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.izn));
            }
            this.izn.bw(this.izq);
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
        this.akU = cbVar;
        createView();
    }

    public void csx() {
        if (this.ixD != null && this.ixD.isShowing()) {
            this.ixD.dismiss();
        }
    }

    public void csy() {
        if (this.izp != null && this.izp.isShowing()) {
            this.izp.dismiss();
        }
    }

    public void csz() {
        csx();
        if (this.mPageContext != null) {
            if (this.ixD == null) {
                this.ixD = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.ixD.nx(R.string.del_thread_confirm);
                this.ixD.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
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
                this.ixD.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.ixD.jF(true);
                this.ixD.b(this.mPageContext);
            }
            this.ixD.bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(ArrayList<al> arrayList) {
        if (this.izp == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.izp = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.izp.setCanceledOnTouchOutside(true);
            this.izp.setCancelable(true);
            this.izp.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.izp.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.izp.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.izp, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.izp, ac.this.mPageContext);
                    ac.this.aI(ac.this.izs, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.izp.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.izp.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.izt = new ArrayList();
        BlueCheckRadioButton eK = eK(this.izr, getString(R.string.thread_good_class, new Object[0]));
        eK.setChecked(true);
        linearLayout.addView(eK);
        this.izt.add(eK);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                al alVar = arrayList.get(i);
                if (alVar != null && !TextUtils.isEmpty(alVar.bmb()) && alVar.bmc() > 0) {
                    BlueCheckRadioButton eK2 = eK(String.valueOf(alVar.bmc()), alVar.bmb());
                    this.izt.add(eK2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(eK2);
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                }
            }
            ScrollView scrollView = (ScrollView) this.izp.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.izp, this.mPageContext);
    }

    private BlueCheckRadioButton eK(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.izu);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.akU != null && gVar != null && gVar.mSuccess) {
            String str = "";
            if (i == 2) {
                this.akU.nn(1);
                com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                zVar.type = 2;
                zVar.tid = this.akU.getTid();
                if (com.baidu.tieba.frs.j.cCd()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, zVar));
                } else {
                    str = aU(gVar.nzx, R.string.set_good_success);
                    z = false;
                }
            } else if (i == 3) {
                this.akU.nn(0);
                str = aU(gVar.nzx, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.akU.nm(1);
                com.baidu.tbadk.core.data.z zVar2 = new com.baidu.tbadk.core.data.z();
                zVar2.type = 1;
                zVar2.tid = this.akU.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, zVar2));
            } else if (i == 5) {
                this.akU.nm(0);
                str = aU(gVar.nzx, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.akU.getId();
            eVar.forumName = this.akU.bnU();
            eVar.forumId = String.valueOf(this.akU.getFid());
            eVar.nzy = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.nzx)) {
            string = gVar.nzx;
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
    public void xc(int i) {
        if (this.akU != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).ap("obj_type", i).v("uid", TbadkCoreApplication.getCurrentAccountId()).v("fid", this.akU.getFid()).dR("tid", this.akU.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csA() {
        if (this.mContext != null && this.akU != null && this.akU.bnQ() != null) {
            String userId = this.akU.bnQ().getUserId();
            String userName = this.akU.bnQ().getUserName();
            String name_show = this.akU.bnQ().getName_show();
            String id = this.akU.getId();
            String bnU = this.akU.bnU();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.akU.getFid()), bnU, id, userId, userName, name_show, null, this.akU.bnQ().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.geq != null && this.akU != null && this.akU.bnQ() != null) {
            String userId = this.akU.bnQ().getUserId();
            String id = this.akU.getId();
            String bnU = this.akU.bnU();
            String valueOf = String.valueOf(this.akU.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.geq.Ts(com.baidu.tbadk.core.util.au.R(jSONArray));
            }
            this.geq.a(valueOf, bnU, id, null, 0, 1, isCurrentAccount, this.akU.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, boolean z) {
        int i;
        if (this.akU != null && this.geq != null) {
            if (this.akU.bnM() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.akU.getId();
            String bnU = this.akU.bnU();
            this.geq.c(String.valueOf(this.akU.getFid()), bnU, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csB() {
        int i;
        if (this.akU != null && this.geq != null) {
            if (this.akU.bnL() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.akU.getId();
            String bnU = this.akU.bnU();
            this.geq.c(String.valueOf(this.akU.getFid()), bnU, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csC() {
        com.baidu.tieba.frs.b.cBr().X(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csD() {
        com.baidu.tieba.frs.a.cBk().X(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csE() {
        if (this.mPageContext != null && this.akU != null) {
            BawuThrones cBw = com.baidu.tieba.frs.c.cBv().cBw();
            if (cBw == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (cBw.total_recommend_num.intValue() == cBw.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.cBv().b(this.mPageContext, String.valueOf(this.akU.getFid()), this.akU.getId());
            } else {
                com.baidu.tieba.frs.c.cBv().eX(String.valueOf(this.akU.getFid()), this.akU.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.akU));
    }

    public void dismissAllDialog() {
        csx();
        csy();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
