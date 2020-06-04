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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
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
public class ab extends com.baidu.tbadk.core.dialog.i {
    private bk ahg;
    private boolean dWD;
    private com.baidu.tbadk.core.dialog.a gEZ;
    private ForumManageModel gFg;
    private final com.baidu.adp.base.d gFl;
    private String gGA;
    private String gGB;
    private List<BlueCheckRadioButton> gGC;
    final CompoundButton.OnCheckedChangeListener gGD;
    private final k.c gGE;
    private final com.baidu.tbadk.core.dialog.k gGw;
    private com.baidu.tbadk.core.dialog.a gGx;
    private Dialog gGy;
    private final List<com.baidu.tbadk.core.dialog.g> gGz;
    private Context mContext;
    private TbPageContext mPageContext;

    public ab(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.gGA = "0";
        this.gGB = this.gGA;
        this.dWD = false;
        this.gGD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ab.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ab.this.gGB = (String) compoundButton.getTag();
                    if (ab.this.gGC != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ab.this.gGC) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ab.this.gGB != null && !str.equals(ab.this.gGB)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.gFl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ab.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ab.this.gFg != null) {
                    switch (ab.this.gFg.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gUw != 0) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.OU) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ab.this.ahg.getId()));
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.loP) ? bVar.loP : ab.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ab.this.gGx == null) {
                                        ab.this.gGx = new com.baidu.tbadk.core.dialog.a(ab.this.mPageContext.getPageActivity());
                                        ab.this.gGx.vO(string);
                                        ab.this.gGx.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ab.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ab.this.gGx.gW(true);
                                        ab.this.gGx.b(ab.this.mPageContext);
                                    }
                                    ab.this.gGx.aST();
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
                            } else if (dVar.OU) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.loP) ? dVar.loP : ab.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.loP) ? dVar.loP : ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ab.this.a(ab.this.gFg.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.OU) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ab.this.ae(gVar.loS);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.gGE = new k.c() { // from class: com.baidu.tieba.card.ab.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ab.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ab.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ab.this.ahg != null && ab.this.ahg.aQx() != null) {
                        if (UtilHelper.isCurrentAccount(ab.this.ahg.aQx().getUserId())) {
                            ab.this.bLw();
                        } else {
                            ab.this.sr(1);
                        }
                    }
                } else if (i == 2) {
                    ab.this.bLx();
                } else if (i == 3) {
                    ab.this.bLy();
                } else if (i == 4) {
                    ab.this.ax(ab.this.gGA, true);
                } else if (i == 5) {
                    ab.this.bLz();
                }
                ab.this.ss(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gGz = new ArrayList();
        this.gGw = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.gGw.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.gGw.a(this.gGE);
        this.gFg = new ForumManageModel(this.mPageContext);
        this.gFg.setLoadDataCallBack(this.gFl);
        this.dWD = z;
        a(this.gGw);
    }

    public void onChangeSkinType() {
        if (this.gGw != null) {
            this.gGw.onChangeSkinType();
        }
        if (this.gEZ != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.gEZ.getRealView());
        }
        if (this.gGx != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.gGx.getRealView());
        }
    }

    private void createView() {
        if (this.ahg != null && this.gGz != null && this.gGw != null) {
            this.gGz.clear();
            if (!com.baidu.tieba.frs.g.bUF()) {
                if (!this.ahg.isBjh()) {
                    this.gGz.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.gGw));
                }
                String str = "";
                if (this.ahg.aQx() != null) {
                    str = this.ahg.aQx().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.gGz.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.gGw));
                }
            }
            if (com.baidu.tieba.frs.g.bUE() || com.baidu.tieba.frs.g.bUF()) {
                this.gGz.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.ahg.aQs() == 1 ? R.string.cancel_top : R.string.f1281top, new Object[0]), this.gGw));
                this.gGz.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.ahg.aQt() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.gGw));
            }
            if (!com.baidu.tieba.frs.g.bUF() && com.baidu.tieba.frs.a.bTZ().bUd() && this.dWD) {
                this.gGz.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.gGw));
            }
            this.gGw.aD(this.gGz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bk bkVar) {
        this.ahg = bkVar;
        createView();
    }

    public void bLu() {
        if (this.gEZ != null && this.gEZ.isShowing()) {
            this.gEZ.dismiss();
        }
    }

    public void bLv() {
        if (this.gGy != null && this.gGy.isShowing()) {
            this.gGy.dismiss();
        }
    }

    public void bLw() {
        bLu();
        if (this.mPageContext != null) {
            if (this.gEZ == null) {
                this.gEZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.gEZ.kF(R.string.del_thread_confirm);
                this.gEZ.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ab.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ab.this.mContext, (int) R.string.neterror);
                        } else {
                            ab.this.T(null);
                        }
                    }
                });
                this.gEZ.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ab.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.gEZ.gW(true);
                this.gEZ.b(this.mPageContext);
            }
            this.gEZ.aST();
        }
    }

    public void sr(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bUc = com.baidu.tieba.frs.a.bTZ().bUc();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bUc != null && bUc.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUc.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bk> bUb = com.baidu.tieba.frs.a.bTZ().bUb();
            for (int i3 = 0; i3 < bUb.size(); i3++) {
                jSONArray.put(bUb.get(i3).getTid());
            }
            ak akVar = new ak();
            akVar.setFeedBackReasonMap(sparseArray);
            akVar.kh(i);
            akVar.M(jSONArray);
            akVar.setFid(com.baidu.tieba.frs.a.bTZ().getForumId());
            eVar.setData(akVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.zj("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ab.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(ab.this.mContext, (int) R.string.neterror);
                    } else {
                        ab.this.T(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(ArrayList<ac> arrayList) {
        if (this.gGy == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.gGy = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.gGy.setCanceledOnTouchOutside(true);
            this.gGy.setCancelable(true);
            this.gGy.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.gGy.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.gGy.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.gGy, ab.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.gGy, ab.this.mPageContext);
                    ab.this.ax(ab.this.gGB, false);
                }
            });
        }
        com.baidu.tbadk.q.a.a(this.mPageContext, this.gGy.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.gGy.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.gGC = new ArrayList();
        BlueCheckRadioButton dP = dP(this.gGA, getString(R.string.thread_good_class, new Object[0]));
        dP.setChecked(true);
        linearLayout.addView(dP);
        this.gGC.add(dP);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.aOS()) && acVar.aOT() > 0) {
                    BlueCheckRadioButton dP2 = dP(String.valueOf(acVar.aOT()), acVar.aOS());
                    this.gGC.add(dP2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(dP2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.gGy.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.gGy, this.mPageContext);
    }

    private BlueCheckRadioButton dP(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.gGD);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.ahg != null && gVar != null && gVar.OU) {
            String str = "";
            if (i == 2) {
                this.ahg.kv(1);
                str = aH(gVar.loP, R.string.operation_success);
            } else if (i == 3) {
                this.ahg.kv(0);
                str = aH(gVar.loP, R.string.operation_success);
            } else if (i == 4) {
                this.ahg.ku(1);
                str = aH(gVar.loP, R.string.top_success);
            } else if (i == 5) {
                this.ahg.ku(0);
                str = aH(gVar.loP, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.ahg.getId();
            eVar.forumName = this.ahg.aQC();
            eVar.forumId = String.valueOf(this.ahg.getFid());
            eVar.loQ = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.loP)) {
            string = gVar.loP;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aH(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(int i) {
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
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).ag("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLx() {
        if (this.mContext != null && this.ahg != null && this.ahg.aQx() != null) {
            String userId = this.ahg.aQx().getUserId();
            String userName = this.ahg.aQx().getUserName();
            String name_show = this.ahg.aQx().getName_show();
            String id = this.ahg.getId();
            String aQC = this.ahg.aQC();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.ahg.getFid()), aQC, id, userId, userName, name_show, null, this.ahg.aQx().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(JSONArray jSONArray) {
        if (this.gFg != null && this.ahg != null && this.ahg.aQx() != null) {
            String userId = this.ahg.aQx().getUserId();
            String id = this.ahg.getId();
            String aQC = this.ahg.aQC();
            String valueOf = String.valueOf(this.ahg.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.gFg.MH(aq.O(jSONArray));
            }
            this.gFg.a(valueOf, aQC, id, null, 0, 1, isCurrentAccount, this.ahg.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, boolean z) {
        int i;
        if (this.ahg != null && this.gFg != null) {
            if (this.ahg.aQt() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.ahg.getId();
            String aQC = this.ahg.aQC();
            this.gFg.b(String.valueOf(this.ahg.getFid()), aQC, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        int i;
        if (this.ahg != null && this.gFg != null) {
            if (this.ahg.aQs() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.ahg.getId();
            String aQC = this.ahg.aQC();
            this.gFg.b(String.valueOf(this.ahg.getFid()), aQC, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLz() {
        com.baidu.tieba.frs.a.bTZ().L(true, false);
        TiebaStatic.log(new an("c13125").dh("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        bLu();
        bLv();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
