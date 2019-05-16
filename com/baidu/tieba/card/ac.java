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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    private boolean caI;
    private bg cbg;
    private final com.baidu.adp.base.d eyB;
    private com.baidu.tbadk.core.dialog.a eyq;
    private ForumManageModel eyx;
    private final com.baidu.tbadk.core.dialog.k ezO;
    private com.baidu.tbadk.core.dialog.a ezP;
    private Dialog ezQ;
    private final List<com.baidu.tbadk.core.dialog.g> ezR;
    private String ezS;
    private String ezT;
    private List<BlueCheckRadioButton> ezU;
    final CompoundButton.OnCheckedChangeListener ezV;
    private final k.c ezW;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.ezS = "0";
        this.ezT = this.ezS;
        this.caI = false;
        this.ezV = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.ezT = (String) compoundButton.getTag();
                    if (ac.this.ezU != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.ezU) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.ezT != null && !str.equals(ac.this.ezT)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.eyB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ac.this.eyx != null) {
                    switch (ac.this.eyx.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.eVs != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.FN) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.cbg.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.jbh) ? bVar.jbh : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.ezP == null) {
                                        ac.this.ezP = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.ezP.mE(string);
                                        ac.this.ezP.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.ezP.dM(true);
                                        ac.this.ezP.b(ac.this.mPageContext);
                                    }
                                    ac.this.ezP.afG();
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
                            } else if (dVar.FN) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jbh) ? dVar.jbh : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jbh) ? dVar.jbh : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.eyx.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.FN) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.M(gVar.jbk);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.ezW = new k.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.jS()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.cbg != null && ac.this.cbg.adv() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.cbg.adv().getUserId())) {
                            ac.this.aXR();
                        } else {
                            ac.this.pq(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.aXS();
                } else if (i == 3) {
                    ac.this.aXT();
                } else if (i == 4) {
                    ac.this.Y(ac.this.ezS, true);
                } else if (i == 5) {
                    ac.this.aXU();
                }
                ac.this.pr(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ezR = new ArrayList();
        this.ezO = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.ezO.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.ezO.a(this.ezW);
        this.eyx = new ForumManageModel(this.mPageContext);
        this.eyx.setLoadDataCallBack(this.eyB);
        this.caI = z;
        setContentView(this.ezO.afZ());
    }

    public void onChangeSkinType() {
        if (this.ezO != null) {
            this.ezO.onChangeSkinType();
        }
        if (this.eyq != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eyq.afH());
        }
        if (this.ezP != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.ezP.afH());
        }
    }

    private void createView() {
        if (this.cbg != null && this.ezR != null && this.ezO != null) {
            this.ezR.clear();
            if (!com.baidu.tieba.frs.g.bjA()) {
                this.ezR.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.ezO));
                String str = "";
                if (this.cbg.adv() != null) {
                    str = this.cbg.adv().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.ezR.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.ezO));
                }
            }
            if (com.baidu.tieba.frs.g.bjz() || com.baidu.tieba.frs.g.bjA()) {
                this.ezR.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.cbg.adq() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.ezO));
                this.ezR.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.cbg.adr() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.ezO));
            }
            if (!com.baidu.tieba.frs.g.bjA() && com.baidu.tieba.frs.a.biT().biY() && this.caI && !com.baidu.tieba.frs.a.biT().biX()) {
                this.ezR.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.ezO));
            }
            this.ezO.W(this.ezR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bg bgVar) {
        this.cbg = bgVar;
        createView();
    }

    public void aXP() {
        if (this.eyq != null && this.eyq.isShowing()) {
            this.eyq.dismiss();
        }
    }

    public void aXQ() {
        if (this.ezQ != null && this.ezQ.isShowing()) {
            this.ezQ.dismiss();
        }
    }

    public void aXR() {
        aXP();
        if (this.mPageContext != null) {
            if (this.eyq == null) {
                this.eyq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.eyq.ho(R.string.del_thread_confirm);
                this.eyq.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.jG()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.neterror);
                        } else {
                            ac.this.G(null);
                        }
                    }
                });
                this.eyq.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.eyq.dM(true);
                this.eyq.b(this.mPageContext);
            }
            this.eyq.afG();
        }
    }

    public void pq(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData biW = com.baidu.tieba.frs.a.biT().biW();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (biW != null && biW.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biW.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bg> biV = com.baidu.tieba.frs.a.biT().biV();
            for (int i3 = 0; i3 < biV.size(); i3++) {
                jSONArray.put(biV.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gR(i);
            ajVar.x(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.biT().getForumId());
            eVar.setData(ajVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.rs("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ac.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.jG()) {
                        com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.neterror);
                    } else {
                        ac.this.G(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(ArrayList<com.baidu.tbadk.core.data.ac> arrayList) {
        if (this.ezQ == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.ezQ = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.ezQ.setCanceledOnTouchOutside(true);
            this.ezQ.setCancelable(true);
            this.ezQ.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ezQ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds540);
            this.ezQ.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ezQ, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.ezQ, ac.this.mPageContext);
                    ac.this.Y(ac.this.ezT, false);
                }
            });
        }
        com.baidu.tbadk.s.a.a(this.mPageContext, this.ezQ.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.ezQ.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.ezU = new ArrayList();
        BlueCheckRadioButton cG = cG(this.ezS, getString(R.string.thread_good_class, new Object[0]));
        cG.setChecked(true);
        linearLayout.addView(cG);
        this.ezU.add(cG);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.abV()) && acVar.abW() > 0) {
                    BlueCheckRadioButton cG2 = cG(String.valueOf(acVar.abW()), acVar.abV());
                    this.ezU.add(cG2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(cG2);
                    al.l(view, R.color.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.ezQ.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.ezQ, this.mPageContext);
    }

    private BlueCheckRadioButton cG(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.ezV);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.cbg != null && gVar != null && gVar.FN) {
            String str = "";
            if (i == 2) {
                this.cbg.hf(1);
                str = aq(gVar.jbh, R.string.operation_success);
            } else if (i == 3) {
                this.cbg.hf(0);
                str = aq(gVar.jbh, R.string.operation_success);
            } else if (i == 4) {
                this.cbg.he(1);
                str = aq(gVar.jbh, R.string.top_success);
            } else if (i == 5) {
                this.cbg.he(0);
                str = aq(gVar.jbh, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.cbg.getId();
            eVar.forumName = this.cbg.adA();
            eVar.forumId = String.valueOf(this.cbg.getFid());
            eVar.jbi = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.jbh)) {
            string = gVar.jbh;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aq(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i) {
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
        TiebaStatic.log(new am("c12713").P("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXS() {
        if (this.mContext != null && this.cbg != null && this.cbg.adv() != null) {
            String userId = this.cbg.adv().getUserId();
            String userName = this.cbg.adv().getUserName();
            String name_show = this.cbg.adv().getName_show();
            String id = this.cbg.getId();
            String adA = this.cbg.adA();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.cbg.getFid()), adA, id, userId, userName, name_show, null, this.cbg.adv().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(JSONArray jSONArray) {
        if (this.eyx != null && this.cbg != null && this.cbg.adv() != null) {
            String userId = this.cbg.adv().getUserId();
            String id = this.cbg.getId();
            String adA = this.cbg.adA();
            String valueOf = String.valueOf(this.cbg.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.eyx.Ea(ap.y(jSONArray));
            }
            this.eyx.a(valueOf, adA, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str, boolean z) {
        int i;
        if (this.cbg != null && this.eyx != null) {
            if (this.cbg.adr() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.cbg.getId();
            String adA = this.cbg.adA();
            this.eyx.a(String.valueOf(this.cbg.getFid()), adA, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXT() {
        int i;
        if (this.cbg != null && this.eyx != null) {
            if (this.cbg.adq() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.cbg.getId();
            String adA = this.cbg.adA();
            this.eyx.a(String.valueOf(this.cbg.getFid()), adA, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXU() {
        com.baidu.tieba.frs.a.biT().A(true, false);
        TiebaStatic.log(new am("c13125").bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aXP();
        aXQ();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
