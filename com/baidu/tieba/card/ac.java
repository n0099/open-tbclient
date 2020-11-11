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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
import tbclient.DeleteThreadInfo;
/* loaded from: classes21.dex */
public class ac extends com.baidu.tbadk.core.dialog.i {
    private bw akq;
    private boolean eWH;
    private com.baidu.tbadk.core.dialog.a hYI;
    private ForumManageModel hYQ;
    private final com.baidu.adp.base.d hYX;
    private final com.baidu.tbadk.core.dialog.k iap;
    private com.baidu.tbadk.core.dialog.a iaq;
    private Dialog iar;
    private final List<com.baidu.tbadk.core.dialog.g> ias;
    private String iat;
    private String iau;
    private List<BlueCheckRadioButton> iav;
    final CompoundButton.OnCheckedChangeListener iaw;
    private final k.c iax;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.iat = "0";
        this.iau = this.iat;
        this.eWH = false;
        this.iaw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.iau = (String) compoundButton.getTag();
                    if (ac.this.iav != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.iav) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.iau != null && !str.equals(ac.this.iau)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.hYX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ac.this.hYQ != null) {
                    switch (ac.this.hYQ.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.ioi != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.QP) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ac.this.akq.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.mZE) ? bVar.mZE : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.iaq == null) {
                                        ac.this.iaq = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.iaq.Bo(string);
                                        ac.this.iaq.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.iaq.iV(true);
                                        ac.this.iaq.b(ac.this.mPageContext);
                                    }
                                    ac.this.iaq.bpc();
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
                            } else if (dVar.QP) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.mZE) ? dVar.mZE : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.mZE) ? dVar.mZE : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.hYQ.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.QP) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.ao(gVar.mZH);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.iax = new k.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.akq != null && ac.this.akq.bmA() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.akq.bmA().getUserId())) {
                            ac.this.cov();
                        } else {
                            ac.this.xh(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.cow();
                } else if (i == 3) {
                    ac.this.cox();
                } else if (i == 4) {
                    ac.this.aH(ac.this.iat, true);
                } else if (i == 5) {
                    ac.this.coy();
                } else if (i == 6) {
                    ac.this.coA();
                } else if (i == 7) {
                    ac.this.coz();
                } else if (i == 8) {
                    ac.this.coB();
                }
                ac.this.xi(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ias = new ArrayList();
        this.iap = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.iap.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.iap.a(this.iax);
        this.hYQ = new ForumManageModel(this.mPageContext);
        this.hYQ.setLoadDataCallBack(this.hYX);
        this.eWH = z;
        a(this.iap);
    }

    public void onChangeSkinType() {
        if (this.iap != null) {
            this.iap.onChangeSkinType();
        }
        if (this.hYI != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hYI.getRealView());
        }
        if (this.iaq != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.iaq.getRealView());
        }
    }

    private void createView() {
        if (this.akq != null && this.ias != null && this.iap != null) {
            this.ias.clear();
            if (!com.baidu.tieba.frs.j.cxX()) {
                if (!this.akq.isBjh()) {
                    this.ias.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.iap));
                }
                String str = "";
                if (this.akq.bmA() != null) {
                    str = this.akq.bmA().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.ias.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.iap));
                }
            }
            if (com.baidu.tieba.frs.j.cxW() || com.baidu.tieba.frs.j.cxX()) {
                this.ias.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.akq.bmv() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.iap));
                this.ias.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.akq.bmw() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.iap));
            }
            if (com.baidu.tieba.frs.j.cxW()) {
                this.ias.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.iap));
            }
            if (com.baidu.tieba.frs.j.cxW() && this.eWH) {
                this.ias.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.iap));
            }
            if (com.baidu.tieba.frs.j.cxW() || com.baidu.tieba.frs.j.cxX()) {
                this.ias.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.iap));
            }
            if (!com.baidu.tieba.frs.j.cxX() && com.baidu.tieba.frs.b.cxm().cxo() && this.eWH) {
                this.ias.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.iap));
            }
            this.iap.br(this.ias);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bw bwVar) {
        this.akq = bwVar;
        createView();
    }

    public void cot() {
        if (this.hYI != null && this.hYI.isShowing()) {
            this.hYI.dismiss();
        }
    }

    public void cou() {
        if (this.iar != null && this.iar.isShowing()) {
            this.iar.dismiss();
        }
    }

    public void cov() {
        cot();
        if (this.mPageContext != null) {
            if (this.hYI == null) {
                this.hYI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hYI.ow(R.string.del_thread_confirm);
                this.hYI.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
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
                this.hYI.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.hYI.iV(true);
                this.hYI.b(this.mPageContext);
            }
            this.hYI.bpc();
        }
    }

    public void xh(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData cxn = com.baidu.tieba.frs.b.cxm().cxn();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cxn != null && cxn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cxn.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> cxj = com.baidu.tieba.frs.b.cxm().cxj();
            for (int i3 = 0; i3 < cxj.size(); i3++) {
                jSONArray.put(cxj.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.nW(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.cxm().getForumId());
            eVar.setData(arVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.EU("1");
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
    public void ao(ArrayList<aj> arrayList) {
        if (this.iar == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.iar = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.iar.setCanceledOnTouchOutside(true);
            this.iar.setCancelable(true);
            this.iar.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.iar.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.iar.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.iar, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.iar, ac.this.mPageContext);
                    ac.this.aH(ac.this.iau, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.iar.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.iar.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.iav = new ArrayList();
        BlueCheckRadioButton eE = eE(this.iat, getString(R.string.thread_good_class, new Object[0]));
        eE.setChecked(true);
        linearLayout.addView(eE);
        this.iav.add(eE);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aj ajVar = arrayList.get(i);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bkO()) && ajVar.bkP() > 0) {
                    BlueCheckRadioButton eE2 = eE(String.valueOf(ajVar.bkP()), ajVar.bkO());
                    this.iav.add(eE2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(eE2);
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.iar.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.iar, this.mPageContext);
    }

    private BlueCheckRadioButton eE(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.iaw);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.akq != null && gVar != null && gVar.QP) {
            String str = "";
            if (i == 2) {
                this.akq.om(1);
                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                xVar.type = 2;
                xVar.tid = this.akq.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar));
            } else if (i == 3) {
                this.akq.om(0);
                str = aM(gVar.mZE, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.akq.ol(1);
                com.baidu.tbadk.core.data.x xVar2 = new com.baidu.tbadk.core.data.x();
                xVar2.type = 1;
                xVar2.tid = this.akq.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar2));
            } else if (i == 5) {
                this.akq.ol(0);
                str = aM(gVar.mZE, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.akq.getId();
            eVar.forumName = this.akq.bmE();
            eVar.forumId = String.valueOf(this.akq.getFid());
            eVar.mZF = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.mZE)) {
            string = gVar.mZE;
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
    public void xi(int i) {
        if (this.akq != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).al("obj_type", i).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.akq.getFid()).dR("tid", this.akq.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cow() {
        if (this.mContext != null && this.akq != null && this.akq.bmA() != null) {
            String userId = this.akq.bmA().getUserId();
            String userName = this.akq.bmA().getUserName();
            String name_show = this.akq.bmA().getName_show();
            String id = this.akq.getId();
            String bmE = this.akq.bmE();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.akq.getFid()), bmE, id, userId, userName, name_show, null, this.akq.bmA().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.hYQ != null && this.akq != null && this.akq.bmA() != null) {
            String userId = this.akq.bmA().getUserId();
            String id = this.akq.getId();
            String bmE = this.akq.bmE();
            String valueOf = String.valueOf(this.akq.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.hYQ.ST(at.R(jSONArray));
            }
            this.hYQ.a(valueOf, bmE, id, null, 0, 1, isCurrentAccount, this.akq.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, boolean z) {
        int i;
        if (this.akq != null && this.hYQ != null) {
            if (this.akq.bmw() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.akq.getId();
            String bmE = this.akq.bmE();
            this.hYQ.b(String.valueOf(this.akq.getFid()), bmE, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cox() {
        int i;
        if (this.akq != null && this.hYQ != null) {
            if (this.akq.bmv() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.akq.getId();
            String bmE = this.akq.bmE();
            this.hYQ.b(String.valueOf(this.akq.getFid()), bmE, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coy() {
        com.baidu.tieba.frs.b.cxm().V(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        com.baidu.tieba.frs.a.cxf().V(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coA() {
        if (this.mPageContext != null && this.akq != null) {
            BawuThrones cxr = com.baidu.tieba.frs.c.cxq().cxr();
            if (cxr == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (cxr.total_recommend_num.intValue() == cxr.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.cxq().b(this.mPageContext, String.valueOf(this.akq.getFid()), this.akq.getId());
            } else {
                com.baidu.tieba.frs.c.cxq().eS(String.valueOf(this.akq.getFid()), this.akq.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.akq));
    }

    public void dismissAllDialog() {
        cot();
        cou();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
