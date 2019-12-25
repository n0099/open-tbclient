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
/* loaded from: classes5.dex */
public class aa extends com.baidu.tbadk.core.dialog.i {
    private bj Nl;
    private boolean ddz;
    private com.baidu.tbadk.core.dialog.a fEI;
    private ForumManageModel fEP;
    private final com.baidu.adp.base.d fEU;
    private final com.baidu.tbadk.core.dialog.k fGf;
    private com.baidu.tbadk.core.dialog.a fGg;
    private Dialog fGh;
    private final List<com.baidu.tbadk.core.dialog.g> fGi;
    private String fGj;
    private String fGk;
    private List<BlueCheckRadioButton> fGl;
    final CompoundButton.OnCheckedChangeListener fGm;
    private final k.c fGn;
    private Context mContext;
    private TbPageContext mPageContext;

    public aa(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.fGj = "0";
        this.fGk = this.fGj;
        this.ddz = false;
        this.fGm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.aa.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    aa.this.fGk = (String) compoundButton.getTag();
                    if (aa.this.fGl != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : aa.this.fGl) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && aa.this.fGk != null && !str.equals(aa.this.fGk)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.fEU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.aa.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && aa.this.fEP != null) {
                    switch (aa.this.fEP.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.fSL != 0) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, aa.this.Nl.getId()));
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.kew) ? bVar.kew : aa.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (aa.this.fGg == null) {
                                        aa.this.fGg = new com.baidu.tbadk.core.dialog.a(aa.this.mPageContext.getPageActivity());
                                        aa.this.fGg.sz(string);
                                        aa.this.fGg.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.aa.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        aa.this.fGg.fu(true);
                                        aa.this.fGg.b(aa.this.mPageContext);
                                    }
                                    aa.this.fGg.aBW();
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
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kew) ? dVar.kew : aa.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kew) ? dVar.kew : aa.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            aa.this.a(aa.this.fEP.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                aa.this.ac(gVar.keA);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.fGn = new k.c() { // from class: com.baidu.tieba.card.aa.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                aa.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (aa.this.Nl != null && aa.this.Nl.azE() != null) {
                        if (UtilHelper.isCurrentAccount(aa.this.Nl.azE().getUserId())) {
                            aa.this.bsD();
                        } else {
                            aa.this.rf(1);
                        }
                    }
                } else if (i == 2) {
                    aa.this.bsE();
                } else if (i == 3) {
                    aa.this.bsF();
                } else if (i == 4) {
                    aa.this.ae(aa.this.fGj, true);
                } else if (i == 5) {
                    aa.this.bsG();
                }
                aa.this.rg(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fGi = new ArrayList();
        this.fGf = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.fGf.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.fGf.a(this.fGn);
        this.fEP = new ForumManageModel(this.mPageContext);
        this.fEP.setLoadDataCallBack(this.fEU);
        this.ddz = z;
        a(this.fGf);
    }

    public void onChangeSkinType() {
        if (this.fGf != null) {
            this.fGf.onChangeSkinType();
        }
        if (this.fEI != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fEI.getRealView());
        }
        if (this.fGg != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fGg.getRealView());
        }
    }

    private void createView() {
        if (this.Nl != null && this.fGi != null && this.fGf != null) {
            this.fGi.clear();
            if (!com.baidu.tieba.frs.g.bAU()) {
                if (!this.Nl.isBjh()) {
                    this.fGi.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.fGf));
                }
                String str = "";
                if (this.Nl.azE() != null) {
                    str = this.Nl.azE().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.fGi.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.fGf));
                }
            }
            if (com.baidu.tieba.frs.g.bAT() || com.baidu.tieba.frs.g.bAU()) {
                this.fGi.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.Nl.azz() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.fGf));
                this.fGi.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.Nl.azA() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.fGf));
            }
            if (!com.baidu.tieba.frs.g.bAU() && com.baidu.tieba.frs.a.bAp().bAu() && this.ddz && !com.baidu.tieba.frs.a.bAp().bAt()) {
                this.fGi.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.fGf));
            }
            this.fGf.aA(this.fGi);
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
        this.Nl = bjVar;
        createView();
    }

    public void bsB() {
        if (this.fEI != null && this.fEI.isShowing()) {
            this.fEI.dismiss();
        }
    }

    public void bsC() {
        if (this.fGh != null && this.fGh.isShowing()) {
            this.fGh.dismiss();
        }
    }

    public void bsD() {
        bsB();
        if (this.mPageContext != null) {
            if (this.fEI == null) {
                this.fEI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.fEI.jF(R.string.del_thread_confirm);
                this.fEI.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.aa.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.neterror);
                        } else {
                            aa.this.S(null);
                        }
                    }
                });
                this.fEI.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.aa.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.fEI.fu(true);
                this.fEI.b(this.mPageContext);
            }
            this.fEI.aBW();
        }
    }

    public void rf(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bAs = com.baidu.tieba.frs.a.bAp().bAs();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bAs != null && bAs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bAs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bAr = com.baidu.tieba.frs.a.bAp().bAr();
            for (int i3 = 0; i3 < bAr.size(); i3++) {
                jSONArray.put(bAr.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jg(i);
            alVar.L(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bAp().getForumId());
            eVar.setData(alVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.vO("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.aa.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void R(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.neterror);
                    } else {
                        aa.this.S(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<ad> arrayList) {
        if (this.fGh == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.fGh = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.fGh.setCanceledOnTouchOutside(true);
            this.fGh.setCancelable(true);
            this.fGh.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fGh.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.fGh.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fGh, aa.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fGh, aa.this.mPageContext);
                    aa.this.ae(aa.this.fGk, false);
                }
            });
        }
        com.baidu.tbadk.q.a.a(this.mPageContext, this.fGh.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.fGh.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.fGl = new ArrayList();
        BlueCheckRadioButton cR = cR(this.fGj, getString(R.string.thread_good_class, new Object[0]));
        cR.setChecked(true);
        linearLayout.addView(cR);
        this.fGl.add(cR);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ad adVar = arrayList.get(i);
                if (adVar != null && !TextUtils.isEmpty(adVar.aya()) && adVar.ayb() > 0) {
                    BlueCheckRadioButton cR2 = cR(String.valueOf(adVar.ayb()), adVar.aya());
                    this.fGl.add(cR2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(cR2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.fGh.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.fGh, this.mPageContext);
    }

    private BlueCheckRadioButton cR(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.fGm);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.Nl != null && gVar != null && gVar.mSuccess) {
            String str = "";
            if (i == 2) {
                this.Nl.jv(1);
                str = ax(gVar.kew, R.string.operation_success);
            } else if (i == 3) {
                this.Nl.jv(0);
                str = ax(gVar.kew, R.string.operation_success);
            } else if (i == 4) {
                this.Nl.ju(1);
                str = ax(gVar.kew, R.string.top_success);
            } else if (i == 5) {
                this.Nl.ju(0);
                str = ax(gVar.kew, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.Nl.getId();
            eVar.forumName = this.Nl.azJ();
            eVar.forumId = String.valueOf(this.Nl.getFid());
            eVar.kex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.kew)) {
            string = gVar.kew;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String ax(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg(int i) {
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
    public void bsE() {
        if (this.mContext != null && this.Nl != null && this.Nl.azE() != null) {
            String userId = this.Nl.azE().getUserId();
            String userName = this.Nl.azE().getUserName();
            String name_show = this.Nl.azE().getName_show();
            String id = this.Nl.getId();
            String azJ = this.Nl.azJ();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.Nl.getFid()), azJ, id, userId, userName, name_show, null, this.Nl.azE().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(JSONArray jSONArray) {
        if (this.fEP != null && this.Nl != null && this.Nl.azE() != null) {
            String userId = this.Nl.azE().getUserId();
            String id = this.Nl.getId();
            String azJ = this.Nl.azJ();
            String valueOf = String.valueOf(this.Nl.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.fEP.IJ(aq.N(jSONArray));
            }
            this.fEP.a(valueOf, azJ, id, null, 0, 1, isCurrentAccount, this.Nl.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(String str, boolean z) {
        int i;
        if (this.Nl != null && this.fEP != null) {
            if (this.Nl.azA() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.Nl.getId();
            String azJ = this.Nl.azJ();
            this.fEP.b(String.valueOf(this.Nl.getFid()), azJ, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsF() {
        int i;
        if (this.Nl != null && this.fEP != null) {
            if (this.Nl.azz() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.Nl.getId();
            String azJ = this.Nl.azJ();
            this.fEP.b(String.valueOf(this.Nl.getFid()), azJ, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsG() {
        com.baidu.tieba.frs.a.bAp().G(true, false);
        TiebaStatic.log(new an("c13125").cp("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        bsB();
        bsC();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
