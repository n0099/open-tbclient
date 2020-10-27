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
public class ac extends com.baidu.tbadk.core.dialog.i {
    private bw akq;
    private boolean eQS;
    private com.baidu.tbadk.core.dialog.a hSL;
    private ForumManageModel hST;
    private final com.baidu.adp.base.d hTa;
    private final k.c hUA;
    private final com.baidu.tbadk.core.dialog.k hUs;
    private com.baidu.tbadk.core.dialog.a hUt;
    private Dialog hUu;
    private final List<com.baidu.tbadk.core.dialog.g> hUv;
    private String hUw;
    private String hUx;
    private List<BlueCheckRadioButton> hUy;
    final CompoundButton.OnCheckedChangeListener hUz;
    private Context mContext;
    private TbPageContext mPageContext;

    public ac(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.hUw = "0";
        this.hUx = this.hUw;
        this.eQS = false;
        this.hUz = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ac.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ac.this.hUx = (String) compoundButton.getTag();
                    if (ac.this.hUy != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ac.this.hUy) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ac.this.hUx != null && !str.equals(ac.this.hUx)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.hTa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ac.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ac.this.hST != null) {
                    switch (ac.this.hST.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.iij != 0) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.QP) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ac.this.akq.getId()));
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.mTG) ? bVar.mTG : ac.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ac.this.hUt == null) {
                                        ac.this.hUt = new com.baidu.tbadk.core.dialog.a(ac.this.mPageContext.getPageActivity());
                                        ac.this.hUt.Ba(string);
                                        ac.this.hUt.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ac.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ac.this.hUt.iM(true);
                                        ac.this.hUt.b(ac.this.mPageContext);
                                    }
                                    ac.this.hUt.bmC();
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
                            } else if (dVar.QP) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.mTG) ? dVar.mTG : ac.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, !TextUtils.isEmpty(dVar.mTG) ? dVar.mTG : ac.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ac.this.a(ac.this.hST.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.QP) {
                                com.baidu.adp.lib.util.l.showToast(ac.this.mContext, ac.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ac.this.ao(gVar.mTJ);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.hUA = new k.c() { // from class: com.baidu.tieba.card.ac.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ac.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ac.this.akq != null && ac.this.akq.bka() != null) {
                        if (UtilHelper.isCurrentAccount(ac.this.akq.bka().getUserId())) {
                            ac.this.clU();
                        } else {
                            ac.this.wU(1);
                        }
                    }
                } else if (i == 2) {
                    ac.this.clV();
                } else if (i == 3) {
                    ac.this.clW();
                } else if (i == 4) {
                    ac.this.aH(ac.this.hUw, true);
                } else if (i == 5) {
                    ac.this.clX();
                } else if (i == 6) {
                    ac.this.clZ();
                } else if (i == 7) {
                    ac.this.clY();
                } else if (i == 8) {
                    ac.this.cma();
                }
                ac.this.wV(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hUv = new ArrayList();
        this.hUs = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.hUs.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.hUs.a(this.hUA);
        this.hST = new ForumManageModel(this.mPageContext);
        this.hST.setLoadDataCallBack(this.hTa);
        this.eQS = z;
        a(this.hUs);
    }

    public void onChangeSkinType() {
        if (this.hUs != null) {
            this.hUs.onChangeSkinType();
        }
        if (this.hSL != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hSL.getRealView());
        }
        if (this.hUt != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hUt.getRealView());
        }
    }

    private void createView() {
        if (this.akq != null && this.hUv != null && this.hUs != null) {
            this.hUv.clear();
            if (!com.baidu.tieba.frs.j.cvw()) {
                if (!this.akq.isBjh()) {
                    this.hUv.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.hUs));
                }
                String str = "";
                if (this.akq.bka() != null) {
                    str = this.akq.bka().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.hUv.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.hUs));
                }
            }
            if (com.baidu.tieba.frs.j.cvv() || com.baidu.tieba.frs.j.cvw()) {
                this.hUv.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.akq.bjV() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.hUs));
                this.hUv.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.akq.bjW() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.hUs));
            }
            if (com.baidu.tieba.frs.j.cvv()) {
                this.hUv.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.hUs));
            }
            if (com.baidu.tieba.frs.j.cvv() && this.eQS) {
                this.hUv.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.hUs));
            }
            if (com.baidu.tieba.frs.j.cvv() || com.baidu.tieba.frs.j.cvw()) {
                this.hUv.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.hUs));
            }
            if (!com.baidu.tieba.frs.j.cvw() && com.baidu.tieba.frs.b.cuL().cuN() && this.eQS) {
                this.hUv.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.hUs));
            }
            this.hUs.bk(this.hUv);
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
        this.akq = bwVar;
        createView();
    }

    public void clS() {
        if (this.hSL != null && this.hSL.isShowing()) {
            this.hSL.dismiss();
        }
    }

    public void clT() {
        if (this.hUu != null && this.hUu.isShowing()) {
            this.hUu.dismiss();
        }
    }

    public void clU() {
        clS();
        if (this.mPageContext != null) {
            if (this.hSL == null) {
                this.hSL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hSL.om(R.string.del_thread_confirm);
                this.hSL.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ac.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.neterror);
                        } else {
                            ac.this.X(null);
                        }
                    }
                });
                this.hSL.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ac.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.hSL.iM(true);
                this.hSL.b(this.mPageContext);
            }
            this.hSL.bmC();
        }
    }

    public void wU(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData cuM = com.baidu.tieba.frs.b.cuL().cuM();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cuM != null && cuM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cuM.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> cuI = com.baidu.tieba.frs.b.cuL().cuI();
            for (int i3 = 0; i3 < cuI.size(); i3++) {
                jSONArray.put(cuI.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.nM(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.cuL().getForumId());
            eVar.setData(arVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.EG("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ac.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(ac.this.mContext, R.string.neterror);
                    } else {
                        ac.this.X(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(ArrayList<aj> arrayList) {
        if (this.hUu == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.hUu = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.hUu.setCanceledOnTouchOutside(true);
            this.hUu.setCancelable(true);
            this.hUu.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hUu.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.hUu.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.hUu, ac.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ac.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ac.this.hUu, ac.this.mPageContext);
                    ac.this.aH(ac.this.hUx, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.hUu.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.hUu.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.hUy = new ArrayList();
        BlueCheckRadioButton eE = eE(this.hUw, getString(R.string.thread_good_class, new Object[0]));
        eE.setChecked(true);
        linearLayout.addView(eE);
        this.hUy.add(eE);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aj ajVar = arrayList.get(i);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bio()) && ajVar.bip() > 0) {
                    BlueCheckRadioButton eE2 = eE(String.valueOf(ajVar.bip()), ajVar.bio());
                    this.hUy.add(eE2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(eE2);
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.hUu.findViewById(R.id.good_scroll);
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
        com.baidu.adp.lib.f.g.a(this.hUu, this.mPageContext);
    }

    private BlueCheckRadioButton eE(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.hUz);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.akq != null && gVar != null && gVar.QP) {
            String str = "";
            if (i == 2) {
                this.akq.oc(1);
                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                xVar.type = 2;
                xVar.tid = this.akq.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar));
            } else if (i == 3) {
                this.akq.oc(0);
                str = aK(gVar.mTG, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.akq.ob(1);
                com.baidu.tbadk.core.data.x xVar2 = new com.baidu.tbadk.core.data.x();
                xVar2.type = 1;
                xVar2.tid = this.akq.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar2));
            } else if (i == 5) {
                this.akq.ob(0);
                str = aK(gVar.mTG, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.akq.getId();
            eVar.forumName = this.akq.bke();
            eVar.forumId = String.valueOf(this.akq.getFid());
            eVar.mTH = i;
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
        if (gVar != null && !TextUtils.isEmpty(gVar.mTG)) {
            string = gVar.mTG;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aK(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(int i) {
        if (this.akq != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).aj("obj_type", i).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.akq.getFid()).dR("tid", this.akq.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clV() {
        if (this.mContext != null && this.akq != null && this.akq.bka() != null) {
            String userId = this.akq.bka().getUserId();
            String userName = this.akq.bka().getUserName();
            String name_show = this.akq.bka().getName_show();
            String id = this.akq.getId();
            String bke = this.akq.bke();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.akq.getFid()), bke, id, userId, userName, name_show, null, this.akq.bka().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.hST != null && this.akq != null && this.akq.bka() != null) {
            String userId = this.akq.bka().getUserId();
            String id = this.akq.getId();
            String bke = this.akq.bke();
            String valueOf = String.valueOf(this.akq.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.hST.SC(at.R(jSONArray));
            }
            this.hST.a(valueOf, bke, id, null, 0, 1, isCurrentAccount, this.akq.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, boolean z) {
        int i;
        if (this.akq != null && this.hST != null) {
            if (this.akq.bjW() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.akq.getId();
            String bke = this.akq.bke();
            this.hST.b(String.valueOf(this.akq.getFid()), bke, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clW() {
        int i;
        if (this.akq != null && this.hST != null) {
            if (this.akq.bjV() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.akq.getId();
            String bke = this.akq.bke();
            this.hST.b(String.valueOf(this.akq.getFid()), bke, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clX() {
        com.baidu.tieba.frs.b.cuL().V(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clY() {
        com.baidu.tieba.frs.a.cuE().V(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clZ() {
        if (this.mPageContext != null && this.akq != null) {
            BawuThrones cuQ = com.baidu.tieba.frs.c.cuP().cuQ();
            if (cuQ == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (cuQ.total_recommend_num.intValue() == cuQ.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.cuP().b(this.mPageContext, String.valueOf(this.akq.getFid()), this.akq.getId());
            } else {
                com.baidu.tieba.frs.c.cuP().eS(String.valueOf(this.akq.getFid()), this.akq.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cma() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.akq));
    }

    public void dismissAllDialog() {
        clS();
        clT();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
