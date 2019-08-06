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
    private boolean cbS;
    private bh ccq;
    private ForumManageModel eDC;
    private final com.baidu.adp.base.d eDG;
    private com.baidu.tbadk.core.dialog.a eDv;
    private final com.baidu.tbadk.core.dialog.k eES;
    private com.baidu.tbadk.core.dialog.a eET;
    private Dialog eEU;
    private final List<com.baidu.tbadk.core.dialog.g> eEV;
    private String eEW;
    private String eEX;
    private List<BlueCheckRadioButton> eEY;
    final CompoundButton.OnCheckedChangeListener eEZ;
    private final k.c eFa;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.eEW = "0";
        this.eEX = this.eEW;
        this.cbS = false;
        this.eEZ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.eEX = (String) compoundButton.getTag();
                    if (ac.this.eEY != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.eEY) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.eEX != null && !str.equals(ac.this.eEX)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.eDG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ac.this.eDC != null) {
                    switch (ac.this.eDC.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.faI != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.FU) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ac.this.ccq.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.jiM) ? bVar.jiM : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.eET == null) {
                                        ac.this.eET = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.eET.mO(string);
                                        ac.this.eET.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.eET.dQ(true);
                                        ac.this.eET.b(ac.this.mPageContext);
                                    }
                                    ac.this.eET.agK();
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
                            } else if (dVar.FU) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jiM) ? dVar.jiM : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.jiM) ? dVar.jiM : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.eDC.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.FU) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.M(gVar.jiP);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.eFa = new k.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.kc()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.ccq != null && ac.this.ccq.aey() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.ccq.aey().getUserId())) {
                            ac.this.aZU();
                        } else {
                            ac.this.pH(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.aZV();
                } else if (i == 3) {
                    ac.this.aZW();
                } else if (i == 4) {
                    ac.this.ac(ac.this.eEW, true);
                } else if (i == 5) {
                    ac.this.aZX();
                }
                ac.this.pI(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eEV = new ArrayList();
        this.eES = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.eES.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.eES.a(this.eFa);
        this.eDC = new ForumManageModel(this.mPageContext);
        this.eDC.setLoadDataCallBack(this.eDG);
        this.cbS = z;
        setContentView(this.eES.ahd());
    }

    public void onChangeSkinType() {
        if (this.eES != null) {
            this.eES.onChangeSkinType();
        }
        if (this.eDv != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eDv.agL());
        }
        if (this.eET != null) {
            com.baidu.tbadk.s.a.a(this.mPageContext, this.eET.agL());
        }
    }

    private void createView() {
        if (this.ccq != null && this.eEV != null && this.eES != null) {
            this.eEV.clear();
            if (!com.baidu.tieba.frs.g.blM()) {
                this.eEV.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.eES));
                String str = "";
                if (this.ccq.aey() != null) {
                    str = this.ccq.aey().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.eEV.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.eES));
                }
            }
            if (com.baidu.tieba.frs.g.blL() || com.baidu.tieba.frs.g.blM()) {
                this.eEV.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.ccq.aet() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.eES));
                this.eEV.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.ccq.aeu() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.eES));
            }
            if (!com.baidu.tieba.frs.g.blM() && com.baidu.tieba.frs.a.blf().blk() && this.cbS && !com.baidu.tieba.frs.a.blf().blj()) {
                this.eEV.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.eES));
            }
            this.eES.W(this.eEV);
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
        this.ccq = bhVar;
        createView();
    }

    public void aZS() {
        if (this.eDv != null && this.eDv.isShowing()) {
            this.eDv.dismiss();
        }
    }

    public void aZT() {
        if (this.eEU != null && this.eEU.isShowing()) {
            this.eEU.dismiss();
        }
    }

    public void aZU() {
        aZS();
        if (this.mPageContext != null) {
            if (this.eDv == null) {
                this.eDv = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.eDv.hu(R.string.del_thread_confirm);
                this.eDv.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.jQ()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, (int) R.string.neterror);
                        } else {
                            ac.this.G(null);
                        }
                    }
                });
                this.eDv.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.eDv.dQ(true);
                this.eDv.b(this.mPageContext);
            }
            this.eDv.agK();
        }
    }

    public void pH(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bli = com.baidu.tieba.frs.a.blf().bli();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bli != null && bli.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bli.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bh> blh = com.baidu.tieba.frs.a.blf().blh();
            for (int i3 = 0; i3 < blh.size(); i3++) {
                jSONArray.put(blh.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gW(i);
            ajVar.x(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.blf().getForumId());
            eVar.setData(ajVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.rJ("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ac.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.jQ()) {
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
        if (this.eEU == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.eEU = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.eEU.setCanceledOnTouchOutside(true);
            this.eEU.setCancelable(true);
            this.eEU.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eEU.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds540);
            this.eEU.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.eEU, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ac.this.eEU, ac.this.mPageContext);
                    ac.this.ac(ac.this.eEX, false);
                }
            });
        }
        com.baidu.tbadk.s.a.a(this.mPageContext, this.eEU.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.eEU.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.eEY = new ArrayList();
        BlueCheckRadioButton cH = cH(this.eEW, getString(R.string.thread_good_class, new Object[0]));
        cH.setChecked(true);
        linearLayout.addView(cH);
        this.eEY.add(cH);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.ac acVar = arrayList.get(i);
                if (acVar != null && !TextUtils.isEmpty(acVar.acY()) && acVar.acZ() > 0) {
                    BlueCheckRadioButton cH2 = cH(String.valueOf(acVar.acZ()), acVar.acY());
                    this.eEY.add(cH2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(cH2);
                    am.l(view, R.color.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.eEU.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.eEU, this.mPageContext);
    }

    private BlueCheckRadioButton cH(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.eEZ);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.ccq != null && gVar != null && gVar.FU) {
            String str = "";
            if (i == 2) {
                this.ccq.hl(1);
                str = ar(gVar.jiM, R.string.operation_success);
            } else if (i == 3) {
                this.ccq.hl(0);
                str = ar(gVar.jiM, R.string.operation_success);
            } else if (i == 4) {
                this.ccq.hk(1);
                str = ar(gVar.jiM, R.string.top_success);
            } else if (i == 5) {
                this.ccq.hk(0);
                str = ar(gVar.jiM, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.ccq.getId();
            eVar.forumName = this.ccq.aeD();
            eVar.forumId = String.valueOf(this.ccq.getFid());
            eVar.jiN = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.jiM)) {
            string = gVar.jiM;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String ar(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI(int i) {
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
        TiebaStatic.log(new an("c12713").P("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZV() {
        if (this.mContext != null && this.ccq != null && this.ccq.aey() != null) {
            String userId = this.ccq.aey().getUserId();
            String userName = this.ccq.aey().getUserName();
            String name_show = this.ccq.aey().getName_show();
            String id = this.ccq.getId();
            String aeD = this.ccq.aeD();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.ccq.getFid()), aeD, id, userId, userName, name_show, null, this.ccq.aey().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(JSONArray jSONArray) {
        if (this.eDC != null && this.ccq != null && this.ccq.aey() != null) {
            String userId = this.ccq.aey().getUserId();
            String id = this.ccq.getId();
            String aeD = this.ccq.aeD();
            String valueOf = String.valueOf(this.ccq.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.eDC.EQ(aq.y(jSONArray));
            }
            this.eDC.a(valueOf, aeD, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(String str, boolean z) {
        int i;
        if (this.ccq != null && this.eDC != null) {
            if (this.ccq.aeu() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.ccq.getId();
            String aeD = this.ccq.aeD();
            this.eDC.a(String.valueOf(this.ccq.getFid()), aeD, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZW() {
        int i;
        if (this.ccq != null && this.eDC != null) {
            if (this.ccq.aet() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.ccq.getId();
            String aeD = this.ccq.aeD();
            this.eDC.a(String.valueOf(this.ccq.getFid()), aeD, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZX() {
        com.baidu.tieba.frs.a.blf().D(true, false);
        TiebaStatic.log(new an("c13125").bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        aZS();
        aZT();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
