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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
import tbclient.DeleteThreadInfo;
/* loaded from: classes8.dex */
public class ab extends com.baidu.tbadk.core.dialog.i {
    private bu aiq;
    private boolean edZ;
    private com.baidu.tbadk.core.dialog.a gRP;
    private ForumManageModel gRX;
    private final com.baidu.adp.base.d gSe;
    private String gTA;
    private String gTB;
    private List<BlueCheckRadioButton> gTC;
    final CompoundButton.OnCheckedChangeListener gTD;
    private final k.c gTE;
    private final com.baidu.tbadk.core.dialog.k gTw;
    private com.baidu.tbadk.core.dialog.a gTx;
    private Dialog gTy;
    private final List<com.baidu.tbadk.core.dialog.g> gTz;
    private Context mContext;
    private TbPageContext mPageContext;

    public ab(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.gTA = "0";
        this.gTB = this.gTA;
        this.edZ = false;
        this.gTD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ab.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ab.this.gTB = (String) compoundButton.getTag();
                    if (ab.this.gTC != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ab.this.gTC) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ab.this.gTB != null && !str.equals(ab.this.gTB)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.gSe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ab.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ab.this.gRX != null) {
                    switch (ab.this.gRX.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hhf != 0) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Pv) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ab.this.aiq.getId()));
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, (int) R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.lIA) ? bVar.lIA : ab.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ab.this.gTx == null) {
                                        ab.this.gTx = new com.baidu.tbadk.core.dialog.a(ab.this.mPageContext.getPageActivity());
                                        ab.this.gTx.we(string);
                                        ab.this.gTx.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ab.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ab.this.gTx.hf(true);
                                        ab.this.gTx.b(ab.this.mPageContext);
                                    }
                                    ab.this.gTx.aUN();
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
                            } else if (dVar.Pv) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.lIA) ? dVar.lIA : ab.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.lIA) ? dVar.lIA : ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ab.this.a(ab.this.gRX.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Pv) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ab.this.ae(gVar.lID);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.gTE = new k.c() { // from class: com.baidu.tieba.card.ab.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ab.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ab.this.mContext, (int) R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ab.this.aiq != null && ab.this.aiq.aSp() != null) {
                        if (UtilHelper.isCurrentAccount(ab.this.aiq.aSp().getUserId())) {
                            ab.this.bOE();
                        } else {
                            ab.this.sP(1);
                        }
                    }
                } else if (i == 2) {
                    ab.this.bOF();
                } else if (i == 3) {
                    ab.this.bOG();
                } else if (i == 4) {
                    ab.this.az(ab.this.gTA, true);
                } else if (i == 5) {
                    ab.this.bOH();
                } else if (i == 6) {
                    ab.this.bOJ();
                } else if (i == 7) {
                    ab.this.bOI();
                }
                ab.this.sQ(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gTz = new ArrayList();
        this.gTw = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.gTw.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.gTw.a(this.gTE);
        this.gRX = new ForumManageModel(this.mPageContext);
        this.gRX.setLoadDataCallBack(this.gSe);
        this.edZ = z;
        a(this.gTw);
    }

    public void onChangeSkinType() {
        if (this.gTw != null) {
            this.gTw.onChangeSkinType();
        }
        if (this.gRP != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.gRP.getRealView());
        }
        if (this.gTx != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.gTx.getRealView());
        }
    }

    private void createView() {
        if (this.aiq != null && this.gTz != null && this.gTw != null) {
            this.gTz.clear();
            if (!com.baidu.tieba.frs.i.bXL()) {
                if (!this.aiq.isBjh()) {
                    this.gTz.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.gTw));
                }
                String str = "";
                if (this.aiq.aSp() != null) {
                    str = this.aiq.aSp().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.gTz.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.gTw));
                }
            }
            if (com.baidu.tieba.frs.i.bXK() || com.baidu.tieba.frs.i.bXL()) {
                this.gTz.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.aiq.aSk() == 1 ? R.string.cancel_top : R.string.f1302top, new Object[0]), this.gTw));
                this.gTz.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.aiq.aSl() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.gTw));
            }
            if (com.baidu.tieba.frs.i.bXK() && com.baidu.tieba.frs.c.bXg().bXh() != null) {
                this.gTz.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.gTw));
            }
            if (com.baidu.tieba.frs.i.bXK() && this.edZ) {
                this.gTz.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.gTw));
            }
            if (!com.baidu.tieba.frs.i.bXL() && com.baidu.tieba.frs.b.bXc().bXe() && this.edZ) {
                this.gTz.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.gTw));
            }
            this.gTw.aL(this.gTz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bu buVar) {
        this.aiq = buVar;
        createView();
    }

    public void bOC() {
        if (this.gRP != null && this.gRP.isShowing()) {
            this.gRP.dismiss();
        }
    }

    public void bOD() {
        if (this.gTy != null && this.gTy.isShowing()) {
            this.gTy.dismiss();
        }
    }

    public void bOE() {
        bOC();
        if (this.mPageContext != null) {
            if (this.gRP == null) {
                this.gRP = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.gRP.kT(R.string.del_thread_confirm);
                this.gRP.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ab.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ab.this.mContext, (int) R.string.neterror);
                        } else {
                            ab.this.U(null);
                        }
                    }
                });
                this.gRP.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ab.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.gRP.hf(true);
                this.gRP.b(this.mPageContext);
            }
            this.gRP.aUN();
        }
    }

    public void sP(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData bXd = com.baidu.tieba.frs.b.bXc().bXd();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bXd != null && bXd.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bXd.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bu> bWZ = com.baidu.tieba.frs.b.bXc().bWZ();
            for (int i3 = 0; i3 < bWZ.size(); i3++) {
                jSONArray.put(bWZ.get(i3).getTid());
            }
            ap apVar = new ap();
            apVar.setFeedBackReasonMap(sparseArray);
            apVar.kt(i);
            apVar.M(jSONArray);
            apVar.setFid(com.baidu.tieba.frs.b.bXc().getForumId());
            eVar.setData(apVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.zC("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ab.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(ab.this.mContext, (int) R.string.neterror);
                    } else {
                        ab.this.U(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(ArrayList<ah> arrayList) {
        if (this.gTy == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.gTy = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.gTy.setCanceledOnTouchOutside(true);
            this.gTy.setCancelable(true);
            this.gTy.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.gTy.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.gTy.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.gTy, ab.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.gTy, ab.this.mPageContext);
                    ab.this.az(ab.this.gTB, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.gTy.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.gTy.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.gTC = new ArrayList();
        BlueCheckRadioButton dU = dU(this.gTA, getString(R.string.thread_good_class, new Object[0]));
        dU.setChecked(true);
        linearLayout.addView(dU);
        this.gTC.add(dU);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ah ahVar = arrayList.get(i);
                if (ahVar != null && !TextUtils.isEmpty(ahVar.aQD()) && ahVar.aQE() > 0) {
                    BlueCheckRadioButton dU2 = dU(String.valueOf(ahVar.aQE()), ahVar.aQD());
                    this.gTC.add(dU2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(dU2);
                    an.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.gTy.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.gTy, this.mPageContext);
    }

    private BlueCheckRadioButton dU(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.gTD);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (this.aiq != null && gVar != null && gVar.Pv) {
            String str = "";
            if (i == 2) {
                this.aiq.kJ(1);
                str = aG(gVar.lIA, R.string.operation_success);
            } else if (i == 3) {
                this.aiq.kJ(0);
                str = aG(gVar.lIA, R.string.operation_success);
            } else if (i == 4) {
                this.aiq.kI(1);
                str = aG(gVar.lIA, R.string.top_success);
            } else if (i == 5) {
                this.aiq.kI(0);
                str = aG(gVar.lIA, R.string.operation_success);
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.aiq.getId();
            eVar.forumName = this.aiq.aSt();
            eVar.forumId = String.valueOf(this.aiq.getFid());
            eVar.lIB = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            com.baidu.adp.lib.util.l.showToast(this.mContext, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.lIA)) {
            string = gVar.lIA;
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
    public void sQ(int i) {
        if (this.aiq != null) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).ag("obj_type", i).s("uid", TbadkCoreApplication.getCurrentAccountId()).s("fid", this.aiq.getFid()).dk("tid", this.aiq.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOF() {
        if (this.mContext != null && this.aiq != null && this.aiq.aSp() != null) {
            String userId = this.aiq.aSp().getUserId();
            String userName = this.aiq.aSp().getUserName();
            String name_show = this.aiq.aSp().getName_show();
            String id = this.aiq.getId();
            String aSt = this.aiq.aSt();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.aiq.getFid()), aSt, id, userId, userName, name_show, null, this.aiq.aSp().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(JSONArray jSONArray) {
        if (this.gRX != null && this.aiq != null && this.aiq.aSp() != null) {
            String userId = this.aiq.aSp().getUserId();
            String id = this.aiq.getId();
            String aSt = this.aiq.aSt();
            String valueOf = String.valueOf(this.aiq.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.gRX.Nj(ar.O(jSONArray));
            }
            this.gRX.a(valueOf, aSt, id, null, 0, 1, isCurrentAccount, this.aiq.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(String str, boolean z) {
        int i;
        if (this.aiq != null && this.gRX != null) {
            if (this.aiq.aSl() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.aiq.getId();
            String aSt = this.aiq.aSt();
            this.gRX.b(String.valueOf(this.aiq.getFid()), aSt, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOG() {
        int i;
        if (this.aiq != null && this.gRX != null) {
            if (this.aiq.aSk() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.aiq.getId();
            String aSt = this.aiq.aSt();
            this.gRX.b(String.valueOf(this.aiq.getFid()), aSt, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        com.baidu.tieba.frs.b.bXc().M(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOI() {
        com.baidu.tieba.frs.a.bWV().M(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOJ() {
        BawuThrones bXh;
        if (this.mPageContext != null && this.aiq != null && (bXh = com.baidu.tieba.frs.c.bXg().bXh()) != null) {
            if (bXh.total_recommend_num.intValue() == bXh.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.bXg().b(this.mPageContext, String.valueOf(this.aiq.getFid()), this.aiq.getId());
            } else {
                com.baidu.tieba.frs.c.bXg().ei(String.valueOf(this.aiq.getFid()), this.aiq.getId());
            }
        }
    }

    public void dismissAllDialog() {
        bOC();
        bOD();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
