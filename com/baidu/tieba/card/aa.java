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
    private boolean dib;
    private com.baidu.tbadk.core.dialog.a fKE;
    private ForumManageModel fKL;
    private final com.baidu.adp.base.d fKQ;
    private final com.baidu.tbadk.core.dialog.k fMb;
    private com.baidu.tbadk.core.dialog.a fMc;
    private Dialog fMd;
    private final List<com.baidu.tbadk.core.dialog.g> fMe;
    private String fMf;
    private String fMg;
    private List<BlueCheckRadioButton> fMh;
    final CompoundButton.OnCheckedChangeListener fMi;
    private final k.c fMj;
    private Context mContext;
    private TbPageContext mPageContext;

    public aa(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.fMf = "0";
        this.fMg = this.fMf;
        this.dib = false;
        this.fMi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.aa.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    aa.this.fMg = (String) compoundButton.getTag();
                    if (aa.this.fMh != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : aa.this.fMh) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && aa.this.fMg != null && !str.equals(aa.this.fMg)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.fKQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.aa.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && aa.this.fKL != null) {
                    switch (aa.this.fKL.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.fYk != 0) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.mSuccess) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, aa.this.NQ.getId()));
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.kju) ? bVar.kju : aa.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (aa.this.fMc == null) {
                                        aa.this.fMc = new com.baidu.tbadk.core.dialog.a(aa.this.mPageContext.getPageActivity());
                                        aa.this.fMc.sS(string);
                                        aa.this.fMc.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.aa.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        aa.this.fMc.fG(true);
                                        aa.this.fMc.b(aa.this.mPageContext);
                                    }
                                    aa.this.fMc.aEC();
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
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kju) ? dVar.kju : aa.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, !TextUtils.isEmpty(dVar.kju) ? dVar.kju : aa.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            aa.this.a(aa.this.fKL.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.mSuccess) {
                                com.baidu.adp.lib.util.l.showToast(aa.this.mContext, aa.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                aa.this.ad(gVar.kjx);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.fMj = new k.c() { // from class: com.baidu.tieba.card.aa.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                aa.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(aa.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (aa.this.NQ != null && aa.this.NQ.aCo() != null) {
                        if (UtilHelper.isCurrentAccount(aa.this.NQ.aCo().getUserId())) {
                            aa.this.bvm();
                        } else {
                            aa.this.rr(1);
                        }
                    }
                } else if (i == 2) {
                    aa.this.bvn();
                } else if (i == 3) {
                    aa.this.bvo();
                } else if (i == 4) {
                    aa.this.ae(aa.this.fMf, true);
                } else if (i == 5) {
                    aa.this.bvp();
                }
                aa.this.rs(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fMe = new ArrayList();
        this.fMb = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.fMb.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.fMb.a(this.fMj);
        this.fKL = new ForumManageModel(this.mPageContext);
        this.fKL.setLoadDataCallBack(this.fKQ);
        this.dib = z;
        a(this.fMb);
    }

    public void onChangeSkinType() {
        if (this.fMb != null) {
            this.fMb.onChangeSkinType();
        }
        if (this.fKE != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fKE.getRealView());
        }
        if (this.fMc != null) {
            com.baidu.tbadk.q.a.a(this.mPageContext, this.fMc.getRealView());
        }
    }

    private void createView() {
        if (this.NQ != null && this.fMe != null && this.fMb != null) {
            this.fMe.clear();
            if (!com.baidu.tieba.frs.g.bDC()) {
                if (!this.NQ.isBjh()) {
                    this.fMe.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.fMb));
                }
                String str = "";
                if (this.NQ.aCo() != null) {
                    str = this.NQ.aCo().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.fMe.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.fMb));
                }
            }
            if (com.baidu.tieba.frs.g.bDB() || com.baidu.tieba.frs.g.bDC()) {
                this.fMe.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.NQ.aCj() == 1 ? R.string.cancel_top : R.string.f1281top, new Object[0]), this.fMb));
                this.fMe.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.NQ.aCk() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.fMb));
            }
            if (!com.baidu.tieba.frs.g.bDC() && com.baidu.tieba.frs.a.bCW().bDb() && this.dib && !com.baidu.tieba.frs.a.bCW().bDa()) {
                this.fMe.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.fMb));
            }
            this.fMb.az(this.fMe);
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

    public void bvk() {
        if (this.fKE != null && this.fKE.isShowing()) {
            this.fKE.dismiss();
        }
    }

    public void bvl() {
        if (this.fMd != null && this.fMd.isShowing()) {
            this.fMd.dismiss();
        }
    }

    public void bvm() {
        bvk();
        if (this.mPageContext != null) {
            if (this.fKE == null) {
                this.fKE = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.fKE.jW(R.string.del_thread_confirm);
                this.fKE.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.aa.1
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
                this.fKE.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.aa.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.fKE.fG(true);
                this.fKE.b(this.mPageContext);
            }
            this.fKE.aEC();
        }
    }

    public void rr(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bCZ = com.baidu.tieba.frs.a.bCW().bCZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bCZ != null && bCZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bCY = com.baidu.tieba.frs.a.bCW().bCY();
            for (int i3 = 0; i3 < bCY.size(); i3++) {
                jSONArray.put(bCY.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jy(i);
            alVar.M(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bCW().getForumId());
            eVar.setData(alVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.wn("1");
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
        if (this.fMd == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.fMd = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.fMd.setCanceledOnTouchOutside(true);
            this.fMd.setCancelable(true);
            this.fMd.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fMd.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.fMd.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fMd, aa.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.aa.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(aa.this.fMd, aa.this.mPageContext);
                    aa.this.ae(aa.this.fMg, false);
                }
            });
        }
        com.baidu.tbadk.q.a.a(this.mPageContext, this.fMd.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.fMd.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.fMh = new ArrayList();
        BlueCheckRadioButton dc = dc(this.fMf, getString(R.string.thread_good_class, new Object[0]));
        dc.setChecked(true);
        linearLayout.addView(dc);
        this.fMh.add(dc);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ad adVar = arrayList.get(i);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAJ()) && adVar.aAK() > 0) {
                    BlueCheckRadioButton dc2 = dc(String.valueOf(adVar.aAK()), adVar.aAJ());
                    this.fMh.add(dc2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(dc2);
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.fMd.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.fMd, this.mPageContext);
    }

    private BlueCheckRadioButton dc(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.fMi);
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
                str = aw(gVar.kju, R.string.operation_success);
            } else if (i == 3) {
                this.NQ.jM(0);
                str = aw(gVar.kju, R.string.operation_success);
            } else if (i == 4) {
                this.NQ.jL(1);
                str = aw(gVar.kju, R.string.top_success);
            } else if (i == 5) {
                this.NQ.jL(0);
                str = aw(gVar.kju, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.NQ.getId();
            eVar.forumName = this.NQ.aCt();
            eVar.forumId = String.valueOf(this.NQ.getFid());
            eVar.kjv = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.kju)) {
            string = gVar.kju;
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
    public void bvn() {
        if (this.mContext != null && this.NQ != null && this.NQ.aCo() != null) {
            String userId = this.NQ.aCo().getUserId();
            String userName = this.NQ.aCo().getUserName();
            String name_show = this.NQ.aCo().getName_show();
            String id = this.NQ.getId();
            String aCt = this.NQ.aCt();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.NQ.getFid()), aCt, id, userId, userName, name_show, null, this.NQ.aCo().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(JSONArray jSONArray) {
        if (this.fKL != null && this.NQ != null && this.NQ.aCo() != null) {
            String userId = this.NQ.aCo().getUserId();
            String id = this.NQ.getId();
            String aCt = this.NQ.aCt();
            String valueOf = String.valueOf(this.NQ.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.fKL.Jh(aq.O(jSONArray));
            }
            this.fKL.a(valueOf, aCt, id, null, 0, 1, isCurrentAccount, this.NQ.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(String str, boolean z) {
        int i;
        if (this.NQ != null && this.fKL != null) {
            if (this.NQ.aCk() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.NQ.getId();
            String aCt = this.NQ.aCt();
            this.fKL.b(String.valueOf(this.NQ.getFid()), aCt, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvo() {
        int i;
        if (this.NQ != null && this.fKL != null) {
            if (this.NQ.aCj() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.NQ.getId();
            String aCt = this.NQ.aCt();
            this.fKL.b(String.valueOf(this.NQ.getFid()), aCt, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvp() {
        com.baidu.tieba.frs.a.bCW().I(true, false);
        TiebaStatic.log(new an("c13125").cy("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        bvk();
        bvl();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
