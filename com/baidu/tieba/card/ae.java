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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class ae extends com.baidu.tieba.person.e {
    private boolean axE;
    private bb buy;
    private final com.baidu.tieba.view.a cBb;
    private com.baidu.tbadk.core.dialog.a cBc;
    private Dialog cBd;
    private final List<a.C0251a> cBe;
    private String cBf;
    private String cBg;
    private List<BlueCheckRadioButton> cBh;
    final CompoundButton.OnCheckedChangeListener cBi;
    private final a.d cBj;
    private com.baidu.tbadk.core.dialog.a czC;
    private ForumManageModel czJ;
    private final com.baidu.adp.base.d czN;
    private Context mContext;
    private TbPageContext mPageContext;

    public ae(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity());
        this.cBf = "0";
        this.cBg = this.cBf;
        this.axE = false;
        this.cBi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ae.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ae.this.cBg = (String) compoundButton.getTag();
                    if (ae.this.cBh != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ae.this.cBh) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ae.this.cBg != null && !str.equals(ae.this.cBg)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.czN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ae.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj != null && ae.this.czJ != null) {
                    switch (ae.this.czJ.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.gQq != 0) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(f.j.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.EX) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, ae.this.buy.getId()));
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, f.j.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.gQs) ? bVar.gQs : ae.this.getString(f.j.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ae.this.cBc == null) {
                                        ae.this.cBc = new com.baidu.tbadk.core.dialog.a(ae.this.mPageContext.getPageActivity());
                                        ae.this.cBc.dB(string);
                                        ae.this.cBc.a(f.j.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ae.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ae.this.cBc.av(true);
                                        ae.this.cBc.b(ae.this.mPageContext);
                                    }
                                    ae.this.cBc.xe();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(f.j.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.EX) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.gQs) ? dVar.gQs : ae.this.getString(f.j.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, !TextUtils.isEmpty(dVar.gQs) ? dVar.gQs : ae.this.getString(f.j.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ae.this.a(ae.this.czJ.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.EX) {
                                com.baidu.adp.lib.util.l.showToast(ae.this.mContext, ae.this.getString(f.j.operation_failed, new Object[0]));
                                return;
                            } else {
                                ae.this.F(gVar.gQv);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.cBj = new a.d() { // from class: com.baidu.tieba.card.ae.8
            @Override // com.baidu.tieba.view.a.d
            public void iV(int i) {
                ae.this.aje();
                if (!com.baidu.adp.lib.util.j.jE()) {
                    com.baidu.adp.lib.util.l.showToast(ae.this.mContext, f.j.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ae.this.buy != null && ae.this.buy.vj() != null) {
                        if (UtilHelper.isCurrentAccount(ae.this.buy.vj().getUserId())) {
                            ae.this.ajh();
                        } else {
                            ae.this.iT(1);
                        }
                    }
                } else if (i == 2) {
                    ae.this.aji();
                } else if (i == 3) {
                    ae.this.ajj();
                } else if (i == 4) {
                    ae.this.s(ae.this.cBf, true);
                } else if (i == 5) {
                    ae.this.ajk();
                }
                ae.this.iU(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.cBe = new ArrayList();
        this.cBb = new com.baidu.tieba.view.a(this.mContext);
        this.cBb.setTitleText(getString(f.j.thread_manager, new Object[0]));
        this.cBb.a(this.cBj);
        this.czJ = new ForumManageModel(this.mPageContext);
        this.czJ.setLoadDataCallBack(this.czN);
        this.axE = z;
        setContentView(this.cBb.bEs());
    }

    public void onChangeSkinType() {
        if (this.cBb != null) {
            this.cBb.onChangeSkinType();
        }
        if (this.czC != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.czC.xf());
        }
        if (this.cBc != null) {
            com.baidu.tbadk.o.a.a(this.mPageContext, this.cBc.xf());
        }
    }

    private void createView() {
        if (this.buy != null && this.cBe != null && this.cBb != null) {
            this.cBe.clear();
            this.cBe.add(new a.C0251a(1, getString(f.j.delete_page, new Object[0]), this.cBb));
            String str = "";
            if (this.buy.vj() != null) {
                str = this.buy.vj().getUserId();
            }
            if (!UtilHelper.isCurrentAccount(str)) {
                this.cBe.add(new a.C0251a(2, getString(f.j.thread_forbid, new Object[0]), this.cBb));
            }
            if (com.baidu.tieba.frs.g.atZ()) {
                this.cBe.add(new a.C0251a(3, getString(this.buy.ve() == 1 ? f.j.cancel_top : f.j.top, new Object[0]), this.cBb));
                this.cBe.add(new a.C0251a(4, getString(this.buy.vf() == 1 ? f.j.cancel_good : f.j.commit_good, new Object[0]), this.cBb));
            }
            if (com.baidu.tieba.frs.a.atC().atF() && this.axE) {
                this.cBe.add(new a.C0251a(5, getString(f.j.multi_delete, new Object[0]), this.cBb));
            }
            this.cBb.dM(this.cBe);
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
        this.buy = bbVar;
        createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aje() {
        com.baidu.adp.lib.g.g.b(this, this.mPageContext);
    }

    public void ajf() {
        if (this.czC != null && this.czC.isShowing()) {
            this.czC.dismiss();
        }
    }

    public void ajg() {
        if (this.cBd != null && this.cBd.isShowing()) {
            this.cBd.dismiss();
        }
    }

    public void ajh() {
        ajf();
        if (this.mPageContext != null) {
            if (this.czC == null) {
                this.czC = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.czC.cf(f.j.del_thread_confirm);
                this.czC.a(f.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ae.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.js()) {
                            com.baidu.adp.lib.util.l.showToast(ae.this.mContext, f.j.neterror);
                        } else {
                            ae.this.g((JSONArray) null);
                        }
                    }
                });
                this.czC.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ae.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.czC.av(true);
                this.czC.b(this.mPageContext);
            }
            this.czC.xe();
        }
    }

    public void iT(int i) {
        if (this.mPageContext != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.cBb.aee());
            AntiData Cb = com.baidu.tieba.frs.a.atC().Cb();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (Cb != null && Cb.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Cb.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> atE = com.baidu.tieba.frs.a.atC().atE();
            for (int i3 = 0; i3 < atE.size(); i3++) {
                jSONArray.put(atE.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.bH(i);
            ahVar.c(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.atC().getForumId());
            eVar.setData(ahVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(f.j.delete_thread_reason_1), getContext().getString(f.j.delete_thread_reason_2), getContext().getString(f.j.delete_thread_reason_3), getContext().getString(f.j.delete_thread_reason_4), getContext().getString(f.j.delete_thread_reason_5)});
            eVar.hZ("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ae.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void f(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.js()) {
                        com.baidu.adp.lib.util.l.showToast(ae.this.mContext, f.j.neterror);
                    } else {
                        ae.this.g(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.cBd == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(f.h.commit_good, (ViewGroup) null);
            this.cBd = new Dialog(this.mContext, f.k.common_alert_dialog);
            this.cBd.setCanceledOnTouchOutside(true);
            this.cBd.setCancelable(true);
            this.cBd.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cBd.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds540);
            this.cBd.getWindow().setAttributes(attributes);
            inflate.findViewById(f.g.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cBd, ae.this.mPageContext);
                }
            });
            inflate.findViewById(f.g.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ae.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.b(ae.this.cBd, ae.this.mPageContext);
                    ae.this.s(ae.this.cBg, false);
                }
            });
        }
        com.baidu.tbadk.o.a.a(this.mPageContext, this.cBd.findViewById(f.g.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.cBd.findViewById(f.g.good_class_group);
        linearLayout.removeAllViews();
        this.cBh = new ArrayList();
        BlueCheckRadioButton aN = aN(this.cBf, getString(f.j.thread_good_class, new Object[0]));
        aN.setChecked(true);
        linearLayout.addView(aN);
        this.cBh.add(aN);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.tX()) && aaVar.tY() > 0) {
                    BlueCheckRadioButton aN2 = aN(String.valueOf(aaVar.tY()), aaVar.tX());
                    this.cBh.add(aN2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(aN2);
                    am.j(view, f.d.cp_bg_line_a);
                }
            }
            ScrollView scrollView = (ScrollView) this.cBd.findViewById(f.g.good_scroll);
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
        com.baidu.adp.lib.g.g.a(this.cBd, this.mPageContext);
    }

    private BlueCheckRadioButton aN(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.cBi);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.buy != null && gVar != null && gVar.EX) {
            String str = "";
            if (i == 2) {
                this.buy.bW(1);
                str = P(gVar.gQs, f.j.operation_success);
            } else if (i == 3) {
                this.buy.bW(0);
                str = P(gVar.gQs, f.j.operation_success);
            } else if (i == 4) {
                this.buy.bV(1);
                str = P(gVar.gQs, f.j.top_success);
            } else if (i == 5) {
                this.buy.bV(0);
                str = P(gVar.gQs, f.j.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.buy.getId();
            eVar.forumName = this.buy.vp();
            eVar.forumId = String.valueOf(this.buy.getFid());
            eVar.gQt = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(f.j.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.gQs)) {
            string = gVar.gQs;
        } else {
            string = getString(f.j.operation_failed, new Object[0]);
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
    public void iU(int i) {
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
    public void aji() {
        if (this.mContext != null && this.buy != null && this.buy.vj() != null) {
            String userId = this.buy.vj().getUserId();
            String userName = this.buy.vj().getUserName();
            String name_show = this.buy.vj().getName_show();
            String id = this.buy.getId();
            String vp = this.buy.vp();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.mContext, String.valueOf(this.buy.getFid()), vp, id, userId, userName, name_show, null, this.buy.vj().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONArray jSONArray) {
        if (this.czJ != null && this.buy != null && this.buy.vj() != null) {
            String userId = this.buy.vj().getUserId();
            String id = this.buy.getId();
            String vp = this.buy.vp();
            String valueOf = String.valueOf(this.buy.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.czJ.tU(ap.d(jSONArray));
            }
            this.czJ.a(valueOf, vp, id, null, 0, 1, isCurrentAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z) {
        int i;
        if (this.buy != null && this.czJ != null) {
            if (this.buy.vf() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.buy.getId();
            String vp = this.buy.vp();
            this.czJ.a(String.valueOf(this.buy.getFid()), vp, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajj() {
        int i;
        if (this.buy != null && this.czJ != null) {
            if (this.buy.ve() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.buy.getId();
            String vp = this.buy.vp();
            this.czJ.a(String.valueOf(this.buy.getFid()), vp, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajk() {
        com.baidu.tieba.frs.a.atC().s(true, false);
        TiebaStatic.log(new an("c13125").ae("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void dismissAllDialog() {
        ajf();
        ajg();
        aje();
    }

    public void destory() {
        dismissAllDialog();
    }
}
