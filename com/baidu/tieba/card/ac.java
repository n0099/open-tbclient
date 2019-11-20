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
    private bh cqG;
    private boolean cqi;
    private com.baidu.tbadk.core.dialog.a eMU;
    private ForumManageModel eNb;
    private final com.baidu.adp.base.d eNf;
    private final com.baidu.tbadk.core.dialog.k eOr;
    private com.baidu.tbadk.core.dialog.a eOs;
    private Dialog eOt;
    private final List<com.baidu.tbadk.core.dialog.g> eOu;
    private String eOv;
    private String eOw;
    private List<BlueCheckRadioButton> eOx;
    final CompoundButton.OnCheckedChangeListener eOy;
    private final k.c eOz;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.eOv = "0";
        this.eOw = this.eOv;
        this.cqi = false;
        this.eOy = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.eOw = (String) compoundButton.getTag();
                    if (ac.this.eOx != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.eOx) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.eOw != null && !str.equals(ac.this.eOw)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.eNf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ac.this.eNb != null) {
                    switch (ac.this.eNb.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.fei != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.sF) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ac.this.cqG.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.jkg) ? bVar.jkg : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.eOs == null) {
                                        ac.this.eOs = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.eOs.nn(string);
                                        ac.this.eOs.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.eOs.eg(true);
                                        ac.this.eOs.b(ac.this.mPageContext);
                                    }
                                    ac.this.eOs.akM();
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
                            } else if (dVar.sF) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jkg) ? dVar.jkg : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jkg) ? dVar.jkg : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.eNb.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.sF) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.R(gVar.jkj);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.eOz = new k.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.cqG != null && ac.this.cqG.aiE() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.cqG.aiE().getUserId())) {
                            ac.this.baz();
                        } else {
                            ac.this.oM(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.baA();
                } else if (i == 3) {
                    ac.this.baB();
                } else if (i == 4) {
                    ac.this.aa(ac.this.eOv, true);
                } else if (i == 5) {
                    ac.this.baC();
                }
                ac.this.oN(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eOu = new ArrayList();
        this.eOr = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.eOr.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.eOr.a(this.eOz);
        this.eNb = new ForumManageModel(this.mPageContext);
        this.eNb.setLoadDataCallBack(this.eNf);
        this.cqi = z;
        a(this.eOr);
    }

    public void onChangeSkinType() {
        if (this.eOr != null) {
            this.eOr.onChangeSkinType();
        }
        if (this.eMU != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eMU.getRealView());
        }
        if (this.eOs != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eOs.getRealView());
        }
    }

    private void nw() {
        if (this.cqG != null && this.eOu != null && this.eOr != null) {
            this.eOu.clear();
            if (!com.baidu.tieba.frs.g.bjB()) {
                this.eOu.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.eOr));
                String str = "";
                if (this.cqG.aiE() != null) {
                    str = this.cqG.aiE().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.eOu.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.eOr));
                }
            }
            if (com.baidu.tieba.frs.g.bjA() || com.baidu.tieba.frs.g.bjB()) {
                this.eOu.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.cqG.aiz() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.eOr));
                this.eOu.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.cqG.aiA() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.eOr));
            }
            if (!com.baidu.tieba.frs.g.bjB() && com.baidu.tieba.frs.a.biU().biZ() && this.cqi && !com.baidu.tieba.frs.a.biU().biY()) {
                this.eOu.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.eOr));
            }
            this.eOr.at(this.eOu);
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
        this.cqG = bhVar;
        nw();
    }

    public void bax() {
        if (this.eMU != null && this.eMU.isShowing()) {
            this.eMU.dismiss();
        }
    }

    public void bay() {
        if (this.eOt != null && this.eOt.isShowing()) {
            this.eOt.dismiss();
        }
    }

    public void baz() {
        bax();
        if (this.mPageContext != null) {
            if (this.eMU == null) {
                this.eMU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.eMU.hT(R.string.del_thread_confirm);
                this.eMU.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
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
                this.eMU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.eMU.eg(true);
                this.eMU.b(this.mPageContext);
            }
            this.eMU.akM();
        }
    }

    public void oM(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData biX = com.baidu.tieba.frs.a.biU().biX();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (biX != null && biX.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biX.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bh> biW = com.baidu.tieba.frs.a.biU().biW();
            for (int i3 = 0; i3 < biW.size(); i3++) {
                jSONArray.put(biW.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.setFeedBackReasonMap(sparseArray);
            ajVar.hv(i);
            ajVar.F(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.biU().getForumId());
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
        if (this.eOt == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.eOt = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.eOt.setCanceledOnTouchOutside(true);
            this.eOt.setCancelable(true);
            this.eOt.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eOt.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.eOt.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.eOt, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.eOt, ac.this.mPageContext);
                    ac.this.aa(ac.this.eOw, false);
                }
            });
        }
        com.baidu.tbadk.s.a.a(this.mPageContext, this.eOt.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.eOt.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.eOx = new ArrayList();
        BlueCheckRadioButton cx = cx(this.eOv, getString(R.string.thread_good_class, new Object[0]));
        cx.setChecked(true);
        linearLayout.addView(cx);
        this.eOx.add(cx);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.ahg()) && acVar.ahh() > 0) {
                    BlueCheckRadioButton cx2 = cx(String.valueOf(acVar.ahh()), acVar.ahg());
                    this.eOx.add(cx2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(cx2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.eOt.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.eOt, this.mPageContext);
    }

    private BlueCheckRadioButton cx(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.eOy);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.cqG != null && gVar != null && gVar.sF) {
            String str = "";
            if (i == 2) {
                this.cqG.hK(1);
                str = ao(gVar.jkg, R.string.operation_success);
            } else if (i == 3) {
                this.cqG.hK(0);
                str = ao(gVar.jkg, R.string.operation_success);
            } else if (i == 4) {
                this.cqG.hJ(1);
                str = ao(gVar.jkg, R.string.top_success);
            } else if (i == 5) {
                this.cqG.hJ(0);
                str = ao(gVar.jkg, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.cqG.getId();
            eVar.forumName = this.cqG.aiJ();
            eVar.forumId = String.valueOf(this.cqG.getFid());
            eVar.jkh = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.jkg)) {
            string = gVar.jkg;
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
    public void oN(int i) {
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
    public void baA() {
        if (this.mContext != null && this.cqG != null && this.cqG.aiE() != null) {
            String userId = this.cqG.aiE().getUserId();
            String userName = this.cqG.aiE().getUserName();
            String name_show = this.cqG.aiE().getName_show();
            String id = this.cqG.getId();
            String aiJ = this.cqG.aiJ();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.cqG.getFid()), aiJ, id, userId, userName, name_show, null, this.cqG.aiE().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(JSONArray jSONArray) {
        if (this.eNb != null && this.cqG != null && this.cqG.aiE() != null) {
            String userId = this.cqG.aiE().getUserId();
            String id = this.cqG.getId();
            String aiJ = this.cqG.aiJ();
            String valueOf = String.valueOf(this.cqG.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.eNb.DU(aq.G(jSONArray));
            }
            this.eNb.a(valueOf, aiJ, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(String str, boolean z) {
        int i;
        if (this.cqG != null && this.eNb != null) {
            if (this.cqG.aiA() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.cqG.getId();
            String aiJ = this.cqG.aiJ();
            this.eNb.b(String.valueOf(this.cqG.getFid()), aiJ, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baB() {
        int i;
        if (this.cqG != null && this.eNb != null) {
            if (this.cqG.aiz() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.cqG.getId();
            String aiJ = this.cqG.aiJ();
            this.eNb.b(String.valueOf(this.cqG.getFid()), aiJ, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baC() {
        com.baidu.tieba.frs.a.biU().G(true, false);
        TiebaStatic.log(new an("c13125").bS("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        bax();
        bay();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
