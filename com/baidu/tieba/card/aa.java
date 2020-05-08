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
    private bj agC;
    private boolean dIo;
    private com.baidu.tbadk.core.dialog.a gpZ;
    private ForumManageModel gqg;
    private final com.baidu.adp.base.d gql;
    private String grA;
    private String grB;
    private List<BlueCheckRadioButton> grC;
    final CompoundButton.OnCheckedChangeListener grD;
    private final k.c grE;
    private final com.baidu.tbadk.core.dialog.k grw;
    private com.baidu.tbadk.core.dialog.a grx;
    private Dialog gry;
    private final List<com.baidu.tbadk.core.dialog.g> grz;
    private Context mContext;
    private TbPageContext mPageContext;

    public aa(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.grA = "0";
        this.grB = this.grA;
        this.dIo = false;
        this.grD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.aa.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    aa.this.grB = (String) compoundButton.getTag();
                    if (aa.this.grC != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : aa.this.grC) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && aa.this.grB != null && !str.equals(aa.this.grB)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.gql = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.aa.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && aa.this.gqg != null) {
                    switch (aa.this.gqg.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gFD != 0) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.OL) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, aa.this.agC.getId()));
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.kVg) ? bVar.kVg : aa.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (aa.this.grx == null) {
                                        aa.this.grx = new com.baidu.tbadk.core.dialog.a(aa.this.mPageContext.getPageActivity());
                                        aa.this.grx.ui(string);
                                        aa.this.grx.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.aa.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        aa.this.grx.gE(true);
                                        aa.this.grx.b(aa.this.mPageContext);
                                    }
                                    aa.this.grx.aMS();
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
                            } else if (dVar.OL) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kVg) ? dVar.kVg : aa.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kVg) ? dVar.kVg : aa.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            aa.this.a(aa.this.gqg.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.OL) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                aa.this.ae(gVar.kVj);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.grE = new k.c() { // from class: com.baidu.tieba.card.aa.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                aa.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (aa.this.agC != null && aa.this.agC.aKC() != null) {
                        if (UtilHelper.isCurrentAccount(aa.this.agC.aKC().getUserId())) {
                            aa.this.bFa();
                        } else {
                            aa.this.rL(1);
                        }
                    }
                } else if (i == 2) {
                    aa.this.bFb();
                } else if (i == 3) {
                    aa.this.bFc();
                } else if (i == 4) {
                    aa.this.ak(aa.this.grA, true);
                } else if (i == 5) {
                    aa.this.bFd();
                }
                aa.this.rM(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.grz = new ArrayList();
        this.grw = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.grw.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.grw.a(this.grE);
        this.gqg = new ForumManageModel(this.mPageContext);
        this.gqg.setLoadDataCallBack(this.gql);
        this.dIo = z;
        a(this.grw);
    }

    public void onChangeSkinType() {
        if (this.grw != null) {
            this.grw.onChangeSkinType();
        }
        if (this.gpZ != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.gpZ.getRealView());
        }
        if (this.grx != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.grx.getRealView());
        }
    }

    private void createView() {
        if (this.agC != null && this.grz != null && this.grw != null) {
            this.grz.clear();
            if (!com.baidu.tieba.frs.g.bOh()) {
                if (!this.agC.isBjh()) {
                    this.grz.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.grw));
                }
                String str = "";
                if (this.agC.aKC() != null) {
                    str = this.agC.aKC().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.grz.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.grw));
                }
            }
            if (com.baidu.tieba.frs.g.bOg() || com.baidu.tieba.frs.g.bOh()) {
                this.grz.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.agC.aKx() == 1 ? R.string.cancel_top : R.string.f1279top, new Object[0]), this.grw));
                this.grz.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.agC.aKy() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.grw));
            }
            if (!com.baidu.tieba.frs.g.bOh() && com.baidu.tieba.frs.a.bNB().bNF() && this.dIo) {
                this.grz.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.grw));
            }
            this.grw.aI(this.grz);
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
        this.agC = bjVar;
        createView();
    }

    public void bEY() {
        if (this.gpZ != null && this.gpZ.isShowing()) {
            this.gpZ.dismiss();
        }
    }

    public void bEZ() {
        if (this.gry != null && this.gry.isShowing()) {
            this.gry.dismiss();
        }
    }

    public void bFa() {
        bEY();
        if (this.mPageContext != null) {
            if (this.gpZ == null) {
                this.gpZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.gpZ.kd(R.string.del_thread_confirm);
                this.gpZ.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.aa.1
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
                this.gpZ.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.aa.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.gpZ.gE(true);
                this.gpZ.b(this.mPageContext);
            }
            this.gpZ.aMS();
        }
    }

    public void rL(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bNE = com.baidu.tieba.frs.a.bNB().bNE();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bNE != null && bNE.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNE.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bND = com.baidu.tieba.frs.a.bNB().bND();
            for (int i3 = 0; i3 < bND.size(); i3++) {
                jSONArray.put(bND.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jF(i);
            alVar.N(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bNB().getForumId());
            eVar.setData(alVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.xD("1");
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
        if (this.gry == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.gry = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.gry.setCanceledOnTouchOutside(true);
            this.gry.setCancelable(true);
            this.gry.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.gry.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.gry.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.gry, aa.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.gry, aa.this.mPageContext);
                    aa.this.ak(aa.this.grB, false);
                }
            });
        }
        com.baidu.tbadk.q.a.a(this.mPageContext, this.gry.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.gry.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.grC = new ArrayList();
        BlueCheckRadioButton dp = dp(this.grA, getString(R.string.thread_good_class, new Object[0]));
        dp.setChecked(true);
        linearLayout.addView(dp);
        this.grC.add(dp);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ad adVar = arrayList.get(i);
                if (adVar != null && !TextUtils.isEmpty(adVar.aIX()) && adVar.aIY() > 0) {
                    BlueCheckRadioButton dp2 = dp(String.valueOf(adVar.aIY()), adVar.aIX());
                    this.grC.add(dp2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(dp2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.gry.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.gry, this.mPageContext);
    }

    private BlueCheckRadioButton dp(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.grD);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.agC != null && gVar != null && gVar.OL) {
            String str = "";
            if (i == 2) {
                this.agC.jT(1);
                str = aG(gVar.kVg, R.string.operation_success);
            } else if (i == 3) {
                this.agC.jT(0);
                str = aG(gVar.kVg, R.string.operation_success);
            } else if (i == 4) {
                this.agC.jS(1);
                str = aG(gVar.kVg, R.string.top_success);
            } else if (i == 5) {
                this.agC.jS(0);
                str = aG(gVar.kVg, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.agC.getId();
            eVar.forumName = this.agC.aKH();
            eVar.forumId = String.valueOf(this.agC.getFid());
            eVar.kVh = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.kVg)) {
            string = gVar.kVg;
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
    public void bFb() {
        if (this.mContext != null && this.agC != null && this.agC.aKC() != null) {
            String userId = this.agC.aKC().getUserId();
            String userName = this.agC.aKC().getUserName();
            String name_show = this.agC.aKC().getName_show();
            String id = this.agC.getId();
            String aKH = this.agC.aKH();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.agC.getFid()), aKH, id, userId, userName, name_show, null, this.agC.aKC().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(JSONArray jSONArray) {
        if (this.gqg != null && this.agC != null && this.agC.aKC() != null) {
            String userId = this.agC.aKC().getUserId();
            String id = this.agC.getId();
            String aKH = this.agC.aKH();
            String valueOf = String.valueOf(this.agC.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.gqg.KT(aq.P(jSONArray));
            }
            this.gqg.a(valueOf, aKH, id, null, 0, 1, isCurrentAccount, this.agC.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(String str, boolean z) {
        int i;
        if (this.agC != null && this.gqg != null) {
            if (this.agC.aKy() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.agC.getId();
            String aKH = this.agC.aKH();
            this.gqg.b(String.valueOf(this.agC.getFid()), aKH, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFc() {
        int i;
        if (this.agC != null && this.gqg != null) {
            if (this.agC.aKx() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.agC.getId();
            String aKH = this.agC.aKH();
            this.gqg.b(String.valueOf(this.agC.getFid()), aKH, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFd() {
        com.baidu.tieba.frs.a.bNB().I(true, false);
        TiebaStatic.log(new an("c13125").cI("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        bEY();
        bEZ();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
