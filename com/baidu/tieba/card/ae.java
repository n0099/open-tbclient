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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes6.dex */
public class ae extends com.baidu.tieba.person.e {
    private boolean aGh;
    private bb bJG;
    private com.baidu.tbadk.core.dialog.a cOU;
    private ForumManageModel cPb;
    private final com.baidu.adp.base.d cPf;
    final CompoundButton.OnCheckedChangeListener cQA;
    private final a.d cQB;
    private final com.baidu.tieba.view.a cQt;
    private com.baidu.tbadk.core.dialog.a cQu;
    private Dialog cQv;
    private final List<a.C0320a> cQw;
    private String cQx;
    private String cQy;
    private List<BlueCheckRadioButton> cQz;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.cQx = "0";
        this.cQy = this.cQx;
        this.aGh = false;
        this.cQA = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.cQy = (String) compoundButton.getTag();
                    if (ae.this.cQz != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.cQz) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.cQy != null && !str.equals(ae.this.cQy)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.cPf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && ae.this.cPb != null) {
                    switch (ae.this.cPb.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hgM != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.HZ) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.bJG.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.hgO) ? bVar.hgO : ae.this.getString(e.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.cQu == null) {
                                        ae.this.cQu = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.cQu.ej(string);
                                        ae.this.cQu.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.cQu.be(true);
                                        ae.this.cQu.b(ae.this.mPageContext);
                                    }
                                    ae.this.cQu.AB();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.HZ) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hgO) ? dVar.hgO : ae.this.getString(e.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.hgO) ? dVar.hgO : ae.this.getString(e.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.cPb.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.HZ) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(e.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.hgR);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cQB = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void hC(int i) {
                ae.this.anT();
                if (!com.baidu.adp.lib.util.j.kV()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.bJG != null && ae.this.bJG.yC() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.bJG.yC().getUserId())) {
                            ae.this.anW();
                        } else {
                            ae.this.kk(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.anX();
                } else if (i == 3) {
                    ae.this.anY();
                } else if (i == 4) {
                    ae.this.A(ae.this.cQx, true);
                } else if (i == 5) {
                    ae.this.anZ();
                }
                ae.this.kl(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cQw = new ArrayList();
        this.cQt = new com.baidu.tieba.view.a(this.mContext);
        this.cQt.setTitleText(getString(e.j.thread_manager, new Object[0]));
        this.cQt.a(this.cQB);
        this.cPb = new ForumManageModel(this.mPageContext);
        this.cPb.setLoadDataCallBack(this.cPf);
        this.aGh = z;
        setContentView(this.cQt.bJU());
    }

    public void onChangeSkinType() {
        if (this.cQt != null) {
            this.cQt.onChangeSkinType();
        }
        if (this.cOU != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cOU.AC());
        }
        if (this.cQu != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cQu.AC());
        }
    }

    private void createView() {
        if (this.bJG != null && this.cQw != null && this.cQt != null) {
            this.cQw.clear();
            this.cQw.add(new a.C0320a(1, getString(e.j.delete_page, new Object[0]), this.cQt));
            String str = "";
            if (this.bJG.yC() != null) {
                str = this.bJG.yC().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cQw.add(new a.C0320a(2, getString(e.j.thread_forbid, new Object[0]), this.cQt));
            }
            if (com.baidu.tieba.frs.g.ayM()) {
                this.cQw.add(new a.C0320a(3, getString(this.bJG.yx() == 1 ? e.j.cancel_top : e.j.top, new Object[0]), this.cQt));
                this.cQw.add(new a.C0320a(4, getString(this.bJG.yy() == 1 ? e.j.cancel_good : e.j.commit_good, new Object[0]), this.cQt));
            }
            if (com.baidu.tieba.frs.a.ayk().ayo() && this.aGh) {
                this.cQw.add(new a.C0320a(5, getString(e.j.multi_delete, new Object[0]), this.cQt));
            }
            this.cQt.dZ(this.cQw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bb bbVar) {
        this.bJG = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anT() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void anU() {
        if (this.cOU != null && this.cOU.isShowing()) {
            this.cOU.dismiss();
        }
    }

    public void anV() {
        if (this.cQv != null && this.cQv.isShowing()) {
            this.cQv.dismiss();
        }
    }

    public void anW() {
        anU();
        if (this.mPageContext != null) {
            if (this.cOU == null) {
                this.cOU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.cOU.cN(e.j.del_thread_confirm);
                this.cOU.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.kK()) {
                            com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.neterror);
                        } else {
                            ae.this.q(null);
                        }
                    }
                });
                this.cOU.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.cOU.be(true);
                this.cOU.b(this.mPageContext);
            }
            this.cOU.AB();
        }
    }

    public void kk(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.cQt.aiX());
            AntiData ayn = com.baidu.tieba.frs.a.ayk().ayn();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ayn != null && ayn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayn.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> aym = com.baidu.tieba.frs.a.ayk().aym();
            for (int i3 = 0; i3 < aym.size(); i3++) {
                jSONArray.put(aym.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cq(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.ayk().getForumId());
            eVar.setData(ahVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            eVar.iP("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ae.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        com.baidu.adp.lib.util.l.showToast(ae.this.mContext, e.j.neterror);
                    } else {
                        ae.this.q(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.cQv == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.commit_good, (ViewGroup) null);
            this.cQv = new Dialog(this.mContext, e.k.common_alert_dialog);
            this.cQv.setCanceledOnTouchOutside(true);
            this.cQv.setCancelable(true);
            this.cQv.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cQv.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds540);
            this.cQv.getWindow().setAttributes(attributes);
            inflate.findViewById(e.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cQv, ae.this.mPageContext);
                }
            });
            inflate.findViewById(e.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cQv, ae.this.mPageContext);
                    ae.this.A(ae.this.cQy, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.cQv.findViewById(e.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cQv.findViewById(e.g.good_class_group);
        linearLayout.removeAllViews();
        this.cQz = new ArrayList();
        BlueCheckRadioButton bi = bi(this.cQx, getString(e.j.thread_good_class, new Object[0]));
        bi.setChecked(true);
        linearLayout.addView(bi);
        this.cQz.add(bi);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xr()) && aaVar.xs() > 0) {
                    BlueCheckRadioButton bi2 = bi(String.valueOf(aaVar.xs()), aaVar.xr());
                    this.cQz.add(bi2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(bi2);
                    al.j(view, e.d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cQv.findViewById(e.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cQv, this.mPageContext);
    }

    private BlueCheckRadioButton bi(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cQA);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.bJG != null && gVar != null && gVar.HZ) {
            String str = "";
            if (i == 2) {
                this.bJG.cE(1);
                str = Y(gVar.hgO, e.j.operation_success);
            } else if (i == 3) {
                this.bJG.cE(0);
                str = Y(gVar.hgO, e.j.operation_success);
            } else if (i == 4) {
                this.bJG.cD(1);
                str = Y(gVar.hgO, e.j.top_success);
            } else if (i == 5) {
                this.bJG.cD(0);
                str = Y(gVar.hgO, e.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.bJG.getId();
            eVar.forumName = this.bJG.yI();
            eVar.forumId = String.valueOf(this.bJG.getFid());
            eVar.hgP = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(e.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.hgO)) {
            string = gVar.hgO;
        } else {
            string = getString(e.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String Y(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kl(int i) {
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
        TiebaStatic.log(new am("c12713").x("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anX() {
        if (this.mContext != null && this.bJG != null && this.bJG.yC() != null) {
            String userId = this.bJG.yC().getUserId();
            String userName = this.bJG.yC().getUserName();
            String name_show = this.bJG.yC().getName_show();
            String id = this.bJG.getId();
            String yI = this.bJG.yI();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.bJG.getFid()), yI, id, userId, userName, name_show, null, this.bJG.yC().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONArray jSONArray) {
        if (this.cPb != null && this.bJG != null && this.bJG.yC() != null) {
            String userId = this.bJG.yC().getUserId();
            String id = this.bJG.getId();
            String yI = this.bJG.yI();
            String valueOf = String.valueOf(this.bJG.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.cPb.vi(ao.i(jSONArray));
            }
            this.cPb.a(valueOf, yI, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, boolean z) {
        int i;
        if (this.bJG != null && this.cPb != null) {
            if (this.bJG.yy() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.bJG.getId();
            String yI = this.bJG.yI();
            this.cPb.a(String.valueOf(this.bJG.getFid()), yI, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anY() {
        int i;
        if (this.bJG != null && this.cPb != null) {
            if (this.bJG.yx() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.bJG.getId();
            String yI = this.bJG.yI();
            this.cPb.a(String.valueOf(this.bJG.getFid()), yI, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anZ() {
        com.baidu.tieba.frs.a.ayk().x(true, false);
        TiebaStatic.log(new am("c13125").ax("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        anU();
        anV();
        anT();
    }

    public void destory() {
        dismissAllDialog();
    }
}
