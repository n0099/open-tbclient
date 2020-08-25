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
/* loaded from: classes15.dex */
public class ab extends com.baidu.tbadk.core.dialog.i {
    private bw ajx;
    private boolean eue;
    private final com.baidu.adp.base.d hkC;
    private com.baidu.tbadk.core.dialog.a hkn;
    private ForumManageModel hkv;
    private final com.baidu.tbadk.core.dialog.k hlU;
    private com.baidu.tbadk.core.dialog.a hlV;
    private Dialog hlW;
    private final List<com.baidu.tbadk.core.dialog.g> hlX;
    private String hlY;
    private String hlZ;
    private List<BlueCheckRadioButton> hma;
    final CompoundButton.OnCheckedChangeListener hmb;
    private final k.c hmc;
    private Context mContext;
    private TbPageContext mPageContext;

    public ab(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.hlY = "0";
        this.hlZ = this.hlY;
        this.eue = false;
        this.hmb = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ab.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ab.this.hlZ = (String) compoundButton.getTag();
                    if (ab.this.hma != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ab.this.hma) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ab.this.hlZ != null && !str.equals(ab.this.hlZ)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.hkC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ab.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ab.this.hkv != null) {
                    switch (ab.this.hkv.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hzG != 0) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Qf) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ab.this.ajx.getId()));
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.mhz) ? bVar.mhz : ab.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ab.this.hlV == null) {
                                        ab.this.hlV = new com.baidu.tbadk.core.dialog.a(ab.this.mPageContext.getPageActivity());
                                        ab.this.hlV.zz(string);
                                        ab.this.hlV.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ab.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ab.this.hlV.m39if(true);
                                        ab.this.hlV.b(ab.this.mPageContext);
                                    }
                                    ab.this.hlV.bhg();
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
                            } else if (dVar.Qf) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.mhz) ? dVar.mhz : ab.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.mhz) ? dVar.mhz : ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ab.this.a(ab.this.hkv.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Qf) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ab.this.al(gVar.mhC);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.hmc = new k.c() { // from class: com.baidu.tieba.card.ab.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ab.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ab.this.ajx != null && ab.this.ajx.beE() != null) {
                        if (UtilHelper.isCurrentAccount(ab.this.ajx.beE().getUserId())) {
                            ab.this.ccb();
                        } else {
                            ab.this.vw(1);
                        }
                    }
                } else if (i == 2) {
                    ab.this.ccc();
                } else if (i == 3) {
                    ab.this.ccd();
                } else if (i == 4) {
                    ab.this.aB(ab.this.hlY, true);
                } else if (i == 5) {
                    ab.this.cce();
                } else if (i == 6) {
                    ab.this.ccg();
                } else if (i == 7) {
                    ab.this.ccf();
                } else if (i == 8) {
                    ab.this.cch();
                }
                ab.this.vx(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hlX = new ArrayList();
        this.hlU = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.hlU.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.hlU.a(this.hmc);
        this.hkv = new ForumManageModel(this.mPageContext);
        this.hkv.setLoadDataCallBack(this.hkC);
        this.eue = z;
        a(this.hlU);
    }

    public void onChangeSkinType() {
        if (this.hlU != null) {
            this.hlU.onChangeSkinType();
        }
        if (this.hkn != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hkn.getRealView());
        }
        if (this.hlV != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hlV.getRealView());
        }
    }

    private void createView() {
        if (this.ajx != null && this.hlX != null && this.hlU != null) {
            this.hlX.clear();
            if (!com.baidu.tieba.frs.j.clE()) {
                if (!this.ajx.isBjh()) {
                    this.hlX.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.hlU));
                }
                String str = "";
                if (this.ajx.beE() != null) {
                    str = this.ajx.beE().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.hlX.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.hlU));
                }
            }
            if (com.baidu.tieba.frs.j.clD() || com.baidu.tieba.frs.j.clE()) {
                this.hlX.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.ajx.bez() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.hlU));
                this.hlX.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.ajx.beA() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.hlU));
            }
            if (com.baidu.tieba.frs.j.clD()) {
                this.hlX.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.hlU));
            }
            if (com.baidu.tieba.frs.j.clD() && this.eue) {
                this.hlX.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.hlU));
            }
            if (com.baidu.tieba.frs.j.clD() || com.baidu.tieba.frs.j.clE()) {
                this.hlX.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.hlU));
            }
            if (!com.baidu.tieba.frs.j.clE() && com.baidu.tieba.frs.b.ckS().ckU() && this.eue) {
                this.hlX.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.hlU));
            }
            this.hlU.aT(this.hlX);
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
        this.ajx = bwVar;
        createView();
    }

    public void cbZ() {
        if (this.hkn != null && this.hkn.isShowing()) {
            this.hkn.dismiss();
        }
    }

    public void cca() {
        if (this.hlW != null && this.hlW.isShowing()) {
            this.hlW.dismiss();
        }
    }

    public void ccb() {
        cbZ();
        if (this.mPageContext != null) {
            if (this.hkn == null) {
                this.hkn = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hkn.nt(R.string.del_thread_confirm);
                this.hkn.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ab.1
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
                this.hkn.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ab.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.hkn.m39if(true);
                this.hkn.b(this.mPageContext);
            }
            this.hkn.bhg();
        }
    }

    public void vw(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData ckT = com.baidu.tieba.frs.b.ckS().ckT();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ckT != null && ckT.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckT.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> ckP = com.baidu.tieba.frs.b.ckS().ckP();
            for (int i3 = 0; i3 < ckP.size(); i3++) {
                jSONArray.put(ckP.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.mT(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.ckS().getForumId());
            eVar.setData(arVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.De("1");
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
    public void al(ArrayList<aj> arrayList) {
        if (this.hlW == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.hlW = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.hlW.setCanceledOnTouchOutside(true);
            this.hlW.setCancelable(true);
            this.hlW.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hlW.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.hlW.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.hlW, ab.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.hlW, ab.this.mPageContext);
                    ab.this.aB(ab.this.hlZ, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.hlW.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.hlW.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.hma = new ArrayList();
        BlueCheckRadioButton en = en(this.hlY, getString(R.string.thread_good_class, new Object[0]));
        en.setChecked(true);
        linearLayout.addView(en);
        this.hma.add(en);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aj ajVar = arrayList.get(i);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bcS()) && ajVar.bcT() > 0) {
                    BlueCheckRadioButton en2 = en(String.valueOf(ajVar.bcT()), ajVar.bcS());
                    this.hma.add(en2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(en2);
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.hlW.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.hlW, this.mPageContext);
    }

    private BlueCheckRadioButton en(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.hmb);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.ajx != null && gVar != null && gVar.Qf) {
            String str = "";
            if (i == 2) {
                this.ajx.nj(1);
                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                xVar.type = 2;
                xVar.tid = this.ajx.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar));
            } else if (i == 3) {
                this.ajx.nj(0);
                str = aI(gVar.mhz, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.ajx.ni(1);
                com.baidu.tbadk.core.data.x xVar2 = new com.baidu.tbadk.core.data.x();
                xVar2.type = 1;
                xVar2.tid = this.ajx.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar2));
            } else if (i == 5) {
                this.ajx.ni(0);
                str = aI(gVar.mhz, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.ajx.getId();
            eVar.forumName = this.ajx.beI();
            eVar.forumId = String.valueOf(this.ajx.getFid());
            eVar.mhA = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.mhz)) {
            string = gVar.mhz;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aI(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx(int i) {
        if (this.ajx != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).ai("obj_type", i).u("uid", TbadkCoreApplication.getCurrentAccountId()).u("fid", this.ajx.getFid()).dD("tid", this.ajx.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccc() {
        if (this.mContext != null && this.ajx != null && this.ajx.beE() != null) {
            String userId = this.ajx.beE().getUserId();
            String userName = this.ajx.beE().getUserName();
            String name_show = this.ajx.beE().getName_show();
            String id = this.ajx.getId();
            String beI = this.ajx.beI();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.ajx.getFid()), beI, id, userId, userName, name_show, null, this.ajx.beE().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.hkv != null && this.ajx != null && this.ajx.beE() != null) {
            String userId = this.ajx.beE().getUserId();
            String id = this.ajx.getId();
            String beI = this.ajx.beI();
            String valueOf = String.valueOf(this.ajx.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.hkv.QP(at.R(jSONArray));
            }
            this.hkv.a(valueOf, beI, id, null, 0, 1, isCurrentAccount, this.ajx.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(String str, boolean z) {
        int i;
        if (this.ajx != null && this.hkv != null) {
            if (this.ajx.beA() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.ajx.getId();
            String beI = this.ajx.beI();
            this.hkv.b(String.valueOf(this.ajx.getFid()), beI, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccd() {
        int i;
        if (this.ajx != null && this.hkv != null) {
            if (this.ajx.bez() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.ajx.getId();
            String beI = this.ajx.beI();
            this.hkv.b(String.valueOf(this.ajx.getFid()), beI, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cce() {
        com.baidu.tieba.frs.b.ckS().R(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccf() {
        com.baidu.tieba.frs.a.ckL().R(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccg() {
        if (this.mPageContext != null && this.ajx != null) {
            BawuThrones ckX = com.baidu.tieba.frs.c.ckW().ckX();
            if (ckX == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (ckX.total_recommend_num.intValue() == ckX.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.ckW().b(this.mPageContext, String.valueOf(this.ajx.getFid()), this.ajx.getId());
            } else {
                com.baidu.tieba.frs.c.ckW().eB(String.valueOf(this.ajx.getFid()), this.ajx.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cch() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.ajx));
    }

    public void dismissAllDialog() {
        cbZ();
        cca();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
