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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class ae extends com.baidu.tieba.person.e {
    private boolean axH;
    private bb buw;
    private final com.baidu.tieba.view.a cBe;
    private com.baidu.tbadk.core.dialog.a cBf;
    private Dialog cBg;
    private final List<a.C0251a> cBh;
    private String cBi;
    private String cBj;
    private List<BlueCheckRadioButton> cBk;
    final CompoundButton.OnCheckedChangeListener cBl;
    private final a.d cBm;
    private com.baidu.tbadk.core.dialog.a czF;
    private ForumManageModel czM;
    private final com.baidu.adp.base.d czQ;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.cBi = "0";
        this.cBj = this.cBi;
        this.axH = false;
        this.cBl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.cBj = (String) compoundButton.getTag();
                    if (ae.this.cBk != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.cBk) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.cBj != null && !str.equals(ae.this.cBj)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.czQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj != null && ae.this.czM != null) {
                    switch (ae.this.czM.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gQp != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(d.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.EX) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.buw.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, d.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.gQr) ? bVar.gQr : ae.this.getString(d.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.cBf == null) {
                                        ae.this.cBf = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.cBf.dB(string);
                                        ae.this.cBf.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.cBf.au(true);
                                        ae.this.cBf.b(ae.this.mPageContext);
                                    }
                                    ae.this.cBf.xf();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.EX) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.gQr) ? dVar.gQr : ae.this.getString(d.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.gQr) ? dVar.gQr : ae.this.getString(d.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.czM.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.EX) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(d.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.gQu);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cBm = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void iW(int i) {
                ae.this.ajb();
                if (!com.baidu.adp.lib.util.j.jE()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, d.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.buw != null && ae.this.buw.vk() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.buw.vk().getUserId())) {
                            ae.this.aje();
                        } else {
                            ae.this.iU(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.ajf();
                } else if (i == 3) {
                    ae.this.ajg();
                } else if (i == 4) {
                    ae.this.s(ae.this.cBi, true);
                } else if (i == 5) {
                    ae.this.ajh();
                }
                ae.this.iV(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cBh = new ArrayList();
        this.cBe = new com.baidu.tieba.view.a(this.mContext);
        this.cBe.setTitleText(getString(d.j.thread_manager, new Object[0]));
        this.cBe.a(this.cBm);
        this.czM = new ForumManageModel(this.mPageContext);
        this.czM.setLoadDataCallBack(this.czQ);
        this.axH = z;
        setContentView(this.cBe.bEq());
    }

    public void onChangeSkinType() {
        if (this.cBe != null) {
            this.cBe.onChangeSkinType();
        }
        if (this.czF != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.czF.xg());
        }
        if (this.cBf != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cBf.xg());
        }
    }

    private void createView() {
        if (this.buw != null && this.cBh != null && this.cBe != null) {
            this.cBh.clear();
            this.cBh.add(new a.C0251a(1, getString(d.j.delete_page, new Object[0]), this.cBe));
            String str = "";
            if (this.buw.vk() != null) {
                str = this.buw.vk().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cBh.add(new a.C0251a(2, getString(d.j.thread_forbid, new Object[0]), this.cBe));
            }
            if (com.baidu.tieba.frs.g.aua()) {
                this.cBh.add(new a.C0251a(3, getString(this.buw.vf() == 1 ? d.j.cancel_top : d.j.top, new Object[0]), this.cBe));
                this.cBh.add(new a.C0251a(4, getString(this.buw.vg() == 1 ? d.j.cancel_good : d.j.commit_good, new Object[0]), this.cBe));
            }
            if (com.baidu.tieba.frs.a.atD().atG() && this.axH) {
                this.cBh.add(new a.C0251a(5, getString(d.j.multi_delete, new Object[0]), this.cBe));
            }
            this.cBe.dM(this.cBh);
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
        this.buw = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajb() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void ajc() {
        if (this.czF != null && this.czF.isShowing()) {
            this.czF.dismiss();
        }
    }

    public void ajd() {
        if (this.cBg != null && this.cBg.isShowing()) {
            this.cBg.dismiss();
        }
    }

    public void aje() {
        ajc();
        if (this.mPageContext != null) {
            if (this.czF == null) {
                this.czF = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.czF.cf(d.j.del_thread_confirm);
                this.czF.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.js()) {
                            com.baidu.adp.lib.util.l.showToast(ae.this.mContext, d.j.neterror);
                        } else {
                            ae.this.g((JSONArray) null);
                        }
                    }
                });
                this.czF.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.czF.au(true);
                this.czF.b(this.mPageContext);
            }
            this.czF.xf();
        }
    }

    public void iU(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.cBe.aec());
            AntiData Ce = com.baidu.tieba.frs.a.atD().Ce();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (Ce != null && Ce.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Ce.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> atF = com.baidu.tieba.frs.a.atD().atF();
            for (int i3 = 0; i3 < atF.size(); i3++) {
                jSONArray.put(atF.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.bH(i);
            ahVar.c(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.atD().getForumId());
            eVar.setData(ahVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(d.j.delete_thread_reason_1), getContext().getString(d.j.delete_thread_reason_2), getContext().getString(d.j.delete_thread_reason_3), getContext().getString(d.j.delete_thread_reason_4), getContext().getString(d.j.delete_thread_reason_5)});
            eVar.hY("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ae.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.js()) {
                        com.baidu.adp.lib.util.l.showToast(ae.this.mContext, d.j.neterror);
                    } else {
                        ae.this.g(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.cBg == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.commit_good, (ViewGroup) null);
            this.cBg = new Dialog(this.mContext, d.k.common_alert_dialog);
            this.cBg.setCanceledOnTouchOutside(true);
            this.cBg.setCancelable(true);
            this.cBg.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cBg.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds540);
            this.cBg.getWindow().setAttributes(attributes);
            inflate.findViewById(d.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cBg, ae.this.mPageContext);
                }
            });
            inflate.findViewById(d.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cBg, ae.this.mPageContext);
                    ae.this.s(ae.this.cBj, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.cBg.findViewById(d.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cBg.findViewById(d.g.good_class_group);
        linearLayout.removeAllViews();
        this.cBk = new ArrayList();
        BlueCheckRadioButton aN = aN(this.cBi, getString(d.j.thread_good_class, new Object[0]));
        aN.setChecked(true);
        linearLayout.addView(aN);
        this.cBk.add(aN);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.tY()) && aaVar.tZ() > 0) {
                    BlueCheckRadioButton aN2 = aN(String.valueOf(aaVar.tZ()), aaVar.tY());
                    this.cBk.add(aN2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aN2);
                    am.j(view, d.C0140d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cBg.findViewById(d.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cBg, this.mPageContext);
    }

    private BlueCheckRadioButton aN(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cBl);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.buw != null && gVar != null && gVar.EX) {
            String str = "";
            if (i == 2) {
                this.buw.bW(1);
                str = P(gVar.gQr, d.j.operation_success);
            } else if (i == 3) {
                this.buw.bW(0);
                str = P(gVar.gQr, d.j.operation_success);
            } else if (i == 4) {
                this.buw.bV(1);
                str = P(gVar.gQr, d.j.top_success);
            } else if (i == 5) {
                this.buw.bV(0);
                str = P(gVar.gQr, d.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.buw.getId();
            eVar.forumName = this.buw.vq();
            eVar.forumId = String.valueOf(this.buw.getFid());
            eVar.gQs = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(d.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gQr)) {
            string = gVar.gQr;
        } else {
            string = getString(d.j.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String P(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(int i) {
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
        TiebaStatic.log(new an("c12713").r("obj_type", i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajf() {
        if (this.mContext != null && this.buw != null && this.buw.vk() != null) {
            String userId = this.buw.vk().getUserId();
            String userName = this.buw.vk().getUserName();
            String name_show = this.buw.vk().getName_show();
            String id = this.buw.getId();
            String vq = this.buw.vq();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.buw.getFid()), vq, id, userId, userName, name_show, null, this.buw.vk().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONArray jSONArray) {
        if (this.czM != null && this.buw != null && this.buw.vk() != null) {
            String userId = this.buw.vk().getUserId();
            String id = this.buw.getId();
            String vq = this.buw.vq();
            String valueOf = String.valueOf(this.buw.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.czM.tQ(ap.d(jSONArray));
            }
            this.czM.a(valueOf, vq, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z) {
        int i;
        if (this.buw != null && this.czM != null) {
            if (this.buw.vg() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.buw.getId();
            String vq = this.buw.vq();
            this.czM.a(String.valueOf(this.buw.getFid()), vq, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajg() {
        int i;
        if (this.buw != null && this.czM != null) {
            if (this.buw.vf() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.buw.getId();
            String vq = this.buw.vq();
            this.czM.a(String.valueOf(this.buw.getFid()), vq, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        com.baidu.tieba.frs.a.atD().s(true, false);
        TiebaStatic.log(new an("c13125").af("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        ajc();
        ajd();
        ajb();
    }

    public void destory() {
        dismissAllDialog();
    }
}
