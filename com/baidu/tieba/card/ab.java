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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
    private bv aii;
    private boolean ekj;
    private ForumManageModel gXC;
    private final com.baidu.adp.base.d gXJ;
    private com.baidu.tbadk.core.dialog.a gXu;
    private final com.baidu.tbadk.core.dialog.k gZb;
    private com.baidu.tbadk.core.dialog.a gZc;
    private Dialog gZd;
    private final List<com.baidu.tbadk.core.dialog.g> gZe;
    private String gZf;
    private String gZg;
    private List<BlueCheckRadioButton> gZh;
    final CompoundButton.OnCheckedChangeListener gZi;
    private final k.c gZj;
    private Context mContext;
    private TbPageContext mPageContext;

    public ab(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.gZf = "0";
        this.gZg = this.gZf;
        this.ekj = false;
        this.gZi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ab.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ab.this.gZg = (String) compoundButton.getTag();
                    if (ab.this.gZh != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ab.this.gZh) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ab.this.gZg != null && !str.equals(ab.this.gZg)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.gXJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ab.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ab.this.gXC != null) {
                    switch (ab.this.gXC.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hmP != 0) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Pv) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ab.this.aii.getId()));
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.lPO) ? bVar.lPO : ab.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ab.this.gZc == null) {
                                        ab.this.gZc = new com.baidu.tbadk.core.dialog.a(ab.this.mPageContext.getPageActivity());
                                        ab.this.gZc.xl(string);
                                        ab.this.gZc.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ab.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ab.this.gZc.hJ(true);
                                        ab.this.gZc.b(ab.this.mPageContext);
                                    }
                                    ab.this.gZc.aYL();
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
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.lPO) ? dVar.lPO : ab.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.lPO) ? dVar.lPO : ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ab.this.a(ab.this.gXC.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Pv) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ab.this.af(gVar.lPR);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.gZj = new k.c() { // from class: com.baidu.tieba.card.ab.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ab.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ab.this.aii != null && ab.this.aii.aWl() != null) {
                        if (UtilHelper.isCurrentAccount(ab.this.aii.aWl().getUserId())) {
                            ab.this.bRP();
                        } else {
                            ab.this.th(1);
                        }
                    }
                } else if (i == 2) {
                    ab.this.bRQ();
                } else if (i == 3) {
                    ab.this.bRR();
                } else if (i == 4) {
                    ab.this.ax(ab.this.gZf, true);
                } else if (i == 5) {
                    ab.this.bRS();
                } else if (i == 6) {
                    ab.this.bRU();
                } else if (i == 7) {
                    ab.this.bRT();
                } else if (i == 8) {
                    ab.this.bRV();
                }
                ab.this.ti(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gZe = new ArrayList();
        this.gZb = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.gZb.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.gZb.a(this.gZj);
        this.gXC = new ForumManageModel(this.mPageContext);
        this.gXC.setLoadDataCallBack(this.gXJ);
        this.ekj = z;
        a(this.gZb);
    }

    public void onChangeSkinType() {
        if (this.gZb != null) {
            this.gZb.onChangeSkinType();
        }
        if (this.gXu != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.gXu.getRealView());
        }
        if (this.gZc != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.gZc.getRealView());
        }
    }

    private void createView() {
        if (this.aii != null && this.gZe != null && this.gZb != null) {
            this.gZe.clear();
            if (!com.baidu.tieba.frs.i.cbi()) {
                if (!this.aii.isBjh()) {
                    this.gZe.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.gZb));
                }
                String str = "";
                if (this.aii.aWl() != null) {
                    str = this.aii.aWl().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.gZe.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.gZb));
                }
            }
            if (com.baidu.tieba.frs.i.cbh() || com.baidu.tieba.frs.i.cbi()) {
                this.gZe.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.aii.aWg() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.gZb));
                this.gZe.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.aii.aWh() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.gZb));
            }
            if (com.baidu.tieba.frs.i.cbh()) {
                this.gZe.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.gZb));
            }
            if (com.baidu.tieba.frs.i.cbh() && this.ekj) {
                this.gZe.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.gZb));
            }
            if (com.baidu.tieba.frs.i.cbh() || com.baidu.tieba.frs.i.cbi()) {
                this.gZe.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.gZb));
            }
            if (!com.baidu.tieba.frs.i.cbi() && com.baidu.tieba.frs.b.caw().cay() && this.ekj) {
                this.gZe.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.gZb));
            }
            this.gZb.aS(this.gZe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bv bvVar) {
        this.aii = bvVar;
        createView();
    }

    public void bRN() {
        if (this.gXu != null && this.gXu.isShowing()) {
            this.gXu.dismiss();
        }
    }

    public void bRO() {
        if (this.gZd != null && this.gZd.isShowing()) {
            this.gZd.dismiss();
        }
    }

    public void bRP() {
        bRN();
        if (this.mPageContext != null) {
            if (this.gXu == null) {
                this.gXu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.gXu.ln(R.string.del_thread_confirm);
                this.gXu.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ab.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.neterror);
                        } else {
                            ab.this.V(null);
                        }
                    }
                });
                this.gXu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ab.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.gXu.hJ(true);
                this.gXu.b(this.mPageContext);
            }
            this.gXu.aYL();
        }
    }

    public void th(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData cax = com.baidu.tieba.frs.b.caw().cax();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cax != null && cax.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cax.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bv> cat = com.baidu.tieba.frs.b.caw().cat();
            for (int i3 = 0; i3 < cat.size(); i3++) {
                jSONArray.put(cat.get(i3).getTid());
            }
            aq aqVar = new aq();
            aqVar.setFeedBackReasonMap(sparseArray);
            aqVar.kN(i);
            aqVar.N(jSONArray);
            aqVar.setFid(com.baidu.tieba.frs.b.caw().getForumId());
            eVar.setData(aqVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.AK("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ab.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void U(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.neterror);
                    } else {
                        ab.this.V(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(ArrayList<ai> arrayList) {
        if (this.gZd == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.gZd = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.gZd.setCanceledOnTouchOutside(true);
            this.gZd.setCancelable(true);
            this.gZd.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.gZd.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.gZd.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.gZd, ab.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.gZd, ab.this.mPageContext);
                    ab.this.ax(ab.this.gZg, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.gZd.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.gZd.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.gZh = new ArrayList();
        BlueCheckRadioButton dW = dW(this.gZf, getString(R.string.thread_good_class, new Object[0]));
        dW.setChecked(true);
        linearLayout.addView(dW);
        this.gZh.add(dW);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ai aiVar = arrayList.get(i);
                if (aiVar != null && !TextUtils.isEmpty(aiVar.aUz()) && aiVar.aUA() > 0) {
                    BlueCheckRadioButton dW2 = dW(String.valueOf(aiVar.aUA()), aiVar.aUz());
                    this.gZh.add(dW2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(dW2);
                    ao.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.gZd.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.gZd, this.mPageContext);
    }

    private BlueCheckRadioButton dW(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.gZi);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.aii != null && gVar != null && gVar.Pv) {
            String str = "";
            if (i == 2) {
                this.aii.ld(1);
                com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                wVar.type = 2;
                wVar.tid = this.aii.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, wVar));
            } else if (i == 3) {
                this.aii.ld(0);
                str = aF(gVar.lPO, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.aii.lc(1);
                com.baidu.tbadk.core.data.w wVar2 = new com.baidu.tbadk.core.data.w();
                wVar2.type = 1;
                wVar2.tid = this.aii.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, wVar2));
            } else if (i == 5) {
                this.aii.lc(0);
                str = aF(gVar.lPO, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.aii.getId();
            eVar.forumName = this.aii.aWp();
            eVar.forumId = String.valueOf(this.aii.getFid());
            eVar.lPP = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.lPO)) {
            string = gVar.lPO;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aF(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(int i) {
        if (this.aii != null) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).ah("obj_type", i).t("uid", TbadkCoreApplication.getCurrentAccountId()).t("fid", this.aii.getFid()).dn("tid", this.aii.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRQ() {
        if (this.mContext != null && this.aii != null && this.aii.aWl() != null) {
            String userId = this.aii.aWl().getUserId();
            String userName = this.aii.aWl().getUserName();
            String name_show = this.aii.aWl().getName_show();
            String id = this.aii.getId();
            String aWp = this.aii.aWp();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.aii.getFid()), aWp, id, userId, userName, name_show, null, this.aii.aWl().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(JSONArray jSONArray) {
        if (this.gXC != null && this.aii != null && this.aii.aWl() != null) {
            String userId = this.aii.aWl().getUserId();
            String id = this.aii.getId();
            String aWp = this.aii.aWp();
            String valueOf = String.valueOf(this.aii.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.gXC.NR(as.P(jSONArray));
            }
            this.gXC.a(valueOf, aWp, id, null, 0, 1, isCurrentAccount, this.aii.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(String str, boolean z) {
        int i;
        if (this.aii != null && this.gXC != null) {
            if (this.aii.aWh() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.aii.getId();
            String aWp = this.aii.aWp();
            this.gXC.b(String.valueOf(this.aii.getFid()), aWp, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRR() {
        int i;
        if (this.aii != null && this.gXC != null) {
            if (this.aii.aWg() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.aii.getId();
            String aWp = this.aii.aWp();
            this.gXC.b(String.valueOf(this.aii.getFid()), aWp, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRS() {
        com.baidu.tieba.frs.b.caw().N(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRT() {
        com.baidu.tieba.frs.a.cap().N(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRU() {
        if (this.mPageContext != null && this.aii != null) {
            BawuThrones caB = com.baidu.tieba.frs.c.caA().caB();
            if (caB == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (caB.total_recommend_num.intValue() == caB.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.caA().b(this.mPageContext, String.valueOf(this.aii.getFid()), this.aii.getId());
            } else {
                com.baidu.tieba.frs.c.caA().ek(String.valueOf(this.aii.getFid()), this.aii.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.aii));
    }

    public void dismissAllDialog() {
        bRN();
        bRO();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
