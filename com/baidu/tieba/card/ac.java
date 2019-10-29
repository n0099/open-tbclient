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
import com.baidu.tbadk.core.data.bh;
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
/* loaded from: classes3.dex */
public class ac extends com.baidu.tbadk.core.dialog.i {
    private boolean cqZ;
    private bh cry;
    private com.baidu.tbadk.core.dialog.a eNL;
    private ForumManageModel eNS;
    private final com.baidu.adp.base.d eNW;
    private final com.baidu.tbadk.core.dialog.k ePi;
    private com.baidu.tbadk.core.dialog.a ePj;
    private Dialog ePk;
    private final List<com.baidu.tbadk.core.dialog.g> ePl;
    private String ePm;
    private String ePn;
    private List<BlueCheckRadioButton> ePo;
    final CompoundButton.OnCheckedChangeListener ePp;
    private final k.c ePq;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.ePm = "0";
        this.ePn = this.ePm;
        this.cqZ = false;
        this.ePp = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.ePn = (String) compoundButton.getTag();
                    if (ac.this.ePo != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.ePo) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.ePn != null && !str.equals(ac.this.ePn)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.eNW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ac.this.eNS != null) {
                    switch (ac.this.eNS.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.feZ != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.tf) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ac.this.cry.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.jkX) ? bVar.jkX : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.ePj == null) {
                                        ac.this.ePj = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.ePj.nn(string);
                                        ac.this.ePj.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.ePj.eg(true);
                                        ac.this.ePj.b(ac.this.mPageContext);
                                    }
                                    ac.this.ePj.akO();
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
                            } else if (dVar.tf) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jkX) ? dVar.jkX : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jkX) ? dVar.jkX : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.eNS.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.tf) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.R(gVar.jla);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.ePq = new k.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.cry != null && ac.this.cry.aiG() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.cry.aiG().getUserId())) {
                            ac.this.baB();
                        } else {
                            ac.this.oN(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.baC();
                } else if (i == 3) {
                    ac.this.baD();
                } else if (i == 4) {
                    ac.this.aa(ac.this.ePm, true);
                } else if (i == 5) {
                    ac.this.baE();
                }
                ac.this.oO(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ePl = new ArrayList();
        this.ePi = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.ePi.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.ePi.a(this.ePq);
        this.eNS = new ForumManageModel(this.mPageContext);
        this.eNS.setLoadDataCallBack(this.eNW);
        this.cqZ = z;
        a(this.ePi);
    }

    public void onChangeSkinType() {
        if (this.ePi != null) {
            this.ePi.onChangeSkinType();
        }
        if (this.eNL != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eNL.getRealView());
        }
        if (this.ePj != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.ePj.getRealView());
        }
    }

    private void nw() {
        if (this.cry != null && this.ePl != null && this.ePi != null) {
            this.ePl.clear();
            if (!com.baidu.tieba.frs.g.bjD()) {
                this.ePl.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.ePi));
                String str = "";
                if (this.cry.aiG() != null) {
                    str = this.cry.aiG().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.ePl.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.ePi));
                }
            }
            if (com.baidu.tieba.frs.g.bjC() || com.baidu.tieba.frs.g.bjD()) {
                this.ePl.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.cry.aiB() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.ePi));
                this.ePl.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.cry.aiC() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.ePi));
            }
            if (!com.baidu.tieba.frs.g.bjD() && com.baidu.tieba.frs.a.biW().bjb() && this.cqZ && !com.baidu.tieba.frs.a.biW().bja()) {
                this.ePl.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.ePi));
            }
            this.ePi.at(this.ePl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bh bhVar) {
        this.cry = bhVar;
        nw();
    }

    public void baz() {
        if (this.eNL != null && this.eNL.isShowing()) {
            this.eNL.dismiss();
        }
    }

    public void baA() {
        if (this.ePk != null && this.ePk.isShowing()) {
            this.ePk.dismiss();
        }
    }

    public void baB() {
        baz();
        if (this.mPageContext != null) {
            if (this.eNL == null) {
                this.eNL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.eNL.hU(R.string.del_thread_confirm);
                this.eNL.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.neterror);
                        } else {
                            ac.this.O(null);
                        }
                    }
                });
                this.eNL.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.eNL.eg(true);
                this.eNL.b(this.mPageContext);
            }
            this.eNL.akO();
        }
    }

    public void oN(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData biZ = com.baidu.tieba.frs.a.biW().biZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (biZ != null && biZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bh> biY = com.baidu.tieba.frs.a.biW().biY();
            for (int i3 = 0; i3 < biY.size(); i3++) {
                jSONArray.put(biY.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.setFeedBackReasonMap(sparseArray);
            ajVar.hw(i);
            ajVar.F(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.biW().getForumId());
            eVar.setData(ajVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.qE("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ac.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void K(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.neterror);
                    } else {
                        ac.this.O(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.ePk == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.ePk = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.ePk.setCanceledOnTouchOutside(true);
            this.ePk.setCancelable(true);
            this.ePk.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ePk.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.ePk.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ePk, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ePk, ac.this.mPageContext);
                    ac.this.aa(ac.this.ePn, false);
                }
            });
        }
        com.baidu.tbadk.s.a.a(this.mPageContext, this.ePk.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.ePk.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.ePo = new ArrayList();
        BlueCheckRadioButton cx = cx(this.ePm, getString(R.string.thread_good_class, new Object[0]));
        cx.setChecked(true);
        linearLayout.addView(cx);
        this.ePo.add(cx);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.ahi()) && acVar.ahj() > 0) {
                    BlueCheckRadioButton cx2 = cx(String.valueOf(acVar.ahj()), acVar.ahi());
                    this.ePo.add(cx2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(cx2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.ePk.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.ePk, this.mPageContext);
    }

    private BlueCheckRadioButton cx(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.ePp);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.cry != null && gVar != null && gVar.tf) {
            String str = "";
            if (i == 2) {
                this.cry.hL(1);
                str = ao(gVar.jkX, R.string.operation_success);
            } else if (i == 3) {
                this.cry.hL(0);
                str = ao(gVar.jkX, R.string.operation_success);
            } else if (i == 4) {
                this.cry.hK(1);
                str = ao(gVar.jkX, R.string.top_success);
            } else if (i == 5) {
                this.cry.hK(0);
                str = ao(gVar.jkX, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.cry.getId();
            eVar.forumName = this.cry.aiL();
            eVar.forumId = String.valueOf(this.cry.getFid());
            eVar.jkY = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.jkX)) {
            string = gVar.jkX;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String ao(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oO(int i) {
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
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).O("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baC() {
        if (this.mContext != null && this.cry != null && this.cry.aiG() != null) {
            String userId = this.cry.aiG().getUserId();
            String userName = this.cry.aiG().getUserName();
            String name_show = this.cry.aiG().getName_show();
            String id = this.cry.getId();
            String aiL = this.cry.aiL();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.cry.getFid()), aiL, id, userId, userName, name_show, null, this.cry.aiG().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(JSONArray jSONArray) {
        if (this.eNS != null && this.cry != null && this.cry.aiG() != null) {
            String userId = this.cry.aiG().getUserId();
            String id = this.cry.getId();
            String aiL = this.cry.aiL();
            String valueOf = String.valueOf(this.cry.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.eNS.DU(aq.G(jSONArray));
            }
            this.eNS.a(valueOf, aiL, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(String str, boolean z) {
        int i;
        if (this.cry != null && this.eNS != null) {
            if (this.cry.aiC() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.cry.getId();
            String aiL = this.cry.aiL();
            this.eNS.a(String.valueOf(this.cry.getFid()), aiL, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baD() {
        int i;
        if (this.cry != null && this.eNS != null) {
            if (this.cry.aiB() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.cry.getId();
            String aiL = this.cry.aiL();
            this.eNS.a(String.valueOf(this.cry.getFid()), aiL, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baE() {
        com.baidu.tieba.frs.a.biW().G(true, false);
        TiebaStatic.log(new an("c13125").bS("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        baz();
        baA();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
