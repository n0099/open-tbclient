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
    private bw ajz;
    private boolean eui;
    private final com.baidu.adp.base.d hkG;
    private com.baidu.tbadk.core.dialog.a hkr;
    private ForumManageModel hkz;
    private final com.baidu.tbadk.core.dialog.k hlY;
    private com.baidu.tbadk.core.dialog.a hlZ;
    private Dialog hma;
    private final List<com.baidu.tbadk.core.dialog.g> hmb;
    private String hmc;
    private String hmd;
    private List<BlueCheckRadioButton> hme;
    final CompoundButton.OnCheckedChangeListener hmf;
    private final k.c hmg;
    private Context mContext;
    private TbPageContext mPageContext;

    public ab(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.hmc = "0";
        this.hmd = this.hmc;
        this.eui = false;
        this.hmf = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ab.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ab.this.hmd = (String) compoundButton.getTag();
                    if (ab.this.hme != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ab.this.hme) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ab.this.hmd != null && !str.equals(ab.this.hmd)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.hkG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ab.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ab.this.hkz != null) {
                    switch (ab.this.hkz.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hzM != 0) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Qf) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ab.this.ajz.getId()));
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.mhO) ? bVar.mhO : ab.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ab.this.hlZ == null) {
                                        ab.this.hlZ = new com.baidu.tbadk.core.dialog.a(ab.this.mPageContext.getPageActivity());
                                        ab.this.hlZ.zA(string);
                                        ab.this.hlZ.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ab.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ab.this.hlZ.ig(true);
                                        ab.this.hlZ.b(ab.this.mPageContext);
                                    }
                                    ab.this.hlZ.bhg();
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
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.mhO) ? dVar.mhO : ab.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.mhO) ? dVar.mhO : ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ab.this.a(ab.this.hkz.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Qf) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ab.this.al(gVar.mhR);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.hmg = new k.c() { // from class: com.baidu.tieba.card.ab.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ab.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ab.this.ajz != null && ab.this.ajz.beE() != null) {
                        if (UtilHelper.isCurrentAccount(ab.this.ajz.beE().getUserId())) {
                            ab.this.ccc();
                        } else {
                            ab.this.vw(1);
                        }
                    }
                } else if (i == 2) {
                    ab.this.ccd();
                } else if (i == 3) {
                    ab.this.cce();
                } else if (i == 4) {
                    ab.this.aB(ab.this.hmc, true);
                } else if (i == 5) {
                    ab.this.ccf();
                } else if (i == 6) {
                    ab.this.cch();
                } else if (i == 7) {
                    ab.this.ccg();
                } else if (i == 8) {
                    ab.this.cci();
                }
                ab.this.vx(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hmb = new ArrayList();
        this.hlY = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.hlY.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.hlY.a(this.hmg);
        this.hkz = new ForumManageModel(this.mPageContext);
        this.hkz.setLoadDataCallBack(this.hkG);
        this.eui = z;
        a(this.hlY);
    }

    public void onChangeSkinType() {
        if (this.hlY != null) {
            this.hlY.onChangeSkinType();
        }
        if (this.hkr != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hkr.getRealView());
        }
        if (this.hlZ != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hlZ.getRealView());
        }
    }

    private void createView() {
        if (this.ajz != null && this.hmb != null && this.hlY != null) {
            this.hmb.clear();
            if (!com.baidu.tieba.frs.j.clF()) {
                if (!this.ajz.isBjh()) {
                    this.hmb.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.hlY));
                }
                String str = "";
                if (this.ajz.beE() != null) {
                    str = this.ajz.beE().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.hmb.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.hlY));
                }
            }
            if (com.baidu.tieba.frs.j.clE() || com.baidu.tieba.frs.j.clF()) {
                this.hmb.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.ajz.bez() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.hlY));
                this.hmb.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.ajz.beA() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.hlY));
            }
            if (com.baidu.tieba.frs.j.clE()) {
                this.hmb.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.hlY));
            }
            if (com.baidu.tieba.frs.j.clE() && this.eui) {
                this.hmb.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.hlY));
            }
            if (com.baidu.tieba.frs.j.clE() || com.baidu.tieba.frs.j.clF()) {
                this.hmb.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.hlY));
            }
            if (!com.baidu.tieba.frs.j.clF() && com.baidu.tieba.frs.b.ckT().ckV() && this.eui) {
                this.hmb.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.hlY));
            }
            this.hlY.aT(this.hmb);
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
        this.ajz = bwVar;
        createView();
    }

    public void cca() {
        if (this.hkr != null && this.hkr.isShowing()) {
            this.hkr.dismiss();
        }
    }

    public void ccb() {
        if (this.hma != null && this.hma.isShowing()) {
            this.hma.dismiss();
        }
    }

    public void ccc() {
        cca();
        if (this.mPageContext != null) {
            if (this.hkr == null) {
                this.hkr = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hkr.nt(R.string.del_thread_confirm);
                this.hkr.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ab.1
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
                this.hkr.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ab.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.hkr.ig(true);
                this.hkr.b(this.mPageContext);
            }
            this.hkr.bhg();
        }
    }

    public void vw(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData ckU = com.baidu.tieba.frs.b.ckT().ckU();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ckU != null && ckU.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckU.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> ckQ = com.baidu.tieba.frs.b.ckT().ckQ();
            for (int i3 = 0; i3 < ckQ.size(); i3++) {
                jSONArray.put(ckQ.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.mT(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.ckT().getForumId());
            eVar.setData(arVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.Df("1");
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
        if (this.hma == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.hma = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.hma.setCanceledOnTouchOutside(true);
            this.hma.setCancelable(true);
            this.hma.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hma.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.hma.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.hma, ab.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.hma, ab.this.mPageContext);
                    ab.this.aB(ab.this.hmd, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.hma.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.hma.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.hme = new ArrayList();
        BlueCheckRadioButton eo = eo(this.hmc, getString(R.string.thread_good_class, new Object[0]));
        eo.setChecked(true);
        linearLayout.addView(eo);
        this.hme.add(eo);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aj ajVar = arrayList.get(i);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bcS()) && ajVar.bcT() > 0) {
                    BlueCheckRadioButton eo2 = eo(String.valueOf(ajVar.bcT()), ajVar.bcS());
                    this.hme.add(eo2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(eo2);
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.hma.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.hma, this.mPageContext);
    }

    private BlueCheckRadioButton eo(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.hmf);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.ajz != null && gVar != null && gVar.Qf) {
            String str = "";
            if (i == 2) {
                this.ajz.nj(1);
                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                xVar.type = 2;
                xVar.tid = this.ajz.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar));
            } else if (i == 3) {
                this.ajz.nj(0);
                str = aI(gVar.mhO, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.ajz.ni(1);
                com.baidu.tbadk.core.data.x xVar2 = new com.baidu.tbadk.core.data.x();
                xVar2.type = 1;
                xVar2.tid = this.ajz.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar2));
            } else if (i == 5) {
                this.ajz.ni(0);
                str = aI(gVar.mhO, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.ajz.getId();
            eVar.forumName = this.ajz.beI();
            eVar.forumId = String.valueOf(this.ajz.getFid());
            eVar.mhP = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.mhO)) {
            string = gVar.mhO;
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
        if (this.ajz != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).ai("obj_type", i).u("uid", TbadkCoreApplication.getCurrentAccountId()).u("fid", this.ajz.getFid()).dD("tid", this.ajz.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccd() {
        if (this.mContext != null && this.ajz != null && this.ajz.beE() != null) {
            String userId = this.ajz.beE().getUserId();
            String userName = this.ajz.beE().getUserName();
            String name_show = this.ajz.beE().getName_show();
            String id = this.ajz.getId();
            String beI = this.ajz.beI();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.ajz.getFid()), beI, id, userId, userName, name_show, null, this.ajz.beE().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.hkz != null && this.ajz != null && this.ajz.beE() != null) {
            String userId = this.ajz.beE().getUserId();
            String id = this.ajz.getId();
            String beI = this.ajz.beI();
            String valueOf = String.valueOf(this.ajz.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.hkz.QP(at.R(jSONArray));
            }
            this.hkz.a(valueOf, beI, id, null, 0, 1, isCurrentAccount, this.ajz.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(String str, boolean z) {
        int i;
        if (this.ajz != null && this.hkz != null) {
            if (this.ajz.beA() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.ajz.getId();
            String beI = this.ajz.beI();
            this.hkz.b(String.valueOf(this.ajz.getFid()), beI, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cce() {
        int i;
        if (this.ajz != null && this.hkz != null) {
            if (this.ajz.bez() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.ajz.getId();
            String beI = this.ajz.beI();
            this.hkz.b(String.valueOf(this.ajz.getFid()), beI, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccf() {
        com.baidu.tieba.frs.b.ckT().R(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccg() {
        com.baidu.tieba.frs.a.ckM().R(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cch() {
        if (this.mPageContext != null && this.ajz != null) {
            BawuThrones ckY = com.baidu.tieba.frs.c.ckX().ckY();
            if (ckY == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (ckY.total_recommend_num.intValue() == ckY.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.ckX().b(this.mPageContext, String.valueOf(this.ajz.getFid()), this.ajz.getId());
            } else {
                com.baidu.tieba.frs.c.ckX().eC(String.valueOf(this.ajz.getFid()), this.ajz.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cci() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.ajz));
    }

    public void dismissAllDialog() {
        cca();
        ccb();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
