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
/* loaded from: classes6.dex */
public class aa extends com.baidu.tbadk.core.dialog.i {
    private bj Np;
    private boolean ddJ;
    private com.baidu.tbadk.core.dialog.a fHS;
    private ForumManageModel fHZ;
    private final com.baidu.adp.base.d fIe;
    private final com.baidu.tbadk.core.dialog.k fJp;
    private com.baidu.tbadk.core.dialog.a fJq;
    private Dialog fJr;
    private final List<com.baidu.tbadk.core.dialog.g> fJs;
    private String fJt;
    private String fJu;
    private List<BlueCheckRadioButton> fJv;
    final CompoundButton.OnCheckedChangeListener fJw;
    private final k.c fJx;
    private Context mContext;
    private TbPageContext mPageContext;

    public aa(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.fJt = "0";
        this.fJu = this.fJt;
        this.ddJ = false;
        this.fJw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.aa.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    aa.this.fJu = (String) compoundButton.getTag();
                    if (aa.this.fJv != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : aa.this.fJv) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && aa.this.fJu != null && !str.equals(aa.this.fJu)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.fIe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.aa.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && aa.this.fHZ != null) {
                    switch (aa.this.fHZ.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.fVU != 0) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, aa.this.Np.getId()));
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.kif) ? bVar.kif : aa.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (aa.this.fJq == null) {
                                        aa.this.fJq = new com.baidu.tbadk.core.dialog.a(aa.this.mPageContext.getPageActivity());
                                        aa.this.fJq.sC(string);
                                        aa.this.fJq.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.aa.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        aa.this.fJq.fz(true);
                                        aa.this.fJq.b(aa.this.mPageContext);
                                    }
                                    aa.this.fJq.aCp();
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
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kif) ? dVar.kif : aa.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kif) ? dVar.kif : aa.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            aa.this.a(aa.this.fHZ.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                aa.this.ac(gVar.kii);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.fJx = new k.c() { // from class: com.baidu.tieba.card.aa.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                aa.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (aa.this.Np != null && aa.this.Np.azX() != null) {
                        if (UtilHelper.isCurrentAccount(aa.this.Np.azX().getUserId())) {
                            aa.this.btF();
                        } else {
                            aa.this.rk(1);
                        }
                    }
                } else if (i == 2) {
                    aa.this.btG();
                } else if (i == 3) {
                    aa.this.btH();
                } else if (i == 4) {
                    aa.this.ae(aa.this.fJt, true);
                } else if (i == 5) {
                    aa.this.btI();
                }
                aa.this.rl(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fJs = new ArrayList();
        this.fJp = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.fJp.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.fJp.a(this.fJx);
        this.fHZ = new ForumManageModel(this.mPageContext);
        this.fHZ.setLoadDataCallBack(this.fIe);
        this.ddJ = z;
        a(this.fJp);
    }

    public void onChangeSkinType() {
        if (this.fJp != null) {
            this.fJp.onChangeSkinType();
        }
        if (this.fHS != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fHS.getRealView());
        }
        if (this.fJq != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fJq.getRealView());
        }
    }

    private void createView() {
        if (this.Np != null && this.fJs != null && this.fJp != null) {
            this.fJs.clear();
            if (!com.baidu.tieba.frs.g.bBW()) {
                if (!this.Np.isBjh()) {
                    this.fJs.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.fJp));
                }
                String str = "";
                if (this.Np.azX() != null) {
                    str = this.Np.azX().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.fJs.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.fJp));
                }
            }
            if (com.baidu.tieba.frs.g.bBV() || com.baidu.tieba.frs.g.bBW()) {
                this.fJs.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.Np.azS() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.fJp));
                this.fJs.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.Np.azT() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.fJp));
            }
            if (!com.baidu.tieba.frs.g.bBW() && com.baidu.tieba.frs.a.bBr().bBw() && this.ddJ && !com.baidu.tieba.frs.a.bBr().bBv()) {
                this.fJs.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.fJp));
            }
            this.fJp.az(this.fJs);
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
        this.Np = bjVar;
        createView();
    }

    public void btD() {
        if (this.fHS != null && this.fHS.isShowing()) {
            this.fHS.dismiss();
        }
    }

    public void btE() {
        if (this.fJr != null && this.fJr.isShowing()) {
            this.fJr.dismiss();
        }
    }

    public void btF() {
        btD();
        if (this.mPageContext != null) {
            if (this.fHS == null) {
                this.fHS = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.fHS.jF(R.string.del_thread_confirm);
                this.fHS.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.aa.1
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
                this.fHS.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.aa.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.fHS.fz(true);
                this.fHS.b(this.mPageContext);
            }
            this.fHS.aCp();
        }
    }

    public void rk(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bBu = com.baidu.tieba.frs.a.bBr().bBu();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bBu != null && bBu.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bBu.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bBt = com.baidu.tieba.frs.a.bBr().bBt();
            for (int i3 = 0; i3 < bBt.size(); i3++) {
                jSONArray.put(bBt.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jg(i);
            alVar.M(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bBr().getForumId());
            eVar.setData(alVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.vS("1");
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
    public void ac(ArrayList<ad> arrayList) {
        if (this.fJr == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.fJr = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.fJr.setCanceledOnTouchOutside(true);
            this.fJr.setCancelable(true);
            this.fJr.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fJr.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.fJr.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fJr, aa.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fJr, aa.this.mPageContext);
                    aa.this.ae(aa.this.fJu, false);
                }
            });
        }
        com.baidu.tbadk.q.a.a(this.mPageContext, this.fJr.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.fJr.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.fJv = new ArrayList();
        BlueCheckRadioButton cT = cT(this.fJt, getString(R.string.thread_good_class, new Object[0]));
        cT.setChecked(true);
        linearLayout.addView(cT);
        this.fJv.add(cT);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ad adVar = arrayList.get(i);
                if (adVar != null && !TextUtils.isEmpty(adVar.ayt()) && adVar.ayu() > 0) {
                    BlueCheckRadioButton cT2 = cT(String.valueOf(adVar.ayu()), adVar.ayt());
                    this.fJv.add(cT2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(cT2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.fJr.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.fJr, this.mPageContext);
    }

    private BlueCheckRadioButton cT(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.fJw);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.Np != null && gVar != null && gVar.mSuccess) {
            String str = "";
            if (i == 2) {
                this.Np.jv(1);
                str = ay(gVar.kif, R.string.operation_success);
            } else if (i == 3) {
                this.Np.jv(0);
                str = ay(gVar.kif, R.string.operation_success);
            } else if (i == 4) {
                this.Np.ju(1);
                str = ay(gVar.kif, R.string.top_success);
            } else if (i == 5) {
                this.Np.ju(0);
                str = ay(gVar.kif, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.Np.getId();
            eVar.forumName = this.Np.aAc();
            eVar.forumId = String.valueOf(this.Np.getFid());
            eVar.kig = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.kif)) {
            string = gVar.kif;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String ay(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl(int i) {
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
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).Z("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btG() {
        if (this.mContext != null && this.Np != null && this.Np.azX() != null) {
            String userId = this.Np.azX().getUserId();
            String userName = this.Np.azX().getUserName();
            String name_show = this.Np.azX().getName_show();
            String id = this.Np.getId();
            String aAc = this.Np.aAc();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.Np.getFid()), aAc, id, userId, userName, name_show, null, this.Np.azX().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(JSONArray jSONArray) {
        if (this.fHZ != null && this.Np != null && this.Np.azX() != null) {
            String userId = this.Np.azX().getUserId();
            String id = this.Np.getId();
            String aAc = this.Np.aAc();
            String valueOf = String.valueOf(this.Np.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.fHZ.IT(aq.O(jSONArray));
            }
            this.fHZ.a(valueOf, aAc, id, null, 0, 1, isCurrentAccount, this.Np.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(String str, boolean z) {
        int i;
        if (this.Np != null && this.fHZ != null) {
            if (this.Np.azT() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.Np.getId();
            String aAc = this.Np.aAc();
            this.fHZ.b(String.valueOf(this.Np.getFid()), aAc, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btH() {
        int i;
        if (this.Np != null && this.fHZ != null) {
            if (this.Np.azS() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.Np.getId();
            String aAc = this.Np.aAc();
            this.fHZ.b(String.valueOf(this.Np.getFid()), aAc, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btI() {
        com.baidu.tieba.frs.a.bBr().G(true, false);
        TiebaStatic.log(new an("c13125").cp("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        btD();
        btE();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
