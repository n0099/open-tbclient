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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
import tbclient.DeleteThreadInfo;
/* loaded from: classes21.dex */
public class ab extends com.baidu.tbadk.core.dialog.i {
    private bw akp;
    private boolean eIw;
    private final com.baidu.adp.base.d hGD;
    private com.baidu.tbadk.core.dialog.a hGo;
    private ForumManageModel hGw;
    private final com.baidu.tbadk.core.dialog.k hHV;
    private com.baidu.tbadk.core.dialog.a hHW;
    private Dialog hHX;
    private final List<com.baidu.tbadk.core.dialog.g> hHY;
    private String hHZ;
    private String hIa;
    private List<BlueCheckRadioButton> hIb;
    final CompoundButton.OnCheckedChangeListener hIc;
    private final k.c hId;
    private Context mContext;
    private TbPageContext mPageContext;

    public ab(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.hHZ = "0";
        this.hIa = this.hHZ;
        this.eIw = false;
        this.hIc = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ab.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ab.this.hIa = (String) compoundButton.getTag();
                    if (ab.this.hIb != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ab.this.hIb) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ab.this.hIa != null && !str.equals(ab.this.hIa)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.hGD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ab.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ab.this.hGw != null) {
                    switch (ab.this.hGw.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hVJ != 0) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.QO) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ab.this.akp.getId()));
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.mGW) ? bVar.mGW : ab.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ab.this.hHW == null) {
                                        ab.this.hHW = new com.baidu.tbadk.core.dialog.a(ab.this.mPageContext.getPageActivity());
                                        ab.this.hHW.AH(string);
                                        ab.this.hHW.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ab.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ab.this.hHW.iz(true);
                                        ab.this.hHW.b(ab.this.mPageContext);
                                    }
                                    ab.this.hHW.bkJ();
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
                            } else if (dVar.QO) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.mGW) ? dVar.mGW : ab.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.mGW) ? dVar.mGW : ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ab.this.a(ab.this.hGw.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.QO) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ab.this.an(gVar.mGZ);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.hId = new k.c() { // from class: com.baidu.tieba.card.ab.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ab.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ab.this.akp != null && ab.this.akp.bih() != null) {
                        if (UtilHelper.isCurrentAccount(ab.this.akp.bih().getUserId())) {
                            ab.this.ciN();
                        } else {
                            ab.this.wB(1);
                        }
                    }
                } else if (i == 2) {
                    ab.this.ciO();
                } else if (i == 3) {
                    ab.this.ciP();
                } else if (i == 4) {
                    ab.this.aF(ab.this.hHZ, true);
                } else if (i == 5) {
                    ab.this.ciQ();
                } else if (i == 6) {
                    ab.this.ciS();
                } else if (i == 7) {
                    ab.this.ciR();
                } else if (i == 8) {
                    ab.this.ciT();
                }
                ab.this.wC(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hHY = new ArrayList();
        this.hHV = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.hHV.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.hHV.a(this.hId);
        this.hGw = new ForumManageModel(this.mPageContext);
        this.hGw.setLoadDataCallBack(this.hGD);
        this.eIw = z;
        a(this.hHV);
    }

    public void onChangeSkinType() {
        if (this.hHV != null) {
            this.hHV.onChangeSkinType();
        }
        if (this.hGo != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hGo.getRealView());
        }
        if (this.hHW != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hHW.getRealView());
        }
    }

    private void createView() {
        if (this.akp != null && this.hHY != null && this.hHV != null) {
            this.hHY.clear();
            if (!com.baidu.tieba.frs.j.csp()) {
                if (!this.akp.isBjh()) {
                    this.hHY.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.hHV));
                }
                String str = "";
                if (this.akp.bih() != null) {
                    str = this.akp.bih().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.hHY.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.hHV));
                }
            }
            if (com.baidu.tieba.frs.j.cso() || com.baidu.tieba.frs.j.csp()) {
                this.hHY.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.akp.bic() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.hHV));
                this.hHY.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.akp.bid() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.hHV));
            }
            if (com.baidu.tieba.frs.j.cso()) {
                this.hHY.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.hHV));
            }
            if (com.baidu.tieba.frs.j.cso() && this.eIw) {
                this.hHY.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.hHV));
            }
            if (com.baidu.tieba.frs.j.cso() || com.baidu.tieba.frs.j.csp()) {
                this.hHY.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.hHV));
            }
            if (!com.baidu.tieba.frs.j.csp() && com.baidu.tieba.frs.b.crE().crG() && this.eIw) {
                this.hHY.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.hHV));
            }
            this.hHV.ba(this.hHY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bw bwVar) {
        this.akp = bwVar;
        createView();
    }

    public void ciL() {
        if (this.hGo != null && this.hGo.isShowing()) {
            this.hGo.dismiss();
        }
    }

    public void ciM() {
        if (this.hHX != null && this.hHX.isShowing()) {
            this.hHX.dismiss();
        }
    }

    public void ciN() {
        ciL();
        if (this.mPageContext != null) {
            if (this.hGo == null) {
                this.hGo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hGo.ob(R.string.del_thread_confirm);
                this.hGo.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ab.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.neterror);
                        } else {
                            ab.this.X(null);
                        }
                    }
                });
                this.hGo.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ab.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.hGo.iz(true);
                this.hGo.b(this.mPageContext);
            }
            this.hGo.bkJ();
        }
    }

    public void wB(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData crF = com.baidu.tieba.frs.b.crE().crF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (crF != null && crF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = crF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> crB = com.baidu.tieba.frs.b.crE().crB();
            for (int i3 = 0; i3 < crB.size(); i3++) {
                jSONArray.put(crB.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.nB(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.crE().getForumId());
            eVar.setData(arVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.En("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ab.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.neterror);
                    } else {
                        ab.this.X(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(ArrayList<aj> arrayList) {
        if (this.hHX == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.hHX = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.hHX.setCanceledOnTouchOutside(true);
            this.hHX.setCancelable(true);
            this.hHX.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hHX.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.hHX.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.hHX, ab.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.hHX, ab.this.mPageContext);
                    ab.this.aF(ab.this.hIa, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.hHX.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.hHX.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.hIb = new ArrayList();
        BlueCheckRadioButton ez = ez(this.hHZ, getString(R.string.thread_good_class, new Object[0]));
        ez.setChecked(true);
        linearLayout.addView(ez);
        this.hIb.add(ez);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aj ajVar = arrayList.get(i);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bgv()) && ajVar.bgw() > 0) {
                    BlueCheckRadioButton ez2 = ez(String.valueOf(ajVar.bgw()), ajVar.bgv());
                    this.hIb.add(ez2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(ez2);
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.hHX.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.hHX, this.mPageContext);
    }

    private BlueCheckRadioButton ez(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.hIc);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.akp != null && gVar != null && gVar.QO) {
            String str = "";
            if (i == 2) {
                this.akp.nR(1);
                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                xVar.type = 2;
                xVar.tid = this.akp.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar));
            } else if (i == 3) {
                this.akp.nR(0);
                str = aJ(gVar.mGW, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.akp.nQ(1);
                com.baidu.tbadk.core.data.x xVar2 = new com.baidu.tbadk.core.data.x();
                xVar2.type = 1;
                xVar2.tid = this.akp.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar2));
            } else if (i == 5) {
                this.akp.nQ(0);
                str = aJ(gVar.mGW, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.akp.getId();
            eVar.forumName = this.akp.bil();
            eVar.forumId = String.valueOf(this.akp.getFid());
            eVar.mGX = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            if (!z) {
                com.baidu.adp.lib.util.l.showToast(this.mContext, str);
                return;
            }
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.mGW)) {
            string = gVar.mGW;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aJ(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC(int i) {
        if (this.akp != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).aj("obj_type", i).u("uid", TbadkCoreApplication.getCurrentAccountId()).u("fid", this.akp.getFid()).dK("tid", this.akp.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciO() {
        if (this.mContext != null && this.akp != null && this.akp.bih() != null) {
            String userId = this.akp.bih().getUserId();
            String userName = this.akp.bih().getUserName();
            String name_show = this.akp.bih().getName_show();
            String id = this.akp.getId();
            String bil = this.akp.bil();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.akp.getFid()), bil, id, userId, userName, name_show, null, this.akp.bih().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.hGw != null && this.akp != null && this.akp.bih() != null) {
            String userId = this.akp.bih().getUserId();
            String id = this.akp.getId();
            String bil = this.akp.bil();
            String valueOf = String.valueOf(this.akp.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.hGw.Sd(at.R(jSONArray));
            }
            this.hGw.a(valueOf, bil, id, null, 0, 1, isCurrentAccount, this.akp.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(String str, boolean z) {
        int i;
        if (this.akp != null && this.hGw != null) {
            if (this.akp.bid() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.akp.getId();
            String bil = this.akp.bil();
            this.hGw.b(String.valueOf(this.akp.getFid()), bil, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciP() {
        int i;
        if (this.akp != null && this.hGw != null) {
            if (this.akp.bic() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.akp.getId();
            String bil = this.akp.bil();
            this.hGw.b(String.valueOf(this.akp.getFid()), bil, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciQ() {
        com.baidu.tieba.frs.b.crE().S(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciR() {
        com.baidu.tieba.frs.a.crx().S(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciS() {
        if (this.mPageContext != null && this.akp != null) {
            BawuThrones crJ = com.baidu.tieba.frs.c.crI().crJ();
            if (crJ == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (crJ.total_recommend_num.intValue() == crJ.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.crI().b(this.mPageContext, String.valueOf(this.akp.getFid()), this.akp.getId());
            } else {
                com.baidu.tieba.frs.c.crI().eN(String.valueOf(this.akp.getFid()), this.akp.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.akp));
    }

    public void dismissAllDialog() {
        ciL();
        ciM();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
