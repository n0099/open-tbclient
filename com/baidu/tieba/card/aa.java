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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes8.dex */
public class aa extends com.baidu.tbadk.core.dialog.i {
    private bj agz;
    private boolean dIk;
    private com.baidu.tbadk.core.dialog.a gpT;
    private ForumManageModel gqa;
    private final com.baidu.adp.base.d gqf;
    private final com.baidu.tbadk.core.dialog.k grq;
    private com.baidu.tbadk.core.dialog.a grr;
    private Dialog grs;
    private final List<com.baidu.tbadk.core.dialog.g> grt;
    private String gru;
    private String grv;
    private List<BlueCheckRadioButton> grw;
    final CompoundButton.OnCheckedChangeListener grx;
    private final k.c gry;
    private Context mContext;
    private TbPageContext mPageContext;

    public aa(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.gru = "0";
        this.grv = this.gru;
        this.dIk = false;
        this.grx = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.aa.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    aa.this.grv = (String) compoundButton.getTag();
                    if (aa.this.grw != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : aa.this.grw) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && aa.this.grv != null && !str.equals(aa.this.grv)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.gqf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.aa.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && aa.this.gqa != null) {
                    switch (aa.this.gqa.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gFx != 0) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.OG) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, aa.this.agz.getId()));
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.kVc) ? bVar.kVc : aa.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (aa.this.grr == null) {
                                        aa.this.grr = new com.baidu.tbadk.core.dialog.a(aa.this.mPageContext.getPageActivity());
                                        aa.this.grr.uf(string);
                                        aa.this.grr.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.aa.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        aa.this.grr.gE(true);
                                        aa.this.grr.b(aa.this.mPageContext);
                                    }
                                    aa.this.grr.aMU();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.OG) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kVc) ? dVar.kVc : aa.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kVc) ? dVar.kVc : aa.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            aa.this.a(aa.this.gqa.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.OG) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                aa.this.ae(gVar.kVf);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.gry = new k.c() { // from class: com.baidu.tieba.card.aa.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                aa.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (aa.this.agz != null && aa.this.agz.aKE() != null) {
                        if (UtilHelper.isCurrentAccount(aa.this.agz.aKE().getUserId())) {
                            aa.this.bFc();
                        } else {
                            aa.this.rL(1);
                        }
                    }
                } else if (i == 2) {
                    aa.this.bFd();
                } else if (i == 3) {
                    aa.this.bFe();
                } else if (i == 4) {
                    aa.this.ak(aa.this.gru, true);
                } else if (i == 5) {
                    aa.this.bFf();
                }
                aa.this.rM(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.grt = new ArrayList();
        this.grq = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.grq.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.grq.a(this.gry);
        this.gqa = new ForumManageModel(this.mPageContext);
        this.gqa.setLoadDataCallBack(this.gqf);
        this.dIk = z;
        a(this.grq);
    }

    public void onChangeSkinType() {
        if (this.grq != null) {
            this.grq.onChangeSkinType();
        }
        if (this.gpT != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.gpT.getRealView());
        }
        if (this.grr != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.grr.getRealView());
        }
    }

    private void createView() {
        if (this.agz != null && this.grt != null && this.grq != null) {
            this.grt.clear();
            if (!com.baidu.tieba.frs.g.bOj()) {
                if (!this.agz.isBjh()) {
                    this.grt.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.grq));
                }
                String str = "";
                if (this.agz.aKE() != null) {
                    str = this.agz.aKE().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.grt.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.grq));
                }
            }
            if (com.baidu.tieba.frs.g.bOi() || com.baidu.tieba.frs.g.bOj()) {
                this.grt.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.agz.aKz() == 1 ? R.string.cancel_top : R.string.f1287top, new Object[0]), this.grq));
                this.grt.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.agz.aKA() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.grq));
            }
            if (!com.baidu.tieba.frs.g.bOj() && com.baidu.tieba.frs.a.bND().bNH() && this.dIk) {
                this.grt.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.grq));
            }
            this.grq.aI(this.grt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bj bjVar) {
        this.agz = bjVar;
        createView();
    }

    public void bFa() {
        if (this.gpT != null && this.gpT.isShowing()) {
            this.gpT.dismiss();
        }
    }

    public void bFb() {
        if (this.grs != null && this.grs.isShowing()) {
            this.grs.dismiss();
        }
    }

    public void bFc() {
        bFa();
        if (this.mPageContext != null) {
            if (this.gpT == null) {
                this.gpT = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.gpT.kd(R.string.del_thread_confirm);
                this.gpT.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.aa.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.neterror);
                        } else {
                            aa.this.U(null);
                        }
                    }
                });
                this.gpT.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.aa.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.gpT.gE(true);
                this.gpT.b(this.mPageContext);
            }
            this.gpT.aMU();
        }
    }

    public void rL(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bNG = com.baidu.tieba.frs.a.bND().bNG();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bNG != null && bNG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNG.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bNF = com.baidu.tieba.frs.a.bND().bNF();
            for (int i3 = 0; i3 < bNF.size(); i3++) {
                jSONArray.put(bNF.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jF(i);
            alVar.N(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bND().getForumId());
            eVar.setData(alVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.xA("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.aa.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.neterror);
                    } else {
                        aa.this.U(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(ArrayList<ad> arrayList) {
        if (this.grs == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.grs = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.grs.setCanceledOnTouchOutside(true);
            this.grs.setCancelable(true);
            this.grs.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.grs.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.grs.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.grs, aa.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.grs, aa.this.mPageContext);
                    aa.this.ak(aa.this.grv, false);
                }
            });
        }
        com.baidu.tbadk.q.a.a(this.mPageContext, this.grs.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.grs.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.grw = new ArrayList();
        BlueCheckRadioButton dp = dp(this.gru, getString(R.string.thread_good_class, new Object[0]));
        dp.setChecked(true);
        linearLayout.addView(dp);
        this.grw.add(dp);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ad adVar = arrayList.get(i);
                if (adVar != null && !TextUtils.isEmpty(adVar.aIZ()) && adVar.aJa() > 0) {
                    BlueCheckRadioButton dp2 = dp(String.valueOf(adVar.aJa()), adVar.aIZ());
                    this.grw.add(dp2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(dp2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.grs.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.grs, this.mPageContext);
    }

    private BlueCheckRadioButton dp(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.grx);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.agz != null && gVar != null && gVar.OG) {
            String str = "";
            if (i == 2) {
                this.agz.jT(1);
                str = aG(gVar.kVc, R.string.operation_success);
            } else if (i == 3) {
                this.agz.jT(0);
                str = aG(gVar.kVc, R.string.operation_success);
            } else if (i == 4) {
                this.agz.jS(1);
                str = aG(gVar.kVc, R.string.top_success);
            } else if (i == 5) {
                this.agz.jS(0);
                str = aG(gVar.kVc, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.agz.getId();
            eVar.forumName = this.agz.aKJ();
            eVar.forumId = String.valueOf(this.agz.getFid());
            eVar.kVd = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.kVc)) {
            string = gVar.kVc;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aG(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rM(int i) {
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
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).af("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFd() {
        if (this.mContext != null && this.agz != null && this.agz.aKE() != null) {
            String userId = this.agz.aKE().getUserId();
            String userName = this.agz.aKE().getUserName();
            String name_show = this.agz.aKE().getName_show();
            String id = this.agz.getId();
            String aKJ = this.agz.aKJ();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.agz.getFid()), aKJ, id, userId, userName, name_show, null, this.agz.aKE().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(JSONArray jSONArray) {
        if (this.gqa != null && this.agz != null && this.agz.aKE() != null) {
            String userId = this.agz.aKE().getUserId();
            String id = this.agz.getId();
            String aKJ = this.agz.aKJ();
            String valueOf = String.valueOf(this.agz.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.gqa.KQ(aq.P(jSONArray));
            }
            this.gqa.a(valueOf, aKJ, id, null, 0, 1, isCurrentAccount, this.agz.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(String str, boolean z) {
        int i;
        if (this.agz != null && this.gqa != null) {
            if (this.agz.aKA() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.agz.getId();
            String aKJ = this.agz.aKJ();
            this.gqa.b(String.valueOf(this.agz.getFid()), aKJ, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFe() {
        int i;
        if (this.agz != null && this.gqa != null) {
            if (this.agz.aKz() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.agz.getId();
            String aKJ = this.agz.aKJ();
            this.gqa.b(String.valueOf(this.agz.getFid()), aKJ, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFf() {
        com.baidu.tieba.frs.a.bND().I(true, false);
        TiebaStatic.log(new an("c13125").cI("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        bFa();
        bFb();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
