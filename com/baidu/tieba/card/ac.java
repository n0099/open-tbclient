package com.baidu.tieba.card;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
import tbclient.DeleteThreadInfo;
/* loaded from: classes20.dex */
public class ac extends com.baidu.tbadk.core.dialog.i {
    private bx akt;
    private boolean eVP;
    private com.baidu.tbadk.core.dialog.a hZi;
    private ForumManageModel hZq;
    private final com.baidu.adp.base.d hZx;
    private final com.baidu.tbadk.core.dialog.k iaR;
    private com.baidu.tbadk.core.dialog.a iaS;
    private Dialog iaT;
    private final List<com.baidu.tbadk.core.dialog.g> iaU;
    private String iaV;
    private String iaW;
    private List<BlueCheckRadioButton> iaX;
    final CompoundButton.OnCheckedChangeListener iaY;
    private final k.c iaZ;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.iaV = "0";
        this.iaW = this.iaV;
        this.eVP = false;
        this.iaY = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.iaW = (String) compoundButton.getTag();
                    if (ac.this.iaX != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.iaX) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.iaW != null && !str.equals(ac.this.iaW)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.hZx = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ac.this.hZq != null) {
                    switch (ac.this.hZq.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.ioW != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.QR) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ac.this.akt.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.naF) ? bVar.naF : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.iaS == null) {
                                        ac.this.iaS = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.iaS.AJ(string);
                                        ac.this.iaS.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.iaS.iW(true);
                                        ac.this.iaS.b(ac.this.mPageContext);
                                    }
                                    ac.this.iaS.bog();
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
                            } else if (dVar.QR) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.naF) ? dVar.naF : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.naF) ? dVar.naF : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.hZq.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.QR) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.ap(gVar.naI);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.iaZ = new k.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.akt != null && ac.this.akt.blC() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.akt.blC().getUserId())) {
                            ac.this.cnX();
                        } else {
                            ac.this.xF(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.cnY();
                } else if (i == 3) {
                    ac.this.cnZ();
                } else if (i == 4) {
                    ac.this.aH(ac.this.iaV, true);
                } else if (i == 5) {
                    ac.this.coa();
                } else if (i == 6) {
                    ac.this.coc();
                } else if (i == 7) {
                    ac.this.cob();
                } else if (i == 8) {
                    ac.this.cod();
                }
                ac.this.xG(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.iaU = new ArrayList();
        this.iaR = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.iaR.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.iaR.a(this.iaZ);
        this.hZq = new ForumManageModel(this.mPageContext);
        this.hZq.setLoadDataCallBack(this.hZx);
        this.eVP = z;
        a(this.iaR);
    }

    public void onChangeSkinType() {
        if (this.iaR != null) {
            this.iaR.onChangeSkinType();
        }
        if (this.hZi != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hZi.getRealView());
        }
        if (this.iaS != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.iaS.getRealView());
        }
    }

    private void createView() {
        if (this.akt != null && this.iaU != null && this.iaR != null) {
            this.iaU.clear();
            if (!com.baidu.tieba.frs.j.cxA()) {
                if (!this.akt.isBjh()) {
                    this.iaU.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.iaR));
                }
                String str = "";
                if (this.akt.blC() != null) {
                    str = this.akt.blC().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.iaU.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.iaR));
                }
            }
            if (com.baidu.tieba.frs.j.cxz() || com.baidu.tieba.frs.j.cxA()) {
                this.iaU.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.akt.blx() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.iaR));
                this.iaU.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.akt.bly() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.iaR));
            }
            if (com.baidu.tieba.frs.j.cxz()) {
                this.iaU.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.iaR));
            }
            if (com.baidu.tieba.frs.j.cxz() && this.eVP) {
                this.iaU.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.iaR));
            }
            if (com.baidu.tieba.frs.j.cxz() || com.baidu.tieba.frs.j.cxA()) {
                this.iaU.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.iaR));
            }
            if (!com.baidu.tieba.frs.j.cxA() && com.baidu.tieba.frs.b.cwO().cwQ() && this.eVP) {
                this.iaU.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.iaR));
            }
            this.iaR.br(this.iaU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bx bxVar) {
        this.akt = bxVar;
        createView();
    }

    public void cnV() {
        if (this.hZi != null && this.hZi.isShowing()) {
            this.hZi.dismiss();
        }
    }

    public void cnW() {
        if (this.iaT != null && this.iaT.isShowing()) {
            this.iaT.dismiss();
        }
    }

    public void cnX() {
        cnV();
        if (this.mPageContext != null) {
            if (this.hZi == null) {
                this.hZi = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hZi.os(R.string.del_thread_confirm);
                this.hZi.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
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
                this.hZi.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.hZi.iW(true);
                this.hZi.b(this.mPageContext);
            }
            this.hZi.bog();
        }
    }

    public void xF(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData cwP = com.baidu.tieba.frs.b.cwO().cwP();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cwP != null && cwP.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cwP.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bx> cwL = com.baidu.tieba.frs.b.cwO().cwL();
            for (int i3 = 0; i3 < cwL.size(); i3++) {
                jSONArray.put(cwL.get(i3).getTid());
            }
            as asVar = new as();
            asVar.setFeedBackReasonMap(sparseArray);
            asVar.nS(i);
            asVar.P(jSONArray);
            asVar.setFid(com.baidu.tieba.frs.b.cwO().getForumId());
            eVar.setData(asVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.Ev("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ac.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.neterror);
                    } else {
                        ac.this.X(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(ArrayList<ak> arrayList) {
        if (this.iaT == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.iaT = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.iaT.setCanceledOnTouchOutside(true);
            this.iaT.setCancelable(true);
            this.iaT.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.iaT.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.iaT.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.iaT, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.iaT, ac.this.mPageContext);
                    ac.this.aH(ac.this.iaW, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.iaT.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.iaT.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.iaX = new ArrayList();
        BlueCheckRadioButton eE = eE(this.iaV, getString(R.string.thread_good_class, new Object[0]));
        eE.setChecked(true);
        linearLayout.addView(eE);
        this.iaX.add(eE);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ak akVar = arrayList.get(i);
                if (akVar != null && !TextUtils.isEmpty(akVar.bjQ()) && akVar.bjR() > 0) {
                    BlueCheckRadioButton eE2 = eE(String.valueOf(akVar.bjR()), akVar.bjQ());
                    this.iaX.add(eE2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(eE2);
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                }
            }
            ScrollView scrollView = (ScrollView) this.iaT.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.iaT, this.mPageContext);
    }

    private BlueCheckRadioButton eE(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.iaY);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.akt != null && gVar != null && gVar.QR) {
            String str = "";
            if (i == 2) {
                this.akt.oi(1);
                com.baidu.tbadk.core.data.y yVar = new com.baidu.tbadk.core.data.y();
                yVar.type = 2;
                yVar.tid = this.akt.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, yVar));
            } else if (i == 3) {
                this.akt.oi(0);
                str = aL(gVar.naF, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.akt.oh(1);
                com.baidu.tbadk.core.data.y yVar2 = new com.baidu.tbadk.core.data.y();
                yVar2.type = 1;
                yVar2.tid = this.akt.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, yVar2));
            } else if (i == 5) {
                this.akt.oh(0);
                str = aL(gVar.naF, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.akt.getId();
            eVar.forumName = this.akt.blG();
            eVar.forumId = String.valueOf(this.akt.getFid());
            eVar.naG = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.naF)) {
            string = gVar.naF;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aL(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG(int i) {
        if (this.akt != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).ak("obj_type", i).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.akt.getFid()).dR("tid", this.akt.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnY() {
        if (this.mContext != null && this.akt != null && this.akt.blC() != null) {
            String userId = this.akt.blC().getUserId();
            String userName = this.akt.blC().getUserName();
            String name_show = this.akt.blC().getName_show();
            String id = this.akt.getId();
            String blG = this.akt.blG();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.akt.getFid()), blG, id, userId, userName, name_show, null, this.akt.blC().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.hZq != null && this.akt != null && this.akt.blC() != null) {
            String userId = this.akt.blC().getUserId();
            String id = this.akt.getId();
            String blG = this.akt.blG();
            String valueOf = String.valueOf(this.akt.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.hZq.SE(au.R(jSONArray));
            }
            this.hZq.a(valueOf, blG, id, null, 0, 1, isCurrentAccount, this.akt.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, boolean z) {
        int i;
        if (this.akt != null && this.hZq != null) {
            if (this.akt.bly() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.akt.getId();
            String blG = this.akt.blG();
            this.hZq.b(String.valueOf(this.akt.getFid()), blG, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnZ() {
        int i;
        if (this.akt != null && this.hZq != null) {
            if (this.akt.blx() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.akt.getId();
            String blG = this.akt.blG();
            this.hZq.b(String.valueOf(this.akt.getFid()), blG, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coa() {
        com.baidu.tieba.frs.b.cwO().V(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cob() {
        com.baidu.tieba.frs.a.cwH().V(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coc() {
        if (this.mPageContext != null && this.akt != null) {
            BawuThrones cwT = com.baidu.tieba.frs.c.cwS().cwT();
            if (cwT == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (cwT.total_recommend_num.intValue() == cwT.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.cwS().b(this.mPageContext, String.valueOf(this.akt.getFid()), this.akt.getId());
            } else {
                com.baidu.tieba.frs.c.cwS().eS(String.valueOf(this.akt.getFid()), this.akt.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.akt));
    }

    public void dismissAllDialog() {
        cnV();
        cnW();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
