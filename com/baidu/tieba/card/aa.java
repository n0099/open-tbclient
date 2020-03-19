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
    private bj NR;
    private boolean dip;
    private com.baidu.tbadk.core.dialog.a fLm;
    private ForumManageModel fLt;
    private final com.baidu.adp.base.d fLy;
    private final com.baidu.tbadk.core.dialog.k fMJ;
    private com.baidu.tbadk.core.dialog.a fMK;
    private Dialog fML;
    private final List<com.baidu.tbadk.core.dialog.g> fMM;
    private String fMN;
    private String fMO;
    private List<BlueCheckRadioButton> fMP;
    final CompoundButton.OnCheckedChangeListener fMQ;
    private final k.c fMR;
    private Context mContext;
    private TbPageContext mPageContext;

    public aa(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.fMN = "0";
        this.fMO = this.fMN;
        this.dip = false;
        this.fMQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.aa.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    aa.this.fMO = (String) compoundButton.getTag();
                    if (aa.this.fMP != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : aa.this.fMP) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && aa.this.fMO != null && !str.equals(aa.this.fMO)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.fLy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.aa.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && aa.this.fLt != null) {
                    switch (aa.this.fLt.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.fYS != 0) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, aa.this.NR.getId()));
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.kkW) ? bVar.kkW : aa.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (aa.this.fMK == null) {
                                        aa.this.fMK = new com.baidu.tbadk.core.dialog.a(aa.this.mPageContext.getPageActivity());
                                        aa.this.fMK.sS(string);
                                        aa.this.fMK.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.aa.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        aa.this.fMK.fH(true);
                                        aa.this.fMK.b(aa.this.mPageContext);
                                    }
                                    aa.this.fMK.aEG();
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
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kkW) ? dVar.kkW : aa.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kkW) ? dVar.kkW : aa.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            aa.this.a(aa.this.fLt.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                aa.this.ad(gVar.kkZ);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.fMR = new k.c() { // from class: com.baidu.tieba.card.aa.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                aa.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (aa.this.NR != null && aa.this.NR.aCr() != null) {
                        if (UtilHelper.isCurrentAccount(aa.this.NR.aCr().getUserId())) {
                            aa.this.bvr();
                        } else {
                            aa.this.rt(1);
                        }
                    }
                } else if (i == 2) {
                    aa.this.bvs();
                } else if (i == 3) {
                    aa.this.bvt();
                } else if (i == 4) {
                    aa.this.ae(aa.this.fMN, true);
                } else if (i == 5) {
                    aa.this.bvu();
                }
                aa.this.ru(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fMM = new ArrayList();
        this.fMJ = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.fMJ.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.fMJ.a(this.fMR);
        this.fLt = new ForumManageModel(this.mPageContext);
        this.fLt.setLoadDataCallBack(this.fLy);
        this.dip = z;
        a(this.fMJ);
    }

    public void onChangeSkinType() {
        if (this.fMJ != null) {
            this.fMJ.onChangeSkinType();
        }
        if (this.fLm != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fLm.getRealView());
        }
        if (this.fMK != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fMK.getRealView());
        }
    }

    private void createView() {
        if (this.NR != null && this.fMM != null && this.fMJ != null) {
            this.fMM.clear();
            if (!com.baidu.tieba.frs.g.bDK()) {
                if (!this.NR.isBjh()) {
                    this.fMM.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.fMJ));
                }
                String str = "";
                if (this.NR.aCr() != null) {
                    str = this.NR.aCr().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.fMM.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.fMJ));
                }
            }
            if (com.baidu.tieba.frs.g.bDJ() || com.baidu.tieba.frs.g.bDK()) {
                this.fMM.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.NR.aCm() == 1 ? R.string.cancel_top : R.string.f1281top, new Object[0]), this.fMJ));
                this.fMM.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.NR.aCn() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.fMJ));
            }
            if (!com.baidu.tieba.frs.g.bDK() && com.baidu.tieba.frs.a.bDd().bDj() && this.dip && !com.baidu.tieba.frs.a.bDd().bDh() && !com.baidu.tieba.frs.a.bDd().bDi()) {
                this.fMM.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.fMJ));
            }
            this.fMJ.az(this.fMM);
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
        this.NR = bjVar;
        createView();
    }

    public void bvp() {
        if (this.fLm != null && this.fLm.isShowing()) {
            this.fLm.dismiss();
        }
    }

    public void bvq() {
        if (this.fML != null && this.fML.isShowing()) {
            this.fML.dismiss();
        }
    }

    public void bvr() {
        bvp();
        if (this.mPageContext != null) {
            if (this.fLm == null) {
                this.fLm = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.fLm.jW(R.string.del_thread_confirm);
                this.fLm.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.aa.1
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
                this.fLm.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.aa.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.fLm.fH(true);
                this.fLm.b(this.mPageContext);
            }
            this.fLm.aEG();
        }
    }

    public void rt(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bDg = com.baidu.tieba.frs.a.bDd().bDg();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bDg != null && bDg.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bDg.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bDf = com.baidu.tieba.frs.a.bDd().bDf();
            for (int i3 = 0; i3 < bDf.size(); i3++) {
                jSONArray.put(bDf.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jy(i);
            alVar.M(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bDd().getForumId());
            eVar.setData(alVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.wo("1");
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
        if (this.fML == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.fML = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.fML.setCanceledOnTouchOutside(true);
            this.fML.setCancelable(true);
            this.fML.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fML.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.fML.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fML, aa.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fML, aa.this.mPageContext);
                    aa.this.ae(aa.this.fMO, false);
                }
            });
        }
        com.baidu.tbadk.q.a.a(this.mPageContext, this.fML.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.fML.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.fMP = new ArrayList();
        BlueCheckRadioButton db = db(this.fMN, getString(R.string.thread_good_class, new Object[0]));
        db.setChecked(true);
        linearLayout.addView(db);
        this.fMP.add(db);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ad adVar = arrayList.get(i);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAM()) && adVar.aAN() > 0) {
                    BlueCheckRadioButton db2 = db(String.valueOf(adVar.aAN()), adVar.aAM());
                    this.fMP.add(db2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(db2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.fML.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.fML, this.mPageContext);
    }

    private BlueCheckRadioButton db(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.fMQ);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.NR != null && gVar != null && gVar.mSuccess) {
            String str = "";
            if (i == 2) {
                this.NR.jM(1);
                str = aw(gVar.kkW, R.string.operation_success);
            } else if (i == 3) {
                this.NR.jM(0);
                str = aw(gVar.kkW, R.string.operation_success);
            } else if (i == 4) {
                this.NR.jL(1);
                str = aw(gVar.kkW, R.string.top_success);
            } else if (i == 5) {
                this.NR.jL(0);
                str = aw(gVar.kkW, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.NR.getId();
            eVar.forumName = this.NR.aCw();
            eVar.forumId = String.valueOf(this.NR.getFid());
            eVar.kkX = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.kkW)) {
            string = gVar.kkW;
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
    public void ru(int i) {
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
    public void bvs() {
        if (this.mContext != null && this.NR != null && this.NR.aCr() != null) {
            String userId = this.NR.aCr().getUserId();
            String userName = this.NR.aCr().getUserName();
            String name_show = this.NR.aCr().getName_show();
            String id = this.NR.getId();
            String aCw = this.NR.aCw();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.NR.getFid()), aCw, id, userId, userName, name_show, null, this.NR.aCr().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(JSONArray jSONArray) {
        if (this.fLt != null && this.NR != null && this.NR.aCr() != null) {
            String userId = this.NR.aCr().getUserId();
            String id = this.NR.getId();
            String aCw = this.NR.aCw();
            String valueOf = String.valueOf(this.NR.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.fLt.Jh(aq.O(jSONArray));
            }
            this.fLt.a(valueOf, aCw, id, null, 0, 1, isCurrentAccount, this.NR.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(String str, boolean z) {
        int i;
        if (this.NR != null && this.fLt != null) {
            if (this.NR.aCn() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.NR.getId();
            String aCw = this.NR.aCw();
            this.fLt.b(String.valueOf(this.NR.getFid()), aCw, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvt() {
        int i;
        if (this.NR != null && this.fLt != null) {
            if (this.NR.aCm() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.NR.getId();
            String aCw = this.NR.aCw();
            this.fLt.b(String.valueOf(this.NR.getFid()), aCw, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvu() {
        com.baidu.tieba.frs.a.bDd().I(true, false);
        TiebaStatic.log(new an("c13125").cx("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        bvp();
        bvq();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
