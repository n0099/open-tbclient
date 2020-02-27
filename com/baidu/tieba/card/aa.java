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
    private bj NQ;
    private boolean dhN;
    private final com.baidu.adp.base.d fKB;
    private com.baidu.tbadk.core.dialog.a fKp;
    private ForumManageModel fKw;
    private final com.baidu.tbadk.core.dialog.k fLM;
    private com.baidu.tbadk.core.dialog.a fLN;
    private Dialog fLO;
    private final List<com.baidu.tbadk.core.dialog.g> fLP;
    private String fLQ;
    private String fLR;
    private List<BlueCheckRadioButton> fLS;
    final CompoundButton.OnCheckedChangeListener fLT;
    private final k.c fLU;
    private Context mContext;
    private TbPageContext mPageContext;

    public aa(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.fLQ = "0";
        this.fLR = this.fLQ;
        this.dhN = false;
        this.fLT = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.aa.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    aa.this.fLR = (String) compoundButton.getTag();
                    if (aa.this.fLS != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : aa.this.fLS) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && aa.this.fLR != null && !str.equals(aa.this.fLR)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.fKB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.aa.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && aa.this.fKw != null) {
                    switch (aa.this.fKw.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.fXV != 0) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, aa.this.NQ.getId()));
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.kjg) ? bVar.kjg : aa.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (aa.this.fLN == null) {
                                        aa.this.fLN = new com.baidu.tbadk.core.dialog.a(aa.this.mPageContext.getPageActivity());
                                        aa.this.fLN.sS(string);
                                        aa.this.fLN.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.aa.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        aa.this.fLN.fG(true);
                                        aa.this.fLN.b(aa.this.mPageContext);
                                    }
                                    aa.this.fLN.aEA();
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
                            } else if (dVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kjg) ? dVar.kjg : aa.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kjg) ? dVar.kjg : aa.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            aa.this.a(aa.this.fKw.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                aa.this.ad(gVar.kjj);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.fLU = new k.c() { // from class: com.baidu.tieba.card.aa.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                aa.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (aa.this.NQ != null && aa.this.NQ.aCm() != null) {
                        if (UtilHelper.isCurrentAccount(aa.this.NQ.aCm().getUserId())) {
                            aa.this.bvj();
                        } else {
                            aa.this.rr(1);
                        }
                    }
                } else if (i == 2) {
                    aa.this.bvk();
                } else if (i == 3) {
                    aa.this.bvl();
                } else if (i == 4) {
                    aa.this.ae(aa.this.fLQ, true);
                } else if (i == 5) {
                    aa.this.bvm();
                }
                aa.this.rs(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fLP = new ArrayList();
        this.fLM = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.fLM.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.fLM.a(this.fLU);
        this.fKw = new ForumManageModel(this.mPageContext);
        this.fKw.setLoadDataCallBack(this.fKB);
        this.dhN = z;
        a(this.fLM);
    }

    public void onChangeSkinType() {
        if (this.fLM != null) {
            this.fLM.onChangeSkinType();
        }
        if (this.fKp != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fKp.getRealView());
        }
        if (this.fLN != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fLN.getRealView());
        }
    }

    private void createView() {
        if (this.NQ != null && this.fLP != null && this.fLM != null) {
            this.fLP.clear();
            if (!com.baidu.tieba.frs.g.bDz()) {
                if (!this.NQ.isBjh()) {
                    this.fLP.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.fLM));
                }
                String str = "";
                if (this.NQ.aCm() != null) {
                    str = this.NQ.aCm().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.fLP.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.fLM));
                }
            }
            if (com.baidu.tieba.frs.g.bDy() || com.baidu.tieba.frs.g.bDz()) {
                this.fLP.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.NQ.aCh() == 1 ? R.string.cancel_top : R.string.f1282top, new Object[0]), this.fLM));
                this.fLP.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.NQ.aCi() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.fLM));
            }
            if (!com.baidu.tieba.frs.g.bDz() && com.baidu.tieba.frs.a.bCT().bCY() && this.dhN && !com.baidu.tieba.frs.a.bCT().bCX()) {
                this.fLP.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.fLM));
            }
            this.fLM.az(this.fLP);
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
        this.NQ = bjVar;
        createView();
    }

    public void bvh() {
        if (this.fKp != null && this.fKp.isShowing()) {
            this.fKp.dismiss();
        }
    }

    public void bvi() {
        if (this.fLO != null && this.fLO.isShowing()) {
            this.fLO.dismiss();
        }
    }

    public void bvj() {
        bvh();
        if (this.mPageContext != null) {
            if (this.fKp == null) {
                this.fKp = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.fKp.jW(R.string.del_thread_confirm);
                this.fKp.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.aa.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.neterror);
                        } else {
                            aa.this.T(null);
                        }
                    }
                });
                this.fKp.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.aa.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.fKp.fG(true);
                this.fKp.b(this.mPageContext);
            }
            this.fKp.aEA();
        }
    }

    public void rr(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bCW = com.baidu.tieba.frs.a.bCT().bCW();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bCW != null && bCW.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCW.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bCV = com.baidu.tieba.frs.a.bCT().bCV();
            for (int i3 = 0; i3 < bCV.size(); i3++) {
                jSONArray.put(bCV.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jy(i);
            alVar.M(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bCT().getForumId());
            eVar.setData(alVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.wm("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.aa.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.neterror);
                    } else {
                        aa.this.T(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(ArrayList<ad> arrayList) {
        if (this.fLO == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.fLO = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.fLO.setCanceledOnTouchOutside(true);
            this.fLO.setCancelable(true);
            this.fLO.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fLO.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.fLO.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fLO, aa.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fLO, aa.this.mPageContext);
                    aa.this.ae(aa.this.fLR, false);
                }
            });
        }
        com.baidu.tbadk.q.a.a(this.mPageContext, this.fLO.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.fLO.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.fLS = new ArrayList();
        BlueCheckRadioButton dc = dc(this.fLQ, getString(R.string.thread_good_class, new Object[0]));
        dc.setChecked(true);
        linearLayout.addView(dc);
        this.fLS.add(dc);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ad adVar = arrayList.get(i);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAH()) && adVar.aAI() > 0) {
                    BlueCheckRadioButton dc2 = dc(String.valueOf(adVar.aAI()), adVar.aAH());
                    this.fLS.add(dc2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(dc2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.fLO.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.fLO, this.mPageContext);
    }

    private BlueCheckRadioButton dc(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.fLT);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.NQ != null && gVar != null && gVar.mSuccess) {
            String str = "";
            if (i == 2) {
                this.NQ.jM(1);
                str = aw(gVar.kjg, R.string.operation_success);
            } else if (i == 3) {
                this.NQ.jM(0);
                str = aw(gVar.kjg, R.string.operation_success);
            } else if (i == 4) {
                this.NQ.jL(1);
                str = aw(gVar.kjg, R.string.top_success);
            } else if (i == 5) {
                this.NQ.jL(0);
                str = aw(gVar.kjg, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.NQ.getId();
            eVar.forumName = this.NQ.aCr();
            eVar.forumId = String.valueOf(this.NQ.getFid());
            eVar.kjh = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.kjg)) {
            string = gVar.kjg;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aw(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(int i) {
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
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).X("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvk() {
        if (this.mContext != null && this.NQ != null && this.NQ.aCm() != null) {
            String userId = this.NQ.aCm().getUserId();
            String userName = this.NQ.aCm().getUserName();
            String name_show = this.NQ.aCm().getName_show();
            String id = this.NQ.getId();
            String aCr = this.NQ.aCr();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.NQ.getFid()), aCr, id, userId, userName, name_show, null, this.NQ.aCm().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(JSONArray jSONArray) {
        if (this.fKw != null && this.NQ != null && this.NQ.aCm() != null) {
            String userId = this.NQ.aCm().getUserId();
            String id = this.NQ.getId();
            String aCr = this.NQ.aCr();
            String valueOf = String.valueOf(this.NQ.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.fKw.Jg(aq.O(jSONArray));
            }
            this.fKw.a(valueOf, aCr, id, null, 0, 1, isCurrentAccount, this.NQ.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(String str, boolean z) {
        int i;
        if (this.NQ != null && this.fKw != null) {
            if (this.NQ.aCi() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.NQ.getId();
            String aCr = this.NQ.aCr();
            this.fKw.b(String.valueOf(this.NQ.getFid()), aCr, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvl() {
        int i;
        if (this.NQ != null && this.fKw != null) {
            if (this.NQ.aCh() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.NQ.getId();
            String aCr = this.NQ.aCr();
            this.fKw.b(String.valueOf(this.NQ.getFid()), aCr, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        com.baidu.tieba.frs.a.bCT().I(true, false);
        TiebaStatic.log(new an("c13125").cy("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        bvh();
        bvi();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
